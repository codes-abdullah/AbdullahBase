package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LCapacity {

	/** {@link Endian} based implementation */
	public final E e = new E();
	public final LCapacityLength lengthOf = new LCapacityLength();

	LCapacity() {
	}

	// =================================================
	// =================================================
	// ======================================= ensure capacity
	// =================================================
	// =================================================

	// ======================= boolean[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public boolean[] ensure(boolean[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public boolean[] ensure(boolean[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public boolean[] ensure(boolean[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new boolean[new_length], new_length);
		}
		return src;
	}

	// ======================= byte[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public byte[] ensure(byte[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public byte[] ensure(byte[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public byte[] ensure(byte[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new byte[new_length], new_length);
		}
		return src;
	}

	// ======================= short[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public short[] ensure(short[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public short[] ensure(short[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public short[] ensure(short[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new short[new_length], new_length);
		}
		return src;
	}

	// ======================= char[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public char[] ensure(char[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public char[] ensure(char[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public char[] ensure(char[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new char[new_length], new_length);
		}
		return src;
	}

	// ======================= int[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public int[] ensure(int[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public int[] ensure(int[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public int[] ensure(int[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new int[new_length], new_length);
		}
		return src;
	}

	// ======================= long[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public long[] ensure(long[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public long[] ensure(long[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public long[] ensure(long[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new long[new_length], new_length);
		}
		return src;
	}

	// ======================= float[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public float[] ensure(float[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public float[] ensure(float[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public float[] ensure(float[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new float[new_length], new_length);
		}
		return src;
	}

	// ======================= double[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public double[] ensure(double[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public double[] ensure(double[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * 
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> If required<br>
	 * <b>New length:</b> By invoker<br>
	 * <br>
	 * 
	 * Ensure <b>src</b> capacity at less equals to <b>required</b>, if not will
	 * double the current size according to given <b>len</b> without exceeding
	 * <b>max_allowed</b><br>
	 * If <b>restrict_to_requirements</b> is true, will ensure <b>src</b> size is
	 * exact equals to <b>required</b>(no extra slots) <br>
	 * <br>
	 *
	 * @param restrict_to_requirements if true, will not make extra slots during
	 *                                 allocation, by default <code>false</code><br>
	 * @param max_allowed              max allowed size for the allocation if
	 *                                 required, by default
	 *                                 {@link Lang.constant.ARRAY_SAFE_CAPACITY}<br>
	 * @throws IllegalArgumentException if required > max_allowed
	 */
	public double[] ensure(double[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, new double[new_length], new_length);
		}
		return src;
	}

	// ======================= T[]

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public <T> T[] ensure(T[] src, int len, int required) {
		return ensure(src, len, required, false);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public <T> T[] ensure(T[] src, int len, int required, boolean restrict_to_requirements) {
		return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #ensure(double[], int, int, boolean, int)
	 */
	public <T> T[] ensure(T[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
		if ((required - len) - (src.length - len) > 0) {
			final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			return Lang.copy.to.that(src, len, Lang.generic.newArray(src, new_length), new_length);
		}
		return src;
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

		// =================================================
		// =================================================
		// ======================================= ensure capacity
		// =================================================
		// =================================================

		// ======================= boolean[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public boolean[] ensure(boolean[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public boolean[] ensure(boolean[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public boolean[] ensure(boolean[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public boolean[] ensure(boolean[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new boolean[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= byte[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public byte[] ensure(byte[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public byte[] ensure(byte[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public byte[] ensure(byte[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public byte[] ensure(byte[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new byte[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= short[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public short[] ensure(short[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public short[] ensure(short[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public short[] ensure(short[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public short[] ensure(short[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new short[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= char[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public char[] ensure(char[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public char[] ensure(char[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public char[] ensure(char[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public char[] ensure(char[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new char[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= int[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public int[] ensure(int[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public int[] ensure(int[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public int[] ensure(int[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public int[] ensure(int[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new int[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= long[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public long[] ensure(long[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public long[] ensure(long[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public long[] ensure(long[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public long[] ensure(long[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new long[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= float[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public float[] ensure(float[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public float[] ensure(float[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public float[] ensure(float[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public float[] ensure(float[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new float[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= double[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public double[] ensure(double[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public double[] ensure(double[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public double[] ensure(double[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks and length<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> N/A<br>
		 * <b>Reallocate:</b> If required<br>
		 * <b>New length:</b> By invoker<br>
		 * <br>
		 * Ensure <b>src</b> capacity at less equals to <b>required</b>, if not will
		 * double the current size according to given <b>len</b> without exceeding
		 * <b>max_allowed</b><br>
		 * If <b>restrict_to_requirements</b> is true, will ensure <b>src</b> size is
		 * exact equals to <b>required</b>(no extra slots) <br>
		 * <br>
		 * 
		 * @param read                     <code>read</code> endian used to read from
		 *                                 given array, by default will use
		 *                                 {@link Endian#LITTLE} <br>
		 * @param restrict_to_requirements if true, will not make extra slots during
		 *                                 allocation, by default <code>false</code><br>
		 * @param max_allowed              max allowed size for the allocation if
		 *                                 required, by default
		 *                                 {@link Lang.L.ARRAY_SAFE_CAPACITY}<br>
		 * @throws IllegalArgumentException if required > max_allowed
		 */
		public double[] ensure(double[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, new double[new_length], new_length, 0, len, read, read);
			}
			return src;
		}

		// ======================= T[]
		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public <T> T[] ensure(T[] src, int len, int required) {
			return ensure(src, len, required, Endian.LITTLE);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public <T> T[] ensure(T[] src, int len, int required, Endian read) {
			return ensure(src, len, required, read, false);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public <T> T[] ensure(T[] src, int len, int required, Endian read, boolean restrict_to_requirements) {
			return ensure(src, len, required, read, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		/**
		 * @see #ensure(double[], int, int, Endian, boolean, int)
		 */
		public <T> T[] ensure(T[] src, int len, int required, Endian read, boolean restrict_to_requirements,
				int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				final int new_length = newCapacity(src.length, required, restrict_to_requirements, max_allowed);
				return Lang.copy.to.e.that(src, len, Lang.generic.newArray(src, new_length), new_length, 0, len, read,
						read);
			}
			return src;
		}

	}

	public static class LCapacityLength {
		private LCapacityLength() {

		}

		public int ensure(boolean[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(boolean[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(boolean[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public int ensure(byte[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(byte[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(byte[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public int ensure(short[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(short[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(short[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public int ensure(char[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(char[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(char[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public int ensure(int[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(int[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(int[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public int ensure(long[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(long[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(long[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public int ensure(float[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(float[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(float[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public int ensure(double[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public int ensure(double[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public int ensure(double[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}

		public <T> int ensure(T[] src, int len, int required) {
			return ensure(src, len, required, false);
		}

		public <T> int ensure(T[] src, int len, int required, boolean restrict_to_requirements) {
			return ensure(src, len, required, restrict_to_requirements, Lang.constant.ARRAY_SAFE_CAPACITY);
		}

		public <T> int ensure(T[] src, int len, int required, boolean restrict_to_requirements, int max_allowed) {
			if ((required - len) - (src.length - len) > 0) {
				return newCapacity(src.length, required, restrict_to_requirements, max_allowed);
			}
			return len;
		}
	}

	private static int newCapacity(int len, int required, boolean restrict_to_requirements, int max_allowed) {
		int newlen = required;
		if (!restrict_to_requirements) {
			// ===========================
			// e.g: src_len = 5, required = 6
			// 5 = (0101) result: 10 (1010) + 2, so newlen = 12
			// ===========================
			newlen = (len << 1) + 2;
			// ===========================
			// make sure the required not causing to go below 0
			// e.g: newlen(12) - required(6) = 6, fine
			// but if, required = 15, then
			// newlen(12) - required(15) = -3, in such case, use required
			// ===========================
			int need = newlen - required;
			if (need < 0) {
				newlen = required;
			}
		}
		// ===========================
		// e.g: max_allowed = 10
		// if newlen < 0 or max_allowed(10) - newlen(-3) < 0, consider it as
		// huge-capacity, check if overflow
		// ===========================
		return (newlen <= 0 || max_allowed - newlen < 0) ? hugeCapacity(required, max_allowed) : newlen;
	}

	private static int hugeCapacity(int required, int max_allowed) {
		if (max_allowed - required < 0) { // overflow
			throw new IllegalArgumentException(String.format("required(%d) > max_allowed(%d)", required, max_allowed));
		}
		return required;
	}
}
