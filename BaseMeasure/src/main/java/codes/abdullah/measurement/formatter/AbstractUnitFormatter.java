package codes.abdullah.measurement.formatter;

import java.util.Arrays;

import codes.abdullah.digits.Digits;
import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;

abstract class AbstractUnitFormatter<Q extends Dimension> implements UnitFormatter<Q> {
	private static final long serialVersionUID = 2315752914154183801L;
	private final int maxFraction, flags, dynamicsLength;
	private final String pattern, applyPattern;
	private final Unit<Q> baseUnit;
	private final int[] insertIndexes;

	AbstractUnitFormatter(Unit<Q> baseUnit, String pattern, String applyPattern, int flags, int maxFraction,
			int dynamicsLength, int[] insertIndexes) {
		this.baseUnit = baseUnit;
		this.pattern = pattern;
		this.applyPattern = applyPattern;
		this.flags = flags;
		this.maxFraction = maxFraction;
		this.dynamicsLength = dynamicsLength;
		this.insertIndexes = insertIndexes;
	}

	@Override
	public UnitFormatter<Q> format(final double input) {
		// ------------------------------ find all possible values
		// clear placeholder for all possible values can be found
		int tempIndex = 0, displacement = 0;
		final int[] sortedUnitIndexes = getSortedUnitIndexes(), unitIndexes = getUnitIndexes();
		final double[] values = getValues();

		double tempVal = 0;
		StringBuilder builder = getBuilder();
		StringBuilder temp = getTemp();
		// String applyPattern = getApplyPattern();
		if (builder.length() > 0)
			builder.delete(0, builder.length());
		if (temp.length() > 0)
			temp.delete(0, temp.length());

		builder.append(applyPattern);

		// --------------
		double unsigned_input = input < 0 ? -input : input;
		double tempInput = unsigned_input;
		Unit<Q> baseUnit = getBaseUnit(), last = baseUnit;
		// find all possible values and assign to vals
		for (int i = 0; i < baseUnit.unitsCount(); i++) {
			// convert from last-unit to current-unit
			tempInput = last.to(tempInput, baseUnit.unitAt(i));
			// do not allow to go beyond the max of current-unit
			tempVal = Math.floor(tempInput % baseUnit.unitAt(i).max());
			// assign
			values[i] = tempVal;
			// remove from input
			tempInput -= tempVal;
			if (tempInput <= 0)
				break;
			last = baseUnit.unitAt(i);
		}

		// ------------------------------ discharge any remaining
		// check if input has remaining values
		if (tempInput != 0) {
			Unit<Q> u = UnitFormatters.findBelongsToWhom(baseUnit, last, tempInput);
			// convert and increment
			values[u.unitIndex()] += last.to(tempInput, u);
		}

		// #######################################
		// if dynamic-detected, will try to auto-create readable pattern according
		// to given dynamic-length and srcInput, i.e: form of (user-text....$[~2])
		// -> (user-text... (748 mb, 22.44 kb))
		if (Digits.ints.isFlagged(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED)) {
			// clear all indexes in sorted arr
			for (int i = 0; i < sortedUnitIndexes.length; i++) {
				sortedUnitIndexes[i] = -1;
				unitIndexes[i] = -1;
			}
			// find the srcInput belongs to whom
			Unit<Q> u = UnitFormatters.findBelongsToWhom(baseUnit, baseUnit, unsigned_input);
			// reverse-loop start from u.index, ends at required length
			for (int i = u.unitIndex(); i >= (u.unitIndex() - (dynamicsLength - 1)); i--) {
				// if went below 0, just assign -1 to skip it later
				if (i < 0) {
					unitIndexes[tempIndex] = -1;
					sortedUnitIndexes[tempIndex++] = -1;
					continue;
				}
				unitIndexes[tempIndex] = i;
				sortedUnitIndexes[tempIndex++] = i;
			}
			// re sort the arr
			Arrays.sort(sortedUnitIndexes);

		}

		// #######################################

		if (!Digits.ints.isFlagged(flags, UnitFormatters.DISCARD_UNDEFINED)) {
			// ------------------------------ do not allow to discard undefined-units-values
			main: for (int i = 0; i < values.length; i++) {
				// if detected some-values of current-unit not empty and the current-unit is not
				// defined, try to find the closest-defined-unit to current-unit starting from
				// bigger
				// siblings
				if (values[i] != 0 && !UnitFormatters.isDefined(unitIndexes, baseUnit.unitAt(i))) {
					for (int j = 0; j < sortedUnitIndexes.length; j++) {
						// if current-unit-index(current-defined-unit) bigger than the
						// undefined-unit-index
						if (sortedUnitIndexes[j] > baseUnit.unitAt(i).unitIndex()) {
							// convert according to current-defined-unit and increment
							values[sortedUnitIndexes[j]] += baseUnit.unitAt(i).to(values[i],
									baseUnit.unitAt(sortedUnitIndexes[j]));
							// clear the value of undefined-unit
							values[i] = 0;
							continue main;
						}
					}

					for (int j = sortedUnitIndexes.length - 1; j >= 0; j--) {
						// if current-unit-index(current-defined-unit) smaller than the
						// undefined-unit-index
						if (sortedUnitIndexes[j] < baseUnit.unitAt(i).unitIndex()) {
							// convert according to current-defined-unit and increment
							values[sortedUnitIndexes[j]] += baseUnit.unitAt(i).to(values[i],
									baseUnit.unitAt(sortedUnitIndexes[j]));
							// clear the value of undefined-unit
							values[i] = 0;
							continue main;
						}
					}
				}
			}
		}
		// ------------------------------ inject according to pattern
		// if dynamic-detected, will inject according to given dynamic-length as
		// possible starting from bigger unit that has been detected according to
		// current srcInput
		if (Digits.ints.isFlagged(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED)) {
			for (int i = 0; i < unitIndexes.length; i++) {
				if (unitIndexes[i] == -1)
					continue;
				if (Digits.ints.isFlagged(flags, UnitFormatters.DISCARD_FRACTION)) {
					if (input < 0)
						temp.append('-');
					temp.append((long) values[unitIndexes[i]]);
				} else {
					if (input < 0)
						temp.append('-');
					temp.append((maxFraction == -1 ? values[unitIndexes[i]]
							: Digits.doubles.round(values[unitIndexes[i]], maxFraction)));
				}

				if (Digits.ints.isFlagged(flags, UnitFormatters.INCLUDE_SYMBOLS))
					temp.append(' ').append(baseUnit.unitAt(unitIndexes[i]).getSymbol());

				if (i > 0)
					temp.insert(0, ' ');
				builder.insert(insertIndexes[0] + displacement, temp);

				displacement += temp.length();
				temp.delete(0, temp.length());
			}
		} else {
			for (int i = 0; i < insertIndexes.length; i++) {
				if (Digits.ints.isFlagged(flags, UnitFormatters.DISCARD_FRACTION)) {
					if (input < 0)
						temp.append('-');
					temp.append((long) values[unitIndexes[i]]);
				} else {
					if (input < 0)
						temp.append('-');
					temp.append((maxFraction == -1 ? values[unitIndexes[i]]
							: Digits.doubles.round(values[unitIndexes[i]], maxFraction)));
				}
				if (Digits.ints.isFlagged(flags, UnitFormatters.INCLUDE_SYMBOLS))
					temp.append(' ').append(baseUnit.unitAt(unitIndexes[i]).getSymbol());

				builder.insert(insertIndexes[i] + displacement, temp);
				displacement += temp.length();
				temp.delete(0, temp.length());
			}
		}
		return assign(sortedUnitIndexes, unitIndexes, values, builder, temp, input);
	}

