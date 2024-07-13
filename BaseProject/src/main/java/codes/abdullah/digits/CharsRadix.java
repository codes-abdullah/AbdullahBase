package codes.abdullah.digits;

import java.io.Serializable;
import java.io.Writer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import codes.abdullah.project.Immutable;
import codes.abdullah.project.lang.Lang;

public abstract class CharsRadix implements Immutable<CharsRadix>, Serializable {
	private static final long serialVersionUID = -7243287709093907733L;
	private final int flags, min_size, radix, expansion, writingMethod, delimitation;
	private final char delimiter;
	private final String prefix;

	// ==========
	/*
	 * (Radix / Base-system) [required] represent 4 common radixes (2,8,10 and 16)
	 */
	public static final int RADIX_02;
	public static final int RADIX_08;
	public static final int RADIX_10;
	public static final int RADIX_16;
	// ==========
	/*
	 * (Minimum size / Start-up size) [optional] min_size represent the minimum size
	 * can be produced or the startup size, if produced digits is larger then this
	 * size, an expansion is used, if set
	 */
	public static final int MIN_SIZE_02;
	public static final int MIN_SIZE_04;
	public static final int MIN_SIZE_08;
	public static final int MIN_SIZE_16;
	public static final int MIN_SIZE_32;
	public static final int MIN_SIZE_64;
	// ==========
	/*
	 * (Minimum additional slots / Allocation size) [optional] while producing
	 * digits, we need to expand and add more slots as much as needed, the expansion
	 * does represent the allocated space for the new digits, so we can say for
	 * example: make new space by (expansion_02) chars, the unused space will be
	 * filled with zeros
	 */
	public static final int EXPANSION_02;
	public static final int EXPANSION_04;
	public static final int EXPANSION_08;
	public static final int EXPANSION_16;
	public static final int EXPANSION_32;
	public static final int EXPANSION_64;
	// ==========
	/*
	 * (Grouping size) [optional] delimitation can be used to inject a delimiter to
	 * represent groups in the whole produced text
	 */
	public static final int DELIMITATION_02;
	public static final int DELIMITATION_04;
	public static final int DELIMITATION_08;
	public static final int DELIMITATION_16;
	public static final int DELIMITATION_32;
	public static final int DELIMITATION_64;
	// ==========
	/*
	 * (Writing method): [required]
	 */
	public static final int WRITE_APPEND;
//	public static final int WRITE_FIRST;
	public static final int WRITE_OVERWRITE;
	// ==========
	/*
	 * [optional]
	 */
	public static final int INCLUDE_PREFIX;
	// =========
	static {
		int n = 1;
		// ==========
		RADIX_02 = (n);
		RADIX_08 = (n <<= 1);
		RADIX_10 = (n <<= 1);
		RADIX_16 = (n <<= 1);
		// ========== offset = 3
		MIN_SIZE_02 = (n <<= 1);
		MIN_SIZE_04 = (n <<= 1);
		MIN_SIZE_08 = (n <<= 1);
		MIN_SIZE_16 = (n <<= 1);
		MIN_SIZE_32 = (n <<= 1);
		MIN_SIZE_64 = (n <<= 1);
		// ========== offset = 9
		EXPANSION_02 = (n <<= 1);
		EXPANSION_04 = (n <<= 1);
		EXPANSION_08 = (n <<= 1);
		EXPANSION_16 = (n <<= 1);
		EXPANSION_32 = (n <<= 1);
		EXPANSION_64 = (n <<= 1);
		// ========== offset 15
		DELIMITATION_02 = (n <<= 1);
		DELIMITATION_04 = (n <<= 1);
		DELIMITATION_08 = (n <<= 1);
		DELIMITATION_16 = (n <<= 1);
		DELIMITATION_32 = (n <<= 1);
		DELIMITATION_64 = (n <<= 1);
		// ==========
		WRITE_APPEND = (n <<= 1);
		WRITE_OVERWRITE = (n <<= 1);
		// ==========
		INCLUDE_PREFIX = (n <<= 1);
	}

	public static CharsRadix ofBinary() {
		return of(RADIX_02 | MIN_SIZE_08 | EXPANSION_08 | DELIMITATION_08 | WRITE_OVERWRITE, '_');
	}

	public static CharsRadix of() {
		return of(0);
	}

	public static CharsRadix of(int flags) {
		return of(flags, (char) 0);
	}

	public static CharsRadix of(int flags, char delimiter) {
		return new MutableCharsRadix(flags, delimiter, null);
	}

	CharsRadix(int flags) {
		this(flags, (char) 0);
	}

