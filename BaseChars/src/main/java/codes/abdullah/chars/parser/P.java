package codes.abdullah.chars.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import codes.abdullah.chars.Chars;
import codes.abdullah.project.Project;

//parser
public class P {
	private Chars src;
	private Class<?> cls;

	public P(Class<?> cls) throws IOException {
		src = Chars
				.of(Files.readAllLines(Project.getSourceFile(cls).toPath()).stream().collect(Collectors.joining("\n")))
				.toImmutable();
		this.cls = cls;
		System.out.println(src);
		
		
		
	}

	public void parse() {

	}

	//1{ 2{ 3{ 4{ 5{ 6{  7{} 8{} 9{ 10{ 11{ 12{ 13{ 14{ 15{ 16{} 17{} 18{} } } } } } } } } } } } } }     
	public static void main(String[] args) throws IOException {
//		P p = new P(Chars.class);

//		Chars c = Chars.of("code[and this [[can go$]] go$] go$");
//		int i = c.indexOfByDepth('$', 0, c.length(), true, 2, "[[".toCharArray(), "]]".toCharArray(), 20);
//		System.out.println(i);
		
		//{}
		for (int i = 0; i < 15; i++) {
			System.out.print((i+1)+"{ ");
			if(i == 5) {
				for (int j = 0; j < 2; j++) {
					i++;
					System.out.print(" "+(i+1)+"{}");
				}
				System.out.print(" ");
			}
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.print((i+1+15)+"{} ");
		}
		
		
		for (int i = 0; i < 13; i++) {
			System.out.print("} ");
		}
//		1{ 2{ 3{ 4{ 5{ 6{  7{} 8{} 9{ 10{ 11{ 12{ 13{ 14{ 15{ 16{} 17{} 18{} } } } } } } } } } } } } } 
		
	}

}
