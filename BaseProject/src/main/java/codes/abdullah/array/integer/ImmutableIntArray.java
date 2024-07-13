package codes.abdullah.array.integer;

import java.util.Objects;

import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;
import codes.abdullah.project.lang.Lang;

class ImmutableIntArray extends AbstractIntArray {
	private static final long serialVersionUID = -5158545987158175306L;
	private final Endian endian;
	private final int len, flags;
	private final int[] arr;

	ImmutableIntArray(int[] arr, int len, Endian read, int flags) {
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
		if (len == 0)
			return IntArray.newEmptyIntArray();
		return Lang.copy.of.e.this_(arr, len, 0, len, endian);
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
		return this;
	}

	@Override
	public MutableIntArray toMutable() {
		return new MutableIntArray(arr, len, endian, flags);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

	@Override
	public ImmutableIntArray assign(int[] arr, int length) {
		return assign(arr, length, endian, flags);
	}

	@Override
	public ImmutableIntArray assign(int[] arr, int length, Endian endian, int flags) {
		return new ImmutableIntArray(arr, length, endian, flags);
	}

	@Override
	public ImmutableIntArray newClone() {
		return new ImmutableIntArray(arr, len, endian, flags);
	}

	@Override
	public ImmutableIntArray newInstance(int[] arr, int len, Endian read, int flags) {
		return new ImmutableIntArray(arr, len, read, flags);
	}

	@Override
	protected ImmutableIntArray[] newArray(int length) {
		return new ImmutableIntArray[length];
	}




}
