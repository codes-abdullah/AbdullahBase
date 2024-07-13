package codes.abdullah.project.generate;

import static codes.abdullah.digits.NumberUtils.and;
import static codes.abdullah.digits.NumberUtils.crop;
import static codes.abdullah.digits.NumberUtils.shiftRightUnsigned;
import static codes.abdullah.project.generate.GenerateSmallToBigTests.declare;
import static codes.abdullah.project.generate.GenerateSmallToBigTests.findLargests;
import static codes.abdullah.project.generate.GenerateSmallToBigTests.header;
import static codes.abdullah.project.generate.GenerateSmallToBigTests.sizeToArrayDecl;
import static codes.abdullah.project.generate.GenerateSmallToBigTests.sizeToInvok;

import codes.abdullah.digits.NumberUtils;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;


/**
 * Will generate testing blocks for {@link Lang} conversion methods
 */
class GenerateBigToSmallTests {

	public static void main(String[] args) {

		int[] ranges = { //
				0, 4, //
				0, 1, //
				0, 2, //
				0, 3, //
				2, 3, //
				2, 4, //
				1, 3,//
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

				if (_in_size <= _out_size)
					continue;

//				System.out.println(_in_size + " vs " + _out_size);
//				_in_size = 32;
				Number[] small = inputs(_in_size);
//				ranges = new int[] { 0, 1 };
//				_in_size = 32;
//				_out_size = 8;
//				small = new Number[] { Integer.MIN_VALUE };
//				small = inputs(32);
//				System.out.println();
				System.out.printf(declare(_in_size, _out_size), header(small, _in_size, _out_size),
						body(small, ranges, _in_size, _out_size), "");
				System.out.println();
				System.out.println();
//				break;
			}
		}

	}

	private static Number[] inputs(int _in_size) {
		Number[] shorts = new Number[] { (short) 10, (short) -10, Short.MAX_VALUE, Short.MIN_VALUE };
		Number[] ints = new Number[] { 10, -10, Integer.MAX_VALUE, Integer.MIN_VALUE };
		Number[] longs = new Number[] { 10L, -10L, Long.MAX_VALUE, Long.MIN_VALUE };
		if (_in_size == 16)
			return shorts;
		else if (_in_size == 32)
			return ints;
		else if (_in_size == 64)
			return longs;
		return null;
	}

	public static String to(Number[] in, int inlen, int from, int to, Endian read, Endian write, int _in_size,
			int _out_size) {
		final int _outputs_per_input = _in_size / _out_size;
		final Number _out_mask = NumberUtils.maskOf(_out_size);
		final Number _in_mask = NumberUtils.maskOf(_in_size);
		inlen = to - from;
		StringBuilder s = new StringBuilder();
		int atIn;
		Number tmp = 0;
		for (; from < to - 1; from++) {
			atIn = read.index(from, inlen, in.length);
			tmp = crop(in[atIn], _in_size);
			for (int j = 0; j < _outputs_per_input; j++) {
				if (write.isLittle()) {
					s.append(crop(tmp, _out_size));
					if (j < _outputs_per_input - 1) {
						s.append(", ");
					}
				} else {
					if (j > 0)
						s.insert(0, ", ");
					s.insert(0, crop(tmp, _out_size));
				}

				tmp = and(shiftRightUnsigned(tmp, _out_size), _in_mask);
			}
			if (write.isLittle()) {
				if (from < to - 1) {
					s.append(", ");
				}
			} else {
				if (from < to - 1) {
					s.insert(0, ", ");
				}
			}
		}
		

		final Number x = in[read.index(to - 1, inlen, in.length)];
		tmp = x;
		for (int j = 1; j <= _outputs_per_input;j++) {

			if (write.isLittle()) {
				s.append(crop(tmp, _out_size));
				if (j <= _outputs_per_input - 1) {
					s.append(", ");
				}
			} else {
				s.insert(0, crop(tmp, _out_size));
				if (j <= _outputs_per_input - 1) {
					s.insert(0, ", ");
				}
			}
		
			tmp = shiftRightUnsigned(x, _out_size*j);
			tmp = and(tmp, _out_mask);
		}
		return s.toString();
	}

	private static String body(Number[] inputs, int[] ranges, int _in_size, int _out_size) {
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
					int from = ranges[xx], to = ranges[xx + 1];
					String x = to(inputs, inputs.length, from, to, read, write, _in_size, _out_size);
					String outArrDec = sizeToArrayDecl(_out_size);
					String str = String.format(
							"" + "		from = %d;\n" + "		to = %d;\n" + "		expected = new %s { %s };//\n"
									+ "		result = Lang.%s(in, inlen, from, to, read, null, 0, write);\n"
									+ "		assertEquals(Arrays.toString(expected), Arrays.toString(result));\n"
									+ "		assertArrayEquals(expected, result);\n",
							from, to, outArrDec, x, sizeToInvok(_out_size));
					s.append(str);
					s.append("\t\t//=======================\n");
					xx++;
				}
			}
		}
		return s.toString();
	}

}
