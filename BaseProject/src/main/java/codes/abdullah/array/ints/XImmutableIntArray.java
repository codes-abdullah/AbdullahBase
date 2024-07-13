package codes.abdullah.array.ints;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableIntArray extends AbstractXIntArray {
	private final int[] array;
	private final int length;

	XImmutableIntArray(int[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	int[] unsafe() {
		return array;
	}
	
	@Override
	public int getAt(int index) {
		return array[index];
	}

	@Override
	public XIntArray setAt(int index, int value) {
		int[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public int[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XIntArray assign(int[] array, int length) {
		return new XImmutableIntArray(array, length);
	}

	@Override
	public XIntArray newClone() {
		return new XImmutableIntArray(array, length);
	}

	@Override
	public XIntArray toImmutable() {
		return this;
	}

	@Override
	public XIntArray newInstance(int[] array, int length) {
		return new XImmutableIntArray(array, length);
	}

	@Override
	public XIntArray toMutable() {
		return new XMutableIntArray(getArray(), length);
	}
	
		@Override
	public XIntArray newInstance(Immutable<?> i) {
		int[] array = new int[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableIntArray(array, 0) :  new XMutableIntArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}