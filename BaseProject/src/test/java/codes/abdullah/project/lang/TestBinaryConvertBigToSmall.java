package codes.abdullah.project.lang;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import codes.abdullah.project.Endian;

public class TestBinaryConvertBigToSmall {

	@Test
	public void testSignleShortToByte() {
		byte[] expected = null, result = null;
		Endian write = Endian.LITTLE;
		short in2 = 32765;
		boolean skipZeros = false;
		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================

		// ----------
		// ---------- skipZeros = false
		// ----------

		// =======================
		expected = new byte[] { -3, 127 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 10227;
		expected = new byte[] { -13, 39 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 4096;
		expected = new byte[] { 0, 16 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 8, 0 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ----------
		// ---------- skipZeros = true
		// ----------

		skipZeros = true;

		// =======================
		in2 = 32765;
		expected = new byte[] { -3, 127 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 10227;
		expected = new byte[] { -13, 39 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 4096;
		expected = new byte[] { 0, 16 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 8 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================

		// ----------
		// ---------- skipZeros = false
		// ----------
		skipZeros = false;
		write = Endian.BIG;
		// =======================
		in2 = 32765;
		expected = new byte[] { 127, -3 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 10227;
		expected = new byte[] { 39, -13 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 4096;
		expected = new byte[] { 16, 0 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 0, 8 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ----------
		// ---------- skipZeros = true
		// ----------

		skipZeros = true;

		// =======================
		in2 = 32765;
		expected = new byte[] { 127, -3 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 10227;
		expected = new byte[] { 39, -13 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 4096;
		expected = new byte[] { 16, 0 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 8 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

	@Test
	public void testSignleIntToByte() {
		byte[] expected = null, result = null;
		Endian write = Endian.LITTLE;
		int in2 = 2147287856;
		boolean skipZeros = false;
		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================

		// ----------
		// ---------- skipZeros = false
		// ----------

		// =======================
		in2 = 2147287856;
		expected = new byte[] { 48, 3, -3, 127 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 469763070;
		expected = new byte[] { -2, 3, 0, 28 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 1143034318;
		expected = new byte[] { -50, 81, 33, 68 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 8, 0, 0, 0 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ----------
		// ---------- skipZeros = true
		// ----------

		skipZeros = true;

		// =======================
		in2 = 2147287856;
		expected = new byte[] { 48, 3, -3, 127 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 469763070;
		expected = new byte[] { -2, 3, 0, 28 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 1143034318;
		expected = new byte[] { -50, 81, 33, 68 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 8 };
		result = Lang.binary.to.bytes(in2, null, 0, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================

		// ----------
		// ---------- skipZeros = false
		// ----------
		skipZeros = false;
		write = Endian.BIG;
		// =======================
		in2 = 2147287856;
		expected = new byte[] { 127, -3, 3, 48 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 469763070;
		expected = new byte[] { 28, 0, 3, -2 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 1143034318;
		expected = new byte[] { 68, 33, 81, -50 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 0, 0, 0, 8 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ----------
		// ---------- skipZeros = true
		// ----------

		skipZeros = true;
		// =======================
		in2 = 2147287856;
		expected = new byte[] { 127, -3, 3, 48 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		in2 = 469763070;
		expected = new byte[] { 28, 0, 3, -2 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 1143034318;
		expected = new byte[] { 68, 33, 81, -50 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// ========================
		in2 = 8;
		expected = new byte[] { 8 };
		result = Lang.binary.to.e.bytes(in2, null, 0, write, skipZeros);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

	@Test
	public void testShortToByte() {
		byte[] expected = null, result = null;
		short[] in = { 10, -10, 32767, -32768 };
		int inlen = 0;
		int from = 0;
		int to = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;

		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new byte[] { 10, 0, -10, -1, -1, 127, 0, -128 };//
		result = Lang.binary.to.bytes(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 10, 0 };//
		result = Lang.binary.to.bytes(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 10, 0, -10, -1 };//
		result = Lang.binary.to.bytes(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 10, 0, -10, -1, -1, 127 };//
		result = Lang.binary.to.bytes(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		// =======================
		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new byte[] { -128, 0, 127, -1, -1, -10, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { -1, -10, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 127, -1, -1, -10, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to LITTLE
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new byte[] { 0, -128, -1, 127, -10, -1, 10, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 0, -128 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 0, -128, -1, 127 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 0, -128, -1, 127, -10, -1 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to BIG
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new byte[] { 0, 10, -1, -10, 127, -1, -128, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { -128, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 127, -1, -128, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { -1, -10, 127, -1, -128, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

	@Test
	public void testIntegerToByte() {
		byte[] expected = null, result = null;
		int[] in = { 10, -10, 2147483647, -2147483648 };
		int inlen = 0;
		int from = 0;
		int to = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;

		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new byte[] { 10, 0, 0, 0, -10, -1, -1, -1, -1, -1, -1, 127, 0, 0, 0, -128 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 10, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 10, 0, 0, 0, -10, -1, -1, -1 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 10, 0, 0, 0, -10, -1, -1, -1, -1, -1, -1, 127 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new byte[] { -128, 0, 0, 0, 127, -1, -1, -1, -1, -1, -1, -10, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 0, 0, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { -1, -1, -1, -10, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 127, -1, -1, -1, -1, -1, -1, -10, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to LITTLE
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new byte[] { 0, 0, 0, -128, -1, -1, -1, 127, -10, -1, -1, -1, 10, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 0, 0, 0, -128 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 0, 0, 0, -128, -1, -1, -1, 127 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 0, 0, 0, -128, -1, -1, -1, 127, -10, -1, -1, -1 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to BIG
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new byte[] { 0, 0, 0, 10, -1, -1, -1, -10, 127, -1, -1, -1, -128, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { -128, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 127, -1, -1, -1, -128, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { -1, -1, -1, -10, 127, -1, -1, -1, -128, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

	@Test
	public void testIntegerToShort() {
		short[] expected = null, result = null;
		int[] in = { 10, -10, 2147483647, -2147483648 };
		int inlen = 0;
		int from = 0;
		int to = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;

		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new short[] { 10, 0, -10, -1, -1, 32767, 0, -32768 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { 10, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { 10, 0, -10, -1 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { 10, 0, -10, -1, -1, 32767 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new short[] { -32768, 0, 32767, -1, -1, -10, 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { -1, -10, 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { 32767, -1, -1, -10, 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to LITTLE
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new short[] { 0, -32768, -1, 32767, -10, -1, 10, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { 0, -32768 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { 0, -32768, -1, 32767 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { 0, -32768, -1, 32767, -10, -1 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to BIG
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new short[] { 0, 10, -1, -10, 32767, -1, -32768, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { -32768, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { 32767, -1, -32768, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { -1, -10, 32767, -1, -32768, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

	@Test
	public void testLongToByte() {
		byte[] expected = null, result = null;
		long[] in = { 10L, -10L, 9223372036854775807L, -9223372036854775808L };
		int inlen = 0;
		int from = 0;
		int to = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;

		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new byte[] { 10, 0, 0, 0, 0, 0, 0, 0, -10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				127, 0, 0, 0, 0, 0, 0, 0, -128 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 10, 0, 0, 0, 0, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 10, 0, 0, 0, 0, 0, 0, 0, -10, -1, -1, -1, -1, -1, -1, -1 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 10, 0, 0, 0, 0, 0, 0, 0, -10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				127 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new byte[] { -128, 0, 0, 0, 0, 0, 0, 0, 127, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-10, 0, 0, 0, 0, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 0, 0, 0, 0, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { -1, -1, -1, -1, -1, -1, -1, -10, 0, 0, 0, 0, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 127, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -10, 0, 0, 0, 0, 0, 0, 0,
				10 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to LITTLE
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new byte[] { 0, 0, 0, 0, 0, 0, 0, -128, -1, -1, -1, -1, -1, -1, -1, 127, -10, -1, -1, -1, -1, -1, -1,
				-1, 10, 0, 0, 0, 0, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { 0, 0, 0, 0, 0, 0, 0, -128 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 0, 0, 0, 0, 0, 0, 0, -128, -1, -1, -1, -1, -1, -1, -1, 127 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { 0, 0, 0, 0, 0, 0, 0, -128, -1, -1, -1, -1, -1, -1, -1, 127, -10, -1, -1, -1, -1, -1, -1,
				-1 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to BIG
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new byte[] { 0, 0, 0, 0, 0, 0, 0, 10, -1, -1, -1, -1, -1, -1, -1, -10, 127, -1, -1, -1, -1, -1, -1,
				-1, -128, 0, 0, 0, 0, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new byte[] { -128, 0, 0, 0, 0, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new byte[] { 127, -1, -1, -1, -1, -1, -1, -1, -128, 0, 0, 0, 0, 0, 0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new byte[] { -1, -1, -1, -1, -1, -1, -1, -10, 127, -1, -1, -1, -1, -1, -1, -1, -128, 0, 0, 0, 0, 0,
				0, 0 };//
		result = Lang.binary.to.e.bytes(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

	@Test
	public void testLongToShort() {
		short[] expected = null, result = null;
		long[] in = { 10L, -10L, 9223372036854775807L, -9223372036854775808L };
		int inlen = 0;
		int from = 0;
		int to = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;

		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new short[] { 10, 0, 0, 0, -10, -1, -1, -1, -1, -1, -1, 32767, 0, 0, 0, -32768 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { 10, 0, 0, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { 10, 0, 0, 0, -10, -1, -1, -1 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { 10, 0, 0, 0, -10, -1, -1, -1, -1, -1, -1, 32767 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new short[] { -32768, 0, 0, 0, 32767, -1, -1, -1, -1, -1, -1, -10, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { 0, 0, 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { -1, -1, -1, -10, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { 32767, -1, -1, -1, -1, -1, -1, -10, 0, 0, 0, 10 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to LITTLE
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new short[] { 0, 0, 0, -32768, -1, -1, -1, 32767, -10, -1, -1, -1, 10, 0, 0, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { 0, 0, 0, -32768 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { 0, 0, 0, -32768, -1, -1, -1, 32767 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { 0, 0, 0, -32768, -1, -1, -1, 32767, -10, -1, -1, -1 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to BIG
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new short[] { 0, 0, 0, 10, -1, -1, -1, -10, 32767, -1, -1, -1, -32768, 0, 0, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new short[] { -32768, 0, 0, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new short[] { 32767, -1, -1, -1, -32768, 0, 0, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new short[] { -1, -1, -1, -10, 32767, -1, -1, -1, -32768, 0, 0, 0 };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

	@Test
	public void testLongToInteger() {
		int[] expected = null, result = null;
		long[] in = { 10L, -10L, 9223372036854775807L, -9223372036854775808L };
		int inlen = 0;
		int from = 0;
		int to = 0;
		Endian read = Endian.LITTLE;
		Endian write = Endian.LITTLE;

		// =======================
		// =======================
		// ======================= LITTLE to LITTLE
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new int[] { 10, 0, -10, -1, -1, 2147483647, 0, -2147483648 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new int[] { 10, 0 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new int[] { 10, 0, -10, -1 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);

		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new int[] { 10, 0, -10, -1, -1, 2147483647 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= LITTLE to BIG
		// =======================
		// =======================
		read = Endian.LITTLE;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new int[] { -2147483648, 0, 2147483647, -1, -1, -10, 0, 10 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new int[] { 0, 10 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new int[] { -1, -10, 0, 10 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new int[] { 2147483647, -1, -1, -10, 0, 10 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to LITTLE
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.LITTLE;
		from = 0;
		to = 4;
		expected = new int[] { 0, -2147483648, -1, 2147483647, -10, -1, 10, 0 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new int[] { 0, -2147483648 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new int[] { 0, -2147483648, -1, 2147483647 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new int[] { 0, -2147483648, -1, 2147483647, -10, -1 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		// =======================
		// =======================
		// ======================= BIG to BIG
		// =======================
		// =======================
		read = Endian.BIG;
		write = Endian.BIG;
		from = 0;
		to = 4;
		expected = new int[] { 0, 10, -1, -10, 2147483647, -1, -2147483648, 0 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 1;
		expected = new int[] { -2147483648, 0 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 2;
		expected = new int[] { 2147483647, -1, -2147483648, 0 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 3;
		expected = new int[] { -1, -10, 2147483647, -1, -2147483648, 0 };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

	}

}
