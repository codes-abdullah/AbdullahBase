package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Endian;

public class LSkip {
	public final E e = new E();

	LSkip() {

	}

	/**
	 * Skip linefeeds according to {@link CodepointSupport#isLinefeed(int)} and
	 * return the new length (No shrink will be applied)
	 */
	public int linefeed(char[] arr, int len) {
		while (--len >= 0 && CodepointSupport.BMP.isLinefeed(arr[len]))
			;
		return len + 1;
	}

	/**
	 * Skip whilespaces according to {@link CodepointSupport#isWhitespace(int)} and
	 * return the new length (No shrink will be applied)
	 */
	public int whitespace(char[] arr, int len) {
		while (--len >= 0 && CodepointSupport.BMP.isWhitespace(arr[len]))
			;
		return len + 1;
	}

	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// ======================================= with endian
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================
	// =================================================

	public static class E {
		private E() {

		}

		/**
		 * Skip linefeeds according to {@link CodepointSupport#isLinefeed(int)} and
		 * return the new length (No shrink will be applied)
		 */
		public int linefeed(char[] arr, int len, Endian read) {
			while (--len >= 0 && CodepointSupport.BMP.isLinefeed(arr[read.index(len, len, arr.length)]))
				;
			return len + 1;
		}

		/**
		 * Skip whilespaces according to {@link CodepointSupport#isWhitespace(int)} and
		 * return the new length (No shrink will be applied)
		 */
		public int whitespace(char[] arr, int len, Endian read) {
			while (--len >= 0 && CodepointSupport.BMP.isWhitespace(arr[read.index(len, len, arr.length)]))
				;
			return len + 1;
		}

	}
}
