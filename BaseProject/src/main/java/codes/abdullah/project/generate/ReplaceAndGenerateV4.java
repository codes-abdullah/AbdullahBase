package codes.abdullah.project.generate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ReplaceAndGenerateV4 {
	public static void main(String[] args) throws IOException {

		String s = Files.readAllLines(Paths.get("").toAbsolutePath().resolve("src/main/java/codes/abdullah/project/generate/file"))
				.stream().collect(Collectors.joining("\n"));
		
		String[] types = "short,char,int,long,float,double".split("[,]");
		for (String type : types) {
			String primitive = type;
			String wrapper = Character.toUpperCase(primitive.charAt(0)) + primitive.substring(1);
			String s2 = s.replaceAll("YYY", primitive).replaceAll("ZZZ", wrapper);
			System.out.println(s2);
		}
	}
}
