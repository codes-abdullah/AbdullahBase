package codes.abdullah.array.chars;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableCharArray extends AbstractXCharArray {
	private final char[] array;
	private final int length;

	XImmutableCharArray(char[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	char[] unsafe() {
		return array;
	}
	
	@Override
	public char getAt(int index) {
		return array[index];
	}

	@Override
	public XCharArray setAt(int index, char value) {
		char[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public char[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XCharArray assign(char[] array, int length) {
		return new XImmutableCharArray(array, length);
	}

	@Override
	public XCharArray newClone() {
		return new XImmutableCharArray(array, length);
	}

	@Override
	public XCharArray toImmutable() {
		return this;
	}

	@Override
	public XCharArray newInstance(char[] array, int length) {
		return new XImmutableCharArray(array, length);
	}

	@Override
	public XCharArray toMutable() {
		return new XMutableCharArray(getArray(), length);
	}
	
		@Override
	public XCharArray newInstance(Immutable<?> i) {
		char[] array = new char[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableCharArray(array, 0) :  new XMutableCharArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}