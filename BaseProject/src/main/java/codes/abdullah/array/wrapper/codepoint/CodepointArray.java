package codes.abdullah.array.wrapper.codepoint;

import java.io.Serializable;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.Immutable;
import codes.abdullah.project.lang.Lang;

public interface CodepointArray extends Serializable, Immutable<CodepointArray> {
	
	
	public CodepointArray assign(char[] arr, int len);

	public CodepointArray assign(CharArray ca);

	public CodepointArray assign(char[] arr, int len, int spcount, CodepointSupport cpa);

	/**
	 * Get array based on implementation, if immutable, return new trimmed-copy,
	 * otherwise return underlying array
	 */
	char[] safe();

	char[] unsafe();

	CodepointArray newClone();

	CodepointArray newInstance();

	CodepointArray newInstance(char[] arr, int alen);

	CodepointArray newInstance(CharArray ca);

	CodepointArray newInstance(char[] arr, int alen, int spcount, CodepointSupport cps);

	boolean isEmpty();

	/**
	 * Curly brace for length [{1, 2, 3}, 0, 0]
	 * 
	 * @return current calculated length used for array
	 * @see #capacity()
	 */
	int length();

	/**
	 * Actual length
	 */
	int lengthActual();

	// ======================

	String toString(int from);

	String toString(int from, int to);

	// ======================

	int compareTo(CodepointArray o);

	// =======================

	/**
	 * @see #toCharArray(int, int)
	 */
	char[] toCharArray();

	/**
	 * @see #toCharArray(int, int)
	 */
	char[] toCharArray(int from);

	/**
	 * return new trimmed-copy of underlying array, no consideration for
	 * mutability/immutability implementation
	 */
	char[] toCharArray(int from, int to);

	/**
	 * The count of all surrogate-pairs
	 */
	int getPairsCount();

	CodepointSupport getPairsSupport();

	/**
	 * @see #toCodepointArray(int, int, CodepointSupport)
	 */
	int[] toCodepointArray();

	/**
	 * @see #toCodepointArray(int, int, CodepointSupport)
	 */
	int[] toCodepointArray(int from);

	/**
	 * @see #toCodepointArray(int, int, CodepointSupport)
	 */
	int[] toCodepointArray(int from, int to);

	CodepointArray setPairsSupport(CodepointSupport cps);

	/**
	 * @return if {@link CodepointSupport#isSupported()}, new trimmed-copy with
	 *         combination of bmp and supplementary code-points, otherwise new
	 *         trimmed-copy of bmp array
	 */
	int[] toCodepointArray(int from, int to, CodepointSupport cps);

	public static CodepointArray of() {
		char[] arr = Lang.chararray.newDefaultArray();
		return of(arr, 0);
	}

	public static CodepointArray of(char[] arr, int alen) {
		return of(arr, alen, 0, null);
	}

	/**
	 * @return mutable-codepoint array implementation
	 */
	public static CodepointArray of(char[] arr, int alen, int spcount, CodepointSupport cps) {
		if (cps != null && cps.isSupported())
			return new MutableSupplementaryCodepointArray(arr, alen, spcount, cps);
		return new MutableBmpCodepointArray(arr, alen);
	}

}
