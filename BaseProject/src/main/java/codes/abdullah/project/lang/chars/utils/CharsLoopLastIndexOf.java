package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.Lang;

 class CharsLoopLastIndexOf implements CharsLoop {

	@Override
	public int codePoints(char[] arr, int len, int from, int to, char[] targets, int targetsLen, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps) {
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean visualLevel = Digits.ints.isFlagged(flags, Lang.constant.FLAG_RETURN_VISUAL_LEVEL);
		boolean matched = false;
		for (int i = to - 1; i >= from; i--) {
			if (cps.isPairIntersectly(arr, to, i)) {
				spcount--;
				i--;
			}

			matched = m.tryMatchAny(arr, len, i, targets, targetsLen, ignoreCase, cps);

			if (matched) {
				spcount = spcount < 0 ? 0 : spcount;
				return visualLevel ? i - spcount : i;
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
		for (int i = to - 1; i >= from; i--) {
			if (cps.isPairIntersectly(arr, to, i)) {
				spcount--;
				i--;
			}

			matched = m.tryMatchAny(arr, len, i, targets, targetsLen, ignoreCase, cps);

			if (matched) {
				spcount = spcount < 0 ? 0 : spcount;
				return visualLevel ? i - spcount : i;
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
			for (int i = to - 1; i >= from; i--) {
				if (cps.isPairIntersectly(arr, to, i)) {
					spcount--;
					i--;
				}

				matched = m.tryMatchBmp(arr, len, i, target, ignoreCase, cps);

				if (matched) {
					spcount = spcount < 0 ? 0 : spcount;
					return visualLevel ? i - spcount : i;
				} else if (m.stopTrying())
					break;
			}
		} else if (cps.isValid(target)) {
			final char thi = cps.toHigh(target);
			final char tlo = cps.toLow(target);
			for (int i = to - 1; i >= from; i--) {
				if (cps.isPairIntersectly(arr, to, i)) {
					matched = m.tryMatchPair(arr, len, i - 1, thi, tlo, ignoreCase, cps);
					if (matched) {
						// e.g: A1, index A|1, i-1, index |A1
						spcount = spcount < 0 ? 0 : spcount;
						return visualLevel ? (i - 1) - spcount : i;
					}
					spcount--;
					i--;
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
			return visualLevel ? to - spcount : to;
		}
		if (to - from < targetLength) {
			return Lang.constant.INDEX_NOT_FOUND;
		}

		for (int i = (to - targetLength); i >= from; i--) {
			matched = m.tryMatchArray(arr, len, i, target, targetLength, ignoreCase, cps);

			if (matched) {
				spcount = spcount < 0 ? 0 : spcount;
				return visualLevel ? i - spcount : i;
			} else if (m.stopTrying())
				break;

			if (cps.isPairIntersectly(arr, len, from)) {
				spcount--;
			}

		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

}
