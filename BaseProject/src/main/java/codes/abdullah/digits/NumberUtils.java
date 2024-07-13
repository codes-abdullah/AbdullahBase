package codes.abdullah.digits;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberUtils {

	/**
	 * bit-size safe and fast to be used to calculate max/min of bigs
	 */
	private static final int BIG_SIZE = 128;
	static final Class<?>[] SUPPORTED_INTEGERS = { Byte.class, Short.class, Integer.class, Long.class,
			BigInteger.class };
	static final Class<?>[] SUPPORTED_DECIMALS = { Float.class, Double.class, BigDecimal.class };
	static final Class<?>[] SUPPORTED_CLASSES = { Byte.class, Short.class, Integer.class, Long.class, Float.class,
			Double.class, BigInteger.class, BigDecimal.class };

	public static boolean eq(Number n1, Number n2) {
		return NumberComparator.eq(n1, n2);
	}

	public static boolean notEq(Number n1, Number n2) {
		return NumberComparator.notEq(n1, n2);
	}

	public static boolean lt(Number n1, Number n2) {
		return NumberComparator.lt(n1, n2);
	}

	public static boolean ltOrEq(Number n1, Number n2) {
		return NumberComparator.ltOrEq(n1, n2);
	}

	public static boolean gt(Number n1, Number n2) {
		return NumberComparator.gt(n1, n2);
	}

	public static boolean gtOrEq(Number n1, Number n2) {
		return NumberComparator.gtOrEq(n1, n2);
	}

	public static Number randomNumber() {
		return Digits.RANDOM.nextBoolean() ? randomInteger() : randomDecimal();
	}

	public static Number randomInteger() {
		Class<?> cls = SUPPORTED_INTEGERS[Digits.ints.random(0, SUPPORTED_INTEGERS.length)];
		Number n = newInstance(cls);
		int size = sizeOf(n);
		RandomRadix rr = new RandomRadix(10, size, false);
		String s = rr.next();
		if (n instanceof Byte) {
			return Byte.valueOf((byte) Digits.ints.parse(s));
		} else if (n instanceof Short) {
			return Short.valueOf((short) Digits.ints.parse(s));
		} else if (n instanceof Integer) {
			return Integer.valueOf(Digits.ints.parse(s));
		} else if (n instanceof Long) {
			return Long.valueOf(Digits.longs.parse(s));
		} else if (n instanceof BigInteger)
			return new BigInteger(s);
		throw new UnsupportedOperationException(cls.getName());
	}

	public static Number randomDecimal() {
		Class<?> cls = SUPPORTED_DECIMALS[Digits.ints.random(0, SUPPORTED_DECIMALS.length)];
		Number n = newInstance(cls);
		int size = sizeOf(n);
		RandomRadix rr = new RandomRadix(10, size, true);
		String s = rr.next();
		if (n instanceof Float) {
			return Float.parseFloat(s);
		} else if (n instanceof Double) {
			return Double.parseDouble(s);
		} else if (n instanceof BigDecimal) {
			return new BigDecimal(s);
		}
		throw new UnsupportedOperationException(cls.getName());
	}

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 1024; i++) {
//			System.out.println(randomNumber());
		}
