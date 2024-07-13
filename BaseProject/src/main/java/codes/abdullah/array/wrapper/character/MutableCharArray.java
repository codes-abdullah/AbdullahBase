package codes.abdullah.array.wrapper.character;

class MutableCharArray implements CharArray {
	private char[] array;
	private int length;

	MutableCharArray(char[] array, int length) {
		this.array = array;
		this.length = length;
	}

	@Override
	public char[] getArray() {
		return array;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public CharArray setArray(char[] array) {
		this.array = array;
		return this;
	}

	@Override
	public CharArray setLength(int length) {
		this.length = length;
		return this;
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
