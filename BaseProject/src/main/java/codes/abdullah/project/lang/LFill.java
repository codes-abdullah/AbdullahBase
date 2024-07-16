package codes.abdullah.project.lang;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LFill {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LFill() {

	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, boolean value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, boolean value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, boolean value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public byte[] in(byte[] arr, int len, byte value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public byte[] in(byte[] arr, int len, byte value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public byte[] in(byte[] arr, int len, byte value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public short[] in(short[] arr, int len, short value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public short[] in(short[] arr, int len, short value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public short[] in(short[] arr, int len, short value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public char[] in(char[] arr, int len, char value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public char[] in(char[] arr, int len, char value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public char[] in(char[] arr, int len, char value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	// ===============
	// =============== surrogate-pairs
	// ===============

	public char[] in(char[] arr, int len, int codepoint) {
		return in(arr, len, codepoint, 0);
	}

	public char[] in(char[] arr, int len, int codepoint, int from) {
		return in(arr, len, codepoint, from, len);
	}

	public char[] in(char[] arr, int len, int codepoint, int from, int to) {
		return in(arr, len, codepoint, from, to, CodepointSupport.BMP);
	}

	public char[] in(char[] arr, int len, int codepoint, int from, int to, CodepointSupport sps) {
		if (!sps.isSupported())
			return in(arr, len, (char) codepoint, from, to);
		if (sps.isBmp(codepoint)) {
			char ch = (char) codepoint;
			for (; from < to; from++) {
				arr[from] = ch;
			}
			return arr;
		} else if (sps.isPair(codepoint)) {
			char high = sps.toHigh(codepoint);
			char low = sps.toLow(codepoint);
			for (; from < to; from++) {
				arr[from++] = high;
				arr[from] = low;
			}
			return arr;
		}
		Check.codePoint(codepoint);
		return null;// should never be here
	}

	// ===============
	// ===============
	// ===============

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public int[] in(int[] arr, int len, int value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public int[] in(int[] arr, int len, int value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public int[] in(int[] arr, int len, int value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public long[] in(long[] arr, int len, long value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public long[] in(long[] arr, int len, long value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public long[] in(long[] arr, int len, long value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public float[] in(float[] arr, int len, float value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public float[] in(float[] arr, int len, float value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public float[] in(float[] arr, int len, float value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public double[] in(double[] arr, int len, double value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public double[] in(double[] arr, int len, double value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 * Fill given array by given value based on range and length
	 * 
	 * @param arr   src array
	 * @param len   src length
	 * @param from  inclusive index to write
	 * @param to    exclusive index to write
	 * @param value value to write
	 * @throws IndexOutOfBoundsException see {@link Check#range(int, int, int)}
	 */
	public double[] in(double[] arr, int len, double value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
		return arr;
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public <T> T[] in(T[] arr, int len, T value) {
		return in(arr, len, value, 0);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public <T> T[] in(T[] arr, int len, T value, int from) {
		return in(arr, len, value, from, len);
	}

	/**
	 * @see #in(double[], int, double, int, int)
	 */
	public <T> T[] in(T[] arr, int len, T value, int from, int to) {
		for (; from < to; from++)
			arr[from] = value;
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
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, boolean value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, boolean value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, boolean value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, boolean value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, byte value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, byte value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, byte value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, byte value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, short value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, short value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, short value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, short value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, char value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, char value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, char value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, char value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		// ===============
		// =============== surrogate-pairs
		// ===============

		public char[] in(char[] arr, int len, int codepoint) {
			return in(arr, len, codepoint, 0);
		}

		public char[] in(char[] arr, int len, int codepoint, int from) {
			return in(arr, len, codepoint, from, len);
		}

		public char[] in(char[] arr, int len, int codepoint, int from, int to) {
			return in(arr, len, codepoint, from, to, Endian.LITTLE);
		}

		public char[] in(char[] arr, int len, int codepoint, int from, int to, Endian write) {
			return in(arr, len, codepoint, from, to, write, CodepointSupport.BMP);
		}

		public char[] in(char[] arr, int len, int codepoint, int from, int to, Endian write, CodepointSupport sps) {
			if (!sps.isSupported())
				return in(arr, len, (char) codepoint, from, to, write);
			if (sps.isBmp(codepoint)) {
				char ch = (char) codepoint;
				for (; from < to; from++) {
					arr[write.index(from, len, arr.length)] = ch;
				}
				return arr;
			} else if (sps.isPair(codepoint)) {
				char high = sps.toHigh(codepoint);
				char low = sps.toLow(codepoint);
				for (; from < to; from++) {
					arr[write.index(from++, len, arr.length)] = high;
					arr[write.index(from, len, arr.length)] = low;
				}
				return arr;
			}
			Check.codePoint(codepoint);
			return null;// should never be here
		}

		// ===============
		// ===============
		// ===============

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, long value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, long value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, long value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, long value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, float value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, float value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, float value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, float value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, double value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, double value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, double value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks and length<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> N/A<br>
		 * <b>Reallocate:</b> N/A<br>
		 * <b>New length:</b> N/A<br>
		 * <br>
		 * Fill given array by given value based on range and length
		 * 
		 * @param arr   src array
		 * @param len   src length
		 * @param from  inclusive index to write
		 * @param to    exclusive index to write
		 * @param value value to write
		 * @param write endian used to write into the array, by default
		 *              {@link Endian#LITTLE}
		 * @throws IndexOutOfBoundsException see {@link Check#range(int, int, int)}
		 */
		public double[] in(double[] arr, int len, double value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, T value) {
			return in(arr, len, value, 0);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, T value, int from) {
			return in(arr, len, value, from, len);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, T value, int from, int to) {
			return in(arr, len, value, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, double, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, T value, int from, int to, Endian write) {
			Check.range(from, to, len);
			for (; from < to; from++)
				arr[write.index(from, len, arr.length)] = value;
			return arr;
		}

	}
}
