package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

public class BigIntegerUtils extends Utils<BigInteger> {

	@Override
	BigInteger ZERO() {
		return BigInteger.ZERO;
	}

	@Override
	public BigInteger ofSize(int bits_size) {
		return BigInteger.valueOf(0);
	}

	@Override
	public BigInteger of(int n) {
		int sign = 1;
		if (n < 0) {
			n = -n;
			sign = -1;
		}
		byte[] bytes = toByteArray(n);
		return new BigInteger(sign, bytes);
	}

	@Override
	public BigInteger of(long n) {
		int sign = 1;
		if (n < 0) {
			n = -n;
			sign = -1;
		}
		byte[] bytes = toByteArray(n);
		return new BigInteger(sign, bytes);
	}

	@Override
	public BigInteger of(byte[] bytes, int len, int sign, Endian order) {
		bytes = Arrays.copyOf(bytes, len);
		if (order.isLittle()) {
			bytes = Lang.reverse.in(bytes, bytes.length);
		}
		return new BigInteger(sign, bytes);
	}

	@Override
	public BigInteger of(int[] words, int wordsInUse, int sign, Endian order) {
		byte[] bytes = toByteArray(words, wordsInUse, order, Endian.BIG);
		return new BigInteger(sign, bytes);
	}

	@Override
	public BigInteger of(long[] dwords, int dwordsInUse, int sign, Endian order) {
		byte[] bytes = toByteArray(dwords, dwordsInUse, order, Endian.BIG);
		return new BigInteger(sign, bytes);
	}

	@Override
	public BigInteger of(BitSet bs, int sign) {
		byte[] bsbytes = bs.toByteArray();
		byte[] bytes = Lang.reverse.in(bsbytes, bsbytes.length);
		return new BigInteger(sign, bytes);
	}

	@Override
	public BigInteger of(BigInteger bi) {
		return bi;
	}

	@Override
	public BigInteger of(Bits b) {
		return b.toBigInteger();
	}

	@Override
	public BigInteger assign(BigInteger t, int n) {
		return of(n);
	}

	@Override
	public BigInteger assign(BigInteger t, long n) {
		return of(n);
	}

	@Override
	public BigInteger assign(BigInteger t, int[] words, int wordsInUse, int sign, Endian order) {
		return of(words, wordsInUse, sign, order);
	}

	@Override
	public BigInteger assign(BigInteger t, BigInteger n) {
		return n;
	}

	@Override
	public BigInteger assign(BigInteger t, CharSequence cs, int radix) {
		return new BigInteger(cs.toString(), radix);
	}

	@Override
	public int numberOfLeadingZeros(BigInteger t) {
		int size = sizeOf(t);
		return size - previousSetBit(t, size) - 1;
	}

	@Override
	public int numberOfTrailingZeros(BigInteger t) {
		return nextSetBit(t, 0);
	}

	@Override
	public BigInteger shiftLeft(BigInteger t, int shift) {
		return t.shiftLeft(shift);
	}

	@Override
	public BigInteger shiftRight(BigInteger t, int shift) {
		BitSet bs = Utils.bs.of(t);
		bs = Utils.bs.shiftRight(bs, shift);
		return of(bs);
	}

	@Override
	public BigInteger shiftRightUnsigned(BigInteger t, int shift) {
		return t.shiftRight(shift);
	}

	@Override
	public BigInteger and(BigInteger t, byte n) {
		return t.and(of(n));
	}

	@Override
	public BigInteger and(BigInteger t, int n) {
		return t.and(of(n));
	}

	@Override
	public BigInteger and(BigInteger t, long n) {
		return t.and(of(n));
	}

	@Override
	public BigInteger and(BigInteger t, BitSet bs) {
		return t.and(of(bs));
	}

	@Override
	public BigInteger and(BigInteger t, BigInteger bi) {
		return t.and(bi);
	}

	@Override
	public BigInteger and(BigInteger t, Bits b) {
		return t.and(b.toBigInteger());
	}

	@Override
	public BigInteger andNot(BigInteger t, byte n) {
		return t.andNot(of(n));
	}

