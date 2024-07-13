package codes.abdullah.measurement.formatter;

import java.util.Arrays;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;

final class ImmutableUnitFormatter<Q extends Dimension> extends AbstractUnitFormatter<Q> {
	private static final long serialVersionUID = 2805575885757163674L;
	private final StringBuilder builder, temp;
	private final double input;
	private final double[] values;
	private final int[] unitIndexes, sortedUnitIndexes;

	ImmutableUnitFormatter(Unit<Q> baseUnit, String pattern, String applyPattern, int flags, int maxFraction,
			int dynamicsLength, int[] insertIndexes, int[] sortedUnitIndexes, int[] unitIndexes, double[] values,
			StringBuilder builder, StringBuilder temp, double input) {
		super(baseUnit, pattern, applyPattern, flags, maxFraction, dynamicsLength, insertIndexes);
		this.input = input;
		this.builder = new StringBuilder(builder);
		this.temp = new StringBuilder(temp);
		this.values = Arrays.copyOf(values, values.length);
		this.unitIndexes = Arrays.copyOf(unitIndexes, unitIndexes.length);
		this.sortedUnitIndexes = Arrays.copyOf(sortedUnitIndexes, sortedUnitIndexes.length);
	}

	@Override
	public double getInput() {
		return input;
	}

	@Override
	protected StringBuilder getBuilder() {
		return new StringBuilder(builder);
	}

	@Override
	protected UnitFormatter<Q> assign(int[] sortedUnitIndexes, int[] unitIndexes, double[] values, StringBuilder builder,
			StringBuilder temp, double input) {
		return new ImmutableUnitFormatter<Q>(getBaseUnit(), getPattern(), getApplyPattern(), getFlags(), getMaxFraction(),
				getDynamicsLength(), getInsertIndexes(), sortedUnitIndexes, unitIndexes, values, builder, temp, input);
	}

	@Override
	protected StringBuilder getTemp() {
		return new StringBuilder(temp);
	}

	@Override
	protected double[] getValues() {
		return Arrays.copyOf(values, values.length);
	}

	@Override
	protected int[] getUnitIndexes() {
		return Arrays.copyOf(unitIndexes, unitIndexes.length);
	}

	@Override
	protected int[] getSortedUnitIndexes() {
		return Arrays.copyOf(sortedUnitIndexes, sortedUnitIndexes.length);
	}

	@Override
	public String toString() {
		return builder.toString();
	}

	@Override
	public UnitFormatter<Q> reset() {
		return new ImmutableUnitFormatter<Q>(getBaseUnit(), getPattern(), getApplyPattern(), getFlags(), getMaxFraction(),
				getDynamicsLength(), getInsertIndexes(), new int[getBaseUnit().unitsCount()],
				new int[getBaseUnit().unitsCount()], new double[getBaseUnit().unitsCount()], getBuilder(), getTemp(),
				getInput());
	}

}
