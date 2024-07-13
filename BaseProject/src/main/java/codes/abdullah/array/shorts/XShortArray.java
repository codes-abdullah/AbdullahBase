package codes.abdullah.array.shorts;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XShortArray extends XArray<XShortArray> {

	short[] getArray();
	
	short getAt(int index);
	
	XShortArray setAt(int index, short value);

	XShortArray assign(short[] array, int length);

	XShortArray newInstance(short[] array, int length);
	
	XShortArray newInstance(Immutable<?> i);

	XShortArray fill(short value, int from, int to);
	
	public static XShortArray of() {
		short[] arr = new short[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XShortArray of(int length) {
		short[] array = new short[length];
		return of(array, length);
	}

	public static XShortArray of(short[] array) {
		return of(array, array.length);
	}

	public static XShortArray of(short[] array, int length) {
		return new XMutableShortArray(array, length);
	}

	public static String join(XShortArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}