package codes.abdullah.bigbit;

import static java.lang.String.format;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.BitSet;

import org.junit.Test;

import codes.abdullah.digits.Digits;
import codes.abdullah.digits.RandomIndex;
import codes.abdullah.project.ImplementationRequiredException;

public class BitsTest {

	private static final boolean immutable = false;
	private static final int loops = 1 << 10;
	private static final int min_bit = 512, max_bit = 2048;
	private static final Utils[] utils = new Utils[] { Utils.i, Utils.l, Utils.b, Utils.bs, Utils.bi };

	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDefaults() {
		Bits b = Bits.of().flagDecimal();
		for (Utils<T> u : utils) {
			T t = u.ofRandomSize(Digits.ints.random(min_bit, max_bit));
			
			b = b.assign(u.toBits(t));

			testGetBits(u, t, b);
			testSetBits(u, t, b);
			testClearBits(u, t, b);
			testFlipBits(u, t, b);
			testAnd(u, t, b);
			testOr(u, t, b);
			testXOr(u, t, b);
			testAndNot(u, t, b);
			testNot(u, t, b);
			if(!b.isFlagged(Bits.FLAG_TO_STRING_DECIMAL))
				throw new ImplementationRequiredException();
			
		}
	}

	public static <T> void testGetBits(Utils<T> u, T t, Bits b) {

		final String srcinfo = info(t, b);
		RandomIndex ri = new RandomIndex(b.size()).setInfinite(true);
		for (int i = 0; i < b.size(); i++) {
			String info = format("src:%s\nindex:%s", srcinfo, i);

			assertEquals(info, u.getBit(t, i), b.get(i));

			int from = ri.nextFrom();
			int to = ri.nextTo(from);

			String rangeinfo = format("[%d-%d]", from, to);

			Bits bsub = b.get(from, to);
			T tsub = u.getBits(t, from, to);

			info = format("src:%s\nrange:%s\n%s", srcinfo, rangeinfo, info(tsub, bsub));

			basicAssertion(u, tsub, bsub, info);
		}
	}

