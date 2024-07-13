package codes.abdullah.digits;

import static java.lang.Character.digit;

import java.math.BigInteger;

import codes.abdullah.project.Check;

/**
 * Mutable implementation.<br>
 * Unsigned Radix-based random digits generator, supported all radixes up to
 * {@link Character#MAX_RADIX}
 */
public class RandomRadix {

	private final static char[] d = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	private final boolean generateDecimal;
	private final String max;
	private final StringBuilder sb = new StringBuilder();
	private final int radix;

	public RandomRadix(int radix, int bitSize) {
		this(radix, bitSize, false);
	}

	/**
	 * @param {@link          Character#MIN_RADIX} and {@link Character#MAX_RADIX}
	 * @param bitSize         the length of the generated string will rely on this
	 *                        size
	 * @param generateDecimal if true, will inject decimal-float-point in results
	 */
	public RandomRadix(int radix, int bitSize, boolean generateDecimal) {
		Check.bitSize(bitSize);
		this.radix = Check.radix(radix);
		if(radix != 10 && generateDecimal) {
			throw new IllegalArgumentException(String.format("can't generate-deciaml values for non-10-radix, found radix(%d)", radix));
		}
		BigInteger bi = BigInteger.valueOf(1L).shiftLeft(bitSize - 1);
		this.max = bi.toString(radix);
		this.generateDecimal = generateDecimal;
	}

	public String next() {
		return next(sb).toString();
	}

	public StringBuilder next(StringBuilder sb) {
		sb.delete(0, sb.length());
		int len = Digits.ints.random(1, max.length() + 1);
		boolean limited = len == max.length();
		int index = limited ? randomDigit(0, 0, len) : Digits.ints.random(1, radix);
		final int fcp = digit(sb.append(d[index]).charAt(0), radix);
		for (int i = 1; i < len; i++) {
			index = limited ? randomDigit(i, fcp, len) : Digits.ints.random(0, radix);
			sb.append(d[index]);
		}
		if (generateDecimal) {
			if (generateBelowZero()) {
				int remain = max.length() - len;
				if (remain > 1) {					
					for (int i = 0; i < remain; i++) {
						sb.insert(0, '0');
					}
					sb.insert(1, '.');
				}
			} else if (sb.length() > 1) {
				index = Digits.ints.random(1, sb.length() - 1);
				sb.insert(index, '.');
			}
		}
		return sb;
	}

	private static boolean generateBelowZero() {
		return Digits.ints.random(0, 10) >= 6;
	}

	/**
	 * @param index   loop current index, which represent the last appended char,
	 *                e.g: 7f2e < e
	 * @param firstCp first code-point in builder-string, e.g: 7f2e < 7, firstCp
	 *                will be used to determine wither current random process will
	 *                be limited to max-string or not, e.g: max-string = 8000 for
	 *                radix 16, firstCp 8, all next processes must generate 0
	 * @param len     the working length for current process
	 */
	private int randomDigit(int index, int firstCp, int len) {
		// if firstCp == 0, means this is first digit will be generated
		// if firstCp < max-string.charAt(0), means we have no limitation, we can
		// generate any digits
		if (firstCp != 0 && firstCp < digit(this.max.charAt(0), radix))
			return Digits.ints.random(0, radix);
		// if firstCp == 0, generate digits starting 1, avoid leading-zeros
		int min = firstCp == 0 ? 1 : 0;
		int max = digit(this.max.charAt(index), radix);
		// if len == 1, allow 0 to be generated
		if (len == 1)
			return Digits.ints.random(0, max);
		return Digits.ints.random(min, max);
	}

	@Override
	public String toString() {
		return next().toString();
	}

}
