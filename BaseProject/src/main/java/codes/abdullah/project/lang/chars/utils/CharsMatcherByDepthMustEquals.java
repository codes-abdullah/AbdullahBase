package codes.abdullah.project.lang.chars.utils;

import java.util.Arrays;

import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;

class CharsMatcherByDepthMustEquals extends CharsMatcherMustEquals implements CharsMatcherByDepth {
	private final int targetDepth, blocksLimit;
	private final char[] blockPrefix, blockSuffix;
	private final boolean identical;
//	private final CodepointSupport cps;
	private int currentDepth, remainBlocks;

	public CharsMatcherByDepthMustEquals(int targetDepth, char[] blockPrefix, char[] blockSuffix, int blocksLimit,
			CodepointSupport cps) {
		this.targetDepth = targetDepth;
		this.blockPrefix = blockPrefix;
		this.blockSuffix = blockSuffix;
		this.blocksLimit = Check.aboveZero(blocksLimit);
		this.remainBlocks = blocksLimit;
		this.identical = Arrays.equals(blockPrefix, blockSuffix);
//		this.cps = cps == null ? CodepointSupport.BMP : cps;
	}

	@Override
	public CharsMatcherByDepth reset() {
		this.remainBlocks = blocksLimit;
		this.currentDepth = 0;
		return this;
	}

	@Override
	public boolean stopTrying() {
		return remainBlocks == 0;
	}

	@Override
	public boolean tryMatchBmp(char[] arr, int len, int index, int target, boolean ignoreCase,
			CodepointSupport cps) {
		boolean matched = false;
		if (currentDepth == targetDepth && remainBlocks > 0) {
			matched = super.tryMatchBmp(arr, len, index, target, ignoreCase, cps);
		}
		check(arr, len, index, ignoreCase);
		return matched;
	}

	@Override
	public boolean tryMatchPair(char[] arr, int len, int index, char targetHigh, char targetLow,
			boolean ignoreCase, CodepointSupport cps) {
		boolean matched = false;
		if (currentDepth == targetDepth) {
			matched = super.tryMatchPair(arr, len, index, targetHigh, targetLow, ignoreCase, cps);
		}
		check(arr, len, index, ignoreCase);
		return matched;
	}

	@Override
	public boolean tryMatchAny(char[] arr, int len, int index, int[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps) {
		boolean matched = false;
		if (currentDepth == targetDepth) {
			matched = super.tryMatchAny(arr, len, index, targets, targetsLen, ignoreCase, cps);
		}
		check(arr, len, index, ignoreCase);
		return matched;
	}

	@Override
	public boolean tryMatchAny(char[] arr, int len, int index, char[] targets, int targetsLen, boolean ignoreCase,
			CodepointSupport cps) {
		boolean matched = false;
		if (currentDepth == targetDepth) {
			matched = super.tryMatchAny(arr, len, index, targets, targetsLen, ignoreCase, cps);
		}
		check(arr, len, index, ignoreCase);
		return matched;
	}

	@Override
	public boolean tryMatchArray(char[] arr, int len, int index, char[] target, int targetLength, boolean ignoreCase,
			CodepointSupport cps) {
		boolean matched = false;
		if (currentDepth == targetDepth) {
			matched = super.tryMatchArray(arr, len, index, target, targetLength, ignoreCase, cps);
		}
		check(arr, len, index, ignoreCase);
		return matched;
	}

	protected void check(char[] arr, int len, int index, boolean iqnoreCase) {
		if (Lang.chararray.starts.with(arr, len, index, blockPrefix, blockPrefix.length, iqnoreCase)) {

			// in case of blockSuffix equals blockPrefix, will consider below as suffix
			if (identical) {
				currentDepth--;
				remainBlocks--;
				checkBalance(arr, len);
				return;
			}

			currentDepth++;
			return;
		}

		if (Lang.chararray.starts.with(arr, len, index, blockSuffix, blockSuffix.length, iqnoreCase)) {
			currentDepth--;
			remainBlocks--;
			checkBalance(arr, len);
			return;
		}
	}

	private void checkBalance(char[] arr, int len) {
		if (currentDepth < 0) {
			throw new IllegalArgumentException("unbalanced depth for: " + new String(arr, 0, len));
		}
	}

}
