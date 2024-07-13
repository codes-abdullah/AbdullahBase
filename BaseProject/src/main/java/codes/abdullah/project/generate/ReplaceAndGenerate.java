package codes.abdullah.project.generate;

import java.io.IOException;
import java.util.Objects;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

class ReplaceAndGenerate {

	public static void main(String[] args) throws IOException {
		generate();
	}

	// ======================
	// ======================
	// ====================== boolean
	// ======================
	// ======================

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to) {
		return in(arr, len, displacement, from, to, 0);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder) {
		return in(arr, len, displacement, from, to, fromBorder, len);
	}

	/**
	 * @see #in(double[], int, int, int, int, int, int, Endian)
	 */
	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {
		try {
			final boolean neg = displacement < 0;
			displacement = Math.abs(displacement);
			final int from0 = from;
			final int to0 = to;
			final int bfrom0 = fromBorder;
			final int bto0 = toBorder;
			int range = to0 - from0;
			int max_displacement = bto0 - from0 - 1;
			int copyinto = from0 + displacement;

			int copyfrom = from0;
			int remain = bto0 - (copyinto + range);
			int copylen = Math.min(range, range + remain);

			if (neg) {
				max_displacement = to0 - bfrom0 - 1;
				remain = from0 - bfrom0;
				copyinto = from0 - displacement;
				copylen = Math.min(range, range + (copyinto - bfrom0));
				copyinto = Math.max(bfrom0, from0 - displacement);
				copyfrom = to0 - copylen;
			}

			if (displacement > max_displacement)
				return arr;

			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);
		} catch (Exception e) {
			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);
		}
		return arr;
	}

	private void checkDisplacementException(Exception e, Object arr, int len, int displacement, int from, int to,
			int bfrom, int bto, Object o) {

	}

	public static void generate() throws IOException {
//		String[] ss = "boolean,byte,short,char,int,long,float,double".split(",");
		String[] ss = "boolean,byte,short,char,int,long,float,double,T".split(",");
//		String[] ss = "boolean,byte".split(",");
//		String[] ss = "int,long,float,double".split(",");
//		String[] ss = "byte,short,char".split(",");
//		String[] ss = "short,int,long".split(",");
//		String[] ss = "byte,short,int,long".split(",");
		String s = "	// ======================\n"
				+ "	// ======================\n"
				+ "	// ====================== boolean\n"
				+ "	// ======================\n"
				+ "	// ======================\n"
				+ "\n"
				+ "	/**\n"
				+ "	 * @see #in(double[], int, int, int, int, int, int, Endian)\n"
				+ "	 */\n"
				+ "	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to) {\n"
				+ "		return in(arr, len, displacement, from, to, 0);\n"
				+ "	}\n"
				+ "\n"
				+ "	/**\n"
				+ "	 * @see #in(double[], int, int, int, int, int, int, Endian)\n"
				+ "	 */\n"
				+ "	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder) {\n"
				+ "		return in(arr, len, displacement, from, to, fromBorder, len);\n"
				+ "	}\n"
				+ "\n"
				+ "	/**\n"
				+ "	 * @see #in(double[], int, int, int, int, int, int, Endian)\n"
				+ "	 */\n"
				+ "	public boolean[] in(boolean[] arr, int len, int displacement, int from, int to, int fromBorder, int toBorder) {\n"
				+ "		try {\n"
				+ "			final boolean neg = displacement < 0;\n"
				+ "			displacement = Math.abs(displacement);\n"
				+ "			final int from0 = from;\n"
				+ "			final int to0 = to;\n"
				+ "			final int bfrom0 = fromBorder;\n"
				+ "			final int bto0 = toBorder;\n"
				+ "			int range = to0 - from0;\n"
				+ "			int max_displacement = bto0 - from0 - 1;\n"
				+ "			int copyinto = from0 + displacement;\n"
				+ "\n"
				+ "			int copyfrom = from0;\n"
				+ "			int remain = bto0 - (copyinto + range);\n"
				+ "			int copylen = Math.min(range, range + remain);\n"
				+ "\n"
				+ "			if (neg) {\n"
				+ "				max_displacement = to0 - bfrom0 - 1;\n"
				+ "				remain = from0 - bfrom0;\n"
				+ "				copyinto = from0 - displacement;\n"
				+ "				copylen = Math.min(range, range + (copyinto - bfrom0));\n"
				+ "				copyinto = Math.max(bfrom0, from0 - displacement);\n"
				+ "				copyfrom = to0 - copylen;\n"
				+ "			}\n"
				+ "\n"
				+ "			if (displacement > max_displacement)\n"
				+ "				return arr;\n"
				+ "\n"
				+ "			System.arraycopy(arr, copyfrom, arr, copyinto, copylen);\n"
				+ "		} catch (Exception e) {\n"
				+ "			checkDisplacementException(e, arr, len, displacement, from, to, fromBorder, toBorder, null);\n"
				+ "		}\n"
				+ "		return arr;\n"
				+ "	}";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ss.length; i++) {
			String to = ss[i];
			for (int j = 0; j < 1; j++) {
//				if (j == i)
//					continue;
				String from = "boolean";
//				String s2 = s.replaceAll("xxxx", to).replaceAll("YYYY", cap(to)).replaceAll("xxxx", from).replaceAll("XXXX", cap(from));
				String s2 = s.replaceAll(from, to).replace(cap(from), cap(to));
//				s2 = s2.replaceAll("Character", "Char").replaceAll("Integer", "Int").replaceAll("it.next\\(\\)\\.charValue\\(\\)", "(char)it.next().intValue()");
				// sb.append(s2).append("\n");

				if (to.equals("T")) {
					s2 = s2.replaceAll("static", "static <T>");
				}
				System.out.println(s2);
//				System.out.println(from+" to "+to);
			}
//			
//			String s2 = jj.replaceAll("yyyy", to).replaceAll("YYYY", cap(to));
//			s2 = s2.replaceAll("Character", "Char").replaceAll("Integer", "Int").replaceAll("it.next\\(\\)\\.charValue\\(\\)", "(char)it.next().intValue()");
//			sb.append(s2).append("\n");

//			System.out.println();

		}

//		Files.write(Paths.get("/home/abod/junk/f1"), sb.toString().getBytes());
//		System.out.println(sb);
	}

	private static String cap(String s) {
		if (s.equals("int"))
			s = "integer";
		else if (s.equals("char"))
			s = "character";
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

	private static void checkCopyThrowedReasonV2(RuntimeException e, Object in, int inlen, int from, int to,
			Endian read, Object out, int outlen, int writeAtIndex, Endian write, int copylen) {
		Objects.requireNonNull(in, "input array is null");
		Objects.requireNonNull(out, "output array is null");
		Objects.requireNonNull(read, "read endian is null");
		Objects.requireNonNull(write, "write endian is null");
		Check.insertIndex(writeAtIndex, Lang.constant.ARRAY_SAFE_CAPACITY - (to - from));
		Check.range(from, to, inlen);
		throw e;
	}

}
