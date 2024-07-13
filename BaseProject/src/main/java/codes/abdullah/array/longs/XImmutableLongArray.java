package codes.abdullah.array.longs;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableLongArray extends AbstractXLongArray {
	private final long[] array;
	private final int length;

	XImmutableLongArray(long[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	long[] unsafe() {
		return array;
	}
	
	@Override
	public long getAt(int index) {
		return array[index];
	}

	@Override
	public XLongArray setAt(int index, long value) {
		long[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public long[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XLongArray assign(long[] array, int length) {
		return new XImmutableLongArray(array, length);
	}

	@Override
	public XLongArray newClone() {
		return new XImmutableLongArray(array, length);
	}

	@Override
	public XLongArray toImmutable() {
		return this;
	}

	@Override
	public XLongArray newInstance(long[] array, int length) {
		return new XImmutableLongArray(array, length);
	}

	@Override
	public XLongArray toMutable() {
		return new XMutableLongArray(getArray(), length);
	}
	
		@Override
	public XLongArray newInstance(Immutable<?> i) {
		long[] array = new long[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableLongArray(array, 0) :  new XMutableLongArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}