package codes.abdullah.array.codepoints.support;

import codes.abdullah.array.wrapper.codepoint.CodepointArray;

/**
 * Useful implementation to delegate the count process to {@link CodepointArray}
 * wrapper, in case of any lazy calculation required by the wrapper, we can
 * disable the delegation easily within the {@link CodepointArray} instance
 * 
 * @see #IQNORE
 * @see #COUNT
 */
public interface CodepointSupportPairsCounter {
	CodepointSupportPairsCounter IQNORE = new IqnoreSurrogatePair();
	CodepointSupportPairsCounter COUNT = new CountSurrogatePair();

	/**
	 * Count surrogate-pairs <br>
	 * {@link #IQNORE}: always 0<br>
	 * {@link #COUNT}: count of pair as 1<br>
	 */
	int countPairs(char[] arr, int len, CodepointSupport cps);

	/**
	 * Count surrogate-pairs <br>
	 * {@link #IQNORE}: always 0<br>
	 * {@link #COUNT}: count of pair as 1<br>
	 */
	int countPairs(char[] arr, int len, CodepointSupport cps, int from);

	/**
	 * Count surrogate-pairs <br>
	 * {@link #IQNORE}: always 0<br>
	 * {@link #COUNT}: count of pair as 1<br>
	 */
	int countPairs(char[] arr, int len, CodepointSupport cps, int from, int to);

	/**
	 * Count code-points <br>
	 * {@link #IQNORE}: count of bmp as 1, and count of pair as 2<br>
	 * {@link #COUNT}: count of bmp as 1, and count of pair as 1<br>
	 */
	int countCodepoints(char[] arr, int len, CodepointSupport cps);

	/**
	 * Count code-points <br>
	 * {@link #IQNORE}: count of bmp as 1, and count of pair as 2<br>
	 * {@link #COUNT}: count of bmp as 1, and count of pair as 1<br>
	 */
	int countCodepoints(char[] arr, int len, CodepointSupport cps, int from);

	/**
	 * Count code-points <br>
	 * {@link #IQNORE}: count of bmp as 1, and count of pair as 2<br>
	 * {@link #COUNT}: count of bmp as 1, and count of pair as 1<br>
	 */
	int countCodepoints(char[] arr, int len, CodepointSupport cps, int from, int to);

	/**
	 * Count surrogate-pairs using extendable-mode <br>
	 * 
	 * @see CodepointSupport#extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(char[] arr, int len, CodepointSupport cps);

	/**
	 * Count surrogate-pairs using extendable-mode <br>
	 * 
	 * @see CodepointSupport#extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(char[] arr, int len, CodepointSupport cps, int from);

	/**
	 * Count surrogate-pairs using extendable-mode <br>
	 * 
	 * @see CodepointSupport#extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(char[] arr, int len, CodepointSupport cps, int from, int to);

	// =================

	/**
	 * Count surrogate-pairs using fixed-mode <br>
	 * 
	 * @see CodepointSupport#fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(char[] arr, int len, CodepointSupport cps);

	/**
	 * Count surrogate-pairs using fixed-mode <br>
	 * 
	 * @see CodepointSupport#fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(char[] arr, int len, CodepointSupport cps, int from);

	/**
	 * Count surrogate-pairs using fixed-mode <br>
	 * 
	 * @see CodepointSupport#fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(char[] arr, int len, CodepointSupport cps, int from, int to);

	public static class IqnoreSurrogatePair implements CodepointSupportPairsCounter {

		private IqnoreSurrogatePair() {
		}

		@Override
		public int countPairs(char[] arr, int len, CodepointSupport cps) {
			return countPairs(arr, len, cps, 0);
		}

		@Override
		public int countPairs(char[] arr, int len, CodepointSupport cps, int from) {
			return countPairs(arr, len, cps, from, len);
		}

		@Override
		public int countPairs(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return 0;
		}

		@Override
		public int countCodepoints(char[] arr, int len, CodepointSupport cps) {
			return countCodepoints(arr, len, cps, 0);
		}

		@Override
		public int countCodepoints(char[] arr, int len, CodepointSupport cps, int from) {
			return countCodepoints(arr, len, cps, from, len);
		}

		@Override
		public int countCodepoints(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return to - from;
		}

		@Override
		public int extendablePairsCount(char[] arr, int len, CodepointSupport cps) {
			return extendablePairsCount(arr, len, cps, 0);
		}

		@Override
		public int extendablePairsCount(char[] arr, int len, CodepointSupport cps, int from) {
			return extendablePairsCount(arr, len, cps, from, len);
		}

		@Override
		public int extendablePairsCount(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return 0;
		}

		@Override
		public int fixedPairsCount(char[] arr, int len, CodepointSupport cps) {
			return fixedPairsCount(arr, len, cps, 0);
		}

		@Override
		public int fixedPairsCount(char[] arr, int len, CodepointSupport cps, int from) {
			return fixedPairsCount(arr, len, cps, from, len);
		}

		@Override
		public int fixedPairsCount(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return 0;
		}

	}

	public static class CountSurrogatePair extends IqnoreSurrogatePair {

		private CountSurrogatePair() {
		}

		@Override
		public int countPairs(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return cps.extendablePairsCount(arr, len, from, to);
		}

		@Override
		public int countCodepoints(char[] arr, int len, CodepointSupport cps) {
			return countCodepoints(arr, len, cps, 0);
		}

		@Override
		public int countCodepoints(char[] arr, int len, CodepointSupport cps, int from) {
			return countCodepoints(arr, len, cps, from, len);
		}

		@Override
		public int countCodepoints(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return cps.countCodepoints(arr, len, from, to);
		}

		@Override
		public int extendablePairsCount(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return cps.extendablePairsCount(arr, len, from, to);
		}

		@Override
		public int fixedPairsCount(char[] arr, int len, CodepointSupport cps, int from, int to) {
			return cps.fixedPairsCount(arr, len, from, to);
		}

	}
}
