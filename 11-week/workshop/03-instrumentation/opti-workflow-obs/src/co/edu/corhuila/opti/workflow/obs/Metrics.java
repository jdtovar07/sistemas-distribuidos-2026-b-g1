package co.edu.corhuila.opti.workflow.obs;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/** The two metrics of 04-metrics.md in Prometheus text format, for GET /metrics. */
public final class Metrics {

    /** Seconds. 2 is the latency SLO threshold, 5 is HTTP_TIMEOUT of the workflow. */
    static final double[] BUCKETS = {0.05, 0.1, 0.25, 0.5, 1, 2, 5, 10};

    private final Map<String, LongAdder> requests = new ConcurrentHashMap<>();
    private final Map<String, LongAdder[]> buckets = new ConcurrentHashMap<>();
    private final Map<String, DoubleAdder> sums = new ConcurrentHashMap<>();

    /** outcome is one of: completed, compensated, failed, rejected. */
    public void count(String saga, String outcome) {
        requests.computeIfAbsent("saga=\"" + saga + "\",outcome=\"" + outcome + "\"", k -> new LongAdder()).increment();
    }

    public void observe(String saga, double seconds) {
        String labels = "saga=\"" + saga + "\"";
        LongAdder[] counts = buckets.computeIfAbsent(labels, k -> newCounters());
        for (int i = 0; i < BUCKETS.length; i++) {
            if (seconds <= BUCKETS[i]) {
                counts[i].increment();
            }
        }
        counts[BUCKETS.length].increment();
        sums.computeIfAbsent(labels, k -> new DoubleAdder()).add(seconds);
    }

    public String render() {
        StringBuilder text = new StringBuilder("# TYPE workflow_saga_requests_total counter\n");
        new TreeMap<>(requests).forEach((labels, n) ->
                text.append("workflow_saga_requests_total{").append(labels).append("} ").append(n.sum()).append('\n'));
        text.append("# TYPE workflow_saga_duration_seconds histogram\n");
        new TreeMap<>(buckets).forEach((labels, counts) -> {
            for (int i = 0; i < BUCKETS.length; i++) {
                text.append("workflow_saga_duration_seconds_bucket{").append(labels).append(",le=\"")
                        .append(BUCKETS[i]).append("\"} ").append(counts[i].sum()).append('\n');
            }
            text.append("workflow_saga_duration_seconds_bucket{").append(labels).append(",le=\"+Inf\"} ")
                    .append(counts[BUCKETS.length].sum()).append('\n');
            text.append("workflow_saga_duration_seconds_sum{").append(labels).append("} ")
                    .append(sums.get(labels).sum()).append('\n');
            text.append("workflow_saga_duration_seconds_count{").append(labels).append("} ")
                    .append(counts[BUCKETS.length].sum()).append('\n');
        });
        return text.toString();
    }

    private static LongAdder[] newCounters() {
        LongAdder[] counters = new LongAdder[BUCKETS.length + 1];
        for (int i = 0; i < counters.length; i++) {
            counters[i] = new LongAdder();
        }
        return counters;
    }
}
