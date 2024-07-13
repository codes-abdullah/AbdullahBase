package codes.abdullah.measurement.dimension;

import codes.abdullah.measurement.system.MeasurementSystems;

public abstract class AbstractDimension implements Dimension {
	private final int id, exponent;
	private final String symbol;
	private final boolean primary;

	protected AbstractDimension(String symbol, boolean primary) {
		this.symbol = symbol;
		this.primary = primary;
		this.id = MeasurementSystems.install(this);
		this.exponent = Dimensions.getExponent(symbol);
	}

	@Override
	public final boolean equals(Object obj) {
		return getClass().equals(obj.getClass());
	}

	@Override
	public boolean isPrimary() {
		return primary;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public final int getId() {
		return id;
	}

	@Override
	public int getExponent() {
		return exponent;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName().toString();
	}

}
