package codes.abdullah.array.integer;

import java.io.Serializable;
import java.util.Random;

import codes.abdullah.project.Endian;
import codes.abdullah.project.Immutable;
import codes.abdullah.project.lang.Lang;

/**
 * Basic wrapper over a primitive array that supports length and
 * {@link Endian}<br>
 * All output methods will effect the output result based on assigned
 * {@link Endian}, except {@link #get()}, which will return raw array
 */
public interface IntArray extends Serializable, Immutable<IntArray> {

	/**
	 * Clone current instance based on current length
	 */
	IntArray newClone();

	// ===========
	int flags();

	boolean isFlagged(int flag);

	IntArray flag(int flag);

	IntArray unflag(int flag);

	IntArray unflag();
	// ===========

	IntArray newInstance();

	IntArray newInstance(int[] arr);

	IntArray newInstance(int[] arr, int len);

	IntArray newInstance(int[] arr, int len, Endian read);

	IntArray newInstance(int[] arr, int len, Endian read, int flags);

	// ===========
	/**
	 * Get current array, if this is {@link #isImmutable()}, return new copy trimmed
	 * by {@link #length()} (discard all extra slots), otherwise return the source
	 * (mutable) with all extra slots<br>
	 * <b>Array: </b>Raw if mutable, otherwise raw and trimmed<br>
	 * <b>Endian:</b> Unconsidered<br>
	 * <b>Capacity:</b> Considered if mutable<br>
	 * <b>Length:</b> Considered if immutable <br>
	 * <br>
	 * This method will not take assigned {@link Endian} in consideration<br>
	 * <br>
	 * e.g: {10, 20, 30}<br>
	 * If assigned {@link Endian#LITTLE}, get returns -> {10, 20, 30}<br>
	 * If assigned {@link Endian#BIG}, get returns -> {10, 20, 30}, nothing will be
	 * changed<br>
	 * <br>
	 * Assigned {@link Endian} will cause all other methods to output based on it,
	 * but not this method<br>
	 * e.g: {10, 20, 30} <br>
	 * {@link Endian#BIG}<br>
	 * {@link #toString()} will output: {30, 20, 10}
	 */
	int[] toArray();
	
	

	/**
	 * Get element from current array<br>
	 * <b>Array: </b>If mutable, get without recopy the array, otherwise recopy and
	 * get<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Unconsidered<br>
	 * <b>Length:</b> Considered<br>
	 * <br>
	 */
	int get(int index);

	/**
	 * Assign length, if given length > {@link #capacity()}, then capacity will be
	 * assigned as length<br>
	 * <b>Array: </b> Not effected (no allocation)<br>
	 * <b>Endian:</b> Not effected<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Effected<br>
	 * 
	 * @see #assign(Object, int, Endian)
	 */
	IntArray assign(int length);

	// =============

	/**
	 * Assign array, if this {@link #isImmutable()}, then new copy will be made
	 * internally(thread-safe), else this instance will wrap given array
	 * (thread-unsafe)<br>
	 * <br>
	 * <b>Array: </b> Effected, if given array is null, then allocate new array with
	 * {@link Lang#ARRAY_DEFAULT_CAPACITY} capacity<br>
	 * <b>Endian:</b> Not effected<br>
	 * <b>Capacity:</b> Effected<br>
	 * <b>Length:</b> Effected, given array capacity will be used as length, if
	 * given array is null, then length will be 0<br>
	 * 
	 * @see #assign(Object, int, Endian)
	 */
	IntArray assign(int[] arr);

	/**
	 * Assign array and length, if this {@link #isImmutable()}, then new copy will
	 * be made internally(thread-safe), else this instance will wrap given array
	 * (thread-unsafe)<br>
	 * <br>
	 * <b>Array: </b> Effected, if given array is null, then allocate new array with
	 * {@link Lang#ARRAY_DEFAULT_CAPACITY} capacity<br>
	 * <b>Endian:</b> Not effected<br>
	 * <b>Capacity:</b> Effected<br>
	 * <b>Length:</b> Effected, given array capacity will be used as length, if
	 * given array is null, then length will be 0<br>
	 * 
	 * @see #assign(Object, int, Endian)
	 */
	IntArray assign(int[] arr, int length);

