package codes.abdullah.project.lang;

public class LWrapper {

	LWrapper() {

	}

	/**
	 * @return wrapper equivalent of given primitive
	 * @throws UnsupportedOperationException if given is not supported
	 * @throws IllegalArgumentException      if given class is not primitive
	 */
	public Class<?> wrapperOf(Class<?> n) {
		if (!n.isPrimitive())
			throw new IllegalArgumentException("not primitve: " + n);
		if (n == byte.class) {
			return Byte.class;
		} else if (n == short.class) {
			return Short.class;
		} else if (n == char.class) {
			return Character.class;
		} else if (n == int.class) {
			return Integer.class;
		} else if (n == long.class) {
			return Long.class;
		} else if (n == float.class) {
			return Float.class;
		} else if (n == double.class) {
			return Double.class;
		} else {
			throw new UnsupportedOperationException(n.toString());
		}
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Boolean[] wrap(boolean[] src) {
		return wrap(src, new Boolean[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Boolean[] wrap(boolean[] src, Boolean[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Boolean[] wrap(boolean[] src, Boolean[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Byte[] wrap(byte[] src) {
		return wrap(src, new Byte[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Byte[] wrap(byte[] src, Byte[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Byte[] wrap(byte[] src, Byte[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Short[] wrap(short[] src) {
		return wrap(src, new Short[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Short[] wrap(short[] src, Short[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Short[] wrap(short[] src, Short[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Character[] wrap(char[] src) {
		return wrap(src, new Character[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Character[] wrap(char[] src, Character[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Character[] wrap(char[] src, Character[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Integer[] wrap(int[] src) {
		return wrap(src, new Integer[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Integer[] wrap(int[] src, Integer[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Integer[] wrap(int[] src, Integer[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Long[] wrap(long[] src) {
		return wrap(src, new Long[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Long[] wrap(long[] src, Long[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Long[] wrap(long[] src, Long[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Float[] wrap(float[] src) {
		return wrap(src, new Float[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Float[] wrap(float[] src, Float[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Float[] wrap(float[] src, Float[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Double[] wrap(double[] src) {
		return wrap(src, new Double[src.length]);
	}

	/**
	 * @see #wrap(double[], Double[], int)
	 */
	public Double[] wrap(double[] src, Double[] buf) {
		return wrap(src, buf, buf.length);
	}

	/**
	 * convert from primitive-array to wrapper-array, the copy will be applied to
	 * the given buffer, for the given length
	 */
	public Double[] wrap(double[] src, Double[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public boolean[] unwrap(Boolean[] src) {
		return unwrap(src, new boolean[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public boolean[] unwrap(Boolean[] src, boolean[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public boolean[] unwrap(Boolean[] src, boolean[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public byte[] unwrap(Byte[] src) {
		return unwrap(src, new byte[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public byte[] unwrap(Byte[] src, byte[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public byte[] unwrap(Byte[] src, byte[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public short[] unwrap(Short[] src) {
		return unwrap(src, new short[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public short[] unwrap(Short[] src, short[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public short[] unwrap(Short[] src, short[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public char[] unwrap(Character[] src) {
		return unwrap(src, new char[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public char[] unwrap(Character[] src, char[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public char[] unwrap(Character[] src, char[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public int[] unwrap(Integer[] src) {
		return unwrap(src, new int[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public int[] unwrap(Integer[] src, int[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public int[] unwrap(Integer[] src, int[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public long[] unwrap(Long[] src) {
		return unwrap(src, new long[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public long[] unwrap(Long[] src, long[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public long[] unwrap(Long[] src, long[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public float[] unwrap(Float[] src) {
		return unwrap(src, new float[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public float[] unwrap(Float[] src, float[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public float[] unwrap(Float[] src, float[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public double[] unwrap(Double[] src) {
		return unwrap(src, new double[src.length]);
	}

	/**
	 * @see #unwrap(Double[], double[], int)
	 */
	public double[] unwrap(Double[] src, double[] buf) {
		return unwrap(src, buf, buf.length);
	}

	/**
	 * convert from wrapper-array to primitive-array, the copy will be applied to
	 * the given buffer, for the given length
	 */
	public double[] unwrap(Double[] src, double[] buf, int length) {
		for (int i = 0; i < length; i++) {
			buf[i] = src[i];
		}
		return buf;
	}

}
