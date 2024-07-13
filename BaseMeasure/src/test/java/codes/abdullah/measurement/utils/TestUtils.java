package codes.abdullah.measurement.utils;

import java.text.NumberFormat;
import java.util.Random;

import codes.abdullah.digits.Digits;
import codes.abdullah.digits.Format;

public class TestUtils {
	public static final double delta = 0.1;
	public static final int loops = 1024;
	public static final Random r = new Random();
	private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();
	public static final double[] fixed_decimals_for_testing = MeasurementUtils.fixed_decimals_for_testing;
	static {
		NUMBER_FORMAT.setMaximumFractionDigits(Integer.MAX_VALUE);
		NUMBER_FORMAT.setGroupingUsed(false);
	}

	public static double nextDouble() {
		int len = Digits.ints.random(1, 19);

		int lendiv = r.nextInt(len);
		int leftlen = lendiv == 0 ? 0 : len / lendiv;
		int rightlen = len - leftlen;

		if (r.nextBoolean()) {
			int temp = rightlen;
			rightlen = leftlen;
			leftlen = temp;
		}

//		System.out.printf("len: %s, lendiv: %s, l: %s, r: %s\n", len, lendiv, leftlen, rightlen);
		int i1 = Math.abs(r.nextInt());
		int i2 = Math.abs(r.nextInt());

		i1 = trim(i1, leftlen);
		i2 = trim(i2, rightlen);

		double div = Math.pow(10, Digits.ints.lengthOf(i2));
		double d2 = i2 / div;
		double d = i1 + d2;
//		System.out.println("\t\t\t"+i1+" & "+d2);
		return d;
	}

	private static int trim(int i, int max) {
		int len = Digits.ints.lengthOf(i);
		if (len > max) {
			int diff = len - max;
			long div = (long) Math.pow(10, diff);
			i = (int) (i / div);
		}
		return i;
	}

	public static String noE(double n) {
		return Format.NO_EXPONENT.format(n);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			double d = nextDouble();
			String s = d + "";
			System.out.println(s.length() + ", " + s + ", " + Format.NO_EXPONENT.format(d));
		}
	}
}