	public static <T> void testSetBits(Utils<T> u, T t, Bits b) {
		String srcinfo = info(t, b);
		RandomIndex ri = new RandomIndex(b.size()).setInfinite(true);
		for (int i = 0; i < b.size(); i++) {
			T t2 = u.of(t);
			Bits b2 = b.newClone();

			int bitIndex = ri.setLength(b2.size()).next();

			t2 = u.setBit(t2, bitIndex);
			b2 = b2.set(bitIndex);

			String info = format("src:%s\nbitIndex:%s\n%s", srcinfo, bitIndex, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================
			t2 = u.of(t);
			b2 = b.newClone();

			int from = ri.nextFrom();
			int to = ri.nextTo(from);

			String rangeinfo = format("[%d-%d]", from, to);

			t2 = u.setBits(t2, from, to);
			b2 = b2.set(from, to);

			info = format("src:%s\nrange:%s\n%s", srcinfo, rangeinfo, info(t2, b2));

			basicAssertion(u, t2, b2, info);
		}
	}

	public static <T> void testClearBits(Utils<T> u, T t, Bits b) {
		String srcinfo = info(t, b);
		RandomIndex ri = new RandomIndex(b.size()).setInfinite(true);
		for (int i = 0; i < b.size(); i++) {
			T t2 = u.of(t);
			Bits b2 = b.newClone();

			int bitIndex = ri.setLength(b2.size()).next();

			t2 = u.clearBit(t2, bitIndex);
			b2 = b2.clear(bitIndex);

			String info = format("src:%s\nbitIndex:%s\n%s", srcinfo, bitIndex, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================
			t2 = u.of(t);
			b2 = b.newClone();

			int from = ri.nextFrom();
			int to = ri.nextTo(from);

			String rangeinfo = format("[%d-%d]", from, to);

			t2 = u.clearBits(t2, from, to);
			b2 = b2.clear(from, to);

			info = format("src:%s\nrange:%s\n%s", srcinfo, rangeinfo, info(t2, b2));

			basicAssertion(u, t2, b2, info);
		}
	}

	public static <T> void testFlipBits(Utils<T> u, T t, Bits b) {
		String srcinfo = info(t, b);
		RandomIndex ri = new RandomIndex(b.size()).setInfinite(true);
		for (int i = 0; i < b.size(); i++) {
			T t2 = u.of(t);
			Bits b2 = b.newClone();

			int bitIndex = ri.setLength(b2.size()).next();

			t2 = u.flipBit(t2, bitIndex);
			b2 = b2.flip(bitIndex);

			String info = format("src:%s\nbitIndex:%s\n%s", srcinfo, bitIndex, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================
			t2 = u.of(t);
			b2 = b.newClone();

			int from = ri.nextFrom();
			int to = ri.nextTo(from);

			String rangeinfo = format("[%d-%d]", from, to);

			t2 = u.flipBits(t2, from, to);
			b2 = b2.flip(from, to);

			info = format("src:%s\nrange:%s\n%s", srcinfo, rangeinfo, info(t2, b2));

			basicAssertion(u, t2, b2, info);
		}
	}

	public static <T> void testAnd(Utils<T> u, T t, Bits b) {
		String srcinfo = info(t, b);
		for (int i = 0; i < loops; i++) {
			byte by = (byte) Digits.RANDOM.nextInt();

			T t2 = u.of(t);
			Bits b2 = b.newClone();

			t2 = u.and(t2, by);
			b2 = b2.and(by);

			String andby = format("%d", by);
			String info = format("src:%s\nand:%s\n%s", srcinfo, andby, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			int in = Digits.RANDOM.nextInt();

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.and(t2, in);
			b2 = b2.and(in);

			String andin = format("%d", in);
			info = format("src:%s\nand:%s\n%s", srcinfo, andin, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			long lo = Digits.RANDOM.nextLong();

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.and(t2, lo);
			b2 = b2.and(lo);

			String andlo = format("%d", lo);
			info = format("src:%s\nand:%s\n%s", srcinfo, andlo, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			BitSet bs = Utils.bs.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.and(t2, bs);
			b2 = b2.and(Utils.b.of(bs));

			String andbs = format("%s", bs);
			info = format("src:%s\nand:%s\n%s", srcinfo, andbs, info(t2, b2));

			basicAssertion(u, t2, b2);
			// =======================

			BigInteger bi = Utils.bi.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.and(t2, bi);
			b2 = b2.and(Utils.b.of(bs));

			String andbi = format("%s", bi);
			info = format("src:%s\nand:%s\n%s", srcinfo, andbi, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			T xx = u.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.and(t2, xx);
			b2 = b2.and(u.toBits(xx));

			String andxx = format("%s", xx);
			info = format("src:%s\nand:%s\n%s", srcinfo, andxx, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

		}
	}

	public static <T> void testOr(Utils<T> u, T t, Bits b) {

		String srcinfo = info(t, b);
		for (int i = 0; i < loops; i++) {
			byte by = (byte) Digits.RANDOM.nextInt();

			T t2 = u.of(t);
			Bits b2 = b.newClone();

			t2 = u.or(t2, by);
			b2 = b2.or(by);

			String orby = format("%d", by);
			String info = format("src:%s\nor:%s\n%s", srcinfo, orby, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			int in = Digits.RANDOM.nextInt();

			t2 = u.of(t);
			b2 = b.newClone();
			


			t2 = u.or(t2, in);
			b2 = b2.or(in);

			String orin = format("%d", in);
			info = format("src:%s\nor:%s\n%s", srcinfo, orin, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			long lo = Digits.RANDOM.nextLong();

			t2 = u.of(t);
			b2 = b.newClone();
			
			t2 = u.or(t2, lo);
			b2 = b2.or(lo);

			String orlo = format("%d", lo);
			info = format("src:%s\nor:%s\n%s", srcinfo, orlo, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			BitSet bs = Utils.bs.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.or(t2, bs);
			b2 = b2.or(Utils.b.of(bs));

			String orbs = format("%s", bs);
			info = format("src:%s\nor:%s\n%s", srcinfo, orbs, info(t2, b2));

			basicAssertion(u, t2, b2);
			// =======================

			BigInteger bi = Utils.bi.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.or(t2, bi);
			b2 = b2.or(Utils.b.of(bs));

			String orbi = format("%s", bi);
			info = format("src:%s\nor:%s\n%s", srcinfo, orbi, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			T xx = u.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.or(t2, xx);
			b2 = b2.or(u.toBits(xx));

			String orxx = format("%s", xx);
			info = format("src:%s\nor:%s\n%s", srcinfo, orxx, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

		}
	}

	public static <T> void testXOr(Utils<T> u, T t, Bits b) {
		String srcinfo = info(t, b);
		for (int i = 0; i < loops; i++) {
			byte by = (byte) Digits.RANDOM.nextInt();

			T t2 = u.of(t);
			Bits b2 = b.newClone();

			t2 = u.xor(t2, by);
			b2 = b2.xor(by);

			String xorby = format("%d", by);
			String info = format("src:%s\nxor:%s\n%s", srcinfo, xorby, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			int in = Digits.RANDOM.nextInt();

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.xor(t2, in);
			b2 = b2.xor(in);

			String xorin = format("%d", in);
			info = format("src:%s\nxor:%s\n%s", srcinfo, xorin, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			long lo = Digits.RANDOM.nextLong();

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.xor(t2, lo);
			b2 = b2.xor(lo);

			String xorlo = format("%d", lo);
			info = format("src:%s\nxor:%s\n%s", srcinfo, xorlo, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			BitSet bs = Utils.bs.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.xor(t2, bs);
			b2 = b2.xor(Utils.b.of(bs));

			String xorbs = format("%s", bs);
			info = format("src:%s\nxor:%s\n%s", srcinfo, xorbs, info(t2, b2));

			basicAssertion(u, t2, b2);
			// =======================

			BigInteger bi = Utils.bi.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.xor(t2, bi);
			b2 = b2.xor(Utils.b.of(bs));

			String xorbi = format("%s", bi);
			info = format("src:%s\nxor:%s\n%s", srcinfo, xorbi, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			T xx = u.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.xor(t2, xx);
			b2 = b2.xor(u.toBits(xx));

			String xorxx = format("%s", xx);
			info = format("src:%s\nxor:%s\n%s", srcinfo, xorxx, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

		}
	}

	public static <T> void testAndNot(Utils<T> u, T t, Bits b) {
		String srcinfo = info(t, b);
		for (int i = 0; i < loops; i++) {
			byte by = (byte) Digits.RANDOM.nextInt();

			T t2 = u.of(t);
			Bits b2 = b.newClone();

			t2 = u.andNot(t2, by);
			b2 = b2.andNot(by);

			String andNotby = format("%d", by);
			String info = format("src:%s\nandNot:%s\n%s", srcinfo, andNotby, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			int in = Digits.RANDOM.nextInt();

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.andNot(t2, in);
			b2 = b2.andNot(in);

			String andNotin = format("%d", in);
			info = format("src:%s\nandNot:%s\n%s", srcinfo, andNotin, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			long lo = Digits.RANDOM.nextLong();

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.andNot(t2, lo);
			b2 = b2.andNot(lo);

			String andNotlo = format("%d", lo);
			info = format("src:%s\nandNot:%s\n%s", srcinfo, andNotlo, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			BitSet bs = Utils.bs.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.andNot(t2, bs);
			b2 = b2.andNot(Utils.b.of(bs));

			String andNotbs = format("%s", bs);
			info = format("src:%s\nandNot:%s\n%s", srcinfo, andNotbs, info(t2, b2));

			basicAssertion(u, t2, b2);
			// =======================

			BigInteger bi = Utils.bi.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.andNot(t2, bi);
			b2 = b2.andNot(Utils.b.of(bs));

			String andNotbi = format("%s", bi);
			info = format("src:%s\nandNot:%s\n%s", srcinfo, andNotbi, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

			T xx = u.ofRandomRange(min_bit, max_bit);

			t2 = u.of(t);
			b2 = b.newClone();

			t2 = u.andNot(t2, xx);
			b2 = b2.andNot(u.toBits(xx));

			String andNotxx = format("%s", xx);
			info = format("src:%s\nandNot:%s\n%s", srcinfo, andNotxx, info(t2, b2));

			basicAssertion(u, t2, b2, info);
			// =======================

		}
	}

	public static <T> void testNot(Utils<T> u, T t, Bits b) {
		T t2 = u.of(t);
		Bits b2 = b.newClone();

		t2 = u.not(t2);
		b2= b2.not();

		basicAssertion(u, t2, b2);
	}

	public static <T> void basicAssertion(Utils<T> u, T t, Bits b) {
		basicAssertion(u, t, b, null);
	}

	public static <T> void basicAssertion(Utils<T> u, T t, Bits b, final String srcinfo) {
//		final String innerinfo = info(t, b);
//		final String info = srcinfo != null ? (srcinfo + innerinfo) : innerinfo;
		String info = srcinfo == null ? info(t, b) : srcinfo;
		b = assign(t, b);
		// ===========
		assertArrayEquals(info, u.words(t), b.toIntegerArray());
		assertEquals(info, u.wordsInUse(t), b.wordsInUse());
		assertEquals(info, u.lengthOfBits(t), b.length());
		assertEquals(info, u.countOfBits(t), b.cardinality());
		assertEquals(info, u.isEmpty(t), b.isEmpty());
		assertEquals(info, u.isZero(t), b.isZero());
		if (u.wordSize() == Utils.b.wordSize()) {
			assertEquals(info, u.isFull(t), b.isFull());
			assertEquals(info, u.sizeOf(t), b.size());
		}
		// ===========
//		RandomIndex ri = new RandomIndex(b.size()).setInfinite(true);
//		int max = Integer.max(u.sizeOf(t), b.size());
//		for (int i = 0; i < max; i++) {
//			assertEquals(info, u.getBit(t, i), b.get(i));
//
//			int from = ri.nextFrom();
//			int to = ri.nextTo(from);
//
//			Bits bsub = b.get(from, to);
//			T tsub = u.getBits(t, from, to);
//
//			String info2 = stringfy(tsub, bsub, "get()");
//			basicAssertion(u, tsub, bsub);
//		}
	}

	private static <T> Bits assign(T t, Bits b) {
		if (t instanceof Byte) {
			return b.assign(((Byte) t));
		} else if (t instanceof Integer) {
			return b.assign((Integer) t);
		} else if (t instanceof Long) {
			return b.assign((Long) t);
		} else if (t instanceof BitSet) {
			return b.assign((BitSet) t);
		} else if (t instanceof BigInteger) {
			return b.assign((BigInteger) t);
		} else if (t instanceof Bits) {
			return b.assign((Bits) t);
		}
		throw new UnsupportedOperationException(t.getClass().getSimpleName());
	}

	private static int randomIndex(int max) {
		return Digits.ints.random(0, max);
	}

	private static String param(Object o) {
		return o.getClass().getSimpleName() + "(" + o + ")";
	}

	private static String info(Object t, Object b) {
		return param(t) + "\n" + param(b);
	}

	private static String info(Object o) {
		return param(o);
	}

	private static String buildformat(int len) {
		StringBuffer s = new StringBuffer("\n%s\n");
		for (int i = 1; i < len; i++) {
			s.append("\n%s\n");
		}
		return s.toString();
	}
}
