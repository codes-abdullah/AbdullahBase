package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

public class BitsUtils extends Utils<Bits> {

//	public static final int BIT_ADDRESS_BITS_PER_WORD = 5;
//	public static final int BIT_MASK_INDEX = Integer.SIZE - 1;
//	public static final int BIT_MASK_SMALL = -1;
//	public static final long BIT_MASK_LARGE = (1L << 32) - 1;
	private static MutableBits newMutable(int[] words, int wordsInUse) {
		return new MutableBits(words, words.length, DEFAULT_SIGNUM, 0, Utils.DEFAULT_BOUNDS, Utils.MAX_WORDS_LENGTH,
				false);
	}

	private static MutableBits newMutable(int[] words, int wordsInUse, int sign) {
		return new MutableBits(words, words.length, sign, 0, Utils.DEFAULT_BOUNDS, Utils.MAX_WORDS_LENGTH, false);
	}

	// ===========
	// ===========
	// ===========

	@Override
	public Bits ofSize(int bits_size) {
		return new MutableBits(bits_size);
	}

	@Override
	public Bits of(int n) {
		int sign = 1;
		if (n < 0) {
			n = -n;
			sign = -1;
		}
		int[] words = new int[] { n };
		return newMutable(words, words.length, sign);
	}

	@Override
	public Bits of(long n) {
		int sign = 1;
		if (n < 0) {
			n = -n;
			sign = -1;
		}
		int[] words = Utils.toIntArray(n);
		return newMutable(words, words.length, sign);
	}

	@Override
	public Bits of(byte[] bytes, int len, int sign, Endian order) {
		int[] words = Utils.toIntArray(bytes, len, order, Endian.LITTLE);
		return newMutable(words, words.length);
	}

	@Override
	public Bits of(int[] words, int wordsInUse, int sign, Endian order) {
		words = Arrays.copyOf(words, wordsInUse);
		if (!order.isLittle()) {
			words =  Lang.reverse.in(words, wordsInUse);
		}
		wordsInUse = recalcWordsInUse(words, wordsInUse);
		return newMutable(words, wordsInUse);
	}

	@Override
	public Bits of(long[] dwords, int dwordsInUse, int sign, Endian order) {
		int[] words = Utils.toIntArray(dwords, dwordsInUse, order);
		return newMutable(words, words.length);
	}

	@Override
	public Bits of(BitSet bs, int sign) {
		int[] words = Utils.toIntArray(bs.toLongArray());
		return of(words, words.length);
	}

	@Override
	public Bits of(BigInteger bi) {
		byte[] bytes = bi.toByteArray();
		return of(bytes, bytes.length, bi.signum(), Endian.BIG);
	}

	@Override
	public Bits of(Bits t) {
		return t.newClone();
	}

	@Override
	public Bits assign(Bits t, int n) {
		return t.assign(n);
	}

	@Override
	public Bits assign(Bits t, long n) {
		return t.assign(n);
	}

	@Override
	public Bits assign(Bits t, int[] words, int wordsInUse, int sign, Endian order) {
		words = Arrays.copyOf(words, wordsInUse);
		if (!order.isLittle()) {
			words =  Lang.reverse.in(words, wordsInUse);
		}
		return t.checkInvariantsAndAssign(words, wordsInUse, t.sign());
	}

	@Override
	public Bits assign(Bits t, Bits n) {
		return t.assign(n);
	}

	@Override
	public Bits assign(Bits t, CharSequence cs, int radix) {
		return t.assign(cs, radix);
	}

	@Override
	public int numberOfLeadingZeros(Bits t) {
		return t.numberOfLeadingZeros();
	}

	@Override
	public int numberOfTrailingZeros(Bits t) {
		return t.numberOfTrailingZeros();
	}

	@Override
	public Bits shiftLeft(Bits t, int shift) {
		return t.shiftLeft(shift);
	}

	@Override
	public Bits shiftRight(Bits t, int shift) {
		return t.shiftRight(shift);
	}

	@Override
	public Bits shiftRightUnsigned(Bits t, int shift) {
		return t.shiftRightUnsigned(shift);
	}

	@Override
	public Bits and(Bits t, byte n) {
		return t.and(of(n));
	}

	@Override
	public Bits and(Bits t, int n) {
		return t.and(of(n));
	}

	@Override
	public Bits and(Bits t, long n) {
		return t.and(of(n));
	}

	@Override
	public Bits and(Bits t, BitSet bs) {
		return t.and(of(bs));
	}

	@Override
	public Bits and(Bits t, BigInteger bi) {
		return t.and(of(bi));
	}

	@Override
	public Bits and(Bits t, Bits b) {
		return t.and(b);
	}

	@Override
	public Bits andNot(Bits t, byte n) {
		return t.andNot(of(n));
	}

	@Override
	public Bits andNot(Bits t, int n) {
		return t.andNot(of(n));
	}

	@Override
	public Bits andNot(Bits t, long n) {
		return t.andNot(of(n));
	}

	@Override
	public Bits andNot(Bits t, BitSet bs) {
		return t.andNot(of(bs));
	}

