package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LIndex {

	LIndex() {

	}

	// ============
	// index-of
	// ============

	public int of(char[] arr, int len, char[] target, int targetLen) {
		return of(arr, len, target, targetLen, 0);
	}

	public int of(char[] arr, int len, char[] target, int targetLen, int from) {
		return of(arr, len, target, targetLen, from, len);
	}

	public int of(char[] arr, int len, char[] target, int targetLen, int from, int to) {
		return of(arr, len, target, targetLen, from, to, 0);
	}

	public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
		return of(arr, len, target, targetLen, from, to, flags, 0);
	}

	public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp) {
		return of(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return of(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		return CharsLoop.INDEX_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m, cps);
	}

	// ============
	// index-of but-not
	// ============

	public int ofButNot(char[] arr, int len, char[] target, int targetLen) {
		return ofButNot(arr, len, target, targetLen, 0);
	}

	public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from) {
		return ofButNot(arr, len, target, targetLen, from, len);
	}

	public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to) {
		return ofButNot(arr, len, target, targetLen, from, to, 0);
	}

	public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
		return ofButNot(arr, len, target, targetLen, from, to, flags, 0);
	}

	public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp) {
		return ofButNot(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
	}

	public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofButNot(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		return CharsLoop.INDEX_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m, cps);
	}

	// ============
	// index-of-any
	// ============

	public int ofAny(char[] arr, int len, char[] targets) {
		return ofAny(arr, len, targets, 0);
	}

	public int ofAny(char[] arr, int len, char[] targets, int from) {
		return ofAny(arr, len, targets, from, len);
	}

	public int ofAny(char[] arr, int len, char[] targets, int from, int to) {
		return ofAny(arr, len, targets, from, to, 0);
	}

	public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags) {
		return ofAny(arr, len, targets, from, to, flags, 0);
	}

	public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m, cps);
	}

	// ============
	// index-of-any but-not
	// ============

	public int ofAnyButNot(char[] arr, int len, char[] targets) {
		return ofAnyButNot(arr, len, targets, 0);
	}

	public int ofAnyButNot(char[] arr, int len, char[] targets, int from) {
		return ofAnyButNot(arr, len, targets, from, len);
	}

	public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to) {
		return ofAnyButNot(arr, len, targets, from, to, 0);
	}

	public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags) {
		return ofAnyButNot(arr, len, targets, from, to, flags, 0);
	}

	public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp) {
		return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
	}

	public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		return CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m, cps);
	}

	// ============
	// index-of end
	// ============

	public int ofEnd(char[] arr, int len, char[] target, int targetLen) {
		return ofEnd(arr, len, target, targetLen, 0);
	}

	public int ofEnd(char[] arr, int len, char[] target, int targetLen, int from) {
		return ofEnd(arr, len, target, targetLen, from, len);
	}

	public int ofEnd(char[] arr, int len, char[] target, int targetLen, int from, int to) {
		return ofEnd(arr, len, target, targetLen, from, to, 0);
	}

	public int ofEnd(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
		return ofEnd(arr, len, target, targetLen, from, to, flags, 0);
	}

	public int ofEnd(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp) {
		return ofEnd(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofEnd(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofEnd(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofEnd(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
		int count = CharsLoop.FORWARD_COUNT_OF.array(arr, len, from, to, target, targetLen, flags, 0, m, cps);
		// spc * count
		fromDisp += cps.fixedPairsCount(target, targetLen, 0, targetLen) * count;
		return (from + (targetLen * count)) - fromDisp;
	}

	// ============
	// index-of-any end
	// ============

	public int ofAnyEnd(char[] arr, int len, char[] targets) {
		return ofAnyEnd(arr, len, targets, 0);
	}

	public int ofAnyEnd(char[] arr, int len, char[] targets, int from) {
		return ofAnyEnd(arr, len, targets, from, len);
	}

	public int ofAnyEnd(char[] arr, int len, char[] targets, int from, int to) {
		return ofAnyEnd(arr, len, targets, from, to, 0);
	}

	public int ofAnyEnd(char[] arr, int len, char[] targets, int from, int to, int flags) {
		return ofAnyEnd(arr, len, targets, from, to, flags, 0);
	}

	public int ofAnyEnd(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp) {
		return ofAnyEnd(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofAnyEnd(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofAnyEnd(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofAnyEnd(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		int index = CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return -1;
		}
		// convert index into actual-level by fromDisp + index
		fromDisp += cps.extendablePairsCount(arr, len, from, fromDisp + index);
		// now fromDisp has every sp before index on (actual-level)
		// convert index into actual-level and assign it into from
		from = index + fromDisp;
		flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
		// --------------------
		// count from index(15) to to(len), c𐂽des.𐁕bd𐂽ll{𐁕𐁕h.java}, count = 2
		// --------------------
		int count = CharsLoop.FORWARD_COUNT_OF.codePoints(arr, len, from, to, targets, targets.length, flags, 0, m,
				cps);
		// --------------------
		// now we need to add sp between index and the stop point by countRepeat, if the
		// target is not bmp, means the count equals to how many sp, we got 2, and
		// target is sp, that 2 sp can be used to displace fromDisp, so fromDisp will be
		// fromDisp(5)
		// --------------------
		fromDisp += !cps.isSupported() ? 0 : count;
		// --------------------
		int lensum = cps.extendablePairsCount(arr, len, from, from + count) + count;
		// --------------------
		// now re convert again according to current state which is hspc = true, so
		// index is the begin, to turn it into visual-level, just subtract fromDisp from
		// it, but we need to push it first be cause we have target in-front of index,
		// so index + (count * length), since target is sp, count(2) * 2 = 4, so index
		// in actual-level equals = index(19), turn it into visual-level = index(19) -
		// fromDisp(5) = 14
		// --------------------
		return (from + lensum) - fromDisp;
	}

	// ============
	// index-of index
	// ============

	public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex) {
		return ofIndex(arr, len, target, targetLen, targetIndex, 0);
	}

	public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from) {
		return ofIndex(arr, len, target, targetLen, targetIndex, from, len);
	}

	public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to) {
		return ofIndex(arr, len, target, targetLen, targetIndex, from, to, 0);
	}

	public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to,
			int flags) {
		return ofIndex(arr, len, target, targetLen, targetIndex, from, to, flags, 0);
	}

	public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to, int flags,
			int fromDisp) {
		return ofIndex(arr, len, target, targetLen, targetIndex, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to, int flags,
			int fromDisp, CharsMatcher m) {
		return ofIndex(arr, len, target, targetLen, targetIndex, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to, int flags,
			int fromDisp, CharsMatcher m, CodepointSupport cps) {
		int position = 0;
		while ((from = CharsLoop.INDEX_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m,
				cps)) > Lang.constant.INDEX_NOT_FOUND) {
			if (position == targetIndex) {
				return from;
			}
			from++;
			position++;
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	// ============
	// index-of difference
	// ============

	public int ofDifference(char[] arr, int len, char[] target, int tlen) {
		return ofDifference(arr, len, target, tlen, 0);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from) {
		return ofDifference(arr, len, target, tlen, from, len);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from, int to) {
		return ofDifference(arr, len, target, tlen, from, to, 0);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from, int to, int tFrom) {
		return ofDifference(arr, len, target, tlen, from, to, tFrom, tlen);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from, int to, int tFrom, int tTo) {
		return ofDifference(arr, len, target, tlen, from, to, tFrom, tTo, 0);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from, int to, int tFrom, int tTo,
			int flags) {
		return ofDifference(arr, len, target, tlen, from, to, tFrom, tTo, flags, 0);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from, int to, int tFrom, int tTo,
			int flags, int fromDisp) {
		return ofDifference(arr, len, target, tlen, from, to, tFrom, tTo, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from, int to, int tFrom, int tTo,
			int flags, int fromDisp, CharsMatcher m) {
		return ofDifference(arr, len, target, tlen, from, to, tFrom, tTo, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofDifference(char[] arr, int len, char[] target, int tlen, int from, int to, int tFrom, int tTo,
			int flags, int fromDisp, CharsMatcher m, CodepointSupport cps) {
		for (; from < to && tFrom < tTo; from++, tFrom++) {
			if (!cps.equals(cps.toCodepoint(arr, len, from), cps.toCodepoint(target, tlen, tFrom)))
				break;
		}
		if (from < to) {
			return from;
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

}
