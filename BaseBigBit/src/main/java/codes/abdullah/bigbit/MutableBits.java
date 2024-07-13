package codes.abdullah.bigbit;

import java.util.Arrays;

import codes.abdullah.project.ImplementationRequiredException;

class MutableBits extends Bits {
	private static final long serialVersionUID = -2359074374365516021L;
	private int[] words;
	private int wordsInUse, flags, lowerBound, upperBound, sign;

	MutableBits() {
		this(Integer.SIZE);
	}

	MutableBits(int nbits) {
		this(Utils.allocateBySize(nbits), 1, Utils.DEFAULT_SIGNUM, 0, Utils.DEFAULT_BOUNDS, Utils.MAX_WORDS_LENGTH,
				false);
	}

	MutableBits(int[] words, int wordsInUse, int sign, int flags, int lowerBound, int upperBound, boolean recopy) {
		Utils.checkBounds(lowerBound, upperBound);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.sign = Utils.isFlagged(flags, Bits.FLAG_UNSIGNED) ? Utils.DEFAULT_SIGNUM : Utils.checkSign(sign);
		this.words = recopy ? Arrays.copyOf(Utils.checkWords(words), wordsInUse) : Utils.checkWords(words);
		this.wordsInUse = Utils.checkWordsInUse(wordsInUse);
		this.flags = flags;
	}

	@Override
	public Bits setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	@Override
	public Bits setBounds(int lowerBound, int upperBound) {
		Utils.checkBounds(lowerBound, upperBound);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		return this;
	}

	@Override
	int flags() {
		return flags;
	}

	@Override
	int[] safe() {
		return words;
	}

	@Override
	int[] unsafe() {
		return words;
	}

	@Override
	public int wordsInUse() {
		return wordsInUse;
	}

	@Override
	public int getLowerBound() {
		return lowerBound;
	}
	
	@Override
	public int getUpperBound() {
		return upperBound;
	}

	@Override
	Bits assign(int[] words, int wordsInUse, int sign, int flags, int lowerBound, int upperBound) {
		Utils.checkBounds(lowerBound, upperBound);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.words = Utils.checkWords(words);
		this.wordsInUse = Utils.checkWordsInUse(wordsInUse);
		this.flags = flags;
		this.sign = Utils.isFlagged(flags, Bits.FLAG_UNSIGNED) ? Utils.DEFAULT_SIGNUM : Utils.checkSign(sign);
		return this;
	}

	@Override
	Bits newInstance(int nbits) {
		return new MutableBits(nbits);
	}

	@Override
	Bits newInstance(int[] words, int wordsInUse, int sign, int flags, int lowerBound, int upperBound) {
		return new MutableBits(words, wordsInUse, sign, flags, lowerBound, upperBound, false);
	}

	@Override
	public Bits toImmutable() {
		throw new ImplementationRequiredException();
	}

	@Override
	public Bits toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public int sign() {
		return sign;
	}
}
