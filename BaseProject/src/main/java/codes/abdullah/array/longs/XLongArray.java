package codes.abdullah.array.longs;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XLongArray extends XArray<XLongArray> {

	long[] getArray();
	
	long getAt(int index);
	
	XLongArray setAt(int index, long value);

	XLongArray assign(long[] array, int length);

	XLongArray newInstance(long[] array, int length);
	
	XLongArray newInstance(Immutable<?> i);

	XLongArray fill(long value, int from, int to);
	
	public static XLongArray of() {
		long[] arr = new long[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XLongArray of(int length) {
		long[] array = new long[length];
		return of(array, length);
	}

	public static XLongArray of(long[] array) {
		return of(array, array.length);
	}

	public static XLongArray of(long[] array, int length) {
		return new XMutableLongArray(array, length);
	}

	public static String join(XLongArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}