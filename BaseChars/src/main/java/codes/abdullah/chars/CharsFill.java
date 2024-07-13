package codes.abdullah.chars;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public abstract class CharsFill {

	abstract Chars unsafe();

	abstract CharsFill assign(Chars c);

	// ===============
	// =============== fill
	// ===============

	/**
	 * @see #fill(int, int, int)
	 */
	public CharsFill fill(int cp, int fillLength) {
		return fill(cp, fillLength, unsafe().length());
	}

	/**
	 * fill this sequence by given code-point based on given fill-length and insert
	 * index
	 */
	public CharsFill fill(int cp, int fillLength, int insertAt) {
		Chars unsafe = unsafe();
		final int len = unsafe.length();
		final int innerlen = unsafe.lengthActual();
		CodepointSupport sps = unsafe().getSurrogatePairsSupport();
		int spc = sps.isSupported() ? unsafe.spc() : 0;
		char[] arr = unsafe.safe();
		Check.insertIndex(insertAt, len);
		int additionLength = sps.isBmp(cp) ? fillLength : fillLength * 2;
		Check.length(additionLength, 1, Lang.constant.ARRAY_SAFE_CAPACITY - innerlen);
		insertAt = sps.reindex(arr, innerlen, insertAt);
		arr = Lang.capacity.ensure(arr, innerlen, innerlen + additionLength);
		arr = Lang.expand.at(arr, innerlen, insertAt, additionLength);
		if (sps.isBmp(cp)) {
			char ch = (char) cp;
			for (int i = 0; i < additionLength; i++) {
				arr[insertAt++] = ch;
			}
			return assign(unsafe.assign(arr, innerlen + additionLength, spc, sps, unsafe.getFlags()));
		} else if (sps.isPair(cp)) {
			char hch = sps.toHigh(cp);
			char lch = sps.toLow(cp);
			for (int i = 0; i < fillLength; i++) {
				arr[insertAt++] = hch;
				arr[insertAt++] = lch;
			}

			spc += sps.isSupported() ? fillLength : 0;
			return assign(unsafe.assign(arr, innerlen + additionLength, spc, sps, unsafe.getFlags()));
		}
		Check.codePoint(cp, sps);
		return null;// must never reach here
	}

	/**
	 * @see #fillByRange(int, int, int, int, boolean)
	 */
	public CharsFill fillByRange(int fromCodePoint, int toCodePoint) {
		return fillByRange(fromCodePoint, toCodePoint, -1);
	}

	/**
	 * @see #fillByRange(int, int, int, int, boolean)
	 */
	public CharsFill fillByRange(int fromCodePoint, int toCodePoint, int fillLength) {
		return fillByRange(fromCodePoint, toCodePoint, fillLength, unsafe().length());
	}

	/**
	 * @see #fillByRange(int, int, int, int, boolean)
	 */
	public CharsFill fillByRange(int fromCodePoint, int toCodePoint, int fillLength, int insertAt) {
		return fillByRange(fromCodePoint, toCodePoint, fillLength, insertAt, false);
	}

	/**
	 * fill at the given offset based on given code-points range with a separator
	 * between each two filled code-points
	 * 
	 * @param separatorCodePoint 0 (null) to skip it <br>
	 *                           <b>default</b> fillLength = -1, means just fill as
	 *                           range, e.g: from '0' to ':' means fill from 0 to 9
	 *                           <br>
	 *                           <b>default</b> randomize = false <br>
	 *                           <b>default</b> insertAt = {@link #length()}
	 */
	public CharsFill fillByRange(int fromCodePoint, int toCodePoint, int fillLength, int insertAt, boolean randomize) {
		if (randomize) {
			// ------------------
			// randomize both bmp and supplementary is possible, but for a unknown length,
			// it's long and heavy ops to reallocate and recopy in each loop
			// ------------------
			if (toCodePoint >= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
				if (fromCodePoint <= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
					throw new IllegalArgumentException(
							"can't randomize fill between bmp and supplementary, do it in two different ops");
				}
			}
		}
		Chars unsafe = unsafe();
		fillLength = fillLength == -1 ? toCodePoint - fromCodePoint : fillLength;
		int len = unsafe.length();
		int innerlen = unsafe.lengthActual();
		Check.length(fillLength, 1, Lang.constant.ARRAY_SAFE_CAPACITY - innerlen);
		insertAt = insertAt > len ? len : insertAt;
		Check.insertIndex(insertAt, len);
		Check.range(fromCodePoint, toCodePoint, Character.MAX_CODE_POINT);
		char[] arr = unsafe.safe();
		int spc = unsafe.spc();
		CodepointSupport sps = unsafe().getSurrogatePairsSupport();
		insertAt = sps.reindex(arr, innerlen, insertAt);
		int addition = (sps.isBmp(fromCodePoint) ? 1 : 2) * fillLength;
		if (fromCodePoint >= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
			spc += addition;
			addition *= 2;
		} else if (toCodePoint >= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
			int spc_addition = (toCodePoint - Character.MIN_SUPPLEMENTARY_CODE_POINT);
			spc += spc_addition;
			addition += spc_addition;
		}

		int newinnerlen = addition + innerlen;
		arr = Lang.capacity.ensure(arr, innerlen, newinnerlen);
		arr = Lang.expand.at(arr, innerlen, insertAt, addition);
		int target = 0;
		final int srcFromCodePoint = fromCodePoint;
		for (int i = 0; i < fillLength; i++) {
			target = randomize ? Digits.ints.random(fromCodePoint, toCodePoint) : fromCodePoint;
			insertAt += sps.toCharArray(target, arr, innerlen, insertAt);
			fromCodePoint = ++fromCodePoint == toCodePoint ? srcFromCodePoint : fromCodePoint;
		}
		return assign(unsafe.assign(arr, newinnerlen, spc, sps, unsafe.getFlags()));
	}

	// ===============
	// =============== fill english
	// ===============

	/**
	 * @see #fillEnglish(int, int, int, int, boolean, boolean)
	 */
	public CharsFill fillEnglish(int fromCodePoint, int toCodePoint) {
		return fillEnglish(fromCodePoint, toCodePoint, -1);
	}

	/**
	 * @see #fillEnglish(int, int, int, int, boolean, boolean)
	 */
	public CharsFill fillEnglish(int fromCodePoint, int toCodePoint, int fillLength) {
		return fillEnglish(fromCodePoint, toCodePoint, fillLength, unsafe().length());
	}

	/**
	 * @see #fillEnglish(int, int, int, int, boolean, boolean)
	 */
	public CharsFill fillEnglish(int fromCodePoint, int toCodePoint, int fillLength, int insertAt) {
		return fillEnglish(fromCodePoint, toCodePoint, fillLength, insertAt, false);
	}

	/**
	 * @see #fillEnglish(int, int, int, int, boolean, boolean)
	 */
	public CharsFill fillEnglish(int fromCodePoint, int toCodePoint, int fillLength, int insertAt, boolean randomize) {
		return fillEnglish(fromCodePoint, toCodePoint, fillLength, insertAt, randomize, unsafe().iagc());
	}

	/**
	 * fill English letters, based on given range
	 * 
	 * <br>
	 * <b>default</b> fromCodePoint = 0 <br>
	 * <b>default</b> toCodePoint = 26 <br>
	 * <b>default</b> lowerCase = {@link #isIgnoreCase()}
	 * 
	 * @see #fillByRange(int, int, int, int, boolean)
	 * @throws IllegalArgumentException if range < inclusive(0) || > exclusive(26)
	 */
	public CharsFill fillEnglish(int fromCodePoint, int toCodePoint, int fillLength, int insertAt, boolean randomize,
			boolean lowerCase) {
		Check.range(fromCodePoint, toCodePoint, 26);
		int off = lowerCase ? 97 : 65;
		return fillByRange(off + fromCodePoint, off + toCodePoint, fillLength, insertAt, randomize);
	}

	// ===============
	// =============== fill digits
	// ===============

	/**
	 * @see #fillDigits(int, int, int, boolean, boolean)
	 */
	public CharsFill fillDigits() {
		return fillDigits(9);
	}

	/**
	 * @see #fillDigits(int, int, int, boolean, boolean)
	 */
	public CharsFill fillDigits(int maxLength) {
		return fillDigits(maxLength, 10);
	}

	/**
	 * @see #fillDigits(int, int, int, boolean, boolean)
	 */
	public CharsFill fillDigits(int maxLength, int radix) {
		return fillDigits(maxLength, radix, unsafe().length());
	}

	/**
	 * @see #fillDigits(int, int, int, boolean, boolean)
	 */
	public CharsFill fillDigits(int maxLength, int radix, int insertAt) {
		return fillDigits(maxLength, radix, insertAt, false);
	}

	/**
	 * @see #fillDigits(int, int, int, boolean, boolean)
	 */
	public CharsFill fillDigits(int maxLength, int radix, int insertAt, boolean includeDecimalPoint) {
		return fillDigits(maxLength, radix, insertAt, includeDecimalPoint, false);
	}

	/**
	 * fill random digits based on given radix
	 * 
	 * @param maxLength           the max length of resulted digits
	 * @param includeDecimalPoint true to include decimal-point randomly
	 * @param randomizeLength     if true, will do random(1, maxLength) <br>
	 *                            <b>default</b> maxLength = 9 <br>
	 *                            <b>default</b> radix = 10 <br>
	 *                            <b>default</b> includeDecimalPoint = false <br>
	 *                            <b>default</b> randomizeLength = false
	 */
	public CharsFill fillDigits(int maxLength, int radix, int insertAt, boolean includeDecimalPoint,
			boolean randomizeLength) {
		Chars c = unsafe();
		int len = c.length();
		Check.insertIndex(insertAt, len);
		Check.length(maxLength, 1, Lang.constant.ARRAY_SAFE_CAPACITY - c.lengthActual());
		maxLength = randomizeLength ? Digits.ints.random(1, maxLength) : maxLength;
		Chars c2 = Chars.of();
		for (int i = 0; i < maxLength; i++) {
			c2 = c2.append(Character.forDigit(Digits.ints.random(0, radix), radix));
		}
		if (includeDecimalPoint && maxLength > 1) {
			c2 = c2.insert(Digits.ints.random(1, maxLength), '.');
		}

		// in case of leading zeros
		if (radix != 2 && c2.firstChar() == '0' && c2.length() > 1 && c2.charAt(1) != '.') {
			int start = 0;
			while (c2.charAt(start + 1) == '0') {
				start++;
			}
			c2 = c2.deleteRange(0, start + 1);
		}
		return assign(c.insert(insertAt, c2.unsafe(), c2.lengthActual()));
	}

	// ===============
	// =============== fill random
	// ===============

	/**
	 * @see #fillRandom(int, int, int, int)
	 */
	public CharsFill fillRandom() {
		return fillRandom(Digits.ints.random(32, 65));
	}

	/**
	 * @see #fillRandom(int, int, int, int)
	 */
	public CharsFill fillRandom(int fromCodePoint) {
		return fillRandom(fromCodePoint, Digits.ints.random(fromCodePoint + 1, (fromCodePoint + 1) * 2));
	}

	/**
	 * @see #fillRandom(int, int, int, int)
	 */
	public CharsFill fillRandom(int fromCodePoint, int toCodePoint) {
		return fillRandom(fromCodePoint, toCodePoint, Digits.ints.random(5, 20));
	}

	/**
	 * @see #fillRandom(int, int, int, int)
	 */
	public CharsFill fillRandom(int fromCodePoint, int toCodePoint, int fillLength) {
		return fillRandom(fromCodePoint, toCodePoint, fillLength, unsafe().length());
	}

	/**
	 * this method will invoke {@link #fillByRange(int, int, int, int, boolean)}
	 * with <b>randomize = true</b>
	 * 
	 * <br>
	 * <b>default</b> fromCodePoint = random(32, 65) <br>
	 * <b>default</b> toCodePoint = double of fromCodePoint <br>
	 * <b>default</b> fillLength = random(5, 20)
	 * 
	 * @see #fillByRange(int, int, int, int, boolean)
	 */
	public CharsFill fillRandom(int fromCodePoint, int toCodePoint, int fillLength, int insertAt) {
		return fillByRange(fromCodePoint, toCodePoint, fillLength, insertAt, true);
	}

	// ===============
	// =============== fill binary
	// ===============

	/**
	 * @see #fillBinary(int, int, int, boolean, boolean)
	 */
	public CharsFill fillBinary() {
		// 8, 16, 32, 64, 128
		return fillBinary(8 << Digits.ints.random(0, 5));
	}

	/**
	 * @see #fillBinary(int, int, int, boolean, boolean)
	 */
	public CharsFill fillBinary(int wordSize) {
		return fillBinary(wordSize, 1);
	}

	/**
	 * @see #fillBinary(int, int, int, boolean, boolean)
	 */
	public CharsFill fillBinary(int wordSize, int wordsCount) {
		return fillBinary(wordSize, wordsCount, unsafe().length());
	}

	/**
	 * @see #fillBinary(int, int, int, boolean, boolean)
	 */
	public CharsFill fillBinary(int wordSize, int wordsCount, int insertAt) {
		return fillBinary(wordSize, wordsCount, insertAt, false);
	}

	/**
	 * @see #fillBinary(int, int, int, boolean, boolean)
	 */
	public CharsFill fillBinary(int wordSize, int wordsCount, int insertAt, boolean readable) {
		return fillBinary(wordSize, wordsCount, insertAt, readable, false);
	}

	/**
	 * fill random binary string
	 * 
	 * @param wordSize   the size of target word to be generated, sizes must be 8,
	 *                   16, 32, 64 ... etc
	 * @param wordsCount how many words to generate
	 * @param readable   if true, each 8 bits will be separated by underscore char
	 * @param stack      if true, words will be separated by linefeed (\n) to be
	 *                   above eachother
	 * @see #fillDigits(int, int, int, boolean, boolean)
	 * @default wordSize: 8 << random(0, 5), e.g: 8, 16, 32, 64, 128
	 * @default wordsCount: 1
	 * @default stack: false
	 * @default readable: false
	 */
	public CharsFill fillBinary(int wordSize, int wordsCount, int insertAt, boolean readable, boolean stack) {
		if (wordSize < 8 || wordSize % 8 != 0) {
			throw new IllegalArgumentException(String
					.format("wordSize(%d) < 8 || wordSize %% 8 != 0, wordSize must be: 8, 16, 24, 32 ..etc", wordSize));
		}
		if (wordsCount == 0) {
			return this;
		}
		Chars c = unsafe();
		Check.insertIndex(insertAt, c.length());
		CharsFill c2 = of();
		c2 = c2.fillDigits(wordSize * wordsCount, 2);
		Chars c3 = c2.unsafe();
		if (readable) {
			c3 = c3.repeatAfterEach('_', 8, 1, true);
		}

		// find how many dividers in each word, e.g: wordSize = 32, dividers = 3
		int divs_count = readable ? (wordSize / 8) - 1 : 0;
		if (stack) {
			// jump over dividers only
			for (int i = wordSize + divs_count; i < c3.length(); i += wordSize + divs_count + 1) {
				// if no dividers exists, insert linefeed
				c3 = readable ? c3.setCodePointAt(i, '\n') : c3.insert(i, '\n');
			}
		}
		return c2.assign(c3.insert(insertAt, c3.unsafe(), c3.lengthActual()));
	}

	// ===================

	public static CharsFill of() {
		return of("");
	}

	public static CharsFill of(CharSequence cs) {
		return new MutableCharsFill(Chars.of(cs));
	}

	static class MutableCharsFill extends CharsFill {
		private Chars c;

		MutableCharsFill(Chars c) {
			this.c = c.toMutable();
		}

		@Override
		Chars unsafe() {
			return c;
		}

		@Override
		CharsFill assign(Chars c) {
			this.c = c;
			return this;
		}
	}

	static class ImmutableCharsFill extends CharsFill {
		private final Chars c;

		ImmutableCharsFill(Chars c) {
			this.c = c.toImmutable();
		}

		@Override
		Chars unsafe() {
			return c;
		}

		@Override
		CharsFill assign(Chars c) {
			return new ImmutableCharsFill(c);
		}
	}

}
