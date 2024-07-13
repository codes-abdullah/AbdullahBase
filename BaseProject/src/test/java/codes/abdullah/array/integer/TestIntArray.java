
package codes.abdullah.array.integer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import codes.abdullah.project.Endian;

public class TestIntArray {
	private static final boolean mutable = true;

	@Test
	public void testSort() {
		int[] expected = null;
		IntArray a = newInstance();
		// ======
		a = a.assign(x(40, 20, 50, 10, 30)).sort();
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		a = a.assign(x(40, 20, 50, 10, 30)).sort(0, 3);
		expected = x(20, 40, 50, 10, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		a = a.assign(x(40, 20, 50, 10, 30)).sort(1, 4);
		expected = x(40, 10, 20, 50, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		a = a.assign(x(40, 20, 50, 10, 30)).sort(2, 5);
		expected = x(40, 20, 10, 30, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		assertTestSortThrowsIndexOutOfBoundsException(a, -1, 4);
		assertTestSortThrowsIndexOutOfBoundsException(a, 2, 0);
		// ======
		// ======
		// ======
		// ======
		// ====== extra slots
		// ======
		// ======
		// ======
		// ======
		int len = 5;
		a = a.assign(x(40, 20, 50, 10, 30, 0, 0, 0), len).sort();
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		a = a.assign(x(40, 20, 50, 10, 30, 0, 0, 0), len).sort(0, 3);
		expected = x(20, 40, 50, 10, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		a = a.assign(x(40, 20, 50, 10, 30, 0, 0, 0), len).sort(1, 4);
		expected = x(40, 10, 20, 50, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		a = a.assign(x(40, 20, 50, 10, 30, 0, 0, 0), len).sort(2, 5);
		expected = x(40, 20, 10, 30, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		assertTestSortThrowsIndexOutOfBoundsException(a, -1, 4);
		assertTestSortThrowsIndexOutOfBoundsException(a, 2, 0);
		// ======

		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======

		// ======
		a = a.big().assign(x(40, 20, 50, 10, 30)).sort();
		expected = x(50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		a = a.big().assign(x(40, 20, 50, 10, 30)).sort(0, 3);
		expected = x(40, 20, 50, 30, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		a = a.big().assign(x(40, 20, 50, 10, 30)).sort(1, 4);
		expected = x(40, 50, 20, 10, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		a = a.big().assign(x(40, 20, 50, 10, 30)).sort(2, 5);
		expected = x(50, 40, 20, 10, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		assertTestSortThrowsIndexOutOfBoundsException(a, -1, 4);
		assertTestSortThrowsIndexOutOfBoundsException(a, 2, 0);
		// ======
		// ======
		// ======
		// ======
		// ====== extra slots
		// ======
		// ======
		// ======
		// ======
		len = 5;
		a = a.big().assign(x(0, 0, 0, 40, 20, 50, 10, 30), len).sort();
		expected = x(50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		a = a.big().assign(x(0, 0, 0, 40, 20, 50, 10, 30), len).sort(0, 3);
		expected = x(40, 20, 50, 30, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		a = a.big().assign(x(0, 0, 0, 40, 20, 50, 10, 30), len).sort(1, 4);
		expected = x(40, 50, 20, 10, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		a = a.big().assign(x(0, 0, 0, 40, 20, 50, 10, 30), len).sort(2, 5);
		expected = x(50, 40, 20, 10, 30);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		assertTestSortThrowsIndexOutOfBoundsException(a, -1, 4);
		assertTestSortThrowsIndexOutOfBoundsException(a, 2, 0);
	}

	@Test
	public void testAssign() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== initial little by default
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10, 20, 30, 40, 50}
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10, 20, 30} by length
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(10, 20, 30);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10} by length
		a = a.assign(x(10, 20, 30, 40, 50), 1);
		expected = x(10);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10, 20} by length
		a = a.assign(x(10, 20, 30, 40, 50));
		a = a.assign(2);
		expected = x(10, 20);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign empty by null
		a = a.assign(null, 100);
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {40, 50} by big endian
		a = a.assign(x(10, 20, 30, 40, 50), 2);
		a = a.big();
		expected = x(40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== initial big
		a = newInstance().big();
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {10, 20, 30, 40, 50}
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {30, 40, 50} by length
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {50} by length
		a = a.assign(x(10, 20, 30, 40, 50), 1);
		expected = x(50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {40, 50} by length
		a = a.assign(x(10, 20, 30, 40, 50));
		a = a.assign(2);
		expected = x(40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign empty by null
		a = a.assign(null, 100);
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {10, 20} by little endian
		a = a.assign(x(10, 20, 30, 40, 50), 2).little();
		expected = x(10, 20);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
	}

	@Test
	public void testFlip() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== flip little to big - all
		a = a.little().flip().assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== flip little to big - length 3
		a = a.little().flip().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== flip little to big - length 1
		a = a.little().flip().assign(x(10, 20, 30, 40, 50), 1);
		expected = x(50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== flip big to little - all
		a = a.big().flip().assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== flip big to little - length 3
		a = a.big().flip().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(10, 20, 30);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== flip big to little - length 1
		a = a.big().flip().assign(x(10, 20, 30, 40, 50), 1);
		expected = x(10);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());

	}

	@Test
	public void testShuffle() {
		IntArray a = newInstance();
		final int maxloop = 10;
		int len = 0;
		int from = 0;
		int to = 0;
		int x = 0;
		Endian read = Endian.LITTLE;
		boolean neq = false;
		String s1 = null, s2 = null;
		int[] src = new int[] { 10, 20, 30, 40, 50 }, b;
		// ======
		len = 5;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		src = new int[] { 10, 20, 30, 40, 50, -1, -2, -3, -4 };
		len = 5;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.little().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== big
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		src = new int[] { 10, 20, 30, 40, 50 };
		len = 5;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOf(src, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		// =====
		src = new int[] { 10, 20, 30, 40, 50, -1, -2, -3, -4 };
		len = 5;
		from = 0;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOfRange(src, len - 1, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 0;
		to = 3;
		x = 0;
		do {
			b = Arrays.copyOfRange(src, len - 1, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 1;
		to = 4;
		x = 0;
		do {
			b = Arrays.copyOfRange(src, len - 1, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====
		from = 3;
		to = 5;
		x = 0;
		do {
			b = Arrays.copyOfRange(src, len - 1, src.length);
			a = a.big().assign(Arrays.copyOf(src, src.length), len).shuffle(from, to);
			s1 = a.toString();
			s2 = Arrays.toString(b);
			neq = notEqualsButContainsSameElements(a.copy(), b, len, read);
		} while (x++ < maxloop && !neq);
		assertTrue(s1 + " == " + s2, neq);
		// =====

	}

	@Test
	public void testSwap() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== swap 0, 4
		a = a.assign(new int[] { 10, 20, 30, 40, 50 }).swap(0, 4);
		expected = x(50, 20, 30, 40, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== swap 4, 0
		a = a.assign(new int[] { 10, 20, 30, 40, 50 }).swap(4, 0);
		expected = x(50, 20, 30, 40, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== swap 1, 2
		a = a.assign(new int[] { 10, 20, 30, 40, 50 }).swap(1, 2);
		expected = x(10, 30, 20, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== swap 0, 10
		final IntArray b = a;
		assertThrows(IndexOutOfBoundsException.class, () -> b.swap(0, 10));
		// ====== swap -5, 1
		assertThrows(IndexOutOfBoundsException.class, () -> b.swap(-5, 1));
	}

	@Test
	public void testCopy() {
		int[] expected = null, result = null;
		IntArray a = newInstance();
		// ====== copy little - all
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		result = a.copy();
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(10, 20, 30);
		result = a.copy();
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by length 1
		a = a.assign(x(10, 20, 30, 40, 50), 1);
		expected = x(10);
		result = a.copy();
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ======
		// ======
		// ======
		// ======
		// ====== test range 1:
		// ======
		// ======
		// ======
		// ====== copy little - by range 1: all
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(20, 30, 40, 50);
		result = a.copy(1);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1: and length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(20, 30);
		result = a.copy(1);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1: and length 1
		final IntArray b = a.assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> b.copy(1));
		// ====== copy little - by range 1:4 all
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(20, 30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1:4 and length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(20, 30);
		result = a.copy(1);
		assertArrayEquals(expected, a.copy(1));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1: and length 1
		final IntArray c = a.assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> c.copy(1));
		// ======
		// ======
		// ======
		// ======
		// ====== test range 1:4
		// ======
		// ======
		// ======
		// ====== copy little - by range 1:4
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(20, 30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1:4 and length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(20, 30);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1: and length 1
		final IntArray d = a.assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> d.copy(1));
		// ====== copy little - by range 1:4 all
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(20, 30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1:4 and length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(20, 30);
		result = a.copy(1, 4);
		assertArrayEquals(expected, a.copy(1));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy little - by range 1: and length 1
		final IntArray e = a.assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> e.copy(1));
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== test big
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== copy big - all
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		result = a.copy();
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40, 50);
		result = a.copy();
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by length 1
		a = a.big().assign(x(10, 20, 30, 40, 50), 1);
		expected = x(50);
		result = a.copy();
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ======
		// ======
		// ======
		// ======
		// ====== test range 1: big
		// ======
		// ======
		// ======
		// ====== copy big - by range 1: all
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40);
		result = a.copy(1);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1: and length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40);
		result = a.copy(1);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1: and length 1
		final IntArray f = a.big().assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> f.copy(1));
		// ====== copy big - by range 1:4 all
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = x(20, 30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1:4 and length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40);
		result = a.copy(1);
		assertArrayEquals(expected, a.copy(1));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1: and length 1
		final IntArray g = a.big().assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> g.copy(1));
		// ======
		// ======
		// ======
		// ======
		// ====== test range 1:4 big
		// ======
		// ======
		// ======
		// ====== copy big - by range 1:4
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = x(20, 30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1:4 and length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1: and length 1
		final IntArray h = a.big().assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> h.copy(1));
		// ====== copy big - by range 1:4 all
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = x(20, 30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, result);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1:4 and length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40);
		result = a.copy(1, 4);
		assertArrayEquals(expected, a.copy(1));
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertEquals(expected.length, result.length);
		// ====== copy big - by range 1: and length 1
		final IntArray i = a.big().assign(x(10, 20, 30, 40, 50), 1);
		assertThrows(IndexOutOfBoundsException.class, () -> i.copy(1));

	}

	@Test
	public void testNewClone() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== initial little by default
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10, 20, 30, 40, 50}
		a = a.assign(x(10, 20, 30, 40, 50)).newClone();
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10, 20, 30} by length
		a = a.assign(x(10, 20, 30, 40, 50), 3).newClone();
		expected = x(10, 20, 30);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10} by length
		a = a.assign(x(10, 20, 30, 40, 50), 1).newClone();
		expected = x(10);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {10, 20} by length
		a = a.assign(x(10, 20, 30, 40, 50)).newClone();
		a = a.assign(2).newClone();
		expected = x(10, 20);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign empty by null
		a = a.assign(null, 100).newClone();
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== assign {40, 50} by big endian
		a = a.big().assign(x(10, 20, 30, 40, 50), 2).newClone();
		expected = x(40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== initial big
		a = newInstance().big();
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {10, 20, 30, 40, 50}
		a = a.assign(x(10, 20, 30, 40, 50)).newClone();
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {30, 40, 50} by length
		a = a.assign(x(10, 20, 30, 40, 50), 3).newClone();
		expected = x(30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {50} by length
		a = a.assign(x(10, 20, 30, 40, 50), 1).newClone();
		expected = x(50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {40, 50} by length
		a = a.assign(x(10, 20, 30, 40, 50)).newClone();
		a = a.assign(2).newClone();
		expected = x(40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign empty by null
		a = a.assign(null, 100).newClone();
		expected = x();
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== assign {10, 20} by little endian
		a = a.assign(x(10, 20, 30, 40, 50), 2).little().newClone();
		expected = x(10, 20);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
	}

	@Test
	public void testToString() {
		String expected = null;
		IntArray a = newInstance();
		// ====== to string all
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(10, 20, 30, 40, 50));
		assertEquals(expected, a.toString());
		// ====== to string by range 1:
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(20, 30, 40, 50));
		assertEquals(expected, a.toString(1));
		// ====== to string by range 1:
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(20, 30, 40, 50));
		assertEquals(expected, a.toString(1));
		// ====== to string by range 3:
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(40, 50));
		assertEquals(expected, a.toString(3));
		// ====== to string by range 1:4
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(20, 30, 40));
		assertEquals(expected, a.toString(1, 4));
		// ====== to string by range 3:7
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(40, 50));
		assertEquals(expected, a.toString(3, 7));
		// ====== to string by range -20:20
		final IntArray d = a;
		assertThrows(IndexOutOfBoundsException.class, () -> d.toString(-20, 20));
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== to string all by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(10, 20, 30));
		assertEquals(expected, a.toString());
		// ====== to string by range 1: by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(20, 30));
		assertEquals(expected, a.toString(1));
		// ====== to string by range 1: by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(20, 30));
		assertEquals(expected, a.toString(1));
		// ====== to string by range 3: by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		final IntArray b = a;
		assertThrows(IndexOutOfBoundsException.class, () -> b.toString(3));
		// ====== to string by range 1:4 by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(20, 30));
		assertEquals(expected, a.toString(1, 4));
		// ====== to string by range 3:7
		final IntArray f = a;
		assertThrows(IndexOutOfBoundsException.class, () -> f.toString(3, 7));
		// ====== to string by range -20:20
		final IntArray g = a;
		assertThrows(IndexOutOfBoundsException.class, () -> g.toString(-20, 20));

		// ======
		// ======
		// ====== big
		// ======
		// ======

		// ====== to string big all
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(10, 20, 30, 40, 50));
		assertEquals(expected, a.toString());
		// ====== to string big by range 1:
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(10, 20, 30, 40));
		assertEquals(expected, a.toString(1));
		// ====== to string big by range 1:
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(10, 20, 30, 40));
		assertEquals(expected, a.toString(1));
		// ====== to string big by range 3:
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(10, 20));
		assertEquals(expected, a.toString(3));
		// ====== to string big by range 1:4
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(20, 30, 40));
		assertEquals(expected, a.toString(1, 4));
		// ====== to string big by range 3:7
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = Arrays.toString(x(10, 20));
		assertEquals(expected, a.toString(3, 7));
		// ====== to string big by range -20:20
		final IntArray u = a;
		assertThrows(IndexOutOfBoundsException.class, () -> u.toString(-20, 20));
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== to string big all by length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(30, 40, 50));
		assertEquals(expected, a.toString());
		// ====== to string big by range 1: by length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(30, 40));
		assertEquals(expected, a.toString(1));
		// ====== to string big by range 1: by length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(30, 40));
		assertEquals(expected, a.toString(1));
		// ====== to string big by range 3: by length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		final IntArray n = a;
		assertThrows(IndexOutOfBoundsException.class, () -> n.toString(3));
		// ====== to string big by range 1:4 by length 3
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = Arrays.toString(x(30, 40));
		assertEquals(expected, a.toString(1, 4));
		// ====== to string big by range 3:7
		final IntArray o = a;
		assertThrows(IndexOutOfBoundsException.class, () -> o.toString(3, 7));
		// ====== to string big by range -20:20
		final IntArray l = a;
		assertThrows(IndexOutOfBoundsException.class, () -> l.toString(-20, 20));
	}

	@Test
	public void testShrink() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== shrink 3, index 0
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(0, 3);
		expected = x(40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrink 3, index 2
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(2, 3);
		expected = x(10, 20);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrink 3, index 4
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(4, 3);
		expected = x(10, 20, 30, 40);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrink 3, index 5
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(5, 3);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrink 100, index 6
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(6, 100);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrink 0, index 60
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(0, 60);
		expected = x();
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrink 0, index 60
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(1, 60);
		expected = x(10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== bad shrinks
		a = a.assign(x(10, 20, 30, 40, 50));
		assertTestShrinkThrowsIndexOutOfBoundsException(a, -1, 1);
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== shrink big 3, index 0
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrink(0, 3);
		expected = x(10, 20);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrink big 3, index 2
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrink(2, 3);
		expected = x(40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrink big 3, index 4
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrink(4, 3);
		expected = x(20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrink 3, index 5
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(5, 3);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrink 100, index 6
		a = a.assign(x(10, 20, 30, 40, 50)).shrink(6, 100);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrink big 3, index 5
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrink(5, 3);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
	}

	@Test
	public void testShrinkAndClear() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== shrinkAndClear 3, index 0
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(0, 3);
		expected = x(40, 50, 0, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrinkAndClear 3, index 2
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(2, 3);
		expected = x(10, 20, 0, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrinkAndClear 3, index 4
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(4, 3);
		expected = x(10, 20, 30, 40, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrinkAndClear 3, index 5
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(5, 3);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrinkAndClear 100, index 6
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(6, 100);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrinkAndClear 0, index 60
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(0, 60);
		expected = x(0, 0, 0, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== shrinkAndClear 0, index 60
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(1, 60);
		expected = x(10, 0, 0, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== bad shrinkAndClears
		a = a.assign(x(10, 20, 30, 40, 50));
		assertTestShrinkThrowsIndexOutOfBoundsException(a, -1, 1);
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== shrinkAndClear big 3, index 0
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrinkAndClear(0, 3);
		expected = x(0, 0, 0, 10, 20);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrinkAndClear big 3, index 2
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrinkAndClear(2, 3);
		expected = x(0, 0, 0, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrinkAndClear big 3, index 4
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrinkAndClear(4, 3);
		expected = x(0, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrinkAndClear 3, index 5
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(5, 3);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrinkAndClear 100, index 6
		a = a.assign(x(10, 20, 30, 40, 50)).shrinkAndClear(6, 100);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== shrinkAndClear big 3, index 5
		a = a.big().assign(x(10, 20, 30, 40, 50)).shrinkAndClear(5, 3);
		expected = x(10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
	}

	@Test
	public void testExpend() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== expend 3, index 0
		a = a.assign(x(10, 20, 30, 40, 50)).expend(0, 3).clear(0, 0 + 3);
		expected = x(0, 0, 0, 10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== expend 3, index 2
		a = a.assign(x(10, 20, 30, 40, 50)).expend(2, 3).clear(2, 2 + 3);
		expected = x(10, 20, 0, 0, 0, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== expend 3, index 4
		a = a.assign(x(10, 20, 30, 40, 50)).expend(4, 3).clear(4, 4 + 3);
		expected = x(10, 20, 30, 40, 0, 0, 0, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== expend 3, index 5
		a = a.assign(x(10, 20, 30, 40, 50)).expend(5, 3).clear(5, 5 + 3);
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== expend big 3, index 0
		a = a.big().assign(x(10, 20, 30, 40, 50)).expend(0, 3).clear(0, 0 + 3);
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== expend big 3, index 2
		a = a.big().assign(x(10, 20, 30, 40, 50)).expend(2, 3).clear(2, 2 + 3);
		expected = x(10, 20, 30, 0, 0, 0, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== expend big 3, index 4
		a = a.big().assign(x(10, 20, 30, 40, 50)).expend(4, 3).clear(4, 4 + 3);
		expected = x(10, 0, 0, 0, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== expend big 3, index 5
		a = a.big().assign(x(10, 20, 30, 40, 50)).expend(5, 3).clear(5, 5 + 3);
		expected = x(0, 0, 0, 10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
	}

	@Test
	public void testExpendAndClear() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== expendAndClear 3, index 0
		a = a.assign(x(10, 20, 30, 40, 50)).expendAndClear(0, 3);
		expected = x(0, 0, 0, 10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== expendAndClear 3, index 2
		a = a.assign(x(10, 20, 30, 40, 50)).expendAndClear(2, 3);
		expected = x(10, 20, 0, 0, 0, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== expendAndClear 3, index 4
		a = a.assign(x(10, 20, 30, 40, 50)).expendAndClear(4, 3);
		expected = x(10, 20, 30, 40, 0, 0, 0, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== expendAndClear 3, index 5
		a = a.assign(x(10, 20, 30, 40, 50)).expendAndClear(5, 3);
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== expendAndClear big 3, index 0
		a = a.big().assign(x(10, 20, 30, 40, 50)).expendAndClear(0, 3);
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== expendAndClear big 3, index 2
		a = a.big().assign(x(10, 20, 30, 40, 50)).expendAndClear(2, 3);
		expected = x(10, 20, 30, 0, 0, 0, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== expendAndClear big 3, index 4
		a = a.big().assign(x(10, 20, 30, 40, 50)).expendAndClear(4, 3);
		expected = x(10, 0, 0, 0, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== expendAndClear big 3, index 5
		a = a.big().assign(x(10, 20, 30, 40, 50)).expendAndClear(5, 3);
		expected = x(0, 0, 0, 10, 20, 30, 40, 50);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
	}

	@Test
	public void testDisplace() {
		int[] expected = null;
		IntArray a = newInstance();

		// ==============
		// ==============
		// ============== positive, little
		// ==============
		// ==============

		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(2, 2, 7);
		expected = x(10, 20, 30, 40, 30, 40, 50, 80, 90, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(5, 2, 9);
		expected = x(10, 20, 30, 40, 50, 60, 70, 30, 40, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(8, 0, 9);
		expected = x(10, 20, 30, 40, 50, 60, 70, 80, 10, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(2, 6, 10);
		expected = x(10, 20, 30, 40, 50, 60, 70, 80, 70, 80);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(2, 6, 10);
		expected = x(10, 20, 30, 40, 50, 60, 70, 80, 70, 80);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());

		// ==============
		// ==============
		// ============== negative, little
		// ==============
		// ==============

		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(-2, 2, 7);
		expected = x(10, 20, 50, 60, 70, 60, 70, 80, 90, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(-5, 2, 9);
		expected = x(10, 20, 80, 90, 50, 60, 70, 80, 90, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(-8, 0, 9);
		expected = x(90, 20, 30, 40, 50, 60, 70, 80, 90, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displace(-2, 6, 10);
		expected = x(10, 20, 30, 40, 50, 60, 90, 100, 90, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());

		// ==============
		// ==============
		// ==============
		// ============== positive, big
		// ==============
		// ==============

		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(2, 2, 7);
		expected = x(100, 90, 80, 50, 40, 30, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(5, 2, 9);
		expected = x(100, 40, 30, 70, 60, 50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(8, 0, 9);
		expected = x(100, 10, 80, 70, 60, 50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(2, 6, 10);
		expected = x(80, 70, 80, 70, 60, 50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== negative, big
		// ==============
		// ==============

		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(-2, 2, 7);
		expected = x(100, 90, 80, 70, 60, 70, 60, 50, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(-5, 2, 9);
		expected = x(100, 90, 80, 70, 60, 50, 90, 80, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(-8, 0, 9);
		expected = x(100, 90, 80, 70, 60, 50, 40, 30, 20, 90);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displace(-2, 6, 10);
		expected = x(100, 90, 100, 90, 60, 50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
	}

	@Test
	public void testDisplaceAndClear() {
		int[] expected = null;
		IntArray a = newInstance();

		// ==============
		// ==============
		// ============== positive, little
		// ==============
		// ==============

		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(2, 2, 7);
		expected = x(10, 20, 0, 0, 30, 40, 50, 80, 90, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(5, 2, 9);
		expected = x(10, 20, 0, 0, 0, 0, 0, 30, 40, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(8, 0, 9);
		expected = x(0, 0, 0, 0, 0, 0, 0, 0, 10, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(2, 6, 10);
		expected = x(10, 20, 30, 40, 50, 60, 0, 0, 70, 80);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());

		// ==============
		// ==============
		// ============== negative, little
		// ==============
		// ==============

		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(-2, 2, 7);
		expected = x(10, 20, 50, 60, 70, 0, 0, 80, 90, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(-5, 2, 9);
		expected = x(10, 20, 80, 90, 0, 0, 0, 0, 0, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(-8, 0, 9);
		expected = x(90, 0, 0, 0, 0, 0, 0, 0, 0, 100);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ==============
		a = a.assign(x(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)).displaceAndClear(-2, 6, 10);
		expected = x(10, 20, 30, 40, 50, 60, 90, 100, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());

		// ==============
		// ==============
		// ==============
		// ============== positive, big
		// ==============
		// ==============

		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(2, 2, 7);
		expected = x(100, 90, 80, 50, 40, 30, 0, 0, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(5, 2, 9);
		expected = x(100, 40, 30, 0, 0, 0, 0, 0, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(8, 0, 9);
		expected = x(100, 10, 0, 0, 0, 0, 0, 0, 0, 0);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(2, 6, 10);
		expected = x(80, 70, 0, 0, 60, 50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== negative, big
		// ==============
		// ==============

		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(-2, 2, 7);
		expected = x(100, 90, 80, 0, 0, 70, 60, 50, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(-5, 2, 9);
		expected = x(100, 0, 0, 0, 0, 0, 90, 80, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(-8, 0, 9);
		expected = x(100, 0, 0, 0, 0, 0, 0, 0, 0, 90);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
		a = a.big().assign(x(100, 90, 80, 70, 60, 50, 40, 30, 20, 10)).displaceAndClear(-2, 6, 10);
		expected = x(0, 0, 100, 90, 60, 50, 40, 30, 20, 10);
		assertEquals(Arrays.toString(expected), a.toString());
		assertArrayEquals(expected, a.copy());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ==============
	}

	@Test
	public void testTrimAndtoArray() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== trim empty
		a = a.assign(x());
		expected = x();
		assertArrayEquals(expected, a.trim().toArray());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== trim all
		a = a.assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.trim().toArray());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== trim by length
		a = a.assign(x(10, 20, 30, 40, 50), 3);
		expected = x(10, 20, 30);
		assertArrayEquals(expected, a.trim().toArray());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== trim big empty
		a = a.big().assign(x());
		expected = x();
		assertArrayEquals(expected, a.trim().toArray());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== trim big all
		a = a.big().assign(x(10, 20, 30, 40, 50));
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.trim().toArray());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== trim big by length
		a = a.big().assign(x(10, 20, 30, 40, 50), 3);
		expected = x(30, 40, 50);
		assertArrayEquals(expected, a.trim().toArray());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
	}

	@Test
	public void testReverse() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== reverse little - all
		a = a.assign(x(10, 20, 30, 40, 50)).reverse();
		expected = x(50, 40, 30, 20, 10);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== reverse little - by range 1:
		a = a.assign(x(10, 20, 30, 40, 50)).reverse(1);
		expected = x(10, 50, 40, 30, 20);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== reverse little - by range 1:4
		a = a.assign(x(10, 20, 30, 40, 50)).reverse(1, 4);
		expected = x(10, 40, 30, 20, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== reverse little - by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3).reverse();
		expected = x(30, 20, 10);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== reverse big - all
		a = a.assign(x(10, 20, 30, 40, 50)).big().reverse();
		expected = x(50, 40, 30, 20, 10);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== reverse big - by range 1:
		a = a.assign(x(10, 20, 30, 40, 50)).big().reverse(1);
		expected = x(40, 30, 20, 10, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== reverse big - by range 1:4
		a = a.assign(x(10, 20, 30, 40, 50)).big().reverse(1, 4);
		expected = x(10, 40, 30, 20, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== reverse big - by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3).big().reverse();
		expected = x(50, 40, 30);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());

	}

	@Test
	public void testClear() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== clear little - all
		a = a.assign(x(10, 20, 30, 40, 50)).clear();
		expected = x(0, 0, 0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== clear little - by range 1:
		a = a.assign(x(10, 20, 30, 40, 50)).clear(1);
		expected = x(10, 0, 0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== clear little - by range 1:4
		a = a.assign(x(10, 20, 30, 40, 50)).clear(1, 4);
		expected = x(10, 0, 0, 0, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== clear little - by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3).clear();
		expected = x(0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== clear big - all
		a = a.assign(x(10, 20, 30, 40, 50)).big().clear();
		expected = x(0, 0, 0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== clear big - by range 1:
		a = a.assign(x(10, 20, 30, 40, 50)).big().clear(1);
		expected = x(0, 0, 0, 0, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== clear big - by range 1:4
		a = a.assign(x(10, 20, 30, 40, 50)).big().clear(1, 4);
		expected = x(10, 0, 0, 0, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== clear big - by length 3
		a = a.assign(x(10, 20, 30, 40, 50), 3).big().clear();
		expected = x(0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());

	}

	@Test
	public void testSkip() {
		int[] expected = null;
		IntArray a = newInstance();
		// ====== skip little
		a = a.assign(x(0, 0, 10, 20, 30, 40, 50)).skip();
		expected = x(0, 0, 10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== skip little - skip 3
		a = a.assign(x(0, 0, 10, 20, 30, 40, 50, 0, 0, 0)).skip();
		expected = x(0, 0, 10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ====== skip little - by length 7
		a = a.assign(x(0, 0, 10, 20, 30, 0, 0, 40, 50, 0, 0), 7).skip();
		expected = x(0, 0, 10, 20, 30);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.LITTLE, a.endian());
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ======
		// ====== skip big
		a = a.assign(x(0, 0, 10, 20, 30, 40, 50)).big().skip();
		expected = x(10, 20, 30, 40, 50);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== skip big - skip 2
		a = a.assign(x(10, 20, 30, 40, 50, 0, 0, 0)).big().skip();
		expected = x(10, 20, 30, 40, 50, 0, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());
		// ====== skip big - by length 7
		a = a.assign(x(0, 0, 10, 20, 30, 0, 0, 40, 50, 0, 0), 7).big().skip();
		expected = x(30, 0, 0, 40, 50, 0, 0);
		assertArrayEquals(expected, a.copy());
		assertEquals(Arrays.toString(expected), a.toString());
		assertEquals(expected.length, a.length());
		assertEquals(Endian.BIG, a.endian());

	}

	private void assertTestShrinkThrowsIndexOutOfBoundsException(IntArray a, int index, int size) {
		assertThrows(IndexOutOfBoundsException.class, () -> a.shrink(index, size));
	}

	private void assertTestSortThrowsIndexOutOfBoundsException(IntArray a, int from, int to) {
		assertThrows(IndexOutOfBoundsException.class, () -> a.sort(from, to));
	}

	private static int[] x(int... arr) {
		return Arrays.copyOf(arr, arr.length);
	}

	public IntArray newInstance() {
		return mutable ? IntArray.of() : IntArray.of().toImmutable();
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
