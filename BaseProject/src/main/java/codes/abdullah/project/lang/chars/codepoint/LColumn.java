package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.LConstants;
import codes.abdullah.project.lang.Lang;

public class LColumn {
	LColumn() {

	}

	// ============
	// from index to column
	// ============

	/**
	 * @see #from(char[], int, int, int, CodepointSupport, boolean)
	 */
	public int from(char[] arr, int len, int index) {
		return from(arr, len, index, Lang.constant.DEFAULT_TAB_SIZE);
	}

	/**
	 * @see #from(char[], int, int, int, CodepointSupport, boolean)
	 */
	public int from(char[] arr, int len, int index, int tabSize) {
		return from(arr, len, index, tabSize, CodepointSupport.BMP);
	}

	/**
	 * @see #from(char[], int, int, int, CodepointSupport, boolean)
	 */
	public int from(char[] arr, int len, int index, int tabSize, CodepointSupport cps) {
		return from(arr, len, index, tabSize, cps, true);
	}

	/**
	 * <b>asMultiLine</b> must be taken in consideration, please see below <br>
	 * Convert codepoint <b>from</b> sequence-index, to column-index<br>
	 * e.g: src: >codes.>abd>ullah (where > is tabs)
	 * 
	 * <pre>
	 *		codes.	abd	ullah
	 *	0123456789ABCDEFGHIJKLMNOPQRS
	 *	--------^----------^
	 * The index 1 is located at column 8, and index 11 is at column 19
	 * </pre>
	 * 
	 * @param arr         src array
	 * @param len         src length
	 * @param index       index to convert to column-based index
	 * @param tabSize     tab-size, see {@link LConstants#DEFAULT_TAB_SIZE}
	 * @param cps         codepoint support, by default {@link CodepointSupport#BMP}
	 * @param asMultiLine if true, will reset column-index after each linefeed, just
	 *                    like ui-apps like <b>Geany</b>, otherwise, will treat the
	 *                    whole array as single-line, by default: <b>true</b>
	 * @return column-index
	 * @see LCount#ofColumns(char[], int, int, int, int, int, CodepointSupport,
	 *      boolean)
	 */
	public int from(char[] arr, int len, int index, int tabSize, CodepointSupport cps, boolean asMultiLine) {
		return Lang.codepoint.count.ofColumns(arr, len, 0, index, tabSize, 0, cps, asMultiLine);
	}

	// ============
	// from column to index
	// ============

	/**
	 * @see #to(char[], int, int, int, int, CodepointSupport, boolean)
	 */
	public int to(char[] arr, int len, int columnIndex, int rowIndex) {
		return to(arr, len, columnIndex, rowIndex, Lang.constant.DEFAULT_TAB_SIZE);
	}

	/**
	 * @see #to(char[], int, int, int, int, CodepointSupport, boolean)
	 */
	public int to(char[] arr, int len, int columnIndex, int rowIndex, int tabSize) {
		return to(arr, len, columnIndex, rowIndex, tabSize, CodepointSupport.BMP);
	}

	/**
	 * @see #to(char[], int, int, int, int, CodepointSupport, boolean)
	 */
	public int to(char[] arr, int len, int columnIndex, int rowIndex, int tabSize, CodepointSupport cps) {
		return to(arr, len, columnIndex, rowIndex, tabSize, cps, true);
	}

	/**
	 * Convert codepoint from column-index <b>to</b> sequence-index<br>
	 * e.g: src: >codes.>abd>ullah (where > is tabs)
	 * 
	 * <pre>
	 *		codes.	abd	ullah
	 *	0123456789ABCDEFGHIJKLMNOPQRS
	 *	--------^----------^
	 * The column 8 is located at index 1, and column 19 is at index 11
	 * </pre>
	 * 
	 * @param arr         src array
	 * @param len         src length
	 * @param columnIndex column-based index to convert to index-based index
	 * @param rowIndex    the row/line index in which the column exists, if
	 *                    <b>asMultiLine</b> = false, rowIndex will be considered as
	 *                    0 for simulating single-line
	 * @param tabSize     tab-size, see {@link LConstants#DEFAULT_TAB_SIZE}
	 * @param cps         codepoint support, by default {@link CodepointSupport#BMP}
	 * @param asMultiLine if true, will reset column-index after each linefeed, just
	 *                    like ui-apps like <b>Geany</b>, otherwise, will treat the
	 *                    whole array as single-line, by default: <b>true</b>
	 * @return sequence-index
	 * @see LCount#ofColumns(char[], int, int, int, int, int, CodepointSupport,
	 *      boolean)
	 * @see LColumn#from(char[], int, int, int, CodepointSupport, boolean)
	 */
	public int to(char[] arr, int len, int columnIndex, int rowIndex, int tabSize, CodepointSupport cps,
			boolean asMultiLine) {
		int currentColumnIndex = 0, occupied = 0, previousColumns = 0, currentRowIndex = 0;
		rowIndex = asMultiLine ? rowIndex : 0;
		for (int i = 0; i < len; i++, previousColumns += occupied) {
			if (cps.isLinefeed(cps.getCodepoint(arr, len, i))) {
				occupied = 0;
				previousColumns = 0;
				if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
					return i;
				currentColumnIndex++;
				if (asMultiLine)
					currentColumnIndex = 0;
				currentRowIndex++;
				continue;
			}

			if (cps.equals(arr, len, i, Lang.constant.DEFAULT_TAB_CHAR)) {
				if (previousColumns == 0 || previousColumns % tabSize == 0) {
					if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
						return i;
					occupied = tabSize;
					currentColumnIndex += occupied;
					continue;
				}
				if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
					return i;
				occupied = Digits.ints.headMissing(previousColumns, tabSize);
				currentColumnIndex += occupied;
				continue;
			}
			if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
				return i;
			occupied = cps.lengthOf(arr, len, i);
			currentColumnIndex += occupied;
			// safe way to check and add 1 if surrogate-pair (to skip low-surrogate)
			i += (occupied - 1);
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	public int toV2(char[] arr, int len, int columnIndex, int rowIndex, int tabSize, CodepointSupport cps,
			boolean asMultiLine) {
		int currentColumnIndex = 0, occupied = 0, previousColumns = 0, currentRowIndex = 0;
		rowIndex = asMultiLine ? rowIndex : 0;
		for (int i = 0; i < len; i++, previousColumns += occupied) {
			if (cps.isLinefeed(cps.getCodepoint(arr, len, i))) {
				occupied = 0;
				previousColumns = 0;
				if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
					return i;
				currentColumnIndex++;
				if (asMultiLine)
					currentColumnIndex = 0;
				currentRowIndex++;
				continue;
			}

			if (cps.equals(arr, len, i, Lang.constant.DEFAULT_TAB_CHAR)) {
				if (previousColumns == 0 || previousColumns % tabSize == 0) {
					if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
						return i;
					occupied = tabSize;
					currentColumnIndex += occupied;
					continue;
				}
				if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
					return i;
				occupied = Digits.ints.headMissing(previousColumns, tabSize);
				currentColumnIndex += occupied;
				continue;
			}
			if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex)
				return i;
			occupied = cps.lengthOf(arr, len, i);
			currentColumnIndex += occupied;
			// safe way to check and add 1 if surrogate-pair (to skip low-surrogate)
			i += (occupied - 1);
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

}
