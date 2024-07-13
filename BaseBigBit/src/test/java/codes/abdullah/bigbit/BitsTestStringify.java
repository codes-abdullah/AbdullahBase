package codes.abdullah.bigbit;

import java.math.BigInteger;
import java.util.Arrays;

import codes.abdullah.chars.Chars;

public class BitsTestStringify {
	private final String sleft, sright, sresult, sextra, operator;
	private Bits bleft, bresult, bextra;
	private BigInteger jleft, jresult, jextra;
	@SuppressWarnings("unused")
	private Number right;
	private String str_right;
	private boolean extraUsed;

	public BitsTestStringify(String sleft, String sright, String sresult, String sextra, String operator) {
		this.sleft = sleft;
		this.sright = sright;
		this.sresult = sresult;
		this.sextra = sextra;
		this.operator = operator;
	}

	private static Bits nonull(Bits b) {
		return b == null ? Bits.of() : b;
	}

	private static BigInteger nonull(BigInteger b) {
		return b == null ? BigInteger.ZERO : b;
	}

	private static String strIt(BigInteger j) {
		return strIt(Utils.bi.words(j)) + ", " + j;
	}

	private static String strIt(Bits b) {
		return strIt(b.toIntegerArray()) + ", " + b.toDecimal();
	}

	private static String strIt(int[] arr) {
		return Arrays.toString(arr) + " ==> (" + arr.length + ")";
	}

	public void right(int i) {
		right = i;
		str_right = "[" + i + "] => " + i;
	}

	public void right(long l) {
		right = l;
		final int word1 = (int) (l >>> Integer.SIZE), word0 = (int) (l & Utils.LONG_MASK);
		int[] arr = word1 == 0 ? new int[] { word0 } : new int[] { word0, word1 };
		str_right = Arrays.toString(arr) + " => " + l + ", unsigned => " + BigIntegerUtils.ofUnsigned(l);
	}

	public void right(Bits i) {
		right = i;
		str_right = "" + i.toIntegerArray() + " => " + i.toDecimal();
	}

	public void left(Bits b, BigInteger j) {
		this.bleft = b.toImmutable();
		this.jleft = j;
	}

	public void result(Bits b, BigInteger j) {
		this.bresult = b.toImmutable();
		this.jresult = j;
	}

	public void extra(Bits b, BigInteger j) {
		this.bextra = b.toImmutable();
		this.jextra = j;
		extraUsed = true;
	}

	@Override
	public String toString() {
		bleft = nonull(bleft);
		jleft = nonull(jleft);

		bresult = nonull(bresult);
		jresult = nonull(jresult);

		Chars c = Chars.of();
		c.ln();
		c.appendFormat("b-%s: %s", sleft, strIt(bleft)).ln();
		c.appendFormat("j-%s: %s", sleft, strIt(jleft)).ln();
		c.appendFormat("%s: %s           %s", sright, str_right, operator).ln();
		c.append("----------------------").ln();
		c.appendFormat("b-%s: %s", sresult, strIt(bresult)).ln();
		c.appendFormat("j-%s: %s", sresult, strIt(jresult)).ln();
		if (extraUsed) {
			bextra = nonull(bextra);
			jextra = nonull(jextra);
			c.appendFormat("b-%s: %s", sextra, strIt(bextra)).ln();
			c.appendFormat("j-%s: %s", sextra, strIt(jextra)).ln();
		}
		c.ln().ln();
		return c.toString();
	}

}
