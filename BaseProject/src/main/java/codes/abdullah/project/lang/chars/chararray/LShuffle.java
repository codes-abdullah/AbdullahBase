package codes.abdullah.project.lang.chars.chararray;

import java.util.Random;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

public class LShuffle {
	public final E e = new E();

	LShuffle() {
	}

	/**
	 * @see #in(char[], int, int, int, Random, CodepointSupport)
	 */
	public char[] in(char[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(char[], int, int, int, Random, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(char[], int, int, int, Random, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(char[], int, int, int, Random, CodepointSupport)
	 */
	public char[] in(char[] arr, int len, int from, int to, Random r) {
		return in(arr, len, from, to, r, CodepointSupport.BMP);
	}

	/**
	 * 
	 */
	public char[] in(char[] arr, int len, int from, int to, Random r, CodepointSupport cps) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.codepoint.swap.with(arr, len, 0, 1, cps) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.codepoint.swap.with(arr, len, left, right, cps);
		}
		return arr;
	}

	public class E {
		private E() {

		}

		/**
		 * @see #in(char[], int, int, int, Endian, Random, CodepointSupport)
		 */
		public char[] in(char[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, Random, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, Random, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, Random, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(char[], int, int, int, Endian, Random, CodepointSupport)
		 */
		public char[] in(char[] arr, int len, int from, int to, Endian read, Random r) {
			return in(arr, len, from, to, read, r, CodepointSupport.BMP);
		}

		/**
		 * 
		 */
		public char[] in(char[] arr, int len, int from, int to, Endian read, Random r, CodepointSupport sps) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.codepoint.swap.with(arr, len, 0, 1, sps) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.codepoint.swap.with(arr, len, left, right, sps);
			}
			return arr;
		}

	}
}
