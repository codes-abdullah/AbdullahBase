package codes.abdullah.measurement.stopwatch;

import codes.abdullah.measurement.dimension.Time;
import codes.abdullah.measurement.formatter.UnitFormatter;
import codes.abdullah.measurement.system.metric.Metrics;
import codes.abdullah.project.Check;

public class ImmutableStopwatch implements Stopwatch {
	private static final long serialVersionUID = -8877610142095031563L;

	private final UnitFormatter<Time> formatter;
	private final long begin;

	ImmutableStopwatch(UnitFormatter<Time> formatter) {
		this(formatter, (long) Metrics.MILLISECOND.to(System.currentTimeMillis(), formatter.getBaseUnit()));
	}

	ImmutableStopwatch(UnitFormatter<Time> formatter, long begin) {
		this.formatter = formatter.toImmutable();
		this.begin = Check.aboveOrEqualsZero(begin);
	}

	@Override
	public double getCurrent() {
		return getElapsed();
	}

	@Override
	public Stopwatch toImmutable() {
		return this;
	}

	@Override
	public Stopwatch toMutable() {
		return new MutableStopwatch(formatter, begin);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

	@Override
	public UnitFormatter<Time> getFormatter() {
		return formatter.format(getElapsed());
	}

	@Override
	public long getBegin() {
		return begin;
	}

	@Override
	public long getElapsed() {
		return ((long) Metrics.MILLISECOND.to(System.currentTimeMillis(), formatter.getBaseUnit())) - begin;
	}

	@Override
	public Stopwatch reset() {
		return new ImmutableStopwatch(formatter.reset());
	}

	@Override
	public final String toString() {
		return getFormatter().toString();
	}

}
