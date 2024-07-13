package codes.abdullah.measurement.system.japan;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Volume;
import codes.abdullah.measurement.unit.AbstractUnit;
import codes.abdullah.measurement.unit.Unit;

public class JapanVolume extends AbstractUnit<Volume> implements Japan<Volume> {

    JapanVolume(double factor, String symbol, int unitIndex, double max) {
        super(factor, Dimensions.VOLUME, symbol, unitIndex, max);
    }

    @Override()
    public Unit<Volume> getBaseUnit() {
        return Japans.volume.SHO;
    }

    @Override()
    public Unit<Volume> unitAt(int i) {
        return Japans.volume.JAPAN_VOLUME_UNITS[i];
    }

    @Override()
    public Unit<Volume>[] units() {
        return Arrays.copyOf(Japans.volume.JAPAN_VOLUME_UNITS, Japans.volume.JAPAN_VOLUME_UNITS.length);
    }

    @Override()
    public int unitsCount() {
        return Japans.volume.JAPAN_VOLUME_UNITS.length;
    }

    public double toSais(double n) {
        return to(n, Japans.volume.SAI);
    }

    public double toShakus(double n) {
        return to(n, Japans.volume.SHAKU);
    }

    public double toGos(double n) {
        return to(n, Japans.volume.GO);
    }

    public double toShos(double n) {
        return to(n, Japans.volume.SHO);
    }

    public double toTos(double n) {
        return to(n, Japans.volume.TO);
    }

    public double toKokus(double n) {
        return to(n, Japans.volume.KOKU);
    }
}
