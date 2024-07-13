package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

public class BitSetUtils extends Utils<BitSet> {

	@Override
	BitSet ZERO() {
		return new BitSet();
	}

	@Override
	public BitSet ofSize(int bits_size) {
		return new BitSet(bits_size);
	}

	@Override
	public BitSet of(int n) {
		return of((long) n);
	}

	@Override
	public BitSet of(long n) {
		return BitSet.valueOf(new long[] { n });
	}

	@Override
	public BitSet of(byte[] bytes, int len, int sign, Endian order) {
		bytes = Arrays.copyOf(bytes, len);
		if (!order.isLittle()) {
			bytes =  Lang.reverse.in(bytes, len);
		}
		return BitSet.valueOf(bytes);
	}

	@Override
	public BitSet of(int[] words, int wordsInUse, int sign, Endian order) {
		long[] dwords = toLongArray(words, wordsInUse, order, Endian.LITTLE);
		return BitSet.valueOf(dwords);
	}

	@Override
	public BitSet of(long[] dwords, int dwordsInUse, int sign, Endian order) {
		dwords = Arrays.copyOf(dwords, dwordsInUse);
		if (!order.isLittle()) {
			dwords =  Lang.reverse.in(dwords, dwordsInUse);
		}
		return BitSet.valueOf(dwords);
	}

	@Override
	public BitSet of(BitSet bs, int sign) {
		return BitSet.valueOf(bs.toLongArray());
	}

	@Override
	public BitSet of(BigInteger bi) {
		byte[] bytes = bi.toByteArray();
		return of(bytes, bytes.length, bi.signum(), Endian.BIG);
	}

	@Override
	public BitSet of(Bits b) {
		return b.toBitSet();
	}

	@Override
	public BitSet of(BitSet t) {
		return BitSet.valueOf(t.toLongArray());
	}

	@Override
	public BitSet assign(BitSet t, int n) {
		t.clear();
		int offset = -1;
		while ((offset = i.nextSetBit(n, offset + 1)) != -1) {
			t.set(offset);
		}
		return t;
	}

	@Override
	public BitSet assign(BitSet t, long n) {
		t.clear();
		long word1 = (n >>> Integer.SIZE), word0 = (n & LONG_MASK);
		int offset = -1;
		while ((offset = l.nextSetBit(word0, offset + 1)) != -1) {
			t.set(offset);
		}

		offset = -1;
		while ((offset = l.nextSetBit(word1, offset + 1)) != -1) {
			t.set(offset + Integer.SIZE);
		}
		return t;
	}

	@Override
	public BitSet assign(BitSet t, int[] words, int wordsInUse, int sign, Endian order) {
		BitSet bs2 = of(words, wordsInUse, sign, order);
		t.clear();
		t.or(bs2);
		return t;
	}

	@Override
	public BitSet assign(BitSet t, BitSet n) {
		t.clear();
		int offset = -1;
		while ((offset = n.nextSetBit(offset + 1)) != -1) {
			t.set(offset);
		}
		return t;
	}

	@Override
	public BitSet assign(BitSet t, CharSequence cs, int radix) {
		return assign(t, of(cs, radix));
	}

	@Override
	public int numberOfLeadingZeros(BitSet t) {
		int size = sizeOf(t);
		return size - t.previousSetBit(size) - 1;
	}

	@Override
	public int numberOfTrailingZeros(BitSet t) {
		return t.nextSetBit(0);
	}

	@Override
	public BitSet shiftLeft(BitSet t, int shift) {
		int size = sizeOf(t);
		BitSet j3 = new BitSet();
		for (int i = 0; i < size; i++) {
			j3.set(i + shift, t.get(i));
		}
		return j3;
	}

	@Override
	public BitSet shiftRight(BitSet t, int shift) {
		int size = sizeOf(t);
		boolean msb = t.get(size - 1);
		BitSet ush = shiftRightUnsigned(t, shift);
		if (!msb)
			return ush;
		int from = shift >= size ? size : Digits.flip(shift, size) + 1;
		ush.set(from, size);
		return ush;
	}

