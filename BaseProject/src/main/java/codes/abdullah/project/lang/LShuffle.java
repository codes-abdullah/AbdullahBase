package codes.abdullah.project.lang;

import java.util.Random;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.Endian;

public class LShuffle {
	/** {@link Endian} based implementation */
	public final E e = new E();

	LShuffle() {

	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public boolean[] in(boolean[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public boolean[] in(boolean[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public boolean[] in(boolean[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public boolean[] in(boolean[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public byte[] in(byte[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public byte[] in(byte[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public byte[] in(byte[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public byte[] in(byte[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public short[] in(short[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public short[] in(short[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public short[] in(short[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public short[] in(short[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public int[] in(int[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public int[] in(int[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public int[] in(int[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public int[] in(int[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public long[] in(long[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public long[] in(long[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public long[] in(long[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public long[] in(long[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public float[] in(float[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public float[] in(float[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public float[] in(float[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public float[] in(float[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public double[] in(double[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public double[] in(double[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public double[] in(double[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 * Shuffle given array based on given range
	 * 
	 * @param arr  src array
	 * @param len  array len
	 * @param from inclusive (left-side)
	 * @param to   exclusive (right-side)
	 * @param r    random object, by default {@link Digits#RANDOM}
	 */
	public double[] in(double[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public <T> T[] in(T[] arr, int len) {
		return in(arr, len, 0);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public <T> T[] in(T[] arr, int len, int from) {
		return in(arr, len, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public <T> T[] in(T[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Digits.RANDOM);
	}

	/**
	 * @see #in(double[], int, int, int, Random)
	 */
	public <T> T[] in(T[] arr, int len, int from, int to, Random r) {
		if (len <= 1)
			return arr;
		else if (len == 2)
			return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
		int bound = to - from;
		int left = 0, right = 0;
		for (int i = from; i < to; i++) {
			// i.e: from 10 to 13, bound = 3, nextInt will be from 0 to 2, add from as
			// offset to be from 10 to 12
			left = r.nextInt(bound) + from;
			right = r.nextInt(bound) + from;
			Lang.swap.with(arr, len, left, right);
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
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public boolean[] in(boolean[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public boolean[] in(boolean[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public boolean[] in(boolean[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public boolean[] in(boolean[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public boolean[] in(boolean[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public byte[] in(byte[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public byte[] in(byte[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public byte[] in(byte[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public byte[] in(byte[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public byte[] in(byte[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public short[] in(short[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public short[] in(short[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public short[] in(short[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public short[] in(short[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public short[] in(short[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}


		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public int[] in(int[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public int[] in(int[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public int[] in(int[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public int[] in(int[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public int[] in(int[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public long[] in(long[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public long[] in(long[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public long[] in(long[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public long[] in(long[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public long[] in(long[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public float[] in(float[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public float[] in(float[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public float[] in(float[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public float[] in(float[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public float[] in(float[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public double[] in(double[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public double[] in(double[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public double[] in(double[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public double[] in(double[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks and length<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> N/A<br>
		 * <b>Reallocate:</b> N/A<br>
		 * <b>New length:</b> N/A<br>
		 * <br>
		 * Shuffle given array based on given range
		 * 
		 * @param arr  src array
		 * @param len  array len
		 * @param from inclusive (left-side)
		 * @param to   exclusive (right-side)
		 * @param read src endian
		 * @param r    random object, by default {@link Digits#RANDOM}
		 */
		public double[] in(double[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public <T> T[] in(T[] arr, int len) {
			return in(arr, len, 0);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public <T> T[] in(T[] arr, int len, int from) {
			return in(arr, len, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public <T> T[] in(T[] arr, int len, int from, int to) {
			return in(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public <T> T[] in(T[] arr, int len, int from, int to, Endian read) {
			return in(arr, len, from, to, read, Digits.RANDOM);
		}

		/**
		 * @see #in(double[], int, int, int, Endian, Random)
		 */
		public <T> T[] in(T[] arr, int len, int from, int to, Endian read, Random r) {
			if (len <= 1)
				return arr;
			else if (len == 2)
				return r.nextBoolean() ? Lang.swap.with(arr, len, 0, 1) : arr;
			int bound = to - from;
			int left = 0, right = 0;
			for (int i = from; i < to; i++) {
				// i.e: from 10 to 13, bound = 3, nextInt will be from 0 to 2, add from as
				// offset to be from 10 to 12
				left = r.nextInt(bound) + from;
				right = r.nextInt(bound) + from;
				Lang.swap.with(arr, len, read.index(left, len, arr.length), read.index(right, len, arr.length));
			}
			return arr;
		}

	}
}
