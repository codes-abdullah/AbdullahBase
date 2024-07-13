package codes.abdullah.measurement.dimension.convert;

import codes.abdullah.digits.Digits;
import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.system.MeasurementSystems;
import codes.abdullah.measurement.unit.Unit;
import codes.abdullah.measurement.utils.MeasurementUtils;

public class BasicDimensionConverter<D extends Dimension> implements DimensionConverter<D> {
	private final int id;
	private final MeasurementSystem superior, inferior;
	private final double factor;
	private final D dimension;

	public BasicDimensionConverter(double superiorPerInferiorFactor, D dimension, MeasurementSystem superior,
			MeasurementSystem inferior) {
		if (superior == inferior) {
			throw new IllegalArgumentException("superior == inferior");
		} else if (superiorPerInferiorFactor == 0) {
			// throw new IllegalArgumentException("superiorPerInferiorFactor == 0");
		}
		this.dimension = dimension;
		this.superior = superior;
		this.inferior = inferior;
		this.factor = superiorPerInferiorFactor;
		this.id = MeasurementSystems.install(this);

	}

	@Override
	public MeasurementSystem getSuperior() {
		return superior;
	}

	@Override
	public MeasurementSystem getInferior() {
		return inferior;
	}

	@Override
	public D getDimension() {
		return dimension;
	}

	@Override
	public final int getId() {
		return id;
	}

	@Override
	public double getFactor() {
		return factor;
	}

	@Override
	public double convert(double n, Unit<D> from, Unit<D> to) {
		// e.g:
		// from = Metric and superior = Metric
		// to = Imperial and inferior = Imperial
		if (from.getSystem() == superior) {
			n = from.toBase(n) / factor;
			return MeasurementUtils.to(to.getBaseUnit(), to, n);
		}
		// e.g:
		// from = Imperial and superior = Metric
		// to = Metric and inferior = Imperial
		n = from.toBase(n) * factor;
		return MeasurementUtils.to(to.getBaseUnit(), to, n);
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof DimensionConverter) {
			DimensionConverter<?> ms = (DimensionConverter<?>) obj;
			return ms.getId() == id;
		}
		return false;
	}

	@Override
	public String toString() {
		// return String.format("id(%s), %s", id, MeasurementSystems.toString(dimension,
		// superior, inferior));
		return String.format("%s vs %s @ %s bin(%s)", superior.getName(), inferior.getName(),
				dimension.getClass().getSimpleName(), toBinaryString());
	}

	@Override
	public String toBinaryString() {
		return String.format("%s | %s", Digits.ints.toBinary(dimension.getId()),
				Digits.ints.toBinary(superior.getId() | inferior.getId()));
	}

}
