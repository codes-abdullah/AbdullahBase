package codes.abdullah.array.floats;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableFloatArray extends AbstractXFloatArray {
	private float[] array;
	private int length;

	XMutableFloatArray(float[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public float getAt(int index) {
		return array[index];
	}

	@Override
	public XFloatArray setAt(int index, float value) {
		array[index] = value;
		return this;
	}

	@Override
	float[] unsafe() {
		return array;
	}

	@Override
	public float[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XFloatArray assign(float[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XFloatArray newClone() {
		float[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableFloatArray(arr2, length);
	}

	@Override
	public XFloatArray toImmutable() {
		return new XImmutableFloatArray(array, length);
	}

	@Override
	public XFloatArray newInstance(float[] array, int length) {
		return new XMutableFloatArray(array, length);
	}

	@Override
	public XFloatArray newInstance(Immutable<?> i) {
		float[] array = new float[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableFloatArray(array, 0) :  new XMutableFloatArray(array, 0); 
	}


	@Override
	public XFloatArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}