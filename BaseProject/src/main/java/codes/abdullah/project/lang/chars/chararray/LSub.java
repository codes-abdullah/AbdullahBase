package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LSub {

	// ============
	// ============ before
	// ============

	public char[] before(char[] arr, int len, char[] target, int tlen) {
		return before(arr, len, target, tlen, 0);
	}

	public char[] before(char[] arr, int len, char[] target, int tlen, int from) {
		return before(arr, len, target, tlen, from, len);
	}

	public char[] before(char[] arr, int len, char[] target, int tlen, int from, int to) {
		return before(arr, len, target, tlen, from, to, 0);
	}

	public char[] before(char[] arr, int len, char[] target, int tlen, int from, int to, int flags) {
		return before(arr, len, target, tlen, from, to, flags, 0);
	}

	public char[] before(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp) {
		return before(arr, len, target, tlen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] before(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return before(arr, len, target, tlen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] before(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int index = Lang.chararray.index.of(arr, len, target, tlen, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return arr;
		return Lang.sub.of(arr, len, from, index);
	}

	// ============
	// ============ before-last
	// ============

	public char[] beforeLast(char[] arr, int len, char[] target, int tlen) {
		return beforeLast(arr, len, target, tlen, 0);
	}

	public char[] beforeLast(char[] arr, int len, char[] target, int tlen, int from) {
		return beforeLast(arr, len, target, tlen, from, len);
	}

	public char[] beforeLast(char[] arr, int len, char[] target, int tlen, int from, int to) {
		return beforeLast(arr, len, target, tlen, from, to, 0);
	}

	public char[] beforeLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags) {
		return beforeLast(arr, len, target, tlen, from, to, flags, 0);
	}

	public char[] beforeLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp) {
		return beforeLast(arr, len, target, tlen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] beforeLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return beforeLast(arr, len, target, tlen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] beforeLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int index = Lang.chararray.lastIndex.of(arr, len, target, tlen, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return arr;
		return Lang.sub.of(arr, len, from, index);
	}

	// ============
	// ============ after
	// ============

	public char[] after(char[] arr, int len, char[] target, int tlen) {
		return after(arr, len, target, tlen, 0);
	}

	public char[] after(char[] arr, int len, char[] target, int tlen, int from) {
		return after(arr, len, target, tlen, from, len);
	}

	public char[] after(char[] arr, int len, char[] target, int tlen, int from, int to) {
		return after(arr, len, target, tlen, from, to, 0);
	}

	public char[] after(char[] arr, int len, char[] target, int tlen, int from, int to, int flags) {
		return after(arr, len, target, tlen, from, to, flags, 0);
	}

	public char[] after(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp) {
		return after(arr, len, target, tlen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] after(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return after(arr, len, target, tlen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] after(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int index = Lang.chararray.index.of(arr, len, target, tlen, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return new char[0];
		return Lang.sub.of(arr, len, index + tlen, len);
	}

	// ============
	// ============ after-last
	// ============

	public char[] afterLast(char[] arr, int len, char[] target, int tlen) {
		return afterLast(arr, len, target, tlen, 0);
	}

	public char[] afterLast(char[] arr, int len, char[] target, int tlen, int from) {
		return afterLast(arr, len, target, tlen, from, len);
	}

	public char[] afterLast(char[] arr, int len, char[] target, int tlen, int from, int to) {
		return afterLast(arr, len, target, tlen, from, to, 0);
	}

	public char[] afterLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags) {
		return afterLast(arr, len, target, tlen, from, to, flags, 0);
	}

	public char[] afterLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp) {
		return afterLast(arr, len, target, tlen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] afterLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return afterLast(arr, len, target, tlen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] afterLast(char[] arr, int len, char[] target, int tlen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int index = Lang.chararray.lastIndex.of(arr, len, target, tlen, from, to, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND)
			return new char[0];
		return Lang.sub.of(arr, len, index + tlen, to);
	}

	// ============
	// ============ between
	// ============

	public char[] between(char[] arr, int len, char[] open, int olen, char[] close, int clen) {
		return between(arr, len, open, olen, close, clen, 0);
	}

	public char[] between(char[] arr, int len, char[] open, int olen, char[] close, int clen, int from) {
		return between(arr, len, open, olen, close, clen, from, len);
	}

	public char[] between(char[] arr, int len, char[] open, int olen, char[] close, int clen, int from, int to) {
		return between(arr, len, open, olen, close, clen, from, to, 0);
	}

	public char[] between(char[] arr, int len, char[] open, int olen, char[] close, int clen, int from, int to,
			int flags) {
		return between(arr, len, open, olen, close, clen, from, to, flags, 0);
	}

	public char[] between(char[] arr, int len, char[] open, int olen, char[] close, int clen, int from, int to,
			int flags, int fromDisp) {
		return between(arr, len, open, olen, close, clen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public char[] between(char[] arr, int len, char[] open, int olen, char[] close, int clen, int from, int to,
			int flags, int fromDisp, CharsMatcher m) {
		return between(arr, len, open, olen, close, clen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public char[] between(char[] arr, int len, char[] open, int olen, char[] close, int clen, int from, int to,
			int flags, int fromDisp, CharsMatcher m, CodepointSupport cps) {
		int start = Lang.chararray.index.of(arr, len, open, olen, from, to, flags, fromDisp, m, cps);
		if (start != Lang.constant.INDEX_NOT_FOUND) {
			start = start + olen;
			int end = Lang.chararray.index.of(arr, len, close, clen, start, to, flags, fromDisp, m, cps);
			if (start != Lang.constant.INDEX_NOT_FOUND) {
				return Lang.sub.of(arr, len, start, end);
			}
		}
		return new char[0];
	}

}
