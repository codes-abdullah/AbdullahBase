package codes.abdullah.measurement.dimension;

import codes.abdullah.measurement.utils.MeasurementId;

public interface Dimension extends MeasurementId {
	/**
	 * @return true if this is primary dimension
	 */
	boolean isPrimary();

	/**
	 * @return the symbol of this dimension
	 */
	String getSymbol();
	
	int getExponent();

}
