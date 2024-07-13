package codes.abdullah.measurement.stopwatch;

import codes.abdullah.measurement.dimension.Time;
import codes.abdullah.measurement.formatter.Formatable;
import codes.abdullah.measurement.formatter.UnitFormatter;

/**
 * The immutable implementation of this interface is Stateless-Lazy which means
 * it will always calculate new results while it is immutable due to the
 * stateless lazy Invocation, the fact of being immutable can be found by
 * invoking the {@link #reset()} method
 */
public interface Stopwatch extends Formatable<Stopwatch> {
	/**
	 * invoking this method will not only return the formatter, but will do a lazy
	 * calculation as well
	 */
	@Override
	UnitFormatter<Time> getFormatter();

	long getBegin();

	long getElapsed();

	Stopwatch reset();

}
