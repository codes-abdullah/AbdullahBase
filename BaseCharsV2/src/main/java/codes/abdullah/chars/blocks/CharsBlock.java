package codes.abdullah.chars.blocks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.chars.Chars;
import codes.abdullah.digits.Range;
import codes.abdullah.project.lang.Lang;

public class CharsBlock {
	public enum Scope {
		LOCAL, GLOBAL
	}

	private Chars src, prefix, suffix, esc;
	private Range range;

	public CharsBlock() {

	}

	public CharsBlock getBlock(int index) {
		
		return null;
	}

	public int getBlocksCount() {
		return 0;
	}
	
	
	public static void main(String[] args) throws Exception {
		char[] arr = Files.readAllLines(Paths.get("/home/abod/junk/blocks")).stream().collect(Collectors.joining("\n")).toCharArray();
//		arr = "		30-if{}".toCharArray();
		int len = arr.length;
		int from = 0;
		int to = len;
		Range range = new Range(from, to);
		Scope scope = Scope.GLOBAL;
		boolean localScope = scope == Scope.GLOBAL;
		int prefix = '{', suffix = '}', esc = '\\';
		int depth = 2, index = 5;
		range = Lang.codepoint.block.of(arr, len, prefix, suffix, esc, depth, index, range, CodepointSupport.BMP, localScope);
		System.out.println(range);
	}
}
