package codes.abdullah.project.lang;

public class LSwap {
	LSwap() {

	}
	// =================================================
	// =================================================
	// ======================================= swap
	// =================================================
	// =================================================

	/**
	 * @see #with(double[], int, int, int)
	 */
	public boolean[] with(boolean[] arr, int len, int leftIndex, int rightIndex) {
		boolean tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

	/**
	 * @see #with(double[], int, int, int)
	 */
	public byte[] with(byte[] arr, int len, int leftIndex, int rightIndex) {
		byte tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

	/**
	 * @see #with(double[], int, int, int)
	 */
	public short[] with(short[] arr, int len, int leftIndex, int rightIndex) {
		short tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

	/**
	 * @see #with(double[], int, int, int)
	 */
	public char[] with(char[] arr, int len, int leftIndex, int rightIndex) {
		char tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}


	/**
	 * @see #with(double[], int, int, int)
	 */
	public int[] with(int[] arr, int len, int leftIndex, int rightIndex) {
		int tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

	/**
	 * @see #with(double[], int, int, int)
	 */
	public long[] with(long[] arr, int len, int leftIndex, int rightIndex) {
		long tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

	/**
	 * @see #with(double[], int, int, int)
	 */
	public float[] with(float[] arr, int len, int leftIndex, int rightIndex) {
		float tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

	/**
	 * <b>Note: </b> Invoker must take care with all checks<br>
	 * Swap the given values with given indexes
	 */
	public double[] with(double[] arr, int len, int leftIndex, int rightIndex) {
		double tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

	/**
	 * @see #with(double[], int, int, int)
	 */
	public <T> T[] with(T[] arr, int len, int leftIndex, int rightIndex) {
		T tmp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = tmp;
		return arr;
	}

}