//		System.out.println(Float.parseFloat("FF"));
//		randomNumber();
//		System.out.println(maxValue(new BigInteger("0")));
		
		double d = 10;
		byte l = 10;
		System.out.println(Long.compare((long) d, l));
		System.out.println(Float.compare( (float) d, l));
		System.out.println(Double.compare( d, l));
		

	}

	public static Number crop(Number n, int size) {
		if (size == Byte.SIZE) {
			return n.byteValue();
		} else if (size == Short.SIZE) {
			return n.shortValue();
		} else if (size == Integer.SIZE) {
			return n.intValue();
		} else if (size == Long.SIZE) {
			return n.longValue();
		} else if (size == Float.SIZE) {
			return n.floatValue();
		} else if (size == Double.SIZE) {
			return n.doubleValue();
		} else {
			throw new UnsupportedOperationException(n.getClass().getName());
		}
	}

	private static final char ADD = '+';
	private static final char SUBTRACT = '-';
	private static final char MULTIPLY = '*';
	private static final char DIVIDE = '/';
	private static final char REMAINDER = '%';
	private static final char SHIFT_LEFT = '<';
	private static final char SHIFT_RIGHT = '>';
	private static final char UNSIGNED_SHIFT_RIGHT = '}';
	private static final char AND = '&';
	private static final char AND_NOT = '@';
	private static final char NOT = '~';
	private static final char OR = '|';
	private static final char XOR = '^';

	private static Byte optByte(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return Byte.valueOf((byte) (n1.byteValue() + n2.byteValue()));
		case SUBTRACT:
			return Byte.valueOf((byte) (n1.byteValue() - n2.byteValue()));
		case MULTIPLY:
			return Byte.valueOf((byte) (n1.byteValue() * n2.byteValue()));
		case DIVIDE:
			return Byte.valueOf((byte) (n1.byteValue() / n2.byteValue()));
		case REMAINDER:
			return Byte.valueOf((byte) (n1.byteValue() % n2.byteValue()));
		case SHIFT_LEFT:
			return Byte.valueOf((byte) (n1.byteValue() << n2.byteValue()));
		case SHIFT_RIGHT:
			return Byte.valueOf((byte) (n1.byteValue() >> n2.byteValue()));
		case UNSIGNED_SHIFT_RIGHT:
			return Byte.valueOf((byte) (n1.byteValue() >>> n2.byteValue()));
		case AND:
			return Byte.valueOf((byte) (n1.byteValue() & n2.byteValue()));
		case AND_NOT:
			return Byte.valueOf((byte) (n1.byteValue() & ~n2.byteValue()));
		case NOT:
			return Byte.valueOf((byte) (~n1.byteValue()));
		case OR:
			return Byte.valueOf((byte) (n1.byteValue() | n2.byteValue()));
		case XOR:
			return Byte.valueOf((byte) (n1.byteValue() ^ n2.byteValue()));
		}

		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static Short optShort(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return Short.valueOf((short) (n1.shortValue() + n2.shortValue()));
		case SUBTRACT:
			return Short.valueOf((short) (n1.shortValue() - n2.shortValue()));
		case MULTIPLY:
			return Short.valueOf((short) (n1.shortValue() * n2.shortValue()));
		case DIVIDE:
			return Short.valueOf((short) (n1.shortValue() / n2.shortValue()));
		case REMAINDER:
			return Short.valueOf((short) (n1.shortValue() % n2.shortValue()));
		case SHIFT_LEFT:
			return Short.valueOf((short) (n1.shortValue() << n2.shortValue()));
		case SHIFT_RIGHT:
			return Short.valueOf((short) (n1.shortValue() >> n2.shortValue()));
		case UNSIGNED_SHIFT_RIGHT:
			return Short.valueOf((short) (n1.shortValue() >>> n2.shortValue()));
		case AND:
			return Short.valueOf((short) (n1.shortValue() & n2.shortValue()));
		case AND_NOT:
			return Short.valueOf((short) (n1.shortValue() & ~n2.shortValue()));
		case NOT:
			return Short.valueOf((short) (~n1.shortValue()));
		case OR:
			return Short.valueOf((short) (n1.shortValue() | n2.shortValue()));
		case XOR:
			return Short.valueOf((short) (n1.shortValue() ^ n2.shortValue()));
		}

		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static Integer optInteger(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return Integer.valueOf((int) (n1.intValue() + n2.intValue()));
		case SUBTRACT:
			return Integer.valueOf((int) (n1.intValue() - n2.intValue()));
		case MULTIPLY:
			return Integer.valueOf((int) (n1.intValue() * n2.intValue()));
		case DIVIDE:
			return Integer.valueOf((int) (n1.intValue() / n2.intValue()));
		case REMAINDER:
			return Integer.valueOf((int) (n1.intValue() % n2.intValue()));
		case SHIFT_LEFT:
			return Integer.valueOf((int) (n1.intValue() << n2.intValue()));
		case SHIFT_RIGHT:
			return Integer.valueOf((int) (n1.intValue() >> n2.intValue()));
		case UNSIGNED_SHIFT_RIGHT:
			return Integer.valueOf((int) (n1.intValue() >>> n2.intValue()));
		case AND:
			return Integer.valueOf((int) (n1.intValue() & n2.intValue()));
		case AND_NOT:
			return Integer.valueOf((int) (n1.intValue() & ~n2.intValue()));
		case NOT:
			return Integer.valueOf((int) (~n1.intValue()));
		case OR:
			return Integer.valueOf((int) (n1.intValue() | n2.intValue()));
		case XOR:
			return Integer.valueOf((int) (n1.intValue() ^ n2.intValue()));
		}

		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static Long optLong(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return Long.valueOf((long) (n1.longValue() + n2.longValue()));
		case SUBTRACT:
			return Long.valueOf((long) (n1.longValue() - n2.longValue()));
		case MULTIPLY:
			return Long.valueOf((long) (n1.longValue() * n2.longValue()));
		case DIVIDE:
			return Long.valueOf((long) (n1.longValue() / n2.longValue()));
		case REMAINDER:
			return Long.valueOf((long) (n1.longValue() % n2.longValue()));
		case SHIFT_LEFT:
			return Long.valueOf((long) (n1.longValue() << n2.longValue()));
		case SHIFT_RIGHT:
			return Long.valueOf((long) (n1.longValue() >> n2.longValue()));
		case UNSIGNED_SHIFT_RIGHT:
			return Long.valueOf((long) (n1.longValue() >>> n2.longValue()));
		case AND:
			return Long.valueOf((long) (n1.longValue() & n2.longValue()));
		case AND_NOT:
			return Long.valueOf((long) (n1.longValue() & ~n2.longValue()));
		case NOT:
			return Long.valueOf((long) (~n1.longValue()));
		case OR:
			return Long.valueOf((long) (n1.longValue() | n2.longValue()));
		case XOR:
			return Long.valueOf((long) (n1.longValue() ^ n2.longValue()));
		}

		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static Float optFloat(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return Float.valueOf((float) (n1.floatValue() + n2.floatValue()));
		case SUBTRACT:
			return Float.valueOf((float) (n1.floatValue() - n2.floatValue()));
		case MULTIPLY:
			return Float.valueOf((float) (n1.floatValue() * n2.floatValue()));
		case DIVIDE:
			return Float.valueOf((float) (n1.floatValue() / n2.floatValue()));
		case REMAINDER:
			return Float.valueOf((float) (n1.floatValue() % n2.floatValue()));
		case SHIFT_LEFT:
		case SHIFT_RIGHT:
		case UNSIGNED_SHIFT_RIGHT:
		case AND:
		case AND_NOT:
		case NOT:
		case OR:
		case XOR:
		}

		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static Double optDouble(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return Double.valueOf((double) (n1.doubleValue() + n2.doubleValue()));
		case SUBTRACT:
			return Double.valueOf((double) (n1.doubleValue() - n2.doubleValue()));
		case MULTIPLY:
			return Double.valueOf((double) (n1.doubleValue() * n2.doubleValue()));
		case DIVIDE:
			return Double.valueOf((double) (n1.doubleValue() / n2.doubleValue()));
		case REMAINDER:
			return Double.valueOf((double) (n1.doubleValue() % n2.doubleValue()));
		case SHIFT_LEFT:
		case SHIFT_RIGHT:
		case UNSIGNED_SHIFT_RIGHT:
		case AND:
		case AND_NOT:
		case NOT:
		case OR:
		case XOR:
		}

		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static BigInteger optBigInteger(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return toBigInteger(n1).add(toBigInteger(n2));
		case SUBTRACT:
			return toBigInteger(n1).subtract(toBigInteger(n2));
		case MULTIPLY:
			return toBigInteger(n1).multiply(toBigInteger(n2));
		case DIVIDE:
			return toBigInteger(n1).divide(toBigInteger(n2));
		case REMAINDER:
			return toBigInteger(n1).remainder(toBigInteger(n2));
		case SHIFT_LEFT:
			return toBigInteger(n1).shiftLeft(toBigInteger(n2).intValue());
		case SHIFT_RIGHT:
			return toBigInteger(n1).shiftRight(toBigInteger(n2).intValue());
		case UNSIGNED_SHIFT_RIGHT:
			break;
		case AND:
			return toBigInteger(n1).and(toBigInteger(n2));
		case AND_NOT:
			return toBigInteger(n1).andNot(toBigInteger(n2));
		case NOT:
			return toBigInteger(n1).not();
		case OR:
			return toBigInteger(n1).or(toBigInteger(n2));
		case XOR:
			return toBigInteger(n1).xor(toBigInteger(n2));
		}
		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static BigDecimal optBigDecimal(Number n1, Number n2, char c) {
		switch (c) {
		case ADD:
			return toBigDecimal(n1).add(toBigDecimal(n2));
		case SUBTRACT:
			return toBigDecimal(n1).subtract(toBigDecimal(n2));
		case MULTIPLY:
			return toBigDecimal(n1).multiply(toBigDecimal(n2));
		case DIVIDE:
			return toBigDecimal(n1).divide(toBigDecimal(n2));
		case SHIFT_LEFT:
		case SHIFT_RIGHT:
		case UNSIGNED_SHIFT_RIGHT:
		case AND:
		case AND_NOT:
		case NOT:
		case OR:
		case XOR:
		}
		throw new UnsupportedOperationException(String.valueOf(c));
	}

	private static Number preOpt(Number n1, Number n2, char c) {
		Number n = NumberInstanceLevelComparator.max(n1, n2);
		if (n instanceof Byte) {
			return optByte(n1, n2, c);
		} else if (n instanceof Short) {
			return optShort(n1, n2, c);
		} else if (n instanceof Integer) {
			return optInteger(n1, n2, c);
		} else if (n instanceof Long || n instanceof BigInteger) {
			return optLong(n1, n2, c);
		} else if (n instanceof Float) {
			return optFloat(n1, n2, c);
		} else if (n instanceof Double || n instanceof BigDecimal) {
			return optDouble(n1, n2, c);
		} else if (n instanceof BigInteger) {
			return optBigInteger(n1, n2, c);
		} else if (n instanceof BigDecimal) {
			return optBigDecimal(n1, n2, c);
		} else {
			throw new UnsupportedOperationException(n1.getClass().toString());
		}
	}

	public static Number add(Number n1, Number n2) {
		return preOpt(n1, n2, ADD);
	}

	public static Number subtract(Number n1, Number n2) {
		return preOpt(n1, n2, SUBTRACT);
	}

	public static Number multiply(Number n1, Number n2) {
		return preOpt(n1, n2, MULTIPLY);
	}

	public static Number divide(Number n1, Number n2) {
		return preOpt(n1, n2, DIVIDE);
	}

	public static Number remmainder(Number n1, Number n2) {
		return preOpt(n1, n2, REMAINDER);
	}

	public static Number shiftLeft(Number n1, Number n2) {
		return preOpt(n1, n2, SHIFT_LEFT);
	}

	public static Number shiftRight(Number n1, Number n2) {
		return preOpt(n1, n2, SHIFT_RIGHT);
	}

	public static Number shiftRightUnsigned(Number n1, Number n2) {
		return preOpt(n1, n2, UNSIGNED_SHIFT_RIGHT);
	}

	public static Number and(Number n1, Number n2) {
		return preOpt(n1, n2, AND);
	}

	public static Number andNot(Number n1, Number n2) {
		return preOpt(n1, n2, AND_NOT);
	}

	public static Number not(Number n1) {
		return preOpt(n1, Byte.valueOf((byte) 0), NOT);
	}

	public static Number or(Number n1, Number n2) {
		return preOpt(n1, n2, OR);
	}

	public static Number xor(Number n1, Number n2) {
		return preOpt(n1, n2, XOR);
	}

	public static boolean isPrimitiveWrapper(Number n) {
		return n instanceof Byte || n instanceof Short || n instanceof Integer || n instanceof Long
				|| n instanceof Float || n instanceof Double;
	}

	public static BigInteger toBigInteger(Number n) {
		if (n instanceof BigInteger)
			return (BigInteger) n;
		else if (n instanceof BigDecimal) {
			return ((BigDecimal) n).toBigInteger();
		}
		return BigInteger.valueOf(n.longValue());
	}

	public static BigDecimal toBigDecimal(Number n) {
		if (n instanceof BigInteger)
			return new BigDecimal((BigInteger) n);
		else if (n instanceof BigDecimal) {
			return (BigDecimal) n;
		}
		return BigDecimal.valueOf(n.doubleValue());
	}

	public static boolean isIntegerOrBelow(Number n) {
		return (n instanceof Byte) || (n instanceof Short) || (n instanceof Integer);
	}

	public static boolean isLongOrBelow(Number n) {
		return isIntegerOrBelow(n) || n instanceof Long;
	}

	public static boolean isInteger(Number n) {
		return isLongOrBelow(n) || n instanceof BigInteger;
	}

	public static boolean isDoubleOrBelow(Number n) {
		return (n instanceof Float) || (n instanceof Double);
	}

	public static boolean isDecimal(Number n) {
		return isDoubleOrBelow(n) || (n instanceof BigDecimal);
	}

	public static boolean isSupported(Number n) {
		return isInteger(n) || isDecimal(n);
	}

	public static boolean isBig(Number n) {
		return n instanceof BigInteger || n instanceof BigDecimal;
	}

	public static Number maskOf(int bitsSize) {
		if (bitsSize == Byte.SIZE) {
			return Short.valueOf((short) ((1 << Byte.SIZE) - 1));
		} else if (bitsSize == Short.SIZE) {
			return Integer.valueOf(((1 << Short.SIZE) - 1));
		} else if (bitsSize == Integer.SIZE) {
			return Long.valueOf((long) ((1L << Integer.SIZE) - 1));
		} else if (bitsSize == Long.SIZE) {
			return BigInteger.ONE.shiftLeft(Long.SIZE).subtract(BigInteger.ONE);
		} else if (bitsSize == BIG_SIZE) {
			return BigInteger.ONE.shiftLeft(BIG_SIZE).subtract(BigInteger.ONE);
		} else {
			throw new UnsupportedOperationException(bitsSize + "");
		}
	}

	public static int sizeOf(Number n) {
		if (n instanceof Byte) {
			return Byte.SIZE;
		} else if (n instanceof Short) {
			return Short.SIZE;
		} else if (n instanceof Integer) {
			return Integer.SIZE;
		} else if (n instanceof Long) {
			return Long.SIZE;
		} else if (n instanceof Float) {
			return Float.SIZE;
		} else if (n instanceof Double) {
			return Double.SIZE;
		} else if (n instanceof BigInteger || n instanceof BigDecimal) {
			return BIG_SIZE;
		} else {
			throw new UnsupportedOperationException(n.getClass().toString());
		}
	}

	public static Number newInstance(Class<?> cls) {
		return newInstance(cls, 0);
	}

	public static Number newInstance(Class<?> cls, Number val) {
		if (cls.equals(Byte.class)) {
			return Byte.valueOf(val.byteValue());
		} else if (cls.equals(Short.class)) {
			return Short.valueOf(val.shortValue());
		} else if (cls.equals(Integer.class)) {
			return Integer.valueOf(val.intValue());
		} else if (cls.equals(Long.class)) {
			return Long.valueOf(val.longValue());
		} else if (cls.equals(Float.class)) {
			return Float.valueOf(val.floatValue());
		} else if (cls.equals(Double.class)) {
			return Double.valueOf(val.doubleValue());
		} else if (cls.equals(BigInteger.class)) {
			return BigInteger.ZERO.add(toBigInteger(val));
		} else if (cls.equals(BigDecimal.class)) {
			return BigDecimal.ZERO.add(toBigDecimal(val));
		} else {
			throw new UnsupportedOperationException(cls.getName());
		}
	}

	public static Number maxValue(Number n) {
		if (n instanceof Byte) {
			return Byte.MAX_VALUE;
		} else if (n instanceof Short) {
			return Short.MAX_VALUE;
		} else if (n instanceof Integer) {
			return Integer.MAX_VALUE;
		} else if (n instanceof Long) {
			return Long.MAX_VALUE;
		} else if (n instanceof Float) {
			return Float.MAX_VALUE;
		} else if (n instanceof Double) {
			return Double.MAX_VALUE;
		} else if (n instanceof BigInteger) {
			return BigInteger.ONE.shiftLeft(BIG_SIZE).subtract(BigInteger.ONE);
		} else if (n instanceof BigDecimal) {
			return toBigDecimal(BigInteger.ONE.shiftLeft(BIG_SIZE).subtract(BigInteger.ONE));
		} else {
			throw new UnsupportedOperationException(n.getClass().toString());
		}
	}

	public static Number minValue(Number n) {
		if (n instanceof Byte) {
			return Byte.MIN_VALUE;
		} else if (n instanceof Short) {
			return Short.MIN_VALUE;
		} else if (n instanceof Integer) {
			return Integer.MIN_VALUE;
		} else if (n instanceof Long) {
			return Long.MIN_VALUE;
		} else if (n instanceof Float) {
			return Float.MIN_VALUE;
		} else if (n instanceof Double) {
			return Double.MIN_VALUE;
		} else if (n instanceof BigInteger) {
			return BigInteger.ONE.shiftLeft(BIG_SIZE).negate();
		} else if (n instanceof BigDecimal) {
			return toBigDecimal(BigInteger.ONE.shiftLeft(BIG_SIZE)).negate();
		} else {
			throw new UnsupportedOperationException(n.getClass().toString());
		}
	}

}
