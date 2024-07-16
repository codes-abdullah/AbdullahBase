package codes.abdullah.project.generate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateXArray {

	public static void main(String[] args) throws IOException {
//		generateCapacity();
//		generateToBinary();
//		generateBinaryMerge();
//		generateCompare();
//		generateDisplaceSqash();
//		generateCheck();
//		generateDisplaceMove();
//		generateEqual();
//		generateExpand();
		generateFill();
	}
	
	
	private static void generateFill() throws IOException {
		String[] types = "boolean,byte,short,char,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(type) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/fill"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("ZZZ", toWrapperLess(type)).replaceAll("YYY", type);
			sb.append(x).append("\n");

		}
		System.out.println(sb);				
	}
	
	private static void generateExpand() throws IOException {
		String[] types = "boolean,byte,short,char,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
//			sb.append("//===========\n");
//			sb.append("//===========\n");
//			sb.append("//===========" + toWrapper(type) + "s\n");
//			sb.append("//===========\n");
//			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/expand"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("ZZZ", toWrapperLess(type)).replaceAll("YYY", type);
			sb.append(x).append("\n");

		}
		System.out.println(sb);				
	}

	private static void generateEqual() throws IOException {
		String[] types = "boolean,byte,short,char,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
//			sb.append("//===========\n");
//			sb.append("//===========\n");
//			sb.append("//===========" + toWrapper(type) + "s\n");
//			sb.append("//===========\n");
//			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/equal"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("ZZZ", toWrapperLess(type)).replaceAll("YYY", type);
			sb.append(x).append("\n");

		}
		System.out.println(sb);		
	}
	
	private static void generateDisplaceMove() throws IOException {
		String[] types = "boolean,byte,short,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(type) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/displace_move"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("ZZZ", toWrapperLess(type)).replaceAll("YYY", type);
			sb.append(x).append("\n");

		}
		System.out.println(sb);		
	}
	
	private static void generateCheck() throws IOException {
		String[] types = "byte,short,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(type) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/check"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("ZZZ", toWrapperLess(type)).replaceAll("YYY", type);
			sb.append(x).append("\n");

		}
		System.out.println(sb);		
	}
	
	private static void generateDisplaceSqash() throws IOException {
		String[] types = "boolean,byte,short,char,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(type) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/displace_squash"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("ZZZ", toWrapperLess(type)).replaceAll("YYY", type);
			sb.append(x).append("\n");

		}
		System.out.println(sb);
	}

	public static void generateCompare() throws IOException {
		String[] types = "boolean,byte,short,char,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(type) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/compare"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("ZZZ", toWrapperLess(type));
			sb.append(x).append("\n");

		}
		System.out.println(sb);
	}

	private static void generateBinaryMerge() throws IOException {
		String[] types = "byte,short,char,int,long".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String fromType = types[i];
//			sb.delete(0, sb.length());
			String core = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/merge_core"))
					.stream().collect(Collectors.joining("\n"));
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(fromType) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			core = core.replaceAll("ZZZ", toWrapperLess(fromType)).replaceAll("YYY", fromType);
			sb.append(core).append("\n");
			for (int j = 0; j < types.length; j++) {
				String toType = types[j];
				if (i == j)
					continue;
				String s = Files.readAllLines(Paths.get(
						"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/merge_small_and_big"))
						.stream().collect(Collectors.joining("\n"));
				s = s.replaceAll("ZZZ", toWrapperLess(fromType)).replaceAll("YYY", fromType).replaceAll("FFF", toWrapperLess(toType));
				sb.append(s).append("\n");
			}

			String packageName = String.format("codes.abdullah.project.langV2.%ss", fromType);
			String className = "/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/langV2/"
					+ fromType + "s/LBinaryTo.java";

//			System.out.println(sb);
//			String out = String.format("package %s;\npublic class LBinaryTo {\nLBinaryTo(){}\n%s\n}", packageName, sb);

//			Files.write(Paths.get(className), out.toString().getBytes());
//			System.exit(0);
		}
		System.out.println(sb);		
	}

	public static void generateCapacity() throws IOException {
		String[] types = "boolean,byte,short,char,int,long,float,double".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(type) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			String s = Files.readAllLines(Paths.get(
					"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/capacity"))
					.stream().collect(Collectors.joining("\n"));
			String x = s.replaceAll("YYY", type).replaceAll("ZZZ", toWrapper(type));
			sb.append(x).append("\n");

		}
		System.out.println(sb);
	}

	public static void generateToBinary() throws IOException {
		String[] types = "byte,short,char,int,long".split("[,]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			String fromType = types[i];
//			sb.delete(0, sb.length());
			sb.append("//===========\n");
			sb.append("//===========\n");
			sb.append("//===========" + toWrapper(fromType) + "s\n");
			sb.append("//===========\n");
			sb.append("//===========\n");
			for (int j = 0; j < types.length; j++) {
				String toType = types[j];
				if (i == j)
					continue;
				String s = "";
				if (i < j) {
					s = Files.readAllLines(Paths.get(
							"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/small_to_big"))
							.stream().collect(Collectors.joining("\n"));
//					System.out.printf("from(%s) to(%s) - small-to-big\n", fromType, toType);
				} else {
					s = Files.readAllLines(Paths.get(
							"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/generate/big_to_small"))
							.stream().collect(Collectors.joining("\n"));
//					System.out.printf("from(%s) to(%s) - big-to-small\n", fromType, toType);
				}
				String XINPUT = String.format("X%sArray", toWrapperLess(fromType));
				String XOUTPUT = String.format("X%sArray", toWrapperLess(toType));
				String x = s.replaceAll("XINPUT", XINPUT).replaceAll("XOUTPUT", XOUTPUT)
						.replaceAll("INPUT_WRAPPER", toWrapper(fromType))
						.replaceAll("OUTPUT_WRAPPER", toWrapper(toType)).replaceAll("xoutput", toType)
						.replaceAll("xinput", fromType);
				sb.append(x).append("\n");
			}

			String packageName = String.format("codes.abdullah.project.langV2.%ss", fromType);
			String className = "/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/langV2/"
					+ fromType + "s/LBinaryTo.java";

//			System.out.println(sb);
//			String out = String.format("package %s;\npublic class LBinaryTo {\nLBinaryTo(){}\n%s\n}", packageName, sb);

//			Files.write(Paths.get(className), out.toString().getBytes());
//			System.exit(0);
		}
		System.out.println(sb);
	}

	public static void generateXArrayText() throws IOException {
		String[] types = "boolean,byte,short,char,int,long,float,double".split("[,]");
		for (String type : types) {
			String primitive = type;
			String wrapper = Character.toUpperCase(primitive.charAt(0)) + primitive.substring(1);

			String inputdir = "/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/array/YYYs";
//			inputdir = "/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/main/java/codes/abdullah/project/langV2/YYYs";
			String outputdir = inputdir.replaceAll("YYY", primitive);
			Path p = Paths.get(inputdir);
			List<Path> ll = Files.list(p).collect(Collectors.toList());
			for (Path x : ll) {
				String s = Files.readAllLines(x).stream().collect(Collectors.joining("\n")).replaceAll("YYY", primitive)
						.replaceAll("ZZZ", wrapper);
				Path outfile = Paths
						.get(x.toString().replaceAll("YYY", primitive).replaceAll("ZZZ", wrapper) + ".java");
				System.out.println(outfile);
				Files.createDirectories(outfile.getParent());
				Files.write(outfile, s.getBytes());

			}
//			Files.createDirectories(Paths.get(outputdir));
//			System.out.println(outputdir);
		}
	}

	public static String toWrapper(String s) {
		if (s.equals("int"))
			return "Integer";
		else if (s.equals("char"))
			return "Character";
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

	public static String toWrapperLess(String s) {
		if (s.equals("int"))
			return "Int";
		else if (s.equals("char"))
			return "Char";
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

}
