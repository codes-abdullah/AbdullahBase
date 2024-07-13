package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import codes.abdullah.chars.Chars;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

import codes.abdullah.project.lang.Lang;

public abstract class Utils<T> {

	// ============
	// ============
	// ============
	public static final Utils<Byte> by = new ByteUtils();
	public static final Utils<Integer> i = new IntUtils();
	public static final Utils<Long> l = new LongUtils();
	public static final Utils<Bits> b = new BitsUtils();
	public static final Utils<BitSet> bs = new BitSetUtils();
	public static final Utils<BigInteger> bi = new BigIntegerUtils();
	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	public static final int ADDRESS_BITS_PER_WORD = 5;
	public static final int BIT_INDEX_MASK = Integer.SIZE - 1;
	public static final int DEFAULT_RADIX = 10;
	public static final int DEFAULT_BOUNDS = 1;
	public static final int DEFAULT_UPPER_BOUND = 2;
	public static final int DEFAULT_SIGNUM = 1;
	/**
	 * word mask used by {@link Bits}
	 */
	public static final int BITS_WORD_MASK = -1;
	public static final long LONG_MASK = (1L << 32) - 1;

	// ==================
	// ==================
	// ==================

	/**
	 * below are how many digits per radix can fit long/int data type in sequence
	 * level, without reach negative limit and in safe manner, e.g: radix = 8,
	 * max-positive-int = 17777777777 (length = 11), since we can't guarantee if
	 * first is 1 and not beyond, we will say max-safe-length for radix 8 is 10
	 * only, below is preallocated array for each supported radixes by java
	 * 
	 * @see {@link BigInteger#digitsPerLong}
	 */
	public static final int DIGITS_PER_LONG[] = { 0, 0, 62, 39, 31, 27, 24, 22, 20, 19, 18, 18, 17, 17, 16, 16, 15, 15,
			15, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12 };

	// --------------------------
	/**
	 * @see #DIGITS_PER_LONG
	 */
	public static final int DIGITS_PER_INT[] = { 0, 0, 30, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7,
			7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5 };
	/**
	 * @see #LONG_RADIX
	 */
	public static final int INT_RADIX[] = { 0, 0, 0x40000000, 0x4546b3db, 0x40000000, 0x48c27395, 0x159fd800,
			0x75db9c97, 0x40000000, 0x17179149, 0x3b9aca00, 0xcc6db61, 0x19a10000, 0x309f1021, 0x57f6c100, 0xa2f1b6f,
			0x10000000, 0x18754571, 0x247dbc80, 0x3547667b, 0x4c4b4000, 0x6b5a6e1d, 0x6c20a40, 0x8d2d931, 0xb640000,
			0xe8d4a51, 0x1269ae40, 0x17179149, 0x1cb91000, 0x23744899, 0x2b73a840, 0x34e63b41, 0x40000000, 0x4cfa3cc1,
			0x5c13d840, 0x6d91b519, 0x39aa400 };

	/**
	 * {@link BigInteger#bitsPerDigit} in the given radix times 1024. Rounded up to
	 * avoid underallocation.
	 */
	static final long BITS_PER_DIGIT[] = { 0, 0, 1024, 1624, 2048, 2378, 2648, 2875, 3072, 3247, 3402, 3543, 3672, 3790,
			3899, 4001, 4096, 4186, 4271, 4350, 4426, 4498, 4567, 4633, 4696, 4756, 4814, 4870, 4923, 4975, 5025, 5074,
			5120, 5166, 5210, 5253, 5295 };

	/**
	 * max-safe words length
	 * 
	 * @see {@link BigInteger#MAX_WORDS_LENGTH}
	 */
	static final int MAX_WORDS_LENGTH = 1 << 26;

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	T ZERO() {
		return of();
	}

	// ============
	// ============
	// ============
	public abstract T ofSize(int bits_size);

	// ============
	// ============
	// ============
	public T of() {
		return of(0);
	}

	public abstract T of(int n);

	public abstract T of(long n);

	// ============
	// ============
	// ============

	public T of(byte[] words) {
		return of(words, words.length);
	}

	public T of(byte[] words, int wordsInUse) {
		return of(words, wordsInUse, DEFAULT_SIGNUM);
	}

	public T of(byte[] words, int wordsInUse, int sign) {
		return of(words, wordsInUse, sign, Endian.LITTLE);
	}

	public abstract T of(byte[] bytes, int len, int sign, Endian order);

	// ============
	// ============
	// ============

	public T of(int[] words) {
		return of(words, words.length);
	}

	public T of(int[] words, int wordsInUse) {
		return of(words, wordsInUse, DEFAULT_SIGNUM);
	}

	public T of(int[] words, int wordsInUse, int sign) {
		return of(words, wordsInUse, sign, Endian.LITTLE);
	}

	public T of(int[] words, int wordsInUse, Endian order) {
		return of(words, wordsInUse, DEFAULT_SIGNUM, order);
	}

	public abstract T of(int[] words, int wordsInUse, int sign, Endian order);

	// ============
	// ============
	// ============

	public T of(long[] words) {
		return of(words, words.length);
	}

	public T of(long[] words, int wordsInUse) {
		return of(words, wordsInUse, DEFAULT_SIGNUM);
	}

	public T of(long[] words, int wordsInUse, int sign) {
		return of(words, wordsInUse, sign, Endian.LITTLE);
	}

	public abstract T of(long[] dwords, int dwordsInUse, int sign, Endian order);

	// ============
	// ============
	// ============

	public T of(CharSequence cs) {
		return of(cs, DEFAULT_RADIX);
	}

	public T of(CharSequence cs, int radix) {
		return of(cs, radix, 0, cs.length());
	}

	public T of(CharSequence src, int radix, int from, int to) {
		return of(src, radix, from, to, null);
	}

	public T of(CharSequence src, int radix, int from, int to, T assignTo) {
		if (src == null || src.length() == 0 || to - from == 0) {
			return of();
		}

		Chars c = src instanceof Chars ? (Chars) src : Chars.of(src);
		// ------------------------
		// clean up underscores
		// ------------------------
		int clen = c.length();
		c = c.delete('_', from, to);
		to -= (clen - c.length());
		clen = c.length();

		Check.range(from, to, clen);
		Check.radix(radix);
		int sign = DEFAULT_SIGNUM;

		// ------------------------
		// Check for at most one leading sign
		// ------------------------
		final int index1 = c.lastIndexOf('-', to, from);
		final int index2 = c.lastIndexOf('+', to, from);

		if (index1 >= 0) {
			// -----------
			// e.g: 123-321 or -123+321
			// -----------
			if (index1 != from || index2 >= from) {
				throw new NumberFormatException("Illegal embedded sign character: " + c.markAt(index1));
			}
			// -----------
			// we have negative sign -123321, skip it
			// -----------
			sign = -1;
			from++;
		} else if (index2 >= 0) {
			// -----------
			// e.g: 123+321
			// -----------
			if (index2 != from) {
				throw new NumberFormatException("Illegal embedded sign character: " + c.markAt(index2));
			}
			// -----------
			// we have positive sign +123321, skip it
			// -----------
			from++;
		}
		if (from == to) {
			throw new NumberFormatException("can't detect any parsable digits based on given range: " + c);
		}
		// -----------
		// Skip leading zeros
		// -----------
		from = c.indexOfAnyButNot('0', from);
		if (from == -1) {
			return of();
		}

		// -----------
		// Pre-allocate array of expected size. May be too large but can
		// never be too small. Typically exact.
		// -----------
		int numDigits = to - from;

		// -----------
		// e.g: radix = 10, numDigits = 9
		// 9 * 3402 = 30618, 30618 >>> 10 = 29 bits, and add 1 for safety
		// -----------
		long numBits = ((numDigits * BITS_PER_DIGIT[radix]) >>> 10) + 1;

		// -----------
		// should not exceed the long-mask(4,294,967,295)
		// -----------
		if (numBits + BIT_INDEX_MASK > LONG_MASK) {
			throw new ArithmeticException("bits of given sequence exceed the supported range, sequence: " + src);
		}

		// -----------
		// find how many len, e.g: numBits = 30
		// 30 + 31 = 61, 61 >>> 5 = 1
		// -----------
		int wordsInUse = (int) (numBits + BIT_INDEX_MASK) >>> ADDRESS_BITS_PER_WORD;
		int[] words = new int[wordsInUse];

		// -----------
		// Process first (potentially short) digit group
		// e.g: given sequence length = 22, which contains:
		// 8723154679516000794054
		// numBits = 74, len = 3, firstGroupLen = 4
		// -----------
		int firstGroupLen = numDigits % DIGITS_PER_INT[radix];

		// -----------
		// if given sequence len less than 9 digits,
		// -----------
		if (firstGroupLen == 0) {
			firstGroupLen = DIGITS_PER_INT[radix];
		}

		// -----------
		// parse first group and advance:
		// {8723}154679516000794054
		// -----------
		words[0] = c.parseInt(radix, from, from += firstGroupLen);
		if (words[0] < 0) {
			int f = from - firstGroupLen, t = from;
			throw new NumberFormatException("Illegal digits detected: " + c.markRange(f, t));
		}

		// -----------
		// Process remaining digit groups
		// -----------
		int superRadix = INT_RADIX[radix];
		int groupVal = 0;
		while (from < clen) {
			// -----------
			// parse next group and advance:
			// 8723{154679516}000794054
			// 8723154679516{000794054}
			// -----------
			groupVal = c.parseInt(radix, from, from += DIGITS_PER_INT[radix]);
			if (groupVal < 0) {
				int f = from - firstGroupLen, t = from;
				throw new NumberFormatException("Illegal digits detected: " + c.markRange(f, t));
			}

			words = multiplyAndAdd_Destructive(words, wordsInUse, superRadix, groupVal);
		}

		if (wordsInUse >= MAX_WORDS_LENGTH) {
			checkRange(words, wordsInUse);
		}
		wordsInUse = recalcWordsInUse(words, wordsInUse);
		return assignTo != null ? assign(assignTo, words, wordsInUse, sign)
				: of(words, wordsInUse, sign, Endian.LITTLE);
	}

	// ============
	// ============
	// ============

	public T of(BitSet bs) {
		return of(bs, DEFAULT_SIGNUM);
	}

	public abstract T of(BitSet bs, int sign);

	public abstract T of(BigInteger bi);

	public abstract T of(Bits b);

	public abstract T of(T t);

	// ============
	// ============
	// ============

	public T ofRandomSize(int size) {
		return ofRandomSize(size, DEFAULT_SIGNUM);
	}

	public T ofRandomSize(int size, int sign) {
		return ofRandomRange(0, size, sign);
	}

	public T ofRandomRange(int fromBit, int toBit) {
		return ofRandomRange(fromBit, toBit, DEFAULT_SIGNUM);
	}

	public T ofRandomRange(int fromBit, int toBit, int sign) {
		int[] words = randomWords(fromBit, toBit);
		return of(words, words.length, sign, Endian.LITTLE);
	}

	// ============
	// ============
	// ============

	public abstract T assign(T t, int n);

	public abstract T assign(T t, long n);

	public T assign(T t, int[] words, int wordsInUse) {
		return assign(t, words, wordsInUse, DEFAULT_SIGNUM);
	}

	public T assign(T t, int[] words, int wordsInUse, int sign) {
		return assign(t, words, wordsInUse, sign, Endian.LITTLE);
	}

	public abstract T assign(T t, int[] words, int wordsInUse, int sign, Endian order);

	public abstract T assign(T t, T n);

