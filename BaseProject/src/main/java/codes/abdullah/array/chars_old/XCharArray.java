package codes.abdullah.array.chars;

import java.util.Arrays;
import java.util.stream.Collectors;

import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XCharArray extends XArray<XCharArray> {

	char[] getArray();
	
	char getAt(int index);

	XCharArray assign(char[] array, int length);

	XCharArray newInstance(char[] array, int length);

	public static XCharArray of() {
		char[] arr = Lang.chararray.newDefaultArray();
		return of(arr, arr.length);
	}

	public static XCharArray of(char[] array) {
		return of(array, array.length);
	}

	public static XCharArray of(char[] array, int length) {
		return new XMutableCharArray(array, length);
	}

	public static String join(XCharArray[] lines) {
		return Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
	}

}
