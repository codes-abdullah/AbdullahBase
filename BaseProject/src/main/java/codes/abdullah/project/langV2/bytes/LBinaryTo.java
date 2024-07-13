package codes.abdullah.project.langV2.bytes;

import codes.abdullah.array.bytes.XByteArray;
import codes.abdullah.array.chars.XCharArray;
import codes.abdullah.array.doubles.XDoubleArray;
import codes.abdullah.array.floats.XFloatArray;
import codes.abdullah.array.ints.XIntArray;
import codes.abdullah.array.longs.XLongArray;
import codes.abdullah.array.shorts.XShortArray;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

//TODO lengthOf + tests
public class LBinaryTo {

	/** {@link Endian} based implementation */
	public final E e = new E();

	/** Words counter */
	public final LToBinaryWordsCounter words = new LToBinaryWordsCounter();
	public final LToBinaryLength lengthOf = new LToBinaryLength();

	LBinaryTo() {

	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XShortArray shorts(XByteArray in) {
		return shorts(in, 0);
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XShortArray shorts(XByteArray in, int from) {
		return shorts(in, from, in.length());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XShortArray shorts(XByteArray in, int from, int to) {
		return shorts(in, from, to, XShortArray.of());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XShortArray shorts(XByteArray in, int from, int to, XShortArray out) {
		int inlen = to - from;
		final int _in_size = Byte.SIZE;
		final int _out_size = Short.SIZE;
		final int parts = _out_size / _in_size;
		final int arr_out_len = (inlen + (parts - 1)) / parts;
		final short mask = (1 << _in_size) - 1;
		XShortArray was = out;
		out = out.toMutable().ensureCapacity(arr_out_len);
		short[] outarr = out.getArray();
		short tmp = 0;
		for (int i = 0; i < arr_out_len; i++) {
			tmp = (short) (in.getAt(from++) & mask);
			for (int j = 1; j < parts && from < to; j++) {
				tmp |= (((short) (in.getAt(from++) & mask)) << _in_size * j);
			}
			outarr[i] |= tmp;
		}
		return was.assign(outarr, out.length());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XCharArray chars(XByteArray in) {
		return chars(in, 0);
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XCharArray chars(XByteArray in, int from) {
		return chars(in, from, in.length());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XCharArray chars(XByteArray in, int from, int to) {
		return chars(in, from, to, XCharArray.of());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XCharArray chars(XByteArray in, int from, int to, XCharArray out) {
		int inlen = to - from;
		final int _in_size = Byte.SIZE;
		final int _out_size = Character.SIZE;
		final int parts = _out_size / _in_size;
		final int arr_out_len = (inlen + (parts - 1)) / parts;
		final char mask = (1 << _in_size) - 1;
		XCharArray was = out;
		out = out.toMutable().ensureCapacity(arr_out_len);
		char[] outarr = out.getArray();
		char tmp = 0;
		for (int i = 0; i < arr_out_len; i++) {
			tmp = (char) (in.getAt(from++) & mask);
			for (int j = 1; j < parts && from < to; j++) {
				tmp |= (((char) (in.getAt(from++) & mask)) << _in_size * j);
			}
			outarr[i] |= tmp;
		}
		return was.assign(outarr, out.length());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XIntArray ints(XByteArray in) {
		return ints(in, 0);
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XIntArray ints(XByteArray in, int from) {
		return ints(in, from, in.length());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XIntArray ints(XByteArray in, int from, int to) {
		return ints(in, from, to, XIntArray.of());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XIntArray ints(XByteArray in, int from, int to, XIntArray out) {
		int inlen = to - from;
		final int _in_size = Byte.SIZE;
		final int _out_size = Integer.SIZE;
		final int parts = _out_size / _in_size;
		final int arr_out_len = (inlen + (parts - 1)) / parts;
		final int mask = (1 << _in_size) - 1;
		XIntArray was = out;
		out = out.toMutable().ensureCapacity(arr_out_len);
		int[] outarr = out.getArray();
		int tmp = 0;
		for (int i = 0; i < arr_out_len; i++) {
			tmp = (int) (in.getAt(from++) & mask);
			for (int j = 1; j < parts && from < to; j++) {
				tmp |= (((int) (in.getAt(from++) & mask)) << _in_size * j);
			}
			outarr[i] |= tmp;
		}
		return was.assign(outarr, out.length());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XLongArray longs(XByteArray in) {
		return longs(in, 0);
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XLongArray longs(XByteArray in, int from) {
		return longs(in, from, in.length());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XLongArray longs(XByteArray in, int from, int to) {
		return longs(in, from, to, XLongArray.of());
	}

	/**
	 * @see #longs(XByteArray, int, int, XLongArray)
	 */
	public XLongArray longs(XByteArray in, int from, int to, XLongArray out) {
		int inlen = to - from;
		final int _in_size = Byte.SIZE;
		final int _out_size = Long.SIZE;
		final int parts = _out_size / _in_size;
		final int arr_out_len = (inlen + (parts - 1)) / parts;
		final long mask = (1 << _in_size) - 1;
		XLongArray was = out;
		out = out.toMutable().ensureCapacity(arr_out_len);
		long[] outarr = out.getArray();
		long tmp = 0;
		for (int i = 0; i < arr_out_len; i++) {
			tmp = (long) (in.getAt(from++) & mask);
			for (int j = 1; j < parts && from < to; j++) {
				tmp |= (((long) (in.getAt(from++) & mask)) << _in_size * j);
			}
			outarr[i] |= tmp;
		}
		return was.assign(outarr, out.length());
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
		// ======================================= to byte array
		// =================================================
		// =================================================

		/**
		 * @see #ints(long, int[], int, Endian, boolean)
		 */
		public byte[] bytes(short n, byte[] out, int outlen, Endian write, boolean skipZeros) {
			if (n == 0) {
				return out;
			}
			final int words = Short.SIZE / Byte.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Byte.SIZE) : words;
			int index = 0;
			out = out == null ? new byte[wordsInUse] : Lang.capacity.e.ensure(out, outlen, wordsInUse, write, true);
			for (int j = 0; j < wordsInUse; j++) {
				out[write.index(index++, wordsInUse, wordsInUse)] = (byte) n;
				n >>>= Byte.SIZE;
			}
			return out;
		}

		/**
		 * @see #ints(long, int[], int, Endian, boolean)
		 */
		public byte[] bytes(int n, byte[] out, int outlen, Endian write, boolean skipZeros) {
			if (n == 0) {
				return out;
			}
			final int words = Integer.SIZE / Byte.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Byte.SIZE) : words;
			int index = 0;
			out = out == null ? new byte[wordsInUse] : Lang.capacity.e.ensure(out, outlen, wordsInUse, write, true);
			for (int j = 0; j < wordsInUse; j++) {
				out[write.index(index++, wordsInUse, wordsInUse)] = (byte) n;
				n >>>= Byte.SIZE;
			}
			return out;
		}

		/**
		 * @see #ints(long, int[], int, Endian, boolean)
		 */
		public byte[] bytes(long n, byte[] out, int outlen, Endian write, boolean skipZeros) {
			if (n == 0) {
				return out;
			}
			final int words = Long.SIZE / Byte.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Byte.SIZE) : words;
			int index = 0;
			out = out == null ? new byte[wordsInUse] : Lang.capacity.e.ensure(out, outlen, wordsInUse, write, true);
			for (int j = 0; j < wordsInUse; j++) {
				out[write.index(index++, wordsInUse, wordsInUse)] = (byte) n;
				n >>>= Byte.SIZE;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, int, int, Endian, long[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen,
				Endian write) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Short.SIZE / _out_size;
			final int _out_mask = (1 << _out_size) - 1;
			final int _in_mask = (1 << Short.SIZE) - 1;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			out = out == null ? new byte[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;
			short tmp = 0;
			for (; from < to - 1; from++) {
				atIn = read.index(from, inlen, in.length);
				tmp = in[atIn];
				for (int j = 0; j < _outputs_per_input; j++) {
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (byte) tmp;
					tmp = (short) (_in_mask & (tmp >>> _out_size));
				}
				outindex += _outputs_per_input;
			}
			for (short x = in[read.index(to - 1, inlen,
					in.length)]; x != 0; x = (short) ((_in_mask & x) >>> _out_size)) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (byte) (x & _out_mask);
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, int, int, Endian, long[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen, Endian write) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Character.SIZE / _out_size;
			final int _out_mask = (1 << _out_size) - 1;
			final int _in_mask = (1 << Character.SIZE) - 1;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			out = out == null ? new byte[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;
			char tmp = 0;
			for (; from < to - 1; from++) {
				atIn = read.index(from, inlen, in.length);
				tmp = in[atIn];
				for (int j = 0; j < _outputs_per_input; j++) {
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (byte) tmp;
					tmp = (char) (_in_mask & (tmp >>> _out_size));
				}
				outindex += _outputs_per_input;
			}
			for (char x = in[read.index(to - 1, inlen, in.length)]; x != 0; x = (char) ((_in_mask & x) >>> _out_size)) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (byte) (x & _out_mask);
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, int, int, Endian, long[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen, Endian write) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Integer.SIZE / _out_size;
			final int _out_mask = (1 << _out_size) - 1;
			final int _in_mask = -1;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			out = out == null ? new byte[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;
			int tmp = 0;
			for (; from < to - 1; from++) {
				atIn = read.index(from, inlen, in.length);
				tmp = in[atIn];
				for (int j = 0; j < _outputs_per_input; j++) {
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (byte) tmp;
					tmp = (int) (_in_mask & (tmp >>> _out_size));
				}
				outindex += _outputs_per_input;
			}
			for (int x = in[read.index(to - 1, inlen, in.length)]; x != 0; x = (int) ((_in_mask & x) >>> _out_size)) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (byte) (x & _out_mask);
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, int, int, Endian, long[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen, Endian write) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Long.SIZE / _out_size;
			final int _out_mask = (1 << _out_size) - 1;
			final long _in_mask = -1L;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			out = out == null ? new byte[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;
			long tmp = 0;
			for (; from < to - 1; from++) {
				atIn = read.index(from, inlen, in.length);
				tmp = in[atIn];
				for (int j = 0; j < _outputs_per_input; j++) {
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (byte) tmp;
					tmp = (long) (_in_mask & (tmp >>> _out_size));
				}
				outindex += _outputs_per_input;
			}
			for (long x = in[read.index(to - 1, inlen, in.length)]; x != 0; x = (long) ((_in_mask & x) >>> _out_size)) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (byte) (x & _out_mask);
			}
			return out;
		}

		// =================================================
		// =================================================
		// ======================================= to short
		// =================================================
		// =================================================

		/**
		 * @see #ints(long, int[], int, Endian, boolean)
		 */
		public short[] shorts(int n, short[] out, int outlen, Endian write, boolean skipZeros) {
			if (n == 0) {
				return out;
			}
			final int words = Integer.SIZE / Short.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Short.SIZE) : words;
			int index = 0;
			out = out == null ? new short[wordsInUse] : Lang.capacity.e.ensure(out, outlen, wordsInUse, write, true);
			for (int j = 0; j < wordsInUse; j++) {
				out[write.index(index++, wordsInUse, wordsInUse)] = (short) n;
				n >>>= Short.SIZE;
			}
			return out;
		}

		/**
		 * @see #ints(long, int[], int, Endian, boolean)
		 */
		public short[] shorts(long n, short[] out, int outlen, Endian write, boolean skipZeros) {
			if (n == 0) {
				return out;
			}
			final int words = Long.SIZE / Short.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Short.SIZE) : words;
			int index = 0;
			out = out == null ? new short[wordsInUse] : Lang.capacity.e.ensure(out, outlen, wordsInUse, write, true);
			for (int j = 0; j < wordsInUse; j++) {
				out[write.index(index++, wordsInUse, wordsInUse)] = (short) n;
				n >>>= Short.SIZE;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			inlen = to - from;
			final int _in_size = Byte.SIZE;
			final int _out_size = Short.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final short mask = (1 << _in_size) - 1;
			out = out == null ? new short[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			short tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (short) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((short) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			inlen = to - from;
			out = out == null ? new short[inlen] : Lang.capacity.e.ensure(out, outlen, inlen, read, true);
			for (int i = 0; from < to; from++, i++) {
				out[write.index(i, outlen, out.length)] = (short) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			final int _out_size = Short.SIZE;
			final int _outputs_per_input = Integer.SIZE / _out_size;
			final int _out_mask = (1 << _out_size) - 1;
			final int _in_mask = -1;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			out = out == null ? new short[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;
			int tmp = 0;
			for (; from < to - 1; from++) {
				atIn = read.index(from, inlen, in.length);
				tmp = in[atIn];
				for (int j = 0; j < _outputs_per_input; j++) {
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (short) tmp;
					tmp = (int) (_in_mask & (tmp >>> _out_size));
				}
				outindex += _outputs_per_input;
			}
			for (int x = in[read.index(to - 1, inlen, in.length)]; x != 0; x = (int) ((_in_mask & x) >>> _out_size)) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (short) (x & _out_mask);
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			final int _out_size = Short.SIZE;
			final int _outputs_per_input = Long.SIZE / _out_size;
			final int _out_mask = (1 << _out_size) - 1;
			final long _in_mask = -1L;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			out = out == null ? new short[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;
			long tmp = 0;
			for (; from < to - 1; from++) {
				atIn = read.index(from, inlen, in.length);
				tmp = in[atIn];
				for (int j = 0; j < _outputs_per_input; j++) {
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (short) tmp;
					tmp = (long) (_in_mask & (tmp >>> _out_size));
				}
				outindex += _outputs_per_input;
			}
			for (long x = in[read.index(to - 1, inlen, in.length)]; x != 0; x = (long) ((_in_mask & x) >>> _out_size)) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (short) (x & _out_mask);
			}
			return out;
		}

		// =================================================
		// =================================================
		// ======================================= to char
		// =================================================
		// =================================================

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen, int from, int to, Endian read, char[] out, int outlen, Endian write) {
			inlen = to - from;
			final int _in_size = Byte.SIZE;
			final int _out_size = Character.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final short mask = (1 << _in_size) - 1;
			out = out == null ? new char[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			char tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (char) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((char) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen, int from, int to, Endian read, char[] out, int outlen,
				Endian write) {
			inlen = to - from;
			out = out == null ? new char[inlen] : Lang.capacity.e.ensure(out, outlen, inlen, read, true);
			for (int i = 0; from < to; from++, i++) {
				out[write.index(i, outlen, out.length)] = (char) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from, int to, Endian read, char[] out, int outlen, Endian write) {
			final int _out_size = Character.SIZE;
			final int _outputs_per_input = Integer.SIZE / _out_size;
			final int mask = (1 << _out_size) - 1;
			inlen = to - from;
			int count = _outputs_per_input * (inlen - 1);
			for (int x = in[read.index(to - 1, inlen, in.length)]; x != 0; x >>>= _out_size) {
				count++;
			}

			out = out == null ? new char[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;

			for (; from < to - 1; from++) {
				for (int j = 0; j < _outputs_per_input; j++) {
					atIn = read.index(from, inlen, in.length);
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (char) in[atIn];
					in[atIn] >>>= _out_size;
				}
				outindex += _outputs_per_input;
			}
			for (int x = in[to - 1]; x != 0; x >>>= _out_size) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (char) (x & mask);
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen, int from, int to, Endian read, char[] out, int outlen, Endian write) {
			final int _out_size = Character.SIZE;
			final int _outputs_per_input = Long.SIZE / _out_size;
			final int mask = (1 << _out_size) - 1;
			inlen = to - from;
			int count = _outputs_per_input * (inlen - 1);
			for (long x = in[read.index(to - 1, inlen, in.length)]; x != 0; x >>>= _out_size) {
				count++;
			}

			out = out == null ? new char[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;

			for (; from < to - 1; from++) {
				for (int j = 0; j < _outputs_per_input; j++) {
					atIn = read.index(from, inlen, in.length);
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (char) in[atIn];
					in[atIn] >>>= _out_size;
				}
				outindex += _outputs_per_input;
			}
			for (long x = in[to - 1]; x != 0; x >>>= _out_size) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (char) (x & mask);
			}
			return out;
		}

		// =================================================
		// =================================================
		// ======================================= to int
		// =================================================
		// =================================================

		/**
		 * Convert given n into into array in binary base, e.g: {@link Long#MAX_VALUE}
		 * results: [-1, -1]<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> Applied<br>
		 * <b>Reallocate:</b> If required<br>
		 * <b>New length:</b> By invoker<br>
		 * <br>
		 * 
		 * 
		 * @param n         src, if n == 0 return out
		 * 
		 * @param out       if null, allocate new, otherwise if not having enough
		 *                  capacity, reallocate new with enough capacity
		 * @param outlen    length of out array, discarded if out is null or has no
		 *                  enough capacity
		 * @param skipZeros skip-zero words in src if exists
		 * @param write     output endian
		 * 
		 */
		public int[] ints(long n, int[] out, int outlen, Endian write, boolean skipZeros) {
			if (n == 0) {
				return out;
			}
			final int words = Long.SIZE / Integer.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Integer.SIZE) : words;
			int index = 0;
			out = out == null ? new int[wordsInUse] : Lang.capacity.e.ensure(out, outlen, wordsInUse, write, true);
			for (int j = 0; j < wordsInUse; j++) {
				out[write.index(index++, wordsInUse, wordsInUse)] = (int) n;
				n >>>= Integer.SIZE;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			inlen = to - from;
			final int _in_size = Byte.SIZE;
			final int _out_size = Integer.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final int mask = (1 << _in_size) - 1;
			out = out == null ? new int[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			int tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (int) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((int) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			inlen = to - from;
			final int _in_size = Short.SIZE;
			final int _out_size = Integer.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final int mask = (1 << _in_size) - 1;
			out = out == null ? new int[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			int tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (int) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((int) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			inlen = to - from;
			final int _in_size = Character.SIZE;
			final int _out_size = Integer.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final int mask = (1 << _in_size) - 1;
			out = out == null ? new int[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			int tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (int) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((int) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			final int _out_size = Integer.SIZE;
			final int _outputs_per_input = Long.SIZE / _out_size;
			final long _out_mask = (1L << _out_size) - 1;
			final long _in_mask = -1L;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			out = out == null ? new int[count] : Lang.capacity.e.ensure(out, outlen, count, read, true);
			int outindex = 0, atOut, atIn;
			long tmp = 0;
			for (; from < to - 1; from++) {
				atIn = read.index(from, inlen, in.length);
				tmp = in[atIn];
				for (int j = 0; j < _outputs_per_input; j++) {
					atOut = write.index(j + outindex, outlen, out.length);
					out[atOut] = (int) tmp;
					tmp = (long) (_in_mask & (tmp >>> _out_size));
				}
				outindex += _outputs_per_input;
			}
			for (long x = in[read.index(to - 1, inlen, in.length)]; x != 0; x = (long) ((_in_mask & x) >>> _out_size)) {
				atOut = write.index(outindex++, outlen, out.length);
				out[atOut] = (int) (x & _out_mask);
			}
			return out;
		}

		// =================================================
		// =================================================
		// ======================================= to long
		// =================================================
		// =================================================

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen, int from, int to, Endian read, long[] out, int outlen, Endian write) {
			inlen = to - from;
			final int _in_size = Byte.SIZE;
			final int _out_size = Long.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final long mask = (1L << _in_size) - 1;
			out = out == null ? new long[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			long tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (long) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((long) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen, int from, int to, Endian read, long[] out, int outlen,
				Endian write) {
			inlen = to - from;
			final int _in_size = Short.SIZE;
			final int _out_size = Long.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final long mask = (1L << _in_size) - 1;
			out = out == null ? new long[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			long tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (long) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((long) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * @see #longs(int[], int, Endian, int, int, long[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen, int from, int to, Endian read, long[] out, int outlen, Endian write) {
			inlen = to - from;
			final int _in_size = Character.SIZE;
			final int _out_size = Long.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final long mask = (1L << _in_size) - 1;
			out = out == null ? new long[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			long tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (long) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((long) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

		/**
		 * Convert given array into binary base, e.g: array of 4 elements of
		 * {@link Integer#MAX_VALUE} results: [-1, -1]
		 * 
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> Applied<br>
		 * <b>Reallocate:</b> If required<br>
		 * <b>New length:</b> By invoker<br>
		 * <br>
		 * 
		 * @param in     input array to read
		 * @param inlen  length of input array
		 * @param from   read input array from inclusive index
		 * @param to     read input array from exclusive index
		 * @param out    output array, if outlen < required, then this array will be
		 *               reallocated, else, if output is null, new array will be created
		 * @param outlen length of output array, if outlen <= 0, ensure is invoked
		 * @param write  output endian
		 * @param read   input endian
		 * 
		 */
		public long[] longs(int[] in, int inlen, int from, int to, Endian read, long[] out, int outlen, Endian write) {
			inlen = to - from;
			final int _in_size = Integer.SIZE;
			final int _out_size = Long.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			final long mask = (1L << _in_size) - 1;
			out = out == null ? new long[arr_out_len] : Lang.capacity.e.ensure(out, outlen, arr_out_len, read, true);
			long tmp = 0;
			for (int i = 0; i < arr_out_len; i++) {
				tmp = (long) (in[read.index(from++, inlen, in.length)] & mask);
				for (int j = 1; j < parts && from < to; j++) {
					tmp |= (((long) (in[read.index(from++, inlen, in.length)] & mask)) << _in_size * j);
				}
				out[write.index(i, outlen, out.length)] |= tmp;
			}
			return out;
		}

	}

	public static class LToBinaryWordsCounter {

		private LToBinaryWordsCounter() {

		}

		/**
		 * count words-in-use<br>
		 * a words is group of bits represented by given <code>forSize</code>, <br>
		 * e.g: n = 10000100001000011000010000100001<br>
		 * - forSize = {@link Byte#SIZE}, so 64 / 8 = 8 words-in-use:<br>
		 * 1000-0100-0010-0001-1000-0100-0010-0001<br>
		 * <br>
		 * - forSize = {@link Integer#SIZE}, so 64 / 32 = 2 words-in-use:<br>
		 * 1000010000100001-1000010000100001<br>
		 * 
		 * @param n       input
		 * @param forSize the target size
		 */
		public int count(long n, int forSize) {
			n = n < 0 ? -n : n;
			int parts = Long.SIZE / forSize;
			for (int i = 0; i < parts; i++) {
				n >>>= forSize;
				if (n == 0) {
					return i + 1;
				}
			}
			return parts;
		}
	}

	public static class LToBinaryLength {

		private LToBinaryLength() {

		}

		public int bytes(short n, byte[] out, int outlen, boolean skipZeros) {
			final int words = Short.SIZE / Byte.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Byte.SIZE) : words;
			return out == null ? wordsInUse : Lang.capacity.lengthOf.ensure(out, outlen, wordsInUse, true);
		}

		public int bytes(char n, byte[] out, int outlen, boolean skipZeros) {
			final int words = Character.SIZE / Byte.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Byte.SIZE) : words;
			return out == null ? wordsInUse : Lang.capacity.lengthOf.ensure(out, outlen, wordsInUse, true);
		}

		public int bytes(int n, byte[] out, int outlen, boolean skipZeros) {
			final int words = Integer.SIZE / Byte.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Byte.SIZE) : words;
			return out == null ? wordsInUse : Lang.capacity.lengthOf.ensure(out, outlen, wordsInUse, true);
		}

		public int bytes(long n, byte[] out, int outlen, boolean skipZeros) {
			final int words = Long.SIZE / Byte.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Byte.SIZE) : words;
			return out == null ? wordsInUse : Lang.capacity.lengthOf.ensure(out, outlen, wordsInUse, true);
		}

		public int bytes(short[] in, int inlen, int from, int to, byte[] out, int outlen) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Short.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		public int bytes(char[] in, int inlen, int from, int to, byte[] out, int outlen) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Character.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		public int bytes(int[] in, int inlen, int from, int to, byte[] out, int outlen) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Integer.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		public int bytes(long[] in, int inlen, int from, int to, byte[] out, int outlen) {
			final int _out_size = Byte.SIZE;
			final int _outputs_per_input = Long.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		// ================

		public int shorts(int n, short[] out, int outlen, boolean skipZeros) {
			final int words = Integer.SIZE / Short.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Short.SIZE) : words;
			return out == null ? wordsInUse : Lang.capacity.lengthOf.ensure(out, outlen, wordsInUse, true);
		}

		public int shorts(long n, short[] out, int outlen, boolean skipZeros) {
			final int words = Long.SIZE / Short.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Short.SIZE) : words;
			return out == null ? wordsInUse : Lang.capacity.lengthOf.ensure(out, outlen, wordsInUse, true);
		}

		public int shorts(byte[] in, int inlen, int from, int to, short[] out, int outlen) {
			final int _in_size = Byte.SIZE;
			final int _out_size = Short.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			return out == null ? arr_out_len : Lang.capacity.lengthOf.ensure(out, outlen, arr_out_len, true);
		}

		public int shorts(char[] in, int inlen, int from, int to, short[] out, int outlen) {
			final int _out_size = Short.SIZE;
			final int _outputs_per_input = Character.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		public int shorts(int[] in, int inlen, int from, int to, short[] out, int outlen) {
			final int _out_size = Short.SIZE;
			final int _outputs_per_input = Integer.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		public int shorts(long[] in, int inlen, int from, int to, short[] out, int outlen) {
			final int _out_size = Short.SIZE;
			final int _outputs_per_input = Long.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		// ================

		public int ints(byte[] in, int inlen, int from, int to, int[] out, int outlen) {
			final int _in_size = Byte.SIZE;
			final int _out_size = Integer.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			return out == null ? arr_out_len : Lang.capacity.lengthOf.ensure(out, outlen, arr_out_len, true);
		}

		public int ints(short[] in, int inlen, int from, int to, int[] out, int outlen) {
			final int _in_size = Short.SIZE;
			final int _out_size = Integer.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			return out == null ? arr_out_len : Lang.capacity.lengthOf.ensure(out, outlen, arr_out_len, true);
		}

		public int ints(char[] in, int inlen, int from, int to, int[] out, int outlen) {
			final int _in_size = Character.SIZE;
			final int _out_size = Integer.SIZE;
			final int parts = _out_size / _in_size;
			final int arr_out_len = (inlen + (parts - 1)) / parts;
			return out == null ? arr_out_len : Lang.capacity.lengthOf.ensure(out, outlen, arr_out_len, true);
		}

		public int ints(long[] in, int inlen, int from, int to, int[] out, int outlen) {
			final int _out_size = Integer.SIZE;
			final int _outputs_per_input = Long.SIZE / _out_size;
			inlen = to - from;
			int count = _outputs_per_input * inlen;
			return out == null ? count : Lang.capacity.lengthOf.ensure(out, outlen, count, true);
		}

		public int ints(long n, int[] out, int outlen, boolean skipZeros) {
			final int words = Long.SIZE / Integer.SIZE;
			final int wordsInUse = skipZeros ? Lang.binary.to.words.count(n, Integer.SIZE) : words;
			return out == null ? wordsInUse : Lang.capacity.lengthOf.ensure(out, outlen, wordsInUse, true);
		}
	}

}
