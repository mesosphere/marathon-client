package mesosphere.marathon.client.model.v2;

import java.util.Map;

import mesosphere.client.common.ModelUtils;

public class GetMetricsResponse {
    private String version;
    private Map<String, Gauge> gauges;
    private Map<String, Counter> counters;
    private Map<String, Histogram> histograms;
    private Map<String, Meter> meters;
    private Map<String, Timer> timers;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Gauge> getGauges() {
        return gauges;
    }

    public void setGauges(Map<String, Gauge> gauges) {
        this.gauges = gauges;
    }

    public Map<String, Counter> getCounters() {
        return counters;
    }

    public void setCounters(Map<String, Counter> counters) {
        this.counters = counters;
    }

    public Map<String, Histogram> getHistograms() {
        return histograms;
    }

    public void setHistograms(Map<String, Histogram> histograms) {
        this.histograms = histograms;
    }

    public Map<String, Meter> getMeters() {
        return meters;
    }

    public void setMeters(Map<String, Meter> meters) {
        this.meters = meters;
    }

    public Map<String, Timer> getTimers() {
        return timers;
    }

    public void setTimers(Map<String, Timer> timers) {
        this.timers = timers;
    }

    static class Gauge {
        private Object value;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    static class Counter {
        private Integer count;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    static class Histogram extends Counter {
        private Double max;
        private Double mean;
        private Double min;
        private Double p50;
        private Double p75;
        private Double p95;
        private Double p98;
        private Double p99;
        private Double p999;
        private Double stddev;

        public Double getMax() {
            return max;
        }

        public void setMax(Double max) {
            this.max = max;
        }

        public Double getMean() {
            return mean;
        }

        public void setMean(Double mean) {
            this.mean = mean;
        }

        public Double getMin() {
            return min;
        }

        public void setMin(Double min) {
            this.min = min;
        }

        public Double getP50() {
            return p50;
        }

        public void setP50(Double p50) {
            this.p50 = p50;
        }

        public Double getP75() {
            return p75;
        }

        public void setP75(Double p75) {
            this.p75 = p75;
        }

        public Double getP95() {
            return p95;
        }

        public void setP95(Double p95) {
            this.p95 = p95;
        }

        public Double getP98() {
            return p98;
        }

        public void setP98(Double p98) {
            this.p98 = p98;
        }

        public Double getP99() {
            return p99;
        }

        public void setP99(Double p99) {
            this.p99 = p99;
        }

        public Double getP999() {
            return p999;
        }

        public void setP999(Double p999) {
            this.p999 = p999;
        }

        public Double getStddev() {
            return stddev;
        }

        public void setStddev(Double stddev) {
            this.stddev = stddev;
        }
    }

    static class Meter extends Counter {
        private Double m15_rate;
        private Double m1_rate;
        private Double m5_rate;
        private Double mean_rate;
        private String units;

        public Double getM15_rate() {
            return m15_rate;
        }

        public void setM15_rate(Double m15_rate) {
            this.m15_rate = m15_rate;
        }

        public Double getM1_rate() {
            return m1_rate;
        }

        public void setM1_rate(Double m1_rate) {
            this.m1_rate = m1_rate;
        }

        public Double getM5_rate() {
            return m5_rate;
        }

        public void setM5_rate(Double m5_rate) {
            this.m5_rate = m5_rate;
        }

        public Double getMean_rate() {
            return mean_rate;
        }

        public void setMean_rate(Double mean_rate) {
            this.mean_rate = mean_rate;
        }

        public String getUnits() {
            return units;
        }

        public void setUnits(String units) {
            this.units = units;
        }
    }

    static class Timer extends Histogram {
        private Double m15_rate;
        private Double m1_rate;
        private Double m5_rate;
        private Double mean_rate;
        private String duration_units;
        private String rate_units;

        public Double getM15_rate() {
            return m15_rate;
        }

        public void setM15_rate(Double m15_rate) {
            this.m15_rate = m15_rate;
        }

        public Double getM1_rate() {
            return m1_rate;
        }

        public void setM1_rate(Double m1_rate) {
            this.m1_rate = m1_rate;
        }

        public Double getM5_rate() {
            return m5_rate;
        }

        public void setM5_rate(Double m5_rate) {
            this.m5_rate = m5_rate;
        }

        public Double getMean_rate() {
            return mean_rate;
        }

        public void setMean_rate(Double mean_rate) {
            this.mean_rate = mean_rate;
        }

        public String getDuration_units() {
            return duration_units;
        }

        public void setDuration_units(String duration_units) {
            this.duration_units = duration_units;
        }

        public String getRate_units() {
            return rate_units;
        }

        public void setRate_units(String rate_units) {
            this.rate_units = rate_units;
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
