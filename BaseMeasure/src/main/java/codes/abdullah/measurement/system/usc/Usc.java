package codes.abdullah.measurement.system.usc;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.system.MeasurementSystems;
import codes.abdullah.measurement.unit.Unit;

public interface Usc<D extends Dimension> extends Unit<D> {

    @Override()
    default MeasurementSystem getSystem() {
        return MeasurementSystems.USC_SYSTEM;
    }
}
