package codes.abdullah.measurement.formatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import codes.abdullah.digits.Digits;
import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;

public class UnitFormatters {

	public static final String DYNAMIC_PATTERN = "$[~3]";
	public static final String FIXED_PATTERN = "$[BASE+1], $[BASE], $[BASE-1]";
	public static final int DISCARD_UNDEFINED = 0x1;
	public static final int INCLUDE_SYMBOLS = 0x2;
	protected static final int DYNAMIC_PATTERN_DETECTED = 0x4;
	public static final int DISCARD_FRACTION = 0x8;

	public static <Q extends Dimension> UnitFormatter<Q> of(Unit<Q> baseUnit) {
		return of(baseUnit, DYNAMIC_PATTERN, 1000);
	}

	public static <Q extends Dimension> UnitFormatter<Q> of(Unit<Q> baseUnit, String pattern) {
		return of(baseUnit, pattern, 1000);
	}

	public static <Q extends Dimension> UnitFormatter<Q> of(Unit<Q> baseUnit, String pattern, int maxFraction) {
		return of(baseUnit, pattern, maxFraction, INCLUDE_SYMBOLS | DISCARD_UNDEFINED);
	}

	public static <Q extends Dimension> UnitFormatter<Q> of(Unit<Q> baseUnit, String pattern, int maxFraction,
			int flags) {
		return parse(baseUnit, pattern, maxFraction, flags, Boolean.TRUE);
	}

	// ---------------------------------

	public static <Q extends Dimension> Builder<Q> ofBuilder(Unit<Q> baseUnit) {
		return new Builder<Q>(baseUnit);
	}

	public static class Builder<Q extends Dimension> {
		private final Unit<Q> baseUnit;
		private int flags, maxFraction;
		private String pattern;

		private Builder(Unit<Q> baseUnit) {
			this.baseUnit = Objects.requireNonNull(baseUnit, "baseUnit is null");
			allDefaults();
		}

		/**
		 * Pattern: {@link UnitFormatters#DYNAMIC_PATTERN}<br>
		 * Max Fraction: 1000<br>
		 * Flags: {@link UnitFormatters#INCLUDE_SYMBOLS} |
		 * {@link UnitFormatters#DISCARD_UNDEFINED}<br>
		 */
		public Builder<Q> allDefaults() {
			return defaultFlags().dynamicPattern().defaultMaxFraction();
		}

		public Builder<Q> includeSymbols() {
			flags |= INCLUDE_SYMBOLS;
			return this;
		}

		public Builder<Q> discardUndefind() {
			flags |= DISCARD_UNDEFINED;
			return this;
		}

		public Builder<Q> discardFraction() {
			flags |= DISCARD_FRACTION;
			return this;
		}

		public Builder<Q> flags(int flags) {
			this.flags = flags;
			return this;
		}

		/**
		 * {@link UnitFormatters#INCLUDE_SYMBOLS} |
		 * {@link UnitFormatters#DISCARD_UNDEFINED}<br>
		 */
		public Builder<Q> defaultFlags() {
			this.flags = INCLUDE_SYMBOLS | DISCARD_UNDEFINED;
			return this;
		}

		/**
		 * Base-Unit: {@link Times#MILLISECOND}<br>
		 * Pattern: $[~3]<br>
		 * Max Fraction: 1000<br>
		 * Flags: {@link UnitFormatters#INCLUDE_SYMBOLS} |
		 * {@link UnitFormatters#DISCARD_UNDEFINED}<br>
		 */
		public Builder<Q> defaultPattern() {
			return dynamicPattern();
		}

		/**
		 * {@link UnitFormatters#FIXED_PATTERN}
		 */
		public Builder<Q> fixedPattern() {
			this.pattern = FIXED_PATTERN;
			return this;
		}

		/**
		 * {@link UnitFormatters#DYNAMIC_PATTERN}
		 */
		public Builder<Q> dynamicPattern() {
			this.pattern = DYNAMIC_PATTERN;
			return this;
		}

		public Builder<Q> dynamicPattern(int length) {
			this.pattern = "$[~" + length + "]";
			return this;
		}

		public Builder<Q> pattern(String pattern) {
			this.pattern = Objects.requireNonNull(pattern, "pattern is null");
			return this;
		}

		public Builder<Q> defaultMaxFraction() {
			return maxFraction(1000);
		}

		public Builder<Q> maxFraction(int n) {
			maxFraction = n;
			return this;
		}

		public UnitFormatter<Q> build() {
			return parse(baseUnit, pattern, maxFraction, flags, Boolean.TRUE);
		}

