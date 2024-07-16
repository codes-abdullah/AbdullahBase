package codes.abdullah.array.codepoints.support;

import codes.abdullah.project.lang.Lang;

class CodepointSupportBmpImpl implements CodepointSupport {

	@Override
	public int reindex(char[] arr, int len, int index) {
		return index;
	}

	@Override
	public int reindex(CharSequence cs, int index) {
		return index;
	}

	@Override
	public int[] reindex(char[] arr, int len, int[] indexes) {
		return indexes;
	}

	@Override
	public int[] reindex(CharSequence cs, int[] indexes) {
		return indexes;
	}

	@Override
	public boolean isValid(int cp) {
		return isBmp(cp);
	}

	@Override
	public boolean isSupported() {
		return false;
	}

	@Override
	public boolean isBmp(int cp) {
		return Character.isBmpCodePoint(cp);
	}

	@Override
	public boolean isBmp(char[] arr, int len, int index) {
		return isBmp(arr[index]);
	}

	@Override
	public boolean isBmp(CharSequence cs, int index) {
		return isBmp(cs.charAt(index));
	}

	@Override
	public boolean isBmp(int[] arr, int len, int index) {
		return isBmp(arr[index]);
	}

	@Override
	public boolean isPair(int ch) {
		return false;
	}

	@Override
	public boolean isPair(int high, int low) {
		return false;
	}

	@Override
	public boolean isPair(char[] arr, int len, int index) {
		if (index + 1 >= len)
			return false;
		return isPair(arr[index], arr[index + 1]);
	}

	@Override
	public boolean isPair(CharSequence cs, int index) {
		if (index + 1 >= cs.length())
			return false;
		return isPair(cs.charAt(index), cs.charAt(index + 1));
	}

	@Override
	public boolean isPair(int[] arr, int len, int index) {
		return isPair(arr[index]);
	}

	@Override
	public boolean isPairBackwardly(char[] arr, int len, int index) {
		if (index - 2 < 0)
			return false;
		return isPair(arr[index - 2], arr[index - 1]);
	}

	@Override
	public boolean isPairBackwardly(CharSequence cs, int index) {
		if (index - 2 < 0)
			return false;
		return isPair(cs.charAt(index - 2), cs.charAt(index - 1));
	}

	@Override
	public boolean isHighOrLow(int ch) {
		return false;
	}

	@Override
	public boolean isHighOrLow(char[] arr, int len, int index) {
		return isHighOrLow(arr[index]);
	}

	@Override
	public boolean isHighOrLow(CharSequence cs, int index) {
		return isHighOrLow(cs.charAt(index));
	}

	@Override
	public boolean isHigh(int ch) {
		return ch >= MIN_HIGH_SURROGATE && ch < (MAX_HIGH_SURROGATE + 1);
	}

	@Override
	public boolean isLow(int ch) {
		return ch >= MIN_LOW_SURROGATE && ch < (MAX_LOW_SURROGATE + 1);
	}

	@Override
	public boolean isHigh(char[] arr, int len, int index) {
		return isHigh(arr[index]);
	}

	@Override
	public boolean isLow(char[] arr, int len, int index) {
		return isLow(arr[index]);
	}

	@Override
	public boolean isHigh(CharSequence cs, int index) {
		return isHigh(cs.charAt(index));
	}

	@Override
	public boolean isLow(CharSequence cs, int index) {
		return isLow(cs.charAt(index));
	}

	@Override
	public boolean isPairIntersectly(char[] arr, int len, int index) {
		if (index - 1 < 0)
			return false;
		return isPair(arr[index - 1], arr[index]);
	}

	@Override
	public boolean isPairIntersectly(CharSequence cs, int index) {
		if (index - 1 < 0)
			return false;
		return isPair(cs.charAt(index - 1), cs.charAt(index));
	}

	@Override
	public int getCodepoint(char[] arr, int len, int index) {
		return arr[index];
	}

	@Override
	public int getCodepoint(CharSequence cs, int index) {
		return cs.charAt(index);
	}

	@Override
	public int getCodepointBackwardly(char[] arr, int len, int index) {
		return arr[index - 1];
	}

	@Override
	public int getCodepointBackwardly(CharSequence cs, int index) {
		return cs.charAt(index - 1);
	}

	@Override
	public char toHigh(int cp) {
		return (char) cp;
	}

	@Override
	public char toLow(int cp) {
		return (char) cp;
	}

	@Override
	public char toHigh(char[] arr, int len, int index) {
		return toHigh(arr[index]);
	}

	@Override
	public char toLow(char[] arr, int len, int index) {
		return toLow(arr[index]);
	}

	@Override
	public char toHigh(CharSequence cs, int index) {
		return toHigh(cs.charAt(index));
	}

