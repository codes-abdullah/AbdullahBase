package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Range;
import codes.abdullah.project.lang.Lang;

public class LBlock {
	LBlock() {

	}

	/**
	 * 
	 */
	public Range of(char[] arr, int len, char[] prefix, int pLen, char[] suffix, int sLen, char[] esc, int eLen,
			int depth, int index, Range r, CodepointSupport cps) {
		int from = r.getFrom();
		int to = r.getTo();
		if (depth == 0) {
			if (index == 0)
				return r.assign(from, to);
			return r.assign(-1, -1);
		}
		int currentDepth = 0, currentIndex = -1;
		int start = 0;
		int end = 0;
		int l = 0;
		for (; from < to; from += l) {
			l = cps.lengthOf(arr, len, from);
			if (eLen > 0 && Lang.chararray.starts.with(arr, len, from, esc, eLen, false)) {
				// e.g: |\A1a, | is the pointer, -> \|A1a
				// and make l = to A1 length for next increment
				from += eLen;
				l = cps.lengthOf(arr, len, from);
				continue;
			}

			if (Lang.chararray.starts.with(arr, len, from, prefix, pLen, false)) {
				currentDepth++;
				if (currentDepth == depth) {
					start = from + pLen;
					from = start - l;

				}
				continue;
			}

			if (Lang.chararray.starts.with(arr, len, from, suffix, sLen, false)) {
				if (currentDepth == depth) {
					currentIndex++;
					currentDepth--;
					end = from;

					if (currentIndex == index) {
						return r.assign(start, end);
					}
					continue;
				}
				currentDepth--;
			}
		}
		return r.assign(-1, -1);
	}

}
