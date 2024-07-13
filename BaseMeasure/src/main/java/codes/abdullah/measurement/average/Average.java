package codes.abdullah.measurement.average;

import java.util.Collection;

public interface Average {
	Average add(long n);

	double getAverage();

	Average addAll(Collection<Long> n);
}
