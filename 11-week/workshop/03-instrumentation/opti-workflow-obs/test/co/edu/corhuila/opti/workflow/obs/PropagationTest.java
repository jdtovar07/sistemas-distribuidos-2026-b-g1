package co.edu.corhuila.opti.workflow.obs;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import com.sun.net.httpserver.HttpServer;

/** Plain main-based test: no framework to install. Exit code 1 when any check fails. */
public final class PropagationTest {

    private static final String INCOMING_TRACE = "9c1e7a34d2f84b6a8f03b5e7c1d29a64";
    private static final String GATEWAY_SPAN = "a1b2c3d4e5f60718";
    private static int failures;

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream logs = new PrintStream(captured, true);
        AtomicReference<String> seenByProducts = new AtomicReference<>();
        AtomicReference<Integer> productsDelayMs = new AtomicReference<>(0);

        HttpServer products = HttpServer.create(new InetSocketAddress(0), 0);
        products.createContext("/", exchange -> {
            seenByProducts.set(exchange.getRequestHeaders().getFirst("traceparent"));
            try {
                Thread.sleep(productsDelayMs.get());
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
            exchange.sendResponseHeaders(201, -1);
            exchange.close();
        });
        products.start();

        WorkflowApp app = new WorkflowApp(0, "http://localhost:" + products.getAddress().getPort(),
                Duration.ofMillis(300), "6f1d2c9e-5b7a-4c1e-9a3d-2e8b4f7a1c60",
                new JsonLog("opti-workflow", "0.1.0", "test", logs));
        app.start();

        HttpResponse<String> response = post(app.port(), "00-" + INCOMING_TRACE + "-" + GATEWAY_SPAN + "-01");
        TraceContext sentDownstream = TraceContext.parse(seenByProducts.get());
        TraceContext returned = TraceContext.parse(response.headers().firstValue("traceparent").orElse(null));
        check("trace_id received equals trace_id sent downstream", sentDownstream != null
                && INCOMING_TRACE.equals(sentDownstream.traceId()));
        check("response returns the same trace_id", returned != null && INCOMING_TRACE.equals(returned.traceId()));
        check("downstream span is not the gateway span", sentDownstream != null
                && !GATEWAY_SPAN.equals(sentDownstream.spanId()));

        post(app.port(), null);
        check("a missing traceparent starts a new trace that still reaches products",
                TraceContext.parse(seenByProducts.get()) != null
                        && !INCOMING_TRACE.equals(TraceContext.parse(seenByProducts.get()).traceId()));

        productsDelayMs.set(1000);
        post(app.port(), "00-" + INCOMING_TRACE + "-" + GATEWAY_SPAN + "-01");
        check("a slow products-api writes participant.call.timeout",
                captured.toString().contains("\"event\":\"participant.call.timeout\""));

        String metrics = get(app.port(), "/metrics");
        check("counter by outcome is exposed", metrics.contains(
                "workflow_saga_requests_total{saga=\"place-order\",outcome=\"completed\"} 2")
                && metrics.contains("outcome=\"failed\"} 1"));
        check("latency histogram is exposed", metrics.contains("workflow_saga_duration_seconds_count{saga=\"place-order\"} 3"));

        System.out.println("--- log lines written during the test ---");
        System.out.print(captured);
        app.stop();
        products.stop(0);
        System.out.println(failures == 0 ? "ALL CHECKS PASSED" : failures + " CHECK(S) FAILED");
        System.exit(failures == 0 ? 0 : 1);
    }

    private static HttpResponse<String> post(int port, String traceparent) throws Exception {
        HttpRequest.Builder request = HttpRequest.newBuilder(URI.create("http://localhost:" + port + "/api/v1/sagas/place-order"))
                .POST(HttpRequest.BodyPublishers.noBody());
        if (traceparent != null) {
            request.header("traceparent", traceparent);
        }
        return HttpClient.newHttpClient().send(request.build(), HttpResponse.BodyHandlers.ofString());
    }

    private static String get(int port, String path) throws Exception {
        return HttpClient.newHttpClient().send(HttpRequest.newBuilder(URI.create("http://localhost:" + port + path)).build(),
                HttpResponse.BodyHandlers.ofString()).body();
    }

    private static void check(String name, boolean ok) {
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if (!ok) {
            failures++;
        }
    }
}
