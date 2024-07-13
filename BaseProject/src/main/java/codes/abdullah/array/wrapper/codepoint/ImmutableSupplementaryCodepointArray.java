package codes.abdullah.array.wrapper.codepoint;

import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

class ImmutableSupplementaryCodepointArray extends AbstractSupplementaryCodepointArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private final int alen, spcount;
	private final char[] arr;
	private final CodepointSupport cps;

	ImmutableSupplementaryCodepointArray(char[] arr, int alen, int spcount, CodepointSupport cps) {
		this.arr = Lang.chararray.newDefaultArrayOrCopy(arr, alen);
		this.alen = arr == null || arr.length == 0 ? 0 : Check.length(alen, 0, arr.length);
		// ------------------
		// spcount should not exceed the half of alen, which represent the whole
		// array are pairs, e.g: A1B2, alen = 4, but spcount = 2 which is the max
		// possible in this case
		// ------------------
		this.spcount = Check.length(spcount, 0, alen / 2);
		this.cps = cps == null ? CodepointSupport.BMP : cps;
	}

	@Override
	public int getPairsCount() {
		return spcount;
	}

	@Override
	public char[] safe() {
		return Lang.copy.of.this_(arr, alen);
	}

	@Override
	public char[] unsafe() {
		return arr;
	}

	@Override
	public int length() {
		return alen;
	}

	@Override
	public int lengthActual() {
		return alen;
	}

	@Override
	public CodepointArray toImmutable() {
		return this;
	}

	@Override
	public CodepointArray toMutable() {
		return new MutableBmpCodepointArray(arr, alen);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

	@Override
	public CodepointArray newClone() {
		return new ImmutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	public CodepointArray newInstance() {
		return newInstance(null, 0);
	}
	
	@Override
	public CodepointArray newInstance(char[] arr, int alen) {
		CodepointSupport cps = getPairsSupport();
		int spcount = arr == null ? 0 : cps.fixedPairsCount(arr, alen);
		return newInstance(arr, alen, spcount, cps);
	}

	@Override
	public CodepointArray newInstance(char[] arr, int alen, int spcount, CodepointSupport cps) {
		return new ImmutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	protected CodepointArray[] newArray(int alen) {
		return new ImmutableSupplementaryCodepointArray[alen];
	}

	@Override
	public CodepointArray assign(char[] arr, int alen, int spcount, CodepointSupport cps) {
		if (!cps.isSupported())
			return new ImmutableBmpCodepointArray(arr, alen);
		return new ImmutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	public CodepointSupport getPairsSupport() {
		return cps;
	}

}