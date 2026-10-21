package co.edu.corhuila.opti.workflow.obs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.UUID;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

/**
 * A slice of opti-workflow: POST /api/v1/sagas/place-order runs only the reserve-stock hop,
 * and GET /metrics exposes the counter and the histogram.
 */
public final class WorkflowApp {

    private static final String SAGA = "place-order";

    private final HttpServer server;
    private final JsonLog log;
    private final Metrics metrics = new Metrics();
    private final StockCall stock;
    private final String frameId;

    public WorkflowApp(int port, String productsUrl, Duration timeout, String frameId, JsonLog log) throws IOException {
        this.log = log;
        this.frameId = frameId;
        this.stock = new StockCall(productsUrl, timeout, log);
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/v1/sagas/place-order", this::placeOrder).getFilters().add(new TraceContextFilter(log));
        server.createContext("/metrics", exchange -> reply(exchange, 200, "text/plain", metrics.render()));
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(0);
    }

    public int port() {
        return server.getAddress().getPort();
    }

    private void placeOrder(HttpExchange exchange) throws IOException {
        TraceContext ctx = (TraceContext) exchange.getAttribute(TraceContextFilter.CONTEXT);
        String correlation = (String) exchange.getAttribute(TraceContextFilter.CORRELATION);
        String sagaId = UUID.randomUUID().toString();
        long started = System.nanoTime();
        log.log("INFO", "saga.started", "place-order started", ctx, correlation, null,
                Map.of("saga_id", sagaId, "saga_type", SAGA));

        int status = stock.reserve(frameId, sagaId, ctx, correlation);
        String outcome = switch (status) {
            case 201 -> "completed";
            case 422 -> "compensated";
            default -> "failed";
        };
        double seconds = (System.nanoTime() - started) / 1e9;
        metrics.count(SAGA, outcome);
        metrics.observe(SAGA, seconds);
        log.log(outcome.equals("completed") ? "INFO" : "ERROR", "saga." + outcome, "place-order " + outcome, ctx,
                correlation, (long) (seconds * 1000), Map.of("saga_id", sagaId, "saga_type", SAGA));
        reply(exchange, 201, "application/json", "{\"id\":\"" + sagaId + "\",\"status\":\"" + outcome.toUpperCase() + "\"}");
    }

    private static void reply(HttpExchange exchange, int status, String type, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", type);
        exchange.sendResponseHeaders(status, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }

    public static void main(String[] args) throws IOException {
        JsonLog log = new JsonLog("opti-workflow", "0.1.0", System.getenv().getOrDefault("ENVIRONMENT", "develop"), System.out);
        WorkflowApp app = new WorkflowApp(Integer.parseInt(System.getenv().getOrDefault("PORT", "8085")),
                System.getenv().getOrDefault("PRODUCTS_URL", "http://localhost:8082"), Duration.ofSeconds(5),
                System.getenv().getOrDefault("DEMO_FRAME_ID", "6f1d2c9e-5b7a-4c1e-9a3d-2e8b4f7a1c60"), log);
        app.start();
        System.out.println("opti-workflow-obs listening on " + app.port());
    }
}
