package codes.abdullah.measurement.dimension;

public class Temperature extends AbstractDimension {

	Temperature() {
		this(Dimensions.TEMPERATURE_SYMBOL, true);
	}

	Temperature(String symbol, boolean primary) {
		super(symbol, primary);
	}

}
