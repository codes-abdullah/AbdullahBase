package codes.abdullah.project.lang.chars.codepoint;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.lang.Lang;

public class X {

	public static void main(String[] args) throws Exception {

		char[] arr = Files.readAllLines(Paths.get("/home/abod/junk/blocks")).stream().collect(Collectors.joining("\n"))
				.toCharArray();
		arr = ("root\n" + "10-class	A{\n" + "	20-fn{\n" + "		30-if{}\n" + "		31-if{\n"
				+ "			40-do{}\n" + "		}\n" + "		32-if{\n" + "			41-do{}\n" + "		}\n"
				+ "	}\n" + "}").toCharArray();
		CodepointSupport cps = CodepointSupport.DEBUG;
		int len = arr.length;
		int targetIndex = 68;
		int targetColumn = Lang.codepoint.column.from(arr, len, targetIndex, 8, cps);
		int columns = 10;
		int rows = 8;
//		arr = "----------------32-if{".toCharArray();
//		arr = "0123456789ABCDEFGHIJKLMNOPQRSTUV".toCharArray();
//		len = arr.length;
		for (int i = 0; targetIndex < 78; i++) {
			
			
//			char[] arr2 = Lang.chararray.ellipse.middle(Lang.copy.of.this_(arr, len), len, columns, i);
//			int len2 = Lang.chararray.ellipse.lengthOf.middle(arr, len, columns, i);
			System.out.println("===============");
			System.out.println(
					CharArray.join(Lang.chararray.crop.in(arr, len, targetIndex++, columns, rows, CodepointSupport.BMP)));
			
		}
//		System.exit(0);
//		CharArray x = Lang.codepoint.replace.tabs(arr, len, ' ');
//		System.out.println(CharArray.join(Lang.chararray.crop.in(x.getArray(), x.getLength(), targetColumn, columns,
//				rows, CodepointSupport.BMP)));
	}

	public static void loop(char[] arr, int len, int from, int to, int tabSize, CodepointSupport cps) {
		int cp_len = 0, cp_columns = 0, spcount = 0;
		int sequence_global_index = 0;
		int sequence_local_index = 0;
		// =================
		int column_global_index = 0;
		int column_local_index = 0;
		// =================
		int line_index = 0;
		int cp = 0;
		int previousColumn = 0;
		for (; sequence_global_index < to;) {

			if (cps.isLinefeed(cp)) {
				sequence_local_index = 0;
				column_local_index = 0;
				line_index++;
				previousColumn = 0;
			}

			cp = cps.getCodepoint(arr, len, sequence_global_index);
			cp_len = cps.lengthOf(cp);
			spcount += (cp_len - 1);
			cp_columns = Lang.codepoint.count.ofColumns(arr, len, sequence_global_index, sequence_global_index + 1,
					tabSize, previousColumn, cps);

			if (sequence_global_index >= from) {
				// ============================
				if (sequence_global_index == 46)
					System.out.println();

				System.out.printf("==sgi(%d), sli(%d), cgi(%d), cli(%d), spcount(%d), line(%d)\n",
						sequence_global_index, sequence_local_index, column_global_index, column_local_index, spcount,
						line_index);
				System.out.println(CharArray.join(Lang.chararray.mark.underneath(arr, len, sequence_global_index)));
				System.out.println("-----------------");
				// ============================
			}

			column_global_index += cp_columns;
			column_local_index += cp_columns;
			previousColumn += cp_columns;
			sequence_global_index++;
			sequence_local_index++;
		}
	}

	public static class D {

		int sequence_global_index, sequence_local_index, column_global_index, column_local_index;
		int tabSize;

		int line_index;
	}

}
