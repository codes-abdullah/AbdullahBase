package codes.abdullah.array.chars;

import codes.abdullah.project.lang.Lang;

class XImmutableCharArray extends AbstractXCharArray {
	private final char[] array;
	private final int length;

	XImmutableCharArray(char[] array, int length) {
		this.array = Lang.copy.of.this_(array, length);
		this.length = length;
	}

	@Override
	char[] unsafe() {
		return array;
	}

	@Override
	public char[] getArray() {
		return Lang.copy.of.this_(array, length);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public XCharArray assign(char[] array, int length) {
		return new XImmutableCharArray(array, length);
	}

	@Override
	public XCharArray newClone() {
		return new XImmutableCharArray(array, length);
	}

	@Override
	public XCharArray toImmutable() {
		return this;
	}

	@Override
	public XCharArray newInstance(char[] array, int length) {
		return new XImmutableCharArray(array, length);
	}

	@Override
	public XCharArray toMutable() {
		return new XMutableCharArray(getArray(), length);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

	@Override
	public String toString() {
		return new String(array, 0, length);
	}

}
