package codes.abdullah.array.codepoints.support;

import codes.abdullah.project.lang.Lang;

class XCodepointSupportSupplementaryImpl extends XCodepointSupportBmpImpl {

	@Override
	public int reindex(char[] arr, int len, int index) {
		return index + extendablePairsCount(arr, len, 0, index);
	}

	@Override
	public int[] reindex(char[] arr, int len, int[] indexes) {
		int spcount = 0, previousIndex = 0;
		for (int i = 0; i < indexes.length; i++) {
			int index = indexes[i];
			int from = previousIndex;
			int to = index + spcount;
			spcount += extendablePairsCount(arr, len, from, to);
			indexes[i] += spcount;
			previousIndex = indexes[i];
		}
		return indexes;
	}

	@Override
	public int reindex(CharSequence cs, int index) {
		return index + extendablePairsCount(cs, 0, index);
	}

	@Override
	public int[] reindex(CharSequence cs, int[] indexes) {
		int spcount = 0, previousIndex = 0;
		for (int i = 0; i < indexes.length; i++) {
			spcount += extendablePairsCount(cs, previousIndex, indexes[i] + spcount);
			indexes[i] += spcount;
			previousIndex = indexes[i];
		}
		return indexes;
	}

	@Override
	public boolean isValid(int cp) {
		return Character.isValidCodePoint(cp);
	}

	@Override
	public boolean isSupported() {
		return true;
	}

	@Override
	public boolean isPair(int ch) {
		return ch >= Character.MIN_SUPPLEMENTARY_CODE_POINT && ch <= Character.MAX_CODE_POINT;
	}

	@Override
	public boolean isPair(int high, int low) {
		return isHigh(high) && isLow(low);
	}

	@Override
	public boolean isPairIntersectly(CharSequence cs, int index) {
		if (index + 1 >= cs.length())
			return false;
		return isPair(cs.charAt(index - 1), cs.charAt(index));
	}

	@Override
	public int getCodepoint(char[] arr, int len, int index) {
		final int hi = index;
		if (isHigh(arr[hi]) && ++index < arr.length) {
			final int li = index;
			if (isLow(arr[li])) {
				return toCodepoint(arr[hi], arr[li]);
			}
		}
		return arr[hi];
	}

	@Override
	public int getCodepoint(CharSequence cs, int index) {
		final int hi = index;
		if (isHigh(cs.charAt(hi)) && ++index < cs.length()) {
			final int li = index;
			if (isLow(cs.charAt(li))) {
				return toCodepoint(cs.charAt(hi), cs.charAt(li));
			}
		}
		return cs.charAt(hi);
	}

	@Override
	public int getCodepointBackwardly(char[] arr, int len, int index) {
		final int li = index - 1;
		if (isLow(arr[li]) && index - 2 > 0) {
			final int hi = index - 2;
			if (isHigh(arr[hi])) {
				return toCodepoint(arr[hi], arr[li]);
			}
		}
		return arr[li];
	}

	@Override
	public int getCodepointBackwardly(CharSequence cs, int index) {
		final int li = index - 1;
		if (isLow(cs.charAt(li)) && index - 2 > 0) {
			final int hi = index - 2;
			if (isHigh(cs.charAt(hi))) {
				return toCodepoint(cs.charAt(hi), cs.charAt(li));
			}
		}
		return cs.charAt(li);
	}

	@Override
	public char toHigh(int cp) {
		return Character.highSurrogate(cp);
	}

	@Override
	public char toLow(int cp) {
		return Character.lowSurrogate(cp);
	}

	@Override
	public int toCodepoint(char high, char low) {
		return Character.toCodePoint(high, low);
	}

	@Override
	public int[] toCodepointArray(CharSequence cs, int from, int to) {
		int len = to - from;
		int[] arr = new int[len];
		int cp = 0, i = 0;
		for (; from < to; from++, i++) {
			cp = getCodepoint(cs, from);
			arr[i] = cp;
			if (isPair(cp)) {
				from++;
			}
		}
		return Lang.trim.in(arr, i);
	}

