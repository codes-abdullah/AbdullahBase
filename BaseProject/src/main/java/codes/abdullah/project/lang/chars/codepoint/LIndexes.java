package codes.abdullah.project.lang.chars.codepoint;

import java.util.ArrayList;
import java.util.List;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.LConstants;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LIndexes {
	LIndexes() {
	}

	// ============
	// indexes-of
	// ============

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] of(char[] arr, int len, int target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] of(char[] arr, int len, int target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] of(char[] arr, int len, int target, int from, int to) {
		return of(arr, len, target, from, to, 0);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] of(char[] arr, int len, int target, int from, int to, int flags) {
		return of(arr, len, target, from, to, flags, 0);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return of(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #of(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return of(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find all indexes of given target
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
	 * @return indexes array, or empty array if noting found
	 * @see CharsLoop
	 */
	public int[] of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		List<Integer> l = new ArrayList<Integer>();
		while ((from = CharsLoop.INDEX_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m,
				sps)) > Lang.constant.INDEX_NOT_FOUND) {
			l.add(from++);
		}
		return Lang.primitive.to.ints(l);
	}

	// ============
	// indexes-of any
	// ============

	public int[] ofAny(char[] arr, int len, int[] targets) {
		return ofAny(arr, len, targets, 0);
	}

	public int[] ofAny(char[] arr, int len, int[] targets, int from) {
		return ofAny(arr, len, targets, from, len);
	}

	public int[] ofAny(char[] arr, int len, int[] targets, int from, int to) {
		return ofAny(arr, len, targets, from, to, 0);
	}

	public int[] ofAny(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return ofAny(arr, len, targets, from, to, flags, 0);
	}

	public int[] ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int[] ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * Find all indexes of any target from given array
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
	 * @return indexes array, or empty array if noting found
	 */
	public int[] ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		List<Integer> l = new ArrayList<Integer>();
		while ((from = CharsLoop.INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m,
				sps)) > Lang.constant.INDEX_NOT_FOUND) {
			l.add(from++);
		}
		return Lang.primitive.to.ints(l);
	}

	// ============
	// index-of linefeed
	// ============

	/**
	 * {@link #ofLinefeed(char[], int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int[] ofLinefeed(char[] arr, int len) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS);
	}

	/**
	 * {@link #ofLinefeed(char[], int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int[] ofLinefeed(char[] arr, int len, int from) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from);
	}

	/**
	 * {@link #ofLinefeed(char[], int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int[] ofLinefeed(char[] arr, int len, int from, int to) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to);
	}

	/**
	 * {@link #ofLinefeed(char[], int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int[] ofLinefeed(char[] arr, int len, int from, int to, int flags) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags);
	}

	/**
	 * {@link #ofLinefeed(char[], int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int[] ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp);
	}

	/**
	 * {@link #ofLinefeed(char[], int, int, int, int, int, CharsMatcher, CodepointSupport)}
	 */
	public int[] ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find all indexes of any linefeed according to {@link LConstants#LINEFEEDS}
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
	 * @return indexes array, or empty array if noting found
	 */
	public int[] ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m, sps);
	}

	// ============
	// index-of whitespace
	// ============

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] ofWhitespace(char[] arr, int len) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] ofWhitespace(char[] arr, int len, int from) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] ofWhitespace(char[] arr, int len, int from, int to) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] ofWhitespace(char[] arr, int len, int from, int to, int flags) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp);
	}

	/**
	 * @see #ofWhitespace(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public int[] ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	/**
	 * Find all indexes of any whitespace according to
	 * {@link LConstants#WHITESPACES}
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
	 * @return indexes array, or empty array if noting found
	 */
	public int[] ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m, sps);
	}
}