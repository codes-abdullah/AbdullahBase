package codes.abdullah.array.doubles;

import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.Immutable;

class XMutableDoubleArray extends AbstractXDoubleArray {
	private double[] array;
	private int length;

	XMutableDoubleArray(double[] array, int length) {
		this.array = array;
		this.length = length;
	}
	
		@Override
	public double getAt(int index) {
		return array[index];
	}

	@Override
	public XDoubleArray setAt(int index, double value) {
		array[index] = value;
		return this;
	}

	@Override
	double[] unsafe() {
		return array;
	}

	@Override
	public double[] getArray() {
		return array;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XDoubleArray assign(double[] array, int length) {
		this.array = array;
		this.length = length;
		return this;
	}

	@Override
	public XDoubleArray newClone() {
		double[] arr2 = Lang.copy.of.this_(array, length);
		return new XMutableDoubleArray(arr2, length);
	}

	@Override
	public XDoubleArray toImmutable() {
		return new XImmutableDoubleArray(array, length);
	}

	@Override
	public XDoubleArray newInstance(double[] array, int length) {
		return new XMutableDoubleArray(array, length);
	}

	@Override
	public XDoubleArray newInstance(Immutable<?> i) {
		double[] array = new double[Lang.constant.DEFAULT_ARRAY_CAPACITY];
		return i.isImmutable() ? new XImmutableDoubleArray(array, 0) :  new XMutableDoubleArray(array, 0); 
	}


	@Override
	public XDoubleArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}