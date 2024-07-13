package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

 class CharsLoopIndexOf implements CharsLoop {

	@Override
	public int codePoints(char[] arr, int len, int from, int to, char[] targets, int targetsLen, int flags,
			int spcount, CharsMatcher m, CodepointSupport cps) {
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean visualLevel = Digits.ints.isFlagged(flags, Lang.constant.FLAG_RETURN_VISUAL_LEVEL);
		boolean matched = false;
		for (; from < to; from++) {
			// --------------------
			// use (to) as (len) for range limitation
			// --------------------
			if (cps.isPair(arr, to, from)) {
				// --------------------
				// lazy increment
				// --------------------
				spcount++;
			}

			matched = m.tryMatchAny(arr, len, from, targets, targetsLen, ignoreCase, cps);

			if (matched) {
				return visualLevel ? from - spcount : from;
			} else if (m.stopTrying())
				break;
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	@Override
	public int codePoints(char[] arr, int len, int from, int to, int[] targets, int targetsLen, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps) {
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean visualLevel = Digits.ints.isFlagged(flags, Lang.constant.FLAG_RETURN_VISUAL_LEVEL);
		boolean matched = false;
		for (; from < to; from++) {
			// --------------------
			// use (to) as (len) for range limitation
			// --------------------
			if (cps.isPair(arr, to, from)) {
				// --------------------
				// lazy increment
				// --------------------
				spcount++;
			}

			matched = m.tryMatchAny(arr, len, from, targets, targetsLen, ignoreCase, cps);

			if (matched) {
				return visualLevel ? from - spcount : from;
			} else if (m.stopTrying())
				break;
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	@Override
	public int codePoint(char[] arr, int len, int from, int to, int target, int flags, int spcount, CharsMatcher m,
			CodepointSupport cps) {
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean visualLevel = Digits.ints.isFlagged(flags, Lang.constant.FLAG_RETURN_VISUAL_LEVEL);
		boolean matched = false;
		if (cps.isBmp(target)) {
			for (; from < to; from++) {
				// --------------------
				// use (to) as (len) for range limitation
				// --------------------
				if (cps.isPair(arr, to, from)) {
					// --------------------
					// lazy increment
					// --------------------
					spcount++;
				}

				matched = m.tryMatchBmp(arr, len, from, target, ignoreCase, cps);

				if (matched) {
					return visualLevel ? from - spcount : from;
				} else if (m.stopTrying())
					break;
			}
		} else if (cps.isValid(target)) {
			final char thi = cps.toHigh(target);
			final char tlo = cps.toLow(target);
			for (; from < to; from++) {
				// --------------------
				// use (to) as (len) for range limitation
				// --------------------
				if (cps.isPair(arr, to, from)) {
					matched = m.tryMatchPair(arr, len, from, thi, tlo, ignoreCase, cps);
					if (matched) {
						return visualLevel ? from - spcount : from;
					}
					// lazy increment
					spcount++;
					// --------------------
					// since inside this block means a pair of surrogate, below to skip checking the
					// low-surrogate
					// --------------------
					from++;
				}

				if (!matched && m.stopTrying())
					break;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	@Override
	public int array(char[] arr, int len, int from, int to, char[] target, int targetLength, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps) {
		if (to - from < targetLength) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean visualLevel = Digits.ints.isFlagged(flags, Lang.constant.FLAG_RETURN_VISUAL_LEVEL);
		boolean matched = false;

		if (targetLength == 0) {
			return visualLevel ? from - spcount : from;
		}
		if (to - from < targetLength) {
			return Lang.constant.INDEX_NOT_FOUND;
		}

		final int max = (to - targetLength);
		for (; from <= max; from++) {
			matched = m.tryMatchArray(arr, len, from, target, targetLength, ignoreCase, cps);

			if (matched) {
				return visualLevel ? from - spcount : from;
			} else if (m.stopTrying())
				break;

			if (cps.isPair(arr, len, from)) {
				// --------------------
				// lazy increment
				// --------------------
				spcount++;
			}

		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

}
