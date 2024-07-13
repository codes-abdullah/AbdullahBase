package codes.abdullah.project.lang;

import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.array.wrapper.integer.IntegerArray;

public class LConstants {

	public final char DEFAULT_TAB_CHAR = '\t';
	// =============
	/**
	 * The maximum size of array to allocate. Some VMs reserve some header words in
	 * an array. Attempts to allocate larger arrays may result in OutOfMemoryError:
	 * Requested array size exceeds VM limit
	 * 
	 * src: {@link AbstractStringBuilder#MAX_ARRAY_SIZE}
	 */
	public final int ARRAY_MAX_CAPACITY = Integer.MAX_VALUE - 8;
	/** Safe array capacity, 1 << 29 */
	public final int ARRAY_SAFE_CAPACITY = (1 << 29);
	/** Default array capacity, 1 << 4 */
	public final int ARRAY_DEFAULT_CAPACITY = (1 << 4);
	// ======================
	// ======================
	// ======================
	/** Empty sequence holder, <b>""</b> */
	public final CharSequence EMPTY_CHARSEQUENCE = "";
	/** Null sequence holder, <b>"null"</b> */
	public final CharSequence NULL_CHARSEQUENCE = "null";
	// ======================
	// ======================
	// ======================

	/** 16 */
	public final int DEFAULT_ARRAY_CAPACITY = 16;
	/** 8192 */
	public final int DEFAULT_PAD_LIMIT = 8192;
	/** -1 */
	public final int INDEX_NOT_FOUND = -1;
	/** 8 */
	public final int DEFAULT_TAB_SIZE = 8;
	// =============
	// =============
	// =============
	/** ignore case */
	public final int FLAG_ALWAYS_IGNORE_CASE = 0X1;

	/**
	 * used to count repeated code-points/char-array instead of counting in all
	 * sequence
	 */
	public final int FLAG_COUNT_REPEATED_ONLY = 0X2;

	/**
	 * used to return visual-level indexes
	 */
	public final int FLAG_RETURN_VISUAL_LEVEL = 0X2;

	// ======================
	// ======================
	// ======================

	/**
	 * All known whitespace codepoints based on {@link Character#isWhitespace(int)}
	 */
	public final IntegerArray WHITESPACES = IntegerArray.of(new int[] { 9, 10, 11, 12, 13, 28, 29, 30, 31, 32, 5760,
			6158, 8192, 8193, 8194, 8195, 8196, 8197, 8198, 8200, 8201, 8202, 8232, 8233, 8287, 12288 }).toImmutable();

	/**
	 * All known linefeeds
	 */
	public final IntegerArray LINEFEEDS = IntegerArray.of(new int[] { '\n', '\r' }).toImmutable();

	// ======================
	// ======================
	// ======================

	public final char DEFAULT_UNDERNEATH_MARKER_CHAR = '^';
	public final int DEFAULT_INLINE_PREFIX_MARKER_CODEPOINT = '{';
	public final int DEFAULT_INLINE_SUFFIX_MARKER_CODEPOINT = '}';
	public final CharArray DEFAULT_INLINE_PREFIX_MARKER_CHARARRAY = CharArray.of("{".toCharArray()).toImmutable();
	public final CharArray DEFAULT_INLINE_SUFFIX_MARKER_CHARARRAY = CharArray.of("}".toCharArray()).toImmutable();
	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

	// ======================
	// ======================
	// ======================

}
