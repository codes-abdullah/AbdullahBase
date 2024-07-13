package codes.abdullah.digits;

import java.util.Comparator;

/**
 * Simple algorithm to compare instance-level of Number implementation<br>
 * 
 * <pre>
 * Byte vs Byte = 0
 * Byte vs Short = -1
 * Byte vs Integer = -2
 * Byte vs Long = -3
 * Byte vs Float = -4
 * Byte vs Double = -5
 * Byte vs BigInteger = -6
 * Byte vs BigDecimal = -7

 * Short vs Byte = 1
 * Short vs Short = 0
 * Short vs Integer = -1
 * Short vs Long = -2
 * Short vs Float = -3
 * Short vs Double = -4
 * Short vs BigInteger = -5
 * Short vs BigDecimal = -6

 * Integer vs Byte = 2
 * Integer vs Short = 1
 * Integer vs Integer = 0
 * Integer vs Long = -1
 * Integer vs Float = -2
 * Integer vs Double = -3
 * Integer vs BigInteger = -4
 * Integer vs BigDecimal = -5

 * Long vs Byte = 3
 * Long vs Short = 2
 * Long vs Integer = 1
 * Long vs Long = 0
 * Long vs Float = -1
 * Long vs Double = -2
 * Long vs BigInteger = -3
 * Long vs BigDecimal = -4

 * Float vs Byte = 4
 * Float vs Short = 3
 * Float vs Integer = 2
 * Float vs Long = 1
 * Float vs Float = 0
 * Float vs Double = -1
 * Float vs BigInteger = -2
 * Float vs BigDecimal = -3

 * Double vs Byte = 5
 * Double vs Short = 4
 * Double vs Integer = 3
 * Double vs Long = 2
 * Double vs Float = 1
 * Double vs Double = 0
 * Double vs BigInteger = -1
 * Double vs BigDecimal = -2

 * BigInteger vs Byte = 6
 * BigInteger vs Short = 5
 * BigInteger vs Integer = 4
 * BigInteger vs Long = 3
 * BigInteger vs Float = 2
 * BigInteger vs Double = 1
 * BigInteger vs BigInteger = 0
 * BigInteger vs BigDecimal = -1

 * BigDecimal vs Byte = 7
 * BigDecimal vs Short = 6
 * BigDecimal vs Integer = 5
 * BigDecimal vs Long = 4
 * BigDecimal vs Float = 3
 * BigDecimal vs Double = 2
 * BigDecimal vs BigInteger = 1
 * BigDecimal vs BigDecimal = 0
 * 
 * 
 * </pre>
 */
public final class NumberInstanceLevelComparator implements Comparator<Number> {

	
	private static final int[] SUPPORTED_WEIGHTS = { 0, 1, 2, 3, 4, 5, 6, 7 };
	public static final NumberInstanceLevelComparator INSTANCE = new NumberInstanceLevelComparator();

	private NumberInstanceLevelComparator() {
		if (NumberUtils.SUPPORTED_CLASSES.length != SUPPORTED_WEIGHTS.length) {
			throw new IllegalStateException("SUPPORTED_NUMBERS.length != SUPPORTED_WEIGHTS.length");
		}
	}

	@Override
	public int compare(Number n1, Number n2) {
		int w1 = findWeight(n1);
		int w2 = findWeight(n2);
		return Integer.compare(w1, w2);
	}

	private static int findWeight(Number n) {
		Class<?> c1 = n.getClass();
		for (int i = 0; i < NumberUtils.SUPPORTED_CLASSES.length; i++) {
			if (c1.equals(NumberUtils.SUPPORTED_CLASSES[i])) {
				return SUPPORTED_WEIGHTS[i];
			}
		}
		throw new UnsupportedOperationException(c1.getName());
	}

	public static boolean eq(Number n1, Number n2) {
		return INSTANCE.compare(n1, n2) == 0;
	}

	public static boolean notEq(Number n1, Number n2) {
		return INSTANCE.compare(n1, n2) != 0;
	}

	public static boolean lt(Number n1, Number n2) {
		return INSTANCE.compare(n1, n2) < 0;
	}

	public static boolean ltOrEq(Number n1, Number n2) {
		return INSTANCE.compare(n1, n2) <= 0;
	}

	public static boolean gt(Number n1, Number n2) {
		return INSTANCE.compare(n1, n2) > 0;
	}

	public static boolean gtOrEq(Number n1, Number n2) {
		return INSTANCE.compare(n1, n2) >= 0;
	}

	public static Number max(Number n1, Number n2) {
		return gtOrEq(n1, n2) ? n1 : n2;
	}

	public static Number min(Number n1, Number n2) {
		return ltOrEq(n1, n2) ? n1 : n2;
	}

}
