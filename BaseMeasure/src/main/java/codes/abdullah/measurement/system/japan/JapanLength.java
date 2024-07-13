package codes.abdullah.measurement.system.japan;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class JapanLength extends AbstractUnit<Length> implements Japan<Length> {

    JapanLength(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.LENGTH, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Length> getBaseUnit() {
        return Japans.SHAKU;
    }

    @Override()
    public Unit<Length> unitAt(int i) {
        return Japans.JAPAN_LENGTH_UNITS[i];
    }

    @Override()
    public Unit<Length>[] units() {
        return Arrays.copyOf(Japans.JAPAN_LENGTH_UNITS, Japans.JAPAN_LENGTH_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Japans.JAPAN_LENGTH_UNITS.length;
    }

    public double toMos(double n) {
        return to(n, Japans.MO);
    }

    public double toRins(double n) {
        return to(n, Japans.RIN);
    }

    public double toBus(double n) {
        return to(n, Japans.BU);
    }

    public double toSuns(double n) {
        return to(n, Japans.SUN);
    }

    public double toShakus(double n) {
        return to(n, Japans.SHAKU);
    }

    public double toKens(double n) {
        return to(n, Japans.KEN);
    }

    public double toJos(double n) {
        return to(n, Japans.JO);
    }

    public double toChos(double n) {
        return to(n, Japans.CHO);
    }

    public double toRis(double n) {
        return to(n, Japans.RI);
    }
}
