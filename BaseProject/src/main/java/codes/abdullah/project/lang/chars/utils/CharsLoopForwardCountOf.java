package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

class CharsLoopForwardCountOf implements CharsLoop {

	@Override
	public int codePoints(char[] arr, int len, int from, int to, int[] targets, int targetsLen, int flags, int spcount,
			CharsMatcher m, CodepointSupport cps) {
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);
		int count = 0;
		for (; from < to; from++) {
			if (m.tryMatchAny(arr, len, from, targets, targetsLen, ignoreCase, cps)) {
				count++;
				if (cps.isPair(arr, to, from)) {
					from++;
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
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);
		int count = 0;
		for (; from < to; from++) {
			if (m.tryMatchAny(arr, len, from, targets, targetsLen, ignoreCase, cps)) {
				count++;
				if (cps.isPair(arr, to, from)) {
					from++;
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
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);

		int count = 0;
		if (cps.isBmp(target)) {
			for (; from < to; from++) {
				if (m.tryMatchBmp(arr, len, from, target, ignoreCase, cps)) {
					count++;
					continue;
				}
				if (countRepeatedOnly)
					break;
			}
		} else if (cps.isPair(target)) {
			final char thi = cps.toHigh(target);
			final char tlo = cps.toLow(target);
			for (; from < to; from++) {
				if (cps.isPair(arr, to, from) && m.tryMatchPair(arr, len, from, thi, tlo, ignoreCase, cps)) {
					count++;
					from++;
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
		final boolean ignoreCase = Digits.ints.isFlagged(flags, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		final boolean countRepeatedOnly = Digits.ints.isFlagged(flags, Lang.constant.FLAG_COUNT_REPEATED_ONLY);
		int count = 0;
		while (from < to) {
			if (m.tryMatchArray(arr, len, from, target, targetLength, ignoreCase, cps)) {
				count++;
				from += targetLength;
				continue;
			}
			if (countRepeatedOnly)
				break;
			from++;
		}
		return count;
	}

}
