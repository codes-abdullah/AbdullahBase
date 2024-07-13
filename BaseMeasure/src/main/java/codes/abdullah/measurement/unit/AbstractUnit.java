package codes.abdullah.measurement.unit;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.dimension.convert.DimensionConverter;
import codes.abdullah.measurement.system.MeasurementSystems;
import codes.abdullah.measurement.utils.MeasurementUtils;

public abstract class AbstractUnit<D extends Dimension> implements Unit<D> {
	private final double factor;
	private final String symbol;
	private final int unitIndex, id, hashCode;
	private final double max;
	private final D dimension;

	protected AbstractUnit(double factor, D dimension, String symbol, int unitIndex, double max) {
		this.factor = factor;
		this.symbol = symbol;
		this.unitIndex = unitIndex;
		this.max = max;
		this.dimension = dimension;
		this.id = MeasurementSystems.install(this);
		this.hashCode = (31 * (int) ((int) factor ^ ((int) factor >>> 32))) + symbol.hashCode();
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public double toBase(double n) {
		return to(n, getBaseUnit());
	}

	@Override
	public double to(double n, Unit<D> target) {
		if (getSystem() != target.getSystem()) {
			DimensionConverter<D> dc = MeasurementSystems.findConverter(getDimension(), getSystem(),
					target.getSystem());
			return dc.convert(n, this, target);
		}
		return MeasurementUtils.to(this, target, n);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof AbstractUnit) {
			AbstractUnit<?> au = (AbstractUnit<?>) obj;
			return au.hashCode() == hashCode();
		}
		return false;
	}

	@Override
	public double getFactor() {
		return factor;
	}

	@Override
	public CharSequence getSymbol() {
		return symbol;
	}

	@Override
	public int unitIndex() {
		return unitIndex;
	}

	@Override
	public String toString() {
		return symbol;
	}

	@Override
	public double max() {
		return max;
	}

	@Override
	public D getDimension() {
		return dimension;
	}

	@Override
	public final int getId() {
		return id;
	}

}
