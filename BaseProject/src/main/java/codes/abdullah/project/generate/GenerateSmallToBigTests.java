package codes.abdullah.project.generate;

import java.util.Arrays;
import java.util.stream.Collectors;

import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;


/**
 * Will generate testing blocks for {@link Lang} conversion methods
 */
class GenerateSmallToBigTests {
	public static void main(String[] args) {

		Object[] small = { -18, 66, -6, 3, 4, -128, 0, 19 };
		int[] ranges = { //
				0, 8, //
				0, 4, //
				2, 6, //
				6, 8, //
				1, 5, //
				1, 7, //
				0, 3,//
		};

		int[] wrongRanges = { //
				3, findLargests(ranges) + 3, //
				-11, 4, //
				0, -20, //
		};

		int[] sizes = { 8, 16, 32, 64 };

		for (int i = 0; i < sizes.length; i++) {
			int _in_size = sizes[i];
			for (int j = 0; j < sizes.length; j++) {
				int _out_size = sizes[j];
//				System.out.println(_in_size+" vs "+_out_size);
				if (_in_size >= _out_size)
					continue;

//				_in_size = 16;
//				_out_size=8;
				System.out.printf(declare(_in_size, _out_size), header(small, _in_size, _out_size),
						body(small, ranges, _in_size, _out_size), footer(wrongRanges, _in_size, _out_size));
				System.out.println();
				System.out.println();
			}
		}

		System.out.println();
		for (int i = 0; i < sizes.length; i++) {
			int _in_size = sizes[i];
			for (int j = 0; j < sizes.length; j++) {
				int _out_size = sizes[j];
//				System.out.println(_in_size+" vs "+_out_size);
				if (_in_size >= _out_size)
					continue;
				System.out.println(generateExceptionMethods(_in_size, _out_size));
			}
		}
	}

	static int findLargests(int[] ranges) {
		int x = 0;
		for (int i = 0; i < ranges.length; i++) {
			if (ranges[i] > x)
				x = ranges[i];
		}
		return x;
	}

	static String header(Object[] in, int _in_size, int _out_size) {
		String _in_arr = sizeToArrayDecl(_in_size);
		String _out_arr = sizeToArrayDecl(_out_size);
//		int[] expected = null, result = null;
//		byte[] in = new byte[] { -18, 66, -6, 3, 4, -128, 0, 19 };
//		int inlen = 0;
//		int from = 0;
//		int to = 0;
//		Endian read = Endian.LITTLE;
//		Endian write = Endian.LITTLE;
		return String.format("		%s expected = null, result = null;\n" + "		%s in = { %s };\n"
				+ "		int inlen = 0;\n" + "		int from = 0;\n" + "		int to = 0;\n"
				+ "		Endian read = Endian.LITTLE;\n" + "		Endian write = Endian.LITTLE;", _out_arr, _in_arr,
				arr2str_strip(in));
	}

	private static String body(Object[] small, int[] ranges, int _in_size, int _out_size) {
		StringBuilder s = new StringBuilder();
		Endian[] endians = Endian.values();
		for (int i = 0; i < endians.length; i++) {
			for (int j = 0; j < endians.length; j++) {
				Endian read = endians[i];
				Endian write = endians[j];
				s.append("\t\t//=======================\n");
				s.append("\t\t//=======================\n");
				s.append(String.format("\t\t//======================= %s to %s\n", read, write));
				s.append("\t\t//=======================\n");
				s.append("\t\t//=======================\n");
				s.append(String.format("\t\tread = Endian.%s;\n", read));
				s.append(String.format("\t\twrite = Endian.%s;\n", write));
				for (int xx = 0; xx < ranges.length / 2; xx++) {
					String x = to(small, small.length, ranges[xx], ranges[xx + 1], read, write, _in_size, _out_size);

					String outArrDec = sizeToArrayDecl(_out_size);
					String str = String.format(
							"" + "		from = %d;\n" + "		to = %d;\n" + "		expected = new %s { %s };//\n"
									+ "		result = Lang.%s(in, inlen, from, to, read, null, 0, write);\n"
									+ "		assertEquals(Arrays.toString(expected), Arrays.toString(result));\n"
									+ "		assertArrayEquals(expected, result);\n",
							ranges[xx], ranges[xx + 1], outArrDec, x, sizeToInvok(_out_size));
					s.append(str);
					s.append("\t\t//=======================\n");
					xx++;
				}
			}
		}
		return s.toString();
	}

