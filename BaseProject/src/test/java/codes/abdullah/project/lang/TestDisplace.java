package codes.abdullah.project.lang;

import static codes.abdullah.project.lang.TestLang.dontCheckAndFill;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;

import org.junit.Test;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Endian;

public class TestDisplace {

	@Test
	public void testSquashLimitedBoarder() {
		int[] a = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, result, expected;
		Endian read = Endian.LITTLE;
		int from = 0, to = 0, displacement, len = a.length, fillfrom, fillto, range, copylen;

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== positive displacement, LITTLE, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		from = 2;
		to = 7;
		displacement = 2;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 10, 20, 00, 00, 30, 40, 50, 80, 90, 100 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		displacement = 5;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 10, 20, 00, 00, 00, 00, 00, 30, 40, 100 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		displacement = 8;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 00, 00, 00, 00, 00, 00, 00, 00, 10, 100 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		displacement = 2;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 10, 20, 30, 40, 50, 60, 00, 00, 70, 80 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
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
		// ============== extra slots
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
		a = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 0, 0, 0, 0, 0 };
		len = 10;
		from = 2;
		to = 7;
		displacement = 2;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 10, 20, 00, 00, 30, 40, 50, 80, 90, 100, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		displacement = 5;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 10, 20, 00, 00, 00, 00, 00, 30, 40, 100, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		displacement = 8;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 00, 00, 00, 00, 00, 00, 00, 00, 10, 100, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		displacement = 2;
		range = to - from;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 10, 20, 30, 40, 50, 60, 00, 00, 70, 80, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== negative displacement, LITTLE, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		a = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		len = 10;
		from = 2;
		to = 7;
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 10, 20, 50, 60, 70, 0, 0, 80, 90, 100 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		displacement = -5;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 10, 20, 80, 90, 0, 0, 0, 0, 0, 100 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		displacement = -8;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 90, 0, 0, 0, 0, 0, 0, 0, 0, 100 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 10, 20, 30, 40, 50, 60, 90, 100, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
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
		// ============== extra slots
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
		a = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 0, 0, 0, 0, 0 };
		len = 10;
		from = 2;
		to = 7;
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 10, 20, 50, 60, 70, 0, 0, 80, 90, 100, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		displacement = -5;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 10, 20, 80, 90, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		displacement = -8;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 90, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 10, 20, 30, 40, 50, 60, 90, 100, 0, 0, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ===================
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 6, to0 = 3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.in(arr0, len0, displacement0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 0, to0 = 30, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.in(arr0, len0, displacement0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = -1, to0 = 3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.in(arr0, len0, displacement0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 4, to0 = -3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.in(arr0, len0, displacement0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 1, to0 = 3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.in(arr0, len0, displacement0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 2, to0 = 5, displacement0 = 300;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.in(arr0, len0, displacement0, from0, to0));
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}

		{
			final int[] arr0 = null;
			final int len0 = len, from0 = 0, to0 = 5, displacement0 = -3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class,
					() -> Lang.displace.squash.in(arr0, len0, displacement0, from0, to0));
			assertThrows(NullPointerException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== positive displacement, BIG, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		a = new int[] { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
		len = a.length;
		read = Endian.BIG;
		from = 2;
		to = 7;
		int bfrom = read.from(from, to, len, a.length);
		int bto = read.to(from, to, len, a.length);
		displacement = 2;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 100, 90, 80, 50, 40, 30, 0, 0, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = 5;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 100, 40, 30, 0, 0, 0, 0, 0, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = 8;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 100, 10, 0, 0, 0, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = 2;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 80, 70, 0, 0, 60, 50, 40, 30, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		a = new int[] { 0, 0, 0, 0, 0, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
		len = a.length;
		read = Endian.BIG;
		from = 2;
		to = 7;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = 2;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 0, 0, 0, 0, 0, 100, 90, 80, 50, 40, 30, 0, 0, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = 5;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 0, 0, 0, 0, 0, 100, 40, 30, 0, 0, 0, 0, 0, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = 8;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 0, 0, 0, 0, 0, 100, 10, 0, 0, 0, 0, 0, 0, 0, 0 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = 2;
		range = bto - bfrom;
		copylen = range - displacement;
		fillfrom = from;
		fillto = fillfrom + displacement;
		expected = new int[] { 0, 0, 0, 0, 0, 80, 70, 0, 0, 60, 50, 40, 30, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== negative displacement, BIG, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		a = new int[] { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
		from = 2;
		to = 7;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 100, 90, 80, 0, 0, 70, 60, 50, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = -5;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 100, 0, 0, 0, 0, 0, 90, 80, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		displacement = -8;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 100, 0, 0, 0, 0, 0, 0, 0, 0, 90 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 0, 0, 100, 90, 60, 50, 40, 30, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		a = new int[] { 0, 0, 0, 0, 0, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
		from = 2;
		to = 7;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 0, 0, 0, 0, 0, 100, 90, 80, 0, 0, 70, 60, 50, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 2;
		to = 9;
		bfrom = read.from(from, to, len, a.length);
		bto = read.to(from, to, len, a.length);
		displacement = -5;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 90, 80, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 0;
		to = 9;
		displacement = -8;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 90 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		from = 6;
		to = 10;
		displacement = -2;
		range = to - from;
		copylen = range - Math.abs(displacement);
		fillfrom = from + copylen;
		fillto = fillfrom + Math.abs(displacement);
		expected = new int[] { 0, 0, 0, 0, 0, 0, 0, 100, 90, 60, 50, 40, 30, 20, 10 };
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, from, to,
				read);
		result = dontCheckAndFill(result, len, 0, fillfrom, fillto, read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 6, to0 = 3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 0, to0 = 30, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = -1, to0 = 3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 4, to0 = -3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 1, to0 = 3, displacement0 = 3;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
		{
			final int[] arr0 = Lang.copy.of.e.this_(a, a.length);
			final int len0 = len, from0 = 2, to0 = 5, displacement0 = 300;
			final Endian read0 = read;
			assertThrows(IndexOutOfBoundsException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}

		{
			final int[] arr0 = null;
			final int len0 = len, from0 = 0, to0 = 5, displacement0 = -3;
			final Endian read0 = read;
			assertThrows(NullPointerException.class,
					() -> Lang.displace.squash.e.in(arr0, len0, displacement0, from0, to0, from0, to0, read0));
		}
	}

	@Test
	public void testSquashExtendedBoarder() {
		int[] a = toints("0123456789ABCD"), result, expected;
		Endian read = Endian.LITTLE;
		int from = 0, to = 0, displacement, len = a.length, bfrom, bto;

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== positive displacement, LITTLE, no extra slots
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============

		// 012[34{5678}9]ABCD
		from = 5;
		to = 9;
		bfrom = 3;
		bto = 10;

		// ==============
		// 012[34x5678]ABCD
		displacement = 1;
		expected = toints("0123455678ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[35678x9]ABCD
		displacement = -1;
		expected = toints("0123567889ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 012[34x5678]ABCD
		displacement = 1;
		expected = toints("0123455678ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[35678x9]ABCD
		displacement = -1;
		expected = toints("0123567889ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// 012[34xx567]ABCD
		displacement = 2;
		expected = toints("0123456567ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[5678xx9]ABCD
		displacement = -2;
		expected = toints("0125678789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 012[34xx567]ABCD
		displacement = 2;
		expected = toints("0123456567ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[5678xx9]ABCD
		displacement = -2;
		expected = toints("0125678789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// 012[34xxx56]ABCD
		displacement = 3;
		expected = toints("0123456756ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[678xxx9]ABCD
		displacement = -3;
		expected = toints("0126786789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 012[34xxx56]ABCD
		displacement = 3;
		expected = toints("0123456756ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[678xxx9]ABCD
		displacement = -3;
		expected = toints("0126786789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============

		// 01234xxxx5ABCD
		displacement = 4;
		expected = toints("0123456785ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[78xxxx]ABCD
		displacement = -4;
		expected = toints("0127856789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 01234xxxx5ABCD
		displacement = 4;
		expected = toints("0123456785ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[78xxxx]ABCD
		displacement = -4;
		expected = toints("0127856789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============

		// 01234xxxxxABCD
		displacement = 5;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[8xxxxx]ABCD
		displacement = -5;
		expected = toints("0128456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian
		// 01234xxxxxABCD
		displacement = 5;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[8xxxxx]ABCD
		displacement = -5;
		expected = toints("0128456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============

		// 01234xxxxxABCD
		displacement = 6;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[xxxxxx]ABCD
		displacement = -6;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 01234xxxxxABCD
		displacement = 6;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[xxxxxx]ABCD
		displacement = -6;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============

		// 01234xxxxxABCD
		displacement = 8;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[xxxxxx]ABCD
		displacement = -8;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 01234xxxxxABCD
		displacement = 8;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[xxxxxx]ABCD
		displacement = -8;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============

		// 0[12{345}6789A]BCD
		from = 3;
		to = 6;
		bfrom = 1;
		bto = 11;

		// ==============
		// 0[12x455789A]BCD
		displacement = 1;
		expected = toints("0123345789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 0[1345x6789A]BCD
		displacement = -1;
		expected = toints("0134556789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 0[12x455789A]BCD
		displacement = 1;
		expected = toints("0123345789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 0[1345x6789A]BCD
		displacement = -1;
		expected = toints("0134556789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// 0[12xxxx345A]BCD
		displacement = 4;
		expected = toints("0123456345ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 0[5xxxx6789A]BCD
		displacement = -4;
		expected = toints("0523456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 0[12xxxx345A]BCD
		displacement = 4;
		expected = toints("0123456345ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 0[5xxxx6789A]BCD
		displacement = -4;
		expected = toints("0523456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// 0[123456789A]BCD
		displacement = 7;
		expected = toints("01234567893BCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// 0[123456789A]BCD
		displacement = -7;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian
		// 0[123456789A]BCD
		displacement = 7;
		expected = toints("01234567893BCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 0[123456789A]BCD
		displacement = -7;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ==============
		// 0[123456789A]BCD
		displacement = 10;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 0[123456789A]BCD
		displacement = -10;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// = endian

		// 0[123456789A]BCD
		displacement = 10;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 0[123456789A]BCD
		displacement = -10;
		expected = toints("0123456789ABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ============== BIG
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============
		// ==============

		// 012345[67{89A}B]CD
		read = Endian.BIG;
		from = 3;
		to = 6;
		bfrom = 2;
		bto = 8;

		// ==============
		// 0123456789ABCD
		// 012345[6789AB]CD
		// 012345[689AxB]CD
		displacement = 1;
		expected = toints("012345689AABCD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// 012[35678x9]ABCD
		displacement = -1;
		expected = toints("01234567889ACD");
		result = Lang.displace.squash.e.in(Lang.copy.of.e.this_(a, a.length), len, displacement, from, to, bfrom, bto,
				read);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

	}

	private static int[] toints(String s) {
		String[] ss = s.split("");
		StringBuffer sb = new StringBuffer(Digits.ints.parse(ss[0], 0, ss[0].length(), 16));
		for (int i = 1; i < ss.length; i++) {
			sb.append(",").append(Digits.ints.parse(ss[i], 0, ss[i].length(), 16));
		}

		return Lang.wrapper
				.unwrap(Arrays.stream(ss = sb.toString().split("[,]")).map(Digits.ints::parse).toArray(Integer[]::new));
	}
}