	CharsRadix(int flags, char delimiter) {
		this.flags = flags;
		// =========
		// radix: required, 10 by default
		// =========
		this.radix = findRadix(flags);
		// =========
		// min-size: optional, 4 by default
		// MIN_SIZE_02 offset on bit 4th (value 16) will shift to right by 3 to extract
		// its value starting from value 2
		// =========
		this.min_size = findByBitAndUnsignedRightShift(flags, MIN_SIZE_02, MIN_SIZE_64, 0, 3);
		// =========
		// expansion: optional, 4 by default
		// EXPANSION_02 offset on bit 10th (value 1024) will shift to right by 9 to
		// extract its value starting from value 2
		// =========
		this.expansion = findByBitAndUnsignedRightShift(flags, EXPANSION_02, EXPANSION_64, 0, 9);
		// =========
		// delimitation: optional, -1 by default
		// DELIMITATION_02 offset on bit 17th (value 65536) will shift to right by 9 to
		// extract its value starting from value 2
		// =========
		this.delimitation = findByBitAndUnsignedRightShift(flags, DELIMITATION_02, DELIMITATION_64, 0, 15);
		this.delimiter = delimiter;
		if (delimitation == 0 && delimiter != 0) {
			throw new IllegalArgumentException(
					"either you set both delimiter & delimitation flag, or you unset both of them, found: delimitation == 0 && delimiter != 0");
		} else if (delimitation != 0 && delimiter == 0) {
			throw new IllegalArgumentException(
					"either you set both delimiter & delimitation flag, or you unset both of them, found: delimitation != 0 && delimiter == 0");
		}
		// =========
		// writing-method: required, overwrite by default
		// =========
		this.writingMethod = findByBit(flags, WRITE_APPEND, WRITE_OVERWRITE, WRITE_OVERWRITE);
		this.prefix = Digits.ints.isFlagged(flags, INCLUDE_PREFIX) ? findPrefix(radix) : "";

	}

	public CharsRadix put(final int n) {
		StringBuilder chars = getChars();
		char[] buffer = getBuffer();
		int required = Integer.max(Digits.ints.lengthOf(n, radix), min_size);
		required += getMissing(required, chars);
		// -------------
		// calculate delimiters required
		// -------------
		required += (delimitation != 0 && required > delimitation ? Digits.ints.headsCount(required, delimitation) - 1
				: 0);

		int offset = 0;
		buffer = Lang.capacity.ensure(buffer, buffer.length, required);
		int charPos = Digits.ints.format(n, radix, buffer, required, offset, delimitation, delimiter);

		// -------------
		// find how many zeros remaining
		// -------------
		final boolean delim = delimitation > 0 && delimiter > 0;
		final boolean insertLeadingZeros = min_size > 0 && expansion > 0;
		if (insertLeadingZeros) {
			int zeros = offset - (offset - charPos);
			for (int i = 0, x = 0; i < zeros; i++, x++) {
				if (delim && i > 0 && x % delimitation == 0) {
					buffer[i++] = delimiter;
					x = 0;
					charPos--;
					if (i >= zeros)
						break;
				}
				buffer[i] = '0';
				charPos--;
			}
		}

		if (Digits.ints.isFlagged(writingMethod, WRITE_APPEND)) {
			if (isDelimitable() && chars.length() != 0) {
				chars = chars.append(delimiter);
			}
			chars = chars.append(buffer, charPos, required);
		} else {
			chars = chars.delete(0, chars.length()).append(buffer, charPos, required);
		}

		return assign(chars);
	}

	public CharsRadix put(final long n) {
		StringBuilder chars = getChars();
		char[] buffer = getBuffer();
		int required = Integer.max(Digits.longs.lengthOf(n, radix), min_size);
		required += getMissing(required, chars);
		// -------------
		// calculate delimiters required
		// -------------
		required += (delimitation != 0 && required > delimitation ? Digits.ints.headsCount(required, delimitation) - 1
				: 0);

		int offset = 0;
		buffer = Lang.capacity.ensure(buffer, buffer.length, required);
		int charPos = Digits.longs.format(n, radix, buffer, required, offset, delimitation, delimiter);

		// -------------
		// find how many zeros remaining
		// -------------
		final boolean delim = delimitation > 0 && delimiter > 0;
		final boolean insertLeadingZeros = min_size > 0 && expansion > 0;
		if (insertLeadingZeros) {
			int zeros = offset - (offset - charPos);
			for (int i = 0, x = 0; i < zeros; i++, x++) {
				if (delim && i > 0 && x % delimitation == 0) {
					buffer[i++] = delimiter;
					x = 0;
					charPos--;
					if (i >= zeros)
						break;
				}
				buffer[i] = '0';
				charPos--;
			}
		}

		if (Digits.ints.isFlagged(writingMethod, WRITE_APPEND)) {
			if (isDelimitable() && chars.length() != 0) {
				chars = chars.append(delimiter);
			}
			chars = chars.append(buffer, charPos, required);
		} else {
			chars = chars.delete(0, chars.length()).append(buffer, charPos, required);
		}

		return assign(chars);
	}

