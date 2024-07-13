package codes.abdullah.measurement.unit;

import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.dimension.Dimensions;
import codes.abdullah.measurement.dimension.Length;
import codes.abdullah.measurement.system.MeasurementSystem;
import codes.abdullah.measurement.system.metric.Metric;
import codes.abdullah.measurement.system.metric.Metrics;
import codes.abdullah.measurement.utils.MeasurementId;

public interface Unit<D extends Dimension> extends MeasurementId {
	/**
	 * @return dimension of this unit, e.g: {@link Length}
	 * @see Dimension
	 * @see Dimensions
	 */
	D getDimension();

	/**
	 * @return the factor of this unit
	 */
	double getFactor();

	/**
	 * @return the symbol of this unit
	 */
	CharSequence getSymbol();

	/**
	 * index of this unit
	 * 
	 * @see #units()
	 */
	int unitIndex();

	/**
	 * convert according to base-unit
	 * 
	 * @see #getBaseUnit()
	 */
	double toBase(double n);

	double to(double n, Unit<D> target);
	

	/**
	 * @return base-unit, for example if this instance is {@link Metric} with
	 *         dimension of {@link Length}, will return {@link Metrics#METER}
	 */
	Unit<D> getBaseUnit();

	/**
	 * @return array of sibling units
	 * @see Metrics#METRIC_LENGTH_UNITS
	 * @see Metrics#METRIC_AREA_UNITS
	 * @see Metrics#METRIC_MASS_UNITS
	 */
	Unit<D> unitAt(int i);

	/**
	 * @return a copy of units array
	 */
	Unit<D>[] units();

	int unitsCount();

	/**
	 * @return the max capacity of current unit, beyond this max, is can be upgraded
	 *         to next unit
	 */
	double max();

	MeasurementSystem getSystem();

	// -------------------------------------------

	// -------------------------------------------

}
