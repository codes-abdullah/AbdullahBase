package codes.abdullah.measurement.dimension;

public class Volume extends Area {

	Volume() {
		this(Dimensions.VOLUME_SYMBOL, false);
	}

	Volume(String symbol, boolean primary) {
		super(symbol, primary);
	}

}
