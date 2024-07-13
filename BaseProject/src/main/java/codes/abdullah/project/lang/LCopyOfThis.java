package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LCopyOfThis {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LCopyOfThis() {

	}

	// ======================= boolean[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public boolean[] this_(boolean[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public boolean[] this_(boolean[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public boolean[] this_(boolean[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new boolean[outlen], outlen, from, to, 0);
	}
	// ======================= byte[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public byte[] this_(byte[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public byte[] this_(byte[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public byte[] this_(byte[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new byte[outlen], outlen, from, to, 0);
	}
	// ======================= short[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public short[] this_(short[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public short[] this_(short[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public short[] this_(short[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new short[outlen], outlen, from, to, 0);
	}
	// ======================= char[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public char[] this_(char[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public char[] this_(char[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public char[] this_(char[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new char[outlen], outlen, from, to, 0);
	}
	// ======================= int[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public int[] this_(int[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public int[] this_(int[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public int[] this_(int[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new int[outlen], outlen, from, to, 0);
	}
	// ======================= long[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public long[] this_(long[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public long[] this_(long[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public long[] this_(long[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new long[outlen], outlen, from, to, 0);
	}
	// ======================= float[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public float[] this_(float[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public float[] this_(float[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public float[] this_(float[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new float[outlen], outlen, from, to, 0);
	}
	// ======================= double[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public double[] this_(double[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public double[] this_(double[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * Copy specific range of given array<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> true<br>
	 * <b>New length:</b> Applied to output<br>
	 * <br>
	 */
	public double[] this_(double[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, new double[outlen], outlen, from, to, 0);
	}
	// ======================= T[]

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public <T> T[] this_(T[] in, int inlen) {
		return this_(in, inlen, 0);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public <T> T[] this_(T[] in, int inlen, int from) {
		return this_(in, inlen, from, inlen);
	}

	/**
	 * @see #this_(double[], int, int, int)
	 */
	public <T> T[] this_(T[] in, int inlen, int from, int to) {
		final int outlen = to - from;
		return Lang.copy.to.that(in, inlen, Lang.generic.newArray(in, outlen), outlen, from, to, 0);
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
	// ======================================= copy with endian
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

		// ======================= boolean[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] this_(boolean[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] this_(boolean[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] this_(boolean[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] this_(boolean[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public boolean[] this_(boolean[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new boolean[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= byte[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public byte[] this_(byte[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public byte[] this_(byte[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public byte[] this_(byte[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public byte[] this_(byte[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public byte[] this_(byte[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new byte[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= short[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public short[] this_(short[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public short[] this_(short[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public short[] this_(short[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public short[] this_(short[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public short[] this_(short[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new short[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= char[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public char[] this_(char[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public char[] this_(char[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public char[] this_(char[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public char[] this_(char[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public char[] this_(char[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new char[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= int[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public int[] this_(int[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public int[] this_(int[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public int[] this_(int[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public int[] this_(int[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public int[] this_(int[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new int[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= long[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public long[] this_(long[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public long[] this_(long[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public long[] this_(long[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public long[] this_(long[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public long[] this_(long[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new long[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= float[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public float[] this_(float[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public float[] this_(float[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public float[] this_(float[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public float[] this_(float[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public float[] this_(float[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new float[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= double[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public double[] this_(double[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public double[] this_(double[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public double[] this_(double[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public double[] this_(double[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public double[] this_(double[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, new double[outlen], outlen, from, to, read, write, 0);
		}
		// ======================= T[]

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] this_(T[] in, int inlen) {
			return this_(in, inlen, 0);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] this_(T[] in, int inlen, int from) {
			return this_(in, inlen, from, inlen);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] this_(T[] in, int inlen, int from, int to) {
			return this_(in, inlen, from, inlen, Endian.LITTLE);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] this_(T[] in, int inlen, int from, int to, Endian read) {
			return this_(in, inlen, from, inlen, read, read);
		}

		/**
		 * @see #this_(double[], int, int, int, Endian, Endian)
		 */
		public <T> T[] this_(T[] in, int inlen, int from, int to, Endian read, Endian write) {
			final int outlen = to - from;
			return Lang.copy.to.e.that(in, inlen, Lang.generic.newArray(in, outlen), outlen, from, to, read, write, 0);
		}
	}
}
