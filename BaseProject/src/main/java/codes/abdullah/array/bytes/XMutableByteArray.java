package codes.abdullah.array.bytes;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableByteArray extends AbstractXByteArray {
	private byte[] array;
	private int length;

	XMutableByteArray(byte[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public byte getAt(int index) {
		return array[index];
	}

	@Override
	public XByteArray setAt(int index, byte value) {
		array[index] = value;
		return this;
	}

	@Override
	byte[] unsafe() {
		return array;
	}

	@Override
	public byte[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XByteArray assign(byte[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XByteArray newClone() {
		byte[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableByteArray(arr2, length);
	}

	@Override
	public XByteArray toImmutable() {
		return new XImmutableByteArray(array, length);
	}

	@Override
	public XByteArray newInstance(byte[] array, int length) {
		return new XMutableByteArray(array, length);
	}

	@Override
	public XByteArray newInstance(Immutable<?> i) {
		byte[] array = new byte[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableByteArray(array, 0) :  new XMutableByteArray(array, 0); 
	}


	@Override
	public XByteArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}