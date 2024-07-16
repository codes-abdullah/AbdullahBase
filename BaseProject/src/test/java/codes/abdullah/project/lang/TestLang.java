package codes.abdullah.project.lang;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class TestLang {

	@Test
	public void testAs() {
		Collection<String> c = Lang.as.collection("a", "b", "c");
		assertEquals(3, c.size());
		assertEquals("[a, b, c]", c.toString());
		// ========
		Set<Integer> s = Lang.as.set(1, 2, 3);
		assertEquals(3, s.size());
		assertEquals("[1, 2, 3]", s.toString());
		// ========
		Queue<TimeUnit> q = Lang.as.queue(TimeUnit.DAYS, TimeUnit.HOURS);
		assertEquals(2, q.size());
		assertEquals("[DAYS, HOURS]", q.toString());
		// ========
		Map<String, Integer> m = Lang.as.map("k1", "k2").with(1, 2);
		assertEquals(2, m.size());
		assertEquals("{k1=1, k2=2}", m.toString());
	}

	@Test
	public void testCapacity() {
		int[] in = { 10, 20, 30, 40, 50 }, expected, result;
		int inlen = in.length;
		int max = Lang.constant.ARRAY_SAFE_CAPACITY;
		int required = 0;
		boolean restrict = true;
		Endian read = Endian.LITTLE;
		// ======================
		in = new int[] { 10, 20, 30, 40, 50 };
		inlen = in.length;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = true;
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		result = Lang.capacity.ensure(Arrays.copyOf(in, in.length), inlen, required, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 10, 20, 30, 40, 50, 0, 0, 0, 0, 0 };
		inlen = 5;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = true;
		expected = x(10, 20, 30, 40, 50, 0, 0, 0, 0, 0);
		result = Lang.capacity.ensure(Arrays.copyOf(in, in.length), inlen, required, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 10, 20, 30, 40, 50 };
		inlen = in.length;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = false;
		expected = x(10, 20, 30, 40, 50, 0, 0, 0, 0, 0, 0, 0);
		result = Lang.capacity.ensure(Arrays.copyOf(in, in.length), inlen, required, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 10, 20, 0, 0, 0 };
		inlen = 2;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 5;
		restrict = true;
		expected = x(10, 20, 0, 0, 0);
		result = Lang.capacity.ensure(Arrays.copyOf(in, in.length), inlen, required, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 10, 20, 0, 0, 0 };
		inlen = 2;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = false;
		expected = x(10, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		result = Lang.capacity.ensure(Arrays.copyOf(in, in.length), inlen, required, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		inlen = 5;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 10;
		restrict = false;
		expected = x(10, 20, 30, 40, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		result = Lang.capacity.ensure(Arrays.copyOf(in, in.length), inlen, required, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		// ====================== will exceed max
		// ======================
		in = new int[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		inlen = 5;
		{
			final int[] in0 = in;
			final int inlen0 = inlen, required0 = 10, max0 = 5;
			final Endian read0 = read;
			boolean restrict0 = restrict;
			assertThrows(IllegalArgumentException.class, () -> Lang.capacity.e.ensure(Arrays.copyOf(in0, inlen0),
					inlen0, required0, read0, restrict0, max0));
		}
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		// ======================
		read = Endian.BIG;
		// ======================
		in = new int[] { 50, 40, 30, 20, 10 };
		inlen = in.length;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = true;
		expected = x(0, 0, 0, 50, 40, 30, 20, 10);
		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 0, 0, 0, 0, 0, 50, 40, 30, 20, 10 };
		inlen = 5;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = true;
		expected = x(0, 0, 0, 0, 0, 50, 40, 30, 20, 10);
		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 50, 40, 30, 20, 10 };
		inlen = in.length;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = false;
		expected = x(0, 0, 0, 0, 0, 0, 0, 50, 40, 30, 20, 10);
		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 0, 0, 0, 20, 10 };
		inlen = 2;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 5;
		restrict = true;
		expected = x(0, 0, 0, 20, 10);
		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 0, 0, 0, 20, 10 };
		inlen = 2;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 8;
		restrict = false;
		expected = x(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 10);
		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		in = new int[] { 0, 0, 0, 50, 40, 30, 20, 10 };
		inlen = 5;
		max = Lang.constant.ARRAY_SAFE_CAPACITY;
		required = 10;
		restrict = false;
		expected = x(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 40, 30, 20, 10);
		result = Lang.capacity.e.ensure(Arrays.copyOf(in, in.length), inlen, required, read, restrict, max);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ======================
		// ====================== will exceed max
		// ======================
		in = new int[] { 0, 0, 0, 50, 40, 30, 20, 10 };
		inlen = 5;
		{
			final int[] in0 = in;
			final int inlen0 = inlen, required0 = 10, max0 = 5;
			final Endian read0 = read;
			boolean restrict0 = restrict;
			assertThrows(IllegalArgumentException.class, () -> Lang.capacity.e.ensure(Arrays.copyOf(in0, inlen0),
					inlen0, required0, read0, restrict0, max0));
		}

	}

	@Test
	public void testCompare() {
		// nothing important to test here
	}

	@Test
	public void testCopyLittleToLittle() {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, expected, result;
		int len = 10;
		int newLength = 5;
		int readFrom = 0;
		int readTo = 5;
		int writeAtIndex = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;
		// =============
		// =============
		// ============= little to little
		// ============= allocate length = 5
		// ============= write at 0
		// ============= expect: some exceptions
		// =============
		// =============
		readFrom = 0;
		readTo = 3;
		expected = x(10, 20, 30, 0, 0);
		result = Lang.copy.to.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom, readTo,
				writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.copy.to.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom, readTo,
				writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(60, 70, 80, 0, 0);
		result = Lang.copy.to.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom, readTo,
				writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(60, 70, 80, 90, 100);
		result = Lang.copy.to.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom, readTo,
				writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(90, 100, 0, 0, 0);
		result = Lang.copy.to.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom, readTo,
				writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// ==============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============

		// =============
		// =============
		// ============= little to little
		// ============= length = 5
		// ============= write at 2
		// ============= expect: some exceptions
		// =============
		// =============
		writeAtIndex = 2;
		readFrom = 0;
		readTo = 3;
		expected = x(0, 0, 10, 20, 30);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(10, 20, 30, 40, 50);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(0, 0, 60, 70, 80);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(60, 70, 80, 90, 100);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(0, 0, 90, 100, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = -1;
		readTo = -12;
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		// =============
		// ============= little to little
		// ============= length = 5
		// ============= write at 5
		// ============= expect: all exceptions
		// =============
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
	}

	@Test
	public void testCopyBigToBig() {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, expected, result;
		int len = 10;
		int newLength = 5;
		int readFrom = 0;
		int readTo = 5;
		int writeAtIndex = 0;
		Endian read = Endian.BIG;
		Endian write = Endian.BIG;
		// =============
		// =============
		// ============= big to big
		// ============= allocate length = 5
		// ============= write at 0
		// ============= expect: some exceptions
		// =============
		// =============
		readFrom = 0;
		readTo = 3;
		expected = x(0, 0, 80, 90, 100);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(60, 70, 80, 90, 100);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(0, 0, 30, 40, 50);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(0, 0, 0, 10, 20);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
		// =============
		// =============
		// ============= big to big
		// ============= length = 5
		// ============= write at 2
		// ============= expect: some exceptions
		// =============
		// =============
		writeAtIndex = 2;
		readFrom = 0;
		readTo = 3;
		expected = x(80, 90, 100, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(10, 20, 30, 40, 50);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(30, 40, 50, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(60, 70, 80, 90, 100);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(0, 10, 20, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
		// =============
		// =============
		// ============= big to big
		// ============= length = 5
		// ============= write at 5
		// ============= expect: all exceptions
		// =============
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
	}

	public void testCopyLittleToBig() {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, expected, result;
		int len = 10;
		int newLength = 5;
		int readFrom = 0;
		int readTo = 5;
		int writeAtIndex = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.BIG;
		// =============
		// =============
		// ============= little to big
		// ============= allocate length = 5
		// ============= write at 0
		// ============= expect: some exceptions
		// =============
		// =============
		readFrom = 0;
		readTo = 3;
		expected = x(0, 0, 10, 20, 30);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(0, 0, 60, 70, 80);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(60, 70, 80, 90, 100);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(0, 0, 0, 90, 100);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 0, readTo0 = 0, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 8, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 10, readTo0 = 12, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
		// =============
		// =============
		// ============= little to big
		// ============= length = 5
		// ============= write at 2
		// ============= expect: some exceptions
		// =============
		// =============
		writeAtIndex = 2;
		readFrom = 0;
		readTo = 3;
		expected = x(10, 20, 30, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(10, 20, 30, 40, 50);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(60, 70, 80, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(60, 70, 80, 90, 100);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(0, 90, 100, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 0, readTo0 = 0, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 8, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 10, readTo0 = 12, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
		// =============
		// =============
		// ============= little to big
		// ============= length = 5
		// ============= write at 5
		// ============= expect: all exceptions
		// =============
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 0, readTo0 = 0, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 8, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = 10, readTo0 = 12, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
	}

	@Test
	public void testCopyBigToLittle() {
		int[] arr = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 }, expected, result;
		int len = 10;
		int newLength = 5;
		int readFrom = 0;
		int readTo = 5;
		int writeAtIndex = 0;
		Endian read = Endian.BIG;
		Endian write = Endian.LITTLE;
		// =============
		// =============
		// ============= big to little
		// ============= allocate length = 5
		// ============= write at 0
		// ============= expect: some exceptions
		// =============
		// =============
		readFrom = 0;
		readTo = 3;
		expected = x(10, 20, 30, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(60, 70, 80, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(60, 70, 80, 90, 100);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(90, 100, 0, 0, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		writeAtIndex = 5;
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
		// =============
		// =============
		// ============= big to little
		// ============= length = 5
		// ============= write at 2
		// ============= expect: some exceptions
		// =============
		// =============
		arr = new int[] { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
		writeAtIndex = 2;
		readFrom = 0;
		readTo = 3;
		expected = x(0, 0, 10, 20, 30);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 0;
		readTo = 5;
		expected = x(10, 20, 30, 40, 50);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 5;
		readTo = 8;
		expected = x(0, 0, 60, 70, 80);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		readFrom = 5;
		readTo = 10;
		expected = x(60, 70, 80, 90, 100);
		assertTestCopyThrowsIndexOutOfBoundsException(arr, len, read, readFrom, readTo, newLength, writeAtIndex, write);
		// =============
		readFrom = 8;
		readTo = 10;
		expected = x(0, 0, 90, 100, 0);
		result = Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len, new int[newLength], newLength, readFrom,
				readTo, read, write, writeAtIndex);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
		// =============
		// =============
		// ============= big to little
		// ============= length = 5
		// ============= write at 5
		// ============= expect: all exceptions
		// =============
		// =============
		writeAtIndex = 5;
		{
			final int[] arr0 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, readFrom0 = -1, readTo0 = 15, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		{
			final int[] arr0 = null;
			final int len0 = len, readFrom0 = 0, readTo0 = 3, newLength0 = newLength, writeAtIndex0 = writeAtIndex;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(NullPointerException.class, () -> Lang.copy.to.e.that(arr0, len0, new int[newLength0],
					newLength0, readFrom0, readTo0, read0, write0, writeAtIndex0));
		}
		// ==============
	}

	@Test
	public void testEqual() {
		int[] a1 = { 10, 20, 30, 40, 50 };
		int[] a2 = { 10, 20, 30, 40, 50, 0, 0, 0 };
		int[] a3 = new int[] { 50, 40, 30, 20, 10 };
		int[] a4 = new int[] { 0, 0, 0, 50, 40, 30, 20, 10 };

		int len1 = 5;
		int len2 = 5;
		assertEquals(Arrays.equals(a1, a1), Lang.equal.test(a1, len1, a2, len2));
		assertEquals(Arrays.equals(a1, a1), Lang.equal.e.test(a1, len1, a2, len2, Endian.LITTLE));
		assertEquals(Arrays.equals(a3, a3), Lang.equal.e.test(a3, len1, a4, len2, Endian.BIG));

		assertEquals(Arrays.equals(a1, a1), Lang.equal.e.test(a2, len1, a4, len2, Endian.LITTLE, Endian.BIG));
		assertEquals(Arrays.equals(a1, a1), Lang.equal.e.test(a4, len1, a2, len2, Endian.BIG, Endian.LITTLE));

	}

	@Test
	public void testExpand() {
		int[] arr = { 10, 20, 30, 40, 50 }, result, expected;
		int len = 0;
		int index = 0;
		int size = 0;
		Endian read = Endian.LITTLE;
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, size = 3, extra slots = 5
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50, 0, 0, 0, 0, 0 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(0, 0, 0, 10, 20, 30, 40, 50, 0, 0);
		result = Lang.expand.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 1;
		size = 3;
		expected = x(10, 0, 0, 0, 20, 30, 40, 50, 0, 0);
		result = Lang.expand.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 3;
		expected = x(10, 20, 0, 0, 0, 30, 40, 50, 0, 0);
		result = Lang.expand.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 3;
		size = 3;
		expected = x(10, 20, 30, 0, 0, 0, 40, 50, 0, 0);
		result = Lang.expand.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 4;
		size = 3;
		expected = x(10, 20, 30, 40, 0, 0, 0, 50, 0, 0);
		result = Lang.expand.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 5;
		size = 3;
		expected = x(10, 20, 30, 40, 50, 0, 0, 0, 0, 0);
		result = Lang.expand.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 6, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 2, size0 = 300;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IllegalArgumentException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, size = 3, extra slots = 3
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(0, 0, 0, 10, 20, 30, 40, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		len = 5;
		index = 4;
		size = 3;
		expected = x(10, 20, 30, 40, 0, 0, 0, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		len = 5;
		index = 5;
		size = 3;
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 6, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 2, size0 = 300;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(IllegalArgumentException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0));
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big, size = 3, extra slots = 5
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 0, 0, 0, 0, 0, 10, 20, 30, 40, 50 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(0, 0, 10, 20, 30, 40, 50, 0, 0, 0);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 1;
		size = 3;
		expected = x(0, 0, 10, 20, 30, 40, 0, 0, 0, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 3;
		expected = x(0, 0, 10, 20, 30, 0, 0, 0, 40, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 3;
		size = 3;
		expected = x(0, 0, 10, 20, 0, 0, 0, 30, 40, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 4;
		size = 3;
		expected = x(0, 0, 10, 0, 0, 0, 20, 30, 40, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 5;
		size = 3;
		expected = x(0, 0, 0, 0, 0, 10, 20, 30, 40, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 6, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 2, size0 = 300;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, size = 3, extra slots = 3
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 0, 0, 0, 10, 20, 30, 40, 50 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		len = 5;
		index = 4;
		size = 3;
		expected = x(10, 0, 0, 0, 20, 30, 40, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		len = 5;
		index = 5;
		size = 3;
		expected = x(0, 0, 0, 10, 20, 30, 40, 50);
		result = Lang.expand.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = dontCheckAndFill(result, len, 0, index, index + size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		len = 5;
		index = 7;
		size = 3;
		// ==============
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 6, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 2, size0 = 300;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 6, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 10, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -100, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 2, size0 = 300;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr2, len0, index0, size0, read0));
		}
	}

	@Test
	public void testFill() {
		int[] arr = { 0, 0, 0, 0, 0 }, expected, result;
		int len = 5;
		int from = 0;
		int to = 0;
		Endian write = Endian.LITTLE;
		// =============
		from = 0;
		to = 3;
		arr = new int[] { 0, 0, 0, 0, 0 };
		expected = x(1, 1, 1, 0, 0);
		result = Lang.fill.e.in(arr, len, 1, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 2;
		to = 4;
		arr = new int[] { 0, 0, 0, 0, 0 };
		expected = x(0, 0, 1, 1, 0);
		result = Lang.fill.e.in(arr, len, 1, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 0;
		to = 5;
		arr = new int[] { 0, 0, 0, 0, 0 };
		expected = x(1, 1, 1, 1, 1);
		result = Lang.fill.e.in(arr, len, 1, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		// =============
		// ============= test by additional slots
		// =============
		// =============
		// =============
		// =============
		from = 0;
		to = 3;
		arr = new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1 };
		expected = x(1, 1, 1, 0, 0, -1, -1, -1, -1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 2;
		to = 4;
		arr = new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1 };
		expected = x(0, 0, 1, 1, 0, -1, -1, -1, -1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 0;
		to = 5;
		arr = new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1 };
		expected = x(1, 1, 1, 1, 1, -1, -1, -1, -1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// ============= test big
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		write = Endian.BIG;
		from = 0;
		to = 3;
		arr = new int[] { 0, 0, 0, 0, 0 };
		expected = x(0, 0, 1, 1, 1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 2;
		to = 4;
		arr = new int[] { 0, 0, 0, 0, 0 };
		expected = x(0, 1, 1, 0, 0);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 0;
		to = 5;
		arr = new int[] { 0, 0, 0, 0, 0 };
		expected = x(1, 1, 1, 1, 1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		// =============
		// ============= test big by additional slots
		// =============
		// =============
		// =============
		// =============
		from = 0;
		to = 3;
		arr = new int[] { 0, 0, 0, 0, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9 };
		expected = x(0, 0, 0, 0, 0, -1, -2, -3, -4, -5, -6, 1, 1, 1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 2;
		to = 4;
		arr = new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1 };
		expected = x(0, 0, 0, 0, 0, 1, 1, -1, -1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		from = 0;
		to = 5;
		arr = new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1 };
		expected = x(0, 0, 0, 0, 1, 1, 1, 1, 1);
		result = Lang.fill.e.in(arr, len, 1, from, to, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============

	}

	@Test
	public void testGeneric() {
		String[] arr = new String[] { "a", "b", "c" };
		String[] out = Lang.generic.newArray(arr);
		assertEquals(arr.length, out.length);

		out = Lang.generic.newArray(arr, 5);
		assertEquals(5, out.length);

		Map<Integer, String> m = new HashMap<>();
		m.put(10, "A");
		m.put(11, "B");
		m.put(12, "C");

		Set<Integer> mk = m.keySet();
		Collection<String> mv = m.values();

		Integer[] mkk = mk.toArray(new Integer[mk.size()]);
		String[] mvv = mv.toArray(new String[mv.size()]);

		assertArrayEquals(mkk, Lang.generic.keys.of(m));
		assertArrayEquals(mvv, Lang.generic.vals.of(m));

		// ================

		assertArrayEquals(mk.toArray(new Integer[mk.size()]), Lang.generic.toArray(mk));
	}

	@Test
	public void testHashCode() {
		int[] in = { 10, 20, 30, 40, 50 };
		int inlen = in.length;

		int expected = Arrays.hashCode(in);

		// ============ without extras

		assertEquals(expected, Lang.hashCode.of(in, inlen));
		assertEquals(expected, Lang.hashCode.e.of(in, inlen, Endian.LITTLE));
		assertEquals(expected, Lang.hashCode.e.of(new int[] { 50, 40, 30, 20, 10 }, inlen, Endian.BIG));

		// ============ with extras
		in = new int[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		inlen = 5;
		assertEquals(expected, Lang.hashCode.of(in, inlen));
		assertEquals(expected, Lang.hashCode.e.of(in, inlen, Endian.LITTLE));
		assertEquals(expected, Lang.hashCode.e.of(new int[] { 0, 0, 0, 50, 40, 30, 20, 10 }, inlen, Endian.BIG));

		// ============
	}

	@Test
	public void testIndex() {
		int[] in = { 10, 20, 30, 40, 50 };
		int inlen = in.length;
		int from = 0;
		int to = inlen;

		// ==============
		// ============== no extra slots
		// ==============

		assertEquals(0, Lang.index.of(in, inlen, 10, from, to));
		assertEquals(1, Lang.index.of(in, inlen, 20, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 100, from, to));
		assertEquals(4, Lang.index.of(in, inlen, 50, from, to));

		from = 2;
		assertEquals(-1, Lang.index.of(in, inlen, 10, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 20, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 100, from, to));
		assertEquals(4, Lang.index.of(in, inlen, 50, from, to));

		to = 4;
		assertEquals(-1, Lang.index.of(in, inlen, 10, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 20, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 100, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 50, from, to));

		// ==============
		// ============== with extra slots
		// ==============

		in = new int[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		inlen = 5;
		from = 0;
		to = inlen;
		assertEquals(0, Lang.index.of(in, inlen, 10, from, to));
		assertEquals(1, Lang.index.of(in, inlen, 20, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 100, from, to));
		assertEquals(4, Lang.index.of(in, inlen, 50, from, to));

		from = 2;
		assertEquals(-1, Lang.index.of(in, inlen, 10, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 20, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 100, from, to));
		assertEquals(4, Lang.index.of(in, inlen, 50, from, to));

		to = 4;
		assertEquals(-1, Lang.index.of(in, inlen, 10, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 20, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 100, from, to));
		assertEquals(-1, Lang.index.of(in, inlen, 50, from, to));

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		Endian read = Endian.LITTLE;
		in = new int[] { 10, 20, 30, 40, 50 };
		from = 0;
		to = inlen;
		assertEquals(0, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		from = 2;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		to = 4;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 50, from, to, read));

		// ==============
		// ============== with extra slots
		// ==============

		in = new int[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		inlen = 5;
		from = 0;
		to = inlen;
		assertEquals(0, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		from = 2;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		to = 4;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 50, from, to, read));

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		in = new int[] { 50, 40, 30, 20, 10 };
		from = 0;
		to = inlen;
		assertEquals(0, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		from = 2;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		to = 4;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 50, from, to, read));

		// ==============
		// ============== with extra slots
		// ==============

		in = new int[] { 0, 0, 0, 50, 40, 30, 20, 10 };
		inlen = 5;
		from = 0;
		to = inlen;
		assertEquals(0, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		from = 2;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(4, Lang.index.e.of(in, inlen, 50, from, to, read));

		to = 4;
		assertEquals(-1, Lang.index.e.of(in, inlen, 10, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 20, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 100, from, to, read));
		assertEquals(-1, Lang.index.e.of(in, inlen, 50, from, to, read));
	}

	@Test
	public void testLastIndex() {
		byte[] in = { 10, 20, 30, 40, 50 };
		int inlen = 0;
		int[] out, expected, result;
		int from = 0;
		int to = 0;
		Endian read, write;
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;

	}

	@Test
	public void testLength() {
		assertEquals(2, Lang.length.of(new boolean[] { true, false }));
		assertEquals(0, Lang.length.of(new boolean[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.booleans(), true));

		assertEquals(5, Lang.length.of(new byte[] { 1, 2, 3, 4, 5 }));
		assertEquals(0, Lang.length.of(new byte[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.bytes(), true));

		assertEquals(5, Lang.length.of(new short[] { 1, 2, 3, 4, 5 }));
		assertEquals(0, Lang.length.of(new short[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.shorts(), true));

		assertEquals(5, Lang.length.of(new char[] { 1, 2, 3, 4, 5 }));
		assertEquals(0, Lang.length.of(new char[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.chars(), true));

		assertEquals(5, Lang.length.of(new int[] { 1, 2, 3, 4, 5 }));
		assertEquals(0, Lang.length.of(new int[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.ints(), true));

		assertEquals(5, Lang.length.of(new long[] { 1, 2, 3, 4, 5 }));
		assertEquals(0, Lang.length.of(new long[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.longs(), true));

		assertEquals(5, Lang.length.of(new float[] { 1, 2, 3, 4, 5 }));
		assertEquals(0, Lang.length.of(new float[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.floats(), true));

		assertEquals(5, Lang.length.of(new double[] { 1, 2, 3, 4, 5 }));
		assertEquals(0, Lang.length.of(new double[] {}));
		assertEquals(0, Lang.length.of(Lang.nuller.doubles(), true));

	}

	@Test
	public void testToPrimitive() {
		byte[] in = { 10, 20, 30, 40, 50 };
		int inlen = 0;
		int[] out, expected, result;
		int from = 0;
		int to = 0;
		Endian read, write;
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little to little, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		in = new byte[] { 10, 20, 30, 40, 50 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(10, 20, 30);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(30, 40, 50);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little to little, extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		in = new byte[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(10, 20, 30);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(30, 40, 50);
		result = Lang.primitive.to.ints(Arrays.copyOf(in, in.length), inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little to big, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		write = Endian.BIG;
		in = new byte[] { 10, 20, 30, 40, 50 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(50, 40, 30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(50, 40, 30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little to big, extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		write = Endian.BIG;
		in = new byte[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(50, 40, 30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(50, 40, 30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big to little, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		write = Endian.LITTLE;
		in = new byte[] { 50, 40, 30, 20, 10 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(10, 20, 30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(30, 40, 50);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big to little, extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		write = Endian.LITTLE;
		in = new byte[] { 0, 0, 0, 50, 40, 30, 20, 10 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(10, 20, 30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(30, 40, 50);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big to big, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		write = Endian.BIG;
		in = new byte[] { 50, 40, 30, 20, 10 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(50, 40, 30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(50, 40, 30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big to big, extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		write = Endian.BIG;
		in = new byte[] { 0, 0, 0, 50, 40, 30, 20, 10 };
		inlen = 5;
		from = 0;
		to = inlen;
		expected = x(50, 40, 30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 20, 10);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 3;
		expected = x(30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = inlen;
		expected = x(50, 40, 30);
		result = Lang.primitive.to.e.ints(Arrays.copyOf(in, in.length), inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
	}

	@Test
	public void testReverse() {
		int[] arr = { 10, 20, 30, 40, 50 }, result, expected;
		int len = 0;
		int from = 0;
		int to = 0;
		Endian read = Endian.LITTLE;
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(50, 40, 30, 20, 10);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 20, 10, 40, 50);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(10, 40, 30, 20, 50);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 3;
		to = 5;
		expected = x(10, 20, 30, 50, 40);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 1, to0 = 300;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little with extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============

		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50, 0, 0, 0, 0 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(50, 40, 30, 20, 10, 0, 0, 0, 0);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 20, 10, 40, 50, 0, 0, 0, 0);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(10, 40, 30, 20, 50, 0, 0, 0, 0);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 3;
		to = 5;
		expected = x(10, 20, 30, 50, 40, 0, 0, 0, 0);
		result = Lang.reverse.in(Arrays.copyOf(arr, arr.length), len, from, to);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 1, to0 = 300;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============

		read = Endian.BIG;
		arr = new int[] { 50, 40, 30, 20, 10 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(10, 20, 30, 40, 50);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(50, 40, 10, 20, 30);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(50, 20, 30, 40, 10);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 3;
		to = 5;
		expected = x(40, 50, 30, 20, 10);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 1, to0 = 300;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big with extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============

		read = Endian.BIG;
		arr = new int[] { 0, 0, 0, 0, 50, 40, 30, 20, 10 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(0, 0, 0, 0, 10, 20, 30, 40, 50);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(0, 0, 0, 0, 50, 40, 10, 20, 30);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(0, 0, 0, 0, 50, 20, 30, 40, 10);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 3;
		to = 5;
		expected = x(0, 0, 0, 0, 40, 50, 30, 20, 10);
		result = Lang.reverse.e.in(Arrays.copyOf(arr, arr.length), len, from, to, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 1, to0 = 300;
			final Endian read0 = read;
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> Lang.reverse.e.in(arr2, len0, from0, to0, read0));
		}
	}

	@Test
	public void testShrink() {
		int[] arr = { 10, 20, 30, 40, 50 }, result, expected;
		int len = 0;
		int index = 0;
		int size = 0;
		Endian read = Endian.LITTLE;
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(40, 50, 0, 0, 0);// 40, 50, 0, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 0;
		size = 1;
		expected = x(20, 30, 40, 50, 0);// 20, 30, 40, 50, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 2;
		expected = x(10, 20, 50, 0, 0);// 10, 20, 50, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 1;
		size = 3;
		expected = x(10, 50, 0, 0, 0);// 10, 50, 0, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 3;
		expected = x(10, 20, 0, 0, 0);// 10, 20, 0, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 3, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 8, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 100;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.shrink.at(arr2, len0, index0, size0));
			assertThrows(IllegalArgumentException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.at(arr2, len0, index0, size0));
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}

		// ==============

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little with extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============

		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50, 0, 0, 0, 0 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(40, 50, 0, 0, 0, 0, 0, 0, 0);// 40, 50, 0, 0, 0, 0, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 0;
		size = 1;
		expected = x(20, 30, 40, 50, 0, 0, 0, 0, 0);// 20, 30, 40, 50, 0, 0, 0, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 2;
		expected = x(10, 20, 50, 0, 0, 0, 0, 0, 0);// 10, 20, 50, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 1;
		size = 3;
		expected = x(10, 50, 0, 0, 0, 0, 0, 0, 0);// 10, 50, 0, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 3;
		expected = x(10, 20, 0, 0, 0, 0, 0, 0, 0);// 10, 20, 0, 0, 0
		result = Lang.shrink.at(Arrays.copyOf(arr, arr.length), len, index, size);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 3, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 8, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 100;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(0, 0, 0, 10, 20);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 0;
		size = 1;
		expected = x(0, 10, 20, 30, 40);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 2;
		expected = x(0, 0, 10, 40, 50);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 1;
		size = 3;
		expected = x(0, 0, 0, 10, 50);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 3;
		expected = x(0, 0, 0, 40, 50);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 3, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 8, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 100;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big, with extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 0, 0, 0, 0, 10, 20, 30, 40, 50 };
		len = 5;
		index = 0;
		size = 3;
		expected = x(0, 0, 0, 0, 0, 0, 0, 10, 20);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 0;
		size = 1;
		expected = x(0, 0, 0, 0, 0, 10, 20, 30, 40);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 2;
		expected = x(0, 0, 0, 0, 0, 0, 10, 40, 50);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 1;
		size = 3;
		expected = x(0, 0, 0, 0, 0, 0, 0, 10, 50);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		index = 2;
		size = 3;
		expected = x(0, 0, 0, 0, 0, 0, 0, 40, 50);
		result = Lang.shrink.e.at(Arrays.copyOf(arr, arr.length), len, index, size, read);
		result = afterShrinkDontCheckAndFill(result, len, index, size, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 3, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 8, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = -1, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 100;
			final Endian read0 = read;
			assertThrows(IllegalArgumentException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = null;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = null;
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}
		{
			final int[] arr2 = {};
			final int len0 = len, index0 = 0, size0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.shrink.e.at(arr2, len0, index0, size0, read0));
		}

	}

	@Test
	public void testShuffle() {
		boolean neq = false;
		int maxloop = 10, x = 0;
		int[] a = { 10, 20, 30, 40, 50 }, b;
		String s1, s2;
		int len = a.length;
		int from = 0;
		int to = 5;
		Endian read = Endian.LITTLE;
		// =============
		// =============
		// =============
		// =============
		// ============= little
		// ============= no extra slots
		// =============
		// =============
		// =============
		// =============
		read = Endian.LITTLE;
		len = a.length;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		// =============
		// =============
		// =============
		// =============
		// ============= little
		// ============= extra slots
		// =============
		// =============
		// =============
		// =============
		a = new int[] { 10, 20, 30, 40, 50, -1, -2, -3, -4 };
		read = Endian.LITTLE;
		len = 5;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		// =============
		// =============
		// =============
		// ============= big
		// ============= no extra slots
		// =============
		// =============
		// =============
		// =============
		a = new int[] { 10, 20, 30, 40, 50 };
		read = Endian.BIG;
		len = 5;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		// =============
		// =============
		// =============
		// =============
		// ============= big
		// ============= extra slots
		// =============
		// =============
		// =============
		// =============
		a = new int[] { 10, 20, 30, 40, 50, -1, -2, -3, -4 };
		read = Endian.BIG;
		len = 5;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Lang.shuffle.e.in(Arrays.copyOf(a, a.length), len, from, to, read, Digits.RANDOM);
			s1 = Arrays.toString(a);
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a, b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =============

	}

	@Test
	public void testSkip() {
		int[] l = new int[] { 10, 20, 30, 40, 50 };
		int[] b = new int[] { 50, 40, 30, 20, 10 };

		int[] el = new int[] { 10, 20, 30, 40, 50 };
		int[] eb = new int[] { 50, 40, 30, 20, 10 };

		int inlen = l.length;
		int newlen = 0;

		// ================= without extras
		newlen = Lang.skip.of(l, inlen);
		assertArrayEquals(el, Lang.copy.of.this_(l, newlen));

		newlen = Lang.skip.e.of(l, inlen, Endian.LITTLE);
		assertArrayEquals(el, Lang.copy.of.e.this_(l, newlen, 0, newlen, Endian.LITTLE));

		newlen = Lang.skip.e.of(b, inlen, Endian.BIG);
		assertArrayEquals(eb, Lang.copy.of.e.this_(b, newlen, 0, newlen, Endian.BIG));

		// ================= with extras
		l = new int[] { 10, 20, 30, 40, 50, 0, 0, 0 };
		b = new int[] { 0, 0, 0, 50, 40, 30, 20, 10 };
		inlen = l.length;

		newlen = Lang.skip.of(l, inlen);
		assertArrayEquals(el, Lang.copy.of.this_(l, newlen));

		newlen = Lang.skip.e.of(l, inlen, Endian.LITTLE);
		assertArrayEquals(el, Lang.copy.of.e.this_(l, newlen, 0, newlen, Endian.LITTLE));

		newlen = Lang.skip.e.of(b, inlen, Endian.BIG);
		assertArrayEquals(eb, Lang.copy.of.e.this_(b, newlen, 0, newlen, Endian.BIG));

		// ================= line-feeds

		char[] larr = "codes\n\r".toCharArray();
		char[] barr = "\n\rcodes".toCharArray();
		char[] earr = "codes".toCharArray();
		inlen = larr.length;

		newlen = Lang.chararray.skip.linefeed(larr, inlen);
		assertArrayEquals(earr, Lang.copy.of.this_(larr, newlen));

		newlen = Lang.chararray.skip.e.linefeed(larr, inlen, Endian.LITTLE);
		assertArrayEquals(earr, Lang.copy.of.e.this_(larr, newlen, 0, newlen, Endian.LITTLE));

		newlen = Lang.chararray.skip.e.linefeed(barr, inlen, Endian.BIG);
		assertArrayEquals(earr, Lang.copy.of.e.this_(barr, newlen, 0, newlen, Endian.BIG));

		// ================= white-space
		larr = "codes \t	".toCharArray();
		inlen = larr.length;
		barr = " \t	codes".toCharArray();
		newlen = Lang.chararray.skip.whitespace(larr, inlen);
		assertArrayEquals(earr, Lang.copy.of.this_(larr, newlen));

		newlen = Lang.chararray.skip.e.whitespace(larr, inlen, Endian.LITTLE);
		assertArrayEquals(earr, Lang.copy.of.e.this_(larr, newlen, 0, newlen, Endian.LITTLE));

		newlen = Lang.chararray.skip.e.whitespace(barr, inlen, Endian.BIG);
		assertArrayEquals(earr, Lang.copy.of.e.this_(barr, newlen, 0, newlen, Endian.BIG));

	}

	@Test
	public void testSwap() {
		int[] arr = { 10, 20, 30, 40, 50 }, expected, result;
		int len = 5;
		// =============
		expected = new int[] { 20, 10, 30, 40, 50 };
		result = Lang.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 1);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = new int[] { 40, 20, 30, 10, 50 };
		result = Lang.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 3);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = new int[] { 50, 20, 30, 40, 10 };
		result = Lang.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 4);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		expected = new int[] { 10, 40, 30, 20, 50 };
		result = Lang.swap.with(Lang.copy.of.e.this_(arr, len), len, 1, 3);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = new int[] { 10, 20, 40, 30, 50 };
		result = Lang.swap.with(Lang.copy.of.e.this_(arr, len), len, 2, 3);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = new int[] { 10, 20, 30, 50, 40 };
		result = Lang.swap.with(Lang.copy.of.e.this_(arr, len), len, 3, 4);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
	}

	@Test
	public void testSwapWithSurrogates() {
		char[] arr = "codes.abdullah".toCharArray(), expected, result;
		int len = arr.length;
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// ============= UNSUPPORRTED
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		CodepointSupport sps = CodepointSupport.BMP;
		// =============
		expected = "ocdes.abdullah".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 1, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "eodcs.abdullah".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 3, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "hodes.abdullac".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 13, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		// =============
		// =============
		expected = "codas.ebdullah".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 3, 6, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "codeslabdu.lah".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 5, 10, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "codes.ahdullab".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 7, 13, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// ============= DEBUG
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		// =============
		arr = "codE3s.abdullA1h".toCharArray();
		len = arr.length;
		sps = CodepointSupport.DEBUG;
		// =============
		expected = "ocdE3s.abdullA1h".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 1, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "E3odcs.abdullA1h".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 3, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "3odEcs.abdullA1h".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 4, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "A1odE3s.abdullch".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 13, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "1odE3s.abdullAch".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 14, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "hodE3s.abdullA1c".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 0, 15, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		// =============
		// =============
		expected = "codus.abdE3llA1h".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 3, 10, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "codE3u.abdsllA1h".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 5, 10, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "codE3s.A1bdullah".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 7, 13, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "codE3s.1bdullAah".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 7, 14, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "codA1s.abdullE3h".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 3, 13, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		expected = "codE3s.abdullhA1".toCharArray();
		result = Lang.codepoint.swap.with(Lang.copy.of.e.this_(arr, len), len, 13, 15, sps);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =============
		// =============
		// =============
		// =============
		// =============
	}

	@Test
	public void testToString() {
		int[] arr = { 10, 20, 30, 40, 50 };
		String expected, result;
		int len = arr.length;
		int from = 0;
		int to = 5;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;
		// =============
		// =============
		// =============
		// =============
		// ============= little to little
		// ============= no extra slots
		// =============
		// =============
		// =============
		// =============
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		len = arr.length;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(10, 20, 30, 40, 50));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(10));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(20, 30, 40));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(30, 40, 50));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 4;
		to = 5;
		expected = Arrays.toString(x(50));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		// =============
		// =============
		// =============
		// ============= little to little
		// ============= extra slots
		// =============
		// =============
		// =============
		arr = new int[] { 10, 20, 30, 40, 50, -1, -2, -3, 4 };
		len = 5;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(10, 20, 30, 40, 50));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(10));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(20, 30, 40));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(30, 40, 50));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 4;
		to = 5;
		expected = Arrays.toString(x(50));
		result = Lang.toString.of(arr, len, from, to);
		assertEquals(expected, result);

		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.of(arr2, len0, from0, to0));
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.of(arr2, len0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============

		// =============
		// =============
		// =============
		// =============
		// ============= little to big
		// ============= no extra slots
		// =============
		// =============
		// =============
		// =============
		read = Endian.LITTLE;
		write = Endian.BIG;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(50, 40, 30, 20, 10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(40, 30, 20));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(50, 40, 30));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 4;
		to = 5;
		expected = Arrays.toString(x(50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		// =============
		// =============
		// =============
		// ============= little to big
		// ============= extra slots
		// =============
		// =============
		// =============
		arr = new int[] { 10, 20, 30, 40, 50, -1, -2, -3, 4 };
		len = 5;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(50, 40, 30, 20, 10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(40, 30, 20));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(50, 40, 30));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 4;
		to = 5;
		expected = Arrays.toString(x(50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		// =============
		// =============
		// =============
		// =============
		// ============= big to big
		// ============= no extra slots
		// =============
		// =============
		// =============
		// =============
		arr = new int[] { 10, 20, 30, 40, 50 };
		read = Endian.BIG;
		write = Endian.BIG;
		len = arr.length;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(10, 20, 30, 40, 50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(20, 30, 40));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(10, 20, 30));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 4;
		to = 5;
		expected = Arrays.toString(x(10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		// =============
		// =============
		// =============
		// ============= big to big
		// ============= extra slots
		// =============
		// =============
		// =============
		arr = new int[] { -1, -2, -3, 4, 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(10, 20, 30, 40, 50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(20, 30, 40));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(10, 20, 30));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 4;
		to = 5;
		expected = Arrays.toString(x(10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		// =============
		// =============
		// =============
		// =============
		// ============= big to little
		// ============= no extra slots
		// =============
		// =============
		// =============
		// =============
		read = Endian.BIG;
		write = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(50, 40, 30, 20, 10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(40, 30, 20));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(30, 20, 10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		// =============
		// =============
		// =============
		// ============= big to little
		// ============= extra slots
		// =============
		// =============
		// =============
		arr = new int[] { -1, -2, -3, 4, 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = Arrays.toString(x(50, 40, 30, 20, 10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 0;
		to = 1;
		expected = Arrays.toString(x(50));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 1;
		to = 4;
		expected = Arrays.toString(x(40, 30, 20));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 2;
		to = 5;
		expected = Arrays.toString(x(30, 20, 10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		from = 4;
		to = 5;
		expected = Arrays.toString(x(10));
		result = Lang.toString.e.of(arr, len, from, to, read, write);
		assertEquals(expected, result);
		// =============
		{
			final int[] arr2 = null;
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertEquals("null", Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 7;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 3, to0 = 10;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = -1, to0 = 3;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
		{
			final int[] arr2 = Lang.copy.of.e.this_(arr, len);
			final int len0 = len, from0 = 0, to0 = 0;
			final Endian read0 = read;
			final Endian write0 = write;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.toString.e.of(arr2, len0, from0, to0, read0, write0));
		}
		// ==============
	}

	@Test
	public void testTrim() {
		int[] l = new int[] { 10, 20, 30, 0, 0 };
		int[] b = new int[] { 0, 0, 30, 20, 10 };

		int[] el = new int[] { 10, 20, 30 };
		int[] eb = new int[] { 30, 20, 10 };

		int inlen = 3;

		// ================= without extras
		assertArrayEquals(el, Lang.trim.in(l, inlen));
		assertArrayEquals(el, Lang.trim.e.in(l, inlen, Endian.LITTLE));
		assertArrayEquals(eb, Lang.trim.e.in(b, inlen, Endian.BIG));

	}

	@Test
	public void testVarargs() {
		// nothing important to test here
	}

	@Test
	public void testWrapper() {
		// nothing important to test here
	}

	@Test
	public void testMarker() {
		final String src = "codes.abdullah";
		int srcLen = src.length();
		String expected = "";
		int expectedLen = expected.length();
		// ================
		char[] srcArr = newArray(src, srcLen + 5);
		char[] expectedArr = null;
		// =================
		char[] prefix = "[".toCharArray(), suffix = "]".toCharArray();
		int prefixLen = prefix.length;
		int suffixLen = suffix.length;
		// ==================
		int from = 0;
		int to = 0;
		CodepointSupport sps = CodepointSupport.DEBUG;
		// ====================
		char[] srcCopy = Arrays.copyOf(srcArr, srcArr.length);
		expected = "[c]odes.abdullah";
		expectedLen = expected.length();
		int remainNulls = srcArr.length - (srcLen + (prefixLen + suffixLen));
		expectedArr = newArray(expected, expectedLen + remainNulls);
		// =====================
		from = 0;
		to = 1;
		char[] resultArr = Lang.chararray.mark.in(srcCopy, srcLen, from, to, prefix, prefixLen, suffix, suffixLen, sps);
		int resultLen = Lang.chararray.mark.lengthOf.in(srcCopy, srcLen, from, to, prefix, prefixLen, suffix, suffixLen,
				sps);
		assertEquals(expectedLen, resultLen);
		assertArrayEquals(resultArr, expectedArr);
		// ====================

	}

	@Test
	public void testToBinary() {
		// nothing to test, has been tested in TestBinaryConvertBigToSmall and
		// TestBinaryConvertSmallToBig
	}

	@Test
	public void testCopy() {
		assertEquals("required impl", "");
	}

	@Test
	public void testEmptyOrNull() {
		assertEquals("required impl", "");
	}

	@Test
	public void testSub() {
		assertEquals("required impl", "");
//		Lang.sub.
	}

	@Test
	public void testConstant() {
		// nothing to test here
	}

	@Test
	public void testNuller() {
		assertEquals(null, Lang.nuller.ints());
	}

	@Test
	public void testChararray() {
//		assertEquals("required impl", "");
//		test TestLChararray instead		
	}

	@Test
	public void testCodepoint() {
		assertEquals("required impl", "");
	}

	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================
	// ======================

	private void assertTestToStringThrowsIndexOutOfBoundsException(int[] arr, int len, int from, int to, Endian read) {
		assertThrows(IndexOutOfBoundsException.class, () -> Lang.toString.e.of(arr, len, from, to, read));
	}

	private void assertTestFillThrowsIndexOutOfBoundsException(int[] arr, int len, int from, int to, int value) {
		assertThrows(IndexOutOfBoundsException.class, () -> Lang.fill.in(arr, len, from, to, value));
	}

	private void assertTestFillThrowsIndexOutOfBoundsException(int[] arr, int len, int from, int to, int value,
			Endian write) {
		assertThrows(IndexOutOfBoundsException.class, () -> Lang.fill.e.in(arr, len, from, to, value, write));
	}

	private void assertTestCopyThrowsIndexOutOfBoundsException(int[] arr, int len, Endian read, int readFrom,
			int readTo, int newLength, int writeAtIndex, Endian write) {
		assertThrows(IndexOutOfBoundsException.class, () -> Lang.copy.to.e.that(Arrays.copyOf(arr, arr.length), len,
				new int[newLength], newLength, readFrom, readTo, read, write, writeAtIndex));
	}

	private void assertTestExpendThrowsIndexOutOfBoundsException(int[] arr, int len, int index, int size, Endian read) {
		assertThrows(IndexOutOfBoundsException.class, () -> Lang.expand.e.at(arr, len, index, size, read));
	}

	private void assertTestThrows(Class<Throwable> cls, int[] arr, int len, int index, int size, Endian read) {
		assertThrows(cls, () -> Lang.shrink.e.at(arr, len, index, size, read));
	}

	private static int[] x(int... arr) {
		return Arrays.copyOf(arr, arr.length);
	}

	private static byte[] b(int... arr) {
		byte[] b = new byte[arr.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) arr[i];
		}
		return b;
	}

	private static char[] newArray(String s, int len) {
		char[] arr = s.toCharArray();
		char[] out = new char[len];
		for (int i = 0; i < arr.length; i++) {
			out[i] = arr[i];
		}
		return out;
	}

	private static int[] afterShrinkDontCheckAndFill(int[] arr, int len, int index, int size, Endian read) {
		final int from0 = index + size;
		final int to0 = (len - index) + index;
		final int disp = to0 - from0;

		final int cleanF0 = index + disp;
		final int cleanT0 = len;

		return dontCheckAndFill(arr, len, 0, cleanF0, cleanT0, read);
	}

	static int[] dontCheckAndFill(int[] arr, int len, int value, int from, int to, Endian write) {
		if (!Check.isValidRange(from, to, arr.length))
			return arr;
		for (; from < arr.length && from < to; from++)
			arr[write.index(from, len, arr.length)] = value;
		return arr;
	}

	/**
	 * @return true if {1, 2, 3} and {2, 1, 3}, and return false if {1, 2, 3} and
	 *         {1, 2, 3}
	 */
	private static boolean notEqualsButContainsSameElements(int[] a, int[] b, int len, Endian read) {
		if (Arrays.equals(a, b))
			return false;
		m: for (int i = 0; i < len; i++) {
			int r = a[read.index(i, len, a.length)];
			for (int j = 0; j < len; j++) {
				if (r == b[read.index(j, len, a.length)])
					continue m;
			}
			return false;
		}
		return true;
	}
}