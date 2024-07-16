package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.Check;
import codes.abdullah.project.lang.Lang;

public class LCodepoint {
	private static final LCodepoint codepoint = new LCodepoint();
	public final LIndex index = new LIndex();
	public final LLastIndex lastIndex = new LLastIndex();
	public final LIndexes indexes = new LIndexes();
	public final LRepeat repeat = new LRepeat();
	public final LFill fill = new LFill();
	public final LRemove remove = new LRemove();
	public final LSplit split = new LSplit();
	public final LMark mark = new LMark();
	public final LLength lengthOf = new LLength();
	public final LCount count = new LCount();
	public final LReplace replace = new LReplace();
	public final LSub sub = new LSub();
	public final LSwap swap = new LSwap();
	public final LBlock block = new LBlock();
	public final LColumn column = new LColumn();
	final int[] CHARS_WHITESPACES_CODEPOINTS = Lang.constant.WHITESPACES.getArray();
	final int[] CHARS_LINEFEEDS_CODEPOINTS = Lang.constant.LINEFEEDS.getArray();

	LCodepoint() {

	}

	public static LCodepoint getInstance() {
		return codepoint;
	}

	/**
	 * <br>
	 * <b>Extend/Shrink:</b> Applied<br>
	 * <b>Capacity:</b> By invoker<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> By invoker (must be before invoking this method)<br>
	 * <br>
	 * 
	 * @return the new length if shrink/expend being applied, or src length if
	 *         shrink/expend
	 */
	public int set(char[] arr, int len, int index, int cp, CodepointSupport cps) {
		// ======================
		// case#1: x -> codes
		// case#2: e -> codE1s = len--
		// case#3: E1 -> codes = len++
		// case#4: X1 -> codE1s
		// ======================
		Check.codePoint(cp, cps);
		if (cps.isBmp(cp) && cps.isPair(arr, len, index)) {
			// cas#2
			Lang.shrink.at(arr, len--, index, 1);
		} else if (cps.isPair(cp) && !cps.isPair(arr, len, index)) {
			// cas#3
			Lang.expand.at(arr, len++, index, 1);
		}
		// case#1&4
		setWithoutExpendOrShrink(arr, len, index, cp, cps);
		return len;
	}

	/**
	 * <br>
	 * <b>Extend/Shrink:</b> Applied<br>
	 * <b>Capacity:</b> By invoker<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> By invoker (must be before invoking this method)<br>
	 * <br>
	 * 
	 * @see Check#unsortedIndexes(int[], int)
	 * @see Check#codePoint(int, CodepointSupport)
	 */
	public CharArray set(char[] arr, int len, int[] indexes, int cp, CodepointSupport cps) {
		final boolean isPair = cps.isPair(cp);
		for (int i = indexes.length - 1; i >= 0; i--) {
			int index = indexes[i];
			Check.unsortedIndexes(indexes, i);
			Check.insertIndex(index, len);
			if (isPair && !cps.isPair(arr, len, index)) {
				arr = Lang.capacity.ensure(arr, len, len + 1);
			}
			len = Lang.codepoint.set(arr, len, index, cp, cps);
		}
		return CharArray.of(arr, len);
	}

	public CharArray setWithReindexing(char[] arr, int len, int[] indexes, int cp, CodepointSupport cps) {
		final boolean isPair = cps.isPair(cp);
		for (int i = indexes.length - 1; i >= 0; i--) {
			int index = indexes[i];
			Check.unsortedIndexes(indexes, i);
			Check.insertIndex(index, len);
			// ==============
			index = cps.reindex(arr, len, index);
			// ==============
			if (isPair && !cps.isPair(arr, len, index)) {
				arr = Lang.capacity.ensure(arr, len, len + 1);
			}
			len = Lang.codepoint.set(arr, len, index, cp, cps);
		}
		return CharArray.of(arr, len);
	}

	/**
	 * No extending/shrinking will be applied
	 */
	public void setWithoutExpendOrShrink(char[] arr, int len, int index, int cp, CodepointSupport cps) {
		if (cps.isBmp(cp)) {
			arr[index] = (char) cp;
		} else if (cps.isPair(cp)) {
			arr[index] = cps.toHigh(cp);
			arr[index + 1] = cps.toLow(cp);
		}
		Check.codePoint(cp, cps);
		// must never reach here
	}

