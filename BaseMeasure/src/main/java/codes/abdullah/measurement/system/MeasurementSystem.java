package codes.abdullah.measurement.system;

import codes.abdullah.measurement.utils.MeasurementId;

/**
 * 
 * Implementing this interface is totally useless, always extend
 * {@link BasicMeasurementSystem} to install yours<br>
 * <br>
 * Representative of a Measurement System<br>
 * A Measurement System implementation should not be installed more than once,
 * therefore the {@link BasicMeasurementSystem#equals(Object)} does the job to
 * make sure no more than one installation per system
 */
public interface MeasurementSystem extends MeasurementId {
	/**
	 * @return e.g:  Metric
	 * */
	String getName();
}
