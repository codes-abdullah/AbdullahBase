package codes.abdullah.project.generate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class GenerateArrayed {

	public static void convert(String p) throws IOException {
		String dir = "/home/abod/.local/bin/eclipse/jse-2022-03/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/array/";
		// ==========================
		String cap = Character.toUpperCase(p.charAt(0)) + p.substring(1);
		// ==========================
		String srcClassInterfaceName = "IntArray";
		String srcClassAbstractName = "AbstractIntArray";
		String srcClassMutableName = "MutableIntArray";
		String srcClassImmutableName = "ImmutableIntArray";

		String srcClassInterfaceFile = dir + "/" + srcClassInterfaceName + ".java";
		String srcClassAbstractFile = dir + "/" + srcClassAbstractName + ".java";
		String srcClassMutableFile = dir + "/" + srcClassMutableName + ".java";
		String srcClassImmutableFile = dir + "/" + srcClassImmutableName + ".java";
		// ==========================
		String outClassInterfaceName = cap + "Array";
		String outClassAbstractName = "Abstract" + cap + "Array";
		String outClassMutableName = "Mutable" + cap + "Array";
		String outClassImmutableName = "Immutable" + cap + "Array";

		String outClassInterfaceFile = dir + "/" + outClassInterfaceName + ".java";
		String outClassAbstractFile = dir + "/" + outClassAbstractName + ".java";
		String outClassMutableFile = dir + "/" + outClassMutableName + ".java";
		String outClassImmutableFile = dir + "/" + outClassImmutableName + ".java";
		// ==========================
		String extra = "IntArray";
		String extraReplace = "CharArray";
		// ==========================

		String s = Files.readAllLines(Paths.get(srcClassInterfaceFile)).stream().collect(Collectors.joining("\n"));
		s = s.replaceAll("int\\[\\]", p + "[]");
		s = s.replaceAll("new int", "new " + p);
		s = s.replaceAll(srcClassInterfaceName, outClassInterfaceName);
		s = s.replaceAll(extra, extraReplace);

		int i = -1;
		while ((i = s.indexOf("L.fill.in(", i + 1)) != -1) {
			i = s.indexOf('0', i);
			if (i >= 0) {
				s = new StringBuilder(s).deleteCharAt(i).insert(i, "(" + p + ")0").toString();
			}
		}

//		Files.write(Paths.get(outClassInterfaceFile), s.getBytes());
		// ==========================

		s = Files.readAllLines(Paths.get(srcClassAbstractFile)).stream().collect(Collectors.joining("\n"));
		s = s.replaceAll("int\\[\\]", p + "[]");
		s = s.replaceAll("new int", "new " + p);
		s = s.replaceAll(srcClassAbstractName, outClassAbstractName);
		s = s.replaceAll(extra, extraReplace);

		i = -1;
		while ((i = s.indexOf("L.fill.in(", i + 1)) != -1) {
			i = s.indexOf('0', i);
			if (i >= 0) {
				s = new StringBuilder(s).deleteCharAt(i).insert(i, "(" + p + ")0").toString();
			}
		}

//		Files.write(Paths.get(outClassAbstractFile), s.getBytes());
		System.out.println(new String(s.getBytes()));
		// ==========================

		s = Files.readAllLines(Paths.get(srcClassMutableFile)).stream().collect(Collectors.joining("\n"));
		s = s.replaceAll("int\\[\\]", p + "[]");
		s = s.replaceAll("new int", "new " + p);
		s = s.replaceAll(srcClassAbstractName, outClassAbstractName);
		s = s.replaceAll(srcClassMutableName, outClassMutableName);
		s = s.replaceAll(srcClassImmutableName, outClassImmutableName);
		s = s.replaceAll(extra, extraReplace);

//		Files.write(Paths.get(outClassMutableFile), s.getBytes());
		System.out.println(new String(s.getBytes()));
		s = Files.readAllLines(Paths.get(srcClassImmutableFile)).stream().collect(Collectors.joining("\n"));
		s = s.replaceAll("int\\[\\]", p + "[]");
		s = s.replaceAll("new int", "new " + p);
		s = s.replaceAll(srcClassAbstractName, outClassAbstractName);
		s = s.replaceAll(srcClassMutableName, outClassMutableName);
		s = s.replaceAll(srcClassImmutableName, outClassImmutableName);
		s = s.replaceAll(extra, extraReplace);

//		Files.write(Paths.get(outClassImmutableFile), s.getBytes());
		
		System.out.println(new String(s.getBytes()));

	}

	public static void main(String[] args) throws Exception {
		convert("char");

	}

}
