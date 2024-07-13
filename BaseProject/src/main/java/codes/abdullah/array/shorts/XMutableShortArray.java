package codes.abdullah.array.shorts;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableShortArray extends AbstractXShortArray {
	private short[] array;
	private int length;

	XMutableShortArray(short[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public short getAt(int index) {
		return array[index];
	}

	@Override
	public XShortArray setAt(int index, short value) {
		array[index] = value;
		return this;
	}

	@Override
	short[] unsafe() {
		return array;
	}

	@Override
	public short[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XShortArray assign(short[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XShortArray newClone() {
		short[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableShortArray(arr2, length);
	}

	@Override
	public XShortArray toImmutable() {
		return new XImmutableShortArray(array, length);
	}

	@Override
	public XShortArray newInstance(short[] array, int length) {
		return new XMutableShortArray(array, length);
	}

	@Override
	public XShortArray newInstance(Immutable<?> i) {
		short[] array = new short[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableShortArray(array, 0) :  new XMutableShortArray(array, 0); 
	}


	@Override
	public XShortArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}