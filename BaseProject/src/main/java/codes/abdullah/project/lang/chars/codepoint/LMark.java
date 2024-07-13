package codes.abdullah.project.lang.chars.codepoint;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public class LMark {
	public final LMarkLength lengthOf = new LMarkLength();

	LMark() {

	}

	// ================
	// ================
	// ================ mark range
	// ================
	// ================

	public char[] in(char[] arr, int len, int from, int to) {
		return in(arr, len, from, to, Lang.constant.DEFAULT_INLINE_PREFIX_MARKER_CODEPOINT,
				Lang.constant.DEFAULT_INLINE_SUFFIX_MARKER_CODEPOINT);
	}

	public char[] in(char[] arr, int len, int from, int to, int mark) {
		return in(arr, len, from, to, mark, mark);
	}

	public char[] in(char[] arr, int len, int from, int to, int prefix, int suffix) {
		return in(arr, len, from, to, prefix, suffix, CodepointSupport.BMP);
	}

	/**
	 * <code><pre>
	 * 	final String l = "abcdefghijklmnopqrstwxyz";
	 * 	try (Scanner scn = new Scanner(System.in);) {
	 * 		CodepointSupport cps = CodepointSupport.DEBUG;
	 * 		int prefix = '{';
	 * 		int suffix = '}';
	 * 		System.out.println("enter from and to: e.g: 1,4");
	 * 		while (scn.hasNext()) {
	 * 			String line = scn.nextLine();
	 * 			List<Integer> lindexes = Arrays.stream(line.split("[,]")).map(String::trim).map(Integer::parseInt)
	 * 					.collect(Collectors.toList());
	 * 			int[] indexes = Lang.primitive.to.intArray(lindexes);
	 *			int from = indexes[0];
	 *			int to = indexes[1];
	 * 			char[] arr = l.toCharArray();
	 * 			final int len = arr.length;
	 *			// ================
	 *			int fromDisp = cps.extendablePairsCount(arr, len, 0, from);
	 *			from += fromDisp;
	 *			to += fromDisp;
	 *			to += cps.extendablePairsCount(arr, len, from, to);
	 *			// ================
	 * 			final int newlen = Lang.codepoint.mark.lengthOf.in(arr, len, from, to, prefix, suffix, cps);
	 * 			arr = Lang.capacity.ensure(arr, len, newlen);
	 * 			arr = Lang.codepoint.mark.in(arr, len, from, to, prefix, suffix, cps);
	 * 			//================
	 * 			String s = new String(arr, 0, newlen);
	 * 			System.out.println(s);
	 * 		}
	 * 	}
	 * </pre>
	 * </code>
	 */
	public char[] in(char[] arr, int len, int from, int to, int prefix, int suffix, CodepointSupport cps) {
		final int prefixLen = cps.lengthOf(prefix);
		final int suffixLen = cps.lengthOf(suffix);		
		final int newlen = lengthOf.in(arr, len, from, to, prefixLen, suffixLen, cps);
		if (newlen == len)
			return arr;
		// -------------------
		if (suffixLen > 0) {//cod--es-
			Lang.codepoint.set(arr, len, to, suffix, cps);
			len += suffixLen;
		}
		if (prefixLen > 0) {
			Lang.codepoint.set(arr, len, from, prefix, cps);
			len += prefixLen;
		}

		return arr;
	}

	// ================
	// ================
	// ================ mark indexes
	// ================
	// ================

	public char[] in(char[] arr, int len, int[] indexes) {
		return in(arr, len, indexes, Lang.constant.DEFAULT_INLINE_PREFIX_MARKER_CODEPOINT,
				Lang.constant.DEFAULT_INLINE_SUFFIX_MARKER_CODEPOINT);
	}

	public char[] in(char[] arr, int len, int[] indexes, int mark) {
		return in(arr, len, indexes, mark, mark);
	}

	public char[] in(char[] arr, int len, int[] indexes, int prefix, int suffix) {
		return in(arr, len, indexes, prefix, suffix, CodepointSupport.BMP);
	}

	/**
	 * <code><pre>
	 * 	final String l = "abcdefghijklmnopqrstwxyz";
	 * 	try (Scanner scn = new Scanner(System.in);) {
	 * 		CodepointSupport cps = CodepointSupport.DEBUG;
	 * 		int prefix = '{';
	 * 		int suffix = '}';
	 * 		System.out.println("enter indexes: e.g: 1,4,8");
	 * 		while (scn.hasNext()) {
	 * 			String line = scn.nextLine();
	 * 			List<Integer> lindexes = Arrays.stream(line.split("[,]")).map(String::trim).map(Integer::parseInt)
	 * 					.collect(Collectors.toList());
	 * 			int[] indexes = Lang.primitive.to.intArray(lindexes);
	 * 			char[] arr = l.toCharArray();
	 * 			final int len = arr.length;
	 * 			//================
	 * 			indexes = cps.reindex(arr, len, indexes);
	 * 			//================
	 * 			final int newlen = Lang.codepoint.mark.lengthOf.in(arr, len, indexes, prefix, suffix, cps);
	 * 			arr = Lang.capacity.ensure(arr, len, newlen);
	 * 			arr = Lang.codepoint.mark.in(arr, len, indexes, prefix, suffix, cps);
	 * 			//================
	 * 			String s = new String(arr, 0, newlen);
	 * 			System.out.println(s);
	 * 		}
	 * 	}
	 * </pre>
	 * </code>
	 */
	public char[] in(char[] arr, int len, int[] indexes, int prefix, int suffix, CodepointSupport cps) {
		final int prefixLen = cps.lengthOf(prefix);
		final int suffixLen = cps.lengthOf(suffix);
		final int addition = prefixLen + suffixLen;
		if (addition == 0)
			return arr;
		final int newlen = lengthOf.in(arr, len, indexes, prefix, suffix, cps);
		int from, to;
		for (int i = indexes.length - 1; i >= 0; i--) {
			Check.unsortedIndexes(indexes, i);
			from = indexes[i];
			to = from + 1;
			// -------------------
			from = indexes[i];
			if (i + 1 >= indexes.length) {
				to = from + 1;
				to += cps.extendablePairsCount(arr, len, from, to);
			} else {
				to = indexes[i + 1];
			}
			// -------------------
			if (suffixLen > 0) {
				// if no displacement, no need to gap
				if (newlen - to >= 0 && to < len) {
					Lang.expand.at(arr, len, to, suffixLen);
				}
				Lang.codepoint.set(arr, len, to, suffix, cps);
				len += suffixLen;
			}
			if (prefixLen > 0) {
				Lang.expand.at(arr, len, from, prefixLen);
				Lang.codepoint.set(arr, len, from, prefix, cps);
				len += prefixLen;
			}
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

		public int in(char[] arr, int len, int[] indexes, int prefix, int suffix, CodepointSupport cps) {
			final int addition = cps.lengthOf(prefix) + cps.lengthOf(suffix);
			return len + (indexes.length * addition);
		}

		public int in(char[] arr, int len, int from, int to, int prefix, int suffix, CodepointSupport cps) {
			final int addition = cps.lengthOf(prefix) + cps.lengthOf(suffix);
			return len + addition;
		}

	}

//	[c, o, {d, e}, s, 
//	[c, o, {d, e}, d, e, s, 
//	[c, o, {B, 1}, e, d, s, 
	// pressure
	// preessure
	public static void main(String[] args) throws IOException {
		final String l = "abcdefghijklmnopqrstwxyzA1B2C3D4E5F6G7H8J9";
		try (Scanner scn = new Scanner(System.in);) {
			CodepointSupport cps = CodepointSupport.DEBUG;
			int prefix = '{';
			int suffix = '}';
			System.out.println("enter from and to: e.g: 1,4");
			while (scn.hasNext()) {
				String line = scn.nextLine();
				List<Integer> lindexes = Arrays.stream(line.split("[,]")).map(String::trim).map(Integer::parseInt)
						.collect(Collectors.toList());
				int[] indexes = Lang.primitive.to.ints(lindexes);
				int from = indexes[0];
				int to = indexes[1];
				char[] arr = l.toCharArray();
				final int len = arr.length;
				// ================
				int fromDisp = cps.extendablePairsCount(arr, len, 0, from);
				from += fromDisp;
				to += fromDisp;
				to += cps.extendablePairsCount(arr, len, from, to);
				// ================
				final int newlen = Lang.codepoint.mark.lengthOf.in(arr, len, from, to, prefix, suffix, cps);
				arr = Lang.capacity.ensure(arr, len, newlen);
				arr = Lang.codepoint.mark.in(arr, len, from, to, prefix, suffix, cps);
				// ================
				String s = new String(arr, 0, newlen);
				System.out.println(s);
			}
		}
	}
}
