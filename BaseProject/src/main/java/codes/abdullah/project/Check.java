package codes.abdullah.project;

import codes.abdullah.digits.Digits;
import codes.abdullah.project.lang.Lang;

public class Check {

	private Check() {
	}

	// =================================================
	// =================================================
	// =================== require above or equals zero
	// =================================================
	// =================================================

	/**
	 * @see #aboveOrEqualsZero(double, CharSequence)
	 */
	public static int aboveOrEqualsZero(int n) {
		return aboveOrEqualsZero(n, null);
	}

	/**
	 * @see #aboveOrEqualsZero(double, CharSequence)
	 */
	public static int aboveOrEqualsZero(int n, CharSequence msg) {
		if (n < 0) {
			throw new IllegalArgumentException(String.format("%d < 0, %s", n, nonull(msg)));
		}
		return n;
	}

	/**
	 * @see #aboveOrEqualsZero(double, CharSequence)
	 */
	public static long aboveOrEqualsZero(long n) {
		return aboveOrEqualsZero(n, null);
	}

	/**
	 * @see #aboveOrEqualsZero(double, CharSequence)
	 */
	public static long aboveOrEqualsZero(long n, CharSequence msg) {
		if (n < 0) {
			throw new IllegalArgumentException(String.format("%d < 0, %s", n, nonull(msg)));
		}
		return n;
	}

	/**
	 * @see #aboveOrEqualsZero(double, CharSequence)
	 */
	public static float aboveOrEqualsZero(float n) {
		return aboveOrEqualsZero(n, null);
	}

	/**
	 * @see #aboveOrEqualsZero(double, CharSequence)
	 */
	public static float aboveOrEqualsZero(float n, CharSequence msg) {
		if (n < 0) {
			throw new IllegalArgumentException(String.format("%f < 0, %s", n, nonull(msg)));
		}
		return n;
	}

	/**
	 * @see #aboveOrEqualsZero(double, CharSequence)
	 */
	public static double aboveOrEqualsZero(double n) {
		return aboveOrEqualsZero(n, null);
	}

	/**
	 * @throws IllegalArgumentException if n < 0
	 */
	public static double aboveOrEqualsZero(double n, CharSequence msg) {
		if (n < 0) {
			throw new IllegalArgumentException(String.format("%f < 0, %s", n, nonull(msg)));
		}
		return n;
	}

	// =================================================
	// =================================================
	// =================== require above zero
	// =================================================
	// =================================================

	/**
	 * @see #aboveZero(double, CharSequence)
	 */
	public static int aboveZero(int n) {
		return aboveZero(n, null);
	}

	/**
	 * @see #aboveZero(double, CharSequence)
	 */
	public static int aboveZero(int n, CharSequence msg) {
		if (n <= 0) {
			throw new IllegalArgumentException(String.format("%d <= 0, %s", n, nonull(msg)));
		}
		return n;
	}

	/**
	 * @see #aboveZero(double, CharSequence)
	 */
	public static long aboveZero(long n) {
		return aboveZero(n, null);
	}

	/**
	 * @see #aboveZero(double, CharSequence)
	 */
	public static long aboveZero(long n, CharSequence msg) {
		if (n <= 0) {
			throw new IllegalArgumentException(String.format("%d <= 0, %s", n, nonull(msg)));
		}
		return n;
	}

	/**
	 * @see #aboveZero(double, CharSequence)
	 */
	public static float aboveZero(float n) {
		return aboveZero(n, null);
	}

	/**
	 * @see #aboveZero(double, CharSequence)
	 */
	public static float aboveZero(float n, CharSequence msg) {
		if (n <= 0) {
			throw new IllegalArgumentException(String.format("%f <= 0, %s", n, nonull(msg)));
		}
		return n;
	}

	/**
	 * @see #aboveZero(double, CharSequence)
	 */
	public static double aboveZero(double n) {
		return aboveZero(n, null);
	}

	/**
	 * @throws IllegalArgumentException if n <= 0
	 */
	public static double aboveZero(double n, CharSequence msg) {
		if (n <= 0) {
			throw new IllegalArgumentException(String.format("%f <= 0, %s", n, nonull(msg)));
		}
		return n;
	}

	// =================================================
	// =================================================
	// =================== between
	// =================================================
	// =================================================

	/**
	 * @see #between(double, double, double, CharSequence)
	 */
	public static int between(int n, int min, int max) {
		return between(n, min, max, null);
	}

