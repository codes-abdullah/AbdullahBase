package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.BitSet;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Endian;

public class ByteUtils extends Utils<Byte> {
	private static final byte BYTE_MASK = -1;

	@Override
	public Byte ofSize(int bits_size) {
		return 0;
	}

	@Override
	public Byte of(int n) {
		return (byte) n;
	}

	@Override
	public Byte of(long n) {
		return (byte) n;
	}

	@Override
	public Byte of(byte[] bytes, int len, int sign, Endian order) {
		byte l = bytes[0];
		if (!order.isLittle()) {
			l = bytes[len - 1];
		}
		if (sign < 0) {
			return (byte) (l < 0 ? l : -l);
		}
		return (byte) (l < 0 ? -l : l);
	}

	@Override
	public Byte of(int[] words, int wordsInUse, int sign, Endian order) {
		byte[] bytes = toByteArray(words, wordsInUse, order);
		return of(bytes, bytes.length, sign);
	}

	@Override
	public Byte of(long[] dwords, int dwordsInUse, int sign, Endian order) {
		byte[] bytes = toByteArray(dwords, dwordsInUse, order);
		return of(bytes, bytes.length, sign);
	}

	@Override
	public Byte of(BitSet bs, int sign) {
		byte[] bytes = bs.toByteArray();
		return of(bytes, bytes.length, sign);
	}

	@Override
	public Byte of(BigInteger bi) {
		byte[] bytes = bi.toByteArray();
		return of(bytes, bytes.length, bi.signum(), Endian.BIG);
	}

	@Override
	public Byte of(Bits b) {
		return b.byteValue();
	}

	@Override
	public Byte of(Byte t) {
		return t;
	}

	@Override
	public Byte assign(Byte t, int n) {
		return (byte) n;
	}

	@Override
	public Byte assign(Byte t, long n) {
		return (byte) n;
	}

	@Override
	public Byte assign(Byte t, int[] words, int wordsInUse, int sign, Endian order) {
		byte[] bytes = toByteArray(words, wordsInUse, order);
		return of(bytes, bytes.length, sign);
	}

	@Override
	public Byte assign(Byte t, Byte n) {
		return n;
	}

	@Override
	public Byte assign(Byte t, CharSequence cs, int radix) {
		return (byte) Digits.parseInt(cs, radix);
	}

	@Override
	public int numberOfLeadingZeros(Byte t) {
		if (t < 0) {
			return 0;
		}
		return Integer.SIZE - Integer.numberOfLeadingZeros(t);
	}

	@Override
	public int numberOfTrailingZeros(Byte t) {
		if (t == 0) {
			return Byte.SIZE;
		}
		return Integer.numberOfTrailingZeros(t);
	}

	@Override
	public Byte shiftLeft(Byte t, int shift) {
		return (byte) (t << shift);
	}

	@Override
	public Byte shiftRight(Byte t, int shift) {
		return (byte) (t >> shift);
	}

	@Override
	public Byte shiftRightUnsigned(Byte t, int shift) {
		return (byte) (t >>> shift);
	}

	@Override
	public Byte and(Byte t, byte n) {
		return (byte) (t & n);
	}

	@Override
	public Byte and(Byte t, int n) {
		return (byte) (t & n);
	}

	@Override
	public Byte and(Byte t, long n) {
		return (byte) (t & n);
	}

	@Override
	public Byte and(Byte t, BitSet bs) {
		return (byte) (t & Utils.bs.byteValue(bs));
	}

	@Override
	public Byte and(Byte t, BigInteger bi) {
		return (byte) (t & bi.byteValue());
	}

	@Override
	public Byte and(Byte t, Bits b) {
		return (byte) (t & b.byteValue());
	}

	@Override
	public Byte and(Byte t1, Byte t2) {
		return (byte) (t1.byteValue() & t2.byteValue());
	}

	@Override
	public Byte andNot(Byte t, byte n) {
		return (byte) (t & ~n);
	}

	@Override
	public Byte andNot(Byte t, int n) {
		return (byte) (t & ~n);
	}

	@Override
	public Byte andNot(Byte t, long n) {
		return (byte) (t & ~n);
	}

	@Override
	public Byte andNot(Byte t, BitSet bs) {
		return (byte) (t & ~Utils.bs.byteValue(bs));
	}

	@Override
	public Byte andNot(Byte t, BigInteger bi) {
		return (byte) (t & ~bi.byteValue());
	}

	@Override
	public Byte andNot(Byte t, Bits b) {
		return (byte) (t & ~b.byteValue());
	}

	@Override
	public Byte andNot(Byte t1, Byte t2) {
		return (byte) (t1.byteValue() & ~t2.byteValue());
	}

	@Override
	public Byte or(Byte t, byte n) {
		return (byte) (t | n);
	}

	@Override
	public Byte or(Byte t, int n) {
		return (byte) (t | n);
	}

	@Override
	public Byte or(Byte t, long n) {
		return (byte) (t | n);
	}

	@Override
	public Byte or(Byte t, BitSet bs) {
		return (byte) (t | Utils.bs.byteValue(bs));
	}

	@Override
	public Byte or(Byte t, BigInteger bi) {
		return (byte) (t | bi.byteValue());
	}

	@Override
	public Byte or(Byte t, Bits b) {
		return (byte) (t | b.byteValue());
	}

