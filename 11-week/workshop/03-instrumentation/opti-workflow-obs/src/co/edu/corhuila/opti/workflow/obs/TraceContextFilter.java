package co.edu.corhuila.opti.workflow.obs;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

/**
 * Reads the traceparent that opti-api-gateway forwards (or starts a trace when it is missing),
 * returns it in the response and writes one log line when the request starts and one when it ends.
 */
public final class TraceContextFilter extends Filter {

    public static final String CONTEXT = "trace.context";
    public static final String CORRELATION = "trace.correlation";
    public static final String CORRELATION_HEADER = "X-Correlation-Id";

    private final JsonLog log;

    public TraceContextFilter(JsonLog log) {
        this.log = log;
    }

    @Override
    public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
        TraceContext incoming = TraceContext.parse(exchange.getRequestHeaders().getFirst(TraceContext.HEADER));
        TraceContext ctx = incoming == null ? TraceContext.fresh() : incoming.child();
        String correlation = exchange.getRequestHeaders().getFirst(CORRELATION_HEADER);
        if (correlation == null || correlation.isBlank()) {
            correlation = "corr-" + UUID.randomUUID().toString().substring(0, 8);
        }
        exchange.setAttribute(CONTEXT, ctx);
        exchange.setAttribute(CORRELATION, correlation);
        exchange.getResponseHeaders().set(TraceContext.HEADER, ctx.format());
        exchange.getResponseHeaders().set(CORRELATION_HEADER, correlation);

        String route = exchange.getRequestMethod() + " " + exchange.getRequestURI().getPath();
        long started = System.nanoTime();
        log.log("INFO", "http.request.received", route, ctx, correlation, null,
                Map.of("trace_origin", incoming == null ? "new" : "gateway"));
        try {
            chain.doFilter(exchange);
        } finally {
            long millis = (System.nanoTime() - started) / 1_000_000;
            log.log("INFO", "http.request.completed", route, ctx, correlation, millis,
                    Map.of("http_status", exchange.getResponseCode()));
        }
    }

    @Override
    public String description() {
        return "trace context and request logging";
    }
}
