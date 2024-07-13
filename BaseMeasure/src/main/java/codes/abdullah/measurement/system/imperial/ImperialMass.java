package codes.abdullah.measurement.system.imperial;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Mass;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class ImperialMass extends AbstractUnit<Mass> implements Imperial<Mass> {

    ImperialMass(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.MASS, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Mass> getBaseUnit() {
        return Imperials.POUND;
    }

    @Override()
    public Unit<Mass> unitAt(int i) {
        return Imperials.IMPERIAL_MASS_UNITS[i];
    }

    @Override()
    public Unit<Mass>[] units() {
        return Arrays.copyOf(Imperials.IMPERIAL_MASS_UNITS, Imperials.IMPERIAL_MASS_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Imperials.IMPERIAL_MASS_UNITS.length;
    }

    public double toGrains(double n) {
        return to(n, Imperials.GRAIN);
    }

    public double toDrachms(double n) {
        return to(n, Imperials.DRACHM);
    }

    public double toOunces(double n) {
        return to(n, Imperials.OUNCE);
    }

    public double toPounds(double n) {
        return to(n, Imperials.POUND);
    }

    public double toStones(double n) {
        return to(n, Imperials.STONE);
    }

    public double toQuarters(double n) {
        return to(n, Imperials.QUARTER);
    }

    public double toHundredweights(double n) {
        return to(n, Imperials.HUNDREDWEIGHT);
    }
}
