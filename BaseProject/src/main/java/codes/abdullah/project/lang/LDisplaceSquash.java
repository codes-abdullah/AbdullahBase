package codes.abdullah.project.lang;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LDisplaceSquash {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LDisplaceSquash() {

	}

	// ======================
	// ======================
	// ====================== boolean
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== byte
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public byte[] in(byte[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public byte[] in(byte[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public byte[] in(byte[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== short
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public short[] in(short[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public short[] in(short[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public short[] in(short[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== char
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public char[] in(char[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public char[] in(char[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public char[] in(char[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== int
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public int[] in(int[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public int[] in(int[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public int[] in(int[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== long
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public long[] in(long[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public long[] in(long[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public long[] in(long[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== float
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public float[] in(float[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public float[] in(float[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public float[] in(float[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== double
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public double[] in(double[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public double[] in(double[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public double[] in(double[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}
	// ======================
	// ======================
	// ====================== T
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public <T> T[] in(T[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public <T> T[] in(T[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public <T> T[] in(T[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
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

		// ======================
		// ======================
		// ====================== boolean
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== byte
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public byte[] in(byte[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== short
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public short[] in(short[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== char
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public char[] in(char[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== int
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public int[] in(int[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== long
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public long[] in(long[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== float
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public float[] in(float[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== double
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public double[] in(double[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}
		// ======================
		// ======================
		// ====================== T
		// ======================
		// ======================

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement, int from, int to) {
			return in(arr, len, displacement, from, to, 0);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement, int from, int to, int fromBorder) {
			return in(arr, len, displacement, from, to, fromBorder, len);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
			return in(arr, len, displacement, from, to, fromBorder, toBorder, Endian.LITTLE);
		}

		/**
		 * @see #in(double[], int, int, int, int, int, int, Endian)
		 */
		public <T> T[] in(T[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder,
				Endian read) {
			try {
				final boolean neg = (read.isLittle() && displacement < 0) || (read.isBig() && displacement > 0);
				displacement = Math.abs(displacement);
				final int from0 = read.from(from, to, len, arr.length);
				final int to0 = read.to(from, to, len, arr.length);
				final int bfrom0 = read.from(fromBorder, toBorder, len, arr.length);
				final int bto0 = read.to(fromBorder, toBorder, len, arr.length);
				int range = to0 - from0;
				int max_displacement = bto0 - from0 - 1;
				int copyinto = from0 + displacement;

				int copyfrom = from0;
				int remain = bto0 - (copyinto + range);
				int copylen = Math.min(range, range + remain);

				if (neg) {
					max_displacement = to0 - bfrom0 - 1;
					remain = from0 - bfrom0;
					copyinto = from0 - displacement;
					copylen = Math.min(range, range + (copyinto - bfrom0));
					copyinto = Math.max(bfrom0, from0 - displacement);
					copyfrom = to0 - copylen;
				}

				if (displacement > max_displacement)
					return arr;

				System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
			} catch (Exception e) {
				checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, read);
			}
			return arr;
		}

	}

	private static void checkDisplacementException(Exception e, Object arr, int len, int displacement, int from, int to,
			int fromBorder, int toBorder, Endian read) {
		Check.range(from, to, len, 0, "invalid displace-range");
		Check.range(fromBorder, toBorder, len, 0, "invalid border-range");
		e.printStackTrace();
	}
}
