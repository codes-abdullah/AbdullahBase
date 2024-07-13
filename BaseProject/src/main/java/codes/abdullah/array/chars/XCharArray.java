package codes.abdullah.array.chars;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XCharArray extends XArray<XCharArray> {

	char[] getArray();
	
	char getAt(int index);
	
	XCharArray setAt(int index, char value);

	XCharArray assign(char[] array, int length);

	XCharArray newInstance(char[] array, int length);
	
	XCharArray newInstance(Immutable<?> i);

	XCharArray fill(char value, int from, int to);
	
	public static XCharArray of() {
		char[] arr = new char[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XCharArray of(int length) {
		char[] array = new char[length];
		return of(array, length);
	}

	public static XCharArray of(char[] array) {
		return of(array, array.length);
	}

	public static XCharArray of(char[] array, int length) {
		return new XMutableCharArray(array, length);
	}

	public static String join(XCharArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}