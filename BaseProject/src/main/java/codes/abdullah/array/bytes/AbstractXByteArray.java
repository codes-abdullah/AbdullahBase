package codes.abdullah.array.bytes;

import codes.abdullah.project.lang.Lang;

public abstract class AbstractXByteArray implements XByteArray {

	abstract byte[] unsafe();

	@Override
	public boolean isEmpty() {
		return length() == 0;
	}

	@Override
	public XByteArray ensureCapacity(int required) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.capacity.ensure(arr, len, required, true);
		return assign(arr, required);
	}

	@Override
	public XByteArray expand(int index, int size) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.expand.at(arr, len, index, size);
		return assign(arr, len);
	}

	@Override
	public XByteArray reverse(int from, int to) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.reverse.in(arr, len, from, to);
		return assign(arr, len);
	}

	@Override
	public XByteArray shuffle(int from, int to) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.shuffle.in(arr, len, from, to);
		return assign(arr, len);
	}

	@Override
	public XByteArray shrink(int index, int size) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.shrink.at(arr, len, index, size);
		return assign(arr, len);
	}

	@Override
	public XByteArray displace(int displacement, int from, int to) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.displace.move.in(arr, len, displacement);
		return assign(arr, len);
	}

	@Override
	public XByteArray swap(int left, int right) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.swap.with(arr, len, left, right);
		return assign(arr, len);
	}

	@Override
	public XByteArray fill(byte value, int from, int to) {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.fill.in(arr, len, value, from, to);
		return assign(arr, len);
	}

	@Override
	public XByteArray trim() {
		byte[] arr = getArray();
		int len = length();
		arr = Lang.trim.in(arr, len);
		return assign(arr, len);
	}

	@Override
	public int compareTo(XByteArray o) {
		byte[] oarr = o instanceof AbstractXByteArray ? ((AbstractXByteArray) o).unsafe() : o.getArray();
		return Lang.compare.test(unsafe(), length(), oarr, length());
	}

	@Override
	public int hashCode() {
		return Lang.hashCode.of(unsafe(), length());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!(obj instanceof AbstractXByteArray))
			return false;
		AbstractXByteArray oarr = (AbstractXByteArray) obj;
		return Lang.equal.test(unsafe(), length(), oarr.unsafe(), oarr.length());
	}

	@Override
	public String toString() {
		return toString(0);
	}

	@Override
	public String toString(int from) {
		return toString(from, length());
	}

	@Override
	public String toString(int from, int to) {
		byte[] arr = getArray();
		int len = length();
		return Lang.toString.of(arr, len, from, to);
	}
}