	/**
	 * @see #between(double, double, double, CharSequence)
	 */
	public static int between(int n, int min, int max, CharSequence msg) {
		if (n < min)
			throw new IllegalArgumentException(String.format("%f < min(%f), %s", n, min, nonull(msg)));
		else if (n > max)
			throw new IllegalArgumentException(String.format("%f > max(%f), %s", n, max, nonull(msg)));
		return n;
	}

	/**
	 * @see #between(double, double, double, CharSequence)
	 */
	public static long between(long n, long min, long max) {
		return between(n, min, max, null);
	}

	/**
	 * @see #between(double, double, double, CharSequence)
	 */
	public static long between(long n, long min, long max, CharSequence msg) {
		if (n < min)
			throw new IllegalArgumentException(String.format("%f < min(%f), %s", n, min, nonull(msg)));
		else if (n > max)
			throw new IllegalArgumentException(String.format("%f > max(%f), %s", n, max, nonull(msg)));
		return n;
	}

	/**
	 * @see #between(double, double, double, CharSequence)
	 */
	public static float between(float n, float min, float max) {
		return between(n, min, max, null);
	}

	/**
	 * @see #between(double, double, double, CharSequence)
	 */
	public static float between(float n, float min, float max, CharSequence msg) {
		if (n < min)
			throw new IllegalArgumentException(String.format("%f < min(%f), %s", n, min, nonull(msg)));
		else if (n > max)
			throw new IllegalArgumentException(String.format("%f > max(%f), %s", n, max, nonull(msg)));
		return n;
	}

	/**
	 * @see #between(double, double, double, CharSequence)
	 */
	public static double between(double n, double min, double max) {
		return between(n, min, max, null);
	}

	/**
	 * @throws IllegalArgumentException if n < min || n > max
	 */
	public static double between(double n, double min, double max, CharSequence msg) {
		if (n < min)
			throw new IllegalArgumentException(String.format("%f < min(%f), %s", n, min, nonull(msg)));
		else if (n > max)
			throw new IllegalArgumentException(String.format("%f > max(%f), %s", n, max, nonull(msg)));
		return n;
	}

	// =================================================
	// =================================================
	// ===================
	// =================================================
	// =================================================

	/**
	 * @throws IllegalArgumentException if
	 *                                  {@link isBmpCodePoint#isValidCodePoint(int)}
	 *                                  returns false
	 * @return cp
	 */
	public static int bmp(int cp) {
		return codePoint(cp, CodepointSupport.SUPPORTED);
	}

	/**
	 * @throws IllegalArgumentException if {@link Character#isValidCodePoint(int)}
	 *                                  returns false
	 * @return cp
	 */
	public static int codePoint(int cp) {
		return codePoint(cp, CodepointSupport.SUPPORTED);
	}

	/**
	 * @throws IllegalArgumentException if
	 *                                  {@link isBmpCodePoint#isValidCodePoint(int)}
	 *                                  returns false
	 * @return codePoint
	 */
	public static int bmp(int cp, CodepointSupport cps) {
		if (!cps.isBmp(cp)) {
			throw new IllegalArgumentException(String.format("not valid BMP, found: %s", cp));
		}
		return cp;
	}

	/**
	 * @throws IllegalArgumentException if {@link Character#isValidCodePoint(int)}
	 *                                  returns false
	 * @return codePoint
	 */
	public static int codePoint(int cp, CodepointSupport cps) {
		if (!cps.isValid(cp)) {
			throw new IllegalArgumentException(
					String.format("not valid code-point, found: %s, implementer: %s", cp, cps));
		}
		return cp;
	}

	// =================================================
	// =================================================
	// ===================
	// =================================================
	// =================================================

	/**
	 * Default from: 0<br>
	 * Default to: cs.length()<br>
	 * Default radix: 10<br>
	 * 
	 * @see #numbersRange(CharSequence, int, int, int)
	 */
	public static CharSequence integer(CharSequence cs) {
		return integer(cs, 0);
	}

	/**
	 * Default to: cs.length()<br>
	 * Default radix: 10<br>
	 * 
	 * @see #integer(CharSequence, int, int, int)
	 */
	public static CharSequence integer(CharSequence cs, int from) {
		return integer(cs, from, cs.length());
	}

	/**
	 * Default radix: 10<br>
	 * 
	 * @see #integer(CharSequence, int, int, int)
	 */
	public static CharSequence integer(CharSequence cs, int from, int to) {
		return integer(cs, from, to, 10);
	}

