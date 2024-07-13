package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.BitSet;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LongUtils extends Utils<Long> {

	@Override
	public Long ofSize(int bits_size) {
		return 0L;
	}

	@Override
	public Long of(int n) {
		return (long) n;
	}

	@Override
	public Long of(long n) {
		return n;
	}

	@Override
	public Long of(byte[] bytes, int len, int sign, Endian order) {
		long l = toLongArray(bytes, len, order, Endian.LITTLE)[0];
		if (sign < 0) {
			return l < 0 ? l : -l;
		}
		return l < 0 ? -l : l;
	}

	@Override
	public Long of(int[] words, int wordsInUse, int sign, Endian order) {
		long l = toLongArray(words, wordsInUse, order, Endian.LITTLE)[0];
		if (sign < 0) {
			return l < 0 ? l : -l;
		}
		return l < 0 ? -l : l;
	}

	@Override
	public Long of(long[] dwords, int dwordsInUse, int sign, Endian order) {
		long l = order.isLittle() ? dwords[0] : dwords[dwordsInUse - 1];
		if (sign < 0) {
			return l < 0 ? l : -l;
		}
		return l < 0 ? -l : l;
	}

	@Override
	public Long of(BitSet bs, int sign) {
		long[] dwords = bs.toLongArray();
		return of(dwords, dwords.length, sign);
	}

	@Override
	public Long of(BigInteger bi) {
		byte[] bytes = bi.toByteArray();
		return of(bytes, bytes.length, bi.signum(), Endian.BIG);
	}

	@Override
	public Long of(Bits b) {
		int[] words = b.toIntegerArray();
		return of(words, words.length, b.sign());
	}

	@Override
	public Long of(Long t) {
		return t;
	}

	@Override
	public Long ofRandomRange(int fromBit, int toBit, int sign) {
		long r = Digits.RANDOM.nextLong() >>> fromBit;
		r <<= fromBit + toBit;
		r >>>= toBit;
		if (sign < 0 && r > 0 || sign > 0 && r < 0) {
			r = -r;
		}
		return r;
	}

	@Override
	public Long assign(Long t, int n) {
		return (long) n;
	}

	@Override
	public Long assign(Long t, long n) {
		return n;
	}

	@Override
	public Long assign(Long t, int[] words, int wordsInUse, int sign, Endian order) {
		return of(words, wordsInUse, sign, order);
	}

	@Override
	public Long assign(Long t, Long n) {
		return n;
	}

	@Override
	public Long assign(Long t, CharSequence cs, int radix) {
		return Digits.longs.parse(cs, radix);
	}

	@Override
	public int numberOfLeadingZeros(Long t) {
		return Long.numberOfLeadingZeros(t);
	}

	@Override
	public int numberOfTrailingZeros(Long t) {
		return Long.numberOfTrailingZeros(t);
	}

	@Override
	public Long shiftLeft(Long t, int shift) {
		return t << shift;
	}

	@Override
	public Long shiftRight(Long t, int shift) {
		return t >> shift;
	}

	@Override
	public Long shiftRightUnsigned(Long t, int shift) {
		return t >>> shift;
	}

	@Override
	public Long and(Long t, byte n) {
		return t & n;
	}

	@Override
	public Long and(Long t, int n) {
		return t & n;
	}

	@Override
	public Long and(Long t, long n) {
		return (long) (t & n);
	}

	@Override
	public Long and(Long t, BitSet bs) {
		return t & Utils.bs.longValue(bs);
	}

	@Override
	public Long and(Long t, BigInteger bi) {
		return t & bi.longValue();
	}

	@Override
	public Long and(Long t, Bits b) {
		return t & b.longValue();
	}

	@Override
	public Long and(Long t1, Long t2) {
		return t1 & t2;
	}

	@Override
	public Long andNot(Long t, byte n) {
		return t & ~n;
	}

	@Override
	public Long andNot(Long t, int n) {
		return t & ~n;
	}

	@Override
	public Long andNot(Long t, long n) {
		return (long) (t & ~n);
	}

	@Override
	public Long andNot(Long t, BitSet bs) {
		return t & ~Utils.bs.longValue(bs);
	}

	@Override
	public Long andNot(Long t, BigInteger bi) {
		return t & ~bi.longValue();
	}

	@Override
	public Long andNot(Long t, Bits b) {
		return t & ~b.longValue();
	}

	@Override
	public Long andNot(Long t1, Long t2) {
		return t1 & ~t2;
	}

	@Override
	public Long or(Long t, byte n) {
		return t | n;
	}

	@Override
	public Long or(Long t, int n) {
		return t | n;
	}

	@Override
	public Long or(Long t, long n) {
		return (long) (t | n);
	}

	@Override
	public Long or(Long t, BitSet bs) {
		return t | Utils.bs.longValue(bs);
	}

	@Override
	public Long or(Long t, BigInteger bi) {
		return t | bi.longValue();
	}

	@Override
	public Long or(Long t, Bits b) {
		return t | b.longValue();
	}

	@Override
	public Long or(Long t1, Long t2) {
		return t1 | t2;
	}

	@Override
	public Long xor(Long t, byte n) {
		return t ^ n;
	}

	@Override
	public Long xor(Long t, int n) {
		return t ^ n;
	}

	@Override
	public Long xor(Long t, long n) {
		return (long) (t ^ n);
	}

	@Override
	public Long xor(Long t, BitSet bs) {
		return t ^ Utils.bs.longValue(bs);
	}

	@Override
	public Long xor(Long t, BigInteger bi) {
		return t ^ bi.longValue();
	}

	@Override
	public Long xor(Long t, Bits b) {
		return t ^ b.longValue();
	}

	@Override
	public Long xor(Long t1, Long t2) {
		return t1 ^ t2;
	}

	@Override
	public Long not(Long t) {
		return ~t;
	}

	@Override
	public int intValue(Long t) {
		return t.intValue();
	}

	@Override
	public long longValue(Long t) {
		return t.longValue();
	}

	@Override
	public int[] words(Long t, Endian order) {
		return toIntArray(t);
	}

	@Override
	public int wordSize() {
		return Long.SIZE;
	}

	@Override
	public int wordsInUse(Long t) {
		return t >>> Integer.SIZE == 0 ? 1 : 2;
	}

	@Override
	public int lengthOfBits(Long t) {
		return Long.SIZE - numberOfLeadingZeros(t);
	}

	@Override
	public int countOfBits(Long t) {
		return Long.bitCount(t);
	}

	@Override
	public int getHighestClearIndex(Long t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getHighestSetIndex(Long t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getLowestClearIndex(Long t) {
		return nextClearBit(t, 0);
	}

	@Override
	public int getLowestSetIndex(Long t) {
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public boolean getBit(Long t, int bitIndex) {
		Check.index(bitIndex);
		int wordsInUse = wordsInUse(t);
		int wordIndex = wordIndex(bitIndex);
		return (wordIndex < wordsInUse) && ((t & (1L << bitIndex)) != 0);
	}

	@Override
	public Long getBits(Long t, int fromBitIndex, int toBitIndex) {
		Check.range(fromBitIndex, toBitIndex);
		long mask = (-1L) >>> (Long.SIZE - toBitIndex);
		return (t & mask) >>> fromBitIndex;
	}

	@Override
	public Long setBit(Long t, int bitIndex) {
		return t | (1L << bitIndex);
	}

	@Override
	public Long setBits(Long t, int fromBitIndex, int toBitIndex) {
		long first = 1L << fromBitIndex;
		long last = 1L >>> -toBitIndex;
		return t | (first & last);
	}

	@Override
	public Long clearBit(Long t, int bitIndex) {
		int wordIndex = Utils.wordIndex(bitIndex);
		if (wordIndex >= 2)
			return t;
		return t & ~(1L << bitIndex);
	}

	@Override
	public Long clearBits(Long t, int fromBitIndex, int toBitIndex) {
		long first = 1L << fromBitIndex;
		long last = 1L >>> -toBitIndex;
		return t & ~(first & last);
	}

	@Override
	public Long flipBit(Long t, int bitIndex) {
		return t ^ (1L << bitIndex);
	}

	@Override
	public Long flipBits(Long t, int fromBitIndex, int toBitIndex) {
		long first = 1L << fromBitIndex;
		long last = 1L >>> -toBitIndex;
		return t ^ (first & last);
	}

	@Override
	public int compare(Long a, Long b) {
		return Long.compare(a, b);
	}

	@Override
	public int nextSetBit(Long t, int offset) {
		if (offset < 0 || offset >= Long.SIZE) {
			return -1;
		}
		t = t & (-1L << offset);
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public int nextClearBit(Long t, int offset) {
		if (offset < 0 || offset >= Long.SIZE)
			return -1;

		t = ~t & (-1L << offset);
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public int previousSetBit(Long t, int offset) {
		if (offset < 0) {
			return -1;
		} else if (offset >= Long.SIZE) {
			return Long.SIZE - 1 - numberOfLeadingZeros(t);
		}
		t = t & (-1L >>> -(offset + 1));
		return Long.SIZE - 1 - numberOfLeadingZeros(t);
	}

	@Override
	public int previousClearBit(Long t, int offset) {
		if (offset < 0) {
			return -1;
		} else if (offset >= Long.SIZE) {
			return offset;
		}
		t = ~t & (-1L >>> -(offset + 1));
		return Long.SIZE - 1 - numberOfLeadingZeros(t);
	}

	@Override
	public boolean isMagnitudeBased() {
		return false;
	}
	
	@Override
	public Byte toByte(Long t) {
		return t.byteValue();
	}

	@Override
	public Integer toInteger(Long t) {
		return t.intValue();
	}

	@Override
	public Long toLong(Long t) {
		return t;
	}

	@Override
	public BitSet toBitSet(Long t) {
		return Utils.bs.of(t);
	}

	@Override
	public BigInteger toBigInteger(Long t) {
		return Utils.bi.of(t);
	}

	@Override
	public Bits toBits(Long t) {
		return Utils.b.of(t);
	}
}