	static String declare(int _in_size, int _out_size) {
		return String.format("\t\t@Test public void test%sTo%s(){\n%%s\n\n%%s\n\n%%s}\n", sizeToType(_in_size),
				sizeToType(_out_size));
	}

	static String footer(int[] wrongRanges, int _in_size, int _out_size) {
		StringBuilder s = new StringBuilder("		// ==================\n" + "		// ==================\n"
				+ "		// ==================\n" + "		// ==================\n" + "		// ==================\n"
				+ "		// ==================\n");

		String ex1 = "ArrayIndexOutOfBoundsException.class";
		String ex2 = "NegativeArraySizeException.class";
		for (int i = 0; i < wrongRanges.length / 2; i++) {

			String ex = ex1;
			int from = wrongRanges[i];
			int to = wrongRanges[i + 1];
			if (to - from < 0)
				ex = ex2;

			String name = sizeToType(_in_size) + "To" + sizeToType(_out_size);
			s.append(String.format("from = %d; to = %d;\n", from, to));
			s.append(String.format("assertTest%sThrows(%s, in, inlen, from, to, read, null, 0, write);\n", name, ex));
			s.append("\t\t// ==================\n");
		}

		return s.toString();
	}

	private static String generateExceptionMethods(int _in_size, int _out_size) {
		String method = sizeToType(_out_size);
		if (method.equals("Integer"))
			method = "Int";
		String name = sizeToType(_in_size) + "To" + sizeToType(_out_size);
		return String.format("\n"
				+ "	private void assertTest%sThrows(Class<? extends Throwable> cls, %s in, int inlen, int from, int to,\n"
				+ "			Endian read, %s out, int outlen, Endian write) {\n"
				+ "		assertThrows(cls, () -> Lang.to%sArray(in, inlen, from, to, read, null, 0, write));\n"
				+ "	}\n", name, sizeToArrayDecl(_in_size), sizeToArrayDecl(_out_size), method);
	}

	private static String to(Object[] in, int inlen, int from, int to, Endian read, Endian write, int _in_size,
			int _out_size) {
		inlen = to - from;
		final int parts = _out_size / _in_size;
		final int arr_out_len = (inlen + (parts - 1)) / parts;
		final long mask = (1L << _in_size) - 1;
		Object tmp = 0;
		StringBuilder all = new StringBuilder();
		for (int i = 0; i < arr_out_len; i++) {
			tmp = in[read.index(from++, inlen, in.length)];
			StringBuilder s = new StringBuilder();
			String maskhex = "0x" + Long.toHexString(mask).toUpperCase();
			if (_out_size == 64)
				maskhex += "L";
			s.append(String.format("(%d & %s)", tmp, maskhex));
			for (int j = 1; j < parts && from < to; j++) {
				tmp = in[read.index(from++, inlen, in.length)];
				s.append(String.format(" | ((%d & %s) << (%s.SIZE * %d))", tmp, maskhex, sizeToType(_in_size), j));
			}

			if (_out_size < Integer.SIZE)
				s.insert(0, "(" + sizeToType(_out_size).toLowerCase() + ")(").append(")");

			if (write.isLittle()) {
				all.append(s);
				if (i < arr_out_len - 1)
					all.append(", ");
			} else {
				if (i > 0)
					all.insert(0, ", ");
				all.insert(0, s);
			}

			s.delete(0, s.length());
		}
		return all.toString();
	}

	static String sizeToType(int size) {
		switch (size) {
		case 8:
			return "Byte";
		case 16:
			return "Short";
		case 32:
			return "Integer";
		case 64:
			return "Long";
		default:
			throw new IllegalStateException();
		}
	}

	static String sizeToInvok(int _out_size) {
		switch (_out_size) {
		case 8:
			return "toByteArray";
		case 16:
			return "toShortArray";
		case 32:
			return "toIntArray";
		case 64:
			return "toLongArray";
		default:
			throw new IllegalStateException();
		}
	}

	static String sizeToArrayDecl(int size) {
		switch (size) {
		case 8:
			return "byte[]";
		case 16:
			return "short[]";
		case 32:
			return "int[]";
		case 64:
			return "long[]";
		default:
			throw new IllegalStateException();
		}
	}

	static String arr2str_strip(Object[] arr) {
		return Arrays.stream(arr).map((e) -> e instanceof Long ? String.valueOf(e) + "L" : String.valueOf(e))
				.collect(Collectors.joining(", "));
	}

}
