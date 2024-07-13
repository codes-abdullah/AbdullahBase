package codes.abdullah.array.integer;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.Endian;

/**
 * @see IntArrayElementLength#DEFAULT_ELEMENT_LENGTH
 * @see CodepointSupport
 */
public interface IntArrayElementLength {
	IntArrayElementLength DEFAULT_ELEMENT_LENGTH = (arr, len, index, read) -> 1;

	int lengthOf(int[] arr, int len, int index, Endian read);
}
