package codes.abdullah.measurement.system.imperial;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Volume;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class ImperialVolume extends AbstractUnit<Volume> implements Imperial<Volume> {

    ImperialVolume(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.VOLUME, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Volume> getBaseUnit() {
        return Imperials.FLUID_OUNCE;
    }

    @Override()
    public Unit<Volume> unitAt(int i) {
        return Imperials.IMPERIAL_VOLUME_UNITS[i];
    }

    @Override()
    public Unit<Volume>[] units() {
        return Arrays.copyOf(Imperials.IMPERIAL_VOLUME_UNITS, Imperials.IMPERIAL_VOLUME_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Imperials.IMPERIAL_VOLUME_UNITS.length;
    }

    public double toTeaSpoons(double n) {
        return to(n, Imperials.TEA_SPOON);
    }

    public double toTableSpoons(double n) {
        return to(n, Imperials.TABLE_SPOON);
    }

    public double toFluidOunces(double n) {
        return to(n, Imperials.FLUID_OUNCE);
    }

    public double toGills(double n) {
        return to(n, Imperials.GILL);
    }

    public double toPints(double n) {
        return to(n, Imperials.PINT);
    }

    public double toQuarts(double n) {
        return to(n, Imperials.QUART);
    }

    public double toGallons(double n) {
        return to(n, Imperials.GALLON);
    }
}