	@Override
	public char toLow(CharSequence cs, int len, int index) {
		return toLow(cs.charAt(index));
	}

	@Override
	public int toCodepoint(char high, char low) {
		return -1;
	}

	@Override
	public int toCodepoint(int high, int low) {
		return toCodepoint((char) high, (char) low);
	}

	@Override
	public int toCodepoint(CharSequence cs) {
		return toCodepoint(cs.charAt(0), cs.charAt(1));
	}

	@Override
	public int toCodepoint(char[] arr, int len, int index) {
		return toCodepoint(arr[index], arr[index + 1]);
	}

	@Override
	public int toCodepoint(CharSequence cs, int index) {
		return toCodepoint(cs.charAt(index), cs.charAt(index + 1));
	}

	@Override
	public int toCodepointBackwardly(char[] arr, int len, int index) {
		return toCodepoint(arr[index - 2], arr[index - 1]);
	}

	@Override
	public int toCodepointBackwardly(CharSequence cs, int index) {
		return toCodepoint(cs.charAt(index - 2), cs.charAt(index - 1));
	}

	@Override
	public int toCodepointIntersectly(char[] arr, int len, int index) {
		return toCodepoint(arr[index - 1], arr[index]);
	}

	@Override
	public int toCodepointIntersectly(CharSequence cs, int index) {
		return toCodepoint(cs.charAt(index - 1), cs.charAt(index));
	}

	@Override
	public int[] toCodepointArray(CharSequence cs) {
		return toCodepointArray(cs, 0);
	}

	@Override
	public int[] toCodepointArray(CharSequence cs, int from) {
		return toCodepointArray(cs, from, cs.length());
	}

	@Override
	public int[] toCodepointArray(CharSequence cs, int from, int to) {
		int len = to - from;
		int[] arr = new int[len];
		for (int i = 0; from < to && i < len; i++, from++) {
			arr[i] = cs.charAt(from);
		}
		return arr;
	}

	@Override
	public int[] toCodepointArray(char[] arr, int len) {
		return toCodepointArray(arr, len, 0);
	}

	@Override
	public int[] toCodepointArray(char[] arr, int len, int from) {
		return toCodepointArray(arr, len, from, len);
	}

	@Override
	public int[] toCodepointArray(char[] arr, int len, int from, int to) {
		int len2 = to - from;
		int[] arr2 = new int[len2];
		for (int i = 0; from < to && i < len2; from++, i++) {
			arr2[i] = (int) arr[from];
		}
		return arr2;
	}

	@Override
	public char[] toCharArray(int cp) {
		return new char[] { (char) cp };
	}

	@Override
	public char[] toCharArray(int[] arr, int len) {
		return toCharArray(arr, len, 0);
	}

	@Override
	public char[] toCharArray(int[] arr, int len, int from) {
		return toCharArray(arr, len, from, len);
	}

	@Override
	public char[] toCharArray(int[] arr, int len, int from, int to) {
		return toCharArray(arr, len, from, to, null);
	}

	@Override
	public char[] toCharArray(int[] arr, int len, int from, int to, char[] out) {
		return toCharArray(arr, len, from, len, out, out == null ? 0 : out.length);
	}

	@Override
	public char[] toCharArray(int[] arr, int len, int from, int to, char[] out, int outlen) {
		return Lang.primitive.to.chars(arr, len, from, to, out, outlen);
	}

	@Override
	public int toCharArray(int cp, char[] buf, int buflen, int insertAt) {
		buf[insertAt] = (char) cp;
		return 1;
	}

	@Override
	public int countCodepoints(char[] arr, int len) {
		return countCodepoints(arr, len, 0);
	}

	@Override
	public int countCodepoints(char[] arr, int len, int from) {
		return countCodepoints(arr, len, from, len);
	}

	@Override
	public int countCodepoints(char[] arr, int len, int from, int to) {
		return to - from;
	}

	@Override
	public int countCodepoints(CharSequence cs) {
		return countCodepoints(cs, 0);
	}

	@Override
	public int countCodepoints(CharSequence cs, int from) {
		return countCodepoints(cs, from, cs.length());
	}

	@Override
	public int countCodepoints(CharSequence cs, int from, int to) {
		return to - from;
	}

	@Override
	public int extendablePairsCount(char[] arr, int len) {
		return extendablePairsCount(arr, len, 0);
	}

	@Override
	public int extendablePairsCount(char[] arr, int len, int from) {
		return extendablePairsCount(arr, len, from, len);
	}

	@Override
	public int extendablePairsCount(char[] arr, int len, int from, int to) {
		return 0;
	}

	@Override
	public int extendablePairsCount(CharSequence cs) {
		return extendablePairsCount(cs, 0);
	}