	@Override
	public BigInteger andNot(BigInteger t, int n) {
		return t.andNot(of(n));
	}

	@Override
	public BigInteger andNot(BigInteger t, long n) {
		return t.andNot(of(n));
	}

	@Override
	public BigInteger andNot(BigInteger t, BitSet bs) {
		return t.andNot(of(bs));
	}

	@Override
	public BigInteger andNot(BigInteger t, BigInteger bi) {
		return t.andNot(bi);
	}

	@Override
	public BigInteger andNot(BigInteger t, Bits b) {
		return t.andNot(b.toBigInteger());
	}

	@Override
	public BigInteger or(BigInteger t, byte n) {
		return t.or(of(n));
	}

	@Override
	public BigInteger or(BigInteger t, int n) {
		return t.or(of(n));
	}

	@Override
	public BigInteger or(BigInteger t, long n) {
		return t.or(of(n));
	}

	@Override
	public BigInteger or(BigInteger t, BitSet bs) {
		return t.or(of(bs));
	}

	@Override
	public BigInteger or(BigInteger t, BigInteger bi) {
		return t.or(bi);
	}

	@Override
	public BigInteger or(BigInteger t, Bits b) {
		return t.or(b.toBigInteger());
	}

	@Override
	public BigInteger xor(BigInteger t, byte n) {
		return t.xor(of(n));
	}

	@Override
	public BigInteger xor(BigInteger t, int n) {
		return t.xor(of(n));
	}

	@Override
	public BigInteger xor(BigInteger t, long n) {
		return t.xor(of(n));
	}

	@Override
	public BigInteger xor(BigInteger t, BitSet bs) {
		return t.xor(of(bs));
	}

	@Override
	public BigInteger xor(BigInteger t, BigInteger bi) {
		return t.xor(bi);
	}

	@Override
	public BigInteger xor(BigInteger t, Bits b) {
		return t.xor(b.toBigInteger());
	}

	@Override
	public BigInteger not(BigInteger t) {
		return t.not();
	}

	@Override
	public int intValue(BigInteger t) {
		return t.intValue();
	}

	@Override
	public long longValue(BigInteger t) {
		return t.longValue();
	}

	@Override
	public int[] words(BigInteger t, Endian order) {
		byte[] bytes = t.abs().toByteArray();
		if (bytes.length == 0) {
			return new int[] { 0 };
		}
		return toIntArray(bytes, bytes.length, Endian.BIG, Endian.LITTLE);
	}

	@Override
	public int wordSize() {
		return Integer.SIZE;
	}

	@Override
	public int wordsInUse(BigInteger t) {
		if (t.equals(BigInteger.ZERO))
			return 1;
		int len = t.bitLength();
		int wiu = len >> ADDRESS_BITS_PER_WORD;
		wiu += ((len & BIT_INDEX_MASK) > 0 ? 1 : 0);
		return wiu == 0 ? 1 : wiu;
	}

	@Override
	public int lengthOfBits(BigInteger t) {
		return t.bitLength();
	}

	@Override
	public int countOfBits(BigInteger t) {
		return t.bitCount();
	}

