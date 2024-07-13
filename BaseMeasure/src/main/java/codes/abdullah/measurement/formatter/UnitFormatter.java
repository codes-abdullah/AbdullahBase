package codes.abdullah.measurement.formatter;

import java.io.Serializable;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;
import codes.abdullah.project.Immutable;

/**
 * Simple formatter supports {@link Unit} api</br>
 * </br>
 * <b>patterns syntax:</b> <b>$[x]</b> where x is your option, i.e: <b>$[1]</b>
 * which means the units-index 1 of the given {@link Unit#unitAt(int)} siblings,
 * or <b>$[BASE]</b> which equals to {@link Unit#getBaseUnit()}, or
 * <b>$[BASE-1]</b> or <b>$[BASE+1]</b> or <b>$[MAX-1]</b> or <b>$[MIN+1]</b>,
 * and of-curse you can use the symbols of {@link Unit#getSymbol()} and you can
 * do something like</br>
 * </br>
 * <code>String.format("$[%s]:$[%s]:$[%s]", Units.MINUTE,
			Units.SECOND, Units.MILLISECOND);</code></br>
 * </br>
 * and finally the dynamic syntax which is <b>$[~3]</b>, the <b>~</b> means a
 * dynamic pattern and the number 3 means the amount of units will be used based
 * on current feed input</br>
 * 
 * <b>flags: </b>{@link UnitFormatters#INCLUDE_SYMBOLS},
 * {@link UnitFormatters#DISCARD_FRACTION},
 * {@link UnitFormatters#DISCARD_UNDEFINED}</br>
 * <b>Factory: </b> {@link UnitFormatters}<br>
 * <b>Builder: </b> {@link UnitFormatters.Builder}, see:
 * {@link UnitFormatters#of(Unit)}<br>
 * 
 */
public interface UnitFormatter<Q extends Dimension> extends Serializable, Immutable<UnitFormatter<Q>> {
	default UnitFormatter<Q> incrementFormat(final double input) {
		return format(getInput() + input);
	}

	default UnitFormatter<Q> decrementFormat(final double input) {
		return format(getInput() - input);
	}

	UnitFormatter<Q> format(final double input);

	String getPattern();

	Unit<Q> getBaseUnit();

	double getInput();

	double getInput(Unit<Q> as);

	UnitFormatter<Q> reset();
}