	/**
	 * Assign array, length and read {@link Endian}, if this {@link #isImmutable()},
	 * then new copy will be made internally(thread-safe), else this instance will
	 * wrap given array (thread-unsafe)<br>
	 * <br>
	 * <b>Array: </b> Effected, if given array is null, then allocate new array with
	 * {@link Lang#ARRAY_DEFAULT_CAPACITY} capacity<br>
	 * <b>Endian:</b> Not effected<br>
	 * <b>Capacity:</b> Effected<br>
	 * <b>Length:</b> Effected, given array capacity will be used as length, if
	 * given array is null, then length will be 0<br>
	 * 
	 * @throws NullPointerException     if endian is null
	 * @throws IllegalArgumentException if len < 0 || len >= arr.length
	 */
	IntArray assign(int[] arr, int length, Endian read);

	IntArray assign(int[] arr, int length, Endian read, int flags);

	/**
	 * @return true if {@link #length()} == 0
	 */
	boolean isEmpty();

	/**
	 * Flip current read {@link Endian} only, e.g: [{10, 20, 30}, 40, 50] -> [10,
	 * 20, {30, 40, 50}]<br>
	 * <b>Array: </b> Not effected<br>
	 * <b>Endian:</b> Effected<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray flip();

	/**
	 * Assign {@link Endian#BIG} as read endian <b>Array: </b> Not effected<br>
	 * <b>Endian:</b> Effected<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray big();

	/**
	 * Assign {@link Endian#LITTLE} as read endian <b>Array: </b> Not effected<br>
	 * <b>Endian:</b> Effected<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray little();

	/**
	 * Assign {@link Endian#nativeOrder()} as read endian <b>Array: </b> Not
	 * effected<br>
	 * <b>Endian:</b> Effected<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray nativee();

	/**
	 * Curly brace for length [{1, 2, 3}, 0, 0]
	 * 
	 * @return current calculated length used for array
	 * @see #capacity()
	 */
	int length();

	/**
	 * Square brackets for capacity [{1, 2, 3}, 0, 0]
	 * 
	 * @return current capacity of used array, including extra slots
	 */
	int capacity();

	/**
	 * Swap value on left-index by value on right-index<br>
	 * <b>Array: </b>Effected<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray swap(int leftIndex, int rightIndex);

	// ======================

	/**
	 * @see #shuffle(int, int, Random)
	 */
	IntArray shuffle();

	/**
	 * @see #shuffle(int, int, Random)
	 */
	IntArray shuffle(int from);

	/**
	 * @see #shuffle(int, int, Random)
	 */
	IntArray shuffle(int from, int to);

	/**
	 * Shuffle array based on given range<br>
	 * <b>Array: </b>Effected<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray shuffle(int from, int to, Random r);

	// ======================

	/**
	 * @see #reverse(int, int)
	 */
	IntArray reverse();

	/**
	 * @see #reverse(int, int)
	 */
	IntArray reverse(int from);

	/**
	 * Reverse current array, e.g: [{10, 20, 30}, 0, 0] -> [{30, 20, 10}, 0, 0]<br>
	 * <b>Array: </b> Effected<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 * 
	 * @see #flip()
	 */
	IntArray reverse(int from, int to);

	// ======================

	/**
	 * @see #reverse(int, int)
	 */
	IntArray sort();

	/**
	 * @see #reverse(int, int)
	 */
	IntArray sort(int from);

	/**
	 * Sort current array, e.g: [{90, 40, 10}, 0, 0] -> [{10, 40, 90}, 0, 0]<br>
	 * <b>Array: </b> Effected<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 * 
	 * @see #flip()
	 */
	IntArray sort(int from, int to);

	// ======================

	/**
	 * Expend current length at given index by given size<br>
	 * <br>
	 * <b>Note: </b> will clear (set to 0) the new slots for demonstration purpose,
	 * in real Implementation, and if you need to clear, you've to invoke
	 * {@link #clear(int, int)} explicitly <br>
	 * <br>
	 * e.g: [{10, 20, 30}], index 1, size 2 -> [{10, 0, 0, 20, 30}]<br>
	 * e.g: [{10, 20, 30, 40, 50}], index 4, size 3 -> [{10, 20, 30, 40, 0, 0, 0,
	 * 50}]<br>
	 * <b>Array: </b> Effected<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Effected only if no enough slots exists<br>
	 * <b>Length:</b> Effected<br>
	 */
	IntArray expend(int index, int size);

