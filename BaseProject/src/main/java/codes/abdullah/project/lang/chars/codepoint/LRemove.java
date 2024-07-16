package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.LConstants;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LRemove {
	LRemove() {

	}

	/**
	 * @see #when(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int when(char[] arr, int len, int target) {
		return when(arr, len, target, 1);
	}

	/**
	 * @see #when(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int when(char[] arr, int len, int target, int delif) {
		return when(arr, len, target, delif, 0);
	}

	/**
	 * @see #when(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int when(char[] arr, int len, int target, int delif, int from) {
		return when(arr, len, target, delif, from, len);
	}

	/**
	 * @see #when(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int when(char[] arr, int len, int target, int delif, int from, int to) {
		return when(arr, len, target, delif, from, to, 0);
	}

	/**
	 * @see #when(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int when(char[] arr, int len, int target, int delif, int from, int to, int fromDisp) {
		return when(arr, len, target, delif, from, to, fromDisp, 0);
	}

	/**
	 * @see #when(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int when(char[] arr, int len, int target, int delif, int from, int to, int fromDisp, int flags) {
		return when(arr, len, target, delif, from, to, fromDisp, flags, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #when(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int when(char[] arr, int len, int target, int delif, int from, int to, int fromDisp, int flags,
			CharsMatcher m) {
		return when(arr, len, target, delif, from, to, fromDisp, flags, m, CodepointSupport.BMP);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> Applied<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> returned as result<br>
	 * <br>
	 * Delete <b>target</b> code-point if found individual or duplicated, and only
	 * (if count of <b>target</b> is > <b>delif</b>)<br>
	 * <b>delif</b> means: delete if greater than <br>
	 * if delif = 1, means del all and keep only 1 of <b>cp</b>, if delif = 0, means
	 * del all and keep nothing of <b>cp</b><br>
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to find
	 * @param delif    delete if greater than this count
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return the new len after clean up
	 */
	public int when(char[] arr, int len, int target, int delif, int from, int to, int fromDisp, int flags,
			CharsMatcher m, CodepointSupport cps) {
		int end = 0, len_of = cps.lengthOf(target), dellen = 0;
		// --------------------
		// will discard any other flags but ignore-case, we will work only on
		// actual-level
		// --------------------
		flags = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE)
				? Lang.constant.FLAG_ALWAYS_IGNORE_CASE
				: 0;
		while ((from = CharsLoop.INDEX_OF.codePoint(arr, len, from, to, target, flags, 0, m,
				cps)) > Lang.constant.INDEX_NOT_FOUND) {
			end = Lang.codepoint.index.ofEnd(arr, len, target, from, to, flags, fromDisp, m, cps);
			// --------------------
			// e.g: codes.abdullah, target l, delif = 0, lenof = 1, index = 10, end = 12
			// calculate the difference
			// --------------------
			dellen = ((end - from) / len_of) - delif;
			// --------------------
			// in case of the detected length less than delif
			// --------------------
			if (dellen <= 0) {
				from = end;
				continue;
			}
			dellen = dellen * len_of;
			arr = Lang.shrink.at(arr, len, from, dellen);
			len -= dellen;
			to -= dellen;
			from = end - dellen;
		}
		return len;
	}

	/**
	 * @see #whenAny(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int whenAny(char[] arr, int len, int[] targets) {
		return whenAny(arr, len, targets, 1);
	}

	/**
	 * @see #whenAny(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int whenAny(char[] arr, int len, int[] targets, int delif) {
		return whenAny(arr, len, targets, delif, 0);
	}

	/**
	 * @see #whenAny(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int whenAny(char[] arr, int len, int[] targets, int delif, int from) {
		return whenAny(arr, len, targets, delif, from, len);
	}

	/**
	 * @see #whenAny(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int whenAny(char[] arr, int len, int[] targets, int delif, int from, int to) {
		return whenAny(arr, len, targets, delif, from, to, 0);
	}

	/**
	 * @see #whenAny(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int whenAny(char[] arr, int len, int[] targets, int delif, int from, int to, int fromDisp) {
		return whenAny(arr, len, targets, delif, from, to, fromDisp, 0);
	}

	/**
	 * @see #whenAny(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int whenAny(char[] arr, int len, int[] targets, int delif, int from, int to, int fromDisp, int flags) {
		return whenAny(arr, len, targets, delif, from, to, fromDisp, flags, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #whenAny(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int whenAny(char[] arr, int len, int[] targets, int delif, int from, int to, int fromDisp, int flags,
			CharsMatcher m) {
		return whenAny(arr, len, targets, delif, from, to, fromDisp, flags, m, CodepointSupport.BMP);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> Applied<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> returned as result<br>
	 * <br>
	 * Delete any of <b>targets</b> if found individual or duplicated, and only (if
	 * count of <b>target</b> is > <b>delif</b>)<br>
	 * <b>delif</b> means: delete if greater than <br>
	 * if delif = 1, means del all and keep only 1 of <b>cp</b>, if delif = 0, means
	 * del all and keep nothing of <b>cp</b><br>
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param targets  targets to find
	 * @param delif    delete if greater than this count
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return the new len after clean up
	 */
	public int whenAny(char[] arr, int len, int[] targets, int delif, int from, int to, int fromDisp, int flags,
			CharsMatcher m, CodepointSupport cps) {
		int end = 0, dellen = 0;
		// --------------------
		// will discard any other flags but ignore-case, we will work only on
		// actual-level
		// --------------------
		flags = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE)
				? Lang.constant.FLAG_ALWAYS_IGNORE_CASE
				: 0;
		while ((from = CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, 0,
				CharsMatcher.MUST_EQUALS, cps)) > Lang.constant.INDEX_NOT_FOUND) {
			end = Lang.codepoint.index.ofAnyEnd(arr, len, targets, from, to, flags, 0, m, cps);
			// --------------------
			// e.g: codes.abdullah, target l, delif = 0, lenof = 1, index = 10, end = 12
			// calculate the difference
			// --------------------
			dellen = end - from;
			int _delif = delif;
			int _end = end - 1;
			while (_delif > 0) {
				if (cps.isPairIntersectly(arr, len, _end)) {
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

	public int linefeeds(char[] arr, int len, int delif) {
		return linefeeds(arr, len, delif, 0);
	}

	public int linefeeds(char[] arr, int len, int delif, int from) {
		return linefeeds(arr, len, delif, from, len);
	}

	public int linefeeds(char[] arr, int len, int delif, int from, int to) {
		return linefeeds(arr, len, delif, from, to, 0);
	}

	public int linefeeds(char[] arr, int len, int delif, int from, int to, int fromDisp) {
		return linefeeds(arr, len, delif, from, to, fromDisp, 0);
	}

	public int linefeeds(char[] arr, int len, int delif, int from, int to, int fromDisp, int flags) {
		return linefeeds(arr, len, delif, from, to, fromDisp, flags, CharsMatcher.MUST_EQUALS);
	}

	public int linefeeds(char[] arr, int len, int delif, int from, int to, int fromDisp, int flags, CharsMatcher m) {
		return linefeeds(arr, len, delif, from, to, fromDisp, flags, m, CodepointSupport.BMP);
	}

	public int linefeeds(char[] arr, int len, int delif, int from, int to, int fromDisp, int flags, CharsMatcher m,
			CodepointSupport cps) {
		return whenAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, delif, from, to, fromDisp, flags, m, cps);
	}

	public int whitespaces(char[] arr, int len, int delif) {
		return whitespaces(arr, len, delif, 0);
	}

	public int whitespaces(char[] arr, int len, int delif, int from) {
		return whitespaces(arr, len, delif, from, len);
	}

	public int whitespaces(char[] arr, int len, int delif, int from, int to) {
		return whitespaces(arr, len, delif, from, to, 0);
	}

	public int whitespaces(char[] arr, int len, int delif, int from, int to, int fromDisp) {
		return whitespaces(arr, len, delif, from, to, fromDisp, 0);
	}

	public int whitespaces(char[] arr, int len, int delif, int from, int to, int fromDisp, int flags) {
		return whitespaces(arr, len, delif, from, to, fromDisp, flags, CharsMatcher.MUST_EQUALS);
	}

	public int whitespaces(char[] arr, int len, int delif, int from, int to, int fromDisp, int flags, CharsMatcher m) {
		return whitespaces(arr, len, delif, from, to, fromDisp, flags, m, CodepointSupport.BMP);
	}

	public int whitespaces(char[] arr, int len, int delif, int from, int to, int fromDisp, int flags, CharsMatcher m,
			CodepointSupport cps) {
		return whenAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, delif, from, to, fromDisp, flags, m, cps);
	}

}
