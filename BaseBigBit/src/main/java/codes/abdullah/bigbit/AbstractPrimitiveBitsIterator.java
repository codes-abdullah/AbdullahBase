package codes.abdullah.bigbit;

import java.math.BigInteger;

import codes.abdullah.digits.Digits;

abstract class AbstractPrimitiveBitsIterator<T> implements BitsIterator {
	protected final Utils<T> u;
	protected final T t;
	protected final int wordsInUse, size, length;
	protected int bitIndex, next;

	public AbstractPrimitiveBitsIterator(Utils<T> u, T t) {
		this.u = u;
		this.t = t;
		this.wordsInUse = u.wordsInUse(t);
		this.size = u.sizeOf(t);
		this.length = u.lengthOfBits(t);
		init();
	}

	/**
	 * will be invoked before exiting constructor by default to allow implementer to
	 * initial extras
	 */
	abstract void init();

	@Override
	public Number value() {
		int bi = bitIndex();
		if (bi <= 30) {
			return Digits.ints.powV2(2, bi);
		} else if (bi <= 62) {
			return Digits.ints.pow(2, bi);
		}
		// TODO mutable
		return BigInteger.valueOf(2).pow(bi);
	}

	@Override
	public int bitIndex() {
		return bitIndex;
	}

	@Override
	public int wordIndex() {
		return Utils.wordIndex(bitIndex);
	}
}