	@Override
	public int getHighestClearIndex(BigInteger t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getHighestSetIndex(BigInteger t) {
		return Utils.getHighestSet(words(t), wordsInUse(t));
	}

	@Override
	public int getLowestClearIndex(BigInteger t) {
		return nextClearBit(t, 0);
	}

	@Override
	public int getLowestSetIndex(BigInteger t) {
		return Utils.getLowestSet(words(t), wordsInUse(t));

	}

	@Override
	public boolean getBit(BigInteger t, int bitIndex) {
		return t.testBit(bitIndex);
	}

	@Override
	public BigInteger getBits(BigInteger t, int fromBitIndex, int toBitIndex) {
		Check.range(fromBitIndex, toBitIndex);
		int[] words = words(t);
		int len = lengthOfBits(t);
		int wordsInUse = wordsInUse(t);

		if (len <= fromBitIndex || fromBitIndex == toBitIndex) {
			return ZERO();
		}

		if (toBitIndex > len) {
			toBitIndex = len;
		}
		int targetWords = Utils.wordIndex(toBitIndex - fromBitIndex - 1) + 1;
		int[] result_words = Utils.get(words, wordsInUse, targetWords, fromBitIndex, toBitIndex);
		int result_wordsInUse = Utils.recalcWordsInUse(result_words, targetWords);
		Utils.checkInvariants(result_words, result_wordsInUse);
		return of(result_words, result_wordsInUse, 1, Endian.LITTLE);
	}

	@Override
	public BigInteger setBit(BigInteger t, int bitIndex) {
		return t.setBit(bitIndex);
	}

	@Override
	public BigInteger setBits(BigInteger t, int fromBitIndex, int toBitIndex) {
		if (fromBitIndex == toBitIndex) {
			return t;
		}
		Check.range(fromBitIndex, toBitIndex);
		int[] words = words(t);
		int wordsInUse = wordsInUse(t);
		words = Utils.set(words, wordsInUse, fromBitIndex, toBitIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return of(words, wordsInUse, t.signum(), Endian.LITTLE);
	}

	@Override
	public BigInteger clearBit(BigInteger t, int bitIndex) {
		return t.clearBit(bitIndex);
	}

	@Override
	public BigInteger clearBits(BigInteger t, int fromBitIndex, int toBitIndex) {
		if (isEmpty(t) || fromBitIndex == toBitIndex) {
			return t;
		}
		Check.range(fromBitIndex, toBitIndex);
		int wordsInUse = wordsInUse(t);
		int[] words = words(t);
		words = Utils.clear(words, wordsInUse, fromBitIndex, toBitIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return of(words, wordsInUse, t.signum());
	}

	@Override
	public BigInteger flipBit(BigInteger t, int bitIndex) {
		return t.flipBit(bitIndex);
	}

	@Override
	public BigInteger flipBits(BigInteger t, int fromBitIndex, int toBitIndex) {
		if (fromBitIndex == toBitIndex) {
			return t;
		}
		Check.range(fromBitIndex, toBitIndex);
		int[] words = words(t);
		int wordsInUse = wordsInUse(t);
		words = Utils.flip(words, wordsInUse, fromBitIndex, toBitIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return of(words, wordsInUse, t.signum());
	}

	@Override
	public int compare(BigInteger a, BigInteger b) {
		return a.compareTo(b);
	}

	@Override
	public int nextSetBit(BigInteger t, int offset) {
		int[] words = words(t);
		return nextSetBit(words, words.length, offset);
	}

	@Override
	public int nextClearBit(BigInteger t, int offset) {
		int[] words = words(t);
		return nextClearBit(words, words.length, offset);
	}

	@Override
	public int previousSetBit(BigInteger t, int offset) {
		int[] words = words(t);
		return previousSetBit(words, words.length, lengthOfBits(t), offset);
	}

	@Override
	public int previousClearBit(BigInteger t, int offset) {
		int[] words = words(t);
		return nextClearBit(words, words.length, offset);
	}

	@Override
	public boolean isMagnitudeBased() {
		return true;
	}

	@Override
	public Byte toByte(BigInteger t) {
		return t.byteValue();
	}

	@Override
	public Integer toInteger(BigInteger t) {
		return t.intValue();
	}

	@Override
	public Long toLong(BigInteger t) {
		return t.longValue();
	}

	@Override
	public BitSet toBitSet(BigInteger t) {
		return Utils.bs.of(t);
	}

	@Override
	public BigInteger toBigInteger(BigInteger t) {
		return t;
	}

	@Override
	public Bits toBits(BigInteger t) {
		return Utils.b.of(t);
	}

	// ==============
	// ==============
	// ==============

	public static BigInteger ofBounds(int bound) {
		checkBounds(bound, MAX_WORDS_LENGTH);
		return BigInteger.ONE.shiftLeft(bound * Integer.SIZE).subtract(BigInteger.ONE);
	}

	public static BigInteger ofUnsigned(int i) {
		if (i >= 0) {
			return BigInteger.valueOf(i);
		} else {
			return BigInteger.valueOf(i & LONG_MASK);
		}
	}

	public static BigInteger ofUnsigned(long l) {
		if (l >= 0L) {
			return BigInteger.valueOf(l);
		} else {
			int upper = (int) (l >>> 32);
			int lower = (int) l;
			return BigInteger.valueOf(Integer.toUnsignedLong(upper)).shiftLeft(32)
					.add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));
		}
	}

	public static BigInteger ofUnsigned(BigInteger j) {
		return ofUnsigned(j, null);
	}

	public static BigInteger ofUnsigned(BigInteger j, BigInteger mask) {
		if (j.compareTo(BigInteger.ZERO) < 0) {
			j = j.and(mask == null ? ofMask(j) : mask);
		}
		return j;
	}

	/**
	 * e.g: 1024, that under 32 bits, will return 32 set-bits to represent mask for
	 * given number
	 */
	public static BigInteger ofMask(BigInteger n) {
		int len = n.bitLength();
		int size = Digits.headMissing(len, Integer.SIZE) + len;
		len = size / Integer.SIZE;
		BigInteger m = BigInteger.ONE.shiftLeft(Integer.SIZE).subtract(BigInteger.ONE);
		BigInteger mask = m;
		for (int i = 0; i < len - 1; i++) {
			mask = mask.shiftLeft(Integer.SIZE).or(m);
		}
		return mask;
	}

	public static BigInteger subtractUnsigned(Number minuend, Number subtrahend, Number lowerBound) {
		return subtractUnsigned(toBi(minuend), toBi(subtrahend), ofBounds(lowerBound.intValue()));
	}

	public static BigInteger subtractUnsigned(BigInteger minuend, BigInteger subtrahend, BigInteger lowerBound) {
		// -----------------
		// if minuend(42) >= subtrahend(22), not going below 0
		// -----------------
		if (minuend.compareTo(subtrahend) >= 0) {
			return minuend.subtract(subtrahend);
		}
		// -----------------
		// if minuend(22) < subtrahend(44), going below 0
		// e.g: bound = 9, the 0 is the 10 in-count
		// 0, 1, .. 8, 9
		// -----------------

		// -----------------
		// so we need to fix the bound to be in-count instead of the-limit by adding 1
		// -----------------
		lowerBound = lowerBound.add(BigInteger.ONE);

		// -----------------
		// now drop all full rounds of bound and keep only remaining, so 44 -> 4
		// -----------------
		subtrahend = subtrahend.mod(lowerBound);

		// -----------------
		// same with minuend, 22 -> 2
		// -----------------
		minuend = minuend.mod(lowerBound);

		// -----------------
		// now we can make normal subtract without exceeding the bound, and taking bound
		// in consideration
		// -----------------
		minuend = minuend.subtract(subtrahend);
		if (minuend.compareTo(BigInteger.ZERO) < 0) {
			return lowerBound.subtract(minuend.abs());
		}
		return minuend;
	}

	public static BigInteger divideUnsigned(BigInteger dividend, BigInteger divisor) {
		dividend = ofUnsigned(dividend);
		divisor = ofUnsigned(divisor);
		return dividend.divide(divisor);
	}

	public static BigInteger remainderUnsigned(BigInteger dividend, BigInteger divisor) {
		dividend = ofUnsigned(dividend);
		divisor = ofUnsigned(divisor);
		return dividend.remainder(divisor);
	}

	public static BigInteger[] divideAndReminderUnsigned(BigInteger dividend, BigInteger divisor) {
		dividend = ofUnsigned(dividend);
		divisor = ofUnsigned(divisor);
		return dividend.divideAndRemainder(divisor);
	}

	public static BigInteger multiplyUnsigned(BigInteger multiplicand, BigInteger multiplier) {
		multiplicand = ofUnsigned(multiplicand);
		multiplier = ofUnsigned(multiplier);
		return multiplicand.multiply(multiplier);
	}

	private static BigInteger toBi(Number n) {
		return n instanceof BigInteger ? (BigInteger) n : new BigInteger(n.toString(), 10);
	}

}
