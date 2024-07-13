package codes.abdullah.digits.java;

/**
 * This class contains copy utils from {@link Integer} class
 */
public class JavaInteger {

	/**
	 * All possible chars for representing a number as a String
	 */
	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	final static char[] DigitTens = { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1',
			'1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3',
			'3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5',
			'5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7',
			'7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', };

	final static char[] DigitOnes = { //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };

	final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };

	public static void scanByRadix(char[] arr, int len, int offset, int radix) {
		for (int i = 0; i < len; i++) {

		}
	}

	/**
	 * @see #getIntRange(int, int, int)
	 */
	public static int getIntAt(int n, int index) {
		return getIntAt(n, index, false);
	}

	/**
	 * @see #getIntRange(int, int, int)
	 */
	public static int getIntAt(int n, int index, boolean reverse) {
		return getIntRange(n, index, index + 1, reverse);
	}

	/**
	 * @see #getIntRange(int, int, int)
	 */
	public static int getIntRange(int n, int from) {
		return getIntRange(n, from, -1);
	}

	public static int getIntRange(int n, int from, int to) {
		return getIntRange(n, from, to, false);
	}

	/**
	 * get digits based on given range
	 * 
	 * @param from    if reverse=false, (left-inclusive), otherwise
	 *                (right-exclusive)
	 * @param to      if reverse=false, (right-exclusive), otherwise
	 *                (left-inclusive), if to = -1, will select the entire digits
	 * @param reverse change selection direction
	 */
	public static int getIntRange(int n, int from, int to, boolean reverse) {
		to = to == -1 ? stringSize(n) : to;
		boolean off = false;
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				off = reverse && from == 0 || !reverse && to == 10 ? true : false;
				n = Integer.MAX_VALUE;
			} else {
				n = -n;
			}
		}

		int len_of = stringSize(n);
		to = to > len_of ? len_of : to;
		from = from < 0 ? 0 : from;
		if (reverse) {
			int tmp = from;
			from = to;
			to = tmp;
			from = (len_of) - from;
			to = (len_of) - to;
		}

		int q, r, pow = 1, out = 0;
		while (n >= 65536 && len_of > from) {
			q = n / 100;
			r = n - ((q << 6) + (q << 5) + (q << 2));
			n = q;

			if (--len_of >= from && len_of < to) {
				out += toInt(DigitOnes[r]) * pow;
				pow *= 10;
			}

			if (--len_of >= from && len_of < to) {
				out += toInt(DigitTens[r]) * pow;
				pow *= 10;
			}
		}

		for (; len_of > from;) {
			q = (n * 52429) >>> (16 + 3);
			r = n - ((q << 3) + (q << 1));

			if (--len_of >= from && len_of < to) {
				out += toInt(digits[r]) * pow;
				pow *= 10;
			}

			n = q;
			if (n == 0) {
				break;
			}
		}

		return off ? out + 1 : out;
	}

	private static int toInt(char c) {
		if (c >= '0' && c <= '9') {
			return c - '0';
		}
		return c - 'a';
	}

	/**
	 * @see Integer#formatUnsignedInt(int, int, char[], int, int)
	 */
	public static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len, int delimitation,
			char delimiter) {
		int charPos = len;
		int radix = 1 << shift;
		int mask = radix - 1;
		int x = delimitation;
		do {
			buf[offset + --charPos] = digits[val & mask];
			val >>>= shift;
			if (charPos > 0 && --x % delimitation == 0) {
				buf[offset + --charPos] = delimiter;
				x = delimitation;
			}
		} while (val != 0 && charPos > 0);
		return charPos;
	}

	public static void main(String[] args) {
		int val = 15;
		int shift = 4;
		char[] buf = new char[10];
		int offset = 0;
		int len = 10;
		buf[buf.length-1] = 'A';
		formatUnsignedInt(val, shift, buf, offset, len);
		System.out.println(new String(buf).trim());
	}
	


	/**
	 * @see Integer#formatUnsignedInt(int, int, char[], int, int)
	 */
	public static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
		int charPos = len;
		int radix = 1 << shift;
		int mask = radix - 1;
		do {
			buf[offset + --charPos] = digits[val & mask];
			val >>>= shift;
		} while (val != 0 && charPos > 0);
		return charPos;
	}

	// codes
	public static int formatUnsignedLong(long val, int shift, char[] buf, int offset, int len) {
		int charPos = len;
		int radix = 1 << shift;
		int mask = radix - 1;
		do {
			buf[offset + --charPos] = digits[((int) val) & mask];
			val >>>= shift;
		} while (val != 0 && charPos > 0);
		return charPos;
	}

	/**
	 * @see Long#formatUnsignedLong(long, int, char[], int, int)
	 */
	public static int formatUnsignedLong(long val, int shift, char[] buf, int offset, int len, final int delimitation,
			final char delimiter) {
		int charPos = len;
		int radix = 1 << shift;
		int mask = radix - 1;
		int x = delimitation;
		do {
			buf[offset + --charPos] = digits[((int) val) & mask];
			val >>>= shift;
			if (--x % delimitation == 0) {
				buf[offset + --charPos] = delimiter;
				x = delimitation;
			}
		} while (val != 0 && charPos > 0);
		return charPos;
	}

	/**
	 * source: {@link Integer#getChars}<br>
	 * convert numeric-format to character-format, Will fail if i ==
	 * {@link Integer#MIN_VALUE} <br>
	 * 
	 * @param i      the number to convert
	 * @param offset the index to insert in buffer (exclusive-backward), i.e: buffer
	 *               contains: abcxyz, index = 5, output: ab428z<br>
	 *               use {@link #stringSize(int)} for digits length
	 * @param buf    buffer to place
	 * @return 
	 */
	public static int getChars(int i, int offset, char[] buf, int shift) {
		int q, r;
		int charPos = offset;
		char sign = 0;

		if (i < 0) {
			sign = '-';
			i = -i;
		}

		// Generate two digits per iteration
		while (i >= 65536) {
			q = i / 100;
			// really: r = i - (q * 100);
			r = i - ((q << 6) + (q << 5) + (q << 2));
			i = q;
			buf[--charPos] = DigitOnes[r];
			buf[--charPos] = DigitTens[r];
		}

		// Fall thru to fast mode for smaller numbers
		// assert(i <= 65536, i);
		for (;;) {
			q = (i * 52429) >>> (16 + 3);
			r = i - ((q << 3) + (q << 1)); // r = i-(q*10) ...
			buf[--charPos] = digits[r];
			i = q;
			if (i == 0)
				break;
		}
		if (sign != 0) {
			buf[--charPos] = sign;
		}
		return charPos;
	}

	public static int getChars(int i, int offset, char[] buf, int delimitation, char delimiter) {
		int q, r;
		int charPos = offset;
		char sign = 0;
		int x = delimitation;
		if (i < 0) {
			sign = '-';
			i = -i;
		}

		// Generate two digits per iteration
		while (i >= 65536) {
			q = i / 100;
			// really: r = i - (q * 100);
			r = i - ((q << 6) + (q << 5) + (q << 2));
			i = q;
			buf[--charPos] = DigitOnes[r];
			offset--;
			if (--x % delimitation == 0) {
				offset--;
				buf[--charPos] = delimiter;
				x = delimitation;
			}
			buf[--charPos] = DigitTens[r];
			offset--;
			if (--x % delimitation == 0) {
				offset--;
				buf[--charPos] = delimiter;
				x = delimitation;
			}
		}

		// Fall thru to fast mode for smaller numbers
		// assert(i <= 65536, i);
		for (;;) {
			q = (i * 52429) >>> (16 + 3);
			r = i - ((q << 3) + (q << 1)); // r = i-(q*10) ...
			buf[--charPos] = digits[r];
			i = q;
			offset--;
			if (i == 0 && offset == 0) {
				break;
			}
			if (--x % delimitation == 0) {
				offset--;
				buf[--charPos] = delimiter;
				x = delimitation;
			}
		}
		if (sign != 0) {
			buf[--charPos] = sign;
		}
		return charPos;
	}

	// Requires positive x
	public static int stringSize(int x) {
		if (x == Integer.MIN_VALUE) {
			return 10;
		}
		for (int i = 0;; i++) {
			if (x <= sizeTable[i]) {
				return i + 1;
			}
		}
	}

	/**
	 * source: {@link Long#getChars}<br>
	 * convert numeric-format to character-format, Will fail if i ==
	 * {@link Long#MIN_VALUE} <br>
	 * 
	 * @param i     the number to convert
	 * @param offset the index to insert in buffer (exclusive-backward), i.e: buffer
	 *              contains: abcxyz, index = 5, output: ab428z<br>
	 *              use {@link #stringSize(int)} for digits length
	 * @param buf   buffer to place
	 * @return 
	 */
	public static int getChars(long i, int offset, char[] buf) {
		long q;
		int r;
		int charPos = offset;
		char sign = 0;

		if (i < 0) {
			sign = '-';
			i = -i;
		}

		// Get 2 digits/iteration using longs until quotient fits into an int
		while (i > Integer.MAX_VALUE) {
			q = i / 100;
			// really: r = i - (q * 100);
			r = (int) (i - ((q << 6) + (q << 5) + (q << 2)));
			i = q;
			buf[--charPos] = DigitOnes[r];
			buf[--charPos] = DigitTens[r];
		}

		// Get 2 digits/iteration using ints
		int q2;
		int i2 = (int) i;
		while (i2 >= 65536) {
			q2 = i2 / 100;
			// really: r = i2 - (q * 100);
			r = i2 - ((q2 << 6) + (q2 << 5) + (q2 << 2));
			i2 = q2;
			buf[--charPos] = DigitOnes[r];
			buf[--charPos] = DigitTens[r];
		}

		// Fall thru to fast mode for smaller numbers
		// assert(i2 <= 65536, i2);
		for (;;) {
			q2 = (i2 * 52429) >>> (16 + 3);
			r = i2 - ((q2 << 3) + (q2 << 1)); // r = i2-(q2*10) ...
			buf[--charPos] = digits[r];
			i2 = q2;
			if (i2 == 0)
				break;
		}
		if (sign != 0) {
			buf[--charPos] = sign;
		}
		return charPos;
	}

	/**
	 * @return size in string representation of given number, i.e: 758 -> 3, 65439
	 *         -> 5
	 */
	public static int stringSize(long x) {
		long p = 10;
		for (int i = 1; i < 19; i++) {
			if (x < p)
				return i;
			p = 10 * p;
		}
		return 19;
	}

}
