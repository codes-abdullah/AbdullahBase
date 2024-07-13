package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.chars.XCharArray;
import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

public class LChararray {

	private static final LChararray chararray = new LChararray();
	public final LIndex index = new LIndex();
	public final LLastIndex lastIndex = new LLastIndex();
	public final LRepeat repeat = new LRepeat();
	public final LRemove remove = new LRemove();
	public final LIndexes indexes = new LIndexes();
	public final LSplit split = new LSplit();
	public final LCrop crop = new LCrop();
	public final LMark mark = new LMark();
	public final LAbbreviate abbreviate = new LAbbreviate();
	public final LEllipse ellipse = new LEllipse();
	public final LCount count = new LCount();
	public final LSkip skip = new LSkip();
	public final LTrim trim = new LTrim();
	public final LReplace replace = new LReplace();
	public final LStarts starts = new LStarts();
	public final LEnds ends = new LEnds();
	public final LRange range = new LRange();
	public final LSub sub = new LSub();
	public final LReverse reverse = new LReverse();
	public final LSort sort = new LSort();
	public final LSwap swap = new LSwap();
	public final LShuffle shuffle = new LShuffle();
	final int[] CHARS_WHITESPACES_CODEPOINTS = Lang.constant.WHITESPACES.getArray();
	final int[] CHARS_LINEFEEDS_CODEPOINTS = Lang.constant.LINEFEEDS.getArray();

	LChararray() {

	}

	public static LChararray getInstance() {
		return chararray;
	}

	public int computeHash(char[] arr, int len) {
		int h = 0;
		for (int i = 0; i < len; i++) {
			h = 31 * h + arr[i];
		}
		return h;
	}

	/**
	 * {@link Character#offsetByCodePointsImpl}
	 * 
	 * @see StringBuilder#offsetByCodePoints(int, int)
	 */
	public int offsetByCodePoints(char[] a, int start, int count, int index, int codePointOffset,
			CodepointSupport sps) {
		int x = index;
		if (codePointOffset >= 0) {
			int limit = start + count;
			int i;
			for (i = 0; x < limit && i < codePointOffset; i++, x++) {
				if (x < limit && sps.isPair(a, a.length, x)) {
					x++;
				}
			}
			if (i < codePointOffset) {
				throw new IndexOutOfBoundsException(String.format("i(%d) < codePointOffset(%d)", i, codePointOffset));
			}
		} else {
			int i;
			for (i = codePointOffset; x > start && i < 0; i++, x--) {
				if (x > start && sps.isPairBackwardly(a, a.length, x)) {
					x--;
				}
			}
			if (i < 0) {
				throw new IndexOutOfBoundsException(String.format("i(%d) < 0", i));
			}
		}
		return x;
	}

	public char[] newDefaultArray() {
		return newArray(Lang.constant.ARRAY_DEFAULT_CAPACITY);
	}

	public char[] newDefaultArrayOrCopy(char[] arr, int alen) {
		return newDefaultArrayOrCopy(arr, alen, 0, alen);
	}

	public char[] newDefaultArrayOrCopy(char[] arr, int alen, int from, int to) {
		if (arr == null || arr.length == 0) {
			return newDefaultArray();
		}
		return alen == 0 ? Lang.copy.of.this_(arr, arr.length, from, to)
				: Lang.copy.to.that(arr, alen, new char[alen], alen, from, to, 0);
	}

	public XCharArray newDefaultXCharArrayOrCopy(XCharArray xarr) {
		return newDefaultXCharArrayOrCopy(xarr, 0, xarr.length());
	}

	public XCharArray newDefaultXCharArrayOrCopy(XCharArray xarr, int from, int to) {
		if (xarr == null || xarr.isEmpty()) {
			char[] arr = newDefaultArray();
			XCharArray out = XCharArray.of(arr, arr.length);
			return xarr != null && xarr.isImmutable() ? out.toImmutable() : out;
		}
		return xarr.newClone();
	}

	public char[] newEmptyArray() {
		return newArray(0);
	}

	public char[] newArray(int alen) {
		return new char[alen];
	}

	public char[] newArray(CharSequence cs, int alen) {
		Check.length(alen, cs.length());
		char[] arr = newArray(alen);
		char[] in = cs.toString().toCharArray();
		return Lang.copy.to.that(in, in.length, arr, alen);
	}

}