		public UnitFormatter<Q> buildImmutable() {
			return parse(baseUnit, pattern, maxFraction, flags, Boolean.FALSE);
		}
	}

	static <Q extends Dimension> UnitFormatter<Q> parse(Unit<Q> baseUnit, String pattern, int maxFraction, int flags,
			boolean mutable) {
		if (baseUnit.unitsCount() == 0)
			throw new IllegalArgumentException(baseUnit + " has no sibiling units");
		if (pattern == null || pattern.length() == 0)
			throw new IllegalArgumentException("pattern is null or empty");
		maxFraction = checkMaxFraction(maxFraction);
		int start = -1;
		int end = -1;
		int prefixIndex = 0;
		int dynamicsLength = 0;
		int[] insertIndexes = null;
		int[] unitIndexes = null;
		int[] sortedUnitIndexes = null;
		List<Integer> lCharIndex = new ArrayList<>();
		List<Integer> lUnitIndex = new ArrayList<>();
		// ## scanning
		while ((start = pattern.indexOf('$', start + 1)) != -1) {
			// is valid open >><$[<< and is valid close >>]<<
			if (isValidOpen(pattern, start) && (end = pattern.indexOf(']', start + 1)) != -1) {
				// println(mark(_pattern, start, end));
				// extract $[>>ddd/MIN/MAX/BASE<<]
				String sub = pattern.substring(start + 2, end);
				if (sub.length() == 0)
					throw new IllegalArgumentException("empty form at: " + mark(pattern, start, end));

				if (isDigits(sub)) {
					if (Digits.ints.isFlagged(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED))
						throw new IllegalArgumentException(
								"can't have dynamic-form and prefixed-digit: " + mark(pattern, start, end));
					// convert and check range
					prefixIndex = Integer.parseInt(sub.toString());
				} else if (isValidPrefix(baseUnit, sub)) {
					if (Digits.ints.isFlagged(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED))
						throw new IllegalArgumentException(
								"can't have dynamic-form and prefixed-form: " + mark(pattern, start, end));
					prefixIndex = convertPrefixToIndex(baseUnit, pattern, start, end, sub);
					int from = -1;
					final boolean ius = isUnitSymbol(baseUnit, sub);
					if (ius && sub.length() > baseUnit.unitAt(prefixIndex).getSymbol().length()) {
						from = baseUnit.unitAt(prefixIndex).getSymbol().length();
					} else if (sub.length() > 3 && sub.charAt(0) == 'M') {
						from = 3;
					} else if (sub.length() > 4 && sub.charAt(0) == 'B')
						from = 4;
					// extract and convert suffix
					if (from != -1) {
						String suffix = sub.substring(from, sub.length());
						int d2 = convertSuffixToIndex(baseUnit, pattern, start, end, prefixIndex, sub, suffix, ius);
						// boolean subtract = (from == 3 && sub.charAt(1) == 'A') || (from == 4 &&
						// sub.charAt(4) == '-') || (ius && suffix.charAt(0) == '-');

						prefixIndex = suffix.charAt(0) == '-' ? prefixIndex - d2 : prefixIndex + d2;
					}
				} else if (isDynamic(sub)) {
					// if already detected
					if (Digits.ints.isFlagged(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED))
						throw new IllegalArgumentException(
								"can't have more than one dynamic-form: " + mark(pattern, start, end));
					flags = Digits.ints.flag(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED);
					dynamicsLength = 1;
					if (sub.length() > 1) {
						String suffix = sub.substring(1, sub.length());
						dynamicsLength = convertSuffixToUpgradesLength(baseUnit, pattern, start, end, sub, suffix);
						checkRange(baseUnit, pattern, start, end, dynamicsLength);
					}
					lCharIndex.add(start);
					// continue to check if other forms detected which will not be allowed
					continue;
				} else {
					fail(pattern, start, end, " bad form");
				}
				checkRange(baseUnit, pattern, start, end, prefixIndex);
				lCharIndex.add(start);
				lUnitIndex.add(prefixIndex);
				start = end;
				if (start + 1 >= pattern.length())
					break;

			}
		}

		// ## assigning
		StringBuilder temp = new StringBuilder(pattern);
		// if dynamic pattern, will create it in else block
		if (Digits.ints.isFlagged(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED)) {
			insertIndexes = new int[lCharIndex.size()];
		} else {
			if (lCharIndex.size() == 0)
				throw new IllegalArgumentException("can't detect any forms in: " + pattern);

			assert lCharIndex.size() == lUnitIndex.size();

			// check duplicates
			for (int i = 0; i < lCharIndex.size(); i++) {
				for (int j = 0; j < lCharIndex.size(); j++) {
					if (i != j && lUnitIndex.get(i) == lUnitIndex.get(j)) {
						int firstEnd = pattern.indexOf(']', lCharIndex.get(i));
						int secondEnd = pattern.indexOf(']', lCharIndex.get(j));
						throw new IllegalArgumentException("detect duplicated forms:\n"
								+ mark(pattern, lCharIndex.get(i), firstEnd) + " refers to "
								+ baseUnit.unitAt(lUnitIndex.get(i)) + "\nand:\n"
								+ mark(pattern, lCharIndex.get(j), secondEnd) + " refers to "
								+ baseUnit.unitAt(lUnitIndex.get(i)) + "\n" + Arrays.toString(baseUnit.units()));
					}
				}
			}

			insertIndexes = new int[lCharIndex.size()];
			unitIndexes = new int[lCharIndex.size()];
		}
		// -------------
		int disp = 0;
		for (int i = 0; i < insertIndexes.length; i++) {
			start = lCharIndex.get(i) - disp;
			end = temp.toString().indexOf(']', start);
			temp.delete(start, end + 1);
			disp += ((end + 1) - start);
			insertIndexes[i] = start;
			if (unitIndexes != null)
				unitIndexes[i] = lUnitIndex.get(i);
		}

		// create instance of unitIndex-array to sort it
		String applyPattern = temp.toString();
		double[] values = new double[baseUnit.unitsCount()];
		if (Digits.ints.isFlagged(flags, UnitFormatters.DYNAMIC_PATTERN_DETECTED))
			unitIndexes = new int[dynamicsLength];
		sortedUnitIndexes = Arrays.copyOf(unitIndexes, unitIndexes.length);
		Arrays.sort(sortedUnitIndexes);
		StringBuilder builder = new StringBuilder("0");

		if (!mutable)
			return new ImmutableUnitFormatter<Q>(baseUnit, pattern, applyPattern, flags, maxFraction, dynamicsLength,
					insertIndexes, sortedUnitIndexes, unitIndexes, values, builder, temp, 0);
		return new MutableUnitFormatter<Q>(baseUnit, pattern, applyPattern, flags, maxFraction, dynamicsLength,
				insertIndexes, sortedUnitIndexes, unitIndexes, values, builder, temp, 0);

	}

