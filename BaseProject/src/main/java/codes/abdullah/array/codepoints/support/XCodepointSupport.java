package codes.abdullah.array.codepoints.support;

import codes.abdullah.array.chars.XCharArray;
import codes.abdullah.project.lang.chars.codepoint.LColumn;

/**
 * Invoker must take care of all checks such as ranges, valid code-points and
 * null pointers<br>
 * <br>
 * This interface has 3 implementations:<br>
 * <b>{@link #BMP}: </b>which will consider any given code-point as normal char
 * (even the range of surrogates will be considered as regular chars)<br>
 * <b>{@link #SUPPORTED}: </b>which will consider the code-point in range of
 * surrogates min/max<br>
 * <b>{@link #DEBUG}</b>: which can be used for debugging mode, is extends
 * SUPPORTED, but will consider A-Z as high surrogates and 0-9 as low
 * surrogates<br>
 */
public interface XCodepointSupport {
	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * 
	 * 
	 * 
	 * All implemented methods will return false, only lengthOf methods will return
	 * 1 for any code-point, and count methods will return the given range as count
	 */
	public static final XCodepointSupport BMP = new XCodepointSupportBmpImpl();
	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * High-surrogates: 0xD800-0xDBFF<br>
	 * Low-surrogates: 0xDC00-0xDFFF<br>
	 */
	public static final XCodepointSupport SUPPORTED = new XCodepointSupportSupplementaryImpl();
	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * For debug only<br>
	 * High-surrogates: A-Z<br>
	 * Low-surrogates: 1-9<br>
	 */
	public static final XCodepointSupport DEBUG = new XCodepointSupportSupplementaryDebugImpl();

	public static final int MIN_HIGH_SURROGATE = 0xD800;
	public static final int MAX_HIGH_SURROGATE = 0xDBFF;
	public static final int MIN_LOW_SURROGATE = 0xDC00;
	public static final int MAX_LOW_SURROGATE = 0xDFFF;

	// =================
	// ================= reindex
	// =================

	/**
	 * @see #reindex(char[], int, int)
	 */
	int reindex(CharSequence cs, int index);

	/**
	 * {@link #reindex(char[], int, int[])}
	 */
	int[] reindex(CharSequence cs, int[] indexes);

	/**
	 * - {@link #BMP}: returns index<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns index +
	 * {@link #extendablePairsCount(char[], int, int, int)}, range: from(0),
	 * to(index)<br>
	 */
	int reindex(XCharArray xarr, int index);

	/**
	 * Will assume all indexes are on <b>same context</b> and are in <b>descending
	 * order</b>, e.g:<br>
	 * src: codeS4.A6bdullah, indexes = {0, 4, 5, 6, 7, 10}<br>
	 * output: [0, 5, 7, 8, 10, 14]
	 * 
	 */
	int[] reindex(XCharArray xarr, int[] indexes);

