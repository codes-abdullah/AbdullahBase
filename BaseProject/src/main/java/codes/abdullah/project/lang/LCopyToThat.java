package codes.abdullah.project.lang;

import java.util.Objects;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LCopyToThat {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LCopyToThat() {

	}

	// ======================= boolean[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= byte[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public byte[] that(byte[] in, int inlen, byte[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= short[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public short[] that(short[] in, int inlen, short[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public short[] that(short[] in, int inlen, short[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public short[] that(short[] in, int inlen, short[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public short[] that(short[] in, int inlen, short[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= char[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public char[] that(char[] in, int inlen, char[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public char[] that(char[] in, int inlen, char[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public char[] that(char[] in, int inlen, char[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public char[] that(char[] in, int inlen, char[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= int[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public int[] that(int[] in, int inlen, int[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public int[] that(int[] in, int inlen, int[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public int[] that(int[] in, int inlen, int[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public int[] that(int[] in, int inlen, int[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= long[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public long[] that(long[] in, int inlen, long[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public long[] that(long[] in, int inlen, long[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public long[] that(long[] in, int inlen, long[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public long[] that(long[] in, int inlen, long[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= float[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public float[] that(float[] in, int inlen, float[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public float[] that(float[] in, int inlen, float[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public float[] that(float[] in, int inlen, float[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public float[] that(float[] in, int inlen, float[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= double[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public double[] that(double[] in, int inlen, double[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public double[] that(double[] in, int inlen, double[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public double[] that(double[] in, int inlen, double[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> By invoker (need enough space to write at given index)<br>
	 * <b>Reallocate:</b> By invoker (output must not be null)<br>
	 * <b>New length:</b> By invoker<br>
	 * <br>
	 * Copy given array to given <code>output</code> array by the given range <br>
	 * 
	 * @param in           input src
	 * @param inlen        src length
	 * @param out          output array to write into it, non-null array
	 * @param from         copy from
	 * @param to           copy to
	 * @param writeAtIndex index to write at, output array must have enough space
	 *                     starting from this index
	 */
	public double[] that(double[] in, int inlen, double[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}
	// ======================= T[]

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public <T> T[] that(T[] in, int inlen, T[] out, int outlen) {
		return that(in, inlen, out, outlen, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from) {
		return that(in, inlen, out, outlen, from, inlen);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from, int to) {
		return that(in, inlen, out, outlen, from, to, 0);
	}

	/**
	 * @see #that(double[], int, double[], int, int, int, int)
	 */
	public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from, int to, int writeAtIndex) {
		if (inlen == 0) {
			return out;
		}
		to = Math.min(inlen, to);
		final int copylen = Math.min(inlen, to - from);
		final int rf = from;
		final int wat = writeAtIndex;
		try {
			System.arraycopy(in, rf, out, wat, copylen);
		} catch (ArrayIndexOutOfBoundsException e) {
			checkCopyThrowedReason(e, in, inlen, from, to, out, outlen, writeAtIndex, copylen);
		}
		return out;
	}

	private void checkCopyThrowedReason(RuntimeException e, Object in, int inlen, int from, int to, Object out,
			int outlen, int writeAtIndex, int copylen) {
		Objects.requireNonNull(in, "input array is null");
		Objects.requireNonNull(out, "output array is null");
		Check.insertIndex(writeAtIndex, Lang.constant.ARRAY_SAFE_CAPACITY - (to - from));
		Check.range(from, to, inlen);
		throw e;
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

		// =================================================
		// =================================================
		// ======================================= copy to
		// =================================================
		// =================================================

		// ======================= boolean[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from, int to, Endian read,
				Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public boolean[] that(boolean[] in, int inlen, boolean[] out, int outlen, int from, int to, Endian read,
				Endian write, int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= byte[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public byte[] that(byte[] in, int inlen, byte[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from, int to, Endian read, Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public byte[] that(byte[] in, int inlen, byte[] out, int outlen, int from, int to, Endian read, Endian write,
				int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= short[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public short[] that(short[] in, int inlen, short[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public short[] that(short[] in, int inlen, short[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public short[] that(short[] in, int inlen, short[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public short[] that(short[] in, int inlen, short[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public short[] that(short[] in, int inlen, short[] out, int outlen, int from, int to, Endian read,
				Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public short[] that(short[] in, int inlen, short[] out, int outlen, int from, int to, Endian read, Endian write,
				int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= char[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public char[] that(char[] in, int inlen, char[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public char[] that(char[] in, int inlen, char[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public char[] that(char[] in, int inlen, char[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public char[] that(char[] in, int inlen, char[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public char[] that(char[] in, int inlen, char[] out, int outlen, int from, int to, Endian read, Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public char[] that(char[] in, int inlen, char[] out, int outlen, int from, int to, Endian read, Endian write,
				int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.chararray.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= int[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public int[] that(int[] in, int inlen, int[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public int[] that(int[] in, int inlen, int[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public int[] that(int[] in, int inlen, int[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public int[] that(int[] in, int inlen, int[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public int[] that(int[] in, int inlen, int[] out, int outlen, int from, int to, Endian read, Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public int[] that(int[] in, int inlen, int[] out, int outlen, int from, int to, Endian read, Endian write,
				int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= long[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public long[] that(long[] in, int inlen, long[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public long[] that(long[] in, int inlen, long[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public long[] that(long[] in, int inlen, long[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public long[] that(long[] in, int inlen, long[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public long[] that(long[] in, int inlen, long[] out, int outlen, int from, int to, Endian read, Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public long[] that(long[] in, int inlen, long[] out, int outlen, int from, int to, Endian read, Endian write,
				int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= float[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public float[] that(float[] in, int inlen, float[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public float[] that(float[] in, int inlen, float[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public float[] that(float[] in, int inlen, float[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public float[] that(float[] in, int inlen, float[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public float[] that(float[] in, int inlen, float[] out, int outlen, int from, int to, Endian read,
				Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public float[] that(float[] in, int inlen, float[] out, int outlen, int from, int to, Endian read, Endian write,
				int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= double[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public double[] that(double[] in, int inlen, double[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public double[] that(double[] in, int inlen, double[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public double[] that(double[] in, int inlen, double[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public double[] that(double[] in, int inlen, double[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public double[] that(double[] in, int inlen, double[] out, int outlen, int from, int to, Endian read,
				Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks and length<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> By invoker (need enough space to write at given index<br>
		 * <b>Reallocate:</b> By invoker (output must not be null)<br>
		 * <b>New length:</b> By invoker<br>
		 * <br>
		 * Copy given array to given <code>output</code> array by the given range <br>
		 * 
		 * @param in           input src
		 * @param inlen        src length
		 * @param out          output array to write into it, non-null array
		 * @param from         copy from
		 * @param to           copy to
		 * @param writeAtIndex index to write at, output array must have enough space
		 *                     starting from this index
		 * @param read         src endian
		 * @param write        output endian
		 */
		public double[] that(double[] in, int inlen, double[] out, int outlen, int from, int to, Endian read,
				Endian write, int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		// ======================= T[]

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public <T> T[] that(T[] in, int inlen, T[] out, int outlen) {
			return that(in, inlen, out, outlen, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from) {
			return that(in, inlen, out, outlen, from, inlen);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from, int to) {
			return that(in, inlen, out, outlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from, int to, Endian read) {
			return that(in, inlen, out, outlen, from, to, read, Endian.LITTLE);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from, int to, Endian read, Endian write) {
			return that(in, inlen, out, outlen, from, to, read, write, 0);
		}

		/**
		 * @see #that(double[], int, double[], int, int, int, Endian, Endian, int)
		 */
		public <T> T[] that(T[] in, int inlen, T[] out, int outlen, int from, int to, Endian read, Endian write,
				int writeAtIndex) {
			if (inlen == 0) {
				return out;
			}
			to = Math.min(inlen, to);
			final int copylen = Math.min(inlen, to - from);
			final int rf = read.from(from, to, inlen, in.length);
			final int wat = write.insertIndex(writeAtIndex, outlen, out.length, copylen);
			try {
				System.arraycopy(in, rf, out, wat, copylen);
				if (!read.equals(write)) {
					// reverse only the copied part
					int f = writeAtIndex;
					int t = writeAtIndex + copylen;
					out = Lang.reverse.e.in(out, outlen, f, t, write);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				checkCopyThrowedReason(e, in, inlen, from, to, read, out, outlen, writeAtIndex, write, copylen);
			}
			return out;
		}

		private void checkCopyThrowedReason(RuntimeException e, Object in, int inlen, int from, int to, Endian read,
				Object out, int outlen, int writeAtIndex, Endian write, int copylen) {
			Objects.requireNonNull(in, "input array is null");
			Objects.requireNonNull(out, "output array is null");
			Objects.requireNonNull(read, "read endian is null");
			Objects.requireNonNull(write, "write endian is null");
			Check.insertIndex(writeAtIndex, Lang.constant.ARRAY_SAFE_CAPACITY - (to - from));
			Check.range(from, to, inlen);
			throw e;
		}
	}
}
