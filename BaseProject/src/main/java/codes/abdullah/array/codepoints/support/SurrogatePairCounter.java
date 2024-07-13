package codes.abdullah.array.codepoints.support;

import codes.abdullah.array.chars.XCharArray;
import codes.abdullah.project.CodepointSupport;

/**
 * Useful implementation to delegate the count process to {@link CodepointArray}
 * wrapper, in case of any lazy calculation required by the wrapper, we can
 * disable the delegation easily within the {@link CodepointArray} instance
 * 
 * @see #IQNORE
 * @see #COUNT
 */
public interface SurrogatePairCounter {
	SurrogatePairCounter IQNORE = new IqnoreSurrogatePair();
	SurrogatePairCounter COUNT = new CountSurrogatePair();

	/**
	 * Count surrogate-pairs <br>
	 * {@link #IQNORE}: always 0<br>
	 * {@link #COUNT}: count of pair as 1<br>
	 */
	int countPairs(XCharArray xarr, CodepointSupport cps);

	/**
	 * Count surrogate-pairs <br>
	 * {@link #IQNORE}: always 0<br>
	 * {@link #COUNT}: count of pair as 1<br>
	 */
	int countPairs(XCharArray xarr, CodepointSupport cps, int from);

	/**
	 * Count surrogate-pairs <br>
	 * {@link #IQNORE}: always 0<br>
	 * {@link #COUNT}: count of pair as 1<br>
	 */
	int countPairs(XCharArray xarr, CodepointSupport cps, int from, int to);

	/**
	 * Count code-points <br>
	 * {@link #IQNORE}: count of bmp as 1, and count of pair as 2<br>
	 * {@link #COUNT}: count of bmp as 1, and count of pair as 1<br>
	 */
	int countCodepoints(XCharArray xarr, CodepointSupport cps);

	/**
	 * Count code-points <br>
	 * {@link #IQNORE}: count of bmp as 1, and count of pair as 2<br>
	 * {@link #COUNT}: count of bmp as 1, and count of pair as 1<br>
	 */
	int countCodepoints(XCharArray xarr, CodepointSupport cps, int from);

	/**
	 * Count code-points <br>
	 * {@link #IQNORE}: count of bmp as 1, and count of pair as 2<br>
	 * {@link #COUNT}: count of bmp as 1, and count of pair as 1<br>
	 */
	int countCodepoints(XCharArray xarr, CodepointSupport cps, int from, int to);

	/**
	 * Count surrogate-pairs using extendable-mode <br>
	 * 
	 * @see CodepointSupport#extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(XCharArray xarr, CodepointSupport cps);

	/**
	 * Count surrogate-pairs using extendable-mode <br>
	 * 
	 * @see CodepointSupport#extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(XCharArray xarr, CodepointSupport cps, int from);

	/**
	 * Count surrogate-pairs using extendable-mode <br>
	 * 
	 * @see CodepointSupport#extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(XCharArray xarr, CodepointSupport cps, int from, int to);

	// =================

	/**
	 * Count surrogate-pairs using fixed-mode <br>
	 * 
	 * @see CodepointSupport#fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(XCharArray xarr, CodepointSupport cps);

	/**
	 * Count surrogate-pairs using fixed-mode <br>
	 * 
	 * @see CodepointSupport#fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(XCharArray xarr, CodepointSupport cps, int from);

	/**
	 * Count surrogate-pairs using fixed-mode <br>
	 * 
	 * @see CodepointSupport#fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(XCharArray xarr, CodepointSupport cps, int from, int to);

	public static class IqnoreSurrogatePair implements SurrogatePairCounter {

		private IqnoreSurrogatePair() {
		}

		@Override
		public int countPairs(XCharArray xarr, CodepointSupport cps) {
			return countPairs(xarr, cps, 0);
		}

		@Override
		public int countPairs(XCharArray xarr, CodepointSupport cps, int from) {
			return countPairs(xarr, cps, from, xarr.length());
		}

		@Override
		public int countPairs(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return 0;
		}

		@Override
		public int countCodepoints(XCharArray xarr, CodepointSupport cps) {
			return countCodepoints(xarr, cps, 0);
		}

		@Override
		public int countCodepoints(XCharArray xarr, CodepointSupport cps, int from) {
			return countCodepoints(xarr, cps, from, xarr.length());
		}

		@Override
		public int countCodepoints(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return to - from;
		}

		@Override
		public int extendablePairsCount(XCharArray xarr, CodepointSupport cps) {
			return extendablePairsCount(xarr, cps, 0);
		}

		@Override
		public int extendablePairsCount(XCharArray xarr, CodepointSupport cps, int from) {
			return extendablePairsCount(xarr, cps, from, xarr.length());
		}

		@Override
		public int extendablePairsCount(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return 0;
		}

		@Override
		public int fixedPairsCount(XCharArray xarr, CodepointSupport cps) {
			return fixedPairsCount(xarr, cps, 0);
		}

		@Override
		public int fixedPairsCount(XCharArray xarr, CodepointSupport cps, int from) {
			return fixedPairsCount(xarr, cps, from, xarr.length());
		}

		@Override
		public int fixedPairsCount(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return 0;
		}

	}

	public static class CountSurrogatePair extends IqnoreSurrogatePair {

		private CountSurrogatePair() {
		}

		@Override
		public int countPairs(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return cps.extendablePairsCount(xarr, from, to);
		}

		@Override
		public int countCodepoints(XCharArray xarr, CodepointSupport cps) {
			return countCodepoints(xarr, cps, 0);
		}

		@Override
		public int countCodepoints(XCharArray xarr, CodepointSupport cps, int from) {
			return countCodepoints(xarr, cps, from, xarr.length());
		}

		@Override
		public int countCodepoints(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return cps.countCodepoints(xarr, from, to);
		}

		@Override
		public int extendablePairsCount(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return cps.extendablePairsCount(xarr, from, to);
		}

		@Override
		public int fixedPairsCount(XCharArray xarr, CodepointSupport cps, int from, int to) {
			return cps.fixedPairsCount(xarr, from, to);
		}

	}
}
