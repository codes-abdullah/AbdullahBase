package codes.abdullah.project.generate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateXArray {

	public static void main(String[] args) throws IOException {
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
				Path outfile = Paths.get(x.toString().replaceAll("YYY", primitive).replaceAll("ZZZ", wrapper)+".java");
				System.out.println(outfile);
				Files.createDirectories(outfile.getParent());
				Files.write(outfile, s.getBytes());
				
			}
//			Files.createDirectories(Paths.get(outputdir));
//			System.out.println(outputdir);
		}
	}

}
