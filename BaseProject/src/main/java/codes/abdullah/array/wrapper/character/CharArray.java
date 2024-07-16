package codes.abdullah.array.wrapper.character;

import java.util.Arrays;
import java.util.stream.Collectors;

import codes.abdullah.project.Immutable;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface CharArray extends Immutable<CharArray> {

	char[] getArray();

	int length();

	boolean isEmpty();

	CharArray assign(char[] array);

	CharArray assign(int length);

	CharArray assign(char[] array, int length);

	CharArray newClone();
	
	CharArray newInstance();
	
	CharArray newInstance(char[] array);
	
	CharArray newInstance(char[] array, int length);

	public static CharArray of(char[] array) {
		return of(array, array.length);
	}

	public static CharArray of(char[] array, int length) {
		return new MutableCharArray(array, length);
	}

	public static String join(CharArray[] lines) {
		return Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
	}
}
