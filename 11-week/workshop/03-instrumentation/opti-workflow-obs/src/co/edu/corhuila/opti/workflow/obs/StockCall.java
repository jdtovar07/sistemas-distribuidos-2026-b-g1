package co.edu.corhuila.opti.workflow.obs;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.Map;

/**
 * The reserve-stock hop of place-order: POST /api/v1/frames/{id}/reservations on opti-products-api.
 * It sends a child span of the current one in traceparent, so products-api joins the same trace.
 */
public final class StockCall {

    /** Returned when products-api did not answer within HTTP_TIMEOUT. */
    public static final int TIMEOUT = 0;

    private final HttpClient http = HttpClient.newHttpClient();
    private final String productsUrl;
    private final Duration timeout;
    private final JsonLog log;

    public StockCall(String productsUrl, Duration timeout, JsonLog log) {
        this.productsUrl = productsUrl;
        this.timeout = timeout;
        this.log = log;
    }

    public int reserve(String frameId, String sagaId, TraceContext current, String correlationId) {
        TraceContext hop = current.child();
        HttpRequest request = HttpRequest.newBuilder(URI.create(productsUrl + "/api/v1/frames/" + frameId + "/reservations"))
                .timeout(timeout)
                .header(TraceContext.HEADER, hop.format())
                .header(TraceContextFilter.CORRELATION_HEADER, correlationId)
                .header("Idempotency-Key", sagaId + ":reserve-stock")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"quantity\":1,\"reference\":\"" + sagaId + "\"}"))
                .build();
        long started = System.nanoTime();
        try {
            int status = http.send(request, HttpResponse.BodyHandlers.discarding()).statusCode();
            log.log("INFO", "participant.call.completed", "products-api answered", hop, correlationId, millisSince(started),
                    Map.of("saga_id", sagaId, "saga_step", "reserve-stock", "participant", "opti-products-api",
                            "http_status", status));
            return status;
        } catch (HttpTimeoutException e) {
            log.log("WARN", "participant.call.timeout", "products-api did not answer", hop, correlationId,
                    millisSince(started), Map.of("saga_id", sagaId, "saga_step", "reserve-stock",
                            "participant", "opti-products-api"));
            return TIMEOUT;
        } catch (Exception e) {
            throw new IllegalStateException("reserve-stock failed: " + e.getMessage(), e);
        }
    }

    private static long millisSince(long startedNanos) {
        return (System.nanoTime() - startedNanos) / 1_000_000;
    }
}
