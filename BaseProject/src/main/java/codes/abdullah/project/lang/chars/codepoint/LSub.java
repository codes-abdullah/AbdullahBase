package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LSub {

	// ============
	// ============ before
	// ============

	public char[] before(char[] arr, int len, int target) {
		return before(arr, len, target, 0);
	}

	public char[] before(char[] arr, int len, int target, int from) {
		return before(arr, len, target, from, len);
	}

	public char[] before(char[] arr, int len, int target, int from, int to) {
		return before(arr, len, target, from, to, 0);
	}

	public char[] before(char[] arr, int len, int target, int from, int to, int flags) {
		return before(arr, len, target, from, to, flags, 0);
	}

	public char[] before(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return before(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] before(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return before(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] before(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		int index = Lang.codepoint.index.of(arr, len, target, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return arr;
		return Lang.sub.of(arr, len, from, index);
	}

	// ============
	// ============ before-last
	// ============

	public char[] beforeLast(char[] arr, int len, int target) {
		return beforeLast(arr, len, target, 0);
	}

	public char[] beforeLast(char[] arr, int len, int target, int from) {
		return beforeLast(arr, len, target, from, len);
	}

	public char[] beforeLast(char[] arr, int len, int target, int from, int to) {
		return beforeLast(arr, len, target, from, to, 0);
	}

	public char[] beforeLast(char[] arr, int len, int target, int from, int to, int flags) {
		return beforeLast(arr, len, target, from, to, flags, 0);
	}

	public char[] beforeLast(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return beforeLast(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] beforeLast(char[] arr, int len, int target, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return beforeLast(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] beforeLast(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		int index = Lang.codepoint.lastIndex.of(arr, len, target, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return arr;
		return Lang.sub.of(arr, len, from, index);
	}

	// ============
	// ============ after
	// ============

	public char[] after(char[] arr, int len, int target) {
		return after(arr, len, target, 0);
	}

	public char[] after(char[] arr, int len, int target, int from) {
		return after(arr, len, target, from, len);
	}

	public char[] after(char[] arr, int len, int target, int from, int to) {
		return after(arr, len, target, from, to, 0);
	}

	public char[] after(char[] arr, int len, int target, int from, int to, int flags) {
		return after(arr, len, target, from, to, flags, 0);
	}

	public char[] after(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return after(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] after(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return after(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] after(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		int index = Lang.codepoint.index.of(arr, len, target, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return new char[0];
		return Lang.sub.of(arr, len, index + cps.lengthOf(target), len);
	}

	// ============
	// ============ after-last
	// ============

	public char[] afterLast(char[] arr, int len, int target) {
		return afterLast(arr, len, target, 0);
	}

	public char[] afterLast(char[] arr, int len, int target, int from) {
		return afterLast(arr, len, target, from, len);
	}

	public char[] afterLast(char[] arr, int len, int target, int from, int to) {
		return afterLast(arr, len, target, from, to, 0);
	}

	public char[] afterLast(char[] arr, int len, int target, int from, int to, int flags) {
		return afterLast(arr, len, target, from, to, flags, 0);
	}

	public char[] afterLast(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return afterLast(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] afterLast(char[] arr, int len, int target, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return afterLast(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] afterLast(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		int index = Lang.codepoint.lastIndex.of(arr, len, target, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return new char[0];
		return Lang.sub.of(arr, len, index + cps.lengthOf(target), to);
	}

	// ============
	// ============ between
	// ============

	public char[] between(char[] arr, int len, int open, int close) {
		return between(arr, len, open, close, 0);
	}

	public char[] between(char[] arr, int len, int open, int close, int from) {
		return between(arr, len, open, close, from, len);
	}

	public char[] between(char[] arr, int len, int open, int close, int from, int to) {
		return between(arr, len, open, close, from, to, 0);
	}

	public char[] between(char[] arr, int len, int open, int close, int from, int to, int flags) {
		return between(arr, len, open, close, from, to, flags, 0);
	}

	public char[] between(char[] arr, int len, int open, int close, int from, int to, int flags, int fromDisp) {
		return between(arr, len, open, close, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] between(char[] arr, int len, int open, int close, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return between(arr, len, open, close, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] between(char[] arr, int len, int open, int close, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int start = Lang.codepoint.index.of(arr, len, open, from, to, flags, fromDisp, m, cps);
		if (start != Lang.constant.INDEX_NOT_FOUND) {
			start = start + cps.lengthOf(open);
			int end = Lang.codepoint.index.of(arr, len, close, start, to, flags, fromDisp, m, cps);
			if (start != Lang.constant.INDEX_NOT_FOUND) {
				return Lang.sub.of(arr, len, start, end);
			}
		}
		return new char[0];
	}

}