	public abstract T assign(T t, CharSequence cs, int radix);

	// ============
	// ============
	// ============

	public abstract int numberOfLeadingZeros(T t);

	public abstract int numberOfTrailingZeros(T t);

	// ============
	// ============
	// ============
	public abstract T shiftLeft(T t, int shift);

	public abstract T shiftRight(T t, int shift);

	public abstract T shiftRightUnsigned(T t, int shift);

	// ============
	// ============
	// ============

	public abstract T and(T t, byte n);

	public abstract T and(T t, int n);

	public abstract T and(T t, long n);

	public abstract T and(T t, BitSet bs);

	public abstract T and(T t, BigInteger bi);

	public abstract T and(T t, Bits b);

	public abstract T and(T t1, T t2);

	// ============
	// ============
	// ============

	public abstract T andNot(T t, byte n);

	public abstract T andNot(T t, int n);

	public abstract T andNot(T t, long n);

	public abstract T andNot(T t, BitSet bs);

	public abstract T andNot(T t, BigInteger bi);

	public abstract T andNot(T t, Bits b);

	public abstract T andNot(T t1, T t2);

	// ============
	// ============
	// ============

	public abstract T or(T t, byte n);

	public abstract T or(T t, int n);

	public abstract T or(T t, long n);

	public abstract T or(T t, BitSet bs);

	public abstract T or(T t, BigInteger bi);

	public abstract T or(T t, Bits b);

	public abstract T or(T t1, T t2);

	// ============
	// ============
	// ============

	public abstract T xor(T t, byte n);

	public abstract T xor(T t, int n);

	public abstract T xor(T t, long n);

	public abstract T xor(T t, BitSet bs);

	public abstract T xor(T t, BigInteger bi);

	public abstract T xor(T t, Bits b);

	public abstract T xor(T t1, T t2);

	// ============
	// ============
	// ============

	public abstract T not(T t);

	// ============
	// ============
	// ============

	public byte byteValue(T t) {
		return (byte) intValue(t);
	}

	public short shortValue(T t) {
		return (short) intValue(t);
	}

	public abstract int intValue(T t);

	public abstract long longValue(T t);

	// ============
	// ============
	// ============

	public int[] words(T t) {
		return words(t, Endian.LITTLE);
	}

	public abstract int[] words(T t, Endian order);

	public String wordsString(T t) {
		return Arrays.toString(words(t));
	}

	public String wordsString(T t, Endian order) {
		return Arrays.toString(words(t, order));
	}

	public abstract int wordSize();

	public abstract int wordsInUse(T t);

	public int sizeOf(T t) {
		return wordsInUse(t) * wordSize();
	}

	public abstract int lengthOfBits(T t);

	public abstract int countOfBits(T t);

	// ============
	// ============
	// ============

	public boolean getMostSignificantBit(T t) {
		return getBit(t, sizeOf(t) - 1);
	}

	public abstract int getLowestSetIndex(T t);

	public abstract int getHighestSetIndex(T t);

	public abstract int getLowestClearIndex(T t);

	public abstract int getHighestClearIndex(T t);

	// ============
	// ============
	// ============

	public abstract boolean getBit(T t, int bitIndex);

	public abstract T getBits(T t, int fromBitIndex, int toBitIndex);

	// ============
	// ============
	// ============

	public abstract T setBit(T t, int bitIndex);

	public abstract T setBits(T t, int fromBitIndex, int toBitIndex);

	// ============
	// ============
	// ============

	public abstract T clearBit(T t, int bitIndex);

	public abstract T clearBits(T t, int fromBitIndex, int toBitIndex);

	// ============
	// ============
	// ============

	public abstract T flipBit(T t, int bitIndex);

	public abstract T flipBits(T t, int fromBitIndex, int toBitIndex);
	// ============
	// ============
	// ============

	public abstract Byte toByte(T t);

	public abstract Integer toInteger(T t);

	public abstract Long toLong(T t);

	public abstract BitSet toBitSet(T t);

	public abstract BigInteger toBigInteger(T t);

	public abstract Bits toBits(T t);
	// ============
	// ============
	// ============

	public String toIndexes(T t) {
		int[] words = words(t);
		int wordsInUse = wordsInUse(t);
		StringBuilder b = new StringBuilder();
		b.append('{');
		int i = nextSetBit(words, wordsInUse, 0);
		if (i != -1) {
			b.append(i);
			while (true) {
				if (++i < 0)
					break;
				if ((i = nextSetBit(words, wordsInUse, i)) < 0)
					break;
				int endOfRun = nextClearBit(words, wordsInUse, i);
				do {
					b.append(", ").append(i);
				} while (++i != endOfRun);
			}
		}

		b.append('}');
		return b.toString();
	}

	public String toBinary(T t) {
		return toBinary(t, wordSize());
	}

	public String toBinary(T t, int binarySize) {
		return toBinary(t, binarySize, false);
	}

	public String toBinary(T t, int binarySize, boolean includeLeadingZeros) {
		return toBinary(t, binarySize, includeLeadingZeros, false);
	}

	public String toBinary(T t, int binarySize, boolean includeLeadingZeros, boolean readable) {
		return toBinary(t, binarySize, includeLeadingZeros, readable, Byte.SIZE);
	}

	public String toBinary(T t, int binarySize, boolean includeLeadingZeros, boolean readable, int division) {
		return toBinary(t, binarySize, includeLeadingZeros, readable, division, '_');
	}

	public String toBinary(T t, int binarySize, boolean includeLeadingZeros, boolean readable, int division,
			char divider) {
		int[] words = words(t);
		return toBinary(words, words.length, binarySize, includeLeadingZeros, readable, division, divider).toString();
	}

	// ============
	// ============
	// ============
	public abstract int compare(T a, T b);
	// ============
	// ============
	// ============

	public abstract int nextSetBit(T t, int offset);

	public abstract int nextClearBit(T t, int offset);

	public abstract int previousSetBit(T t, int offset);

	public abstract int previousClearBit(T t, int offset);
	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	/**
	 * e.g: index 33, return wordIndex = 1 (33 is in second word)
	 */
	public static int wordIndex(int bitIndex) {
		return bitIndex >> ADDRESS_BITS_PER_WORD;
	}

	/**
	 * e.g: index 33, return wordsCount = 2 (33 is in second word)
	 */
	public static int wordsCount(int bitIndex) {
		return wordIndex(bitIndex) + 1;
	}

	// ============
	// ============
	// ============

	/**
	 * initial new words-array based on given number-of-bits
	 */
	public static int[] allocateBySize(int number_of_bits) {
		return new int[wordIndex(number_of_bits - 1) + 1];
	}

	// ============
	// ============
	// ============

	/**
	 * Every public method must preserve these invariants.
	 */
	public static void checkInvariants(int[] words, int wordsInUse) {
		if (wordsInUse > words.length || wordsInUse <= 0) {
			throw new IllegalStateException(
					String.format("wordsInUse(%d) > words.length(%d) ||  wordsInUse <= 0", wordsInUse, words.length));
		}
		checkRange(words, wordsInUse);
	}

	public static void checkBounds(int lowerBound, int upperBound) {
		if (lowerBound < 1) {
			throw new IllegalArgumentException(String.format("lowerBound(%d) < 1, %s", lowerBound));
		} else if (upperBound > MAX_WORDS_LENGTH) {
			throw new IllegalArgumentException(
					String.format("upperBound(%d) > MAX_WORDS_LENGTH(%d)", upperBound, MAX_WORDS_LENGTH));
		} else if (lowerBound > upperBound) {
			throw new IllegalArgumentException(
					String.format("lowerBound(%d) > upperBound(%d)", lowerBound, upperBound));
		}
	}

	/**
	 * Throws an {@code ArithmeticException} if the wordsInUse would be out of the
	 * supported range.
	 *
	 * @throws ArithmeticException if exceeds the supported range.
	 */
	public static void checkRange(int[] words, int wordsInUse) {
		if (wordsInUse > MAX_WORDS_LENGTH || wordsInUse == MAX_WORDS_LENGTH && words[0] < 0) {
			throw new ArithmeticException(String.format(
					"wordsInUse(%d) > MAX_WORDS_LENGTH(%d) || wordsInUse == MAX_WORDS_LENGTH && words[0](%d) < 0",
					wordsInUse, MAX_WORDS_LENGTH, words[0]));
		}
	}

	static int checkSign(int sign) {
		if (sign != 1 && sign != -1) {
			throw new IllegalArgumentException(sign + "");
		}
		return sign;
	}

	static int checkWordsInUse(int wordsInUse) {
		if (wordsInUse < 1) {
			throw new IllegalArgumentException(wordsInUse + "");
		}
		return wordsInUse;
	}

	static int[] checkWords(int[] words) {
		if (words.length == 0) {
			throw new IllegalArgumentException(words.length + "");
		}
		return words;
	}

	/**
	 * Ensures that the BitSet can hold enough words.
	 * 
	 * @param wordsRequired the minimum acceptable number of words.
	 */
	public static int[] ensureCapacity(int[] words, int wordsRequired) {
		if (words.length < wordsRequired) {
			// Allocate larger of doubled size or required size
			int request = Math.max(2 * words.length, wordsRequired);
			words = Arrays.copyOf(words, request);
		}
		return words;
	}

	// ============
	// ============
	// ============

	public static boolean isFlagged(int flags, int f) {
		return (flags & f) == f;
	}

	public static boolean isZero(int[] words, int wordsInUse) {
		return wordsInUse == 1 && words[0] == 0;
	}

	public static boolean isZero(int[] words, int wordsInUse, Endian order) {
		if (order.isLittle()) {
			return isZero(words, wordsInUse);
		}
		return wordsInUse == 1 && words[wordsInUse - 1] == 0;
	}

	// ============
	// ============
	// ============

	public abstract boolean isMagnitudeBased();

	public boolean isZero(T t) {
		return compare(t, ZERO()) == 0;
	}

	public boolean isFull(T t) {
		return countOfBits(t) == sizeOf(t);
	}

	public boolean isEmpty(T t) {
		return lengthOfBits(t) == 0;
	}

	// ==================
	// ================== iteration
	// ==================

	/**
	 * iterate over all bits, include leading zero-bits based on current
	 * {@link #wordsInUse()}
	 * 
	 * <br>
	 * <br>
	 * {@link BitsIterator#next()} will return next <b>bit-state</b><br>
	 * e.g: ...1000101, first -> 1, second -> 0, third -> 1 ..etc
	 */
	public BitsIterator iterator(T t) {
		if (isMagnitudeBased()) {
			return new AbstractMagnitudeBitsIterator<T>(this, t) {
				int wordIndex;

				@Override
				void init() {
					// nothing
				}

				@Override
				public boolean hasNext() {
					return bitIndex < size;
				}

				@Override
				public Integer next() {
					// ------------------
					// find current bit belongs to which word
					// ------------------
					wordIndex = wordIndex();

					// ------------------
					// e.g: wordIndex = 1, bitIndex = 33 which equals to 1 after-round :
					// 000000000000000000000000000011{0}0
					// left-shift 1 by bitIndex and apply AND to find if bitIndex 33 is set or not
					//
					// left-shift:
					// 00000000000000000000000000000001 << bitIndex(33)
					// =================================
					// 00000000000000000000000000000010
					//
					// apply AND:
					// 00000000000000000000000000001100
					// 00000000000000000000000000000010
					// =================================
					// 00000000000000000000000000000000, 33rd bitIndex is clear
					// ------------------
					return (wordIndex < wordsInUse) && ((words[wordIndex] & (1 << bitIndex++)) != 0) ? 1 : 0;
				}

				@Override
				public int bitIndex() {
					return bitIndex - 1;
				}
			};
		}

		// ==============
		// ============== Primitive
		// ==============

		return new AbstractPrimitiveBitsIterator<T>(this, t) {
			@Override
			void init() {
				// nothing
			}

			@Override
			public boolean hasNext() {
				return bitIndex < size;
			}

			@Override
			public Integer next() {
				return u.nextSetBit(t, bitIndex++) != -1 ? 1 : 0;
			}

			@Override
			public int bitIndex() {
				return bitIndex - 1;
			}
		};

	}