	int getMissing(int len) {
		return getMissing(len, null);
	}

	int getMissing(int len, CharSequence previous) {
		// ---------
		// e.g: 0b100, min_size = 02, expansion = 04, find missing for expansion
		// ---------
		int missing = 0;
		boolean prev = previous != null && previous.length() > 0;
		boolean expandable = expansion != 0 && len % expansion != 0;
		boolean delimitable = delimitation != 0 && len % delimitation != 0 && prev;
		if (len >= min_size && delimitable) {
			missing = Digits.ints.headMissing(len, delimitation);
		} else if (len > min_size && expandable) {
			missing = Digits.ints.headMissing(len, expansion);
		} else if (len < min_size) {
			// ---------
			// e.g: 0b100, min_size = 04, find missing for min_size
			// ---------
			missing = Digits.ints.headMissing(len, min_size);
		}
		return missing;
	}

	abstract CharsRadix assign(StringBuilder sb);

	abstract StringBuilder getChars();

	abstract char[] getBuffer();

	public int getDelimitation() {
		return delimitation;
	}

	public char getDelimiter() {
		return delimiter;
	}

	public int getExpansion() {
		return expansion;
	}

	public int getFlags() {
		return flags;
	}

	public int getMinSize() {
		return min_size;
	}

	public String getPrefix() {
		return prefix;
	}

	public boolean isWriteOverwite() {
		return Digits.ints.isFlagged(flags, WRITE_OVERWRITE);
	}

	public boolean isWriteAppend() {
		return Digits.ints.isFlagged(flags, WRITE_APPEND);
	}

	public boolean isIncludePrefix() {
		return Digits.ints.isFlagged(flags, INCLUDE_PREFIX);
	}

	public boolean isDelimitable() {
		return delimitation != 0 && delimiter != 0;
	}

	public boolean isExpandable() {
		return expansion != 0;
	}

	public int getRadix() {
		return radix;
	}

	@Override
	public String toString() {
		return prefix + getChars().toString();
	}

	private static int findRadix(int flags) {
		if (Digits.ints.isFlagged(flags, RADIX_16))
			return 16;
		else if (Digits.ints.isFlagged(flags, RADIX_08))
			return 8;
		else if (Digits.ints.isFlagged(flags, RADIX_02))
			return 2;
		return 10;
	}

	private static String findPrefix(int radix) {
		switch (radix) {
		case 2:
			return "0b";
		case 8:
			return "0";
		case 16:
			return "0x";
		default:
			return "";
		}
	}

	/**
	 * invoke {@link #findByBit(int, int, int, int)}, if returned value is > 0, will
	 * do n >>> shift, otherwise return n
	 */
	private static int findByBitAndUnsignedRightShift(int flags, int firstBit, int lastBit, int defaultResult,
			int shift) {
		int n = findByBit(flags, firstBit, lastBit, defaultResult);
		if (n > 0)
			return n >>> shift;
		return n;
	}

	/**
	 * limited method<br>
	 * search through bits for specific flag<br>
	 * e.g: ...1000010000, firstBit value = 16, lastBit value = 512, if given flags
	 * has set any bit from 16 (inclusive) to 512 (inclusive), will return that bit,
	 * otherwise return defaultResult
	 */
	private static int findByBit(int flags, int firstBit, int lastBit, int defaultResult) {
		int bit = lastBit;
		// check lastBit since below for-loop will exclude lastBit from searching
		if (Digits.ints.isFlagged(flags, bit))
			return bit;
		// find how many loops (inclusive - exclusive), lastBit must be checked before
		// this point
		int loops = (Integer.numberOfLeadingZeros(firstBit) - Integer.numberOfLeadingZeros(lastBit));
		for (int i = 0; i < loops; i++) {
			if (Digits.ints.isFlagged(flags, bit >>= 1))
				return bit;
		}
		return defaultResult;
	}

	String stringfyFlags() {
		return FlagsIterator.stringfyFlags(flags);
	}

