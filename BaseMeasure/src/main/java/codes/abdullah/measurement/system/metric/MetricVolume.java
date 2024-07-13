package codes.abdullah.measurement.system.metric;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Volume;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class MetricVolume extends AbstractUnit<Volume> implements Metric<Volume> {

    MetricVolume(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.VOLUME, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Volume> getBaseUnit() {
        return Metrics.LITER;
    }

    @Override()
    public Unit<Volume> unitAt(int i) {
        return Metrics.METRIC_VOLUME_UNITS[i];
    }

    @Override()
    public Unit<Volume>[] units() {
        return Arrays.copyOf(Metrics.METRIC_VOLUME_UNITS, Metrics.METRIC_VOLUME_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Metrics.METRIC_VOLUME_UNITS.length;
    }

    public double toMilliliters(double n) {
        return to(n, Metrics.MILLILITER);
    }

    public double toCentiliters(double n) {
        return to(n, Metrics.CENTILITER);
    }

    public double toDeciliters(double n) {
        return to(n, Metrics.DECILITER);
    }

    public double toLiters(double n) {
        return to(n, Metrics.LITER);
    }

    public double toDekaliters(double n) {
        return to(n, Metrics.DEKALITER);
    }

    public double toHectoliters(double n) {
        return to(n, Metrics.HECTOLITER);
    }

    public double toKiloliters(double n) {
        return to(n, Metrics.KILOLITER);
    }
}
