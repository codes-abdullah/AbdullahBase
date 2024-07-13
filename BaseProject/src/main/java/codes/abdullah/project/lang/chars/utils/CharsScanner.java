package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public class CharsScanner {

	public CharArray scan(char[] arr, int len, int from, int to, int tabSize, CodepointSupport cps) {
		int cp_len = 0, cp_columns = 0, spcount = 0;
		int globalIndex = 0;
		int localIndex = 0;
		// =================
		int globalColumn = 0;
		int localColumn = 0;
		// =================
		int lineIndex = 0;
		int cp = 0;
		int previousColumn = 0;
		CharArray result = CharArray.of(arr, len);
		for (; globalIndex < to;) {

			if (cps.isLinefeed(cp)) {
				localIndex = 0;
				localColumn = 0;
				lineIndex++;
				previousColumn = 0;
			}

			cp = cps.getCodepoint(arr, len, globalIndex);
			cp_len = cps.lengthOf(cp);
			spcount += (cp_len - 1);
			cp_columns = Lang.codepoint.count.ofColumns(arr, len, globalIndex, globalIndex + 1, tabSize, previousColumn,
					cps);

			if (globalIndex >= from) {
				// ============================
//				if (globalIndex == 46)
//					System.out.println();
//
//				System.out.printf("==sgi(%d), sli(%d), cgi(%d), cli(%d), spcount(%d), line(%d)\n", globalIndex,
//						localIndex, globalColumn, localColumn, spcount, lineIndex);
//				System.out.println(CharArray.join(Lang.chararray.mark.underneath(arr, len, globalIndex)));
//
//				System.out.println("-----------------");
				// ============================
//				result = csv.apply(arr, globalIndex, localIndex, globalColumn, localColumn, lineIndex, spcount,
//						cps);
				if (result != null)
					return result;
			}

			globalColumn += cp_columns;
			localColumn += cp_columns;
			previousColumn += cp_columns;
			globalIndex++;
			localIndex++;
		}
		return result;
	}
}
