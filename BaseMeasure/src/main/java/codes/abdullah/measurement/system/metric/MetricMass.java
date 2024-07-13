package codes.abdullah.measurement.system.metric;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Mass;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class MetricMass extends AbstractUnit<Mass> implements Metric<Mass> {

    MetricMass(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.MASS, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Mass> getBaseUnit() {
        return Metrics.GRAM;
    }

    @Override()
    public Unit<Mass> unitAt(int i) {
        return Metrics.METRIC_MASS_UNITS[i];
    }

    @Override()
    public Unit<Mass>[] units() {
        return Arrays.copyOf(Metrics.METRIC_MASS_UNITS, Metrics.METRIC_MASS_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Metrics.METRIC_MASS_UNITS.length;
    }

    public double toMilligrams(double n) {
        return to(n, Metrics.MILLIGRAM);
    }

    public double toCentigrams(double n) {
        return to(n, Metrics.CENTIGRAM);
    }

    public double toDecigrams(double n) {
        return to(n, Metrics.DECIGRAM);
    }

    public double toGrams(double n) {
        return to(n, Metrics.GRAM);
    }

    public double toDekagrams(double n) {
        return to(n, Metrics.DEKAGRAM);
    }

    public double toHecograms(double n) {
        return to(n, Metrics.HECOGRAM);
    }

    public double toKilograms(double n) {
        return to(n, Metrics.KILOGRAM);
    }
}
