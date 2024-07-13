package codes.abdullah.array.integer;

import java.util.Arrays;
import java.util.Random;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

public abstract class AbstractIntArray implements IntArray {
	private static final long serialVersionUID = 1811105028991728056L;

	protected abstract IntArray[] newArray(int length);

	@Override
	public boolean isFlagged(int flag) {
		return (flags() & flag) == flag;
	}

	@Override
	public IntArray flag(int flag) {
		return assign(toArray(), length(), endian(), flags() | flag);
	}

	@Override
	public IntArray unflag() {
		return assign(toArray(), length(), endian(), 0);
	}

	@Override
	public IntArray unflag(int flag) {
		final int flags = flags();
		return assign(toArray(), length(), endian(), flags & (flags ^ flag));
	}

	@Override
	public int get(int index) {
		int len = length();
		Check.index(index, len);
		int[] arr = toArray();
		return arr[endian().index(index, len, arr.length)];
	}

	// ====================

	@Override
	public IntArray newInstance() {
		return newInstance(IntArray.newIntArray(Lang.constant.ARRAY_DEFAULT_CAPACITY), Lang.constant.ARRAY_DEFAULT_CAPACITY, endian());
	}

	@Override
	public IntArray newInstance(int[] arr) {
		int len = arr == null ? 0 : arr.length;
		arr = arr == null ? IntArray.newDefaultIntArray() : arr; // implementer must take care of recopy
		return newInstance(arr, len, endian());
	}

	@Override
	public IntArray newInstance(int[] arr, int length) {
		length = Math.min(arr.length, length);
		return newInstance(arr, length, endian());
	}

	@Override
	public IntArray newInstance(int[] arr, int len, Endian read) {
		return newInstance(arr, len, read, 0);
	}

	@Override
	public IntArray assign(int length) {
		int[] arr = toArray();
		return assign(arr, Integer.min(arr.length, length), endian());
	}

	@Override
	public IntArray assign(int[] arr) {
		int len = arr == null ? 0 : arr.length;
		arr = arr == null ? IntArray.newDefaultIntArray() : arr; // implementer must take care of recopy
		return assign(arr, len, endian());
	}

	@Override
	public IntArray assign(int[] arr, int length) {
		return assign(arr, length, endian());
	}

	@Override
	public IntArray assign(int[] arr, int length, Endian read) {
		return assign(arr, length, read, flags());
	}

	@Override
	public boolean isEmpty() {
		return length() == 0;
	}

	@Override
	public IntArray flip() {
		return assign(toArray(), length(), endian().flip());
	}

	@Override
	public IntArray big() {
		return assign(toArray(), length(), Endian.BIG);
	}

	@Override
	public IntArray little() {
		return assign(toArray(), length(), Endian.LITTLE);
	}

	@Override
	public IntArray nativee() {
		return assign(toArray(), length(), Endian.nativeOrder());
	}

	@Override
	public IntArray swap(int leftIndex, int rightIndex) {
		int len = length();
		if (len == 0)
			return this;
		Check.index(leftIndex, len);
		Check.index(rightIndex, len);
		Endian read = endian();
		return assign(Lang.swap.with(toArray(), len, leftIndex, rightIndex), len, read);
	}

	@Override
	public IntArray shuffle() {
		return shuffle(0);
	}

	@Override
	public IntArray shuffle(int from) {
		return shuffle(from, length());
	}

	@Override
	public IntArray shuffle(int from, int to) {
		return shuffle(from, to, Digits.RANDOM);
	}

	@Override
	public IntArray shuffle(int from, int to, Random r) {
		int len = length();
		if (len <= 0)
			return this;
		to = to > len ? len : to;
		Check.range(from, to, len);
		Endian read = endian();
		return assign(Lang.shuffle.e.in(toArray(), len, from, to, read, r), len, read);
	}

	@Override
	public IntArray reverse() {
		return reverse(0);
	}

	@Override
	public IntArray reverse(int from) {
		return reverse(from, length());
	}

	@Override
	public IntArray reverse(int from, int to) {
		int len = length();
		if (len == 0)
			return this;
		to = to > len ? len : to;
		Check.range(from, to, len);
		Endian read = endian();
		return assign(Lang.reverse.e.in(toArray(), len, from, to, read), len, read);
	}

	@Override
	public IntArray sort() {
		return sort(0);
	}

	@Override
	public IntArray sort(int from) {
		return sort(from, length());
	}

	@Override
	public IntArray sort(int from, int to) {
		int len = length();
		if (len == 0)
			return this;
		to = to > len ? len : to;
		Check.range(from, to, len);
		Endian read = endian();
		int[] arr = toArray();
		Arrays.sort(arr, read.from(from, to, len, arr.length), read.to(from, to, len, arr.length));
		if (read.isBig())
			arr = Lang.reverse.e.in(arr, len, from, to, read);
		return assign(arr, len, read);
	}

	@Override
	public IntArray expend(int index, int size) {
		int len = length();
		if (len == 0)
			return this;
		index = index > len ? len : index;
		Check.index(index);
		int newlen = len + size;
		Endian read = endian();
		int[] arr = Lang.capacity.e.ensure(toArray(), len, newlen, read);
		// e.g: [10, 20, 30], index 3, size 3
		// no need to expend, ensureCapacity will ensure having extra slots
		if (index < len)
			arr = Lang.expand.e.at(arr, len, index, size, read);
		return assign(arr, newlen, read);
	}

