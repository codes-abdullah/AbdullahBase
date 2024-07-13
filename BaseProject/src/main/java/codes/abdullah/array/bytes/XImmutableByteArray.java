package codes.abdullah.array.bytes;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableByteArray extends AbstractXByteArray {
	private final byte[] array;
	private final int length;

	XImmutableByteArray(byte[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	byte[] unsafe() {
		return array;
	}
	
	@Override
	public byte getAt(int index) {
		return array[index];
	}

	@Override
	public XByteArray setAt(int index, byte value) {
		byte[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public byte[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XByteArray assign(byte[] array, int length) {
		return new XImmutableByteArray(array, length);
	}

	@Override
	public XByteArray newClone() {
		return new XImmutableByteArray(array, length);
	}

	@Override
	public XByteArray toImmutable() {
		return this;
	}

	@Override
	public XByteArray newInstance(byte[] array, int length) {
		return new XImmutableByteArray(array, length);
	}

	@Override
	public XByteArray toMutable() {
		return new XMutableByteArray(getArray(), length);
	}
	
		@Override
	public XByteArray newInstance(Immutable<?> i) {
		byte[] array = new byte[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableByteArray(array, 0) :  new XMutableByteArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}