	/**
	 * @see #nextSetBit(int)
	 */
	public BitsIterator nextSetIterator(T t) {
		if (isMagnitudeBased()) {
			return new AbstractMagnitudeBitsIterator<T>(this, t) {

				@Override
				void init() {
					next = nextSetBit(words, wordsInUse, 0);
				}

				@Override
				public boolean hasNext() {
					return next != -1;
				}

				@Override
				public Integer next() {
					bitIndex = next;
					next = nextSetBit(words, wordsInUse, next + 1);
					return bitIndex;
				}
			};
		}

		// ==============
		// ============== Primitive
		// ==============

		return new AbstractPrimitiveBitsIterator<T>(this, t) {
			@Override
			void init() {
				next = u.nextSetBit(t, 0);
			}

			@Override
			public boolean hasNext() {
				return next != -1;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = u.nextSetBit(t, next + 1);
				return bitIndex;
			}

		};
	}

	/**
	 * @see {@link #nextClearBit(int)}
	 */
	public BitsIterator nextClearIterator(T t) {
		if (isMagnitudeBased()) {
			return new AbstractMagnitudeBitsIterator<T>(this, t) {
				@Override
				void init() {
					next = nextClearBit(words, wordsInUse, 0);
				}

				@Override
				public boolean hasNext() {
					return next != -1 && next < size;
				}

				@Override
				public Integer next() {
					bitIndex = next;
					next = nextClearBit(words, wordsInUse, next + 1);
					return bitIndex;
				}

			};
		}

		// ==============
		// ============== Primitive
		// ==============

		return new AbstractPrimitiveBitsIterator<T>(this, t) {
			@Override
			void init() {
				next = u.nextClearBit(t, 0);
			}

			@Override
			public boolean hasNext() {
				return next != -1 && next < size;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = u.nextClearBit(t, next + 1);
				return bitIndex;
			}

		};
	}

	/**
	 * @see #previousSetBit(int)
	 */
	public BitsIterator previousSetIterator(T t) {
		if (isMagnitudeBased()) {
			return new AbstractMagnitudeBitsIterator<T>(this, t) {
				@Override
				void init() {
					next = previousSetBit(words, wordsInUse, length, size - 1);
				}

				@Override
				public boolean hasNext() {
					return next >= 0;
				}

				@Override
				public Integer next() {
					bitIndex = next;
					next = previousSetBit(words, wordsInUse, length, next - 1);
					return bitIndex;
				}
			};
		}
		// ==============
		// ============== Primitive
		// ==============

		return new AbstractPrimitiveBitsIterator<T>(this, t) {
			@Override
			void init() {
				next = u.previousSetBit(t, size - 1);
			}

			@Override
			public boolean hasNext() {
				return next >= 0;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = u.previousSetBit(t, next - 1);
				return bitIndex;
			}

		};
	}

	/**
	 * @see #previousClearBit(int)
	 */
	public BitsIterator previousClearIterator(T t) {
		if (isMagnitudeBased()) {
			return new AbstractMagnitudeBitsIterator<T>(this, t) {
				@Override
				void init() {
					next = previousClearBit(words, wordsInUse, size - 1);
				}

				@Override
				public boolean hasNext() {
					return next >= 0;
				}

				@Override
				public Integer next() {
					bitIndex = next;
					next = previousClearBit(words, wordsInUse, next - 1);
					return bitIndex;
				}
			};
		}

		// ==============
		// ============== Primitive
		// ==============

		return new AbstractPrimitiveBitsIterator<T>(this, t) {
			@Override
			void init() {
				next = u.previousClearBit(t, size - 1);
			}

			@Override
			public boolean hasNext() {
				return next >= 0;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = u.previousClearBit(t, next - 1);
				return bitIndex;
			}

		};
	}

	/**
	 * @see Bits#nextSetBit(int)
	 * 
	 * @param words little-endian
	 */
	public static int nextSetBit(int[] words, int wordsInUse, int offset) {
		// return -1 if out the range
		if (offset < 0) {
			return -1;
		}
		int wordIndex = wordIndex(offset);
		// return -1 if out the range
		if (wordIndex >= wordsInUse) {
			return -1;
		}
		// -------------
		// case(1): words-in-use = 1, word-0 is empty
		// -------------
		// case(2): words-in-use = 1, word-0 has some,
		// to find a set-bit from given offset, we need to dismiss any
		// previous existing set-bits, e.g: if offset = 4 and word-0 = ..01101110, shift
		// the mask by offset and apply AND operator to word-0:
		// ..01101110
		// ..11110000 (after shift by 4)
		// --------
		// ..01100000
		// now we can look clearly into only whatever after given offset
		// for very first time, this is the first word to check it up
		// -------------
		// case(3): words-in-use >= 2, word-0 is empty, word-1 has some
		// for this case, word will be zero for very first time since offset is pointing
		// to word-0, which is empty
		// -------------
		// case(4): words-in-use >= 2, all has some
		// -------------
		int word = words[wordIndex] & (BITS_WORD_MASK << offset);
		while (true) {
			// -------------
			// case(2): word will be > 0, so we need to look into only the
			// trailing-zeros for the result
			// -------------
			// case(3): will skip this for first loop, second loop will detect something on
			// word-1, will find the result by trailing-zeros, and we need to include how
			// many bits been before this bit-index
			// -------------
			// case(4): same as case(3)
			// -------------
			if (word != 0) {
				return (wordIndex * Integer.SIZE) + Integer.numberOfTrailingZeros(word);
			}
			// -------------
			// case(1): is last word, below will be break it with no result
			// -------------
			// case(3): increment and new loop
			// -------------
			if (++wordIndex == wordsInUse) {
				return -1;
			}
			word = words[wordIndex];
		}
	}

	/**
	 * {@link Bits#nextClearBit(int)}
	 * 
	 * @param words little-endian
	 */
	public static int nextClearBit(int[] words, int wordsInUse, int offset) {
		if (offset < 0)
			return -1;
		int wordIndex = wordIndex(offset);
		if (wordIndex >= wordsInUse) {
			return offset;
		}
		// this works exactly like what been documented in nextSetBit, the only 2
		// differences are: since we will be looking into clear-bits, we don't have
		// tools to count trailing-ones, so will apply NOT and count trailing-zeros,
		// e.g: offset is 3, and words-in-use = 1
		// ..01101110
		// ..11110000 (after shift by 3)
		// --------
		// ..01100000
		// can't look clearly to find a result, so will flip all bits:
		// -------------
		// ..01101110
		// ..10010001 (after NOT)
		// ..11110000 (after shift by 3)
		// --------
		// ..10010000
		// now it is clear if we look again into ones only by using trailing-zeros for
		// results
		// ---------
		// what if we have zero on word-0 and offset is zero?, will clearly the idea
		// will be looking into ones, so e.g:
		// word-0 = 0, and offset = 0,
		// word = ..1111 (-1), first if-block inside the loop will be executed, number
		// of trailing-zeros are 0, so first result is correct
		// next, offset = 1, word = ..1110 (-2), trailing-zeros = 1 ..etc
		// ---------
		int word = ~words[wordIndex] & (BITS_WORD_MASK << offset);
		while (true) {
			if (word != 0) {
				return (wordIndex * Integer.SIZE) + Integer.numberOfTrailingZeros(word);
			}
			// ---------
			// the second difference in below algorithm is below block, since we are looking
			// into zeros for a vector of bits, it is always infinite amount of zeros after
			// last word, and according to above flip technique, at some point we will not
			// detect any zeros, it could be last word like 1111.., so the next zero is
			// outside this word
			if (++wordIndex == wordsInUse) {
				return wordsInUse * Integer.SIZE;
			}
			word = ~words[wordIndex];
		}
	}

	/**
	 * {@link Bits#previousSetBit(int)}
	 * 
	 * @param words little-endian
	 */
	public static int previousSetBit(int[] words, int wordsInUse, int length, int offset) {
		// return -1 if out the range
		if (offset < 0) {
			return -1;
		}
		int wordIndex = wordIndex(offset);
		// if out the range, return last known set-bit, or -1 if non-set
		if (wordIndex >= wordsInUse) {
			return length - 1;
		}
		// -------------
		// the idea here is same as documented in nextSetBit, but with backward
		// look
		// -------------
		// e.g: word-0 = ..10110, offset = 30
		// 1001..0010110
		// 1111..1111111 (mask)
		// as usual, the mask will be used to keep only the part we are interested
		// about, so will shift it to keep the part from right side only since this is
		// backward look
		// -------------
		// the code -(offset + 1) equals to (-31), in positive form
		// equals (1) which came from (31 - offset), so shift right by 1, if for
		// example, offset = (21) -> negative-form(-22) -> positive-form(10), 31 - 21 =
		// 10
		// -------------
		// so above will be
		// 1001..0010110
		// 0111..1111111 (after shifting right by -31)
		// -------
		// 0001..0010110 the result is clear by using leading-zeros
		// -------------
		int word = words[wordIndex] & (BITS_WORD_MASK >>> -(offset + 1));
		while (true) {
			// leading-zeros are count, turn the result into index by:
			// ((Integer.SIZE(32) - 1) - leading-zeros-count(3)) that equals 28
			// include word-1 and beyond as usual by multiply wordIdex in Integer.SIZE, but
			// since we are looking backward, the wordIndex should not be 0, that will kill
			// the backward look, so will do (wordIndex + 1) * Integer.SIZE
			if (word != 0) {
				return (wordIndex + 1) * Integer.SIZE - 1 - Integer.numberOfLeadingZeros(word);
			}
			// it is backward look, reverse
			if (wordIndex-- == 0) {
				return -1;
			}
			word = words[wordIndex];
		}
	}

	/**
	 * {@link Bits#previousClearBit(int)}
	 * 
	 * @param words little-endian
	 */
	public static int previousClearBit(int[] words, int wordsInUse, int offset) {
		if (offset < 0) {
			return -1;
		}
		int wordIndex = wordIndex(offset);
		if (wordIndex >= wordsInUse) {
			return offset;
		}
		// --------------
		// --------------
		// the idea here is merge between what documented in nextClearBit and
		// previousSetBit
		// --------------
		// --------------
		int word = ~words[wordIndex] & (BITS_WORD_MASK >>> -(offset + 1));
		while (true) {
			if (word != 0) {
				return (wordIndex + 1) * Integer.SIZE - 1 - Integer.numberOfLeadingZeros(word);
			}
			if (wordIndex-- == 0) {
				return -1;
			}
			word = ~words[wordIndex];
		}
	}

	public static int getLowestSet(int[] words, int wordsInUse) {
		// --------------
		// e.g: search from lowest-significant-word
		// --------------
		for (int i = 0; i < wordsInUse; i++) {
			if (words[i] != 0) {
				// --------------
				// e.g: ..01000100, training-zeros = 2, plus number of bits of previous words (i
				// << 5)
				// --------------
				return (i << Utils.ADDRESS_BITS_PER_WORD) + Integer.numberOfTrailingZeros(words[i]);
			}
		}
		return -1;
	}

