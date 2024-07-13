package codes.abdullah.array.longs;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableLongArray extends AbstractXLongArray {
	private long[] array;
	private int length;

	XMutableLongArray(long[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public long getAt(int index) {
		return array[index];
	}

	@Override
	public XLongArray setAt(int index, long value) {
		array[index] = value;
		return this;
	}

	@Override
	long[] unsafe() {
		return array;
	}

	@Override
	public long[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XLongArray assign(long[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XLongArray newClone() {
		long[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableLongArray(arr2, length);
	}

	@Override
	public XLongArray toImmutable() {
		return new XImmutableLongArray(array, length);
	}

	@Override
	public XLongArray newInstance(long[] array, int length) {
		return new XMutableLongArray(array, length);
	}

	@Override
	public XLongArray newInstance(Immutable<?> i) {
		long[] array = new long[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableLongArray(array, 0) :  new XMutableLongArray(array, 0); 
	}


	@Override
	public XLongArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}