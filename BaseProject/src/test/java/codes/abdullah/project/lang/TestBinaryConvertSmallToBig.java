package codes.abdullah.project.lang;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;

import org.junit.Test;

import codes.abdullah.project.Endian;

public class TestBinaryConvertSmallToBig {
	@Test
	public void testByteToShort() {
		short[] expected = null, result = null;
		byte[] in = { -18, 66, -6, 3, 4, -128, 0, 19 };
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
		to = 8;
		expected = new short[] { (short) ((-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((4 & 0xFF) | ((-128 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((0 & 0xFF) | ((19 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.shorts(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new short[] { (short) ((-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.shorts(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new short[] { (short) ((-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((4 & 0xFF) | ((-128 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.shorts(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new short[] { (short) ((0 & 0xFF) | ((19 & 0xFF) << (Byte.SIZE * 1))) };//
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
		to = 8;
		expected = new short[] { (short) ((0 & 0xFF) | ((19 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((4 & 0xFF) | ((-128 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new short[] { (short) ((-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new short[] { (short) ((4 & 0xFF) | ((-128 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new short[] { (short) ((0 & 0xFF) | ((19 & 0xFF) << (Byte.SIZE * 1))) };//
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
		to = 8;
		expected = new short[] { (short) ((19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((3 & 0xFF) | ((-6 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((66 & 0xFF) | ((-18 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new short[] { (short) ((19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new short[] { (short) ((-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((3 & 0xFF) | ((-6 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new short[] { (short) ((66 & 0xFF) | ((-18 & 0xFF) << (Byte.SIZE * 1))) };//
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
		to = 8;
		expected = new short[] { (short) ((66 & 0xFF) | ((-18 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((3 & 0xFF) | ((-6 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new short[] { (short) ((-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new short[] { (short) ((3 & 0xFF) | ((-6 & 0xFF) << (Byte.SIZE * 1))),
				(short) ((-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new short[] { (short) ((66 & 0xFF) | ((-18 & 0xFF) << (Byte.SIZE * 1))) };//
		result = Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		from = 3;
		to = 11;
		assertTestByteToShortThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = 11;
		to = -11;
		assertTestByteToShortThrows(NegativeArraySizeException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = -11;
		to = 4;
		assertTestByteToShortThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
	}

	@Test
	public void testByteToInteger() {
		int[] expected = null, result = null;
		byte[] in = { -18, 66, -6, 3, 4, -128, 0, 19 };
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
		to = 8;
		expected = new int[] {
				(-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1)) | ((-6 & 0xFF) << (Byte.SIZE * 2))
						| ((3 & 0xFF) << (Byte.SIZE * 3)),
				(4 & 0xFF) | ((-128 & 0xFF) << (Byte.SIZE * 1)) | ((0 & 0xFF) << (Byte.SIZE * 2))
						| ((19 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1)) | ((-6 & 0xFF) << (Byte.SIZE * 2))
				| ((3 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1)) | ((4 & 0xFF) << (Byte.SIZE * 2))
				| ((-128 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (0 & 0xFF) | ((19 & 0xFF) << (Byte.SIZE * 1)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
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
		to = 8;
		expected = new int[] {
				(4 & 0xFF) | ((-128 & 0xFF) << (Byte.SIZE * 1)) | ((0 & 0xFF) << (Byte.SIZE * 2))
						| ((19 & 0xFF) << (Byte.SIZE * 3)),
				(-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1)) | ((-6 & 0xFF) << (Byte.SIZE * 2))
						| ((3 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (-18 & 0xFF) | ((66 & 0xFF) << (Byte.SIZE * 1)) | ((-6 & 0xFF) << (Byte.SIZE * 2))
				| ((3 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (-6 & 0xFF) | ((3 & 0xFF) << (Byte.SIZE * 1)) | ((4 & 0xFF) << (Byte.SIZE * 2))
				| ((-128 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (0 & 0xFF) | ((19 & 0xFF) << (Byte.SIZE * 1)) };//
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
		to = 8;
		expected = new int[] {
				(19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1)) | ((-128 & 0xFF) << (Byte.SIZE * 2))
						| ((4 & 0xFF) << (Byte.SIZE * 3)),
				(3 & 0xFF) | ((-6 & 0xFF) << (Byte.SIZE * 1)) | ((66 & 0xFF) << (Byte.SIZE * 2))
						| ((-18 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1)) | ((-128 & 0xFF) << (Byte.SIZE * 2))
				| ((4 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1)) | ((3 & 0xFF) << (Byte.SIZE * 2))
				| ((-6 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (66 & 0xFF) | ((-18 & 0xFF) << (Byte.SIZE * 1)) };//
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
		to = 8;
		expected = new int[] {
				(3 & 0xFF) | ((-6 & 0xFF) << (Byte.SIZE * 1)) | ((66 & 0xFF) << (Byte.SIZE * 2))
						| ((-18 & 0xFF) << (Byte.SIZE * 3)),
				(19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1)) | ((-128 & 0xFF) << (Byte.SIZE * 2))
						| ((4 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (19 & 0xFF) | ((0 & 0xFF) << (Byte.SIZE * 1)) | ((-128 & 0xFF) << (Byte.SIZE * 2))
				| ((4 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (-128 & 0xFF) | ((4 & 0xFF) << (Byte.SIZE * 1)) | ((3 & 0xFF) << (Byte.SIZE * 2))
				| ((-6 & 0xFF) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (66 & 0xFF) | ((-18 & 0xFF) << (Byte.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		from = 3;
		to = 11;
		assertTestByteToIntegerThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = 11;
		to = -11;
		assertTestByteToIntegerThrows(NegativeArraySizeException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = -11;
		to = 4;
		assertTestByteToIntegerThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
	}

	@Test
	public void testByteToLong() {
		long[] expected = null, result = null;
		byte[] in = { -18, 66, -6, 3, 4, -128, 0, 19 };
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
		to = 8;
		expected = new long[] { (-18 & 0xFFL) | ((66 & 0xFFL) << (Byte.SIZE * 1)) | ((-6 & 0xFFL) << (Byte.SIZE * 2))
				| ((3 & 0xFFL) << (Byte.SIZE * 3)) | ((4 & 0xFFL) << (Byte.SIZE * 4))
				| ((-128 & 0xFFL) << (Byte.SIZE * 5)) | ((0 & 0xFFL) << (Byte.SIZE * 6))
				| ((19 & 0xFFL) << (Byte.SIZE * 7)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (-18 & 0xFFL) | ((66 & 0xFFL) << (Byte.SIZE * 1)) | ((-6 & 0xFFL) << (Byte.SIZE * 2))
				| ((3 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-6 & 0xFFL) | ((3 & 0xFFL) << (Byte.SIZE * 1)) | ((4 & 0xFFL) << (Byte.SIZE * 2))
				| ((-128 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (0 & 0xFFL) | ((19 & 0xFFL) << (Byte.SIZE * 1)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] { (-18 & 0xFFL) | ((66 & 0xFFL) << (Byte.SIZE * 1)) | ((-6 & 0xFFL) << (Byte.SIZE * 2))
				| ((3 & 0xFFL) << (Byte.SIZE * 3)) | ((4 & 0xFFL) << (Byte.SIZE * 4))
				| ((-128 & 0xFFL) << (Byte.SIZE * 5)) | ((0 & 0xFFL) << (Byte.SIZE * 6))
				| ((19 & 0xFFL) << (Byte.SIZE * 7)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (-18 & 0xFFL) | ((66 & 0xFFL) << (Byte.SIZE * 1)) | ((-6 & 0xFFL) << (Byte.SIZE * 2))
				| ((3 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-6 & 0xFFL) | ((3 & 0xFFL) << (Byte.SIZE * 1)) | ((4 & 0xFFL) << (Byte.SIZE * 2))
				| ((-128 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (0 & 0xFFL) | ((19 & 0xFFL) << (Byte.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] { (19 & 0xFFL) | ((0 & 0xFFL) << (Byte.SIZE * 1)) | ((-128 & 0xFFL) << (Byte.SIZE * 2))
				| ((4 & 0xFFL) << (Byte.SIZE * 3)) | ((3 & 0xFFL) << (Byte.SIZE * 4))
				| ((-6 & 0xFFL) << (Byte.SIZE * 5)) | ((66 & 0xFFL) << (Byte.SIZE * 6))
				| ((-18 & 0xFFL) << (Byte.SIZE * 7)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (19 & 0xFFL) | ((0 & 0xFFL) << (Byte.SIZE * 1)) | ((-128 & 0xFFL) << (Byte.SIZE * 2))
				| ((4 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-128 & 0xFFL) | ((4 & 0xFFL) << (Byte.SIZE * 1)) | ((3 & 0xFFL) << (Byte.SIZE * 2))
				| ((-6 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (66 & 0xFFL) | ((-18 & 0xFFL) << (Byte.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] { (19 & 0xFFL) | ((0 & 0xFFL) << (Byte.SIZE * 1)) | ((-128 & 0xFFL) << (Byte.SIZE * 2))
				| ((4 & 0xFFL) << (Byte.SIZE * 3)) | ((3 & 0xFFL) << (Byte.SIZE * 4))
				| ((-6 & 0xFFL) << (Byte.SIZE * 5)) | ((66 & 0xFFL) << (Byte.SIZE * 6))
				| ((-18 & 0xFFL) << (Byte.SIZE * 7)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (19 & 0xFFL) | ((0 & 0xFFL) << (Byte.SIZE * 1)) | ((-128 & 0xFFL) << (Byte.SIZE * 2))
				| ((4 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-128 & 0xFFL) | ((4 & 0xFFL) << (Byte.SIZE * 1)) | ((3 & 0xFFL) << (Byte.SIZE * 2))
				| ((-6 & 0xFFL) << (Byte.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (66 & 0xFFL) | ((-18 & 0xFFL) << (Byte.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		from = 3;
		to = 11;
		assertTestByteToLongThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = 11;
		to = -11;
		assertTestByteToLongThrows(NegativeArraySizeException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = -11;
		to = 4;
		assertTestByteToLongThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
	}

	@Test
	public void testShortToInteger() {
		int[] expected = null, result = null;
		short[] in = { -18, 66, -6, 3, 4, -128, 0, 19 };
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
		to = 8;
		expected = new int[] { (-18 & 0xFFFF) | ((66 & 0xFFFF) << (Short.SIZE * 1)),
				(-6 & 0xFFFF) | ((3 & 0xFFFF) << (Short.SIZE * 1)),
				(4 & 0xFFFF) | ((-128 & 0xFFFF) << (Short.SIZE * 1)),
				(0 & 0xFFFF) | ((19 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (-18 & 0xFFFF) | ((66 & 0xFFFF) << (Short.SIZE * 1)),
				(-6 & 0xFFFF) | ((3 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (-6 & 0xFFFF) | ((3 & 0xFFFF) << (Short.SIZE * 1)),
				(4 & 0xFFFF) | ((-128 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (0 & 0xFFFF) | ((19 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.ints(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
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
		to = 8;
		expected = new int[] { (0 & 0xFFFF) | ((19 & 0xFFFF) << (Short.SIZE * 1)),
				(4 & 0xFFFF) | ((-128 & 0xFFFF) << (Short.SIZE * 1)),
				(-6 & 0xFFFF) | ((3 & 0xFFFF) << (Short.SIZE * 1)),
				(-18 & 0xFFFF) | ((66 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (-6 & 0xFFFF) | ((3 & 0xFFFF) << (Short.SIZE * 1)),
				(-18 & 0xFFFF) | ((66 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (4 & 0xFFFF) | ((-128 & 0xFFFF) << (Short.SIZE * 1)),
				(-6 & 0xFFFF) | ((3 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (0 & 0xFFFF) | ((19 & 0xFFFF) << (Short.SIZE * 1)) };//
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
		to = 8;
		expected = new int[] { (19 & 0xFFFF) | ((0 & 0xFFFF) << (Short.SIZE * 1)),
				(-128 & 0xFFFF) | ((4 & 0xFFFF) << (Short.SIZE * 1)),
				(3 & 0xFFFF) | ((-6 & 0xFFFF) << (Short.SIZE * 1)),
				(66 & 0xFFFF) | ((-18 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (19 & 0xFFFF) | ((0 & 0xFFFF) << (Short.SIZE * 1)),
				(-128 & 0xFFFF) | ((4 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (-128 & 0xFFFF) | ((4 & 0xFFFF) << (Short.SIZE * 1)),
				(3 & 0xFFFF) | ((-6 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (66 & 0xFFFF) | ((-18 & 0xFFFF) << (Short.SIZE * 1)) };//
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
		to = 8;
		expected = new int[] { (66 & 0xFFFF) | ((-18 & 0xFFFF) << (Short.SIZE * 1)),
				(3 & 0xFFFF) | ((-6 & 0xFFFF) << (Short.SIZE * 1)),
				(-128 & 0xFFFF) | ((4 & 0xFFFF) << (Short.SIZE * 1)),
				(19 & 0xFFFF) | ((0 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new int[] { (-128 & 0xFFFF) | ((4 & 0xFFFF) << (Short.SIZE * 1)),
				(19 & 0xFFFF) | ((0 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new int[] { (3 & 0xFFFF) | ((-6 & 0xFFFF) << (Short.SIZE * 1)),
				(-128 & 0xFFFF) | ((4 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new int[] { (66 & 0xFFFF) | ((-18 & 0xFFFF) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		from = 3;
		to = 11;
		assertTestShortToIntegerThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = 11;
		to = -11;
		assertTestShortToIntegerThrows(NegativeArraySizeException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = -11;
		to = 4;
		assertTestShortToIntegerThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
	}

	@Test
	public void testShortToLong() {
		long[] expected = null, result = null;
		short[] in = { -18, 66, -6, 3, 4, -128, 0, 19 };
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
		to = 8;
		expected = new long[] {
				(-18 & 0xFFFFL) | ((66 & 0xFFFFL) << (Short.SIZE * 1)) | ((-6 & 0xFFFFL) << (Short.SIZE * 2))
						| ((3 & 0xFFFFL) << (Short.SIZE * 3)),
				(4 & 0xFFFFL) | ((-128 & 0xFFFFL) << (Short.SIZE * 1)) | ((0 & 0xFFFFL) << (Short.SIZE * 2))
						| ((19 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (-18 & 0xFFFFL) | ((66 & 0xFFFFL) << (Short.SIZE * 1))
				| ((-6 & 0xFFFFL) << (Short.SIZE * 2)) | ((3 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-6 & 0xFFFFL) | ((3 & 0xFFFFL) << (Short.SIZE * 1))
				| ((4 & 0xFFFFL) << (Short.SIZE * 2)) | ((-128 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (0 & 0xFFFFL) | ((19 & 0xFFFFL) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] {
				(4 & 0xFFFFL) | ((-128 & 0xFFFFL) << (Short.SIZE * 1)) | ((0 & 0xFFFFL) << (Short.SIZE * 2))
						| ((19 & 0xFFFFL) << (Short.SIZE * 3)),
				(-18 & 0xFFFFL) | ((66 & 0xFFFFL) << (Short.SIZE * 1)) | ((-6 & 0xFFFFL) << (Short.SIZE * 2))
						| ((3 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (-18 & 0xFFFFL) | ((66 & 0xFFFFL) << (Short.SIZE * 1))
				| ((-6 & 0xFFFFL) << (Short.SIZE * 2)) | ((3 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-6 & 0xFFFFL) | ((3 & 0xFFFFL) << (Short.SIZE * 1))
				| ((4 & 0xFFFFL) << (Short.SIZE * 2)) | ((-128 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (0 & 0xFFFFL) | ((19 & 0xFFFFL) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] {
				(19 & 0xFFFFL) | ((0 & 0xFFFFL) << (Short.SIZE * 1)) | ((-128 & 0xFFFFL) << (Short.SIZE * 2))
						| ((4 & 0xFFFFL) << (Short.SIZE * 3)),
				(3 & 0xFFFFL) | ((-6 & 0xFFFFL) << (Short.SIZE * 1)) | ((66 & 0xFFFFL) << (Short.SIZE * 2))
						| ((-18 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (19 & 0xFFFFL) | ((0 & 0xFFFFL) << (Short.SIZE * 1))
				| ((-128 & 0xFFFFL) << (Short.SIZE * 2)) | ((4 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-128 & 0xFFFFL) | ((4 & 0xFFFFL) << (Short.SIZE * 1))
				| ((3 & 0xFFFFL) << (Short.SIZE * 2)) | ((-6 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (66 & 0xFFFFL) | ((-18 & 0xFFFFL) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] {
				(3 & 0xFFFFL) | ((-6 & 0xFFFFL) << (Short.SIZE * 1)) | ((66 & 0xFFFFL) << (Short.SIZE * 2))
						| ((-18 & 0xFFFFL) << (Short.SIZE * 3)),
				(19 & 0xFFFFL) | ((0 & 0xFFFFL) << (Short.SIZE * 1)) | ((-128 & 0xFFFFL) << (Short.SIZE * 2))
						| ((4 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (19 & 0xFFFFL) | ((0 & 0xFFFFL) << (Short.SIZE * 1))
				| ((-128 & 0xFFFFL) << (Short.SIZE * 2)) | ((4 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-128 & 0xFFFFL) | ((4 & 0xFFFFL) << (Short.SIZE * 1))
				| ((3 & 0xFFFFL) << (Short.SIZE * 2)) | ((-6 & 0xFFFFL) << (Short.SIZE * 3)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (66 & 0xFFFFL) | ((-18 & 0xFFFFL) << (Short.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		from = 3;
		to = 11;
		assertTestShortToLongThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = 11;
		to = -11;
		assertTestShortToLongThrows(NegativeArraySizeException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = -11;
		to = 4;
		assertTestShortToLongThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
	}

	@Test
	public void testIntegerToLong() {
		long[] expected = null, result = null;
		int[] in = { -18, 66, -6, 3, 4, -128, 0, 19 };
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
		to = 8;
		expected = new long[] { (-18 & 0xFFFFFFFFL) | ((66 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-6 & 0xFFFFFFFFL) | ((3 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(4 & 0xFFFFFFFFL) | ((-128 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(0 & 0xFFFFFFFFL) | ((19 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (-18 & 0xFFFFFFFFL) | ((66 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-6 & 0xFFFFFFFFL) | ((3 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-6 & 0xFFFFFFFFL) | ((3 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(4 & 0xFFFFFFFFL) | ((-128 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (0 & 0xFFFFFFFFL) | ((19 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.longs(in, inlen, from, to, null, 0);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
				
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] { (0 & 0xFFFFFFFFL) | ((19 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(4 & 0xFFFFFFFFL) | ((-128 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-6 & 0xFFFFFFFFL) | ((3 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-18 & 0xFFFFFFFFL) | ((66 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (-6 & 0xFFFFFFFFL) | ((3 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-18 & 0xFFFFFFFFL) | ((66 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (4 & 0xFFFFFFFFL) | ((-128 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-6 & 0xFFFFFFFFL) | ((3 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (0 & 0xFFFFFFFFL) | ((19 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] { (19 & 0xFFFFFFFFL) | ((0 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-128 & 0xFFFFFFFFL) | ((4 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(3 & 0xFFFFFFFFL) | ((-6 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(66 & 0xFFFFFFFFL) | ((-18 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (19 & 0xFFFFFFFFL) | ((0 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-128 & 0xFFFFFFFFL) | ((4 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (-128 & 0xFFFFFFFFL) | ((4 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(3 & 0xFFFFFFFFL) | ((-6 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (66 & 0xFFFFFFFFL) | ((-18 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
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
		to = 8;
		expected = new long[] { (66 & 0xFFFFFFFFL) | ((-18 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(3 & 0xFFFFFFFFL) | ((-6 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-128 & 0xFFFFFFFFL) | ((4 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(19 & 0xFFFFFFFFL) | ((0 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 0;
		to = 4;
		expected = new long[] { (-128 & 0xFFFFFFFFL) | ((4 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(19 & 0xFFFFFFFFL) | ((0 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 2;
		to = 6;
		expected = new long[] { (3 & 0xFFFFFFFFL) | ((-6 & 0xFFFFFFFFL) << (Integer.SIZE * 1)),
				(-128 & 0xFFFFFFFFL) | ((4 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================
		from = 6;
		to = 8;
		expected = new long[] { (66 & 0xFFFFFFFFL) | ((-18 & 0xFFFFFFFFL) << (Integer.SIZE * 1)) };//
		result = Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write);
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
		assertArrayEquals(expected, result);
		// =======================

		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		// ==================
		from = 3;
		to = 11;
		assertTestIntegerToLongThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = 11;
		to = -11;
		assertTestIntegerToLongThrows(NegativeArraySizeException.class, in, inlen, from, to, read, null, 0, write);
//==================
		from = -11;
		to = 4;
		assertTestIntegerToLongThrows(ArrayIndexOutOfBoundsException.class, in, inlen, from, to, read, null, 0, write);
//==================
	}

	private void assertTestByteToShortThrows(Class<? extends Throwable> cls, byte[] in, int inlen, int from, int to,
			Endian read, short[] out, int outlen, Endian write) {
		assertThrows(cls, () -> Lang.binary.to.e.shorts(in, inlen, from, to, read, null, 0, write));
	}

	private void assertTestByteToIntegerThrows(Class<? extends Throwable> cls, byte[] in, int inlen, int from, int to,
			Endian read, int[] out, int outlen, Endian write) {
		assertThrows(cls, () -> Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write));
	}

	private void assertTestByteToLongThrows(Class<? extends Throwable> cls, byte[] in, int inlen, int from, int to,
			Endian read, long[] out, int outlen, Endian write) {
		assertThrows(cls, () -> Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write));
	}

	private void assertTestShortToIntegerThrows(Class<? extends Throwable> cls, short[] in, int inlen, int from, int to,
			Endian read, int[] out, int outlen, Endian write) {
		assertThrows(cls, () -> Lang.binary.to.e.ints(in, inlen, from, to, read, null, 0, write));
	}

	private void assertTestShortToLongThrows(Class<? extends Throwable> cls, short[] in, int inlen, int from, int to,
			Endian read, long[] out, int outlen, Endian write) {
		assertThrows(cls, () -> Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write));
	}

	private void assertTestIntegerToLongThrows(Class<? extends Throwable> cls, int[] in, int inlen, int from, int to,
			Endian read, long[] out, int outlen, Endian write) {
		assertThrows(cls, () -> Lang.binary.to.e.longs(in, inlen, from, to, read, null, 0, write));
	}

}
