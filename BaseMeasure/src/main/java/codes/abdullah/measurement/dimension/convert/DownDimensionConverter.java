package codes.abdullah.measurement.dimension.convert;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;

public interface DownDimensionConverter<PARENT extends Dimension, CHILD extends PARENT> {
	double convert(double n, Unit<PARENT> from, Unit<CHILD> to);
}
