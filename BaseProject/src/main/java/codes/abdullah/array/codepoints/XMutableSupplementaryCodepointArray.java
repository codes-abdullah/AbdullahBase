package codes.abdullah.array.codepoints;

import codes.abdullah.array.chars.XCharArray;
import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

class XMutableSupplementaryCodepointArray extends XAbstractSupplementaryCodepointArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private int spcount;
	private XCharArray xarr;
	private CodepointSupport cps;

	XMutableSupplementaryCodepointArray(XCharArray xarr, int spcount, CodepointSupport cps) {
		this.xarr = Lang.chararray.newDefaultXCharArrayOrCopy(xarr);
		// ------------------
		// spcount should not exceed the half of alen, which represent the whole
		// array are pairs, e.g: A1B2, alen = 4, but spcount = 2 which is the max
		// possible in this case
		// ------------------
		this.spcount = Check.length(spcount, 0, xarr.length() / 2);
		this.cps = cps == null ? CodepointSupport.BMP : cps;
	}

	@Override
	public int getPairsCount() {
		return spcount;
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
	public XCodepointArray toImmutable() {
		return new XImmutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	public XCodepointArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public XCodepointArray newClone() {
		return new XMutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	public XCodepointArray newInstance() {
		return newInstance(arr, alen);
	}

	@Override
	public XCodepointArray newInstance(char[] arr, int alen) {
		CodepointSupport cps = getPairsSupport();
		int spcount = arr == null ? 0 : cps.fixedPairsCount(arr, alen);
		return newInstance(arr, alen, spcount, cps);
	}

	@Override
	public XCodepointArray newInstance(char[] arr, int alen, int spcount, CodepointSupport cps) {
		return new XMutableSupplementaryCodepointArray(arr, alen, spcount, cps);
	}

	@Override
	protected XCodepointArray[] newArray(int alen) {
		return new XMutableSupplementaryCodepointArray[alen];
	}

	@Override
	public XCodepointArray assign(char[] arr, int alen, int spcount, CodepointSupport cps) {
		if (cps != null && !cps.isSupported())
			return new XMutableBmpCodepointArray(arr, alen);
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