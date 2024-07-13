package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LEqual {

	/** {@link Endian} based implementation */
	public final E e = new E();

	LEqual() {

	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public boolean test(boolean[] a1, int len1, boolean[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public boolean test(byte[] a1, int len1, byte[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public boolean test(short[] a1, int len1, short[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public boolean test(char[] a1, int len1, char[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public boolean test(int[] a1, int len1, int[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public boolean test(long[] a1, int len1, long[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public boolean test(float[] a1, int len1, float[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * Test equalization of given arrays element by element
	 */
	public boolean test(double[] a1, int len1, double[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	/**
	 * @see #test(double[], int, double[], int)
	 */
	public <T> boolean test(T[] a1, int len1, T[] a2, int len2) {
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (!a1[i].equals(a2[i]))
				return false;
		return true;
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
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(boolean[] a1, int len1, boolean[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(boolean[] a1, int len1, boolean[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(boolean[] a1, int len1, boolean[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(byte[] a1, int len1, byte[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(byte[] a1, int len1, byte[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(byte[] a1, int len1, byte[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(short[] a1, int len1, short[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(short[] a1, int len1, short[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(short[] a1, int len1, short[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(char[] a1, int len1, char[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(char[] a1, int len1, char[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(char[] a1, int len1, char[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(int[] a1, int len1, int[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(int[] a1, int len1, int[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(int[] a1, int len1, int[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(long[] a1, int len1, long[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(long[] a1, int len1, long[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(long[] a1, int len1, long[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(float[] a1, int len1, float[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(float[] a1, int len1, float[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(float[] a1, int len1, float[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(double[] a1, int len1, double[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public boolean test(double[] a1, int len1, double[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * Test equalization based on given lengths and endians
		 */
		public boolean test(double[] a1, int len1, double[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (a1[read1.index(i, len1, a1.length)] != a2[read2.index(i, len2, a2.length)])
					return false;
			return true;
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public <T> boolean test(T[] a1, int len1, T[] a2, int len2) {
			return test(a1, len1, a2, len2, Endian.LITTLE);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public <T> boolean test(T[] a1, int len1, T[] a2, int len2, Endian read1) {
			return test(a1, len1, a2, len2, read1, read1);
		}

		/**
		 * @see #test(double[], int, double[], int, Endian, Endian)
		 */
		public <T> boolean test(T[] a1, int len1, T[] a2, int len2, Endian read1, Endian read2) {
			if (len1 != len2)
				return false;
			for (int i = 0; i < len1; i++)
				if (!a1[read1.index(i, len1, a1.length)].equals(a2[read2.index(i, len2, a2.length)]))
					return false;
			return true;
		}

	}
}
