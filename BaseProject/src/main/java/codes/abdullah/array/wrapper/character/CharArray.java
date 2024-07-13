package codes.abdullah.array.wrapper.character;

import java.util.Arrays;
import java.util.stream.Collectors;

import codes.abdullah.project.Immutable;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface CharArray extends Immutable<CharArray> {

	char[] getArray();

	int getLength();

	@Deprecated
	CharArray setArray(char[] array);

	@Deprecated
	CharArray setLength(int length);

	CharArray assign(char[] array, int length);

	CharArray newInstance(char[] array, int length);

	public static CharArray of(char[] array) {
		return of(array, array.length);
	}

	public static CharArray of(char[] array, int length) {
		return new MutableCharArray(array, length);
	}

	public static String join(CharArray[] lines) {
		return Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.getLength()))
				.collect(Collectors.joining("\n"));
	}
}
