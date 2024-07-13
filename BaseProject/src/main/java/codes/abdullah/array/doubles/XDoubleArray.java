package codes.abdullah.array.doubles;

import java.util.Arrays;
import java.util.stream.Collectors;
import codes.abdullah.project.Immutable;
import codes.abdullah.array.XArray;
import codes.abdullah.project.lang.Lang;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XDoubleArray extends XArray<XDoubleArray> {

	double[] getArray();
	
	double getAt(int index);
	
	XDoubleArray setAt(int index, double value);

	XDoubleArray assign(double[] array, int length);

	XDoubleArray newInstance(double[] array, int length);
	
	XDoubleArray newInstance(Immutable<?> i);

	XDoubleArray fill(double value, int from, int to);
	
	public static XDoubleArray of() {
		double[] arr = new double[Lang.constant.ARRAY_DEFAULT_CAPACITY];
		return of(arr, arr.length);
	}
	
	public static XDoubleArray of(int length) {
		double[] array = new double[length];
		return of(array, length);
	}

	public static XDoubleArray of(double[] array) {
		return of(array, array.length);
	}

	public static XDoubleArray of(double[] array, int length) {
		return new XMutableDoubleArray(array, length);
	}

	public static String join(XDoubleArray[] arrays) {
		return Arrays.stream(arrays).map(array -> array.toString())
				.collect(Collectors.joining("\n"));
	}

}