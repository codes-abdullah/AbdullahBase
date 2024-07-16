package codes.abdullah.array.wrapper.character;

import codes.abdullah.project.lang.Lang;

class ImmutableCharArray implements CharArray {
	private final char[] array;
	private final int length;

	ImmutableCharArray(char[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
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
	public CharArray assign(char[] arr, int len) {
		return new ImmutableCharArray(arr, len);
	}

	@Override
	public CharArray toImmutable() {
		return this;
	}

	@Override
	public CharArray newClone() {
		return new ImmutableCharArray(array, length);
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
		return new ImmutableCharArray(array, length);
	}

	@Override
	public CharArray toMutable() {
		return new MutableCharArray(getArray(), length);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

	@Override
	public String toString() {
		return new String(array, 0, length);
	}

}