	public static int getHighestSet(int[] words, int wordsInUse) {
		for (int i = wordsInUse - 1; i >= 0; i--) {
			if (words[i] != 0) {
				// --------------
				// e.g: 01000100.., leading-zeros = 1, flip the count, 32 - 1 = 31, turn it into
				// index by 31 - 1 = 30, plus number of bits of previous words (i << 5)
				// --------------
				return (i << Utils.ADDRESS_BITS_PER_WORD) + (Integer.SIZE - Integer.numberOfLeadingZeros(words[i]) - 1);
			}
		}
		return -1;
	}

	public static int[] get(int[] words, int wordsInUse, int targetWords, int fromIndex, int toIndex) {
		int[] result_words = Utils.allocateBySize(toIndex - fromIndex);
		int sourceIndex = Utils.wordIndex(fromIndex);
		boolean wordAligned = ((fromIndex & Utils.BIT_INDEX_MASK) == 0);

		// ---------------
		// Process all words but the last word
		// ---------------
		for (int i = 0; i < targetWords - 1; i++, sourceIndex++) {
			result_words[i] = wordAligned ? words[sourceIndex]
					: (words[sourceIndex] >>> fromIndex) | (words[sourceIndex + 1] << -fromIndex);
		}
		// ---------------
		// Process the last word
		// ---------------
		int lastWordMask = Utils.BITS_WORD_MASK >>> -toIndex;
		result_words[targetWords - 1] = ((toIndex - 1) & Utils.BIT_INDEX_MASK) < (fromIndex & Utils.BIT_INDEX_MASK)
				? /* straddles source words */
				((words[sourceIndex] >>> fromIndex) | (words[sourceIndex + 1] & lastWordMask) << -fromIndex)
				: ((words[sourceIndex] & lastWordMask) >>> fromIndex);
		return result_words;
	}

	public static int[] set(int[] words, int wordsInUse, int fromIndex, int toIndex) {
		int startWordIndex = Utils.wordIndex(fromIndex);
		int endWordIndex = Utils.wordIndex(toIndex - 1);
		// ------------ expend
		int wordsRequired = endWordIndex + 1;
		if (wordsInUse < wordsRequired) {
			words = Utils.ensureCapacity(words, wordsRequired);
			wordsInUse = wordsRequired;
		}
		// ------------
		int firstWordMask = Utils.BITS_WORD_MASK << fromIndex;
		int lastWordMask = Utils.BITS_WORD_MASK >>> -toIndex;
		if (startWordIndex == endWordIndex) {
			// ---------------
			// Case 1: One word
			// ---------------
			words[startWordIndex] |= (firstWordMask & lastWordMask);
		} else {
			// ---------------
			// Case 2: Multiple words
			// Handle first word
			// ---------------
			words[startWordIndex] |= firstWordMask;
			// ---------------
			// Handle intermediate words, if any
			// ---------------
			for (int i = startWordIndex + 1; i < endWordIndex; i++) {
				words[i] |= Utils.BITS_WORD_MASK;
			}
			// ---------------
			// Handle last word
			// ---------------
			words[endWordIndex] |= lastWordMask;
		}
		return words;
	}

	public static int[] clear(int[] words, int wordsInUse, int fromIndex, int toIndex) {
		int startWordIndex = Utils.wordIndex(fromIndex);
		if (startWordIndex >= wordsInUse)
			return words;

		int endWordIndex = Utils.wordIndex(toIndex - 1);
		if (endWordIndex >= wordsInUse) {
			toIndex = lengthOfBits(words, wordsInUse);
			endWordIndex = wordsInUse - 1;
		}
		int firstWordMask = Utils.BITS_WORD_MASK << fromIndex;
		int lastWordMask = Utils.BITS_WORD_MASK >>> -toIndex;
		if (startWordIndex == endWordIndex) {
			// ---------------
			// Case 1: One word
			// ---------------
			words[startWordIndex] &= ~(firstWordMask & lastWordMask);
		} else {
			// ---------------
			// Case 2: Multiple words
			// Handle first word
			// ---------------
			words[startWordIndex] &= ~firstWordMask;
			// ---------------
			// Handle intermediate words, if any
			for (int i = startWordIndex + 1; i < endWordIndex; i++) {
				words[i] = 0;
			}
			// ---------------
			// Handle last word
			// ---------------
			words[endWordIndex] &= ~lastWordMask;
		}
		return words;
	}

	public static int[] flip(int[] words, int wordsInUse, int fromBitIndex, int toBitIndex) {
		if (fromBitIndex == toBitIndex) {
			return words;
		}
		Check.range(fromBitIndex, toBitIndex);

		int startWordIndex = Utils.wordIndex(fromBitIndex);
		int endWordIndex = Utils.wordIndex(toBitIndex - 1);
		// ------------ expend
		int wordsRequired = endWordIndex + 1;
		if (wordsInUse < wordsRequired) {
			words = Utils.ensureCapacity(words, wordsRequired);
			wordsInUse = wordsRequired;
		}
		// ------------
		int firstWordMask = Utils.BITS_WORD_MASK << fromBitIndex;
		int lastWordMask = Utils.BITS_WORD_MASK >>> -toBitIndex;
		if (startWordIndex == endWordIndex) {
			// ---------------
			// Case 1: One word
			// ---------------
			words[startWordIndex] ^= (firstWordMask & lastWordMask);
		} else {
			// ---------------
			// Case 2: Multiple words
			// Handle first word
			// ---------------
			words[startWordIndex] ^= firstWordMask;

			// Handle intermediate words, if any
			for (int i = startWordIndex + 1; i < endWordIndex; i++)
				words[i] ^= Utils.BITS_WORD_MASK;
			// ---------------
			// Handle last word
			// ---------------
			words[endWordIndex] ^= lastWordMask;
		}
		return words;
	}

	// ============
	// ============
	// ============

	/**
	 * @see #randomWords(int, int, Endian)
	 */
	public static int[] randomWords(int bits_size) {
		return randomWords(0, bits_size);
	}

	/**
	 * @see #randomWords(int, int, Endian)
	 */
	public static int[] randomWords(int fromBit, int toBit) {
		return randomWords(fromBit, toBit, Endian.LITTLE);
	}

	/**
	 * generate random words-array <br>
	 */
	public static int[] randomWords(int fromBit, int toBit, Endian order) {
		Check.range(fromBit, toBit);
		int wordsInUse = toBit >>> ADDRESS_BITS_PER_WORD;
		wordsInUse += (toBit & BIT_INDEX_MASK) > 0 ? 1 : 0;
		final int[] words = new int[wordsInUse];

		// ---------------
		int wordIndex = 0;
		while (fromBit < toBit) {
			if (Digits.RANDOM.nextBoolean()) {
				wordIndex = fromBit >>> ADDRESS_BITS_PER_WORD;
				words[wordIndex] |= (1 << fromBit);
			}
			fromBit++;
		}

		if (words[wordsInUse - 1] == 0) {
			words[wordsInUse - 1] |= (1 << toBit);
		}
		return order.isLittle() ? words : Lang.reverse.in(words, words.length);
	}

	// ============
	// ============
	// ============

	/**
	 * skip trailing zeros<br>
	 * e.g: {7, 3, 12, 0, 0, 0}, wordsInUse = 6 -> return 3
	 */
	public static int recalcWordsInUse(int[] words, int wordsInUse) {
		int i;
		for (i = wordsInUse - 1; i >= 0; i--) {
			if (words[i] != 0) {
				break;
			}
		}
		// i is index-level, turn into count-level
		wordsInUse = i + 1;
		return wordsInUse == 0 ? 1 : wordsInUse;
	}

	public static int recalcWordsInUse(int[] words, int wordsInUse, Endian order) {
		if (order.isLittle()) {
			return recalcWordsInUse(words, wordsInUse);
		}
		int i = words.length - wordsInUse - 1;
		for (i = words.length - wordsInUse - 1; i < words.length; i++) {
			if (words[i] != 0) {
				break;
			}
		}
		// i is index-level, flip it
		wordsInUse = words.length - i;
		return wordsInUse == 0 ? 1 : wordsInUse;
	}

	/**
	 * set words out of wordsInUse range to 0 in {@link Endian#LITTLE} order, e.g:
	 * [1,2,3,4], wordsInUse = 2 -> [1,2,0,0]
	 */
	public static int[] cleanUp(int[] words, int wordsInUse) {
		for (int i = words.length - 1; i >= wordsInUse; i--) {
			words[i] = 0;
		}
		return words;
	}

	/**
	 * set words out of wordsInUse range to 0 in big-endian order, e.g: [1,2,3,4],
	 * wordsInUse = 2 -> [0,0,3,4]
	 */
	public static int[] cleanUp(int[] words, int wordsInUse, Endian order) {
		if (order.isLittle()) {
			return cleanUp(words, wordsInUse);
		}
		for (int i = 0; i < words.length - wordsInUse; i++) {
			words[i] = 0;
		}
		return words;
	}