	// =================
	// ================= is-bmp
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: invokes {@link #isBmp(int)}<br>
	 * - {@link #SUPPORTED}: invokes {@link Character#isValidCodePoint(int)}<br>
	 * - {@link #DEBUG}: true if {@link #isBmp(int)} or {@link #isPair(int)}<br>
	 */
	boolean isValid(int cp);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED}: always true<br>
	 * - {@link #DEBUG}: always true<br>
	 */
	boolean isSupported();
	// =================
	// ================= is-bmp
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}, {@link #SUPPORTED} and {@link #DEBUG}: invokes
	 * {@link Character#isBmpCodePoint(int)}<br>
	 */
	boolean isBmp(int cp);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}, {@link #SUPPORTED} and {@link #DEBUG}: true if arr[index] is
	 * bmp according to {@link #isBmp(int)}<br>
	 */
	boolean isBmp(XCharArray xarr, int index);

	/**
	 * @se {@link #isBmp(char[], int, int)}
	 */
	boolean isBmp(CharSequence cs, int index);

	/**
	 * {@link #isBmp(char[], int, int)}
	 */
	boolean isBmp(int[] arr, int len, int index);

	// =================
	// ================= is-pair
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * 
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED}: true in range:
	 * {@link Character#MIN_SUPPLEMENTARY_CODE_POINT} to
	 * {@link Character#MAX_CODE_POINT}<br>
	 * - {@link #DEBUG}: true according to
	 * {@link XCodepointSupportSupplementaryDebugImpl#cps}<br>
	 */
	boolean isPair(int ch);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED}: true if high in range 0xD800-0xDBFF and low in range
	 * 0xDC00-0xDFFF<br>
	 * - {@link #DEBUG}: true if high in range 'A'-'Z' and low in range '0'-'9'<br>
	 */
	boolean isPair(int high, int low);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: true if arr[index] is high, and
	 * arr[index+1] is low<br>
	 */
	boolean isPair(XCharArray xarr, int index);

	/**
	 * {@link #isPair(char[], int, int)}
	 */
	boolean isPair(CharSequence cs, int index);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: true if arr[index] is valid
	 * according to {@link #is(int)}<br>
	 */
	boolean isPair(int[] arr, int len, int index);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: true if arr[index-2] is high, and
	 * arr[index-1] is low<br>
	 */
	boolean isPairBackwardly(XCharArray xarr, int index);

	/**
	 * {@link #isPairBackwardly(char[], int, int)}
	 */
	boolean isPairBackwardly(CharSequence cs, int index);

	// =================
	// ================= is-any
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}, {@link #SUPPORTED} and {@link #DEBUG}: true if high or
	 * low<br>
	 */
	boolean isHighOrLow(int ch);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}, {@link #SUPPORTED} and {@link #DEBUG}: true if high or
	 * low<br>
	 */
	boolean isHighOrLow(XCharArray xarr, int index);

	/**
	 * {@link #isHighOrLow(char[], int, int)}
	 */
	boolean isHighOrLow(CharSequence cs, int index);

	// =================
	// ================= is-high/low
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP} && {@link #SUPPORTED}: true if high<br>
	 * - {@link #DEBUG}: true if high in range 'A'-'Z'<br>
	 */
	boolean isHigh(int ch);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP} && {@link #SUPPORTED}: true if low<br>
	 * - {@link #DEBUG}: true if low in range '0'-'9'<br>
	 */
	boolean isLow(int ch);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP} && {@link #SUPPORTED}: true if high<br>
	 * - {@link #DEBUG}: true if high in range 'A'-'Z'<br>
	 */
	boolean isHigh(XCharArray xarr, int index);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP} && {@link #SUPPORTED}: true if low<br>
	 * - {@link #DEBUG}: true if low in range '0'-'9'<br>
	 */
	boolean isLow(XCharArray xarr, int index);

	/**
	 * {@link #isHigh(CharSequence, int)}
	 */
	boolean isHigh(CharSequence cs, int index);

	/**
	 * {@link #isLow(char[], int, int)}
	 */
	boolean isLow(CharSequence cs, int index);

	// =================
	// ================= is-intersect
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: true if arr[index-1] is high, and
	 * arr[index] is low<br>
	 */
	boolean isPairIntersectly(XCharArray xarr, int index);

	/**
	 * {@link #isPairIntersectly(char[], int, int)}
	 */
	boolean isPairIntersectly(CharSequence cs, int index);

	// =================
	// ================= get code-point
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Exactly like {@link Character#codePointAt(char[], int)}<br>
	 * <br>
	 * 
	 * - {@link #BMP}: returns arr[index]<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: if arr[index] is high and
	 * arr[index+1] is low, return supplementary code-point based on implementation,
	 * otherwise return arr[index]<br>
	 */
	int getCodepoint(XCharArray xarr, int index);

	/**
	 * {@link #getCodepoint(char[], int, int)}
	 */
	int getCodepoint(CharSequence cs, int index);

	/**
	 * Equivalent to {@link Character#codePointAt(char[], int)<br>
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: returns arr[index]<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: if arr[index-2] is high and
	 * arr[index - 1] is low, return supplementary code-point based on
	 * implementation, otherwise return arr[index -1]<br>
	 */
	int getCodepointBackwardly(XCharArray xarr, int index);

	/**
	 * {@link #getCodepointBackwardly(char[], int, int)}
	 */
	int getCodepointBackwardly(CharSequence cs, int index);

	// =================
	// ================= to high/low
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Exactly like {@link Character#highSurrogate(int)}<br>
	 * <br>
	 * - {@link #BMP}: returns (char)cp<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: if {@link #is(int)} is true, return
	 * high-surrogate of this code-point based on implementation<br>
	 */
	char toHigh(int cp);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Exactly like {@link Character#lowSurrogate(int)}<br>
	 * <br>
	 * - {@link #BMP}: returns (char)cp<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: if {@link #is(int)} is true, return
	 * low-surrogate of this code-point based on implementation<br>
	 */
	char toLow(int cp);

	/**
	 * @see #toHigh(int)
	 */
	char toHigh(XCharArray xarr, int index);

	/**
	 * @see #toLow(int)
	 */
	char toLow(XCharArray xarr, int index);

	/**
	 * @see #toHigh(int)
	 */
	char toHigh(CharSequence cs, int index);

	/**
	 * @see #toLow(int)
	 */
	char toLow(CharSequence cs, int len, int index);

	// =================
	// ================= to code-point
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Exactly like {@link Character#toCodePoint(char, char)}<br>
	 * <br>
	 * - {@link #BMP}: returns -1<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: combine into supplementary
	 * code-point based on implementation<br>
	 */
	int toCodepoint(char high, char low);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Exactly like {@link Character#toCodePoint(char, char)}<br>
	 * <br>
	 * - {@link #BMP}: returns -1<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: combine into supplementary
	 * code-point based on implementation<br>
	 */
	int toCodepoint(int high, int low);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * This is convenient method for 1 pair to be converted to supplementary
	 * code-point, it will invoke {@link #codePointAt(CharSequence, int)} with index
	 * 0<br>
	 * - {@link #BMP}: arr[0]<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: combine into supplementary
	 * code-point based on implementation, and given range<br>
	 */
	int toCodepoint(CharSequence cs);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Exactly like {@link Character#toCodePoint(char, char)}<br>
	 * <br>
	 * - {@link #BMP}: returns arr[index]<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: combine into supplementary
	 * code-point based on implementation<br>
	 */
	int toCodepoint(XCharArray xarr, int index);

	/**
	 * {@link #toCodepoint(char[], int, int)}
	 */
	int toCodepoint(CharSequence cs, int index);

	/**
	 * 
	 * */
	int toCodepointBackwardly(XCharArray xarr, int index);

	/**
	 * {@link #toCodepointBackwardly(char[], int, int)
	 */
	int toCodepointBackwardly(CharSequence cs, int index);

	/**
	 * 
	 * */
	int toCodepointIntersectly(XCharArray xarr, int index);

	/**
	 * {@link #toCodepointIntersectly(char[], int, int)
	 */
	int toCodepointIntersectly(CharSequence cs, int index);

	// =================
	// ================= to code-points array
	// =================

	/**
	 * {@link #toCodepointArray(char[], int, int, int)}
	 */
	int[] toCodepointArray(CharSequence cs);

	/**
	 * {@link #toCodepointArray(char[], int, int, int)}
	 */
	int[] toCodepointArray(CharSequence cs, int from);

	/**
	 * {@link #toCodepointArray(char[], int, int, int)}
	 */
	int[] toCodepointArray(CharSequence cs, int from, int to);

	/**
	 * {@link #toCodepointArray(char[], int, int, int)}
	 */
	int[] toCodepointArray(XCharArray xarr);

	/**
	 * {@link #toCodepointArray(char[], int, int, int)}
	 */
	int[] toCodepointArray(XCharArray xarr, int from);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * <br>
	 * - {@link #BMP}: returns normal bmp int-array based on given range<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: combine into bmp and supplementary
	 * code-point array based on {@link #codePointAt(char[], int, int)} and
	 * {@link #codePointBackward(char[], int, int)}, based on implementation, and
	 * given range<br>
	 */
	int[] toCodepointArray(XCharArray xarr, int from, int to);

	// =================
	// ================= to char-array
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * This is convenient method for 1 code-point to be converted to high/low pair,
	 * if code-point is not supplementary, return it<br>
	 * - {@link #BMP}: arr[0]<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: if given code-point is
	 * supplementary, return array with high/low, otherwise return array contains
	 * given cp<br>
	 */
	XCharArray toCharArray(int cp);

	/**
	 * @see #toCharArray(int[], int, int, int, char[], int)
	 */
	XCharArray toCharArray(int[] arr, int len);

	/**
	 * @see #toCharArray(int[], int, int, int, char[], int)
	 */
	XCharArray toCharArray(int[] arr, int len, int from);

	/**
	 * @see #toCharArray(int[], int, int, int, char[], int)
	 */
	XCharArray toCharArray(int[] arr, int len, int from, int to);

	/**
	 * @see #toCharArray(int[], int, int, int, char[], int)
	 */
	XCharArray toCharArray(int[] arr, int len, int from, int to, XCharArray out);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * <br>
	 * - {@link #BMP}: returns normal bmp char-array based on given range, if given
	 * array contains supplementary code-points, will cast them into char-type
	 * without any further checks, output array length is always equals to input
	 * range<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: copy given code-points into
	 * char-array, if supplementaries exists, decode them into high/low and extend
	 * the char-array length, the output array always trimmed to length<br>
	 */
	XCharArray toCharArray(int[] arr, int len, int from, int to, XCharArray out, int outlen);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * <br>
	 * - {@link #BMP}: returns normal bmp char-array based on given range, if given
	 * array contains supplementary code-points, will cast them into char-type
	 * without any further checks, output array length is always equals to input
	 * range<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: copy given code-points into
	 * char-array, if supplementaries exists, decode them into high/low and extend
	 * the char-array length, the output array always trimmed to length<br>
	 */
	int toCharArray(int cp, XCharArray out, int outlen, int insertAt);

	// =================
	// ================= count code-points
	// =================

	/**
	 * @see #countCodepoints(char[], int, int, int)
	 */
	int countCodepoints(XCharArray xarr);

	/**
	 * @see #countCodepoints(char[], int, int, int)
	 */
	int countCodepoints(XCharArray xarr, int from);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Exactly like {@link String#codePointCount(int, int)}<br>
	 * Count the code-points based on given range, including bmp<br>
	 * e.g:<br>
	 * from 0 to 4, cA1.B2C<br>
	 * <br>
	 * {@link #BMP}: returns 4<br>
	 * {@link #SUPPORTED}: returns 3 (assuming A1 is valid surrogate-pair)
	 * {@link #DEBUG}: returns 3 (since A1 is valid surrogate-pair according to
	 * debug implementation)
	 * 
	 * <br>
	 * - {@link #BMP}: return to - from<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: count of code-points including bmp,
	 * valid surrogate-pairs are counted 1
	 */
	int countCodepoints(XCharArray xarr, int from, int to);

	/**
	 * @see #countCodepoints(char[], int, int, int)
	 */
	int countCodepoints(CharSequence cs);

	/**
	 * @see #countCodepoints(char[], int, int, int)
	 */
	int countCodepoints(CharSequence cs, int from);

	/**
	 * @see #countCodepoints(char[], int, int, int)
	 */
	int countCodepoints(CharSequence cs, int from, int to);

	// =================
	// ================= extendable pairs count
	// =================

	/**
	 * @see #extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(XCharArray xarr);

	/**
	 * @see #extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(XCharArray xarr, int from);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Count only surrogate-pairs within given range, and extends the range during
	 * the count<br>
	 * e.g #1: {cA1.}B2C3bdD4h, range 0-4:, count = 2, first pair extends the range
	 * by 1 after being detected, so will be {cA1.B}2C3bdD4h, therefore, second pair
	 * will be detected<br>
	 * e.g #2: cA{1.B}2C3bdD4h, range 0-4, count = 1, first intersection was not
	 * taken in consideration, but second has been noticed<br>
	 * 
	 * 
	 * <br>
	 * - {@link #BMP}: always 0<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: count of surrogate-pairs in
	 * extendable-mode<br>
	 * 
	 * <pre>
	 * <code>
	 * final int fromDisp = spc.extendablePairsCount(arr, alen, sps, 0, from);
	 * from += fromDisp;
	 * to += fromDisp;
	 * final int toDisp = spc.extendablePairsCount(arr, alen, sps, from, to);
	 * to += toDisp;
	 * </code>
	 * </pre>
	 */
	int extendablePairsCount(XCharArray xarr, int from, int to);

	/**
	 * @see #extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(CharSequence cs);

	/**
	 * @see #extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(CharSequence cs, int from);

	/**
	 * @see #extendablePairsCount(char[], int, int, int)
	 */
	int extendablePairsCount(CharSequence cs, int from, int to);

	// =================
	// ================= fixed pairs count
	// =================

	/**
	 * @see #fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(XCharArray xarr);

	/**
	 * @see #fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(XCharArray xarr, int from);

	/**
	 * @see #fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(XCharArray xarr, int from, int to);

	/**
	 * @see #fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(CharSequence cs);

	/**
	 * @see #fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(CharSequence cs, int from);

	/**
	 * @see #fixedPairsCount(char[], int, int, int)
	 */
	int fixedPairsCount(CharSequence cs, int from, int to);

	// =================
	// ================= length of
	// =================

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * <br>
	 * - {@link #BMP}: returns 1 if valid bmp, otherwise 0<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: 2 if {@link #is(int)} true, else 1
	 * if bmp, otherwise 0<br>
	 */
	int lengthOf(int ch);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: returns 1 if arr[index] is valid bmp, otherwise 0<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns 2 if arr[index] is high and
	 * arr[index+1] is low true, else returns 1 if arr[index] is bmp, otherwise
	 * 0<br>
	 * 
	 * @see #lengthOf(int)
	 */
	int lengthOf(XCharArray xarr, int index);

	/**
	 * @see #lengthOf(char[], int, int)
	 */
	int lengthOf(CharSequence cs, int index);

	/**
	 * @see #lengthOf(int)
	 */
	int lengthOf(int[] arr, int len, int index);

	/**
	 * @see #columnsOf(int, int)
	 */
	int columnsOf(int ch);

	/**
	 * Gets column-length of given codepoint<br>
	 * <br>
	 * Why no array-based implementation?<br>
	 * In short: we need to know the column-index, and not the sequence-index, so
	 * better to use {@link LColumn#from(char[], int, int, int, XCodepointSupport)}
	 * <br>
	 * See below example:<br>
	 * 
	 * <pre>
	 * 	cO1des.	aB2d	ullah
	 * tab at index 8 = 1 column, but if we replaced tab at index 0 by bmp
	 * 
	 * XcO1des.	aB2d	ullah
	 * the same tab at index 8 = 8 columns
	 * 
	 * </pre>
	 * 
	 * <br>
	 * The reason: tabs relies on column-index, and not sequence-index, so first
	 * example, the sequence-index of tab was 8, but column-index was 15, which
	 * means 15%8 = 7, thats why it shows a column-length of 1 only, and the second
	 * example, when we inject X, the sequence-index was same, but column-index
	 * changed to 8, which is means 8%8 = 0, that's why it consider itself at index
	 * 0<br>
	 * 
	 * <br>
	 * - {@link #BMP}: returns 1 if valid bmp, otherwise if is tab, return tabSize,
	 * else 0<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: 2 if {@link #is(int)} true, else 1
	 * if bmp, otherwise if tab, return tabSize, else 0<br>
	 */
	int columnsOf(int ch, int tabSize);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: returns 1 if arr[index - 1] is valid bmp, otherwise 0<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns 2 if arr[index-2] is high
	 * and arr[index-1] is low, else returns 1 if arr[index - 1] is bmp, otherwise
	 * 0<br>
	 * 
	 * @see #lengthOf(int)
	 */
	int lengthOfBackwardly(XCharArray xarr, int index);

	/**
	 * @see #lengthOfBackwardly(char[], int, int)
	 */
	int lengthOfBackwardly(CharSequence cs, int index);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: returns 1 if arr[index] is valid bmp, otherwise 0<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns 2 if arr[index-1] is high
	 * and arr[index] is low true, else returns 1 if arr[index] is bmp, otherwise
	 * 0<br>
	 * 
	 * @see #lengthOf(int)
	 */
	int lengthOfIntersectly(XCharArray xarr, int index);

	/**
	 * @see #lengthOfIntersectly(char[], int, int)
	 */
	int lengthOfIntersectly(CharSequence cs, int index);

	// =================
	// ================= index of broken
	// =================

	/**
	 * @see #indexOfBroken(char[], int, int, int)
	 */
	int indexOfBroken(XCharArray xarr);

	/**
	 * 
	 * @see #indexOfBroken(char[], int, int, int)
	 */
	int indexOfBroken(XCharArray xarr, int from);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * - {@link #BMP}: returns -1<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns index of any leftover high
	 * or low surrogates, -1 if nothing found<br>
	 */
	int indexOfBroken(XCharArray xarr, int from, int to);

	/**
	 * @see #indexOfBroken(char[], int, int, int)
	 */
	int indexOfBroken(CharSequence cs);

	/**
	 * @see #indexOfBroken(char[], int, int, int)
	 */
	int indexOfBroken(CharSequence cs, int from);

	/**
	 * @see #indexOfBroken(char[], int, int, int)
	 */
	int indexOfBroken(CharSequence cs, int from, int to);

	// =================
	// ================= to string
	// =================

	/**
	 * Convert codepoint to string representation
	 */
	String toString(int cp);

	// =================
	// ================= equals
	// =================

	/**
	 * @see #equals(int, int, boolean)
	 */
	boolean equals(int cp1, int cp2);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given codepoints according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}, {@link #SUPPORTED} and {@link #DEBUG}: returns true if cp1 ==
	 * cp2
	 */
	boolean equals(int cp1, int cp2, boolean ignoreCase);

	// -------------

	/**
	 * @see #equals(char, char, char, char, boolean)
	 */
	boolean equals(char high, char low, char otherHigh, char otherLow);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given pairs according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns true if arr[index] ==
	 * otherHigh and arr[index+1] == otherLow
	 */
	boolean equals(char high, char low, char otherHigh, char otherLow, boolean ignoreCase);

	// -------------

	/**
	 * @see #equals(char[], int, int, int, boolean)
	 */
	boolean equals(XCharArray xarr, int index, int cp);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given pairs according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns true if arr[index] ==
	 * otherHigh and arr[index+1] == otherLow
	 */
	boolean equals(XCharArray xarr, int index, int cp, boolean ignoreCase);

	// --------------

	/**
	 * @see #equals(char[], int, int, char, char, boolean)
	 */
	boolean equals(XCharArray xarr, int index, char otherHigh, char otherLow);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given pairs according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns true if arr[index] ==
	 * otherHigh and arr[index+1] == otherLow
	 */
	boolean equals(XCharArray xarr, int index, char otherHigh, char otherLow, boolean ignoreCase);

	// -------------

	/**
	 * @see #equalsIntersectly(char[], int, int, int, boolean)
	 */
	boolean equalsIntersectly(XCharArray xarr, int index, int cp);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given pairs according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns true if arr[index-1] ==
	 * otherHigh and arr[index] == otherLow
	 */
	boolean equalsIntersectly(XCharArray xarr, int index, int cp, boolean ignoreCase);

	// --------------

	/**
	 * @see #equalsIntersectly(char[], int, int, char, char, boolean)
	 */
	boolean equalsIntersectly(XCharArray xarr, int index, char otherHigh, char otherLow);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given pairs according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns true if arr[index-1] ==
	 * otherHigh and arr[index] == otherLow
	 */
	boolean equalsIntersectly(XCharArray xarr, int index, char otherHigh, char otherLow, boolean ignoreCase);

	// -------------

	/**
	 * @see #equalsBackwardly(char[], int, int, int, boolean)
	 */
	boolean equalsBackwardly(XCharArray xarr, int index, int cp);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given pairs according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns true if arr[index-2] ==
	 * otherHigh and arr[index-1] == otherLow
	 */
	boolean equalsBackwardly(XCharArray xarr, int index, int cp, boolean ignoreCase);

	// --------------
	/**
	 * @see #equalsBackwardly(char[], int, int, char, char, boolean)
	 */
	boolean equalsBackwardly(XCharArray xarr, int index, char otherHigh, char otherLow);

	/**
	 * Invoker must take care of all checks such as ranges, valid code-points and
	 * null pointers<br>
	 * <br>
	 * Compare given pairs according to given case-sensitive flag<br>
	 * <br>
	 * - {@link #BMP}: always false<br>
	 * - {@link #SUPPORTED} and {@link #DEBUG}: returns true if arr[index-2] ==
	 * otherHigh and arr[index-1] == otherLow
	 */
	boolean equalsBackwardly(XCharArray xarr, int index, char otherHigh, char otherLow, boolean ignoreCase);

	// -------------

	/**
	 * @see #equals(char[], int, int, char, char, boolean)
	 */
	boolean equals(CharSequence cs, int index, char otherHigh, char otherLow);

	/**
	 * @see #equals(char[], int, int, char, char, boolean)
	 */
	boolean equals(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase);

	// -------------

	/**
	 * @see #equals(char[], int, int, int, boolean)
	 */
	boolean equals(CharSequence cs, int index, int cp);

	/**
	 * @see #equals(char[], int, int, int, boolean)
	 */
	boolean equals(CharSequence cs, int index, int cp, boolean ignoreCase);

	// --------------

	/**
	 * @see #equalsIntersectly(char[], int, char, char, boolean)
	 */
	boolean equalsIntersectly(CharSequence cs, int index, char otherHigh, char otherLow);

	/**
	 * @see #equalsIntersectly(char[], int, char, char, boolean)
	 */
	boolean equalsIntersectly(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase);

	// --------------

	/**
	 * @see #equalsIntersectly(char[], int, int, int, boolean)
	 */
	boolean equalsIntersectly(CharSequence cs, int index, int cp);

	/**
	 * @see #equalsIntersectly(char[], int, int, int, boolean)
	 */
	boolean equalsIntersectly(CharSequence cs, int index, int cp, boolean ignoreCase);

	// --------------
	/**
	 * @see #equalsBackwardly(char[], int, int, char, char, boolean)
	 */
	boolean equalsBackwardly(CharSequence cs, int index, char otherHigh, char otherLow);

	/**
	 * @see #equalsBackwardly(char[], int, int, char, char, boolean)
	 */
	boolean equalsBackwardly(CharSequence cs, int index, char otherHigh, char otherLow, boolean ignoreCase);

	// --------------

	/**
	 * @see #equalsBackwardly(char[], int, int, int, boolean)
	 */
	boolean equalsBackwardly(CharSequence cs, int index, int cp);

	/**
	 * @see #equalsBackwardly(char[], int, int, int, boolean)
	 */
	boolean equalsBackwardly(CharSequence cs, int index, int cp, boolean ignoreCase);

	// =================
	// ================= case
	// =================

	boolean isLowerCase(int cp);

	boolean isUpperCase(int cp);

	boolean isLowerCase(char ch);

	boolean isUpperCase(char ch);

	int toLowerCase(int cp);

	int toUpperCase(int cp);

	char toLowerCase(char ch);

	char toUpperCase(char ch);

	boolean isLinefeed(int cp);

	boolean isWhitespace(int cp);

	/**
	 * - ⁰ [U+2070] - ¹ [U+00B9, Latin-1 Supplement] - ² [U+00B2, Latin-1
	 * Supplement] - ³ [U+00B3, Latin-1 Supplement] - ⁴ [U+2074] - ⁵ [U+2075] - ⁶
	 * [U+2076] - ⁷ [U+2077] - ⁸ [U+2078] - ⁹
	 */
	boolean isSuperscriptDigit(int cp);

	/**
	 * - ⁰ [U+2070] - ¹ [U+00B9, Latin-1 Supplement] - ² [U+00B2, Latin-1
	 * Supplement] - ³ [U+00B3, Latin-1 Supplement] - ⁴ [U+2074] - ⁵ [U+2075] - ⁶
	 * [U+2076] - ⁷ [U+2077] - ⁸ [U+2078] - ⁹ [U+2079] - ⁺ [U+207A] - ⁻ [U+207B] - ⁼
	 * [U+207C] - ⁽ [U+207D] - ⁾ [U+207E] - ⁿ [U+207F] - ⁱ [U+2071]
	 */
	boolean isSuperscript(int cp);

	int superscriptToAscii(int cp);
}