	@Override
	public Bits andNot(Bits t, BigInteger bi) {
		return t.andNot(of(bi));
	}

	@Override
	public Bits andNot(Bits t, Bits b) {
		return t.andNot(b);
	}

	@Override
	public Bits or(Bits t, byte n) {
		return t.or(of(n));
	}

	@Override
	public Bits or(Bits t, int n) {
		return t.or(of(n));
	}

	@Override
	public Bits or(Bits t, long n) {
		return t.or(of(n));
	}

	@Override
	public Bits or(Bits t, BitSet bs) {
		return t.or(of(bs));
	}

	@Override
	public Bits or(Bits t, BigInteger bi) {
		return t.or(of(bi));
	}

	@Override
	public Bits or(Bits t, Bits b) {
		return t.or(b);
	}

	@Override
	public Bits xor(Bits t, byte n) {
		return t.xor(of(n));
	}

	@Override
	public Bits xor(Bits t, int n) {
		return t.xor(of(n));
	}

	@Override
	public Bits xor(Bits t, long n) {
		return t.xor(of(n));
	}

	@Override
	public Bits xor(Bits t, BitSet bs) {
		return t.xor(of(bs));
	}

	@Override
	public Bits xor(Bits t, BigInteger bi) {
		return t.xor(of(bi));
	}

	@Override
	public Bits xor(Bits t, Bits b) {
		return t.xor(b);
	}

	@Override
	public Bits not(Bits t) {
		return t.not();
	}

	@Override
	public int intValue(Bits t) {
		return t.intValue();
	}

	@Override
	public long longValue(Bits t) {
		return t.longValue();
	}

	@Override
	public int[] words(Bits t, Endian order) {
		return t.toIntegerArray(order);
	}

	@Override
	public int wordSize() {
		return Integer.SIZE;
	}

	@Override
	public int wordsInUse(Bits t) {
		return t.wordsInUse();
	}

	@Override
	public int sizeOf(Bits t) {
		return t.size();
	}

	@Override
	public int lengthOfBits(Bits t) {
		return t.length();
	}

	@Override
	public int countOfBits(Bits t) {
		return t.cardinality();
	}

	@Override
	public boolean getMostSignificantBit(Bits t) {
		return t.getMostSignificant();
	}

	@Override
	public int getHighestClearIndex(Bits t) {
		return t.getHighestClear();
	}

	@Override
	public int getHighestSetIndex(Bits t) {
		return t.getHighestSet();
	}

	@Override
	public int getLowestClearIndex(Bits t) {
		return t.getLowestClear();
	}

	@Override
	public int getLowestSetIndex(Bits t) {
		return t.getLowestSet();
	}

	@Override
	public boolean getBit(Bits t, int bitIndex) {
		return t.get(bitIndex);
	}

	@Override
	public Bits getBits(Bits t, int fromBitIndex, int toBitIndex) {
		return t.get(fromBitIndex, toBitIndex);
	}

	@Override
	public Bits setBit(Bits t, int bitIndex) {
		t.set(bitIndex);
		return t;
	}

	@Override
	public Bits setBits(Bits t, int fromBitIndex, int toBitIndex) {
		t.set(fromBitIndex, toBitIndex);
		return t;
	}

	@Override
	public Bits clearBit(Bits t, int bitIndex) {
		return t.clear(bitIndex);
	}

	@Override
	public Bits clearBits(Bits t, int fromBitIndex, int toBitIndex) {
		return t.clear(fromBitIndex, toBitIndex);
	}

	@Override
	public Bits flipBit(Bits t, int bitIndex) {
		return t.flip(bitIndex);
	}

	@Override
	public Bits flipBits(Bits t, int fromBitIndex, int toBitIndex) {
		return t.flip(fromBitIndex, toBitIndex);
	}

	@Override
	public String toBinary(Bits t, int binarySize, boolean includeLeadingZeros, boolean readable, int division,
			char divider) {
		return t.toBinary(binarySize, includeLeadingZeros, readable, division, divider).toString();
	}

	@Override
	public int compare(Bits a, Bits b) {
		return a.compareTo(b);
	}

	@Override
	public int nextSetBit(Bits t, int offset) {
		return t.nextSetBit(offset);
	}

	@Override
	public int nextClearBit(Bits t, int offset) {
		return t.nextClearBit(offset);
	}

	@Override
	public int previousSetBit(Bits t, int offset) {
		return t.previousSetBit(offset);
	}

	@Override
	public int previousClearBit(Bits t, int offset) {
		return t.previousClearBit(offset);
	}

	@Override
	public boolean isMagnitudeBased() {
		return true;
	}

	@Override
	public Byte toByte(Bits t) {
		return t.byteValue();
	}

	@Override
	public Integer toInteger(Bits t) {
		return t.intValue();
	}

	@Override
	public Long toLong(Bits t) {
		return t.longValue();
	}

	@Override
	public BitSet toBitSet(Bits t) {
		return t.toBitSet();
	}

	@Override
	public BigInteger toBigInteger(Bits t) {
		return t.toBigInteger();
	}

	@Override
	public Bits toBits(Bits t) {
		return t.newClone();
	}

}
