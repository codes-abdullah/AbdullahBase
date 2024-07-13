package codes.abdullah.project.lang;

import java.util.Comparator;

import codes.abdullah.project.Endian;
import codes.abdullah.project.ObjectComparator;

public class LCompare {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LCompare() {

	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public int test(boolean[] a1, int l1, boolean[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Boolean.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public int test(byte[] a1, int l1, byte[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Byte.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public int test(short[] a1, int l1, short[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Short.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public int test(char[] a1, int l1, char[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Character.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	public int test(char[] a, int alen, char[] b, int blen, boolean ignoreCase) {
		int len1 = alen;
		int len2 = blen;
		int min = Math.min(len1, len2);
		char c1;
		char c2;
		if (!ignoreCase) {
			int k = 0;
			while (k < min) {
				c1 = a[k];
				c2 = b[k];
				if (c1 != c2) {
					return c1 - c2;
				}
				k++;
			}
		} else {
			for (int i = 0; i < min; i++) {
				c1 = a[i];
				c2 = b[i];
				if (c1 != c2) {
					c1 = Character.toUpperCase(c1);
					c2 = Character.toUpperCase(c2);
					if (c1 != c2) {
						c1 = Character.toLowerCase(c1);
						c2 = Character.toLowerCase(c2);
						if (c1 != c2) {
							return c1 - c2;
						}
					}
				}
			}
		}
		return len1 - len2;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public int test(int[] a1, int l1, int[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Integer.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public int test(long[] a1, int l1, long[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Long.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public int test(float[] a1, int l1, float[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Float.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	/**
	 * Compare two arrays based on given lengths <br>
	 * 
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> N/A<br>
	 * <b>New length:</b> N/A<br>
	 * <br>
	 */
	public int test(double[] a1, int l1, double[] a2, int l2) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = Double.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public <T> int test(T[] a1, int l1, T[] a2, int l2) {
		return test(a1, l1, a2, l2, ObjectComparator.INSTANCE);
	}

	/**
	 * @see ObjectComparator
	 */
	public <T> int test(T[] a1, int l1, T[] a2, int l2, Comparator<T> comp) {
		if (a1 == a2)
			return 0;
		if (l1 != l2)
			return Integer.compare(l1, l2);
		int c = 0;
		for (int i = 0; i < l1; i++)
			if ((c = comp.compare(a1[i], a2[i])) != 0)
				return c;
		return 0;
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
		// ======================================= compare
		// =================================================
		// =================================================

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(boolean[] a1, int l1, boolean[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(boolean[] a1, int l1, boolean[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(boolean[] a1, int l1, boolean[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Boolean.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(byte[] a1, int l1, byte[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(byte[] a1, int l1, byte[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(byte[] a1, int l1, byte[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Byte.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(short[] a1, int l1, short[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(short[] a1, int l1, short[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(short[] a1, int l1, short[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Short.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(char[] a1, int l1, char[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(char[] a1, int l1, char[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(char[] a1, int l1, char[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Character.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(int[] a1, int l1, int[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(int[] a1, int l1, int[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(int[] a1, int l1, int[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Integer.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(long[] a1, int l1, long[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(long[] a1, int l1, long[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(long[] a1, int l1, long[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Long.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(float[] a1, int l1, float[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(float[] a1, int l1, float[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(float[] a1, int l1, float[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Float.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(double[] a1, int l1, double[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public int test(double[] a1, int l1, double[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * Compare two arrays based on given lengths and read {@link Endian}
		 */
		public int test(double[] a1, int l1, double[] a2, int l2, Endian read1, Endian read2) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = Double.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public <T> int test(T[] a1, int l1, T[] a2, int l2) {
			return test(a1, l1, a2, l2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public <T> int test(T[] a1, int l1, T[] a2, int l2, Endian read1) {
			return test(a1, l1, a2, l2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public <T> int test(T[] a1, int l1, T[] a2, int l2, Endian read1, Endian read2) {
			return test(a1, l1, a2, l2, read1, read2, ObjectComparator.INSTANCE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 * @see ObjectComparator
		 */
		public <T> int test(T[] a1, int l1, T[] a2, int l2, Endian read1, Endian read2, Comparator<T> comp) {
			if (a1 == a2)
				return 0;
			if (l1 != l2)
				return Integer.compare(l1, l2);
			int c = 0;
			for (int i = 0; i < l1; i++)
				if ((c = comp.compare(a1[read1.index(i, l1, a1.length)], a2[read2.index(i, l2, a2.length)])) != 0)
					return c;
			return 0;
		}
	}
}
