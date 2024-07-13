package codes.abdullah.array.chars;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableCharArray extends AbstractXCharArray {
	private char[] array;
	private int length;

	XMutableCharArray(char[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public char getAt(int index) {
		return array[index];
	}

	@Override
	public XCharArray setAt(int index, char value) {
		array[index] = value;
		return this;
	}

	@Override
	char[] unsafe() {
		return array;
	}

	@Override
	public char[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XCharArray assign(char[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XCharArray newClone() {
		char[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableCharArray(arr2, length);
	}

	@Override
	public XCharArray toImmutable() {
		return new XImmutableCharArray(array, length);
	}

	@Override
	public XCharArray newInstance(char[] array, int length) {
		return new XMutableCharArray(array, length);
	}

	@Override
	public XCharArray newInstance(Immutable<?> i) {
		char[] array = new char[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableCharArray(array, 0) :  new XMutableCharArray(array, 0); 
	}


	@Override
	public XCharArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}