package codes.abdullah.measurement.formatter;

import java.io.Serializable;

import codes.abdullah.project.Immutable;

public interface Formatable<F extends Formatable<F>> extends Immutable<F>, Serializable {
	double getCurrent();

	UnitFormatter<?> getFormatter();
	
	F reset();
}
