package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LReplace {
	public final LReplaceLength lengthOf = new LReplaceLength();

	LReplace() {

	}

	public char[] range(char[] arr, int len, int from, int to, char[] replacement, int rlen, CodepointSupport cps) {
		int rangeLen = to - from;
		if (rangeLen == len) {
			arr = Lang.capacity.ensure(arr, len, rlen);
			arr = Lang.copy.to.that(replacement, rlen, arr, arr.length, 0, rlen, 0);
			return arr;
		}

		int newlen = len - rangeLen + rlen;
		int displacement = newlen - len;
		int dfrom = to;
		int dto = len;
		arr = Lang.capacity.ensure(arr, len, newlen);
		if (to < len) {
			arr = Lang.displace.squash.in(arr, len, displacement, dfrom, dto, from, arr.length);
		}
		arr = Lang.copy.to.that(replacement, rlen, arr, arr.length, 0, rlen, from);
		return arr;
	}

	public CharArray all(char[] arr, int len, char[] target, int tlen, int replacement, int from, int to, int flags,
			CodepointSupport cps) {
		int[] indexes = Lang.chararray.indexes.of(arr, len, target, tlen, from, to, flags, 0, CharsMatcher.MUST_EQUALS,
				cps);
		if (Lang.emptyOrNull.isAny(indexes)) {
			return CharArray.of(arr, len);
		}

		int rlen = cps.lengthOf(replacement);
		int newlen = len - (tlen * indexes.length) + (rlen * indexes.length);
		arr = Lang.capacity.ensure(arr, len, newlen);
		int displacement = rlen - tlen;
		for (int i = indexes.length - 1; i >= 0; i--) {
			int index = indexes[i];
			arr = Lang.displace.squash.in(arr, len, displacement, index + 1, len, index, arr.length);
			len += displacement;
			Lang.codepoint.setWithoutExpendOrShrink(arr, len, index, replacement, cps);
		}

		return CharArray.of(arr, newlen);
	}

	public CharArray all(char[] arr, int len, char[] target, int tlen, char[] replacement, int rlen, int from, int to,
			int flags, CodepointSupport cps) {
		int[] indexes = Lang.chararray.indexes.of(arr, len, target, tlen, from, to, flags, 0, CharsMatcher.MUST_EQUALS,
				cps);
		if (Lang.emptyOrNull.isAny(indexes)) {
			return CharArray.of(arr, len);
		}

		int newlen = len - (tlen * indexes.length) + (rlen * indexes.length);
		arr = Lang.capacity.ensure(arr, len, newlen);
		int displacement = rlen - tlen;
		for (int i = indexes.length - 1; i >= 0; i--) {
			int index = indexes[i];
			arr = Lang.displace.squash.in(arr, len, displacement, index + 1, len, index, arr.length);
			len += displacement;
			arr = Lang.copy.to.that(replacement, rlen, arr, arr.length, 0, rlen, index);
		}

		return CharArray.of(arr, newlen);
	}

	public char[] first(char[] arr, int len, char[] target, int tlen, char[] replacement, int rlen, int from, int to,
			int flags, CodepointSupport cps) {
		int index = Lang.chararray.index.of(arr, len, target, tlen, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return arr;
		}
		return range(arr, len, index, index + tlen, replacement, rlen, cps);
	}

	public char[] last(char[] arr, int len, char[] target, int tlen, char[] replacement, int rlen, int from, int to,
			int flags, CodepointSupport cps) {
		int index = Lang.chararray.lastIndex.of(arr, len, target, tlen, from, to, flags, 0, CharsMatcher.MUST_EQUALS,
				cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return arr;
		}
		return range(arr, len, index, index + tlen, replacement, rlen, cps);
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

		public int range(char[] arr, int len, int from, int to, char[] replacement, int rlen, CodepointSupport cps) {
			return len - (to - from) + rlen;
		}

		public int first(char[] arr, int len, char[] target, int tlen, char[] replacement, int rlen, int from, int to,
				int flags, CodepointSupport cps) {
			return (len - tlen) + rlen;
		}

		public int last(char[] arr, int len, char[] target, int tlen, char[] replacement, int rlen, int from, int to,
				int flags, CodepointSupport cps) {
			return (len - tlen) + rlen;
		}
	}
}
