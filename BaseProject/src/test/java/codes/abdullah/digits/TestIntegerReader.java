package codes.abdullah.digits;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import codes.abdullah.project.Endian;

public class TestIntegerReader {
	private static final int[] radixes = { 2, 8, 10, 16 };

	@Test
	public void testLengthOf() {
		for (int r = 0; r < radixes.length; r++) {
			int radix = radixes[r];
			for (int i = 0; i < 1024 * 1024; i++) {
				int n = Digits.RANDOM.nextInt();
				String str = toString(n, radix, false);
				int len = Digits.ints.lengthOf(n, radix);
				String msg = String.format("radix(%d), n(%d), str(%s), strlen(%d), len(%d)\n", radix, n, str,
						str.length(), len);
				if (str.length() != len)
					System.err.printf(msg);
				assertEquals(msg, len, str.length());
			}
		}
//
		for (int r = 0; r < radixes.length; r++) {
			int radix = radixes[r];
			for (int i = 0; i < 1024 * 1024; i++) {
				long n = Digits.RANDOM.nextLong();
				String str = toString(n, radix, false);
				str = str.charAt(0) == '-' ? str.substring(1) : str;
				int len = Digits.longs.lengthOf(n, radix);
				String msg = String.format("radix(%d), n(%d), str(%s), strlen(%d), len(%d)\n", radix, n, str,
						str.length(), len);
				if (str.length() != len)
					System.err.printf(msg);
				assertEquals(msg, len, str.length());
			}
		}
	}