	String explainFlags() {
		return FlagsIterator.explainFlags(flags, delimiter);
	}

	/**
	 * (Radix / Base-system) [<b>required</b>] represent 4 common radixes (2,8,10
	 * and 16)<br>
	 */
	static int[] getRadixesFlags() {
		return new int[] { RADIX_02, RADIX_08, RADIX_10, RADIX_16 };
	}

	/**
	 * (Minimum Size / Start-up size) [<b>required</b>] min_size represent the
	 * minimum size can be produced or the startup size, if produced digits is
	 * larger then this size, an expansion is used, if set<br>
	 */
	static int[] getMinSizeFlags() {
		return new int[] { MIN_SIZE_02, MIN_SIZE_04, MIN_SIZE_08, MIN_SIZE_16, MIN_SIZE_32, MIN_SIZE_64 };
	}

	/**
	 * (Minimum additional slots / Allocation size) [<b>required</b>] while
	 * producing digits, we need to expand and add more slots as much as needed, the
	 * expansion does represent the allocated space for the new digits, so we can
	 * say for example: make new space by (expansion_02) chars, the unused space
	 * will be filled with zeros<br>
	 */
	static int[] getExpansionFlags() {
		return new int[] { EXPANSION_02, EXPANSION_04, EXPANSION_08, EXPANSION_16, EXPANSION_32, EXPANSION_64 };
	}

	/**
	 * (Grouping size) [<b>optional</b>] delimitation can be used to inject a
	 * delimiter to represent groups in the whole produced text<br>
	 */
	static int[] getDelimitationFlags() {
		return new int[] { DELIMITATION_02, DELIMITATION_04, DELIMITATION_08, DELIMITATION_16, DELIMITATION_32,
				DELIMITATION_64, 0 };
	}

	/**
	 * (Writing method): [<b>required</b>]<br>
	 */
	static int[] getWriteFlags() {
		return new int[] { WRITE_APPEND, WRITE_OVERWRITE };
	}

	/**
	 * Usage: <b>Optional</b>
	 */
	static int[] getIncludePrefixFlags() {
		return new int[] { INCLUDE_PREFIX, 0 };
	}

	static class FlagsIterator implements Iterator<Integer> {

		private boolean hasMore = true;
		private int iRadix, iMinSize, iExpension, iDelimitation, iWrite, iIncludePrefix;
		private int[] radixesFlags = CharsRadix.getRadixesFlags();
		private int[] minSizesFlags = CharsRadix.getMinSizeFlags();
		private int[] expansionsFlags = CharsRadix.getExpansionFlags();
		private int[] delimitationFlags = CharsRadix.getDelimitationFlags();
		private int[] writeFlags = CharsRadix.getWriteFlags();
		private int[] includePrefixesFlags = CharsRadix.getIncludePrefixFlags();
		private int excludeFlags;

		FlagsIterator() {

		}

		FlagsIterator(int excludeFlags) {
			this.excludeFlags = excludeFlags;
		}

		FlagsIterator withoutMinSizeFlags() {
			return new FlagsIterator(excludeFlags | Digits.ints.combineFlags(getMinSizeFlags()));
		}

		FlagsIterator withoutExpansionFlags() {
			return new FlagsIterator(excludeFlags | Digits.ints.combineFlags(getExpansionFlags()));
		}

		FlagsIterator withoutDelimitaionFlags() {
			return new FlagsIterator(excludeFlags | Digits.ints.combineFlags(getDelimitationFlags()));
		}

		FlagsIterator withoutWriteFlags() {
			return new FlagsIterator(excludeFlags | Digits.ints.combineFlags(getWriteFlags()));
		}

		FlagsIterator withoutIncludePrefixesFlags() {
			return new FlagsIterator(excludeFlags | Digits.ints.combineFlags(getIncludePrefixFlags()));
		}

		@Override
		public boolean hasNext() {
			return hasMore;
		}

		@Override
		public Integer next() {
			if (!hasMore)
				throw new NoSuchElementException();
			int radixFlag = radixesFlags[iRadix];
			int minSizeFlag = minSizesFlags[iMinSize];
			int expansionFlag = expansionsFlags[iExpension];
			int delimitationFlag = delimitationFlags[iDelimitation];
			int writeFlag = writeFlags[iWrite];
			int includePrefixFlag = includePrefixesFlags[iIncludePrefix++];
			if (iIncludePrefix == includePrefixesFlags.length) {
				iIncludePrefix = 0;
				iWrite++;
				if (iWrite == writeFlags.length) {
					iWrite = 0;
					iDelimitation++;
					if (iDelimitation == delimitationFlags.length) {
						iExpension++;
						iDelimitation = 0;
						if (iExpension == expansionsFlags.length) {
							iMinSize++;
							iExpension = 0;
							if (iMinSize == minSizesFlags.length) {
								iRadix++;
								iMinSize = 0;
								if (iRadix == radixesFlags.length) {
									hasMore = false;
								}
							}
						}
					}
				}
			}
			int flags = radixFlag | minSizeFlag | expansionFlag | delimitationFlag | writeFlag | includePrefixFlag;
			flags = Digits.ints.unflag(flags, excludeFlags);
			return flags;
		}

