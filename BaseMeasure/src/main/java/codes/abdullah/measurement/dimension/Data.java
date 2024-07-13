package codes.abdullah.measurement.dimension;

public class Data extends AbstractDimension {

	Data() {
		this(Dimensions.DATA_SYMBOL, true);
	}
	
	Data(String symbol, boolean primary) {
		super(symbol, primary);
	}
}
