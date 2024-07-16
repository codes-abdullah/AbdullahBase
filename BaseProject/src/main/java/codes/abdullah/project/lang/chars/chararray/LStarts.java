package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;

public class LStarts {
	LStarts() {

	}

	/**
	 * @see #with(char[], int, int, char[], int, boolean)
	 */
	public boolean with(char[] src, int len, int offset, char[] target, int targetLength) {
		return with(src, len, offset, target, targetLength, false);
	}

	/**
	 * @param offset (inclusive-left-index)
	 * @return true if starts with given target based on given offset
	 */
	public boolean with(char[] src, int len, int offset, char[] target, int targetLength, boolean ignoreCase) {
		if (src[offset] != target[0]) {
			return false;
		}
		int targetIndex = 0;
		while (--targetLength >= 0) {
			if (!CodepointSupport.BMP.equals(src[offset++], target[targetIndex++], ignoreCase)) {
				return false;
			}
		}
		return true;
	}
}