	/**
	 * i.e: prefix = [BASE]-3/[MIN]+2/[MAX]-1, suffix BASE[-3]/MIN[-2]/MAX[-1]
	 */
	private static int convertPrefixToIndex(Unit<?> baseUnit, String pattern, int start, int end, String prefix) {
		// check if unit symbol
		for (int i = 0; i < baseUnit.unitsCount(); i++) {
			if (prefix.startsWith(baseUnit.unitAt(i).getSymbol().toString()))
				return baseUnit.unitAt(i).unitIndex();
		}
		// BASE
		if (prefix.length() >= 4 && prefix.charAt(0) == 'B') {
			return baseUnit.getBaseUnit().unitIndex();
		} else if (prefix.length() >= 3) {
			// MAX
			if (prefix.charAt(1) == 'A')
				return baseUnit.unitsCount() - 1;
			// MIN
			return 0;
		}
		fail(pattern, start, end, "prefix not starts with BASE/MAX/MIN or valid unit symbol");
		// should never return -1
		return -1;
	}

	/**
	 * i.e: prefix = [BASE]-3/[MIN]+2/[MAX]-1, suffix BASE[-3]/MIN[+2]/MAX[-1]
	 */
	private static int convertSuffixToIndex(Unit<?> baseUnit, String pattern, int start, int end, int prefixIndex,
			String sub, String suffix, boolean ius) {
		// case of - only or + only
		if (suffix.length() == 1)
			fail(pattern, start, end, " is invalid form");
		if (ius) {
			// do nothing
		} else if (sub.charAt(0) == 'B') {
			// do nothing, both + && - accepted
		} else if (sub.charAt(1) == 'A') {
			// MAX case, must be MAX-ddd...
			if (suffix.charAt(0) != '-')
				fail(pattern, start, end, " is invalid form, you must use [-] after MAX");
		} else if (sub.charAt(1) == 'I') {
			// MIN case, must be MIN+ddd...
			if (suffix.charAt(0) != '+')
				fail(pattern, start, end, " is invalid form, you must use [+] after MIN");
		}
		// should be only digits ddd...
		suffix = suffix.substring(1, suffix.length());
		if (!isDigits(suffix))
			fail(pattern, start, end, " is invalid form, contains non-digits");
		return Integer.parseInt(suffix.toString());
	}