	@Override
	public int countCodepoints(char[] arr, int len, int from, int to) {
		int range = to - from;
		int endIndex = from + range;
		for (; from < endIndex;) {
			if (isPair(arr, len, from++) && from < endIndex) {
				range--;
				from++;
			}
		}
		return range;
	}

	@Override
	public int countCodepoints(CharSequence cs, int from, int to) {
		int range = to - from;
		int endIndex = from + range;
		for (; from < endIndex;) {
			if (isPair(cs, from++) && from < endIndex) {
				range--;
				from++;
			}
		}
		return range;
	}

	@Override
	public int lengthOf(int ch) {
		if (!Character.isValidCodePoint(ch))
			return 0;
		return isPair(ch) ? 2 : 1;
	}

	@Override
	public int indexOfBroken(char[] arr, int len, int from, int to) {
		for (; from < to; from++) {
			if (isHigh(arr[from]) || isLow(arr[from])) {
				if (!isPair(arr, len, from))
					return from;
				from++;
			}
		}
		return -1;
	}

	@Override
	public int indexOfBroken(CharSequence cs, int from, int to) {
		for (; from < to; from++) {
			if (isHigh(cs.charAt(from)) || isLow(cs.charAt(from))) {
				if (!isPair(cs, from))
					return from;
				from++;
			}
		}
		return -1;
	}

	@Override
	public int[] toCodepointArray(char[] arr, int len, int from, int to) {
		int olen = to - from;
		int[] oarr = new int[olen];
		int cp = 0, i = 0;
		for (; from < to; from++, i++) {
			cp = getCodepoint(arr, len, from);

			oarr[i] = cp;
			if (isPair(cp)) {
				from++;
			}
		}

		// e.g: abD1xK9, from=3 to=6, abD[1xK]9
		// codePointAt will detect surrogate-pair on 5th index
		// so the result will be: 1xK9, to avoid this, below will exclude the low
		// surrogate
		if (from > to && isPair(cp)) {
			// assume pointer: [
			// on above increment will be: 1xK9[, below will go: 1xK[9
			from--;
			// and below will go: 1x[K9
			oarr[i - 1] = arr[from - 1];
		}

		return Lang.trim.in(oarr, i);
	}

