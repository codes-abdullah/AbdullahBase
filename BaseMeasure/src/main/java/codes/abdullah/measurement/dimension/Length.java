package codes.abdullah.measurement.dimension;

public class Length extends AbstractDimension {

	Length() {
		this(Dimensions.LENGTH_SYMBOL, true);
	}

	Length(String symbol, boolean primary) {
		super(symbol, primary);
	}

}
