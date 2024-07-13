package codes.abdullah.array.codepoints;

import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

class XMutableBmpCodepointArray extends XAbstractBmpCodepointArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private int alen;
	private char[] arr;

	XMutableBmpCodepointArray(char[] arr, int alen) {
		this.arr = Lang.chararray.newDefaultArrayOrCopy(arr, alen);
		this.alen = arr == null || arr.length == 0 ? 0 : Check.length(alen, 0, arr.length);
	}

	@Override
	public int getPairsCount() {
		return 0;
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
	public XCodepointArray toImmutable() {
		return new XImmutableBmpCodepointArray(arr, alen);
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
		return new XMutableBmpCodepointArray(arr, alen);
	}
	
	@Override
	public XCodepointArray newInstance() {		
		return newInstance(null, 0);
	}

	@Override
	public XCodepointArray newInstance(char[] arr, int alen) {
		return newInstance(arr, alen, 0, null);
	}

	@Override
	public XCodepointArray newInstance(char[] arr, int alen, int spcount, CodepointSupport cps) {
		return new XMutableBmpCodepointArray(arr, alen);
	}

	@Override
	protected XCodepointArray[] newArray(int alen) {
		return new XMutableBmpCodepointArray[alen];
	}

	@Override
	public XCodepointArray assign(char[] arr, int alen, int spcount, CodepointSupport cps) {
		this.arr = arr == null ? Lang.chararray.newDefaultArray() : arr;
		this.alen = arr == null ? 0 : Check.length(alen, 0, arr.length);
		return this;
	}

}