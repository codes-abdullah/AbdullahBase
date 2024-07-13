package codes.abdullah.project.lang;

import codes.abdullah.project.Endian;

public class LPrimitiveMerge {
	/** {@link Endian} based implementation */
	public final E e = new E();
	// ==================
	// ================== byte[]
	// ==================

	/** @see #longs(long[], int, long[], int) */
	public byte[] bytes(byte[] in, int inlen, byte[] with, int withlen) {
		int outlen = inlen + withlen;
		byte[] out = new byte[outlen];
		out = Lang.copy.to.that(in, inlen, out, outlen, 0, inlen, 0);
		out = Lang.copy.to.that(with, withlen, out, outlen, 0, withlen, inlen);
		return out;
	}

	/** @see #longs(long[], int, long[], int) */
	public byte[] bytes(byte[] in, int inlen, short[] with, int withlen) {
		byte[] with2 = Lang.primitive.to.bytes(with, withlen, 0, withlen, null, 0);
		return bytes(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public byte[] bytes(byte[] in, int inlen, char[] with, int withlen) {
		byte[] with2 = Lang.primitive.to.bytes(with, withlen, 0, withlen, null, 0);
		return bytes(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public byte[] bytes(byte[] in, int inlen, int[] with, int withlen) {
		byte[] with2 = Lang.primitive.to.bytes(with, withlen, 0, withlen, null, 0);
		return bytes(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public byte[] bytes(byte[] in, int inlen, long[] with, int withlen) {
		byte[] with2 = Lang.primitive.to.bytes(with, withlen, 0, withlen, null, 0);
		return bytes(in, inlen, with2, with2.length);
	}

	// ==================
	// ================== short[]
	// ==================

	/** @see #longs(long[], int, long[], int) */
	public short[] shorts(short[] in, int inlen, byte[] with, int withlen) {
		short[] with2 = Lang.primitive.to.shorts(with, withlen, 0, withlen, null, 0);
		return shorts(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public short[] shorts(short[] in, int inlen, short[] with, int withlen) {
		int outlen = inlen + withlen;
		short[] out = new short[outlen];
		out = Lang.copy.to.that(in, inlen, out, outlen, 0, inlen, 0);
		out = Lang.copy.to.that(with, withlen, out, outlen, 0, withlen, inlen);
		return out;
	}

	/** @see #longs(long[], int, long[], int) */
	public short[] shorts(short[] in, int inlen, char[] with, int withlen) {
		short[] with2 = Lang.primitive.to.shorts(with, withlen, 0, withlen, null, 0);
		return shorts(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public short[] shorts(short[] in, int inlen, int[] with, int withlen) {
		short[] with2 = Lang.primitive.to.shorts(with, withlen, 0, withlen, null, 0);
		return shorts(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public short[] shorts(short[] in, int inlen, long[] with, int withlen) {
		short[] with2 = Lang.primitive.to.shorts(with, withlen, 0, withlen, null, 0);
		return shorts(in, inlen, with2, with2.length);
	}

	// ==================
	// ================== char[]
	// ==================

	/** @see #longs(long[], int, long[], int) */
	public char[] chars(char[] in, int inlen, byte[] with, int withlen) {
		char[] with2 = Lang.primitive.to.chars(with, withlen, 0, withlen, null, 0);
		return chars(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public char[] chars(char[] in, int inlen, short[] with, int withlen) {
		char[] with2 = Lang.primitive.to.chars(with, withlen, 0, withlen, null, 0);
		return chars(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public char[] chars(char[] in, int inlen, char[] with, int withlen) {
		int outlen = inlen + withlen;
		char[] out = new char[outlen];
		out = Lang.copy.to.that(in, inlen, out, outlen, 0, inlen, 0);
		out = Lang.copy.to.that(with, withlen, out, outlen, 0, withlen, inlen);
		return out;
	}

	/** @see #longs(long[], int, long[], int) */
	public char[] chars(char[] in, int inlen, int[] with, int withlen) {
		char[] with2 = Lang.primitive.to.chars(with, withlen, 0, withlen, null, 0);
		return chars(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public char[] chars(char[] in, int inlen, long[] with, int withlen) {
		char[] with2 = Lang.primitive.to.chars(with, withlen, 0, withlen, null, 0);
		return chars(in, inlen, with2, with2.length);
	}

	// ==================
	// ================== int[]
	// ==================

	/** @see #longs(long[], int, long[], int) */
	public int[] ints(int[] in, int inlen, byte[] with, int withlen) {
		int[] with2 = Lang.primitive.to.ints(with, withlen, 0, withlen, null, 0);
		return ints(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public int[] ints(int[] in, int inlen, short[] with, int withlen) {
		int[] with2 = Lang.primitive.to.ints(with, withlen, 0, withlen, null, 0);
		return ints(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public int[] ints(int[] in, int inlen, char[] with, int withlen) {
		int[] with2 = Lang.primitive.to.ints(with, withlen, 0, withlen, null, 0);
		return ints(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public int[] ints(int[] in, int inlen, int[] with, int withlen) {
		int outlen = inlen + withlen;
		int[] out = new int[outlen];
		out = Lang.copy.to.that(in, inlen, out, outlen, 0, inlen, 0);
		out = Lang.copy.to.that(with, withlen, out, outlen, 0, withlen, inlen);
		return out;
	}

	/** @see #longs(long[], int, long[], int) */
	public int[] ints(int[] in, int inlen, long[] with, int withlen) {
		int[] with2 = Lang.primitive.to.ints(with, withlen, 0, withlen, null, 0);
		return ints(in, inlen, with2, with2.length);
	}

	// ==================
	// ================== long[]
	// ==================

	/** @see #longs(long[], int, long[], int) */
	public long[] longs(long[] in, int inlen, byte[] with, int withlen) {
		long[] with2 = Lang.primitive.to.longs(with, withlen, 0, withlen, null, 0);
		return longs(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public long[] longs(long[] in, int inlen, short[] with, int withlen) {
		long[] with2 = Lang.primitive.to.longs(with, withlen, 0, withlen, null, 0);
		return longs(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public long[] longs(long[] in, int inlen, char[] with, int withlen) {
		long[] with2 = Lang.primitive.to.longs(with, withlen, 0, withlen, null, 0);
		return longs(in, inlen, with2, with2.length);
	}

	/** @see #longs(long[], int, long[], int) */
	public long[] longs(long[] in, int inlen, int[] with, int withlen) {
		long[] with2 = Lang.primitive.to.longs(with, withlen, 0, withlen, null, 0);
		return longs(in, inlen, with2, with2.length);
	}

	/**
	 * Merge given arrays together in binary base, see {@link LPrimitiveTo}
	 * 
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> N/A<br>
	 * <b>Reallocate:</b> true<br>
	 * <b>New length:</b> Applied to output<br>
	 * <br>
	 * 
	 * @param in      src array
	 * @param inlen   src length
	 * @param with    src other array
	 * @param withlen other src array
	 * @return new allocated array with both arrays based on {@link LPrimitiveTo}
	 */
	public long[] longs(long[] in, int inlen, long[] with, int withlen) {
		int outlen = inlen + withlen;
		long[] out = new long[outlen];
		out = Lang.copy.to.that(in, inlen, out, outlen, 0, inlen, 0);
		out = Lang.copy.to.that(with, withlen, out, outlen, 0, withlen, inlen);
		return out;
	}

	// ==================
	// ================== E
	// ==================

	public static class E {
		private E() {
		}

		// ==================
		// ================== byte[]
		// ==================

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public byte[] bytes(byte[] in, int inlen, byte[] with, int withlen, Endian read, Endian write) {
			int outlen = inlen + withlen;
			byte[] out = new byte[outlen];
			out = Lang.copy.to.e.that(in, inlen, out, outlen, 0, inlen, read, write, 0);
			out = Lang.copy.to.e.that(with, withlen, out, outlen, 0, withlen, read, write, inlen);
			return out;
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public byte[] bytes(byte[] in, int inlen, short[] with, int withlen, Endian read, Endian write) {
			byte[] with2 = Lang.primitive.to.e.bytes(with, withlen, 0, withlen, read, null, 0, read);
			return bytes(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public byte[] bytes(byte[] in, int inlen, char[] with, int withlen, Endian read, Endian write) {
			byte[] with2 = Lang.primitive.to.e.bytes(with, withlen, 0, withlen, read, null, 0, read);
			return bytes(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public byte[] bytes(byte[] in, int inlen, int[] with, int withlen, Endian read, Endian write) {
			byte[] with2 = Lang.primitive.to.e.bytes(with, withlen, 0, withlen, read, null, 0, read);
			return bytes(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public byte[] bytes(byte[] in, int inlen, long[] with, int withlen, Endian read, Endian write) {
			byte[] with2 = Lang.primitive.to.e.bytes(with, withlen, 0, withlen, read, null, 0, read);
			return bytes(in, inlen, with2, with2.length, read, write);
		}

		// ==================
		// ================== short[]
		// ==================

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public short[] shorts(short[] in, int inlen, byte[] with, int withlen, Endian read, Endian write) {
			short[] with2 = Lang.primitive.to.e.shorts(with, withlen, 0, withlen, read, null, 0, read);
			return shorts(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public short[] shorts(short[] in, int inlen, short[] with, int withlen, Endian read, Endian write) {
			int outlen = inlen + withlen;
			short[] out = new short[outlen];
			out = Lang.copy.to.e.that(in, inlen, out, outlen, 0, inlen, read, write, 0);
			out = Lang.copy.to.e.that(with, withlen, out, outlen, 0, withlen, read, write, inlen);
			return out;
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public short[] shorts(short[] in, int inlen, char[] with, int withlen, Endian read, Endian write) {
			short[] with2 = Lang.primitive.to.e.shorts(with, withlen, 0, withlen, read, null, 0, read);
			return shorts(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public short[] shorts(short[] in, int inlen, int[] with, int withlen, Endian read, Endian write) {
			short[] with2 = Lang.primitive.to.e.shorts(with, withlen, 0, withlen, read, null, 0, read);
			return shorts(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public short[] shorts(short[] in, int inlen, long[] with, int withlen, Endian read, Endian write) {
			short[] with2 = Lang.primitive.to.e.shorts(with, withlen, 0, withlen, read, null, 0, read);
			return shorts(in, inlen, with2, with2.length, read, write);
		}
		// ==================
		// ================== char[]
		// ==================

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public char[] chars(char[] in, int inlen, byte[] with, int withlen, Endian read, Endian write) {
			char[] with2 = Lang.primitive.to.e.chars(with, withlen, 0, withlen, read, null, 0, read);
			return chars(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public char[] chars(char[] in, int inlen, char[] with, int withlen, Endian read, Endian write) {
			int outlen = inlen + withlen;
			char[] out = new char[outlen];
			out = Lang.copy.to.e.that(in, inlen, out, outlen, 0, inlen, read, write, 0);
			out = Lang.copy.to.e.that(with, withlen, out, outlen, 0, withlen, read, write, inlen);
			return out;
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public char[] chars(char[] in, int inlen, short[] with, int withlen, Endian read, Endian write) {
			char[] with2 = Lang.primitive.to.e.chars(with, withlen, 0, withlen, read, null, 0, read);
			return chars(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public char[] chars(char[] in, int inlen, int[] with, int withlen, Endian read, Endian write) {
			char[] with2 = Lang.primitive.to.e.chars(with, withlen, 0, withlen, read, null, 0, read);
			return chars(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public char[] chars(char[] in, int inlen, long[] with, int withlen, Endian read, Endian write) {
			char[] with2 = Lang.primitive.to.e.chars(with, withlen, 0, withlen, read, null, 0, read);
			return chars(in, inlen, with2, with2.length, read, write);
		}
		// ==================
		// ================== int[]
		// ==================

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public int[] ints(int[] in, int inlen, byte[] with, int withlen, Endian read, Endian write) {
			int[] with2 = Lang.primitive.to.e.ints(with, withlen, 0, withlen, read, null, 0, read);
			return ints(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public int[] ints(int[] in, int inlen, int[] with, int withlen, Endian read, Endian write) {
			int outlen = inlen + withlen;
			int[] out = new int[outlen];
			out = Lang.copy.to.e.that(in, inlen, out, outlen, 0, inlen, read, write, 0);
			out = Lang.copy.to.e.that(with, withlen, out, outlen, 0, withlen, read, write, inlen);
			return out;
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public int[] ints(int[] in, int inlen, short[] with, int withlen, Endian read, Endian write) {
			int[] with2 = Lang.primitive.to.e.ints(with, withlen, 0, withlen, read, null, 0, read);
			return ints(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public int[] ints(int[] in, int inlen, char[] with, int withlen, Endian read, Endian write) {
			int[] with2 = Lang.primitive.to.e.ints(with, withlen, 0, withlen, read, null, 0, read);
			return ints(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public int[] ints(int[] in, int inlen, long[] with, int withlen, Endian read, Endian write) {
			int[] with2 = Lang.primitive.to.e.ints(with, withlen, 0, withlen, read, null, 0, read);
			return ints(in, inlen, with2, with2.length, read, write);
		}
		// ==================
		// ================== long[]
		// ==================

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public long[] longs(long[] in, int inlen, byte[] with, int withlen, Endian read, Endian write) {
			long[] with2 = Lang.primitive.to.e.longs(with, withlen, 0, withlen, read, null, 0, read);
			return longs(in, inlen, with2, with2.length, read, write);
		}

		/**
		 * Merge given arrays together in binary base, see {@link LPrimitiveTo}
		 * 
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> N/A<br>
		 * <b>Reallocate:</b> true<br>
		 * <b>New length:</b> Applied to output<br>
		 * <br>
		 * 
		 * @param in      src array
		 * @param inlen   src length
		 * @param with    src other array
		 * @param withlen other src array
		 * @param read    read endian
		 * @param write   write endian
		 * @return new allocated array with both arrays based on {@link LPrimitiveTo}
		 */
		public long[] longs(long[] in, int inlen, long[] with, int withlen, Endian read, Endian write) {
			int outlen = inlen + withlen;
			long[] out = new long[outlen];
			out = Lang.copy.to.e.that(in, inlen, out, outlen, 0, inlen, read, write, 0);
			out = Lang.copy.to.e.that(with, withlen, out, outlen, 0, withlen, read, write, inlen);
			return out;
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public long[] longs(long[] in, int inlen, short[] with, int withlen, Endian read, Endian write) {
			long[] with2 = Lang.primitive.to.e.longs(with, withlen, 0, withlen, read, null, 0, read);
			return longs(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public long[] longs(long[] in, int inlen, char[] with, int withlen, Endian read, Endian write) {
			long[] with2 = Lang.primitive.to.e.longs(with, withlen, 0, withlen, read, null, 0, read);
			return longs(in, inlen, with2, with2.length, read, write);
		}

		/** @see #longs(long[], int, long[], int, Endian, Endian) */
		public long[] longs(long[] in, int inlen, int[] with, int withlen, Endian read, Endian write) {
			long[] with2 = Lang.primitive.to.e.longs(with, withlen, 0, withlen, read, null, 0, read);
			return longs(in, inlen, with2, with2.length, read, write);
		}
	}

}
