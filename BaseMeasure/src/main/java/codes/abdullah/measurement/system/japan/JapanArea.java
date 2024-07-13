package codes.abdullah.measurement.system.japan;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Area;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class JapanArea extends AbstractUnit<Area> implements Japan<Area> {

    JapanArea(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.AREA, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Area> getBaseUnit() {
        return Japans.area.TSUBO;
    }

    @Override()
    public Unit<Area> unitAt(int i) {
        return Japans.area.JAPAN_AREA_UNITS[i];
    }

    @Override()
    public Unit<Area>[] units() {
        return Arrays.copyOf(Japans.area.JAPAN_AREA_UNITS, Japans.area.JAPAN_AREA_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Japans.area.JAPAN_AREA_UNITS.length;
    }

    public double toShakus(double n) {
        return to(n, Japans.area.SHAKU);
    }

    public double toGos(double n) {
        return to(n, Japans.area.GO);
    }

    public double toJos(double n) {
        return to(n, Japans.area.JO);
    }

    public double toTsubos(double n) {
        return to(n, Japans.area.TSUBO);
    }

    public double toSes(double n) {
        return to(n, Japans.area.SE);
    }

    public double toTans(double n) {
        return to(n, Japans.area.TAN);
    }

    public double toChos(double n) {
        return to(n, Japans.area.CHO);
    }
}
