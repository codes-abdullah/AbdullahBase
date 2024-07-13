package codes.abdullah.array.shorts;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableShortArray extends AbstractXShortArray {
	private final short[] array;
	private final int length;

	XImmutableShortArray(short[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	short[] unsafe() {
		return array;
	}
	
	@Override
	public short getAt(int index) {
		return array[index];
	}

	@Override
	public XShortArray setAt(int index, short value) {
		short[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public short[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XShortArray assign(short[] array, int length) {
		return new XImmutableShortArray(array, length);
	}

	@Override
	public XShortArray newClone() {
		return new XImmutableShortArray(array, length);
	}

	@Override
	public XShortArray toImmutable() {
		return this;
	}

	@Override
	public XShortArray newInstance(short[] array, int length) {
		return new XImmutableShortArray(array, length);
	}

	@Override
	public XShortArray toMutable() {
		return new XMutableShortArray(getArray(), length);
	}
	
		@Override
	public XShortArray newInstance(Immutable<?> i) {
		short[] array = new short[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableShortArray(array, 0) :  new XMutableShortArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}