package codes.abdullah.array.bytes;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XByteArray extends XArray<XByteArray> {

	byte[] getArray();
	
	byte getAt(int index);
	
	XByteArray setAt(int index, byte value);

	XByteArray assign(byte[] array, int length);

	XByteArray newInstance(byte[] array, int length);
	
	XByteArray newInstance(Immutable<?> i);

	XByteArray fill(byte value, int from, int to);
	
	public static XByteArray of() {
		byte[] arr = new byte[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XByteArray of(int length) {
		byte[] array = new byte[length];
		return of(array, length);
	}

	public static XByteArray of(byte[] array) {
		return of(array, array.length);
	}

	public static XByteArray of(byte[] array, int length) {
		return new XMutableByteArray(array, length);
	}

	public static String join(XByteArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}