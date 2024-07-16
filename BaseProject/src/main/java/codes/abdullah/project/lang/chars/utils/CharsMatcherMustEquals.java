package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.array.codepoints.support.CodepointSupport;

class CharsMatcherMustEquals implements CharsMatcher {

	CharsMatcherMustEquals() {

	}

	@Override
	public boolean stopTrying() {
		return false;
	}

	@Override
	public boolean tryMatchBmp(char[] arr, int len, int index, int target, boolean ignoreCase, CodepointSupport cps) {
		return cps.equals(arr, len, index, target, ignoreCase);
	}

	@Override
	public boolean tryMatchPair(char[] arr, int len, int index, char targetHigh, char targetLow,
			boolean ignoreCase, CodepointSupport cps) {
		return cps.equals(arr, len, index, targetHigh, targetLow, ignoreCase);
	}

	@Override
	public boolean tryMatchAny(char[] arr, int len, int index, int[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps) {
		int target = 0;
		for (int i = 0; i < targetsLen; i++) {
			target = targets[i];
			if (cps.isBmp(target)) {
				if (cps.equals(arr[index], target, ignoreCase))
					return true;
			} else if (cps.isPair(target) && (index + 1 < len)) {
				final char thi = cps.toHigh(target);
				final char tlo = cps.toLow(target);
				if (cps.equals(arr, len, index, thi, tlo, ignoreCase))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean tryMatchAny(char[] arr, int len, int index, char[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps) {
		for (int i = 0; i < targetsLen; i++) {
			if (cps.isBmp(targets[i])) {
				if (cps.equals(arr[index], targets[i], ignoreCase))
					return true;
			} else if (cps.isPair(targets, targetsLen, i)) {
				final char thi = cps.toHigh(targets, targetsLen, i);
				final char tlo = cps.toLow(targets, targetsLen, i);
				if (cps.equals(arr, len, index, thi, tlo, ignoreCase))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean tryMatchArray(char[] arr, int len, int index, char[] target, int targetLength, boolean ignoreCase,
			CodepointSupport cps) {
		if (cps.equals(arr[index], target[0], ignoreCase)) {
			index++;
			int fullMatchIndex = index + targetLength - 1;
			int end = Math.min(fullMatchIndex, len);
			for (int targetIndex = 1; index < end
					&& cps.equals(arr[index], target[targetIndex], ignoreCase); index++, targetIndex++)
				;
			return index == fullMatchIndex;
		}
		return false;
	}

}
