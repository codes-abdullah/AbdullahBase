package codes.abdullah.measurement.system.metric;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class MetricLength extends AbstractUnit<Length> implements Metric<Length> {

    MetricLength(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.LENGTH, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Length> getBaseUnit() {
        return Metrics.METER;
    }

    @Override()
    public Unit<Length> unitAt(int i) {
        return Metrics.METRIC_LENGTH_UNITS[i];
    }

    @Override()
    public Unit<Length>[] units() {
        return Arrays.copyOf(Metrics.METRIC_LENGTH_UNITS, Metrics.METRIC_LENGTH_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Metrics.METRIC_LENGTH_UNITS.length;
    }

    public double toMillimeters(double n) {
        return to(n, Metrics.MILLIMETER);
    }

    public double toCentimeters(double n) {
        return to(n, Metrics.CENTIMETER);
    }

    public double toDecimeters(double n) {
        return to(n, Metrics.DECIMETER);
    }

    public double toMeters(double n) {
        return to(n, Metrics.METER);
    }

    public double toDekameters(double n) {
        return to(n, Metrics.DEKAMETER);
    }

    public double toHecometers(double n) {
        return to(n, Metrics.HECOMETER);
    }

    public double toKilometers(double n) {
        return to(n, Metrics.KILOMETER);
    }
}
