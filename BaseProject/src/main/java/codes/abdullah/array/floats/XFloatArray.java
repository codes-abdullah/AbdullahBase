package codes.abdullah.array.floats;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XFloatArray extends XArray<XFloatArray> {

	float[] getArray();
	
	float getAt(int index);
	
	XFloatArray setAt(int index, float value);

	XFloatArray assign(float[] array, int length);

	XFloatArray newInstance(float[] array, int length);
	
	XFloatArray newInstance(Immutable<?> i);

	XFloatArray fill(float value, int from, int to);
	
	public static XFloatArray of() {
		float[] arr = new float[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XFloatArray of(int length) {
		float[] array = new float[length];
		return of(array, length);
	}

	public static XFloatArray of(float[] array) {
		return of(array, array.length);
	}

	public static XFloatArray of(float[] array, int length) {
		return new XMutableFloatArray(array, length);
	}

	public static String join(XFloatArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}