	// ============
	// ============
	// ============

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public static Chars toBinary(int[] words, int wordsInUse) {
		return toBinary(words, wordsInUse, Integer.SIZE);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public static Chars toBinary(int[] words, int wordsInUse, int binarySize) {
		return toBinary(words, wordsInUse, binarySize, false);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public static Chars toBinary(int[] words, int wordsInUse, int binarySize, boolean includeLeadingZeros) {
		return toBinary(words, wordsInUse, binarySize, includeLeadingZeros, false);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public static Chars toBinary(int[] words, int wordsInUse, int binarySize, boolean includeLeadingZeros,
			boolean readable) {
		return toBinary(words, wordsInUse, binarySize, includeLeadingZeros, readable, Byte.SIZE);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public static Chars toBinary(int[] words, int wordsInUse, int binarySize, boolean includeLeadingZeros,
			boolean readable, int division) {
		return toBinary(words, wordsInUse, binarySize, includeLeadingZeros, readable, division, '_');
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 * @default binarySize = {@link Integer#SIZE}
	 */
	public static Chars toBinary(int[] words, int wordsInUse, int binarySize, boolean includeLeadingZeros,
			boolean readable, int division, char divider) {
		if (binarySize <= 0 || binarySize % Byte.SIZE != 0) {
			if (binarySize != -1) {
				throw new IllegalArgumentException(String.format(
						"binarySize(%d) <= 0 || binarySize %% 8 != 0, binarySize must be: 8, 16, 24, 32.. etc",
						binarySize));
			}
		}

		// --------------
		// auto-detect, this will always include-leading-zeros
		// --------------
		if (binarySize == -1) {
			// --------------
			// use 8 as default
			// --------------
			binarySize = Byte.SIZE;
			int i = wordsInUse - 1;
			// --------------
			// find first most-significant non-zero word
			// --------------
			for (; i >= 0; i--) {
				if (words[i] != 0) {
					wordsInUse = i + 1;
					binarySize = Integer.SIZE - Integer.numberOfLeadingZeros(words[i]);
					final int missing = Digits.ints.headMissing(binarySize, division);
					binarySize += missing < division ? missing : 0;
					break;
				}
			}
			binarySize += Integer.SIZE * (wordsInUse - 1);
		}

		// --------------
		// zero
		// --------------
		if (isZero(words, wordsInUse)) {
			Chars c = Chars.of();
			binarySize = binarySize == -1 ? Byte.SIZE : binarySize;
			c = includeLeadingZeros ? c.repeat('0', binarySize) : c.append('0');
			return readable ? c.repeatAfterEach(divider, division) : c;
		}

		Chars c;
		if (binarySize <= Integer.SIZE) {
			// --------------
			// will try to inject, if failed, will consider injecting zeros only
			// --------------
			c = Chars.of().appendBinary(words[0], binarySize, includeLeadingZeros, readable, division, divider);
			if (!includeLeadingZeros && c.isEmpty()) {
				c = Chars.of().appendBinary(0, binarySize, true, readable, division, divider);
			}
			return c;
		}

		int fullWords = Digits.ints.headsCount(binarySize, Integer.SIZE);
		c = Chars.of();
		// --------------
		// skip last word to below so we can use include-leading-bits flag
		// --------------
		int i = 0;
		for (; i < wordsInUse - 1; i++) {
			c = c.insertBinary(0, words[i], Integer.SIZE, true, readable, division, divider);
			c = readable ? c.insert(0, divider) : c;
		}

		c = c.insertBinary(0, words[i], Integer.SIZE, includeLeadingZeros, readable, division, divider);
		int remain = fullWords - wordsInUse;
		if (remain > 0 && includeLeadingZeros) {
			Chars c2 = Chars.of().repeat('0', remain * Integer.SIZE);
			if (readable) {
				c2 = c2.repeatAfterEach(divider, division);
			}
			c = readable ? c.insert(0, '_').insert(0, c2) : c.insert(0, c2);
		}
		return c;
	}

	// ============
	// ============
	// ============

	/**
	 * @return decimal string representation of given {@link Bits}, if negative =
	 *         true, insert negative sign on index 0
	 */
	public static Chars toDecimal(Bits b, boolean negative) {
		if (b.isZero()) {
			return Chars.of('0');
		}
		int[] words = b.toIntegerArray();
		int wordsInUse = b.wordsInUse();
		// --------------
		// each word will produce 10 digits, and maybe 1 sign
		// --------------
		int top = wordsInUse * 10 + 1;
		final char[] buf = new char[top];
		Arrays.fill(buf, '0');
		while (true) {
			final int j = top;
			// toStringDiv
			// ---------------------------------------
			final int pow5 = 1_220_703_125, pow2 = 1 << 13;
			int nextq = 0;
			long rem = 0;
			for (int i = wordsInUse - 1; i > 0; i--) {
				rem = (rem << 32) + (words[i] & LONG_MASK);
				final int q = (int) (rem / pow5);
				rem = rem % pow5;
				words[i] = nextq | q >>> 13;
				nextq = q << 32 - 13;
			}
			rem = (rem << 32) + (words[0] & LONG_MASK);
			final int mod2 = words[0] & pow2 - 1;
			words[0] = nextq | (int) (rem / pow5 >>> 13);
			rem = rem % pow5;
			// Applies the Chinese Remainder Theorem.
			// -67*5^13 + 9983778*2^13 = 1
			final long pow10 = (long) pow5 * pow2;
			rem = (rem - pow5 * (mod2 - rem) % pow10 * 67) % pow10;
			if (rem < 0) {
				rem += pow10;
			}
			if (words[wordsInUse - 1] == 0 && wordsInUse > 1) {
				if (words[--wordsInUse - 1] == 0 && wordsInUse > 1) {
					--wordsInUse;
				}
			}
			// ---------------------------------------
			for (long tmp = rem; tmp > 0; tmp /= 10) {
				buf[--top] += tmp % 10;
			}
			if (wordsInUse == 1 && words[0] == 0) {
				break;
			} else {
				top = j - 13;
			}
		}
		if (negative) {
			buf[--top] = '-';
		}

		return Chars.of(new String(buf, top, buf.length - top));
	}

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============
//
//	// =============
//	// ============= short to byte[]
//	// =============
//
//	public static byte[] toByteArray(short n) {
//		return toByteArray(n, Endian.LITTLE);
//	}
//
//	public static byte[] toByteArray(short n, Endian out) {
//		return toByteArray(n, out, true);
//	}
//
//	public static byte[] toByteArray(short n, Endian out, boolean skipZeros) {
//		if (n == 0) {
//			return new byte[] { 0 };
//		}
//		final int parts = 2;
//		final int last = skipZeros ? partsInUse(n, Byte.SIZE) : parts;
//		final int arr_out_len = parts - (parts - last);
//		final byte[] arr_out = new byte[arr_out_len];
//		int index = 0;
//
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (byte) n;
//			n >>>= Byte.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= int to byte[]
//	// =============
//
//	public static byte[] toByteArray(int n) {
//		return toByteArray(n, Endian.LITTLE);
//	}
//
//	public static byte[] toByteArray(int n, Endian out) {
//		return toByteArray(n, out, true);
//	}
//
//	public static byte[] toByteArray(int n, Endian out, boolean skipZeros) {
//		if (n == 0) {
//			return new byte[] { 0 };
//		}
//		final int parts = 4;
//		final int last = skipZeros ? partsInUse(n, Byte.SIZE) : parts;
//		final int arr_out_len = parts - (parts - last);
//		final byte[] arr_out = new byte[arr_out_len];
//		int index = 0;
//
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (byte) n;
//			n >>>= Byte.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= long to byte[]
//	// =============
//
//	public static byte[] toByteArray(long n) {
//		return toByteArray(n, Endian.LITTLE);
//	}
//
//	public static byte[] toByteArray(long n, Endian out) {
//		return toByteArray(n, out, true);
//	}
//
//	public static byte[] toByteArray(long n, Endian out, boolean skipZeros) {
//		if (n == 0) {
//			return new byte[] { 0 };
//		}
//		final int parts = 8;
//		final int last = skipZeros ? partsInUse(n, Byte.SIZE) : parts;
//		final int arr_out_len = parts - (parts - last);
//		final byte[] arr_out = new byte[arr_out_len];
//		int index = 0;
//
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (byte) n;
//			n >>>= Byte.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= int to short[]
//	// =============
//
//	public static short[] toShortArray(int n) {
//		return toShortArray(n, Endian.LITTLE);
//	}
//
//	public static short[] toShortArray(int n, Endian out) {
//		return toShortArray(n, out, true);
//	}
//
//	public static short[] toShortArray(int n, Endian out, boolean skipZeros) {
//		if (n == 0) {
//			return new short[] { 0 };
//		}
//		final int parts = 2;
//		final int last = skipZeros ? partsInUse(n, Short.SIZE) : parts;
//		final int arr_out_len = parts - (parts - last);
//		final short[] arr_out = new short[arr_out_len];
//		int index = 0;
//
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (short) n;
//			n >>>= Short.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= long to short[]
//	// =============
//
//	public static short[] toShortArray(long n) {
//		return toShortArray(n, Endian.LITTLE);
//	}
//
//	public static short[] toShortArray(long n, Endian out) {
//		return toShortArray(n, out, true);
//	}
//
//	public static short[] toShortArray(long n, Endian out, boolean skipZeros) {
//		if (n == 0) {
//			return new short[] { 0 };
//		}
//		final int parts = 4;
//		final int last = skipZeros ? partsInUse(n, Short.SIZE) : parts;
//		final int arr_out_len = parts - (parts - last);
//		final short[] arr_out = new short[arr_out_len];
//		int index = 0;
//
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (short) n;
//			n >>>= Short.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= long to int[]
//	// =============
//
//	public static int[] toIntArray(long n) {
//		return toIntArray(n, Endian.LITTLE);
//	}
//
//	public static int[] toIntArray(long n, Endian out) {
//		return toIntArray(n, out, true);
//	}
//
//	public static int[] toIntArray(long n, Endian out, boolean skipZeros) {
//		if (n == 0) {
//			return new int[] { 0 };
//		}
//		final int parts = 2;
//		final int last = skipZeros ? partsInUse(n, Integer.SIZE) : parts;
//		final int arr_out_len = parts - (parts - last);
//		final int[] arr_out = new int[arr_out_len];
//		int index = 0;
//
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (int) n;
//			n >>>= Integer.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= short[] to byte[]
//	// =============
//
//	public static byte[] toByteArray(short[] arr) {
//		return toByteArray(arr, arr.length);
//	}
//
//	public static byte[] toByteArray(short[] arr, int len) {
//		return toByteArray(arr, len, Endian.LITTLE);
//	}
//
//	public static byte[] toByteArray(short[] arr, int len, Endian in) {
//		return toByteArray(arr, len, in, in);
//	}
//
//	public static byte[] toByteArray(short[] arr, int len, Endian in, Endian out) {
//		return toByteArray(arr, len, in, in, true);
//	}
//
//	public static byte[] toByteArray(short[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new byte[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 2;
//		final int last = partsInUse(arr[in.index(len - 1, len)], Byte.SIZE);
//		final int arr_out_len = len * parts - (parts - last);
//
//		// #change
//		final byte[] arr_out = new byte[arr_out_len];
//		// #change
//		short tmp = 0;
//		int index = 0;
//		for (int i = 0; i < len - 1; i++) {
//			tmp = arr[in.index(i, src_len)];
//			for (int j = 0; j < parts; j++) {
//				arr_out[out.index(index++, arr_out_len)] = (byte) tmp;
//				// #change
//				tmp >>>= Byte.SIZE;
//			}
//		}
//
//		// last
//		tmp = arr[in.index(len - 1, src_len)];
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (byte) tmp;
//			// #change
//			tmp >>>= Byte.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= int[] to byte[]
//	// =============
//
//	public static byte[] toByteArray(int[] arr) {
//		return toByteArray(arr, arr.length);
//	}
//
//	public static byte[] toByteArray(int[] arr, int len) {
//		return toByteArray(arr, len, Endian.LITTLE);
//	}
//
//	public static byte[] toByteArray(int[] arr, int len, Endian in) {
//		return toByteArray(arr, len, in, in);
//	}
//
//	public static byte[] toByteArray(int[] arr, int len, Endian in, Endian out) {
//		return toByteArray(arr, len, in, out, true);
//	}
//
//	public static byte[] toByteArray(int[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new byte[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 4;
//		final int last = partsInUse(arr[in.index(len - 1, len)], Byte.SIZE);
//		final int arr_out_len = len * parts - (parts - last);
//
//		// #change
//		final byte[] arr_out = new byte[arr_out_len];
//		// #change
//		int tmp = 0;
//		int index = 0;
//		for (int i = 0; i < len - 1; i++) {
//			tmp = arr[in.index(i, src_len)];
//			for (int j = 0; j < parts; j++) {
//				arr_out[out.index(index++, arr_out_len)] = (byte) tmp;
//				// #change
//				tmp >>>= Byte.SIZE;
//			}
//		}
//
//		// last
//		tmp = arr[in.index(len - 1, src_len)];
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (byte) tmp;
//			// #change
//			tmp >>>= Byte.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= long[] to byte[]
//	// =============
//
//	public static byte[] toByteArray(long[] arr) {
//		return toByteArray(arr, arr.length);
//	}
//
//	public static byte[] toByteArray(long[] arr, int len) {
//		return toByteArray(arr, len, Endian.LITTLE);
//	}
//
//	public static byte[] toByteArray(long[] arr, int len, Endian in) {
//		return toByteArray(arr, len, in, in);
//	}
//
//	public static byte[] toByteArray(long[] arr, int len, Endian in, Endian out) {
//		return toByteArray(arr, len, in, out, true);
//	}
//
//	public static byte[] toByteArray(long[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new byte[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 8;
//		final int last = partsInUse(arr[in.index(len - 1, len)], Byte.SIZE);
//		final int arr_out_len = len * parts - (parts - last);
//
//		// #change
//		final byte[] arr_out = new byte[arr_out_len];
//		// #change
//		long tmp = 0;
//		int index = 0;
//		for (int i = 0; i < len - 1; i++) {
//			tmp = arr[in.index(i, src_len)];
//			for (int j = 0; j < parts; j++) {
//				arr_out[out.index(index++, arr_out_len)] = (byte) tmp;
//				// #change
//				tmp >>>= Byte.SIZE;
//			}
//		}
//
//		// last
//		tmp = arr[in.index(len - 1, src_len)];
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (byte) tmp;
//			// #change
//			tmp >>>= Byte.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= byte[] to short[]
//	// =============
//
//	public static short[] toShortArray(byte[] arr) {
//		return toShortArray(arr, arr.length);
//	}
//
//	public static short[] toShortArray(byte[] arr, int len) {
//		return toShortArray(arr, len, Endian.LITTLE);
//	}
//
//	public static short[] toShortArray(byte[] arr, int len, Endian in) {
//		return toShortArray(arr, len, in, in);
//	}
//
//	public static short[] toShortArray(byte[] arr, int len, Endian in, Endian out) {
//		return toShortArray(arr, len, in, out, true);
//	}
//
//	public static short[] toShortArray(byte[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new short[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 2;
//		final int arr_out_len = (len + (parts - 1)) / parts;
//		// #change
//		final short[] arr_out = new short[arr_out_len];
//		// #change
//		short tmp = 0;
//		short mask = (1 << Byte.SIZE) - 1;
//		int index = 0;
//		for (int i = 0; i < arr_out_len; i++) {
//			// #change
//			tmp = (short) (arr[in.index(index++, src_len)] & mask);
//			for (int j = 1; j < parts && index < len; j++) {
//				// #change
//				tmp |= (((short) (arr[in.index(index++, src_len)] & mask)) << Byte.SIZE * j);
//			}
//			arr_out[out.index(i, arr_out_len)] |= tmp;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= int[] to short[]
//	// =============
//
//	public static short[] toShortArray(int[] arr) {
//		return toShortArray(arr, arr.length);
//	}
//
//	public static short[] toShortArray(int[] arr, int len) {
//		return toShortArray(arr, len, Endian.LITTLE);
//	}
//
//	public static short[] toShortArray(int[] arr, int len, Endian in) {
//		return toShortArray(arr, len, in, in);
//	}
//
//	public static short[] toShortArray(int[] arr, int len, Endian in, Endian out) {
//		return toShortArray(arr, len, in, out, true);
//	}
//
//	public static short[] toShortArray(int[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new short[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 2;
//		final int last = partsInUse(arr[in.index(len - 1, len)], Short.SIZE);
//		final int arr_out_len = len * parts - (parts - last);
//
//		// #change
//		final short[] arr_out = new short[arr_out_len];
//		// #change
//		int tmp = 0;
//		int index = 0;
//		for (int i = 0; i < len - 1; i++) {
//			tmp = arr[in.index(i, src_len)];
//			for (int j = 0; j < parts; j++) {
//				arr_out[out.index(index++, arr_out_len)] = (short) tmp;
//				// #change
//				tmp >>>= Short.SIZE;
//			}
//		}
//
//		// last
//		tmp = arr[in.index(len - 1, src_len)];
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (short) tmp;
//			// #change
//			tmp >>>= Short.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= long[] to short[]
//	// =============
//
//	public static short[] toShortArray(long[] arr) {
//		return toShortArray(arr, arr.length);
//	}
//
//	public static short[] toShortArray(long[] arr, int len) {
//		return toShortArray(arr, len, Endian.LITTLE);
//	}
//
//	public static short[] toShortArray(long[] arr, int len, Endian in) {
//		return toShortArray(arr, len, in, in);
//	}
//
//	public static short[] toShortArray(long[] arr, int len, Endian in, Endian out) {
//		return toShortArray(arr, len, in, out, true);
//	}
//
//	public static short[] toShortArray(long[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new short[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 4;
//		final int last = partsInUse(arr[in.index(len - 1, len)], Short.SIZE);
//		final int arr_out_len = len * parts - (parts - last);
//
//		// #change
//		final short[] arr_out = new short[arr_out_len];
//		// #change
//		long tmp = 0;
//		int index = 0;
//		for (int i = 0; i < len - 1; i++) {
//			tmp = arr[in.index(i, src_len)];
//			for (int j = 0; j < parts; j++) {
//				arr_out[out.index(index++, arr_out_len)] = (short) tmp;
//				// #change
//				tmp >>>= Short.SIZE;
//			}
//		}
//
//		// last
//		tmp = arr[in.index(len - 1, src_len)];
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (short) tmp;
//			// #change
//			tmp >>>= Short.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= byte[] to int[]
//	// =============
//
//	public static int[] toIntArray(byte[] arr) {
//		return toIntArray(arr, arr.length);
//	}
//
//	public static int[] toIntArray(byte[] arr, int len) {
//		return toIntArray(arr, len, Endian.LITTLE);
//	}
//
//	public static int[] toIntArray(byte[] arr, int len, Endian in) {
//		return toIntArray(arr, len, in, in);
//	}
//
//	public static int[] toIntArray(byte[] arr, int len, Endian in, Endian out) {
//		return toIntArray(arr, len, in, out, true);
//	}
//
//	public static int[] toIntArray(byte[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new int[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 4;
//		final int arr_out_len = (len + (parts - 1)) / parts;
//		// #change
//		final int[] arr_out = new int[arr_out_len];
//		// #change
//		int tmp = 0;
//		short mask = (1 << Byte.SIZE) - 1;
//		int index = 0;
//		for (int i = 0; i < arr_out_len; i++) {
//			// #change
//			tmp = arr[in.index(index++, src_len)] & mask;
//			for (int j = 1; j < parts && index < len; j++) {
//				// #change
//				tmp |= ((arr[in.index(index++, src_len)] & mask) << Byte.SIZE * j);
//			}
//			arr_out[out.index(i, arr_out_len)] |= tmp;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= short[] to int[]
//	// =============
//
//	public static int[] toIntArray(short[] arr) {
//		return toIntArray(arr, arr.length);
//	}
//
//	public static int[] toIntArray(short[] arr, int len) {
//		return toIntArray(arr, len, Endian.LITTLE);
//	}
//
//	public static int[] toIntArray(short[] arr, int len, Endian in) {
//		return toIntArray(arr, len, in, in);
//	}
//
//	public static int[] toIntArray(short[] arr, int len, Endian in, Endian out) {
//		return toIntArray(arr, len, in, out, true);
//	}
//
//	public static int[] toIntArray(short[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new int[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 2;
//		final int arr_out_len = (len + (parts - 1)) / parts;
//		// #change
//		final int[] arr_out = new int[arr_out_len];
//		// #change
//		int tmp = 0;
//		int mask = (1 << Short.SIZE) - 1;
//		int index = 0;
//		for (int i = 0; i < arr_out_len; i++) {
//			// #change
//			tmp = arr[in.index(index++, src_len)] & mask;
//			for (int j = 1; j < parts && index < len; j++) {
//				// #change
//				tmp |= ((arr[in.index(index++, src_len)] & mask) << Short.SIZE * j);
//			}
//			arr_out[out.index(i, arr_out_len)] |= tmp;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= long[] to int[]
//	// =============
//
//	public static int[] toIntArray(long[] arr) {
//		return toIntArray(arr, arr.length);
//	}
//
//	public static int[] toIntArray(long[] arr, int len) {
//		return toIntArray(arr, len, Endian.LITTLE);
//	}
//
//	public static int[] toIntArray(long[] arr, int len, Endian in) {
//		return toIntArray(arr, len, in, in);
//	}
//
//	public static int[] toIntArray(long[] arr, int len, Endian in, Endian out) {
//		return toIntArray(arr, len, in, out, true);
//	}
//
//	/**
//	 * @param arr
//	 * @param len
//	 * @param in
//	 * @param out
//	 * @param skipZeros (true by default), e.g: given [687, 876, 0, 0, 0], len = 5,
//	 *                  will skip the trailing/leading zeros according input order
//	 */
//	public static int[] toIntArray(long[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new int[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		int parts = 2;
//		final int last = partsInUse(arr[in.index(len - 1, len)], Integer.SIZE);
//		final int arr_out_len = len * parts - (parts - last);
//
//		// #change
//		final int[] arr_out = new int[arr_out_len];
//		// #change
//		long tmp = 0;
//		int index = 0;
//		for (int i = 0; i < len - 1; i++) {
//			tmp = arr[in.index(i, src_len)];
//			for (int j = 0; j < parts; j++) {
//				arr_out[out.index(index++, arr_out_len)] = (int) tmp;
//				// #change
//				tmp >>>= Integer.SIZE;
//			}
//		}
//
//		// last
//		tmp = arr[in.index(len - 1, src_len)];
//		for (int j = 0; j < last; j++) {
//			arr_out[out.index(index++, arr_out_len)] = (int) tmp;
//			// #change
//			tmp >>>= Integer.SIZE;
//		}
//		return arr_out;
//	}
//
//	// =============
//	// ============= byte[] to long[]
//	// =============
//
//	public static long[] toLongArray(byte[] arr) {
//		return toLongArray(arr, arr.length);
//	}
//
//	public static long[] toLongArray(byte[] arr, int len) {
//		return toLongArray(arr, len, Endian.LITTLE);
//	}
//
//	public static long[] toLongArray(byte[] arr, int len, Endian in) {
//		return toLongArray(arr, len, in, in);
//	}
//
//	public static long[] toLongArray(byte[] arr, int len, Endian in, Endian out) {
//		return toLongArray(arr, len, in, out, true);
//	}
//
//	public static long[] toLongArray(byte[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new long[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 8;
//		final int arr_out_len = (len + (parts - 1)) / parts;
//		// #change
//		final long[] arr_out = new long[arr_out_len];
//		// #change
//		long tmp = 0;
//		short mask = (1 << Byte.SIZE) - 1;
//		int index = 0;
//		for (int i = 0; i < arr_out_len; i++) {
//			// #change
//			tmp = arr[in.index(index++, src_len)] & mask;
//			for (int j = 1; j < parts && index < len; j++) {
//				// #change
//				tmp |= (((long) arr[in.index(index++, src_len)] & mask) << Byte.SIZE * j);
//			}
//			arr_out[out.index(i, arr_out_len)] |= tmp;
//		}
//
//		return arr_out;
//	}
//
//	// =============
//	// ============= short[] to long[]
//	// =============
//
//	public static long[] toLongArray(short[] arr) {
//		return toLongArray(arr, arr.length);
//	}
//
//	public static long[] toLongArray(short[] arr, int len) {
//		return toLongArray(arr, len, Endian.LITTLE);
//	}
//
//	public static long[] toLongArray(short[] arr, int len, Endian in) {
//		return toLongArray(arr, len, in, in);
//	}
//
//	public static long[] toLongArray(short[] arr, int len, Endian in, Endian out) {
//		return toLongArray(arr, len, in, out, true);
//	}
//
//	public static long[] toLongArray(short[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new long[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 4;
//		final int arr_out_len = (len + (parts - 1)) / parts;
//		// #change
//		final long[] arr_out = new long[arr_out_len];
//		// #change
//		long tmp = 0;
//		int mask = (1 << Short.SIZE) - 1;
//		int index = 0;
//		for (int i = 0; i < arr_out_len; i++) {
//			// #change
//			tmp = arr[in.index(index++, src_len)] & mask;
//			for (int j = 1; j < parts && index < len; j++) {
//				// #change
//				tmp |= (((long) arr[in.index(index++, src_len)] & mask) << Short.SIZE * j);
//			}
//			arr_out[out.index(i, arr_out_len)] |= tmp;
//		}
//
//		return arr_out;
//	}
//
//	// =============
//	// ============= int[] to long[]
//	// =============
//
//	public static long[] toLongArray(int[] arr) {
//		return toLongArray(arr, arr.length);
//	}
//
//	public static long[] toLongArray(int[] arr, int len) {
//		return toLongArray(arr, len, Endian.LITTLE);
//	}
//
//	public static long[] toLongArray(int[] arr, int len, Endian in) {
//		return toLongArray(arr, len, in, in);
//	}
//
//	public static long[] toLongArray(int[] arr, int len, Endian in, Endian out) {
//		return toLongArray(arr, len, in, out, true);
//	}
//
//	public static long[] toLongArray(int[] arr, int len, Endian in, Endian out, boolean skipZeros) {
//		if (len == 1 && arr[0] == 0) {
//			// #change
//			return new long[] { 0 };
//		}
//		final int src_len = len;
//		len = skipZeros ? in.isLittle() ? Lang.skipTrailingZeros(arr, len) : Lang.skipLeadingZeros(arr, len) : len;
//		// #change
//		final int parts = 2;
//		final int arr_out_len = (len + (parts - 1)) / parts;
//		// #change
//		final long[] arr_out = new long[arr_out_len];
//		// #change
//		long tmp = 0;
//		long mask = (1L << Integer.SIZE) - 1;
//		int index = 0;
//		for (int i = 0; i < arr_out_len; i++) {
//			// #change
//			tmp = arr[in.index(index++, src_len)] & mask;
//			for (int j = 1; j < parts && index < len; j++) {
//				// #change
//				tmp |= (((long) arr[in.index(index++, src_len)] & mask) << Integer.SIZE * j);
//			}
//			arr_out[out.index(i, arr_out_len)] |= tmp;
//		}
//
//		return arr_out;
//	}
//
	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	public static long toLong(int[] a) {
		if (a.length > 2)
			throw new IllegalStateException();
		return (a[1] & LONG_MASK) << Integer.SIZE | (int) (a[0] & LONG_MASK);
	}

	// ============
	// ============
	// ============

	/**
	 * @see #lengthOfBits(BitSet)
	 */
	public static int lengthOfBits(int[] words, int wordsInUse) {
		return ((wordsInUse - 1) << ADDRESS_BITS_PER_WORD) + i.lengthOfBits(words[wordsInUse - 1]);
	}

	/**
	 * @see #lengthOfBits(BitSet)
	 */
	public static int lengthOfBits(int[] words, int wordsInUse, Endian order) {
		// --------------
		// to find length, consider all words are in count, except most-significant
		// word, so e.g: wordsInUse = 5, we have 4 in count, which can be counted by
		// ((wordsInUse - 1) << ADDRESS_BITS_PER_WORD) = 128 bits in count
		// now find last
		// --------------
		return ((wordsInUse - 1) << ADDRESS_BITS_PER_WORD) + i.lengthOfBits(order.msb(words, wordsInUse));
	}

	/**
	 * 
	 * <pre>
	 * byte x = 127, forSize = Byte.SIZE, return 1
	 * int x = 127, forSize = Byte.SIZE, return 1
	 * int x = 127, forSize = Long.SIZE, return 1
	 * int x = 1<<16, forSize = Byte.SIZE, return 3
	 * int x = 1<<16, forSize = Short.SIZE, return 2
	 * int x = 1<<16, forSize = Integer.SIZE, return 1
	 * long x = 1L<<60, forSize = Byte.SIZE, return 8
	 * long x = -1L, forSize = Byte.SIZE, return 8
	 * long x = -1L, forSize = Short.SIZE, return 4
	 * </pre>
	 * 
	 * @return how many parts in use based on given size
	 */
	public static int partsInUse(long n, int forSize) {
		int parts = Long.SIZE / forSize;
		for (int i = 0; i < parts; i++) {
			n >>>= forSize;
			if (n == 0) {
				return i + 1;
			}
		}
		return parts;
	}

	/**
	 * @see #toIndexes(BitSet)
	 */
	public static String toIndexes(int n) {
		if (n == 0) {
			return "{}";
		}
		int highestSet = 0;
		int x = 1 << 31;
		for (int i = 0; i < 32; i++) {
			if ((n & (x >>> i)) != 0) {
				highestSet = 31 - i;
				break;
			}
		}
		String sHighestSet = String.valueOf(highestSet);
		String s = BitSet.valueOf(new long[] { n }).toString();
		int index = s.indexOf(sHighestSet);
		if (index < 0) {
			throw new IllegalStateException("input: " + n + ", sHighestSet: " + sHighestSet + ", bs: " + s);
		}

		return s.substring(0, index + sHighestSet.length()) + "}";
	}

	/**
	 * return random unsigned long
	 */
	public static long randomLongUnsigned() {
		long n = Digits.RANDOM.nextLong();
		return n < 0 ? -n : n;
	}

	/**
	 * assign words of assignment to words[]
	 */
	public static int[] assign(int[] words, long assignment) {
		int word1 = (int) (assignment >>> Integer.SIZE);
		int word0 = (int) (assignment & LONG_MASK);
		words[0] = word0;
		int wordsInUse = 1;
		if (word1 != 0) {
			words[1] = word1;
			wordsInUse = 2;
		}
		return cleanUp(words, wordsInUse);
	}

	// ============
	// ============
	// ============

	public static int[] negate(int[] words, int wordsInUse) {
		words[0] = ~words[0] + 1;
		for (int i = 1; i < wordsInUse; i++) {
			words[i] = ~words[i];
		}
		return words;
	}

	// ============
	// ============
	// ============

	/**
	 * Divides the first magnitude u[0..m) by v[0..n) and stores the resulting
	 * quotient in q. The remainder will be stored in u, so u will be destroyed. u[]
	 * must have room for an additional element, i.e. u[m] is a legal access.
	 *
	 * @param u The first magnitude array, the dividend.
	 * @param v The second magnitude array, the divisor.
	 * @param m The length of the first array.
	 * @param n The length of the second array.
	 * @param q An array of length at least n-m+1 where the quotient will be stored.
	 * @complexity O(m*n)
	 */
	// Hacker'sDelight's
	// //
	// Knuth's
	// Algorithm
	// D
	public static void divideMagnitudes(final int[] u, final int[] v, final int m, final int n, final int[] q) {
		final long b = 1L << Integer.SIZE; // Number base (32 bits).
		long qhat; // Estimated quotient digit.
		long rhat; // A remainder.
		long p; // Product of two digits.

		int s, i, j;
		long t, k;

		// Normalize by shifting v left just enough so that
		// its high-order bit is on, and shift u left the
		// same amount. We may have to append a high-order
		// digit on the dividend; we do that unconditionally.

		s = Integer.numberOfLeadingZeros(v[n - 1]);
		if (s > 0) // In Java (x<<32)==(x<<0) so...
		{
			for (i = n - 1; i > 0; i--)
				v[i] = (v[i] << s) | (v[i - 1] >>> Integer.SIZE - s);
			v[0] = v[0] << s;

			u[m] = u[m - 1] >>> Integer.SIZE - s;
			for (i = m - 1; i > 0; i--)
				u[i] = (u[i] << s) | (u[i - 1] >>> Integer.SIZE - s);
			u[0] = u[0] << s;
		}

		final long dh = v[n - 1] & LONG_MASK, dl = v[n - 2] & LONG_MASK, hbit = Long.MIN_VALUE;

		for (j = m - n; j >= 0; j--) // Main loop
		{
			// Compute estimate qhat of q[j].
			k = u[j + n] * b + (u[j + n - 1] & LONG_MASK); // Unsigned division is a pain in the ass! ='(
			qhat = (k >>> 1) / dh << 1;
			t = k - qhat * dh;
			if (t + hbit >= dh + hbit)
				qhat++; // qhat = (u[j+n]*b + u[j+n-1])/v[n-1];
			rhat = k - qhat * dh;

			while (qhat + hbit >= b + hbit || qhat * dl + hbit > b * rhat + (u[j + n - 2] & LONG_MASK) + hbit) // Unsigned
			// comparison.
			{
				qhat = qhat - 1;
				rhat = rhat + dh;
				if (rhat + hbit >= b + hbit)
					break;
			}

			// Multiply and subtract.
			k = 0;
			for (i = 0; i < n; i++) {
				p = qhat * (v[i] & LONG_MASK);
				t = (u[i + j] & LONG_MASK) - k - (p & LONG_MASK);
				u[i + j] = (int) t;
				k = (p >>> Integer.SIZE) - (t >> Integer.SIZE);
			}
			t = (u[j + n] & LONG_MASK) - k;
			u[j + n] = (int) t;

			q[j] = (int) qhat; // Store quotient digit. If we subtracted too much, add back.
			if (t < 0) {
				q[j] = q[j] - 1;
				k = 0;
				for (i = 0; i < n; i++) {
					t = (u[i + j] & LONG_MASK) + (v[i] & LONG_MASK) + k;
					u[i + j] = (int) t;
					k = t >>> Integer.SIZE; // >>
				}
				u[j + n] += (int) k;
			}
		}

		if (s > 0) {
			// Unnormalize v[].
			for (i = 0; i < n - 1; i++)
				v[i] = v[i] >>> s | v[i + 1] << Integer.SIZE - s;
			v[n - 1] >>>= s;

			// Unnormalize u[].
			for (i = 0; i < m; i++)
				u[i] = u[i] >>> s | u[i + 1] << Integer.SIZE - s;
			u[m] >>>= s;
		}
	}

	/**
	 * Multiply <b>mag</b> array times y in place, and add word z
	 * 
	 * @see BigInteger#destructiveMulAdd()
	 */
	public static int[] multiplyAndAdd_Destructive(int[] words, int wordsInUse, int multiplication, int addition) {
		// Perform the multiplication word by word
		long umul = multiplication & LONG_MASK;
		long uadd = addition & LONG_MASK;

		long product = 0;
		long carry = 0;
		for (int i = 0; i < wordsInUse; i++) {
			product = umul * (words[i] & LONG_MASK) + carry;
			words[i] = (int) product;
			carry = product >>> Integer.SIZE;
		}

		// Perform the addition
		long sum = (words[0] & LONG_MASK) + uadd;
		words[0] = (int) sum;
		carry = sum >>> Integer.SIZE;
		for (int i = 1; i < wordsInUse; i++) {
			sum = (words[i] & LONG_MASK) + carry;
			words[i] = (int) sum;
			carry = sum >>> Integer.SIZE;
		}
		return words;
	}

	/**
	 * Multiplies two magnitude arrays and returns the result.
	 *
	 * @param words       The first magnitude array.
	 * @param wordsInUse  The length of the first array.
	 * @param bWords      The second magnitude array.
	 * @param bWordsInUse The length of the second array.
	 * @return product
	 * @complexity O(n^2)
	 */
	public static int[] multiplyNaive(final int[] words, final int wordsInUse, final int[] bWords,
			final int bWordsInUse) {
		final int[] product = new int[wordsInUse + bWordsInUse];
		long carry = 0, tmp, currentWord = words[0] & LONG_MASK;

		// -------------
		// multiply first word in all bWords
		// -------------
		for (int j = 0; j < bWordsInUse; j++) {
			tmp = currentWord * (bWords[j] & LONG_MASK) + carry;
			product[j] = (int) tmp;
			carry = tmp >>> Integer.SIZE;
		}
		product[bWordsInUse] = (int) carry;

		// -------------
		// now multiply the rest of words in remaining bWords
		// -------------
		for (int i = 1; i < wordsInUse; i++) {
			currentWord = words[i] & LONG_MASK;
			carry = 0;
			for (int j = 0; j < bWordsInUse; j++) {
				tmp = currentWord * (bWords[j] & LONG_MASK);
				tmp += (product[i + j] & LONG_MASK);
				tmp += carry;
				product[i + j] = (int) tmp;
				carry = tmp >>> Integer.SIZE;
			}
			product[i + bWordsInUse] = (int) carry;
		}
		return product;
	}

	private static int _get(int[] w, int i) {
		return i < w.length ? w[i] : 0;
	}

	/**
	 * Multiplies partial magnitude arrays x[off..off+n) and y[off...off+n) and
	 * returns the result. Algorithm: Karatsuba
	 *
	 * @param x   The first magnitude array.
	 * @param y   The second magnitude array.
	 * @param off The offset, where the first element is residing.
	 * @param n   The length of each of the two partial arrays.
	 * @complexity O(n^1.585)
	 */
	public static int[] kmul(final int[] x, final int[] y, final int off, final int n) {
		// x = x1*B^m + x0
		// y = y1*B^m + y0
		// xy = z2*B^2m + z1*B^m + z0
		// z2 = x1*y1, z0 = x0*y0, z1 = (x1+x0)(y1+y0)-z2-z0
		final long mask = LONG_MASK;
		if (n <= 32) // Basecase
		{
			final int[] z = new int[2 * n];
			long carry = 0, tmp, xi = _get(x, off) & mask;
			for (int j = 0; j < n; j++) {
				tmp = xi * (_get(y, off + j) & mask) + carry;
				z[j] = (int) tmp;
				carry = tmp >>> 32;
			}
			z[n] = (int) carry;
			for (int i = 1; i < n; i++) {
				xi = _get(x, off + i) & mask;
				carry = 0;
				for (int j = 0; j < n; j++) {
					tmp = xi * (_get(y, off + j) & mask) + (z[i + j] & mask) + carry;
					z[i + j] = (int) tmp;
					carry = tmp >>> 32;
				}
				z[i + n] = (int) carry;
			}
			return z;
		}

		final int b = n >>> 1;
		final int[] z2 = kmul(x, y, off + b, n - b);
		final int[] z0 = kmul(x, y, off, b);

		final int[] x2 = new int[n - b + 1], y2 = new int[n - b + 1];
		long carry = 0;
		for (int i = 0; i < b; i++) {
			carry = (_get(x, off + b + i) & mask) + (_get(x, off + i) & mask) + carry;
			x2[i] = (int) carry;
			carry >>>= 32;
		}
		if ((n & 1) != 0)
			x2[b] = _get(x, off + b + b);
		if (carry != 0)
			if (++x2[b] == 0)
				++x2[b + 1];
		carry = 0;
		for (int i = 0; i < b; i++) {
			carry = (_get(y, off + b + i) & mask) + (_get(y, off + i) & mask) + carry;
			y2[i] = (int) carry;
			carry >>>= 32;
		}
		if ((n & 1) != 0)
			y2[b] = _get(y, off + b + b);
		if (carry != 0)
			if (++y2[b] == 0)
				++y2[b + 1];

		final int[] z1 = kmul(x2, y2, 0, n - b + (x2[n - b] != 0 || y2[n - b] != 0 ? 1 : 0));

		final int[] z = new int[2 * n];
		System.arraycopy(z0, 0, z, 0, 2 * b); // Add z0
		System.arraycopy(z2, 0, z, b + b, 2 * (n - b)); // Add z2

		// Add z1
		carry = 0;
		int i = 0;
		for (; i < 2 * b; i++) {
			carry = (z[i + b] & mask) + (z1[i] & mask) - (z2[i] & mask) - (z0[i] & mask) + carry;
			z[i + b] = (int) carry;
			carry >>= 32;
		}
		for (; i < 2 * (n - b); i++) {
			carry = (z[i + b] & mask) + (z1[i] & mask) - (z2[i] & mask) + carry;
			z[i + b] = (int) carry;
			carry >>= 32;
		}
		for (; i < z1.length; i++) {
			carry = (z[i + b] & mask) + (z1[i] & mask) + carry;
			z[i + b] = (int) carry;
			carry >>= 32;
		}
		if (carry != 0)
			while (++z[i + b] == 0)
				++i;

		return z;
	}

	/**
	 * Multiplies partial magnitude arrays x[off..off+n) and y[off...off+n) and
	 * returns the result. Algorithm: Parallell Karatsuba
	 *
	 * @param x    The first magnitude array.
	 * @param y    The second magnitude array.
	 * @param off  The offset, where the first element is residing.
	 * @param n    The length of each of the two partial arrays.
	 * @param lim  The recursion depth up until which we will spawn new threads.
	 * @param pool Where spawn threads will be added and executed.
	 * @throws Various thread related exceptions.
	 * @complexity O(n^1.585)
	 */
	public static int[] pmul(final int[] x, final int[] y, final int off, final int n, final int lim,
			final ExecutorService pool) throws Exception {
		final int b = n >>> 1;
		final long mask = LONG_MASK;
		final Future<int[]> left = pool.submit(new Callable<int[]>() {
			public int[] call() throws Exception {
				return lim == 0 ? kmul(x, y, off, b) : pmul(x, y, off, b, lim - 1, pool);
			}
		});

		final Future<int[]> right = pool.submit(new Callable<int[]>() {
			public int[] call() throws Exception {
				return lim == 0 ? kmul(x, y, off + b, n - b) : pmul(x, y, off + b, n - b, lim - 1, pool);
			}
		});

		final int[] x2 = new int[n - b + 1], y2 = new int[n - b + 1];
		long carry = 0;
		for (int i = 0; i < b; i++) {
			carry = (_get(x, off + b + i) & mask) + (_get(x, off + i) & mask) + carry;
			x2[i] = (int) carry;
			carry >>>= 32;
		}
		if ((n & 1) != 0)
			x2[b] = _get(x, off + b + b);
		if (carry != 0)
			if (++x2[b] == 0)
				++x2[b + 1];
		carry = 0;
		for (int i = 0; i < b; i++) {
			carry = (_get(y, off + b + i) & mask) + (_get(y, off + i) & mask) + carry;
			y2[i] = (int) carry;
			carry >>>= 32;
		}
		if ((n & 1) != 0)
			y2[b] = _get(y, off + b + b);
		if (carry != 0)
			if (++y2[b] == 0)
				++y2[b + 1];

		final Future<int[]> mid = pool.submit(new Callable<int[]>() {
			public int[] call() throws Exception {
				return lim == 0 ? kmul(x2, y2, 0, n - b + (x2[n - b] != 0 || y2[n - b] != 0 ? 1 : 0))
						: pmul(x2, y2, 0, n - b + (x2[n - b] != 0 || y2[n - b] != 0 ? 1 : 0), lim - 1, pool);
			}
		});

		final int[] z = new int[2 * n];

		final int[] z0 = left.get();
		System.arraycopy(z0, 0, z, 0, 2 * b);
		final int[] z2 = right.get();
		System.arraycopy(z2, 0, z, b + b, 2 * (n - b));

		final int[] z1 = mid.get();

		carry = 0;
		int i = 0;
		for (; i < 2 * b; i++) {
			carry = (z[i + b] & mask) + (z1[i] & mask) - (z2[i] & mask) - (z0[i] & mask) + carry;
			z[i + b] = (int) carry;
			carry >>= 32;
		}
		for (; i < 2 * (n - b); i++) {
			carry = (z[i + b] & mask) + (z1[i] & mask) - (z2[i] & mask) + carry;
			z[i + b] = (int) carry;
			carry >>= 32;
		}
		for (; i < z1.length; i++) {
			carry = (z[i + b] & mask) + (z1[i] & mask) + carry;
			z[i + b] = (int) carry;
			carry >>= 32;
		}
		if (carry != 0)
			while (++z[i + b] == 0)
				++i;
		return z;
	}

	/**
	 * Squares the contents of the int array x. The result is placed into the int
	 * array z. The contents of x are not changed.
	 */
	public static final int[] squareToLen(int[] words, int wordsInUse, int[] result) {
		// ------------
		// duplicate the size for result`
		// ------------
		int resultLen = wordsInUse << 1;
		if (result == null || result.length < resultLen)
			result = new int[resultLen];

		// Store the squares, right shifted one bit (i.e., divided by 2)
		int lastProductLowWord = 0;
		long piece = 0, product = 0;
		for (int i = 0, k = 0; i < wordsInUse; i++) {
			piece = (words[i] & LONG_MASK);
			product = piece * piece;
			result[k++] = (lastProductLowWord << 31) | (int) (product >>> 33);
			result[k++] = (int) (product >>> 1);
			lastProductLowWord = (int) product;
		}

		// Add in off-diagonal sums
		for (int i = wordsInUse, offset = 1; i > 0; i--, offset += 2) {
			int t = words[i - 1];
			t = mulAdd(result, words, offset, i - 1, t);
			addOne(result, offset - 1, i, t);
		}

		// Shift back up and set low bit
		primitiveLeftShift(result, resultLen, 1);
		result[resultLen - 1] |= words[wordsInUse - 1] & 1;
		return result;
	}

	/**
	 * Multiply an array by one word k and add to result, return the carry
	 */
	static int mulAdd(int[] out, int[] in, int offset, int len, int k) {
		if (len > in.length) {
			throw new IllegalArgumentException("input length is out of bound: " + len + " > " + in.length);
		}
		if (offset < 0) {
			throw new IllegalArgumentException("input offset is invalid: " + offset);
		}
		if (offset > (out.length - 1)) {
			throw new IllegalArgumentException("input offset is out of bound: " + offset + " > " + (out.length - 1));
		}
		if (len > (out.length - offset)) {
			throw new IllegalArgumentException("input len is out of bound: " + len + " > " + (out.length - offset));
		}

		long kLong = k & LONG_MASK;
		long carry = 0;

		offset = out.length - offset - 1;
		for (int j = len - 1; j >= 0; j--) {
			long product = (in[j] & LONG_MASK) * kLong + (out[offset] & LONG_MASK) + carry;
			out[offset--] = (int) product;
			carry = product >>> 32;
		}
		return (int) carry;
	}

	/**
	 * Add one word to the number a mlen words into a. Return the resulting carry.
	 */
	static int addOne(int[] a, int offset, int mlen, int carry) {
		offset = a.length - 1 - mlen - offset;
		long t = (a[offset] & LONG_MASK) + (carry & LONG_MASK);

		a[offset] = (int) t;
		if ((t >>> 32) == 0)
			return 0;
		while (--mlen >= 0) {
			if (--offset < 0) { // Carry out of number
				return 1;
			} else {
				a[offset]++;
				if (a[offset] != 0)
					return 0;
			}
		}
		return 1;
	}

	// shifts a up to len left n bits assumes no leading zeros, 0<=n<32
	static void primitiveLeftShift(int[] a, int len, int n) {
		if (len == 0 || n == 0)
			return;

		int n2 = 32 - n;
		for (int i = 0, c = a[i], m = i + len - 1; i < m; i++) {
			int b = c;
			c = a[i + 1];
			a[i] = (b << n) | (c >>> n2);
		}
		a[len - 1] <<= n;
	}

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

	// ============
	// ============
	// ============

}
