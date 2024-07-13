package codes.abdullah.measurement.dimension.convert;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.unit.Unit;
import codes.abdullah.measurement.utils.MeasurementId;

public interface DimensionConverter<D extends Dimension> extends MeasurementId {

	MeasurementSystem getSuperior();

	MeasurementSystem getInferior();

	D getDimension();

	/**
	 * @return superior per inferior factor
	 */
	double getFactor();

	double convert(double n, Unit<D> from, Unit<D> to);
	
	String toBinaryString();
}
