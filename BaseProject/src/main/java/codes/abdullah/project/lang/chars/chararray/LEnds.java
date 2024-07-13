package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.Lang;

public class LEnds {
	LEnds() {

	}

	/**
	 * @see #with(char[], int, int, char[], int, boolean)
	 */
	public boolean with(char[] src, int len, int offset, char[] target, int targetLength) {
		return with(src, len, offset, target, targetLength, false);

	}

	/**
	 * @param offset (exclusive-right-index)
	 * @return true if ends with given target based on given offset
	 */
	public boolean with(char[] src, int len, int offset, char[] target, int targetLength, boolean ignoreCase) {
		if (offset - targetLength > len) {
			return false;
		}
		// --------------------
		// flip offset
		// the offset is exclusive, will turn it into inclusive by saying offset-1
		// --------------------
		offset = Digits.ints.flip(offset - 1, len);
		return Lang.chararray.starts.with(src, len, (len - targetLength) - offset, target, targetLength, ignoreCase);
	}
}
