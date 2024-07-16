package codes.abdullah.project.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

public class LPrimitiveTo {
	/** {@link Endian} based implementation */
	public final E e = new E();

	LPrimitiveTo() {

	}

	// ============= short[] to byte[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(short[] in) {
		return bytes(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(short[] in, int inlen) {
		return bytes(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(short[] in, int inlen, int from) {
		return bytes(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(short[] in, int inlen, int from, int to) {
		return bytes(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(short[] in, int inlen, int from, int to, byte[] out) {
		return bytes(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(short[] in, int inlen, int from, int to, byte[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new byte[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (byte) in[from];
		}
		return out;
	}

	// ============= char[] to byte[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(char[] in) {
		return bytes(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(char[] in, int inlen) {
		return bytes(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(char[] in, int inlen, int from) {
		return bytes(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(char[] in, int inlen, int from, int to) {
		return bytes(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(char[] in, int inlen, int from, int to, byte[] out) {
		return bytes(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(char[] in, int inlen, int from, int to, byte[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new byte[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (byte) in[from];
		}
		return out;
	}

	// ============= int[] to byte[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(int[] in) {
		return bytes(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(int[] in, int inlen) {
		return bytes(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(int[] in, int inlen, int from) {
		return bytes(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(int[] in, int inlen, int from, int to) {
		return bytes(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(int[] in, int inlen, int from, int to, byte[] out) {
		return bytes(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(int[] in, int inlen, int from, int to, byte[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new byte[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (byte) in[from];
		}
		return out;
	}

	// ============= long[] to byte[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(long[] in) {
		return bytes(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(long[] in, int inlen) {
		return bytes(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(long[] in, int inlen, int from) {
		return bytes(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(long[] in, int inlen, int from, int to) {
		return bytes(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(long[] in, int inlen, int from, int to, byte[] out) {
		return bytes(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(long[] in, int inlen, int from, int to, byte[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new byte[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (byte) in[from];
		}
		return out;
	}

	// ============= float[] to byte[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(float[] in) {
		return bytes(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(float[] in, int inlen) {
		return bytes(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(float[] in, int inlen, int from) {
		return bytes(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(float[] in, int inlen, int from, int to) {
		return bytes(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(float[] in, int inlen, int from, int to, byte[] out) {
		return bytes(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(float[] in, int inlen, int from, int to, byte[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new byte[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (byte) in[from];
		}
		return out;
	}

	// ============= double[] to byte[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(double[] in) {
		return bytes(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(double[] in, int inlen) {
		return bytes(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(double[] in, int inlen, int from) {
		return bytes(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(double[] in, int inlen, int from, int to) {
		return bytes(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(double[] in, int inlen, int from, int to, byte[] out) {
		return bytes(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(double[] in, int inlen, int from, int to, byte[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new byte[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (byte) in[from];
		}
		return out;
	}
	// ============ collection to byte[]

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(Collection<? extends Number> in) {
		return bytes(in, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(Collection<? extends Number> in, int from) {
		return bytes(in, from, in.size());
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(Collection<? extends Number> in, int from, int to) {
		return bytes(in, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(Collection<? extends Number> in, int from, int to, byte[] out) {
		return bytes(in, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public byte[] bytes(Collection<? extends Number> in, int from, int to, byte[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new byte[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		Iterator<? extends Number> it = in.iterator();
		int itnow = 0;
		while (it.hasNext() && itnow < from) {
			itnow++;
			it.next();
		}
		for (int i = 0; from < to && it.hasNext(); from++, i++) {
			out[i] = it.next().byteValue();
		}
		return out;
	}

	// ============= byte[] to short[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(byte[] in) {
		return shorts(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(byte[] in, int inlen) {
		return shorts(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(byte[] in, int inlen, int from) {
		return shorts(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(byte[] in, int inlen, int from, int to) {
		return shorts(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(byte[] in, int inlen, int from, int to, short[] out) {
		return shorts(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(byte[] in, int inlen, int from, int to, short[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new short[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (short) in[from];
		}
		return out;
	}

	// ============= char[] to short[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(char[] in) {
		return shorts(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(char[] in, int inlen) {
		return shorts(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(char[] in, int inlen, int from) {
		return shorts(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(char[] in, int inlen, int from, int to) {
		return shorts(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(char[] in, int inlen, int from, int to, short[] out) {
		return shorts(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(char[] in, int inlen, int from, int to, short[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new short[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (short) in[from];
		}
		return out;
	}

	// ============= int[] to short[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(int[] in) {
		return shorts(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(int[] in, int inlen) {
		return shorts(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(int[] in, int inlen, int from) {
		return shorts(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(int[] in, int inlen, int from, int to) {
		return shorts(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(int[] in, int inlen, int from, int to, short[] out) {
		return shorts(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(int[] in, int inlen, int from, int to, short[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new short[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (short) in[from];
		}
		return out;
	}

	// ============= long[] to short[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(long[] in) {
		return shorts(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(long[] in, int inlen) {
		return shorts(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(long[] in, int inlen, int from) {
		return shorts(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(long[] in, int inlen, int from, int to) {
		return shorts(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(long[] in, int inlen, int from, int to, short[] out) {
		return shorts(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(long[] in, int inlen, int from, int to, short[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new short[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (short) in[from];
		}
		return out;
	}

	// ============= float[] to short[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(float[] in) {
		return shorts(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(float[] in, int inlen) {
		return shorts(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(float[] in, int inlen, int from) {
		return shorts(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(float[] in, int inlen, int from, int to) {
		return shorts(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(float[] in, int inlen, int from, int to, short[] out) {
		return shorts(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(float[] in, int inlen, int from, int to, short[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new short[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (short) in[from];
		}
		return out;
	}

	// ============= double[] to short[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(double[] in) {
		return shorts(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(double[] in, int inlen) {
		return shorts(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(double[] in, int inlen, int from) {
		return shorts(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(double[] in, int inlen, int from, int to) {
		return shorts(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(double[] in, int inlen, int from, int to, short[] out) {
		return shorts(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(double[] in, int inlen, int from, int to, short[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new short[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (short) in[from];
		}
		return out;
	}
//============ collection to short[]

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(Collection<? extends Number> in) {
		return shorts(in, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(Collection<? extends Number> in, int from) {
		return shorts(in, from, in.size());
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(Collection<? extends Number> in, int from, int to) {
		return shorts(in, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(Collection<? extends Number> in, int from, int to, short[] out) {
		return shorts(in, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public short[] shorts(Collection<? extends Number> in, int from, int to, short[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new short[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		Iterator<? extends Number> it = in.iterator();
		int itnow = 0;
		while (it.hasNext() && itnow < from) {
			itnow++;
			it.next();
		}
		for (int i = 0; from < to && it.hasNext(); from++, i++) {
			out[i] = it.next().shortValue();
		}
		return out;
	}

	// ============= byte[] to char[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(byte[] in) {
		return chars(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(byte[] in, int inlen) {
		return chars(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(byte[] in, int inlen, int from) {
		return chars(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(byte[] in, int inlen, int from, int to) {
		return chars(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(byte[] in, int inlen, int from, int to, char[] out) {
		return chars(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(byte[] in, int inlen, int from, int to, char[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (char) in[from];
		}
		return out;
	}

	// ============= short[] to char[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(short[] in) {
		return chars(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(short[] in, int inlen) {
		return chars(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(short[] in, int inlen, int from) {
		return chars(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(short[] in, int inlen, int from, int to) {
		return chars(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(short[] in, int inlen, int from, int to, char[] out) {
		return chars(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(short[] in, int inlen, int from, int to, char[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (char) in[from];
		}
		return out;
	}

	// ============= int[] to char[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(int[] in) {
		return chars(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(int[] in, int inlen) {
		return chars(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(int[] in, int inlen, int from) {
		return chars(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(int[] in, int inlen, int from, int to) {
		return chars(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(int[] in, int inlen, int from, int to, char[] out) {
		return chars(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(int[] in, int inlen, int from, int to, char[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (char) in[from];
		}
		return out;
	}

	/**
	 * 
	 * This method has the option to use {@link CodepointSupport}<br>
	 * e.g, input: [65545, 97, 66562], {@link CodepointSupport#DEBUG}<br>
	 * output: [A, 9, a, B, 2]<br>
	 * e.g, input: [65, 57, 97, 66, 50], {@link CodepointSupport#BMP}<br>
	 * output: [A, 9, a, B, 2]
	 * 
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(int[] in, int inlen, int from, int to, char[] out, int outlen, CodepointSupport sps) {
		if (!sps.isSupported())
			return chars(in, inlen, from, to, out, outlen);
		List<Character> l = new ArrayList<>();
		for (; from < to; from++) {
			if (sps.isPair(in, inlen, from)) {
				l.add(sps.toHigh(in[from]));
				l.add(sps.toLow(in[from]));
				continue;
			}
			l.add((char) in[from]);
		}
		out = out == null ? new char[l.size()] : Lang.capacity.ensure(out, outlen, l.size(), true);
		return Lang.wrapper.unwrap(l.toArray(new Character[l.size()]), out);
	}

	// ============= long[] to char[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(long[] in) {
		return chars(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(long[] in, int inlen) {
		return chars(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(long[] in, int inlen, int from) {
		return chars(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(long[] in, int inlen, int from, int to) {
		return chars(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(long[] in, int inlen, int from, int to, char[] out) {
		return chars(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(long[] in, int inlen, int from, int to, char[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (char) in[from];
		}
		return out;
	}

	// ============= float[] to char[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(float[] in) {
		return chars(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(float[] in, int inlen) {
		return chars(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(float[] in, int inlen, int from) {
		return chars(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(float[] in, int inlen, int from, int to) {
		return chars(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(float[] in, int inlen, int from, int to, char[] out) {
		return chars(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(float[] in, int inlen, int from, int to, char[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (char) in[from];
		}
		return out;
	}

	// ============= double[] to char[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(double[] in) {
		return chars(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(double[] in, int inlen) {
		return chars(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(double[] in, int inlen, int from) {
		return chars(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(double[] in, int inlen, int from, int to) {
		return chars(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(double[] in, int inlen, int from, int to, char[] out) {
		return chars(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(double[] in, int inlen, int from, int to, char[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (char) in[from];
		}
		return out;
	}
//============ collection to char[]

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(Collection<? extends Number> in) {
		return chars(in, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(Collection<? extends Number> in, int from) {
		return chars(in, from, in.size());
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(Collection<? extends Number> in, int from, int to) {
		return chars(in, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(Collection<? extends Number> in, int from, int to, char[] out) {
		return chars(in, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public char[] chars(Collection<? extends Number> in, int from, int to, char[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new char[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		Iterator<? extends Number> it = in.iterator();
		int itnow = 0;
		while (it.hasNext() && itnow < from) {
			itnow++;
			it.next();
		}
		for (int i = 0; from < to && it.hasNext(); from++, i++) {
			out[i] = (char) it.next().intValue();
		}
		return out;
	}

	// ============= byte[] to int[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(byte[] in) {
		return ints(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(byte[] in, int inlen) {
		return ints(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(byte[] in, int inlen, int from) {
		return ints(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(byte[] in, int inlen, int from, int to) {
		return ints(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(byte[] in, int inlen, int from, int to, int[] out) {
		return ints(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(byte[] in, int inlen, int from, int to, int[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (int) in[from];
		}
		return out;
	}

	// ============= short[] to int[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(short[] in) {
		return ints(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(short[] in, int inlen) {
		return ints(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(short[] in, int inlen, int from) {
		return ints(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(short[] in, int inlen, int from, int to) {
		return ints(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(short[] in, int inlen, int from, int to, int[] out) {
		return ints(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(short[] in, int inlen, int from, int to, int[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (int) in[from];
		}
		return out;
	}

	// ============= char[] to int[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(char[] in) {
		return ints(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(char[] in, int inlen) {
		return ints(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(char[] in, int inlen, int from) {
		return ints(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(char[] in, int inlen, int from, int to) {
		return ints(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(char[] in, int inlen, int from, int to, int[] out) {
		return ints(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(char[] in, int inlen, int from, int to, int[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (int) in[from];
		}
		return out;
	}

	/**
	 * This method has the option to use {@link CodepointSupport}<br>
	 * e.g, input: "A9aB2", {@link CodepointSupport#DEBUG}<br>
	 * output: [65545, 97, 66562]<br>
	 * e.g, input: "A9aB2", {@link CodepointSupport#BMP}<br>
	 * output: [65, 57, 97, 66, 50]
	 * 
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(char[] in, int inlen, int from, int to, int[] out, int outlen, CodepointSupport sps) {
		if (!sps.isSupported())
			return ints(in, inlen, from, to, out, outlen);
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		int i = 0;
		for (; from < to; i++, from++) {
			int cp = 0;
			if (sps.isPair(in, inlen, from)) {
				cp = sps.toCodepoint(in[from], in[++from]);
			} else {
				cp = (int) in[from];
			}
			out[i] = cp;
		}
		return Lang.trim.in(out, i);
	}

	// ============= long[] to int[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(long[] in) {
		return ints(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(long[] in, int inlen) {
		return ints(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(long[] in, int inlen, int from) {
		return ints(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(long[] in, int inlen, int from, int to) {
		return ints(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(long[] in, int inlen, int from, int to, int[] out) {
		return ints(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(long[] in, int inlen, int from, int to, int[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (int) in[from];
		}
		return out;
	}

	// ============= float[] to int[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(float[] in) {
		return ints(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(float[] in, int inlen) {
		return ints(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(float[] in, int inlen, int from) {
		return ints(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(float[] in, int inlen, int from, int to) {
		return ints(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(float[] in, int inlen, int from, int to, int[] out) {
		return ints(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(float[] in, int inlen, int from, int to, int[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (int) in[from];
		}
		return out;
	}

	// ============= double[] to int[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(double[] in) {
		return ints(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(double[] in, int inlen) {
		return ints(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(double[] in, int inlen, int from) {
		return ints(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(double[] in, int inlen, int from, int to) {
		return ints(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(double[] in, int inlen, int from, int to, int[] out) {
		return ints(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(double[] in, int inlen, int from, int to, int[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (int) in[from];
		}
		return out;
	}
//============ collection to int[]

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(Collection<? extends Number> in) {
		return ints(in, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(Collection<? extends Number> in, int from) {
		return ints(in, from, in.size());
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(Collection<? extends Number> in, int from, int to) {
		return ints(in, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(Collection<? extends Number> in, int from, int to, int[] out) {
		return ints(in, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public int[] ints(Collection<? extends Number> in, int from, int to, int[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new int[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		Iterator<? extends Number> it = in.iterator();
		int itnow = 0;
		while (it.hasNext() && itnow < from) {
			itnow++;
			it.next();
		}
		for (int i = 0; from < to && it.hasNext(); from++, i++) {
			out[i] = it.next().intValue();
		}
		return out;
	}

	// ============= byte[] to long[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(byte[] in) {
		return longs(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(byte[] in, int inlen) {
		return longs(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(byte[] in, int inlen, int from) {
		return longs(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(byte[] in, int inlen, int from, int to) {
		return longs(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(byte[] in, int inlen, int from, int to, long[] out) {
		return longs(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(byte[] in, int inlen, int from, int to, long[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new long[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (long) in[from];
		}
		return out;
	}

	// ============= short[] to long[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(short[] in) {
		return longs(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(short[] in, int inlen) {
		return longs(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(short[] in, int inlen, int from) {
		return longs(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(short[] in, int inlen, int from, int to) {
		return longs(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(short[] in, int inlen, int from, int to, long[] out) {
		return longs(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(short[] in, int inlen, int from, int to, long[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new long[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (long) in[from];
		}
		return out;
	}

	// ============= char[] to long[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(char[] in) {
		return longs(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(char[] in, int inlen) {
		return longs(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(char[] in, int inlen, int from) {
		return longs(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(char[] in, int inlen, int from, int to) {
		return longs(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(char[] in, int inlen, int from, int to, long[] out) {
		return longs(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(char[] in, int inlen, int from, int to, long[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new long[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (long) in[from];
		}
		return out;
	}

	// ============= int[] to long[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(int[] in) {
		return longs(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(int[] in, int inlen) {
		return longs(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(int[] in, int inlen, int from) {
		return longs(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(int[] in, int inlen, int from, int to) {
		return longs(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(int[] in, int inlen, int from, int to, long[] out) {
		return longs(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(int[] in, int inlen, int from, int to, long[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new long[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (long) in[from];
		}
		return out;
	}

	// ============= float[] to long[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(float[] in) {
		return longs(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(float[] in, int inlen) {
		return longs(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(float[] in, int inlen, int from) {
		return longs(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(float[] in, int inlen, int from, int to) {
		return longs(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(float[] in, int inlen, int from, int to, long[] out) {
		return longs(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(float[] in, int inlen, int from, int to, long[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new long[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (long) in[from];
		}
		return out;
	}

	// ============= double[] to long[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(double[] in) {
		return longs(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(double[] in, int inlen) {
		return longs(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(double[] in, int inlen, int from) {
		return longs(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(double[] in, int inlen, int from, int to) {
		return longs(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(double[] in, int inlen, int from, int to, long[] out) {
		return longs(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(double[] in, int inlen, int from, int to, long[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new long[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (long) in[from];
		}
		return out;
	}
//============ collection to long[]

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(Collection<? extends Number> in) {
		return longs(in, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(Collection<? extends Number> in, int from) {
		return longs(in, from, in.size());
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(Collection<? extends Number> in, int from, int to) {
		return longs(in, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(Collection<? extends Number> in, int from, int to, long[] out) {
		return longs(in, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public long[] longs(Collection<? extends Number> in, int from, int to, long[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new long[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		Iterator<? extends Number> it = in.iterator();
		int itnow = 0;
		while (it.hasNext() && itnow < from) {
			itnow++;
			it.next();
		}
		for (int i = 0; from < to && it.hasNext(); from++, i++) {
			out[i] = it.next().longValue();
		}
		return out;
	}

	// ============= byte[] to float[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(byte[] in) {
		return floats(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(byte[] in, int inlen) {
		return floats(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(byte[] in, int inlen, int from) {
		return floats(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(byte[] in, int inlen, int from, int to) {
		return floats(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(byte[] in, int inlen, int from, int to, float[] out) {
		return floats(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(byte[] in, int inlen, int from, int to, float[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new float[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (float) in[from];
		}
		return out;
	}

	// ============= short[] to float[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(short[] in) {
		return floats(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(short[] in, int inlen) {
		return floats(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(short[] in, int inlen, int from) {
		return floats(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(short[] in, int inlen, int from, int to) {
		return floats(in, inlen, from, to);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(short[] in, int inlen, int from, int to, float[] out) {
		return floats(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(short[] in, int inlen, int from, int to, float[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new float[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (float) in[from];
		}
		return out;
	}

	// ============= char[] to float[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(char[] in) {
		return floats(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(char[] in, int inlen) {
		return floats(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(char[] in, int inlen, int from) {
		return floats(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(char[] in, int inlen, int from, int to) {
		return floats(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(char[] in, int inlen, int from, int to, float[] out) {
		return floats(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(char[] in, int inlen, int from, int to, float[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new float[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (float) in[from];
		}
		return out;
	}

	// ============= int[] to float[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(int[] in) {
		return floats(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(int[] in, int inlen) {
		return floats(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(int[] in, int inlen, int from) {
		return floats(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(int[] in, int inlen, int from, int to) {
		return floats(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(int[] in, int inlen, int from, int to, float[] out) {
		return floats(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(int[] in, int inlen, int from, int to, float[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new float[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (float) in[from];
		}
		return out;
	}

	// ============= long[] to float[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(long[] in) {
		return floats(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(long[] in, int inlen) {
		return floats(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(long[] in, int inlen, int from) {
		return floats(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(long[] in, int inlen, int from, int to) {
		return floats(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(long[] in, int inlen, int from, int to, float[] out) {
		return floats(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(long[] in, int inlen, int from, int to, float[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new float[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (float) in[from];
		}
		return out;
	}

	// ============= double[] to float[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(double[] in) {
		return floats(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(double[] in, int inlen) {
		return floats(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(double[] in, int inlen, int from) {
		return floats(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(double[] in, int inlen, int from, int to) {
		return floats(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(double[] in, int inlen, int from, int to, float[] out) {
		return floats(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(double[] in, int inlen, int from, int to, float[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new float[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (float) in[from];
		}
		return out;
	}
//============ collection to float[]

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(Collection<? extends Number> in) {
		return floats(in, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(Collection<? extends Number> in, int from) {
		return floats(in, from, in.size());
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(Collection<? extends Number> in, int from, int to) {
		return floats(in, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(Collection<? extends Number> in, int from, int to, float[] out) {
		return floats(in, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public float[] floats(Collection<? extends Number> in, int from, int to, float[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new float[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		Iterator<? extends Number> it = in.iterator();
		int itnow = 0;
		while (it.hasNext() && itnow < from) {
			itnow++;
			it.next();
		}
		for (int i = 0; from < to && it.hasNext(); from++, i++) {
			out[i] = it.next().floatValue();
		}
		return out;
	}

	// ============= byte[] to double[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(byte[] in) {
		return doubles(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(byte[] in, int inlen) {
		return doubles(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(byte[] in, int inlen, int from) {
		return doubles(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(byte[] in, int inlen, int from, int to) {
		return doubles(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(byte[] in, int inlen, int from, int to, double[] out) {
		return doubles(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(byte[] in, int inlen, int from, int to, double[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new double[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (double) in[from];
		}
		return out;
	}

	// ============= short[] to double[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(short[] in) {
		return doubles(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(short[] in, int inlen) {
		return doubles(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(short[] in, int inlen, int from) {
		return doubles(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(short[] in, int inlen, int from, int to) {
		return doubles(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(short[] in, int inlen, int from, int to, double[] out) {
		return doubles(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(short[] in, int inlen, int from, int to, double[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new double[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (double) in[from];
		}
		return out;
	}

	// ============= char[] to double[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(char[] in) {
		return doubles(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(char[] in, int inlen) {
		return doubles(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(char[] in, int inlen, int from) {
		return doubles(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(char[] in, int inlen, int from, int to) {
		return doubles(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(char[] in, int inlen, int from, int to, double[] out) {
		return doubles(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(char[] in, int inlen, int from, int to, double[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new double[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (double) in[from];
		}
		return out;
	}

	// ============= int[] to double[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(int[] in) {
		return doubles(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(int[] in, int inlen) {
		return doubles(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(int[] in, int inlen, int from) {
		return doubles(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(int[] in, int inlen, int from, int to) {
		return doubles(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(int[] in, int inlen, int from, int to, double[] out) {
		return doubles(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(int[] in, int inlen, int from, int to, double[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new double[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (double) in[from];
		}
		return out;
	}

	// ============= long[] to double[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(long[] in) {
		return doubles(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(long[] in, int inlen) {
		return doubles(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(long[] in, int inlen, int from) {
		return doubles(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(long[] in, int inlen, int from, int to) {
		return doubles(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(long[] in, int inlen, int from, int to, double[] out) {
		return doubles(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(long[] in, int inlen, int from, int to, double[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new double[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (double) in[from];
		}
		return out;
	}

	// ============= float[] to double[]
	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(float[] in) {
		return doubles(in, in.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(float[] in, int inlen) {
		return doubles(in, inlen, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(float[] in, int inlen, int from) {
		return doubles(in, inlen, from, inlen);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(float[] in, int inlen, int from, int to) {
		return doubles(in, inlen, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(float[] in, int inlen, int from, int to, double[] out) {
		return doubles(in, inlen, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * <b>Note: </b> Invoker must take care of all checks and length<br>
	 * <br>
	 * <b>Extend/Shrink:</b> N/A<br>
	 * <b>Capacity:</b> If required (if given output capacity not enough, reallocate
	 * new capacity)<br>
	 * <b>Reallocate:</b> If required (if given output is null, reallocate new
	 * array)<br>
	 * <b>New length:</b> Depend<br>
	 * <br>
	 * Convert given array int specific array, using regular type assignment
	 * 
	 * @param in     src array
	 * @param inlen  src length
	 * @param from   from inclusive index
	 * @param to     to exclusive index
	 * @param out    output array, if null, allocate new array
	 * @param outlen output length
	 */
	public double[] doubles(float[] in, int inlen, int from, int to, double[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new double[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		for (int i = 0; from < to; i++, from++) {
			out[i] = (double) in[from];
		}
		return out;
	}
//============ collection to double[]

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(Collection<? extends Number> in) {
		return doubles(in, 0);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(Collection<? extends Number> in, int from) {
		return doubles(in, from, in.size());
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(Collection<? extends Number> in, int from, int to) {
		return doubles(in, from, to, null);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(Collection<? extends Number> in, int from, int to, double[] out) {
		return doubles(in, from, to, out, out == null ? 0 : out.length);
	}

	/**
	 * @see #doubles(float[], int, int, int, double[], int)
	 */
	public double[] doubles(Collection<? extends Number> in, int from, int to, double[] out, int outlen) {
		int newoutlen = to - from;
		out = out == null ? new double[newoutlen] : Lang.capacity.ensure(out, outlen, newoutlen, true);
		Iterator<? extends Number> it = in.iterator();
		int itnow = 0;
		while (it.hasNext() && itnow < from) {
			itnow++;
			it.next();
		}
		for (int i = 0; from < to && it.hasNext(); from++, i++) {
			out[i] = it.next().doubleValue();
		}
		return out;
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

		// ============= short[] to byte[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in) {
			return bytes(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen) {
			return bytes(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen, int from) {
			return bytes(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen, int from, int to) {
			return bytes(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen, int from, int to, Endian read) {
			return bytes(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen, int from, int to, Endian read, byte[] out) {
			return bytes(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen) {
			return bytes(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(short[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new byte[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (byte) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= char[] to byte[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in) {
			return bytes(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen) {
			return bytes(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen, int from) {
			return bytes(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen, int from, int to) {
			return bytes(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen, int from, int to, Endian read) {
			return bytes(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen, int from, int to, Endian read, byte[] out) {
			return bytes(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen) {
			return bytes(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(char[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new byte[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (byte) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= int[] to byte[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in) {
			return bytes(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen) {
			return bytes(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen, int from) {
			return bytes(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen, int from, int to) {
			return bytes(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen, int from, int to, Endian read) {
			return bytes(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen, int from, int to, Endian read, byte[] out) {
			return bytes(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen) {
			return bytes(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(int[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new byte[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (byte) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= long[] to byte[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in) {
			return bytes(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen) {
			return bytes(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen, int from) {
			return bytes(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen, int from, int to) {
			return bytes(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen, int from, int to, Endian read) {
			return bytes(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen, int from, int to, Endian read, byte[] out) {
			return bytes(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen) {
			return bytes(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(long[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new byte[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (byte) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= float[] to byte[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in) {
			return bytes(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in, int inlen) {
			return bytes(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in, int inlen, int from) {
			return bytes(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in, int inlen, int from, int to) {
			return bytes(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in, int inlen, int from, int to, Endian read) {
			return bytes(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in, int inlen, int from, int to, Endian read, byte[] out) {
			return bytes(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen) {
			return bytes(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(float[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new byte[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (byte) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= double[] to byte[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in) {
			return bytes(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in, int inlen) {
			return bytes(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in, int inlen, int from) {
			return bytes(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in, int inlen, int from, int to) {
			return bytes(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in, int inlen, int from, int to, Endian read) {
			return bytes(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in, int inlen, int from, int to, Endian read, byte[] out) {
			return bytes(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen) {
			return bytes(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(double[] in, int inlen, int from, int to, Endian read, byte[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new byte[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (byte) in[read.index(from, inlen, in.length)];
			}
			return out;
		}
		// ============ collection to byte[]

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(Collection<? extends Number> in) {
			return bytes(in, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(Collection<? extends Number> in, int from) {
			return bytes(in, from, in.size());
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(Collection<? extends Number> in, int from, int to) {
			return bytes(in, from, to, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(Collection<? extends Number> in, int from, int to, byte[] out) {
			return bytes(in, from, to, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(Collection<? extends Number> in, int from, int to, byte[] out, int outlen) {
			return bytes(in, from, to, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public byte[] bytes(Collection<? extends Number> in, int from, int to, byte[] out, int outlen, Endian write) {
			Check.range(from, to, in.size());
			int newoutlen = to - from;
			out = out == null ? new byte[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			Iterator<? extends Number> it = in.iterator();
			int itnow = 0;
			while (it.hasNext() && itnow < from) {
				itnow++;
				it.next();
			}
			for (int i = 0; from < to && it.hasNext(); from++, i++) {
				out[write.index(i, newoutlen, out.length)] = it.next().byteValue();
			}
			return out;
		}

		// ============= byte[] to short[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in) {
			return shorts(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen) {
			return shorts(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen, int from) {
			return shorts(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen, int from, int to) {
			return shorts(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen, int from, int to, Endian read) {
			return shorts(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen, int from, int to, Endian read, short[] out) {
			return shorts(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen, int from, int to, Endian read, short[] out, int outlen) {
			return shorts(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(byte[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new short[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (short) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= char[] to short[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in) {
			return shorts(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen) {
			return shorts(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen, int from) {
			return shorts(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen, int from, int to) {
			return shorts(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen, int from, int to, Endian read) {
			return shorts(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen, int from, int to, Endian read, short[] out) {
			return shorts(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen, int from, int to, Endian read, short[] out, int outlen) {
			return shorts(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(char[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new short[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (short) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= int[] to short[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in) {
			return shorts(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen) {
			return shorts(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen, int from) {
			return shorts(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen, int from, int to) {
			return shorts(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen, int from, int to, Endian read) {
			return shorts(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen, int from, int to, Endian read, short[] out) {
			return shorts(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen, int from, int to, Endian read, short[] out, int outlen) {
			return shorts(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(int[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new short[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (short) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= long[] to short[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in) {
			return shorts(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen) {
			return shorts(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen, int from) {
			return shorts(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen, int from, int to) {
			return shorts(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen, int from, int to, Endian read) {
			return shorts(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen, int from, int to, Endian read, short[] out) {
			return shorts(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen, int from, int to, Endian read, short[] out, int outlen) {
			return shorts(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(long[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new short[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (short) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= float[] to short[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in) {
			return shorts(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in, int inlen) {
			return shorts(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in, int inlen, int from) {
			return shorts(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in, int inlen, int from, int to) {
			return shorts(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in, int inlen, int from, int to, Endian read) {
			return shorts(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in, int inlen, int from, int to, Endian read, short[] out) {
			return shorts(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in, int inlen, int from, int to, Endian read, short[] out, int outlen) {
			return shorts(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(float[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new short[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (short) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= double[] to short[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in) {
			return shorts(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in, int inlen) {
			return shorts(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in, int inlen, int from) {
			return shorts(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in, int inlen, int from, int to) {
			return shorts(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in, int inlen, int from, int to, Endian read) {
			return shorts(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in, int inlen, int from, int to, Endian read, short[] out) {
			return shorts(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in, int inlen, int from, int to, Endian read, short[] out, int outlen) {
			return shorts(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(double[] in, int inlen, int from, int to, Endian read, short[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new short[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (short) in[read.index(from, inlen, in.length)];
			}
			return out;
		}
		// ============ collection to short[]

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(Collection<? extends Number> in) {
			return shorts(in, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(Collection<? extends Number> in, int from) {
			return shorts(in, from, in.size());
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(Collection<? extends Number> in, int from, int to) {
			return shorts(in, from, to, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(Collection<? extends Number> in, int from, int to, short[] out) {
			return shorts(in, from, to, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(Collection<? extends Number> in, int from, int to, short[] out, int outlen) {
			return shorts(in, from, to, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public short[] shorts(Collection<? extends Number> in, int from, int to, short[] out, int outlen,
				Endian write) {
			Check.range(from, to, in.size());
			int newoutlen = to - from;
			out = out == null ? new short[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			Iterator<? extends Number> it = in.iterator();
			int itnow = 0;
			while (it.hasNext() && itnow < from) {
				itnow++;
				it.next();
			}
			for (int i = 0; from < to && it.hasNext(); from++, i++) {
				out[write.index(i, newoutlen, out.length)] = it.next().shortValue();
			}
			return out;
		}

		// ============= byte[] to char[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in) {
			return chars(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen) {
			return chars(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen, int from) {
			return chars(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen, int from, int to) {
			return chars(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen, int from, int to, Endian read) {
			return chars(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen, int from, int to, Endian read, char[] out) {
			return chars(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen, int from, int to, Endian read, char[] out, int outlen) {
			return chars(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(byte[] in, int inlen, int from, int to, Endian read, char[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new char[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (char) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= short[] to char[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in) {
			return chars(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen) {
			return chars(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen, int from) {
			return chars(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen, int from, int to) {
			return chars(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen, int from, int to, Endian read) {
			return chars(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen, int from, int to, Endian read, char[] out) {
			return chars(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen, int from, int to, Endian read, char[] out, int outlen) {
			return chars(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(short[] in, int inlen, int from, int to, Endian read, char[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new char[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (char) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= int[] to char[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in) {
			return chars(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen) {
			return chars(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from) {
			return chars(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from, int to) {
			return chars(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from, int to, Endian read) {
			return chars(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from, int to, Endian read, char[] out) {
			return chars(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from, int to, Endian read, char[] out, int outlen) {
			return chars(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from, int to, Endian read, char[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new char[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (char) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		/**
		 * 
		 * This method has the option to use {@link CodepointSupport}<br>
		 * e.g, input: [65545, 97, 66562], {@link CodepointSupport#DEBUG}<br>
		 * output: [A, 9, a, B, 2]<br>
		 * e.g, input: [65, 57, 97, 66, 50], {@link CodepointSupport#BMP}<br>
		 * output: [A, 9, a, B, 2]
		 * 
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(int[] in, int inlen, int from, int to, Endian read, char[] out, int outlen, Endian write,
				CodepointSupport sps) {
			if (!sps.isSupported())
				return chars(in, inlen, from, to, read, out, outlen, write);
			Check.range(from, to, inlen);
			List<Character> l = new ArrayList<>();
			for (; from < to; from++) {
				if (sps.isPair(in, inlen, from)) {
					l.add(sps.toHigh(in[read.index(from, inlen, in.length)]));
					l.add(sps.toLow(in[read.index(from, inlen, in.length)]));
					continue;
				}
				l.add((char) in[read.index(from, inlen, in.length)]);
			}
			out = out == null ? new char[l.size()] : Lang.capacity.e.ensure(out, outlen, l.size(), write, true);
			return Lang.wrapper.unwrap(l.toArray(new Character[l.size()]), out);
		}

		// ============= long[] to char[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in) {
			return chars(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen) {
			return chars(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen, int from) {
			return chars(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen, int from, int to) {
			return chars(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen, int from, int to, Endian read) {
			return chars(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen, int from, int to, Endian read, char[] out) {
			return chars(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen, int from, int to, Endian read, char[] out, int outlen) {
			return chars(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(long[] in, int inlen, int from, int to, Endian read, char[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new char[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (char) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= float[] to char[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in) {
			return chars(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in, int inlen) {
			return chars(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in, int inlen, int from) {
			return chars(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in, int inlen, int from, int to) {
			return chars(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in, int inlen, int from, int to, Endian read) {
			return chars(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in, int inlen, int from, int to, Endian read, char[] out) {
			return chars(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in, int inlen, int from, int to, Endian read, char[] out, int outlen) {
			return chars(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(float[] in, int inlen, int from, int to, Endian read, char[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new char[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (char) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= double[] to char[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in) {
			return chars(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in, int inlen) {
			return chars(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in, int inlen, int from) {
			return chars(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in, int inlen, int from, int to) {
			return chars(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in, int inlen, int from, int to, Endian read) {
			return chars(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in, int inlen, int from, int to, Endian read, char[] out) {
			return chars(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in, int inlen, int from, int to, Endian read, char[] out, int outlen) {
			return chars(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(double[] in, int inlen, int from, int to, Endian read, char[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new char[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (char) in[read.index(from, inlen, in.length)];
			}
			return out;
		}
		// ============ collection to char[]

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(Collection<? extends Number> in) {
			return chars(in, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(Collection<? extends Number> in, int from) {
			return chars(in, from, in.size());
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(Collection<? extends Number> in, int from, int to) {
			return chars(in, from, to, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(Collection<? extends Number> in, int from, int to, char[] out) {
			return chars(in, from, to, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(Collection<? extends Number> in, int from, int to, char[] out, int outlen) {
			return chars(in, from, to, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public char[] chars(Collection<? extends Number> in, int from, int to, char[] out, int outlen, Endian write) {
			Check.range(from, to, in.size());
			int newoutlen = to - from;
			out = out == null ? new char[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			Iterator<? extends Number> it = in.iterator();
			int itnow = 0;
			while (it.hasNext() && itnow < from) {
				itnow++;
				it.next();
			}
			for (int i = 0; from < to && it.hasNext(); from++, i++) {
				out[write.index(i, newoutlen, out.length)] = (char) it.next().intValue();
			}
			return out;
		}

		// ============= byte[] to int[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in) {
			return ints(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen) {
			return ints(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen, int from) {
			return ints(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen, int from, int to) {
			return ints(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen, int from, int to, Endian read) {
			return ints(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen, int from, int to, Endian read, int[] out) {
			return ints(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen, int from, int to, Endian read, int[] out, int outlen) {
			return ints(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(byte[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (int) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= short[] to int[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in) {
			return ints(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen) {
			return ints(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen, int from) {
			return ints(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen, int from, int to) {
			return ints(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen, int from, int to, Endian read) {
			return ints(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen, int from, int to, Endian read, int[] out) {
			return ints(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen, int from, int to, Endian read, int[] out, int outlen) {
			return ints(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(short[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (int) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= char[] to int[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in) {
			return ints(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen) {
			return ints(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from) {
			return ints(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from, int to) {
			return ints(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from, int to, Endian read) {
			return ints(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from, int to, Endian read, int[] out) {
			return ints(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from, int to, Endian read, int[] out, int outlen) {
			return ints(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (int) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		/**
		 * This method has the option to use {@link CodepointSupport}<br>
		 * e.g, input: "A9aB2", {@link CodepointSupport#DEBUG}<br>
		 * output: [65545, 97, 66562]<br>
		 * e.g, input: "A9aB2", {@link CodepointSupport#BMP}<br>
		 * output: [65, 57, 97, 66, 50]
		 * 
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(char[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write,
				CodepointSupport sps) {
			if (!sps.isSupported())
				return ints(in, inlen, from, to, read, out, outlen, write);
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			int i = 0;
			for (; from < to; i++, from++) {
				int cp = 0;
				if (sps.isPair(in, inlen, from)) {
					cp = sps.toCodepoint(in[read.index(from, inlen, in.length)],
							in[read.index(++from, inlen, in.length)]);
				} else {
					cp = (int) in[read.index(from, inlen, in.length)];
				}
				out[write.index(i, newoutlen, out.length)] = cp;
			}
			return Lang.trim.e.in(out, i, write);
		}

		// ============= long[] to int[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in) {
			return ints(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen) {
			return ints(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen, int from) {
			return ints(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen, int from, int to) {
			return ints(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen, int from, int to, Endian read) {
			return ints(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen, int from, int to, Endian read, int[] out) {
			return ints(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen, int from, int to, Endian read, int[] out, int outlen) {
			return ints(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(long[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (int) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= float[] to int[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in) {
			return ints(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in, int inlen) {
			return ints(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in, int inlen, int from) {
			return ints(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in, int inlen, int from, int to) {
			return ints(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in, int inlen, int from, int to, Endian read) {
			return ints(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in, int inlen, int from, int to, Endian read, int[] out) {
			return ints(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in, int inlen, int from, int to, Endian read, int[] out, int outlen) {
			return ints(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(float[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (int) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= double[] to int[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in) {
			return ints(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in, int inlen) {
			return ints(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in, int inlen, int from) {
			return ints(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in, int inlen, int from, int to) {
			return ints(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in, int inlen, int from, int to, Endian read) {
			return ints(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in, int inlen, int from, int to, Endian read, int[] out) {
			return ints(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in, int inlen, int from, int to, Endian read, int[] out, int outlen) {
			return ints(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(double[] in, int inlen, int from, int to, Endian read, int[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (int) in[read.index(from, inlen, in.length)];
			}
			return out;
		}
		// ============ collection to int[]

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(Collection<? extends Number> in) {
			return ints(in, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(Collection<? extends Number> in, int from) {
			return ints(in, from, in.size());
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(Collection<? extends Number> in, int from, int to) {
			return ints(in, from, to, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(Collection<? extends Number> in, int from, int to, int[] out) {
			return ints(in, from, to, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(Collection<? extends Number> in, int from, int to, int[] out, int outlen) {
			return ints(in, from, to, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public int[] ints(Collection<? extends Number> in, int from, int to, int[] out, int outlen, Endian write) {
			Check.range(from, to, in.size());
			int newoutlen = to - from;
			out = out == null ? new int[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			Iterator<? extends Number> it = in.iterator();
			int itnow = 0;
			while (it.hasNext() && itnow < from) {
				itnow++;
				it.next();
			}
			for (int i = 0; from < to && it.hasNext(); from++, i++) {
				out[write.index(i, newoutlen, out.length)] = it.next().intValue();
			}
			return out;
		}

		// ============= byte[] to long[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in) {
			return longs(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen) {
			return longs(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen, int from) {
			return longs(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen, int from, int to) {
			return longs(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen, int from, int to, Endian read) {
			return longs(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen, int from, int to, Endian read, long[] out) {
			return longs(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen, int from, int to, Endian read, long[] out, int outlen) {
			return longs(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(byte[] in, int inlen, int from, int to, Endian read, long[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new long[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (long) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= short[] to long[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in) {
			return longs(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen) {
			return longs(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen, int from) {
			return longs(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen, int from, int to) {
			return longs(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen, int from, int to, Endian read) {
			return longs(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen, int from, int to, Endian read, long[] out) {
			return longs(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen, int from, int to, Endian read, long[] out, int outlen) {
			return longs(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(short[] in, int inlen, int from, int to, Endian read, long[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new long[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (long) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= char[] to long[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in) {
			return longs(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen) {
			return longs(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen, int from) {
			return longs(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen, int from, int to) {
			return longs(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen, int from, int to, Endian read) {
			return longs(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen, int from, int to, Endian read, long[] out) {
			return longs(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen, int from, int to, Endian read, long[] out, int outlen) {
			return longs(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(char[] in, int inlen, int from, int to, Endian read, long[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new long[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (long) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= int[] to long[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in) {
			return longs(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in, int inlen) {
			return longs(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in, int inlen, int from) {
			return longs(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in, int inlen, int from, int to) {
			return longs(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in, int inlen, int from, int to, Endian read) {
			return longs(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in, int inlen, int from, int to, Endian read, long[] out) {
			return longs(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in, int inlen, int from, int to, Endian read, long[] out, int outlen) {
			return longs(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(int[] in, int inlen, int from, int to, Endian read, long[] out, int outlen, Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new long[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (long) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= float[] to long[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in) {
			return longs(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in, int inlen) {
			return longs(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in, int inlen, int from) {
			return longs(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in, int inlen, int from, int to) {
			return longs(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in, int inlen, int from, int to, Endian read) {
			return longs(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in, int inlen, int from, int to, Endian read, long[] out) {
			return longs(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in, int inlen, int from, int to, Endian read, long[] out, int outlen) {
			return longs(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(float[] in, int inlen, int from, int to, Endian read, long[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new long[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (long) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= double[] to long[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in) {
			return longs(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in, int inlen) {
			return longs(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in, int inlen, int from) {
			return longs(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in, int inlen, int from, int to) {
			return longs(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in, int inlen, int from, int to, Endian read) {
			return longs(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in, int inlen, int from, int to, Endian read, long[] out) {
			return longs(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in, int inlen, int from, int to, Endian read, long[] out, int outlen) {
			return longs(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(double[] in, int inlen, int from, int to, Endian read, long[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new long[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (long) in[read.index(from, inlen, in.length)];
			}
			return out;
		}
		// ============ collection to long[]

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(Collection<? extends Number> in) {
			return longs(in, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(Collection<? extends Number> in, int from) {
			return longs(in, from, in.size());
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(Collection<? extends Number> in, int from, int to) {
			return longs(in, from, to, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(Collection<? extends Number> in, int from, int to, long[] out) {
			return longs(in, from, to, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(Collection<? extends Number> in, int from, int to, long[] out, int outlen) {
			return longs(in, from, to, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public long[] longs(Collection<? extends Number> in, int from, int to, long[] out, int outlen, Endian write) {
			Check.range(from, to, in.size());
			int newoutlen = to - from;
			out = out == null ? new long[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			Iterator<? extends Number> it = in.iterator();
			int itnow = 0;
			while (it.hasNext() && itnow < from) {
				itnow++;
				it.next();
			}
			for (int i = 0; from < to && it.hasNext(); from++, i++) {
				out[write.index(i, newoutlen, out.length)] = it.next().longValue();
			}
			return out;
		}

		// ============= byte[] to float[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in) {
			return floats(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in, int inlen) {
			return floats(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in, int inlen, int from) {
			return floats(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in, int inlen, int from, int to) {
			return floats(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in, int inlen, int from, int to, Endian read) {
			return floats(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in, int inlen, int from, int to, Endian read, float[] out) {
			return floats(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in, int inlen, int from, int to, Endian read, float[] out, int outlen) {
			return floats(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(byte[] in, int inlen, int from, int to, Endian read, float[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new float[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (float) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= short[] to float[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in) {
			return floats(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in, int inlen) {
			return floats(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in, int inlen, int from) {
			return floats(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in, int inlen, int from, int to) {
			return floats(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in, int inlen, int from, int to, Endian read) {
			return floats(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in, int inlen, int from, int to, Endian read, float[] out) {
			return floats(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in, int inlen, int from, int to, Endian read, float[] out, int outlen) {
			return floats(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(short[] in, int inlen, int from, int to, Endian read, float[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new float[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (float) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= char[] to float[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in) {
			return floats(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in, int inlen) {
			return floats(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in, int inlen, int from) {
			return floats(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in, int inlen, int from, int to) {
			return floats(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in, int inlen, int from, int to, Endian read) {
			return floats(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in, int inlen, int from, int to, Endian read, float[] out) {
			return floats(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in, int inlen, int from, int to, Endian read, float[] out, int outlen) {
			return floats(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(char[] in, int inlen, int from, int to, Endian read, float[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new float[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (float) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= int[] to float[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in) {
			return floats(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in, int inlen) {
			return floats(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in, int inlen, int from) {
			return floats(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in, int inlen, int from, int to) {
			return floats(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in, int inlen, int from, int to, Endian read) {
			return floats(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in, int inlen, int from, int to, Endian read, float[] out) {
			return floats(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in, int inlen, int from, int to, Endian read, float[] out, int outlen) {
			return floats(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(int[] in, int inlen, int from, int to, Endian read, float[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new float[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (float) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= long[] to float[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in) {
			return floats(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in, int inlen) {
			return floats(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in, int inlen, int from) {
			return floats(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in, int inlen, int from, int to) {
			return floats(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in, int inlen, int from, int to, Endian read) {
			return floats(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in, int inlen, int from, int to, Endian read, float[] out) {
			return floats(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in, int inlen, int from, int to, Endian read, float[] out, int outlen) {
			return floats(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(long[] in, int inlen, int from, int to, Endian read, float[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new float[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (float) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= double[] to float[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in) {
			return floats(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in, int inlen) {
			return floats(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in, int inlen, int from) {
			return floats(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in, int inlen, int from, int to) {
			return floats(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in, int inlen, int from, int to, Endian read) {
			return floats(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in, int inlen, int from, int to, Endian read, float[] out) {
			return floats(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in, int inlen, int from, int to, Endian read, float[] out, int outlen) {
			return floats(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(double[] in, int inlen, int from, int to, Endian read, float[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new float[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (float) in[read.index(from, inlen, in.length)];
			}
			return out;
		}
		// ============ collection to float[]

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(Collection<? extends Number> in) {
			return floats(in, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(Collection<? extends Number> in, int from) {
			return floats(in, from, in.size());
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(Collection<? extends Number> in, int from, int to) {
			return floats(in, from, to, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(Collection<? extends Number> in, int from, int to, float[] out) {
			return floats(in, from, to, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(Collection<? extends Number> in, int from, int to, float[] out, int outlen) {
			return floats(in, from, to, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public float[] floats(Collection<? extends Number> in, int from, int to, float[] out, int outlen,
				Endian write) {
			Check.range(from, to, in.size());
			int newoutlen = to - from;
			out = out == null ? new float[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			Iterator<? extends Number> it = in.iterator();
			int itnow = 0;
			while (it.hasNext() && itnow < from) {
				itnow++;
				it.next();
			}
			for (int i = 0; from < to && it.hasNext(); from++, i++) {
				out[write.index(i, newoutlen, out.length)] = it.next().floatValue();
			}
			return out;
		}

		// ============= byte[] to double[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(byte[] in) {
			return doubles(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(byte[] in, int inlen) {
			return doubles(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(byte[] in, int inlen, int from) {
			return doubles(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(byte[] in, int inlen, int from, int to) {
			return doubles(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(byte[] in, int inlen, int from, int to, Endian read) {
			return doubles(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(byte[] in, int inlen, int from, int to, Endian read, double[] out) {
			return doubles(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(byte[] in, int inlen, int from, int to, Endian read, double[] out, int outlen) {
			return doubles(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * <b>Note: </b> Invoker must take care of all checks and length<br>
		 * <br>
		 * <b>Extend/Shrink:</b> N/A<br>
		 * <b>Capacity:</b> If required (if given output capacity not enough, reallocate
		 * new capacity)<br>
		 * <b>Reallocate:</b> If required (if given output is null, reallocate new
		 * array)<br>
		 * <b>New length:</b> Depend<br>
		 * <br>
		 * Convert given array int specific array, using regular type assignment
		 * 
		 * @param in     src array
		 * @param inlen  src length
		 * @param from   from inclusive index
		 * @param to     to exclusive index
		 * @param out    output array, if null, allocate new array
		 * @param outlen output length
		 * @param read   src endian
		 * @param write  output endian
		 */
		public double[] doubles(byte[] in, int inlen, int from, int to, Endian read, double[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new double[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (double) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= short[] to double[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in) {
			return doubles(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in, int inlen) {
			return doubles(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in, int inlen, int from) {
			return doubles(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in, int inlen, int from, int to) {
			return doubles(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in, int inlen, int from, int to, Endian read) {
			return doubles(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in, int inlen, int from, int to, Endian read, double[] out) {
			return doubles(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in, int inlen, int from, int to, Endian read, double[] out, int outlen) {
			return doubles(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(short[] in, int inlen, int from, int to, Endian read, double[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new double[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (double) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= char[] to double[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in) {
			return doubles(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in, int inlen) {
			return doubles(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in, int inlen, int from) {
			return doubles(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in, int inlen, int from, int to) {
			return doubles(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in, int inlen, int from, int to, Endian read) {
			return doubles(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in, int inlen, int from, int to, Endian read, double[] out) {
			return doubles(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in, int inlen, int from, int to, Endian read, double[] out, int outlen) {
			return doubles(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(char[] in, int inlen, int from, int to, Endian read, double[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new double[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (double) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= int[] to double[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in) {
			return doubles(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in, int inlen) {
			return doubles(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in, int inlen, int from) {
			return doubles(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in, int inlen, int from, int to) {
			return doubles(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in, int inlen, int from, int to, Endian read) {
			return doubles(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in, int inlen, int from, int to, Endian read, double[] out) {
			return doubles(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in, int inlen, int from, int to, Endian read, double[] out, int outlen) {
			return doubles(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(int[] in, int inlen, int from, int to, Endian read, double[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new double[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (double) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= long[] to double[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in) {
			return doubles(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in, int inlen) {
			return doubles(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in, int inlen, int from) {
			return doubles(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in, int inlen, int from, int to) {
			return doubles(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in, int inlen, int from, int to, Endian read) {
			return doubles(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in, int inlen, int from, int to, Endian read, double[] out) {
			return doubles(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in, int inlen, int from, int to, Endian read, double[] out, int outlen) {
			return doubles(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(long[] in, int inlen, int from, int to, Endian read, double[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new double[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (double) in[read.index(from, inlen, in.length)];
			}
			return out;
		}

		// ============= float[] to double[]
		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in) {
			return doubles(in, in.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in, int inlen) {
			return doubles(in, inlen, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in, int inlen, int from) {
			return doubles(in, inlen, from, inlen);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in, int inlen, int from, int to) {
			return doubles(in, inlen, from, to, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in, int inlen, int from, int to, Endian read) {
			return doubles(in, inlen, from, to, read, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in, int inlen, int from, int to, Endian read, double[] out) {
			return doubles(in, inlen, from, to, read, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in, int inlen, int from, int to, Endian read, double[] out, int outlen) {
			return doubles(in, inlen, from, to, read, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(float[] in, int inlen, int from, int to, Endian read, double[] out, int outlen,
				Endian write) {
			Check.range(from, to, inlen);
			int newoutlen = to - from;
			out = out == null ? new double[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			for (int i = 0; from < to; i++, from++) {
				out[write.index(i, newoutlen, out.length)] = (double) in[read.index(from, inlen, in.length)];
			}
			return out;
		}
		// ============ collection to double[]

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(Collection<? extends Number> in) {
			return doubles(in, 0);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(Collection<? extends Number> in, int from) {
			return doubles(in, from, in.size());
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(Collection<? extends Number> in, int from, int to) {
			return doubles(in, from, to, null);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(Collection<? extends Number> in, int from, int to, double[] out) {
			return doubles(in, from, to, out, out == null ? 0 : out.length);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(Collection<? extends Number> in, int from, int to, double[] out, int outlen) {
			return doubles(in, from, to, out, outlen, Endian.LITTLE);
		}

		/**
		 * @see #doubles(double[], int, int, int, Endian, double[], int, Endian)
		 */
		public double[] doubles(Collection<? extends Number> in, int from, int to, double[] out, int outlen,
				Endian write) {
			Check.range(from, to, in.size());
			int newoutlen = to - from;
			out = out == null ? new double[newoutlen] : Lang.capacity.e.ensure(out, outlen, newoutlen, write, true);
			Iterator<? extends Number> it = in.iterator();
			int itnow = 0;
			while (it.hasNext() && itnow < from) {
				itnow++;
				it.next();
			}
			for (int i = 0; from < to && it.hasNext(); from++, i++) {
				out[write.index(i, newoutlen, out.length)] = it.next().doubleValue();
			}
			return out;
		}
	}
}