	// ================
	// ================
	// ================
	// ================

	public static class LLength {
		private LLength() {

		}

		public int set(char[] arr, int len, int index, int cp, CodepointSupport cps) {
			return len - cps.lengthOf(arr, len, index) + cps.lengthOf(cp);
		}

		public int set(char[] arr, int len, int[] indexes, int cp, CodepointSupport cps) {
			int targetLength = cps.lengthOf(cp);
			int diff = 0;
			int newlen = len;
			for (int i = 0; i < indexes.length; i++) {
				diff = targetLength - cps.lengthOf(arr, len, indexes[i]);
				newlen += diff;
			}
			return newlen;
		}
	}

	/**
	 * this tool is a help tool for <b>stepping</b> concept <br>
	 * this tool will count surrogate-pairs and will extend while counting to help
	 * converting from visual-level to surrogate level<br>
	 * if given range contains no-surrogates, then the given <b>target</b> is return
	 * <br>
	 * <br>
	 * the tool supports backward-loop, i.e: codes.abdullah, from = 14, target = 7,
	 * this means backward look
	 * 
	 * @param from   offset to start
	 * @param target target visual-level index to convert to surrogate-level
	 */
	public int convertFromVisualLevelToSurrogateLevel(char[] arr, int innerlen, int from, int target, int flags,
			CodepointSupport cps) {
		if (!cps.isSupported()) {
			return target;
		}

		// --------------------
		// like str="codes.abdullah",from = 14, target 6, means backward search,
		// otherwise forward search
		// --------------------
		if (target < from) {
			while (--from > target) {
				if (cps.isPairIntersectly(arr, innerlen, from)) {
					target--;
				}
			}
			if (cps.isPairIntersectly(arr, innerlen, target)) {
				target--;
			}
		} else {
			while (++from < target) {
				if (cps.isPairIntersectly(arr, innerlen, from)) {
					target++;
				}
			}
			if (target < innerlen && cps.isPairIntersectly(arr, innerlen, target)) {
				target++;
			}
		}
		return target;
	}

	/**
	 * special tool for stepping, it helps to convert if step exceed max, i.e:
	 * codes.abdullah, steps = 16, will return -2
	 */
	//TODO: is this works right ??
	public int restep(int src_steps, int steps, int right_max, int left_max) {
		if (src_steps > 0) {
			// --------------------
			// if steps to right side -->>>
			// --------------------
			if (steps <= right_max) {
				// --------------------
				// if steps less than the end of right side (or equal)
				// ok, step
				// --------------------
			} else {
				// --------------------
				// if steps greater than the end of right side
				// drop the right side, and will remain how many steps on left side (fliped),
				// the (-1): for each full loop will add 1, remove it
				// i.e: 𐃄codes.{𐁕BD}ullah𐂽, steps = 8, right_max = 6, left_max = (-7), --->
				// will result = 1
				// --------------------
				steps = (steps - right_max) - 1;
				// --------------------
				// if we have left side, flip the current steps to represent negative steps, so
				// according to above: 1 + (-7) = -6
				// --------------------
				if (left_max < 0) {
					steps = steps + left_max;
				}
			}
		} else {
			// --------------------
			// >>>> here steps will be a negative <<<<
			// if steps to left side <<<--
			// i.e: 𐃄codes.{𐁕BD}ullah𐂽, steps = -3, right_max = 6, left_max = (-7), OK we
			// are inside the range
			// --------------------
			if (steps >= left_max) {
				// ok, step
			} else {
				// --------------------
				// i.e: 𐃄codes.{𐁕BD}ullah𐂽, steps = -10, right_max = 6, left_max = (-7),
				// -----> will result: (-2)
				// --------------------
				steps = (steps - left_max) + 1;
				// --------------------
				// flip: (-2) + 6 = 4
				// --------------------
				if (right_max > 0) {
					steps = steps + right_max;
				}
			}
		}
		return steps;
	}

}
