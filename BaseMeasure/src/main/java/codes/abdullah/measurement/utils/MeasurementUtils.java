package codes.abdullah.measurement.utils;

import codes.abdullah.digits.Format;
import codes.abdullah.measurement.dimension.Dimension;
import codes.abdullah.measurement.unit.Unit;

public class MeasurementUtils {
	public final static double[] fixed_decimals_for_testing = { -1, -0.1, -0.0004567890, -73.25, -56229.321,
			-873.5432456, 0, 0.1, 0.0000876543297, 0.33, 0.6543, 1, 1.6543, 22.45, 9876.5432, 1987654344.3345,
			784.46789765434 };

	/**
	 * This helper method can do common <b>one-system</b> conversion, e.g: INCH to
	 * CHAIN (imperial system) or KILOMETER to CENTIMETER (metric system)<br>
	 * <br>
	 * <b>The results will be unpredictable if different systems involved</b>
	 */

	public static <D extends Dimension> double to(Unit<D> source, Unit<D> target, double n) {
		return scale(n, source.getFactor() / target.getFactor(),
				Double.MAX_VALUE / (source.getFactor() / target.getFactor()));
	}

	public static <D extends Dimension> double to(double sourceFactor, double targetFactor, double n) {
		return scale(n, sourceFactor / targetFactor, Double.MAX_VALUE / (sourceFactor / targetFactor));
	}

//	public static <D extends Dimension> double to(Unit<D> source, Unit<D> target, double n) {
//		return scale(n,
//				source.unitIndex() > target.unitIndex() ? n / (target.getFactor() / source.getFactor())
//						: n * (source.getFactor() / target.getFactor()),
//				Double.MAX_VALUE / (source.getFactor() / target.getFactor()));
//	}

	/**
	 * helper method to scale
	 */
	private static double scale(double n, double m, double overflow) {
		if (n > overflow)
			return Double.MAX_VALUE;
		if (n < -overflow)
			return Double.MIN_VALUE;
		return n * m;
//		return m;
	}

	public static String noE(double n) {
		return Format.NO_EXPONENT.format(n);
	}

	/**
	 * Map 3 keys to an index<br>
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * Traditionally, when you have 2 items or more that required to represent a key
	 * in key-value mapping, you will wrap them inside 1 object, simply will use the
	 * object as the key.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * The tradition idea of mapping is prefect and simple, but it is not the best
	 * if your target is performance, especially for loop/recursion retrieving ops,
	 * because on every retrieve, we will search the hole key-set to find the
	 * required value, imagine we have 1000,000,000 keys!!
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * During the development of my Installable Measurement Systems, which was
	 * totally stateless, I needed an idea to install a Dimension-Converter for each
	 * 2 Systems based on 1 Dimension, therefore I faced the problem of having 3
	 * items to represent a key, and the solution was not absent, I could use normal
	 * Hash-Mapping, but I wanted something faster for my stateless implementation,
	 * and the idea was to eliminate 3 important futures from Hash-Mapping.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 1: Wrapping, I’ll not use a fourth object to represent key, I’ll just use my
	 * 3 objects together on every invocation.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 2: Searching, I’ll not search for the key to find corresponding value, I’ll
	 * use unique index to get the converter without any searching.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * How? Lets make a live example, assume the following
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - We have systems: Metric, Imperial and Arabic.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - We have Dimensions: Length, Mass
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - 3 Lists for System, Dimension and Converter accordingly.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - We need: MetricImperialLengthConverter, MetricArabicLengthConverter,
	 * ImperialArabicLengthConverter, MetricImperialMassConverter,
	 * MetricArabicMassConverter, ImperialArabicMassConverter.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - On every System / Dimension creation: hold the size of the List, avoid
	 * duplication and inject/return the a unique bit-id by (1 &lt;&lt; size) to
	 * inserted System / Dimension, e.g: Metric 0001, Imperial 0010 and Arabic 0100,
	 * and for Dimensions, Length 0001 and Mass 0010.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - On every Converter creation: hold a reference of 2 Systems and a reference
	 * of the Dimension.
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - Before the insertion of any converter, find the correct index based on the
	 * combination of the bit-ids of 2 systems and 1 dimension, e.g: the
	 * combinations on 64-bit are:
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 0001..0011 =&gt; index 0 for MetricImperialLengthConverter
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 0010..0011 =&gt; index 1 for MetricImperialMassConverter
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 0001..0101 =&gt; index 2 for MetricArabicLengthConverter
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 0010..0101 =&gt; index 3 for MetricArabicMassConverter
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 0001..0110 =&gt; index 4 for ImperialArabicLengthConverter
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * 0010..0110 =&gt; index 5 for ImperialArabicMassConverter
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * <br/>
	 * 
	 * </p>
	 * <p align="left" style="margin-bottom: 0in; line-height: 100%">
	 * - If the creation of object on index 2 occurred before index 0 and 1, we must
	 * hold a null reference on indexes 0 and 1 till we have a valid
	 * creation/insertion.
	 * </p>
	 * 
	 * @param combination    binary combination of 32 low and high bits
	 * @param low_list_size  the list size of low-bits, e.g: systems
	 * @param high_list_size the list size of high-bits, e.g: dimensions
	 * 
	 * @author Abdullah Aldokhi<br>see findBitMappingIndexAlgorithm.ods for more information
	 */
	public static int findBitMappingIndex(long combination, int low_list_size, int high_list_size) {
		//
		// -------------------
		// e.g: will try with combination of 64-bit, left(high) has ..0100, and
		// right(low) has ..0100100
		// -------------------
		// break down the combination into high and low
		final int high = (int) (combination >> 32), low = (int) combination;
		// -------------------
		// find low-leading-zeros, (26)
		final int llz = Integer.numberOfLeadingZeros(low);
		// find low-trailing-zeros, (2)
		final int ltz = Integer.numberOfTrailingZeros(low);
		// -------------------
		// find LSB index on low-bits, (2)
		final int lsbIndex = ltz;
		// find MSB index on low-bits, (32 - 26 - 1 = 5)
		final int msbIndex = Integer.SIZE - llz - 1;
		// -------------------
		// find high-trailing-zeros, this can represent the high-bit index
		final int highBitIndex = Integer.numberOfTrailingZeros(high);
		// -------------------
		// find LSB group-index, which equals to ltz, (2)
		final int lsbGroupIndex = ltz;
		// find MSB group-index, which equals to (MSB(5) - LSB(2) - 1 = 2)
		final int msbGroupIndex = msbIndex - lsbIndex - 1;
		// -------------------
		// why (low_list_size-1)? each item in low-list will face all other items but
		// itself, so if
		// items=10 and high_list_size=7, to find how many items 1st item will face
		// is by saying: ((low_list_size - 1) * high_list_size) = 63
		// now 2nd item will not face 1st item again (avoid duplications), so 2nd
		// group will have 7 high_items less than the previous, which means 2nd group
		// has deduction of combinations by: high_list_size * groupIndex = 7
		// -------------------
		// find how many deductions in current group only
		final int lsbCombinationsDeductionPerGroup = high_list_size * lsbGroupIndex;
		// find how many combinations in current group (after deduction)
		final int lsbCombinationsPerGroupAfterDeduction = ((low_list_size - 1) * high_list_size)
				- lsbCombinationsDeductionPerGroup;
		// e.g: low_list_size = 10, high_list_size = 7 and total combinations = 70
		// (before any deductions)
		final int lsbCombinationsPerGroupBeforeDeduction = low_list_size * high_list_size;
		// -------------------
		// if lsbGroupIndex = 2, the count is 3
		final int lsbCountOfGroups = lsbGroupIndex + 1;
		// find deduction-factor in LSB-group
		final int deductionFactor = dualDeductionFactor(lsbCountOfGroups);
		// total deductions in LSB-group
		final int lsbTotalDeduction = high_list_size * deductionFactor;
		// -------------------
		// find the last index of current group
		final int lsbCombinationsLastIndex = (lsbCombinationsPerGroupBeforeDeduction * lsbCountOfGroups)
				- lsbTotalDeduction;
		// now return to target index
		final int index = (lsbCombinationsLastIndex - lsbCombinationsPerGroupAfterDeduction)
				+ (msbGroupIndex * high_list_size) + highBitIndex;

		return index;
	}

