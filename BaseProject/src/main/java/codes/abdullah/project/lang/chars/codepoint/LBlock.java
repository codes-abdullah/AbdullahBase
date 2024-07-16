package codes.abdullah.project.lang.chars.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.digits.Range;
import codes.abdullah.project.lang.Lang;

public class LBlock {
	LBlock() {

	}

	public static void main(String[] args) {
		char[] arr = "go{run(ops{xx})car}".toCharArray();
		int len = arr.length;
		int prefix = '{';
		int suffix = '}';
		int esc = '\\';
//		prefix = '(';
//		suffix = ')';
		int depth = 0;
		int index = 0;
		Range r = Range.of(0, len);
		CodepointSupport cps = CodepointSupport.DEBUG;
		boolean localScope = false;

		Range r2 = Lang.codepoint.block.of(arr, len, prefix, suffix, esc, depth, index, r, cps, localScope);
		System.out.println(r2);
	}

	public Range of(char[] arr, int len, int prefix, int suffix, int esc, int depth, int index, Range r,
			CodepointSupport cps, boolean localScope) {
		int from = r.getFrom();
		int to = r.getTo();
//		if (depth == 0) {
//			if (index == 0)
//				return r.assign(from, to);
//			return r.assign(-1, -1);
//		}
		int pLen = cps.lengthOf(prefix), eLen = cps.lengthOf(esc);
		int insideDepth = 0, currentIndex = -1;
		int start = 0;
		int end = 0;
		int l = 0;
		for (; from < to; from += l) {
			l = cps.lengthOf(arr, len, from);

			if (cps.equals(arr, len, from, esc)) {
				// e.g: |\A1a, | is the pointer, -> \|A1a
				// and make l = to A1 length for next increment
				from += eLen;
				l = cps.lengthOf(arr, len, from);
				continue;
			}

			if (cps.equals(arr, len, from, prefix)) {
				if (insideDepth == depth) {
					start = from;
				}
				insideDepth++;
				continue;
			}

			if (cps.equals(arr, len, from, suffix)) {
				insideDepth--;
				if (insideDepth == depth) {
					currentIndex++;
					end = from;

					if (currentIndex == index) {
						return r.assign(start, end);
					}
					if (localScope)
						break;
					continue;
				}
				insideDepth--;
			}
		}
		return r.assign(-1, -1);
	}

	/**
	 * 
	 */
//	public Range of(char[] arr, int len, int prefix, int suffix, int esc, int depth, int index, Range r,
//			CodepointSupport cps, boolean localScope) {
//		int from = r.getFrom();
//		int to = r.getTo();
////		if (depth == 0) {
////			if (index == 0)
////				return r.assign(from, to);
////			return r.assign(-1, -1);
////		}
//		int pLen = cps.lengthOf(prefix), eLen = cps.lengthOf(esc);
//		int insideDepth = 0, currentIndex = -1;
//		int start = 0;
//		int end = 0;
//		int l = 0;
//		for (; from < to; from += l) {
//			l = cps.lengthOf(arr, len, from);
//
////			CharArray[] lines = Lang.chararray.mark.underneath(Lang.copy.of.this_(arr, len), len, from,
////					Lang.constant.DEFAULT_UNDERNEATH_MARKER_CHAR, cps);
////			char[] out = CharArray.join(lines).toCharArray();			
////			lines = Lang.chararray.crop.in(out, out.length, from, 25, 5, cps);
////			out = CharArray.join(lines).toCharArray();
////			System.out.println("==============: "+from);
////			System.out.println(new String(out));
////			System.out.println("##############");
//			if (cps.equals(arr, len, from, esc)) {
//				// e.g: |\A1a, | is the pointer, -> \|A1a
//				// and make l = to A1 length for next increment
//				from += eLen;
//				l = cps.lengthOf(arr, len, from);
//				continue;
//			}
//
//			if (cps.equals(arr, len, from, prefix)) {
//				insideDepth++;
//				if (insideDepth == depth) {
//					start = from + pLen;
//					from = start - l;
//
//				}
//				continue;
//			}
//
//			if (cps.equals(arr, len, from, suffix)) {
//				if (insideDepth == depth) {
//					currentIndex++;
//					insideDepth--;
//					end = from;
//
//					if (currentIndex == index) {
//						return r.assign(start, end);
//					}
//					if (localScope)
//						break;
//					continue;
//				}
//				insideDepth--;
//			}
//		}
//		return r.assign(-1, -1);
//	}

}