	IntArray expendAndClear(int index, int size);

	/**
	 * Shrink current length at given index by given size<br>
	 * e.g: [{10, 20, 30, 40, 50}, 0, 0], index 2, size 3 -> [{10, 20}, 30, 40, 50,
	 * 0, 0]<br>
	 * <b>Array: </b> Effected<br>
	 * <b>Endian:</b> Unconsidered<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Effected<br>
	 */
	IntArray shrink(int index, int size);

	IntArray shrinkAndClear(int index, int size);

	IntArray displace(int displacement);

	IntArray displace(int displacement, int from);

	IntArray displace(int displacement, int from, int to);

	IntArray displaceAndClear(int displacement);

	IntArray displaceAndClear(int displacement, int from);

	IntArray displaceAndClear(int displacement, int from, int to);

	/**
	 * Skip MSB zeros/nulls based on current {@link #endian()} <br>
	 * e.g: {@link Endian#LITTLE}, [{10, 20, 30, 0, 0}], -> [{10, 20, 30}, 0, 0]<br>
	 * e.g: {@link Endian#BIG}, [{0, 0, 30, 20, 10}], -> [0, 0, {30, 20, 10}]<br>
	 * <b>Array: </b> Not effected<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Effected<br>
	 * 
	 * @see #clear(int, int)
	 */
	IntArray skip();

	// ======================
	/**
	 * Trim current array to length (remove extra slots)<br>
	 * <b>Array: </b> Not effected<br>
	 * <b>Endian:</b> Not effected<br>
	 * <b>Capacity:</b> Effected if extra slots exists<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray trim();

	/**
	 * @return current read {@link Endian}
	 */
	Endian endian();

	// ======================

	/**
	 * @see #copy(int, int, Endian)
	 */
	int[] copy();

	/**
	 * @see #copy(int, int, Endian)
	 */
	int[] copy(int from);

	/**
	 * @see #copy(int, int, Endian)
	 */
	int[] copy(int from, int to);

	/**
	 * @return copy of current array based given range, {@link #length()} and write
	 *         {@link Endian}
	 */
	int[] copy(int from, int to, Endian write);

	// ======================

	/**
	 * @see #clear(int, int)
	 */
	IntArray clear();

	/**
	 * @see #clear(int, int)
	 */
	IntArray clear(int from);

	/**
	 * Fill null/zero to given range<br>
	 * <b>Array: </b> Effected<br>
	 * <b>Endian:</b> Considered<br>
	 * <b>Capacity:</b> Not effected<br>
	 * <b>Length:</b> Not effected<br>
	 */
	IntArray clear(int from, int to);

	// ======================

	String toString(int from);

	String toString(int from, int to);

	String toString(int from, int to, Endian write);

	// ======================

	int compareTo(IntArray o);

	// =========================

	public static IntArray of() {
		return of(null);
	}

	public static IntArray of(int[] arr) {
		int len = arr == null ? 0 : arr.length;
		return of(arr, len);
	}

	public static IntArray of(int[] arr, int len) {
		return of(arr, len, Endian.LITTLE);
	}

	public static IntArray of(int[] arr, int len, Endian endian) {
		return new MutableIntArray(arr, len, endian, 0);
	}

	// =========================

	static int[] newDefaultIntArray() {
		return newIntArray(Lang.constant.ARRAY_DEFAULT_CAPACITY);
	}

	static int[] newDefaultIntArrayOrCopy(int[] arr, int len, Endian read) {
		if (arr == null || arr.length == 0) {
			return newDefaultIntArray();
		}		
		return len == 0 ? Lang.copy.of.e.this_(arr, arr.length, 0, arr.length, read) : Lang.copy.of.e.this_(arr, len, 0, len, read);		
	}

	static int[] newEmptyIntArray() {
		return newIntArray(0);
	}

	static int[] newIntArray(int len) {
		return new int[len];
	}

}
