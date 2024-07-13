package codes.abdullah.measurement.system.usc;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Volume;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class UscVolume extends AbstractUnit<Volume> implements Usc<Volume> {

    UscVolume(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.VOLUME, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Volume> getBaseUnit() {
        return Uscs.FLUID_OUNCE;
    }

    @Override()
    public Unit<Volume> unitAt(int i) {
        return Uscs.USC_VOLUME_UNITS[i];
    }

    @Override()
    public Unit<Volume>[] units() {
        return Arrays.copyOf(Uscs.USC_VOLUME_UNITS, Uscs.USC_VOLUME_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Uscs.USC_VOLUME_UNITS.length;
    }

    public double toTeaSpoons(double n) {
        return to(n, Uscs.TEA_SPOON);
    }

    public double toTableSpoons(double n) {
        return to(n, Uscs.TABLE_SPOON);
    }

    public double toFluidOunces(double n) {
        return to(n, Uscs.FLUID_OUNCE);
    }

    public double toCups(double n) {
        return to(n, Uscs.CUP);
    }

    public double toPints(double n) {
        return to(n, Uscs.PINT);
    }

    public double toQuarts(double n) {
        return to(n, Uscs.QUART);
    }

    public double toGallons(double n) {
        return to(n, Uscs.GALLON);
    }
}
