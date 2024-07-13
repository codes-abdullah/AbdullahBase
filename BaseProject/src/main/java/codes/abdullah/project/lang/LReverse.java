package codes.abdullah.project.lang;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Endian;

public class LReverse {
	/** {@link Endian} based implementation */
	public final E e = new E();

	LReverse() {
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public boolean[] in(boolean[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public byte[] in(byte[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public byte[] in(byte[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public byte[] in(byte[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public short[] in(short[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public short[] in(short[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public short[] in(short[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
		}
		return arr;
	}



	/**
	 * @see #in(double[], int, int, int)
	 */
	public int[] in(int[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public int[] in(int[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public int[] in(int[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public long[] in(long[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public long[] in(long[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public long[] in(long[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public float[] in(float[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public float[] in(float[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public float[] in(float[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public double[] in(double[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public double[] in(double[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * <b>Note: </b> Invoker must take care in all checks<br>
	 * 
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 * Reverse given array based on given range
	 * 
	 * @param arr  src array
	 * @param len  src length
	 * @param from inclusive index
	 * @param to   exclusive index
	 * @return src array after reversing
	 * @see Digits#ints
	 * @see LSwap
	 */
	public double[] in(double[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public <T> T[] in(T[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public <T> T[] in(T[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int)
	 */
	public <T> T[] in(T[] arr, int len, int from, int to) {
		final int loops = (to - from) / 2;
		int left = from, right = 0;
		for (int i = 0; i < loops; i++) {
			right = Digits.ints.flip(left, from + to);
			arr = Lang.swap.with(arr, len, left, right);
			left++;
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
		 * @see #in(double[], int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * <b>Note: </b> Invoker must take care in all checks<br>
		 * 
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> N/A<br>
		 * <b>Reallocate:</b> N/A<br>
		 * <b>New length:</b> N/A<br>
		 * <br>
		 * Reverse given array based on given range
		 * 
		 * @param arr  src array
		 * @param len  src length
		 * @param from inclusive index
		 * @param to   exclusive index
		 * @param read read endian
		 * @return src array after reversing
		 * 
		 * @see Digits#ints
		 * @see LSwap
		 */
		public double[] in(double[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int from, int to, Endian read) {
			final int loops = (to - from) / 2;
			int left = from, right = 0;
			for (int i = 0; i < loops; i++) {
				right = Digits.ints.flip(left, from + to);
				arr = Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
				left++;
			}
			return arr;
		}
	}

}