	@Override
	public IntArray expendAndClear(int index, int size) {
		int len = length();
		if (len == 0)
			return this;
		index = index > len ? len : index;
		Check.index(index);
		int newlen = len + size;
		Endian read = endian();
		int[] arr = Lang.capacity.e.ensure(toArray(), len, newlen, read);
		int to = index + size;
		to = to > newlen ? newlen : to;
		if (index < len)
			arr = Lang.expand.e.at(arr, newlen, index, size, read);
		return assign(Lang.fill.e.in(arr, newlen, 0, index, to, read), newlen, read);
	}

	@Override
	public IntArray shrink(int index, int size) {
		int len = length();
		if (len == 0 || index >= len)
			return this;
		Check.index(index, len);
		// len - index to eliminate additional size
		// e.g: [{1, 2, 3}], len = 3, size = 3, index = 2
		// [{1, 2, 3} x, x], x's are eliminated from the count
		size = Math.min(size, len - index);
		int newlen = len - size;
		Endian read = endian();
		// e.g: [1, 2, 3, 4, 5], len = 5, index = 2, size = 3
		// effected: [1, 2, {3, 4, 5}]
		if (index + size == len) {
			return assign(toArray(), len - size, read);
		}
		int[] arr = Lang.shrink.e.at(toArray(), len, index, size, read);
		return assign(arr, newlen, read);
	}

	@Override
	public IntArray shrinkAndClear(int index, int size) {
		int len = length();
		if (len == 0 || index >= len)
			return this;
		Check.index(index, len);
		size = Math.min(size, len - index);
		Endian read = endian();
		if (index + size == len) {
			return assign(Lang.fill.e.in(toArray(), len, 0, len - size, len, read), len, read);
		}
		int[] arr = Lang.shrink.e.at(toArray(), len, index, size, read);
		int to = index + size;
		to = to > len ? len : to;
		return assign(Lang.fill.e.in(arr, len, 0, len - size, len, read), len, read);
	}

	@Override
	public IntArray displace(int displacement) {
		return displace(displacement, 0);
	}

	@Override
	public IntArray displace(int displacement, int from) {
		return displace(displacement, 0, length());
	}

	@Override
	public IntArray displace(int displacement, int from, int to) {
		int len = length();
		if (len == 0)
			return this;
		Check.range(from, to, len);
		Endian read = endian();
		int[] arr = Lang.displace.squash.e.in(toArray(), len, displacement, from, to, from, to, read);
		return assign(arr, len, read);
	}

	@Override
	public IntArray displaceAndClear(int displacement) {
		return displaceAndClear(displacement);
	}

	@Override
	public IntArray displaceAndClear(int displacement, int from) {
		return displaceAndClear(displacement, from);
	}

	@Override
	public IntArray displaceAndClear(int displacement, int from, int to) {
		int len = length();
		if (len == 0)
			return this;
		Check.range(from, to, len);
		Endian read = endian();
		int[] arr = Lang.displace.squash.e.in(toArray(), len, displacement, from, to, from, to, read);
		final boolean negative = displacement < 0;
		displacement = Math.abs(displacement);
		int fillfrom = from;
		int fillto = fillfrom + displacement;
		if (negative) {
			fillfrom = from + ((to - from) - displacement);
			fillto = fillfrom + displacement;
		}
		return assign(Lang.fill.e.in(arr, len, 0, fillfrom, fillto, read), len, read);
	}

	@Override
	public IntArray skip() {
		int len = length();
		if (len == 0)
			return this;
		int[] arr = toArray();
		Endian read = endian();
		return assign(arr, Lang.skip.e.of(arr, len, read), read);
	}

	@Override
	public IntArray trim() {
		int len = length();
		if (len == 0)
			return assign(IntArray.newEmptyIntArray(), 0, endian());
		Endian read = endian();
		return assign(Lang.trim.e.in(toArray(), len, read), len, read);
	}

	@Override
	public int[] copy() {
		return copy(0);
	}

	@Override
	public int[] copy(int from) {
		return copy(from, length());
	}

	@Override
	public int[] copy(int from, int to) {
		return copy(from, to, endian());
	}

	@Override
	public int[] copy(int from, int to, Endian write) {
		int len = length();
		if (len == 0)
			return IntArray.newEmptyIntArray();
		to = to > len ? len : to;
		Check.range(from, to, len);
		int outlen = to - from;
		return Lang.copy.to.e.that(toArray(), len, new int[outlen], outlen, from, to, endian(), write);
	}

	@Override
	public IntArray clear() {
		return clear(0);
	}

	@Override
	public IntArray clear(int from) {
		return clear(from, length());
	}

	@Override
	public IntArray clear(int from, int to) {
		int len = length();
		to = to > len ? len : to;
		Check.range(from, to, len);
		int[] arr = toArray();
		Endian read = endian();
		return assign(Lang.fill.e.in(arr, len, 0, from, to, read), len, read);
	}

	@Override
	public int compareTo(IntArray o) {
		return Lang.compare.e.test(toArray(), length(), o.toArray(), o.length(), endian(), o.endian());
	}

	@Override
	public int hashCode() {
		return Lang.hashCode.e.of(toArray(), length(), endian());
	}

	@Override
	public String toString() {
		return toString(0);
	}

	@Override
	public String toString(int from) {
		return toString(from, length());
	}

	@Override
	public String toString(int from, int to) {
		return toString(from, to, endian());
	}

	@Override
	public String toString(int from, int to, Endian write) {
		int len = length();
		if (len == 0)
			return "[]";
		to = to > len ? len : to;
		Check.range(from, to, len);
		return Lang.toString.e.of(toArray(), length(), from, to, write);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof IntArray) {
			IntArray o = (IntArray) obj;
			return Lang.equal.e.test(toArray(), length(), o.toArray(), o.length(), endian(), o.endian());
		}
		return false;
	}

	// =========================

}
