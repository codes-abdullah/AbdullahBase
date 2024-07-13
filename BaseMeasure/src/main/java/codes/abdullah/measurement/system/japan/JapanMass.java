package codes.abdullah.measurement.system.japan;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Mass;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class JapanMass extends AbstractUnit<Mass> implements Japan<Mass> {

    JapanMass(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.MASS, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Mass> getBaseUnit() {
        return Japans.KIN;
    }

    @Override()
    public Unit<Mass> unitAt(int i) {
        return Japans.JAPAN_MASS_UNITS[i];
    }

    @Override()
    public Unit<Mass>[] units() {
        return Arrays.copyOf(Japans.JAPAN_MASS_UNITS, Japans.JAPAN_MASS_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Japans.JAPAN_MASS_UNITS.length;
    }

    public double toFuns(double n) {
        return to(n, Japans.FUN);
    }

    public double toMommes(double n) {
        return to(n, Japans.MOMME);
    }

    public double toHyakumes(double n) {
        return to(n, Japans.HYAKUME);
    }

    public double toKins(double n) {
        return to(n, Japans.KIN);
    }

    public double toKans(double n) {
        return to(n, Japans.KAN);
    }

    public double toMarus(double n) {
        return to(n, Japans.MARU);
    }

    public double toTans(double n) {
        return to(n, Japans.TAN);
    }
}
