package codes.abdullah.project.lang;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class LEmptyOrNull {
	LEmptyOrNull() {
	}

	// =================================================
	// =================================================
	// ======================================= is-empty
	// =================================================
	// =================================================

	/**
	 * @see #isEmpty(double[])
	 */
	public boolean isEmpty(boolean[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * @see #isEmpty(double[])
	 */
	public boolean isEmpty(byte[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * @see #isEmpty(double[])
	 */
	public boolean isEmpty(short[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * @see #isEmpty(double[])
	 */
	public boolean isEmpty(char[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * @see #isEmpty(double[])
	 */
	public boolean isEmpty(int[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * @see #isEmpty(double[])
	 */
	public boolean isEmpty(long[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * @see #isEmpty(double[])
	 */
	public boolean isEmpty(float[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * Test if given array is empty
	 * 
	 * @return true if given array is empty according to
	 *         {@link LLength#of(double[])}
	 */
	public boolean isEmpty(double[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * @see #isEmpty(double[])
	 */
	public <T> boolean isEmpty(T[] array) {
		return Lang.length.of(array) == 0;
	}

	/**
	 * Test if Array, {@link Collection}, {@link Map} or {@link CharSequence} is
	 * empty
	 * 
	 * @return true if {@link Collection}, {@link Map} or {@link CharSequence} and
	 *         is empty
	 * @throws UnsupportedOperationException if given is undefined, defined only any
	 *                                       array according to
	 *                                       {@link Class#isArray()},
	 *                                       {@link Collection}, {@link Map} and
	 *                                       {@link CharSequence}
	 * @throws NullPointerException          if given is null
	 */
	@SuppressWarnings("rawtypes")
	public boolean isEmpty(Object o) {
		if (o.getClass().isArray())
			return Array.getLength(o) == 0;
		else if (o instanceof Collection)
			return ((Collection) o).isEmpty();
		else if (o instanceof Map)
			return ((Map) o).isEmpty();
		else if (o instanceof CharSequence)
			return ((CharSequence) o).length() == 0;
		throw new UnsupportedOperationException("undefined object, found: " + o.getClass());
	}

	// =================================================
	// =================================================
	// ======================================= is-null-or-empty
	// =================================================
	// =================================================

	/**
	 * @see #isAny(double[])
	 */
	public boolean isAny(boolean[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public boolean isAny(byte[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public boolean isAny(short[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public boolean isAny(char[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public boolean isAny(int[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public boolean isAny(long[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public boolean isAny(float[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * Test if given array is null or empty
	 * 
	 * @return true if given array is empty according to
	 *         {@link LLength#of(double[], boolean)}
	 */
	public boolean isAny(double[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public <T> boolean isAny(T[] array) {
		return Lang.length.of(array, true) == 0;
	}

	/**
	 * @see #isAny(double[])
	 */
	public <T> boolean isAny(T o) {
		return o == null || isEmpty(o);
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public boolean isAny(boolean[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public boolean isAny(byte[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public boolean isAny(short[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public boolean isAny(char[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public boolean isAny(int[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public boolean isAny(long[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public boolean isAny(float[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * Test if given array is null or given len == 0
	 */
	public boolean isAny(double[] arr, int len) {
		return arr == null || len == 0;
	}

	/**
	 * @see #isAny(double[], int)
	 */
	public <T> boolean isAny(T[] arr, int len) {
		return arr == null || len == 0;
	}

	// =================================================
	// =================================================
	// ======================================= require-no-null-or-empty
	// =================================================
	// =================================================

	/**
	 * Pass only if given object is not null
	 * 
	 * @throws NullPointerException if object is null
	 */
	public <T> T requireNoNull(T object) {
		return requireNoNull(object, null);
	}

	/**
	 * Pass only if given object is not null
	 * 
	 * @param prefix a prefix to inject before the exception text, pass null or
	 *               empty str to skip it
	 * 
	 * @throws NullPointerException if object is null
	 */
	public <T> T requireNoNull(T object, CharSequence prefix) {
		if (object == null) {
			String str = prefix == null || prefix.length() == 0 ? "object is null" : prefix + " is null";
			throw new NullPointerException(str);
		}
		return object;
	}

	/**
	 * @see #requireNiether(Object, CharSequence)
	 */
	public <T> T requireNiether(T object) {
		return requireNiether(object, null);
	}

	/**
	 * Pass only if given object is not null and not empty according to
	 * {@link #isEmpty(Object)}
	 * 
	 * @param prefix a prefix to inject before the exception text, pass null or
	 *               empty str to skip it
	 * 
	 * @throws NullPointerException          if T is null
	 * @throws IllegalArgumentException      if T is empty
	 * @throws UnsupportedOperationException if T not supported according to
	 *                                       {@link #isEmpty(Object)}
	 */
	public <T> T requireNiether(T object, CharSequence prefix) {
		requireNoNull(object, prefix);
		if (isEmpty(object)) {
			String type = object.getClass().isArray() ? "array" : "object";
			String str = prefix == null || prefix.length() == 0 ? String.format("%s is empty", type)
					: prefix + " is empty";
			throw new IllegalArgumentException(str);
		}
		return object;
	}

}
