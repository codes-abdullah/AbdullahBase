package codes.abdullah.array.floats;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableFloatArray extends AbstractXFloatArray {
	private final float[] array;
	private final int length;

	XImmutableFloatArray(float[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	float[] unsafe() {
		return array;
	}
	
	@Override
	public float getAt(int index) {
		return array[index];
	}

	@Override
	public XFloatArray setAt(int index, float value) {
		float[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public float[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XFloatArray assign(float[] array, int length) {
		return new XImmutableFloatArray(array, length);
	}

	@Override
	public XFloatArray newClone() {
		return new XImmutableFloatArray(array, length);
	}

	@Override
	public XFloatArray toImmutable() {
		return this;
	}

	@Override
	public XFloatArray newInstance(float[] array, int length) {
		return new XImmutableFloatArray(array, length);
	}

	@Override
	public XFloatArray toMutable() {
		return new XMutableFloatArray(getArray(), length);
	}
	
		@Override
	public XFloatArray newInstance(Immutable<?> i) {
		float[] array = new float[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableFloatArray(array, 0) :  new XMutableFloatArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}