package codes.abdullah.bigbit;

import java.util.Iterator;

public interface BitsIterator extends Iterator<Integer> {

	@Override
	Integer next();

	/**
	 * <b>Caution: </b>Always invoke {@link #next()} before invoking this method<br>
	 * 
	 * @return the value of current bit, (2^bitIndex)
	 */
	Number value();

	/**
	 * <b>Caution: </b>Always invoke {@link #next()} before invoking this method<br>
	 * 
	 * @return index of current bit
	 */
	int bitIndex();
	
	/**
	 * <b>Caution: </b>Always invoke {@link #next()} before invoking this method<br>
	 * 
	 * @return index of current word
	 */
	int wordIndex();
}
