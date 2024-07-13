package codes.abdullah.array.wrapper.integer;

class MutableIntegerArray implements IntegerArray {
	private int[] array;
	private int length;

	MutableIntegerArray(int[] array, int length) {
		this.array = array;
		this.length = length;
	}

	@Override
	public int[] getArray() {
		return array;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public IntegerArray setArray(int[] array) {
		this.array = array;
		return this;
	}

	@Override
	public IntegerArray setLength(int length) {
		this.length = length;
		return this;
	}

	@Override
	public IntegerArray toImmutable() {
		return new ImmutableIntegerArray(array, length);
	}

	@Override
	public IntegerArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public String toString() {
//		return Lang.toString.of(array, length);
		return new String(array, 0, length);
	}

}
