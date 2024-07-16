package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

public class LTrim {
	public final E e = new E();

	LTrim() {

	}

	/**
	 * Skip linefeeds according to {@link CodepointSupport#isLinefeed(int)} and
	 * return the new length (shrink will be applied)
	 */
	public char[] linefeed(char[] arr, int len) {
		len = Lang.chararray.skip.linefeed(arr, len);
		return Lang.trim.in(arr, len);
	}

	/**
	 * Skip linefeeds according to {@link CodepointSupport#isWhitespace(int)} and
	 * return the new length (shrink will be applied)
	 */
	public char[] whitespace(char[] arr, int len) {
		len = Lang.chararray.skip.whitespace(arr, len);
		return Lang.trim.in(arr, len);
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
		 * return the new length (shrink will be applied)
		 */
		public char[] linefeed(char[] arr, int len, Endian read) {
			len = Lang.chararray.skip.e.linefeed(arr, len, read);
			return Lang.trim.e.in(arr, len, read);
		}


		/**
		 * Skip linefeeds according to {@link CodepointSupport#isWhitespace(int)} and
		 * return the new length (shrink will be applied)
		 */
		public char[] whitespace(char[] arr, int len, Endian read) {
			len = Lang.chararray.skip.e.whitespace(arr, len, read);
			return Lang.trim.e.in(arr, len, read);
		}
	}

}