	@Override
	public int extendablePairsCount(CharSequence cs, int from) {
		return extendablePairsCount(cs, 0, cs.length());
	}

	@Override
	public int extendablePairsCount(CharSequence cs, int from, int to) {
		return 0;
	}

	@Override
	public int fixedPairsCount(char[] arr, int len) {
		return fixedPairsCount(arr, len, 0);
	}

	@Override
	public int fixedPairsCount(char[] arr, int len, int from) {
		return fixedPairsCount(arr, len, from, len);
	}

	@Override
	public int fixedPairsCount(char[] arr, int len, int from, int to) {
		return 0;
	}

	@Override
	public int fixedPairsCount(CharSequence cs) {
		return fixedPairsCount(cs, 0);
	}

	@Override
	public int fixedPairsCount(CharSequence cs, int from) {
		return fixedPairsCount(cs, 0, cs.length());
	}

	@Override
	public int fixedPairsCount(CharSequence cs, int from, int to) {
		return 0;
	}

	@Override
	public int columnsOf(int ch) {
		return columnsOf(ch, Lang.constant.DEFAULT_TAB_SIZE);
	}

	@Override
	public int columnsOf(int ch, int tabSize) {
		if (ch == Lang.constant.DEFAULT_TAB_CHAR)
			return tabSize;
		return lengthOf(ch);
	}


	@Override
	public int lengthOf(int ch) {
		return isBmp(ch) ? 1 : 0;
	}

	@Override
	public int lengthOf(char[] arr, int len, int index) {
		if (isPair(arr, len, index))
			return lengthOf(toCodepoint(arr, len, index));
		return lengthOf(arr[index]);
	}

	@Override
	public int lengthOf(CharSequence cs, int index) {
		if (isPair(cs, index))
			return lengthOf(toCodepoint(cs, index));
		return lengthOf(cs.charAt(index));
	}

	@Override
	public int lengthOf(int[] arr, int len, int index) {
		return lengthOf(arr[index]);
	}

	@Override
	public int lengthOfBackwardly(char[] arr, int len, int index) {
		if (isPairBackwardly(arr, len, index))
			return lengthOf(toCodepointBackwardly(arr, len, index));
		return lengthOf(arr[index - 1]);
	}

	@Override
	public int lengthOfBackwardly(CharSequence cs, int index) {
		if (isPairBackwardly(cs, index))
			return lengthOf(toCodepointBackwardly(cs, index));
		return lengthOf(cs.charAt(index - 1));
	}

	@Override
	public int lengthOfIntersectly(char[] arr, int len, int index) {
		if (isPairIntersectly(arr, len, index))
			return lengthOf(toCodepointIntersectly(arr, len, index));
		return lengthOf(arr[index]);
	}

	@Override
	public int lengthOfIntersectly(CharSequence cs, int index) {
		if (isPairIntersectly(cs, index))
			return lengthOf(toCodepointIntersectly(cs, index));
		return lengthOf(cs.charAt(index));
	}

	@Override
	public int indexOfBroken(char[] arr, int len) {
		return indexOfBroken(arr, len, 0);
	}

	@Override
	public int indexOfBroken(char[] arr, int len, int from) {
		return indexOfBroken(arr, len, from, len);
	}

	@Override
	public int indexOfBroken(char[] arr, int len, int from, int to) {
		return -1;
	}

	@Override
	public int indexOfBroken(CharSequence cs) {
		return indexOfBroken(cs, 0);
	}

	@Override
	public int indexOfBroken(CharSequence cs, int from) {
		return indexOfBroken(cs, from, cs.length());
	}

	@Override
	public int indexOfBroken(CharSequence cs, int from, int to) {
		return -1;
	}

	// ------------------

	@Override
	public boolean equals(int cp1, int cp2) {
		return equals(cp1, cp2, false);
	}

	@Override
	public boolean equals(int cp1, int cp2, boolean ignoreCase) {
		// e.g: a == A ??
		if (!ignoreCase)
			return cp1 == cp2;

		// all below if ignore-case = true
		if (cp1 == cp2)
			return true;

		if (toLowerCase(cp1) == toLowerCase(cp2))
			return true;

		if (toUpperCase(cp1) == toUpperCase(cp2))
			return true;

		return false;
	}

	// ------------------

	@Override
	public boolean equals(char high, char low, char otherHigh, char otherLow) {
		return equals(high, low, otherHigh, otherLow, false);
	}

