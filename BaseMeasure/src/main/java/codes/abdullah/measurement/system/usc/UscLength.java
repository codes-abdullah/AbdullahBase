package codes.abdullah.measurement.system.usc;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class UscLength extends AbstractUnit<Length> implements Usc<Length> {

    UscLength(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.LENGTH, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Length> getBaseUnit() {
        return Uscs.FOOT;
    }

    @Override()
    public Unit<Length> unitAt(int i) {
        return Uscs.USC_LENGTH_UNITS[i];
    }

    @Override()
    public Unit<Length>[] units() {
        return Arrays.copyOf(Uscs.USC_LENGTH_UNITS, Uscs.USC_LENGTH_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Uscs.USC_LENGTH_UNITS.length;
    }

    public double toPoints(double n) {
        return to(n, Uscs.POINT);
    }

    public double toPicas(double n) {
        return to(n, Uscs.PICA);
    }

    public double toInches(double n) {
        return to(n, Uscs.INCH);
    }

    public double toFeet(double n) {
        return to(n, Uscs.FOOT);
    }

    public double toYards(double n) {
        return to(n, Uscs.YARD);
    }

    public double toMiles(double n) {
        return to(n, Uscs.MILE);
    }
}
