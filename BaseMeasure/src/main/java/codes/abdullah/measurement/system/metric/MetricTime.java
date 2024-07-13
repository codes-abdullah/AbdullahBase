package codes.abdullah.measurement.system.metric;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Time;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class MetricTime extends AbstractUnit<Time> implements Metric<Time> {

    MetricTime(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.TIME, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Time> getBaseUnit() {
        return Metrics.SECOND;
    }

    @Override()
    public Unit<Time> unitAt(int i) {
        return Metrics.METRIC_TIME_UNITS[i];
    }

    @Override()
    public Unit<Time>[] units() {
        return Arrays.copyOf(Metrics.METRIC_TIME_UNITS, Metrics.METRIC_TIME_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Metrics.METRIC_TIME_UNITS.length;
    }

    public double toNanoseconds(double n) {
        return to(n, Metrics.NANOSECOND);
    }

    public double toMicroseconds(double n) {
        return to(n, Metrics.MICROSECOND);
    }

    public double toMilliseconds(double n) {
        return to(n, Metrics.MILLISECOND);
    }

    public double toSeconds(double n) {
        return to(n, Metrics.SECOND);
    }

    public double toMinutes(double n) {
        return to(n, Metrics.MINUTE);
    }

    public double toHours(double n) {
        return to(n, Metrics.HOUR);
    }

    public double toDays(double n) {
        return to(n, Metrics.DAY);
    }
}
