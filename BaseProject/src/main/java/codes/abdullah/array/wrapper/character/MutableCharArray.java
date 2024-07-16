package codes.abdullah.array.wrapper.character;

import codes.abdullah.project.lang.Lang;

class MutableCharArray implements CharArray {
	private char[] array;
	private int length;

	MutableCharArray(char[] array, int length) {
		this.array = array;
		this.length = length;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public CharArray assign(char[] array) {
		return assign(array, length);
	}

	@Override
	public CharArray assign(int length) {
		return assign(array, length);
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
	public CharArray assign(char[] arr, int len) {
		this.array = arr;
		this.length = len;
		return this;
	}

	@Override
	public CharArray toImmutable() {
		return new ImmutableCharArray(array, length);
	}

	@Override
	public CharArray newClone() {
		return new MutableCharArray(Lang.copy.of.this_(array, length), length);
	}

	@Override
	public CharArray newInstance() {
		char[] array = Lang.chararray.newDefaultArray();
		return newInstance(array, 0);
	}

	@Override
	public CharArray newInstance(char[] array) {
		return newInstance(array, array.length);
	}

	@Override
	public CharArray newInstance(char[] array, int length) {
		return new MutableCharArray(array, length);
	}

	@Override
	public CharArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public String toString() {
		return new String(array, 0, length);
	}

}
