package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

public class LReverse {
	public final E e = new E();

	LReverse() {

	}

	/**
	 * @see #in(double[], int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int from, int to) {
		return in(arr, len, from, to, CodepointSupport.BMP);
	}

	/**
	 * 
	 */
	public char[] in(char[] arr, int len, int from, int to, CodepointSupport cps) {
		int left = from, right = to, llen = 0, rlen;
		while (left < right) {
			llen = cps.lengthOf(arr, len, left);
			rlen = cps.lengthOfBackwardly(arr, len, right);

			arr = Lang.codepoint.swap.with(arr, len, left, right - rlen, cps);

			// e.g: mA1xyz, while L.swap.withping 1 and 5, llen=2, rlen=1, will have:
			// mzxyA1, we need to push left cursor by rlen, and right cursor by llen
			left += rlen;
			right -= llen;

		}
		return arr;
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
		 * @see #in(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] in(char[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, CodepointSupport.BMP);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from, int to, Endian read, CodepointSupport cps) {
			int left = from, right = to, llen = 0, rlen;

			while (left < right) {
				llen = cps.lengthOf(arr, len, left);
				rlen = cps.lengthOfBackwardly(arr, len, right);

				arr = Lang.codepoint.swap.with(arr, len, left, right - rlen, cps);

				// e.g: mA1xyz, while L.swap.withping 1 and 5, llen=2, rlen=1, will have:
				// mzxyA1, we need to push left cursor by rlen, and right cursor by llen
				left += rlen;
				right -= llen;

			}
			return arr;
		}

	}
}
