package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LRemove {
	LRemove() {

	}

	public int when(char[] arr, int len, char[] target, int targetLen) {
		return when(arr, len, target, targetLen, 1);
	}

	public int when(char[] arr, int len, char[] target, int targetLen, int delif) {
		return when(arr, len, target, targetLen, delif, 0);
	}

	public int when(char[] arr, int len, char[] target, int targetLen, int delif, int from) {
		return when(arr, len, target, targetLen, delif, from, len);
	}

	public int when(char[] arr, int len, char[] target, int targetLen, int delif, int from, int to) {
		return when(arr, len, target, targetLen, delif, from, to, 0);
	}

	public int when(char[] arr, int len, char[] target, int targetLen, int delif, int from, int to, int fromDisp) {
		return when(arr, len, target, targetLen, delif, from, to, fromDisp, 0);
	}

	public int when(char[] arr, int len, char[] target, int targetLen, int delif, int from, int to, int fromDisp,
			int flags) {
		return when(arr, len, target, targetLen, delif, from, to, fromDisp, flags, CharsMatcher.MUST_EQUALS);
	}

	public int when(char[] arr, int len, char[] target, int targetLen, int delif, int from, int to, int fromDisp,
			int flags, CharsMatcher m) {
		return when(arr, len, target, targetLen, delif, from, to, fromDisp, flags, m, CodepointSupport.BMP);
	}

	public int when(char[] arr, int len, char[] target, int targetLen, int delif, int from, int to, int fromDisp,
			int flags, CharsMatcher m, CodepointSupport sps) {
		int end = 0, dellen = 0;
		// --------------------
		// will discard any other flags but ignore-case, we will work only on
		// actual-level
		// --------------------
		flags = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE)
				? Lang.constant.FLAG_ALWAYS_IGNORE_CASE
				: 0;
		while ((from = CharsLoop.INDEX_OF.array(arr, len, from, to, target, targetLen, flags, 0, m,
				sps)) > Lang.constant.INDEX_NOT_FOUND) {
			end = Lang.chararray.index.ofEnd(arr, len, target, targetLen, from, to, flags, 0, m);
			// TODO: fix, not working if delif = 1 and targetLen=1
//				dellen = ((end - from) / targetLength) - delif;
			dellen = end - from;
			// --------------------
			// in case of the detected length less than delif
			// --------------------
			if (dellen <= 0) {
				continue;
			}
			dellen = dellen * targetLen;
			arr = Lang.shrink.at(arr, len, from, dellen);
			len -= dellen;
			to -= dellen;
			from = end - dellen;
		}
		return len;
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen) {
		return whenAny(arr, len, targets, targetsLen, 1);
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen, int delif) {
		return whenAny(arr, len, targets, targetsLen, delif, 0);
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen, int delif, int from) {
		return whenAny(arr, len, targets, targetsLen, delif, from, len);
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen, int delif, int from, int to) {
		return whenAny(arr, len, targets, targetsLen, delif, from, to, 0);
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen, int delif, int from, int to, int fromDisp) {
		return whenAny(arr, len, targets, targetsLen, delif, from, to, fromDisp, 0);
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen, int delif, int from, int to, int fromDisp,
			int flags) {
		return whenAny(arr, len, targets, targetsLen, delif, from, to, fromDisp, flags, CharsMatcher.MUST_EQUALS);
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen, int delif, int from, int to, int fromDisp,
			int flags, CharsMatcher m) {
		return whenAny(arr, len, targets, targetsLen, delif, from, to, fromDisp, flags, m, CodepointSupport.BMP);
	}

	public int whenAny(char[] arr, int len, char[] targets, int targetsLen, int delif, int from, int to, int fromDisp,
			int flags, CharsMatcher m, CodepointSupport sps) {
		int end = 0, dellen = 0;
		// --------------------
		// will discard any other flags but ignore-case, we will work only on
		// actual-level
		// --------------------
		flags = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE)
				? Lang.constant.FLAG_ALWAYS_IGNORE_CASE
				: 0;
		while ((from = CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targetsLen, flags, 0,
				CharsMatcher.MUST_EQUALS, sps)) > Lang.constant.INDEX_NOT_FOUND) {
			end = Lang.chararray.index.ofAnyEnd(arr, len, targets, from, to, flags, 0, m, sps);
			// --------------------
			// e.g: codes.abdullah, target l, delif = 0, lenof = 1, index = 10, end = 12
			// calculate the difference
			// --------------------
			dellen = end - from;
			int _delif = delif;
			int _end = end - 1;
			while (_delif > 0) {
				if (sps.isPairIntersectly(arr, len, _end)) {
					_end -= 1;
					dellen--;
					_delif--;
					continue;
				}
				_end -= 1;
				dellen--;
				_delif--;
			}
			// --------------------
			// in case of the detected length less than delif
			// --------------------
			if (dellen <= 0) {
				from = end;
				continue;
			}
			arr = Lang.shrink.at(arr, len, from, dellen);
			len -= dellen;
			to -= dellen;
			from = end - dellen;
		}
		return len;
	}
	
	
	
}
