package codes.abdullah.array.wrapper.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Check;
import codes.abdullah.project.lang.Lang;

class MutableSupplementaryCodepointArray extends AbstractSupplementaryCodepointArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private int alen, spcount;
	private char[] arr;
	private CodepointSupport cps;

	MutableSupplementaryCodepointArray(char[] arr, int alen, int spcount, CodepointSupport cps) {
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
		return arr;
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
		return new ImmutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	public CodepointArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public CodepointArray newClone() {
		return new MutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	
	@Override
	public CodepointArray newInstance() {
		return newInstance(arr, alen);
	}
	
	@Override
	public CodepointArray newInstance(char[] arr, int alen) {
		CodepointSupport cps = getPairsSupport();
		int spcount = arr == null ? 0 : cps.fixedPairsCount(arr, alen);
		return newInstance(arr, alen, spcount, cps);
	}

	@Override
	public CodepointArray newInstance(char[] arr, int alen, int spcount, CodepointSupport cps) {
		return new MutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	protected CodepointArray[] newArray(int alen) {
		return new MutableSupplementaryCodepointArray[alen];
	}

	@Override
	public CodepointArray assign(char[] arr, int alen, int spcount, CodepointSupport cps) {
		if (cps != null && !cps.isSupported())
			return new MutableBmpCodepointArray(arr, alen);
		this.arr = arr == null ? Lang.chararray.newDefaultArray() : arr;
		this.alen = arr == null ? 0 : Check.length(alen, 0, arr.length);
		// ------------------
		// spcount should not exceed the half of alen, which represent the whole
		// array are pairs, e.g: A1B2, alen = 4, but spcount = 2 which is the max
		// possible in this case
		// ------------------
		this.spcount = Check.length(spcount, 0, alen / 2);
		this.cps = cps == null ? CodepointSupport.BMP : cps;
		return this;
	}

	@Override
	public CodepointSupport getPairsSupport() {
		return cps;
	}

	

}