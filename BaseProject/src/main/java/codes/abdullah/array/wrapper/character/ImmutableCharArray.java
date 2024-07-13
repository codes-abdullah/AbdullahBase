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
	public int getLength() {
		return length;
	}

	@Override
	public CharArray setArray(char[] array) {
		return new ImmutableCharArray(array, length);
	}

	@Override
	public CharArray setLength(int length) {
		return new ImmutableCharArray(array, length);
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
