package codes.abdullah.measurement.dimension;

public class Area extends Length {
	Area() {
		this(Dimensions.LENGTH_SYMBOL, false);
	}

	Area(String symbol, boolean primary) {
		super(symbol, primary);
	}
}
