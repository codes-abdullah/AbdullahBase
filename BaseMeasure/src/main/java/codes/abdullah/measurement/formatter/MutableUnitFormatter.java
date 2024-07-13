package codes.abdullah.measurement.formatter;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;
/**
 * 
 * */
final class MutableUnitFormatter<Q extends Dimension> extends AbstractUnitFormatter<Q> {
	private static final long serialVersionUID = 2805575885757163674L;
	private int[] sortedUnitIndexes, unitIndexes;
	private double[] values;
	private StringBuilder builder, temp;
	private double input;

	MutableUnitFormatter(Unit<Q> baseUnit, String pattern, String applyPattern, int flags, int maxFraction,
			int dynamicsLength, int[] insertIndexes, int[] sortedUnitIndexes, int[] unitIndexes, double[] values,
			StringBuilder builder, StringBuilder temp, double input) { 
		super(baseUnit, pattern, applyPattern, flags, maxFraction, dynamicsLength, insertIndexes);
		this.sortedUnitIndexes = sortedUnitIndexes;
		this.unitIndexes = unitIndexes;
		this.temp = temp;
		this.builder = builder;
		this.values = values;
		this.input = input;
	}

	@Override
	public double getInput() {
		return input;
	}

	@Override
	protected StringBuilder getBuilder() {
		return builder;
	}

	@Override
	protected UnitFormatter<Q> assign(int[] sortedUnitIndexes, int[] unitIndexes, double[] values,
			StringBuilder builder, StringBuilder temp, double input) {
		this.sortedUnitIndexes = sortedUnitIndexes;
		this.unitIndexes = unitIndexes;
		this.values = values;
		this.builder = builder;
		this.temp = temp;
		this.input = input;
		return this;
	}

	@Override
	protected StringBuilder getTemp() {
		return temp;
	}

	@Override
	protected double[] getValues() {
		for (int i = 0; i < values.length; i++) {
			values[i] = 0;
		}
		return values;
	}

	@Override
	protected int[] getUnitIndexes() {
		return unitIndexes;
	}

	@Override
	protected int[] getSortedUnitIndexes() {
		return sortedUnitIndexes;
	}

	@Override
	public String toString() {
		return builder.toString();
	}

	@Override
	public UnitFormatter<Q> reset() {
		for (int i = 0; i < sortedUnitIndexes.length; i++) {
			sortedUnitIndexes[i] = -1;
		}
		for (int i = 0; i < unitIndexes.length; i++) {
			unitIndexes[i] = -1;
		}
		for (int i = 0; i < values.length; i++) {
			values[i] = 0;
		}
		if (builder.length() > 0)
			builder.delete(0, builder.length());
		if (temp.length() > 0)
			temp.delete(0, temp.length());
		return this;
	}

}
