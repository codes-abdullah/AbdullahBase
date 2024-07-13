package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LSplit {
	LSplit() {

	}

	public CharArray[] by(char[] arr, int len, char[] target, int targetLen) {
		return by(arr, len, target, targetLen, 0);
	}

	public CharArray[] by(char[] arr, int len, char[] target, int targetLen, int from) {
		return by(arr, len, target, targetLen, from, len);
	}

	public CharArray[] by(char[] arr, int len, char[] target, int targetLen, int from, int to) {
		return by(arr, len, target, targetLen, from, to, 0);
	}

	public CharArray[] by(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags) {
		return by(arr, len, target, targetLen, from, to, flags, 0);
	}

	public CharArray[] by(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags,
			int fromDisp) {
		return by(arr, len, target, targetLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public CharArray[] by(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return by(arr, len, target, targetLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public CharArray[] by(char[] arr, int len, char[] target, int targetLen, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport sps) {
		int[] indexes = Lang.chararray.indexes.of(arr, len, target, targetLen, from, to, flags, fromDisp, m, sps);
		if (indexes.length == 0)
			return new CharArray[0];
		CharArray[] cwa = new CharArray[indexes.length + 1];
		if (indexes.length == 0) {
			cwa[0] = CharArray.of(Lang.copy.of.this_(arr, len), len);
			return cwa;
		}
		int currentIndex = fromDisp + from, nextIndex = 0, outlen = 0, cwai = 0;
		for (int i = 0; i < indexes.length; i++) {
			nextIndex = indexes[i];
			outlen = nextIndex - currentIndex;
			char[] out = Lang.chararray.newArray(outlen);
			out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
			cwa[cwai++] = CharArray.of(out, outlen);
			currentIndex = indexes[i] + targetLen;
		}

		currentIndex = indexes[indexes.length - 1] + targetLen;
		nextIndex = to;
		outlen = nextIndex - currentIndex;
		char[] out = Lang.chararray.newArray(outlen);
		out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
		cwa[cwai++] = CharArray.of(out, outlen);
		return cwa;
	}

	public CharArray[] byAny(char[] arr, int len, char[] targets, int targetsLen) {
		return byAny(arr, len, targets, targetsLen, 0);
	}

	public CharArray[] byAny(char[] arr, int len, char[] targets, int targetsLen, int from) {
		return byAny(arr, len, targets, targetsLen, from, len);
	}

	public CharArray[] byAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to) {
		return byAny(arr, len, targets, targetsLen, from, to, 0);
	}

	public CharArray[] byAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags) {
		return byAny(arr, len, targets, targetsLen, from, to, flags, 0);
	}

	public CharArray[] byAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags,
			int fromDisp) {
		return byAny(arr, len, targets, targetsLen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public CharArray[] byAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags,
			int fromDisp, CharsMatcher m) {
		return byAny(arr, len, targets, targetsLen, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public CharArray[] byAny(char[] arr, int len, char[] targets, int targetsLen, int from, int to, int flags,
			int fromDisp, CharsMatcher m, CodepointSupport sps) {
		int[] indexes = Lang.chararray.indexes.ofAny(arr, len, targets, targetsLen, from, to, flags, fromDisp, m, sps);
		if (indexes.length == 0)
			return new CharArray[0];
		CharArray[] cwa = new CharArray[indexes.length + 1];
		if (indexes.length == 0)
			return new CharArray[0];
		if (indexes.length == 0) {
			cwa[0] = CharArray.of(Lang.copy.of.this_(arr, len), len);
			return cwa;
		}
		int currentIndex = fromDisp + from, nextIndex = 0, outlen = 0, cwai = 0;
		int targetLen = 0;
		for (int i = 0; i < indexes.length; i++) {
			nextIndex = indexes[i];
			outlen = nextIndex - currentIndex;
			targetLen = sps.lengthOf(arr, len, nextIndex);
			char[] out = Lang.chararray.newArray(outlen);
			out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
			cwa[cwai++] = CharArray.of(out, outlen);
			currentIndex = indexes[i] + targetLen;
		}

		currentIndex = indexes[indexes.length - 1] + targetLen;
		nextIndex = to;
		outlen = nextIndex - currentIndex;
		char[] out = Lang.chararray.newArray(outlen);
		out = Lang.copy.to.that(arr, len, out, outlen, currentIndex, nextIndex, 0);
		cwa[cwai++] = CharArray.of(out, outlen);
		return cwa;
	}
	
	
	public CharArray[] linefeeds(char[] arr, int len) {
		return linefeeds(arr, len, 0);
	}

	public CharArray[] linefeeds(char[] arr, int len, int from) {
		return linefeeds(arr, len, from, len);
	}

	public CharArray[] linefeeds(char[] arr, int len, int from, int to) {
		return linefeeds(arr, len, from, to, 0);
	}

	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags) {
		return linefeeds(arr, len, from, to, flags, 0);
	}

	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags,
			int fromDisp) {
		return linefeeds(arr, len, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return linefeeds(arr, len, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public CharArray[] linefeeds(char[] arr, int len, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport sps) {
		return Lang.codepoint.split.linefeeds(arr, len, from, to, flags, fromDisp, m, sps);
	}
	

	public CharArray[] whitespcaces(char[] arr, int len) {
		return whitespcaces(arr, len, 0);
	}

	public CharArray[] whitespcaces(char[] arr, int len, int from) {
		return whitespcaces(arr, len, from, len);
	}

	public CharArray[] whitespcaces(char[] arr, int len, int from, int to) {
		return whitespcaces(arr, len, from, to, 0);
	}

	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags) {
		return whitespcaces(arr, len, from, to, flags, 0);
	}

	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return whitespcaces(arr, len, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return whitespcaces(arr, len, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS, CodepointSupport.BMP);
	}

	public CharArray[] whitespcaces(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport sps) {
		return Lang.codepoint.split.whitespcaces(arr, len, from, to, flags, fromDisp, m, sps);
	}
}
