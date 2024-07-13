package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LSkip {
	/** {@link Endian} based implementation */
	public final E e = new E();

	LSkip() {

	}

	/**
	 * 
	 * @see #of(double[], int)
	 */
	public int of(boolean[] arr, int len) {
		while (--len >= 0 && !arr[len])
			;
		return len + 1;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(byte[] arr, int len) {
		while (--len >= 0 && arr[len] == 0)
			;
		return len + 1;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(short[] arr, int len) {
		while (--len >= 0 && arr[len] == 0)
			;
		return len + 1;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(char[] arr, int len) {
		while (--len >= 0 && arr[len] == 0)
			;
		return len + 1;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(int[] arr, int len) {
		while (--len >= 0 && arr[len] == 0)
			;
		return len + 1;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(long[] arr, int len) {
		while (--len >= 0 && arr[len] == 0)
			;
		return len + 1;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(float[] arr, int len) {
		while (--len >= 0 && arr[len] == 0)
			;
		return len + 1;
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks<br>
	 * Skip zeros/nulls <br>
	 * e.g: arr {65, 87, 0, 0}, len = 4, return len = 2
	 * 
	 * @return new length after skping the zeros
	 */
	public int of(double[] arr, int len) {
		while (--len >= 0 && arr[len] == 0)
			;
		return len + 1;
	}

	/**
	 * @see #of(double[], int, Endian)
	 */
	public <T> int of(T[] arr, int len) {
		while (--len >= 0 && arr[len] == null)
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
		 * Skip false based on given read {@link Endian}
		 * 
		 * @see #of(double[], int, Endian)
		 */
		public int of(boolean[] arr, int len, Endian read) {
			while (--len >= 0 && !arr[read.index(len, len, arr.length)])
				;
			return len + 1;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(byte[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == 0)
				;
			return len + 1;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(short[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == 0)
				;
			return len + 1;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(char[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == 0)
				;
			return len + 1;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(int[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == 0)
				;
			return len + 1;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(long[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == 0)
				;
			return len + 1;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(float[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == 0)
				;
			return len + 1;
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks<br>
		 * Skip zeros/nulls based on given read {@link Endian}, <br>
		 * e.g: [10, 20, 30, 0, 0], len = 5, read = LITTLE, return new len = 3<br>
		 * e.g: [0, 0, 30, 20, 10], len = 5, read = BIG, return new len = 3
		 * 
		 * @return new length after ofping the zeros
		 */
		public int of(double[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == 0)
				;
			return len + 1;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public <T> int of(T[] arr, int len, Endian read) {
			while (--len >= 0 && arr[read.index(len, len, arr.length)] == null)
				;
			return len + 1;
		}

	}
}
