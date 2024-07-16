package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public class LRepeat {
	/** Length tools */
	public final LRepeatLength lengthOf = new LRepeatLength();

	LRepeat() {

	}

	/**
	 * @see #after(char[], int, char[], int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division) {
		return after(arr, len, divider, dividerLen, division, 1);
	}

	/**
	 * @see #after(char[], int, char[], int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat) {
		return after(arr, len, divider, dividerLen, division, repeat, 0);
	}

	/**
	 * @see #after(char[], int, char[], int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat, int from) {
		return after(arr, len, divider, dividerLen, division, repeat, from, len);
	}

	/**
	 * @see #after(char[], int, char[], int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat, int from,
			int to) {
		return after(arr, len, divider, dividerLen, division, repeat, from, to, (to - from) % division);
	}

	/**
	 * @see #after(char[], int, char[], int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat, int from, int to,
			int last_part) {
		return after(arr, len, divider, dividerLen, division, repeat, from, to, last_part, false);
	}

	/**
	 * @see #after(char[], int, char[], int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat, int from, int to,
			int last_part, boolean reverse) {
		return after(arr, len, divider, dividerLen, division, repeat, from, to, last_part, reverse, 0);
	}

	/**
	 * @see #after(char[], int, char[], int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat, int from, int to,
			int last_part, boolean reverse, int flags) {
		return after(arr, len, divider, dividerLen, division, repeat, from, to, last_part, reverse, flags,
				CodepointSupport.BMP);
	}

	/**
	 * 
	 * Repeat given divider after each division, times given repeat count<br>
	 * <b>Expend/Shrink: </b>true<br>
	 * see-also:
	 * {@link LRepeatLength#after(char[], int, char[], int, int, int, int, int, int, boolean, int, CodepointSupport)}<br>
	 * see-also: {@link LRepeatLength#lastPart(int, int, int)}<br>
	 * <code>
	 * <pre>
	 * char[] arr = "codes.abdullah".toCharArray();
	 * int len = arr.length;
	 * int from = 0;
	 * int to = len;
	 * char[] divider = "_".toCharArray();
	 * int dividerLen = divider.length;
	 * int division = 4;
	 * int repeat = 1;
	 * boolean reverse = false;
	 * int flags = 0;
	 * CodepointSupport sps = CodepointSupport.DEBUG;
	 * int last_part = Lang.chararray.repeat.lengthOf.lastPart(from, to, division);
	 * int newlen = Lang.chararray.repeat.lengthOf.after(arr, len, divider, dividerLen, division, repeat, from, to,
	 * last_part, reverse, flags, sps);
	 * arr = Lang.capacity.ensure(arr, len, newlen);
	 * // ================
	 * int fromDisp = sps.extendablePairsCount(arr, len, 0, from);
	 * from += fromDisp;
	 * to += fromDisp;
	 * int toDisp = sps.extendablePairsCount(arr, len, from, to);
	 * to += toDisp;
	 * // ==============
	 * arr = Lang.chararray.repeat.after(arr, len, divider, dividerLen, division, repeat, from, to, last_part, reverse,
	 * 		flags, sps);
	 * System.out.println(new String(arr, 0, newlen));
	 * </pre>
	 * 
	 * </code>
	 * 
	 */
	public char[] after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat, int from, int to,
			int last_part, boolean reverse, int flags, CodepointSupport sps) {
		final int injectionRepeatLength = repeat * dividerLen;
		// --------------------
		// the divisionCounter the the most important key of this tool
		// for forward injection, e.g: 00001, -> 0000_1
		// and for reverse injection -> 0_0001
		// this can be achieved by manipulating divisionCounter
		// usually we start with 0, but for reverse, will start by (divider - last_part)
		// --------------------
		int divisionCounter = 0;
		// --------------------
		// e.g: codes.abdullah.java, reverse(true)
		// last_part= rangelen(19) % divider(4) = 3
		// expected: cod_es.a_bdul_lah._java
		// to get his expectation, we will do
		// divisionCounter(1) = divider(4) - last_part(3)
		// this is true only in reverse mode
		// --------------------
		if (reverse && last_part > 0) {
			divisionCounter = division - last_part;
		}

		for (; from < to;) {
			// --------------------
			// why divisionCounter > 0?
			// divisionCounter(0) % divider is always 0, to be able to do range injecting,
			// we need to make sure we will never do anything while divisionCounter = 0
			// --------------------
			if (divisionCounter > 0 && divisionCounter % division == 0 && from > 0) {
				arr = Lang.expand.at(arr, len, from, injectionRepeatLength);
				for (int j = 0; j < repeat; j++) {
					arr = Lang.copy.to.that(divider, dividerLen, arr, len, 0, dividerLen, from);
					from += dividerLen;
				}
				to += injectionRepeatLength;
				len += injectionRepeatLength;// enlarge
			}

			// use (to) as (len) for range limitation
			from += sps.lengthOf(arr, to, from);
			divisionCounter++;
		}
		return arr;
	}

	// =================
	// =================
	// =================
	// =================
	// =================

	/**
	 * @see #in(char[], int, char[], int, int, int)
	 */
	public char[] in(char[] arr, int len, char[] target, int targetLength, int repeat) {
		return in(arr, len, target, targetLength, repeat, len);
	}

	/**
	 * Repeat given target, times gievn repeat count and insert into src<br>
	 * <b>Expend/Shrink: </b>true<br>
	 * see-also: {@link LRepeatLength#in(char[], int, char[], int, int, int)}<br>
	 * 
	 * @see #lengthOf
	 */
	public char[] in(char[] arr, int len, char[] target, int targetLength, int repeat, int insertAt) {
		final int addition = (targetLength * repeat);
		arr = Lang.expand.at(arr, len, insertAt, addition);
		for (int i = 0; i < repeat; i++) {
			arr = Lang.copy.to.that(target, target.length, arr, arr.length, 0, targetLength, insertAt);
			insertAt += targetLength;
		}
		return arr;
	}

	// =================
	// =================
	// =================
	// =================
	// =================

	public static class LRepeatLength {

		private LRepeatLength() {

		}

		/**
		 * @param from must be visual
		 * @param to   must be visual
		 */
		public int lastPart(int from, int to, int division) {
			// ----------------------
			// last_part, e.g: codes, division = 4, last part is 1 -> code_s
			// ----------------------
			return (to - from) % division;
		}

		/**
		 * @param from must be visual
		 * @param to   must be visual
		 */
		public int after(char[] arr, int len, char[] divider, int dividerLen, int division, int repeat, int from,
				int to, int last_part, boolean reverse, int flags, CodepointSupport sps) {
			// ---------------------
			// leftover: for 2 group of sequences like 0000_1111, we will add 1 division
			// between them
			// e.g: division = 4, innerlen = 8, innerlen / division - 1 = 1
			// but if we have 1 more char, or any amount <= division(4), will add 1 more
			// division as
			// well like: 0000_1111_0
			// ---------------------
			final int rangelen = to - from;
			final int leftover = last_part > 0 ? 1 : 0;
			final int divs_count = (rangelen / division) - 1;
			final int each_divs_len = repeat * dividerLen;
			final int addition = (divs_count + leftover) * each_divs_len;
			return len + addition;
		}

		/**
		 * @param from must be visual
		 * @param to   must be visual
		 */
		public int in(char[] arr, int len, char[] target, int targetLength, int repeat, int insertAt) {
			return (targetLength * repeat) + len;
		}

	}
}
