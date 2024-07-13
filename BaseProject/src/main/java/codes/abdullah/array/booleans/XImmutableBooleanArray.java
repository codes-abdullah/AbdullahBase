package codes.abdullah.array.booleans;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableBooleanArray extends AbstractXBooleanArray {
	private final boolean[] array;
	private final int length;

	XImmutableBooleanArray(boolean[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	boolean[] unsafe() {
		return array;
	}
	
	@Override
	public boolean getAt(int index) {
		return array[index];
	}

	@Override
	public XBooleanArray setAt(int index, boolean value) {
		boolean[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public boolean[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XBooleanArray assign(boolean[] array, int length) {
		return new XImmutableBooleanArray(array, length);
	}

	@Override
	public XBooleanArray newClone() {
		return new XImmutableBooleanArray(array, length);
	}

	@Override
	public XBooleanArray toImmutable() {
		return this;
	}

	@Override
	public XBooleanArray newInstance(boolean[] array, int length) {
		return new XImmutableBooleanArray(array, length);
	}

	@Override
	public XBooleanArray toMutable() {
		return new XMutableBooleanArray(getArray(), length);
	}
	
		@Override
	public XBooleanArray newInstance(Immutable<?> i) {
		boolean[] array = new boolean[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableBooleanArray(array, 0) :  new XMutableBooleanArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}