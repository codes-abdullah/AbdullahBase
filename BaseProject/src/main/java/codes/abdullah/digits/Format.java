package codes.abdullah.digits;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 
 * Supports rendering of Java numeric types float, double,
 * 
 * and BigDecimal in "default" format and in format that
 * 
 * avoids use of scientific notation.
 * 
 */

public enum Format {

	DEFAULT {

		@Override
		public String format(final float floatValue) {
			return String.valueOf(floatValue);
		}

		@Override
		public String format(final double doubleValue) {
			return String.valueOf(doubleValue);
		}

		@Override
		public String format(final BigDecimal bigDecimalValue) {
			return bigDecimalValue.toString();
		}

	},

	NO_EXPONENT {

		@Override

		public String format(final float floatValue) {
			return numberFormat.format(floatValue);
		}

		@Override

		public String format(final double doubleValue) {
			return numberFormat.format(doubleValue);
		}

		@Override

		public String format(final BigDecimal bigDecimalValue) {
			return bigDecimalValue.toPlainString();
		}

	};

	private static final NumberFormat numberFormat = NumberFormat.getInstance();

	static {


		numberFormat.setMaximumFractionDigits(Integer.MAX_VALUE);

		numberFormat.setGroupingUsed(false);

	}

	public abstract String format(final float floatValue);

	public abstract String format(final double doubleValue);

	public abstract String format(final BigDecimal bigDecimalValue);

}