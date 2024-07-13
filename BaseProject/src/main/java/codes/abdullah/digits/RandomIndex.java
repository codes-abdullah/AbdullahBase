package codes.abdullah.digits;

import java.util.Iterator;
import java.util.NoSuchElementException;

import codes.abdullah.project.Check;

/**
 * Mutable implementation.<br>
 * This object can produce random indexes without any duplications,
 * {@link java.util.Random} will generate a lot of duplicates because it is
 * stateless.<br>
 * <br>
 * The class has an <b>infinite flag</b>, if an instance marked as infinite,
 * will produce the random indexes infinitely (after each unique set will
 * repeat), so {@link #hasNext()} will be useless<br>
 * By default it will work as normal {@link Iterator} and will throw
 * {@link NoSuchElementException} if reached to end
 * 
 */

public class RandomIndex implements Iterator<Integer> {
	private static final long additional = 1013904223, multiplier = 1664525;
	private long divider;
	private int seed, next, length, offset;
	private boolean hasNext, infinite;

	/**
	 * @param length
	 */
	public RandomIndex(int length) {
		setLength(length, 0);
	}

	/**
	 * 
	 * @param from inclusive
	 * @param to   exclusive
	 */
	public RandomIndex(int from, int to) {
		setRange(from, to);
	}

	/**
	 * set the range<br>
	 * if invoked, will reset the current state and will start all over
	 * 
	 * @param from inclusive
	 * @param to   exclusive
	 */
	public RandomIndex setRange(int from, int to) {
		Check.range(from, to);
		return setLength(to - from, from);
	}

	/**
	 * if an marked as infinite, will produce the random indexes infinitely (after
	 * each unique set will repeat), so {@link #hasNext()} will be useless<br>
	 */
	public RandomIndex setInfinite(boolean infinite) {
		this.infinite = infinite;
		return setLength(length, offset);
	}

	/**
	 * @return the offset
	 */
	public int getFrom() {
		return offset;
	}

	/**
	 * @return the range
	 */
	public int getTo() {
		return offset + length;
	}

	/**
	 * @see #setLength(int, int)
	 */
	public RandomIndex setLength(int length) {
		return setLength(length, 0);
	}

	/**
	 * recalculate the state of this instance
	 * 
	 * @param length i.e: 3
	 * @param offset i.e: 10, so will produce from 10 to 13
	 * @throws UnsupportedOperationException if length <= 0 or length > 2^30
	 */
	public RandomIndex setLength(int length, int offset) {
		if (length <= 0 || length > Math.pow(2, 30))
			throw new UnsupportedOperationException("Unsupported length: " + length);
		this.length = length;
		double log = Math.log(length);
		double log2 = Math.log(2);
		double exponent = Math.ceil(log / log2);
		this.divider = (int) Math.pow(2, exponent);
		this.seed = Digits.RANDOM.nextInt((int) Math.min(length, Integer.MAX_VALUE));
		this.next = seed;
		this.hasNext = true;
		this.offset = offset;
		return this;
	}

	/**
	 * reset the state of this instance <br>
	 * if invoked, will reset the current state and will start all over
	 */
	public RandomIndex reset() {
		return setLength(length, offset);
	}

	@Override
	public boolean hasNext() {
		return hasNext;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	@Override
	public Integer next() {
		if (!hasNext) {
			if (infinite) {
				setLength(length, offset);
			} else {
				throw new NoSuchElementException();
			}
		}
		next = (int) ((multiplier * next + additional) % divider);
		while (next < 0 || next >= length) {
			next = (int) ((multiplier * next + additional) % divider);
		}
		if (next == seed)
			hasNext = false;

		return next + offset;
	}

	/**
	 * produce a from<br>
	 * The <b>Infinite</b> flag be set, and length must be > 1
	 * 
	 * @return always will be <= (length / 2)
	 * @throws IllegalStateException if (!infinite || length == 1)
	 */
	public int nextFrom() {
		checkForRange();
		int from;
		do {
			from = next();
		} while (from >= length / 2);
		return from;
	}

	/**
	 * produce a to<br>
	 * The <b>Infinite</b> flag be set, and length must be > 1
	 * 
	 * @throws IllegalStateException    if (!infinite || length == 1)
	 * @throws IllegalArgumentException if (from >= (length / 2))
	 */
	public int nextTo(int from) {
		checkForRange();
		if (from >= length / 2)
			throw new IllegalArgumentException(
					String.format("(from(%d) >= length(%d) / 2)(%d)", from, length, length / 2));
		int to = from;
		while (to <= from) {
			to = next();
		}
		return to;
	}

	private void checkForRange() {
		if (!infinite || length == 1) {
			throw new IllegalStateException(String.format(
					"!infinite(%s) || length(%s) == 1\nif you want to use this as infinite random range generator, invoke setInfinite(boolean)",
					infinite, length));
		}
	}

}