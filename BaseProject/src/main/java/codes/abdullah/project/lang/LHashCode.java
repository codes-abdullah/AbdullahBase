package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LHashCode {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LHashCode() {

	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(boolean[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++)
			result = 31 * result + (arr[i] ? 1231 : 1237);
		return result;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(byte[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++)
			result = 31 * result + arr[i];
		return result;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(char[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++)
			result = 31 * result + arr[i];
		return result;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(short[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++)
			result = 31 * result + arr[i];
		return result;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(int[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++)
			result = 31 * result + arr[i];
		return result;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(long[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++) {
			int elementHash = (int) (arr[i] ^ (arr[i] >>> 32));
			result = 31 * result + elementHash;
		}
		return result;
	}

	/**
	 * @see #of(double[], int)
	 */
	public int of(float[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++)
			result = 31 * result + Float.floatToIntBits(arr[i]);
		return result;
	}

	/**
	 * Calculate hash-code based on given length
	 */
	public int of(double[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		long bits = 0;
		for (int i = 0; i < len; i++) {
			bits = Double.doubleToLongBits(arr[i]);
			result = 31 * result + (int) (bits ^ (bits >>> 32));
		}
		return result;
	}

	/**
	 * @see #of(double[], int)
	 */
	public <T> int of(T[] arr, int len) {
		if (arr == null)
			return 0;
		int result = 1;
		for (int i = 0; i < len; i++)
			result = 31 * result + (arr[i] == null ? 0 : arr[i].hashCode());
		return result;
	}

	public static class E {
		private E() {
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(boolean[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(boolean[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++)
				result = 31 * result + (arr[read.index(i, len, arr.length)] ? 1231 : 1237);
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(byte[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(byte[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++)
				result = 31 * result + arr[read.index(i, len, arr.length)];
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(char[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(char[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++)
				result = 31 * result + arr[read.index(i, len, arr.length)];
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(short[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(short[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++)
				result = 31 * result + arr[read.index(i, len, arr.length)];
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(int[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(int[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++) {
				result = 31 * result + arr[read.index(i, len, arr.length)];
			}
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(long[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(long[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++) {
				int elementHash = (int) (arr[read.index(i, len, arr.length)]
						^ (arr[read.index(i, len, arr.length)] >>> 32));
				result = 31 * result + elementHash;
			}
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(float[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(float[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++)
				result = 31 * result + Float.floatToIntBits(arr[read.index(i, len, arr.length)]);
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public int of(double[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * Calculate hash-code based on given length
		 */
		public int of(double[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			long bits = 0;
			for (int i = 0; i < len; i++) {
				bits = Double.doubleToLongBits(arr[read.index(i, len, arr.length)]);
				result = 31 * result + (int) (bits ^ (bits >>> 32));
			}
			return result;
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public <T> int of(T[] arr, int len) {
			return of(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, Endian)
		 */
		public <T> int of(T[] arr, int len, Endian read) {
			if (arr == null)
				return 0;
			int result = 1;
			for (int i = 0; i < len; i++)
				result = 31 * result + (arr[read.index(i, len, arr.length)] == null ? 0
						: arr[read.index(i, len, arr.length)].hashCode());
			return result;
		}
	}
}
