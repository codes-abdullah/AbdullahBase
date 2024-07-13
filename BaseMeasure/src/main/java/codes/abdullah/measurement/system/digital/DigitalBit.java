package codes.abdullah.measurement.system.digital;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Data;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class DigitalBit extends AbstractUnit<Data> implements Digital<Data> {

    DigitalBit(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.DATA, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Data> getBaseUnit() {
        return Digitals.MEGABIT;
    }

    @Override()
    public Unit<Data> unitAt(int i) {
        return Digitals.DIGITAL_BIT_UNITS[i];
    }

    @Override()
    public Unit<Data>[] units() {
        return Arrays.copyOf(Digitals.DIGITAL_BIT_UNITS, Digitals.DIGITAL_BIT_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Digitals.DIGITAL_BIT_UNITS.length;
    }

    public double toBits(double n) {
        return to(n, Digitals.BIT);
    }

    public double toKilobits(double n) {
        return to(n, Digitals.KILOBIT);
    }

    public double toMegabits(double n) {
        return to(n, Digitals.MEGABIT);
    }

    public double toGigabits(double n) {
        return to(n, Digitals.GIGABIT);
    }

    public double toTerabits(double n) {
        return to(n, Digitals.TERABIT);
    }

    public double toPetabits(double n) {
        return to(n, Digitals.PETABIT);
    }
}
