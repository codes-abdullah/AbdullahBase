package codes.abdullah.measurement.system.digital;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.system.MeasurementSystems;
import codes.abdullah.measurement.unit.Unit;

public interface Digital<D extends Dimension> extends Unit<D> {

    @Override()
    default MeasurementSystem getSystem() {
        return MeasurementSystems.DIGITAL_SYSTEM;
    }
}