	/**
	 * @throws NumberFormatException if given cs contains non numbers only
	 * @return cs
	 * @see Digits#parseIntRange(CharSequence, int, int, int)
	 */
	public static CharSequence integer(CharSequence cs, int from, int to, int radix) {
		try {
			Digits.ints.parse(cs, from, to, radix);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("detect non digits in: " + cs);
		}
		return cs;
	}

	// =================================================
	// =================================================
	// ===================
	// =================================================
	// =================================================

	/**
	 * useful tool for loops while working with arraies and indexes, this tool does
	 * not do iteration over the array, instead it will only check if
	 * <b>indexes[current] <= indexes[0]</b>, will throw
	 * {@link IllegalArgumentException} <br>
	 * <b>current</b>: must be the loop index
	 */
	public static void unsortedIndexes(int[] indexes, int current) {
		if (current > 0 && indexes[current] <= indexes[0]) {
			throw new IllegalArgumentException(String.format(
					"indexes[%s](%s) <= indexes[0](%s), consider passing a sorted array to avoid this exception",
					current, indexes[current], indexes[0]));
		}
	}

	// =================================================
	// =================================================
	// =================== range
	// =================================================
	// =================================================
	/**
	 * Default min: 0<br>
	 * Default max: {@link Integer#MAX_VALUE}<br>
	 * 
	 * @see #range(int, int, int, int, CharSequence)
	 */
	public static void range(int from, int to) {
		range(from, to, Integer.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #range(int, int, int, int, CharSequence)
	 */
	public static void range(int from, int to, int max) {
		range(from, to, max, 0);
	}

	/**
	 * @see #range(int, int, int, int, CharSequence)
	 */
	public static void range(int from, int to, int max, int min) {
		range(from, to, max, min, null);
	}

	/**
	 * @throws IndexOutOfBoundsException from < min || to > max || from >= to
	 */
	public static void range(int from, int to, int max, int min, CharSequence msg) {
		if (from < min) {
			throw new IndexOutOfBoundsException(String.format("from(%d) < min(%d), %s", from, min, nonull(msg)));
		} else if (to > max) {
			throw new IndexOutOfBoundsException(String.format("to(%d) > max(%d), %s", to, max, nonull(msg)));
		} else if (from >= to) {
			throw new IndexOutOfBoundsException(String.format("from(%d) >= to(%d), %s", from, to, nonull(msg)));
		}
	}

	/**
	 * Default min: 0<br>
	 * Default max: {@link Long#MAX_VALUE}<br>
	 * 
	 * @see #range(long, long, long, long, CharSequence)
	 */
	public static void range(long from, long to) {
		range(from, to, Long.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #range(long, long, long, long, CharSequence)
	 */
	public static void range(long from, long to, long max) {
		range(from, to, max, 0);
	}

	/**
	 * @see #range(long, long, long, long, CharSequence)
	 */
	public static void range(long from, long to, long max, long min) {
		range(from, to, max, min, null);
	}

	/**
	 * @throws IllegalArgumentException from < min || to > max || from >= to
	 */
	public static void range(long from, long to, long max, long min, CharSequence msg) {
		if (from < min) {
			throw new IllegalArgumentException(String.format("from(%d) < min(%d), %s", from, min, nonull(msg)));
		} else if (to > max) {
			throw new IllegalArgumentException(String.format("to(%d) > max(%d), %s", to, max, nonull(msg)));
		} else if (from >= to) {
			throw new IllegalArgumentException(String.format("from(%d) >= to(%d), %s", from, to, nonull(msg)));
		}
	}

	/**
	 * Default min: 0<br>
	 * Default max: {@link Float#MAX_VALUE}<br>
	 * 
	 * @see #range(float, float, float, float, CharSequence)
	 */
	public static void range(float from, float to) {
		range(from, to, Float.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #range(float, float, float, float, CharSequence)
	 */
	public static void range(float from, float to, float max) {
		range(from, to, max, 0);
	}

	/**
	 * @see #range(float, float, float, float, CharSequence)
	 */
	public static void range(float from, float to, float max, float min) {
		range(from, to, max, min, null);
	}

	/**
	 * @throws IllegalArgumentException from < min || to > max || from >= to
	 */
	public static void range(float from, float to, float max, float min, CharSequence msg) {
		if (from < min) {
			throw new IllegalArgumentException(String.format("from(%d) < min(%d), %s", from, min, nonull(msg)));
		} else if (to > max) {
			throw new IllegalArgumentException(String.format("to(%d) > max(%d), %s", to, max, nonull(msg)));
		} else if (from >= to) {
			throw new IllegalArgumentException(String.format("from(%d) >= to(%d), %s", from, to, nonull(msg)));
		}
	}

	/**
	 * Default min: 0<br>
	 * Default max: {@link Double#MAX_VALUE}<br>
	 * 
	 * @see #range(double, double, double, double, CharSequence)
	 */
	public static void range(double from, double to) {
		range(from, to, Double.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #range(double, double, double, double, CharSequence)
	 */
	public static void range(double from, double to, double max) {
		range(from, to, max, 0);
	}

	/**
	 * @see #range(double, double, double, double, CharSequence)
	 */
	public static void range(double from, double to, double max, double min) {
		range(from, to, max, min, null);
	}

	/**
	 * @throws IllegalArgumentException from < min || to > max || from >= to
	 */
	public static void range(double from, double to, double max, double min, CharSequence msg) {
		if (from < min) {
			throw new IllegalArgumentException(String.format("from(%d) < min(%d), %s", from, min, nonull(msg)));
		} else if (to > max) {
			throw new IllegalArgumentException(String.format("to(%d) > max(%d), %s", to, max, nonull(msg)));
		} else if (from >= to) {
			throw new IllegalArgumentException(String.format("from(%d) >= to(%d), %s", from, to, nonull(msg)));
		}
	}

	/**
	 * Default min: 0<br>
	 * Default max: {@link Integer#MAX_VALUE}<br>
	 * 
	 * @see #isValidRange(int, int, int, int)
	 */
	public static boolean isValidRange(int from, int to) {
		return isValidRange(from, to, Integer.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #isValidRange(int, int, int, int)
	 */
	public static boolean isValidRange(int from, int to, int max) {
		return isValidRange(from, to, max, 0);
	}

	/**
	 * @return true if from >= min && from < to && to < max
	 */
	public static boolean isValidRange(int from, int to, int max, int min) {
		return from >= min && from < to && to <= max;
	}

	/**
	 * Default min: 0<br>
	 * Default max: {@link Long#MAX_VALUE}<br>
	 * 
	 * @see #isValidRange(long, long, long, long)
	 */
	public static boolean isValidRange(long from, long to) {
		return isValidRange(from, to, Long.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #isValidRange(long, long, long, long)
	 */
	public static boolean isValidRange(long from, long to, long max) {
		return isValidRange(from, to, max, 0);
	}

	/**
	 * @return true if from >= min && from < to && to < max
	 */
	public static boolean isValidRange(long from, long to, long max, long min) {
		return from >= min && from < to && to <= max;
	}

	/**
	 * Default min: 0<br>
	 * Default max: {@link Float#MAX_VALUE}<br>
	 * 
	 * @see #isValidRange(float, float, float, float)
	 */
	public static boolean isValidRange(float from, float to) {
		return isValidRange(from, to, Float.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #isValidRange(float, float, float, float)
	 */
	public static boolean isValidRange(float from, float to, float max) {
		return isValidRange(from, to, max, 0);
	}

	/**
	 * @return true if from >= min && from < to && to < max
	 */
	public static boolean isValidRange(float from, float to, float max, float min) {
		return from >= min && from < to && to <= max;
	}

	/**
	 * Default min: 0<br>
	 * Default max: {@link Double#MAX_VALUE}<br>
	 * 
	 * @see #isValidRange(double, double, double, double)
	 */
	public static boolean isValidRange(double from, double to) {
		return isValidRange(from, to, Double.MAX_VALUE);
	}

	/**
	 * Default min: 0<br>
	 * 
	 * @see #isValidRange(double, double, double, double)
	 */
	public static boolean isValidRange(double from, double to, double max) {
		return isValidRange(from, to, max, 0);
	}

	/**
	 * @return true if from >= min && from < to && to < max
	 */
	public static boolean isValidRange(double from, double to, double max, double min) {
		return from >= min && from < to && to <= max;
	}

	// =================================================
	// =================================================
	// =================== index
	// =================================================
	// =================================================

	/**
	 * Default max: {@link Integer#MAX_VALUE}
	 * 
	 * @see #index(int, int, CharSequence)
	 */
	public static int index(int index) {
		return index(index, Integer.MAX_VALUE);
	}

	/**
	 * @see #index(int, int, CharSequence)
	 */
	public static int index(int index, int max) {
		return index(index, max, null);
	}

	/**
	 * @throws IndexOutOfBoundsException if index < 0 or index >= max
	 * @return index
	 */
	public static int index(int index, int max, CharSequence msg) {
		if (index < 0) {
			throw new IndexOutOfBoundsException(String.format("index(%d) < 0, %s", index, nonull(msg)));
		} else if (index >= max) {
			throw new IndexOutOfBoundsException(String.format("index(%d) >= max(%d), %s", index, max, nonull(msg)));
		}
		return index;
	}

	/**
	 * Default max: {@link Integer#MAX_VALUE}
	 * 
	 * @see #isValidIndex(int, int)
	 */
	public static boolean isValidIndex(int index) {
		return isValidIndex(index, Integer.MAX_VALUE);
	}

	/**
	 * @return true if index >= 0 && index < max
	 */
	public static boolean isValidIndex(int index, int max) {
		return index >= 0 && index < max;
	}

	// =================================================
	// =================================================
	// =================== insert index
	// =================================================
	// =================================================

	/**
	 * @see #insertIndex(int, int, CharSequence)
	 */
	public static int insertIndex(int index, int max) {
		return insertIndex(index, max, null);
	}

	/**
	 * @throws IndexOutOfBoundsException if index > max || index < 0
	 * @return index
	 */
	public static int insertIndex(int index, int max, CharSequence msg) {
		if (index > max || index < 0)
			throw new IndexOutOfBoundsException(
					String.format("index(%d) > max(%d) || index < 0, %s", index, max, nonull(msg)));
		return index;
	}

	/**
	 * @return true if index >= 0 && index <= max
	 */
	public static boolean isValidInsertIndex(int index, int max) {
		return index >= 0 && index <= max;
	}

	/**
	 * @see #insertLengthAt(int, int, int, CharSequence)
	 */
	public static int insertLengthAt(int index, int insertLength, int max) {
		return insertLengthAt(index, insertLength, max, null);
	}

	/**
	 * @return true if (index >= 0 && index <= max) && (index + length <= max)
	 */
	public static boolean isValidInsertLengthAt(int index, int insertLength, int max) {
		return (index >= 0 && index <= max) && (index + insertLength > max);
	}

	/**
	 * Check if <code>index</code> within range of 0 to <code>max</code>
	 * inclusively, and <code>length</code> can be inserted at given
	 * <code>index</code> without exceeding <code>max</code>
	 * 
	 * @throws IndexOutOfBoundsException if index > max || index < 0
	 * @throws IndexOutOfBoundsException if index + length > max
	 * @return index
	 */
	public static int insertLengthAt(int index, int insertLength, int max, CharSequence msg) {
		if (index > max || index < 0)
			throw new IndexOutOfBoundsException(
					String.format("index(%d) > max(%d) || index < 0, %s", index, max, nonull(msg)));
		else if (index + insertLength > max)
			throw new IndexOutOfBoundsException(
					String.format("index(%d) + length(%d) > max(%d), %s", index, insertLength, max, nonull(msg)));
		return index;
	}

	// =================================================
	// =================================================
	// =================== Numeric
	// =================================================
	// =================================================

	public static boolean isValidNumeric(char[] arr, int len) {
		return isValidNumeric(arr, len, 10);
	}

	public static boolean isValidNumeric(char[] arr, int len, int radix) {
		return isValidNumeric(arr, len, radix, 0);
	}

	public static boolean isValidNumeric(char[] arr, int len, int radix, int from) {
		return isValidNumeric(arr, len, radix, from, len);
	}

	/**
	 * Validate if given string is valid numeric<br>
	 * [TEST]
	 * 
	 * <pre>
	 * </pre>
	 */
	public static boolean isValidNumeric(char[] arr, int len, int radix, int from, int to) {
		if (len == 0)
			return false;

		int floatAt = -1;

		// .123
		if (arr[from] == '.')
			floatAt = from++;

		// -123
		if (arr[from] == '-') {
			// .-123 not ok
			if (floatAt != -1)
				return false;
			// -.123 is ok
			if (arr[from] == '.')
				floatAt = from++;
		}

		if (len == 0 || Character.digit(arr[from], radix) == -1) {
			return false;
		}

		for (; from < to; from++) {
			if (floatAt == -1 && arr[from] == '.') {
				floatAt = from;
				continue;
			}

			if (Character.digit(arr[from], radix) == -1) {
				return false;
			}
		}

		return true;
	}

	// =================================================
	// =================================================
	// =================== length
	// =================================================
	// =================================================

	/**
	 * Default min: 1<br>
	 * Default max: {@link Lang#ARRAY_SAFE_CAPACITY}<br>
	 * 
	 * @see #length(int, int, int, CharSequence)
	 */
	public static int length(int length) {
		return length(length, 1);
	}

	/**
	 * Default max: {@link Lang#ARRAY_SAFE_CAPACITY}<br>
	 * 
	 * @see #length(int, int, int, CharSequence)
	 */
	public static int length(int length, int min) {
		return length(length, min, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @see #length(int, int, int, CharSequence)
	 */
	public static int length(int length, int min, int max) {
		return length(length, min, max, null);
	}

	/**
	 * @throws IllegalArgumentException if length < min || length > max
	 */
	public static int length(int length, int min, int max, CharSequence msg) {
		if (length < min || length > max) {
			throw new IllegalArgumentException(
					String.format("length(%d) < min(%d) || length >= max(%d), %s", length, min, max, nonull(msg)));
		}
		return length;
	}

	/**
	 * @see #isValidLength(int, int, int)
	 */
	public static boolean isValidLength(int length) {
		return isValidLength(length, 1);
	}

	/**
	 * @see #isValidLength(int, int, int)
	 */
	public static boolean isValidLength(int length, int min) {
		return isValidLength(length, min, Lang.constant.ARRAY_SAFE_CAPACITY);
	}

	/**
	 * @return true if length >= min && length < max
	 */
	public static boolean isValidLength(int length, int min, int max) {
		return length >= min && length < max;
	}

	// =================================================
	// =================================================
	// =================== bit size
	// =================================================
	// =================================================

	/**
	 * @see #bitSize(int, CharSequence)
	 */
	public static int bitSize(int size) {
		return bitSize(size, null);
	}

	/**
	 * @throws IllegalArgumentException if size < 1
	 * @return size
	 */
	public static int bitSize(int size, CharSequence msg) {
		if (size < 1) {
			throw new IllegalArgumentException(String.format("size(%d) < 1, %s", size, nonull(msg)));
		}
		return size;
	}

	/**
	 * @return true if size > 0
	 */
	public boolean isValidBitSize(int size) {
		return size > 0;
	}
	// =================================================
	// =================================================
	// =================== radix
	// =================================================
	// =================================================

	/**
	 * @see #radix(int, CharSequence)
	 */
	public static int radix(int radix) {
		return radix(radix, null);
	}

	/**
	 * @throws NumberFormatException if radix < {@link Character#MIN_RADIX} or radix
	 *                               > {@link Character#MAX_RADIX}
	 * @return radix
	 */
	public static int radix(int radix, CharSequence msg) {
		if (radix < Character.MIN_RADIX) {
			throw new NumberFormatException(
					String.format("radix(%d) < Character.MIN_RADIX(%d), %s", radix, Character.MIN_RADIX, nonull(msg)));
		}
		if (radix > Character.MAX_RADIX) {
			throw new NumberFormatException(
					String.format("radix(%d) > Character.MAX_RADIX(%d), %s", radix, Character.MAX_RADIX, nonull(msg)));
		}
		return radix;
	}

	/**
	 * @return true if radix >= {@link Character#MIN_RADIX} || radix <=
	 *         {@link Character#MAX_RADIX}
	 */
	public boolean isValidRadix(int radix) {
		return radix >= Character.MIN_RADIX || radix <= Character.MAX_RADIX;
	}

	// =================================================
	// =================================================
	// =================== capacity
	// =================================================
	// =================================================

	/**
	 * @see #capacity(int, int, CharSequence)
	 */
	public static int capacity(int capacity, int required) {
		return capacity(capacity, required, null);
	}

	/**
	 * @return capacity
	 * @throws IndexOutOfBoundsException if capacity < required
	 */
	public static int capacity(int capacity, int required, CharSequence msg) {
		if (capacity < required)
			throw new IndexOutOfBoundsException(
					String.format("capacity(%d) < required(%d), %s", capacity, required, nonull(msg)));
		return capacity;
	}

	// -----------------

	private static CharSequence nonull(CharSequence msg) {
		return msg == null ? "" : msg;
	}

	public static void checkCopy(int arrlen, int len, int readFrom, int readTo, int newLength, int writeAtIndex) {
		Check.range(readFrom, readTo, len);
		Check.capacity(newLength, readTo - readFrom);
		Check.index(writeAtIndex, newLength);

	}

}
