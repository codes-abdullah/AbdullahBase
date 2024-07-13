package codes.abdullah.project.lang;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LDisplaceMove {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LDisplaceMove() {

	}
	// =================================================
	// =================================================
	// ======================================= displace
	// =================================================
	// =================================================

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// ==================
			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public byte[] in(byte[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public byte[] in(byte[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public byte[] in(byte[] arr, int len, int displacement, int from, int to) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// ==================
			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public short[] in(short[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public short[] in(short[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public short[] in(short[] arr, int len, int displacement, int from, int to) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// ==================
			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public char[] in(char[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public char[] in(char[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public char[] in(char[] arr, int len, int displacement, int from, int to) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// ==================
			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public int[] in(int[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public int[] in(int[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public int[] in(int[] arr, int len, int displacement, int from, int to) {
		try {
			//2:9 -> 9
			//co[des.abd]ullah
			//co[des.abd]ullde
			//codes.abdullah
			//codes.abdudes.abd
			//codedes.abdlah
			//6:13 (7) -> 7
			//codes.abdullah
			//codes.abdullaabdulla
			//6:14(8) -> 14
			//codes.abdullah.java.c++.run
			//codes.abdullah.java.abdulla[h]
			final int from0 = from;
			final int to0 = to;
			final int copylen = to0 - from0;
			// =================
			int copyfrom = from0;
			int copyinto = from0 + displacement;
			// ==================
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public long[] in(long[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public long[] in(long[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public long[] in(long[] arr, int len, int displacement, int from, int to) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// ==================
			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public float[] in(float[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public float[] in(float[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public float[] in(float[] arr, int len, int displacement, int from, int to) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// ==================
			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public double[] in(double[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public double[] in(double[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A, no additional space required<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A (same as src-length)<br>
	 * <br>
	 * Displace range in elements based given positive/negative displacement
	 * e.g:<br>
	 * (displaced elements will be represented by 00 for demonstration purpose)<br>
	 * 
	 * <pre>
	 * Endian: LITTLE
	 * 10, 20, {30, 40, 50, 60, 70, 80, 90}, 100 (source)
	 * 10, 20, {<b>00, 00, 00, 00, 00</b>, 30, 40}, 100, -> positive by 5
	 * 10, 20, {80, 90, <b>00, 00, 00, 00, 00</b>}, 100, <- negative by -5
	 * 
	 * Endian: BIG
	 * 100, {90, 80, 70, 60, 50, 40, 30}, 20, 10 (source)
	 * 100, {40, 30, <b>00, 00, 00, 00, 00</b>}, 20, 10, -> negative by -5
	 * 100, {<b>00, 00, 00, 00, 00</b>, 90, 80}, 20, 10, <- positive by 5
	 * </pre>
	 * 
	 * @param arr          src array
	 * @param len          src length
	 * @param displacement displacement amount, can be positive and negative
	 * @param from         displacement applied from given range (inclusive)
	 * @param to           displacement applied to given range (exclusive)
	 * 
	 */
	public double[] in(double[] arr, int len, int displacement, int from, int to) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// ==================
			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
			throw e;
		}
		return arr;
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public <T> T[] in(T[] arr, int len, int displacement) {
		return in(arr, len, displacement, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public <T> T[] in(T[] arr, int len, int displacement, int from) {
		return in(arr, len, displacement, from, len);
	}

	/**
	 * @see #in(double[], int, int, int, int)
	 */
	public <T> T[] in(T[] arr, int len, int displacement, int from, int to) {
		try {
			// 10, 20, {30, 40, 50, 60, 70, 80, 90}, 100 (source)
			// 10, 20, {00, 00, 00, 00, 00, 30, 40}, 100, positive ->
			// 10, 20, {80, 90, 00, 00, 00, 00, 00}, 100, <- negative
			// =========================
			// 100, {90, 80, 70, 60, 50, 40, 30}, 20, 10 (source)
			// 100, {40, 30, 00, 00, 00, 00, 00}, 20, 10, negative ->
			// 100, {00, 00, 00, 00, 00, 90, 80}, 20, 10, <- positive
			// ==================
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int range = to0 - from0;
			// =================
			int copylen = range - displacement;
			int copyfrom = from0 + 0;
			int copyinto = from0 + displacement;
			// =================
			// int fillfrom = from;
			// int fillto = fillfrom + displacement;
			// int fillfrom0 = read.from(fillfrom, fillto, len, arr.length);
			// int fillto0 = read.to(fillfrom, fillto, len, arr.length);
			// =================

			if (neg) {
				copyfrom = from0 + displacement;
				copyinto = from0 + 0;
				// fillfrom = from + copylen;
				// fillto = fillfrom + displacement;
				// fillfrom0 = read.from(fillfrom, fillto, len, arr.length);
				// fillto0 = read.to(fillfrom, fillto, len, arr.length);
			}
			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			// arr = fill(arr, len, 0, fillfrom0, fillto0);
			// System.out.println(Arrays.toString(arr));
		} catch (IndexOutOfBoundsException e) {
			Check.range(from, to, len);
			if (!Check.isValidLength(displacement, 1, to - from)) {
				throw new IndexOutOfBoundsException(
						String.format("displacement(%d) > range(%d)", displacement, to - from));
			}
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
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int copylen = to0 - from0;
				// =================
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks and length<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> N/A, no additional space required<br>
		 * <b>Reallocate:</b> N/A<br>
		 * <b>New length:</b> N/A (same as src-length)<br>
		 * <br>
		 * Displace range in elements based given positive/negative displacement
		 * e.g:<br>
		 * (displaced elements will be represented by 00 for demonstration purpose)<br>
		 * 
		 * <pre>
		 * Endian: LITTLE
		 * 10, 20, {30, 40, 50, 60, 70, 80, 90}, 100 (source)
		 * 10, 20, {<b>00, 00, 00, 00, 00</b>, 30, 40}, 100, -> positive by 5
		 * 10, 20, {80, 90, <b>00, 00, 00, 00, 00</b>}, 100, <- negative by -5
		 * 
		 * Endian: BIG
		 * 100, {90, 80, 70, 60, 50, 40, 30}, 20, 10 (source)
		 * 100, {40, 30, <b>00, 00, 00, 00, 00</b>}, 20, 10, -> negative by -5
		 * 100, {<b>00, 00, 00, 00, 00</b>, 90, 80}, 20, 10, <- positive by 5
		 * </pre>
		 * 
		 * @param arr          src array
		 * @param len          src length
		 * @param displacement displacement amount, can be positive and negative
		 * @param from         displacement applied from given range (inclusive)
		 * @param to           displacement applied to given range (exclusive)
		 * @param read         src endian
		 */
		public double[] in(double[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// ==================
				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement) {
			return in(arr, len, displacement, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement, int from) {
			return in(arr, len, displacement, from, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement, int from, int to, Endian read) {
			try {
				// 10, 20, {30, 40, 50, 60, 70, 80, 90}, 100 (source)
				// 10, 20, {00, 00, 00, 00, 00, 30, 40}, 100, positive ->
				// 10, 20, {80, 90, 00, 00, 00, 00, 00}, 100, <- negative
				// =========================
				// 100, {90, 80, 70, 60, 50, 40, 30}, 20, 10 (source)
				// 100, {40, 30, 00, 00, 00, 00, 00}, 20, 10, negative ->
				// 100, {00, 00, 00, 00, 00, 90, 80}, 20, 10, <- positive
				// ==================
				final boolean neg = displacement < 0;
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int range = to0 - from0;
				// =================
				int copylen = range - displacement;
				int copyfrom = from0 + (read.isBig() ? displacement : 0);
				int copyinto = from0 + (read.isBig() ? 0 : displacement);
				// =================
				// int fillfrom = from;
				// int fillto = fillfrom + displacement;
				// int fillfrom0 = read.from(fillfrom, fillto, len, arr.length);
				// int fillto0 = read.to(fillfrom, fillto, len, arr.length);
				// =================

				if (neg) {
					copyfrom = from0 + (read.isBig() ? 0 : displacement);
					copyinto = from0 + (read.isBig() ? displacement : 0);
					// fillfrom = from + copylen;
					// fillto = fillfrom + displacement;
					// fillfrom0 = read.from(fillfrom, fillto, len, arr.length);
					// fillto0 = read.to(fillfrom, fillto, len, arr.length);
				}
				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
				// arr = fill(arr, len, 0, fillfrom0, fillto0);
				// System.out.println(Arrays.toString(arr));
			} catch (IndexOutOfBoundsException e) {
				Check.range(from, to, len);
				if (!Check.isValidLength(displacement, 1, to - from)) {
					throw new IndexOutOfBoundsException(
							String.format("displacement(%d) > range(%d)", displacement, to - from));
				}
				throw e;
			}
			return arr;
		}
	}
}