	private static boolean isDynamic(String sub) {
		return sub.charAt(0) == '~';
	}

	private static int convertSuffixToUpgradesLength(Unit<?> baseUnit, String pattern, int start, int end,
			String prefix, String suffix) {
		if (suffix.length() == 0)
			fail(pattern, start, end, " is invalid form");
		if (!isDigits(suffix))
			fail(pattern, start, end, " is invalid form, contains non-digits");
		return Integer.parseInt(suffix.toString());
	}

	private static int checkMaxFraction(double maxFraction) {
		if (maxFraction == 0 || maxFraction == -1)
			return -1;
		if (!Digits.ints.isPowerOf((int) maxFraction, 10))
			throw new IllegalArgumentException("maxFraction(" + maxFraction + ") must be power of 10");
		return (int) maxFraction;
	}

	private static String mark(String cs, int from, int to) {
		return new StringBuilder(cs).insert(to, '}').insert(from, '{').toString();
	}

	private static void fail(String pattern, int start, int end, String due) throws IllegalArgumentException {
		throw new IllegalArgumentException(
				pattern.substring(start, end + 1) + due + " \nsrc: " + mark(pattern, start, end));
	}

	/**
	 * invoke {@link #fail(String, int, int, String)} if <b>d</b> < 0 or <b>d</b> >=
	 * baseUnit.unitsCount()
	 */
	private static void checkRange(Unit<?> baseUnit, String pattern, int start, int end, int d) {
		if (d < 0)
			fail(pattern, start, end, ", (" + d + ") < (0) ");
		else if (d >= baseUnit.unitsCount())
			fail(pattern, start, end, ", (" + d + ") >= baseUnit.unitsCount(" + baseUnit.unitsCount() + ") ");
	}

	/**
	 * @return true if whole sub is only English digits
	 */
	private static boolean isDigits(String sub) {
		for (int i = 0; i < sub.length(); i++) {
			if (sub.charAt(i) < '0' || sub.charAt(i) > '9')
				return false;
		}
		return true;
	}

	/**
	 * @return true only if index pointing to <b>$</b> and next is <b>[</b>
	 */
	private static boolean isValidOpen(String pattern, int index) {
		return pattern.charAt(index) == '$' && index + 1 < pattern.length() && pattern.charAt(index + 1) == '[';
	}

	/**
	 * @return true only if prefix.len >= 3 && starts with [BASE/MAX/MIN]
	 */
	private static boolean isValidPrefix(Unit<?> baseUnit, String prefix) {
		if (isUnitSymbol(baseUnit, prefix))
			return true;
		// MAX/MIN or BASE
		if (prefix.length() < 3)
			return false;
		if (prefix.length() >= 4 && prefix.charAt(0) == 'B' && prefix.charAt(1) == 'A' && prefix.charAt(2) == 'S'
				&& prefix.charAt(3) == 'E') {
			return true;
		} else if (prefix.length() >= 3 && prefix.charAt(0) == 'M'
				&& ((prefix.charAt(1) == 'I' && prefix.charAt(2) == 'N')
						|| (prefix.charAt(1) == 'A' && prefix.charAt(2) == 'X'))) {
			return true;
		}
		return false;
	}

	private static boolean isUnitSymbol(Unit<?> baseUnit, String prefix) {
		for (int i = 0; i < baseUnit.unitsCount(); i++) {
			if (prefix.startsWith(baseUnit.unitAt(i).getSymbol().toString()))
				return true;
		}
		return false;
	}

	/**
	 * @return find and return unit that input belongs to it, if nothing found,
	 *         return the last unit
	 */
	static <Q extends Dimension> Unit<Q> findBelongsToWhom(Unit<Q> baseUnit, Unit<Q> u, double n) {
		for (int i = 0; i < baseUnit.unitsCount(); i++) {
			n = u.to(n, baseUnit.unitAt(i));
			if (n > 0 && n < baseUnit.unitAt(i).max())
				return baseUnit.unitAt(i);
			u = baseUnit.unitAt(i);
		}
		return baseUnit.unitAt(baseUnit.unitsCount() - 1);
	}

	static <Q extends Dimension> boolean isDefined(int[] unitIndexes, Unit<Q> unit) {
		for (int i = 0; i < unitIndexes.length; i++) {
			if (unitIndexes[i] == unit.unitIndex())
				return true;
		}
		return false;
	}

}
