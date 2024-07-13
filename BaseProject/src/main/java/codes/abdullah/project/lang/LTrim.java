package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LTrim {
	/** {@link Endian} based implementation */
	public final E e = new E();

	LTrim() {

	}

	/**
	 * @see #in(double[], int)
	 */
	public boolean[] in(boolean[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * @see #in(double[], int)
	 */
	public byte[] in(byte[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * @see #in(double[], int)
	 */
	public short[] in(short[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * @see #in(double[], int)
	 */
	public char[] in(char[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * @see #in(double[], int)
	 */
	public int[] in(int[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * @see #in(double[], int)
	 */
	public long[] in(long[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * @see #in(double[], int)
	 */
	public float[] in(float[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * Trim array based on given length<br>
	 * e.g: [1, 2, 3, 4, 5, 6, 7, 8, 9], len: 5<br>
	 * result: [1, 2, 3, 4, 5]<br>
	 * 
	 * @return new trimmed array
	 */
	public double[] in(double[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
	}

	/**
	 * @see #in(double[], int)
	 */
	public <T> T[] in(T[] arr, int len) {
		return len < arr.length ? Lang.copy.of.this_(arr, len) : arr;
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
		 * @see #in(double[], int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public byte[] in(byte[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public byte[] in(byte[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public short[] in(short[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public short[] in(short[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public char[] in(char[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public char[] in(char[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public int[] in(int[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public int[] in(int[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public long[] in(long[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public long[] in(long[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public float[] in(float[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public float[] in(float[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public double[] in(double[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * Trim array based on given length and read {@link Endian}<br>
		 * e.g: [1, 2, 3, 4, 5, 6, 7, 8, 9], len: 5<br>
		 * read: {@link Endian#LITTLE}<br>
		 * result: [1, 2, 3, 4, 5]<br>
		 * <br>
		 * e.g: [9, 8, 7, 6, 5, 4, 3, 2, 1], len: 5<br>
		 * read: {@link Endian#BIG}<br>
		 * e.g: [5, 4, 3, 2, 1]
		 */
		public double[] in(double[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

		/**
		 * @see #_in(double[], int, Endian)
		 */
		public <T> T[] in(T[] arr, int len) {
			return in(arr, len, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, Endian read) {
			return len < arr.length ? Lang.copy.of.e.this_(arr, len, 0, len, read) : arr;
		}

	}

}