	@Override
	public boolean equals(char high, char low, char otherHigh, char otherLow, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equals(char[] arr, int len, int index, char otherHigh, char otherLow) {
		return equals(arr, len, index, otherHigh, otherLow, false);
	}

	@Override
	public boolean equals(char[] arr, int len, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(char[] arr, int len, int index, char otherHigh, char otherLow) {
		return equalsIntersectly(arr, len, index, otherHigh, otherLow, false);
	}

	@Override
	public boolean equalsIntersectly(char[] arr, int len, int index, char otherHigh, char otherLow,
			boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(char[] arr, int len, int index, char otherHigh, char otherLow) {
		return equalsBackwardly(arr, len, index, otherHigh, otherLow, false);
	}

	@Override
	public boolean equalsBackwardly(char[] arr, int len, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equals(CharSequence cs, int index, char otherHigh, char otherLow) {
		return equals(cs, index, otherHigh, otherHigh, false);
	}

	@Override
	public boolean equals(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(CharSequence cs, int index, char otherHigh, char otherLow) {
		return equalsIntersectly(cs, index, otherHigh, otherHigh, false);
	}

	@Override
	public boolean equalsIntersectly(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(CharSequence cs, int index, char otherHigh, char otherLow) {
		return equalsBackwardly(cs, index, otherHigh, otherHigh, false);
	}

	@Override
	public boolean equalsBackwardly(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equals(char[] arr, int len, int index, int cp) {
		return equals(arr, len, index, cp, false);
	}

	@Override
	public boolean equals(char[] arr, int len, int index, int cp, boolean ignoreCase) {
		return equals(arr[index], cp, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(char[] arr, int len, int index, int cp) {
		return equalsIntersectly(arr, len, index, cp, false);
	}

	@Override
	public boolean equalsIntersectly(char[] arr, int len, int index, int cp, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(char[] arr, int len, int index, int cp) {
		return equalsBackwardly(arr, len, index, cp, false);
	}

	@Override
	public boolean equalsBackwardly(char[] arr, int len, int index, int cp, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equals(CharSequence cs, int index, int cp) {
		return equals(cs, index, cp, false);
	}

	@Override
	public boolean equals(CharSequence cs, int index, int cp, boolean ignoreCase) {
		return equals(cs.charAt(index), cp, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(CharSequence cs, int index, int cp) {
		return equalsIntersectly(cs, index, cp, false);
	}

	@Override
	public boolean equalsIntersectly(CharSequence cs, int index, int cp, boolean ignoreCase) {
		return false;
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(CharSequence cs, int index, int cp) {
		return equalsBackwardly(cs, index, cp, false);
	}

	@Override
	public boolean equalsBackwardly(CharSequence cs, int index, int cp, boolean ignoreCase) {
		return false;
	}
	// ------------------

	@Override
	public String toString(int cp) {
		return new String(toCharArray(cp));
	}

	@Override
	public boolean isLowerCase(int cp) {
		return Character.isLowerCase(cp);
	}

	@Override
	public boolean isUpperCase(int cp) {
		return Character.isUpperCase(cp);
	}

	@Override
	public boolean isLowerCase(char ch) {
		return Character.isLowerCase(ch);
	}

	@Override
	public boolean isUpperCase(char ch) {
		return Character.isUpperCase(ch);
	}

	@Override
	public int toLowerCase(int cp) {
		return Character.toLowerCase(cp);
	}

	@Override
	public int toUpperCase(int cp) {
		return Character.toUpperCase(cp);
	}

	@Override
	public char toLowerCase(char ch) {
		return (char) toLowerCase((int) ch);
	}

	@Override
	public char toUpperCase(char ch) {
		return (char) toUpperCase((int) ch);
	}

	// ===================================

	@Override
	public boolean isLinefeed(int cp) {
		return cp == '\n' || cp == '\r';
	}

	@Override
	public boolean isWhitespace(int cp) {
		return Character.isWhitespace(cp);
	}

	@Override
	public boolean isSuperscriptDigit(int cp) {
		return (cp >= 0x00b2 && cp <= 0x00b3) || (cp >= 0x2074 && cp <= 0x2079) || cp == 0x2070 || cp == 0x00B9;
	}

	@Override
	public boolean isSuperscript(int cp) {
		return (cp >= 0x207A && cp <= 0x207F) || cp == 0x2071 || isSuperscriptDigit(cp);
	}

	@Override
	public int superscriptToAscii(int cp) {
		switch (cp) {
		case '⁰':
			return '0';
		case '¹':
			return '1';
		case '²':
			return '2';
		case '³':
			return '3';
		case '⁴':
			return '4';
		case '⁵':
			return '5';
		case '⁶':
			return '6';
		case '⁷':
			return '7';
		case '⁸':
			return '8';
		case '⁹':
			return '9';
		case '⁺':
			return '+';
		case '⁻':
			return '-';
		case '⁼':
			return '=';
		case '⁽':
			return '(';
		case '⁾':
			return ')';
		case 'ⁿ':
			return 'n';
		case 'ⁱ':
			return 'i';
		}
		return cp;
	}

}
