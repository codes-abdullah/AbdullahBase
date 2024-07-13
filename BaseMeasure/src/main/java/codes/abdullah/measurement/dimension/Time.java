package codes.abdullah.measurement.dimension;

public class Time extends AbstractDimension {

	Time() {
		this(Dimensions.TIME_SYMBOL, true);
	}

	Time(String symbol, boolean primary) {
		super(symbol, primary);
	}

}
