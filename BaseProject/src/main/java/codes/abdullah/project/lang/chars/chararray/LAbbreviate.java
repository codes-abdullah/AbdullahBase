package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.project.lang.Lang;

public class LAbbreviate {

	public final LAbbreviateLength lengthOf = new LAbbreviateLength();

	LAbbreviate() {

	}

	public char[] begin(char[] arr, int len, int width, char[] marker, int markerLen) {
		return begin(arr, len, width, marker, markerLen, 0);
	}

	public char[] begin(char[] arr, int len, int width, char[] marker, int markerLen, int offset) {
		if (width > len) {
			if (offset > len) {
				arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			}
			return arr;
		}
		int newlen = lengthOf.begin(arr, len, width, marker, markerLen, offset);
		if (newlen <= markerLen) {
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			return arr;
		}
		int from = offset;
		int to = offset + width;
		to = to > len ? len : to;

		if (from > 0) {
			arr = Lang.copy.to.that(arr, len, arr, len, from, to, markerLen);
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			int disp = markerLen - from;
			to += disp;
		}

		if (to < len) {
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, to);
		}
		return arr;
	}

	public char[] middle(char[] arr, int len, int width, char[] marker, int markerLen, int offset) {
		if (width > len) {
			if (offset > len) {
				arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			}
			return arr;
		}
		int newlen = lengthOf.middle(arr, len, width, marker, markerLen, offset);
		if (newlen <= markerLen) {
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			return arr;
		}
		
		
		int half = (width / 2);
		int from = offset - half;
		from = Math.max(from, 0);
		int to = Math.min(offset + half, len);

		if (to - from <= 0) {
			return Lang.copy.of.this_(marker, markerLen);
		}

		if (from > 0) {
			arr = Lang.copy.to.that(arr, len, arr, len, from, to, markerLen);
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			int disp = markerLen - from;
			to += disp;
		}

		if (to < len) {
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, to);
		}
		return arr;
	}

	public char[] end(char[] arr, int len, int width, char[] marker, int markerLen, int offset) {
		if (width > len) {
			if (offset > len) {
				arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			}
			return arr;
		}
		int newlen = lengthOf.end(arr, len, width, marker, markerLen, offset);
		if (newlen <= markerLen) {
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			return arr;
		}
		int from = offset - width;
		from = Math.min(Math.max(from, 0), len - width);
		int to = Math.min(from + width, len);
		if (from > 0) {
			arr = Lang.copy.to.that(arr, len, arr, len, from, to, markerLen);
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			int disp = markerLen - from;
			to += disp;
		}

		if (to < (len - width)) {
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, to);
		}
		return arr;
	}

	/**
	 * @see #abbr(char[], int, int, char[], int, int)
	 */
	public char[] abbr(char[] arr, int len, int maxWidth, char[] marker, int markerLen) {
		return abbr(arr, len, maxWidth, marker, markerLen, 0);
	}

	/**
	 * below implementation of StringUtils ported to pure array base, it works fine
	 * but does not meet my satisfaction, so I made my own implementation in
	 * {@link #in(char[], int, int, char[], int, int)}<br>
	 * 
	 * <pre>
	 *	StringUtils.abbreviate(null, *, *)                = null
	 *	StringUtils.abbreviate("", 0, 4)                  = ""
	 *	StringUtils.abbreviate("abcdefghijklmno", -1, 10) = "abcdefg..."
	 *	StringUtils.abbreviate("abcdefghijklmno", 0, 10)  = "abcdefg..."
	 *	StringUtils.abbreviate("abcdefghijklmno", 1, 10)  = "abcdefg..."
	 *	StringUtils.abbreviate("abcdefghijklmno", 4, 10)  = "abcdefg..."
	 *	StringUtils.abbreviate("abcdefghijklmno", 5, 10)  = "...fghi..."
	 *	StringUtils.abbreviate("abcdefghijklmno", 6, 10)  = "...ghij..."
	 *	StringUtils.abbreviate("abcdefghijklmno", 8, 10)  = "...ijklmno"
	 *	StringUtils.abbreviate("abcdefghijklmno", 10, 10) = "...ijklmno"
	 *	StringUtils.abbreviate("abcdefghijklmno", 12, 10) = "...ijklmno"
	 *	StringUtils.abbreviate("abcdefghij", 0, 3)        = IllegalArgumentException
	 *	StringUtils.abbreviate("abcdefghij", 5, 6)        = IllegalArgumentException
	 * </pre>
	 */
	public char[] abbr(char[] arr, int len, int maxWidth, char[] marker, int markerLen, int offset) {
		boolean arrEmptyOrNull = Lang.emptyOrNull.isAny(arr, len);
		boolean marEmptyOrNull = Lang.emptyOrNull.isAny(marker, markerLen);
		if (arrEmptyOrNull && marEmptyOrNull) {
			return arr;
		} else if (!arrEmptyOrNull && marEmptyOrNull && maxWidth > 0) {
			return arr;
		} else if (arrEmptyOrNull || marEmptyOrNull) {
			return arr;
		}
		final int minAbbrevWidth = markerLen + 1;
		final int minAbbrevWidthOffset = markerLen + markerLen + 1;

		if (maxWidth < minAbbrevWidth) {
			throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", minAbbrevWidth));
		}
		if (len <= maxWidth) {
			return arr;
		}
		if (offset > len) {
			offset = len;
		}

		if (len - offset < maxWidth - markerLen) {
			offset = len - (maxWidth - markerLen);
		}
		if (offset <= markerLen + 1) {
			arr = Lang.copy.to.that(arr, len, arr, len, 0, maxWidth - markerLen, 0);
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, maxWidth - markerLen);
			return arr;
		}
		if (maxWidth < minAbbrevWidthOffset) {
			throw new IllegalArgumentException(
					String.format("Minimum abbreviation width with offset is %d", minAbbrevWidthOffset));
		}

		if ((offset + maxWidth) - markerLen < len) {
			arr = Lang.copy.to.that(arr, len, arr, len, offset, len, markerLen);
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
			arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, maxWidth - markerLen);
			return arr;
		}
		arr = Lang.copy.to.that(arr, len, arr, len, offset, len, markerLen);
		arr = Lang.copy.to.that(marker, markerLen, arr, len, 0, markerLen, 0);
		return arr;
	}

	// ====================
	// ====================
	// ====================
	// ====================
	// ====================
	// ====================

	// ================
	// ================
	// ================
	// ================

	public static class LAbbreviateLength {
		private LAbbreviateLength() {

		}

		public int begin(char[] arr, int len, int width, char[] marker, int markerLen, int offset) {
			if (width > len) {
				if (offset > len)
					return markerLen;
				return len;
			}
			int newlen = len;
			int from = offset;
			int to = offset + width;
			to = to > len ? len : to;
			newlen = (newlen - from);
			newlen = (newlen - (len - to));
			newlen += from > 0 ? markerLen : 0;
			newlen += to < len ? markerLen : 0;
			if (newlen <= markerLen)
				return markerLen;
			return newlen;
		}

		public int middle(char[] arr, int len, int width, char[] marker, int markerLen, int offset) {
			if (width > len) {
				if (offset > len)
					return markerLen;
				return len;
			}

			int newlen = len;
			int half = (width / 2);
			int from = offset - half;
			from = Math.max(from, 0);
			int to = Math.min(offset + half, len);
			if (to - from <= 0)
				return markerLen;

			newlen = (newlen - from);
			newlen = (newlen - (len - to));
			newlen += from > 0 ? markerLen : 0;
			newlen += to < len ? markerLen : 0;
			if (newlen <= markerLen)
				return markerLen;
			return newlen;
		}

		public int end(char[] arr, int len, int width, char[] marker, int markerLen, int offset) {
			if (width > len) {
				if (offset > len)
					return markerLen;
				return len;
			}

			int newlen = len;
			int from = offset - width;
			from = Math.min(Math.max(from, 0), len - width);
			int to = Math.min(from + width, len);

			newlen = (newlen - from);
			newlen = (newlen - (len - to));
			newlen += from > 0 ? markerLen : 0;
			newlen += to < len ? markerLen : 0;
			if (newlen <= markerLen)
				return markerLen;
			return newlen;
		}

		public int abbr(char[] arr, int len, int maxWidth, char[] marker, int markerLen) {
			return abbr(arr, len, maxWidth, marker, markerLen, 0);
		}

		public int abbr(char[] arr, int len, int maxWidth, char[] marker, int markerLen, int offset) {
			boolean arrEmptyOrNull = Lang.emptyOrNull.isAny(arr, len);
			boolean marEmptyOrNull = Lang.emptyOrNull.isAny(marker, markerLen);
			if (arrEmptyOrNull && marEmptyOrNull) {
				return len;
			} else if (!arrEmptyOrNull && marEmptyOrNull && maxWidth > 0) {
				return maxWidth;
			} else if (arrEmptyOrNull || marEmptyOrNull) {
				return len;
			}
			return Math.min(len, maxWidth);
		}
	}

}
