package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.project.lang.Lang;

public class LSwap {
	LSwap() {

	}

	public char[] with(char[] arr, int len, int leftIndex, int leftLength, int rightIndex, int rightLength) {
		if (leftLength == 1 && rightLength == 1) {
			return Lang.codepoint.swap.with(arr, len, leftIndex, rightIndex);
		}		
		// =======================
		// case1: codes.abdullah
		// case2: codXXs.abdullXXh
		// case3: codXXs.abdullah
		// case4: codes.abdullXXh
		
		// =======================
		// case-1 and case-2
		if (leftLength == rightLength) {
			while (leftLength-- != 0) {
				arr = Lang.swap.with(arr, len, leftIndex++, rightIndex++);
			}
			return arr;
		}

		int midLength = rightIndex - (leftIndex + leftLength);
		if (midLength == 0) {
			// [java2se-.-][c++]
			// java2se-.-c++
			// c++java2se-.-
			char[] left = Lang.copy.of.this_(arr, len, leftIndex, leftIndex + leftLength);
			char[] right = Lang.copy.of.this_(arr, len, rightIndex, rightIndex + rightLength);

			int pointer = 0;
			arr = Lang.copy.to.that(right, right.length, arr, len, 0, right.length, pointer);
			pointer += right.length;
			arr = Lang.copy.to.that(left, left.length, arr, len, 0, left.length, pointer);
			return arr;
		}

		// [java2se]-.-[c++]
		// java2se-.-c++
		// c++-.-java2se
		char[] left = Lang.copy.of.this_(arr, len, leftIndex, leftIndex + leftLength);
		char[] mid = Lang.copy.of.this_(arr, len, leftIndex + leftLength, rightIndex);
		char[] right = Lang.copy.of.this_(arr, len, rightIndex, rightIndex + rightLength);

		int pointer = 0;
		arr = Lang.copy.to.that(right, right.length, arr, len, 0, right.length, pointer);
		pointer += right.length;
		arr = Lang.copy.to.that(mid, mid.length, arr, len, 0, mid.length, pointer);
		pointer += mid.length;
		arr = Lang.copy.to.that(left, left.length, arr, len, 0, left.length, pointer);
		return arr;
	}
}
