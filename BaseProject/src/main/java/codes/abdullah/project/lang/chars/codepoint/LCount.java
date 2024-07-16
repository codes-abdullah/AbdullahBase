package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.LConstants;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LCount {

	LCount() {

	}

	// ============
	// count-of
	// ============

	public int of(char[] arr, int len, int target) {
		return of(arr, len, target, 0);
	}

	public int of(char[] arr, int len, int target, int from) {
		return of(arr, len, target, from, len);
	}

	public int of(char[] arr, int len, int target, int from, int to) {
		return of(arr, len, target, from, to, 0);
	}

	public int of(char[] arr, int len, int target, int from, int to, int flags) {
		return of(arr, len, target, from, to, flags, 0);
	}

	public int of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return of(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return of(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int of(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return CharsLoop.FORWARD_COUNT_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m, cps);
	}

	// ============
	// count-of but-not
	// ============

	public int ofButNot(char[] arr, int len, int target) {
		return ofButNot(arr, len, target, 0);
	}

	public int ofButNot(char[] arr, int len, int target, int from) {
		return ofButNot(arr, len, target, from, len);
	}

	public int ofButNot(char[] arr, int len, int target, int from, int to) {
		return ofButNot(arr, len, target, from, to, 0);
	}

	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags) {
		return ofButNot(arr, len, target, from, to, flags, 0);
	}

	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return ofButNot(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
	}

	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofButNot(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofButNot(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return CharsLoop.FORWARD_COUNT_OF.codePoint(arr, len, from, to, target, flags, fromDisp, m, cps);
	}

	// ============
	// count-of-any
	// ============

	public int ofAny(char[] arr, int len, int[] targets) {
		return ofAny(arr, len, targets, 0);
	}

	public int ofAny(char[] arr, int len, int[] targets, int from) {
		return ofAny(arr, len, targets, from, len);
	}

	public int ofAny(char[] arr, int len, int[] targets, int from, int to) {
		return ofAny(arr, len, targets, from, to, 0);
	}

	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return ofAny(arr, len, targets, from, to, flags, 0);
	}

	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofAny(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return CharsLoop.FORWARD_COUNT_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m,
				cps);
	}

	// ============
	// count-of-any but-not
	// ============

	public int ofAnyButNot(char[] arr, int len, int[] targets) {
		return ofAnyButNot(arr, len, targets, 0);
	}

	public int ofAnyButNot(char[] arr, int len, int[] targets, int from) {
		return ofAnyButNot(arr, len, targets, from, len);
	}

	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to) {
		return ofAnyButNot(arr, len, targets, from, to, 0);
	}

	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags) {
		return ofAnyButNot(arr, len, targets, from, to, flags, 0);
	}

	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp) {
		return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, CharsMatcher.MUST_NOT_EQUALS);
	}

	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m) {
		return ofAnyButNot(arr, len, targets, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofAnyButNot(char[] arr, int len, int[] targets, int from, int to, int flags, int fromDisp,
			CharsMatcher m, CodepointSupport cps) {
		return CharsLoop.FORWARD_COUNT_OF.codePoints(arr, len, from, to, targets, targets.length, flags, fromDisp, m,
				cps);
	}

	// ============
	// count-of linefeed
	// ============

	public int ofLinefeed(char[] arr, int len) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS);
	}

	public int ofLinefeed(char[] arr, int len, int from) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from);
	}

	public int ofLinefeed(char[] arr, int len, int from, int to) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to);
	}

	public int ofLinefeed(char[] arr, int len, int from, int to, int flags) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags);
	}

	public int ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp);
	}

	public int ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	public int ofLinefeed(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_LINEFEEDS_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

	// ============
	// count-of whitespace
	// ============

	public int ofWhitespace(char[] arr, int len) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS);
	}

	public int ofWhitespace(char[] arr, int len, int from) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from);
	}

	public int ofWhitespace(char[] arr, int len, int from, int to) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to);
	}

	public int ofWhitespace(char[] arr, int len, int from, int to, int flags) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags);
	}

	public int ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp);
	}

	public int ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m);
	}

	public int ofWhitespace(char[] arr, int len, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		return ofAny(arr, len, Lang.codepoint.CHARS_WHITESPACES_CODEPOINTS, from, to, flags, fromDisp, m, cps);
	}

	// ============
	// count-of repeat
	// ============

	public int ofRepeat(char[] arr, int len, int target) {
		return ofRepeat(arr, len, target, 0);
	}

	public int ofRepeat(char[] arr, int len, int target, int from) {
		return ofRepeat(arr, len, target, from, len);
	}

	public int ofRepeat(char[] arr, int len, int target, int from, int to) {
		return ofRepeat(arr, len, target, from, to, 0);
	}

	public int ofRepeat(char[] arr, int len, int target, int from, int to, int flags) {
		return ofRepeat(arr, len, target, from, to, flags, 0);
	}

	public int ofRepeat(char[] arr, int len, int target, int from, int to, int flags, int fromDisp) {
		return ofRepeat(arr, len, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS);
	}

	public int ofRepeat(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m) {
		return ofRepeat(arr, len, target, from, to, flags, fromDisp, m, CodepointSupport.BMP);
	}

	public int ofRepeat(char[] arr, int len, int target, int from, int to, int flags, int fromDisp, CharsMatcher m,
			CodepointSupport cps) {
		int index = Lang.codepoint.index.of(arr, len, target, from, to, flags, 0, m, cps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return 0;
		}
		return of(arr, len, target, from, to, flags, 0, m);
	}

	/**
	 * @see #ofColumns(char[], int, int, int, int, int, CodepointSupport, boolean)
	 */
	public int ofColumns(char[] arr, int len) {
		return ofColumns(arr, len, 0);
	}

	/**
	 * @see #ofColumns(char[], int, int, int, int, int, CodepointSupport, boolean)
	 */
	public int ofColumns(char[] arr, int len, int from) {
		return ofColumns(arr, len, from, len);
	}

	/**
	 * @see #ofColumns(char[], int, int, int, int, int, CodepointSupport, boolean)
	 */
	public int ofColumns(char[] arr, int len, int from, int to) {
		return ofColumns(arr, len, from, to, Lang.constant.DEFAULT_TAB_SIZE);
	}

	/**
	 * @see #ofColumns(char[], int, int, int, int, int, CodepointSupport, boolean)
	 */
	public int ofColumns(char[] arr, int len, int from, int to, int tabSize) {
		return ofColumns(arr, len, from, to, tabSize, 0);
	}

	/**
	 * @see #ofColumns(char[], int, int, int, int, int, CodepointSupport, boolean)
	 */
	public int ofColumns(char[] arr, int len, int from, int to, int tabSize, int previousColumns) {
		return ofColumns(arr, len, from, to, tabSize, previousColumns, CodepointSupport.BMP);
	}

	/**
	 * @see #ofColumns(char[], int, int, int, int, int, CodepointSupport, boolean)
	 */
	public int ofColumns(char[] arr, int len, int from, int to, int tabSize, int previousColumns,
			CodepointSupport cps) {
		return ofColumns(arr, len, from, to, tabSize, previousColumns, cps, false);
	}


	/**
	 * Invoker must take care of all checks<br>
	 * <code>from-to</code> range must be in actual-Level <br>
	 * <b>resetOnLinefeeds</b> must be taken in consideration, please see below <br>
	 * <br>
	 * Count seat-occupation (columns) of codepoints based on given range<br>
	 * <br>
	 * 
	 * Ideology: <br>
	 * Chars are displayed on screen differently, like bmp, occupies 1 seat while
	 * displaying it on screen, and surrogate-pairs occupies 2 seats, but tabs has
	 * dynamic occupation based on the location of the line, usually a tab on
	 * beginning of line occupies 4 or 8 seats, depends on implementer.<br>
	 * <br>
	 * Assume tab size = 8, and we have line <b>"c>des.ab>ullah"</b> (> represents a
	 * tab for explanation purpose and below digits to represents occupation seats)
	 * <br>
	 * 
	 * <pre>
	 * Test#1
	 * c	 des.ab	 ullah
	 * 0123456789ABCDEFGHIJKLMNOPQRST
	 * 
	 * Test#2
	 * ab	 ullah
	 * 0123456789ABCDEFGHIJKLMNOPQRST
	 * </pre>
	 * 
	 * So on test#1, first tab occupies 7 seats, and second tab occupies 2 seats,
	 * but on test#2, the same word but, tab occupies 6 seats, and thats because on
	 * test#1, the word starts on seat number# 5, while on test#2 it starts on seat
	 * number# 0<br>
	 * <br>
	 * Now the above is exactly what will be seen by this tool when we specify a
	 * range, it can't tell what is the occupation of a tab in that range without
	 * knowing what was occupied before it<br>
	 * <br>
	 * So, invoker must maintain previous-occupations <b>or</b> keep from = 0 all
	 * times to avoid maintaining previous-occupations
	 * 
	 * @param previousColumns occupation (line-local-level) before given from, this
	 *                        is important only if range starts after index 0,
	 *                        please see above explanation, this must be previous
	 *                        column starting from linefeed, so first char after
	 *                        linefeed must be 0
	 * @param tabSize         usually 4 or 8, please see {@link Lang#constant} and
	 *                        {@link LConstants#DEFAULT_TAB_SIZE}
	 * @param from            from actual-level
	 * @param to              actual-level
	 * @param len             actual-length
	 * @param asMultiLine     if true, will reset column-index after each linefeed,
	 *                        just like ui-apps like <b>Geany</b>, otherwise, will
	 *                        treat the whole array as single-line, by default:
	 *                        <b>false</b>
	 * @return column count
	 * @see LColumn#from(char[], int, int, int, CodepointSupport)
	 * @see LColumn#to(char[], int, int, int, CodepointSupport)
	 */
	public int ofColumns(char[] arr, int len, int from, int to, int tabSize, int previousColumns, CodepointSupport cps,
			boolean asMultiLine) {
		int columns = 0;
		int occupied = 0;
		int cp = 0;
		previousColumns = from == 0 ? 0 : previousColumns;
		for (; from < to; from++, previousColumns += occupied) {
			cp = cps.getCodepoint(arr, len, from);
			if (cps.isLinefeed(cp)) {
				print(arr, len, from, columns, occupied, previousColumns, cps);
				occupied = 0;
				previousColumns = 0;
				columns++;
				if (asMultiLine)
					columns = 0;
				continue;
			}
			if (cps.equals(cp, Lang.constant.DEFAULT_TAB_CHAR)) {
				if (previousColumns == 0 || previousColumns % tabSize == 0) {
					occupied = tabSize;
					print(arr, len, from, columns, occupied, previousColumns, cps);
					columns += occupied;
					continue;
				}

				occupied = Digits.ints.headMissing(previousColumns, tabSize);
				print(arr, len, from, columns, occupied, previousColumns, cps);
				columns += occupied;
				continue;
			}
			occupied = cps.lengthOf(arr, len, from);
			print(arr, len, from, columns, occupied, previousColumns, cps);
			columns += occupied;
			// safe way to check and add 1 if surrogate-pair (to skip low-surrogate)
			from += (occupied - 1);
		}
		return columns;
	}

	// TODO to be removed
	private static void print(char[] arr, int len, int from, int columns, int occupied, int previousColumns,
			CodepointSupport cps) {
//		System.out.println(
//				"---------------- " + from + ": columns(" + columns + "), occupied(" + occupied + "), previous("
//						+ previousColumns + ")" + (cps.equals(arr, len, from, Lang.constant.DEFAULT_TAB_CHAR)));
//		System.out.println(CharArray.join(Lang.chararray.mark.underneath(arr, len, from)));
//		System.out.println("----------------");
	}
}
