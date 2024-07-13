package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.project.CodepointSupport;

class CharsMatcherMustNotEquals extends CharsMatcherMustEquals {

	@Override
	public boolean tryMatchBmp(char[] arr, int len, int index, int target, boolean ignoreCase, CodepointSupport cps) {
		return !super.tryMatchBmp(arr, len, index, target, ignoreCase, cps);
	}

	@Override
	public boolean tryMatchPair(char[] arr, int len, int index, char targetHigh, char targetLow,
			boolean ignoreCase, CodepointSupport cps) {
		return !super.tryMatchPair(arr, len, index, targetHigh, targetLow, ignoreCase, cps);
	}

	@Override
	public boolean tryMatchAny(char[] arr, int len, int index, int[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps) {
		return !super.tryMatchAny(arr, len, index, targets, targetsLen, ignoreCase, cps);
	}

	@Override
	public boolean tryMatchAny(char[] arr, int len, int index, char[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps) {
		return !super.tryMatchAny(arr, len, index, targets, targetsLen, ignoreCase, cps);
	}

	@Override
	public boolean tryMatchArray(char[] arr, int len, int index, char[] target, int targetLength, boolean ignoreCase,
			CodepointSupport cps) {
		if (!cps.equals(arr[index], target[0], ignoreCase)) {
			index++;
			int end = index + targetLength - 1;
			for (int targetIndex = 1; index < end
					&& !cps.equals(arr[index], target[targetIndex], ignoreCase); index++, targetIndex++)
				;

			if (index == end) {
				return true;
			}
		}
		return false;
	}

}