	@Test
	public void testFormat() {
		for (int r = 0; r < radixes.length; r++) {
			int radix = radixes[r];
			for (int i = 0; i < (1024 * 1024) * 2; i++) {
				int n = Digits.RANDOM.nextInt();
				// n = 0b1011111100000001001011000110101;
				final String str = toString(n, radix, true);
				int len = Digits.ints.lengthOf(n, radix);
				// only for radix 10, sign were excluded, include it here to be inserted in
				// buffer
				if (radix == 10 && n < 0)
					len++;
//				String msg = String.format("radix(%d), n(%d), str(%s), strlen(%d), len(%d)", radix, n, str,str.length(), len);
//				System.out.println(msg);
				// ======================
				char[] out = new char[len];
				int outlen = out.length;
				int offset = 0;
				char delimeter = 0;
				int delimitaion = 0;

				int charPos = Digits.ints.format(n, radix, out, outlen, offset);
				String s = new String(out, 0, out.length);

				assertEquals(str, s);
				assertEquals(0, charPos);// charPos must be 0
				// ======================
				// ====================== //insert x at beginning, e.g: xx4922
				int more = 2;
				String str2 = str;
				out = new char[len + more];
				for (int j = 0; j < more; j++) {
					out[j] = 'x';
					str2 = "x" + str2;
				}
				outlen = out.length;
				offset = 0;
				delimeter = 0;
				delimitaion = 0;

				charPos = Digits.ints.format(n, radix, out, outlen, offset);
				s = new String(out, 0, out.length);

				assertEquals(str2, s);
				assertEquals(0 + more, charPos);// charPos must be 0 + more
				// ======================
				// ====================== //insert x at end, e.g: 4922xx
				more = 2;
				str2 = str;
				out = new char[len + more];
				for (int j = 0; j < more; j++) {
					out[len + j] = 'x';
					str2 = str2 + "x";
				}
				outlen = out.length;
				offset = more;
				delimeter = 0;
				delimitaion = 0;

				charPos = Digits.ints.format(n, radix, out, outlen, offset);
				s = new String(out, 0, out.length);

				assertEquals(str2, s);
				assertEquals(0, charPos);// charPos must be 0
				// ======================
				// ====================== //insert x at middle, e.g: xx4922xx
				more = 4;
				str2 = "";
				out = new char[len + more];
				// full fill
				for (int j = 0; j < out.length; j++) {
					out[j] = 'x';
					str2 = str2 + "x";
				}
				str2 = new StringBuilder(str2).delete(more / 2, (more / 2) + str.length()).insert(more / 2, str)
						.toString();

				outlen = out.length;
				offset = more / 2;
				delimeter = 0;
				delimitaion = 0;

				charPos = Digits.ints.format(n, radix, out, outlen, offset);
				s = new String(out, 0, out.length);

				assertEquals(str2, s);
				assertEquals(more / 2, charPos);// charPos must be 0
				// ======================

			}

		}

		// ================================
		// ================================
		// ================================
		// ================================
		// ================================
		// ================================
		// ================================

		for (int r = 0; r < radixes.length; r++) {
			int radix = radixes[r];
			for (int i = 0; i < (1024 * 1024) * 2; i++) {
				long n = Digits.RANDOM.nextInt();
				// n = 0b1011111100000001001011000110101;
				final String str = toString(n, radix, true);
				int len = Digits.longs.lengthOf(n, radix);
				// only for radix 10, sign were excluded, include it here to be inserted in
				// buffer
				if (radix == 10 && n < 0)
					len++;
//				String msg = String.format("radix(%d), n(%d), str(%s), strlen(%d), len(%d)", radix, n, str,str.length(), len);
//				System.out.println(msg);
				// ======================
				char[] out = new char[len];
				int outlen = out.length;
				int offset = 0;
				char delimeter = 0;
				int delimitaion = 0;

				int charPos = Digits.longs.format(n, radix, out, outlen, offset);
				String s = new String(out, 0, out.length);

				assertEquals(str, s);
				assertEquals(0, charPos);// charPos must be 0
				// ======================
				// ====================== //insert x at beginning, e.g: xx4922
				int more = 2;
				String str2 = str;
				out = new char[len + more];
				for (int j = 0; j < more; j++) {
					out[j] = 'x';
					str2 = "x" + str2;
				}
				outlen = out.length;
				offset = 0;
				delimeter = 0;
				delimitaion = 0;

				charPos = Digits.longs.format(n, radix, out, outlen, offset);
				s = new String(out, 0, out.length);

				assertEquals(str2, s);
				assertEquals(0 + more, charPos);// charPos must be 0 + more
				// ======================
				// ====================== //insert x at end, e.g: 4922xx
				more = 2;
				str2 = str;
				out = new char[len + more];
				for (int j = 0; j < more; j++) {
					out[len + j] = 'x';
					str2 = str2 + "x";
				}
				outlen = out.length;
				offset = more;
				delimeter = 0;
				delimitaion = 0;

				charPos = Digits.longs.format(n, radix, out, outlen, offset);
				s = new String(out, 0, out.length);

				assertEquals(str2, s);
				assertEquals(0, charPos);// charPos must be 0
				// ======================
				// ====================== //insert x at middle, e.g: xx4922xx
				more = 4;
				str2 = "";
				out = new char[len + more];
				// full fill
				for (int j = 0; j < out.length; j++) {
					out[j] = 'x';
					str2 = str2 + "x";
				}
				str2 = new StringBuilder(str2).delete(more / 2, (more / 2) + str.length()).insert(more / 2, str)
						.toString();

				outlen = out.length;
				offset = more / 2;
				delimeter = 0;
				delimitaion = 0;

				charPos = Digits.longs.format(n, radix, out, outlen, offset);
				s = new String(out, 0, out.length);

				assertEquals(str2, s);
				assertEquals(more / 2, charPos);// charPos must be 0
				// ======================

			}

		}
	}

	@Test
	public void testParse() {
		for (int r = 0; r < radixes.length; r++) {
			int radix = radixes[r];
			RandomRadix rr = new RandomRadix(radix, Integer.SIZE);
			RandomIndex ri = new RandomIndex(1).setInfinite(true);
			for (int i = 0; i < (1024 * 1024) * 2; i++) {
				String str = rr.next();
//				str = "10000000000000000000000000000000";
				// ============ whole
				int from = 0;
				int to = str.length();
				int p = Digits.ints.parse(str, radix, from, to);
				int j = parseInt(str, radix, from, to);
				assertEquals(str, j, p);
				// ============ range
				if (str.length() > 1) {
					ri.setLength(str.length());
					from = ri.nextFrom();
					to = ri.nextTo(from);
					p = Digits.ints.parse(str, radix, from, to);
					j = parseInt(str, radix, from, to);
					assertEquals(str + "(from: " + from + ", to: " + to + ")", j, p);
				}

			}
		}

		for (int r = 0; r < radixes.length; r++) {
			int radix = radixes[r];
			RandomRadix rr = new RandomRadix(radix, Long.SIZE);
			RandomIndex ri = new RandomIndex(1).setInfinite(true);
			for (int i = 0; i < (1024 * 1024) * 2; i++) {
				String str = rr.next();
				// ============ whole
				int from = 0;
				int to = str.length();
//				str = "1000000000000000000000";
//				from = 3; to = 6;
//				radix = 8;
//				int iii = IntegerReader2.parseInt(str, radix, from, to);
				long p = Digits.longs.parse(str, radix, from, to);
				long j = parseLong(str, radix, from, to);
				assertEquals(str, j, p);
				// ============ range
				if (str.length() > 1) {
					ri.setLength(str.length());
					from = ri.nextFrom();
					to = ri.nextTo(from);
					p = Digits.longs.parse(str, radix, from, to);
					j = parseLong(str, radix, from, to);
					assertEquals(str + " (from: " + from + ", to: " + to + ") on radix: " + radix, j, p);
				}

			}
		}
	}

