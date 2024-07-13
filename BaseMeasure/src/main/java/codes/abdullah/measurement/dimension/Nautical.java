package codes.abdullah.measurement.dimension;

public class Nautical extends Length {

	Nautical() {
		this(Dimensions.LENGTH_SYMBOL, false);
	}

	Nautical(String symbol, boolean primary) {
		super(symbol, primary);
	}

}
