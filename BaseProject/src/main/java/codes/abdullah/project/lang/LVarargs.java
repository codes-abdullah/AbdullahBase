package codes.abdullah.project.lang;

public class LVarargs {

	LVarargs() {

	}

	// =================================================
	// =================================================
	// ======================================= varargs
	// =================================================
	// =================================================

	/**
	 * @see #of(double...)
	 */
	public boolean[] of(boolean... a) {
		return a;
	}

	/**
	 * @see #of(double...)
	 */
	public byte[] of(byte... a) {
		return a;
	}

	/**
	 * @see #of(double...)
	 */
	public short[] of(short... a) {
		return a;
	}

	/**
	 * @see #of(double...)
	 */
	public char[] of(char... a) {
		return a;
	}

	/**
	 * @see #of(double...)
	 */
	public int[] of(int... a) {
		return a;
	}

	/**
	 * @see #of(double...)
	 */
	public long[] of(long... a) {
		return a;
	}

	/**
	 * @see #of(double...)
	 */
	public float[] of(float... a) {
		return a;
	}

	/**
	 * helper method to cheat compiler while work with varargs and to avoid facing
	 * ambiguous errors by compiler
	 */
	public double[] of(double... a) {
		return a;
	}


	@SuppressWarnings("unchecked")
	public <T> T[] of(T... a) {
		return a;
	}

	// =================================================
	// =================================================
	// ======================================= varargs - wrappers / unwraps
	// =================================================
	// =================================================

	/**
	 * @see #wrap(double...)
	 */
	public Boolean[] wrap(boolean... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * @see #wrap(double...)
	 */
	public Byte[] wrap(byte... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * @see #wrap(double...)
	 */
	public Short[] wrap(short... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * @see #wrap(double...)
	 */
	public Character[] wrap(char... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * @see #wrap(double...)
	 */
	public Integer[] wrap(int... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * @see #wrap(double...)
	 */
	public Long[] wrap(long... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * @see #wrap(double...)
	 */
	public Float[] wrap(float... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * wrap given varargs array
	 */
	public Double[] wrap(double... a) {
		return Lang.wrapper.wrap(a);
	}

	/**
	 * @see #unwrap(Double...)
	 */
	public boolean[] unwrap(Boolean... a) {
		return Lang.wrapper.unwrap(a);
	}

	/**
	 * @see #unwrap(Double...)
	 */
	public byte[] unwrap(Byte... a) {
		return Lang.wrapper.unwrap(a);
	}

	/**
	 * @see #unwrap(Double...)
	 */
	public short[] unwrap(Short... a) {
		return Lang.wrapper.unwrap(a);
	}

	/**
	 * @see #unwrap(Double...)
	 */
	public char[] unwrap(Character... a) {
		return Lang.wrapper.unwrap(a);
	}

	/**
	 * @see #unwrap(Double...)
	 */
	public int[] unwrap(Integer... a) {
		return Lang.wrapper.unwrap(a);
	}

	/**
	 * @see #unwrap(Double...)
	 */
	public long[] unwrap(Long... a) {
		return Lang.wrapper.unwrap(a);
	}

	/**
	 * @see #unwrap(Double...)
	 */
	public float[] unwrap(Float... a) {
		return Lang.wrapper.unwrap(a);
	}

	/**
	 * unwrap given varargs array
	 */
	public double[] unwrap(Double... a) {
		return Lang.wrapper.unwrap(a);
	}

}
