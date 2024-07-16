package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Check;
import codes.abdullah.project.lang.Lang;

public class LRepeat {
	public final LRepeatLength lengthOf = new LRepeatLength();

	LRepeat() {
	}

	/**
	 * @see #after(char[], int, int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, int divider, int division) {
		return after(arr, len, divider, division, 1);
	}

	/**
	 * @see #after(char[], int, int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, int divider, int division, int repeat) {
		return after(arr, len, divider, division, repeat, 0);
	}

	/**
	 * @see #after(char[], int, int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, int divider, int division, int repeat, int from) {
		return after(arr, len, divider, division, repeat, from, len);
	}

	/**
	 * @see #after(char[], int, int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, int divider, int division, int repeat, int from, int to) {
		return after(arr, len, divider, division, repeat, from, to, lengthOf.lastPart(from, to, division));
	}

	/**
	 * @see #after(char[], int, int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, int divider, int division, int repeat, int from, int to, int last_part) {
		return after(arr, len, divider, division, repeat, from, to, last_part, false);
	}

	/**
	 * @see #after(char[], int, int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, int divider, int division, int repeat, int from, int to, int last_part,
			boolean reverse) {
		return after(arr, len, divider, division, repeat, from, to, last_part, reverse, 0);
	}

	/**
	 * @see #after(char[], int, int, int, int, int, int, int, boolean, int,
	 *      CodepointSupport)
	 */
	public char[] after(char[] arr, int len, int divider, int division, int repeat, int from, int to, int last_part,
			boolean reverse, int flags) {
		return after(arr, len, divider, division, repeat, from, to, last_part, reverse, flags, CodepointSupport.BMP);
	}

	/**
	 * 
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> expend applied<br>
	 * <b>Capacity:</b> By invoker (must have enough space for the size to be
	 * expended<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> By invoker<br>
	 * <br>
	 * Repeat given divider after each division and insert it<br>
	 * 
	 * e.g: arr = codes, divider = _, division = 2, repeat = 2, result ->
	 * co__de__s<br>
	 * 
	 * @param arr       src array
	 * @param len       src length
	 * @param divider   divider codepoint
	 * @param division  division in which will insert division after each
	 * @param repeat    count of repeat, by default = 1
	 * @param from      inclusive index
	 * @param to        exclusive index
	 * @param last_part after last division, some chars will be less than given
	 *                  division, in above example, division = 2, last-part = 1,
	 *                  this must not be calculated manually because it relays on
	 *                  range, best practice to use
	 *                  {@link LRepeatLength#lastPart(int, int, int)}
	 * @param reverse   if true, start from right to left, in above example, result
	 *                  -> c_od_es
	 */
	public char[] after(char[] arr, int len, int divider, int division, int repeat, int from, int to, int last_part,
			boolean reverse, int flags, CodepointSupport sps) {
		// ----------------------
		// rangelen = to - from (visual-level)
		// last_part, e.g: codes, division = 4, last part is 1 -> code_s
		// ----------------------
		final int injectionRepeatLength = sps.lengthOf(divider) * repeat;
		final boolean bmp = sps.isBmp(divider);
		final char c1 = (char) (bmp ? divider : sps.toHigh(divider));
		final char c2 = (char) (bmp ? 0 : sps.toLow(divider));
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
				Lang.expand.at(arr, len, from, injectionRepeatLength);
				for (int j = 0; j < repeat; j++) {
					arr[from++] = c1;
					if (!bmp) {
						arr[from++] = c2;
					}
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
	 * @see #in(char[], int, int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int target, int repeat) {
		return in(arr, len, target, repeat, len);
	}

	/**
	 * @see #in(char[], int, int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int target, int repeat, int insertAt) {
		return in(arr, len, target, repeat, insertAt, CodepointSupport.BMP);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> expend applied<br>
	 * <b>Capacity:</b> By invoker (must have enough space for the size to be
	 * expended<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> By invoker<br>
	 * <br>
	 * Repeat given target and insert it in insertAt<br>
	 * <b>Array capacity: </b> will be expended internally<br>
	 * e.g: arr = codes, target = A, repeat = 3, insertAt = 2, result ->
	 * coAAAdes<br>
	 * 
	 */
	public char[] in(char[] arr, int len, int target, int repeat, int insertAt, CodepointSupport sps) {
		int addition = (repeat * sps.lengthOf(target));
		// ------------------
		if (sps.isBmp(target)) {
			Lang.expand.at(arr, len, insertAt, repeat);
			char ch = (char) target;
			for (int i = 0; i < repeat; i++) {
				arr[insertAt++] = ch;
			}
			return arr;
		} else if (sps.isPair(target)) {
			Lang.expand.at(arr, len, insertAt, addition);
			char high = sps.toHigh(target);
			char low = sps.toLow(target);
			for (int i = 0; i < repeat; i++) {
				arr[insertAt++] = high;
				arr[insertAt++] = low;
			}
			return arr;
		}
		Check.codePoint(target, sps);
		return null;
	}

	// =================
	// =================
	// =================
	// =================
	// =================

	/**
	 * Calculate lengths of {@link LRepeat} tools
	 */
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
		public int after(char[] arr, int len, int divider, int division, int repeat, int from, int to, int last_part,
				boolean reverse, int flags, CodepointSupport sps) {
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
			final int each_divs_len = repeat * sps.lengthOf(divider);
			final int addition = (divs_count + leftover) * each_divs_len;
			return len + addition;
		}

		public int in(char[] arr, int len, int target, int repeat, int insertAt, CodepointSupport sps) {
			int addition = (repeat * sps.lengthOf(target));
			return len + addition;
		}

	}
}