package codes.abdullah.measurement.system.usc;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class UscNautical extends AbstractUnit<Length> implements Usc<Length> {

    UscNautical(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.LENGTH, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Length> getBaseUnit() {
        return Uscs.CABLE;
    }

    @Override()
    public Unit<Length> unitAt(int i) {
        return Uscs.USC_NAUTICAL_UNITS[i];
    }

    @Override()
    public Unit<Length>[] units() {
        return Arrays.copyOf(Uscs.USC_NAUTICAL_UNITS, Uscs.USC_NAUTICAL_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Uscs.USC_NAUTICAL_UNITS.length;
    }

    public double toFathoms(double n) {
        return to(n, Uscs.FATHOM);
    }

    public double toCables(double n) {
        return to(n, Uscs.CABLE);
    }

    public double toNauticalMiles(double n) {
        return to(n, Uscs.NAUTICAL_MILE);
    }
}
