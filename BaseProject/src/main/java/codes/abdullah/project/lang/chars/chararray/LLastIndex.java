package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LLastIndex {

		 LLastIndex() {

		}

		// ============
		// last-index-of
		// ============

		public int of(char[] arr, int len, char[] target, int targetLen) {
			return of(arr, len, target, targetLen, 0);
		}

		public int of(char[] arr, int len, char[] target, int targetLen, int from) {
			return of(arr, len, target, targetLen, from, len);
		}

		public int of(char[] arr, int len, char[] target, int targetLen, int from, int to) {
			return of(arr, len, target, targetLen, from, to, 0);
		}

		public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
			return of(arr, len, target, targetLen, from, to, flags, 0);
		}

		public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp) {
			return of(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
		}

		public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
				CharsMatcher m) {
			return of(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
		}

		public int of(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
				CharsMatcher m, CodepointSupport sps) {
			return CharsLoop.LAST_INDEX_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m, sps);
		}

		// ============
		// last-index-of but-not
		// ============

		public int ofButNot(char[] arr, int len, char[] target, int targetLen) {
			return ofButNot(arr, len, target, targetLen, 0);
		}

		public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from) {
			return ofButNot(arr, len, target, targetLen, from, len);
		}

		public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to) {
			return ofButNot(arr, len, target, targetLen, from, to, 0);
		}

		public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
			return ofButNot(arr, len, target, targetLen, from, to, flags, 0);
		}

		public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags,
				int fromDisp) {
			return ofButNot(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
		}

		public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags,
				int fromDisp, CharsMatcher m) {
			return ofButNot(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
		}

		public int ofButNot(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags,
				int fromDisp, CharsMatcher m, CodepointSupport sps) {
			return CharsLoop.LAST_INDEX_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m, sps);
		}

		// ============
		// last-index-of-any
		// ============

		public int ofAny(char[] arr, int len, char[] targets) {
			return ofAny(arr, len, targets, 0);
		}

		public int ofAny(char[] arr, int len, char[] targets, int from) {
			return ofAny(arr, len, targets, from, len);
		}

		public int ofAny(char[] arr, int len, char[] targets, int from, int to) {
			return ofAny(arr, len, targets, from, to, 0);
		}

		public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags) {
			return ofAny(arr, len, targets, from, to, flags, 0);
		}

		public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp) {
			return ofAny(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
		}

		public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
				CharsMatcher m) {
			return ofAny(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
		}

		public int ofAny(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
				CodepointSupport sps) {
			return CharsLoop.LAST_INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp,
					m, sps);
		}

		// ============
		// last-index-of-any but-not
		// ============

		public int ofAnyButNot(char[] arr, int len, char[] targets) {
			return ofAnyButNot(arr, len, targets, 0);
		}

		public int ofAnyButNot(char[] arr, int len, char[] targets, int from) {
			return ofAnyButNot(arr, len, targets, from, len);
		}

		public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to) {
			return ofAnyButNot(arr, len, targets, from, to, 0);
		}

		public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags) {
			return ofAnyButNot(arr, len, targets, from, to, flags, 0);
		}

		public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp) {
			return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
		}

		public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
				CharsMatcher m) {
			return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
		}

		public int ofAnyButNot(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
				CharsMatcher m, CodepointSupport sps) {
			return CharsLoop.LAST_INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp,
					m, sps);
		}

		// ============
		// last-index-of begin
		// ============

		public int ofBegin(char[] arr, int len, char[] target, int targetLen) {
			return ofBegin(arr, len, target, targetLen, 0);
		}

		public int ofBegin(char[] arr, int len, char[] target, int targetLen, int from) {
			return ofBegin(arr, len, target, targetLen, from, len);
		}

		public int ofBegin(char[] arr, int len, char[] target, int targetLen, int from, int to) {
			return ofBegin(arr, len, target, targetLen, from, to, 0);
		}

		public int ofBegin(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
			return ofBegin(arr, len, target, targetLen, from, to, flags, 0);
		}

		public int ofBegin(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags,
				int fromDisp) {
			return ofBegin(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
		}

		public int ofBegin(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
				CharsMatcher m) {
			return ofBegin(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
		}

		public int ofBegin(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
				CharsMatcher m, CodepointSupport sps) {
			flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
			int count = CharsLoop.BACKWARD_COUNT_OF.array(arr, len, from, to, target, targetLen, flags, 0,
					CharsMatcher.MUST_EQUALS, sps);
			// targetLength must be excluded after multiplication
			// e.g: codes.javajava{java}abdullah
			return from - (targetLen * count - targetLen);
		}

		// ============
		// index-of-any begin
		// ============

		public int ofAnyBegin(char[] arr, int len, char[] targets) {
			return ofAnyBegin(arr, len, targets, 0);
		}

		public int ofAnyBegin(char[] arr, int len, char[] targets, int from) {
			return ofAnyBegin(arr, len, targets, from, len);
		}

		public int ofAnyBegin(char[] arr, int len, char[] targets, int from, int to) {
			return ofAnyBegin(arr, len, targets, from, to, 0);
		}

		public int ofAnyBegin(char[] arr, int len, char[] targets, int from, int to, int flags) {
			return ofAnyBegin(arr, len, targets, from, to, flags, 0);
		}

		public int ofAnyBegin(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp) {
			return ofAnyBegin(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
		}

		public int ofAnyBegin(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
				CharsMatcher m) {
			return ofAnyBegin(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
		}

		public int ofAnyBegin(char[] arr, int len, char[] targets, int from, int to, int flags, int fromDisp,
				CharsMatcher m, CodepointSupport sps) {
			int lastIndex = CharsLoop.LAST_INDEX_OF.codePoints(arr, len, from, to, targets, targets.length, flags,
					fromDisp, m, sps);
			if (lastIndex == Lang.constant.INDEX_NOT_FOUND) {
				return Lang.constant.INDEX_NOT_FOUND;
			}
			// -------------
			// e.g: src = xrcccE3E3E3sX4, targets = {a, E3, c}
			// lastIndex = 9, targetLen = 2, count = 3
			// beginIndex = (9 + 2) - (3 * 2)
			// -------------
			flags = flags | Lang.constant.FLAG_COUNT_REPEATED_ONLY;
			int target = sps.toCodepoint(arr, len, lastIndex);
			int targetLen = sps.lengthOf(target);
			int count = CharsLoop.BACKWARD_COUNT_OF.codePoint(arr, len, lastIndex, to, target, flags, 0, m, sps);
			int beginIndex = (lastIndex + targetLen) - (count * targetLen);
			fromDisp = sps.extendablePairsCount(arr, len, 0, beginIndex);
			return beginIndex - fromDisp;
		}

		// ============
		// index-of index
		// ============

		public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex) {
			return ofIndex(arr, len, target, targetLen, targetIndex, 0);
		}

		public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from) {
			return ofIndex(arr, len, target, targetLen, targetIndex, from, len);
		}

		public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to) {
			return ofIndex(arr, len, target, targetLen, targetIndex, from, to, 0);
		}

		public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to,
				int flags) {
			return ofIndex(arr, len, target, targetLen, targetIndex, from, to, flags, 0);
		}

		public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to,
				int flags, int fromDisp) {
			return ofIndex(arr, len, target, targetLen, targetIndex, from, to, flags, fromDisp,
					CharsMatcher.MUST_EQUALS);
		}

		public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to,
				int flags, int fromDisp, CharsMatcher m) {
			return ofIndex(arr, len, target, targetLen, targetIndex, from, to, flags, fromDisp, m,
					CodepointSupport.BMP);
		}

		public int ofIndex(char[] arr, int len, char[] target, int targetLen, int targetIndex, int from, int to,
				int flags, int fromDisp, CharsMatcher m, CodepointSupport sps) {
			int position = 0;
			while ((from = CharsLoop.LAST_INDEX_OF.array(arr, len, from, to, target, targetLen, flags, fromDisp, m,
					sps)) > Lang.constant.INDEX_NOT_FOUND) {
				if (position == targetIndex) {
					fromDisp = sps.fixedPairsCount(arr, len, 0, from);
					return from - fromDisp;
				}
				from += targetLen;
				position++;
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

	}