	@Override
	public Byte or(Byte t1, Byte t2) {
		return (byte) (t1.byteValue() | t2.byteValue());
	}

	@Override
	public Byte xor(Byte t, byte n) {
		return (byte) (t ^ n);
	}

	@Override
	public Byte xor(Byte t, int n) {
		return (byte) (t ^ n);
	}

	@Override
	public Byte xor(Byte t, long n) {
		return (byte) (t ^ n);
	}

	@Override
	public Byte xor(Byte t, BitSet bs) {
		return (byte) (t ^ Utils.bs.byteValue(bs));
	}

	@Override
	public Byte xor(Byte t, BigInteger bi) {
		return (byte) (t ^ bi.byteValue());
	}

	@Override
	public Byte xor(Byte t, Bits b) {
		return (byte) (t ^ b.byteValue());
	}

	@Override
	public Byte xor(Byte t1, Byte t2) {
		return (byte) (t1.byteValue() ^ t2.byteValue());
	}

	@Override
	public Byte not(Byte t) {
		return (byte) ~t;
	}

	@Override
	public int intValue(Byte t) {
		return t.intValue();
	}

	@Override
	public long longValue(Byte t) {
		return t.longValue();
	}

	@Override
	public int[] words(Byte t, Endian order) {
		return new int[] { t };
	}

	@Override
	public int wordSize() {
		return Byte.SIZE;
	}

	@Override
	public int wordsInUse(Byte t) {
		return 1;
	}

	@Override
	public int lengthOfBits(Byte t) {
		return numberOfLeadingZeros(t);
	}

	@Override
	public int countOfBits(Byte t) {
		return Integer.bitCount(t);
	}

	@Override
	public int getHighestClearIndex(Byte t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getHighestSetIndex(Byte t) {
		return previousClearBit(t, sizeOf(t) - 1);
	}

	@Override
	public int getLowestClearIndex(Byte t) {
		return nextClearBit(t, 0);
	}

	@Override
	public int getLowestSetIndex(Byte t) {
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public boolean getBit(Byte t, int bitIndex) {
		return Utils.i.getBit(t.intValue(), bitIndex);
	}

	@Override
	public Byte getBits(Byte t, int fromBitIndex, int toBitIndex) {
		return Utils.i.getBits(t.intValue(), fromBitIndex, toBitIndex).byteValue();
	}

	@Override
	public Byte setBit(Byte t, int bitIndex) {
		return Utils.i.setBit(t.intValue(), bitIndex).byteValue();
	}

	@Override
	public Byte setBits(Byte t, int fromBitIndex, int toBitIndex) {
		return Utils.i.setBits(t.intValue(), fromBitIndex, toBitIndex).byteValue();
	}

	@Override
	public Byte clearBit(Byte t, int bitIndex) {
		return Utils.i.clearBit(t.intValue(), bitIndex).byteValue();
	}

	@Override
	public Byte clearBits(Byte t, int fromBitIndex, int toBitIndex) {
		return Utils.i.clearBits(t.intValue(), fromBitIndex, toBitIndex).byteValue();
	}

	@Override
	public Byte flipBit(Byte t, int bitIndex) {
		return Utils.i.flipBit(t.intValue(), bitIndex).byteValue();
	}

	@Override
	public Byte flipBits(Byte t, int fromBitIndex, int toBitIndex) {
		return Utils.i.flipBits(t.intValue(), fromBitIndex, toBitIndex).byteValue();
	}

	
	
	
	@Override
	public int compare(Byte a, Byte b) {
		return Byte.compare(a, b);
	}

	@Override
	public int nextSetBit(Byte t, int offset) {
		if (offset < 0 || offset >= Byte.SIZE) {
			return -1;
		}
		t = (byte) (t & (BYTE_MASK << offset));
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public int nextClearBit(Byte t, int offset) {
		if (offset < 0 || offset >= Byte.SIZE)
			return -1;

		t = (byte) (~t & (BYTE_MASK << offset));
		if (t == 0) {
			return -1;
		}
		return numberOfTrailingZeros(t);
	}

	@Override
	public int previousSetBit(Byte t, int offset) {
		if (offset < 0) {
			return -1;
		} else if (offset >= Byte.SIZE) {
			return Byte.SIZE - 1 - numberOfLeadingZeros(t);
		}
		t = (byte) (t & (BYTE_MASK >>> -(offset + 1)));
		return Byte.SIZE - 1 - numberOfLeadingZeros(t);
	}

	@Override
	public int previousClearBit(Byte t, int offset) {
		if (offset < 0) {
			return -1;
		} else if (offset >= Byte.SIZE) {
			return offset;
		}
		t = (byte) (~t & (BYTE_MASK >>> -(offset + 1)));
		return Byte.SIZE - 1 - numberOfLeadingZeros(t);
	}

	@Override
	public boolean isMagnitudeBased() {
		return false;
	}

	@Override
	public Byte toByte(Byte t) {
		return t;
	}

	@Override
	public Integer toInteger(Byte t) {
		return t.intValue();
	}

	@Override
	public Long toLong(Byte t) {
		return t.longValue();
	}

	@Override
	public BitSet toBitSet(Byte t) {
		return Utils.bs.of(t);
	}

	@Override
	public BigInteger toBigInteger(Byte t) {
		return Utils.bi.of(t);
	}

	@Override
	public Bits toBits(Byte t) {
		return Utils.b.of(t);
	}

}
