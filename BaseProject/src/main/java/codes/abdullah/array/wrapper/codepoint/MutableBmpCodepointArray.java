package codes.abdullah.array.wrapper.codepoint;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Check;
import codes.abdullah.project.lang.Lang;

class MutableBmpCodepointArray extends AbstractBmpCodepointArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private int alen;
	private char[] arr;

	MutableBmpCodepointArray(char[] arr, int alen) {
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
	public CodepointArray toImmutable() {
		return new ImmutableBmpCodepointArray(arr, alen);
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
		return new MutableBmpCodepointArray(arr, alen);
	}
	
	@Override
	public CodepointArray newInstance() {		
		return newInstance(null, 0);
	}

	@Override
	public CodepointArray newInstance(char[] arr, int alen) {
		return newInstance(arr, alen, 0, null);
	}

	@Override
	public CodepointArray newInstance(char[] arr, int alen, int spcount, CodepointSupport cps) {
		return new MutableBmpCodepointArray(arr, alen);
	}

	@Override
	protected CodepointArray[] newArray(int alen) {
		return new MutableBmpCodepointArray[alen];
	}

	@Override
	public CodepointArray assign(char[] arr, int alen, int spcount, CodepointSupport cps) {
		this.arr = arr == null ? Lang.chararray.newDefaultArray() : arr;
		this.alen = arr == null ? 0 : Check.length(alen, 0, arr.length);
		return this;
	}

}