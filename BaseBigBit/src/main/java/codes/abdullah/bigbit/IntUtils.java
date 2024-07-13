package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.BitSet;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class IntUtils extends Utils<Integer> {

	@Override
	public Integer ofSize(int bits_size) {
		return 0;
	}

	@Override
	public Integer of(int n) {
		return n;
	}

	@Override
	public Integer of(long n) {
		return (int) n;
	}

	@Override
	public Integer of(byte[] bytes, int len, int sign, Endian order) {
		int l = toIntArray(bytes, len, order, Endian.LITTLE)[0];
		if (sign < 0) {
			return l < 0 ? l : -l;
		}
		return l < 0 ? -l : l;
	}

	@Override
	public Integer of(int[] words, int wordsInUse, int sign, Endian order) {
		int l = words[0];
		if (!order.isLittle()) {
			l = words[wordsInUse - 1];
		}
		if (sign < 0) {
			return l < 0 ? l : -l;
		}
		return l < 0 ? -l : l;
	}

	@Override
	public Integer of(long[] dwords, int dwordsInUse, int sign, Endian order) {
		int l = toIntArray(dwords, dwordsInUse, order, Endian.LITTLE)[0];
		if (sign < 0) {
			return l < 0 ? l : -l;
		}
		return l < 0 ? -l : l;
	}

	@Override
	public Integer of(BitSet bs, int sign) {
		long[] dwords = bs.toLongArray();
		return of(dwords, dwords.length, sign);
	}

	@Override
	public Integer of(BigInteger bi) {
		byte[] bytes = bi.toByteArray();
		return of(bytes, bytes.length, bi.signum());
	}

	@Override
	public Integer of(Bits b) {
		return b.intValue();
	}

	@Override
	public Integer of(Integer t) {
		return t;
	}

	@Override
	public Integer ofRandomRange(int fromBit, int toBit, int sign) {
		int r = Digits.RANDOM.nextInt() >>> fromBit;
		r <<= fromBit + toBit;
		r >>>= toBit;
		if (sign < 0 && r > 0 || sign > 0 && r < 0) {
			r = -r;
		}
		return r;
	}

	@Override
	public Integer assign(Integer t, int n) {
		return n;
	}

	@Override
	public Integer assign(Integer t, long n) {
		return (int) n;
	}

	@Override
	public Integer assign(Integer t, int[] words, int wordsInUse, int sign, Endian order) {
		return of(words, wordsInUse, sign, order);
	}

	@Override
	public Integer assign(Integer t, Integer n) {
		return n;
	}

	@Override
	public Integer assign(Integer t, CharSequence cs, int radix) {
		return Digits.parseInt(cs, radix);
	}

	@Override
	public int numberOfLeadingZeros(Integer t) {
		return Integer.numberOfLeadingZeros(t);
	}

	@Override
	public int numberOfTrailingZeros(Integer t) {
		return Integer.numberOfTrailingZeros(t);
	}

	@Override
	public Integer shiftLeft(Integer t, int shift) {
		return t << shift;
	}

	@Override
	public Integer shiftRight(Integer t, int shift) {
		return t >> shift;
	}

	@Override
	public Integer shiftRightUnsigned(Integer t, int shift) {
		return t >>> shift;
	}

	@Override
	public int intValue(Integer t) {
		return t.intValue();
	}

	@Override
	public long longValue(Integer t) {
		return t.longValue();
	}

	@Override
	public Integer and(Integer t, byte n) {
		return t & n;
	}

	@Override
	public Integer and(Integer t, int n) {
		return t & n;
	}

	@Override
	public Integer and(Integer t, long n) {
		return (int) (t & n);
	}

	@Override
	public Integer and(Integer t, BitSet bs) {
		return t & Utils.bs.intValue(bs);
	}

	@Override
	public Integer and(Integer t, BigInteger bi) {
		return t & bi.intValue();
	}

	@Override
	public Integer and(Integer t, Bits b) {
		return t & b.intValue();
	}

	@Override
	public Integer and(Integer t1, Integer t2) {
		return t1 & t2;
	}

	@Override
	public Integer andNot(Integer t, byte n) {
		return t & ~n;
	}

	@Override
	public Integer andNot(Integer t, int n) {
		return t & ~n;
	}

	@Override
	public Integer andNot(Integer t, long n) {
		return (int) (t & ~n);
	}

	@Override
	public Integer andNot(Integer t, BitSet bs) {
		return t & ~Utils.bs.intValue(bs);
	}

	@Override
	public Integer andNot(Integer t, BigInteger bi) {
		return t & ~bi.intValue();
	}

	@Override
	public Integer andNot(Integer t, Bits b) {
		return t & ~b.intValue();
	}

	@Override
	public Integer andNot(Integer t1, Integer t2) {
		return t1 & ~t2;
	}

	@Override
	public Integer or(Integer t, byte n) {
		return t | n;
	}

	@Override
	public Integer or(Integer t, int n) {
		return t | n;
	}

	@Override
	public Integer or(Integer t, long n) {
		return (int) (t | n);
	}

	@Override
	public Integer or(Integer t, BitSet bs) {
		return t | Utils.bs.intValue(bs);
	}

	@Override
	public Integer or(Integer t, BigInteger bi) {
		return t | bi.intValue();
	}

	@Override
	public Integer or(Integer t, Bits b) {
		return t | b.intValue();
	}

	@Override
	public Integer or(Integer t1, Integer t2) {
		return t1 | t2;
	}

	@Override
	public Integer xor(Integer t, byte n) {
		return t ^ n;
	}

	@Override
	public Integer xor(Integer t, int n) {
		return t ^ n;
	}

	@Override
	public Integer xor(Integer t, long n) {
		return (int) (t ^ n);
	}

	@Override
	public Integer xor(Integer t, BitSet bs) {
		return t ^ Utils.bs.intValue(bs);
	}

	@Override
	public Integer xor(Integer t, BigInteger bi) {
		return t ^ bi.intValue();
	}

	@Override
	public Integer xor(Integer t, Bits b) {
		return t ^ b.intValue();
	}

	@Override
	public Integer xor(Integer t1, Integer t2) {
		return t1 ^ t2;
	}

	@Override
	public Integer not(Integer t) {
		return ~t;
	}

	@Override
	public int[] words(Integer t, Endian order) {
		return new int[] { t };
	}

	@Override
	public int wordSize() {
		return Integer.SIZE;
	}

	@Override
	public int wordsInUse(Integer t) {
		return 1;
	}

	@Override
	public int sizeOf(Integer t) {
		return Integer.SIZE;
	}

	@Override
	public int lengthOfBits(Integer t) {
		return Integer.SIZE - numberOfLeadingZeros(t);
	}

	@Override
	public int countOfBits(Integer t) {
		return Integer.bitCount(t);
	}

	@Override
	public int getHighestClearIndex(Integer t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getHighestSetIndex(Integer t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getLowestClearIndex(Integer t) {
		return nextClearBit(t, 0);
	}

	@Override
	public int getLowestSetIndex(Integer t) {
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public boolean getBit(Integer t, int bitIndex) {
		Check.index(bitIndex);
		int wordsInUse = 1;
		int wordIndex = wordIndex(bitIndex);
		return (wordIndex < wordsInUse) && ((t & (1 << bitIndex)) != 0);
	}

	@Override
	public Integer getBits(Integer t, int fromBitIndex, int toBitIndex) {
		Check.range(fromBitIndex, toBitIndex);
		int mask = (-1) >>> (Integer.SIZE - toBitIndex);
		return (t & mask) >>> fromBitIndex;
	}

	@Override
	public Integer setBit(Integer t, int bitIndex) {
		return t | 1 << bitIndex;
	}

	@Override
	public Integer setBits(Integer t, int fromBitIndex, int toBitIndex) {
		int first = Utils.BITS_WORD_MASK << fromBitIndex;
		int last = Utils.BITS_WORD_MASK >>> -toBitIndex;
		return t | (first & last);
	}

	@Override
	public Integer clearBit(Integer t, int bitIndex) {
		int wordIndex = Utils.wordIndex(bitIndex);
		if (wordIndex >= 1)
			return t;
		return t & ~(1 << bitIndex);
	}

	@Override
	public Integer clearBits(Integer t, int fromBitIndex, int toBitIndex) {
		int first = Utils.BITS_WORD_MASK << fromBitIndex;
		int last = Utils.BITS_WORD_MASK >>> -toBitIndex;
		return t & ~(first & last);
	}

	@Override
	public Integer flipBit(Integer t, int bitIndex) {
		return t ^ (1 << bitIndex);
	}

	@Override
	public Integer flipBits(Integer t, int fromBitIndex, int toBitIndex) {
		int first = Utils.BITS_WORD_MASK << fromBitIndex;
		int last = Utils.BITS_WORD_MASK >>> -toBitIndex;
		return t ^ (first & last);
	}

	@Override
	public int compare(Integer a, Integer b) {
		return Integer.compare(a, b);
	}

	@Override
	public int nextSetBit(Integer t, int offset) {
		if (offset < 0 || offset >= Integer.SIZE) {
			return -1;
		}
		t = t & (BITS_WORD_MASK << offset);
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public int nextClearBit(Integer t, int offset) {
		if (offset < 0 || offset >= Integer.SIZE)
			return -1;

		t = ~t & (-1 << offset);
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public int previousSetBit(Integer t, int offset) {
		if (offset < 0) {
			return -1;
		} else if (offset >= Integer.SIZE) {
			return Integer.SIZE - 1 - numberOfLeadingZeros(t);
		}
		t = t & (BITS_WORD_MASK >>> -(offset + 1));
		return Integer.SIZE - 1 - numberOfLeadingZeros(t);
	}

	@Override
	public int previousClearBit(Integer t, int offset) {
		if (offset < 0) {
			return -1;
		} else if (offset >= Integer.SIZE) {
			return offset;
		}
		t = ~t & (BITS_WORD_MASK >>> -(offset + 1));
		return Integer.SIZE - 1 - numberOfLeadingZeros(t);
	}

	@Override
	public boolean isMagnitudeBased() {
		return false;
	}

	@Override
	public Byte toByte(Integer t) {
		return t.byteValue();
	}

	@Override
	public Integer toInteger(Integer t) {
		return t;
	}

	@Override
	public Long toLong(Integer t) {
		return t.longValue();
	}

	@Override
	public BitSet toBitSet(Integer t) {
		return Utils.bs.of(t);
	}

	@Override
	public BigInteger toBigInteger(Integer t) {
		return Utils.bi.of(t);
	}

	@Override
	public Bits toBits(Integer t) {
		return Utils.b.of(t);
	}

}