		int totalCombinations() {
			return radixesFlags.length * minSizesFlags.length * expansionsFlags.length * delimitationFlags.length
					* writeFlags.length * includePrefixesFlags.length;

		}

		@SuppressWarnings("unused")
		static void writeAll(Writer w) {
			try {
				Set<Integer> set = new TreeSet<>();
				FlagsIterator it = new FlagsIterator();
				int a = 0;
				while (it.hasNext()) {
					a++;
					Integer flags = (Integer) it.next();
					set.add(flags);
					w.append(stringfyFlags(flags)).append('\n');
				}
//				w.append(a+", "+it.totalCombinations()+", "+set.size()+"\n");
				w.flush();
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		static String stringfyFlags(int flags) {
			StringJoiner sj = new StringJoiner(" | ");
			sj.add("RADIX_" + Digits.ints.considerTen(findRadix(flags)));
			stringfyFlagsPrefixer("MIN_SIZE", sj, getMinSizeFlags(), flags);
			stringfyFlagsPrefixer("EXPANSION", sj, getExpansionFlags(), flags);
			stringfyFlagsPrefixer("DELIMITATION", sj, getDelimitationFlags(), flags);
			if (Digits.ints.isFlagged(flags, WRITE_APPEND)) {
				sj.add("WRITE_APPEND");
			} else {
				sj.add("WRITE_OVERWRITE");
			}
			if (Digits.ints.isFlagged(flags, INCLUDE_PREFIX)) {
				sj.add("INCLUDE_PREFIX");
			}

			return sj.toString();
		}

		static String explainFlags(int flags, char delimiter) {
			StringJoiner sj = new StringJoiner(" | ");
			sj.add("RADIX_" + Digits.ints.considerTen(findRadix(flags)));
			explainFlagsPrefixer("MIN_SIZE", sj, getMinSizeFlags(), flags);
			explainFlagsPrefixer("EXPANSION", sj, getExpansionFlags(), flags);
			explainFlagsPrefixer("DELIMITATION", sj, getDelimitationFlags(), flags);
			sj.add(String.format("DELIMITER(%s)", delimiter == 0 ? "NOT-SET" : String.valueOf(delimiter)));
			if (Digits.ints.isFlagged(flags, WRITE_APPEND)) {
				sj.add("WRITE_APPEND");
			} else {
				sj.add("WRITE_OVERWRITE");
			}
			if (Digits.ints.isFlagged(flags, INCLUDE_PREFIX)) {
				sj.add("INCLUDE_PREFIX");
			}

			return sj.toString();
		}

		private static void stringfyFlagsPrefixer(String prefix, StringJoiner sj, int[] flagsArr, int flags) {
			for (int i = 0; i < flagsArr.length; i++) {
				if (flagsArr[i] > 0 && Digits.ints.isFlagged(flags, flagsArr[i])) {
					sj.add(prefix + "_" + Digits.ints.considerTen(2 << i));
					return;
				}
			}
		}

		private static void explainFlagsPrefixer(String prefix, StringJoiner sj, int[] flagsArr, int flags) {
			for (int i = 0; i < flagsArr.length; i++) {
				if (flagsArr[i] > 0 && Digits.ints.isFlagged(flags, flagsArr[i])) {
					sj.add(prefix + "_" + Digits.ints.considerTen(2 << i));
					return;
				}
			}
			sj.add(prefix + "(NOT-SET)");
		}

	}

	public static void main(String[] args) {
		FlagsIterator fit = new FlagsIterator();
		while (fit.hasNext()) {
			int flags = fit.next();
			if(isDelimitaionFlagged(flags)) {
				System.out.println(FlagsIterator.stringfyFlags(flags));
			}
			
		}
	}
	
	private static boolean isDelimitaionFlagged(int flags) {
		for (int f : CharsRadix.getDelimitationFlags()) {
			if (f != 0 && Digits.ints.isFlagged(flags, f)) {
				return true;
			}
		}
		return false;
	}
}
