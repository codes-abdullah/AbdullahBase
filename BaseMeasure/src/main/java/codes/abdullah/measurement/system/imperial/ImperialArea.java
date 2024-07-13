package codes.abdullah.measurement.system.imperial;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Area;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class ImperialArea extends AbstractUnit<Area> implements Imperial<Area> {

    ImperialArea(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.AREA, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Area> getBaseUnit() {
        return Imperials.SQUARE_FOOT;
    }

    @Override()
    public Unit<Area> unitAt(int i) {
        return Imperials.IMPERIAL_AREA_UNITS[i];
    }

    @Override()
    public Unit<Area>[] units() {
        return Arrays.copyOf(Imperials.IMPERIAL_AREA_UNITS, Imperials.IMPERIAL_AREA_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Imperials.IMPERIAL_AREA_UNITS.length;
    }

    public double toSquareThous(double n) {
        return to(n, Imperials.SQUARE_THOU);
    }

    public double toSquareInches(double n) {
        return to(n, Imperials.SQUARE_INCH);
    }

    public double toSquareFeet(double n) {
        return to(n, Imperials.SQUARE_FOOT);
    }

    public double toSquareYards(double n) {
        return to(n, Imperials.SQUARE_YARD);
    }

    public double toSquareChains(double n) {
        return to(n, Imperials.SQUARE_CHAIN);
    }

    public double toSquareFurlongs(double n) {
        return to(n, Imperials.SQUARE_FURLONG);
    }

    public double toSquareMiles(double n) {
        return to(n, Imperials.SQUARE_MILE);
    }
}
