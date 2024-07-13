package codes.abdullah.measurement.dimension.convert;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;

public interface UpDimensionConverter<TO extends Dimension, FROM extends TO> {
	double convert(double n, Unit<TO> from, Unit<FROM> to);
}
