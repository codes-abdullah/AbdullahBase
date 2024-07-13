package codes.abdullah.array.booleans;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableBooleanArray extends AbstractXBooleanArray {
	private boolean[] array;
	private int length;

	XMutableBooleanArray(boolean[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public boolean getAt(int index) {
		return array[index];
	}

	@Override
	public XBooleanArray setAt(int index, boolean value) {
		array[index] = value;
		return this;
	}

	@Override
	boolean[] unsafe() {
		return array;
	}

	@Override
	public boolean[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XBooleanArray assign(boolean[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XBooleanArray newClone() {
		boolean[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableBooleanArray(arr2, length);
	}

	@Override
	public XBooleanArray toImmutable() {
		return new XImmutableBooleanArray(array, length);
	}

	@Override
	public XBooleanArray newInstance(boolean[] array, int length) {
		return new XMutableBooleanArray(array, length);
	}

	@Override
	public XBooleanArray newInstance(Immutable<?> i) {
		boolean[] array = new boolean[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableBooleanArray(array, 0) :  new XMutableBooleanArray(array, 0); 
	}


	@Override
	public XBooleanArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}