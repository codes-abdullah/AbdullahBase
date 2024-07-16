package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LReplace {
	public final LReplaceLength lengthOf = new LReplaceLength();

	LReplace() {

	}

	public char[] range(char[] arr, int len, int from, int to, int replacement, CodepointSupport cps) {
		int rangeLen = to - from;
		if (rangeLen == len) {
			Lang.codepoint.setWithoutExpendOrShrink(arr, len, 0, replacement, cps);
			return arr;
		}
		int rlen = cps.lengthOf(replacement);
		int newlen = len - rangeLen + rlen;
		int displacement = newlen - len;
		int dfrom = to;
		int dto = len;
		arr = Lang.capacity.ensure(arr, len, newlen);
		if (to < len) {
			arr = Lang.displace.squash.in(arr, len, displacement, dfrom, dto, from, arr.length);
		}
		Lang.codepoint.setWithoutExpendOrShrink(arr, len, from, replacement, cps);
		return arr;
	}

	public CharArray all(char[] arr, int len, int target, int replacement, int from, int to, int flags,
			CodepointSupport cps) {
		int[] indexes = Lang.codepoint.indexes.of(arr, len, target, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
		if (Lang.emptyOrNull.isAny(indexes)) {
			return CharArray.of(arr, len);
		}
		return Lang.codepoint.set(arr, len, indexes, replacement, cps);
	}

	public CharArray all(char[] arr, int len, int target, char[] replacement, int rlen, int from, int to, int flags,
			CodepointSupport cps) {
		int[] indexes = Lang.codepoint.indexes.of(arr, len, target, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
		if (Lang.emptyOrNull.isAny(indexes)) {
			return CharArray.of(arr, len);
		}
		int tlen = cps.lengthOf(target);
		int newlen = len - (tlen * indexes.length) + (rlen * indexes.length);
		arr = Lang.capacity.ensure(arr, len, newlen);
		int displacement = rlen - tlen;
		for (int i = indexes.length - 1; i >= 0; i--) {
			int index = indexes[i];
			arr = Lang.displace.squash.in(arr, len, displacement, index + 1, len, from, arr.length);
			len += displacement;
			arr = Lang.copy.to.that(replacement, rlen, arr, len, 0, rlen, index);
		}

		return CharArray.of(arr, newlen);
	}

	public char[] first(char[] arr, int len, int target, int replacement, int from, int to, int flags,
			CodepointSupport cps) {
		int index = Lang.codepoint.index.of(arr, len, target, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return arr;
		}
		len = Lang.codepoint.set(arr, len, index, replacement, cps);
		return arr;
	}

	public char[] last(char[] arr, int len, int target, int replacement, int from, int to, int flags,
			CodepointSupport cps) {
		int index = Lang.codepoint.lastIndex.of(arr, len, target, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return arr;
		}
		len = Lang.codepoint.set(arr, len, index, replacement, cps);
		return arr;
	}

	/**
	 * @see #tabs(char[], int, char, int, int, int, CodepointSupport)
	 */
	public CharArray tabs(char[] arr, int len, char replacement) {
		return tabs(arr, len, replacement, 0);
	}

	/**
	 * @see #tabs(char[], int, char, int, int, int, CodepointSupport)
	 */
	public CharArray tabs(char[] arr, int len, char replacement, int from) {
		return tabs(arr, len, replacement, from, len);
	}

	/**
	 * @see #tabs(char[], int, char, int, int, int, CodepointSupport)
	 */
	public CharArray tabs(char[] arr, int len, char replacement, int from, int to) {
		return tabs(arr, len, replacement, from, to, Lang.constant.DEFAULT_TAB_SIZE);
	}

	/**
	 * @see #tabs(char[], int, char, int, int, int, CodepointSupport)
	 */
	public CharArray tabs(char[] arr, int len, char replacement, int from, int to, int tabSize) {
		return tabs(arr, len, replacement, from, to, tabSize, CodepointSupport.BMP);
	}

	/**
	 * Replace tabs by given replacement in columns-level <br>
	 * 
	 * <pre>
	 * what 	 do y	 thin	 ba	 that
	 * 
	 * to
	 * 
	 * what --- do y--- thin--- ba----- that
	 * </pre>
	 * 
	 * Why this method does not support codepoint as replacement?<br>
	 * Because: e.g: codes>.abdullah, the tab (>) represents 3 columns, and
	 * codepoints if surrogate-pairs will be 2 columns, it does not fit
	 */
	public CharArray tabs(char[] arr, int len, char replacement, int from, int to, int tabSize, CodepointSupport cps) {
		if (replacement == Lang.constant.DEFAULT_TAB_CHAR)
			return CharArray.of(arr, len);
		int cp = 0;
		int pointer = Lang.codepoint.lastIndex.ofLinefeed(arr, len, 0, from, 0, 0, CharsMatcher.MUST_EQUALS, cps);
		pointer = pointer < 0 ? 0 : pointer + 1;
		int previousColumns = 0;
		int cp_columns = 0;
		int addition = 0;
		for (; pointer < from; pointer += cps.lengthOf(cp)) {
			cp = cps.getCodepoint(arr, len, from);
			cp_columns += Lang.codepoint.count.ofColumns(arr, len, pointer, pointer + 1, tabSize, previousColumns, cps);
		}
		cp = 0;
		for (; from < to; from += cp_columns) {
			if (cps.isLinefeed(cp))
				previousColumns = 0;

			cp = cps.getCodepoint(arr, len, from);
			cp_columns = Lang.codepoint.count.ofColumns(arr, len, from, from + 1, tabSize, previousColumns, cps);
			if (cp == Lang.constant.DEFAULT_TAB_CHAR) {
				addition = (cp_columns - 1);
				arr = Lang.capacity.ensure(arr, len, len + addition);
				arr[from] = replacement;
				if (addition > 1) {
					arr = Lang.codepoint.repeat.in(arr, len, replacement, addition, from + 1, cps);
					len = Lang.codepoint.repeat.lengthOf.in(arr, len, replacement, addition, from + 1, cps);
				}
				to += addition;
			}
			previousColumns += cp_columns;
		}
		return CharArray.of(arr, len);
	}

	// =================
	// =================
	// =================
	// =================
	// =================

	/**
	 * Calculate lengths of {@link LReplace} tools
	 */
	public static class LReplaceLength {

		private LReplaceLength() {

		}

		public int range(char[] arr, int len, int from, int to, int replacement, CodepointSupport cps) {
			return len + cps.lengthOf(replacement) - (to - from);
		}

		public int first(char[] arr, int len, int target, int replacement, int from, int to, int flags,
				CodepointSupport cps) {
			return (len - cps.lengthOf(target)) + cps.lengthOf(replacement);
		}

		public int last(char[] arr, int len, int target, int replacement, int from, int to, int flags,
				CodepointSupport cps) {
			return (len - cps.lengthOf(target)) + cps.lengthOf(replacement);
		}

	}
}
