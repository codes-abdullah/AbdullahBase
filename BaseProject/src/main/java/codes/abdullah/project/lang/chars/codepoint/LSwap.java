package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public class LSwap {
	LSwap() {

	}
	
	public char[] with(char[] arr, int len, int leftIndex, int rightIndex) {
		return with(arr, len, leftIndex, rightIndex, CodepointSupport.BMP);
	}

	/**
	 * Swap with help with {@link CodepointSupport}<br>
	 * 
	 * @param cps if {@link CodepointSupport#isSupported()} returns false, will
	 *            invoke {@link #with(char[], int, int, int)} using provided read
	 *            endian to correct indexes
	 */
	public char[] with(char[] arr, int len, int leftIndex, int rightIndex, CodepointSupport cps) {
		if (!cps.isSupported()) {
			return Lang.swap.with(arr, len, leftIndex, rightIndex);
		}
		final int l0 = leftIndex, r0 = rightIndex;
		// =======================
		// case1: codes.abdullah
		// case2: codXXs.abdullXXh
		// case3: codXXs.abdullah
		// case4: codes.abdullXXh
		int leftLength = cps.lengthOf(arr, len, l0);
		int rightLength = cps.lengthOf(arr, len, r0);
		// case-1 and case-2
		if (leftLength == rightLength) {
			while (leftLength-- != 0) {
				arr = Lang.swap.with(arr, len, leftIndex++, rightIndex++);
			}
			return arr;
		}

		// case-3:
		if (leftLength > rightLength) {
			// e.g: codXXs.abdullah, left = 3, right = 13
			final char h = arr[leftIndex], l = arr[leftIndex + 1];
			// before: cod{XXs.abdulla}h
			// after:: cod{Xs.abdulla0}h (for LITTLE with -1, <-)
			// after:: cod{Xs.abdulla0}h (for BIG with 1 <-)
			arr = Lang.displace.squash.in(arr, len, -1, l0, r0 + 1);
			// cod{as.abdulla0}h
			arr[leftIndex] = arr[rightIndex - 1];
			// cod{as.abdullXX}h
			arr[rightIndex - 1] = h;
			arr[rightIndex] = l;
			return arr;
		}

		// case-4:
		// e.g: codes.abdullXXh, left = 3, right = 12
		final char h = arr[rightIndex], l = arr[rightIndex + 1];
		// before: cod{es.abdullXX}h (for LITTLE with 1, ->)
		// after:: cod{0es.abdullX}h (for BIG with -1, ->)
		arr = Lang.displace.squash.in(arr, len, 1, l0, r0 + 2);
		arr[rightIndex + 1] = arr[leftIndex + 1];
		arr[leftIndex] = h;
		arr[leftIndex + 1] = l;
		return arr;
	}
}
