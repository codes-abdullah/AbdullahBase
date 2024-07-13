package codes.abdullah.chars;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.function.BiPredicate;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import codes.abdullah.digits.Digits;
import codes.abdullah.digits.java.JavaFloatingDecimal;
import codes.abdullah.digits.java.JavaInteger;
import codes.abdullah.project.Check;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.Immutable;
import codes.abdullah.project.ImplementationRequiredException;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;
import codes.abdullah.project.lang.chars.utils.CharsMatcherByDepth;

/**
 * codes.abdullah.util.chars.Chars is an implementation that aims to provide a
 * mutable/immutable full rich of text tools with full support of supplementary
 * code-points from a visual-level
 */
public abstract class Chars
		implements CharSequence, Serializable, Appendable, Comparable<CharSequence>, Immutable<Chars> {
	private static final long serialVersionUID = -1980093613645889131L;
	static final int[] WHITESPACES_ARRAY = Lang.constant.WHITESPACES.getArray();
	static final int[] LINEFEEDS_ARRAY = Lang.constant.LINEFEEDS.getArray();

	// ===============
	// =============== abstract
	// ===============

	/**
	 * The implementations of {@link Chars} must considers this method as the visual
	 * length of the sequence, e.g: <b>codF4s.H2bdullah</b> if
	 * {@link #isSurrogatePairsSupported()} enabled, this method will <b>returns
	 * 14</b>, and if surrogate-pairs support disabled, this method will <b>returns
	 * 16</b><br>
	 * <br>
	 * 
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * 
	 * int a = 0, b = 1,
	 * 
	 * 		c = 2;
	 * Object a = null;
	 * Object b = "";
	 * Object c = 1;
	 * 
	 * </pre>
	 * 
	 * 
	 * 
	 * @return the visual length of this instance
	 * @see #lengthActual()
	 */
	@Override
	public abstract int length();

	/**
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * null.length() = 0
	 * "".length() = 0
	 * "codes.abdullah".actualLength() = 14
	 * "codF4s.H2bdullah".actualLength() = 16
	 * 
	 * [SP=true,IC=false]
	 * "".length() = 0
	 * "codes.abdullah".actualLength() = 14
	 * "codF4s.H2bdullah".actualLength() = 16
	 * </pre>
	 * 
	 * @return inner-length which is the actual-length used for the buffer
	 * @see #length()
	 */
	public abstract int lengthActual();

	/**
	 * - <b>internal usage only</b><br>
	 * <br>
	 * 
	 * @return flags of this instance
	 */
	public abstract int getFlags();

	/**
	 * - <b>internal usage only</b><br>
	 * <br>
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * "codF4s.H2bdullah".spc() = 0
	 * 
	 * [SP=true,IC=false]
	 * "codF4s.H2bdullah".spc() = 2
	 * </pre>
	 * 
	 * @return surrogate-pairs count <br>
	 *         <b>Note</b> the difference between this method and
	 *         {@link #countSurrogatePairs(int, int)} is, that method will always
	 *         count surrogate pairs based on range, no matter if
	 *         {@link #isSurrogatePairsSupported()} or not, while this is the
	 *         always-count of whole surrogate-pairs with consideration for the
	 *         support and not
	 */
	abstract int spc();

	/**
	 * safe <br>
	 * - <b>internal usage only</b><br>
	 * <br>
	 * - modification will be applied<br>
	 * <br>
	 * - <b>immutable-implementer</b> must return new copy<br>
	 * - <b>mutable-implementer</b> must return original copy<br>
	 * 
	 * @return core object/array that represent the data of current instance
	 */
	abstract char[] safe();

	/**
	 * unsafe <br>
	 * - <b>internal usage only</b><br>
	 * <br>
	 * - modification will <b>NOT</b> be applied, no need for more garbage<br>
	 * <br>
	 * - <b>immutable-implementer</b> must return original copy<br>
	 * - <b>mutable-implementer</b> must return original copy<br>
	 * 
	 * @return core object/array that represent the data of current instance
	 */
	abstract char[] unsafe();

	/**
	 * - <b>internal usage only</b><br>
	 * <br>
	 * - <b>immutable-implementer</b> must recopy<br>
	 * - <b>mutable-implementer</b> should not recopy<br>
	 */
	abstract Chars assign(char[] arr, int innerlen, int spc, CodepointSupport sps, int flags);

	/**
	 * - <b>internal usage only</b><br>
	 * <br>
	 * - <b>invoker</b> must pass new copy<br>
	 * - <b>immutable-implementer</b> should not recopy<br>
	 * - <b>mutable-implementer</b> should not recopy<br>
	 */
	abstract Chars newInstance(char[] arr, int innerlen, int spc, CodepointSupport sps, int flags);

	// ===============
	// =============== new instance
	// ===============

	/**
	 * clone the content of this instance based on current implementation
	 * (Mutable/Immutable) and flags
	 */
	public abstract Chars newClone();

	/**
	 * create new <b>empty</b> instance based on current implementation
	 * (Mutable/Immutable) and flags
	 */
	public Chars newInstance() {
		return newInstance(new char[Lang.constant.DEFAULT_ARRAY_CAPACITY], 0, 0, getSurrogatePairsSupport(),
				getFlags());
	}

	/**
	 * create new instance based on current implementation (Mutable/Immutable) and
	 * flags with given sequence
	 */
	public Chars newInstance(CharSequence cs) {
		char[] arr = cs.toString().toCharArray();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = sps.extendablePairsCount(arr, arr.length);
		return newInstance(arr, arr.length, spc, sps, getFlags());
	}

	// ===============
	// =============== assign
	// ===============

	/**
	 * assign given sequence to this instance<br>
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * null.assign(null) = ""
	 * "".assign("") = ""
	 * "".assign("codes.abdullah") = "codes.abdullah"
	 * "codes".assign(null) = ""
	 * "codes".assign("") = ""
	 * "codes".assign("abdullah") = "abdullah"
	 * "codes".assign("abdullah").length() = 8
	 * </pre>
	 */
	public Chars assign(CharSequence cs) {
		if (cs instanceof Chars) {
			Chars c2 = (Chars) cs;
			return assign(c2.toCharArray(), c2.lengthActual(), c2.spc(), c2.getSurrogatePairsSupport(), getFlags());
		}
		if (Lang.emptyOrNull.isAny(cs)) {
			return assign(safe(), 0, 0, getSurrogatePairsSupport(), getFlags());
		}
		char[] arr = cs.toString().toCharArray();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = sps.extendablePairsCount(arr, arr.length);
		return assign(arr, cs.length(), spc, sps, getFlags());
	}

	// ===============
	// =============== options setters
	// ===============

	/**
	 * enable/disable surrogate-pairs support
	 */
	public Chars setSurrogatePairsSupport(CodepointSupport sps) {
		final char[] arr = safe();
		final int innerlen = lengthActual();
		return assign(arr, innerlen, sps.extendablePairsCount(arr, innerlen), sps, getFlags());
	}

	public abstract CodepointSupport getSurrogatePairsSupport();

	/**
	 * enable/disable ignore case-sensitive
	 */
	public Chars setIgnoreCase(boolean b) {
		return assign(unsafe(), lengthActual(), spc(), getSurrogatePairsSupport(),
				reflag(b, Lang.constant.FLAG_ALWAYS_IGNORE_CASE));
	}

	/**
	 * - <b>internal usage only</b><br>
	 * <br>
	 * set flags of this instance
	 */
	Chars setFlags(int flags) {
		return assign(safe(), lengthActual(), spc(), getSurrogatePairsSupport(), flags);
	}

	// ===============
	// =============== unsafe ops
	// ===============

	// ===============
	// =============== char setters
	// ===============

	/**
	 * set char to given index
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * int a= 10, b= 20, c=300;
	 * Chars c100 = Chars.of("bla");
	 * "".setCharAt(0, 'a') = java.lang.IndexOutOfBoundsException
	 * "".setCharAt(0, 'a') = java.lang.IndexOutOfBoundsException
	 * "codes".setCharAt(5, 'a') = java.lang.IndexOutOfBoundsException
	 * "codes".setCharAt(0, 'a') = "aodes"
	 * "codes".setCharAt(4, 'a') = "codea"
	 * "codF4".setCharAt(3, 'X').toCodePointArray() = {99, 111, 100, 88, 56509}
	 * c.length() = 5
	 * 
	 * [SP=true,IC=false]
	 * "codF4".setCharAt(3, 'X').toCodePointArray() = {99, 111, 100, 88 }
	 * Chars.of("").length() = 4
	 * </pre>
	 */
	public Chars setCharAt(int index, char ch) {
		Check.index(index, length());
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		index = sps.reindex(arr, innerlen, index);
		arr[index] = ch;
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	// ===============
	// =============== char getters
	// ===============

	/**
	 * <b>Warning:</b> return actual-level <br>
	 * get char at given index
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * null.charAt(0) = java.lang.IndexOutOfBoundsException
	 * "".charAt(0) = java.lang.IndexOutOfBoundsException
	 * "codes".charAt(5) = java.lang.IndexOutOfBoundsException
	 * "codes".charAt(0) = 'c'
	 * "codF4".charAt(4) = 56509
	 * [SP=true,IC=false]
	 * "codF4".charAt(4) = java.lang.IndexOutOfBoundsException
	 * "codF4".charAt(3) = 65725
	 * </pre>
	 */
	public char charAt(int index) {
		Check.index(index, length());
		return unsafe()[index];
	}

	/**
	 * get first char
	 * 
	 * @see #charAt(int)
	 */
	public char firstChar() {
		return charAt(0);
	}

	/**
	 * get last char
	 * 
	 * @see #charAt(int)
	 */
	public char lastChar() {
		return charAt(length() - 1);
	}

	// ===============
	// =============== code-point setters
	// ===============

	/**
	 * set code-point at given index
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * null.setCodePointAt(0, 'c') = java.lang.IndexOutOfBoundsException
	 * "".setCodePointAt(0, 'c') = java.lang.IndexOutOfBoundsException
	 * "c".setCodePointAt(1, 'x') = java.lang.IndexOutOfBoundsException
	 * "code".setCodePointAt(0, 'x').toCodePointArray() = {99, 111, 100, 101}
	 * "code".setCodePointAt(3, 'x') = "codx"
	 * "codF4".setCodePointAt(3, 'x').toCodePointArray() = {99, 111, 100, 120, 56509}
	 * "code".setCodePointAt(0, 65621).toCodePointArray() = {55296, 56509, 100, 101}
	 * "codF4".setCodePointAt(3, 65621).toCodePointArray() = {99, 111, 100, 120, 55296, 56509}
	 * 
	 * [SP=true,IC=false]
	 * "codF4".setCodePointAt(3, 'x').toCodePointArray() = {99, 111, 100, 120}
	 * "codF4".setCodePointAt(3, 65621).toCodePointArray() = {99, 111, 100, 55296, 56405}
	 * </pre>
	 * 
	 * 99, 111, 100, 101, 55296, 56509
	 */
	public Chars setCodePointAt(int index, int cp) {
		Check.insertIndex(index, length());
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		char[] arr = safe();
		index = sps.reindex(arr, innerlen, index);
		if (sps.isBmp(cp)) {
			if (sps.isPair(arr, innerlen, innerlen - 1)) {
				Lang.shrink.at(arr, innerlen, index, 1);
				spc -= spc > 0 ? 1 : 0;
				innerlen--;
			}
			arr[index] = (char) cp;
			return assign(arr, innerlen, spc, sps, getFlags());
		} else if (sps.isPair(cp)) {
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + 2);
			if (!sps.isPair(arr, innerlen, index)) {
				Lang.expand.at(arr, innerlen, index, 1);
				spc += sps.isSupported() ? 1 : 0;
				innerlen++;
			}
			arr[index] = sps.toHigh(cp);
			arr[index + 1] = sps.toLow(cp);
			return assign(arr, innerlen, spc, sps, getFlags());
		}
		Check.codePoint(cp, sps);
		return null;// must never reach here
	}

	/**
	 * set code-point at given indexes array
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * null.setCodePointsAt(null, 'c') = java.util.NoSuchElementException
	 * "".setCodePointsAt(null, 'c') = java.util.NoSuchElementException
	 * "".setCodePointsAt(null, 'c') = java.util.NoSuchElementException
	 * "a".setCodePointsAt(null, 'a') = java.lang.NullPointerException
	 * "code".setCodePointsAt({0, 2, 1}, 0x10FFFF) = java.lang.IllegalArgumentException
	 * "code".setCodePointsAt({0, 2, 1}, 'x') = java.lang.IllegalArgumentException
	 * "code".setCodePointsAt({0, 1, 2, 3, 4}, 'x') = java.lang.IndexOutOfBoundsException
	 * "code".setCodePointsAt({0, 1, 2}, 'x').toCodePointArray() = {120, 120, 120, 101} 
	 * "codF4".setCodePointsAt({0, 1, 2}, 'x').toCodePointArray() = {120, 120, 120, 56509}
	 * "code".setCodePointsAt({0}, 65725).toCodePointArray() = {99, 111, 100, 101} 
	 * 
	 * [SP=true,IC=false]
	 * "codF4".setCodePointsAt({0}, 'x').toCodePointArray() = {99, 111, 100, 120}
	 * "codF4".setCodePointsAt({3}, 65621).toCodePointArray() = {99, 111, 100, 55296, 56405}
	 * </pre>
	 * 
	 */
	public Chars setCodePointsAt(int[] indexes, int cp) {
		ensureNotEmpty();
		Check.codePoint(cp);
		int len = length();
		CodepointSupport sps = getSurrogatePairsSupport();
		int innerlen = lengthActual();
		int spc = spc();
		char[] arr = safe();
		int current_spc = 0;
		int to = 0, from = 0;
		int all_spc_so_far = 0;
		int lastKnownIndex = -1;

		for (int i = 0; i < indexes.length; i++) {
			int index = indexes[i];
			if (index <= lastKnownIndex)
				throw new IllegalArgumentException("detect unsorted indexes: " + Arrays.toString(indexes));
			lastKnownIndex = index;
			Check.insertIndex(index, len);
			// if index == 0, means no surrogate pairs before it, so no need to count and
			// fix
			if (index != 0) {
				// --------------------
				// index will represent to, from will be for very first time equals to 0
				// on loop 1 and so on, from will be equals to previous index
				// --------------------
				to = index + all_spc_so_far;
				current_spc = sps.extendablePairsCount(arr, innerlen, from, to);
				all_spc_so_far += current_spc;
				// --------------------
				// reassign the index with all spc count so far
				// --------------------
				index += all_spc_so_far;
				from = index;
			}
			if (sps.isBmp(cp)) {
				if (sps.isPair(arr, innerlen, index)) {
					Lang.shrink.at(arr, innerlen, index, 1);
					spc -= spc > 0 ? 1 : 0;
					innerlen--;
				}
				arr[index] = (char) cp;
			} else {
				arr = Lang.capacity.ensure(arr, innerlen, innerlen + 2);
				if (!sps.isPair(arr, innerlen, index)) {
					Lang.expand.at(arr, innerlen, index, 1);
					spc += sps.isSupported() ? 1 : 0;
					innerlen++;
				}
				arr[index] = sps.toHigh(cp);
				arr[index + 1] = sps.toLow(cp);
			}
		}
		return assign(arr, innerlen, spc, sps, getFlags());
	}

	// ===============
	// =============== code-point getters
	// ===============

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * null.codePointAt(0) = java.lang.IndexOutOfBoundsException
	 * "".codePointAt(0) = java.lang.IndexOutOfBoundsException
	 * "c".codePointAt(1) = java.lang.IndexOutOfBoundsException
	 * "code".codePointAt(0) = 'c'
	 * "code".codePointAt(3) = 'e'
	 * "codF4".codePointAt(3) = 65621
	 * "codF4".codePointAt(4) = 56405
	 * 
	 * [SP=true,IC=false]
	 * "codF4".codePointAt(3) = 65621
	 * "codF4".codePointAt(4) = java.lang.IndexOutOfBoundsException
	 * </pre>
	 * 
	 * @return code-point at given index, if given index pointing to valid
	 *         surrogate-pair, a supplementary code-point return
	 */
	public int codePointAt(int index) {
		Check.index(index, length());
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ===============
		index = sps.reindex(arr, innerlen, index);
		// ===============
		return sps.getCodepoint(arr, innerlen, index);
	}

	/**
	 * @see #codePointAt(int)
	 * @return first code-point, if first is valid surrogate-pair, a supplementary
	 *         code-point return
	 */
	public int firstCodePoint() {
		CodepointSupport sps = getSurrogatePairsSupport();
		char high = firstChar();
		if (!sps.isSupported() || lengthActual() == 1) {
			return high;
		}
		if (sps.isHigh(high)) {
			char low = charAt(1);
			if (sps.isLow(low)) {
				return sps.toCodepoint(high, low);
			}
		}
		return high;
	}

	/**
	 * @see #codePointAt(int)
	 * @return last code-point, if last is valid surrogate-pair, a supplementary
	 *         code-point return
	 */
	public int lastCodePoint() {
		CodepointSupport sps = getSurrogatePairsSupport();
		char low = lastChar();
		if (!sps.isSupported() || lengthActual() == 1) {
			return low;
		}
		if (sps.isLow(low)) {
			char high = charAt(length() - 2);
			if (sps.isHigh(low)) {
				return sps.toCodepoint(high, low);
			}
		}
		return low;
	}

	/**
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * null.codePointBefore(0) = java.lang.IndexOutOfBoundsException
	 * "".codePointBefore(0) = java.lang.IndexOutOfBoundsException
	 * "c".codePointBefore(0) = java.lang.IndexOutOfBoundsException
	 * "co".codePointBefore(1) = 'c'
	 * "code".codePointBefore(3) = 'd'
	 * "codF4".codePointBefore(3) = 'd'
	 * "codF4".codePointBefore(4) = 56405
	 * "codF4".codePointBefore(5) = 65621
	 * 
	 * [SP=true,IC=false]
	 * "codF4".codePointBefore(4) = 65621
	 * "codF4".codePointBefore(5) = java.lang.IndexOutOfBoundsException
	 * </pre>
	 * 
	 * @return code-point at (index - 1), if given (index - 1) pointing to valid
	 *         surrogate-pair, a supplementary code-point return
	 * @see String#codePointBefore(int)
	 */
	public int codePointBefore(int index) {
		CodepointSupport sps = getSurrogatePairsSupport();
		Check.index(index - 1, length());
		char[] arr = unsafe();
		int innerlen = lengthActual();
		index = sps.reindex(arr, innerlen, index);
		char c2 = arr[--index];
		if (sps.isLow(c2)) {
			char c1 = arr[--index];
			if (sps.isHigh(c1)) {
				return sps.toCodepoint(c1, c2);
			}
		}
		return c2;
	}

	// ===============
	// =============== general query
	// ===============

	/**
	 * @see Character#hashCode(char)
	 */
	public int hashCodeAt(int index) {
		return codePointAt(index);
	}

	/**
	 * @return if {@link #length()} == 0
	 */
	public boolean isEmpty() {
		return length() == 0;
	}

	/**
	 * @return if flagged to always ignore case-sensitive
	 */
	public boolean isIgnoreCase() {
		return iagc();
	}

	/**
	 * - <b>internal usage only</b><br>
	 * <br>
	 * 
	 * @return true if Always-Ignore-Case-Sensitive is enabled
	 */
	boolean iagc() {
		return isFlagged(Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
	}

	// ===============
	// =============== quantity query
	// ===============

	/**
	 * @return current buffer capacity
	 */
	public int capacity() {
		return unsafe().length;
	}

	public int countTabAsSpace(int from, int to) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		if (from == 0 && to == len) {
			return countSurrogatePairs();
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int count = 0;
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, innerlen, from, to);
		// ---------------------
		for (int i = from; i < to; i++) {
			// if pointing to middle of surrogate-pair, don't count it
			if (arr[i] == '\t') {
				count++;
			}
		}
		return count * 8;
	}

//	abdullah
//1234567812345678

	/**
	 * @see #countSurrogatePairs(int, int)
	 */
	public int countSurrogatePairs() {
		CodepointSupport sps = getSurrogatePairsSupport();
		if (sps.isSupported()) {
			return spc();
		}
		int innerlen = lengthActual();
		return sps.extendablePairsCount(unsafe(), innerlen);
	}

	/**
	 * @see #countSurrogatePairs(int, int)
	 */
	public int countSurrogatePairs(int from) {
		return countSurrogatePairs(from, length());
	}

	/**
	 * count surrogate-pairs based on given range<br>
	 * 
	 * <br>
	 * <b>Note</b> the difference between this method and {@link #spc()} is, this
	 * method will <b>lazy-count</b> surrogate pairs based on range, no matter if
	 * {@link #isSurrogatePairsSupported()} or not, while {@link #spc()} is the
	 * <b>pre-count</b> of whole surrogate-pairs with consideration for the support
	 * and not
	 * 
	 * 
	 */
	public int countSurrogatePairs(int from, int to) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		if (from == 0 && to == len) {
			return countSurrogatePairs();
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int count = 0;
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, innerlen, from, to);
		// ---------------------
		for (int i = from; i < to; i++) {
			// if pointing to middle of surrogate-pair, don't count it
			if (i + 1 < to && sps.isPair(arr, innerlen, i)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @return always return 1 if {@link CodepointSupport#isSupported()} is false,
	 *         otherwise will return
	 *         {@link CodepointSupport#lengthOf(char[], int, int)}
	 * 
	 */
	public int lengthOfAt(int index) {
		Check.index(index, length());
		CodepointSupport sps = getSurrogatePairsSupport();
		if (!sps.isSupported()) {
			return 1;
		}
		char[] arr = unsafe();
		int innerlen = lengthActual();
		// ------------------
		index = sps.reindex(arr, innerlen, index);
		// ------------------
		return sps.lengthOf(arr, innerlen, index);
	}

	/**
	 * @see #countCodePoints(int, int)
	 */
	public int countCodePoints() {
		if (getSurrogatePairsSupport().isSupported()) {
			return length();
		}
		return countCodePoints(0, length());
	}

	/**
	 * @see #countCodePoints(int, int)
	 */
	public int countCodePoints(int from) {
		return countCodePoints(from, length());
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * null.countCodePoints(0, 10) = 0
	 * "".countCodePoints(0, 10) = 0
	 * "c".countCodePoints(0, 10) = 1
	 * "co".countCodePoints(1, 10) = 1
	 * "co".countCodePoints(-1, 10) = java.lang.IllegalArgumentException
	 * "code".countCodePoints(1, 3) = 2
	 * "codF4".countCodePoints(0, 4) = 4
	 * "codF4".countCodePoints(0, 5) = 4
	 * "codF4".countCodePoints(0, 10) = 4
	 * "codF4".countCodePoints(3, 5) = 1
	 * "codF4".countCodePoints(3, 10) = 1
	 * "codF4".countCodePoints(4, 5) = 1
	 * "codF4".countCodePoints(4, 10) = 1
	 * 
	 * [SP=true,IC=false]
	 * "codF4javH2".countCodePoints(0, 3) = 3
	 * "codF4javH2".countCodePoints(0, 4) = 4
	 * "codF4H2ava".countCodePoints(0, 5) = 4
	 * "H2odF4H2ava".countCodePoints(2, 4) = 2
	 * "F4odF4".countCodePoints(3, 4) = 1
	 * </pre>
	 * 
	 * @return code-points count based on given range <br>
	 *         <b>Note</b> if valid surrogate-pairs exists, will be counted as 1
	 *         supplementary code-point for each pair
	 * @see String#codePointCount(int, int)
	 */
	public int countCodePoints(int from, int to) {
		final int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, length());
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, innerlen, from, to);
		// ---------------------
		return sps.countCodepoints(arr, innerlen, from, to);
	}

	// ===============
	// =============== count repeat
	// ===============

	/**
	 * @see #countRepeat(int, int, int, boolean)
	 */
	public int countRepeat(int target) {
		return countRepeat(target, 0);
	}

	/**
	 * @see #countRepeat(int, int, int, boolean)
	 */
	public int countRepeat(int target, int from) {
		return countRepeat(target, from, length());
	}

	/**
	 * @see #countRepeat(int, int, int, boolean)
	 */
	public int countRepeat(int target, int from, int to) {
		return countRepeat(target, from, to, iagc());
	}

	/**
	 * Find the first occurrence of given code-point based on given range, and count
	 * the repeat-in-sequence, e.g: j{aaa}va, target: a, repeat-in-sequence= 3
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * "".countRepeat(0, 0, 14, false) = 0
	 * "".countRepeat('a', 0, 14, false) = 0
	 * "codes".countRepeat('a', 0, 14, false) = 0
	 * "codes.abdullah".countRepeat('a', 0, 14, false) = 1
	 * "codes.aaaabdullah".countRepeat('a', 0, 17, false) = 4
	 * "codes.aAaabdullah".countRepeat('a', 0, 17, false) = 1
	 * "codes.aAaabdullah".countRepeat('a', 0, 17, true) = 4
	 * "codes.aAaabdullah".countRepeat('a', 10, 10, true) = java.lang.IllegalArgumentException
	 * "codF4-java".countRepeat(65725, 0, 10, false) = 1
	 * "codF4F4jF4va".countRepeat(65725, 0, 12, false) = 2
	 * 
	 * [SP=true,IC=false]
	 * "codF4-java".countRepeat(65725, 0, 9, false) = 1
	 * "codF4F4jF4va".countRepeat(65725, 0, 9, false) = 2
	 * </pre>
	 * 
	 * @see #indexOfEnd(int, int, int, boolean)
	 * @see #indexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int countRepeat(int target, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, innerlen, from, to);
		// ---------------------
		int index = CharsLoop.INDEX_OF.codePoint(arr, innerlen, from, to, target, flags, 0, CharsMatcher.MUST_EQUALS,
				sps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return 0;
		}
		int indexDisp = sps.extendablePairsCount(arr, innerlen, from, index);
		from = index + indexDisp;
		return CharsLoop.FORWARD_COUNT_OF.codePoint(arr, innerlen, from, to, target, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
	}

	// ===============
	// =============== count repeat sequence
	// ===============

	/**
	 * @see #countRepeat(char[], int, int, int, boolean)
	 */
	public int countRepeat(CharSequence cs) {
		return countRepeat(cs, 0);
	}

	/**
	 * @see #countRepeat(char[], int, int, int, boolean)
	 */
	public int countRepeat(CharSequence cs, int from) {
		return countRepeat(cs, from, length());
	}

	/**
	 * @see #countRepeat(char[], int, int, int, boolean)
	 */
	public int countRepeat(CharSequence cs, int from, int to) {
		return countRepeat(cs, from, to, iagc());
	}

	/**
	 * @see #countRepeat(char[], int, int, int, boolean)
	 */
	public int countRepeat(CharSequence target, int from, int to, boolean ignoreCase) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return countRepeat(tarr, tlen, from, to, ignoreCase);
	}

	// ===============
	// =============== count repeat by char array
	// ===============

	/**
	 * @see #countRepeat(char[], int, int, int, boolean)
	 */
	public int countRepeat(char[] target, int targetLength) {
		return countRepeat(target, targetLength, 0);
	}

	/**
	 * @see #countRepeat(char[], int, int, int, boolean)
	 */
	public int countRepeat(char[] target, int targetLength, int from) {
		return countRepeat(target, targetLength, from, length());
	}

	/**
	 * @see #countRepeat(char[], int, int, int, boolean)
	 */
	public int countRepeat(char[] target, int targetLength, int from, int to) {
		return countRepeat(target, targetLength, from, to, iagc());
	}

	/**
	 * find the first occurrence of given char-array based on given range, and count
	 * the repeat-in-sequence, e.g: codes.codes.java.codes, target: codes,
	 * repeat-in-sequence= 2
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * "".countRepeat(null, 0, 0, 100, false) = 0
	 * "".countRepeat(new char[]{}, 0, 0, 100, false) = 0
	 * "codes".countRepeat({'c'}, 1, 0, 5, false) = 1
	 * "codcs".countRepeat({'c'}, 1, 2, 4, false) = 1
	 * "codcs".countRepeat({'c', 'o'}, 2, 0, 5, false) = 1
	 * "codcs".countRepeat({'c', 'o'}, 2, 4, 5, false) = 1
	 * "codco".countRepeat({'c', 'o'}, 2, 0, 5, false) = 1
	 * "codco".countRepeat({'c', 'o'}, 2, 0, 5, false) = 1
	 * "CodcO".countRepeat({'C', 'o'}, 2, 0, 5, true) = 1
	 * "coDcoD".countRepeat({'c', 'o', 'd'}, 3, 0, 5, true) = 2
	 * "coDcoD".countRepeat({'c', 'o', 'd'}, 3, 1, 5, true) = 1
	 * "coDcoD".countRepeat({'c', 'o', 'd'}, 3, 1, 4, true) = 1
	 * "coDcoD".countRepeat({'c', 'o', 'd'}, 3, 1, 4, true) = 0
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 0, 15, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 4, 15, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 4, 7, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 4, 6, false) = 0
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 6, 15, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 10, 15, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 11, 15, false) = 0
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 0, 15, false) = 2
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 5, 15, false) = 2
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 6, 15, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 5, 14, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 10, 15, false) = 2
	 * "codF4cF4F4odcF4od".countRepeat({55296, 56509}, 2, 0, 15, false) = 1
	 * "codF4cF4F4odcF4od".countRepeat({55296, 56509}, 2, 5, 15, false) = 2
	 * "codF4cF4F4odcF4od".countRepeat({55296, 56509}, 2, 7, 15, false) = 1
	 * 
	 * 
	 * [SP=true,IC=false]
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509}, 3, 0, 12, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 0, 12, false) = 2
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 4, 12, false) = 2
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 5, 12, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 4, 11, false) = 1
	 * "codF4cF4odcF4od".countRepeat({'c', 55296, 56509, 'o', 'd'}, 5, 4, 7, false) = 0
	 * </pre>
	 */
	public int countRepeat(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0 || target == null || targetLength == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		int index = CharsLoop.INDEX_OF.array(arr, len, from, to, target, targetLength, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return 0;
		}
		int indexDisp = sps.extendablePairsCount(arr, innerlen, from, index);
		from = index + indexDisp;
		return CharsLoop.FORWARD_COUNT_OF.array(arr, innerlen, from, to, target, targetLength, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
	}

	// ===============
	// =============== count matches by code-point
	// ===============

	/**
	 * @see #countMatches(int, int, int, boolean)
	 */
	public int countMatches(int target) {
		return countMatches(target, 0);
	}

	/**
	 * @see #countMatches(int, int, int, boolean)
	 */
	public int countMatches(int target, int from) {
		return countMatches(target, from, length());
	}

	/**
	 * @see #countMatches(int, int, int, boolean)
	 */
	public int countMatches(int target, int from, int to) {
		return countMatches(target, from, to, iagc());
	}

	/**
	 * count any occurrence of given code-point based on given range
	 */
	public int countMatches(int target, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		return CharsLoop.FORWARD_COUNT_OF.codePoint(arr, innerlen, from, to, target, flags, 0, CharsMatcher.MUST_EQUALS,
				sps);
	}

	// ===============
	// =============== count matches by sequence
	// ===============

	/**
	 * @see #countMatches(char[], int, int, int, boolean)
	 */
	public int countMatches(CharSequence cs) {
		return countMatches(cs, 0);
	}

	/**
	 * @see #countMatches(char[], int, int, int, boolean)
	 */
	public int countMatches(CharSequence cs, int from) {
		return countMatches(cs, from, length());
	}

	public int countMatches(CharSequence cs, int from, int to) {
		return countMatches(cs, from, to, iagc());
	}

	/**
	 * @see #countMatches(char[], int, int, int, boolean)
	 */
	public int countMatches(CharSequence target, int from, int to, boolean ignoreCase) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return countMatches(tarr, tlen, from, to, ignoreCase);
	}

	// ===============
	// =============== count matches by char array
	// ===============

	/**
	 * @see #countMatches(char[], int, int, int, boolean)
	 */
	public int countMatches(char[] target, int targetLength) {
		return countMatches(target, targetLength, 0);
	}

	/**
	 * @see #countMatches(char[], int, int, int, boolean)
	 */
	public int countMatches(char[] target, int targetLength, int from) {
		return countMatches(target, targetLength, from, length());
	}

	public int countMatches(char[] target, int targetLength, int from, int to) {
		return countMatches(target, targetLength, from, to, iagc());
	}

	/**
	 * count matches of given target based on given range
	 */
	public int countMatches(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0 || target == null || targetLength == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		return CharsLoop.FORWARD_COUNT_OF.array(arr, innerlen, from, to, target, targetLength, flags, 0,
				CharsMatcher.MUST_EQUALS, sps);
	}

	// ===============
	// =============== count tabs as spaces
	// ===============

	public int countOccupied() {
		return countOccupied(0);
	}

	public int countOccupied(int from) {
		return countOccupied(from, length());
	}

	public int countOccupied(int from, int to) {
		return countOccupied(from, to, Lang.constant.DEFAULT_TAB_SIZE);
	}

	/**
	 * Count occupied space after that a console will render, this is special tool
	 * to take tab character in consideration of repeated space character<br>
	 * e.g: tabSize = 8, (will represent tab using dash -)<br>
	 * <br>
	 * src: [abc\t], length = 5<br>
	 * out: [abc-----], length = 8<br>
	 * src: [abcDEF\t], length = 7<br>
	 * out: [abcDEF--], length = 8<br>
	 * src: [abcDEFxy\t], length = 9<br>
	 * out: [abcDEFxyz-------], length = 16<br>
	 */

	public int countOccupied(int from, int to, int fromVisual) {
		return countOccupied(from, to, fromVisual, Lang.constant.DEFAULT_TAB_SIZE);
	}

	public int countOccupied(int from, int to, int fromVisual, int tabSize) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		return Lang.codepoint.countOccupied(arr, innerlen, from, to, fromVisual, tabSize, sps);
	}

	// ===============
	// =============== insert
	// ===============

	/**
	 * format and insert given args into this sequence
	 */
	// TODO enhance
	public Chars insertFormat(int offset, CharSequence format, Object... args) {
		Formatter f = null;
		try {
			StringBuilder a = new StringBuilder();
			f = new Formatter(a);
			f.format(format.toString(), args);
			return insert(offset, a);
		} finally {
			if (f != null) {
				f.close();
			}
		}
	}

	/**
	 * insert "null"
	 */
	public Chars insertNull(int offset) {
		ensureCanAccommodate(4);
		final int innerlen = lengthActual();
		final int newlen = innerlen + 4;
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		offset = sps.reindex(arr, innerlen, offset);
		Check.insertIndex(offset, length());
		arr = Lang.capacity.ensure(arr, innerlen, newlen);
		Lang.expand.at(arr, innerlen, offset, 4);
		arr[offset++] = 'n';
		arr[offset++] = 'u';
		arr[offset++] = 'l';
		arr[offset++] = 'l';
		return assign(arr, newlen, spc(), sps, getFlags());
	}

	public Chars insert(int offset, char[] array, int arrayLength) {
		return insert(offset, array, arrayLength, 0, arrayLength);
	}

	/**
	 * insert given array based on given copy-offset and copy-length
	 */
	public Chars insert(int offset, char[] inj, int injlen, int copyOffset, int copyLen) {
		if (inj == null) {
			return insertNull(offset);
		} else if (injlen == 0 || copyLen == 0) {
			return this;
		}

		ensureCanAccommodate(copyLen);
		Check.insertIndex(offset, length());
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		final int innerlen = lengthActual();

		// turn copyLen to copyTo, both suppose to be in visual-level
		int copyTo = copyOffset + copyLen;
		offset = sps.reindex(arr, innerlen, offset);

		// below, copyOffset, copyTo and copyLen will be in surrogate-level
		// ========================
		int spc_before = sps.extendablePairsCount(inj, injlen, 0, copyOffset);
		copyOffset += spc_before;
		copyTo += spc_before;
		int spc_between = sps.extendablePairsCount(inj, injlen, copyOffset, copyTo);
		copyTo += spc_between;
		// ========================
		// int disp_after = countSurrogatePairs(inj, inj.length, copyTo, inj.length);

		copyTo = copyTo > injlen ? injlen : copyTo;
		copyLen = copyTo - copyOffset;
		spc += spc_between;

		Check.insertIndex(copyOffset + copyLen, inj.length);
		final int newLen = innerlen + copyLen;
		arr = Lang.capacity.ensure(arr, innerlen, newLen);
		Lang.expand.at(arr, innerlen, offset, copyLen);
		Lang.copy.to.that(inj, inj.length, arr, arr.length, copyOffset, copyOffset + copyLen, offset);
		return assign(arr, newLen, sps.isSupported() ? spc : 0, sps, getFlags());
	}

	/**
	 * if obj is null, insert "null", else if instanceof {@link CharSequence}, cast
	 * and insert, finally will insert object.toString() if can't be determined.
	 */
	public Chars insertObject(int offset, Object obj) {
		if (obj == null) {
			return insertNull(offset);
		} else if (obj instanceof CharSequence) {
			return insert(offset, (CharSequence) obj);
		}
		return insert(offset, obj.toString());
	}

	/**
	 * insert char-sequence, if char-sequence is null, insert "null"
	 */
	public Chars insert(int offset, CharSequence cs) {
		char[] tarr = null;
		int tlen = 0;
		if (cs instanceof Chars) {
			Chars c = (Chars) cs;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else {
			tarr = cs.toString().toCharArray();
			tlen = cs.length();
		}
		return insert(offset, tarr, tlen, 0, tlen);
	}

	/**
	 * insert char-sequence based on given range, if char-sequence is null, insert
	 * "null"
	 */
	public Chars insert(int offset, CharSequence cs, int from) {
		if (cs == null) {
			cs = "null";
		}
		return insert(offset, cs, from, cs.length());
	}

	/**
	 * insert char-sequence based on given range, if char-sequence is null, insert
	 * "null"
	 */
	public Chars insert(int offset, CharSequence cs, int from, int to) {
		if (cs == null) {
			cs = "null";
		}
		char[] tarr = null;
		int tlen = 0;
		if (cs instanceof Chars) {
			Chars c = (Chars) cs;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (cs != null) {
			tarr = cs.toString().toCharArray();
			tlen = cs.length();
		}

		int copyLen = to - from;
		return insert(offset, tarr, tlen, from, copyLen);
	}

	/**
	 * insert given byte
	 */
	public Chars insert(int offset, byte n) {
		return insert(offset, (int) n);
	}

	/**
	 * insert given short
	 */
	public Chars insert(int offset, short n) {
		return insert(offset, (int) n);
	}

	/**
	 * insert given boolean
	 */
	public Chars insert(int offset, boolean b) {
		return insert(offset, b ? "true" : "false");
	}

	/**
	 * insert given char
	 */
	public Chars insert(int offset, char ch) {
		return insertCodePoint(offset, ch);
	}

	/**
	 * insert given integer
	 */
	public Chars insert(int offset, int n) {
		if (n == Integer.MIN_VALUE) {
			return insert(offset, "-2147483648");
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		char[] arr = safe();
		int innerlen = lengthActual();
		offset = sps.reindex(arr, innerlen, offset);
		Check.insertIndex(offset, length());
		int nlen = Digits.ints.lengthOf(n);
		int newlen = innerlen + nlen;
		arr = Lang.capacity.ensure(arr, innerlen, newlen);
		Lang.expand.at(arr, innerlen, offset, nlen);
		JavaInteger.getChars(n, offset + nlen, arr);
		return assign(arr, newlen, spc(), sps, getFlags());
	}

	/**
	 * insert given long
	 */
	public Chars insert(int offset, long n) {
		if (n == Long.MIN_VALUE) {
			return insert(offset, "-9223372036854775808");
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		char[] arr = safe();
		int innerlen = lengthActual();
		offset = sps.reindex(arr, innerlen, offset);
		Check.insertIndex(offset, length());
		int nlen = Digits.longs.lengthOf(n);
		int newlen = innerlen + nlen;
		arr = Lang.capacity.ensure(arr, innerlen, newlen);
		Lang.expand.at(arr, innerlen, offset, nlen);
		JavaInteger.getChars(n, offset + nlen, arr);
		return assign(arr, newlen, spc(), sps, getFlags());
	}

	public Chars insert(int offset, float n) {
		String str = JavaFloatingDecimal.toJavaFormatString(n);
		char[] inj = str.toString().toCharArray();
		return insert(offset, inj, inj.length, 0, str.length());
	}

	/**
	 * insert given double
	 */
	public Chars insert(int offset, double n) {
		String str = JavaFloatingDecimal.toJavaFormatString(n);
		char[] inj = str.toString().toCharArray();
		return insert(offset, inj, inj.length, 0, str.length());
	}

	/**
	 * insert given code-point
	 */
	public Chars insertCodePoint(int offset, int cp) {
		final int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		char[] arr = safe();
		Check.insertIndex(offset, length());
		offset = sps.reindex(arr, innerlen, offset);
		if (sps.isBmp(cp)) {
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + 1);
			Lang.expand.at(arr, innerlen, offset, 1);
			arr[offset] = (char) cp;
			return assign(arr, innerlen + 1, spc, sps, getFlags());
		} else if (sps.isPair(cp)) {
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + 2);
			Lang.expand.at(arr, innerlen, offset, 2);
			arr[offset] = sps.toHigh(cp);
			arr[offset + 1] = sps.toLow(cp);
			spc += sps.isSupported() ? 1 : 0;
			return assign(arr, innerlen + 2, spc, sps, getFlags());
		}
		Check.codePoint(cp, sps);
		return null;// must never reach here
	}

	/**
	 * insert given code-points array
	 */
	public Chars insertCodePoints(int offset, int[] cps) {
		return insertCodePoints(offset, cps, 0);
	}

	/**
	 * insert given code-points array based on given range
	 */
	public Chars insertCodePoints(int offset, int[] cps, int from) {
		return insertCodePoints(offset, cps, from, cps.length);
	}

	/**
	 * insert given code-points array based on given range
	 */
	public Chars insertCodePoints(int offset, int[] cps, int from, int to) {
		to = to > cps.length ? cps.length : to;
		Check.range(from, to, cps.length);
		ensureCanAccommodate(to - from);
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		char[] arr = safe();
		offset = sps.reindex(arr, innerlen, offset);
		Check.insertIndex(offset, length());
		int cp = 0;
		for (int i = from; i < to; i++) {
			cp = cps[i];
			if (sps.isBmp(cp)) {
				arr = Lang.capacity.ensure(arr, innerlen, innerlen + 1);
				Lang.expand.at(arr, innerlen, offset, 1);
				arr[offset] = (char) cp;
				innerlen++;
				offset++;
			} else if (sps.isPair(cp)) {
				arr = Lang.capacity.ensure(arr, innerlen, innerlen + 2);
				Lang.expand.at(arr, innerlen, offset, 2);
				arr[offset] = sps.toHigh(cp);
				arr[offset + 1] = sps.toLow(cp);
				spc += sps.isSupported() ? 1 : 0;
				innerlen += 2;
				offset += 2;
			} else {
				Check.codePoint(cp, sps);
			}

		}
		return assign(arr, innerlen, spc, sps, getFlags());
	}

	public Chars insertFirst(CharSequence target) {
		return insert(0, target);
	}

	public Chars insertFirst(char[] target, int targetLength) {
		return insert(0, target, targetLength);
	}

	public Chars insertCodePointFirst(int target) {
		return insertCodePoint(0, target);
	}

	// ===============
	// =============== join and insert code-points
	// ===============

	/**
	 * @see #insertJoin(int, int, int, int, int...)
	 */
	public Chars insertJoin(int offset, int... elements) {
		return insertJoin(offset, 0, 0, 0, elements);
	}

	/**
	 * @see #insertJoin(int, int, int, int, int...)
	 */
	public Chars insertJoin(int offset, int delim, int... elements) {
		return insertJoin(offset, delim, 0, 0, elements);
	}

	/**
	 * join given code-points array and insert
	 */
	public Chars insertJoin(int offset, int delim, int prefix, int suffix, int... elements) {
		Lang.emptyOrNull.requireNiether(elements);
		Chars c = of();
		if (prefix != 0) {
			c = c.appendCodePoint(prefix);
		}
		if (delim != 0) {
			c = c.appendCodePoint(elements[0]);
			for (int i = 1; i < elements.length; i++) {
				c = c.appendCodePoint(delim).appendCodePoint(elements[i]);
			}
		} else {
			c = c.appendCodePoints(elements);
		}
		if (suffix != 0) {
			c = c.appendCodePoint(suffix);
		}
		return insert(offset, c);
	}

	// ===============
	// =============== join and insert CharSequence
	// ===============

	/**
	 * @see #insertJoin(int, int, CharSequence, CharSequence, CharSequence...)
	 */
	public Chars insertJoin(int offset, CharSequence... elements) {
		return insertJoin(offset, null, elements);
	}

	/**
	 * @see #insertJoin(int, int, CharSequence, CharSequence, CharSequence...)
	 */
	public Chars insertJoin(int offset, CharSequence delim, CharSequence... elements) {
		return insertJoin(offset, delim, null, null, elements);
	}

	/**
	 * join given sequences array and insert
	 */
	public Chars insertJoin(int offset, CharSequence delim, CharSequence prefix, CharSequence suffix,
			CharSequence... elements) {
		Lang.emptyOrNull.requireNiether(elements);
		Chars c = of();
		if (prefix != null) {
			c = c.append(prefix);
		}
		if (delim != null) {
			c = c.append(elements[0]);
			for (int i = 1; i < elements.length; i++) {
				c = c.append(delim).append(elements[i]);
			}
		} else {
			for (int i = 0; i < elements.length; i++) {
				c = c.append(elements[i]);
			}
		}
		if (suffix != null) {
			c = c.append(suffix);
		}
		return insert(offset, c);
	}

	// ===============
	// =============== join iterator/iterable and insert CharSequence
	// ===============

	/**
	 * @see #insertJoin(int, CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars insertJoin(int offset, Iterable<CharSequence> it) {
		return insertJoin(offset, null, it);
	}

	/**
	 * @see #insertJoin(int, CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars insertJoin(int offset, CharSequence delim, Iterable<CharSequence> it) {
		return insertJoin(offset, delim, null, null, it);
	}

	/**
	 * @see #insertJoin(int, CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars insertJoin(int offset, CharSequence delim, CharSequence prefix, CharSequence suffix,
			Iterable<CharSequence> it) {
		return insertJoin(offset, delim, prefix, suffix, it.iterator());
	}

	/**
	 * @see #insertJoin(int, CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars insertJoin(int offset, Iterator<CharSequence> it) {
		return insertJoin(offset, null, it);
	}

	/**
	 * @see #insertJoin(int, CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars insertJoin(int offset, CharSequence delim, Iterator<CharSequence> it) {
		return insertJoin(offset, delim, null, null, it);
	}

	/**
	 * join items of given iterator and insert
	 */
	public Chars insertJoin(int offset, CharSequence delim, CharSequence prefix, CharSequence suffix,
			Iterator<CharSequence> it) {
		Lang.emptyOrNull.requireNoNull(it);
		Chars c = of();
		if (prefix != null) {
			c = c.append(prefix);
		}
		if (delim != null) {
			it.hasNext();
			c = c.append(it.next());
			while (it.hasNext()) {
				c = c.append(delim).append(it.next());
			}
		} else {
			while (it.hasNext()) {
				c = c.append(it.next());
			}
		}
		if (suffix != null) {
			c = c.append(suffix);
		}
		return insert(offset, c);
	}

	// ===============
	// =============== join and insert as lines
	// ===============

	/**
	 * join and insert given code-points, delim='\n'
	 */
	public Chars insertJoinAsLines(int offset, int... elements) {
		return insertJoin(offset, '\n', elements);
	}

	/**
	 * join and insert given char-sequence, delim='\n'
	 */
	public Chars insertJoinAsLines(int offset, CharSequence... elements) {
		return insertJoin(offset, "\n", elements);
	}

	/**
	 * join and insert given iterator/iterable items, delim='\n'
	 */
	public Chars insertJoinAsLines(int offset, Iterable<CharSequence> it) {
		return insertJoinAsLines(offset, it.iterator());
	}

	/**
	 * join and insert given iterator/iterable items, delim='\n'
	 */
	public Chars insertJoinAsLines(int offset, Iterator<CharSequence> it) {
		return insertJoin(offset, "\n", it);
	}

	// ===============
	// =============== append
	// ===============

	/**
	 * format and append given args into this sequence
	 */
	public Chars appendFormat(CharSequence format, Object... args) {
		return insertFormat(length(), format, args);
	}

	/**
	 * append "null"
	 */
	public Chars appendNull() {
		return insertNull(length());
	}

	/**
	 * append object.toString(), if object is null, append "null"
	 */
	public Chars appendObject(Object obj) {
		return insertObject(length(), obj);
	}

	/**
	 * append given char-sequence, if char-sequence is null, append "null"
	 */
	public Chars append(CharSequence cs) {
		return insert(length(), cs);
	}

	/**
	 * append given char-sequence, based on given range if char-sequence is null,
	 * append "null"
	 */
	public Chars append(CharSequence cs, int from) {
		return insert(length(), cs, from, cs.length());
	}

	/**
	 * append given char-sequence, based on given range if char-sequence is null,
	 * append "null"
	 */
	public Chars append(CharSequence cs, int from, int to) {
		return insert(length(), cs, from, to);
	}

	/**
	 * append given array
	 */
	public Chars append(char[] array) {
		return append(array, array.length);
	}

	/**
	 * append given array
	 */
	public Chars append(char[] array, int arrayLength) {
		return append(array, arrayLength, 0, arrayLength);
	}

	/**
	 * append given array based on given copy-offset and given copy-length
	 */
	public Chars append(char[] array, int arrayLength, int copyOffset, int copyLen) {
		return insert(length(), array, arrayLength, copyOffset, copyLen);
	}

	/**
	 * append given byte
	 */
	public Chars append(byte n) {
		return append((int) n);
	}

	/**
	 * append given boolean
	 */
	public Chars append(boolean b) {
		return insert(length(), b);
	}

	/**
	 * append given short
	 */
	public Chars append(short n) {
		return append((int) n);
	}

	/**
	 * append given char
	 */
	public Chars append(char ch) {
		return insert(length(), ch);
	}

	/**
	 * append given integer
	 */
	public Chars append(int n) {
		return insert(length(), n);
	}

	/**
	 * append given long
	 */
	public Chars append(long n) {
		return insert(length(), n);
	}

	/**
	 * append given float
	 */
	public Chars append(float n) {
		return insert(length(), n);
	}

	/**
	 * append given double
	 */
	public Chars append(double n) {
		return insert(length(), n);
	}

	/**
	 * append given code-point
	 */
	public Chars appendCodePoint(int cp) {
		return insertCodePoint(length(), cp);
	}

	/**
	 * append given code-points array
	 */
	public Chars appendCodePoints(int[] cps) {
		return appendCodePoints(cps, 0);
	}

	/**
	 * append given code-points array based on given range
	 */
	public Chars appendCodePoints(int[] cps, int from) {
		return appendCodePoints(cps, from, cps.length);
	}

	/**
	 * append given code-points array based on given range
	 */
	public Chars appendCodePoints(int[] cps, int from, int to) {
		return insertCodePoints(length(), cps, from, to);
	}

	// ===============
	// =============== append join code-points
	// ===============

	/**
	 * @see #appendJoin(int, int, int, int...)
	 */
	public Chars appendJoin(int... elements) {
		return appendJoin(0, elements);
	}

	/**
	 * @see #appendJoin(int, int, int, int...)
	 */
	public Chars appendJoin(int delim, int... elements) {
		return appendJoin(delim, 0, 0, elements);
	}

	/**
	 * join given code-points array and insert
	 */
	public Chars appendJoin(int delim, int prefix, int suffix, int... elements) {
		return insertJoin(length(), delim, prefix, suffix, elements);
	}

	// ===============
	// =============== append join CharSequence
	// ===============

	/**
	 * @see #appendJoin(CharSequence, CharSequence, CharSequence, CharSequence...)
	 */
	public Chars appendJoin(CharSequence... elements) {
		return appendJoin(null, elements);
	}

	/**
	 * @see #appendJoin(CharSequence, CharSequence, CharSequence, CharSequence...)
	 */
	public Chars appendJoin(CharSequence delim, CharSequence... elements) {
		return appendJoin(delim, null, null, elements);
	}

	/**
	 * join given sequences array and append it
	 */
	public Chars appendJoin(CharSequence delim, CharSequence prefix, CharSequence suffix, CharSequence... elements) {
		return insertJoin(length(), delim, prefix, suffix, elements);
	}

	/**
	 * @see #appendJoin(CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars appendJoin(Iterable<CharSequence> it) {
		return appendJoin(null, it);
	}

	/**
	 * @see #appendJoin(CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars appendJoin(CharSequence delim, Iterable<CharSequence> it) {
		return appendJoin(delim, null, null, it);
	}

	// ===============
	// =============== append join iterator/iterable
	// ===============

	/**
	 * @see #appendJoin(CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars appendJoin(CharSequence delim, CharSequence prefix, CharSequence suffix, Iterable<CharSequence> it) {
		return appendJoin(delim, prefix, suffix, it.iterator());
	}

	/**
	 * @see #appendJoin(CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars appendJoin(Iterator<CharSequence> it) {
		return appendJoin(null, it);
	}

	/**
	 * @see #appendJoin(CharSequence, CharSequence, CharSequence, Iterator)
	 */
	public Chars appendJoin(CharSequence delim, Iterator<CharSequence> it) {
		return appendJoin(delim, null, null, it);
	}

	/**
	 * join items of given iterator and append it
	 */
	public Chars appendJoin(CharSequence delim, CharSequence prefix, CharSequence suffix, Iterator<CharSequence> it) {
		return insertJoin(length(), delim, prefix, suffix, it);
	}

	// ===============
	// =============== join and append as lines
	// ===============

	/**
	 * join and append given code-points, delim='\n'
	 */
	public Chars appendJoinAsLines(int... elements) {
		return insertJoin(length(), '\n', elements);
	}

	/**
	 * join and append given char-sequence, delim='\n'
	 */
	public Chars appendJoinAsLines(CharSequence... elements) {
		return insertJoin(length(), "\n", elements);
	}

	/**
	 * join and append given iterator/iterable items, delim='\n'
	 */
	public Chars appendJoinAsLines(Iterable<CharSequence> it) {
		return insertJoinAsLines(length(), it.iterator());
	}

	/**
	 * join and insert given iterator/iterable items, delim='\n'
	 */
	public Chars appendJoinAsLines(Iterator<CharSequence> it) {
		return insertJoin(length(), "\n", it);
	}

	// ===============
	// =============== sub-string
	// ===============

	/**
	 * @see #substring(int, int)
	 */
	public String substring(int from) {
		return substring(from, length());
	}

	/**
	 * @see String#substring(int, int)
	 */
	public String substring(int from, int to) {
		int len = length();
		if (len == 0 || from == to) {
			return "";
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		return new String(unsafe(), from, to - from);
	}

	// ===============
	// =============== sub-string before
	// ===============

	/**
	 * @see #substringBefore(char[], int)
	 */
	public String substringBefore(int separator) {
		int len = lengthActual();
		if (len == 0) {
			return toString();
		}

		final int pos = indexOf(separator);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return toString();
		}
		return substring(0, pos);
	}

	/**
	 * @see #substringBefore(char[], int)
	 */
	public String substringBefore(CharSequence separator) {
		char[] tarr = null;
		int tlen = 0;
		if (separator instanceof Chars) {
			Chars c = (Chars) separator;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (separator != null) {
			tarr = separator.toString().toCharArray();
			tlen = separator.length();
		}
		return substringBefore(tarr, tlen);
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".substringBefore(null, 0)           = ""
	 * "".substringBefore(new char[]{}, 0)           = ""
	 * "abc".substringBefore(new char[]{}, 0)       = "" 
	 * "abc".substringBefore(null, 0)     = "abc"
	 * "codes.abdullah".substringBefore({'c', 'o', 'd', 'e', 's'}, 5)      = ""
	 * "abcba".substringBefore({'b'}, 1)    = "a"
	 * "abc".substringBefore({'c'}, 1)      = "ab"
	 * "abc".substringBefore({'d'}, 1)      = "abc"
	 * </pre>
	 */
	public String substringBefore(char[] separator, int separatorLength) {
		int len = lengthActual();
		if (len == 0 || Lang.emptyOrNull.isAny(separator) || separatorLength <= 0) {
			return toString();
		}

		final int pos = indexOf(separator, separatorLength);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return toString();
		}
		return substring(0, pos);
	}

	// ===============
	// =============== sub-string before-last
	// ===============

	/**
	 * @see #substringBeforeLast(char[], int)
	 */
	public String substringBeforeLast(int separator) {
		if (isEmpty()) {
			return toString();
		}

		final int pos = lastIndexOf(separator);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return toString();
		}
		return substring(0, pos);
	}

	/**
	 * @see #substringBeforeLast(char[], int)
	 */
	public String substringBeforeLast(CharSequence separator) {
		char[] tarr = null;
		int tlen = 0;
		if (separator instanceof Chars) {
			Chars c = (Chars) separator;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (separator != null) {
			tarr = separator.toString().toCharArray();
			tlen = separator.length();
		}
		return substringBeforeLast(tarr, tlen);
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".substringBeforeLast(null, 0)           = ""
	 * "".substringBeforeLast(new char[]{}, 0)           = ""
	 * "abcba".substringBeforeLast({'b'}, 1)    = "abc"
	 * "abc".substringBeforeLast({'c'}, 1)      = "ab"
	 * "a".substringBeforeLast({'a'}, 1)        = ""
	 * "a".substringBeforeLast({'z'}, 1)        = "a"
	 * "a".substringBeforeLast(null, 0)       = "a"
	 * "a".substringBeforeLast(new char[]{}, 0)         = "a"
	 * </pre>
	 */
	public String substringBeforeLast(char[] separator, int separatorLength) {
		if (isEmpty() || Lang.emptyOrNull.isAny(separator) || separatorLength <= 0) {
			return toString();
		}

		final int pos = lastIndexOf(separator, separatorLength);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return toString();
		}
		return substring(0, pos);
	}

	// ===============
	// =============== sub-string after
	// ===============

	/**
	 * @see #substringAfter(char[], int)
	 */
	public String substringAfter(int separator) {
		if (isEmpty()) {
			return toString();
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		if (!sps.isBmp(separator)) {
			return "";
		}
		final int pos = indexOf(separator);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return "";
		}
		return substring(pos + sps.lengthOf(separator));
	}

	/**
	 * @see #substringAfter(char[], int)
	 */
	public String substringAfter(CharSequence separator) {
		char[] tarr = null;
		int tlen = 0;
		if (separator instanceof Chars) {
			Chars c = (Chars) separator;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (separator != null) {
			tarr = separator.toString().toCharArray();
			tlen = separator.length();
		}
		return substringAfter(tarr, tlen);
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".substringAfter(null, 0)           = ""
	 * "".substringAfter(new char[]{}, 0)           = ""
	 * "codes".substringAfter(null, 0)         = ""
	 * "codes".substringAfter(new char[]{}, 0)         = "codes"
	 * "abc".substringAfter({'a'}, 1)      = "bc"
	 * "abcba".substringAfter({'b'}, 1)    = "cba"
	 * "abc".substringAfter({'c'}, 1)      = ""
	 * "abc".substringAfter({'d'}, 1)      = ""
	 * </pre>
	 */
	public String substringAfter(char[] separator, int separatorLength) {
		if (isEmpty() || (separator != null && separatorLength <= 0)) {
			return toString();
		}
		if (separator == null) {
			return "";
		}
		final int pos = indexOf(separator, separatorLength);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return "";
		}
		return substring(pos + separatorLength);
	}

	// ===============
	// =============== sub-string after-last
	// ===============

	/**
	 * @see #substringAfterLast(char[], int)
	 */
	public String substringAfterLast(int separator) {
		if (isEmpty()) {
			return toString();
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		if (!sps.isBmp(separator)) {
			return "";
		}
		final int pos = lastIndexOf(separator);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return "";
		}
		return substring(pos + sps.lengthOf(separator));
	}

	/**
	 * @see #substringAfterLast(char[], int)
	 */
	public String substringAfterLast(CharSequence separator) {
		char[] tarr = null;
		int tlen = 0;
		if (separator instanceof Chars) {
			Chars c = (Chars) separator;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (separator != null) {
			tarr = separator.toString().toCharArray();
			tlen = separator.length();
		}
		return substringAfterLast(tarr, tlen);
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".substringAfterLast(null, 0)           = ""
	 * "".substringAfterLast(new char[]{}, 0)           = ""
	 * "codes".substringAfterLast(new char[]{}, 0)           = ""
	 * "codes".substringAfterLast(null, 0)         = ""
	 * "abc".substringAfterLast({'a'}, 1)      = "bc"
	 * "abcba".substringAfterLast({'b'}, 1)    = "a"
	 * "abc".substringAfterLast({'c'}, 1)      = ""
	 * "a".substringAfterLast({'a'}, 1)        = ""
	 * "a".substringAfterLast({'z'}, 1)        = ""
	 * </pre>
	 */
	public String substringAfterLast(char[] separator, int separatorLength) {
		if (isEmpty()) {
			return toString();
		}
		if (Lang.emptyOrNull.isAny(separator) || separatorLength <= 0) {
			return "";
		}
		final int pos = lastIndexOf(separator, separatorLength);
		if (pos == Lang.constant.INDEX_NOT_FOUND) {
			return "";
		}
		return substring(pos + separatorLength);
	}

	// ===============
	// =============== sub-string between
	// ===============

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public String substringBetween(int tag) {
		return substringBetween(tag, tag);
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public String substringBetween(int open, int close) {
		CodepointSupport sps = getSurrogatePairsSupport();
		if (isEmpty() || !sps.isBmp(open) || !sps.isBmp(close)) {
			return "";
		}

		final int start = indexOf(open);
		if (start != Lang.constant.INDEX_NOT_FOUND) {
			final int end = indexOf(close, start + sps.lengthOf(open));
			if (end != Lang.constant.INDEX_NOT_FOUND) {
				return substring(start + sps.lengthOf(open), end);
			}
		}
		return "";
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public String substringBetween(CharSequence tag) {
		return substringBetween(tag, tag);
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public String substringBetween(CharSequence open, CharSequence close) {
		char[] oarr = null, carr = null;
		int olen = 0, clen = 0;
		if (open instanceof Chars) {
			Chars c = (Chars) open;
			oarr = c.unsafe();
			olen = c.lengthActual();
		} else if (open != null) {
			oarr = open.toString().toCharArray();
			olen = open.length();
		}
		if (close instanceof Chars) {
			Chars c = (Chars) close;
			carr = c.unsafe();
			clen = c.lengthActual();
		} else if (close != null) {
			carr = close.toString().toCharArray();
			clen = close.length();
		}
		return substringBetween(oarr, olen, carr, clen);
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public String substringBetween(char[] tag, int tagLength) {
		return substringBetween(tag, tagLength, tag, tagLength);
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "wx[b]yz".substringBetween({'['}, 1, {']'}, 1)       = "b"
	 * "".substringBetween(null, 0, null, 0)                  = ""
	 * "codes".substringBetween(null, 0, {']'}, 1)                = ""
	 * "codes".substringBetween({'['}, 1, null, 0)                = ""
	 * "".substringBetween(new char[]{}, 0, new char[]{}, 0)                = ""
	 * "".substringBetween(new char[]{}, 0, {']'}, 1)               = ""
	 * "".substringBetween({'['}, 1, {']'}, 1)              = ""
	 * "yabcz".substringBetween(new char[]{}, 0, new char[]{}, 0)           = ""
	 * "yabcz".substringBetween({'y'}, 1, {'z'}, 1)         = "abc"
	 * "yabczyabcz".substringBetween({'y'}, 1, {'z'}, 1)    = "abc"
	 * </pre>
	 */
	public String substringBetween(char[] open, int openLength, char[] close, int closeLength) {
		if (isEmpty() || Lang.emptyOrNull.isAny(open) || Lang.emptyOrNull.isAny(close) || openLength <= 0
				|| closeLength <= 0) {
			return "";
		}

		final int start = indexOf(open, openLength);
		if (start != Lang.constant.INDEX_NOT_FOUND) {
			final int end = indexOf(close, closeLength, start + openLength);
			if (end != Lang.constant.INDEX_NOT_FOUND) {
				return substring(start + openLength, end);
			}
		}
		return "";
	}

	// ===============
	// =============== sub-sequence
	// ===============

	/**
	 * @see #subSequence(int, int)
	 */
	public CharSequence subSequence(int from) {
		return subSequence(from, length());
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return substring(start, end);
	}

	// ===============
	// =============== sub-chars
	// ===============

	/**
	 * @see #sub(int, int)
	 */
	public Chars sub(int from) {
		return sub(from, length());
	}

	/**
	 * same as substring, just return it as {@link Chars}
	 */
	public Chars sub(int from, int to) {
		int len = length();
		if (len == 0 || from == to) {
			return newInstance("");
		}

		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = safe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		// since the range is (from-to), means the count of spc between from-to
		// equals the spc_newlen
		to += disp;
		// -------------------
		int spc_newlen = sps.isSupported() ? disp : 0;
		return newInstance(Arrays.copyOfRange(unsafe(), from, to), to - from, spc_newlen, getSurrogatePairsSupport(),
				getFlags());
	}

	// ===============
	// =============== sub-chars before
	// ===============

	/**
	 * @see #substringBefore(char[], int)
	 */
	public Chars subBefore(int separator) {
		return newInstance(substringBefore(separator));
	}

	/**
	 * @see #substringBefore(char[], int)
	 */
	public Chars subBefore(CharSequence separator) {
		return newInstance(substringBefore(separator));
	}

	/**
	 * @see #substringBefore(char[], int)
	 */
	public Chars subBefore(char[] separator, int separatorLength) {
		return newInstance(substringBefore(separator, separatorLength));
	}

	// ===============
	// =============== sub-chars before-last
	// ===============

	/**
	 * @see #substringBeforeLast(char[], int)
	 */
	public Chars subBeforeLast(int separator) {
		return newInstance(substringBeforeLast(separator));
	}

	/**
	 * @see #substringBeforeLast(char[], int)
	 */
	public Chars subBeforeLast(CharSequence separator) {
		return newInstance(substringBeforeLast(separator));
	}

	/**
	 * @see #substringBeforeLast(char[], int)
	 */
	public Chars subBeforeLast(char[] separator, int separatorLength) {
		return newInstance(substringBeforeLast(separator, separatorLength));
	}

	// ===============
	// =============== sub-chars after
	// ===============

	/**
	 * @see #substringAfter(char[], int)
	 */
	public Chars subAfter(int separator) {
		return newInstance(substringAfter(separator));
	}

	/**
	 * @see #substringAfter(char[], int)
	 */
	public Chars subAfter(CharSequence separator) {
		return newInstance(substringAfter(separator));
	}

	/**
	 * @see #substringAfter(char[], int)
	 */
	public Chars subAfter(char[] separator, int separatorLength) {
		return newInstance(substringAfter(separator, separatorLength));
	}

	// ===============
	// =============== sub-chars after-last
	// ===============

	/**
	 * @see #substringAfterLast(char[], int)
	 */
	public Chars subAfterLast(int separator) {
		return newInstance(substringAfterLast(separator));
	}

	/**
	 * @see #substringAfterLast(char[], int)
	 */
	public Chars subAfterLast(CharSequence separator) {
		return newInstance(substringAfterLast(separator));
	}

	/**
	 * @see #substringAfterLast(char[], int)
	 */
	public Chars subAfterLast(char[] separator, int separatorLength) {
		return newInstance(substringAfterLast(separator, separatorLength));
	}

	// ===============
	// =============== sub-chars between
	// ===============

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(int tag) {
		return subBetween(tag, tag);
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(int open, int close) {
		return newInstance(substringBetween(open, close));
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(CharSequence tag) {
		return subBetween(tag, tag);
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(CharSequence open, CharSequence close) {
		return newInstance(substringBetween(open, close));
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(char[] tag, int tagLength) {
		return subBetween(tag, tagLength, tag, tagLength);
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(char[] open, int openLength, char[] close, int closeLength) {
		return newInstance(substringBetween(open, openLength, close, closeLength));
	}

	// ===============
	// =============== assign-difference
	// ===============

	/**
	 * @see #difference(CharSequence, int, boolean)
	 */
	public Chars assignDifference(CharSequence competitive) {
		return assignDifference(competitive, 0);
	}

	/**
	 * @see #difference(CharSequence, int, boolean)
	 */
	public Chars assignDifference(CharSequence competitive, int offset) {
		return assignDifference(competitive, offset, iagc());
	}

	/**
	 * @see #difference(CharSequence, int, boolean)
	 */
	public Chars assignDifference(CharSequence competitive, int offset, boolean ignoreCase) {
		return assign(difference(competitive));
	}

	// ===============
	// =============== get-difference
	// ===============
	/**
	 * @see #difference(CharSequence, int, boolean)
	 */
	public CharSequence difference(CharSequence competitive) {
		return difference(competitive, 0);
	}

	/**
	 * @see #difference(CharSequence, int, boolean)
	 */
	public CharSequence difference(CharSequence competitive, int offset) {
		return difference(competitive, offset, iagc());
	}

	/**
	 * @return the difference between this sequence and given competitive
	 * 
	 *         [TEST]
	 * 
	 *         <pre>
	 * "".difference(null, 0, false) = ""
	 * "".difference("", 0, false) = ""
	 * "".difference("abc", 0, false) = "abc"
	 * "abc".difference("", 0, false) = ""
	 * "abc".difference("abc", 0, false) = ""
	 * "".difference("", 0, false) = ""
	 * "abc".difference("ab") = ""
	 * "ab".difference("abxyz") = "xyz"
	 * "abcde".difference("abxyz") = "xyz"
	 * "abcde".difference("xyz") = "xyz"
	 *         </pre>
	 */
	public CharSequence difference(CharSequence competitive, int offset, boolean ignoreCase) {
		if (Lang.emptyOrNull.isAny(competitive)) {
			return "";
		}

		if (isEmpty()) {
			return competitive == null ? competitive : competitive.toString().substring(offset);
		}
		int at = indexOfDifference(competitive, offset, ignoreCase);
		if (at == Lang.constant.INDEX_NOT_FOUND) {
			return "";
		}
		return competitive.subSequence(at, competitive.length()).toString();
	}

	// ===============
	// =============== pad
	// ===============

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".leftPad(0)        = ""
	 * "".leftPad(3)        = " "
	 * "bat".leftPad(3)     = "bat"
	 * "bat".leftPad(5)     = " bat"
	 * "bat".leftPad(1)     = "bat"
	 * "bat".leftPad(-1)    = "bat"
	 * </pre>
	 * 
	 * <br>
	 * <b>default</b> pad: ' '
	 */
	public Chars leftPad(int size) {
		return leftPad(size, ' ');
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".leftPad(0, 0)          = ""
	 * "".leftPad(3, 'z')        = "zzz"
	 * "bat".leftPad(3, 'z')     = "bat"
	 * "bat".leftPad(5, 'z')     = "zzbat"
	 * "bat".leftPad(1, 'z')     = "bat"
	 * "bat".leftPad(-1, 'z')    = "bat"
	 * </pre>
	 */
	public Chars leftPad(int size, int codePoint) {
		int len = length();
		final int pads = size - len;
		if (pads <= 0) {
			return this;
		}
		if (pads > Lang.constant.DEFAULT_PAD_LIMIT) {
			CodepointSupport sps = getSurrogatePairsSupport();
			return rightPad(size, sps.toString(codePoint));
		}
		return repeat(codePoint, pads, 0);
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".leftPad(0, 0)           = ""
	 * "".leftPad(3, "z")         = "zzz"
	 * "bat".leftPad(3, "yz")     = "bat"
	 * "bat".leftPad(5, "yz")     = "yzbat"
	 * "bat".leftPad(8, "yz")     = "yzyzybat"
	 * "bat".leftPad(1, "yz")     = "bat"
	 * "bat".leftPad(-1, "yz")    = "bat"
	 * "bat".leftPad(5, null)     = " bat"
	 * "bat".leftPad(5, "")       = " bat"
	 * </pre>
	 */
	public Chars leftPad(final int size, CharSequence cs) {
		int len = length();
		if (Lang.emptyOrNull.isAny(cs)) {
			cs = " ";
		}
		final int padLen = cs.length();
		int pads = size - len;
		if (pads <= 0) {
			return this;
		}
		if (padLen == 1 && pads <= Lang.constant.DEFAULT_PAD_LIMIT) {
			CodepointSupport sps = getSurrogatePairsSupport();
			return leftPad(size, sps.getCodepoint(cs, 0));
		}

		if (pads == padLen) {
			return insert(0, cs);
		} else if (pads < padLen) {
			return insert(0, cs, 0, pads);
		} else {
			CodepointSupport sps = getSurrogatePairsSupport();
			int innerlen = lengthActual();
			int innerlen_was = innerlen;
			char[] arr = safe();
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + pads);
			int bi = 0, pspc = 0;
			for (int i = 0; i < pads; i++) {
				bi = i % padLen;
				if (sps.isPair(cs, bi)) {
					pspc += 1;
					pads += 1;
					arr = Lang.capacity.ensure(arr, innerlen, innerlen + pads);
				}
				arr[innerlen++] = cs.charAt(bi);
			}
			int diff = innerlen - innerlen_was;
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + diff);
			Lang.copy.to.that(arr, arr.length, arr, arr.length, 0, 0 + innerlen, diff);
			Lang.copy.to.that(arr, arr.length, arr, arr.length, innerlen, innerlen + diff, 0);
			return assign(arr, innerlen, sps.isSupported() ? spc() + pspc : 0, sps, getFlags());
		}
	}

	/**
	 * <p>
	 * Right pad
	 * </p>
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".rightPad(0)        = ""
	 * "".rightPad(3)        = " "
	 * "bat".rightPad(3)     = "bat"
	 * "bat".rightPad(5)     = "bat "
	 * "bat".rightPad(1)     = "bat"
	 * "bat".rightPad(-1)    = "bat"
	 * </pre>
	 * 
	 * <br>
	 * <b>default</b> pad: ' '
	 */
	public Chars rightPad(int size) {
		return rightPad(size, ' ');
	}

	/**
	 * <p>
	 * Right pad a with a specified code-point.
	 * </p>
	 *
	 * [TEST]
	 * 
	 * <pre>
	 * "".rightPad(0, 0)          = ""
	 * "".rightPad('z', 3)        = "zzz"
	 * "bat".rightPad('z', 3)     = "bat"
	 * "bat".rightPad('z', 5)     = "batzz"
	 * "bat".rightPad('z', 1)     = "bat"
	 * "bat".rightPad('z', -1)    = "bat"
	 * </pre>
	 */
	public Chars rightPad(int size, int padCodePoint) {
		int len = length();
		final int pads = size - len;
		if (pads <= 0) {
			return this;
		}
		if (pads > Lang.constant.DEFAULT_PAD_LIMIT) {
			CodepointSupport sps = getSurrogatePairsSupport();
			return rightPad(size, sps.toString(padCodePoint));
		}
		return repeat(padCodePoint, pads, length());
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".rightPad(0, 0)           = ""
	 * "".rightPad(3, "z")         = "zzz"
	 * "bat".rightPad(3, "yz")     = "bat"
	 * "bat".rightPad(5, "yz")     = "batyz"
	 * "bat".rightPad(8, "yz")     = "batyzyzy"
	 * "bat".rightPad(1, "yz")     = "bat"
	 * "bat".rightPad(-1, "yz")    = "bat"
	 * "bat".rightPad(5, null)     = "bat "
	 * "bat".rightPad(5, "")       = "bat "
	 * </pre>
	 */
	public Chars rightPad(int size, CharSequence pad) {
		int len = length();
		if (Lang.emptyOrNull.isAny(pad)) {
			pad = " ";
		}
		final int padLen = pad.length();
		int pads = size - len;
		if (pads <= 0) {
			return this;
		}
		if (padLen == 1 && pads <= Lang.constant.DEFAULT_PAD_LIMIT) {
			return rightPad(size, getSurrogatePairsSupport().getCodepoint(pad, 0));
		}

		if (pads == padLen) {
			return append(pad);
		} else if (pads < padLen) {
			return append(pad, 0, pads);
		} else {
			CodepointSupport sps = getSurrogatePairsSupport();
			int innerlen = lengthActual();
			char[] arr = safe();
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + pads);
			int bi = 0, pspc = 0;
			for (int i = 0; i < pads; i++) {
				bi = i % padLen;
				if (sps.isPair(pad, bi)) {
					pspc += 1;
					pads += 1;
					arr = Lang.capacity.ensure(arr, innerlen, innerlen + pads);
				}
				arr[innerlen++] = pad.charAt(bi);
			}
			return assign(arr, innerlen, sps.isSupported() ? spc() + pspc : 0, sps, getFlags());
		}
	}

	// ===============
	// =============== center
	// ===============

	/**
	 * <p>
	 * Centers the content based on given size
	 * </p>
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".center(0)        = ""
	 * "".center(4)        = " "
	 * "ab".center(-1)     = "ab"
	 * "ab".center(4)      = " ab "
	 * "abcd".center(2)    = "abcd"
	 * "a".center(4)       = " a "
	 * </pre>
	 * 
	 * <br>
	 * <b>default</b> padCodePoint: ' '
	 */
	public Chars center(int size) {
		return center(size, ' ');
	}

	/**
	 * <p>
	 * Centers the content based on given size
	 * </p>
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".center(0, 0)          = ""
	 * "".center(4, ' ')        = " "
	 * "ab".center(-1, ' ')     = "ab"
	 * "ab".center(4, ' ')      = " ab "
	 * "abcd".center(2, ' ')    = "abcd"
	 * "a".center(4, ' ')       = " a "
	 * "a".center(4, 'y')       = "yayy"
	 * </pre>
	 * 
	 */
	public Chars center(int size, int padCodePoint) {
		if (size <= 0) {
			return this;
		}
		int len = lengthActual();
		final int pads = size - len;
		if (pads <= 0) {
			return this;
		}
		return leftPad(len + pads / 2, padCodePoint).rightPad(size, padCodePoint);
	}

	/**
	 * <p>
	 * Centers the content based on given size
	 * </p>
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".center(0, 0)          = ""
	 * "".center(4, " ")        = " "
	 * "ab".center(-1, " ")     = "ab"
	 * "ab".center(4, " ")      = " ab "
	 * "abcd".center(2, " ")    = "abcd"
	 * "a".center(4, " ")       = " a "
	 * "a".center(4, "yz")      = "yayz"
	 * "abc".center(7, null)    = " abc "
	 * "abc".center(7, "")      = " abc "
	 * </pre>
	 */
	public Chars center(int size, CharSequence pad) {
		if (size <= 0) {
			return this;
		}
		if (Lang.emptyOrNull.isAny(pad)) {
			pad = " ";
		}
		int len = length();
		final int pads = size - len;
		if (pads <= 0) {
			return this;
		}
		return leftPad(len + pads / 2, pad).rightPad(size, pad);
	}

	// ===============
	// =============== chop
	// ===============
	/**
	 * <p>
	 * Remove the last character from this sequence.
	 * </p>
	 *
	 * <p>
	 * If this sequence ends with {@code \r\n}, then remove both of them.
	 * </p>
	 *
	 * [TEST]
	 * 
	 * <pre>
	 * "".chop()            = ""
	 * "".chop()            = ""
	 * "abc \r".chop()      = "abc "
	 * "abc\n".chop()       = "abc"
	 * "abc\r\n".chop()     = "abc"
	 * "abc".chop()         = "ab"
	 * "abc\nabc".chop()    = "abc\nab"
	 * "a".chop()           = ""
	 * "\r".chop()          = ""
	 * "\n".chop()          = ""
	 * "\r\n".chop()        = ""
	 * </pre>
	 */
	public Chars chop() {
		int innerlen = lengthActual();
		if (innerlen == 0)
			return this;
		if (innerlen < 2) {
			return clear();
		}

		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		if (sps.isPairIntersectly(arr, innerlen, innerlen - 1)) {
			return assign(arr, innerlen - 2, spc - 1, sps, getFlags());
		}

		final int lastIdx = innerlen - 1;
		final char last = arr[lastIdx];

		if (last == 0xA && arr[lastIdx - 1] == 0xD) {
			return assign(arr, innerlen - 2, spc, sps, getFlags());
		}

		return assign(safe(), innerlen - 1, spc, sps, getFlags());
	}

	// ===============
	// =============== chomp
	// ===============

	/**
	 * <p>
	 * Removes one newline from end of this sequence if it's there, otherwise leave
	 * it alone. A newline is &quot;{@code \n}&quot;, &quot;{@code \r}&quot;, or
	 * &quot;{@code \r\n}&quot;.
	 * </p>
	 *
	 * [TEST]
	 * 
	 * <pre>
	 * "".chomp()               = ""
	 * "".chomp()               = ""
	 * "abc \r".chomp()         = "abc "
	 * "abc\n".chomp()          = "abc"
	 * "abc\r\n".chomp()        = "abc"
	 * "abc\r\n\r\n".chomp()    = "abc\r\n"
	 * "abc\n\r".chomp()        = "abc\n"
	 * "abc\n\rabc".chomp()     = "abc\n\rabc"
	 * "\r".chomp()             = ""
	 * "\n".chomp()             = ""
	 * "\r\n".chomp()           = ""
	 * </pre>
	 * 
	 */
	public Chars chomp() {
		int len = lengthActual();
		if (len == 0)
			return this;

		if (len == 1) {
			char ch = charAt(0);
			if (ch == 0xD || ch == 0xA) {
				return assign(safe(), 0, spc(), getSurrogatePairsSupport(), getFlags());
			}
			return this;
		}

		int lastIdx = len - 1;
		char last = charAt(lastIdx);

		if (last == 0xA) {
			if (charAt(lastIdx - 1) == 0xD) {
				lastIdx--;
			}
		} else if (last != 0xD) {
			lastIdx++;
		}
		return assign(safe(), lastIdx, spc(), getSurrogatePairsSupport(), getFlags());
	}

	// ===============
	// =============== ellipse
	// ===============

	/**
	 * @see #abbreviate(int, CharSequence, int)
	 */
	public Chars ellipse(int maxWidth) {
		return ellipse(maxWidth, 0);
	}

	/**
	 * @see #abbreviate(int, CharSequence, int)
	 */
	public Chars ellipse(int maxWidth, int offset) {
		return abbreviate(maxWidth, "...", offset);
	}

	// ===============
	// ===============
	// ===============

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".abbreviate(0)           = ""
	 * "".abbreviate(4)           = ""
	 * "abcdefg".abbreviate(6)    = "abc..."
	 * "abcdefg".abbreviate(7)    = "abcdefg"
	 * "abcdefg".abbreviate(8)    = "abcdefg"
	 * "abcdefg".abbreviate(4)    = "a..."
	 * "abcdefg".abbreviate(3)    = java.lang.IllegalArgumentException
	 * </pre>
	 * 
	 * @see #abbreviate(int, CharSequence, int)
	 */
	public Chars abbreviate(int maxWidth) {
		return abbreviate(maxWidth, "...");
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".abbreviate(0, "...")           = ""
	 * "abcdefg".abbreviate(0, null)     = "abcdefg"
	 * "".abbreviate(4, "...")           = ""
	 * "abcdefg".abbreviate(5, ".")      = "abcd."
	 * "abcdefg".abbreviate(7, ".")      = "abcdefg"
	 * "abcdefg".abbreviate(8, ".")      = "abcdefg"
	 * "abcdefg".abbreviate(4, "..")     = "ab.."
	 * "abcdefg".abbreviate(3, "..")     = "a.."
	 * "abcdefg".abbreviate(2, "..")     = java.lang.IllegalArgumentException
	 * "abcdefg".abbreviate(3, "...")    = java.lang.IllegalArgumentException
	 * </pre>
	 * 
	 * 
	 * @see #abbreviate(int, CharSequence, int)
	 */
	public Chars abbreviate(int maxWidth, CharSequence marker) {
		return abbreviate(maxWidth, marker, 0);
	}

	/**
	 * Abbreviates using ellipses. e.g:<br>
	 * "Now is the time for all good men"<br>
	 * output<br>
	 * "...is the time for..."
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".abbreviate(0, null, 0)                      = ""
	 * "abcdefghijklmno".abbreviate(0, null, 0)       = "abcdefghijklmno"
	 * "".abbreviate(4, "...", 0)                     = ""
	 * "abcdefghijklmno".abbreviate(10, "---", -1)    = "abcdefg---"
	 * "abcdefghijklmno".abbreviate(0, ", ")          = "abcdefghi,"
	 * "abcdefghijklmno".abbreviate(1, ", ")          = "abcdefghi,"
	 * "abcdefghijklmno".abbreviate(2, ", ")          = "abcdefghi,"
	 * "abcdefghijklmno".abbreviate(10, "::", 4)      = "::efghij::"
	 * "abcdefghijklmno".abbreviate(10, "...", 6)     = "...ghij..."
	 * "abcdefghijklmno".abbreviate(10, "ANY_THING", 9)       = "*ghijklmno"
	 * "abcdefghijklmno".abbreviate(10, "'", 10)      = "'ghijklmno"
	 * "abcdefghijklmno".abbreviate(10, "!", 12)      = "!ghijklmno"
	 * "abcdefghij".abbreviate(4, "abra", 0)          = java.lang.IllegalArgumentException
	 * "abcdefghij".abbreviate(6, "...", 5)           = java.lang.IllegalArgumentException
	 * </pre>
	 * 
	 * 
	 * 
	 * 
	 * <br>
	 * <b>default</b> offset = 0 <br>
	 * <b>default</b> marker = "..."
	 */
	public Chars abbreviate(int maxWidth, CharSequence marker, int offset) {
		int len = length();
		if (len == 0 && Lang.emptyOrNull.isAny(marker)) {
			return this;
		} else if (len > 0 && Lang.emptyOrNull.isAny(marker) && maxWidth > 0) {
			CodepointSupport sps = getSurrogatePairsSupport();
			Check.range(0, maxWidth, len);
			char[] arr = safe();
			int innerlen = lengthActual();
			int spc = sps.extendablePairsCount(arr, innerlen, 0, maxWidth);
			return assign(arr, maxWidth, spc, sps, getFlags());
		} else if (len == 0 || Lang.emptyOrNull.isAny(marker)) {
			return this;
		}

		final int mlen = marker.length();
		final int mwidth = mlen + 1;
		final int mwidthoff = mlen + mlen + 1;

		if (maxWidth < mwidth) {
			throw new IllegalArgumentException(String.format("min abbreviation width is %d", mwidth));
		}
		if (len <= maxWidth) {
			return this;
		}
		if (offset > len) {
			offset = len;
		}

		if (len - offset < maxWidth - mlen) {
			offset = len - (maxWidth - mlen);
		}
		if (offset <= mlen + 1) {
			int writAt = maxWidth - mlen;
			return replaceRange(marker, maxWidth - mlen);
		}
		if (maxWidth < mwidthoff) {
			throw new IllegalArgumentException(String.format("min abbreviation width with offset is %d", mwidthoff));
		}

		if ((offset + maxWidth) - mlen < len) {
			Chars sub = sub(offset);
			sub = sub.abbreviate(maxWidth - mlen, marker);
			sub = sub.insert(0, marker);
			char[] subarr = sub.toCharArray();
			return assign(subarr, subarr.length, sub.spc(), sub.getSurrogatePairsSupport(), sub.getFlags());
		}
		return replaceRange(marker, 0, len - (maxWidth - mlen));
	}

	public static void main(String[] args) throws IOException {
		String str = "abcdefghijklmno";
		String marker = ".";
		Chars c = Chars.of(str).abbreviate(10, marker, 6);
		System.out.println(c);
		str = StringUtils.abbreviate(str, marker, 6, 10);
		System.out.println(str);
	}

	/**
	 * Abbreviates to the length passed, replacing the middle characters with the
	 * supplied replacement CharSequence.
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".abbreviateMiddle(null, 0)         = ""
	 * "abc".abbreviateMiddle(null, 0)      = "abc"
	 * "abc".abbreviateMiddle(".", 0)       = "abc"
	 * "abc".abbreviateMiddle(".", 3)       = "abc"
	 * "abcdef".abbreviateMiddle(".", 4)    = "ab.f"
	 * </pre>
	 * 
	 */
	public Chars abbreviateMiddle(CharSequence middle, int length) {
		int len = length();
		if (len == 0 || Lang.emptyOrNull.isAny(middle)) {
			return this;
		}

		if (length >= len || length < middle.length() + 2) {
			return this;
		}

		final int targetSting = length - middle.length();
		final int startOffset = targetSting / 2 + targetSting % 2;
		final int endOffset = len - targetSting / 2;
		Chars sub = sub(endOffset);
		return replaceRange(middle, startOffset).append(sub);
	}

	// ===============
	// ===============
	// ===============

	public Chars space() {
		return space(1);
	}

	public Chars space(int repeat) {
		return space(repeat, length());
	}

	public Chars space(int repeat, int insertAt) {
		return repeat(' ', repeat, insertAt);
	}

	public Chars tab() {
		return tab(1);
	}

	public Chars tab(int repeat) {
		return tab(repeat, length());
	}

	public Chars tab(int repeat, int insertAt) {
		return repeat('\t', repeat, insertAt);
	}

	public Chars ln() {
		return ln(1);
	}

	public Chars ln(int repeat) {
		return ln(repeat, length());
	}

	public Chars ln(int repeat, int insertAt) {
		return repeat('\n', repeat, insertAt);
	}

	// ===============
	// =============== replace range
	// ===============

	/**
	 * @see #replaceRange(char[], int, int, int)
	 */
	public Chars replaceRange(CharSequence replacement) {
		return replaceRange(replacement, 0);
	}

	/**
	 * @see #replaceRange(char[], int, int, int)
	 */
	public Chars replaceRange(CharSequence replacement, int from) {
		return replaceRange(replacement, from, length());
	}

	/**
	 * @see #replaceRange(char[], int, int, int)
	 */
	public Chars replaceRange(CharSequence replacement, int from, int to) {
		char[] tarr = null;
		int tlen = 0;
		if (replacement instanceof Chars) {
			Chars c = (Chars) replacement;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (replacement != null) {
			tarr = replacement.toString().toCharArray();
			tlen = replacement.length();
		}
		return replaceRange(tarr, tlen, from, to);
	}

	/**
	 * @see #replaceRange(char[], int, int, int)
	 */
	public Chars replaceRange(char[] replacement, int replacementLength) {
		return replaceRange(replacement, replacementLength, 0);
	}

	/**
	 * @see #replaceRange(char[], int, int, int)
	 */
	public Chars replaceRange(char[] replacement, int replacementLength, int from) {
		return replaceRange(replacement, replacementLength, from, length());
	}

	/**
	 * replace range of of this sequence based on given range
	 */
	public Chars replaceRange(char[] replacement, int replacementLength, int from, int to) {
		int len = length();
		if (len == 0) {
			return append(replacement, replacementLength);
		}
		if (Lang.emptyOrNull.isAny(replacement) || replacementLength <= 0) {
			return this;
		}
		int innerlen = lengthActual();
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		if (from == 0 && to == len) {
			arr = Lang.capacity.ensure(arr, innerlen, replacementLength);
			innerlen = replacementLength;
			Lang.copy.to.that(replacement, replacement.length, arr, arr.length, 0, 0 + replacementLength, 0);
			spc = sps.extendablePairsCount(arr, innerlen);
			return assign(arr, innerlen, spc, sps, getFlags());
		}
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		spc -= sps.extendablePairsCount(arr, innerlen, from, to);
		int rspc = sps.extendablePairsCount(replacement, replacementLength, 0, replacementLength);
		spc += rspc;
		// -----------------
		int rlen = replacementLength;
		int newLength = innerlen + rlen - (to - from);
		arr = Lang.capacity.ensure(arr, innerlen, newLength);
		// no need to copy if all right side will be replaced: e.g: codes[.abdullah]
		if (to < innerlen) {
			Lang.copy.to.that(arr, innerlen, arr, innerlen, to, innerlen - to, from + rlen);
		}
		Lang.copy.to.that(replacement, replacement.length, arr, arr.length, 0, 0 + replacementLength, from);
		return assign(arr, newLength, spc, sps, getFlags());
	}

	// ===============
	// =============== replace all
	// ===============

	/**
	 * #see {@link #replaceAll(int, int, int, int, boolean)}
	 */
	public Chars replaceAll(int targetCodePoint, int replacementCodePoint) {
		return replaceAll(targetCodePoint, replacementCodePoint, 0);
	}

	/**
	 * #see {@link #replaceAll(int, int, int, int, boolean)}
	 */
	public Chars replaceAll(int targetCodePoint, int replacementCodePoint, int from) {
		return replaceAll(targetCodePoint, replacementCodePoint, from, length());
	}

	/**
	 * #see {@link #replaceAll(int, int, int, int, boolean)}
	 */
	public Chars replaceAll(int targetCodePoint, int replacementCodePoint, int from, int to) {
		return replaceAll(targetCodePoint, replacementCodePoint, from, to, iagc());
	}

	/**
	 * replace all occurrences of target based on given range
	 */
	public Chars replaceAll(int targetCodePoint, int replacementCodePoint, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from == len) {
			return this;
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		Check.bmp(targetCodePoint, sps);
		Check.codePoint(replacementCodePoint, sps);
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = safe();
		int innerlen = lengthActual();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		int[] indexes = Lang.codepoint.indexes.of(arr, innerlen, targetCodePoint, from, to,
				reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE), fromDisp, CharsMatcher.MUST_EQUALS, sps);
		if (Lang.emptyOrNull.isAny(indexes)) {
			return this;
		}
		return setCodePointsAt(indexes, replacementCodePoint);
	}

	public Chars replaceAll(CharSequence regex, CharSequence replacement) {
		return replaceAll(regex, replacement, null);
	}

	/**
	 * @see {@link String#replaceAll(String, String)}
	 */
	public Chars replaceAll(CharSequence regex, CharSequence replacement, Pattern pattern) {
		if (isEmpty())
			return this;
		CodepointSupport sps = getSurrogatePairsSupport();
		int innerlen = lengthActual();
		String reg = regex.toString();
		String repl = replacement.toString();
		String res = Pattern.compile(reg).matcher(this).replaceAll(repl);
		char[] resarr = res.toString().toCharArray();
		return assign(resarr, innerlen + (res.length() - innerlen), spc(), sps, getFlags());
	}

	// ===============
	// =============== replace first
	// ===============

	/**
	 * @see #replaceFirst(int, int, int, int, boolean)
	 */
	public Chars replaceFirst(int targetCodePoint, int replacementCodePoint) {
		return replaceFirst(targetCodePoint, replacementCodePoint, 0);
	}

	/**
	 * @see #replaceFirst(int, int, int, int, boolean)
	 */
	public Chars replaceFirst(int targetCodePoint, int replacementCodePoint, int from) {
		return replaceFirst(targetCodePoint, replacementCodePoint, from, length());
	}

	/**
	 * @see #replaceFirst(int, int, int, int, boolean)
	 */
	public Chars replaceFirst(int targetCodePoint, int replacementCodePoint, int from, int to) {
		return replaceFirst(targetCodePoint, replacementCodePoint, from, to, iagc());
	}

	/**
	 * replace first occurrence of target based on given range
	 * 
	 * @see #replaceFirst(int, int, int, int, boolean)
	 */
	public Chars replaceFirst(int targetCodePoint, int replacementCodePoint, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0) {
			return this;
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		Check.bmp(targetCodePoint, sps);
		Check.codePoint(replacementCodePoint, sps);
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = safe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		int index = CharsLoop.INDEX_OF.codePoint(arr, innerlen, from, to, targetCodePoint, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return this;
		}
		return setCodePointAt(index, replacementCodePoint);
	}

	public Chars replaceFirst(CharSequence regex, CharSequence replacement) {
		return replaceFirst(regex, replacement, null);
	}

	/**
	 * :
	 * 
	 * @see String#replaceFirst(String, String)
	 */
	public Chars replaceFirst(CharSequence regex, CharSequence replacement, Pattern pattern) {
		CodepointSupport sps = getSurrogatePairsSupport();
		int innerlen = lengthActual();
		pattern = pattern == null ? Pattern.compile(regex.toString()) : pattern;
		String res = pattern.matcher(this).replaceFirst(replacement.toString());
		char[] resarr = res.toString().toCharArray();
		return assign(resarr, innerlen + (res.length() - innerlen), spc(), sps, getFlags());
	}

	// ===============
	// =============== split
	// ===============

	/**
	 * @see String#split(String)
	 */
	public String[] split(CharSequence regex) {
		return split(regex.toString(), 0);
	}

	/**
	 * @see String#split(String, int)
	 */
	public String[] split(CharSequence regex, int limit) {
		return toString().split(regex.toString(), limit);
	}

	/**
	 * @see String#split(String)
	 */
	public Chars[] splitAsChars(CharSequence regex) {
		return splitAsChars(regex, 0);
	}

	/**
	 * @see String#split(String, int)
	 */
	public Chars[] splitAsChars(CharSequence regex, int limit) {
		String[] ss = split(regex, limit);
		Chars[] cc = new Chars[ss.length];
		for (int i = 0; i < ss.length; i++) {
			cc[i] = newInstance(ss[i]);
		}
		return cc;
	}

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// =============== query max length by code-points
	// ===============

	/**
	 * @see #maxLength(int, int, int, boolean)
	 */
	public int maxLength(int separator) {
		return maxLength(separator, 0);
	}

	/**
	 * @see #maxLength(int, int, int, boolean)
	 */
	public int maxLength(int separator, int from) {
		return maxLength(separator, from, length());
	}

	/**
	 * @see #maxLength(int, int, int, boolean)
	 */
	public int maxLength(int separator, int from, int to) {
		return maxLength(separator, from, to, iagc());
	}

	/**
	 * e.g: codes.abdullah.math, separator = '.', returns: 8 (length of abdullah)
	 * 
	 * @return max length, or 0 if no max found
	 */
	public int maxLength(int separator, int from, int to, boolean ignoreCase) {
		return findMaxMinLengthByCodePoint(separator, from, to, ignoreCase, true);
	}

	// ===============
	// =============== query min length by code-points
	// ===============

	/**
	 * @see #minLength(int, int, int, boolean)
	 */
	public int minLength(int separator) {
		return minLength(separator, 0);
	}

	/**
	 * @see #minLength(int, int, int, boolean)
	 */
	public int minLength(int separator, int from) {
		return minLength(separator, from, length());
	}

	/**
	 * @see #minLength(int, int, int, boolean)
	 */
	public int minLength(int separator, int from, int to) {
		return minLength(separator, from, to, iagc());
	}

	/**
	 * e.g: codes.abdullah.math, separator = '.', returns: 4 (length of math)
	 * 
	 * @return min length, or 0 if no min found
	 */
	public int minLength(int separator, int from, int to, boolean ignoreCase) {
		return findMaxMinLengthByCodePoint(separator, from, to, ignoreCase, false);
	}

	// ===============
	// =============== query max length by sequence
	// ===============

	/**
	 * @see #maxLength(char[], int, int, int, boolean)
	 */
	public int maxLength(CharSequence separator) {
		return maxLength(separator, 0);
	}

	/**
	 * @see #maxLength(char[], int, int, int, boolean)
	 */
	public int maxLength(CharSequence separator, int from) {
		return maxLength(separator, from, length());
	}

	/**
	 * @see #maxLength(char[], int, int, int, boolean)
	 */
	public int maxLength(CharSequence separator, int from, int to) {
		return maxLength(separator, from, to, iagc());
	}

	/**
	 * @see #maxLength(char[], int, int, int, boolean)
	 */
	public int maxLength(CharSequence separator, int from, int to, boolean ignoreCase) {
		char[] arr = null;
		int arrlen = 0;
		if (separator instanceof Chars) {
			Chars c = (Chars) separator;
			arr = c.unsafe();
			arrlen = c.lengthActual();
		} else if (separator != null) {
			arr = separator.toString().toCharArray();
			arrlen = separator.length();
		}
		return maxLength(arr, arrlen, from, to, ignoreCase);
	}

	// ===============
	// =============== query min length by sequence
	// ===============

	/**
	 * @see #minLength(CharSequence, int, int, boolean)
	 */
	public int minLength(CharSequence separator) {
		return minLength(separator, 0);
	}

	/**
	 * @see #minLength(CharSequence, int, int, boolean)
	 */
	public int minLength(CharSequence separator, int from) {
		return minLength(separator, from, length());
	}

	/**
	 * @see #minLength(CharSequence, int, int, boolean)
	 */
	public int minLength(CharSequence separator, int from, int to) {
		return minLength(separator, from, to, iagc());
	}

	/**
	 * @see #minLength(char[], int, int, int, boolean)
	 */
	public int minLength(CharSequence separator, int from, int to, boolean ignoreCase) {
		char[] arr = null;
		int arrlen = 0;
		if (separator instanceof Chars) {
			Chars c = (Chars) separator;
			arr = c.unsafe();
			arrlen = c.lengthActual();
		} else if (separator != null) {
			arr = separator.toString().toCharArray();
			arrlen = separator.length();
		}
		return minLength(arr, arrlen, from, to, ignoreCase);
	}

	// ===============
	// =============== query max length by array
	// ===============

	/**
	 * @see #maxLength(char[], int, int, int, boolean)
	 */
	public int maxLength(char[] separator, int separatorLength) {
		return maxLength(separator, separatorLength, 0);
	}

	/**
	 * @see #maxLength(char[] int, int, int, boolean)
	 */
	public int maxLength(char[] separator, int separatorLength, int from) {
		return maxLength(separator, separatorLength, from, length());
	}

	/**
	 * @see #maxLength(char[] int, int, int, boolean)
	 */
	public int maxLength(char[] separator, int separatorLength, int from, int to) {
		return maxLength(separator, separatorLength, from, to, iagc());
	}

	/**
	 * e.g: codes.abdullah.math, separator = '.', returns: 8 (length of abdullah)
	 * 
	 * @return max length, or 0 if no max found
	 */
	public int maxLength(char[] separator, int separatorLength, int from, int to, boolean ignoreCase) {
		return findMaxMinLengthByCharArray(separator, separatorLength, from, to, ignoreCase, true);
	}

	// ===============
	// =============== query min length by array
	// ===============

	/**
	 * @see #minLength(char[], int, int, int, boolean)
	 */
	public int minLength(char[] separator, int separatorLength) {
		return minLength(separator, separatorLength, 0);
	}

	/**
	 * @see #minLength(char[] int, int, int, boolean)
	 */
	public int minLength(char[] separator, int separatorLength, int from) {
		return minLength(separator, separatorLength, from, length());
	}

	/**
	 * @see #minLength(char[] int, int, int, boolean)
	 */
	public int minLength(char[] separator, int separatorLength, int from, int to) {
		return minLength(separator, separatorLength, from, to, iagc());
	}

	/**
	 * e.g: codes.abdullah.math, separator = '.', returns: 4 (length of math)<br>
	 * if two seps after each like: <b>java//math</b> or <b>java/math//</b>, the min
	 * will be 0, first and last sep based on given range are not considered exists,
	 * e.g: <b>/java/math/</b>, will be: java/math
	 * 
	 * @return min length, or 0 if no min found
	 */
	public int minLength(char[] separator, int separatorLength, int from, int to, boolean ignoreCase) {
		return findMaxMinLengthByCharArray(separator, separatorLength, from, to, ignoreCase, false);
	}

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// ===============
	// ===============

	// ===============
	// =============== clear and delete
	// ===============

	/**
	 * clear the entire sequence
	 */
	public Chars clear() {
		return assign(safe(), 0, 0, getSurrogatePairsSupport(), getFlags());
	}

	/**
	 * delete code-point at given index
	 */
	public Chars deleteAt(int index) {
		return deleteRange(index, index + 1);
	}

	/**
	 * delete first code-point
	 */
	public Chars deleteFirst() {
		int len = length();
		if (len == 0) {
			return this;
		}
		return deleteRange(0, 1);
	}

	/**
	 * delete last code-point
	 */
	public Chars deleteLast() {
		int len = length();
		if (len == 0) {
			return this;
		}
		return deleteRange(len - 1, len);
	}

	/**
	 * delete based on given range
	 */
	public Chars deleteRange(int from) {
		return from == 0 ? clear() : deleteRange(from, length());
	}

	/**
	 * delete based on given range
	 */
	public Chars deleteRange(int from, int to) {
		final int len = length();
		if (len == 0)
			return this;
		else if (from == 0 && to >= len)
			return clear();

		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointSupport sps = getSurrogatePairsSupport();
		final int spc = spc();
		char[] arr = safe();
		final int innerlen = lengthActual();
		// ----------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ---------------------
		// since the deletion is (from-to), means the count of spc between from-to
		// equals
		// the spc_dellen
		final int spc_dellen = disp;
		final int spc_newlen = spc - spc_dellen;

		int dellen = to - from;
		final int newlen = innerlen - dellen;
		if (newlen == 0)
			return assign(arr, 0, 0, sps, getFlags());
		// in-case of deleting from middle to len, no need to shrink the tail

		if (to == innerlen) {
			return assign(arr, newlen, spc_newlen, sps, getFlags());
		}

		Lang.shrink.at(arr, innerlen, from, dellen);
		return assign(arr, newlen, spc_newlen, sps, getFlags());
	}

	/**
	 * @see #delete(int, int, int, boolean)
	 */
	public Chars delete(int target) {
		return delete(target, 0);
	}

	/**
	 * @see #delete(int, int, int, boolean)
	 */
	public Chars delete(int target, int from) {
		return delete(target, from, length());
	}

	/**
	 * @see #delete(int, int, int, boolean)
	 */
	public Chars delete(int target, int from, int to) {
		return delete(target, from, to, iagc());
	}

	/**
	 * delete all occurrences of given code-point based on given range
	 */
	public Chars delete(int target, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		final int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = sps.extendablePairsCount(arr, innerlen, from, to);
		to += between;
		// ---------------------
		int newlen = Lang.codepoint.remove.when(arr, innerlen, target, 0, from, to, fromDisp, flags,
				CharsMatcher.MUST_EQUALS, sps);
		int diff = innerlen - newlen;
		spc -= sps.isSupported() && !sps.isBmp(target) ? (diff / 2) : 0;
		return assign(arr, newlen, sps.isSupported() ? spc : 0, sps, getFlags());
	}

	// TODO support delete sequence and array
	public Chars delete(CharSequence regex, int from, int to) {
		throw new ImplementationRequiredException();
	}

	/**
	 * delete all occurrences of white-spaces according to
	 * {@link Character#isWhitespace(char)}
	 */
	public Chars deleteWhitespaces() {
		return deleteWhitespaces(0);
	}

	/**
	 * delete all occurrences of white-spaces according to
	 * {@link Character#isWhitespace(char)} and based on given range
	 */
	public Chars deleteWhitespaces(int from) {
		return deleteWhitespaces(from, length());
	}

	/**
	 * delete all occurrences of white-spaces according to
	 * {@link Character#isWhitespace(char)} and based on given range
	 */
	public Chars deleteWhitespaces(int from, int to) {
		final int len = length();
		if (len == 0) {
			return this;
		}

		int innerlen = lengthActual();
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ------------------
		int cp = 0, del_from = 0, size;
		for (int del_to = to - 1; del_to >= from; del_to--) {
			cp = arr[del_to];
			if (Character.isWhitespace(cp)) {
				del_from = del_to;
				while (del_from - 1 >= 0 && Character.isWhitespace(arr[del_from - 1])) {
					del_from--;
				}
				size = (del_to + 1) - del_from;
				arr = Lang.shrink.at(arr, innerlen, del_from, size);
				innerlen -= size;
				del_to -= size;
			}
		}
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	/**
	 * delete all occurrences of line-feeds<br>
	 * supported: \n, \r and \r\n
	 */
	public Chars deleteLinefeeds() {
		return deleteLinefeeds(0);
	}

	/**
	 * delete all occurrences of line-feeds and based on given range <br>
	 * supported: \n, \r and \r\n
	 */
	public Chars deleteLinefeeds(int from) {
		return deleteLinefeeds(from, length());
	}

	/**
	 * delete all occurrences of line-feeds and based on given range <br>
	 * supported: \n, \r and \r\n
	 */
	public Chars deleteLinefeeds(int from, int to) {
		final int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = sps.extendablePairsCount(arr, innerlen, from, to);
		to += between;
		// ---------------------
		// ------------------
		int cp = 0, del_from = 0, size;
		for (int del_to = to - 1; del_to >= from; del_to--) {
			cp = arr[del_to];
			if (Lang.codepoint.isLinefeed(cp)) {
				del_from = del_to;
				while (del_from - 1 >= 0 && Lang.codepoint.isLinefeed(arr[del_from - 1])) {
					del_from--;
				}
				size = (del_to + 1) - del_from;
				arr = Lang.shrink.at(arr, innerlen, del_from, size);
				innerlen -= size;
				del_to -= size;
			}
		}
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	// ===============
	// =============== delete duplicates
	// ===============

	/**
	 * @see #deleteDuplicates(int, int, int)
	 */
	public Chars deleteDuplicates() {
		// -1 means search and delete any duplicates
		return deleteDuplicates(Lang.constant.INDEX_NOT_FOUND);
	}

	/**
	 * @see #deleteDuplicates(int, int, int)
	 */
	public Chars deleteDuplicates(int target) {
		return deleteDuplicates(target, 0);
	}

	/**
	 * @see #deleteDuplicates(int, int, int)
	 */
	public Chars deleteDuplicates(int target, int from) {
		return deleteDuplicates(target, from, length());
	}

	/**
	 * delete all occurrences of duplicated given code-point based on given range
	 * 
	 * <br>
	 * <b>default</b> target: -1, means search and find any duplicates
	 */
	public Chars deleteDuplicates(int target, int from, int to) {
		final int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		int flags = getFlags();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = sps.extendablePairsCount(arr, innerlen, from, to);
		to += between;
		// ---------------------
		if (target == -1) {
			// ---------------------
			// to avoid recount sp, will use this boolean holder which basically will be set
			// to true only if target is sp and already exists
			// ---------------------
			boolean delspc = false;
			int newlen = 0, deleted;
			for (; from < to; from++) {
				target = sps.getCodepoint(arr, to, from);
				delspc = spc > 0 && target >= Character.MIN_SUPPLEMENTARY_CODE_POINT;
				newlen = Lang.codepoint.remove.when(arr, innerlen, target, 1, from, to, fromDisp, flags,
						CharsMatcher.MUST_EQUALS, sps);
				deleted = innerlen - newlen;
				// ---------------------
				// now, since each 1 sp represented by 2 chars, will do (innerlen - newlen) to
				// find how many deleted, e.g: 6, will divide by 2, so 3 sp deleted
				// ---------------------
				spc -= (delspc && deleted > 0 ? spc - (deleted / 2) : 0);
				innerlen = newlen;
				to -= deleted;
			}
			return assign(arr, innerlen, spc, sps, getFlags());
		}
		// ------------------
		int newlen = Lang.codepoint.remove.when(arr, innerlen, target, 1, from, to, fromDisp, flags,
				CharsMatcher.MUST_EQUALS, sps);
		int diff = innerlen - newlen;
		spc -= sps.isSupported() && !sps.isBmp(target) ? (diff / 2) : 0;
		return assign(arr, newlen, spc, sps, flags);
	}

	public Chars deleteDuplicates(CharSequence target) {
		return deleteDuplicates(target, 0);
	}

	public Chars deleteDuplicates(CharSequence target, int from) {
		return deleteDuplicates(target, from, length());
	}

	public Chars deleteDuplicates(CharSequence target, int from, int to) {
		return deleteDuplicates(target, from, to, iagc());
	}

	public Chars deleteDuplicates(CharSequence target, int from, int to, boolean ignoreCase) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return deleteDuplicates(tarr, tlen, from, to, ignoreCase);
	}

	public Chars deleteDuplicates(char[] target, int targetLength) {
		return deleteDuplicates(target, targetLength, 0);
	}

	public Chars deleteDuplicates(char[] target, int targetLength, int from) {
		return deleteDuplicates(target, targetLength, from, length());
	}

	public Chars deleteDuplicates(char[] target, int targetLength, int from, int to) {
		return deleteDuplicates(target, targetLength, from, to, iagc());
	}

	public Chars deleteDuplicates(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0 || target == null && targetLength <= 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		int newlen = Lang.chararray.remove.when(arr, innerlen, target, targetLength, 1, from, to, fromDisp, flags,
				CharsMatcher.MUST_EQUALS, sps);
		// deleted: how many target been removed
		int deleted = (innerlen - newlen) / targetLength;
		if (deleted > 0) {
			spc -= sps.isSupported() ? (sps.fixedPairsCount(target, targetLength, 0, targetLength) * deleted) : 0;
		}
		return assign(arr, newlen, spc, sps, flags);
	}

	// ===============
	// =============== duplicate
	// ===============
	/**
	 * @see #duplicate(int, int, int)
	 */
	public Chars duplicate() {
		return duplicate(0);
	}

	/**
	 * @see #duplicate(int, int, int)
	 */
	public Chars duplicate(int from) {
		return duplicate(from, length());
	}

	/**
	 * @see #duplicate(int, int, int)
	 */
	public Chars duplicate(int from, int to) {
		return duplicate(from, to, length());
	}

	/**
	 * @see #duplicate(int, int, int)
	 */
	public Chars duplicate(int from, int to, int insertAt) {
		int len = length();
		if (len == 0) {
			return this;
		}
		Check.insertIndex(insertAt, len);
		int innerlen = lengthActual();
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		// -----------------
		insertAt = sps.reindex(arr, innerlen, insertAt);
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		spc += sps.isSupported() ? disp : 0;
		// -----------------
		int objective_len = to - from;
		// e.g: 2, 4, index 5: codes -> codes[de], this means no displacement required,
		// codes still in it's original position
		// so just copy to end
		int displace_len = innerlen - insertAt;
		int newinnerlen = innerlen + objective_len;
		// codes -> codescodes
		if ((from == 0 && to == innerlen && insertAt == innerlen) || (displace_len == 0)) {
			arr = Lang.capacity.ensure(arr, innerlen, newinnerlen);
			Lang.copy.to.that(arr, arr.length, arr, arr.length, from, from + objective_len, insertAt);
			return assign(arr, newinnerlen, sps.isSupported() ? spc : 0, sps, getFlags());
		}

		// newinnerlen + objective_len?? we need extra slots for temp copy
		// e.g: 2, 4, index 0 -> [codes] -> [codes--]__
		arr = Lang.capacity.ensure(arr, innerlen, newinnerlen + objective_len);
		// [codes--]__ -> [codes--]de
		Lang.copy.to.that(arr, arr.length, arr, arr.length, from, from + objective_len, newinnerlen);
		// displace: [codes--]de -> [cocodes]de
		Lang.copy.to.that(arr, innerlen, arr, innerlen, insertAt, displace_len, insertAt + objective_len);
		Lang.copy.to.that(arr, arr.length, arr, arr.length, newinnerlen, newinnerlen + objective_len, insertAt);
		return assign(arr, newinnerlen, spc, sps, getFlags());
	}

	// ===============
	// =============== repeat code-point
	// ===============

	/**
	 * @see #repeat(int, int, int)
	 */
	public Chars repeat(int target, int repeat) {
		return repeat(target, repeat, length());
	}

	/**
	 * repeat given code-point and insert it
	 */
	public Chars repeat(int target, int repeat, int insertAt) {
		if (repeat <= 0) {
			return this;
		} else if (repeat == 1) {
			return insertCodePoint(insertAt, target);
		}
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		Check.insertIndex(insertAt, length());
		insertAt = sps.reindex(arr, innerlen, insertAt);
		// ------------------
		if (sps.isBmp(target)) {
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + repeat);
			Lang.expand.at(arr, innerlen, insertAt, repeat);
			char ch = (char) target;
			for (int i = 0; i < repeat; i++) {
				arr[insertAt++] = ch;
			}
			return assign(arr, innerlen + repeat, spc, sps, getFlags());
		} else if (sps.isPair(target)) {
			int addition = (repeat * 2);
			arr = Lang.capacity.ensure(arr, innerlen, innerlen + addition);
			Lang.expand.at(arr, innerlen, insertAt, addition);
			char high = sps.toHigh(target);
			char low = sps.toLow(target);
			for (int i = 0; i < repeat; i++) {
				arr[insertAt++] = high;
				arr[insertAt++] = low;
				spc += sps.isSupported() ? 1 : 0;
			}
			return assign(arr, innerlen + addition, spc, sps, getFlags());
		}
		Check.codePoint(target, sps);
		return null;// must never reach here
	}

	// ===============
	// =============== repeat sequence
	// ===============

	/**
	 * @see #repeat(char[], int, int, int)
	 */
	public Chars repeat(CharSequence cs, int repeat) {
		return repeat(cs, repeat, length());
	}

	/**
	 * @see #repeat(char[], int, int, int)
	 */
	public Chars repeat(CharSequence target, int repeat, int insertAt) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return repeat(tarr, tlen, repeat, insertAt);
	}

	// ===============
	// =============== repeat char-array
	// ===============

	/**
	 * @see #repeat(char[], int, int, int)
	 */
	public Chars repeat(char[] target, int targetLength, int repeat) {
		return repeat(target, targetLength, repeat, length());
	}

	/**
	 * repeat given char-array and insert it
	 */
	public Chars repeat(char[] target, int targetLength, int repeat, int insertAt) {
		if (repeat <= 0 || Lang.emptyOrNull.isAny(target) || targetLength == 0)
			return this;
		Check.insertIndex(insertAt, length());
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		final int innerlen = lengthActual();
		insertAt = sps.reindex(arr, innerlen, insertAt);
		int injspc = sps.extendablePairsCount(target, targetLength, 0, targetLength) * repeat;
		final int addition = (targetLength * repeat);
		final int newLen = innerlen + addition;
		arr = Lang.capacity.ensure(arr, innerlen, newLen);
		Lang.expand.at(arr, innerlen, insertAt, addition);
		for (int i = 0; i < repeat; i++) {
			Lang.copy.to.that(target, target.length, arr, arr.length, 0, 0 + targetLength, insertAt);
			insertAt += targetLength;
		}
		return assign(arr, newLen, spc + injspc, sps, getFlags());
	}

	// ===============
	// =============== repeat-after-each code-point
	// ===============

	/**
	 * @see #repeatAfterEach(int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(int dividerCodePoint, int division) {
		return repeatAfterEach(dividerCodePoint, division, 1);
	}

	/**
	 * @see #repeatAfterEach(int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(int dividerCodePoint, int division, int repeat) {
		return repeatAfterEach(dividerCodePoint, division, repeat, false);
	}

	/**
	 * @see #repeatAfterEach(int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(int dividerCodePoint, int division, int repeat, boolean reverse) {
		return repeatAfterEach(dividerCodePoint, division, repeat, reverse, 0);
	}

	/**
	 * @see #repeatAfterEach(int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(int dividerCodePoint, int division, int repeat, boolean reverse, int from) {
		return repeatAfterEach(dividerCodePoint, division, repeat, reverse, from, length());
	}

	/**
	 * repeat given code-point based on given range, division, repeat amount and
	 * direction<br>
	 * <br>
	 * e.g: sequence = 1000001101011111, dividerCodePoint = _, division = 8, ,
	 * repeat = 2, and reverse = true<br>
	 * output: 10000011__01011111
	 * 
	 * <br>
	 * <b>default</b> repeat = 1 <br>
	 * <b>default</b> reverse = false
	 */
	public Chars repeatAfterEach(int dividerCodePoint, int division, int repeat, boolean reverse, int from, int to) {
		int len = length();
		// ---------------------
		// in case no division will be added, e.g: 111100001111
		// to(8) - from(4) <= division(4)
		// ---------------------
		if (len == 0 || repeat < 1 || to - from <= division) {
			return this;
		} else if (division < 1) {
			throw new IllegalArgumentException(String.format("division(%d) < 1, found: ", division));
		}
		to = to > len ? len : to;
		Check.codePoint(dividerCodePoint);
		Check.range(from, to, len);
		char[] arr = safe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		final int rangelen = to - from;
		final boolean bmp = sps.isBmp(dividerCodePoint);
		int flags = getFlags();
		// ================
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ==============
		// ----------------------
		// last_part, e.g: codes, division = 4, last part is 1 -> code_s
		// ----------------------
		final int last_part = rangelen % division;
		// ---------------------
		// leftover: for 2 group of sequences like 0000_1111, we will add 1 division
		// between them
		// e.g: division = 4, innerlen = 8, innerlen / division - 1 = 1
		// but if we have 1 more char, or any amount <= division(4), will add 1 more
		// division as
		// well like: 0000_1111_0
		// ---------------------
		final int leftover = last_part > 0 ? 1 : 0;
		final int divs_count = (rangelen / division) - 1;
		final int each_divs_len = repeat * sps.lengthOf(dividerCodePoint);
		final int addition = (divs_count + leftover) * each_divs_len;
		spc += bmp ? 0 : addition / 2;
		arr = Lang.capacity.ensure(arr, innerlen, innerlen + addition);
		// ---------------------
		arr = Lang.codepoint.repeat.after(arr, innerlen, dividerCodePoint, division, repeat, from, to, last_part,
				reverse, flags, sps);
		return assign(arr, innerlen + addition, spc, sps, flags);
	}

	// ===============
	// =============== repeat-after-each sequence
	// ===============
	/**
	 * @see #repeatAfterEach(char[], int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(CharSequence injection, int division) {
		return repeatAfterEach(injection, division, 1);
	}

	/**
	 * @see #repeatAfterEach(char[], int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(CharSequence injection, int division, int repeat) {
		return repeatAfterEach(injection, division, repeat, false);
	}

	/**
	 * @see #repeatAfterEach(char[], int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(CharSequence injection, int division, int repeat, boolean reverse) {
		return repeatAfterEach(injection, division, repeat, false, 0);
	}

	/**
	 * @see #repeatAfterEach(char[], int, int, int, boolean, int, int)
	 */
	public Chars repeatAfterEach(CharSequence injection, int division, int repeat, boolean reverse, int from) {
		return repeatAfterEach(injection, division, repeat, false, from, length());
	}

	/**
	 * @see #repeatAfterEach(char[], int, int, int, int, int, boolean)
	 */
	public Chars repeatAfterEach(CharSequence injection, int division, int repeat, boolean reverse, int from, int to) {
		char[] tarr = null;
		int tlen = 0;
		if (injection instanceof Chars) {
			Chars c = (Chars) injection;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (injection != null) {
			tarr = injection.toString().toCharArray();
			tlen = injection.length();
		}
		return repeatAfterEach(tarr, tlen, division, repeat, reverse, from, to);
	}

	// ===============
	// =============== repeat-after-each char-array
	// ===============

	/**
	 * @see #repeatAfterEach(char[], int, int, int, int, int, boolean)
	 */
	public Chars repeatAfterEach(char[] injection, int injectionLength, int division) {
		return repeatAfterEach(injection, injectionLength, division, 1);
	}

	/**
	 * @see #repeatAfterEach(char[], int, int, int, int, int, boolean)
	 */
	public Chars repeatAfterEach(char[] injection, int injectionLength, int division, int repeat) {
		return repeatAfterEach(injection, injectionLength, division, repeat, false);
	}

	/**
	 * @see #repeatAfterEach(char[], int, int, int, int, int, boolean)
	 */
	public Chars repeatAfterEach(char[] injection, int injectionLength, int division, int repeat, boolean reverse) {
		return repeatAfterEach(injection, injectionLength, division, repeat, reverse, 0);
	}

	/**
	 * @see #repeatAfterEach(char[], int, int, int, int, int, boolean)
	 */
	public Chars repeatAfterEach(char[] injection, int injectionLength, int division, int repeat, boolean reverse,
			int from) {
		return repeatAfterEach(injection, injectionLength, division, repeat, reverse, from, length());
	}

	/**
	 * repeat given char-array based on given range, division, repeat amount and
	 * direction<br>
	 * <br>
	 * e.g: equence = 1000001101011111, injection = _, division = 8, , repeat = 2,
	 * and reverse = true<br>
	 * output: 10000011__01011111
	 * 
	 * <br>
	 * <b>default</b> repeat = 1 <br>
	 * <b>default</b> reverse = false
	 */
	public Chars repeatAfterEach(char[] injection, int injectionLength, int division, int repeat, boolean reverse,
			int from, int to) {
		int len = length();
		// ---------------------
		// in case no division will be added, e.g: 111100001111
		// to(8) - from(4) <= division(4)
		// ---------------------
		if (len == 0 || repeat < 1 || to - from <= division || Lang.emptyOrNull.isAny(injection)
				|| injectionLength <= 0) {
			return this;
		} else if (division < 1) {
			throw new IllegalArgumentException(String.format("division(%d) < 1, found: ", division));
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = safe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		int spc = spc();
		final int rangelen = to - from;
		int flags = getFlags();
		// ==================
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ----------------------
		// last_part, e.g: codes, division = 4, last part is 1 -> code_s
		// ----------------------
		final int last_part = rangelen % division;
		// ---------------------
		// leftover: for 2 group of sequences like 0000_1111, we will add 1 division
		// between them
		// e.g: division = 4, innerlen = 8, innerlen / division - 1 = 1
		// but if we have 1 more char, or any amount <= division(4), will add 1 more
		// division as
		// well like: 0000_1111_0
		// ---------------------
		final int leftover = last_part > 0 ? 1 : 0;
		final int divs_count = (rangelen / division) - 1;
		final int each_divs_len = repeat * injectionLength;
		final int addition = (divs_count + leftover) * each_divs_len;
		int targetSpc = sps.fixedPairsCount(injection, injectionLength, 0, injectionLength);
		targetSpc = targetSpc * (divs_count + leftover);
		spc += targetSpc * repeat;
		arr = Lang.capacity.ensure(arr, innerlen, innerlen + addition);
		// ---------------------
		arr = Lang.chararray.repeat.after(arr, innerlen, injection, injectionLength, division, repeat, from, to,
				last_part, reverse, flags, sps);
		return assign(arr, innerlen + addition, spc, sps, getFlags());
	}

	// ===============
	// =============== reverse
	// ===============

	/**
	 * reverse the entire sequence
	 */
	public Chars reverse() {
		return reverse(0);
	}

	/**
	 * reverse sequence based on given range
	 */
	public Chars reverse(int from) {
		return reverse(from, length());
	}

	/**
	 * reverse sequence based on given range
	 */
	public Chars reverse(int from, int to) {
		int len = length();
		if (len == 0)
			return this;
		to = to > len ? len : to;
		Check.range(from, to, len);
		boolean hasSurrogates = false;
		int size = to - from;
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		for (int i = from; i < to; i += size) {
			int left = i;
			// to handle case when size is not multiple
			// of len
			int right = Math.min(i + size - 1, len - 1);
			int temp;
			// reverse the sub-array [left, right]
			while (left < right) {
				if (!hasSurrogates && (sps.isPair(arr[left]) || sps.isPair(arr[right])))
					hasSurrogates = true;
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = (char) temp;
				left += 1;
				right -= 1;
			}
		}

		if (hasSurrogates) {
			for (int i = from; i < to - 1; i++) {
				char c2 = arr[i];
				if (sps.isLow(c2)) {
					char c1 = arr[i + 1];
					if (sps.isHigh(c1)) {
						arr[i++] = c1;
						arr[i] = c2;
					}
				}
			}
		}

		return assign(arr, len, spc(), sps, getFlags());
	}

	// ===============
	// =============== sort
	// ===============
	/**
	 * sort the entire sequence
	 */
	public Chars sort() {
		return sort(0);
	}

	/**
	 * sort sequence based on given range
	 */
	public Chars sort(int from) {
		return sort(from, length());
	}

	/**
	 * sort sequence based on given range
	 */
	public Chars sort(int vfrom, int vto) {
		int len = length();
		if (len == 0)
			return this;
		vto = vto > len ? length() : vto;
		Check.range(vfrom, vto, len);
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, vfrom);
		int from = vfrom + disp;
		int to = vto + disp;
		disp = sps.extendablePairsCount(arr, innerlen, vfrom, vto);
		to += disp;
		// -----------------
		if (sps.isSupported()) {
			int[] cparr = sps.toCodepointArray(arr, innerlen);
			Arrays.sort(cparr, vfrom, vto);
			arr = sps.toCharArray(cparr, cparr.length, 0, cparr.length, arr, innerlen);
		} else {
			Arrays.sort(arr, from, to);
		}
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	/**
	 * parallel-sort the entire sequence
	 */
	public Chars parallelSort() {
		return parallelSort(0);
	}

	/**
	 * parallel-sort sequence based on given range
	 */
	public Chars parallelSort(int from) {
		return parallelSort(from, length());
	}

	/**
	 * parallel-sort sequence based on given range
	 */
	public Chars parallelSort(int from, int to) {
		int len = length();
		if (len == 0)
			return this;
		to = to > len ? length() : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// -----------------
		if (sps.isSupported()) {
			int[] cparr = sps.toCodepointArray(arr, innerlen);
			Arrays.parallelSort(cparr, from, to);
			arr = sps.toCharArray(cparr, cparr.length, 0, cparr.length, arr, innerlen);
		} else {
			Arrays.parallelSort(arr, from, to);
		}
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	// ===============
	// =============== shuffle
	// ===============

	/**
	 * @see #shuffle(int, int)
	 */
	public Chars shuffle() {
		return shuffle(0);
	}

	/**
	 * @see #shuffle(int, int)
	 */
	public Chars shuffle(int from) {
		return shuffle(from, length());
	}

	/**
	 * shuffle sequence based on given range
	 */
	public Chars shuffle(int from, int to) {
		int len = length();
		if (len <= 1)
			return this;
		to = to > len ? length() : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		// in both cases below, no need to displace due to surrogates
		// -----------------
		if (sps.isSupported()) {
			int[] cparr = sps.toCodepointArray(arr, innerlen);
			Lang.shuffle.in(cparr, cparr.length, from, to);
			arr = sps.toCharArray(cparr, cparr.length, 0, cparr.length, arr, innerlen);
		} else {
			Lang.shuffle.in(arr, innerlen, from, to);
		}
		return assign(arr, innerlen, spc(), sps, getFlags());

	}

	// ===============
	// =============== swap
	// ===============

	public Chars swap(int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			throw new IllegalArgumentException(String.format("leftIndex(%d) >= rightIndex(%d)", leftIndex, rightIndex));
		}
		int len = length();
		Check.index(leftIndex, len);
		Check.index(rightIndex, len);
		int innerlen = lengthActual();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, leftIndex);
		leftIndex += disp;
		rightIndex += disp;
		disp = sps.extendablePairsCount(arr, innerlen, leftIndex, rightIndex);
		rightIndex += disp;
		// -----------------
		arr = Lang.swap.with(arr, innerlen, leftIndex, rightIndex, sps);
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	// ===============
	// =============== binary search
	// ===============

	/**
	 * @see #binarySearch(char, int, int)
	 */
	public int binarySearch(char target) {
		return binarySearch(target, 0);
	}

	/**
	 * @see #binarySearch(char, int, int)
	 */
	public int binarySearch(char target, int from) {
		return binarySearch(target, from, length());
	}

	/**
	 * search for given target based on given range<br>
	 * the content must be sorted for a correct binary-search results
	 * 
	 * @see Arrays#binarySearch(char[], int, int, char)
	 */
	public int binarySearch(char target, int from, int to) {
		int len = length();
		if (len == 0)
			return Lang.constant.INDEX_NOT_FOUND;
		to = to > len ? length() : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ==================
		return Arrays.binarySearch(arr, from, to, target);
	}

	/**
	 * @see #binarySearchCodePoint(int, int, int)
	 */
	public int binarySearchCodePoint(int codepoint) {
		return binarySearchCodePoint(codepoint, 0);
	}

	/**
	 * @see #binarySearchCodePoint(int, int, int)
	 */
	public int binarySearchCodePoint(int codepoint, int from) {
		return binarySearchCodePoint(codepoint, from, length());
	}

	/**
	 * search for given target based on given range<br>
	 * the content must be sorted for a correct binary-search results
	 * 
	 * @see Arrays#binarySearch(int[], int, int, char)
	 */
	public int binarySearchCodePoint(int codepoint, int from, int to) {
		int len = length();
		if (len == 0)
			return Lang.constant.INDEX_NOT_FOUND;
		to = to > len ? length() : to;
		Check.range(from, to, len);
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		int[] cparr = sps.toCodepointArray(arr, innerlen);
		return Arrays.binarySearch(cparr, from, to, codepoint);
	}

	// ===============
	// =============== trim
	// ===============

	/**
	 * trim both sides
	 */
	public Chars trim() {
		return trimBySide(true, true);
	}

	/**
	 * trim left side
	 */
	public Chars trimLeft() {
		return trimBySide(true, false);
	}

	/**
	 * trim right side
	 */
	public Chars trimRight() {
		return trimBySide(false, true);
	}

	/**
	 * remove any extra slots from the buffer
	 */
	public Chars trimToSize() {
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		if (innerlen == 0 && arr.length > 0) {
			return assign(new char[16], innerlen, spc(), sps, getFlags());
		}
		if (innerlen == arr.length) {
			return this;
		}
		arr = Arrays.copyOf(arr, innerlen);
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	// ===============
	// =============== to-array
	// ===============

	/**
	 * @see #toByteArray(int, int, Charset)
	 */
	public byte[] toByteArray() {
		return toByteArray(0);
	}

	/**
	 * @see #toByteArray(int, int, Charset)
	 */
	public byte[] toByteArray(int from) {
		return toByteArray(from, length());
	}

	/**
	 * @see #toByteArray(int, int, Charset)
	 */
	public byte[] toByteArray(int from, int to) {
		return toByteArray(from, to, Charset.defaultCharset());
	}

	/**
	 * @see String#getBytes(Charset) <br>
	 *      <b>default</b> charset = {@link Charset#defaultCharset()}
	 */
	public byte[] toByteArray(int from, int to, Charset charset) {
		final int len = length();
		if (len == 0) {
			return new byte[0];
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		final int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ---------------------
		if (from == 0 && to == innerlen) {
			return new String(arr, 0, innerlen).getBytes(charset);
		}
		// String will do the re-copy
		return new String(arr, from, to - from).getBytes(charset);
	}

	/**
	 * @see #toCharArray(int, int)
	 */
	public char[] toCharArray() {
		return toCharArray(0);
	}

	/**
	 * @see #toCharArray(int, int)
	 */
	public char[] toCharArray(int from) {
		return toCharArray(from, length());
	}

	/**
	 * @return a copy of current content based on given range
	 */
	public char[] toCharArray(int from, int to) {
		final int len = length();
		if (len == 0) {
			return new char[0];
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		final int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ---------------------
		int copylen = (to - from);
		return Lang.copy.to.that(arr, innerlen, Lang.chararray.newArray(copylen), copylen, from, to, 0);
	}

	/**
	 * @see #toCodePointArray(int, int, boolean)
	 */
	public int[] toCodePointArray() {
		return toCodePointArray(0);
	}

	/**
	 * @see #toCodePointArray(int, int, boolean)
	 */
	public int[] toCodePointArray(boolean bmpOnly) {
		return toCodePointArray(0, length(), bmpOnly);
	}

	/**
	 * @see #toCodePointArray(int, int, boolean)
	 */
	public int[] toCodePointArray(int from) {
		return toCodePointArray(from, length());
	}

	/**
	 * @see #toCodePointArray(int, int, boolean)
	 */
	public int[] toCodePointArray(int from, int to) {
		return toCodePointArray(from, to, true);
	}

	/**
	 * all below examples based on cH2.H2H2bdH2h, but for the seek of simplicity,
	 * will use the form: cXX.ZZXXbdXXh, the ZZ just to more clear instead of having
	 * 4 X<br>
	 * <br>
	 * code-points: <br>
	 * [99, 65621, 46, 65621, 65621, 98, 100, 65621, 104] <br>
	 * bmp only: <br>
	 * [99, 55296, 56405, 46, 55296, 56405, 55296, 56405, 98, 100, 55296, 56405,
	 * 104] <br>
	 * <br>
	 * hspc: means handle surrogate pairs, which is the return of
	 * {@link #isSurrogatePairsSupported()} <br>
	 * e.g:
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * [SP=false,IC=false]
	 * "cXX.ZZXXbdXXh".toCodePointArray(0, 4) = {99, 65621, 46}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 4) = {65621, 46}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 4) = {56405, 46}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 5) = {56405, 46, 55296}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 8) = {65621, 46, 65621, 65621}
	 * 
	 * [SP=true,IC=false]
	 * "cXX.ZZXXbdXXh".toCodePointArray(0, 4) = {99, 65621, 46, 65621}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 4) = {65621, 46, 65621}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 4) = {46, 65621}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 5) = {46, 65621, 65621}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 8) = {65621, 46, 65621, 65621, 98, 100, 65621}
	 * 
	 * [SP=false,IC=false]
	 * "cXX.ZZXXbdXXh".toCodePointArray(0, 4, true) = {99, 55296, 56405, 46}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 4, true) = {55296, 56405, 46}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 4, true) = {56405, 46}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 5, true) = {56405, 46, 55296}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 8, true) = {55296, 56405, 46, 55296, 56405, 55296, 56405}
	 * 
	 * [SP=true,IC=false]
	 * "cXX.ZZXXbdXXh".toCodePointArray(0, 4, true) = {99, 55296, 56405, 46, 55296, 56405}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 4, true) = {55296, 56405, 46, 55296, 56405}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 4, true) = {46, 55296, 56405}
	 * "cXX.ZZXXbdXXh".toCodePointArray(2, 5, true) = {46, 55296, 56405, 55296, 56405}
	 * "cXX.ZZXXbdXXh".toCodePointArray(1, 8, true) = {55296, 56405, 46, 55296, 56405, 55296, 56405, 98, 100, 55296, 56405}
	 * </pre>
	 * 
	 * @param bmpOnly if true, return only BMP code-points, if supplementary found,
	 *                include it's pair , otherwise return code-points only
	 * @return a copy of current content based on given range <br>
	 *         <b>default</b> bmpOnly = false
	 */
	public int[] toCodePointArray(int from, int to, boolean bmpOnly) {
		final int len = length();
		if (len == 0) {
			return new int[0];
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		final int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = sps.extendablePairsCount(arr, innerlen, from, to);
		to += between;
		// ---------------------
		int copylen = 0;
		// ============ cases are:
		// bmpOnly && hspc: copylen = to - from;
		// bmpOnly && !hspc: copylen = to - from;
		// !bmpOnly && hspc: copylen = (to - from) - between;
		// !bmpOnly && !hspc: between = fixedSurrogatePairsCount; copylen = (to - from)
		// - between;
		// ============
		copylen = to - from;
		between = sps.fixedPairsCount(arr, innerlen, from, to);

		if (!bmpOnly) {
			copylen = (to - from) - between;
		}

		int[] buf = new int[copylen];
		int cp = 0, c = 0;
		for (; from < to;) {
			// =======================
			// e.g: bmpOnly = false, hspc = false, range 2-5, cX{X.Z}ZXXbdXXh
			// to avoid having last as code-point, will do:
			// if (!bmpOnly && from + 1 == to) is true, get me only bmp char
			// =======================
			cp = bmpOnly || (!bmpOnly && from + 1 == to) ? arr[from] : sps.getCodepoint(arr, innerlen, from);
			from += sps.lengthOf(cp);
			buf[c++] = cp;
		}
		return buf;
	}

	// ===============
	// =============== to-object
	// ===============

	/**
	 * @return new {@link StringBuilder} with this content
	 */
	public StringBuilder toStringBuilder() {
		return new StringBuilder(toString());
	}

	/**
	 * @return new {@link StringBuffer} with this content
	 */
	public StringBuffer toStringBuffer() {
		return new StringBuffer(toString());
	}

	@Override
	public String toString() {
		// String class will re-copy
		return new String(unsafe(), 0, lengthActual());
	}

	// ===============
	// =============== to lower case
	// ===============

	/**
	 * @see #toLowerCaseAt(int, Locale)
	 */
	public Chars toLowerCaseAt(int index) {
		return toLowerCaseAt(index, Locale.getDefault());
	}

	/**
	 * convert the code-point at given index to lower case
	 * 
	 * <br>
	 * <b>default</b> {@link Locale#getDefault()}
	 */
	public Chars toLowerCaseAt(int index, Locale locale) {
		return toLowerCase(index, index + 1, locale);
	}

	/**
	 * @see #toLowerCase(int, int, Locale)
	 */
	public Chars toLowerCase() {
		return toLowerCase(0);
	}

	/**
	 * @see #toLowerCase(int, int, Locale)
	 */
	public Chars toLowerCase(int from) {
		return toLowerCase(from, length());
	}

	/**
	 * @see #toLowerCase(int, int, Locale)
	 */
	public Chars toLowerCase(int from, int to) {
		return toLowerCase(from, to, Locale.getDefault());
	}

	/**
	 * convert to lower case based on given range
	 * 
	 * <br>
	 * <b>default</b> {@link Locale#getDefault()}
	 */
	public Chars toLowerCase(int from, int to, Locale locale) {
		return changeCaseByRange(from, to, false, locale);
	}

	// ===============
	// =============== to upper case
	// ===============

	/**
	 * @see #toUpperCaseAt(int, Locale)
	 */
	public Chars toUpperCaseAt(int index) {
		return toUpperCaseAt(index, Locale.getDefault());
	}

	/**
	 * convert the code-point at given index to upper case
	 * 
	 * <br>
	 * <b>default</b> {@link Locale#getDefault()}
	 */
	public Chars toUpperCaseAt(int index, Locale locale) {
		return toUpperCase(index, index + 1, locale);
	}

	/**
	 * @see #toUpperCase(int, int, Locale)
	 */
	public Chars toUpperCase() {
		return toUpperCase(0);
	}

	/**
	 * @see #toUpperCase(int, int, Locale)
	 */
	public Chars toUpperCase(int from) {
		return toUpperCase(from, length());
	}

	/**
	 * @see #toUpperCase(int, int, Locale)
	 */
	public Chars toUpperCase(int from, int to) {
		return toUpperCase(from, to, Locale.getDefault());
	}

	/**
	 * convert to upper case based on given range
	 * 
	 * <br>
	 * <b>default</b> {@link Locale#getDefault()}
	 */
	public Chars toUpperCase(int from, int to, Locale locale) {
		return changeCaseByRange(from, to, true, locale);
	}

	// ===============
	// =============== capitalize
	// ===============

	/**
	 * @see #capitalize(Locale) <br>
	 *      <b>default</b> {@link Locale#getDefault()}
	 */
	public Chars capitalize() {
		return capitalize(Locale.getDefault());
	}

	/**
	 * convert first code-point into upper case
	 */
	public Chars capitalize(Locale locale) {
		return toUpperCaseAt(0, locale);
	}

	/**
	 * @see #uncapitalize(Locale) <br>
	 *      <b>default</b> {@link Locale#getDefault()}
	 */
	public Chars uncapitalize() {
		return uncapitalize(Locale.getDefault());
	}

	/**
	 * convert first code-point into lower case
	 */
	public Chars uncapitalize(Locale locale) {
		return toLowerCaseAt(0, locale);
	}

	// ===============
	// =============== query is lower
	// ===============

	/**
	 * @see #isLowerCase(int, int)
	 */
	public boolean isLowerCase() {
		return isLowerCase(0);
	}

	/**
	 * @see #isLowerCase(int, int)
	 */
	public boolean isLowerCase(int from) {
		return isLowerCase(from, length());
	}

	/**
	 * @return true based on given range
	 */
	public boolean isLowerCase(int from, int to) {
		final int len = length();
		if (len == 0) {
			return false;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// -----------------
		int x = 0;
		for (int i = from; i < to;) {
			x = sps.getCodepoint(arr, innerlen, i);
			if (Character.isUpperCase(x)) {
				if (Character.isLowerCase(x)) {
					i += sps.lengthOf(x);
					continue;
				}
				return false;
			}
			i += sps.lengthOf(x);
		}
		return true;
	}

	// ===============
	// =============== query is upper
	// ===============

	/**
	 * @see #isUpperCase(int, int)
	 */
	public boolean isUpperCase() {
		return isUpperCase(0);
	}

	/**
	 * @see #isUpperCase(int, int)
	 */
	public boolean isUpperCase(int from) {
		return isUpperCase(from, length());
	}

	/**
	 * @return true based on given range
	 */
	public boolean isUpperCase(int from, int to) {
		final int len = length();
		if (len == 0) {
			return false;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// -----------------
		int x = 0;
		for (int i = from; i < to;) {
			x = sps.getCodepoint(arr, innerlen, i);
			if (!Character.isUpperCase(x)) {
				if (!Character.isLowerCase(x)) {
					i += sps.lengthOf(x);
					continue;
				}
				return false;
			}
			i += sps.lengthOf(x);
		}
		return true;
	}

	// ===============
	// =============== query is mixed case
	// ===============
	/**
	 * @see #isMixedCase(int, int)
	 */
	public boolean isMixedCase() {
		return isMixedCase(0);
	}

	/**
	 * @see #isMixedCase(int, int)
	 */
	public boolean isMixedCase(int from) {
		return isMixedCase(from, length());
	}

	/**
	 * @return true based on given range
	 */
	public boolean isMixedCase(int from, int to) {
		final int len = length();
		if (len == 0) {
			return false;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// -----------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// -----------------
		int x = 0;
		boolean isUppercase = false;
		boolean isLowercase = false;
		for (int i = from; i < to;) {
			x = sps.getCodepoint(arr, innerlen, i);
			if (!isUppercase) {
				isUppercase = Character.isUpperCase(x);
			}
			if (!isLowercase) {
				isLowercase = Character.isLowerCase(x);
			}
			i += sps.lengthOf(x);
		}
		return isUppercase && isLowercase;
	}

	/**
	 * @return true if first code-point is upper case
	 */
	public boolean isCapitalize() {
		if (isEmpty()) {
			return false;
		}
		return Character.isUpperCase(codePointAt(0));
	}

	// ===============
	// =============== compare
	// ===============

	@Override
	public int compareTo(CharSequence other) {
		return compareTo(other, iagc());
	}

	/**
	 * @see String#compareTo(String)
	 */
	public int compareTo(CharSequence other, boolean ignoreCase) {
		if (other instanceof Chars) {
			Chars oc = (Chars) other;
			char[] oarr = oc.unsafe();
			int olen = oc.lengthActual();
			return compareTo(oarr, olen, ignoreCase);
		}
		// below has no consideration to surrogate-pairs, must use innerlength
		// ------------------------
		// why repeating the code????
		// if given object is instance of Chars, we need the actual-length for correct
		// comparing, otherwise, if other is something else, and we can't extract unsafe
		// array, a copy will be required and that will cause low performance, so will
		// go with this approach
		// ------------------------
		int len1 = lengthActual();
		int len2 = other.length();
		int min = Math.min(len1, len2);
		char c1;
		char c2;
		if (!ignoreCase) {
			int k = 0;
			while (k < min) {
				c1 = charAt(k);
				c2 = other.charAt(k);
				if (c1 != c2) {
					return c1 - c2;
				}
				k++;
			}
		} else {
			for (int i = 0; i < min; i++) {
				c1 = charAt(i);
				c2 = other.charAt(i);
				if (c1 != c2) {
					c1 = Character.toUpperCase(c1);
					c2 = Character.toUpperCase(c2);
					if (c1 != c2) {
						c1 = Character.toLowerCase(c1);
						c2 = Character.toLowerCase(c2);
						if (c1 != c2) {
							// No overflow because of numeric promotion
							return c1 - c2;
						}
					}
				}
			}
		}
		return len1 - len2;
	}

	/**
	 * @see #compareTo(char[], int, boolean)
	 */
	public int compareTo(char[] other) {
		return compareTo(other, other.length);
	}

	/**
	 * @see #compareTo(char[], int, boolean)
	 */
	public int compareTo(char[] other, int otherLength) {
		return compareTo(other, otherLength, iagc());
	}

	/**
	 * @see String#compareTo(String)
	 */
	public int compareTo(char[] other, int otherLength, boolean ignoreCase) {
		// below has no consideration to surrogate-pairs, must use innerlen
		// we should not care about surrogate-pairs and the length of other
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int min = Math.min(innerlen, otherLength);
		char c1;
		char c2;
		if (!ignoreCase) {
			int k = 0;
			while (k < min) {
				c1 = arr[k];
				c2 = other[k];
				if (c1 != c2) {
					return c1 - c2;
				}
				k++;
			}
		} else {
			for (int i = 0; i < min; i++) {
				c1 = arr[i];
				c2 = other[i];
				if (c1 != c2) {
					c1 = Character.toUpperCase(c1);
					c2 = Character.toUpperCase(c2);
					if (c1 != c2) {
						c1 = Character.toLowerCase(c1);
						c2 = Character.toLowerCase(c2);
						if (c1 != c2) {
							// No overflow because of numeric promotion
							return c1 - c2;
						}
					}
				}
			}
		}
		return innerlen - otherLength;
	}

	// ===============
	// =============== equals
	// ===============

	/**
	 * @see #equals(Object, boolean)
	 */
	@Override
	public boolean equals(Object obj) {
		return equals(obj, iagc());
	}

	/**
	 * @return true references are equals or if object is instance of {@link Chars}
	 *         and both content are equals
	 */
	public boolean equals(Object obj, boolean ignoreCase) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Chars) {
			Chars oc = (Chars) obj;
			char[] oarr = oc.unsafe();
			int olen = oc.lengthActual();
			return compareTo(oarr, olen, ignoreCase) == 0;
		}
		return false;
	}

	/**
	 * @see #contentEquals(CharSequence, boolean)
	 */
	public boolean contentEquals(CharSequence cs) {
		return contentEquals(cs, iagc());
	}

	/**
	 * *
	 * 
	 * @see true if both content are equals
	 */
	public boolean contentEquals(CharSequence cs, boolean ignoreCase) {
		return compareTo(cs, ignoreCase) == 0;
	}

	// ===============
	// =============== index-of code-point
	// ===============
	/**
	 * @see #indexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(int target) {
		return indexOf(target, 0);
	}

	/**
	 * @see #indexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(int target, int from) {
		return indexOf(target, from, length());
	}

	/**
	 * @see #indexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(int target, int from, int to) {
		return indexOf(target, from, to, iagc());
	}

	/**
	 * @see #indexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(int target, int from, int to, boolean ignoreCase) {
		return indexOf(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return index of given target code-point based on given range, or -1 if not
	 *         found
	 * @see String#indexOf(int, int)
	 */
	protected int indexOf(int target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		return CharsLoop.INDEX_OF.codePoint(arr, innerlen, from, to, target, flags, fromDisp, m, sps);
	}

	// ===============
	// =============== index-of sequence
	// ===============
	/**
	 * @see #indexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(CharSequence target) {
		return indexOf(target, 0);
	}

	/**
	 * @see #indexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(CharSequence target, int from) {
		return indexOf(target, from, length());
	}

	/**
	 * @see #indexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(CharSequence target, int from, int to) {
		return indexOf(target, from, to, iagc());
	}

	/**
	 * @see #indexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(CharSequence target, int from, int to, boolean ignoreCase) {
		return indexOf(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return index of given target sequence <b>(entire)</b> based on given range,
	 *         or -1 if not found
	 * @see String#indexOf(String, int)
	 */
	protected int indexOf(CharSequence target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return indexOf(tarr, tlen, from, to, ignoreCase, m);
	}

	// ===============
	// =============== index-of array
	// ===============

	/**
	 * @see #indexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(char[] target, int targetLength) {
		return indexOf(target, targetLength, 0);
	}

	/**
	 * @see #indexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(char[] target, int targetLength, int from) {
		return indexOf(target, targetLength, from, length());
	}

	/**
	 * @see #indexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(char[] target, int targetLength, int from, int to) {
		return indexOf(target, targetLength, from, to, iagc());
	}

	/**
	 * @see #indexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOf(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		return indexOf(target, targetLength, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return index of given target char-array <b>(entire)</b> based on given
	 *         range, or -1 if not found
	 * @see String#indexOf(String, int)
	 */
	protected int indexOf(char[] target, int targetLength, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (target == null) {
			return Lang.constant.INDEX_NOT_FOUND;
		} else if (from >= len) {
			return (targetLength == 0 ? len : Lang.constant.INDEX_NOT_FOUND);
		} else if (targetLength == 0) {
			return from;
		}
		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		return CharsLoop.INDEX_OF.array(arr, innerlen, from, to, target, targetLength, flags, fromDisp, m, sps);
	}

	// ===============
	// =============== lastIndex-of code-point
	// ===============
	/**
	 * @see #lastIndexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(int target) {
		return lastIndexOf(target, length());
	}

	/**
	 * @see #lastIndexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(int target, int from) {
		return lastIndexOf(target, from, 0);
	}

	/**
	 * @see #lastIndexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(int target, int from, int to) {
		return lastIndexOf(target, from, to, iagc());
	}

	/**
	 * @see #lastIndexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(int target, int from, int to, boolean ignorCase) {
		return lastIndexOf(target, from, to, ignorCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @param from (exclusive-right-index)
	 * @param to   (inclusive-left-index)
	 * @return last-index of given target code-point based on given range, or return
	 *         -1 if not found
	 * @see String#lastIndexOf(int, int)
	 */
	protected int lastIndexOf(int target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (len == 0 || to < 0) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		from = from > len ? len : from;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int toDisp = sps.extendablePairsCount(arr, innerlen, 0, to);
		to += toDisp;
		from += toDisp;
		int fromDisp = sps.extendablePairsCount(arr, innerlen, to, from);
		from += fromDisp;
		// ------------------
		return CharsLoop.LAST_INDEX_OF.codePoint(arr, innerlen, from, to, target, flags, fromDisp, m, sps);
	}

	// ===============
	// =============== lastIndex-of sequence
	// ===============
	/**
	 * @see #lastIndexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(CharSequence target) {
		return lastIndexOf(target, length());
	}

	/**
	 * @see #lastIndexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(CharSequence target, int from) {
		return lastIndexOf(target, from, 0);
	}

	/**
	 * @see #lastIndexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(CharSequence target, int from, int to) {
		return lastIndexOf(target, from, to, iagc());
	}

	/**
	 * @see #lastIndexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(CharSequence target, int from, int to, boolean ignoreCase) {
		return lastIndexOf(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return last-index of given target sequence <b>(entire)</b> based on given
	 *         range, or -1 if not found
	 * @see String#lastIndexOf(String, int) <br>
	 *      <b>default</b> to=-1 to return exact result as
	 *      {@link String#lastIndexOf(String, int)}
	 */
	protected int lastIndexOf(CharSequence target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return lastIndexOf(tarr, tlen, from, to, ignoreCase, m);
	}

	// ===============
	// =============== lastIndex-of array
	// ===============

	/**
	 * @see #lastIndexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(char[] target, int targetLength) {
		return lastIndexOf(target, targetLength, length());
	}

	/**
	 * @see #lastIndexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(char[] target, int targetLength, int from) {
		return lastIndexOf(target, targetLength, from, 0);
	}

	/**
	 * @see #lastIndexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(char[] target, int targetLength, int from, int to) {
		return lastIndexOf(target, targetLength, from, to, iagc());
	}

	/**
	 * @see #lastIndexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOf(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		return lastIndexOf(target, targetLength, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return last-index of given target char-array <b>(entire)</b> based on given
	 *         range, or -1 if not found
	 * @see String#lastIndexOf(String, int)
	 */
	protected int lastIndexOf(char[] target, int targetLength, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		// special case if: to < -1, means invalid range, and no match
		// -1 for no range match, and will work like traditional String.lastIndexOf
		if (len == 0 || to < -1 || target == null) {
			return Lang.constant.INDEX_NOT_FOUND;
		} else if (targetLength == 0) {
			return from;
		}
		from = from > len ? len : from;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int toDisp = to == -1 ? 0 : sps.extendablePairsCount(arr, innerlen, 0, to);
		to += toDisp;
		from += toDisp;
		int fromDisp = sps.extendablePairsCount(arr, innerlen, to == -1 ? 0 : to, from);
		from += fromDisp;
		// ------------------
		return CharsLoop.LAST_INDEX_OF.array(arr, innerlen, from, to, target, targetLength, flags, fromDisp, m, sps);
	}

	// ===============
	// =============== index-of any code-point
	// ===============

	/**
	 * @see #indexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(int[] targets) {
		return indexOfAny(targets, 0);
	}

	/**
	 * @see #indexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(int[] targets, int from) {
		return indexOfAny(targets, from, length());
	}

	/**
	 * @see #indexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(int[] targets, int from, int to) {
		return indexOfAny(targets, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(int[] targets, int from, int to, boolean ignoreCase) {
		return indexOfAny(targets, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * find index of any code-point of given targets
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".indexOfAny(null)                 = -1
	 * "".indexOfAny(new int[]{})                 = -1
	 * "codes".indexOfAny(null)               = -1
	 * "codes".indexOfAny(new int[]{})                 = -1
	 * "zzabyycdxx".indexOfAny(new int[]{'z'})    = 0
	 * "zzabyycdxx".indexOfAny(new int[]{'b'})    = 3
	 * "aba".indexOfAny(new int[]{'z'})          = -1
	 * </pre>
	 * 
	 * @return index of any target of given code-points array <b>(individuals)</b>
	 *         based on given range, or -1 if not found
	 */
	protected int indexOfAny(int[] targets, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (len == 0 || from >= len || Lang.emptyOrNull.isAny(targets)) {
			return Lang.constant.INDEX_NOT_FOUND;
		}

		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		return CharsLoop.INDEX_OF.codePoints(arr, innerlen, from, to, targets, targets.length, flags, fromDisp, m, sps);
	}

	// ===============
	// =============== last-index-of any code-point
	// ===============

	/**
	 * @see #lastIndexOfAny(int[], int, int, boolean, CharsMatcher, CharsMatcher)
	 */
	public int lastIndexOfAny(int[] targets) {
		return lastIndexOfAny(targets, 0);
	}

	/**
	 * @see #lastIndexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfAny(int[] targets, int from) {
		return lastIndexOfAny(targets, from, length());
	}

	/**
	 * @see #lastIndexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfAny(int[] targets, int from, int to) {
		return lastIndexOfAny(targets, from, to, iagc());
	}

	/**
	 * @see #lastIndexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfAny(int[] targets, int from, int to, boolean ignoreCase) {
		return lastIndexOfAny(targets, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * find index of any code-point of given targets
	 * 
	 * 
	 * @return index of any target of given code-points array <b>(individuals)</b>
	 *         based on given range, or -1 if not found
	 */
	protected int lastIndexOfAny(int[] targets, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (len == 0 || to < -1 || Lang.emptyOrNull.isAny(targets)) {
			return Lang.constant.INDEX_NOT_FOUND;
		}

		from = from > len ? len : from;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int toDisp = to == -1 ? 0 : sps.extendablePairsCount(arr, innerlen, 0, to);
		to += toDisp;
		from += toDisp;
		int fromDisp = sps.extendablePairsCount(arr, innerlen, to == -1 ? 0 : to, from);
		from += fromDisp;
		// ------------------
		return CharsLoop.LAST_INDEX_OF.codePoints(arr, innerlen, from, to, targets, targets.length, flags, fromDisp, m,
				sps);
	}

	// ===============
	// =============== index-of code-point if spc supported or index-of char
	// ===============
	/**
	 * @see #indexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence target) {
		return indexOfAny(target, 0);
	}

	/**
	 * @see #indexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence target, int from) {
		return indexOfAny(target, from, length());
	}

	/**
	 * @see #indexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence target, int from, int to) {
		return indexOfAny(target, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence target, int from, int to, boolean ignoreCase) {
		return indexOfAny(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * find index of any code-point of given target
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".indexOfAny(null)                 = -1
	 * "".indexOfAny("")                 = -1
	 * "codes".indexOfAny(null)               = -1
	 * "codes".indexOfAny("")                 = -1
	 * "zzabyycdxx".indexOfAny("za")    = 0
	 * "zzabyycdxx".indexOfAny("by")    = 3
	 * "aba".indexOfAny("z")            = -1
	 * </pre>
	 * 
	 * @return index of any target of given code-points/chars sequence
	 *         <b>(individuals)</b> based on given range, or -1 if not found <br>
	 *         <b>Note</b> if {@link #isSurrogatePairsSupported()} true, will look
	 *         into the given sequence as code-points array, otherwise will be
	 *         normal bmp char-array, so e.g if surrogate-pairs not supported, and
	 *         src: codF4s.H2bdullah, and looking for: H2, the result will be: 3
	 *         because F4 and H2 has the same high surrogate [<b>55296</b>, 56509,
	 *         <b>55296</b>, 56405]
	 */
	protected int indexOfAny(CharSequence targets, int from, int to, boolean ignoreCase, CharsMatcher m) {
		char[] tarr = null;
		int tlen = 0;
		if (targets instanceof Chars) {
			Chars c = (Chars) targets;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (targets != null) {
			tarr = targets.toString().toCharArray();
			tlen = targets.length();
		}
		return indexOfAny(tarr, tlen, from, to, ignoreCase, m);
	}

	// ===============
	// =============== index-of code-point if spc supported or index-of char
	// ===============
	/**
	 * @see #indexOfAny(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(char[] targets, int targetsLength) {
		return indexOfAny(targets, targetsLength, 0);
	}

	/**
	 * @see #indexOfAny(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(char[] targets, int targetsLength, int from) {
		return indexOfAny(targets, targetsLength, from, length());
	}

	/**
	 * @see #indexOfAny(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(char[] targets, int targetsLength, int from, int to) {
		return indexOfAny(targets, targetsLength, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(char[], int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(char[] targets, int targetsLength, int from, int to, boolean ignoreCase) {
		return indexOfAny(targets, targetsLength, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * find index of any code-point of given target
	 * 
	 * <pre>
	 * "".indexOfAny(null, 0, 0, 0)                 = -1
	 * "".indexOfAny(new char[]{}, 0, 0, 0)                 = -1
	 * "codes".indexOfAny(null, 0, 0, 0)               = -1
	 * "codes".indexOfAny("")                 = -1
	 * "zzabyycdxx".indexOfAny("za")    = 0
	 * "zzabyycdxx".indexOfAny("by")    = 3
	 * "aba".indexOfAny("z")            = -1
	 * </pre>
	 * 
	 * @return index of any target of given code-points/chars char-array
	 *         <b>(individuals)</b> based on given range, or -1 if not found <br>
	 *         <b>Note</b> if {@link #isSurrogatePairsSupported()} true, will look
	 *         into the given sequence as code-points array, otherwise will be
	 *         normal bmp char-array, so e.g if surrogate-pairs not supported, and
	 *         src: codF4s.H2bdullah, and looking for: H2, the result will be: 3
	 *         because F4 and H2 has the same high surrogate [<b>55296</b>, 56509,
	 *         <b>55296</b>, 56405]
	 */
	protected int indexOfAny(char[] targets, int targetsLength, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (targets == null) {
			return Lang.constant.INDEX_NOT_FOUND;
		} else if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		from = from < 0 ? 0 : from;
		if (targetsLength == 0) {
			return from;
		}

		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		int index = Lang.constant.INDEX_NOT_FOUND;
		int target = 0;
		for (int i = 0; i < targetsLength;) {
			target = sps.getCodepoint(targets, targetsLength, i);
			index = CharsLoop.INDEX_OF.codePoint(arr, innerlen, from, to, target, flags, fromDisp, m, sps);
			if (index > Lang.constant.INDEX_NOT_FOUND) {
				return index;
			}
			i += sps.lengthOf(target);
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	// ===============
	// =============== index-of any sequence
	// ===============

	/**
	 * @see #indexOfAny(CharSequence[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence[] targets) {
		return indexOfAny(targets, 0);
	}

	/**
	 * @see #indexOfAny(CharSequence[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence[] targets, int from) {
		return indexOfAny(targets, from, length());
	}

	/**
	 * @see #indexOfAny(CharSequence[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence[] targets, int from, int to) {
		return indexOfAny(targets, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(CharSequence[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence[] targets, int from, int to, boolean ignoreCase) {
		return indexOfAny(targets, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * <p>
	 * Find the first index of any of a set of potential substrings.
	 * </p>
	 * 
	 * [TEST]
	 * 
	 * <pre>
	 * "".indexOfAny(null, 0, 0, false)                           = -1
	 * "codes".indexOfAny(null, 0, 0, false)                         = -1
	 * "codes".indexOfAny(new String[]{}, 0, 0, false)                           = -1
	 * "zzabyycdxx".indexOfAny({"ab", "cd"})      = 2
	 * "zzabyycdxx".indexOfAny({"cd", "ab"})      = 6
	 * "zzabyycdxx".indexOfAny({"mn", "op"})      = -1
	 * "zzabyycdxx".indexOfAny({"zab", "aby"})    = 1
	 * "zzabyycdxx".indexOfAny({""})              = 0
	 * "".indexOfAny({""})                        = 0
	 * "".indexOfAny({"a"})                       = -1
	 * </pre>
	 * 
	 * @return index of any target of given sequence-array <b>(entire)</b> based on
	 *         given range, or -1 if not found
	 */
	protected int indexOfAny(CharSequence[] targets, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (targets == null) {
			return Lang.constant.INDEX_NOT_FOUND;
		} else if (from >= len) {
			return len;
		} else if (targets.length == 0) {
			return from;
		}

		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		int index = Lang.constant.INDEX_NOT_FOUND;
		for (final CharSequence target : targets) {
			if (target == null) {
				continue;
			}

			char[] tarr = null;
			int tlen = 0;
			if (target instanceof Chars) {
				Chars c = (Chars) target;
				tarr = c.unsafe();
				tlen = c.lengthActual();
			} else if (target != null) {
				tarr = target.toString().toCharArray();
				tlen = target.length();
			}
			index = CharsLoop.INDEX_OF.array(arr, innerlen, from, to, tarr, tlen, flags, fromDisp, m, sps);
			if (index > Lang.constant.INDEX_NOT_FOUND) {
				return index;
			}
		}
		return Lang.constant.INDEX_NOT_FOUND;
	}

	// ===============
	// =============== index-of any but not code-point
	// ===============

	/**
	 * @see #indexOfAnyButNot(int, int, int, boolean)
	 */
	public int indexOfAnyButNot(int target) {
		return indexOfAnyButNot(target, 0);
	}

	/**
	 * @see #indexOfAnyButNot(int, int, int, boolean)
	 */
	public int indexOfAnyButNot(int target, int from) {
		return indexOfAnyButNot(target, from, length());
	}

	/**
	 * @see #indexOfAnyButNot(int, int, int, boolean)
	 */
	public int indexOfAnyButNot(int target, int from, int to) {
		return indexOfAnyButNot(target, from, to, iagc());
	}

	/**
	 * @return index of any code-point but not the given based on given range, or -1
	 *         if not found
	 * @see #indexOf(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAnyButNot(int target, int from, int to, boolean ignoreCase) {
		return indexOf(target, from, to, ignoreCase, CharsMatcher.MUST_NOT_EQUALS);
	}

	// ===============
	// =============== index-of any but not code-point array
	// ===============

	/**
	 * @see #indexOfAnyButNot(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAnyButNot(int[] targets) {
		return indexOfAnyButNot(targets, 0);
	}

	/**
	 * @see #indexOfAnyButNot(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAnyButNot(int[] targets, int from) {
		return indexOfAnyButNot(targets, from, length());
	}

	/**
	 * @see #indexOfAnyButNot(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAnyButNot(int[] targets, int from, int to) {
		return indexOfAnyButNot(targets, from, to, iagc());
	}

	/**
	 * 
	 * 
	 * <pre>
	 * "".indexOfAnyButNot(null)                                  = -1
	 * "".indexOfAnyButNot(new int[]{})                                  = -1
	 * "codes".indexOfAnyButNot(null)                                = -1
	 * "codes".indexOfAnyButNot(new int[]{})                                  = -1
	 * "zzabyycdxx".indexOfAnyButNot(new int[] {'z', 'a'})    = 3
	 * "aba".indexOfAnyButNot(new int[] {'z'})                = 0
	 * "aba".indexOfAnyButNot(new int[] {'a', 'b'})           = -1
	 * </pre>
	 * 
	 * @return index of any code-point but not the once inside the given code-points
	 *         array <b>(individuals)</b> based on given range, or -1 if not found
	 * @see #indexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public int indexOfAnyButNot(int[] targets, int from, int to, boolean ignoreCase) {
		return indexOfAny(targets, from, to, ignoreCase, CharsMatcher.MUST_NOT_EQUALS);
	}

	// ===============
	// =============== index-of any but not code-point from sequence
	// ===============

	/**
	 * @see #indexOfAnyButNot(CharSequence, int, int, boolean)
	 */
	public int indexOfAnyButNot(CharSequence target) {
		return indexOfAnyButNot(target, 0);
	}

	/**
	 * @see #indexOfAnyButNot(CharSequence, int, int, boolean)
	 */
	public int indexOfAnyButNot(CharSequence target, int from) {
		return indexOfAnyButNot(target, from, length());
	}

	/**
	 * @see #indexOfAnyButNot(CharSequence, int, int, boolean)
	 */
	public int indexOfAnyButNot(CharSequence target, int from, int to) {
		return indexOfAnyButNot(target, from, to, iagc());
	}

	/**
	 * 
	 * 
	 * @return index of any code-point <b>(individuals)</b> but not the given
	 *         code-points based on given range, or -1 if not found
	 */
	public int indexOfAnyButNot(CharSequence target, int from, int to, boolean ignoreCase) {
		return indexOfAny(target, from, to, ignoreCase, CharsMatcher.MUST_NOT_EQUALS);
	}

	// ===============
	// =============== index-of any but not code-point from char[]
	// ===============

	/**
	 * @see #indexOfAnyButNot(char[], int, int, int, boolean)
	 */
	public int indexOfAnyButNot(char[] targets, int targetsLength) {
		return indexOfAnyButNot(targets, targetsLength, 0);
	}

	/**
	 * @see #indexOfAnyButNot(char[], int, int, int, boolean)
	 */
	public int indexOfAnyButNot(char[] targets, int targetsLength, int from) {
		return indexOfAnyButNot(targets, targetsLength, from, length());
	}

	/**
	 * @see #indexOfAnyButNot(char[], int, int, int, boolean)
	 */
	public int indexOfAnyButNot(char[] targets, int targetsLength, int from, int to) {
		return indexOfAnyButNot(targets, targetsLength, from, to, iagc());
	}

	/**
	 * @return index of any code-point but not the once inside the given code-points
	 *         array <b>(individuals)</b> based on given range, or -1 if not found
	 */
	public int indexOfAnyButNot(char[] targets, int targetsLength, int from, int to, boolean ignoreCase) {
		return indexOfAny(targets, targetsLength, from, to, ignoreCase, CharsMatcher.MUST_NOT_EQUALS);
	}

	// ===============
	// =============== index-of-end by code-point
	// ===============
	/**
	 * @return {@link #indexOfEnd(int, int, int, boolean)}
	 */
	public int indexOfEnd(int target) {
		return indexOfEnd(target, 0);
	}

	/**
	 * @return {@link #indexOfEnd(int, int, int, boolean)}
	 */
	public int indexOfEnd(int target, int from) {
		return indexOfEnd(target, from, length());
	}

	/**
	 * @return {@link #indexOfEnd(int, int, int, boolean)}
	 */
	public int indexOfEnd(int target, int from, int to) {
		return indexOfEnd(target, from, to, iagc());
	}

	/**
	 * find the index-of-end <b>exclusively</b> based on given range<br>
	 * <br>
	 * e.g: codes.j<b>aaaa</b>va.abdullah, char (a) first shown index is 7, and in
	 * sequence, last shown index is 11, which is index-of-end
	 */
	public int indexOfEnd(int target, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		from = from < 0 ? 0 : from;
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		// e.g: hspc = true, from(7), to(len), cF4des.H2{bdF4llH2H2h.java}, fromDisp(2),
		// toDisp(3)
		// target='H2', index(12) (visual-level)
		int index = CharsLoop.INDEX_OF.codePoint(arr, innerlen, from, to, target, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		// convert index into actual-level by fromDisp + index
		fromDisp += sps.extendablePairsCount(arr, innerlen, from, fromDisp + index);
		// now fromDisp has every sp before index on (actual-level)
		// convert index into actual-level and assign it into from
		from = index + fromDisp;
		return Lang.codepoint.index.ofEnd(arr, innerlen, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS,
				sps);
	}

	// ===============
	// =============== index-of-end array
	// ===============

	/**
	 * @see #indexOfEnd(int, int)
	 */
	public int indexOfEnd(int[] targets) {
		return indexOfEnd(targets, 0);
	}

	/**
	 * @see #indexOfEnd(int, int)
	 */
	public int indexOfEnd(int[] targets, int from) {
		return indexOfEnd(from, length());
	}

	/**
	 * @return index-of end of any (even in sequence) based on given range, or -1 if
	 *         not found <br>
	 */
	public int indexOfEnd(int[] targets, int from, int to) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = getFlags();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		int index = CharsLoop.INDEX_OF.codePoints(arr, innerlen, from, to, targets, targets.length, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return -1;
		}
		// convert index into actual-level by fromDisp + index
		fromDisp += sps.extendablePairsCount(arr, innerlen, from, fromDisp + index);
		// now fromDisp has every sp before index on (actual-level)
		// convert index into actual-level and assign it into from
		from = index + fromDisp;
		return Lang.codepoint.index.ofAnyEnd(arr, innerlen, targets, from, to, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
	}

	// ===============
	// =============== index-of-end by char sequence
	// ===============

	/**
	 * @see #indexOfEnd(char[], int, int, int, boolean)
	 */
	public int indexOfEnd(CharSequence cs) {
		return indexOfEnd(cs, 0);
	}

	/**
	 * @see #indexOfEnd(char[], int, int, int, boolean)
	 */
	public int indexOfEnd(CharSequence cs, int from) {
		return indexOfEnd(cs, from, length());
	}

	public int indexOfEnd(CharSequence cs, int from, int to) {
		return indexOfEnd(cs, from, to, iagc());
	}

	/**
	 * @see #indexOfEnd(char[], int, int, int, boolean)
	 */
	public int indexOfEnd(CharSequence target, int from, int to, boolean ignoreCase) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return indexOfEnd(tarr, tlen, from, to, ignoreCase);
	}

	// ===============
	// =============== index-of-end by char array
	// ===============

	/**
	 * @see #indexOfEnd(char[], int, int, int, boolean)
	 */
	public int indexOfEnd(char[] target, int targetLength) {
		return indexOfEnd(target, targetLength, 0);
	}

	/**
	 * @see #indexOfEnd(char[], int, int, int, boolean)
	 */
	public int indexOfEnd(char[] target, int targetLength, int from) {
		return indexOfEnd(target, targetLength, from, length());
	}

	/**
	 * @see #indexOfEnd(char[], int, int, int, boolean)
	 */
	public int indexOfEnd(char[] target, int targetLength, int from, int to) {
		return indexOfEnd(target, targetLength, from, to, iagc());
	}

	/**
	 * count matches of given target based on given range
	 */
	public int indexOfEnd(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0 || target == null || targetLength == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ---------------------
		int index = CharsLoop.INDEX_OF.array(arr, innerlen, from, to, target, targetLength, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
		if (index == Lang.constant.INDEX_NOT_FOUND) {
			return -1;
		}
		// convert index into actual-level by fromDisp + index
		fromDisp += sps.extendablePairsCount(arr, innerlen, from, fromDisp + index);
		// now fromDisp has every sp before index on (actual-level)
		// convert index into actual-level and assign it into from
		from = index + fromDisp;
		return Lang.chararray.index.ofEnd(arr, innerlen, target, targetLength, from, to, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps);
	}

	// ===============
	// =============== index-of-end white space end
	// ===============

	/**
	 * @see #indexOfWhitespaceEnd(int, int)
	 */
	public int indexOfWhitespaceEnd() {
		return indexOfWhitespaceEnd(0);
	}

	/**
	 * @see #indexOfWhitespaceEnd(int, int)
	 */
	public int indexOfWhitespaceEnd(int from) {
		return indexOfWhitespaceEnd(from, length());
	}

	/**
	 * @return index-of end of any whitespace based on given range, or -1 if not
	 *         found <br>
	 *         <b>Note</b> Whitespaces are: the defined in
	 *         {@link Character#isWhitespace(int)}
	 */
	public int indexOfWhitespaceEnd(int from, int to) {
		return indexOfEnd(WHITESPACES_ARRAY, from, to);
	}

	// ===============
	// =============== index-of-end line-feed
	// ===============

	/**
	 * @see #indexOfLinefeedEnd(int, int)
	 */
	public int indexOfLinefeedEnd() {
		return indexOfLinefeedEnd(0);
	}

	/**
	 * @see #indexOfLinefeedEnd(int, int)
	 */
	public int indexOfLinefeedEnd(int from) {
		return indexOfLinefeedEnd(from, length());
	}

	/**
	 * @return index-of end of any linefeed based on given range, or -1 if not found
	 *         <br>
	 *         <b>Note</b> Linefeeds are: (\r), (\n) and (\r\n)
	 */
	public int indexOfLinefeedEnd(int from, int to) {
		return indexOfEnd(LINEFEEDS_ARRAY, from, to);
	}

	// ===============
	// =============== index-of index
	// ===============

	/**
	 * @see #indexOfIndex(int, int, int, int, boolean)
	 */
	public int indexOfIndex(int targetCodePoint, int targetIndex) {
		return indexOfIndex(targetCodePoint, targetIndex, 0);
	}

	/**
	 * @see #indexOfIndex(int, int, int, int, boolean)
	 */
	public int indexOfIndex(int targetCodePoint, int targetIndex, int from) {
		return indexOfIndex(targetCodePoint, targetIndex, from, iagc());
	}

	/**
	 * @see #indexOfIndex(int, int, int, int, boolean)
	 */
	public int indexOfIndex(int targetCodePoint, int targetIndex, int from, boolean ignoreCase) {
		return indexOfIndex(targetCodePoint, targetIndex, from, length(), ignoreCase);
	}

	/**
	 * find an index-of index<br>
	 * <br>
	 * e.g: codes.abdullah, the char (a) shown 2 times, we can say index-of first
	 * (a) is 0, and is shown at sequence-index = 6, and index-of second (a) is 1,
	 * and is shown at sequence-index = 12, so index-of-index 1 is 12
	 */
	public int indexOfIndex(int targetCodePoint, int targetIndex, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
//		return CharsUtils.indexOfCodePointIndex(arr, innerlen, from, to, targetCodePoint, targetIndex,
//				reflag(ignoreCase, Lang.constant.CHARS_FLAG_ALWAYS_IGNORE_CASE), fromDisp, sps);
		return Lang.codepoint.index.ofIndex(arr, innerlen, targetCodePoint, targetIndex, from, to,
				reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE), fromDisp, CharsMatcher.MUST_EQUALS, sps);
	}

	// ===============
	// =============== index-of leftover
	// ===============

	/**
	 * #see {@link #indexOfLeftoverSurrogate(int, int)}
	 */
	public int indexOfLeftoverSurrogate() {
		return indexOfLeftoverSurrogate(0);
	}

	/**
	 * #see {@link #indexOfLeftoverSurrogate(int, int)}
	 */
	public int indexOfLeftoverSurrogate(int from) {
		return indexOfLeftoverSurrogate(from, length());
	}

	/**
	 * leftover surrogates are any high or low surrogates not in bound properly as
	 * [HL]
	 */
	public int indexOfLeftoverSurrogate(int from, int to) {
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ------------------
		return sps.indexOfBroken(arr, innerlen, from, to);
	}

	// ===============
	// =============== index-of difference
	// ===============
	/**
	 * @see #indexOfDifference(CharSequence, int, int, boolean)
	 */
	public int indexOfDifference(CharSequence competitive) {
		return indexOfDifference(competitive, 0);
	}

	/**
	 * @see #indexOfDifference(CharSequence, int, int, boolean)
	 */
	public int indexOfDifference(CharSequence competitive, int from) {
		return indexOfDifference(competitive, from, iagc());
	}

	/**
	 * @see #indexOfDifference(CharSequence, int, int, boolean)
	 */
	public int indexOfDifference(CharSequence competitive, int from, boolean ignoreCase) {
		return indexOfDifference(competitive, from, length(), ignoreCase);
	}

	/**
	 * [TEST]
	 * 
	 * <pre>
	 * "".indexOfDifference(null) = -1
	 * "".indexOfDifference("") = -1
	 * "".indexOfDifference("abc") = 0
	 * "abc".indexOfDifference("") = 0
	 * "abc".indexOfDifference("abc") = -1
	 * "ab".indexOfDifference("abxyz") = 2
	 * "abcde".indexOfDifference("abxyz") = 2
	 * "abcde".indexOfDifference("xyz") = 0
	 * </pre>
	 */
	public int indexOfDifference(CharSequence competitive, int from, int to, boolean ignoreCase) {
		int len = length();

		if (len == 0 && (competitive != null && competitive.length() == 0)) {
			return Lang.constant.INDEX_NOT_FOUND;
		}

		if (this == competitive) {
			return Lang.constant.INDEX_NOT_FOUND;
		}

		if (len == 0 || Lang.emptyOrNull.isAny(competitive)) {
			return 0;
		}

		if (from >= len && from >= competitive.length()) {
			return Lang.constant.INDEX_NOT_FOUND;
		} else if (from >= len && from < competitive.length()) {
			return from;
		} else if (from < len && from >= competitive.length()) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		char[] arr = unsafe();
		int innerlen = lengthActual();
		to = to > len ? len : to;
		Check.range(from, to);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ------------------

		int ch1, ch2;
		int i, spc = 0;
		for (i = from; i < to && i < competitive.length(); ++i) {
			ch1 = sps.getCodepoint(arr, innerlen, i);
			ch2 = sps.getCodepoint(competitive, i);
			if (ignoreCase) {
				ch1 = Character.toLowerCase(ch1);
				ch2 = Character.toLowerCase(ch2);
			}

			if (ch1 != ch2) {
				break;
			}

			if (Character.isSupplementaryCodePoint(ch1)) {
				i++;
				spc++;
			}
		}
		if (i < len || i < competitive.length()) {
			return sps.isSupported() ? i - spc : i;
		}

		return Lang.constant.INDEX_NOT_FOUND;
	}

	// ===============
	// =============== indexes-of code-point
	// ===============
	/**
	 * @see #indexesOf(int, int, int, boolean)
	 */
	public int[] indexesOf(int target) {
		return indexesOf(target, 0);
	}

	/**
	 * @see #indexesOf(int, int, int, boolean)
	 */
	public int[] indexesOf(int target, int from) {
		return indexesOf(target, from, length());
	}

	/**
	 * @see #indexesOf(int, int, int, boolean)
	 */
	public int[] indexesOf(int target, int from, int to) {
		return indexesOf(target, from, to, iagc());
	}

	/**
	 * @return indexes of all occurrences of given target based on given range
	 */
	public int[] indexesOf(int target, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from >= len) {
			return new int[0];
		}
		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		return Lang.codepoint.indexes.of(arr, innerlen, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS,
				sps);
	}

	// ===============
	// =============== indexes-of sequence
	// ===============

	/**
	 * @see #indexesOf(CharSequence, int, int, boolean)
	 */
	public int[] indexesOf(CharSequence target) {
		return indexesOf(target, 0);
	}

	/**
	 * @see #indexesOf(CharSequence, int, int, boolean)
	 */
	public int[] indexesOf(CharSequence target, int from) {
		return indexesOf(target, from, length());
	}

	/**
	 * @see #indexesOf(CharSequence, int, int, boolean)
	 */
	public int[] indexesOf(CharSequence target, int from, int to) {
		return indexesOf(target, from, to, iagc());
	}

	/**
	 * @return indexes of all occurrences of given target based on given range
	 */
	public int[] indexesOf(CharSequence target, int from, int to, boolean ignoreCase) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return indexesOf(tarr, tlen, from, to, ignoreCase);
	}

	// ===============
	// =============== indexes-of char-array
	// ===============

	/**
	 * @see #indexesOf(char[], int, int, int, boolean)
	 */
	public int[] indexesOf(char[] target, int targetLength) {
		return indexesOf(target, targetLength, 0);
	}

	/**
	 * @see #indexesOf(char[], int, int, int, boolean)
	 */
	public int[] indexesOf(char[] target, int targetLength, int from) {
		return indexesOf(target, targetLength, from, length());
	}

	/**
	 * @see #indexesOf(char[], int, int, int, boolean)
	 */
	public int[] indexesOf(char[] target, int targetLength, int from, int to) {
		return indexesOf(target, targetLength, from, to, iagc());
	}

	/**
	 * @return indexes of all occurrences of given target based on given range
	 */
	public int[] indexesOf(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from >= len || Lang.emptyOrNull.isAny(target) || targetLength <= 0) {
			return new int[0];
		}
		from = from < 0 ? 0 : from;
		to = to > len ? len : to;
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		return Lang.chararray.indexes.of(arr, innerlen, target, targetLength, from, to,
				reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE), fromDisp, CharsMatcher.MUST_EQUALS, sps);
	}

	// ===============
	// =============== index-of white space
	// ===============

	/**
	 * @see #indexOfWhitespace(int, int)
	 */
	public int indexOfWhitespace() {
		return indexOfWhitespace(0);
	}

	/**
	 * @see #indexOfWhitespace(int, int)
	 */
	public int indexOfWhitespace(int from) {
		return indexOfWhitespace(from, length());
	}

	/**
	 * @return index-of whitespace based on given range, or -1 if not found <br>
	 *         <b>Note</b> Whitespaces are: the defined in
	 *         {@link Character#isWhitespace(int)}
	 */
	public int indexOfWhitespace(int from, int to) {
		return indexOfAny(WHITESPACES_ARRAY, from, to);
	}

	// ===============
	// =============== lastIndex-of white space
	// ===============
	/**
	 * @see #lastIndexOfWhitespace(int, int)
	 */
	public int lastIndexOfWhitespace() {
		return lastIndexOfWhitespace(length());
	}

	/**
	 * @see #lastIndexOfWhitespace(int, int)
	 */
	public int lastIndexOfWhitespace(int from) {
		return lastIndexOfWhitespace(from, 0);
	}

	/**
	 * @return last-index-of whitespace based on given range, or -1 if not found
	 *         <br>
	 *         <b>Note</b> Whitespaces are: the defined in
	 *         {@link Character#isWhitespace(int)}
	 */
	public int lastIndexOfWhitespace(int from, int to) {
		return lastIndexOfAny(WHITESPACES_ARRAY, from, to);
	}

	// ===============
	// =============== index-of line-feed
	// ===============

	/**
	 * @see #indexOfLinefeed(int, int)
	 */
	public int indexOfLinefeed() {
		return indexOfLinefeed(0);
	}

	/**
	 * @see #indexOfLinefeed(int, int)
	 */
	public int indexOfLinefeed(int from) {
		return indexOfLinefeed(from, length());
	}

	/**
	 * @return index-of linefeed based on given range, or -1 if not found <br>
	 *         <b>Note</b> Linefeeds are: (\r), (\n) and (\r\n)
	 */
	public int indexOfLinefeed(int from, int to) {
		return indexOfAny(LINEFEEDS_ARRAY, from, to);
	}

	// ===============
	// =============== index-of by depth
	// ===============

	// ===============
	// =============== lastIndex-of line-feed
	// ===============

	/**
	 * @see #lastIndexOfLinefeed(int, int)
	 */
	public int lastIndexOfLinefeed() {
		return lastIndexOfLinefeed(length());
	}

	/**
	 * @see #lastIndexOfLinefeed(int, int)
	 */
	public int lastIndexOfLinefeed(int from) {
		return lastIndexOfLinefeed(from, 0);
	}

	/**
	 * @return last-index-of linefeed based on given range, or -1 if not found <br>
	 *         <b>Note</b> Linefeeds are: (\r), (\n) and (\r\n)
	 */
	public int lastIndexOfLinefeed(int from, int to) {
		return lastIndexOfAny(LINEFEEDS_ARRAY, from, to);
	}

	// ===============
	// =============== index-of by depth
	// ===============

	public int indexOfByDepth(int target, int from, int to, boolean ignoreCase, int blockDepth, char[] blockPrefix,
			char[] blockSuffix) {
		return indexOf(target, from, to, ignoreCase, CharsMatcher.byDepth.newMustEquals(blockDepth, blockPrefix,
				blockSuffix, Integer.MAX_VALUE, getSurrogatePairsSupport()));
	}

	public int indexOfByDepth(int target, int from, int to, boolean ignoreCase, int blockDepth, char[] blockPrefix,
			char[] blockSuffix, int blocksLimit) {
		return indexOf(target, from, to, ignoreCase, CharsMatcher.byDepth.newMustEquals(blockDepth, blockPrefix,
				blockSuffix, blocksLimit, getSurrogatePairsSupport()));
	}

	public int indexOfByDepth(int target, int from, int to, boolean ignoreCase, CharsMatcherByDepth m) {
		return indexOf(target, from, to, ignoreCase, m);
	}

	// =============== indexes-of by depth

	public int[] indexesOfByDepth(int target, int from, int to, boolean ignoreCase, int blockDepth, char[] blockPrefix,
			char[] blockSuffix) {
		return indexesOfByDepth(target, from, to, ignoreCase, blockDepth, blockPrefix, blockSuffix, Integer.MAX_VALUE);
	}

	public int[] indexesOfByDepth(int target, int from, int to, boolean ignoreCase, int blockDepth, char[] blockPrefix,
			char[] blockSuffix, int blocksLimit) {
		return indexesOfByDepth(target, from, to, ignoreCase, CharsMatcher.byDepth.newMustEquals(blockDepth,
				blockPrefix, blockSuffix, blocksLimit, getSurrogatePairsSupport()));
	}

	public int[] indexesOfByDepth(int target, int from, int to, boolean ignoreCase, CharsMatcherByDepth m) {
		List<Integer> l = new ArrayList<>();
		while ((from = indexOf(target, from, to, ignoreCase, m)) != -1) {
			l.add(from++);
		}
		return Lang.toPrimitive.ints(l);
	}

	// ===============
	// =============== contains code-point
	// ===============

	/**
	 * @see #contains(int, int, int, boolean)
	 */
	public boolean contains(int cp) {
		return contains(cp, 0);
	}

	/**
	 * @see #contains(int, int, int, boolean)
	 */
	public boolean contains(int cp, int from) {
		return contains(cp, from, length());
	}

	/**
	 * @see #contains(int, int, int, boolean)
	 */
	public boolean contains(int cp, int from, int to) {
		return contains(cp, from, to, iagc());
	}

	/**
	 * @see #indexOf(int, int, int, boolean, CharsMatcher)
	 */
	public boolean contains(int cp, int from, int to, boolean ignoreCase) {
		return indexOf(cp, from, to, ignoreCase) >= 0;
	}

	// ===============
	// =============== contains sequence
	// ===============

	/**
	 * @see #contains(CharSequence, int, int, boolean)
	 */
	public boolean contains(CharSequence target) {
		return contains(target, 0);
	}

	/**
	 * @see #contains(CharSequence, int, int, boolean)
	 */
	public boolean contains(CharSequence target, int from) {
		return contains(target, from, length());
	}

	/**
	 * @see #contains(CharSequence, int, int, boolean)
	 */
	public boolean contains(CharSequence target, int from, int to) {
		return contains(target, from, to, iagc());
	}

	/**
	 * @see #indexOf(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public boolean contains(CharSequence target, int from, int to, boolean ignoreCase) {
		return indexOf(target, from, to, ignoreCase) >= 0;
	}

	// ===============
	// =============== contains char-array
	// ===============

	/**
	 * @see #contains(char[], int, int, int, boolean)
	 */
	public boolean contains(char[] target, int targetLength) {
		return contains(target, targetLength, 0);
	}

	/**
	 * @see #contains(char[], int, int, int, boolean)
	 */
	public boolean contains(char[] target, int targetLength, int from) {
		return contains(target, targetLength, from, length());
	}

	/**
	 * @see #contains(char[], int, int, int, boolean)
	 */
	public boolean contains(char[] target, int targetLength, int from, int to) {
		return contains(target, targetLength, from, to, iagc());
	}

	/**
	 * @see #indexOf(char[], int, int, int, boolean, CharsMatcher)
	 */
	public boolean contains(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		return indexOf(target, targetLength, from, to, ignoreCase) >= 0;
	}

	// ===============
	// =============== index-of code-point if spc supported or index-of char
	// ===============
	/**
	 * @see #containsAny(int[], int, int, boolean)
	 */
	public boolean containsAny(int[] codepoints) {
		return containsAny(codepoints, 0);
	}

	/**
	 * @see #containsAny(int[], int, int, boolean)
	 */
	public boolean containsAny(int[] codepoints, int from) {
		return containsAny(codepoints, from, length());
	}

	/**
	 * @see #containsAny(int[], int, int, boolean)
	 */
	public boolean containsAny(int[] codepoints, int from, int to) {
		return containsAny(codepoints, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(int[], int, int, boolean, CharsMatcher)
	 */
	public boolean containsAny(int[] codepoints, int from, int to, boolean ignoreCase) {
		return indexOfAny(codepoints, from, to, ignoreCase) >= 0;
	}

	// ===============
	// =============== contains any code-point/char
	// ===============

	/**
	 * @see #containsAny(CharSequence, int, int, boolean)
	 */
	public boolean containsAny(CharSequence targets) {
		return containsAny(targets, 0);
	}

	/**
	 * @see #containsAny(CharSequence, int, int, boolean)
	 */
	public boolean containsAny(CharSequence targets, int from) {
		return containsAny(targets, from, length());
	}

	/**
	 * @see #containsAny(CharSequence, int, int, boolean)
	 */
	public boolean containsAny(CharSequence targets, int from, int to) {
		return containsAny(targets, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public boolean containsAny(CharSequence targets, int from, int to, boolean ignoreCase) {
		return indexOfAny(targets, from, to, ignoreCase) >= 0;
	}

	// ===============
	// =============== contains any code-point/char
	// ===============
	/**
	 * @see #containsAny(char[], int, int, int, boolean)
	 */
	public boolean containsAny(char[] target, int targetLength) {
		return containsAny(target, targetLength, 0);
	}

	/**
	 * @see #containsAny(char[], int, int, int, boolean)
	 */
	public boolean containsAny(char[] target, int targetLength, int from) {
		return containsAny(target, targetLength, from, length());
	}

	/**
	 * @see #containsAny(char[], int, int, int, boolean)
	 */
	public boolean containsAny(char[] target, int targetLength, int from, int to) {
		return containsAny(target, targetLength, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(char[], int, int, int, boolean, CharsMatcher)
	 */
	public boolean containsAny(char[] target, int targetLength, int from, int to, boolean ignoreCase) {
		return indexOfAny(target, targetLength, from, to, ignoreCase) >= 0;
	}

	// ===============
	// =============== contains any entire-sequence
	// ===============

	/**
	 * @see #containsAny(CharSequence[], int, int, boolean)
	 */
	public boolean containsAny(CharSequence[] targets) {
		return containsAny(targets, 0);
	}

	/**
	 * @see #containsAny(CharSequence[], int, int, boolean)
	 */
	public boolean containsAny(CharSequence[] targets, int from) {
		return containsAny(targets, from, length());
	}

	/**
	 * @see #containsAny(CharSequence[], int, int, boolean)
	 */
	public boolean containsAny(CharSequence[] targets, int from, int to) {
		return containsAny(targets, from, to, iagc());
	}

	/**
	 * @see #indexOfAny(CharSequence[], int, int, boolean, CharsMatcher)
	 */
	public boolean containsAny(CharSequence[] targets, int from, int to, boolean ignoreCase) {
		return indexOfAny(targets, from, to, ignoreCase) >= 0;
	}

	// ===============
	// =============== contains linefeed
	// ===============

	/**
	 * @see #containsLinefeed(int, int)
	 */
	public boolean containsLinefeeds() {
		return containsLinefeeds(0);
	}

	/**
	 * @see #containsLinefeed(int, int)
	 */
	public boolean containsLinefeeds(int from) {
		return containsLinefeeds(from, length());
	}

	/**
	 * @see #indexOfLinefeed(CharSequence[], int, int, boolean)
	 */
	public boolean containsLinefeeds(int from, int to) {
		return indexOfLinefeed(from, to) >= 0;
	}

	// ===============
	// =============== contains whitespace
	// ===============

	/**
	 * @see #containsWhitespace(int, int)
	 */
	public boolean containsWhitespace() {
		return containsWhitespace(0);
	}

	/**
	 * @see #containsWhitespace(int, int)
	 */
	public boolean containsWhitespace(int from) {
		return containsWhitespace(from, length());
	}

	/**
	 * @see #indexOfWhitespace(CharSequence[], int, int, boolean)
	 */
	public boolean containsWhitespace(int from, int to) {
		return indexOfWhitespace(from, to) >= 0;
	}

	// ===============
	// =============== contains leftover surrogates
	// ===============

	/**
	 * #see {@link #indexOfLeftoverSurrogate(int, int)}
	 */
	public boolean containsLeftoverSurrogate() {
		return containsLeftoverSurrogate(0);
	}

	/**
	 * #see {@link #indexOfLeftoverSurrogate(int, int)}
	 */
	public boolean containsLeftoverSurrogate(int from) {
		return containsLeftoverSurrogate(from, length());
	}

	/**
	 * #see {@link #indexOfLeftoverSurrogate(int, int)}
	 */
	public boolean containsLeftoverSurrogate(int from, int to) {
		return indexOfLeftoverSurrogate(from, to) > Lang.constant.INDEX_NOT_FOUND;
	}

	// ===============
	// =============== starts/ends with
	// ===============

	/**
	 * @see #startsWith(char[], int, int, boolean)
	 */
	public boolean startsWith(CharSequence target) {
		return startsWith(target, 0);
	}

	/**
	 * @see #startsWith(char[], int, int, boolean)
	 */
	public boolean startsWith(CharSequence target, int offset) {
		return startsWith(target, offset, iagc());
	}

	/**
	 * @see #startsWith(char[], int, int, boolean)
	 */
	public boolean startsWith(CharSequence target, int offset, boolean ignoreCase) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return startsWith(tarr, tlen, offset, ignoreCase);
	}

	/**
	 * @see #startsWith(char[], int, int, boolean)
	 */
	public boolean startsWith(char[] target, int targetLength) {
		return startsWith(target, targetLength, 0);
	}

	/**
	 * @see #startsWith(char[], int, int, boolean)
	 */
	public boolean startsWith(char[] target, int targetLength, int offset) {
		return startsWith(target, targetLength, offset, iagc());
	}

	/**
	 * @param offset inclusive forward offset
	 */
	public boolean startsWith(char[] target, int targetLength, int offset, boolean ignoreCase) {
		int len = length();
		if (target == null || len == 0) {
			return false;
		}
		int innerlen = lengthActual();
		if ((offset < 0) || (offset > innerlen - targetLength)) {
			return false;
		}
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		offset = sps.reindex(arr, innerlen, offset);
		// ---------------------
		return Lang.chararray.startsWith(arr, innerlen, offset, target, targetLength, ignoreCase);
	}

	/**
	 * @see #endsWith(CharSequence, int, boolean)
	 */
	public boolean endsWith(CharSequence target) {
		return endsWith(target, length());
	}

	/**
	 * @see #endsWith(CharSequence, int, boolean)
	 */
	public boolean endsWith(CharSequence target, int offset) {
		return endsWith(target, offset, iagc());
	}

	/**
	 * @param offset backward offset
	 */
	public boolean endsWith(CharSequence target, int offset, boolean ignoreCase) {
		char[] tarr = null;
		int tlen = 0;
		if (target instanceof Chars) {
			Chars c = (Chars) target;
			tarr = c.unsafe();
			tlen = c.lengthActual();
		} else if (target != null) {
			tarr = target.toString().toCharArray();
			tlen = target.length();
		}
		return endsWith(tarr, tlen, offset, ignoreCase);
	}

	/**
	 * @see #endsWith(char[], int, int, boolean)
	 */
	public boolean endsWith(char[] target, int targetLength) {
		return endsWith(target, targetLength, length());
	}

	/**
	 * @see #endsWith(char[], int, int, boolean)
	 */
	public boolean endsWith(char[] target, int targetLength, int offset) {
		return endsWith(target, targetLength, offset, iagc());
	}

	/**
	 * @param offset backward exclusive offset
	 */
	public boolean endsWith(char[] target, int targetLength, int offset, boolean ignoreCase) {
		int len = length();
		if (target == null || len == 0 || offset <= 0) {
			return false;
		}
		int innerlen = lengthActual();
		char[] arr = unsafe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ----------------------
		offset = sps.reindex(arr, innerlen, offset);
		// ---------------------
		return Lang.chararray.endsWith(arr, innerlen, offset, target, targetLength, ignoreCase);
	}

	// ===============
	// =============== slide, squash and step
	// ===============

	/**
	 * @see #squash(int, int)
	 */
	public Chars squash(int steps) {
		return squash(steps, Lang.constant.INDEX_NOT_FOUND);
	}

	/**
	 * Squash chars in steps-direction and fill the steps-opposite-direction gap by
	 * the given code-point<br>
	 * squash also equivalent to bitwise operators (shift-right and shift-left) in
	 * sequence representation<br>
	 * <br>
	 * e.g: codes.abdullah, steps = 2 and fill = '-'<br>
	 * result: --codes.abdull, if steps = -2, results: des.abdullah--
	 * 
	 * @param fill code-point to fillup the gap, if 0 (null) will shrink the
	 *             <b>length</b>, e.g: instead of: [des.abdullah--] will result
	 *             [des.abdullah]
	 */
	public Chars squash(int steps, int fill) {
		int len = length();
		if (len == 0) {
			return this;
		}

		CodepointSupport sps = getSurrogatePairsSupport();
		int fill_char_len = sps.lengthOf(fill);

		int innerlen = lengthActual();
		// src_squash represents the visual squash
		final int src_steps = steps;
		int flags = getFlags();
		int spc = spc();
		char[] arr = safe();

		// check if squash is positive and > len, or abs and check
		if (steps >= len || -steps >= len) {
			if (fill <= 0) {
				return clear();
			}

			int newinnerlen = len * fill_char_len;
			spc = fill_char_len == 2 ? newinnerlen / 2 : 0;
			arr = Lang.capacity.ensure(arr, innerlen, newinnerlen);
			Lang.codepoint.fill.in(arr, innerlen, fill, fill + 1, newinnerlen, 0, false, sps);
			return assign(arr, newinnerlen, sps.isSupported() ? spc : 0, sps, getFlags());
		}

		// ---------------------------
		int backuplen = 0, backupFrom = 0, backupTo = 0, fillFrom = 0, fillTo = 0, injectBackupAt = 0, delspc = 0;

		if (steps > 0) {
			// convert squash to surrogate-level, e.g: H2Xcodes{-F4} if required is 2 in
			// visual-level, turn it to surrogate-level, which is 3
			steps = Lang.codepoint.convertFromVisualLevelToSurrogateLevel(arr, innerlen, innerlen, innerlen - steps,
					flags, sps);
			steps = innerlen - steps;

			// count surrogate-pairs in squash area: H2Xcodes{-F4}
			delspc = steps - src_steps;
			spc -= delspc;
			if (fill <= 0) {
				return assign(arr, innerlen - steps, sps.isSupported() ? spc : 0, sps, getFlags());
			}

			// set backup indexes: {H2Xcodes}-F4
			backupFrom = 0;
			backupTo = innerlen - steps;
			backuplen = backupTo;

			// remove squashed area from innerlen: H2Xcodes{-F4}
			innerlen = innerlen - (innerlen - backupTo);

			// how many addition slots is needed
			final int addition = (src_steps * fill_char_len);
			innerlen += addition;
			injectBackupAt = addition;
			fillFrom = 0;
			fillTo = injectBackupAt;

			// add new surrogates count
			spc += fill_char_len == 2 ? addition / 2 : 0;

		} else {
			// #Important: will turn squash to positive
			// convert squash to surrogate-level, e.g: {H2X}codes-F4 if required is 2 in
			// visual-level, turn it to surrogate-level, which is 3
			steps = Lang.codepoint.convertFromVisualLevelToSurrogateLevel(arr, innerlen, 0, -steps, flags, sps);

			// #Important: src_squash still negative, e.g: src = -2, squash = 3, delspc will
			// be 1
			// count surrogate-pairs in squash area: {H2X}codes-F4
			delspc = steps + src_steps;
			spc -= delspc;

			if (fill <= 0) {
				int newlen = innerlen - steps;
				if (newlen <= 0) {
					return clear();
				}
				Lang.copy.to.that(arr, arr.length, arr, arr.length, steps, steps + newlen, 0);
				return assign(arr, innerlen - steps, sps.isSupported() ? spc : 0, sps, getFlags());
			}

			// backupFrom = 0, backupTo: H2X{codes-F4}
			backupFrom = steps;
			backupTo = innerlen;
			backuplen = backupTo - backupFrom;

			// remove squashed area from innerlen: {H2X}codes-F4
			innerlen = innerlen - backupFrom;

			// how many addition slots is needed
			final int addition = (-src_steps * fill_char_len);
			innerlen += addition;

			injectBackupAt = 0;
			fillFrom = backuplen;
			fillTo = fillFrom + addition;

			// add new surrogates count
			spc += fill_char_len == 2 ? addition / 2 : 0;
		}

		arr = Lang.capacity.ensure(arr, innerlen, innerlen);
		arr = Lang.copy.to.that(arr, arr.length, arr, arr.length, backupFrom, backupFrom + backuplen, injectBackupAt);
		arr = Lang.codepoint.fill.in(arr, innerlen, fill, fill + 1, fillTo - fillFrom, fillFrom, false, sps);
		return assign(arr, innerlen, sps.isSupported() ? spc : 0, sps, getFlags());
	}

	/**
	 * @see #step(int, int, int)
	 */
	public Chars step(int from, int steps) {
		return step(from, lengthActual(), steps);
	}

	/**
	 * step a range of code-points from index to another<br>
	 * e.g: {codes}.abdullah, range: 0:5, steps: 5, results: .abdu{codes}llah
	 */
	public Chars step(int from, int to, int steps) {

		/*
		 * any var starts with _s means surrogate-level, otherwise visual-level
		 */

		int len = length();
		if (steps == 0 || len == 0 || from == 0 && to == len)
			return this;

		final int _sinnerlen = lengthActual();
		to = to > len ? len : to;
		Check.range(from, to, len);
		int flags = getFlags();
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ===================== visual-vars
		// assume: M6codes.{H2BD}ullahF4, from = 7, to 10, steps = 3
		final int src_steps = steps;
		// how many steps to reach the max on right side (positive steps):
		// M6codes.H2BD{ullahF4}
		int right_max = len - to;
		// how many steps to reach the max on left side (negative steps):
		// {M6codes.}H2BDullahF4, left_max will be always a negative number
		int left_max = -from;
		// length of chars to step: M6codes.{H2BD}ullahF4, range = 3
		int range = to - from;
		// how many positive/negative steps to return to same point (complete full
		// loop), note: transfer from edge to other consider as 1 step, e.g:
		// M6codes.ullahF4{H2BD}, 1 step to right results: {H2BD}M6codes.ullahF4, and
		// this why we add 1 step more below for complete loop
		int full_loop = (len - range) + 1;
		steps = src_steps % full_loop;
		// convert steps if beyond max and turn it into opposite direction, e.g:
		// M6codes.ullahF4{H2BD}, 1 step to right equals to -13 steps to left
		steps = Lang.codepoint.restep(src_steps, steps, right_max, left_max);
		// =====================

		// --------------
		// --------------
		// --------------
		int _sleft_pairs = sps.extendablePairsCount(arr, _sinnerlen, 0, from);
		int _sfrom = from + _sleft_pairs;
		int _sto = to + _sleft_pairs;
		int _smiddle_pairs = sps.extendablePairsCount(arr, _sinnerlen, _sfrom, _sto);
		_sto += _smiddle_pairs;
		// --------------
		// --------------
		// --------------

		int _sleft_max = -_sfrom;
		int _srange = _sto - _sfrom;

		// ---------------
		if (steps == 0) {
			return this;
		}

		int displaceFrom, displaceTo, displaceRange, injectDisplacedAt, injectBackupAt;

		if (steps > 0) {
			displaceFrom = _sto;
			displaceTo = Lang.codepoint.convertFromVisualLevelToSurrogateLevel(arr, _sinnerlen, _sto, _sto + steps,
					flags, sps);
			displaceRange = displaceTo - displaceFrom;
			injectDisplacedAt = _sfrom;
			injectBackupAt = _sfrom + displaceRange;
		} else {
			displaceFrom = Lang.codepoint.convertFromVisualLevelToSurrogateLevel(arr, _sinnerlen, _sfrom,
					steps - _sleft_max, flags, sps);
			displaceTo = _sfrom;
			displaceRange = displaceTo - displaceFrom;
			injectDisplacedAt = (displaceTo - displaceRange) + _srange;
			injectBackupAt = displaceFrom;
		}
		arr = Lang.capacity.ensure(arr, _sinnerlen, _srange + _sinnerlen);
		// backup
		Lang.copy.to.that(arr, arr.length, arr, arr.length, _sfrom, _sfrom + _srange, _sinnerlen);
		// move
		Lang.copy.to.that(arr, arr.length, arr, arr.length, displaceFrom, displaceFrom + displaceRange,
				injectDisplacedAt);
		// Lang.codepoint.inject
		Lang.copy.to.that(arr, arr.length, arr, arr.length, _sinnerlen, _sinnerlen + _srange, injectBackupAt);
		return assign(arr, _sinnerlen, spc(), sps, getFlags());
	}

	/**
	 * Slide the entire sequence<br>
	 * e.g: codes.abdullah, steps = -3, results: es.abdullahcod
	 */
	public Chars slide(int steps) {
		int len = length();
		if (len == 0 || steps == 0 || steps == len)
			return this;

		steps = steps % len;

		if (steps == 0)
			return this;
		CodepointSupport sps = getSurrogatePairsSupport();
		int flags = getFlags();
		int innerlen = lengthActual();
		char[] arr = safe();
		int fromLeft = 0, toLeft = 0, fromRight = 0, toRight = 0, leftLen, rightLen;
		if (steps > 0) {
			// e.g, steps = 3, right side is -> H2Xcodes{-F4}, and left is {H2Xcodes}-F4
			fromRight = Lang.codepoint.convertFromVisualLevelToSurrogateLevel(arr, innerlen, innerlen, innerlen - steps,
					flags, sps);
			toRight = innerlen;
			fromLeft = 0;
			toLeft = fromRight;
		} else {
			// e.g, steps = -3, right side is -> H2Xc{odes-F4}, and left is {H2Xc}odes-F4
			fromLeft = 0;
			toLeft = Lang.codepoint.convertFromVisualLevelToSurrogateLevel(arr, innerlen, 0, -steps, flags, sps);
			fromRight = toLeft;
			toRight = innerlen;
		}
		rightLen = toRight - fromRight;
		leftLen = toLeft - fromLeft;

		arr = Lang.capacity.ensure(arr, innerlen, leftLen + innerlen);

		// backup left side
		// [{H2Xcode}s-F4] -> [H2Xcodes-F4]H2Xcode
		Lang.copy.to.that(arr, arr.length, arr, arr.length, fromLeft, fromLeft + leftLen, innerlen);
		// displace right side to left side
		// [H2Xcode{s-F4}]H2Xcode -> [{s-F4}odes-F4]H2Xcode
		Lang.copy.to.that(arr, arr.length, arr, arr.length, fromRight, fromRight + rightLen, fromLeft);
		// insert backup to right side
		// [s-F4odes-F4]{H2Xcode} -> [s-F4{H2Xcode}]H2Xcode
		Lang.copy.to.that(arr, arr.length, arr, arr.length, innerlen, innerlen + leftLen, rightLen);
		return assign(arr, innerlen, spc(), sps, getFlags());
	}

	// ===============
	// =============== keep only
	// ===============

	/**
	 * keep only predicated code-points, the first argument of given
	 * {@link BiPredicate} represent the index of the code-point in the original
	 * instance, and the second represent the code-point to test<br>
	 * 
	 * @return scan and keep only predicated, the entire sequence will be cleared,
	 *         return empty sequence if no results collected
	 */
	public Chars keep(int from, int to, BiPredicate<Integer, Integer> bp) {
		int len = length();
		if (len == 0) {
			return this;
		}
		char[] arr = unsafe();
		int innerlen = lengthActual();
		to = to > len ? len : to;
		Check.range(from, to);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ------------------
		int cp = 0, rangelen = to - from;
		List<Integer> l = new ArrayList<Integer>();
		for (int i = from; i < to; i++) {
			cp = sps.getCodepoint(arr, rangelen, i);
			if (bp.test(i, cp)) {
				l.add(cp);
			}
			i += sps.isSupported() && !sps.isBmp(cp) ? 1 : 0;
		}
		if (l.isEmpty()) {
			return of();
		}
		return clear().appendCodePoints(Lang.toPrimitive.ints(l));
	}

	/**
	 * @see #keepDigits(int, int, int)
	 */
	public Chars keepDigits() {
		return keepDigits(10);
	}

	/**
	 * @see #keepDigits(int, int, int)
	 */
	public Chars keepDigits(int radix) {
		return keepDigits(radix, 0);
	}

	/**
	 * @see #keepDigits(int, int, int)
	 */
	public Chars keepDigits(int radix, int from) {
		return keepDigits(radix, from, length());
	}

	/**
	 * search for digits based on given range and radix, clean the entire sequence
	 * and assign the result, else assign '0' if no results found
	 * 
	 * @see #keep(int, int, BiPredicate)
	 * @see Character#digit(int, int) <br>
	 *      <b>default</b> radix = 10
	 */
	public Chars keepDigits(int radix, int from, int to) {
		Chars c = keep(from, to, new BiPredicate<Integer, Integer>() {
			@Override
			public boolean test(Integer index, Integer cp) {
				return Character.digit(cp, radix) != -1;
			}
		});
		return c.isEmpty() ? c.appendCodePoint('0') : c;
	}

	// ===============
	// =============== indent
	// ===============

	/**
	 * @see #indentByTabs(int, int, boolean)
	 */
	public Chars indentByTabs() {
		return indentByTabs(' ');
	}

	/**
	 * <br>
	 * <b>default</b> forEachCodePoint: 0xA (linefeed)
	 * 
	 * @see #indentByTabs(int, int, boolean)
	 */
	public Chars indentByTabs(int separatorCodePoint) {
		return indentByTabs(separatorCodePoint, '\n');
	}

	/**
	 * <br>
	 * <b>default</b> organize: true
	 * 
	 * @see #indentByTabs(int, int, boolean)
	 */
	public Chars indentByTabs(int separatorCodePoint, int forEachCodePoint) {
		return indentByTabs(separatorCodePoint, forEachCodePoint, true);
	}

	/**
	 * e.g: Java is a class-based<b>\n</b>object-oriented<b>\n</b>programming
	 * language that is<b>\n</b>designed to have as few<b>\n</b>implementation
	 * dependencies<b>\n</b>as possible<br>
	 * <br>
	 * <b>separatorCodePoint</b> = ' '<br>
	 * <b>forEachCodePoint</b> = '\n'<br>
	 * <b>organize</b> = true<br>
	 * Output:<br>
	 * 
	 * 
	 * 
	 * <pre>
	 * Java		is		a		class-based
	 * object-oriented
	 * programming	language	that		is
	 * designed	to		have		as		few
	 * implementation	dependencies
	 * as		possible
	 * </pre>
	 * 
	 * <br>
	 * <b>default</b> separatorCodePoint: 0x20 (space)
	 */
	public Chars indentByTabs(int separatorCodePoint, int forEachCodePoint, boolean organize) {
		if (isEmpty()) {
			return this;
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		Check.codePoint(separatorCodePoint, sps);
		Check.codePoint(forEachCodePoint, sps);

		if (!organize) {
			return replaceAll(separatorCodePoint, '\t');
		}

		// final int separatorCodePoint = ' ', forEachCodePoint = '\n';
		/*
		 * This tool will use to '\n' split the text into lines, and will do a scan
		 * trough lines, words will be indexed just like in columns, so first wordindex
		 * in line 0 is wordindex 0 and first word in line 1 is wordindex 0, and so on.
		 * Each Two words in one line that been separated by a space will be turned into
		 * a one or more of tabs with some organization for batter looking. Each
		 * detected space-index will be referred as (begin) inclusively, and (end)
		 * exclusively. Since we will scan per wordindex, for each wordindex we will
		 * look for the longest word-length to represent the (min), which means the
		 * minimum-requirement amount of chars can be used with other lines for the same
		 * wordindex, e.g: line=0, wordindex=0 [codes], and for line=1 [PYTHON_LOVE],
		 * line=1 has longest word-length (11 chars), this means the space after line=0
		 * wordindex=0 needs to push the word after it by at less a representation of 11
		 * chars (including the [codes] chars), so the (headsize) of [codes] is the
		 * length of it which is 5, missing 6 to reach 11, so if we add 1 tab, we will
		 * have only a representation of 8 chars because by default consoles will adjust
		 * the missing part of a tab and will consider the previous chars as part of it,
		 * so adding 1 tab to 5 chars means we are adding only 3 chars to complete full
		 * tab, this means we are only fixing the (brokensize), so (headsize) is the
		 * word-length, and (borkensize) is how many chars more to complete a full tab.
		 * Now 8 is below 11, so we need another tab to achieve the minimum-requirement,
		 * adding another tab will fix it. Now we fixed the line=0 wordindex=0, time to
		 * fix line=1 wordindex 1, and again the (headsize) of it is 11, means the
		 * (brokensize) is 5 to complete full tab, we will fix it by adding a tab, and
		 * check if not within the minimum-requirement, it will rerpesent 16 chars, so
		 * fixed and organized. The (min) will be used for same wordindex but for all
		 * lines
		 */

		int begins = 0, ends = 0, min = 0, works = -1, currentsize = 0, brokensize = 0;
		Chars[] lines = newClone().toMutable().splitAsChars(sps.toString(forEachCodePoint));
		// after each fix, we don't need to rescan each line from beginning, so we will
		// store the offset of each line
		int[] offsets = new int[lines.length];
		if (lines.length == 1) {
			return lines[0].deleteDuplicates(' ').replaceAll(' ', '\t');
		}

		// this loop represent wordindex loop (through 1 column loop)
		while (true) {
			// each 1 (or sequence) space represents 1 work, if works == 0 means no more
			// spaces could be found
			if (works == 0) {
				break;
			}
			works = 0;
			min = 0;
			for (int i = 0; i < lines.length; i++) {
				// if an offset been set to -1, means we've reached the end of the line belongs
				// to it and no need to look into it any more
				if (offsets[i] == -1) {
					continue;
				}

				Chars line = lines[i];
				begins = line.indexOf(separatorCodePoint, offsets[i]);
				// if reached end of a line
				if (begins == -1) {
					// get the length of last word, if larger then min, consider it as min and set
					// the offset to -1 to skip working with this line
					currentsize = line.length() - offsets[i];
					if (currentsize > min) {
						min = currentsize;
						offsets[i] = -1;
					}
					// if > min or not, no need for this line, so continue
					continue;
				}
				// if current word length is larger then min, consider it as min
				currentsize = begins - offsets[i];
				if (currentsize > min) {
					min = currentsize;
				}
				ends = line.indexOfEnd(separatorCodePoint, offsets[i]);
				if (ends == -1) {
					// means current line has no more seps, skip it
					continue;
				}
				// caught a work to be fixed
				works++;
			}

			// if min equals 8 or 16 ..etc, means the we have non-broken headsize, and we
			// can't make any tabs for that kind of full-headsize, so this kind of head will
			// be stick to next word, e.g: [abcdefgh 1234 -> abcdefgh1234] to fix this we
			// will add 1 more to min to break any full-headsize in this line or other lines
			// for current wordindex, e.g 8, will make it 9, now every headsize below 8
			// chars will be fixed with 2 tabs, which means 16 chars, and every
			// full-headsize(8) will be fixed with 1, which means 16 chars as well
			if (min % 8 == 0) {
				min++;
			}

			for (int i = 0; i < lines.length; i++) {
				Chars line = lines[i];
				if (offsets[i] == -1) {
					continue;
				}
				begins = line.indexOf(separatorCodePoint, offsets[i]);
				ends = line.indexOfEnd(separatorCodePoint, offsets[i]);
				if (ends == -1) {
					continue;
				}
				// find current wordindex headize and brokensize
				currentsize = begins - offsets[i];
				brokensize = Digits.ints.headMissing(currentsize, 8);

				// e.g: headsize = 2, brokensize = 6, and min = 11, to fix his head correctly,
				// will consider that we have only the brokensize, and will find tabs-count
				// below, so for 2 we will get 1 tab, now 1 tab equals 6 chars (the borkensize),
				// we still below the min-requirement, so will check here if we turn this head
				// into full-headsize(8) and still below the min(11), this means the head is
				// fixed and no need to look to it any more. the missing part is 3 chars to
				// reach min, so best way is to say fixedhead is equals to min, now headsize is
				// 11, missing 5, this will be the new borkensize
				int currentFixedhead = brokensize;
				if (currentsize + brokensize < min) {
					currentFixedhead = min;
				}

				// if we got fixedhead equals 11, tabsCount will return it as 2 tabs
				int tabscount = currentFixedhead == 0 ? 0 : Digits.ints.headsCount(currentFixedhead, 8);
				// if headsize == 8 or 16 ..etc, brokensize will be 0, so we already have
				// full-headsize and we must drop it from tabs count
				if (brokensize == 0 && tabscount != 0) {
					tabscount--;
				}
				// delete range of spaces and insert repeated-tabs
				line.deleteRange(begins, ends);
				line.repeat('\t', tabscount, begins);
				offsets[i] += (tabscount + currentsize);

			}
			// wordindex++;
		}
		Chars line = lines[0];
		for (int i = 1; i < lines.length; i++) {
			line.appendCodePoint(forEachCodePoint).append(lines[i]);
		}
		if (isImmutable()) {
			return line.toImmutable();
		}
		Chars ac = (Chars) line;
		return assign(ac.unsafe(), ac.lengthActual(), ac.spc(), ac.getSurrogatePairsSupport(), ac.getFlags());
	}

	/**
	 * @see #indent(int, int, int)
	 */
	public Chars indent() {
		return indent(' ');
	}

	/**
	 * @see #indent(int, int, int)
	 */
	public Chars indent(int separatorCodePoint) {
		return indent(separatorCodePoint, '\n');
	}

	/**
	 * @see #indent(int, int, int)
	 */
	public Chars indent(int separatorCodePoint, int forEachCodePoint) {
		return indent(separatorCodePoint, forEachCodePoint, -1);
	}

	/**
	 * e.g: Java is a class-based<b>\n</b>object-oriented<b>\n</b>programming
	 * language that is<b>\n</b>designed to have as few<b>\n</b>implementation
	 * dependencies<b>\n</b>as possible<br>
	 * <br>
	 * <b>separatorCodePoint</b> = ' '<br>
	 * <b>forEachCodePoint</b> = '\n'<br>
	 * <b>replacementCodePoint</b> = '-'<br>
	 * Output:<br>
	 * 
	 * 
	 * <pre>
	 * Java-----------is-----------a----class-based
	 * object-oriented
	 * programming----language-----that-is
	 * designed-------to-----------have-as----------few
	 * implementation-dependencies
	 * as-------------possible
	 * </pre>
	 * 
	 * @param replacementCodePoint -1 to skip <br>
	 *                             <b>default</b> replacementCodePoint: -1 <br>
	 *                             <b>default</b> separatorCodePoint: 32 <br>
	 *                             <b>default</b> replacementCodePoint: \n
	 */
	public Chars indent(int separatorCodePoint, int forEachCodePoint, int replacementCodePoint) {
		if (isEmpty()) {
			return this;
		}
		CodepointSupport sps = getSurrogatePairsSupport();
		Check.codePoint(separatorCodePoint, sps);
		Check.codePoint(forEachCodePoint, sps);
		Check.codePoint(replacementCodePoint, sps);
		// make sure not below -1
		replacementCodePoint = replacementCodePoint < -1 ? -1 : replacementCodePoint;
		// if both are same, no need for replacement job
		if (replacementCodePoint == separatorCodePoint) {
			replacementCodePoint = -1;
		}

		// begins: index-of sep, e.g: codes{ } abdullah
		int begins = 0,
				// ends: index-of-end of sep, e.g: codes { }abdullah
				ends = 0,
				// sepOffset: whenever we fix lines by max, max will be become this offset, no
				// need to look from begain of line again
				sepOffset = 0,
				// max: a holder for ends which represent most far away sep compared to other
				// lines for current word-index, e.g: line1: [car-is-fast], line2:
				// [love-javaaa-ya], ends of line1 word-index 0 is 4, and for line2 word-index 1
				// is 5, so 5 will be held as max, next run (word-index 1 run), [car--is-fast],
				// [ilove-java-ya], 11 will be the max for line2 word-index 1
				max = 0,
				// min: is the minimum index that max should not be less-or-equal to, e.g:
				// [car-java], [a-b-c], first has 2 words, second has 3 words, after fixing them
				// in normal way, we will get
				// [car-java]
				// [a---b-c]
				// to fix this, we will limit the max of 3rd-word-index to the length of some
				// other line that may have bigger length and less words, and before using the
				// max, will assign min + 1 if max < min
				min = 0,
				// works: how many lines needs to fix, a line contains at less 1 sep consider as
				// work line
				works = -1;

		Chars[] lines = newClone().toMutable().splitAsChars(sps.toString(forEachCodePoint));
		if (lines.length == 0) {
			throw new IllegalArgumentException("invalid newLineCodePoint, can't split");
		} else if (lines.length == 1) {
			return lines[0].deleteDuplicates(' ');
		}
//		"2^15 = 32,768\n" +//13 
//		"2^7 = 128\n" + //9 + 4
//		"2^4 = 16\n" + //8 + 5 
//		"2^3 = 8";
//		int wordIndex = 0;
		while (true) {
			// since works will start with -1, 1 and 0 will break this
			// if works == 0, means detected last sep and fixed, no more lines to go
			// if works == 1, one line has 1 or more of seps, but no more lines to compare
			// with
			if (works == 1 || works == 0) {
				break;
			}

			// -----------------------------------
			// ----------- reset
			works = 0;
			sepOffset = max;
			max = -1;
			min = sepOffset;
			// -----------------------------------
			// ----------- find max
			for (int i = 0; i < lines.length; i++) {
				Chars line = lines[i];
				begins = line.indexOf(separatorCodePoint, sepOffset);
				// if no begins detected, this means: line has no seps at all, or no more seps
				// detected from current offset
				if (begins == -1) {
					// will hold the line.length as the min
					if (line.length() > min) {
						min = line.length();
					}
					continue;
				}
				if (begins > min) {
					// by default min will be equals to begins, unless we have special cases, will
					// be equals to line.length
					min = begins;
				}
				ends = line.indexOfEnd(separatorCodePoint, sepOffset);
				if (ends == -1) {
					// means current line has no more seps, skip it
					continue;
				}
				// caught a work to be fixed
				works++;
				if (ends > max) {
					// hold the largest ends to push all fixes based on it
					max = ends;
				}
			}
			// -----------------------------------
			// ----------- fix missing seps and apply replacement
			// special case, explained above
			if (max < min) {
				max = min + 1;
			}

			for (int i = 0; i < lines.length; i++) {
				Chars line = lines[i];
				begins = line.indexOf(separatorCodePoint, sepOffset);
				ends = line.indexOfEnd(separatorCodePoint, sepOffset);
				if (ends == -1) {
					continue;
				}

//				int size = ends - begins;
				// find how seps many missing
				int repeat = max - ends;
				if (replacementCodePoint != -1) {
					// if replacement is required, delete current found seps
					line.deleteRange(begins, ends);
					int len = (ends - begins);
					// increase the missing count
					repeat += len;
					ends -= len;
					line.repeat(replacementCodePoint, repeat, ends);
				} else {
					if (repeat != 0) {
						line.repeat(separatorCodePoint, repeat, ends);
					}
				}

			}
//			wordIndex++;
		}
		Chars line = lines[0];
		for (int i = 1; i < lines.length; i++) {
			line.appendCodePoint(forEachCodePoint).append(lines[i]);
		}
		if (isImmutable()) {
			return line.toImmutable();
		}
		Chars ac = (Chars) line;
		return assign(ac.unsafe(), ac.lengthActual(), ac.spc(), ac.getSurrogatePairsSupport(), ac.getFlags());
	}

	// ===============
	// =============== align
	// ===============

	/**
	 * remove any existing linefeeds(\r and \n), and insert new once after each max
	 * 
	 * @see #repeatAfterEach(int, int, int, boolean, int, int)
	 */
	public Chars restrictLines(int max) {
		if (max > length()) {
			return this;
		} // TODO: ??
		return replaceAll("(?s)[\\n\\r]+", " ").repeatAfterEach('\n', max);
	}

	// ===============
	// =============== Character class methods
	// ===============

	/**
	 * @see StringBuilder#offsetByCodePoints(int, int)
	 * @see Character#offsetByCodePointsImpl
	 */
	public int offsetByCodePoints(int index, int codePointOffset) {
		Check.index(index, length());
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ==================
		index = sps.reindex(arr, innerlen, index);
		// ==================
		return Lang.chararray.offsetByCodePoints(arr, 0, innerlen, index, codePointOffset, sps);
	}

	/**
	 * @see Character#getName(int)
	 */
	public CharSequence getNameAt(int index) {
		ensureNotEmpty();
		return Character.getName(codePointAt(index));
	}

	/**
	 * @see Character#highSurrogate(int)
	 */
	public char highSurrogateAt(int index) {
		return getSurrogatePairsSupport().toHigh(codePointAt(index));
	}

	/**
	 * @see Character#lowSurrogate(int)
	 */
	public char lowSurrogateAt(int index) {
		return getSurrogatePairsSupport().toLow(codePointAt(index));
	}

	/**
	 * @see Character#isBmpCodePoint(int)
	 */
	public boolean isBmpCodePointAt(int index) {
		return getSurrogatePairsSupport().isBmp(codePointAt(index));
	}

	/**
	 * @see Character#toChars(int, char[], int)
	 */
	public int toCharArrayAt(int index, char[] buf, int insertAt) {
		return getSurrogatePairsSupport().toCharArray(codePointAt(index), buf, buf.length, insertAt);
	}

	/**
	 * @see Character#toChars(int)
	 */
	public char[] toCharArrayAt(int index) {
		return getSurrogatePairsSupport().toCharArray(codePointAt(index));
	}

	/**
	 * @see Character#isDigit(int)
	 */
	public boolean isDigitAt(int index) {
		return Character.isDigit(codePointAt(index));
	}

	/**
	 * @see Character#isSurrogate(char)
	 */
	public boolean isSurrogateAt(int index) {
		return getSurrogatePairsSupport().isHighOrLow(codePointAt(index));
	}

	public boolean isLowSurrogateAt(int index) {
		return getSurrogatePairsSupport().isLow(codePointAt(index));
	}

	/**
	 * @see Character#isHighSurrogate(char)
	 */
	public boolean isHighSurrogateAt(int index) {
		return getSurrogatePairsSupport().isHigh(codePointAt(index));
	}

	/**
	 * @see Character#isLetter(int)
	 */
	public boolean isLetterAt(int index) {
		return Character.isLetter(codePointAt(index));
	}

	/**
	 * @see Character#isLetterOrDigit(int)
	 */
	public boolean isLetterOrDigitAt(int index) {
		return Character.isLetterOrDigit(codePointAt(index));
	}

	/**
	 * @see Character#isSupplementaryCodePoint(int)
	 */
	public boolean isSupplementaryCodePointAt(int index) {
		return getSurrogatePairsSupport().isPair(codePointAt(index));
	}

	/**
	 * @see Character#isSurrogatePair(char, char)
	 */
	public boolean isSurrogatePairAt(int index) {
		return getSurrogatePairsSupport().isPair(codePointAt(index));
	}

	/**
	 * @see Character#isLowerCase(int)
	 */
	public boolean isLowerCaseAt(int index) {
		return Character.isLowerCase(codePointAt(index));
	}

	/**
	 * @see Character#isUpperCase(int)
	 */
	public boolean isUpperCaseAt(int index) {
		return Character.isUpperCase(codePointAt(index));
	}

	/**
	 * @see Character#isTitleCase(int)
	 */
	public boolean isTitleCaseAt(int index) {
		return Character.isTitleCase(codePointAt(index));
	}

	/**
	 * @see Character#toTitleCase(int)
	 */
	public Chars toTitleCaseAt(int index) {
		int c = codePointAt(index);
		return setCodePointAt(index, Character.toTitleCase(c));
	}

	/**
	 * @see Character#isDefined(int)
	 */
	public boolean isDefinedAt(int index) {
		return Character.isDefined(codePointAt(index));
	}

	/**
	 * @see Character#isAlphabetic(int)
	 */
	public boolean isAlphabeticAt(int index) {
		return Character.isAlphabetic(codePointAt(index));
	}

	/**
	 * @see Character#isIdeographic(int)
	 */
	public boolean isIdeographicAt(int index) {
		return Character.isIdeographic(codePointAt(index));
	}

	/**
	 * @see Character#isUnicodeIdentifierStart(int)
	 */
	public boolean isUnicodeIdentifierStartAt(int index) {
		return Character.isUnicodeIdentifierStart(codePointAt(index));
	}

	/**
	 * @see Character#isUnicodeIdentifierPart(int)
	 */
	public boolean isUnicodeIdentifierPartAt(int index) {
		return Character.isUnicodeIdentifierPart(codePointAt(index));
	}

	/**
	 * @see Character#isJavaIdentifierStart(int)
	 */
	public boolean isJavaIdentifierStartAt(int index) {
		return Character.isJavaIdentifierStart(codePointAt(index));
	}

	/**
	 * @see Character#isJavaIdentifierPart(int)
	 */
	public boolean isJavaIdentifierPartAt(int index) {
		return Character.isJavaIdentifierPart(codePointAt(index));
	}

	/**
	 * @see Character#isIdentifierIgnorable(int)
	 */
	public boolean isIdentifierIgnorableAt(int index) {
		return Character.isIdentifierIgnorable(codePointAt(index));
	}

	/**
	 * <br>
	 * <b>default</b> radix: 10
	 * 
	 * @see Character#digit(int, int)
	 */
	public int getDigitAt(int index) {
		return getDigitAt(index, 10);
	}

	/**
	 * @see Character#digit(int, int)
	 */
	public int getDigitAt(int index, int radix) {
		return Character.digit(codePointAt(index), radix);
	}

	/**
	 * @see Character#getNumericValue(int)
	 */
	public int getNumericValueAt(int index) {
		return Character.getNumericValue(codePointAt(index));
	}

	/**
	 * @see Character#isSpaceChar(int)
	 */
	public boolean isSpaceAt(int index) {
		return Character.isSpaceChar(codePointAt(index));
	}

	/**
	 * @see Character#isWhitespace(int)
	 */
	public boolean isWhitespaceAt(int index) {
		return Character.isWhitespace(codePointAt(index));
	}

	/**
	 * @see Character#isISOControl(int)
	 */
	public boolean isISOControlAt(int index) {
		return Character.isISOControl(codePointAt(index));
	}

	/**
	 * <br>
	 * <b>default</b> radix = 10
	 * 
	 * @see Character#forDigit(int, int)
	 */
	public char forDigit(int index) {
		return forDigit(index, 10);
	}

	/**
	 * @see Character#forDigit(int, int)
	 */
	public char forDigit(int index, int radix) {
		return Character.forDigit(getDigitAt(index, radix), radix);
	}

	/**
	 * @see Character#isMirrored(int)
	 */
	public boolean isMirroredAt(int index) {
		return Character.isMirrored(codePointAt(index));
	}

	/**
	 * @see Character#getDirectionality(int)
	 */
	public byte getDirectionality(int index) {
		return Character.getDirectionality(codePointAt(index));
	}

	/**
	 * @see Character#getType(int)
	 */
	public int getCategoryAt(int index) {
		return Character.getType(codePointAt(index));
	}

	/**
	 * @see Character#COMBINING_SPACING_MARK
	 */
	public boolean isCategoryCombiningSpacingMarkAt(int index) {
		return Character.getType(codePointAt(index)) == Character.COMBINING_SPACING_MARK;
	}

	/**
	 * @see Character#CONNECTOR_PUNCTUATION
	 */
	public boolean isCategoryConnectorPunctuationAt(int index) {
		return Character.getType(codePointAt(index)) == Character.CONNECTOR_PUNCTUATION;
	}

	/**
	 * @see Character#CONTROL
	 */
	public boolean isCategoryControlAt(int index) {
		return Character.getType(codePointAt(index)) == Character.CONTROL;
	}

	/**
	 * @see Character#CURRENCY_SYMBOL
	 */
	public boolean isCategoryCurrencySymbolAt(int index) {
		return Character.getType(codePointAt(index)) == Character.CURRENCY_SYMBOL;
	}

	/**
	 * @see Character#DASH_PUNCTUATION
	 */
	public boolean isCategoryDashPunctuationAt(int index) {
		return Character.getType(codePointAt(index)) == Character.DASH_PUNCTUATION;
	}

	/**
	 * @see Character#DECIMAL_DIGIT_NUMBER
	 */
	public boolean isCategoryDecimalDigitNumberAt(int index) {
		return Character.getType(codePointAt(index)) == Character.DECIMAL_DIGIT_NUMBER;
	}

	/**
	 * @see Character#ENCLOSING_MARK
	 */
	public boolean isCategoryEnclosingMarkAt(int index) {
		return Character.getType(codePointAt(index)) == Character.ENCLOSING_MARK;
	}

	/**
	 * @see Character#END_PUNCTUATION
	 */
	public boolean isCategoryEndPunctuationAt(int index) {
		return Character.getType(codePointAt(index)) == Character.END_PUNCTUATION;
	}

	/**
	 * @see Character#FINAL_QUOTE_PUNCTUATION
	 */
	public boolean isCategoryFinalQuotePunctuationAt(int index) {
		return Character.getType(codePointAt(index)) == Character.FINAL_QUOTE_PUNCTUATION;
	}

	/**
	 * @see Character#FORMAT
	 */
	public boolean isCategoryFormatAt(int index) {
		return Character.getType(codePointAt(index)) == Character.FORMAT;
	}

	/**
	 * @see Character#INITIAL_QUOTE_PUNCTUATION
	 */
	public boolean isCategoryInitialQuotePunctuationAt(int index) {
		return Character.getType(codePointAt(index)) == Character.INITIAL_QUOTE_PUNCTUATION;
	}

	/**
	 * @see Character#LETTER_NUMBER
	 */
	public boolean isCategoryLetterNumberAt(int index) {
		return Character.getType(codePointAt(index)) == Character.LETTER_NUMBER;
	}

	/**
	 * @see Character#LINE_SEPARATOR
	 */
	public boolean isCategoryLineSeparatorAt(int index) {
		return Character.getType(codePointAt(index)) == Character.LINE_SEPARATOR;
	}

	/**
	 * @see Character#LOWERCASE_LETTER
	 */
	public boolean isCategoryLowercaseLetterAt(int index) {
		return Character.getType(codePointAt(index)) == Character.LOWERCASE_LETTER;
	}

	/**
	 * @see Character#MATH_SYMBOL
	 */
	public boolean isCategoryMathSymbolAt(int index) {
		return Character.getType(codePointAt(index)) == Character.MATH_SYMBOL;
	}

	/**
	 * @see Character#MODIFIER_LETTER
	 */
	public boolean isCategoryModifierLetterAt(int index) {
		return Character.getType(codePointAt(index)) == Character.MODIFIER_LETTER;
	}

	/**
	 * @see Character#MODIFIER_SYMBOL
	 */
	public boolean isCategoryModifierSymbolAt(int index) {
		return Character.getType(codePointAt(index)) == Character.MODIFIER_SYMBOL;
	}

	/**
	 * @see Character#NON_SPACING_MARK
	 */
	public boolean isCategoryNonSpacingMarkAt(int index) {
		return Character.getType(codePointAt(index)) == Character.NON_SPACING_MARK;
	}

	/**
	 * @see Character#OTHER_LETTER
	 */
	public boolean isCategoryOtherLetterAt(int index) {
		return Character.getType(codePointAt(index)) == Character.OTHER_LETTER;
	}

	/**
	 * @see Character#OTHER_NUMBER
	 */
	public boolean isCategoryOtherNumberAt(int index) {
		return Character.getType(codePointAt(index)) == Character.OTHER_NUMBER;
	}

	/**
	 * @see Character#OTHER_PUNCTUATION
	 */
	public boolean isCategoryOtherPunctuationAt(int index) {
		return Character.getType(codePointAt(index)) == Character.OTHER_PUNCTUATION;
	}

	/**
	 * @see Character#OTHER_SYMBOL
	 */
	public boolean isCategoryOtherSymbolAt(int index) {
		return Character.getType(codePointAt(index)) == Character.OTHER_SYMBOL;
	}

	/**
	 * @see Character#PARAGRAPH_SEPARATOR
	 */
	public boolean isCategoryParagraphSeparatorAt(int index) {
		return Character.getType(codePointAt(index)) == Character.PARAGRAPH_SEPARATOR;
	}

	/**
	 * @see Character#PRIVATE_USE
	 */
	public boolean isCategoryPrivateUseAt(int index) {
		return Character.getType(codePointAt(index)) == Character.PRIVATE_USE;
	}

	/**
	 * @see Character#SPACE_SEPARATOR
	 */
	public boolean isCategorySpaceSeparatorAt(int index) {
		return Character.getType(codePointAt(index)) == Character.SPACE_SEPARATOR;
	}

	/**
	 * @see Character#START_PUNCTUATION
	 */
	public boolean isCategoryStartPunctuationAt(int index) {
		return Character.getType(codePointAt(index)) == Character.START_PUNCTUATION;
	}

	/**
	 * @see Character#SURROGATE
	 */
	public boolean isCategorySurrogateAt(int index) {
		return Character.getType(codePointAt(index)) == Character.SURROGATE;
	}

	/**
	 * @see Character#TITLECASE_LETTER
	 */
	public boolean isCategoryTitlecaseLetterAt(int index) {
		return Character.getType(codePointAt(index)) == Character.TITLECASE_LETTER;
	}

	/**
	 * @see Character#UNASSIGNED
	 */
	public boolean isCategoryUnassignedAt(int index) {
		return Character.getType(codePointAt(index)) == Character.UNASSIGNED;
	}

	/**
	 * @see Character#UPPERCASE_LETTER
	 */
	public boolean isCategoryUppercaseLetterAt(int index) {
		return Character.getType(codePointAt(index)) == Character.UPPERCASE_LETTER;
	}

	/**
	 * @see Character#DIRECTIONALITY_UNDEFINED
	 */
	public boolean isDirectionalityUndefinedAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_UNDEFINED;
	}

	/**
	 * @see Character#DIRECTIONALITY_LEFT_TO_RIGHT
	 */
	public boolean isDirectionalityLeftToRightAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_LEFT_TO_RIGHT;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT
	 */
	public boolean isDirectionalityRightToLeftAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC
	 */
	public boolean isDirectionalityRightToLeftArabicAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
	}

	/**
	 * @see Character#DIRECTIONALITY_EUROPEAN_NUMBER
	 */
	public boolean isDirectionalityEuropeanNumberAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_EUROPEAN_NUMBER;
	}

	/**
	 * @see Character#DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR
	 */
	public boolean isDirectionalityEuropeanNumberSeparatorAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR
	 */
	public boolean isDirectionalityEuropeanNumberTerminatorAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_ARABIC_NUMBER
	 */
	public boolean isDirectionalityArabicNumberAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_ARABIC_NUMBER;
	}

	/**
	 * @see Character#DIRECTIONALITY_COMMON_NUMBER_SEPARATOR
	 */
	public boolean isDirectionalityCommonNumberSeparatorAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_NONSPACING_MARK
	 */
	public boolean isDirectionalityNonspacingMarkAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_NONSPACING_MARK;
	}

	/**
	 * @see Character#DIRECTIONALITY_BOUNDARY_NEUTRAL
	 */
	public boolean isDirectionalityBoundaryNeutralAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_BOUNDARY_NEUTRAL;
	}

	/**
	 * @see Character#DIRECTIONALITY_PARAGRAPH_SEPARATOR
	 */
	public boolean isDirectionalityParagraphSeparatorAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_SEGMENT_SEPARATOR
	 */
	public boolean isDirectionalitySegmentSeparatorAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_SEGMENT_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_WHITESPACE
	 */
	public boolean isDirectionalityWhitespaceAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_WHITESPACE;
	}

	/**
	 * @see Character#DIRECTIONALITY_OTHER_NEUTRALS
	 */
	public boolean isDirectionalityOtherNeutralsAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_OTHER_NEUTRALS;
	}

	/**
	 * @see Character#DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING
	 */
	public boolean isDirectionalityLeftToRightEmbeddingAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING;
	}

	/**
	 * @see Character#DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE
	 */
	public boolean isDirectionalityLeftToRightOverrideAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING
	 */
	public boolean isDirectionalityRightToLeftEmbeddingAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE
	 */
	public boolean isDirectionalityRightToLeftOverrideAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE;
	}

	/**
	 * @see Character#DIRECTIONALITY_POP_DIRECTIONAL_FORMAT
	 */
	public boolean isDirectionalityPopDirectionalFormatAt(int index) {
		return Character.getDirectionality(codePointAt(index)) == Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT;
	}

	// ===============
	// =============== parse int
	// ===============

	public int parseInt() {
		return parseInt(10);
	}

	public int parseInt(int radix) {
		return parseInt(radix, 0);
	}

	public int parseInt(int radix, int from) {
		return parseInt(radix, from, length());
	}

	public int parseInt(int radix, int from, int to) {
		final int len = length();
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, innerlen, from, to);
		// ------------------
		return Digits.ints.parse(this, from, to, radix);
	}

	public long parseLong() {
		return parseLong(10);
	}

	public long parseLong(int radix) {
		return parseLong(radix, 0);
	}

	public long parseLong(int radix, int from) {
		return parseLong(radix, from, length());
	}

	public long parseLong(int radix, int from, int to) {
		final int len = length();
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, innerlen, from, to);
		// ------------------
		return Digits.longs.parse(this, from, to, radix);
	}

	// ===============
	// =============== is-valid-numeric
	// ===============

	/**
	 * @see #isValidNumeric(int, int, int)
	 */
	public boolean isValidNumeric() {
		return isValidNumeric(10);
	}

	/**
	 * @see #isValidNumeric(int, int, int)
	 */
	public boolean isValidNumeric(int radix) {
		return isValidNumeric(radix, 0);
	}

	/**
	 * @see #isValidNumeric(int, int, int)
	 */
	public boolean isValidNumeric(int radix, int from) {
		return isValidNumeric(radix, from, length());
	}

	/**
	 * validate numeric based on given radix and range
	 * 
	 * <br>
	 * <b>default</b>: radix = 10
	 */
	public boolean isValidNumeric(int radix, int from, int to) {
		final int len = length();
		if (from >= len) {
			return false;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] arr = unsafe();
		int innerlen = lengthActual();
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, innerlen, from, to);
		// ------------------
		return Lang.chararray.isValidNumeric(arr, innerlen, radix, from, to);
	}

	// ===============
	// =============== private helpers
	// ===============

	Chars changeCaseByRange(int from, int to, boolean upperCase, Locale locale) {
		int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		int diff = 0;
		char[] arr = safe();
		CodepointSupport sps = getSurrogatePairsSupport();
		if (from == 0 && to == len) {
			String sthis = new String(arr, 0, innerlen);
			sthis = upperCase ? sthis.toUpperCase(locale) : sthis.toLowerCase(locale);
			diff = sthis.length() - innerlen;
			arr = sthis.toString().toCharArray();
			return assign(arr, innerlen + diff, spc(), sps, getFlags());
		}

		// ------------------
		int disp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += disp;
		to += disp;
		disp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += disp;
		// ------------------

		String sub = new String(arr, from, to - from);
		String targetCase = upperCase ? sub.toUpperCase(locale) : sub.toLowerCase(locale);
		diff = targetCase.length() - sub.length();
		char[] tarr = targetCase.toString().toCharArray();
		if (diff <= 0) {
			if (diff < 0) {
				diff = -diff;
				Lang.shrink.at(arr, len, to - diff, diff);
			}
			arr = Lang.copy.to.that(tarr, tarr.length, arr, innerlen, 0, tarr.length, from);
		} else if (diff > 0) {
			arr = Lang.capacity.ensure(arr, innerlen, len + diff);
			arr = Lang.expand.at(arr, innerlen + diff, to, diff);
			arr = Lang.copy.to.that(tarr, tarr.length, arr, innerlen, 0, tarr.length, from);
		}
		return assign(arr, innerlen + diff, spc(), sps, getFlags());
	}

	int findMaxMinLengthByCodePoint(int separator, int from, int to, boolean ignoreCase, boolean findMax) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		int begins = from;
		int index = from;
		int max = 0, min = 0, length = 0;
		boolean firstTime = true;
		int spDisp = sps.isBmp(separator) ? 0 : 1;
		final int srcfrom = from;

		/*
		 * the work here is mixture of conversion from visual-level to actual-level e.g:
		 * F4codeF4H2bdullH2hF4jF4, the visual-length=17, actual-length=23,
		 * separator=F4, range (whole-text).
		 */
		// -------------------
		// - srcfrom: will be used to detect first sep, if given from pointing into a
		// sep for first loop, will be excluded, why? assume: //java/math, the min here
		// is 0, to detect it, first sep needs to be dismissed while comparing
		// - spDisp and fromDisp: are count of surrogate-pairs
		// - begins: is actual-level of a being of sequence
		// - from: is actual-level of offset to be used with index-of
		// - length: is actual-level of length of last-sequence
		// - index: is visual-level index of next separator
		// - min/max: are visual-level of min/max sequences been detected
		// - firstTime: will be used to assign min for first time as minimum detected
		// value, since initialized with 0, we can't look below that
		// -------------------
		// F4codeF4H2bdullH2hF4jF4
		// -------------------
		// first sequence: index of sep is zero, so from(2) = index(0) + 1 +
		// fromDisp(1),
		// why fromDisp contains 1? will, separator is supplementary so, spDisp will
		// hold 1 all time, and will be added to fromDisp every new loop
		// -------------------
		// second sequence: index(5), that a visual-level, to find length of
		// last-sequence
		// we need to displace by fromDisp(1), so the actual-level of length(4), max(4)
		// detected, min(4) detected as well, we don't have supplementary in this
		// sequence, but at less one sep was there, so spDisp will be added to fromDisp,
		// fromDisp(2), from(8) = index(5) + 1 + fromDisp(2), now it is clear how does
		// this work
		// -------------------
		// last sequence: only if last-sequence has length,
		// will compare, the reason is
		// for last sep, if exits at the end of line, next
		// sequence will be consider as length of 0, and this is wrong, so to avoid this
		// from
		// and if min =0, means the text has only one sequence, just assign
		// last detected length
		// -------------------
		while ((index = CharsLoop.INDEX_OF.codePoint(arr, innerlen, from, to, separator, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps)) != Lang.constant.INDEX_NOT_FOUND) {
			if (index > srcfrom && index < to) {
				length = (index + fromDisp) - begins;
				max = Math.max(max, length);
				if (firstTime) {
					min = max;
					firstTime = false;
				}
				min = Math.min(min, length);
			}
			fromDisp += sps.extendablePairsCount(arr, innerlen, from, index + fromDisp) + spDisp;
			from = index + 1 + fromDisp;
			begins = from;
		}

		fromDisp = sps.extendablePairsCount(arr, innerlen, begins, to);
		length = (to - fromDisp) - begins;
		// may be the min that been detected is 0, if true, don't touch it, otherwise,
		// only if min > 0 and length
		if (min > 0 && length > 0) {
			min = Math.min(min, length);
		}

		max = Math.max(max, length);
		return findMax ? max : min;
	}

	int findMaxMinLengthByCharArray(char[] separator, int separatorLength, int from, int to, boolean ignoreCase,
			boolean findMax) {
		int len = length();
		if (len == 0 || separator == null || from >= len || separatorLength == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		int innerlen = lengthActual();
		char[] arr = unsafe();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE);
		CodepointSupport sps = getSurrogatePairsSupport();
		// ------------------
		int fromDisp = sps.extendablePairsCount(arr, innerlen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = sps.extendablePairsCount(arr, innerlen, from, to);
		to += toDisp;
		// ------------------
		final int srcfrom = from;
		int begins = from;
		int index = from;
		int max = 0, min = 0, length = 0;
		boolean firstTime = true;
		int spDisp = separatorLength - 1;
		while ((index = CharsLoop.INDEX_OF.array(arr, innerlen, from, to, separator, separatorLength, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, sps)) != Lang.constant.INDEX_NOT_FOUND) {
			if (index > srcfrom && index < to) {
				length = (index + fromDisp) - begins;
				max = Math.max(max, length);
				if (firstTime) {
					min = max;
					firstTime = false;
				}
				min = Math.min(min, length);
			}
			fromDisp += sps.extendablePairsCount(arr, innerlen, from, index + fromDisp) + spDisp;
			from = index + 1 + fromDisp;
			begins = from;
		}
		fromDisp = sps.extendablePairsCount(arr, innerlen, begins, to);
		length = (to - fromDisp) - begins;
		if (min > 0 && length > 0) {
			min = Math.min(min, length);
		}
		max = Math.max(max, length);
		return findMax ? max : min;
	}

	/**
	 * trim left and right and assign results
	 */
	Chars trimBySide(boolean trimLeft, boolean trimRight) {
		int len = lengthActual();
		int right = len;
		int left = 0;
		char[] arr = safe();
		if (trimLeft)
			while ((left < right) && (arr[left] <= ' ')) {
				left++;
			}
		if (trimRight)
			while ((left < right) && (arr[right - 1] <= ' ')) {
				right--;
			}
		if (left == 0 && right == len) {
			return this;
		}
		// (len - right) = total deleted from right side
		// left = total deleted from left side
		len -= ((len - right) + left);
		System.arraycopy(arr, left, arr, 0, len);
		return assign(arr, len, spc(), getSurrogatePairsSupport(), getFlags());
	}

	int reflag(boolean b, int f) {
		return b ? flag(f) : unflag(f);
	}

	int flag(int f) {
		int flags = getFlags();
		return flags | f;
	}

	int unflag(int f) {
		int flags = getFlags();
		return flags & (flags ^ f);
	}

	boolean isFlagged(int f) {
		return Digits.ints.isFlagged(getFlags(), f);
	}

	void ensureNotEmpty() {
		if (isEmpty()) {
			throw new NoSuchElementException("sequence is empty");
		}
	}

	/**
	 * make sure the addition length is accommodatable and will not exceed
	 * {@link Lang#ARRAY_SAFE_CAPACITY}
	 * 
	 * @see Check#length(int)
	 */
	void ensureCanAccommodate(int additionLength) {
		Check.length(additionLength, 1, Lang.constant.ARRAY_SAFE_CAPACITY - length());
	}

//	int codePointAtIfSurrogatePairsSupported(char[] arr, int len, int i) {
//		if (!hspc()) {
//			return arr[i];
//		}
//		return CharsUtils.codePointAt(arr, len, i);
//	}

	// ===============
	// =============== static initializers
	// ===============

	/**
	 * @return new empty mutable instance
	 * @see Immutable#toImmutable()
	 */
	public static Chars of() {
		return new MutableChars(new char[Lang.constant.ARRAY_DEFAULT_CAPACITY], 0, 0, CodepointSupport.BMP, 0);
	}

	/**
	 * @return new mutable with given {@link Object}
	 * @see Object#toString()
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(Object obj) {
		return of().appendObject(obj);
	}

	/**
	 * @return new mutable with given {@link CharSequence}
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(CharSequence cs) {
		return of().append(cs);
	}

	/**
	 * @return new mutable with given array
	 * @see #ofCodePoints(int[])
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(char[] array) {
		return of(array, array.length);
	}

	/**
	 * @return new mutable with given array
	 * @see #ofCodePoints(int[])
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(char[] array, int arrayLength) {
		return of().append(array, arrayLength);
	}

	public static Chars of(byte[] b, Charset c) {
		return of().append(new String(b, c));
	}

	/**
	 * @return new mutable with given boolean
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(boolean b) {
		return of().append(b);
	}

	/**
	 * @return new mutable with given byte
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(byte n) {
		return of().append((int) n);
	}

	/**
	 * @return new mutable with given short
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(short n) {
		return of().append((int) n);
	}

	/**
	 * @return new mutable with given char
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(char ch) {
		return of().append(ch);
	}

	/**
	 * @return new mutable with given integer
	 * @see #ofCodePoint(int)
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(int n) {
		return of().append(n);
	}

	/**
	 * @return new mutable with given long
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(long n) {
		return of().append(n);
	}

	/**
	 * @return new mutable with given float
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(float n) {
		return of().append(n);
	}

	/**
	 * @return new mutable with given double
	 * @see Immutable#toImmutable()
	 */
	public static Chars of(double n) {
		return of().append(n);
	}

	/**
	 * @return new mutable with given code-point
	 * @see Immutable#toImmutable()
	 */
	public static Chars ofCodePoint(int cp) {
		return of().appendCodePoint(cp);
	}

	/**
	 * @return new mutable with given code-points
	 * @see Immutable#toImmutable()
	 */
	public static Chars ofCodePoints(int[] cps) {
		return of().appendCodePoints(cps);
	}

	// ----------------------------

	public static Chars joinAsLines(Object[] elements) {
		return joinObjects("\n", elements);
	}

	public static Chars joinObjects(Object delim, Object[] elements) {
		Chars c = of();
		if (delim == null || delim.equals("")) {
			for (int i = 0; i < elements.length; i++) {
				c = c.appendObject(elements[i]);
			}
			return c;
		}
		c = c.appendObject(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			c = c.appendObject(delim).appendObject(elements[i]);
		}
		return c;
	}

	public static <T> Chars joinArray(Object delim, T[] elements) {
		return joinObjects(delim, elements);
	}

	public static Chars join(Object delim, Iterable<?> it) {
		return join(delim, it.iterator());
	}

	public static Chars join(Object delim, Iterator<?> it) {
		Lang.emptyOrNull.requireNoNull(it);
		Chars c = of();
		it.hasNext();
		c.appendObject(it.next());
		while (it.hasNext()) {
			c.appendObject(delim).appendObject(it.next());
		}
		return c;
	}

	// ----------------------------

}
