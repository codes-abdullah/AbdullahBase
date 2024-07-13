package codes.abdullah.project.lang;

import java.lang.reflect.Array;

public class LLength {

	LLength() {
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(boolean[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(boolean[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(byte[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(byte[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(short[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(short[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(char[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(char[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(int[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(int[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(long[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(long[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(float[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(float[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public int of(double[] array) {
		return of(array, false);
	}

	/**
	 * Get length of array, usually arr.length, unless zeroIfNull is true, will
	 * return 0 if arr == null
	 * 
	 * @param zeroIfNull true to return 0 if given array is null
	 * @return length of the given array
	 * @throws NullPointerException     if zeroIfNull is false and given is null
	 */
	public int of(double[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return array.length;
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public <T> int of(T[] array) {
		return of(array, false);
	}

	/**
	 * @see #of(double[], boolean)
	 */
	public <T> int of(T[] array, boolean zeroIfNull) {
		if (zeroIfNull && array == null)
			return 0;
		return Array.getLength(array);
	}

}
