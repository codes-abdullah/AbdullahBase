package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public class LFill {
	LFill() {
	}

	/**
	 * fill at the given offset based on given code-points range with a separator
	 * between each two filled code-points
	 * 
	 * @param separatorCodePoint 0 (null) to skip it <br>
	 *                           <b>default</b> fillLength = -1, means just fill as
	 *                           range, e.g: from '0' to ':' means fill from 0 to 9
	 *                           <br>
	 *                           <b>default</b> randomize = false <br>
	 *                           <b>default</b> insertAt = {@link #length()}
	 */
	public char[] in(char[] arr, int innerlen, int fromCodePoint, int toCodePoint, int fillLength, int insertAt,
			boolean randomize, CodepointSupport sps) {
		if (randomize) {
			// ------------------
			// randomize both bmp and supplementary is possible, but for a unknown length,
			// it's long and heavy ops to reallocate and recopy in each loop
			// ------------------
			if (toCodePoint >= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
				if (fromCodePoint <= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
					throw new IllegalArgumentException(
							"can't randomize fill between bmp and supplementary, do it in two different ops");
				}
			}
		}

		if (toCodePoint - fromCodePoint == 1) {
			int additionLength = sps.isBmp(fromCodePoint) ? fillLength : fillLength * 2;
			Check.length(additionLength, 1, Lang.constant.ARRAY_SAFE_CAPACITY - innerlen);
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + additionLength);
			arr = Lang.expand.at(arr, innerlen, insertAt, additionLength);
			if (sps.isBmp(fromCodePoint)) {
				char ch = (char) fromCodePoint;
				for (int i = 0; i < additionLength; i++) {
					arr[insertAt++] = ch;
				}
				return arr;
			} else if (sps.isPair(fromCodePoint)) {
				char hch = sps.toHigh(fromCodePoint);
				char lch = sps.toLow(fromCodePoint);
				for (int i = 0; i < fillLength; i++) {
					arr[insertAt++] = hch;
					arr[insertAt++] = lch;
				}
				return arr;
			}
			Check.codePoint(fromCodePoint, sps);
			return null;// must never reach here
		}

		fillLength = fillLength == -1 ? toCodePoint - fromCodePoint : fillLength;
		Check.length(fillLength, 1, Lang.constant.ARRAY_SAFE_CAPACITY - innerlen);
		int addition = sps.lengthOf(fromCodePoint) * fillLength;
		if (fromCodePoint >= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
			addition *= 2;
		} else if (toCodePoint >= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
			int spc_addition = (toCodePoint - Character.MIN_SUPPLEMENTARY_CODE_POINT);
			addition += spc_addition;
		}

		int newinnerlen = addition + innerlen;
		arr = Lang.capacity.ensure(arr, innerlen, newinnerlen);
		arr = Lang.expand.at(arr, innerlen, insertAt, addition);
		int target = 0;
		final int srcFromCodePoint = fromCodePoint;
		for (int i = 0; i < fillLength; i++) {
			target = randomize ? Digits.ints.random(fromCodePoint, toCodePoint) : fromCodePoint;
			insertAt += sps.toCharArray(target, arr, innerlen, insertAt);
			fromCodePoint = ++fromCodePoint == toCodePoint ? srcFromCodePoint : fromCodePoint;
		}
		return arr;
	}
}
