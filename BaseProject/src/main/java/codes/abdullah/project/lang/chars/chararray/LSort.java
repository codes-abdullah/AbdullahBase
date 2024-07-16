package codes.abdullah.project.lang.chars.chararray;

import java.util.Arrays;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Endian;

public class LSort {
	LSort() {

	}

	/**
	 * @see #in(char[], int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(char[], int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(char[], int, int, int, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int from, int to) {
		return in(arr, len, from, to, CodepointSupport.BMP);
	}

	/**
	 * Note: Src arr will not be same as the returned if {@link CodepointSupport#isSupported()}:<br>
	 * reason:<br>
	 * 
	 * Sorting a bmp-char-based array is simple using {@link Arrays#sort(char[])},
	 * but sorting codepoint-char-based array using same method will shuffle
	 * surrogate-pairs, the best solution is to turn a codepoint-char-based to
	 * codepoint-int-based, sort it and turn it back as codepoint-char-based
	 */
	public char[] in(char[] arr, int len, int from, int to, CodepointSupport cps) {
		if (cps.isSupported()) {
			int[] cparr = cps.toCodepointArray(arr, len);
			Arrays.sort(cparr, from, to);
			arr = cps.toCharArray(cparr, cparr.length, 0, cparr.length, arr, len);
		} else {
			Arrays.sort(arr, from, to);
		}
		return arr;
	}

	/**
	 * @see #parallel(char[], int, int, int, CodepointSupport)
	 */
	public char[] parallel(char[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #parallel(char[], int, int, int, CodepointSupport)
	 */
	public char[] parallel(char[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #parallel(char[], int, int, int, CodepointSupport)
	 */
	public char[] parallel(char[] arr, int len, int from, int to) {
		return in(arr, len, from, to, CodepointSupport.BMP);
	}

	/**
	 * Note: Src arr will not be same as the returned if {@link CodepointSupport#isSupported()}:<br>
	 * reason:<br>
	 * 
	 * Sorting a bmp-char-based array is simple using {@link Arrays#sort(char[])},
	 * but sorting codepoint-char-based array using same method will shuffle
	 * surrogate-pairs, the best solution is to turn a codepoint-char-based to
	 * codepoint-int-based, sort it and turn it back as codepoint-char-based
	 */
	public char[] parallel(char[] arr, int len, int from, int to, CodepointSupport cps) {
		if (cps.isSupported()) {
			int[] cparr = cps.toCodepointArray(arr, len);
			Arrays.parallelSort(cparr, from, to);
			arr = cps.toCharArray(cparr, cparr.length, 0, cparr.length, arr, len);
		} else {
			Arrays.parallelSort(arr, from, to);
		}
		return arr;
	}

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
		 * 
		 */
		public char[] in(char[] arr, int len, int from, int to, Endian read, CodepointSupport cps) {
			from = read.from(from, to, len, arr.length);
			to = read.to(from, to, len, arr.length);
			if (cps.isSupported()) {
				int[] cparr = cps.toCodepointArray(arr, len);
				Arrays.sort(cparr, from, to);
				arr = cps.toCharArray(cparr, cparr.length, 0, cparr.length, arr, len);
			} else {
				Arrays.sort(arr, from, to);
			}
			return arr;
		}

		/**
		 * @see #parallel(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] parallel(char[] arr, int len) {
			return parallel(arr, len, 0);
		}

		/**
		 * @see #parallel(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] parallel(char[] arr, int len, int from) {
			return parallel(arr, len, from, len);
		}

		/**
		 * @see #parallel(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] parallel(char[] arr, int len, int from, int to) {
			return parallel(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #parallel(char[], int, int, int, Endian, CodepointSupport)
		 */
		public char[] parallel(char[] arr, int len, int from, int to, Endian read) {
			return parallel(arr, len, from, to, read, CodepointSupport.BMP);
		}

		/**
		 * 
		 */
		public char[] parallel(char[] arr, int len, int from, int to, Endian read, CodepointSupport cps) {
			from = read.from(from, to, len, arr.length);
			to = read.to(from, to, len, arr.length);
			if (cps.isSupported()) {
				int[] cparr = cps.toCodepointArray(arr, len);
				Arrays.sort(cparr, from, to);
				arr = cps.toCharArray(cparr, cparr.length, 0, cparr.length, arr, len);
			} else {
				Arrays.sort(arr, from, to);
			}
			return arr;
		}
	}
}
