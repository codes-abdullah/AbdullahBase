package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.LConstants;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LIndex {

	LIndex() {

	}

	// ============
	// index-of
	// ============

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int of(char[] arr, int len, int target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int of(char[] arr, int len, int target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int of(char[] arr, int len, int target, int from, int to) {
		return of(arr, len, target, from, to, 0);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int of(char[] arr, int len, int target, int from, int to, int flags) {
		return of(arr, len, target, from, to, flags, 0);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return of(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return of(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index of given target
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to find
	 * @param from     inclusive index
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 * @see CharsLoop
	 */
	public int of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return CharsLoop.INDEX_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m, cps);
	}

	// ============
	// index-of but-not
	// ============

	/**
	 * @see #ofButNot(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofButNot(char[] arr, int len, int target) {
		return ofButNot(arr, len, target, 0);
	}

	/**
	 * @see #ofButNot(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofButNot(char[] arr, int len, int target, int from) {
		return ofButNot(arr, len, target, from, len);
	}

	/**
	 * @see #ofButNot(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofButNot(char[] arr, int len, int target, int from, int to) {
		return ofButNot(arr, len, target, from, to, 0);
	}

	/**
	 * @see #ofButNot(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags) {
		return ofButNot(arr, len, target, from, to, flags, 0);
	}

	/**
	 * @see #ofButNot(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return ofButNot(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
	}

	/**
	 * @see #ofButNot(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofButNot(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index of anything, but not given target
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to not-find
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_NOT_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return CharsLoop.INDEX_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m, cps);
	}

	// ============
	// index-of-any
	// ============

	/**
	 * @see #ofAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAny(char[] arr, int len, int[] targets) {
		return ofAny(arr, len, targets, 0);
	}

	/**
	 * @see #ofAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAny(char[] arr, int len, int[] targets, int from) {
		return ofAny(arr, len, targets, from, len);
	}

	/**
	 * @see #ofAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAny(char[] arr, int len, int[] targets, int from, int to) {
		return ofAny(arr, len, targets, from, to, 0);
	}

	/**
	 * @see #ofAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return ofAny(arr, len, targets, from, to, flags, 0);
	}

	/**
	 * @see #ofAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #ofAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index of any target from given array
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param targets  targets to find any of them
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m, cps);
	}

	// ============
	// index-of-any but-not
	// ============

	/**
	 * @see #ofAnyButNot(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets) {
		return ofAnyButNot(arr, len, targets, 0);
	}

	/**
	 * @see #ofAnyButNot(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets, int from) {
		return ofAnyButNot(arr, len, targets, from, len);
	}

	/**
	 * @see #ofAnyButNot(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to) {
		return ofAnyButNot(arr, len, targets, from, to, 0);
	}

	/**
	 * @see #ofAnyButNot(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return ofAnyButNot(arr, len, targets, from, to, flags, 0);
	}

	/**
	 * @see #ofAnyButNot(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
	}

	/**
	 * @see #ofAnyButNot(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index of anything, but not from given array
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param targets  targets to not-find
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_NOT_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		return CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m, cps);
	}

	// ============
	// index-of end
	// ============

	/**
	 * @see #ofEnd(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofEnd(char[] arr, int len, int target) {
		return ofEnd(arr, len, target, 0);
	}

	/**
	 * @see #ofEnd(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofEnd(char[] arr, int len, int target, int from) {
		return ofEnd(arr, len, target, from, len);
	}

	/**
	 * @see #ofEnd(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofEnd(char[] arr, int len, int target, int from, int to) {
		return ofEnd(arr, len, target, from, to, 0);
	}

	/**
	 * @see #ofEnd(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofEnd(char[] arr, int len, int target, int from, int to, int flags) {
		return ofEnd(arr, len, target, from, to, flags, 0);
	}

	/**
	 * @see #ofEnd(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofEnd(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return ofEnd(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #ofEnd(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofEnd(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofEnd(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index-of-end for given target, index-of-end is the last index in
	 * sequence for given target, e.g: codes.jjjjava, if target is j, index = 6, and
	 * index-of-end is 9
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to find
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofEnd(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		// ---------------------
		boolean visualLevel = Digits.ints.isFlagged(flags, Lang.constant.FLAG_RETURN_VISUAL_LEVEL);
		int flags0 = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE)
				? Lang.constant.FLAG_ALWAYS_IGNORE_CASE
				: 0;
		int index = CharsLoop.INDEX_OF.codePoint(arr, len, from, to, target, flags0, fromDisp, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return Lang.constant.INDEX_NOT_FOUND;
		}

		fromDisp += cps.fixedPairsCount(arr, len, from, index);
		flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
		int count = CharsLoop.FORWARD_COUNT_OF.codePoint(arr, len, index, to, target, flags, fromDisp, m, cps);
		fromDisp += cps.isBmp(target) || !cps.isSupported() ? 0 : count;
		int end = (index + count * cps.lengthOf(target));
		return visualLevel ? end - fromDisp : end;
	}

	// ============
	// index-of-any end
	// ============

	/**
	 * @see #ofAnyEnd(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyEnd(char[] arr, int len, int[] targets) {
		return ofAnyEnd(arr, len, targets, 0);
	}

	/**
	 * @see #ofAnyEnd(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyEnd(char[] arr, int len, int[] targets, int from) {
		return ofAnyEnd(arr, len, targets, from, len);
	}

	/**
	 * @see #ofAnyEnd(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyEnd(char[] arr, int len, int[] targets, int from, int to) {
		return ofAnyEnd(arr, len, targets, from, to, 0);
	}

	/**
	 * @see #ofAnyEnd(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyEnd(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return ofAnyEnd(arr, len, targets, from, to, flags, 0);
	}

	/**
	 * @see #ofAnyEnd(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyEnd(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return ofAnyEnd(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #ofAnyEnd(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyEnd(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAnyEnd(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index-of-end for any of given targets, index-of-end is the last index in
	 * sequence for given target, e.g: codes.jjjxmava, if targets is [j, x, m],
	 * index = 6, and index-of-end is 7, will try to find first
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to find
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofAnyEnd(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		// ---------------------
		boolean visualLevel = Digits.ints.isFlagged(flags, Lang.constant.FLAG_RETURN_VISUAL_LEVEL);
		int flags0 = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE)
				? Lang.constant.FLAG_ALWAYS_IGNORE_CASE
				: 0;
		int index = CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags0, fromDisp, m,
				cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		int target = cps.getCodepoint(arr, len, index);
		fromDisp += cps.fixedPairsCount(arr, len, from, index);
		flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
		int count = CharsLoop.FORWARD_COUNT_OF.codePoints(arr, len, index, to, targets, targets.length, flags, fromDisp,
				m, cps);
		fromDisp += cps.isBmp(target) || !cps.isSupported() ? 0 : count;
		int end = (index + count * cps.lengthOf(target));
		return visualLevel ? end - fromDisp : end;
	}

	// ============
	// index-of linefeed
	// ============

	/**
	 * @see #ofLinefeed(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeed(char[] arr, int len) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS);
	}

	/**
	 * @see #ofLinefeed(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeed(char[] arr, int len, int from) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from);
	}

	/**
	 * @see #ofLinefeed(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeed(char[] arr, int len, int from, int to) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to);
	}

	/**
	 * @see #ofLinefeed(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeed(char[] arr, int len, int from, int to, int flags) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags);
	}

	/**
	 * @see #ofLinefeed(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp);
	}

	/**
	 * @see #ofLinefeed(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find index of any linefeed according to {@link LConstants#LINEFEEDS}
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

	// ============
	// index-of linefeed-end
	// ============

	/**
	 * @see #ofLinefeedEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeedEnd(char[] arr, int len) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS);
	}

	/**
	 * @see #ofLinefeedEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeedEnd(char[] arr, int len, int from) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from);
	}

	/**
	 * @see #ofLinefeedEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeedEnd(char[] arr, int len, int from, int to) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to);
	}

	/**
	 * @see #ofLinefeedEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeedEnd(char[] arr, int len, int from, int to, int flags) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags);
	}

	/**
	 * @see #ofLinefeedEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeedEnd(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp);
	}

	/**
	 * @see #ofLinefeedEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofLinefeedEnd(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find index-of-linefeed-end according to {@link LConstants#LINEFEEDS}, e.g:
	 * codes.|||abdullah, index-of-linefeed-end is 8
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofLinefeedEnd(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

	// ============
	// index-of whitespace
	// ============

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespace(char[] arr, int len) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespace(char[] arr, int len, int from) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespace(char[] arr, int len, int from, int to) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespace(char[] arr, int len, int from, int to, int flags) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find index of any whitespace according to {@link LConstants#WHITESPACES}
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

	// ============
	// index-of whitespace-end
	// ============

	/**
	 * @see #ofWhitespaceEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespaceEnd(char[] arr, int len) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS);
	}

	/**
	 * @see #ofWhitespaceEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespaceEnd(char[] arr, int len, int from) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from);
	}

	/**
	 * @see #ofWhitespaceEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespaceEnd(char[] arr, int len, int from, int to) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to);
	}

	/**
	 * @see #ofWhitespaceEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespaceEnd(char[] arr, int len, int from, int to, int flags) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags);
	}

	/**
	 * @see #ofWhitespaceEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespaceEnd(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp);
	}

	/**
	 * @see #ofWhitespaceEnd(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofWhitespaceEnd(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find index-of-whitespace-end according to {@link LConstants#WHITESPACES},
	 * e.g: codes.|||abdullah, index-of-whitespace-end is 8
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofWhitespaceEnd(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return ofAnyEnd(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

	// ============
	// index-of index [codepoint]
	// ============

	/**
	 * @see #ofIndex(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int target, int targetIndex) {
		return ofIndex(arr, len, target, targetIndex, 0);
	}

	/**
	 * @see #ofIndex(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int target, int targetIndex, int from) {
		return ofIndex(arr, len, target, targetIndex, from, len);
	}

	/**
	 * @see #ofIndex(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int target, int targetIndex, int from, int to) {
		return ofIndex(arr, len, target, targetIndex, from, to, 0);
	}

	/**
	 * @see #ofIndex(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int target, int targetIndex, int from, int to, int flags) {
		return ofIndex(arr, len, target, targetIndex, from, to, flags, 0);
	}

	/**
	 * @see #ofIndex(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int target, int targetIndex, int from, int to, int flags, int fromDisp) {
		return ofIndex(arr, len, target, targetIndex, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #ofIndex(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int target, int targetIndex, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofIndex(arr, len, target, targetIndex, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index-of-index of given target, e.g: codes.abdullah, indexes of <b>a</b>
	 * are 6 and 12, so we want to find second index of <b>a</b>, we can say target
	 * is <b>a</b> and targetIndex is 1, result is 12
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofIndex(char[] arr, int len, int target, int targetIndex, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int position = 0;
		while ((from = CharsLoop.INDEX_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m,
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
	// index-of index [targets]
	// ============

	/**
	 * @see #ofIndex(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex) {
		return ofIndex(arr, len, targets, targetIndex, 0);
	}

	/**
	 * @see #ofIndex(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex, int from) {
		return ofIndex(arr, len, targets, targetIndex, from, len);
	}

	/**
	 * @see #ofIndex(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex, int from, int to) {
		return ofIndex(arr, len, targets, targetIndex, from, to, 0);
	}

	/**
	 * @see #ofIndex(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex, int from, int to, int flags) {
		return ofIndex(arr, len, targets, targetIndex, from, to, flags, 0);
	}

	/**
	 * @see #ofIndex(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex, int from, int to, int flags, int fromDisp) {
		return ofIndex(arr, len, targets, targetIndex, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #ofIndex(char[], int, int[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofIndex(arr, len, targets, targetIndex, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index-of-index of any target, e.g: codes.abdullah, indexes of <b>a</b>
	 * are 6 and 12, so we want to find second index of <b>a</b>, we can say target
	 * is <b>a</b> and targetIndex is 1, result is 12
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     inclusive index,
	 * @param to       exclusive index
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int position = 0;
		while ((from = CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m,
				cps)) > Lang.constant.INDEX_NOT_FOUND) {
			if (position == targetIndex) {
				return from;
			}
			from++;
			position++;
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	
}