	protected abstract StringBuilder getBuilder();

	protected abstract StringBuilder getTemp();

	protected abstract double[] getValues();

	protected abstract int[] getUnitIndexes();

	protected abstract int[] getSortedUnitIndexes();

	protected abstract UnitFormatter<Q> assign(int[] sortedUnitIndexes, int[] unitIndexes, double[] values,
			StringBuilder builder, StringBuilder temp, double input);

	@Override
	public String getPattern() {
		return pattern;
	}

	@Override
	public Unit<Q> getBaseUnit() {
		return baseUnit;
	}

	protected int getFlags() {
		return flags;
	}

	protected String getApplyPattern() {
		return applyPattern;
	}

	public int getMaxFraction() {
		return maxFraction;
	}

	public int getDynamicsLength() {
		return dynamicsLength;
	}

	public int[] getInsertIndexes() {
		return insertIndexes;
	}

	@Override
	public double getInput(Unit<Q> as) {
		return getBaseUnit().to(getInput(), as);
	}

	@Override
	public UnitFormatter<Q> toImmutable() {
		return new ImmutableUnitFormatter<Q>(getBaseUnit(), getPattern(), getApplyPattern(), getFlags(), getMaxFraction(),
				getDynamicsLength(), getInsertIndexes(), getSortedUnitIndexes(), getUnitIndexes(), getValues(),
				getBuilder(), getTemp(), getInput());
	}

	@Override
	public UnitFormatter<Q> toMutable() {
		return new MutableUnitFormatter<Q>(getBaseUnit(), getPattern(), getApplyPattern(), getFlags(), getMaxFraction(),
				getDynamicsLength(), getInsertIndexes(), getSortedUnitIndexes(), getUnitIndexes(), getValues(),
				getBuilder(), getTemp(), getInput());
	}

	@Override
	public boolean isImmutable() {
		return this instanceof ImmutableUnitFormatter;
	}

}
