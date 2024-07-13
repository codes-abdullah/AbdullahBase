package codes.abdullah.array;

import codes.abdullah.project.Immutable;

/**
 * Simple wrapper to implement mutability/immutability
 */
public interface XArray<T extends XArray<T>> extends Immutable<T>, Comparable<T> {

	int length();

	boolean isEmpty();

	T newClone();

	T ensureCapacity(int required);

	T expand(int index, int size);

	T shrink(int index, int size);

	T shuffle(int from, int to);

	T reverse(int from, int to);

	T displace(int displacement, int from, int to);

	T swap(int left, int right);

	T trim();

	String toString(int from);

	String toString(int from, int to);



}