	@Test
	public void testSub() {
		// ===========================
		// ===========================
		// =========================== reverse = false
		// ===========================
		// ===========================
		int from = 0, to = 0;
		RandomIndex ri = new RandomIndex(1).setInfinite(true);
		for (int i = 0; i < (1024 * 1024) * 2; i++) {
			int n = Digits.RANDOM.nextInt();
			n = Math.abs(n);
			ri.setLength(String.valueOf(n).length());
			from = ri.nextFrom();
			to = ri.nextTo(from);
			String substring = String.valueOf(n).substring(from, to);
			int sub = Digits.ints.sub(n, from, to, false);
			int n2 = parseInt(substring, 10, 0, substring.length());
			assertEquals(substring + " (from: " + from + ", to: " + to + "): ", n2, sub);
		}

		for (int i = 0; i < (1024 * 1024) * 2; i++) {
			long n = Digits.RANDOM.nextLong();
			n = Math.abs(n);
			ri.setLength(String.valueOf(n).length());
			from = ri.nextFrom();
			to = ri.nextTo(from);
			String substring = String.valueOf(n).substring(from, to);
			long sub = Digits.longs.sub(n, from, to, false);
			long n2 = parseLong(substring, 10, 0, substring.length());
			assertEquals(substring + " (from: " + from + ", to: " + to + "): ", n2, sub);
		}

		// ===========================
		// ===========================
		// =========================== reverse = true
		// ===========================
		// ===========================
		for (int i = 0; i < (1024 * 1024) * 2; i++) {
			int n = Digits.RANDOM.nextInt();
			n = Math.abs(n);
			ri.setLength(String.valueOf(n).length());
			from = ri.nextFrom();
			to = ri.nextTo(from);
			String str = String.valueOf(n);
			int rFrom = Endian.BIG.from(from, to, str.length(), str.length());
			int rTo = Endian.BIG.to(from, to, str.length(), str.length());
			String substring = str.substring(rFrom, rTo);
			int sub = Digits.ints.sub(n, from, to, true);
			int n2 = parseInt(substring, 10, 0, substring.length());
			String msg = String.format(" %s (%d:%d) -> (%d:%d)", str, from, to, rFrom, rTo);
			assertEquals(substring + msg + " [reverse = true]", n2, sub);
		}

		for (int i = 0; i < (1024 * 1024) * 2; i++) {
			long n = Digits.RANDOM.nextLong();
			n = Math.abs(n);
			ri.setLength(String.valueOf(n).length());
			from = ri.nextFrom();
			to = ri.nextTo(from);
			String str = String.valueOf(n);
			int rFrom = Endian.BIG.from(from, to, str.length(), str.length());
			int rTo = Endian.BIG.to(from, to, str.length(), str.length());
			String substring = str.substring(rFrom, rTo);
			long sub = Digits.longs.sub(n, from, to, true);
			long n2 = parseLong(substring, 10, 0, substring.length());
			String msg = String.format(" %s (%d:%d) -> (%d:%d)", str, from, to, rFrom, rTo);
			assertEquals(substring + msg + " [reverse = true]", n2, sub);
		}
	}

