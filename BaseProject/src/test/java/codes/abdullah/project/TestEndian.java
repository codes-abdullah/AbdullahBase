package codes.abdullah.project;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;

import org.junit.Test;

public class TestEndian {

	@Test
	public void testInsertIndex() {
		int[] arr = new int[] { 10, 20, 30, 40, 50 };
		int len = arr.length, index, insertLength;
		Endian read = Endian.LITTLE;
		// ==============
		// ==============
		// ============== little, no extra slots
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		insertLength = 3;
		assertEquals(0, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(2, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(4, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(10, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-1, read.insertIndex(-1, len, arr.length, insertLength));
		// ==============
		insertLength = 5;
		assertEquals(0, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(2, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(4, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(10, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-1, read.insertIndex(-1, len, arr.length, insertLength));
		// ==============
		insertLength = 100;
		assertEquals(0, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(2, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(4, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(10, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-1, read.insertIndex(-1, len, arr.length, insertLength));
		// ==============
		// ==============
		// ==============
		// ============== little, extra slots
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50, 0, 0, 0, 0 };
		len = 5;
		insertLength = 3;
		assertEquals(0, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(2, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(4, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(10, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-1, read.insertIndex(-1, len, arr.length, insertLength));
		// ==============
		insertLength = 5;
		assertEquals(0, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(2, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(4, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(10, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-1, read.insertIndex(-1, len, arr.length, insertLength));
		// ==============
		insertLength = 100;
		assertEquals(0, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(2, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(4, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(10, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-1, read.insertIndex(-1, len, arr.length, insertLength));

		// ==============
		// ==============
		// ============== big, no extra slots
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		insertLength = 3;
		assertEquals(2, read.insertIndex(0, len, arr.length, insertLength)); // [10, 20, x, x, x]
		assertEquals(0, read.insertIndex(2, len, arr.length, insertLength));// [x, x, x, 40, 50]
		assertEquals(-2, read.insertIndex(4, len, arr.length, insertLength));// x, x, [x, 20, 30, 40, 50]
		assertEquals(-8, read.insertIndex(10, len, arr.length, insertLength));// x, x, x, ?, ?, ?, ?, ? [10, 20, 30, 40, 50]
		assertEquals(3, read.insertIndex(-1, len, arr.length, insertLength));// [10, 20, 30, x, x] x
		// ==============
		insertLength = 5;
		assertEquals(0, read.insertIndex(0, len, arr.length, insertLength));// x, x, [x, x, x, 40, 50]
		assertEquals(-2, read.insertIndex(2, len, arr.length, insertLength)); //
		assertEquals(-4, read.insertIndex(4, len, arr.length, insertLength));//x, x, x, x, [x, 20, 30, 40, 50]
		assertEquals(-10, read.insertIndex(10, len, arr.length, insertLength));//x, x, x, x, x, ?, ?, ?, ?, ? [10, 20, 30, 40, 50]
		assertEquals(1, read.insertIndex(-1, len, arr.length, insertLength));//[x, x, x, x, x]
		// ==============
		insertLength = 100;
		assertEquals(-95, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(-97, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(-99, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(-105, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-94, read.insertIndex(-1, len, arr.length, insertLength));
		// ==============
		// ==============
		// ==============
		// ============== little, extra slots
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 0, 0, 0, 0, 10, 20, 30, 40, 50};
		len = 5;
		insertLength = 3;
		assertEquals(6, read.insertIndex(0, len, arr.length, insertLength)); // [0, 0, 0, 0, 10, 20, x, x, x]
		assertEquals(4, read.insertIndex(2, len, arr.length, insertLength));// [0, 0, 0, 0, x, x, x, 40, 50]
		assertEquals(2, read.insertIndex(4, len, arr.length, insertLength));// [0, x, x, x, 20, 30, 40, 50]
		assertEquals(-4, read.insertIndex(10, len, arr.length, insertLength));// x, x, x, ?, [0, 0, 0, 0, 10, 20, 30, 40, 50]
		assertEquals(7, read.insertIndex(-1, len, arr.length, insertLength));// [0, 0, 0, 0, 10, 20, 30, x, x], x
		// ==============
		insertLength = 5;
		assertEquals(4, read.insertIndex(0, len, arr.length, insertLength));// [0, 0, 0, 0, x, x, x, x, x]
		assertEquals(2, read.insertIndex(2, len, arr.length, insertLength)); // [0, 0, x, x, x, x, x, 40, 50]
		assertEquals(0, read.insertIndex(4, len, arr.length, insertLength));//  [x, x, x, x, x, 20, 30, 40, 50]
		assertEquals(-6, read.insertIndex(10, len, arr.length, insertLength));//x, x, x, x, x, ?, [0, 0, 0, 0, 10, 20, 30, 40, 50]
		assertEquals(5, read.insertIndex(-1, len, arr.length, insertLength));//[0, 0, 0, 0, 10, x, x, x, x] x
		// ==============
		insertLength = 100;
		assertEquals(-91, read.insertIndex(0, len, arr.length, insertLength));
		assertEquals(-93, read.insertIndex(2, len, arr.length, insertLength));
		assertEquals(-95, read.insertIndex(4, len, arr.length, insertLength));
		assertEquals(-101, read.insertIndex(10, len, arr.length, insertLength));
		assertEquals(-90, read.insertIndex(-1, len, arr.length, insertLength));
	}

	@Test
	public void testIndex() {
		int[] arr = new int[] { 10, 20, 30, 40, 50 };
		int len = arr.length;
		Endian read = Endian.LITTLE;
		// ==============
		// ==============
		// ============== little, no extra slots
		// ==============
		// ==============
		// ==============
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		assertEquals(0, read.index(0, len, arr.length));
		assertEquals(10, arr[read.index(0, len, arr.length)]);
		// ==============
		assertEquals(2, read.index(2, len, arr.length));
		assertEquals(30, arr[read.index(2, len, arr.length)]);
		// ==============
		assertEquals(4, read.index(4, len, arr.length));
		assertEquals(50, arr[read.index(4, len, arr.length)]);
		// ==============
		assertEquals(5, read.index(5, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, 5, read);
		// ==============
		assertEquals(10, read.index(10, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, 10, read);
		// ==============
		assertEquals(-1, read.index(-1, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, -1, read);
		// ==============
		// ==============
		// ============== little, extra slots
		// ==============
		// ==============
		arr = new int[] { 10, 20, 30, 40, 50, 0, 0, 0, 0 };
		len = 5;
		assertEquals(0, read.index(0, len, arr.length));
		assertEquals(10, arr[read.index(0, len, arr.length)]);
		// ==============
		assertEquals(2, read.index(2, len, arr.length));
		assertEquals(30, arr[read.index(2, len, arr.length)]);
		// ==============
		assertEquals(4, read.index(4, len, arr.length));
		assertEquals(50, arr[read.index(4, len, arr.length)]);
		// ==============
		assertEquals(5, read.index(5, len, arr.length));
		// index(..) method does not care about range checking, so
		// this will not throw any exception since we're not out of bound
		assertEquals(0, arr[read.index(5, len, arr.length)]);
		// ==============
		assertEquals(10, read.index(10, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, 10, read);
		// ==============
		assertEquals(-1, read.index(-1, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, -1, read);
		// ==============
		// ==============
		// ==============
		// ============== big, no extra slots
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		assertEquals(4, read.index(0, len, arr.length));
		assertEquals(50, arr[read.index(0, len, arr.length)]);
		// ==============
		assertEquals(2, read.index(2, len, arr.length));
		assertEquals(30, arr[read.index(2, len, arr.length)]);
		// ==============
		assertEquals(0, read.index(4, len, arr.length));
		assertEquals(10, arr[read.index(4, len, arr.length)]);
		// ==============
		assertEquals(-1, read.index(5, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, 5, read);
		// ==============
		assertEquals(-6, read.index(10, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, 10, read);
		// ==============
		assertEquals(5, read.index(-1, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, -1, read);
		// ==============
		// ==============
		// ============== big, extra slots
		// ==============
		// ==============
		arr = new int[] { 0, 0, 0, 0, 10, 20, 30, 40, 50 };
		len = 5;
		assertEquals(8, read.index(0, len, arr.length));
		assertEquals(50, arr[read.index(0, len, arr.length)]);
		// ==============
		assertEquals(6, read.index(2, len, arr.length));
		assertEquals(30, arr[read.index(2, len, arr.length)]);
		// ==============
		assertEquals(4, read.index(4, len, arr.length));
		assertEquals(10, arr[read.index(4, len, arr.length)]);
		// ==============
		// index(..) method does not care about range checking, so
		// this will not throw any exception since we're not out of bound
		assertEquals(3, read.index(5, len, arr.length));
		assertEquals(0, arr[read.index(5, len, arr.length)]);
		// ==============
		assertEquals(-2, read.index(10, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, 10, read);
		// ==============
		assertEquals(9, read.index(-1, len, arr.length));
		assertTestIndexThrowsIndexOutOfBoundsException(arr, len, -1, read);
	}

	@Test
	public void testRange() {
		int[] arr = new int[] { 10, 20, 30, 40, 50 }, expected, result;
		int len = arr.length, from = 0, to = 0;
		Endian read = Endian.LITTLE;
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(10, 20, 30, 40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(10, 20, 30);
		result = copy(arr, len, from, to, read);
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(3, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(20, 30, 40);
		result = copy(arr, len, from, to, read);
		assertEquals(1, read.from(from, to, len, arr.length));
		assertEquals(4, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 3;
		to = 5;
		expected = x(40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(3, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 6;
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(6, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 4;
		to = 10;
		assertEquals(4, read.from(from, to, len, arr.length));
		assertEquals(10, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 0;
		to = -1;
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(-1, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = -2;
		to = -1;
		assertEquals(-2, read.from(from, to, len, arr.length));
		assertEquals(-1, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== little, extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.LITTLE;
		arr = new int[] { 10, 20, 30, 40, 50, 0, 0, 0, 0 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(10, 20, 30, 40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(10, 20, 30);
		result = copy(arr, len, from, to, read);
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(3, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(20, 30, 40);
		result = copy(arr, len, from, to, read);
		assertEquals(1, read.from(from, to, len, arr.length));
		assertEquals(4, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 3;
		to = 5;
		expected = x(40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(3, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 6;
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(6, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 4;
		to = 10;
		assertEquals(4, read.from(from, to, len, arr.length));
		assertEquals(10, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 0;
		to = -1;
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(-1, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = -2;
		to = -1;
		assertEquals(-2, read.from(from, to, len, arr.length));
		assertEquals(-1, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(10, 20, 30, 40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(2, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(20, 30, 40);
		result = copy(arr, len, from, to, read);
		assertEquals(1, read.from(from, to, len, arr.length));
		assertEquals(4, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 2;
		expected = x(40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(3, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 6;
		assertEquals(-1, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 4;
		to = 10;
		assertEquals(-5, read.from(from, to, len, arr.length));
		assertEquals(1, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 0;
		to = -1;
		assertEquals(6, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = -2;
		to = -1;
		assertEquals(6, read.from(from, to, len, arr.length));
		assertEquals(7, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== big, extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		read = Endian.BIG;
		arr = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		expected = x(10, 20, 30, 40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(0, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 3;
		expected = x(30, 40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(2, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 1;
		to = 4;
		expected = x(20, 30, 40);
		result = copy(arr, len, from, to, read);
		assertEquals(1, read.from(from, to, len, arr.length));
		assertEquals(4, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 2;
		expected = x(40, 50);
		result = copy(arr, len, from, to, read);
		assertEquals(3, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 6;
		assertEquals(-1, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 4;
		to = 10;
		assertEquals(-5, read.from(from, to, len, arr.length));
		assertEquals(1, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = 0;
		to = -1;
		assertEquals(6, read.from(from, to, len, arr.length));
		assertEquals(5, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
		// ==============
		from = -2;
		to = -1;
		assertEquals(6, read.from(from, to, len, arr.length));
		assertEquals(7, read.to(from, to, len, arr.length));
		assertTestRangeThrowsIndexOutOfBoundsException(arr, len, from, to, read);
	}

	private static int[] copy(final int[] arr, final int len, final int from, int to, Endian read) {
		int f = read.from(from, to, len, arr.length);
		int t = read.to(from, to, len, arr.length);
		Check.range(f, t, len);
		return Arrays.copyOfRange(arr, f, t);
	}

	private void assertTestRangeThrowsIndexOutOfBoundsException(final int[] arr, final int len, final int from,
			final int to, final Endian read) {
		assertThrows(IndexOutOfBoundsException.class, () -> copy(arr, len, from, to, read));
	}

	private void assertTestIndexThrowsIndexOutOfBoundsException(final int[] arr, final int len, final int index,
			final Endian read) {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			final int a = arr[read.index(index, len, arr.length)];
		});
	}

	private static int[] x(int... arr) {
		return Arrays.copyOf(arr, arr.length);
	}

}