	@Override
	public BitSet shiftRightUnsigned(BitSet t, int shift) {
		return t.get(shift, Math.max(shift, t.length()));
	}

	@Override
	public BitSet and(BitSet t, byte n) {
		t.and(of(n));
		return t;
	}

	@Override
	public BitSet and(BitSet t, int n) {
		t.and(of(n));
		return t;
	}

	@Override
	public BitSet and(BitSet t, long n) {
		t.and(of(n));
		return t;
	}

	@Override
	public BitSet and(BitSet t, BitSet bs) {
		t.and(bs);
		return t;
	}

	@Override
	public BitSet and(BitSet t, BigInteger bi) {
		t.and(of(bi));
		return t;
	}

	@Override
	public BitSet and(BitSet t, Bits b) {
		t.and(b.toBitSet());
		return t;
	}

	@Override
	public BitSet andNot(BitSet t, byte n) {
		t.andNot(of(n));
		return t;
	}

	@Override
	public BitSet andNot(BitSet t, int n) {
		t.andNot(of(n));
		return t;
	}

	@Override
	public BitSet andNot(BitSet t, long n) {
		t.andNot(of(n));
		return t;
	}

	@Override
	public BitSet andNot(BitSet t, BitSet bs) {
		t.andNot(bs);
		return t;
	}

	@Override
	public BitSet andNot(BitSet t, BigInteger bi) {
		t.andNot(of(bi));
		return t;
	}

	@Override
	public BitSet andNot(BitSet t, Bits b) {
		t.andNot(b.toBitSet());
		return t;
	}

	@Override
	public BitSet or(BitSet t, byte n) {
		t.or(of(n));
		return t;
	}

	@Override
	public BitSet or(BitSet t, int n) {
		t.or(of(n));
		return t;
	}

	@Override
	public BitSet or(BitSet t, long n) {
		t.or(of(n));
		return t;
	}

	@Override
	public BitSet or(BitSet t, BitSet bs) {
		t.or(bs);
		return t;
	}

	@Override
	public BitSet or(BitSet t, BigInteger bi) {
		t.or(of(bi));
		return t;
	}

	@Override
	public BitSet or(BitSet t, Bits b) {
		t.or(b.toBitSet());
		return t;
	}

	@Override
	public BitSet xor(BitSet t, byte n) {
		t.xor(of(n));
		return t;
	}

	@Override
	public BitSet xor(BitSet t, int n) {
		t.xor(of(n));
		return t;
	}

	@Override
	public BitSet xor(BitSet t, long n) {
		t.xor(of(n));
		return t;
	}

	@Override
	public BitSet xor(BitSet t, BitSet bs) {
		t.xor(bs);
		return t;
	}

	@Override
	public BitSet xor(BitSet t, BigInteger bi) {
		t.xor(of(bi));
		return t;
	}

	@Override
	public BitSet xor(BitSet t, Bits b) {
		t.xor(b.toBitSet());
		return t;
	}

	@Override
	public BitSet not(BitSet t) {
		t.flip(0, t.size());
		return t;
	}

	@Override
	public int intValue(BitSet t) {
		return (int) (words(t)[0] & Utils.BITS_WORD_MASK);
	}

	@Override
	public long longValue(BitSet t) {
		int[] words = words(t);
		long result = words[0] & Utils.LONG_MASK;
		if (wordsInUse(t) > 1) {
			result |= (((long) words[1] & Utils.BITS_WORD_MASK) << Integer.SIZE);
		}
		return result;
	}

	@Override
	public int[] words(BitSet t, Endian order) {
		long[] dwords = t.toLongArray();
		if (dwords.length == 0) {
			return new int[] { 0 };
		}
		return toIntArray(dwords, dwords.length);
	}

	@Override
	public int wordSize() {
		return Long.SIZE;
	}

