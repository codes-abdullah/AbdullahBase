package codes.abdullah.project.lang.chars.utils;

import codes.abdullah.project.CodepointSupport;

public interface CharsMatcherByDepth extends CharsMatcher {

	CharsMatcherByDepth reset();

	public static CharsMatcherByDepth newMustEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix) {
		return newMustEquals(blockDepth, blockPrefix, blockSuffix, Integer.MAX_VALUE);
	}

	public static CharsMatcherByDepth newMustEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
			int blocksLimit) {
		return newMustEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, CodepointSupport.BMP);
	}

	public static CharsMatcherByDepth newMustEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
			int blocksLimit, CodepointSupport cps) {
		return new CharsMatcherByDepthMustEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, cps);
	}

	// ====================

	public static CharsMatcherByDepth newMustNotEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix) {
		return newMustNotEquals(blockDepth, blockPrefix, blockSuffix, Integer.MAX_VALUE);
	}

	public static CharsMatcherByDepth newMustNotEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
			int blocksLimit) {
		return newMustNotEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, CodepointSupport.BMP);
	}

	public static CharsMatcherByDepth newMustNotEquals(int blockDepth, char[] blockPrefix, char[] blockSuffix,
			int blocksLimit, CodepointSupport cps) {
		return new CharsMatcherByDepthMustNotEquals(blockDepth, blockPrefix, blockSuffix, blocksLimit, cps);
	}

}
