package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LSub {
	LSub() {

	}

	// ======================= byte[]

	/**
	 * @see #of(double[], int, int, int)
	 */
	public byte[] of(byte[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public byte[] of(byte[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	// ======================= short[]
	/**
	 * @see #of(double[], int, int, int)
	 */
	public short[] of(short[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	public short[] of(short[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	// ======================= char[]
	/**
	 * @see #of(double[], int, int, int)
	 */
	public char[] of(char[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public char[] of(char[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	// ======================= int[]
	/**
	 * @see #of(double[], int, int, int)
	 */
	public int[] of(int[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public int[] of(int[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	// ======================= long[]
	/**
	 * @see #of(double[], int, int, int)
	 */
	public long[] of(long[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public long[] of(long[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	// ======================= float[]

	/**
	 * @see #of(double[], int, int, int)
	 */
	public float[] of(float[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public float[] of(float[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	// ======================= double[]
	/**
	 * @see #of(double[], int, int, int)
	 */
	public double[] of(double[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * Copy range of elements
	 * 
	 * @param arr  src array
	 * @param len  src length
	 * @param from copy from
	 * @param to   copy to
	 * 
	 * 
	 * @return new array of given range
	 */
	public double[] of(double[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	// ======================= T[]
	/**
	 * @see #of(double[], int, int, int)
	 */
	public <T> T[] of(T[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public <T> T[] of(T[] arr, int len, int from, int to) {
		return Lang.copy.of.this_(arr, len, from, to);
	}

	public class E {
		private E() {

		}

		// ======================= boolean[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] of(boolean[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] of(boolean[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] of(boolean[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] of(boolean[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= byte[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public byte[] of(byte[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public byte[] of(byte[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public byte[] of(byte[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public byte[] of(byte[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= short[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public short[] of(short[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public short[] of(short[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public short[] of(short[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public short[] of(short[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= char[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public char[] of(char[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public char[] of(char[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public char[] of(char[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public char[] of(char[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= int[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public int[] of(int[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public int[] of(int[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public int[] of(int[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public int[] of(int[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= long[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public long[] of(long[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public long[] of(long[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public long[] of(long[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public long[] of(long[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= float[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public float[] of(float[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public float[] of(float[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public float[] of(float[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public float[] of(float[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= double[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public double[] of(double[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public double[] of(double[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public double[] of(double[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * Copy range of elements
		 * 
		 * @param arr   src array
		 * @param len   src length
		 * @param from  copy from
		 * @param to    copy to
		 * @param read  src endian
		 * @param write output endian
		 * 
		 * @return new array of given range
		 */
		public double[] of(double[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}
		// ======================= T[]

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] of(T[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] of(T[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] of(T[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] of(T[] arr, int len, int from, int to, Endian read, Endian write) {
			return Lang.copy.of.e.this_(arr, len, from, to, read, write);
		}

	}
}
