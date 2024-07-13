package codes.abdullah.array.codepoints;

import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

class XImmutableBmpCodepointArray extends XAbstractBmpCodepointArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private final int alen;
	private final char[] arr;

	XImmutableBmpCodepointArray(char[] arr, int alen) {
		this.arr = Lang.chararray.newDefaultArrayOrCopy(arr, alen);
		this.alen = arr == null || arr.length == 0 ? 0 : Check.length(alen, 0, arr.length);
	}

	@Override
	public int getPairsCount() {
		return 0;
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
	public XCodepointArray toImmutable() {
		return this;
	}

	@Override
	public XCodepointArray toMutable() {
		return new XMutableBmpCodepointArray(arr, alen);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

	@Override
	public XCodepointArray newClone() {
		return new XImmutableBmpCodepointArray(arr, alen);
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
		return new XImmutableBmpCodepointArray(arr, alen);
	}

	@Override
	protected XCodepointArray[] newArray(int alen) {
		return new XImmutableBmpCodepointArray[alen];
	}

	@Override
	public XCodepointArray assign(char[] arr, int alen, int spcount, CodepointSupport cps) {
		return new XImmutableBmpCodepointArray(arr, alen);
	}

}