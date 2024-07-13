package codes.abdullah.array.doubles;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XImmutableDoubleArray extends AbstractXDoubleArray {
	private final double[] array;
	private final int length;

	XImmutableDoubleArray(double[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	double[] unsafe() {
		return array;
	}
	
	@Override
	public double getAt(int index) {
		return array[index];
	}

	@Override
	public XDoubleArray setAt(int index, double value) {
		double[] arr = getArray();
		arr[index] = value;
		return assign(arr, length());
	}

	@Override
	public double[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XDoubleArray assign(double[] array, int length) {
		return new XImmutableDoubleArray(array, length);
	}

	@Override
	public XDoubleArray newClone() {
		return new XImmutableDoubleArray(array, length);
	}

	@Override
	public XDoubleArray toImmutable() {
		return this;
	}

	@Override
	public XDoubleArray newInstance(double[] array, int length) {
		return new XImmutableDoubleArray(array, length);
	}

	@Override
	public XDoubleArray toMutable() {
		return new XMutableDoubleArray(getArray(), length);
	}
	
		@Override
	public XDoubleArray newInstance(Immutable<?> i) {
		double[] array = new double[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableDoubleArray(array, 0) :  new XMutableDoubleArray(array, 0); 
	}

	@Override
	public boolean isImmutable() {
		return true;
	}


}