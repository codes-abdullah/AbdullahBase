package codes.abdullah.digits;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;

public final class NumberComparator implements Comparator<Number> {
	public static final NumberComparator INSTANCE = new NumberComparator();

	private NumberComparator() {
	}

	@Override
	public int compare(Number o1, Number o2) {
		Class<?> o1c = o1.getClass();
		Class<?> o2c = o2.getClass();
		if (o1c == o2c) {
			if (o1 instanceof BigDecimal) {
				return ((BigDecimal) o1).compareTo((BigDecimal) o2);
			} else if (o2 instanceof BigInteger) {
				return ((BigInteger) o1).compareTo((BigInteger) o2);
			}
			return Double.compare(o1.doubleValue(), o2.doubleValue());
		} else if (o1 instanceof BigDecimal || o2 instanceof BigDecimal) {
			return NumberUtils.toBigDecimal(o1).compareTo(NumberUtils.toBigDecimal(o2));
		} else if (o1 instanceof BigInteger || o2 instanceof BigInteger) {
			return NumberUtils.toBigInteger(o1).compareTo(NumberUtils.toBigInteger(o2));
		} else if (o1 instanceof Double || o2 instanceof Double) {
			return Double.compare(o1.doubleValue(), o2.doubleValue());
		} else if (o1 instanceof Float || o2 instanceof Float) {
			return Float.compare(o1.floatValue(), o2.floatValue());
		}
		return Long.compare(o1.longValue(), o2.longValue());
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
