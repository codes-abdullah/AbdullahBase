package codes.abdullah.array.wrapper.codepoint;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

abstract class AbstractSupplementaryCodepointArray extends AbstractBmpCodepointArray implements CodepointArray {

	private static final long serialVersionUID = 7262954575519992965L;

	protected abstract CodepointArray[] newArray(int length);

	@Override
	public boolean isEmpty() {
		return length() == 0;
	}

	@Override
	public CodepointArray setPairsSupport(CodepointSupport cps) {
		return assign(unsafe(), length(), 0, cps);
	}

	@Override
	public CodepointArray assign(char[] arr, int alen) {
		CodepointSupport cps = getPairsSupport();
		int spcount = arr == null ? 0 : cps.fixedPairsCount(arr, alen);
		return assign(arr, alen, spcount, cps);
	}

	@Override
	public int compareTo(CodepointArray o) {
		AbstractSupplementaryCodepointArray aca = (AbstractSupplementaryCodepointArray) o;
		return Lang.compare.test(unsafe(), length(), aca.unsafe(), o.length());
	}

	@Override
	public int hashCode() {
		return Lang.hashCode.e.of(unsafe(), length());
	}

	@Override
	public String toString() {
		return toString(0);
	}

	@Override
	public String toString(int from) {
		return toString(from, length());
	}

	@Override
	public String toString(int from, int to) {
		int len = length();
		if (len == 0)
			return "[]";
		to = to > len ? len : to;
		return Lang.toString.of(unsafe(), length(), from, to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof CodepointArray) {
			AbstractSupplementaryCodepointArray o = (AbstractSupplementaryCodepointArray) obj;
			return Lang.equal.test(unsafe(), length(), o.unsafe(), o.length());
		}
		return false;
	}

	// =========================
	@Override
	public char[] toCharArray() {
		return toCharArray(0);
	}

	@Override
	public char[] toCharArray(int from) {
		return toCharArray(from, length());
	}

	@Override
	public char[] toCharArray(int from, int to) {
		int len = length();
		if (len == 0)
			return Lang.chararray.newEmptyArray();
		to = to > len ? len : to;
		return Lang.chararray.newDefaultArrayOrCopy(unsafe(), length(), from, to);
	}

	@Override
	public int[] toCodepointArray() {
		return toCodepointArray(0);
	}

	@Override
	public int[] toCodepointArray(int from) {
		return toCodepointArray(from, length());
	}

	@Override
	public int[] toCodepointArray(int from, int to) {
		return toCodepointArray(from, to, getPairsSupport());
	}

	@Override
	public int[] toCodepointArray(int from, int to, CodepointSupport cps) {
		int len = length();
		if (len == 0)
			return new int[0];
		to = to > len ? len : to;
		return Lang.primitive.to.ints(unsafe(), length(), from, to, null, 0, cps);
	}

}
