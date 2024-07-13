package codes.abdullah.measurement.stopwatch;

import codes.abdullah.measurement.dimension.Time;
import codes.abdullah.measurement.formatter.UnitFormatter;
import codes.abdullah.measurement.system.metric.Metrics;
import codes.abdullah.project.Check;

public class MutableStopwatch implements Stopwatch {
	private static final long serialVersionUID = -8877610142095031563L;

	private UnitFormatter<Time> formatter;
	private long begin;

	MutableStopwatch(UnitFormatter<Time> formatter) {
		this(formatter, (long) Metrics.MILLISECOND.to(System.currentTimeMillis(), formatter.getBaseUnit()));
	}

	MutableStopwatch(UnitFormatter<Time> formatter, long begin) {
		this.formatter = formatter.toMutable();
		this.begin = Check.aboveOrEqualsZero(begin);
	}

	@Override
	public double getCurrent() {
		return getElapsed();
	}

	@Override
	public Stopwatch toImmutable() {
		return new ImmutableStopwatch(formatter, begin);
	}

	@Override
	public Stopwatch toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
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
		this.begin = (long) Metrics.MILLISECOND.to(System.currentTimeMillis(), formatter.getBaseUnit());
		this.formatter = formatter.reset();
		return this;
	}

	@Override
	public final String toString() {
		return getFormatter().toString();
	}

}
