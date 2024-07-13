package codes.abdullah.project.lang;

import java.util.StringJoiner;

class X {

	public void ofByte() {

	}

	public static void main(String[] args) {
//		String[] types = { "byte", "short", "int", "long" };
		String[] types = { "boolean", "byte", "short", "char", "int", "long", "float", "double" };
		String[] params = { "in", "out", "int outlen", "boolean skipZeros", "Endian write" };
		String[] top = { "n", "null", "out == null ? 0 : out.length", "true", "Endian.LITTLE" };
		String[] btm = { "n", "out", "outlen", "skipZeros", "write" };

		for (int i = 0; i < types.length; i++) {
			String cls = types[i];
//			System.out.printf("%s %s = new %sImpl();\n", cls, cls, cls);

			System.out.printf("/**@return null array to avoid compiler ambiguous warrning caused by overriding*/\npublic %s[] of%ss(){return null;}\n", cls, Character.toUpperCase(cls.charAt(0)) + cls.substring(1));

		}

		System.exit(0);
		for (int i = 0; i < types.length; i++) {
			String in = types[i];
			System.out.printf("public static class %ssImpl implements %ss{\n", in, in);
			for (int j = 0; j < types.length; j++) {
				if (i == j)
					continue;
				String out = types[j];
				String methodName = "to" + cap(out) + "Array";
				StringJoiner sj = new StringJoiner(", ");

				for (int k = 0; k < params.length; k++) {
					String param = params[k];
					if (param.equals("in"))
						param = param.replace("in", in + " n");
					else if (param.equals("out"))
						param = param.replace("out", out + "[] out");
					sj.add(param);

//						System.out.println();

					if (k == params.length - 1) {
						System.out.printf("\t@Override\npublic %s[] %s(%s){return null;}\n", out, methodName, sj);
					} else {

					}

				}

			}
			System.out.println("}");
			System.out.println();
			System.out.println();
			System.out.println("\t\t//===================");
			System.out.println();

		}

		for (int i = 0; i < types.length; i++) {
			String in = types[i];
			System.out.println("public static interface " + in + "s {");
			for (int j = 0; j < types.length; j++) {
				if (i == j)
					continue;
				String out = types[j];
				String methodName = "to" + cap(out) + "Array";
				StringJoiner sj = new StringJoiner(", ");

				for (int k = 0; k < params.length; k++) {
					String param = params[k];
					if (param.equals("in"))
						param = param.replace("in", in + " n");
					else if (param.equals("out"))
						param = param.replace("out", out + "[] out");
					sj.add(param);

//					System.out.println();

					if (k == params.length - 1) {
						System.out.printf("\t%s[] %s(%s);\n", out, methodName, sj);
					} else {
						int rParamsCount = (k + 1) + 1;
						StringJoiner rsj = new StringJoiner(", ");
						for (int l = 0; l < rParamsCount; l++) {
							String p = btm[l];
							if (l == rParamsCount - 1)
								p = top[l];
//							System.out.println(p);
							rsj.add(p);
						}
						System.out.printf("\tdefault %s[] %s(%s){\n\t\treturn %s(%s);\n\t\t}\n", out, methodName, sj,
								methodName, rsj);
					}

				}

				System.out.println();
				System.out.println("\t\t//===================");
				System.out.println();

			}
			System.out.println("}");
			System.out.println();

		}
	}

	public static void main_old(String[] args) {
		String[] types = { "byte", "short", "int", "long" };
		String[] params = { "in", "out", "int outlen", "boolean skipZeros", "Endian write" };
		String[] top = { "n", "null", "out == null ? 0 : out.length", "true", "Endian.LITTLE" };
		String[] btm = { "n", "out", "outlen", "skipZeros", "write" };
		for (int i = 0; i < types.length; i++) {
			String out = types[i];
			System.out.println("public static class " + out + "s {");
			for (int j = 0; j < types.length; j++) {
				if (j == i)
					continue;
				String in = types[j];
				String methodName = "to" + cap(out) + "Array";
				StringJoiner sj = new StringJoiner(", ");

				for (int k = 0; k < params.length; k++) {
					String param = params[k];
					if (param.equals("in"))
						param = param.replace("in", in + " n");
					else if (param.equals("out"))
						param = param.replace("out", out + "[] out");
					sj.add(param);

//					System.out.println();

					if (k == params.length - 1) {
						System.out.printf("\t%s[] %s(%s);\n", out, methodName, sj);
					} else {
						int rParamsCount = (k + 1) + 1;
						StringJoiner rsj = new StringJoiner(", ");
						for (int l = 0; l < rParamsCount; l++) {
							String p = btm[l];
							if (l == rParamsCount - 1)
								p = top[l];
//							System.out.println(p);
							rsj.add(p);
						}
						System.out.printf("\tdefault %s[] %s(%s){\n\t\treturn %s(%s);\n\t\t}\n", out, methodName, sj,
								methodName, rsj);
					}

				}
				System.out.println();
				System.out.println("\t\t//===================");
				System.out.println();
			}
			System.out.println("}");
			System.out.println();
		}
	}

	public static String cap(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

}