	@Test
	public void testIntegerNumberOf() {
		int n = 0, num = 0;
		int stringCountedTrailingZeros = 0;
		int[] radixes = { 2, 8, 10, 16 };
		for (int i = 0; i < 33; i++) {
			for (int j = 0; j < radixes.length; j++) {
				int radix = radixes[j];
				// ============== trailing
				String s = Integer.toString(n, radix);
				stringCountedTrailingZeros = countTrailingZeros(n, radix);
				num = Digits.ints.numberOfTrailingZeros(n, radix);
				String msg = String.format(
						"input(%d), radix(%d), java(%s), java-len(%s) -> string-counted-trailing(%d), numberOf(%d)\n",
						n, radix, s, s.length(), stringCountedTrailingZeros, num);
				assertEquals(msg, stringCountedTrailingZeros, num);
				// ============= leading
				num = Digits.ints.numberOfLeadingZeros(n, radix);
			}
			n = 1 << i;
		}

	}

	@Test
	public void testNumberOf() {
		int n = 0;
		int[] radixes = { 2, 8, 10, 16 };
		for (int i = 0; i < 33; i++) {
			for (int j = 0; j < radixes.length; j++) {
				int radix = radixes[j];
				String s = Integer.toString(n, radix);
				int stringCounted = countTrailingZeros(n, radix);
				int num = Digits.ints.numberOfTrailingZeros(n, radix);
				String msg = String.format(
						"input(%d), radix(%d), java(%s), java-len(%s) -> string-counted(%d), numberOf(%d)\n", n, radix,
						s, s.length(), stringCounted, num);
				assertEquals(msg, stringCounted, num);
			}
			n = 1 << i;
		}

		for (int i = 0; i < 1024 * 1024; i++) {
			for (int j = 0; j < radixes.length; j++) {
				int radix = radixes[j];

				String s = Integer.toString(n, radix);
				int stringCounted = countTrailingZeros(n, radix);
				int num = Digits.ints.numberOfTrailingZeros(n, radix);
				String msg = String.format(
						"input(%d), radix(%d), java(%s), java-len(%s) -> string-counted(%d), numberOf(%d)\n", n, radix,
						s, s.length(), stringCounted, num);
				assertEquals(msg, stringCounted, num);
			}
			n = Digits.RANDOM.nextInt();
		}

	}

	private static int countTrailingZeros(int n, int radix) {
		if (n == 0) {
			if (radix == 2)
				return 32;
			else if (radix == 8)
				return 11;
			else if (radix == 10)
				return 10;
			else if (radix == 16)
				return 8;
		}
		String s = Integer.toString(n, radix);
		int x = s.length(), y = 0;
		while (s.charAt(--x) == '0') {
			y++;
		}
		return y;
	}

	private static int countTrailingZeros(long n, int radix) {
		if (n == 0)
			return Long.SIZE;
		String s = Long.toString(n, radix);
		int x = s.length(), y = 0;
		while (s.charAt(--x) == '0') {
			y++;
		}
		return y;
	}

	private static int parseInt(String str, int radix, int from, int to) {
		return new BigInteger(str.substring(from, to), radix).intValue();
	}

	private static long parseLong(String str, int radix, int from, int to) {
		return new BigInteger(str.substring(from, to), radix).longValue();
	}

	private static String toString(int n, int radix, boolean includeSign) {
		String s = null;
		switch (radix) {
		case 2:
			s = Integer.toBinaryString(n);
			break;
		case 8:
			s = Integer.toOctalString(n);
			break;
		case 10:
			s = String.valueOf(n);
			s = includeSign ? s : s.charAt(0) == '-' ? s.substring(1) : s;
			break;
		case 16:
			s = Integer.toHexString(n);
			break;
		default:
			throw new IllegalArgumentException("unknown radix: " + radix);
		}

		return s;
	}

	private static String toString(long n, int radix, boolean includeSign) {
		String s = null;
		switch (radix) {
		case 2:
			s = Long.toBinaryString(n);
			break;
		case 8:
			s = Long.toOctalString(n);
			break;
		case 10:
			s = String.valueOf(n);
			s = includeSign ? s : s.charAt(0) == '-' ? s.substring(1) : s;
			break;
		case 16:
			s = Long.toHexString(n);
			break;
		default:
			throw new IllegalArgumentException("unknown radix: " + radix);
		}

		return s;
	}

}
