package codes.abdullah.measurement.system.digital;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Data;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class DigitalByte extends AbstractUnit<Data> implements Digital<Data> {

    DigitalByte(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.DATA, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Data> getBaseUnit() {
        return Digitals.MEGABYTE;
    }

    @Override()
    public Unit<Data> unitAt(int i) {
        return Digitals.DIGITAL_BYTE_UNITS[i];
    }

    @Override()
    public Unit<Data>[] units() {
        return Arrays.copyOf(Digitals.DIGITAL_BYTE_UNITS, Digitals.DIGITAL_BYTE_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Digitals.DIGITAL_BYTE_UNITS.length;
    }

    public double toBytes(double n) {
        return to(n, Digitals.BYTE);
    }

    public double toKilobytes(double n) {
        return to(n, Digitals.KILOBYTE);
    }

    public double toMegabytes(double n) {
        return to(n, Digitals.MEGABYTE);
    }

    public double toGigabytes(double n) {
        return to(n, Digitals.GIGABYTE);
    }

    public double toTerabytes(double n) {
        return to(n, Digitals.TERABYTE);
    }

    public double toPetabytes(double n) {
        return to(n, Digitals.PETABYTE);
    }
}
