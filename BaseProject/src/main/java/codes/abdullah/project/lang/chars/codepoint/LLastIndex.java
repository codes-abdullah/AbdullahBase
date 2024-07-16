package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.LConstants;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LLastIndex {

	LLastIndex() {

	}

	// ============
	// last-index-of
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
	 * Find last-index of given target
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to find
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
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
			CodepointSupport sps) {
		return CharsLoop.LAST_INDEX_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m, sps);
	}

	// ============
	// last-index-of but-not
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
	 * Find last-index of anything, but not given target
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to not-find
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_NOT_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return CharsLoop.LAST_INDEX_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m, sps);
	}

	// ============
	// last-index-of-any
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
	 * Find last-index of any target from given array
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param targets  targets to find any of them
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return CharsLoop.LAST_INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m, sps);
	}

	// ============
	// last-index-of-any but-not
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
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_NOT_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport sps) {
		return CharsLoop.LAST_INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m, sps);
	}

	// ============
	// last-index-of begin
	// ============

	/**
	 * {@link #ofBegin(char[], int, int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int ofBegin(char[] arr, int len, int target) {
		return ofBegin(arr, len, target, 0);
	}

	/**
	 * {@link #ofBegin(char[], int, int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int ofBegin(char[] arr, int len, int target, int from) {
		return ofBegin(arr, len, target, from, len);
	}

	/**
	 * {@link #ofBegin(char[], int, int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int ofBegin(char[] arr, int len, int target, int from, int to) {
		return ofBegin(arr, len, target, from, to, 0);
	}

	/**
	 * {@link #ofBegin(char[], int, int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int ofBegin(char[] arr, int len, int target, int from, int to, int flags) {
		return ofBegin(arr, len, target, from, to, flags, 0);
	}

	/**
	 * {@link #ofBegin(char[], int, int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int ofBegin(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return ofBegin(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * {@link #ofBegin(char[], int, int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int ofBegin(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofBegin(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index-of-begin for given target, index-of-begin is the first index in
	 * sequence for given target, e.g: codes.jjjjava, if target is j, last-index =
	 * 9, and index-of-begin is 6
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to find
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofBegin(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		int lastIndex = CharsLoop.LAST_INDEX_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m, sps);
		if (lastIndex == Lang.constant.INDEX_NOT_FOUND) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		// -------------
		// e.g: src = xrcccE3E3E3sX4, targets = {a, E3, c}
		// lastIndex = 9, targetLen = 2, count = 3
		// beginIndex = (9 + 2) - (3 * 2)
		// -------------
		flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
		int count = CharsLoop.BACKWARD_COUNT_OF.codePoint(arr, len, lastIndex, to, target, flags, fromDisp, m, sps);
		int targetLen = sps.lengthOf(target);
		int beginIndex = (lastIndex + targetLen) - (count * targetLen);
		fromDisp = sps.extendablePairsCount(arr, len, 0, beginIndex);
		return beginIndex - fromDisp;
	}

	// ============
	// index-of-any begin
	// ============

	/**
	 * @see #ofAnyBegin(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyBegin(char[] arr, int len, int[] targets) {
		return ofAnyBegin(arr, len, targets, 0);
	}

	/**
	 * @see #ofAnyBegin(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyBegin(char[] arr, int len, int[] targets, int from) {
		return ofAnyBegin(arr, len, targets, from, len);
	}

	/**
	 * @see #ofAnyBegin(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyBegin(char[] arr, int len, int[] targets, int from, int to) {
		return ofAnyBegin(arr, len, targets, from, to, 0);
	}

	/**
	 * @see #ofAnyBegin(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyBegin(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return ofAnyBegin(arr, len, targets, from, to, flags, 0);
	}

	/**
	 * @see #ofAnyBegin(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyBegin(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return ofAnyBegin(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #ofAnyBegin(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofAnyBegin(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofAnyBegin(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find index-of-begin for any of given targets, index-of-begin is the first
	 * index in sequence for given target, e.g: codes.jjjxmava, if targets is [j, x,
	 * m], index = 8, and index-of-begin is 6
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param targets  targets to find any of them
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofAnyBegin(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		int lastIndex = CharsLoop.LAST_INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp,
				m, sps);
		if (lastIndex == Lang.constant.INDEX_NOT_FOUND) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		// -------------
		// e.g: src = xrcccE3E3E3sX4, targets = {a, E3, c}
		// lastIndex = 9, targetLen = 2, count = 3
		// beginIndex = (9 + 2) - (3 * 2)
		// -------------
		flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
		int target = sps.toCodepoint(arr, len, lastIndex);
		int targetLen = sps.lengthOf(target);
		int count = CharsLoop.BACKWARD_COUNT_OF.codePoint(arr, len, lastIndex, to, target, flags, 0, m, sps);
		int beginIndex = (lastIndex + targetLen) - (count * targetLen);
		fromDisp = sps.extendablePairsCount(arr, len, 0, beginIndex);
		return beginIndex - fromDisp;
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
	 * Find last-index of any linefeed according to {@link LConstants#LINEFEEDS}
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m, sps);
	}

	// ============
	// index-of linefeed-begin
	// ============

	public int ofLinefeedBegin(char[] arr, int len) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS);
	}

	public int ofLinefeedBegin(char[] arr, int len, int from) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from);
	}

	public int ofLinefeedBegin(char[] arr, int len, int from, int to) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to);
	}

	public int ofLinefeedBegin(char[] arr, int len, int from, int to, int flags) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags);
	}

	public int ofLinefeedBegin(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp);
	}

	public int ofLinefeedBegin(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find last-index-of-linefeed-begin according to {@link LConstants#LINEFEEDS},
	 * e.g: codes.|||abdullah, index-of-linefeed-begin is 6
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofLinefeedBegin(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m, sps);
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
	 * Find last-index of any whitespace according to {@link LConstants#WHITESPACES}
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m, sps);
	}

	// ============
	// index-of whitespace-end
	// ============

	public int ofWhitespaceBegin(char[] arr, int len) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS);
	}

	public int ofWhitespaceBegin(char[] arr, int len, int from) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from);
	}

	public int ofWhitespaceBegin(char[] arr, int len, int from, int to) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to);
	}

	public int ofWhitespaceBegin(char[] arr, int len, int from, int to, int flags) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags);
	}

	public int ofWhitespaceBegin(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp);
	}

	public int ofWhitespaceBegin(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find last-index-of-whitespace-begin according to
	 * {@link LConstants#WHITESPACES}, e.g: codes.|||abdullah,
	 * last-index-of-whitespace-begin is 6
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofWhitespaceBegin(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return ofAnyBegin(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m, sps);
	}

	// ============
	// index-of index
	// ============

	/**
	 * @see #ofIndex(char[], int, int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int ofIndex(char[] arr, int len, int targetCodepoint, int targetIndex) {
		return ofIndex(arr, len, targetCodepoint, targetIndex, 0);
	}

	public int ofIndex(char[] arr, int len, int targetCodepoint, int targetIndex, int from) {
		return ofIndex(arr, len, targetCodepoint, targetIndex, from, len);
	}

	public int ofIndex(char[] arr, int len, int targetCodepoint, int targetIndex, int from, int to) {
		return ofIndex(arr, len, targetCodepoint, targetIndex, from, to, 0);
	}

	public int ofIndex(char[] arr, int len, int targetCodepoint, int targetIndex, int from, int to, int flags) {
		return ofIndex(arr, len, targetCodepoint, targetIndex, from, to, flags, 0);
	}

	public int ofIndex(char[] arr, int len, int targetCodepoint, int targetIndex, int from, int to, int flags,
			int fromDisp) {
		return ofIndex(arr, len, targetCodepoint, targetIndex, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofIndex(char[] arr, int len, int targetCodepoint, int targetIndex, int from, int to, int flags,
			int fromDisp, CharsMatcher m) {
		return ofIndex(arr, len, targetCodepoint, targetIndex, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find last-index-of-index of given target, e.g: codes.abdullah, indexes of
	 * <b>a</b> are 6 and 12, so we want to find second last-index of <b>a</b>, we
	 * can say target is <b>a</b> and targetIndex is 1, result is 6
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofIndex(char[] arr, int len, int targetCodepoint, int targetIndex, int from, int to, int flags,
			int fromDisp, CharsMatcher m, CodepointSupport sps) {
		int position = 0;
		while ((to = CharsLoop.LAST_INDEX_OF.codePoint(arr, len, from, to, targetCodepoint, flags, fromDisp, m,
				sps)) > Lang.constant.INDEX_NOT_FOUND) {
			if (position == targetIndex) {
				return to;
			}
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
	 * Find last-index-of-index of any target, e.g: codes.abdullah, indexes of
	 * <b>a</b> are 6 and 12, so we want to find second last-index of <b>a</b>, we
	 * can say target is <b>a</b> and targetIndex is 1, result is 6
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     exclusive index (right-side)
	 * @param to       inclusive index (left-side)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return index of target, or {@link LConstants#INDEX_NOT_FOUND}
	 */
	public int ofIndex(char[] arr, int len, int[] targets, int targetIndex, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport sps) {
		int position = 0;
		while ((to = CharsLoop.LAST_INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m,
				sps)) > Lang.constant.INDEX_NOT_FOUND) {
			if (position == targetIndex) {
				return to;
			}
			position++;
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

}
