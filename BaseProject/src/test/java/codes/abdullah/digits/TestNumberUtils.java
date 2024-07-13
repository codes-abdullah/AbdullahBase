package codes.abdullah.digits;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class TestNumberUtils {
	@Test
	public void test() {
		for (int i = 0; i < 1024 * 1024; i++) {
			Number a = NumberUtils.randomInteger();
			Number b = NumberUtils.randomInteger();
			// ========

			String msg = String.format("%s(%s) vs %s(%s)", a.getClass(), a, b.getClass(), b);
			System.out.println(msg);
			BigInteger expected = NumberUtils.toBigInteger(a).add(NumberUtils.toBigInteger(b));
			
			Number actual = NumberUtils.add(a, b);
			String sExpected = expected.toString();
			String sActual = actual.toString();
			assertEquals(msg, sExpected, sActual);
//			boolean eq = NumberComparator.eq(expected, actual);
//			assertTrue(s, eq);
//			assertEquals(a - b, NumberUtils.subtract(a, b));
//			assertEquals(a * b, NumberUtils.multiply(a, b));
//			assertEquals(a / b, NumberUtils.divide(a, b));
//			assertEquals(a % b, NumberUtils.remmainder(a, b));
//			assertEquals(a << b, NumberUtils.shiftLeft(a, b));
//			assertEquals(a >> b, NumberUtils.shiftRight(a, b));
//			assertEquals(a >>> b, NumberUtils.shiftRightUnsigned(a, b));
//			assertEquals(a & b, NumberUtils.and(a, b));
//			assertEquals(a & ~b, NumberUtils.andNot(a, b));
//			assertEquals(a | b, NumberUtils.or(a, b));
//			assertEquals(a ^ b, NumberUtils.xor(a, b));
//			assertEquals(~a, NumberUtils.not(a));
		}
	}

}
