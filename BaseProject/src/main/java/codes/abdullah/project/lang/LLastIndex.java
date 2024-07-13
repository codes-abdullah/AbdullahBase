package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LLastIndex {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LLastIndex() {

	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(boolean[] arr, int len, boolean target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(boolean[] arr, int len, boolean target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(boolean[] arr, int len, boolean target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(byte[] arr, int len, byte target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(byte[] arr, int len, byte target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(byte[] arr, int len, byte target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(short[] arr, int len, short target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(short[] arr, int len, short target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(short[] arr, int len, short target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(char[] arr, int len, char target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(char[] arr, int len, char target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(char[] arr, int len, char target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(int[] arr, int len, int target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(int[] arr, int len, int target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(int[] arr, int len, int target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(long[] arr, int len, long target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(long[] arr, int len, long target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(long[] arr, int len, long target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(float[] arr, int len, float target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(float[] arr, int len, float target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(float[] arr, int len, float target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(double[] arr, int len, double target) {
		return of(arr, len, target, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public int of(double[] arr, int len, double target, int from) {
		return of(arr, len, target, from, len);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks<br>
	 * Find last index of given target based on range
	 * 
	 * @param arr    src array
	 * @param len    src length
	 * @param target target to find it's index
	 * @param from   exclusive from index (right-side), by default: <code>len</code>
	 * @param to     inclusive to index (left-side), by default: <code>0</code>
	 * @return {@link LConstants#INDEX_NOT_FOUND} if not found
	 */
	public int of(double[] arr, int len, double target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target == arr[from]) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public <T> int of(T[] arr, int len, T target) {
		return of(arr, len, target, len);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public <T> int of(T[] arr, int len, T target, int from) {
		return of(arr, len, target, from, 0);
	}

	/**
	 * @see #of(double[], int, double, int, int)
	 */
	public <T> int of(T[] arr, int len, T target, int from, int to) {
		from = Math.min(from, len - 1);
		for (; from >= to; from--) {
			if (target.equals(arr[from])) {
				return from;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
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
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(boolean[] arr, int len, boolean target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(boolean[] arr, int len, boolean target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(boolean[] arr, int len, boolean target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(boolean[] arr, int len, boolean target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(byte[] arr, int len, byte target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(byte[] arr, int len, byte target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(byte[] arr, int len, byte target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(byte[] arr, int len, byte target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(short[] arr, int len, short target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(short[] arr, int len, short target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(short[] arr, int len, short target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(short[] arr, int len, short target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(char[] arr, int len, char target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(char[] arr, int len, char target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(char[] arr, int len, char target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(char[] arr, int len, char target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(int[] arr, int len, int target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(int[] arr, int len, int target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(int[] arr, int len, int target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(int[] arr, int len, int target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(long[] arr, int len, long target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(long[] arr, int len, long target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(long[] arr, int len, long target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(long[] arr, int len, long target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(float[] arr, int len, float target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(float[] arr, int len, float target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(float[] arr, int len, float target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(float[] arr, int len, float target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(double[] arr, int len, double target) {
			return of(arr, len, target, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(double[] arr, int len, double target, int from) {
			return of(arr, len, target, from, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public int of(double[] arr, int len, double target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks<br>
		 * Find last index of given target based on range
		 * 
		 * @param arr    src array
		 * @param len    src length
		 * @param target target to find it's index
		 * @param from   exclusive from index (right-side for little endian and
		 *               left-index for big endian), by default: <code>len</code>
		 * @param to     inclusive to index (left-side for little endian and right-index
		 *               for big endian), by default: <code>0</code>
		 * @param read   endian used to read given array, by default:
		 *               {@link Endian#LITTLE}
		 * @return {@link LConstants#INDEX_NOT_FOUND} if not found
		 */
		public int of(double[] arr, int len, double target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target == arr[read.index(from, len, arr.length)]) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public <T> int of(T[] arr, int len, T target) {
			return of(arr, len, target, len);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public <T> int of(T[] arr, int len, T target, int from) {
			return of(arr, len, target, from, 0);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public <T> int of(T[] arr, int len, T target, int from, int to) {
			return of(arr, len, target, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, double, int, int, Endian)
		 */
		public <T> int of(T[] arr, int len, T target, int from, int to, Endian read) {
			from = Math.min(from, len - 1);
			for (; from >= to; from--) {
				if (target.equals(arr[read.index(from, len, arr.length)])) {
					return from;
				}
			}
			return Lang.constant.INDEX_NOT_FOUND;
		}
	}
}