	public static void main(String[] args) {
		int high = 0b100, low = 0b10000100;
		long com = (long)high << 32 | low;
		findBitMappingIndex(com, 0, 0);
	}

	/**
	 * Lazy recursion to find the factor of dual-deduction<br>
	 * example: if we have 4 items to perform dual comparison without any
	 * duplications will do<br>
	 * 1 vs 1 (itself)<br>
	 * 1 vs 2<br>
	 * 1 vs 3<br>
	 * 1 vs 4<br>
	 * <br>
	 * 2 vs 1 (duplicated)<br>
	 * 2 vs 2 (itself)<br>
	 * 2 vs 3<br>
	 * 2 vs 4<br>
	 * <br>
	 * 3 vs 1 (duplicated)<br>
	 * 3 vs 2 (duplicated)<br>
	 * 3 vs 3 (itself)<br>
	 * 3 vs 4<br>
	 * <br>
	 * 4 vs 1 (duplicated)<br>
	 * 4 vs 2 (duplicated)<br>
	 * 4 vs 3 (duplicated)<br>
	 * 4 vs 4 (itself)<br>
	 * <br>
	 * <br>
	 * so this method to find out how many (duplications) and (itself) count, you
	 * can use the factor returned by this method and multiply it by the total of
	 * all groups to find the total deductions<br>
	 * <br>
	 * other example: each count of groups will cause a certain amount of
	 * deduction<br>
	 * e.g: if systems = 10 and dims = 7<br>
	 * - group 1 will face all other systems except itself, so will avoid 1 * 7 =
	 * 7<br>
	 * - group 2 will face all other systems except itself and group 1, this
	 * means<br>
	 * any avoided duplications in group 1 will be included in group 2, so group 2
	 * will avoid 2 duplications (2 && 1) and (2 && 2) including the avoided duals
	 * of previous groups (1 and 2), this means factor of 3 will be avoided, so 3 *
	 * 7 = 21
	 * 
	 * @author Abdullah Aldokhi
	 */
	public static int dualDeductionFactor(int groupsCount) {
		return groupsCount > 0 ? dualDeductionFactor(groupsCount - 1) + groupsCount : 0;
	}

}