	@Override
	public char[] toCharArray(int[] arr, int len, int from, int to, char[] out, int outlen) {
		int _outlen = 0;
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; from++, i++) {
			int cp = arr[from];
			out = Lang.capacity.ensure(out, _outlen, _outlen + 2);
			if (isPair(cp)) {
				out[i] = toHigh(cp);
				out[++i] = toLow(cp);
				_outlen += 2;
				continue;
			}
			out[i] = (char) cp;
			_outlen++;
		}
		return Lang.trim.in(out, _outlen);
	}

	@Override
	public char[] toCharArray(int cp) {
		if (isPair(cp)) {
			return new char[] { toHigh(cp), toLow(cp) };
		}
		return super.toCharArray(cp);
	}

	@Override
	public int toCharArray(int cp, char[] buf, int buflen, int insertAt) {
		if (isPair(cp)) {
			buf[insertAt] = toHigh(cp);
			buf[insertAt + 1] = toLow(cp);
			return 2;
		}
		return super.toCharArray(cp, buf, buflen, insertAt);
	}

	@Override
	public int extendablePairsCount(char[] arr, int len, int from, int to) {
		int c = 0;
		// --------------------
		// we need from < len due to avoid extension violation
		// --------------------
		for (; from < len && from < to; from++) {
			if (isPair(arr, len, from)) {
				from++;
				c++;
				// --------------------
				// extend
				// --------------------
				to++;
			}
		}
		return c;
	}

	@Override
	public int extendablePairsCount(CharSequence cs, int from, int to) {
		int c = 0;
		int len = cs.length();
		// --------------------
		// we need from < len due to avoid extension violation
		// --------------------
		for (; from < len && from < to; from++) {
			if (isPair(cs, from)) {
				from++;
				c++;
				// --------------------
				// extend
				// --------------------
				to++;
			}
		}
		return c;
	}

	@Override
	public int fixedPairsCount(char[] arr, int len, int from, int to) {
		int c = 0;
		for (; from < to; from++) {
			if (from + 1 < to && isPair(arr, len, from)) {
				from++;
				c++;
			}
		}
		return c;
	}

	@Override
	public int fixedPairsCount(CharSequence cs, int from, int to) {
		int c = 0;
		for (; from < to; from++) {
			if (from + 1 < to && isPair(cs, from)) {
				from++;
				c++;
			}
		}
		return c;
	}

	// ------------------

	@Override
	public boolean equals(char high, char low, char otherHigh, char otherLow, boolean ignoreCase) {
		if (!ignoreCase) {
			return high == otherHigh && low == otherLow;
		}

		// all below if ignore-case = true
		if (high == otherHigh && low == otherLow) {
			return true;
		}

		if (toLowerCase(high) == toLowerCase(otherHigh) && toLowerCase(low) == toLowerCase(otherLow)) {
			return true;
		}

		if (toUpperCase(high) == toUpperCase(otherHigh) && toUpperCase(low) == toUpperCase(otherLow)) {
			return true;
		}

		return false;
	}

	// ------------------

	@Override
	public boolean equals(char[] arr, int len, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		if (index + 1 >= len)
			return false;
		return equals(arr[index], arr[index + 1], otherHigh, otherLow, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(char[] arr, int len, int index, char otherHigh, char otherLow,
			boolean ignoreCase) {
		if (index - 1 < 0)
			return false;
		return equals(arr[index - 1], arr[index], otherHigh, otherLow, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(char[] arr, int len, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		if (index - 2 < 0)
			return false;
		return equals(arr[index - 2], arr[index - 1], otherHigh, otherLow, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equals(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		if (index + 1 >= cs.length())
			return false;
		return equals(cs.charAt(index), cs.charAt(index + 1), otherHigh, otherLow, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		if (index - 1 < 0)
			return false;
		return equals(cs.charAt(index - 1), cs.charAt(index), otherHigh, otherLow, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase) {
		if (index - 2 < 0)
			return false;
		return equals(cs.charAt(index - 2), cs.charAt(index - 1), otherHigh, otherLow, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equals(char[] arr, int len, int index, int cp, boolean ignoreCase) {
		if (isPair(cp)) {
			if (index + 1 >= len)
				return false;
			return equals(arr[index], arr[index + 1], toHigh(cp), toLow(cp), ignoreCase);
		}
		return equals(arr[index], cp, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(char[] arr, int len, int index, int cp, boolean ignoreCase) {
		if (isPair(cp)) {
			if (index - 1 < 0)
				return false;
			return equals(arr[index - 1], arr[index], toHigh(cp), toLow(cp), ignoreCase);
		}
		return equals(arr[index], cp, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(char[] arr, int len, int index, int cp, boolean ignoreCase) {
		if (isPair(cp)) {
			if (index - 2 < 0)
				return false;
			return equals(arr[index - 2], arr[index - 1], toHigh(cp), toLow(cp), ignoreCase);
		}
		return index - 1 < 0 ? false : equals(arr[index - 1], cp, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equals(CharSequence cs, int index, int cp, boolean ignoreCase) {
		if (isPair(cp)) {
			if (index + 1 >= 0)
				return false;
			return equals(cs.charAt(index), cs.charAt(index + 1), toHigh(cp), toLow(cp), ignoreCase);
		}
		return equals(cs.charAt(index), cp, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsIntersectly(CharSequence cs, int index, int cp, boolean ignoreCase) {
		if (isPair(cp)) {
			if (index - 1 < 0)
				return false;
			return equals(cs.charAt(index - 1), cs.charAt(index), toHigh(cp), toLow(cp), ignoreCase);
		}
		return equals(cs.charAt(index), cp, ignoreCase);
	}

	// ------------------

	@Override
	public boolean equalsBackwardly(CharSequence cs, int index, int cp, boolean ignoreCase) {
		if (isPair(cp)) {
			if (index - 2 < 0)
				return false;
			return equals(cs.charAt(index - 2), cs.charAt(index - 1), toHigh(cp), toLow(cp), ignoreCase);
		}
		return index - 1 < 0 ? false : equals(cs.charAt(index), cp, ignoreCase);
	}
	// ------------------
}
