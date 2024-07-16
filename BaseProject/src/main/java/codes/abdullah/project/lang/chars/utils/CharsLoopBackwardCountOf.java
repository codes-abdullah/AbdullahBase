package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.Lang;

class CharsLoopBackwardCountOf implements CharsLoop {

	@Override
	public int codePoints(char[] arr, int len, int from, int to, int[] targets, int targetsLen, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps) {
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		to = Math.min(to, len);
		int count = 0;
		for (int i = to - 1; i >= from; i--) {
			if (m.tryMatchAny(arr, to, i, targets, targetsLen, ignoreCase, cps)) {
				count++;
				if (cps.isPairIntersectly(arr, to, i)) {
					i--;
				}
				continue;
			}
			if (countRepeatedOnly)
				break;
		}
		return count;
	}

	@Override
	public int codePoints(char[] arr, int len, int from, int to, char[] targets, int targetsLen, int flags,
			int spcount, CharsMatcher m, CodepointSupport cps) {
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		to = Math.min(to, len);
		int count = 0;
		for (int i = to - 1; i >= from; i--) {
			if (m.tryMatchAny(arr, to, i, targets, targetsLen, ignoreCase, cps)) {
				count++;
				if (cps.isPairIntersectly(arr, to, i)) {
					i--;
				}
				continue;
			}
			if (countRepeatedOnly)
				break;
		}
		return count;
	}

	@Override
	public int codePoint(char[] arr, int len, int from, int to, int target, int flags, int spcount, CharsMatcher m,
			CodepointSupport cps) {
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		to = Math.min(to, len);
		int count = 0;
		if (cps.isBmp(target)) {
			for (int i = to - 1; i >= from; i--) {
				if (m.tryMatchBmp(arr, to, i, target, ignoreCase, cps)) {
					count++;
					continue;
				}
				if (countRepeatedOnly)
					break;
			}
		} else if (cps.isValid(target)) {
			final char thi = cps.toHigh(target);
			final char tlo = cps.toLow(target);
			for (int i = to - 1; i >= from; i--) {
				if (m.tryMatchPair(arr, to, i, thi, tlo, ignoreCase, cps)) {
					count++;
					i--;
					continue;
				}
				if (countRepeatedOnly)
					break;
			}
		}
		return count;
	}

	@Override
	public int array(char[] arr, int len, int from, int to, char[] target, int targetLength, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps) {
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		to = Math.min(to, len);
		int count = 0;
		for (int i = (to - targetLength); i >= from; i--) {
			if (m.tryMatchArray(arr, to, i, target, targetLength, ignoreCase, cps)) {
				count++;
				i -= (targetLength - 1);
				continue;
			}
			if (countRepeatedOnly)
				break;
		}
		return count;
	}

}
