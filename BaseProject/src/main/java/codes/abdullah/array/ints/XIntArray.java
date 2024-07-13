package codes.abdullah.array.ints;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XIntArray extends XArray<XIntArray> {

	int[] getArray();
	
	int getAt(int index);
	
	XIntArray setAt(int index, int value);

	XIntArray assign(int[] array, int length);

	XIntArray newInstance(int[] array, int length);
	
	XIntArray newInstance(Immutable<?> i);

	XIntArray fill(int value, int from, int to);
	
	public static XIntArray of() {
		int[] arr = new int[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XIntArray of(int length) {
		int[] array = new int[length];
		return of(array, length);
	}

	public static XIntArray of(int[] array) {
		return of(array, array.length);
	}

	public static XIntArray of(int[] array, int length) {
		return new XMutableIntArray(array, length);
	}

	public static String join(XIntArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}