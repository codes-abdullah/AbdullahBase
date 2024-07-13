package codes.abdullah.measurement.stopwatch;

import codes.abdullah.measurement.dimension.Time;
import codes.abdullah.measurement.formatter.UnitFormatter;
import codes.abdullah.measurement.formatter.UnitFormatters;
import codes.abdullah.measurement.system.metric.Metrics;
import codes.abdullah.measurement.unit.Unit;

public class Stopwatches {

	public static Stopwatch ofNanos() {
		return of(Metrics.MILLISECOND);
	}

	public static Stopwatch ofMillis() {
		return of(Metrics.MILLISECOND);
	}

	public static Stopwatch ofSeconds() {
		return of(Metrics.SECOND);
	}

	public static Stopwatch of(Unit<Time> u) {
		return of(UnitFormatters.of(u));
	}

	public static Stopwatch of(UnitFormatter<Time> formatter) {
		return new MutableStopwatch(formatter);
	}

}