	@Override
	public int wordsInUse(BitSet t) {
		if (t.isEmpty()) {
			return 1;
		}
		int len = t.length();
		// e.g: len = 33(00000000_00100001), dwordsInUse = 1
		// len >> ADDRESS_BITS_PER_WORD(5) = (00000000_00000001) that 1 word
		int wiu = len >> ADDRESS_BITS_PER_WORD;
		// len & BIT_INDEX_MASK(31)
		// 00000000_00100001
		// 00000000_00011111
		// ----------------
		// 00000000_00000001 that another 1 word
		wiu += ((len & BIT_INDEX_MASK) > 0 ? 1 : 0);
		return wiu == 0 ? 1 : wiu;
	}

	@Override
	public int lengthOfBits(BitSet t) {
		return t.length();
	}

	@Override
	public int countOfBits(BitSet t) {
		return t.cardinality();
	}

	@Override
	public int getHighestClearIndex(BitSet t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getHighestSetIndex(BitSet t) {
		return Utils.getHighestSet(words(t), wordsInUse(t));
	}

	@Override
	public int getLowestClearIndex(BitSet t) {
		return nextClearBit(t, 0);
	}

	@Override
	public int getLowestSetIndex(BitSet t) {
		return Utils.getLowestSet(words(t), wordsInUse(t));
	}

	@Override
	public boolean getBit(BitSet t, int bitIndex) {
		return t.get(bitIndex);
	}

	@Override
	public BitSet getBits(BitSet t, int fromBitIndex, int toBitIndex) {
		return t.get(fromBitIndex, toBitIndex);
	}

	@Override
	public BitSet setBit(BitSet t, int bitIndex) {
		t.set(bitIndex);
		return t;
	}

	@Override
	public BitSet setBits(BitSet t, int fromBitIndex, int toBitIndex) {
		t.set(fromBitIndex, toBitIndex);
		return t;
	}

	@Override
	public BitSet clearBit(BitSet t, int bitIndex) {
		t.clear(bitIndex);
		return t;
	}

	@Override
	public BitSet clearBits(BitSet t, int fromBitIndex, int toBitIndex) {
		t.clear(fromBitIndex, toBitIndex);
		return t;
	}

	@Override
	public BitSet flipBit(BitSet t, int bitIndex) {
		t.flip(bitIndex);
		return t;
	}

	@Override
	public BitSet flipBits(BitSet t, int fromBitIndex, int toBitIndex) {
		t.flip(fromBitIndex, toBitIndex);
		return t;
	}

	@Override
	public String toIndexes(BitSet t) {
		return t.toString();
	}

	@Override
	public int compare(BitSet a, BitSet b) {
		// e.g:
		// 1010
		// 1000 ^
		// ------
		// 0010
		// (diff index = 1), check if (a) has set index 1, means (a) is greater
		if (a.equals(b))
			return 0;
		BitSet aa = (BitSet) a.clone();
		aa.xor(b);
		int diff = aa.length() - 1;
		if (diff == -1)
			return 0;

		return a.get(diff) ? 1 : -1;
	}

	@Override
	public int nextSetBit(BitSet t, int offset) {
		return t.nextSetBit(offset);
	}

	@Override
	public int nextClearBit(BitSet t, int offset) {
		return t.nextClearBit(offset);
	}

	@Override
	public int previousSetBit(BitSet t, int offset) {
		return t.previousSetBit(offset);
	}

	@Override
	public int previousClearBit(BitSet t, int offset) {
		return t.previousClearBit(offset);
	}

	@Override
	public boolean isMagnitudeBased() {
		return true;
	}
	
	@Override
	public Byte toByte(BitSet t) {
		return byteValue(t);
	}

	@Override
	public Integer toInteger(BitSet t) {
		return intValue(t);
	}

	@Override
	public Long toLong(BitSet t) {
		return longValue(t);
	}

	@Override
	public BitSet toBitSet(BitSet t) {
		return of(t);
	}

	@Override
	public BigInteger toBigInteger(BitSet t) {
		return Utils.bi.of(t);
	}

	@Override
	public Bits toBits(BitSet t) {
		return Utils.b.of(t);
	}

}
