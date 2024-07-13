package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.LConstants;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LSplit {
	LSplit() {

	}

	/**
	 * @see #by(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] by(char[] arr, int len, int target) {
		return by(arr, len, target, 0);
	}

	/**
	 * @see #by(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] by(char[] arr, int len, int target, int from) {
		return by(arr, len, target, from, len);
	}

	/**
	 * @see #by(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] by(char[] arr, int len, int target, int from, int to) {
		return by(arr, len, target, from, to, 0);
	}

	/**
	 * @see #by(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] by(char[] arr, int len, int target, int from, int to, int flags) {
		return by(arr, len, target, from, to, flags, 0);
	}

	/**
	 * @see #by(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] by(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return by(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #by(char[], int, int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] by(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return by(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 * Split given array by given target based on range<br>
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param target   target to use as splitter
	 * @param from     from index (inclusive)
	 * @param to       to index (exclusive)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return array of {@link CharArray} wrapper, in which every instance represent
	 *         line
	 * 
	 * @see CharArray
	 */
	public CharArray[] by(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		int[] indexes = Lang.codepoint.indexes.of(arr, len, target, from, to, flags, fromDisp, m, cps);
		if (indexes.length == 0)
			return new CharArray[0];
		CharArray[] cwa = new CharArray[indexes.length + 1];
		if (indexes.length == 0) {
			cwa[0] = CharArray.of(Lang.copy.of.this_(arr, len), len);
			return cwa;
		}
		int currentIndex = fromDisp + from, nextIndex = 0, outlen = 0, cwai = 0;
		int targetLen = cps.lengthOf(target);
		for (int i = 0; i < indexes.length; i++) {
			nextIndex = indexes[i];
			outlen = nextIndex - currentIndex;
			char[] out = Lang.chararray.newArray(outlen);
			out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
			cwa[cwai++] = CharArray.of(out, outlen);
			currentIndex = indexes[i] + targetLen;
		}

		currentIndex = indexes[indexes.length - 1] + targetLen;
		nextIndex = to;
		outlen = nextIndex - currentIndex;
		char[] out = Lang.chararray.newArray(outlen);
		out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
		cwa[cwai++] = CharArray.of(out, outlen);
		return cwa;
	}

	/**
	 * @see #byAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] byAny(char[] arr, int len, int[] targets) {
		return byAny(arr, len, targets, 0);
	}

	/**
	 * @see #byAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] byAny(char[] arr, int len, int[] targets, int from) {
		return byAny(arr, len, targets, from, len);
	}

	/**
	 * @see #byAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] byAny(char[] arr, int len, int[] targets, int from, int to) {
		return byAny(arr, len, targets, from, to, 0);
	}

	/**
	 * @see #byAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] byAny(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return byAny(arr, len, targets, from, to, flags, 0);
	}

	/**
	 * @see #byAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] byAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return byAny(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #byAny(char[], int, int[], int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] byAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return byAny(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 * Split given array by any target based on range<br>
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param targets  targets to use as splitters
	 * @param from     from index (inclusive)
	 * @param to       to index (exclusive)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return array of {@link CharArray} wrapper, in which every instance represent
	 *         line
	 * 
	 * @see CharArray
	 */
	public CharArray[] byAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		int[] indexes = Lang.codepoint.indexes.ofAny(arr, len, targets, from, to, flags, fromDisp, m, cps);
		if (indexes.length == 0) {
			return new CharArray[] { CharArray.of(arr, len) };
		}
		CharArray[] cwa = new CharArray[indexes.length + 1];
		if (indexes.length == 0) {
			cwa[0] = CharArray.of(Lang.copy.of.this_(arr, len), len);
			return cwa;
		}
		int currentIndex = fromDisp + from, nextIndex = 0, outlen = 0, cwai = 0;
		int targetLen = 0;
		for (int i = 0; i < indexes.length; i++) {
			nextIndex = indexes[i];
			outlen = nextIndex - currentIndex;
			targetLen = cps.lengthOf(arr, len, nextIndex);
			char[] out = Lang.chararray.newArray(outlen);
			out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
			cwa[cwai++] = CharArray.of(out, outlen);
			currentIndex = indexes[i] + targetLen;
		}

		currentIndex = indexes[indexes.length - 1] + targetLen;
		nextIndex = to;
		outlen = nextIndex - currentIndex;
		char[] out = Lang.chararray.newArray(outlen);
		out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
		cwa[cwai++] = CharArray.of(out, outlen);
		return cwa;
	}

	/**
	 * @see #linefeeds(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] linefeeds(char[] arr, int len) {
		return linefeeds(arr, len, 0);
	}

	/**
	 * @see #linefeeds(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] linefeeds(char[] arr, int len, int from) {
		return linefeeds(arr, len, from, len);
	}

	/**
	 * @see #linefeeds(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] linefeeds(char[] arr, int len, int from, int to) {
		return linefeeds(arr, len, from, to, 0);
	}

	/**
	 * @see #linefeeds(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags) {
		return linefeeds(arr, len, from, to, flags, 0);
	}

	/**
	 * @see #linefeeds(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return linefeeds(arr, len, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #linefeeds(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return linefeeds(arr, len, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS, CodepointSupport.BMP);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 * Split given array by any linefeed according to
	 * {@link LConstants#LINEFEEDS}<br>
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     from index (inclusive)
	 * @param to       to index (exclusive)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return array of {@link CharArray} wrapper, in which every instance represent
	 *         line
	 * 
	 * @see CharArray
	 */
	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return byAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

	/**
	 * @see #whitespcaces(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] whitespcaces(char[] arr, int len) {
		return whitespcaces(arr, len, 0);
	}

	/**
	 * @see #whitespcaces(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] whitespcaces(char[] arr, int len, int from) {
		return whitespcaces(arr, len, from, len);
	}

	/**
	 * @see #whitespcaces(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] whitespcaces(char[] arr, int len, int from, int to) {
		return whitespcaces(arr, len, from, to, 0);
	}

	/**
	 * @see #whitespcaces(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags) {
		return whitespcaces(arr, len, from, to, flags, 0);
	}

	/**
	 * @see #whitespcaces(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return whitespcaces(arr, len, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @see #whitespcaces(char[], int, int, int, int, int, CharsMatcher,
	 *      CodepointSupport)
	 */
	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return whitespcaces(arr, len, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS, CodepointSupport.BMP);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 * Split given array by any whitespace according to
	 * {@link LConstants#WHITESPACES}<br>
	 * 
	 * @param arr      src array
	 * @param len      src length
	 * @param from     from index (inclusive)
	 * @param to       to index (exclusive)
	 * @param flags    see {@link LConstants} flags
	 * @param fromDisp in case invoker wants return value in visual-level, invoker
	 *                 must pass surrogate-pairs count before from index
	 * @param m        matcher type, by default {@link CharsMatcher#MUST_EQUALS}
	 * @param cps      codepoint support, by default {@link CodepointSupport#BMP}
	 * 
	 * @return array of {@link CharArray} wrapper, in which every instance represent
	 *         line
	 * 
	 * @see CharArray
	 */
	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return byAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

}
