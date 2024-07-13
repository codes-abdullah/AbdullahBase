package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.LConstants;

public interface CharsMatcher {
	public static final ByDepth byDepth = new ByDepth();
	public static final CharsMatcher MUST_EQUALS = new CharsMatcherMustEquals();
	public static final CharsMatcher MUST_NOT_EQUALS = new CharsMatcherMustNotEquals();
	// ===========================

	/**
	 * In {@link CharsLoop} implementation, if current loop can't match provided
	 * target, it will invoke this method, if this method returns true, the loop
	 * will be break and {@link LConstants#INDEX_NOT_FOUND} is returned
	 */
	boolean stopTrying();

	/**
	 * Try match provided target as bmp <br>
	 * 
	 * @param arr        src array
	 * @param len        src length
	 * @param target     target to try to match
	 * @param ignoreCase true to ignore-case sensitive
	 * @param cps
	 */
	boolean tryMatchBmp(char[] arr, int len, int index, int target, boolean ignoreCase, CodepointSupport cps);

	/**
	 * Try match provided surrogate-pair <br>
	 * 
	 * @param arr        src array
	 * @param len        src length
	 * @param targetHigh high surrogate
	 * @param targetLow  low surrogate
	 * @param ignoreCase true to ignore-case sensitive
	 * @param cps
	 */
	boolean tryMatchPair(char[] arr, int len, int index, char targetHigh, char targetLow, boolean ignoreCase,
			CodepointSupport cps);

	/**
	 * Try match any of provided targets based on their type, if targets[index] is
	 * bmp, will try to match as bmp, otherwise will try to match as surrogate-pair,
	 * if it is.<br>
	 * 
	 * @param arr           src array
	 * @param len           src length
	 * @param targets       code-points to try to match any of them
	 * @param targetsLength length of target
	 * @param ignoreCase    true to ignore-case sensitive
	 * @param cps
	 */
	boolean tryMatchAny(char[] arr, int len, int index, int[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps);

	/**
	 * Try match any of provided targets (individually) based on their type, if
	 * targets[index] is bmp, will try to match as bmp, otherwise will try to match
	 * as surrogate-pair, if it is.<br>
	 * 
	 * @param arr           src array
	 * @param len           src length
	 * @param targets       code-points to try to match any of them
	 * @param targetsLength length of target
	 * @param ignoreCase    true to ignore-case sensitive
	 * @param cps
	 */
	boolean tryMatchAny(char[] arr, int len, int index, char[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps);

	/**
	 * Try match any of provided target (sequence)<br>
	 * 
	 * @param arr          src array
	 * @param len          src length
	 * @param target       target to match
	 * @param targetLength length of target
	 * @param ignoreCase   true to ignore-case sensitive
	 * @param cps
	 */
	boolean tryMatchArray(char[] arr, int len, int index, char[] target, int targetLength, boolean ignoreCase,
			CodepointSupport cps);

	// ==========

	// ===========================

	public static CharsMatcher newMustEquals() {
		return new CharsMatcherMustEquals();
	}

	public static CharsMatcher newMustNotEquals() {
		return new CharsMatcherMustNotEquals();
	}

	// ===========================
	public static class ByDepth {

		private ByDepth() {
		}

		public CharsMatcherByDepth newMustEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix) {
			return newMustEquals(blockDepth, blockPrefix, blockSuffix, Integer.MAX_VALUE);
		}

		public CharsMatcherByDepth newMustEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
				int blocksLimit) {
			return newMustEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, CodepointSupport.BMP);
		}

		public CharsMatcherByDepth newMustEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
				int blocksLimit, CodepointSupport cps) {
			return CharsMatcherByDepth.newMustEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, cps);
		}

		// =================

		public CharsMatcherByDepth newMustNotEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix) {
			return newMustNotEquals(blockDepth, blockPrefix, blockSuffix, Integer.MAX_VALUE);
		}

		public CharsMatcherByDepth newMustNotEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
				int blocksLimit) {
			return newMustNotEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, CodepointSupport.BMP);
		}

		public CharsMatcherByDepth newMustNotEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
				int blocksLimit, CodepointSupport cps) {
			return CharsMatcherByDepth.newMustNotEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, cps);
		}
	}

}
