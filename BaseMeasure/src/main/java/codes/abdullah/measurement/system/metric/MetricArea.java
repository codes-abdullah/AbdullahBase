package codes.abdullah.measurement.system.metric;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Area;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class MetricArea extends AbstractUnit<Area> implements Metric<Area> {

    MetricArea(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.AREA, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Area> getBaseUnit() {
        return Metrics.SQUARE_METER;
    }

    @Override()
    public Unit<Area> unitAt(int i) {
        return Metrics.METRIC_AREA_UNITS[i];
    }

    @Override()
    public Unit<Area>[] units() {
        return Arrays.copyOf(Metrics.METRIC_AREA_UNITS, Metrics.METRIC_AREA_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Metrics.METRIC_AREA_UNITS.length;
    }

    public double toSquareMillimeters(double n) {
        return to(n, Metrics.SQUARE_MILLIMETER);
    }

    public double toSquareCentimeters(double n) {
        return to(n, Metrics.SQUARE_CENTIMETER);
    }

    public double toSquareDecimeters(double n) {
        return to(n, Metrics.SQUARE_DECIMETER);
    }

    public double toSquareMeters(double n) {
        return to(n, Metrics.SQUARE_METER);
    }

    public double toSquareDekameters(double n) {
        return to(n, Metrics.SQUARE_DEKAMETER);
    }

    public double toSquareHecometers(double n) {
        return to(n, Metrics.SQUARE_HECOMETER);
    }

    public double toSquareKilometers(double n) {
        return to(n, Metrics.SQUARE_KILOMETER);
    }
}
