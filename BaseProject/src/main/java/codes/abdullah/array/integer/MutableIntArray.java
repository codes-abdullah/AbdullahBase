package codes.abdullah.array.integer;

import java.util.Objects;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;

class MutableIntArray extends AbstractIntArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private Endian endian;
	private int len, flags;
	private int[] arr;

	MutableIntArray(int[] arr, int len, Endian read, int flags) {
		this.endian = Objects.requireNonNull(read);
		this.arr = IntArray.newDefaultIntArrayOrCopy(arr, len, read);
		this.len = arr == null || arr.length == 0 ? 0 : Check.length(len, 0, arr.length);
		this.flags = flags;
	}

	@Override
	public int flags() {
		return flags;
	}

	@Override
	public int[] toArray() {
		return arr;
	}

	@Override
	public int length() {
		return len;
	}

	@Override
	public int capacity() {
		return arr.length;
	}

	@Override
	public Endian endian() {
		return endian;
	}

	@Override
	public ImmutableIntArray toImmutable() {
		return new ImmutableIntArray(arr, len, endian, flags);
	}

	@Override
	public MutableIntArray toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public MutableIntArray newClone() {
		return new MutableIntArray(arr, len, endian, flags);
	}

	@Override
	public MutableIntArray assign(int[] arr, int len, Endian e, int flags) {
		this.endian = Objects.requireNonNull(e);
		this.arr = arr == null ? IntArray.newDefaultIntArray() : arr;
		this.len = arr == null ? 0 : Check.length(len, 0, arr.length);
		this.flags = flags;
		return this;
	}

	@Override
	public MutableIntArray newInstance(int[] arr, int len, Endian read, int flags) {
		return new MutableIntArray(arr, len, read, flags);
	}

	@Override
	protected MutableIntArray[] newArray(int length) {
		return new MutableIntArray[length];
	}

}
