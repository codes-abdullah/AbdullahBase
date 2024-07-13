package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LShrink {
	/** {@link Endian} based implementation */
	public final E e = new E();

	LShrink() {

	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public boolean[] at(boolean[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public byte[] at(byte[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public short[] at(short[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public char[] at(char[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public int[] at(int[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public long[] at(long[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public float[] at(float[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A (same as src-length)<br>
	 * <br>
	 * Shrink given array based on given index and size, shrinking does nothing but
	 * copying elements away to make specific area ready for other data<br>
	 * <br>
	 * e.g: src: [1, 2, 3, 4, 5], index: 1, size: 3 <br>
	 * for demonstration purpose, will fill shrank area with zeros<br>
	 * <br>
	 * read: {@link Endian#LITTLE}: <br>
	 * result: [1, <b>5</b>, 0, 0, 0] <br>
	 * <br>
	 * read: {@link Endian#BIG}: <br>
	 * result: [0, 0, 0, <b>1</b>, 5] <br>
	 * 
	 * @param arr   src array
	 * @param len   src length
	 * @param index index in which will start expending
	 * @param size  the expending size, an enough capacity required for the given
	 *              size
	 */
	public double[] at(double[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;
			final int from = from0;
			final int into0 = index;
			final int into = into0;
			System.arraycopy(arr, from, arr, into, disp);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
		}
		return arr;
	}

	/**
	 * @see #at(double[], int, int, int)
	 */
	public <T> T[] at(T[] arr, int len, int index, int size) {
		try {
			final int from0 = index + size;
			final int to0 = (len - index) + index;
			final int disp = to0 - from0;

			final int from = from0;
//			final int to = read.to(from0, to0, len, arr.length);
			final int into0 = index;
			final int into = into0;
//			final int cleanF0 = index + disp;
//			final int cleanT0 = len;
//			final int cleanF = read.from(cleanF0, cleanT0, len, arr.length);
//			final int cleanT = read.to(cleanF0, cleanT0, len, arr.length);
//			System.out.println();
//			System.out.printf("pres: from(%d), to(%d), into(%d), disp(%d), cleanF(%d), cleanT(%d)\n", from0, to0, into0,
//					disp, cleanF0, cleanT0);
//			
//			System.out.printf("real: from(%d), to(%d), into(%d), disp(%d), cleanF(%d), cleanT(%d)\n", from, to, into,
//					disp, cleanF, cleanT);
			System.arraycopy(arr, from, arr, into, disp);
//			fill(arr, len, 0, cleanF0, cleanT0);
		} catch (IndexOutOfBoundsException e) {
			LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
			throw e;
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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
			}
			return arr;
		}
		// [c, o, d, e, s, ., a, b, d, u, l, l, a, h]

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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
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
		 * <b>Capacity:</b> N/A<br>
		 * <b>Reallocate:</b> N/A<br>
		 * <b>New length:</b> N/A (same as src-length)<br>
		 * <br>
		 * Shrink given array based on given index and size, shrinking does nothing but
		 * copying elements away to make specific area ready for other data<br>
		 * <br>
		 * e.g: src: [1, 2, 3, 4, 5], index: 1, size: 3 <br>
		 * for demonstration purpose, will fill shrank area with zeros<br>
		 * <br>
		 * read: {@link Endian#LITTLE}: <br>
		 * result: [1, <b>5</b>, 0, 0, 0] <br>
		 * <br>
		 * read: {@link Endian#BIG}: <br>
		 * result: [0, 0, 0, <b>1</b>, 5] <br>
		 * 
		 * @param arr   src array
		 * @param len   src length
		 * @param index index in which will start expending
		 * @param size  the expending size, an enough capacity required for the given
		 *              size
		 * @param read  read endian
		 */
		public double[] at(double[] arr, int len, int index, int size, Endian read) {
			try {
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;
				final int from = read.from(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
				System.arraycopy(arr, from, arr, into, disp);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
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
				final int from0 = index + size;
				final int to0 = (len - index) + index;
				final int disp = to0 - from0;

				final int from = read.from(from0, to0, len, arr.length);
//				final int to = read.to(from0, to0, len, arr.length);
				final int into0 = index;
				final int into = read.insertIndex(into0, len, arr.length, disp);
//				final int cleanF0 = index + disp;
//				final int cleanT0 = len;
//				final int cleanF = read.from(cleanF0, cleanT0, len, arr.length);
//				final int cleanT = read.to(cleanF0, cleanT0, len, arr.length);
//				System.out.println();
//				System.out.printf("pres: from(%d), to(%d), into(%d), disp(%d), cleanF(%d), cleanT(%d)\n", from0, to0, into0,
//						disp, cleanF0, cleanT0);
//				
//				System.out.printf("real: from(%d), to(%d), into(%d), disp(%d), cleanF(%d), cleanT(%d)\n", from, to, into,
//						disp, cleanF, cleanT);
				System.arraycopy(arr, from, arr, into, disp);
//				fill(arr, len, 0, cleanF0, cleanT0, read);
			} catch (IndexOutOfBoundsException e) {
				LExpand.checkExpendOrShrinkThrowdReason(e, arr.length, len, index, size);
				throw e;
			}
			return arr;
		}

	}
}
