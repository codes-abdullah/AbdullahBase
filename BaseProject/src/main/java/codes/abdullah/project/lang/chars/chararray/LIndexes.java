package codes.abdullah.project.lang.chars.chararray;

import java.util.ArrayList;
import java.util.List;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LIndexes {
	LIndexes() {
	}

	// ============
	// indexes-of
	// ============

	public int[] of(char[] arr, int len, char[] target, int targetLen) {
		return of(arr, len, target, targetLen, 0);
	}

	public int[] of(char[] arr, int len, char[] target, int targetLen, int from) {
		return of(arr, len, target, targetLen, from, len);
	}

	public int[] of(char[] arr, int len, char[] target, int targetLen, int from, int to) {
		return of(arr, len, target, targetLen, from, to, 0);
	}

	public int[] of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
		return of(arr, len, target, targetLen, from, to, flags, 0);
	}

	public int[] of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp) {
		return of(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int[] of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return of(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int[] of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport sps) {
		List<Integer> l = new ArrayList<Integer>();
		while ((from = CharsLoop.INDEX_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m,
				sps)) > Lang.constant.INDEX_NOT_FOUND) {
			l.add(from++);
		}
		return Lang.primitive.to.ints(l);
	}

	// ============
	// indexes-of any
	// ============

	public int[] ofAny(char[] arr, int len, char[] targets, int targetsLen) {
		return ofAny(arr, len, targets, targetsLen, 0);
	}

	public int[] ofAny(char[] arr, int len, char[] targets, int targetsLen, int from) {
		return ofAny(arr, len, targets, targetsLen, from, len);
	}

	public int[] ofAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to) {
		return ofAny(arr, len, targets, targetsLen, from, to, 0);
	}

	public int[] ofAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags) {
		return ofAny(arr, len, targets, targetsLen, from, to, flags, 0);
	}

	public int[] ofAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, targets, targetsLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int[] ofAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofAny(arr, len, targets, targetsLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int[] ofAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport sps) {
		List<Integer> l = new ArrayList<Integer>();
		while ((from = CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targetsLen, flags, fromDisp, m,
				sps)) > Lang.constant.INDEX_NOT_FOUND) {
			l.add(from++);
		}
		return Lang.primitive.to.ints(l);
	}

}