package codes.abdullah.project;

import java.nio.ByteOrder;

public interface EndianIndex {
	/**
	 * <b>Note:</b> invoker must always pass the <b>array.length</b> as
	 * <b>capacity</b> value<br>
	 * <b>Note: </b> inputs should be based on instance perspective, and returned
	 * value is always little-endian perspective to be compilable with Java
	 * indexing<br>
	 * e.g: {10, 20, 30}<br>
	 * if this instance {@link #BIG}: index: 0 returns 30<br>
	 * if this instance {@link #LITTLE}: index: 0 returns 10<br>
	 * 
	 * @see #from(int, int, int)
	 * @see #to(int, int, int)
	 * @see #insertIndex(int, int, int)
	 * 
	 */
	int index(int index, int len, int capacity);

	/**
	 * <b>Note: </b> The implementation of this method should not do any checks at
	 * all, invokers must take care of all indexing safety<br>
	 * <b>Note:</b> invoker must always pass the <b>array.length</b> as
	 * <b>capacity</b> value<br>
	 * <b>Note: </b> inputs should be based on instance perspective, and returned
	 * value is always little-endian perspective to be compilable with Java
	 * indexing<br>
	 * <br>
	 * This method will convert index based on insertion-length to be inserted at
	 * given index<br>
	 * Assume, you have array: [0, 0, 0, 0, 0], and you want to copy [10, 20, 30]
	 * into it<br>
	 * <br>
	 * {@link #LITTLE}, same indexes will returned<br>
	 * {@link #BIG}:<br>
	 * index = 0, return 2, -> [0, 0, 10, 20, 30]<br>
	 * index = 1, return 1, -> [0, 10, 20, 30, 0]<br>
	 * index = 2, return 0, -> [10, 20, 30, 0, 0]<br>
	 * index = 3, return -1, -> 10, [20, 30, 0, 0, 0] violation, expansion
	 * required<br>
	 * index = 4, return -2, -> 10, 20, [30, 0, 0, 0, 0] violation, expansion
	 * required<br>
	 * <br>
	 * 
	 * @param index
	 * @param insertionLength the insertion length
	 * @param capacity        the length of the array
	 */
	int insertIndex(int index, int len, int capacity, int insertionLength);

	/**
	 * @param from     inclusive from index
	 * @param to       exclusive to index
	 * @param len      the calculated length of the array
	 * @param capacity the full length of the array, e.g: arr.length
	 */
	int from(int from, int to, int len, int capacity);

	/**
	 * @param from     inclusive from index
	 * @param to       exclusive to index
	 * @param len      the calculated length of the array
	 * @param capacity the full length of the array, e.g: arr.length
	 */
	int to(int from, int to, int len, int capacity);


	int msb(int[] mag, int len);

	int lsb(int[] mag, int len);

	boolean isLittle();

	boolean isBig();

	ByteOrder toByteOrder();

	Endian flip();

	/**
	 * @return integer that represent the direction of an endian,
	 *         {@link Endian#LITTLE} returns 1, and {@link Endian#BIG} returns -1
	 */
	int direction();
}
