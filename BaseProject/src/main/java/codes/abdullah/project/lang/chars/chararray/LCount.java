package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LCount {

	LCount() {

	}

	// ============
	// count-of
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
		return CharsLoop.FORWARD_COUNT_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m, cps);
	}

	// ============
	// count-of but-not
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
		return CharsLoop.FORWARD_COUNT_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m, cps);
	}

	// ============
	// count-of-any
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
		return CharsLoop.FORWARD_COUNT_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m,
				cps);
	}

	// ============
	// count-of-any but-not
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
		return CharsLoop.FORWARD_COUNT_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m,
				cps);
	}

	// ============
	// count-of repeat
	// ============

	public int ofRepeat(char[] arr, int len, char[] target, int targetLen) {
		return ofRepeat(arr, len, target, targetLen, 0);
	}

	public int ofRepeat(char[] arr, int len, char[] target, int targetLen, int from) {
		return ofRepeat(arr, len, target, targetLen, from, len);
	}

	public int ofRepeat(char[] arr, int len, char[] target, int targetLen, int from, int to) {
		return ofRepeat(arr, len, target, targetLen, from, to, 0);
	}

	public int ofRepeat(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
		return ofRepeat(arr, len, target, targetLen, from, to, flags, 0);
	}

	public int ofRepeat(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp) {
		return ofRepeat(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofRepeat(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofRepeat(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofRepeat(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int index = Lang.chararray.index.of(arr, len, target, targetLen, from, to, flags, 0, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return 0;
		}
		return of(arr, len, target, targetLen, from, to, flags, 0, m);
	}

}
