package codes.abdullah.array.shorts;

import codes.abdullah.project.lang.Lang;

public abstract class AbstractXShortArray implements XShortArray {

	abstract short[] unsafe();
	


	@Override
	public boolean isEmpty() {
		return length() == 0;
	}

	@Override
	public XShortArray ensureCapacity(int required) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.capacity.ensure(arr, len, required, true);
		return assign(arr, required);
	}

	@Override
	public XShortArray expand(int index, int size) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.expand.at(arr, len, index, size);
		return assign(arr, len);
	}

	@Override
	public XShortArray reverse(int from, int to) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.reverse.in(arr, len, from, to);
		return assign(arr, len);
	}

	@Override
	public XShortArray shuffle(int from, int to) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.shuffle.in(arr, len, from, to);
		return assign(arr, len);
	}

	@Override
	public XShortArray shrink(int index, int size) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.shrink.at(arr, len, index, size);
		return assign(arr, len);
	}

	@Override
	public XShortArray displace(int displacement, int from, int to) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.displace.move.in(arr, len, displacement);
		return assign(arr, len);
	}

	@Override
	public XShortArray swap(int left, int right) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.swap.with(arr, len, left, right);
		return assign(arr, len);
	}

	@Override
	public XShortArray fill(short value, int from, int to) {
		short[] arr = getArray();
		int len = length();
		arr = Lang.fill.in(arr, len, value, from, to);
		return assign(arr, len);
	}

	@Override
	public XShortArray trim() {
		short[] arr = getArray();
		int len = length();
		arr = Lang.trim.in(arr, len);
		return assign(arr, len);
	}


	@Override
	public int compareTo(XShortArray o) {
		short[] oarr = o instanceof AbstractXShortArray ? ((AbstractXShortArray) o).unsafe() : o.getArray();
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
		if (!(obj instanceof AbstractXShortArray))
			return false;
		AbstractXShortArray oarr = (AbstractXShortArray) obj;
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
		short[] arr = getArray();
		int len = length();
		return Lang.toString.of(arr, len, from, to);
	}
}