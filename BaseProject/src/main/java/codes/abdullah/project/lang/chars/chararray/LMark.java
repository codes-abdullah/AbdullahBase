package codes.abdullah.project.lang.chars.chararray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.Check;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LMark {

	private static final char[] DEFAULT_PREFIX_MARKER = Lang.constant.DEFAULT_INLINE_PREFIX_MARKER_CHARARRAY.getArray();
	private static final char[] DEFAULT_SUFFIX_MARKER = Lang.constant.DEFAULT_INLINE_SUFFIX_MARKER_CHARARRAY.getArray();
	public final LMarkLength lengthOf = new LMarkLength();

	LMark() {

	}

	// ================
	// ================
	// ================ mark inline by range
	// ================
	// ================

	public char[] in(char[] arr, int len, int from, int to) {
		return in(arr, len, from, to, DEFAULT_PREFIX_MARKER, DEFAULT_PREFIX_MARKER.length, DEFAULT_SUFFIX_MARKER,
				DEFAULT_SUFFIX_MARKER.length);
	}

	public char[] in(char[] arr, int len, int from, int to, char[] mark, int markLen) {
		return in(arr, len, from, to, mark, markLen, mark, markLen);
	}

	public char[] in(char[] arr, int len, int from, int to, char[] prefix, int prefixLen, char[] suffix,
			int suffixLen) {
		return in(arr, len, from, to, prefix, prefixLen, suffix, suffixLen, CodepointSupport.BMP);
	}

	public char[] in(char[] arr, int len, int from, int to, char[] prefix, int prefixLen, char[] suffix, int suffixLen,
			CodepointSupport cps) {
		final int addition = prefix.length + suffix.length;
		if (addition == 0)
			return arr;
		final int newlen = lengthOf.in(arr, len, from, to, prefix, prefixLen, suffix, suffixLen, cps);
		// -------------------
		// if no displacement, no need to gap
		if (suffixLen > 0) {
			if (newlen - to >= 0 && to < len) {
				arr = Lang.expand.at(arr, len, to, suffix.length);
			}
			arr = Lang.copy.to.that(suffix, suffix.length, arr, len, 0, suffix.length, to);
			len += suffix.length;
		}
		if (prefixLen > 0) {
			arr = Lang.expand.at(arr, len, from, prefix.length);
			arr = Lang.copy.to.that(prefix, prefix.length, arr, len, 0, prefix.length, from);
			len += prefix.length;
		}
		return arr;
	}

	// ================
	// ================
	// ================ mark inline by indexes
	// ================
	// ================

	public char[] in(char[] arr, int len, int[] indexes) {
		return in(arr, len, indexes, DEFAULT_PREFIX_MARKER, DEFAULT_PREFIX_MARKER.length, DEFAULT_SUFFIX_MARKER,
				DEFAULT_SUFFIX_MARKER.length);
	}

	public char[] in(char[] arr, int len, int[] indexes, char[] mark, int markLen) {
		return in(arr, len, indexes, mark, markLen, mark, markLen);
	}

	public char[] in(char[] arr, int len, int[] indexes, char[] prefix, int prefixLen, char[] suffix, int suffixLen) {
		return in(arr, len, indexes, prefix, prefixLen, suffix, suffixLen, CodepointSupport.BMP);
	}

	public char[] in(char[] arr, int len, int[] indexes, char[] prefix, int prefixLen, char[] suffix, int suffixLen,
			CodepointSupport cps) {
		final int addition = prefix.length + suffix.length;
		if (addition == 0)
			return arr;
		final int newlen = lengthOf.in(arr, len, indexes, prefix, prefixLen, suffix, suffixLen, cps);
		int from, to;
		for (int i = indexes.length - 1; i >= 0; i--) {
			Check.unsortedIndexes(indexes, i);
			// -------------------
			from = indexes[i];
			if (i + 1 >= indexes.length) {
				to = from + 1;
				// TODO remove reindexing
				to += cps.extendablePairsCount(arr, len, from, to);
			} else {
				to = indexes[i + 1];
			}
			// -------------------
			// if no displacement, no need to gap
			if (suffixLen > 0) {
				if (newlen - to >= 0 && to < len) {
					Lang.expand.at(arr, len, to, suffix.length);
				}
				Lang.copy.to.that(suffix, suffix.length, arr, len, 0, suffix.length, to);
				len += suffix.length;
			}
			if (prefixLen > 0) {
				Lang.expand.at(arr, len, from, prefix.length);
				Lang.copy.to.that(prefix, prefix.length, arr, len, 0, prefix.length, from);
				len += prefix.length;
			}
		}
		return arr;
	}

	// ================
	// ================
	// ================ mark underneath by range
	// ================
	// ================

	public CharArray[] underneath(final char[] arr, final int len, int index) {
		return underneath(arr, len, index, Lang.constant.DEFAULT_UNDERNEATH_MARKER_CHAR);
	}

	public CharArray[] underneath(final char[] arr, final int len, int index, char marker) {
		return underneath(arr, len, index, marker, ' ');
	}

	public CharArray[] underneath(final char[] arr, final int len, int index, char marker, char padChar) {
		return underneath(arr, len, index, index + 1, marker, padChar, padChar);
	}

	public CharArray[] underneath(final char[] arr, final int len, int index, char marker, char leftPadChar,
			char middlePadChar) {
		return underneath(arr, len, index, index + 1, marker, leftPadChar, middlePadChar);
	}

	public CharArray[] underneath(final char[] arr, final int len, int index, char marker, char leftPadChar,
			char middlePadChar, CodepointSupport cps) {
		return underneath(arr, len, index, index + 1, marker, leftPadChar, middlePadChar, cps);
	}

	public CharArray[] underneath(final char[] arr, final int len, int from, int to) {
		return underneath(arr, len, from, to, Lang.constant.DEFAULT_UNDERNEATH_MARKER_CHAR);
	}

	public CharArray[] underneath(final char[] arr, final int len, int from, int to, char marker) {
		return underneath(arr, len, from, to, marker, ' ');
	}

	public CharArray[] underneath(final char[] arr, final int len, int from, int to, char marker, char padChar) {
		return underneath(arr, len, from, to, marker, padChar, padChar, CodepointSupport.BMP);
	}

	public CharArray[] underneath(final char[] arr, final int len, int from, int to, char marker, char leftPadChar,
			char middlePadChar) {
		return underneath(arr, len, from, to, marker, leftPadChar, middlePadChar, CodepointSupport.BMP);
	}

	public static void main(String[] args) throws IOException{
		String s = Files.readAllLines(Paths.get(
				"/home/abod/.local/bin/eclipse/jse/2022-12/workspace/AbdullahBase/BaseProject/src/test/resources/mark_underneeth_tests/block01.input"))
				.stream().collect(Collectors.joining("\n"));
		char[] arr = s.toCharArray();
		int len = arr.length;
		int from = 18, to = 32;
		char leftPadChar = ' ';
		char middlePadChar = '_';
		CodepointSupport sps = CodepointSupport.BMP;
		CharArray[] lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		System.out.println(CharArray.join(lines));
	}

	public CharArray[] underneath(final char[] arr, final int len, int from, int to, char marker, char leftPadChar,
			char middlePadChar, CodepointSupport cps) {

		// =======================
		// =======================
		// =======================
		// =======================
		// Case#1: one-line:
		// Step[A]: pad(' ')->mark(^)
		// Step[B]: pad('_')->mark(^)
		//
		// Case#2: multilines:
		// Step[C]: pad(' ')->mark(^)
		// Step[D]: pad('_') >>>may be same-line<<<
		// Step[E]: pad('_') >>>may be next-lines<<<
		// Step[F]: pad('_')->mark(^)
		// =======================
		// =======================
		// =======================
		// =======================
		CharArray[] lines = Lang.codepoint.split.linefeeds(arr, len, 0, len, 0, 0, CharsMatcher.MUST_EQUALS, cps);
		Check.range(from, to, len);

		int previousOccupations = 0;
		int lineLen = 0, lineLenOriginal = 0;
		// =============
		// * All lengths of previous lines (excluding current in loop)
		// * This can be used to convert multiline global-index into current-line index
		// e.g: codes|abdullah, where | is linefeed, and index = 6
		// so index = 6 - (previous-line-length + 1), while the +1 represents the
		// linefeed that been removed while splitting lines
		// =============
		int all_len = 0;
		boolean sameLine = false;

		// ===========
		// codes.abdullah
		// ####^
		// ===========
		boolean one_mark = to - from == 1;
		int i = 0;
		int start = -1;
		int end = -1;
		int index = from;
		char padChar = leftPadChar;
		boolean _middel_padding_ = false;
		for (; i < lines.length; i++) {
			index -= lineLenOriginal;			
			CharArray line = lines[i];
			char[] lineArr = line.getArray();
			lineLen = line.length();
			//TODO: all_len incorrect calculation after padding middle
			//check with test mark_underneeth_tests/block01-expected/18-34.expected
			all_len += lineLenOriginal;
//			lineLenOriginal = (i == lines.length - 1) ? lineLen+1 : lineLen + 1;
			lineLenOriginal = lineLen + 1;

			// ==============
			// if index outside line length, go to next line, above will take care of
			// conversion
			// ==============
			if (index >= lineLenOriginal) {
				continue;
			}
			if (index < lineLenOriginal) {
				start = end;
				end = index;
				if (!sameLine) {
					start = 0;
					end = index;
				}

				// =============
				// Only on working with (to) and if (index--)
				// results intersect index, fix it
				// =============
//				if (padChar == ' ') {
//				if (padChar == middlePadChar) {
				if (_middel_padding_)
					if (end < lineLen && cps.isPairIntersectly(lineArr, lineLen, end)) {
						end--;
					}

			}

			// =============
			// Case#1-Step[A] & Case#2-Step[C]
			// Case#1-Step[B] & Case#2-Step[F]
			// =============
			int occupation = Lang.codepoint.count.ofColumns(lineArr, line.length(), start, end,
					Lang.constant.DEFAULT_TAB_SIZE, previousOccupations, cps);
//				int occupation = end - start;
			previousOccupations += occupation;
			//TODO: improve allocation
			lineArr = Lang.capacity.ensure(lineArr, lineLen, (lineLenOriginal * 2) + occupation, true);
			if (occupation == 0 && lineLen == 0 && lineArr.length == 0) {
				// double linefeed were here, the second has been considered as empty line
				lineArr = new char[2];
				lineLen = 0;
				occupation = 0;
			}

			if (!sameLine)
				lineArr[lineLen++] = '\n';

			// ===============
			// * Only if on same line, exclude previous ^ from pad-count (|=linefeed,
			// #=space)
			// e.g: codes|abdullah
			// #######^___
			// ===============
			if (sameLine)
				occupation--;
			lineArr = Lang.codepoint.repeat.in(lineArr, lineLen, padChar, occupation, lineLen, cps);
//				lineArr = analogRepeat(lineArr, lineLen, lineArr, lineLen, start, end, padChar, lineLen);
			lineLen = lineLen + occupation;
			lineArr[lineLen++] = marker;

			line = line.assign(lineArr, lineLen);

			// ===============
			// * If detected padChar = '_', means we are at the end of Step[B] or Step[F]
			// * if one-mark-only, break
			// ===============
//				if (padChar == ' ' || one_mark)
//				if (padChar == middlePadChar || one_mark)
			if (_middel_padding_ || one_mark)
				break;

			// ==============
			// * Passing this point means we finished with Step[A] or Step[C]
			// ==============
//				padChar = ' ';
			padChar = middlePadChar;
			_middel_padding_ = true;

			// ===============
			// * Now convert (to) from global-index to local-line-index
			// ===============
			index = to - all_len;

			// ============
			// * We are working with (to) it must be exclusive index,
			// e.g: from 3 to 7 = 4 only
			// codes.abdullah
			// ###^___^ (index--)
			// result:
			// codes.abdullah
			// ###^__^
			// But doing this only will cause troubles with surrogate-pairs
			// codes.A1bdullah
			// ###^____^ (index--)
			// result:
			// codes.A1bdullah
			// ###^___^
			// Solution is by using pair-intersect check on above code
			// ============
			index--;
			// ===========
			// * If index (which is (to)) < lineLenOrigianl (which is the current line
			// original length, means (to) is on same line
			// e.g: codes|abdullah
			// ############^___^
			// ===========
			if (index < lineLenOriginal) {
				sameLine = true;

				// ============
				// the main loop will modify the below, reverse the instructions by now
				// ============
				i--;
				index += lineLenOriginal;
				all_len -= lineLenOriginal;
				continue;
			}

			// ==============
			// * Passing this line means the (to) is on different line
			// we need to pad current line to the end of it and pad all lines
			// between current line and the line of (to)
			// ==============

			// ==============
			// * Starting with current line, which maybe not the line-index(0), we need to
			// convert (from) from global-index to line-local-index
			// ==============
			from = from - all_len;

			// ==============
			// * For the current line only, pad from the mark(^) to end of line (we will
			// exclude ^ from occupation count on below)
			// ==============
			start = from;
			end = lineLenOriginal;

			// ==============
			// * Only on current line, because we need to pad it, will say it is on same
			// line
			// ==============
			sameLine = true;

			// ==============
			// See below
			// ==============
			int linefeedCount = 0;

			// ===========
			// Case#2
			// Step[D]: pad('_') >>>may be same-line<<<
			// Step[E]: pad('_') >>>may be next-lines<<<
			// ===========
			do {
				// ===========
				// * previousOccupations is important only for first loop, (| means linefeed, #
				// blank space), on
				// below example, we need to find previousOccupations only on first line before
				// e char
				// codes|abdullah
				// ###^____^
				// ===========
				//TODO: this is wrong, check with test mark_underneeth_tests/block01-expected/18-34.expected
				//on first mark (^), below counts columns count 1 only
				//TODO: improve allocation
				occupation = Lang.codepoint.count.ofColumns(lineArr, lineLen, start, end,
						Lang.constant.DEFAULT_TAB_SIZE, previousOccupations, cps);
//					occupation = end - start;
				lineArr = Lang.capacity.ensure(lineArr, lineLen, (lineLen * 2) + occupation, true);

				// ===============
				// Double linefeeds when being split, one will be removed and the other will
				// represent empty, we need to reallocate by 2, the first will be linefeed, and
				// second will be pad(_), e.g: (| is linefeed)
				// |
				// _
				// ===============
				if (occupation == 0 && lineLen == 0 && lineArr.length == 0) {
					lineArr = new char[2];
					lineLen = 0;
					occupation = 0;
				}
				if (!sameLine)
					lineArr[lineLen++] = '\n';
				if (sameLine)
					occupation--;
				// =============
				// * linefeedCount: Only on next lines, we need to include the removed linefeed
				// while splitting the lines, remove it from occupation count
				// =============
				occupation += linefeedCount;
				lineArr = Lang.codepoint.repeat.in(lineArr, lineLen, padChar, occupation, lineLen, cps);
//					lineArr = analogRepeat(lineArr, lineLen, lineArr, lineLen, start, end, padChar, lineLen);
				lineLen = lineLen + occupation;
				line = line.assign(lineArr, lineLen);
				line = lines[++i];
				lineArr = line.getArray();
				lineLen = line.length();
				index -= lineLenOriginal;
				lineLenOriginal = (i == lines.length - 1) ? lineLen : lineLen + 1;
				start = 0;
				end = lineLen;
				sameLine = index < lineLenOriginal;
				linefeedCount = 1;
				previousOccupations = 0;
			} while (index >= lineLenOriginal);
			// ==============
			// * After complete padding, reset below, main loop will take care of it
			// ==============
			i--;
			index += lineLenOriginal;
			all_len -= lineLenOriginal;
			sameLine = false;
			previousOccupations = 0;
		}

		return lines;

	}

	// ================
	// ================
	// ================ mark underneath by indexes
	// ================
	// ================

	/**
	 * <code><pre>
	 * 	String src = "java||A1B2C3|codes|A1B2C3|||c++".replaceAll("[|]", "\n");
	 * 	System.out.println(src);
	 * 	System.out.println("=================");
	 * 	char[] arr = src.toCharArray();
	 * 	int len = arr.length;
	 * 	int spcount =6; 		
	 * 	CodepointSupport cps = CodepointSupport.DEBUG;
	 * 	int[] indexes = Digits.ints.range(0, len - spcount);
	 * 	indexes = cps.reindex(arr, len, indexes);
	 * 	Chararray[] lines = Lang.chararray.mark.underneath(arr, len, indexes, Lang.constant.DEFAULT_UNDERNEETH_MARKER_CHAR, cps);
	 * 	String s = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.getLength())).collect(Collectors.joining("\n"));
	 * 	System.out.println(s);
	 * 	System.out.println(src.length() + " -> " + s.length());
	 * </pre></code>
	 */
	public CharArray[] underneath(final char[] arr, final int len, int[] indexes, char marker, char leftPadChar,
			char middlePadChar, CodepointSupport cps) {
		// =======================
		CharArray[] lines = Lang.codepoint.split.byAny(arr, len, Lang.chararray.CHARS_LINEFEEDS_CODEPOINTS, 0, len, 0,
				0, CharsMatcher.MUST_EQUALS, cps);
		// ========================

		// =============
		// * Compare previous-index to current to determine ascending order
		// =============
		int lastKnownIndex = -1;
		int from = 0, to = 0;
		int previousOccupations = 0;
		int j = 0;
		int lineLen = 0, lineLenOriginal = 0;
		// =============
		// * All lengths of previous lines (excluding current in loop)
		// * This can be used to convert multiline global-index into current-line index
		// e.g: codes|abdullah, where | is linefeed, and index = 6
		// so index = 6 - (previous-line-length + 1), while the +1 represents the
		// linefeed that been removed while splitting lines
		// =============
		int all_len = 0;
		boolean sameLine = false;
		char padChar = leftPadChar;
		for (int i = 0; i < lines.length; i++) {
			// ==============
			// ==============
			all_len += i == 0 ? 0 : (lineLenOriginal + 1);
			CharArray line = lines[i];
			char[] lineArr = line.getArray();
			lineLen = line.length();
			lineLenOriginal = lineLen;
			lastKnownIndex = -1;
			sameLine = false;
			from = 0;
			to = 0;
			previousOccupations = 0;
			for (; j < indexes.length; j++) {
				int index = indexes[j];
				if (index <= lastKnownIndex)
					throw new IllegalArgumentException("detect unacsending-order indexes: " + Arrays.toString(indexes));
				lastKnownIndex = index;
				Check.insertIndex(index, len);

				// -----------
				// =============
				// * Convert global-index to current-line index
				// =============
				index -= all_len;

				// =============
				// * After converting, if index > current-line length, go to next line
				// =============
				if (index > lineLenOriginal) {
					break;
				}
				// =============
				// * Ensure we have space that is at less (current-line-length * 2) + 1
				// while the +1 for the linefeed to append
				// * Append linefeed to current line, this is true at this point because
				// definitely we have something to mark
				// =============
				if (!sameLine) {
					lineArr = Lang.capacity.ensure(lineArr, lineLen, (lineLen * 2) + 1, true);
					lineArr[lineLen++] = '\n';
				}

				// =============
				// * On new-line, from will be 0, but on same-line, from = to
				// * Below to specify the range of occupation count
				// =============
				// -----------
				from = to;
				to = index;
				// -----------
				// TODO implement same as the top method
				// TODO implement same as the top method
				// TODO implement same as the top method
				// TODO implement same as the top method
				// TODO implement same as the top method
				// TODO implement same as the top method
				int occupation = Lang.codepoint.count.ofColumns(lineArr, lineLenOriginal, from, to,
						Lang.constant.DEFAULT_TAB_SIZE, previousOccupations, cps);

				// ===============
				// * On any new-line, all-occupation makes no sense, because from will be 0, and
				// CodepointSupport.countOccupation will discard it, be on same-line, we need to
				// know what was the previous-occupation before current from
				// ===============
				previousOccupations += occupation;

				int pad = occupation;

				// ===============
				// only if on same line, remove previous ^ from pad count
				// ===============
				if (sameLine)
					pad--;
				// -----------
				lineArr = Lang.capacity.ensure(lineArr, lineLen, lineLen + pad + 1);
				lineArr = Lang.codepoint.repeat.in(lineArr, lineLen, padChar, pad, lineLen, cps);
				lineLen = lineLen + pad;
				lineArr[lineLen++] = marker;
				sameLine = true;
				// -----------
			}
			line = line.assign(lineArr, lineLen);
		}

		return lines;
	}

	/**
	 * I don't remember why I've created this, but the main job of it is to inject a
	 * tab below tab if found
	 */
	@Deprecated
	private char[] analogRepeat(char[] arr, int len, char[] analong, int analogLen, int analogFrom, int analogTo,
			char target, int insertAt) {
		// ------------------
		if (new String(arr, 0, len).contentEquals(" 	20-fn{")) {
			System.out.println("got: " + new String(arr, 0, len));
		}
		Lang.expand.at(arr, len, insertAt, analogTo - analogFrom);
		for (; analogFrom < analogTo; analogFrom++) {
			if (analong[analogFrom] == Lang.constant.DEFAULT_TAB_CHAR) {
				arr[insertAt++] = Lang.constant.DEFAULT_TAB_CHAR;
				continue;
			}
			arr[insertAt++] = target;
		}
		return arr;
	}

	// ================
	// ================
	// ================ mark length-of
	// ================
	// ================

	public static class LMarkLength {
		private LMarkLength() {

		}

		public int in(char[] arr, int len, int[] indexes, char[] prefix, int prefixLen, char[] suffix, int suffixLen,
				CodepointSupport cps) {
			final int addition = prefixLen + suffixLen;
			return len + (indexes.length * addition);
		}

		public int in(char[] arr, int len, int from, int to, char[] prefix, int prefixLen, char[] suffix, int suffixLen,
				CodepointSupport cps) {
			final int addition = prefixLen + suffixLen;
			return len + addition;
		}
	}

}
