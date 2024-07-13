package codes.abdullah.array.wrapper.integer;

import codes.abdullah.project.Immutable;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface IntegerArray extends Immutable<IntegerArray> {

	int[] getArray();

	int getLength();

	IntegerArray setArray(int[] array);

	IntegerArray setLength(int length);

	public static IntegerArray of(int[] array) {
		return new MutableIntegerArray(array, array.length);
	}

	public static IntegerArray of(int[] array, int length) {
		return new MutableIntegerArray(array, length);
	}

}
