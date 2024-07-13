package codes.abdullah.array.booleans;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XBooleanArray extends XArray<XBooleanArray> {

	boolean[] getArray();
	
	boolean getAt(int index);
	
	XBooleanArray setAt(int index, boolean value);

	XBooleanArray assign(boolean[] array, int length);

	XBooleanArray newInstance(boolean[] array, int length);
	
	XBooleanArray newInstance(Immutable<?> i);

	XBooleanArray fill(boolean value, int from, int to);
	
	public static XBooleanArray of() {
		boolean[] arr = new boolean[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XBooleanArray of(int length) {
		boolean[] array = new boolean[length];
		return of(array, length);
	}

	public static XBooleanArray of(boolean[] array) {
		return of(array, array.length);
	}

	public static XBooleanArray of(boolean[] array, int length) {
		return new XMutableBooleanArray(array, length);
	}

	public static String join(XBooleanArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}