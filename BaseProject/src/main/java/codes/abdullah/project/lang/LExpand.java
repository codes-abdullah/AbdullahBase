package codes.abdullah.project.lang;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LExpand {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LExpand() {

	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public boolean[] at(boolean[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public byte[] at(byte[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public short[] at(short[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public char[] at(char[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public int[] at(int[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public long[] at(long[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public float[] at(float[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> By invoker (must have enough space for the size to be
	 * expended<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A (same as src-length)<br>
	 * <br>
	 * Expend given array based on given index and size, expending does nothing but
	 * copying elements away to make specific area ready for other data<br>
	 * <br>
	 * e.g: src: [1, 2, 3, 4, 5], index: 1, size: 2 <br>
	 * for demonstration purpose, will fill expended area with zeros<br>
	 * <br>
	 * read: {@link Endian#LITTLE}: <br>
	 * result: [1, <b>0, 0</b>, 2, 3] <br>
	 * <br>
	 * read: {@link Endian#BIG}: <br>
	 * result: [3, 4, <b>0, 0</b>, 5] <br>
	 * 
	 * @param arr   src array
	 * @param len   src length
	 * @param index index in which will start expending
	 * @param size  the expending size, an enough capacity required for the given
	 *              size
	 */
	public double[] at(double[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public <T> T[] at(T[] arr, int len, int index, int size) {
		try {
			final int disp = len - index;
			final int from0 = index;
			final int into0 = from0 + size;
			final int from = from0;
			// final int to = read.to(from0, to0, len, arr.length);
			final int into = into0;
			// final int cleanF0 = index + disp;
			// final int cleanT0 = len;
			// final int cleanF = read.from(cleanF0, cleanT0, len, arr.length);
			// final int cleanT = read.to(cleanF0, cleanT0, len, arr.length);
			// System.out.println();
			// System.out.printf("pres: from(%d), to(%d), into(%d), disp(%d), cleanF(%d),
			// cleanT(%d)\n", from0, to0, into0,
			// disp, cleanF0, cleanT0);
			//
			// System.out.printf("real: from(%d), to(%d), into(%d), disp(%d), cleanF(%d),
			// cleanT(%d)\n", from, to, into,
			// disp, cleanF, cleanT);
			System.arraycopy(arr, from, arr, into, disp);
			// fill(arr, len, 0, cleanF0, cleanT0);
		} catch (IndexOutOfBoundsException e) {
			checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
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
		 * @see #at(double[], int, int, int, Endian)
		 */
		public boolean[] at(boolean[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public boolean[] at(boolean[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public byte[] at(byte[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public byte[] at(byte[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public short[] at(short[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public short[] at(short[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public char[] at(char[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public char[] at(char[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public int[] at(int[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public int[] at(int[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public long[] at(long[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public long[] at(long[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public float[] at(float[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public float[] at(float[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public double[] at(double[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks and length<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> By invoker (must have enough space for the size to be
		 * expended<br>
		 * <b>Reallocate:</b> N/A<br>
		 * <b>New length:</b> N/A (same as src-length)<br>
		 * <br>
		 * Expend given array based on given index and size, expending does nothing but
		 * copying elements away to make specific area ready for other data<br>
		 * <br>
		 * e.g: src: [1, 2, 3, 4, 5], index: 1, size: 2 <br>
		 * for demonstration purpose, will fill expended area with zeros<br>
		 * <br>
		 * read: {@link Endian#LITTLE}: <br>
		 * result: [1, <b>0, 0</b>, 2, 3] <br>
		 * <br>
		 * read: {@link Endian#BIG}: <br>
		 * result: [3, 4, <b>0, 0</b>, 5] <br>
		 * 
		 * @param arr   src array
		 * @param len   src length
		 * @param index index in which will start expending
		 * @param size  the expending size, an enough capacity required for the given
		 *              size
		 * @param read  src endian
		 */
		public double[] at(double[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public <T> T[] at(T[] arr, int len, int index, int size) {
			return at(arr, len, index, size, Endian.LITTLE);
		}

		/**
		 * @see #at(double[], int, int, int, Endian)
		 */
		public <T> T[] at(T[] arr, int len, int index, int size, Endian read) {
			try {
				final int disp = len - index;
				final int from0 = index;
				final int to0 = index + disp;
				final int into0 = from0 + size;
				final int from = read.from(from0, to0, len, arr.length);
				// final int to = read.to(from0, to0, len, arr.length);
				final int into = read.insertIndex(into0, len, arr.length, disp);
				// final int cleanF0 = index + disp;
				// final int cleanT0 = len;
				// final int cleanF = read.from(cleanF0, cleanT0, len, arr.length);
				// final int cleanT = read.to(cleanF0, cleanT0, len, arr.length);
				// System.out.println();
				// System.out.printf("pres: from(%d), to(%d), into(%d), disp(%d), cleanF(%d),
				// cleanT(%d)\n", from0, to0, into0,
				// disp, cleanF0, cleanT0);
				//
				// System.out.printf("real: from(%d), to(%d), into(%d), disp(%d), cleanF(%d),
				// cleanT(%d)\n", from, to, into,
				// disp, cleanF, cleanT);
				System.arraycopy(arr, from, arr, into, disp);
				// fill(arr, len, 0, cleanF0, cleanT0, read);
			} catch (IndexOutOfBoundsException e) {
				checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			}
			return arr;
		}
	}

	static void checkExpendOrShrinkThrowdReason(IndexOutOfBoundsException e, int srclen, int len, int index, int size) {
		Check.index(index, len);
		Check.length(size, 0, len);
		Check.capacity(srclen, len + size,
				String.format("arr.len(%d), len(%d), index(%d), size(%d)", srclen, len, index, size));
		throw e;
	}
}
