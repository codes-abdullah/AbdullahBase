package codes.abdullah.measurement.system.imperial;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class ImperialLength extends AbstractUnit<Length> implements Imperial<Length> {

    ImperialLength(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.LENGTH, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Length> getBaseUnit() {
        return Imperials.FOOT;
    }

    @Override()
    public Unit<Length> unitAt(int i) {
        return Imperials.IMPERIAL_LENGTH_UNITS[i];
    }

    @Override()
    public Unit<Length>[] units() {
        return Arrays.copyOf(Imperials.IMPERIAL_LENGTH_UNITS, Imperials.IMPERIAL_LENGTH_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Imperials.IMPERIAL_LENGTH_UNITS.length;
    }

    public double toThous(double n) {
        return to(n, Imperials.THOU);
    }

    public double toInches(double n) {
        return to(n, Imperials.INCH);
    }

    public double toFeet(double n) {
        return to(n, Imperials.FOOT);
    }

    public double toYards(double n) {
        return to(n, Imperials.YARD);
    }

    public double toChains(double n) {
        return to(n, Imperials.CHAIN);
    }

    public double toFurlongs(double n) {
        return to(n, Imperials.FURLONG);
    }

    public double toMiles(double n) {
        return to(n, Imperials.MILE);
    }
}
