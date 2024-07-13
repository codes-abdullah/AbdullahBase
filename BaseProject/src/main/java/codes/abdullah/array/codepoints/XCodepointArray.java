package codes.abdullah.array.codepoints;

import codes.abdullah.array.XArray;
import codes.abdullah.array.chars.XCharArray;
import codes.abdullah.array.codepoints.support.XCodepointSupport;
import codes.abdullah.project.ImplementationRequiredException;

public interface XCodepointArray extends XArray<XCodepointArray> {

	XCodepointArray assign(XCharArray array, int spcount, XCodepointSupport cps);

	XCodepointArray newInstance(XCharArray array, int spcount, XCodepointSupport cps);

	XCharArray getArray();

	/**
	 * Actual length
	 */
	int lengthActual();

	// ======================

	/**
	 * The count of all surrogate-pairs
	 */
	int getPairsCount();

	XCodepointSupport getPairsSupport();

	/**
	 * @see #toCodepointArray(int, int, XCodepointSupport)
	 */
	int[] toCodepointArray();

	/**
	 * @see #toCodepointArray(int, int, XCodepointSupport)
	 */
	int[] toCodepointArray(int from);

	/**
	 * @see #toCodepointArray(int, int, XCodepointSupport)
	 */
	int[] toCodepointArray(int from, int to);

	/**
	 * @return if {@link XCodepointSupport#isSupported()}, new trimmed-copy with
	 *         combination of bmp and supplementary code-points, otherwise new
	 *         trimmed-copy of bmp array
	 */
	int[] toCodepointArray(int from, int to, XCodepointSupport cps);

	
	// =========================
	static XCodepointArray of() {
		return of(XCharArray.of());
	}

	static XCodepointArray of(XCharArray xarr) {
		return of(xarr, 0);
	}

	static XCodepointArray of(XCharArray xarr, int spcount) {
		return of(xarr, spcount, XCodepointSupport.BMP);
	}

	/**
	 * @return mutable-codepoint array implementation
	 */
	static XCodepointArray of(XCharArray xarr, int spcount, XCodepointSupport cps) {
		//if (cps != null && cps.isSupported())
			//return new XMutableSupplementaryCodepointArray(xarr, spcount, cps);
		//return null;// new XMutableBmpCodepointArray(xarr);
		throw new ImplementationRequiredException();
	}

}
