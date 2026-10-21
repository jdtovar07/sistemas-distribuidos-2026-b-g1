package co.edu.corhuila.opti.workflow.obs;

import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** W3C trace context of one hop: 32-hex trace id, 16-hex span id and the id of the parent span. */
public record TraceContext(String traceId, String spanId, String parentSpanId, String flags) {

    public static final String HEADER = "traceparent";

    private static final Pattern FORMAT = Pattern.compile("^00-([0-9a-f]{32})-([0-9a-f]{16})-([0-9a-f]{2})$");
    private static final SecureRandom RANDOM = new SecureRandom();

    /** A brand new trace: used when the gateway did not send a traceparent. */
    public static TraceContext fresh() {
        return new TraceContext(randomHex(16), randomHex(8), null, "01");
    }

    /** Reads an incoming header. Returns null when it is absent or malformed. */
    public static TraceContext parse(String header) {
        if (header == null) {
            return null;
        }
        Matcher m = FORMAT.matcher(header.trim());
        if (!m.matches() || m.group(1).matches("0+") || m.group(2).matches("0+")) {
            return null;
        }
        return new TraceContext(m.group(1), m.group(2), null, m.group(3));
    }

    /** Same trace, new span whose parent is this one: what a service creates for its own work or the next hop. */
    public TraceContext child() {
        return new TraceContext(traceId, randomHex(8), spanId, flags);
    }

    public String format() {
        return "00-" + traceId + "-" + spanId + "-" + flags;
    }

    private static String randomHex(int bytes) {
        byte[] raw = new byte[bytes];
        RANDOM.nextBytes(raw);
        return HexFormat.of().formatHex(raw);
    }
}
