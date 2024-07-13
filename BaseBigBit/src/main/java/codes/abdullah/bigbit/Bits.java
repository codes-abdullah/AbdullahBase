package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.BitSet;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import codes.abdullah.chars.Chars;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;
import codes.abdullah.project.Immutable;
import codes.abdullah.project.ImplementationRequiredException;
import codes.abdullah.project.lang.Lang;

//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------
// to find how much an element of magnitude is carrying
// e.g  {1, 3, 2}, the element-index 2, how much inside it, use this equation
// R = C . M^I
// where is:
// R = result
// C: Count of targeted element
// M: Mask of the magnitude
// I: Index of element
// e.g: {1, 3, 2}, mask = 4, element-index = 2
// 2 . 4^2
// 2 . 16
// R = 32
//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------
//------------------------------------------------------

// [0] [1] [2] [3]
// 1 2 4 8
// [4] [5] [6] [7]
// 16 32 64 128
// [8] [9] [10] [11]
// 256 512 1024 2048
// [12] [13] [14] [15]
// 4096 8192 16384 32768
// [16] [17] [18] [19]
// 65536 131072 262144 524288
// [20] [21] [22] [23]
// 1048576 2097152 4194304 8388608
// [24] [25] [26] [27]
// 16777216 33554432 67108864 134217728
// [28] [29] [30] [31]
// 268435456 536870912 1073741824 2147483648
//------------------------------------------------------
//2^0 = 1
//2^1 = 2
//2^2 = 4
//2^3 = 8
//2^4 = 16
//2^5 = 32
//2^6 = 64
//2^7 = 128
//2^8 = 256
//2^9 = 512
//2^10 = 1,024
//2^11 = 2,048
//2^12 = 4,096
//2^13 = 8,192
//2^14 = 16,384
//2^15 = 32,768
//2^16 = 65,536
//2^17 = 131,072
//2^18 = 262,144
//2^19 = 524,288
//2^20 = 1,048,576
//2^21 = 2,097,152
//2^22 = 4,194,304
//2^23 = 8,388,608
//2^24 = 16,777,216
//2^25 = 33,554,432
//2^26 = 67,108,864
//2^27 = 134,217,728
//2^28 = 268,435,456
//2^29 = 536,870,912
//2^30 = 1,073,741,824
//2^31 = 2,147,483,648
//2^32 = 4,294,967,296
//2^33 = 8,589,934,592
//2^34 = 17,179,869,184
//2^35 = 34,359,738,368
//2^36 = 68,719,476,736
//2^37 = 137,438,953,472
//2^38 = 274,877,906,944
//2^39 = 549,755,813,888
//2^40 = 1,099,511,627,776
//2^41 = 2,199,023,255,552
//2^42 = 4,398,046,511,104
//2^43 = 8,796,093,022,208
//2^44 = 17,592,186,044,416
//2^45 = 35,184,372,088,832
//2^46 = 70,368,744,177,664
//2^47 = 140,737,488,355,328
//2^48 = 281,474,976,710,656
//2^49 = 562,949,953,421,312
//2^50 = 1,125,899,906,842,624
//2^51 = 2,251,799,813,685,248
//2^52 = 4,503,599,627,370,496
//2^53 = 9,007,199,254,740,992
//2^54 = 18,014,398,509,481,984
//2^55 = 36,028,797,018,963,968
//2^56 = 72,057,594,037,927,936
//2^57 = 144,115,188,075,855,872
//2^58 = 288,230,376,151,711,744
//2^59 = 576,460,752,303,423,488
//2^60 = 1,152,921,504,606,846,976
//2^61 = 2,305,843,009,213,693,952
//2^62 = 4,611,686,018,427,387,904
//2^63 = 9,223,372,036,854,775,808
//2^64 = 18,446,744,073,709,551,616
//2^65 = 36,893,488,147,419,103,232
//2^66 = 73,786,976,294,838,206,464
//2^67 = 147,573,952,589,676,412,928
//2^68 = 295,147,905,179,352,825,856
//2^69 = 590,295,810,358,705,651,712
//2^70 = 1,180,591,620,717,411,303,424
//2^71 = 2,361,183,241,434,822,606,848
//2^72 = 4,722,366,482,869,645,213,696
//2^73 = 9,444,732,965,739,290,427,392
//2^74 = 18,889,465,931,478,580,854,784
//2^75 = 37,778,931,862,957,161,709,568
//2^76 = 75,557,863,725,914,323,419,136
//2^77 = 151,115,727,451,828,646,838,272
//2^78 = 302,231,454,903,657,293,676,544
//2^79 = 604,462,909,807,314,587,353,088
//2^80 = 1,208,925,819,614,629,174,706,176
//2^81 = 2,417,851,639,229,258,349,412,352
//2^82 = 4,835,703,278,458,516,698,824,704
//2^83 = 9,671,406,556,917,033,397,649,408
//2^84 = 19,342,813,113,834,066,795,298,816
//2^85 = 38,685,626,227,668,133,590,597,632
//2^86 = 77,371,252,455,336,267,181,195,264
//2^87 = 154,742,504,910,672,534,362,390,528
//2^88 = 309,485,009,821,345,068,724,781,056
//2^89 = 618,970,019,642,690,137,449,562,112
//2^90 = 1,237,940,039,285,380,274,899,124,224
//2^91 = 2,475,880,078,570,760,549,798,248,448
//2^92 = 4,951,760,157,141,521,099,596,496,896
//2^93 = 9,903,520,314,283,042,199,192,993,792
//2^94 = 19,807,040,628,566,084,398,385,987,584
//2^95 = 39,614,081,257,132,168,796,771,975,168
//2^96 = 79,228,162,514,264,337,593,543,950,336
public abstract class Bits extends Number
		implements java.io.Serializable, Immutable<Bits>, Comparable<Bits>, Iterable<Integer> {

	static final long serialVersionUID = -460407103310043830L;

	/**
	 * the shift methods will act just like primitive shift operations
	 * 
	 * @see #setFlags(int)
	 */
	public static final int FLAG_CIRCULAR_SHIFT = 0x1;
	/**
	 * {@link #toString()} and {@link #toChars()} outputs will be delimited by
	 * underscore between every 8 bits, e.g: 1110000_0011000_0100000_1000000
	 * 
	 * @see #setFlags(int)
	 * @see #toChars()
	 */
	public static final int FLAG_TO_STRING_READABLE = 0x2;
	/**
	 * {@link #toString()} and {@link #toChars()} outputs will be only indexes of
	 * set-bits, e.g: {1, 4, 32}
	 * 
	 * @see #setFlags(int)
	 * @see #toChars()
	 */
	public static final int FLAG_TO_STRING_INDEXES_ONLY = 0x4;
	/**
	 * {@link #toString()} and {@link #toChars()} outputs will {@link #toDecimal()}
	 * 
	 * @see #setFlags(int)
	 * @see #toChars()
	 */
	public static final int FLAG_TO_STRING_DECIMAL = 0x8;

	public static final int FLAG_UNSIGNED = 0x10;

	// ============
	// ============
	// ============
	public static Bits of() {
		return Utils.b.of();
	}

	public static Bits of(int n) {
		return Utils.b.of(n);
	}

	public static Bits of(long n) {
		return Utils.b.of(n);
	}

	// ============
	// ============
	// ============

	public static Bits of(byte[] words) {
		return of(words, words.length);
	}

	public static Bits of(byte[] words, int wordsInUse) {
		return of(words, wordsInUse, Utils.DEFAULT_SIGNUM);
	}

	public static Bits of(byte[] words, int wordsInUse, int sign) {
		return Utils.b.of(words, wordsInUse, sign, Endian.LITTLE);
	}

	// ============
	// ============
	// ============

	public static Bits of(int[] words) {
		return of(words, words.length);
	}

	public static Bits of(int[] words, int wordsInUse) {
		return of(words, wordsInUse, Utils.DEFAULT_SIGNUM);
	}

	public static Bits of(int[] words, int wordsInUse, int sign) {
		return of(words, wordsInUse, sign, Endian.LITTLE);
	}

	public static Bits of(int[] words, int wordsInUse, Endian order) {
		return of(words, wordsInUse, Utils.DEFAULT_SIGNUM, order);
	}

	public static Bits of(int[] words, int wordsInUse, int sign, Endian order) {
		return Utils.b.of(words, wordsInUse, sign, order);
	}

	// ============
	// ============
	// ============

	public static Bits of(long[] words) {
		return of(words, words.length);
	}

	public static Bits of(long[] words, int wordsInUse) {
		return of(words, wordsInUse, Utils.DEFAULT_SIGNUM);
	}

	public static Bits of(long[] words, int wordsInUse, int sign) {
		return Utils.b.of(words, wordsInUse, sign, Endian.LITTLE);
	}

	// ============
	// ============
	// ============

	public static Bits of(CharSequence cs) {
		return of(cs, Utils.DEFAULT_RADIX);
	}

	public static Bits of(CharSequence cs, int radix) {
		return of(cs, radix, 0, cs.length());
	}

	public static Bits of(CharSequence src, int radix, int from, int to) {
		return of(src, radix, from, to, null);
	}

	public static Bits of(CharSequence src, int radix, int from, int to, Bits assignTo) {
		return Utils.b.of(src, radix, from, to, assignTo);
	}

	// ============
	// ============
	// ============

	public static Bits of(Bits b) {
		return b.newClone();
	}

	public static Bits of(BitSet bs) {
		return Utils.b.of(bs, Utils.DEFAULT_SIGNUM);
	}

	public static Bits of(BigInteger bi) {
		return Utils.b.of(bi);
	}

	// ============
	// ============
	// ============

	public static Bits ofRandomSize(int size) {
		return ofRandomSize(size, Utils.DEFAULT_SIGNUM);
	}

	public static Bits ofRandomSize(int size, int sign) {
		return ofRandomRange(0, size, sign);
	}

	public static Bits ofRandomRange(int fromBit, int toBit) {
		return ofRandomRange(fromBit, toBit, Utils.DEFAULT_SIGNUM);
	}

	public static Bits ofRandomRange(int fromBit, int toBit, int sign) {
		int[] words = Utils.randomWords(fromBit, toBit);
		return Utils.b.of(words, words.length, sign, Endian.LITTLE);
	}

	// ================
	// ================
	// ================

	public Bits toUnsigned() {
		if (isUnsigned())
			return this;
		int flags = reflag(true, FLAG_UNSIGNED);
		int sign = sign();
		int[] words = safe();
		int wordsInUse = wordsInUse();
		if (sign > 0) {
			return assign(words, wordsInUse, sign, flags);
		}
		words = Utils.negate(words, wordsInUse);
		return assign(words, wordsInUse, sign, flags);
	}

	public Bits toSigned() {
		return setFlags(reflag(false, FLAG_UNSIGNED));
	}

	public Bits flagDecimal() {
		return flagDecimal(true);
	}

	public Bits flagDecimal(boolean b) {
		return setFlags(reflag(b, FLAG_TO_STRING_DECIMAL));
	}

	/**
	 * @see #flagCircularShift(boolean)
	 */
	public Bits flagCircularShift() {
		return flagCircularShift(true);
	}

	/**
	 * @see #FLAG_CIRCULAR_SHIFT
	 * @see #setFlags(int)
	 * @default flagCircularShift = true
	 */
	public Bits flagCircularShift(boolean b) {
		return setFlags(reflag(b, FLAG_CIRCULAR_SHIFT));
	}

	/**
	 * @see #FLAG_CIRCULAR_SHIFT
	 */
	public boolean isCircularShift() {
		return isFlagged(FLAG_CIRCULAR_SHIFT);
	}

	/**
	 * @see #FLAG_CIRCULAR_SHIFT
	 * @see #FLAG_TO_STRING_INDEXES_ONLY
	 * @see #FLAG_TO_STRING_READABLE
	 */
	public abstract Bits setFlags(int flags);

	/**
	 * set the lower-bound of this instance magnitude<br>
	 * just like unsigned int in c++, if you subtract 1 from 0, you return to
	 * 4,294,967,295, so the lower-bound is zero, and if we add 1 to 4,294,967,295
	 * you return to 0, so upper-bound is 4,294,967,295<br>
	 * <br>
	 * in this implementation, upper-bound term is not used at all, but you can
	 * think in {@link Utils#MAX_WORDS_LENGTH} as the upper-bound, and lower-bound
	 * is user-predefined, by default equals to {@link Utils#DEFAULT_BOUNDS}<br>
	 * <br>
	 * the idea behind lower-bound, is to have a bound for subtractions and
	 * divisions, e.g: if we subtract 1 from 0, what is the result?<br>
	 * <br>
	 * we can use {@link Utils#MAX_WORDS_LENGTH}, but that will consume a lot of
	 * time and memory, instead, and since subtractions is not very common, we will
	 * use a lower-bound term.<br>
	 * <br>
	 * to clear the confusion, in above c++ example, lower-bound is 0, and
	 * upper-bound is 4,294,967,295, that due to bits limitation, but we don't have
	 * a noticeable bits limitation here, so we will exclude the term upper-bound
	 * permanently, and will use term lower-bound only for the return point when we
	 * exceed 0 due to subtractions or divisions <br>
	 * <br>
	 * the lower-bound is a 32 word count, e.g: 1 for return point 4,294,967,295
	 * 
	 * 
	 */
	public abstract Bits setBounds(int lowerBound, int upperBound);

	/**
	 * - <b>internal use only</b><br>
	 * 
	 * @see #setFlags(int)
	 */
	abstract int flags();

	public boolean isFlagged(int flag) {
		return Utils.isFlagged(flags(), flag);
	}

	/**
	 * - <b>internal use only</b><br>
	 */
	int reflag(boolean b, int f) {
		return b ? flag(f) : unflag(f);
	}

	/**
	 * - <b>internal use only</b><br>
	 */
	int flag(int f) {
		int flags = flags();
		return flags | f;
	}

	/**
	 * - <b>internal use only</b><br>
	 */
	int unflag(int f) {
		int flags = flags();
		return flags & (flags ^ f);
	}

	/**
	 * <b>wordsInUse always >= 1</b>
	 * 
	 * @return how many words-in-use, a word is one {@link Integer}
	 * 
	 */
	public abstract int wordsInUse();

	public abstract int getLowerBound();

	public abstract int getUpperBound();

	public Bits abs() {
		int sign = sign();
		// if this is unsigned, below should never be true
		if (sign < 0) {
			sign = 1;
			int wordsInUse = wordsInUse();
			int[] words = Utils.negate(safe(), wordsInUse);
			return assign(words, wordsInUse, sign, flags());
		}
		// if unsigned or already positive
		return this;
	}

	public Bits negate() {
		int sign = sign();
		if (!isUnsigned()) {
			sign = -sign;
		}
		int wordsInUse = wordsInUse();
		int[] words = Utils.negate(safe(), wordsInUse);
		return assign(words, wordsInUse, sign, flags());
	}

	public abstract int sign();

	public boolean isUnsigned() {
		return isFlagged(FLAG_UNSIGNED);
	}

	public boolean isNegative() {
		return sign() < 0;
	}

	/**
	 * safe <br>
	 * - <b>internal use only</b><br>
	 * <br>
	 * - modification will be applied<br>
	 * <br>
	 * - <b>immutable-implementer</b> must return new copy<br>
	 * - <b>mutable-implementer</b> must return original copy<br>
	 * 
	 * @return core object/array that represent the data of current instance
	 */
	abstract int[] safe();

	/**
	 * unsafe <br>
	 * - <b>internal use only</b><br>
	 * <br>
	 * - modification will <b>NOT</b> be applied, no need for more garbage<br>
	 * <br>
	 * - <b>immutable-implementer</b> must return original copy<br>
	 * - <b>mutable-implementer</b> must return original copy<br>
	 * 
	 * @return core object/array that represent the data of current instance
	 */
	abstract int[] unsafe();

	Bits assign(int[] words, int wordsInUse, int sign, int flags) {
		return assign(words, wordsInUse, sign, flags, getLowerBound(), getUpperBound());
	}

	/**
	 * - <b>internal use only</b><br>
	 * <br>
	 * - <b>immutable-implementer</b> must recopy<br>
	 * - <b>mutable-implementer</b> should not recopy<br>
	 */
	abstract Bits assign(int[] words, int wordsInUse, int sign, int flags, int lowerBound, int upperBound);

	/**
	 * <b>Warning: internal use only</b><br>
	 * 
	 * @see #newInstance(int)
	 */
	Bits newInstance() {
		return newInstance(Integer.SIZE);
	}

	/**
	 * <b>Warning: internal use only</b><br>
	 * 
	 * @return new empty instance based on current implementation and given
	 *         bits-length, with fresh flags
	 * @default nbits = {@link Integer#SIZE}
	 * @default flags = 0
	 */
	abstract Bits newInstance(int nbits);

	/**
	 * <b>Warning: internal use only</b><br>
	 * 
	 * @see #newInstance(int[], int, int)
	 */
	Bits newInstance(int[] words) {
		return newInstance(words, words.length, Utils.DEFAULT_SIGNUM, 0, Utils.DEFAULT_BOUNDS, Utils.MAX_WORDS_LENGTH);
	}

	Bits newInstance(int[] words, int wordsInUse, int sign, int flags) {
		return newInstance(words, wordsInUse, sign, flags, getLowerBound(), getUpperBound());
	}

	/**
	 * - <b>internal use only</b><br>
	 * <br>
	 * - <b>invoker</b> must pass new copy<br>
	 * - <b>immutable-implementer</b> should not recopy<br>
	 * - <b>mutable-implementer</b> should not recopy<br>
	 */
	abstract Bits newInstance(int[] words, int wordsInUse, int sign, int flags, int lowerBound, int upperBound);

	/**
	 * @return new clone of current implementation, current bit-set and current
	 *         flags
	 */
	public Bits newClone() {
		return newInstance(toIntegerArray(), wordsInUse(), sign(), flags());
	}

	// ==============
	// ============== assign
	// ==============
	public Bits assign(CharSequence cs, int radix) {
		return Utils.b.of(cs, radix, 0, cs.length(), this);
	}

	/**
	 * assign unsigned-int
	 */
	public Bits assign(int n) {
		// ---------------
		int wordsInUse = 1;
		int[] words = safe();
		words = Utils.ensureCapacity(words, wordsInUse);
		// ---------------
		words[0] = n;
		words = Utils.cleanUp(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, Utils.DEFAULT_SIGNUM);
	}

	/**
	 * assign unsigned-long
	 */
	public Bits assign(long l) {
		// ---------------
		int wordsInUse = 1;
		int[] words = safe();
		// ---------------
		// keep extra slot in-case n has 2 words
		// ---------------
		words = Utils.ensureCapacity(words, 2);

		long word1 = l >>> Integer.SIZE, word0 = l & Utils.BITS_WORD_MASK;
		words[0] = (int) word0;
		if (word1 != 0) {
			words[wordsInUse++] = (int) word1;
		}
		words = Utils.cleanUp(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, Utils.DEFAULT_SIGNUM);
	}

	public Bits assign(BitSet bs) {
		int[] w = Utils.bs.words(bs);
		return assign(w, w.length, Utils.DEFAULT_SIGNUM, flags());
	}

	public Bits assign(BigInteger bi) {
		int[] w = Utils.bi.words(bi, Endian.LITTLE);
		return assign(w, w.length, Utils.DEFAULT_SIGNUM, flags());
	}

	public Bits assign(Bits b) {
		int[] w = b.toIntegerArray();
		return assign(w, w.length, b.sign(), b.flags(), b.getLowerBound(), b.getUpperBound());
	}

	// ==============
	// ============== subtract
	// ==============

	/**
	 * perform subtraction
	 */
	public Bits subtract(int n) {
		if (n < 0 && !isUnsigned())
			return addUnsigned(-n);
		return subtractUnsigned(n);
	}

	/**
	 * perform unsigned subtraction
	 */
	private Bits subtractUnsigned(int n) {
		if (n == 0) {
			return this;
		}

		// ---------------
		int sign = sign();
		if (sign < 0) {
			return addAndSign(n, -1);
		}
		final boolean unsigned = isUnsigned();
		final boolean thisSmaller = this.lt(n);
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		long tmp;
		// ---------------
		if (!unsigned && thisSmaller) {
			tmp = (n & Utils.LONG_MASK) - (words[0] & Utils.LONG_MASK);
			sign = -1;
		} else {
			tmp = (words[0] & Utils.LONG_MASK) - (n & Utils.LONG_MASK);
		}
		words[0] = (int) tmp;
		tmp >>= Integer.SIZE;
		// ---------------

		if (tmp != 0) {
			if (unsigned && thisSmaller) {
				wordsInUse = getLowerBound() + 1;
				words = Utils.ensureCapacity(words, wordsInUse);
				for (int i = 1; i < wordsInUse - 1; i++) {
					words[i] = 0;
				}
				words[wordsInUse - 1] = 1;
			}
			int i = 1;
			for (; i < wordsInUse && words[i] == 0; i++) {
				--words[i];
			}

			if ((i < wordsInUse && --words[i] == 0) && i + 1 == wordsInUse)
				--wordsInUse;
		}

		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	/**
	 * perform subtraction
	 */
	public Bits subtract(long n) {
		return subtractUnsigned(n);
	}

	/**
	 * perform unsigned subtraction
	 */
	public Bits subtractUnsigned(long n) {
		return subtractAndSign(n, Utils.DEFAULT_SIGNUM);
	}

	/**
	 * perform subtraction and assign given sign
	 */
	private Bits subtractAndSign(long n, int sign) {
		if (n == 0) {
			return this;
		}

		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		int lowerBound = getLowerBound();
		// ---------------

		// ---------------
		boolean unsigned = false;
		final boolean thisSmaller = this.lt(n);
		wordsInUse = wordsInUse < 2 ? 2 : wordsInUse;
		words = Utils.ensureCapacity(words, wordsInUse);
		// ---------------

		// ---------------
		final long word1 = n >>> Integer.SIZE, word0 = n & Utils.LONG_MASK;
		long tmp = (words[0] & Utils.LONG_MASK) - word0;
		words[0] = (int) tmp;
		tmp >>= Integer.SIZE;
		tmp = (words[1] & Utils.LONG_MASK) - word1 + tmp;
		words[1] = (int) tmp;
		tmp >>= Integer.SIZE;
		// ---------------

		if (tmp != 0) {
			// -----------
			// note: if thisSmaller, means this wordsInUse <= 2
			// -----------
			if (unsigned && thisSmaller) {
				// TODO fix to support big negative
				wordsInUse = lowerBound + 1;
				words = Utils.ensureCapacity(words, wordsInUse);
				for (int i = 2; i < wordsInUse - 1; i++) {
					words[i] = 0;
				}

				// TODO fix: this may lead to bug if lower = 1 only
				words[wordsInUse - 1] = 1;
			}
			int i = 2;
			for (; i < wordsInUse && words[i] == 0; i++) {
				--words[i];
			}

			if ((i < wordsInUse && --words[i] == 0) && i + 1 == wordsInUse)
				--wordsInUse;
		}

		// negate all and flip sign
		if (!unsigned && thisSmaller) {
			words[0] = ~words[0] + 1;
			for (int i = 1; i < wordsInUse; i++) {
				words[i] = ~words[i];
			}
			sign = -sign;
		}
		// --------------- section#7
		wordsInUse = Utils.recalcWordsInUse(words,
				unsigned && thisSmaller ? Math.min(lowerBound, wordsInUse) : wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	/**
	 * perform subtraction
	 */
	public Bits subtract(Bits n) {
		return subtractUnsigned(n);
	}

	/**
	 * perform unsigned subtraction
	 */
	public Bits subtractUnsigned(Bits n) {
		return subtractAndSign(n, Utils.DEFAULT_SIGNUM);
	}

	/**
	 * perform unsigned subtraction and assign given sign
	 */
	private Bits subtractAndSign(Bits n, int sign) {
		if (n.isZero()) {
			return this;
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		int lowerBound = getLowerBound();
		// ---------------

		// ---------------
		int bwordsInUse = n.wordsInUse();
		int[] bwords = n.safe();
		// ---------------

		// ---------------
		final boolean thisSmaller = this.lt(n);
		long tmp = 0;
		int i = 0;
		// ---------------

		// ----------------- section#1
		// if thisSmaller, will enter lower-bound range
		// e.g: wordsInUse = 3, bWordsInUse = 6, lowerBound = 1
		// above is fine, no re-allocation required, but if lowerBound = 10, we need to
		// re-allocate to keep zeros in-front of 3rd, 4th and 5th indexes of bWords,
		// like:
		// [4, -7, 8, 0, 0, 0]
		// [3, 8, 9, -10, 2, 1]
		// also lower-bound is the safe-requirements
		// ----------------- section#2
		// else if NOT-thisSmaller, will NOT enter lower-bound range
		// e.g: wordsInUse = 7, bWordsInUse = 5, lowerBound = 1
		// therefore, new wordsInUse will be <= bwordsInuse
		// also, we don't need the zeros of bWords, the remain words will pulled down
		// e.g:
		// [4, -7, 8, 8, 0, 9, 1]
		// [3, 8, 9, -10, 2]
		// 5th and 6th indexes of words will be pulled down with results without any
		// further calculations
		// -----------------
		words = Utils.ensureCapacity(words, thisSmaller ? lowerBound : bwordsInUse);

		// ----------------- section#3
		// for loops, will rely on:
		// if thisSmaller = true, e.g:
		// [4, -7, 8]
		// [3, 8, 9, -10, 2, 1]
		// above will make sure we have extra zeros on words array, so we will use:
		// i < lowerBound && i < bwordsInUse for conditioning
		// else if thisSmaller = false, e.g:
		// [4, -7, 8, 8, 0]
		// [3, 8, 9]
		// this operation will be applied to common-words only, which are 0th, 1st and
		// 2nd indexes, remain of words will be pulled down, so we can use only i <
		// bwordsInUse for conditioning
		// -----------------
		for (; thisSmaller ? (i < lowerBound && i < bwordsInUse) : i < bwordsInUse; i++) {
			tmp = (words[i] & Utils.LONG_MASK) - (bwords[i] & Utils.LONG_MASK) + tmp;
			words[i] = (int) tmp;
			tmp >>= Integer.SIZE;
		}

		// ----------------- section#4
		// in chaos/unpredictable operations, clean-up is must
		// e.g: wordsInUse = 7, bWordsInUse = 10, lowerBound = 1
		// result wordsInUse = 1, if below clean-up not performed next may happen
		// wordsInUse = 1, bWordsInUse = 5, lowerBound = 15
		// will exceed lower-bound, above will not re-allocate, some left from last ops;
		// and because we did not clean-up last time, the above subtract and carry will
		// make wrong calculation, because words after index 0 must equals to 0
		// and in some cases, tmp != 0 will equals to true, which means wordsInUse will
		// remain equals to 1 as it was
		// ---
		// therefore, below clean-up is must due to nature of mutability and lower-bound
		// algorithm
		// ----------------- section#5
		// e.g: [4, -7, 8] vs [3, 8, 9, -10], and lower-bound < 3
		// -----------------
		if (thisSmaller && lowerBound < wordsInUse) {
			// will start from last calculated word, using last i, and clean remining
			for (int k = i; k < wordsInUse; k++) {
				words[k] = 0;
			}
		}

		if (tmp != 0) {
			// ----------------- section#6
			// if thisSmaller = true, that means we will use lower-bound as offset
			// e.g:
			// [1, 1]
			// [1, 1, 1]
			// 3rd index of bWords can't be subtracted from words
			// so will subtract it from lower-bound
			// if lower-bound, e.g: 4
			// that means we will subtract the remaining from:
			// [-1, -1, -1, -1], but this will produce wrong results, because -1 is
			// full-mask and not full-count, therefore will always consider the lower-bound
			// as full-count by saying: [0, 0, 0, 0, 1]. note it become 5 elements.
			// -----------------
			if (thisSmaller) {
				// ---------------
				// make sure wordsInUse equals lower-bound full-count,
				// e.g: [1, 1],lower-bound = 4 -> [1, 1, ?, ?, ?]
				// ---------------
				wordsInUse = lowerBound + 1;
				words = Utils.ensureCapacity(words, wordsInUse);
				// ---------------
				// set all to zero, exclude last -> [1, 1, 0, 0, ?]
				// ---------------
				for (int k = bwordsInUse; k < wordsInUse - 1; k++) {
					words[k] = 0;
				}
				// ---------------
				// set last to 1 -> [1, 1, 0, 0, 1]
				// ---------------
				words[wordsInUse - 1] = 1;
			}

			// ---------------
			// now apply carry subtraction on reset
			// ---------------
			for (; i < wordsInUse && words[i] == 0; i++) {
				--words[i];
			}

			if ((i < wordsInUse && --words[i] == 0) && i + 1 == wordsInUse)
				--wordsInUse;
		}
		// TODO figure out the sign
		// --------------- section#7
		// if thisSmaller, means we will use min(lowerBound, wordsInUse), otherwise will
		// go with wordsInUse
		// ---------------
		wordsInUse = Utils.recalcWordsInUse(words, thisSmaller ? Math.min(lowerBound, wordsInUse) : wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	// ==============
	// ============== add
	// ==============

	/**
	 * perform addition
	 */
	public Bits add(int n) {
//		if (!isUnsigned() && n < 0)
//			return subtractUnsigned(-n);
		return addUnsigned(n);
	}

	/**
	 * perform unsigned addition
	 */
	public Bits addUnsigned(int n) {
		return addAndSign(n, Utils.DEFAULT_SIGNUM);
	}

	/**
	 * perform unsigned addition and assign given sign
	 */
	private Bits addAndSign(int n, int sign) {
		if (n == 0) {
			return this;
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------

		// ---------------
		// n is only 1 word so unsigned operation will be performed upon word[0]
		// and carry remaining to next words
		// ---------------
		long tmp = (words[0] & Utils.LONG_MASK) + (n & Utils.LONG_MASK);

		// ---------------
		// interested only in tmp-word0, assign it to word[0]
		// ---------------
		words[0] = (int) tmp;

		// ---------------
		// find if something left on tmp-word1
		// ---------------
		if ((tmp >>> Integer.SIZE) != 0) {
			// ---------------
			// if something left, means (tmp > mask) we will rise next word by 1,
			// e.g: { 1, -1, 1 }, if n == -1 which equals to unsigned (4294967295), words[0]
			// will be (0) which equals to (4294967296), we need to transfer the
			// (4294967295) to next word by adding (1), and consider only (1) on LSB, so
			// will start
			// scanning from word#1, on word#1 and after adding (1) to it, will check if it
			// reach (0) which could happen when we have word[1] = -1,
			// which equals to unsigned (4294967295), same, if reached 0, means we need to
			// rise up the next word by 1 which is word#2, so at the end the result will be
			// { 0, 0, 2 }
			// ---------------
			int i = 1;
			for (; i < wordsInUse && ++words[i] == 0; i++)
				;

			// ---------------
			// in-case of { 1, -1, -1 }, the above rise up will result: { 0, 0, 0 }, we need
			// to expend and transfer to word#3, below will expend and transfer to MSB
			// ---------------
			if (i == wordsInUse) {
				words = Utils.ensureCapacity(words, wordsInUse + 1);
				words[wordsInUse++] = 1;
			}
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	/**
	 * perform addition
	 */
	public Bits add(long n) {
		return addUnsigned(n);
	}

	/**
	 * perform unsigned addition
	 */
	public Bits addUnsigned(long n) {
		return addAndSign(n, Utils.DEFAULT_SIGNUM);
	}

	/**
	 * perform unsigned addition and assign given sign
	 */
	private Bits addAndSign(long n, int sign) {
		if (n == 0) {
			return this;
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = Utils.ensureCapacity(safe(), 2);
		wordsInUse = wordsInUse < 2 ? 2 : wordsInUse;
		// ---------------

		// ---------------
		// extract words
		// ---------------
		final long word1 = n >>> Integer.SIZE, word0 = n & Utils.LONG_MASK;

		// ---------------
		// perform addition to word[0] and carry the remaining to next words
		// ---------------
		long tmp = (words[0] & Utils.LONG_MASK) + word0;

		// ---------------
		// interested only in tmp-word0, assign it to word[0]
		// ---------------
		words[0] = (int) tmp;

		// ---------------
		// interested only in tmp-word1, drop tmp-word0, below will add it with above
		// extracted >>word1<<, which can carry more
		// ---------------
		tmp >>>= Integer.SIZE;

		// ---------------
		// if this instance has only 1 wordInUse, we will consider word[1] equals to 0.
		// perform word[1] + (word1 + tmp), and carry the rest to next words
		// ---------------
		tmp = (words[1] & Utils.LONG_MASK) + (word1 + tmp);

		// ---------------
		// again, interested only in tmp-word1, assign it to word[1]
		// ---------------
		words[1] = (int) tmp;

		// ---------------
		// if tmp has something left on tmp-word1
		// ---------------
		if (tmp >>> Integer.SIZE != 0) {
			// ---------------
			// check if last addition to word[1] has some to carry, we will loop and rise
			// next word by 1 if current is full, starting from word[2],
			// e.g: {554, 5566, -1, -1, 8}
			// words[2](-1) -> 0
			// words[3](-1) -> 0
			// words[4](8) -> 9
			// ---------------
			int i = 2;
			for (; i < wordsInUse && ++words[i] == 0; i++)
				;

			if (i == wordsInUse) {
				// ---------------
				// if last example: {554, 5566, -1, -1, -1}
				// words[4](-1) -> 0, this requires new
				// word to carry 1 more due to word[4] is full
				// ---------------
				words = Utils.ensureCapacity(words, wordsInUse + 1);
				words[wordsInUse++] = 1;
			}
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	/**
	 * perform addition
	 */
	public Bits add(final Bits n) {
		return addUnsigned(n);
	}

	/**
	 * perform unsigned addition
	 */
	public Bits addUnsigned(final Bits n) {
		return addAndSign(n, Utils.DEFAULT_SIGNUM);
	}

	/**
	 * perform unsigned addition and assign given sign
	 */
	private Bits addAndSign(final Bits n, final int sign) {
		if (n.isZero()) {
			return this;
		}
		int bwordsInUse = n.wordsInUse();
		int[] bwords = n.safe();
		// ---------------
		// for reallocation and assigning reasons,
		// we need to ensure the smaller array is assigned to words
		// -----------------

		// ---------------
		// need to have one method to handle below wordInUse cases for looping and
		// reallocating:
		// case-1: wordsInUse = bwordsInUse, [9, 2, 3] vs [8, 10, 2]
		// case-2: wordsInUse < bwordsInUse, [9, 2, 3] vs [8, 10, 2, 199]
		// case-3: wordsInUse > bwordsInUse, [9, 2, 3, 155] vs [8, 10, 2]
		// ----------------

		// -----------------
		// by default, consider wordsInUse <= bwordsInUse (case-1 and case-2)
		// -----------------
		int wordsInUse = wordsInUse();
		int[] words = safe();

		// -----------------
		// if case-3, flip them
		// -----------------
		if (wordsInUse > bwordsInUse) {
			wordsInUse = bwordsInUse;
			bwordsInUse = wordsInUse();

			int[] w = words;
			words = bwords;
			bwords = w;
		}

		// -----------------
		// -----------------
		// -----------------
		// -----------------
		// example will be used:
		// wordsInUse = 3, bwordsInUse = 4
		// words{-1, 3, -1}, bwords{4, 2, -1, -1}
		// -----------------
		// -----------------
		// -----------------
		// -----------------

		// ----------------
		// ensure words.length >= bwordsInUse + 1
		// ----------------
		words = Utils.ensureCapacity(words, bwordsInUse + 1);

		long tmp = 0;
		int i = 0;

		// ----------------
		// step-1: perform unsigned addition, assign results to tmp
		// step-2: interested only in tmp-word0, assigned it to word[i]
		// step-3: now interested only in tmp-word1, drop tmp-word0
		// step-1 (again): now we have something left from previous addition on
		// tmp-word0, include it in current words addition
		// step-4: if wordsInuse < bwordsInUse, copy remaining from bwords to words
		// step-5: if tmp != 0, rise next words by 1 if current reached 0 (full mask)
		// ----------------
		// e.g: words{-1, 3, -1}, bwords{4, 2, -1, -1}
		// loop[0]
		// step-1: 4294967295 + 4 + 0 = 4294967299 (set-bits: 0, 1 and 32)
		// step-2: words[0] = 3 (after cast)
		// step-3: tmp-word0 = 1, (after dropping tmp-word0)
		// loop[1]
		// step-1: 3 + 2 + 1 = 6 (set-bits: 1 and 2)
		// step-2: words[1] = 6
		// step-3: tmp-word0 = 0
		// loop[2]
		// step-1: 4294967295 + 4294967295 + 0 = 8589934590 (set bits: from 1 to 33)
		// step-2: words[2] = -2 (after cast, because bit-0 is clear)
		// step-3: tmp-word0 = 1 (after dropping tmp-word0)
		// ----------------
		for (; i < wordsInUse; i++) {
			tmp = (words[i] & Utils.LONG_MASK) + (bwords[i] & Utils.LONG_MASK) + tmp;
			words[i] = (int) tmp;
			tmp >>>= Integer.SIZE;
		}

		// ----------------
		// according to above, words = {3, 6, -2}
		// step-4: will copy remaining bwords to words
		// {3, 6, -2} -> {3, 6, -2, -1}
		// ----------------
		if (wordsInUse < bwordsInUse) {
			System.arraycopy(bwords, wordsInUse, words, wordsInUse, bwordsInUse - wordsInUse);
			wordsInUse = bwordsInUse;
		}

		// ----------------
		// according to above, tmp = 1, and i = 3
		// so:
		// words[3](-1) -> 0, reached full mask, rise up next by 1
		// words[4](0) -> 1
		// ----------------
		if (tmp != 0) {
			for (; i < wordsInUse && ++words[i] == 0; i++)
				;
			if (i == wordsInUse) {
				words = Utils.ensureCapacity(words, wordsInUse * 2);
				words[wordsInUse++] = 1;
			}
		}
		// ----------------
		// result: {3, 6, -2, 0, 1, .....}, wordsInUse = 5
		// ----------------
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	// ==============
	// ============== divide
	// ==============

	public Bits divide(int n) {
		return divideUnsigned(n);
	}

	public Bits remainder(int n) {
		return remainderUnsigned(n);
	}

	public Bits divideAndRemainder(int n) {
		return divideAndRemainderUnsigned(n);
	}

	public Bits divideUnsigned(int n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_QUOTIENT_DISCARD_REMAINDER);
	}

	public Bits remainderUnsigned(int n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_REMAINDER_DISCARD_QUOTIENT);
	}

	public Bits divideAndRemainderUnsigned(int n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_QUOTIENT_RETURN_REMAINDER);
	}

	private Bits divideUnsignedAndAssign(int divisor, int sign, AfterDivision ad) {
		if (divisor == 0) {
			throw new ArithmeticException("divisor is zero");
		} else if (isZero()) {
			switch (ad) {
			case ASSIGN_QUOTIENT_DISCARD_REMAINDER:
			case ASSIGN_REMAINDER_DISCARD_QUOTIENT:
				return assign(0);
			case ASSIGN_QUOTIENT_RETURN_REMAINDER:
				if (isImmutable()) {
					throw new IllegalStateException("can't assign quotient to immuable instance");
				}
				assign(0);
				return Utils.b.of(0);
			default:
				throw new ImplementationRequiredException(ad.toString());
			}
		}

		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------
		long remainder = 0;
		final long long_divisor = divisor & Utils.LONG_MASK;

		// ---------------
		// below division documentation covers:
		// (1): --## normal-division algorithm ##--
		// (2): --## overflow-division algorithm ##--
		// ---------------
		if (divisor > 0) {
			// ---------------
			// --## normal-division ##--
			// ---------------
			// basic steps algorithm, shift, unmask, divide and carry.
			// e.g: for the seek of simplicity, will use size of 8-bit, and carry container
			// of 16-bit
			// mask = 255, mag = [-6, 10, -44] -> unsigned [250, 10, 212]
			// divisor = 127 (max possible positive divisor)
			// ---------------
			// loop-2: working with column[2]
			// just like traditional division, will start from highest column, which is
			// [212]
			// rem(0) = rem(0) << 8 (explained in loop-1)
			// rem(212) = rem(0) + (212)
			// w[2](1) = rem(212) / div(127)
			// rem(85) = rem(212) % div(127)
			// mag: [,, 1] -> unsigned [,, 1]
			// ---------------
			// loop-1: working with column[1]
			// now we are carrying something from previous division (85)
			// the carried must be represented according to previous column
			// so we need to shift it to left by 8-bit
			// rem(21,760) = rem(85) << 8
			// rem(21,770) = rem(21,760) + (10)
			// w[1](171) = rem(21,770) / div(127)
			// rem(53) = rem(21,770) % div(127)
			// mag: [, -85, 1] -> unsigned [, 171, 1]
			// ---------------
			// loop-0: working with column[0]
			// rem(13,568) = rem(53) << 8
			// rem(13,818) = rem(13,568) + (250)
			// w[1](108) = rem(13,818) / div(127)
			// rem(102) = rem(13,818) % div(127)
			// mag: [108, -85, 1] -> unsigned [108, 171, 1]
			// ---------------
			// quotient: [108, -85, 1] --> unsigned [108, 171, 1]
			// remainder: [102]
			// ---------------
			for (int i = wordsInUse - 1; i >= 0; i--) {
				remainder <<= Integer.SIZE;
				remainder = remainder + (words[i] & Utils.LONG_MASK);
				words[i] = (int) (remainder / long_divisor);
				remainder = remainder % long_divisor;
			}
		} else {
			// ---------------
			// --## overflow-division ##--
			// ---------------
			// --## the limitation ##--
			// ---------------
			// in the normal algorithm steps, we need to carry current remainder to next
			// column division, and we must represent that remainder according to previous
			// column, e.g: if we have 126 / 127, quotient = 0, and remainder = 126
			// next column, we need to represent the remainder according to previous column,
			// so 126 << 8 = 32,256, and that is the max possible safe remainder we can
			// carry, if we exceed that, we will get negative remainder
			// ---------------
			// --## the problem ##--
			// ---------------
			// in above normal division example, the results will be inaccurate if we used a
			// negative divisors (not all of them, but higher negative/unsigned means higher
			// errors),
			// lets go through the steps to see why.
			// same example above, but divisor = -6 -> unsigned (250)
			// ---------------
			// loop-2: working with column[2]
			// rem(0) = rem(0) << 8
			// rem(212) = rem(0) + (212)
			// w[2](0) = rem(212) / div(250)
			// rem(212) = rem(212) % div(250)
			// mag: [,, 0] -> unsigned [,, 0]
			// ---------------
			// loop-1: working with column[1]
			// rem(-11,264) (unsigned 54,272) = rem(212) << 8
			// ---------------
			// before we continue, you can see that we have an overflow
			// the carry container = 16-bit only, and the shifted rem(212) resulted
			// something beyond that capacity if we try to handle in unsigned manner, so the
			// normal-division
			// can't handle such a situation, and if we continue we will lose
			// the accuracy of the final results
			// ---------------
			// --## the solution ##--
			// ---------------
			// since we already knew that we have an overflow, then we
			// have the half of the solution
			// the carry container is 16-bit only, means max possible positive value we can
			// carry is 32,767 (15-bit), so we can just exclude this amount from any
			// overflow division, and append only the quotient and remainder to division
			// process whenever we have an overflow
			// ---------------
			// will continue with divisor of (-6) --> unsigned (250)
			// ---------------
			// --## the preparation ##--
			// ---------------
			// 1: will hold the highest-bit as high_bit which will be needed a lot for later
			// usage
			// 2: will find the the >>before-overflow<< quotient as high_quotient which
			// represent the max possible positive dividend, and that always equals to
			// 32,767.
			// hq(131) = (hbit(-32,768) - 1)(32,767) / div(250)
			// 3: in case high_quotient = -32,768, that means only highest-bit is set
			// in below algorithm, whenever we carry remainders from previous column
			// division, and that carried value has overflow, we will use the high_quotient
			// and high_remainder, and to use them we need to
			// detect at less 1 set-bit from bit(0) to (15) in high_quotient/high_remainder,
			// so if we have
			// 100..00, will add 1 to turn it into 100..01, and if remainder equals to 1...,
			// and by shifting it to right by 15 will produce (1111..), applying logical AND
			// on high_quotient will return high_quotient again, if high_quotient equals
			// (100..), the returned will be negative itself
			// more explained below under overflow detection
			// 4: will find the the overflow remainder as high_remainder
			// hrem(18) = hbit(-32,768) - hq(131) * div(250)
			// ---------------
			// --## the algorithm ##--
			// ---------------
			// loop-2:
			// rem(0) = rem(0) << 8
			// rem(212) = rem(0) + w[2](212)
			// ## interested only in overflow quantity (explained below) ##
			// overflow(212) = rem(212) & (hbit - 1)(32,767)
			// hq_carry(0) = hq(131) & (rem(212) >> 15)(0)
			// hrem_carry(0) = hrem(18) & (rem(212) >> 15)(0)
			// ## end of interesting ##
			// q(0) = hq_carry(0) + (overflow(212) + hrem_carry(0)) / div(250)
			// rem(212) = rem(212) - q(0) * div(250)
			// mag: [,, 0]
			// ---------------
			// loop-1:
			// rem(-11264) unsigned(54272) = rem(212) << 8
			// rem(-11254) unsigned(54282) = rem(-11264) + w[1](10)
			// ##########################################
			// ## interested only in overflow quantity ##
			// ## as explained before, rem(-11254) now has an overflow, if
			// ## we extract the overflow, it will be 32,768 + 21,514
			// ## the hq(131) is the quotient of 32,768 / 250
			// ## the hrem(18) is the remainder of 32,768 % 250
			// ## so we are now interested only in the overflow part which is 21,514
			// ## to extract the overflow part, will do below:
			// ##########################################
			// overflow(21,514) = rem(-11,254) & (hbit - 1)(32,767)
			// ##########################################
			// ## and below is to use the hq only if we detect an overflow in current loop
			// ## the below shift will produce -1, and only in this case we can
			// ## say we have an overflow and use the high_quotient/high_remainder
			// ##########################################
			// hq_carry(131) = hq(131) & (rem(-11,254) >> 15)(-1)
			// hrem_carry(18) = hrem(18) & (rem(-11,254) >> 15)(-1)
			// ## end of interesting ##
			// ##########################################
			// q(217) = hq_carry(131) + (overflow(21,514) + hrem_carry(18)) / div(250)
			// rem(32) = rem(-11254) - q(217) * div(250)
			// mag: [, -39, 0] -> unsigned [, 217, 0]
			// ---------------
			// loop-0:
			// rem(8192) = rem(32) << 8
			// rem(8442) = rem(8192) + w[0](250)
			// overflow(8442) = rem(8442) & (hbit - 1)(32,767)
			// hq_carry(0) = hq(131) & (rem(8442) >> 15)(0)
			// hrem_carry(0) = hrem(18) & (rem(8442) >> 15)(0)
			// q(33) = hq_carry(0) + (overflow(8442) + hrem_carry(0)) / div(250)
			// rem(192) = rem(8442) - q(33) * div(250)
			// mag: [33, -39, 0] -> unsigned [33, 217, 0]
			// ---------------
			// --## the results ##--
			// ---------------
			// quotient: [33, -39, 0] -> unsigned [33, 217, 0]
			// remainder: [-64] -> unsigned [192]
			// ---------------
			final long high_bit = Long.MIN_VALUE;
			long high_quotient = (high_bit - 1) / long_divisor;
			if (high_quotient * long_divisor + long_divisor == high_bit) {
				++high_quotient;
			}
			final long high_remainder = high_bit - high_quotient * long_divisor;
			long high_quotient_carry = 0;
			long high_remainder_carry = 0;
			long overflow = 0;
			long quotient = 0;
			for (int i = wordsInUse - 1; i >= 0; i--) {
				remainder <<= Integer.SIZE;
				remainder = remainder + (words[i] & Utils.LONG_MASK);

				overflow = (remainder & high_bit - 1);

				high_quotient_carry = (high_quotient & remainder >> 63);
				high_remainder_carry = (high_remainder & remainder >> 63);

				quotient = high_quotient_carry + (overflow + high_remainder_carry) / long_divisor;
				remainder = remainder - quotient * long_divisor;

				words[i] = (int) quotient;
			}
		}

		if (words[wordsInUse - 1] == 0 && wordsInUse > 1)
			--wordsInUse;

		switch (ad) {
		case ASSIGN_QUOTIENT_DISCARD_REMAINDER:
			wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
			return checkInvariantsAndAssign(words, wordsInUse, sign);
		case ASSIGN_QUOTIENT_RETURN_REMAINDER:
			if (isImmutable()) {
				throw new IllegalStateException("can't assign quotient to immuable instance");
			}
			wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
			checkInvariantsAndAssign(words, wordsInUse, sign);
			return Utils.b.of(remainder);
		case ASSIGN_REMAINDER_DISCARD_QUOTIENT:
			words = Utils.ensureCapacity(words, 2);
			words = Utils.assign(words, remainder);
			wordsInUse = Utils.recalcWordsInUse(words, 2);
			return checkInvariantsAndAssign(words, wordsInUse, sign);
		default:
			throw new ImplementationRequiredException(ad.toString());
		}
	}

	public Bits divide(long n) {
		return divideUnsigned(n);
	}

	public Bits remainder(long n) {
		return remainderUnsigned(n);
	}

	public Bits divideAndRemainder(long n) {
		return divideAndRemainderUnsigned(n);
	}

	public Bits divideUnsigned(long n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_QUOTIENT_DISCARD_REMAINDER);
	}

	public Bits remainderUnsigned(long n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_REMAINDER_DISCARD_QUOTIENT);
	}

	public Bits divideAndRemainderUnsigned(long n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_QUOTIENT_RETURN_REMAINDER);
	}

	private Bits divideUnsignedAndAssign(long divisor, int sign, AfterDivision ad) {

		// ---------------
		// check if divisor is 32-bit, if true, go to 32-bit implementation
		// ---------------
		if (divisor == (divisor & Utils.LONG_MASK))
			return divideUnsignedAndAssign((int) divisor, sign, ad);

		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------

		// ---------------
		// if reached here, means divisor is bigger than 32-bit, if this instance has
		// only 1 word (32-bit), consider it as remainder
		// ---------------
		if (wordsInUse == 1) {
			final long remainder = words[0] & Utils.LONG_MASK;
			switch (ad) {
			case ASSIGN_QUOTIENT_DISCARD_REMAINDER:
				return assign(0);
			case ASSIGN_QUOTIENT_RETURN_REMAINDER:
				if (isImmutable()) {
					throw new IllegalStateException("can't assign quotient to immuable instance");
				}
				assign(0);
				return Utils.b.of(remainder);
			case ASSIGN_REMAINDER_DISCARD_QUOTIENT:
				words = Utils.ensureCapacity(words, 2);
				words = Utils.assign(words, remainder);
				wordsInUse = Utils.recalcWordsInUse(words, 2);
				return checkInvariantsAndAssign(words, wordsInUse, sign);
			default:
				throw new ImplementationRequiredException(ad.toString());
			}

		}

		final int leadingZeros = Integer.numberOfLeadingZeros((int) (divisor >>> Integer.SIZE));
		final long divisor_high = divisor >>> Integer.SIZE - leadingZeros;
		final long divisor_low = (divisor << leadingZeros) & Utils.LONG_MASK;
		final long high_bit = Long.MIN_VALUE;

		long u2 = 0;
		long u1 = words[wordsInUse - 1] >>> Integer.SIZE - leadingZeros;
		long u0 = (words[wordsInUse - 1] << leadingZeros | words[wordsInUse - 2] >>> Integer.SIZE - leadingZeros)
				& Utils.LONG_MASK;
		if (leadingZeros == 0) {
			u1 = 0;
			u0 = words[wordsInUse - 1] & Utils.LONG_MASK;
		}

		for (int j = wordsInUse - 2; j >= 0; j--) {
			u2 = u1;
			u1 = u0;
			u0 = leadingZeros > 0 && j > 0
					? (words[j] << leadingZeros | words[j - 1] >>> Integer.SIZE - leadingZeros) & Utils.LONG_MASK
					: (words[j] << leadingZeros) & Utils.LONG_MASK;

			long k = (u2 << Integer.SIZE) + u1; // Unsigned division is a pain in the ass! ='(
			long qhat = (k >>> 1) / divisor_high << 1;
			long t = k - qhat * divisor_high;
			if (t + high_bit >= divisor_high + high_bit)
				qhat++; // qhat = (u[j+n]*b + u[j+n-1])/v[n-1];
			long rhat = k - qhat * divisor_high;

			// Unsigned comparison.
			while (qhat + high_bit >= (1L << Integer.SIZE) + high_bit
					|| qhat * divisor_low + high_bit > (rhat << Integer.SIZE) + u0 + high_bit) {
				--qhat;
				rhat = rhat + divisor_high;
				if (rhat + high_bit >= (1L << Integer.SIZE) + high_bit)
					break;
			}

			// Multiply and subtract. Unfolded loop.
			long p = qhat * divisor_low;
			t = u0 - (p & Utils.LONG_MASK);
			u0 = t & Utils.LONG_MASK;
			k = (p >>> Integer.SIZE) - (t >> Integer.SIZE);
			p = qhat * divisor_high;
			t = u1 - k - (p & Utils.LONG_MASK);
			u1 = t & Utils.LONG_MASK;
			k = (p >>> Integer.SIZE) - (t >> Integer.SIZE);
			t = u2 - k;
			u2 = t & Utils.LONG_MASK;

			words[j] = (int) qhat; // Store quotient digit. If we subtracted too much, add back.
			if (t < 0) {
				--words[j]; // Unfolded loop.
				t = u0 + divisor_low;
				u0 = t & Utils.LONG_MASK;
				t >>>= Integer.SIZE;
				t = u1 + divisor_high + t;
				u1 = t & Utils.LONG_MASK;
				t >>>= Integer.SIZE;
				u2 += t & Utils.LONG_MASK;
			}
		}

		--wordsInUse;
		words[wordsInUse] = 0;
		if (wordsInUse > 1 && words[wordsInUse - 1] == 0)
			--wordsInUse;

		final long tmp = u1 << Integer.SIZE - leadingZeros | u0 >>> leadingZeros;
		final long remainder = leadingZeros == 0 ? tmp : u2 << Long.SIZE - leadingZeros | tmp;

		switch (ad) {
		case ASSIGN_QUOTIENT_DISCARD_REMAINDER:
			wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
			return checkInvariantsAndAssign(words, wordsInUse, sign);
		case ASSIGN_QUOTIENT_RETURN_REMAINDER:
			if (isImmutable()) {
				throw new IllegalStateException("can't assign quotient to immuable instance");
			}
			wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
			checkInvariantsAndAssign(words, wordsInUse, sign);
			return Utils.b.of(remainder);
		case ASSIGN_REMAINDER_DISCARD_QUOTIENT:
			words = Utils.ensureCapacity(words, 2);
			words = Utils.assign(words, remainder);
			wordsInUse = Utils.recalcWordsInUse(words, 2);
			return checkInvariantsAndAssign(words, wordsInUse, sign);
		default:
			throw new ImplementationRequiredException(ad.toString());
		}
	}

	public Bits divide(Bits n) {
		return divideUnsigned(n);
	}

	public Bits remainder(Bits n) {
		return remainderUnsigned(n);
	}

	public Bits divideAndRemainder(Bits n) {
		return divideAndRemainderUnsigned(n);
	}

	public Bits divideUnsigned(Bits n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_QUOTIENT_DISCARD_REMAINDER);
	}

	public Bits remainderUnsigned(Bits n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_REMAINDER_DISCARD_QUOTIENT);
	}

	public Bits divideAndRemainderUnsigned(Bits n) {
		return divideUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM, AfterDivision.ASSIGN_QUOTIENT_RETURN_REMAINDER);
	}

	private Bits divideUnsignedAndAssign(Bits divisor, int sign, AfterDivision ad) {
		if (divisor.isZero()) {
			throw new ArithmeticException("divisor is zero");
		} else if (isZero()) {
			switch (ad) {
			case ASSIGN_QUOTIENT_DISCARD_REMAINDER:
			case ASSIGN_REMAINDER_DISCARD_QUOTIENT:
				return assign(0);
			case ASSIGN_QUOTIENT_RETURN_REMAINDER:
				if (isImmutable()) {
					throw new IllegalStateException("can't assign quotient to immuable instance");
				}
				assign(0);
				return of(0);
			default:
				throw new ImplementationRequiredException(ad.toString());
			}
		}

		int compare = compareTo(divisor);

		if (compare <= 0) {
			switch (ad) {
			case ASSIGN_QUOTIENT_DISCARD_REMAINDER:
				return compare == 0 ? assign(1) : assign(0);
			case ASSIGN_REMAINDER_DISCARD_QUOTIENT:
				return compare == 0 ? assign(0) : this;
			case ASSIGN_QUOTIENT_RETURN_REMAINDER:
				if (isImmutable()) {
					throw new IllegalStateException("can't assign quotient to immuable instance");
				}
				Bits remainder = this.newClone();
				assign(0);
				return remainder;
			default:
				throw new ImplementationRequiredException(ad.toString());
			}
		}

		// ---------------
		// bwordsInUse <= 2
		// ---------------
		int bWordsInUse = divisor.wordsInUse();
		if (bWordsInUse <= 2) {
			if (bWordsInUse == 1) {
				return divideUnsignedAndAssign(divisor.unsafe()[0], sign, ad);
			}
			return divideUnsignedAndAssign(divisor.longValue(), sign, ad);
		}

		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = Utils.ensureCapacity(safe(), wordsInUse + 1);
		int[] bWords = divisor.safe();
		// ---------------

		final int[] q = new int[wordsInUse - bWordsInUse + 1];
		Utils.divideMagnitudes(words, bWords, wordsInUse, bWordsInUse, q);

		final int[] rWords = words;
		wordsInUse = Utils.recalcWordsInUse(q, q.length);
		words = q;
		int rWordsInUse = Utils.recalcWordsInUse(rWords, bWordsInUse);
		switch (ad) {
		case ASSIGN_QUOTIENT_DISCARD_REMAINDER:
			return checkInvariantsAndAssign(words, wordsInUse, sign);
		case ASSIGN_REMAINDER_DISCARD_QUOTIENT:
			return checkInvariantsAndAssign(rWords, rWordsInUse, sign);
		case ASSIGN_QUOTIENT_RETURN_REMAINDER:
			if (isImmutable()) {
				throw new IllegalStateException("can't assign quotient to immuable instance");
			}
			checkInvariantsAndAssign(words, wordsInUse, sign);
			return of(rWords, rWordsInUse);
		default:
			throw new ImplementationRequiredException(ad.toString());
		}
	}

	// ==============
	// ============== multiply
	// ==============

	public Bits multiply(final int n) {
		return multiplyUnsigned(n);
	}

	public Bits multiplyUnsigned(final int n) {
		return multiplyUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM);
	}

	public Bits multiplyUnsignedAndAssign(final int n, int sign) {
		if (n == 0) {
			return assign(0);
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = Utils.ensureCapacity(safe(), wordsInUse + 1);
		// ---------------

		// ---------------
		// unmask multiplier
		// ---------------
		final long multiplier = n & Utils.LONG_MASK;
		long carry = 0;

		for (int i = 0; i < wordsInUse; i++) {
			// ---------------
			// just like normal multiplication
			// ---------------
			carry = (words[i] & Utils.LONG_MASK) * multiplier + carry;
			words[i] = (int) carry;
			carry >>>= Integer.SIZE;
		}
		if (carry != 0) {
			words[wordsInUse++] = (int) carry;
		}

		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	public Bits multiply(final long n) {
		return multiplyUnsigned(n);
	}

	public Bits multiplyUnsigned(final long n) {
		return multiplyUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM);
	}

	public Bits multiplyUnsignedAndAssign(final long n, int sign) {
		if (n == 0) {
			return assign(0);
		} else if ((n & Utils.LONG_MASK) == n) {
			return multiply((int) n);
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = Utils.ensureCapacity(safe(), wordsInUse + 2);
		// ---------------

		// ---------------
		// unmask
		// ---------------
		final long word1 = n >>> Integer.SIZE, word0 = n & Utils.LONG_MASK;
		long carry = 0, next = 0, tmp;
		for (int i = 0; i < wordsInUse; i++) {
			// ---------------
			// since we are multiplying by 2 words, we will use another algorithm, for
			// the seek of simplicity, will use size of 8-bit, and carry container
			// of 16-bit, mask = 255, mag = [-6, 10, -44] -> unsigned [250, 10, 212]
			// and multiplier = 32767(max)
			// ----------------
			// loop-0:
			// carry(0) = carry(0) + next(0);
			// tmp(-1786) unsigned (63750) = (w[0](250) & mask(255)) * word0(255)
			// ## the next will be carried as well to next word
			// next(31750) = (words[0](250) & mask(255)) * word1(127)
			// words[0](-1786) = (int) (tmp(-1786) + carry(0));
			// ###################################
			// # now to combine the (carry) from this column
			// # 1- we must carry the overflow of (tmp) which represent current column
			// # addition
			// # 2- we must carry the overflow of (carry) of current column
			// # 3-
			// # 4-
			// ###################################
			// ---------------
			carry = carry + next;
			tmp = (words[i] & Utils.LONG_MASK) * word0;
			next = (words[i] & Utils.LONG_MASK) * word1;
			words[i] = (int) (tmp + carry);
			carry = (tmp >>> Integer.SIZE) + (carry >>> Integer.SIZE)
					+ ((tmp & Utils.LONG_MASK) + (carry & Utils.LONG_MASK) >>> Integer.SIZE);
		}

		// ---------------
		// assign last overflow
		// ---------------
		carry = carry + next;
		words[wordsInUse++] = (int) carry;
		words[wordsInUse++] = (int) (carry >>> Integer.SIZE);

		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign);
	}

	public Bits multiply(final Bits n) {
		return multiplyUnsigned(n);
	}

	public Bits multiplyUnsigned(final Bits n) {
		return multiplyUnsignedAndAssign(n, Utils.DEFAULT_SIGNUM);
	}

	public Bits multiplyUnsignedAndAssign(final Bits n, int sign) {
		if (isZero()) {
			return this;
		} else if (n.isZero()) {
			return assign(0);
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------
		// ---------------
		int bWordsInUse = n.wordsInUse();
		int[] bWords = n.safe();
		// ---------------

		if (wordsInUse <= 2 || bWordsInUse <= 2) {
			if (bWordsInUse == 1) {
				return multiply(bWords[0]);
			} else if (wordsInUse == 1) {
				final int mul = words[0];
				words = isImmutable() ? bWords : Arrays.copyOf(bWords, bWordsInUse);
				return checkInvariantsAndAssign(words, bWordsInUse, sign()).multiply(mul);
			} else if (bWordsInUse == 2) {
				return multiply((long) bWords[1] << Integer.SIZE | (bWords[0] & Utils.LONG_MASK));
			}
			final long mul = (long) words[1] << Integer.SIZE | (words[0] & Utils.LONG_MASK);
			words = isImmutable() ? bWords : Arrays.copyOf(bWords, bWordsInUse);
			return checkInvariantsAndAssign(words, bWordsInUse, sign()).multiply(mul);
		} else if (wordsInUse < 128 || bWordsInUse < 128 || (long) wordsInUse * bWordsInUse < 1_000_000) {
			if (bWordsInUse < wordsInUse) {
				// xxx
				// xx

				// xx
				// xxx
				final int wiu = wordsInUse;
				final int[] w = words;

				words = bWords;
				wordsInUse = bWordsInUse;

				bWords = w;
				bWordsInUse = wiu;
			}
			int[] product = Utils.multiplyNaive(words, wordsInUse, bWords, bWordsInUse);
			return checkInvariantsAndAssign(product, product.length, sign);
		}

		final boolean parallel = Math.max(wordsInUse, bWordsInUse) >= 20000;

		if (words.length < bWords.length) {
			// words = Utils.ensureCapacity(words, bWords.length);
		}

		if (bWords.length < words.length) {
			// bWords = Utils.ensureCapacity(bWords, words.length);
		}

		int[] product = null;
		final int len = Math.max(wordsInUse, bWordsInUse);
		if (!parallel)
			product = Utils.kmul(words, bWords, 0, len);
		else {
			final ExecutorService pool = Executors.newFixedThreadPool(12);
			try {
				product = Utils.pmul(words, bWords, 0, len, 1, pool);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.shutdown();
			}
		}
		return checkInvariantsAndAssign(product, wordsInUse + bWordsInUse, sign);
	}

	public Bits pow(int exponent) {
		if (exponent < 0) {
			throw new ArithmeticException(String.format("exponent(%d) < 0", exponent));
		} else if (exponent == 0) {
			return assign(1);
		}

		final int src_length = length();
		Bits partToSquare = this;
		int powersOfTwo = partToSquare.getLowestSet();
		long bitsToShiftLong = (long) powersOfTwo * exponent;
		if (bitsToShiftLong > Integer.MAX_VALUE) {
			throw new ArithmeticException(String.format("exponent(%d) will overflow supported range", exponent));
		}
		int bitsToShift = (int) bitsToShiftLong;

		int remainingBits;

		// Factor the powers of two out quickly by shifting right, if needed.
		if (powersOfTwo > 0) {
			partToSquare = partToSquare.shiftRight(powersOfTwo);
			remainingBits = partToSquare.length();
			if (remainingBits == 1) {
				return partToSquare.assign(1).shiftLeft(bitsToShift);
			}
		} else {
			remainingBits = partToSquare.length();
			if (remainingBits == 1) {
				return partToSquare.assign(1);
			}
		}

		// This is a quick way to approximate the size of the result,
		// similar to doing log2[n] * exponent. This will give an upper bound
		// of how big the result can be, and which algorithm to use.
		long scaleFactor = (long) remainingBits * exponent;

		// Use slightly different algorithms for small and large operands.
		// See if the result will safely fit into a long. (Largest 2^63-1)
		if (partToSquare.wordsInUse() == 1 && scaleFactor <= 62) {
			// Small number algorithm. Everything fits into a long.

			long result = 1;
			long baseToPow2 = partToSquare.unsafe()[0] & Utils.LONG_MASK;

			int workingExponent = exponent;

			// Perform exponentiation using repeated squaring trick
			while (workingExponent != 0) {
				if ((workingExponent & 1) == 1) {
					result = result * baseToPow2;
				}

				if ((workingExponent >>>= 1) != 0) {
					baseToPow2 = baseToPow2 * baseToPow2;
				}
			}

			// Multiply back the powers of two (quickly, by shifting left)
			if (powersOfTwo > 0) {
				if (bitsToShift + scaleFactor <= 62) { // Fits in long?
					return partToSquare.assign(result << bitsToShift);
				} else {
					return partToSquare.assign(result).shiftLeft(bitsToShift);
				}
			} else {
				return partToSquare.assign(result);
			}
		} else {
			if ((long) src_length * exponent / Integer.SIZE > Utils.MAX_WORDS_LENGTH) {
				throw new ArithmeticException(String.format("exponent(%d) will overflow supported range", exponent));
			}

			// Large number algorithm. This is basically identical to
			// the algorithm above, but calls multiply() and square()
			// which may use more efficient algorithms for large numbers.
			Bits answer = newInstance().assign(1);

			int workingExponent = exponent;
			// Perform exponentiation using repeated squaring trick
			while (workingExponent != 0) {
				if ((workingExponent & 1) == 1) {
					answer = answer.multiply(partToSquare);
				}

				if ((workingExponent >>>= 1) != 0) {
					partToSquare = partToSquare.square();
				}
			}
			// Multiply back the (exponentiated) powers of two (quickly,
			// by shifting left)
			if (powersOfTwo > 0) {
				answer = answer.shiftLeft(bitsToShift);
			}

			return answer;
		}
	}

	public Bits square() {
		throw new ImplementationRequiredException();
	}

	// ==============
	// ============== Number class implementation
	// ==============
	/**
	 * @return decimal-base int value in two's complement binary representation
	 */
	@Override
	public int intValue() {
		int result = (int) (unsafe()[0] & Utils.BITS_WORD_MASK);
		return result;
	}

	/**
	 * @return decimal-base long value in two's complement binary representation
	 */
	@Override
	public long longValue() {
		int[] words = unsafe();
		long result = words[0] & Utils.LONG_MASK;
		if (wordsInUse() > 1) {
			result |= (((long) words[1] & Utils.BITS_WORD_MASK) << Integer.SIZE);
		}
		return result;
	}

	@Override
	public float floatValue() {
		throw new ImplementationRequiredException();
	}

	@Override
	public double doubleValue() {
		throw new ImplementationRequiredException();
	}

	// ==============
	// ============== to byte-array
	// ==============

	/**
	 * @see #toByteArray(Endian, boolean, byte[])
	 */
	public byte[] toByteArray() {
		return toByteArray(Endian.LITTLE);
	}

	/**
	 * @see #toByteArray(Endian, byte[])
	 */
	public byte[] toByteArray(Endian order) {
		return toByteArray(order, null);
	}

	/**
	 * Convert this bits-set into byte-array
	 * 
	 * @param order the byte-order of returned array, useful to use for
	 *              {@link BigInteger} which uses {@link Endian#BIG}, you can pass
	 *              null to use defaults which is {@link Endian#LITTLE}
	 * @param buf   buffer to reuse, pass null to create new one. Note: if buffer
	 *              size if not enough, this method may reallocate new one
	 */
	public byte[] toByteArray(Endian order, byte[] buf) {
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		if (wordsInUse == 1 && words[0] == 0) {
			return new byte[0];
		}
		// ------------------
		// each integer-word has 4 bytes, e.g: 13 words has 52 bytes
		// we need to make a special calculation for most-significant word, so will skip
		// it in below calculation by saying wordsInUse - 1
		// ------------------
		int bytesCount = 4 * (wordsInUse - 1);
		// ------------------
		// here will count how many full-byte the most-significant-word has, each byte
		// will rise up len by 1
		// ------------------
		for (int x = words[wordsInUse - 1]; x != 0; x >>>= 8) {
			bytesCount++;
		}

		buf = buf == null ? new byte[bytesCount] : Lang.capacity.ensure(buf, buf.length, bytesCount);
		ByteBuffer bb = ByteBuffer.wrap(buf).order(ByteOrder.LITTLE_ENDIAN);
		// ------------------
		// skip most significant-word
		// ------------------
		for (int i = 0; i < wordsInUse - 1; i++) {
			bb.putInt(words[i]);
		}
		// ------------------
		// again, will handle the most significant-word here
		// ------------------
		for (int x = words[wordsInUse - 1]; x != 0; x >>>= 8) {
			bb.put((byte) (x & 0xff));
		}
		if (order == Endian.BIG) {
			return  Lang.reverse.in(buf, buf.length);
		}
		return buf;
	}

	// ==============
	// ============== to integer-array
	// ==============

	/**
	 * @see #toIntegerArray()
	 */
	public int[] toIntegerArray() {
		return toIntegerArray(Endian.LITTLE);
	}

	/**
	 * @return a copy of current words based on given order
	 */
	public int[] toIntegerArray(Endian order) {
		int[] words = safe();
		if (!isImmutable()) {
			words = Arrays.copyOf(words, wordsInUse());
		}
		return order.isLittle() ? words :  Lang.reverse.in(words, words.length);
	}

	// ==============
	// ============== to long-array
	// ==============

	public long[] toLongArray() {
		return toLongArray(Endian.LITTLE);
	}

	/**
	 * @return long-array that equivalents to {@link BitSet#toLongArray()}
	 */
	public long[] toLongArray(Endian order) {
		final int[] words = unsafe();
		final int wordsInUse = wordsInUse();
		long[] dwords = Utils.toLongArray(words, wordsInUse);
		return order.isLittle() ? dwords :  Lang.reverse.in(dwords, dwords.length);
	}

	// ==============
	// ============== to BitSet
	// ==============

	/**
	 * inject this unsigned bit-set into {@link BitSet}
	 */
	public BitSet toBitSet() {
		return BitSet.valueOf(toLongArray());
	}

	// ==============
	// ============== to BigInteger
	// ==============

	/**
	 * inject this unsigned bit-set into {@link BigInteger}
	 */
	public BigInteger toBigInteger() {
		return new BigInteger(toBinary().toString(), 2);
	}

	// ==============
	// ============== flip
	// ==============

	/**
	 * flip specific bit, e.g: index = 3, 1001 -> 0001
	 */
	public Bits flip(int bitIndex) {
		Check.index(bitIndex);
		int[] words = safe();
		int wordsInUse = wordsInUse();
		int wordIndex = Utils.wordIndex(bitIndex);
		// ------------ expend
		int wordsRequired = wordIndex + 1;
		if (wordsInUse < wordsRequired) {
			words = Utils.ensureCapacity(words, wordsRequired);
			wordsInUse = wordsRequired;
		}
		// ------------
		words[wordIndex] ^= (1 << bitIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * flip specific range of bits, e.g: from = 1 to = 4, 1001 -> 0111
	 */
	public Bits flip(int fromIndex, int toIndex) {
		if (fromIndex == toIndex) {
			return this;
		}
		Check.range(fromIndex, toIndex);
		int[] words = safe();
		int wordsInUse = wordsInUse();
		words = Utils.flip(words, wordsInUse, fromIndex, toIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * flip all bits, e.g: 1011 -> 0100
	 */
	public Bits flipAll() {
		return flip(0, size());
	}

	/**
	 * flip MSB only, e.g: 1111 -> 0111
	 */
	public Bits flipMostSignificant() {
		return flip(size() - 1);
	}

	// ==============
	// ============== set
	// ==============

	/**
	 * set specific bit, e.g: index = 0, 0110 -> 1110
	 */
	public Bits set(int bitIndex) {
		Check.index(bitIndex);
		int[] words = safe();
		int wordsInUse = wordsInUse();
		int wordIndex = Utils.wordIndex(bitIndex);
		// ------------ expend
		int wordsRequired = wordIndex + 1;
		if (wordsInUse < wordsRequired) {
			words = Utils.ensureCapacity(words, wordsRequired);
			wordsInUse = wordsRequired;
		}
		// ------------
		words[wordIndex] |= (1 << bitIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * set/clear specific bit based on given boolean
	 */
	public Bits set(int bitIndex, boolean value) {
		if (value)
			return set(bitIndex);
		return clear(bitIndex);
	}

	/**
	 * set specific range of bits, e.g: from = 2, to = 4, 0000 -> 1100
	 */
	public Bits set(int fromIndex, int toIndex) {
		if (fromIndex == toIndex) {
			return this;
		}
		Check.range(fromIndex, toIndex);
		int[] words = safe();
		int wordsInUse = wordsInUse();
		words = Utils.set(words, wordsInUse, fromIndex, toIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * set/clear specific range of bits based on given boolean
	 */
	public Bits set(int fromIndex, int toIndex, boolean value) {
		if (value)
			return set(fromIndex, toIndex);
		return clear(fromIndex, toIndex);
	}

	/**
	 * set/clear all bits based on given boolean
	 */
	public Bits setAll(boolean value) {
		if (value) {
			return set(0, size(), value);
		}
		return clear();
	}

	/**
	 * set MSB only, e.g: 0000 -> 1000
	 */
	public Bits setMostSignificant() {
		return setMostSignificant(true);
	}

	/**
	 * set/clear MSB based on given boolean
	 */
	public Bits setMostSignificant(boolean set) {
		return set(size() - 1, set);
	}

	// ==============
	// ============== clear
	// ==============

	/**
	 * clear specific bit, e.g: index = 0, 0101 -> 0100
	 */
	public Bits clear(int bitIndex) {
		if (isEmpty()) {
			return this;
		}
		Check.index(bitIndex);
		int[] words = safe();
		int wordsInUse = wordsInUse();
		int wordIndex = Utils.wordIndex(bitIndex);
		if (wordIndex >= wordsInUse)
			return this;
		words[wordIndex] &= ~(1 << bitIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * clear specific range of bits, e.g: from = 0, to = 2, 1110 -> 1100
	 */
	public Bits clear(int fromIndex, int toIndex) {
		if (isEmpty() || fromIndex == toIndex) {
			return this;
		}
		Check.range(fromIndex, toIndex);
		int wordsInUse = wordsInUse();
		int[] words = safe();
		words = Utils.clear(words, wordsInUse, fromIndex, toIndex);
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * clear all bits, e.g: 1110 -> 0000
	 */
	public Bits clear() {
		if (isEmpty()) {
			return this;
		}
		int[] words = safe();
		words = Utils.cleanUp(words, 0);
		return checkInvariantsAndAssign(words, 1, Utils.DEFAULT_SIGNUM);
	}

	/**
	 * clear MSB only, e.g: 1110 -> 0100
	 */
	public Bits clearMostSignificant() {
		return clear(size() - 1);
	}

	// ==============
	// ============== get
	// ==============

	/**
	 * test and get specific bit state, e.g: index = 0, 1110 -> false
	 */
	public boolean get(int bitIndex) {
		Check.index(bitIndex);
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		int wordIndex = Utils.wordIndex(bitIndex);
		boolean set = (wordIndex < wordsInUse) && ((words[wordIndex] & (1 << bitIndex)) != 0);
		return set;
	}

	/**
	 * test and get specific range of bits as new {@link Bits}, e.g: int from 2, to
	 * 4, 0110 -> 0001
	 */
	public Bits get(int fromIndex, int toIndex) {
		if (isZero()) {
			return of();
		}
		Check.range(fromIndex, toIndex);
		int[] words = unsafe();
		int len = length();
		int wordsInUse = wordsInUse();
		// ---------------
		// If no set bits in range return empty bitset
		// ---------------
		if (len <= fromIndex || fromIndex == toIndex) {
			return newInstance(new int[] { 0 }, 1, Utils.DEFAULT_SIGNUM, flags(), getLowerBound(), getUpperBound());
		}
		// ---------------
		// An optimization
		// ---------------
		if (toIndex > len) {
			toIndex = len;
		}
		int targetWords = Utils.wordIndex(toIndex - fromIndex - 1) + 1;
		int[] result_words = Utils.get(words, wordsInUse, targetWords, fromIndex, toIndex);
		int result_wordsInUse = Utils.recalcWordsInUse(result_words, targetWords);
		Utils.checkInvariants(result_words, result_wordsInUse);
		return newInstance(result_words, result_wordsInUse, sign(), flags());
	}

	/**
	 * test and get MSB only, e.g: 1110 -> true
	 */
	public boolean getMostSignificant() {
		return get(size() - 1);
	}

	// ==============
	// ============== get index
	// ==============

	/**
	 * <pre>
	 * ..1111 -> 0
	 * ..1000 -> 3
	 * ..0000 -> -1  (if all clear)
	 * </pre>
	 * 
	 * @return lowest set-bit index
	 */
	public int getLowestSet() {
		return Utils.getLowestSet(unsafe(), wordsInUse());
	}

	/**
	 * <pre>
	 * 1010.. -> 31
	 * ..0111 -> 2
	 * ..0000 -> -1  (if all clear)
	 * </pre>
	 * 
	 * @return highest set-bit index
	 */
	public int getHighestSet() {
		return Utils.getHighestSet(unsafe(), wordsInUse());
	}

	/**
	 * <pre>
	 * ..1010 -> 0
	 * ..0111 -> 3
	 * ..0000 -> 0  (if all clear)
	 * </pre>
	 * 
	 * @return lowest clear-bit index
	 */
	public int getLowestClear() {
		return nextClearBit(0);
	}

	/**
	 * <pre>
	 * {@link #size()} = 32, ..1010 -> 31
	 * {@link #size()} = 64, ..1010 -> 63
	 * {@link #size()} = 32, ..0000 -> 31 (if all clear)
	 * </pre>
	 * 
	 * @return highest clear-bit index, based on current {@link #size()}
	 */
	public int getHighestClear() {
		return previousClearBit(size() - 1);
	}

	// ==============
	// ============== number of zeros
	// ==============

	/**
	 * @return number of leading zeros, e.g: 00010110 -> return 3
	 */
	public int numberOfLeadingZeros() {
		return Integer.numberOfLeadingZeros(unsafe()[wordsInUse() - 1]);
	}

	/**
	 * @return number of trailing zeros, e.g: 00010110 -> return 1
	 */
	public int numberOfTrailingZeros() {
		int trailingZeros = 0;
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		// e.g: {0, 0, 1024}, 1st has 32, 2nd has 32 and 3rd has 9, and break
		for (int i = 0; i < wordsInUse; i++) {
			if (words[i] != 0) {
				trailingZeros += Integer.numberOfTrailingZeros(words[i]);
				break;
			}
			trailingZeros += Integer.numberOfTrailingZeros(words[i]);
		}
		return trailingZeros;
	}

	// ==============
	// ============== negate
	// ==============

//	public Bits negate() {
//		return negateAndSign(sign());
//	}
//
//	private Bits negateAndSign(int sign) {
//		if (isEmpty()) {
//			return this;
//		}
//		int wordsInUse = wordsInUse();
//		int[] words = safe();
//		long w = words[0] & Utils.BITS_WORD_MASK;
//		if (w > Integer.MAX_VALUE) {
//			words = Utils.ensureCapacity(words, ++wordsInUse);
//		}
//		// --------------------
////		words[0] = ~words[0] + 1;
////		for (int i = 1; i < wordsInUse; i++) {
////			words[i] = ~words[i];
////		}
//		
//		
//		for (int i = 0; i < wordsInUse; i++) {
//			words[i] = ~words[i] +1;
//		}
//		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
//		return checkInvariantsAndAssign(words, wordsInUse, sign);
//	}

	// ==============
	// ============== next
	// ==============

	/**
	 * find next set-bit index starting from given offset <br>
	 * 
	 * <pre>
	 * ...0110
	 * <<---
	 * </pre>
	 * 
	 * if: offset < 0, return -1<br>
	 * if: offset > {@link #size()}, return -1
	 * 
	 */
	public int nextSetBit(int fromIndex) {
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		return Utils.nextSetBit(words, wordsInUse, fromIndex);
	}

	/**
	 * find next clear-bit index starting from given offset <br>
	 * 
	 * <pre>
	 * ...0110
	 * <<---
	 * </pre>
	 * 
	 * if: offset < 0, return -1<br>
	 * if: offset > {@link #size()}, return offset
	 */
	public int nextClearBit(int fromIndex) {
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		return Utils.nextClearBit(words, wordsInUse, fromIndex);
	}

	// ==============
	// ============== previous
	// ==============

	/**
	 * find previous set-bit index starting from given offset
	 * 
	 * <pre>
	 * ...0110
	 * --->>
	 * </pre>
	 * 
	 * if: offset < 0, return -1<br>
	 * if: offset > {@link #size()}, return {@link #length()} - 1, which is the last
	 * set-bit or -1 if non-set
	 */
	public int previousSetBit(int fromIndex) {
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		return Utils.previousSetBit(words, wordsInUse, length(), fromIndex);
	}

	/**
	 * find previous clear-bit index starting from given offset
	 * 
	 * <pre>
	 * ...0110
	 * --->>
	 * </pre>
	 * 
	 * if: offset < 0, return -1<br>
	 * if: offset > {@link Integer#SIZE}, return offset
	 * 
	 * @return previous clear-bit index starting from given index
	 */
	public int previousClearBit(int fromIndex) {
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		return Utils.previousClearBit(words, wordsInUse, fromIndex);
	}

	// ==============
	// ============== iterators
	// ==============

	/**
	 * iterate over all bits, include leading zero-bits based on current
	 * {@link #wordsInUse()}
	 * 
	 * <br>
	 * <br>
	 * {@link BitsIterator#next()} will return next <b>bit-state</b><br>
	 * e.g: ...1000101, first -> 1, second -> 0, third -> 1 ..etc
	 */
	public BitsIterator iterator() {
		return new AbstractBitsIterator(this) {
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

	/**
	 * @see #nextSetBit(int)
	 */
	public BitsIterator nextSetIterator() {
		return new AbstractBitsIterator(this) {

			@Override
			void init() {
				next = Utils.nextSetBit(words, wordsInUse, 0);
			}

			@Override
			public boolean hasNext() {
				return next >= 0;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = Utils.nextSetBit(words, wordsInUse, next + 1);
				return bitIndex;
			}

		};
	}

	/**
	 * @see {@link #nextClearBit(int)}
	 */
	public BitsIterator nextClearIterator() {
		return new AbstractBitsIterator(this) {
			@Override
			void init() {
				next = Utils.nextClearBit(words, wordsInUse, 0);
			}

			@Override
			public boolean hasNext() {
				return next < size;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = Utils.nextClearBit(words, wordsInUse, next + 1);
				return bitIndex;
			}

		};
	}

	/**
	 * @see #previousSetBit(int)
	 */
	public BitsIterator previousSetIterator() {
		return new AbstractBitsIterator(this) {
			@Override
			void init() {
				next = Utils.previousSetBit(words, wordsInUse, length, size - 1);
			}

			@Override
			public boolean hasNext() {
				return next >= 0;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = Utils.previousSetBit(words, wordsInUse, length, next - 1);
				return bitIndex;
			}
		};
	}

	/**
	 * @see #previousClearBit(int)
	 */
	public BitsIterator previousClearIterator() {
		return new AbstractBitsIterator(this) {
			@Override
			void init() {
				next = Utils.previousClearBit(words, wordsInUse, size - 1);
			}

			@Override
			public boolean hasNext() {
				return next >= 0;
			}

			@Override
			public Integer next() {
				bitIndex = next;
				next = Utils.previousClearBit(words, wordsInUse, next - 1);
				return bitIndex;
			}
		};
	}

	// ==============
	// ============== weight of / value of
	// ==============

	// ==============
	// ============== queries
	// ==============

	/**
	 * @return true if {@link #wordsInUse()} == 1 & word[0] == 0
	 */
	public boolean isZero() {
		return wordsInUse() == 1 && unsafe()[0] == 0;
	}

	/**
	 * e.g: ..0111 -> false
	 * 
	 * @return true {@link #length()} == 0
	 */
	public boolean isEmpty() {
		return length() == 0;
	}

	/**
	 * e.g: ..1111 -> true
	 * 
	 * @return true if {@link #cardinality()} == {@link #size()}
	 */
	public boolean isFull() {
		return cardinality() == size();
	}

	/**
	 * 00<b>1</b>0<br>
	 * 10<b>1</b>1<br>
	 * ----<br>
	 * true
	 * 
	 * @return true if the specified {@code Bits} has any bits set to {@code true}
	 *         that are also set to {@code true} in this {@code Bits}.
	 */
	public boolean intersects(Bits aset) {
		int awordsInUse = aset.wordsInUse();
		int[] awords = aset.unsafe();
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		// ---------------
		for (int i = Math.min(wordsInUse, awordsInUse) - 1; i >= 0; i--) {
			if ((words[i] & awords[i]) != 0) {
				return true;
			}
		}
		return false;
	}

	// ==============
	// ============== count
	// ==============

	/**
	 * {@link #wordsInUse()} * {@link Integer#SIZE}
	 * 
	 * @return how many bits are reserved, usually 32, 64, 96 .. etc
	 */
	public int size() {
		return wordsInUse() * Integer.SIZE;
	}

	/**
	 * {@link #capacityOfWords()} * {@link Integer#SIZE}
	 * 
	 * @return the current max bits capacity can be used<br>
	 *         e.g: current {@link #size()} is 8 bits<br>
	 *         0000 [0000 0100]<br>
	 *         capacity is 12<br>
	 *         <br>
	 */
	public int capacity() {
		return capacityOfWords() * Integer.SIZE;
	}

	/**
	 * @return how many bits in use, e.g: [0001 0100] equals 5 bits in use
	 */
	public int length() {
		final int wordsInUse = wordsInUse();
		final int[] words = unsafe();
		if (wordsInUse == 0 && words[0] == 0) {
			return 0;
		}
		return Utils.lengthOfBits(words, wordsInUse);
	}

	/**
	 * @return length of buffer
	 */
	public int capacityOfWords() {
		return unsafe().length;
	}

	/**
	 * <b>1</b>0<b>11</b> = 3<br>
	 * 
	 * @return how many bits are set based on current {@link #size()}, e.g: [0000
	 *         11001] returns 3
	 */
	public int cardinality() {
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		int set = 0;
		for (int i = 0; i < wordsInUse; i++) {
			set += Integer.bitCount(words[i]);
		}
		return set;
	}

	/**
	 * 1<b>0</b>11 = 1<br>
	 * 
	 * @return how many bits are clear based on current {@link #size()}, e.g:
	 *         wordsInUse = 1 x 32, [0000 11001] 3 are set, so 29 are clear
	 */
	public int clearCardinality() {
		return size() - cardinality();
	}

	// ==============
	// ============== AND
	// ==============

	/**
	 * @see #and(Bits)
	 */
	public Bits and(int n) {
		// ---------------
		int wordsInUse = 1;
		int[] words = safe();
		words = Utils.ensureCapacity(words, wordsInUse);
		// ---------------
		words[0] &= n;
		words = Utils.cleanUp(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * @see #and(Bits)
	 */
	public Bits and(long n) {
		int wordsInUse = 1;
		int[] words = safe();
		// ---------------
		// keep extra slot in-case n has 2 words
		// ---------------
		words = Utils.ensureCapacity(words, 2);
		long word1 = n >>> Integer.SIZE, word0 = n & Utils.BITS_WORD_MASK;
		words[0] &= word0;
		if (word1 != 0) {
			words[wordsInUse++] &= word1;
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		words = Utils.cleanUp(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * Performs a logical <b>AND</b>(if both are set)<br>
	 * 0010<br>
	 * 1011<br>
	 * ---- &<br>
	 * 0010
	 */
	public Bits and(Bits aset) {
		if (this == aset) {
			return this;
		}
		int awordsInUse = aset.wordsInUse();
		int[] awords = aset.safe();
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------
		// the result will be based on smaller wordsInUse, so clear words in bigger bs
		// ---------------
		while (wordsInUse > awordsInUse) {
			words[--wordsInUse] = 0;
		}
		// ---------------
		// Perform logical AND on words in common
		// ---------------
		for (int i = 0; i < wordsInUse; i++) {
			words[i] &= awords[i];
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	// ==============
	// ============== OR
	// ==============

	/**
	 * @see #or(Bits)
	 */
	public Bits or(int n) {
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		words = Utils.ensureCapacity(words, 1);
		// don't drop the rest of words, all must remain
		wordsInUse = wordsInUse < 1 ? 1 : wordsInUse;
		// ---------------
		words[0] |= n;
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * @see #or(Bits)
	 */
	public Bits or(long n) {
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		words = Utils.ensureCapacity(words, 2);
		// ---------------
		// don't drop the rest of words, all must remain
		// ---------------
		wordsInUse = wordsInUse < 2 ? 2 : wordsInUse;
		// ---------------
		long word1 = n >>> Integer.SIZE, word0 = n & Utils.BITS_WORD_MASK;
		words[0] |= word0;
		words[1] |= word1;
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * Performs a logical <b>OR</b>(if any is set)<br>
	 * 0010<br>
	 * 1011<br>
	 * ---- |<br>
	 * 1011
	 */
	public Bits or(Bits aset) {
		if (this == aset) {
			return this;
		}
		int awordsInUse = aset.wordsInUse();
		int[] awords = aset.safe();
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------

		int wordsInCommon = Math.min(wordsInUse, awordsInUse);

		if (wordsInUse < awordsInUse) {
			words = Utils.ensureCapacity(words, awordsInUse);
			wordsInUse = awordsInUse;
		}
		// ---------------
		// Perform logical OR on words in common
		// ---------------
		for (int i = 0; i < wordsInCommon; i++) {
			words[i] |= awords[i];
		}

		// ---------------
		// Copy any remaining words
		// ---------------
		if (wordsInCommon < awordsInUse) {
			System.arraycopy(awords, wordsInCommon, words, wordsInCommon, wordsInUse - wordsInCommon);
		}

		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	// ==============
	// ============== XOR
	// ==============

	/**
	 * @see #xor(Bits)
	 */
	public Bits xor(int n) {
		int wordsInUse = wordsInUse();
		int[] words = safe();
		words = Utils.ensureCapacity(words, 1);
		// ---------------
		words[0] ^= n;
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * @see #xor(Bits)
	 */
	public Bits xor(long n) {
		int wordsInUse = wordsInUse();
		int[] words = safe();
		words = Utils.ensureCapacity(words, 2);
		// ---------------
		long word1 = n >>> Integer.SIZE, word0 = n & Utils.BITS_WORD_MASK;
		words[0] ^= word0;
		words[1] ^= word1;
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * Performs a logical <b>XOR</b> (if both not equals)<br>
	 * 0110<br>
	 * 1011<br>
	 * ---- ^<br>
	 * 1001
	 */
	public Bits xor(Bits aset) {
		int awordsInUse = aset.wordsInUse();
		int[] awords = aset.safe();
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------
		int wordsInCommon = Math.min(wordsInUse, awordsInUse);

		if (wordsInUse < awordsInUse) {
			words = Utils.ensureCapacity(words, awordsInUse);
			wordsInUse = awordsInUse;
		}

		// ---------------
		// Perform logical XOR on words in common
		// ---------------
		for (int i = 0; i < wordsInCommon; i++) {
			words[i] ^= awords[i];
		}

		// ---------------
		// Copy any remaining words
		// ---------------
		if (wordsInCommon < awordsInUse) {
			System.arraycopy(awords, wordsInCommon, words, wordsInCommon, awordsInUse - wordsInCommon);
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	// ==============
	// ============== NOT
	// ==============

	/**
	 * Performs a logical <b>NOT</b>(flip)<br>
	 * 0010<br>
	 * ---- ~<br>
	 * 1101
	 */
	public Bits not() {
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------
		for (int i = wordsInUse - 1; i >= 0; i--) {
			words[i] = ~words[i];
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		words = Utils.cleanUp(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	// ==============
	// ============== AND-NOT
	// ==============

	/**
	 * @see #andNot(Bits)
	 */
	public Bits andNot(int n) {
		// ---------------
		int wordsInUse = 1;
		int[] words = safe();
		words = Utils.ensureCapacity(words, wordsInUse);
		// ---------------
		words[0] &= ~n;
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		words = Utils.cleanUp(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * @see #andNot(Bits)
	 */
	public Bits andNot(long l) {
		// ---------------
		int wordsInUse = 1;
		int[] words = safe();
		// keep extra slot in-case n has 2 words
		words = Utils.ensureCapacity(words, 2);
		// ---------------
		l = ~l;
		long word1 = l >>> Integer.SIZE, word0 = l & Utils.BITS_WORD_MASK;
		words[0] &= word0;
		if (word1 != 0) {
			words[wordsInUse++] &= word1;
		}

		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * Performs a logical <b>AND NOT</b>(flip then perform <b>AND</b>)<br>
	 * 1001<br>
	 * ---- ~<br>
	 * 0110 <br>
	 * <br>
	 * 0010<br>
	 * 0110<br>
	 * ---- &<br>
	 * 0010
	 */
	public Bits andNot(Bits aset) {
		int awordsInUse = aset.wordsInUse();
		int[] awords = aset.safe();
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------
		// Perform logical (a & !b) on words in common
		// ---------------
		for (int i = Math.min(wordsInUse, awordsInUse) - 1; i >= 0; i--) {
			words[i] &= ~awords[i];
		}

		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	// ==============
	// ============== shift
	// ==============

	/**
	 * Performs <b>shift-left</b><br>
	 * 0010<br>
	 * ---- << (2)<br>
	 * 1000
	 * 
	 * @see #FLAG_CIRCULAR_SHIFT
	 */
	public Bits shiftLeft(int shift) {
		final int flags = flags();
		final boolean circular = isFlagged(FLAG_CIRCULAR_SHIFT);
		if (circular) {
			shift = shift % size();
		}
		if (shift == 0 || isEmpty()) {
			return this;
		} else if (shift < 0) {
			return shiftRightUnsigned(-shift);
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------
		// See right shift for below algorithm
		// ---------------
		final int bigShift = shift >>> Utils.ADDRESS_BITS_PER_WORD, smallShift = shift & Utils.BIT_INDEX_MASK;
		if (bigShift > 0) {
			final int newlen = circular ? wordsInUse : wordsInUse + bigShift;
			final int copylen = circular ? wordsInUse - bigShift : wordsInUse;
			if (newlen > words.length) {
				words = Utils.ensureCapacity(words, newlen);
			}
			System.arraycopy(words, 0, words, bigShift, copylen);
			for (int i = 0; i < bigShift; i++) {
				words[i] = 0;
			}
			wordsInUse = newlen;
		}

		if (smallShift > 0) {
			// ---------------
			// check if will overflow, e.g: 001011..., shift by 3 or more will overflow
			// overflow can't exceed 31 on most-significant word, more than that, will be
			// considered as entire word and will be handled with bigShift
			// shifting most-significant word << smallShift and shifting it >> to check if
			// any bits lost, if yes, means will overflow
			// since that max possible overflow is 31 bits (full word), we will increase
			// current words array by 1 only, if no extra slots available
			// if extra slot available, just reset the most-significant word to 0 because it
			// will be recalculated below
			// ---------------
			// overflow may occur due to words array extending, if flagged as circular, no
			// overflow will occur
			// ---------------
			if (!circular) {
				if ((words[wordsInUse - 1] << smallShift >>> smallShift) != words[wordsInUse - 1]) { // Overflow?
					if (++wordsInUse > words.length) {
						words = Utils.ensureCapacity(words, wordsInUse);
					} else {
						words[wordsInUse - 1] = 0;
					}
				}
			}

			// ---------------
			// similar to right-shift, only will go in reverse-loop to hold words before
			// losing them
			// ---------------
			int previous_word = wordsInUse > words.length ? 0 : words[wordsInUse - 1];
			int word = 0;
			int remain = Integer.SIZE - smallShift;
			for (int i = wordsInUse - 1; i > bigShift; i--) {
				word = previous_word << smallShift;
				previous_word = words[i - 1] >>> remain;
				words[i] = word | previous_word;
				previous_word = words[i - 1];
			}
			words[bigShift] = previous_word << smallShift;
		}

		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * Performs <b>unsigned-shift-right</b><br>
	 * <b>Note: </b>this method will ignore MSB and always fill trailing positions
	 * with 0<br>
	 * 1000<br>
	 * ---- >> (2)<br>
	 * 0010<br>
	 * <br>
	 * 
	 * @see #FLAG_CIRCULAR_SHIFT
	 */
	public Bits shiftRightUnsigned(int shift) {
		final int flags = flags();
		if (isFlagged(FLAG_CIRCULAR_SHIFT)) {
			shift = shift % size();
		}
		if (shift == 0 || isEmpty()) {
			return this;
		} else if (shift < 0) {
			return shiftLeft(-shift);
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------

		// ----------------------------
		// bigShift(word-level): is how many word will be shifted, e.g: if we have 3
		// words in use (bits-level 96 bits), and shift = 100, (100 is bits-level), by
		// unsigned-shifting 100 by Utils.ADDRESS_BITS_PER_WORD(5), we will gets how
		// many
		// words is 100 does represents, 100 >>> 5 = 3 words, so wordsShift will shift 3
		// full words
		// ---------------------------
		// smallShift(bits-level): since we were shifting by 100, it represent 3 full
		// words, which equals to 96 bits, so is there any remaining to shift? 100 - 96
		// = 4, thats what smallShift, it represent the remaining of shifts that we need
		// to apply on bits-level, it can be found by 100 & Utils.BIT_INDEX_MASK(31)
		// = 4
		// ----------------------------
		final int bigShift = shift >>> Utils.ADDRESS_BITS_PER_WORD, smallShift = shift & Utils.BIT_INDEX_MASK;

		// ---------------
		// if the all current words will be shifted
		// ---------------
		if (bigShift >= wordsInUse) {
			return clear();
		}

		// -----------------------------
		// if bigShift < wordsInUse, will shift a bunch of words from position
		// to another
		// -----------------------------
		if (bigShift > 0) {
			System.arraycopy(words, bigShift, words, 0, wordsInUse - bigShift);
			wordsInUse -= bigShift;
		}

		// ----------------------------
		// smallShift: assume, we have in bits-level: word[0] = [100..], word[1] =
		// [..001], (dots for continues zeros), the form in bits-level is:
		// [..001][100..], if we want to unsigned-right-shift = 1, we need to transfer
		// some bits from word[1] to word[0], basically, put them above each other to
		// understand
		// [0][100..]
		// [1][..001]
		// so shift word[0] by smallShift(1), will result: [010..]
		// and shift next word which is word[1] by the remaining of (32 - smallShift)
		// which is 31, so word[1] will will result: [100..]
		// now applying OR operator will merge them in the new word which will represent
		// the word[0], doing this repeatedly will do all transfers successfully, only
		// the last word, must be handled separately
		// ----------------------------
		if (smallShift > 0) {
			int word = 0;
			int next_word = 0;
			int remain = Integer.SIZE - smallShift;
			// ---------------
			// loop for all, skip last handle separately
			// ---------------
			for (int i = 0; i < wordsInUse - 1; i++) {
				word = words[i] >>> smallShift;
				next_word = words[i + 1] << remain;
				words[i] = word | next_word;
			}
			// ---------------
			// special-case: if we have only one word, or if we reach last, will be handled
			// here
			// ---------------
			word = words[wordsInUse - 1] >>> smallShift;
			words[wordsInUse - 1] = word;
			// ----------------------------
			if (word == 0 && wordsInUse > 1) {
				--wordsInUse;
			}
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	/**
	 * Performs <b>signed-shift-right</b><br>
	 * <b>Note: </b>this method will use the <b>MSB</b> based on current
	 * {@link #size()} to fill trailing positions<br>
	 * 1000<br>
	 * ---- >> (2)<br>
	 * 1110<br>
	 * <br>
	 * 
	 * @see #FLAG_CIRCULAR_SHIFT
	 */
	public Bits shiftRight(int shift) {
		final int flags = flags();
		if (isFlagged(FLAG_CIRCULAR_SHIFT)) {
			shift = shift % size();
		}
		if (shift == 0 || isEmpty()) {
			return this;
		} else if (shift < 0) {
			return shiftLeft(-shift);
		}
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = safe();
		// ---------------

		// ---------------
		// bigShift(word-level): is how many word will be shifted, e.g: if we have 3
		// words in use (bits-level 96 bits), and shift = 100, (100 is bits-level), by
		// unsigned-shifting 100 by Utils.ADDRESS_BITS_PER_WORD(5), we will gets how
		// many
		// words is 100 does represents, 100 >>> 5 = 3 words, so wordsShift will shift 3
		// full words
		// ---------------
		// smallShift(bits-level): since we were shifting by 100, it represent 3 full
		// words, which equals to 96 bits, so is there any remaining to shift? 100 - 96
		// = 4, thats what smallShift, it represent the remaining of shifts that we need
		// to apply on bits-level, it can be found by 100 & Utils.BIT_INDEX_MASK(31)
		// = 4
		// ---------------
		final int bigShift = shift >>> Utils.ADDRESS_BITS_PER_WORD, smallShift = shift & Utils.BIT_INDEX_MASK;
		final boolean mostSignificantIsSet = getMostSignificant();
		// if the all current words will be shifted
		if (bigShift >= wordsInUse) {
			return clear();
		}

		// ---------------
		// if bigShift < wordsInUse, will shift a bunch of words from position
		// to another
		// ---------------
		if (bigShift > 0) {
			System.arraycopy(words, bigShift, words, 0, wordsInUse - bigShift);
			wordsInUse -= bigShift;
		}

		// ---------------
		// smallShift: assume, we have in bits-level: word[0] = [100..], word[1] =
		// [..001], (dots for continues zeros), the form in bits-level is:
		// [..001][100..], if we want to unsigned-right-shift = 1, we need to transfer
		// some bits from word[1] to word[0], basically, put them above each other to
		// understand
		// [0][100..]
		// [1][..001]
		// so shift word[0] by smallShift(1), will result: [010..]
		// and shift next word which is word[1] by the remaining of (32 - smallShift)
		// which is 31, so word[1] will will result: [100..]
		// now applying OR operator will merge them in the new word which will represent
		// the word[0], doing this repeatedly will do all transfers successfully, only
		// the last word, must be handled separately
		// ---------------
		if (smallShift > 0) {
			int word = 0;
			int next_word = 0;
			int remain = Integer.SIZE - smallShift;
			// loop for all, skip last handle separately
			for (int i = 0; i < wordsInUse - 1; i++) {
				word = words[i] >>> smallShift;
				next_word = words[i + 1] << remain;
				words[i] = word | next_word;
			}
			// ---------------
			// special-case: if we have only one word, or if we reach last, will be handled
			// here
			// ---------------
			word = words[wordsInUse - 1] >> smallShift;
			words[wordsInUse - 1] = word;
			// ----------------------------
			if (word == 0 && wordsInUse > 1) {
				--wordsInUse;
			}
		}
		// ---------------
		// only if most-significant bit is set, consider bigShift words as set bits
		// ---------------
		if (mostSignificantIsSet) {
			wordsInUse += bigShift;
			// ---------------
			// will apply OR Utils.WORD_MASK on on words got shifted by bigShift only
			// ---------------
			for (int i = 0; i < bigShift; i++) {
				// ---------------
				// reverse look
				// ---------------
				words[(wordsInUse - 1) - i] |= Utils.BITS_WORD_MASK;
			}
		}
		wordsInUse = Utils.recalcWordsInUse(words, wordsInUse);
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	// ==============
	// ============== to string / to binary
	// ==============

	/**
	 * @return unsigned decimal representation
	 * @see #toChars()
	 */
	public Chars toDecimal() {
		return Utils.toDecimal(this, isNegative());
	}

	/**
	 * @see #toChars()
	 */
	@Override
	public String toString() {
		return toChars().toString();
	}

	/**
	 * if flagged with {@link #FLAG_TO_STRING_READABLE}<br>
	 * return {@link #toReadable()}<br>
	 * <br>
	 * else<br>
	 * if flagged with {@link #FLAG_TO_STRING_INDEXES_ONLY}<br>
	 * return {@link #toIndexes()}<br>
	 * <br>
	 * else<br>
	 * if flagged with {@link #FLAG_TO_STRING_DECIMAL}<br>
	 * return {@link #toDecimal()}<br>
	 * <br>
	 * else<br>
	 * return {@link #toBinary()}, which by default will strip-leading bits
	 */
	public Chars toChars() {
		if (isFlagged(FLAG_TO_STRING_READABLE)) {
			return toReadable();
		} else if (isFlagged(FLAG_TO_STRING_INDEXES_ONLY)) {
			return toIndexes();
		} else if (isFlagged(FLAG_TO_STRING_DECIMAL)) {
			return toDecimal();
		}
		return toBinary();
	}

	public static void main(String[] args) {
		int from = 9, to = 20;
		Bits b = Bits.of("1110101", 2).flagDecimal().newClone();
		System.out.println(b);
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

	/**
	 * @see #{@link #toReadable(int)}
	 */
	public Chars toReadable() {
		if (isZero())
			return isImmutable() ? Chars.of("0").toImmutable() : Chars.of("0");
		return toReadable(Byte.SIZE);
	}

	/**
	 * @return {@link #toBinary()} with underscore divider, e.g:
	 *         1110000_0011000_0100000_1000000
	 */
	public Chars toReadable(int division) {
		if (isZero())
			return isImmutable() ? Chars.of("0").toImmutable() : Chars.of("0");
		return toBinary(Integer.SIZE * wordsInUse(), true, true, division, '_');
	}

	/**
	 * return set-indexes only, just like {@link BitSet#toString()}, e.g: {1, 4, 32}
	 */
	public Chars toIndexes() {
		if (isZero())
			return isImmutable() ? Chars.of("{}").toImmutable() : Chars.of("{}");
		Chars b = Chars.of(Utils.b.toIndexes(this));
		return isImmutable() ? b.toImmutable() : b;
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public Chars toBinary() {
		if (isZero())
			return isImmutable() ? Chars.of("0").toImmutable() : Chars.of("0");
		return toBinary(-1);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public Chars toBinary(int binarySize) {
		return toBinary(binarySize, false);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public Chars toBinary(int binarySize, boolean includeLeadingZeros) {
		return toBinary(binarySize, includeLeadingZeros, false);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public Chars toBinary(int binarySize, boolean includeLeadingZeros, boolean readable) {
		return toBinary(binarySize, includeLeadingZeros, readable, Byte.SIZE);
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public Chars toBinary(int binarySize, boolean includeLeadingZeros, boolean readable, int division) {
		return toBinary(binarySize, includeLeadingZeros, readable, division, '_');
	}

	/**
	 * @see Chars#insertBinary(int, int, int, boolean, boolean, int, char)
	 */
	public Chars toBinary(int binarySize, boolean includeLeadingZeros, boolean readable, int division, char divider) {
		Chars c = Utils.toBinary(unsafe(), wordsInUse(), binarySize, includeLeadingZeros, readable, division, divider);
		return isImmutable() ? c.toImmutable() : c;
	}

	// ==============
	// ============== compare
	// ==============

	/**
	 * @see #compareTo(Bits)
	 */
	public int compareTo(int n) {
		return wordsInUse() > 1 ? 1 : Integer.compareUnsigned(unsafe()[0], n);
	}

	/**
	 * compare on binary level based on {@link Long#bitCount(int)}
	 */
	public int compareTo(long n) {
		if (wordsInUse() > 2) {
			return 1;
		}
		return Long.compareUnsigned(longValue(), n);
	}

	/**
	 * @see #compareTo(Bits)
	 */
	public int compareTo(java.util.BitSet o) {
		final int wordsInUse = wordsInUse();
		final int owordsInUse = Utils.bs.wordsInUse(o);
		if (wordsInUse != owordsInUse) {
			return Integer.compare(wordsInUse, owordsInUse);
		}

		int len1 = length();
		int len2 = o.length();
		if (len1 != len2) {
			return Integer.compare(len1, len2);
		}

		boolean b1, b2;
		for (int i = len1 - 1; i >= 0; i--) {
			b1 = get(i);
			b2 = o.get(i);
			if (b1 != b2) {
				return Boolean.compare(b1, b2);
			}
		}
		return 0;
	}

	/**
	 * <b>Warning: </b> unsigned implementation only<br>
	 * <br>
	 * 
	 * @see #compareTo(Bits)
	 */
	public int compareTo(java.math.BigInteger o) {
		final int wordsInUse = wordsInUse();
		final int owordsInUse = Utils.bi.wordsInUse(o);
		if (wordsInUse != owordsInUse) {
			return Integer.compare(wordsInUse, owordsInUse);
		}

		int len1 = length();
		int len2 = o.bitLength();
		if (len1 != len2) {
			return Integer.compare(len1, len2);
		}

		boolean b1, b2;
		for (int i = len1 - 1; i >= 0; i--) {
			b1 = get(i);
			b2 = o.testBit(i);
			if (b1 != b2) {
				return Boolean.compare(b1, b2);
			}
		}
		return 0;
	}

	/**
	 * unsigned compare this instance to given other
	 */
	@Override
	public int compareTo(Bits o) {
		final int wordsInUse = wordsInUse();
		final int owordsInUse = o.wordsInUse();
		if (wordsInUse != owordsInUse) {
			return Integer.compare(wordsInUse, owordsInUse);
		}

		final int len1 = length();
		final int len2 = o.length();
		if (len1 != len2) {
			return Integer.compare(len1, len2);
		}

		final int[] words = unsafe();
		final int[] owords = o.unsafe();
		for (int i = wordsInUse - 1; i >= 0; i--) {
			if (words[i] != owords[i]) {
				return Integer.compareUnsigned(words[i], owords[i]);
			}
		}
		return 0;
	}

	// ===========
	// =========== greater-than
	// ===========

	public boolean gt(int n) {
		return compareTo(n) > 0;
	}

	public boolean gt(long n) {
		return compareTo(n) > 0;
	}

	public boolean gt(BitSet bs) {
		return compareTo(bs) > 0;
	}

	public boolean gt(BigInteger bi) {
		return compareTo(bi) > 0;
	}

	public boolean gt(Bits b) {
		return compareTo(b) > 0;
	}

	// ===========
	// =========== greater-than or equals
	// ===========

	public boolean gtOrEq(int n) {
		return compareTo(n) >= 0;
	}

	public boolean gtOrEq(long n) {
		return compareTo(n) >= 0;
	}

	public boolean gtOrEq(BitSet bs) {
		return compareTo(bs) >= 0;
	}

	public boolean gtOrEq(BigInteger bi) {
		return compareTo(bi) >= 0;
	}

	public boolean gtOrEq(Bits b) {
		return compareTo(b) >= 0;
	}

	// ===========
	// =========== less-than
	// ===========

	public boolean lt(int n) {
		return compareTo(n) < 0;
	}

	public boolean lt(long n) {
		return compareTo(n) < 0;
	}

	public boolean lt(BitSet bs) {
		return compareTo(bs) < 0;
	}

	public boolean lt(BigInteger bi) {
		return compareTo(bi) < 0;
	}

	public boolean lt(Bits b) {
		return compareTo(b) < 0;
	}

	// ===========
	// =========== less-than or equals
	// ===========

	public boolean ltOrEq(int n) {
		return compareTo(n) <= 0;
	}

	public boolean ltOrEq(long n) {
		return compareTo(n) <= 0;
	}

	public boolean ltOrEq(BitSet bs) {
		return compareTo(bs) <= 0;
	}

	public boolean ltOrEq(BigInteger bi) {
		return compareTo(bi) <= 0;
	}

	public boolean ltOrEq(Bits b) {
		return compareTo(b) <= 0;
	}

	// ===========
	// =========== equals
	// ===========

	public boolean eq(int n) {
		return compareTo(n) == 0;
	}

	public boolean eq(long n) {
		return compareTo(n) == 0;
	}

	public boolean eq(BitSet bs) {
		return compareTo(bs) == 0;
	}

	public boolean eq(BigInteger bi) {
		return compareTo(bi) == 0;
	}

	public boolean eq(Bits b) {
		return compareTo(b) == 0;
	}

	// ===========
	// =========== not
	// ===========

	public boolean neq(int n) {
		return compareTo(n) != 0;
	}

	public boolean neq(long n) {
		return compareTo(n) != 0;
	}

	public boolean neq(BitSet bs) {
		return compareTo(bs) != 0;
	}

	public boolean neq(BigInteger bi) {
		return compareTo(bi) != 0;
	}

	public boolean neq(Bits b) {
		return compareTo(b) != 0;
	}

	// ===========
	// =========== max
	// ===========

	/**
	 * @see #max(Bits)
	 */
	public Bits max(int n) {
		if (wordsInUse() > 1) {
			return this;
		}
		int len = length();
		int nlen = Utils.i.lengthOfBits(n);
		if (len == nlen) {
			return Integer.compareUnsigned(unsafe()[0], n) >= 0 ? this : Utils.b.of(n);
		}
		return len > nlen ? this : Utils.b.of(n);
	}

	/**
	 * @see #max(Bits)
	 */
	public Bits max(long n) {
		if (wordsInUse() > 2) {
			return this;
		}
		int len = length();
		int nlen = Utils.l.lengthOfBits(n);
		if (len == nlen) {
			return Long.compareUnsigned(longValue(), n) >= 0 ? this : Utils.b.of(n);
		}
		return len > nlen ? this : Utils.b.of(n);
	}

	/**
	 * @see #max(Bits)
	 */
	public Bits max(BitSet bs) {
		if (wordsInUse() > Utils.bs.wordsInUse(bs)) {
			return this;
		}
		int len = length();
		int nlen = bs.length();
		if (len == nlen) {
			return compareTo(bs) >= 0 ? this : Utils.b.of(bs);
		}
		return len > nlen ? this : Utils.b.of(bs);
	}

	/**
	 * <b>Warning: </b> unsigned implementation only<br>
	 * <br>
	 * 
	 * @see #max(Bits)
	 */
	public Bits max(BigInteger bi) {
		if (wordsInUse() > Utils.bi.wordsInUse(bi)) {
			return this;
		}
		int len = length();
		int nlen = bi.bitLength();
		if (len == nlen) {
			return compareTo(bi) >= 0 ? this : Utils.b.of(bi);
		}
		return len > nlen ? this : Utils.b.of(bi);
	}

	/**
	 * <pre>
	 *	0111_1111 vs 1000_0000 -> 1000_0000
	 *	1111_1111 vs 1000_0000 -> 1111_1111
	 * </pre>
	 * 
	 * @return the greater, if given competitor is not {@link Bits} instance, it
	 *         will be wrapped and returned
	 */
	public Bits max(Bits b) {
		if (wordsInUse() > b.wordsInUse()) {
			return this;
		}
		int len = length();
		int nlen = b.length();
		if (len == nlen) {
			// 1111_1111 vs 1000_0000
			return compareTo(b) >= 0 ? this : b;
		}
		// 0111_1111 vs 1000_0000
		return len > nlen ? this : b;
	}

	// ===========
	// =========== min
	// ===========

	/**
	 * @see #min(Bits)
	 */
	public Bits min(int n) {
		if (wordsInUse() < 1) {
			return this;
		}
		int len = length();
		int nlen = Utils.i.lengthOfBits(n);
		if (len == nlen) {
			return Integer.compareUnsigned(unsafe()[0], n) <= 0 ? this : Utils.b.of(n);
		}
		return len < nlen ? this : Utils.b.of(n);
	}

	/**
	 * @see #min(Bits)
	 */
	public Bits min(long n) {
		if (wordsInUse() < 2) {
			return this;
		}
		int len = length();
		int nlen = Utils.l.lengthOfBits(n);
		if (len == nlen) {
			return Long.compareUnsigned(longValue(), n) <= 0 ? this : Utils.b.of(n);
		}
		return len < nlen ? this : Utils.b.of(n);
	}

	/**
	 * @see #min(Bits)
	 */
	public Bits min(BitSet bs) {
		if (wordsInUse() < Utils.bs.wordsInUse(bs)) {
			return this;
		}
		int len = length();
		int nlen = bs.length();
		if (len == nlen) {
			return compareTo(bs) <= 0 ? this : Utils.b.of(bs);
		}
		return len < nlen ? this : Utils.b.of(bs);
	}

	/**
	 * <b>Warning: </b> unsigned implementation only<br>
	 * <br>
	 * 
	 * @see #min(Bits)
	 */
	public Bits min(BigInteger bi) {
		if (wordsInUse() < Utils.bi.wordsInUse(bi)) {
			return this;
		}
		int len = length();
		int nlen = bi.bitLength();
		if (len == nlen) {
			return compareTo(bi) <= 0 ? this : Utils.b.of(bi);
		}
		return len < nlen ? this : Utils.b.of(bi);
	}

	/**
	 * <pre>
	 *	0111_1111 vs 1000_0000 -> 1000_0000
	 *	1111_1111 vs 1000_0000 -> 1111_1111
	 * </pre>
	 * 
	 * @return the smaller, if given competitor is not {@link Bits} instance, it
	 *         will be wrapped and returned
	 */
	public Bits min(Bits b) {
		if (wordsInUse() < b.wordsInUse()) {
			return this;
		}
		int len = length();
		int nlen = b.length();
		if (len == nlen) {
			// 1111_1111 vs 1000_0000
			return compareTo(b) <= 0 ? this : b;
		}
		// 0111_1111 vs 1000_0000
		return len < nlen ? this : b;
	}

	// ==============
	// ============== extras
	// ==============

	/**
	 * trim buffer to current {@link #wordsInUse()}
	 */
	public Bits trimToSize() {
		int[] words = unsafe();
		int wordsInUse = wordsInUse();
		if (wordsInUse != words.length) {
			words = Arrays.copyOf(words, wordsInUse);
		}
		return checkInvariantsAndAssign(words, wordsInUse, sign());
	}

	@Override
	public int hashCode() {
		int wordsInUse = wordsInUse();
		int[] words = unsafe();
		int h = 1234;
		for (int i = wordsInUse; --i >= 0;) {
			h ^= words[i] * (i + 1);
		}
		return (int) ((h >> Integer.SIZE) ^ h);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bits)) {
			return false;
		}
		if (this == obj) {
			return true;
		}

		Bits aset = (Bits) obj;
		// ---------------
		int awordsInUse = aset.wordsInUse();
		int[] awords = aset.unsafe();
		// ---------------
		int wordsInUse = wordsInUse();
		int[] words = unsafe();

		if (wordsInUse != awordsInUse) {
			return false;
		}
		// ---------------
		// Check words in use by both
		// ---------------
		for (int i = 0; i < wordsInUse; i++) {
			if (words[i] != awords[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * stream over next-set-bits
	 * 
	 * @see #nextSetBit(int)
	 * @see #nextSetIterator()
	 */
	public IntStream stream() {
		class BitSetIterator implements PrimitiveIterator.OfInt {
			int next = nextSetBit(0);

			@Override
			public boolean hasNext() {
				return next != -1;
			}

			@Override
			public int nextInt() {
				if (next != -1) {
					int ret = next;
					next = nextSetBit(next + 1);
					return ret;
				} else {
					throw new NoSuchElementException();
				}
			}
		}

		return StreamSupport.intStream(
				() -> Spliterators.spliterator(new BitSetIterator(), cardinality(),
						Spliterator.ORDERED | Spliterator.DISTINCT | Spliterator.SORTED),
				Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.ORDERED | Spliterator.DISTINCT
						| Spliterator.SORTED,
				false);
	}

	// ==============
	// ============== help tools
	// ==============

	/**
	 * - <b>internal use only</b><br>
	 * check and assign
	 */
	Bits checkInvariantsAndAssign(int[] words, int wordsInUse, int sign) {
		Utils.checkInvariants(words, wordsInUse);
		if (wordsInUse != words.length && isImmutable()) {
			words = Arrays.copyOf(words, wordsInUse);
		}
		return assign(words, wordsInUse, sign, flags());
	}

	// ===========================
	// ===========================
	// ===========================
	// =========================== below for debuging only
	// ===========================
	// ===========================
	// ===========================
	// ===========================

	private static void assertEquals(boolean b, boolean c) {
		if (b != c)
			throw new IllegalStateException(String.format("%s != %s", b, c));
	}

	private static void assertEquals(int b, int c) {
		if (b != c)
			throw new IllegalStateException(String.format("%s != %s", b, c));
	}

	private static void assertEquals(long b, long c) {
		if (b != c)
			throw new IllegalStateException(String.format("%s != %s", b, c));

	}

	private static void assertEquals(String b, String c) {
		if (!b.equals(c)) {
			throw new IllegalStateException(String.format("%s != %s", b, c));
		}
	}

	private static void assertEquals(BigInteger j, Bits b) {
		String x = j.toString();
		String y = b.toDecimal().toString();
		if (!x.equals(y)) {
			String f = String.format("\nj: %s\n!=\nb: %s\nj: %s\nb: %s", x, y, Arrays.toString(Utils.bi.words(j)),
					Arrays.toString(b.toIntegerArray()));
			throw new IllegalStateException(f);
		}
	}

	private static int[] toIntegerArray(long n) {
		final int word1 = (int) (n >>> Integer.SIZE), word0 = (int) (n & Utils.LONG_MASK);
		return word1 == 0 ? new int[] { word0 } : new int[] { word0, word1 };
	}

	private static long fromIntegerArray(int[] a) {
		if (a.length > 2)
			throw new IllegalStateException();
		return (a[1] & Utils.LONG_MASK) << 32 | (int) (a[0] & Utils.LONG_MASK);
	}

	public static String asUnsigned(long l) {
		return asUnsigned(toIntegerArray(l));
	}

	public static String asUnsigned(int[] w) {
		String s = "[";
		for (int i = 0; i < w.length; i++) {
			s += w[i] & Utils.LONG_MASK;
			if (i < w.length - 1) {
				s += ", ";
			}
		}
//		return s + "]";
		return Arrays.toString(w);
	}

	private static BigInteger bi(long n) {
		return BigInteger.valueOf(n);
	}

	private static int[] newRandomWordsByWordsInUse(int wiu) {
		int n = 0;
		int[] w = new int[wiu];
		for (int i = 0; i < wiu - 1; i++) {
			w[i] = Digits.RANDOM.nextInt();
		}
		// ensure last is not zero
		while ((n = Digits.RANDOM.nextInt()) == 0)
			;
		w[wiu - 1] = n;
		return w;
	}

	private static int compareTo(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return Integer.compare(s1.length(), s2.length());
		}
		int x = s1.compareTo(s2);
		if (x > 0) {
			return 1;
		} else if (x < 0) {
			return -1;
		}
		return 0;
	}

}
