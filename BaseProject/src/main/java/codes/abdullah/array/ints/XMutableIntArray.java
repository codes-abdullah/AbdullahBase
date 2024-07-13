package codes.abdullah.array.ints;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableIntArray extends AbstractXIntArray {
	private int[] array;
	private int length;

	XMutableIntArray(int[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public int getAt(int index) {
		return array[index];
	}

	@Override
	public XIntArray setAt(int index, int value) {
		array[index] = value;
		return this;
	}

	@Override
	int[] unsafe() {
		return array;
	}

	@Override
	public int[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XIntArray assign(int[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XIntArray newClone() {
		int[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableIntArray(arr2, length);
	}

	@Override
	public XIntArray toImmutable() {
		return new XImmutableIntArray(array, length);
	}

	@Override
	public XIntArray newInstance(int[] array, int length) {
		return new XMutableIntArray(array, length);
	}

	@Override
	public XIntArray newInstance(Immutable<?> i) {
		int[] array = new int[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableIntArray(array, 0) :  new XMutableIntArray(array, 0); 
	}


	@Override
	public XIntArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}