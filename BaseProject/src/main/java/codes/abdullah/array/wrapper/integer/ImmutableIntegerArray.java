package codes.abdullah.array.wrapper.integer;

import codes.abdullah.project.lang.Lang;

class ImmutableIntegerArray implements IntegerArray {
	private final int[] array;
	private final int length;

	ImmutableIntegerArray(int[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	public int[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public IntegerArray setArray(int[] array) {
		return new ImmutableIntegerArray(array, length);
	}

	@Override
	public IntegerArray setLength(int length) {
		return new ImmutableIntegerArray(array, length);
	}

	@Override
	public IntegerArray toImmutable() {
		return this;
	}

	@Override
	public IntegerArray toMutable() {
		return new MutableIntegerArray(Lang.copy.of.this_(array, length), length);
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
