package codes.abdullah.project.lang;

import java.util.Arrays;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LToString {
	/** {@link Endian} based implementation */
	public final E e = new E();

	LToString() {

	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(boolean[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(boolean[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(boolean[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(byte[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(byte[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(byte[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(short[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(short[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(short[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(char[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(char[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(char[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(int[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(int[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(int[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(long[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(long[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(long[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(float[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(float[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(float[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(double[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public String of(double[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * Do exactly like {@link Arrays#of(Object[])}, with extra futures such as,
	 * range, len, read and write {@link Endian}
	 * 
	 * @param arr
	 * @param len
	 * @param from inclusive from index, by default <code>0</code>
	 * @param to   exclusive to index, by default <code>len</code>
	 * 
	 * @throws IndexOutOfBoundsException see {@link Check#range(int, int, int, int)}
	 */
	public String of(double[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public <T> String of(T[] arr, int len) {
		return of(arr, len, 0);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public <T> String of(T[] arr, int len, int from) {
		return of(arr, len, from, len);
	}

	/**
	 * @see #of(double[], int, int, int)
	 */
	public <T> String of(T[] arr, int len, int from, int to) {
		if (arr == null)
			return "null";
		if (len == 0 || arr.length == 0)
			return "[]";

		Check.range(from, to, len);
		StringBuilder sb = new StringBuilder();
		sb.insert(sb.length(), String.valueOf(arr[from]));
		while (++from < to) {
			sb.insert(sb.length(), ", ").insert(sb.length(), arr[from]);
		}
		return sb.insert(0, "[").append("]").toString();
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
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(boolean[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(boolean[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(boolean[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(boolean[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(boolean[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(byte[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(byte[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(byte[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(byte[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(byte[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(short[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(short[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(short[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(short[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(short[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(char[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(char[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(char[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(char[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(char[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(int[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(int[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(int[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(int[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(int[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(long[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(long[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(long[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(long[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(long[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(float[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(float[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(float[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(float[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(float[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(double[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(double[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(double[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public String of(double[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * Do exactly like {@link Arrays#of(Object[])}, with extra futures such as,
		 * range, len, read and write {@link Endian}
		 * 
		 * @param arr
		 * @param len
		 * @param from  inclusive from index, by default <code>0</code>
		 * @param to    exclusive to index, by default <code>len</code>
		 * @param read  endian used to read from given arr, by default:
		 *              {@link Endian#LITTLE}
		 * @param write endian used to write into output string, by default:
		 *              <code>read</code>
		 * 
		 * @throws IndexOutOfBoundsException see {@link Check#range(int, int, int, int)}
		 */
		public String of(double[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> String of(T[] arr, int len) {
			return of(arr, len, 0);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> String of(T[] arr, int len, int from) {
			return of(arr, len, from, len);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> String of(T[] arr, int len, int from, int to) {
			return of(arr, len, from, to, Endian.LITTLE);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> String of(T[] arr, int len, int from, int to, Endian read) {
			return of(arr, len, from, to, read, read);
		}

		/**
		 * @see #of(double[], int, int, int, Endian, Endian)
		 */
		public <T> String of(T[] arr, int len, int from, int to, Endian read, Endian write) {
			if (arr == null)
				return "null";
			if (len == 0 || arr.length == 0)
				return "[]";

			Check.range(from, to, len);
			final boolean little = write.isLittle();
			StringBuilder sb = new StringBuilder();
			sb.insert(little ? sb.length() : 0, String.valueOf(arr[read.index(from, len, arr.length)]));
			while (++from < to) {
				sb.insert(little ? sb.length() : 0, ", ").insert(little ? sb.length() : 0,
						arr[read.index(from, len, arr.length)]);
			}
			return sb.insert(0, "[").append("]").toString();
		}

	}
}
