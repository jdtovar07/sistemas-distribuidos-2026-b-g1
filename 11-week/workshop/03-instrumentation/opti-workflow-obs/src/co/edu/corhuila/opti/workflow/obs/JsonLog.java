package co.edu.corhuila.opti.workflow.obs;

import java.io.PrintStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/** One JSON object per line, with the fields of 02-log-contract.md. */
public final class JsonLog {

    /** Keys that must never reach a log line (see "never log" in 02-log-contract.md). */
    private static final Set<String> NEVER_LOG = Set.of("document_number", "phone", "email", "password",
            "authorization", "service_token", "prescription");

    private final String service;
    private final String version;
    private final String environment;
    private final PrintStream out;

    public JsonLog(String service, String version, String environment, PrintStream out) {
        this.service = service;
        this.version = version;
        this.environment = environment;
        this.out = out;
    }

    public void log(String level, String event, String message, TraceContext ctx, String correlationId,
                    Long durationMs, Map<String, Object> domain) {
        Map<String, Object> line = new LinkedHashMap<>();
        line.put("timestamp", Instant.now().truncatedTo(ChronoUnit.MILLIS).toString());
        line.put("level", level);
        line.put("service", service);
        line.put("version", version);
        line.put("environment", environment);
        line.put("trace_id", ctx.traceId());
        line.put("span_id", ctx.spanId());
        line.put("correlation_id", correlationId);
        line.put("event", event);
        line.put("message", message);
        if (durationMs != null) {
            line.put("duration_ms", durationMs);
        }
        domain.forEach((key, value) -> line.put(key, NEVER_LOG.contains(key) ? "***" : value));
        out.println(toJson(line));
    }

    static String toJson(Map<String, Object> fields) {
        StringBuilder json = new StringBuilder("{");
        fields.forEach((key, value) -> {
            if (json.length() > 1) {
                json.append(',');
            }
            json.append(quote(key)).append(':');
            json.append(value instanceof Number ? value.toString() : quote(String.valueOf(value)));
        });
        return json.append('}').toString();
    }

    private static String quote(String text) {
        return "\"" + text.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", " ") + "\"";
    }
}
