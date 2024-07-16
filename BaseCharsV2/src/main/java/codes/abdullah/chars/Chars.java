package codes.abdullah.chars;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.function.BiPredicate;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.array.wrapper.codepoint.CodepointArray;
import codes.abdullah.digits.Digits;
import codes.abdullah.digits.java.JavaFloatingDecimal;
import codes.abdullah.project.Check;
import codes.abdullah.project.Endian;
import codes.abdullah.project.Immutable;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsLoop;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public abstract class Chars
		implements CharSequence, Serializable, Appendable, Comparable<CharSequence>, Immutable<Chars> {
	private static final long serialVersionUID = -6019552843442030931L;

	// ================
	// ================
	// ================

	boolean isFlagged(int f) {
		return (getFlags() & f) == f;
	}

	Chars reflag(int f, boolean b) {
		int flags = getFlags();
		return setFlags(b ? Digits.ints.flag(flags, f) : Digits.ints.unflag(flags, f));
	}

	Chars flag(int f) {
		return setFlags(getFlags() | f);
	}

	Chars unflag(int f) {
		return setFlags(getFlags() & (getFlags() ^ f));
	}

	public abstract int getFlags();

	public abstract Chars setFlags(int flags);

	@Override
	public int length() {
		return unsafe().length();
	}

	@Override
	public char charAt(int index) {
		return (char) unsafe().unsafe()[0];
	}

	// ================
	// ================ assign / new / safe / unsafe
	// ================

	abstract CodepointArray newCodepointArray(CharSequence cs);

	abstract CodepointArray newCodepointArray(CharArray ca);

	abstract CodepointArray newCodepointArray(char[] arr, int len);

	abstract CodepointArray newCodepointArray(char[] arr, int len, int spcount);

	public abstract Chars setPairsSupport(CodepointSupport cps);

	abstract CodepointArray safe();

	abstract CodepointArray unsafe();

	abstract Chars assign(CodepointArray cpa);

	abstract Chars newInstance();

	abstract Chars[] newArray(int len);

	abstract Chars newInstance(CharSequence cs);

	abstract Chars newInstance(CodepointArray cpa);

	public Chars assign(CharSequence cs) {
		return assign(newCodepointArray(cs));
	}

	public Chars setIgnoreCase(boolean b) {
		return assign(reflag(Lang.constant.FLAG_ALWAYS_IGNORE_CASE, b));
	}

	public abstract boolean isIgnoreCase();

	public static Chars of() {
		return new MutableChars(CodepointArray.of(), 0);
	}

	public static Chars of(CharSequence cs) {
		char[] arr = cs.toString().toCharArray();
		return new MutableChars(CodepointArray.of(arr, arr.length), 0);
	}

	// ================
	// ================ set
	// ================

	public Chars set(int index, int cp) {
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		Check.codePoint(cp, cps);
		char[] arr = cpa.safe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		// ==============
		index = cps.reindex(arr, alen, index);
		// ==============
		if (cps.isPair(cp) && !cps.isPair(arr, alen, index))
			arr = Lang.capacity.ensure(arr, alen, alen + 1);
		int newlen = Lang.codepoint.set(arr, alen, index, cp, cps);
		return assign(cpa.assign(arr, alen, spcount + (newlen - alen), cps));
	}

	public Chars set(int[] indexes, int cp) {
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		Check.codePoint(cp, cps);
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		char[] arr = cpa.safe();
		CharArray result = Lang.codepoint.setWithReindexing(arr, alen, indexes, cp, cps);
		spcount -= alen - result.length();
		return assign(cpa.assign(result.getArray(), result.length(), spcount, cps));
	}

	// ================
	// ================ get
	// ================

	public int getCodepointAt(int index) {
		CodepointArray cpa = unsafe();
		int alen = cpa.lengthActual();
		if (alen == 0)
			return 0;
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		// ================
		index = cps.reindex(arr, alen, index);
		// ================
		return cps.getCodepoint(arr, alen, index);
	}

	public int getFirstCodepoint() {
		return getCodepointAt(0);
	}

	public int getLastCodepoint() {
		return getCodepointAt(length());
	}

	public int getCodepointBefore(int index) {
		CodepointArray cpa = unsafe();
		int alen = cpa.lengthActual();
		if (alen == 0)
			return 0;
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		// ================
		index = cps.reindex(arr, alen, index);
		// ================
		return cps.getCodepointBackwardly(arr, alen, index);
	}

	// ================
	// ================ Appendable methods
	// ================

	// ================
	// ================ Comparable methods
	// ================

	@Override
	public int compareTo(CharSequence o) {
		return compareTo(o, isIgnoreCase());
	}

	public int compareTo(CharSequence o, boolean ignoreCase) {
		char[] arr = unsafe().unsafe();
		int innerlen = unsafe().lengthActual();
		int min = Math.min(innerlen, o.length());
		char c1;
		char c2;
		if (!ignoreCase) {
			int k = 0;
			while (k < min) {
				c1 = arr[k];
				c2 = o.charAt(k);
				if (c1 != c2) {
					return c1 - c2;
				}
				k++;
			}
		} else {
			for (int i = 0; i < min; i++) {
				c1 = arr[i];
				c2 = o.charAt(i);
				if (c1 != c2) {
					c1 = Character.toUpperCase(c1);
					c2 = Character.toUpperCase(c2);
					if (c1 != c2) {
						c1 = Character.toLowerCase(c1);
						c2 = Character.toLowerCase(c2);
						if (c1 != c2) {
							return c1 - c2;
						}
					}
				}
			}
		}
		return innerlen - o.length();

	}

	// ================
	// ================ is methods
	// ================

	public boolean isEmpty() {
		return length() == 0;
	}

	// ================
	// ================ count repeat
	// ================

	public int countRepeat(int target, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		return Lang.codepoint.count.ofRepeat(arr, alen, target, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
	}

	public int countRepeat(CharSequence target, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0 || target == null || target.length() == 0) {
			return 0;
		}
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, len, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		return Lang.chararray.count.ofRepeat(arr, alen, tarr, tlen, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
	}

	// ================
	// ================ count matches
	// ================

	public int countMatches(int target, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		return Lang.codepoint.count.of(arr, alen, target, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS, cps);
	}

	public int countMatches(CharSequence target, int from, int to, boolean ignoreCase) {
		int len = length();
		if (len == 0 || target == null || target.length() == 0) {
			return 0;
		}
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		return Lang.chararray.count.of(arr, alen, tarr, tlen, from, to, flags, fromDisp, CharsMatcher.MUST_EQUALS, cps);
	}

	// ================
	// ================ count occupied
	// ================

	public int countColumns(int from, int to, int previousColumns, int tabSize) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		return Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousColumns, cps);
	}

	// ===============
	// =============== insert
	// ===============

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

	public Chars insertNull(int offset) {
		final int size = 4;
		ensureCanAccommodate(size);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.safe();
		int alen = cpa.lengthActual();
		final int newlen = alen + size;
		// -------------------
		offset = cps.reindex(arr, alen, offset);
		// -------------------
		Check.insertIndex(offset, length());
		arr = Lang.capacity.ensure(arr, alen, newlen);
		Lang.expand.at(arr, alen, offset, size);
		arr[offset++] = 'n';
		arr[offset++] = 'u';
		arr[offset++] = 'l';
		arr[offset++] = 'l';
		return assign(cpa.assign(arr, newlen));
	}

	public Chars insertObject(int offset, Object obj) {
		if (obj == null) {
			return insertNull(offset);
		} else if (obj instanceof CharSequence) {
			return insert(offset, (CharSequence) obj);
		}
		return insert(offset, obj.toString());
	}

	public Chars insert(int offset, CharSequence cs) {
		char[] tarr = readOnlyArray(cs);
		int tlen = readOnlyArrayLength(cs);
		return insert(offset, tarr, tlen, 0, tlen);
	}

	public Chars insert(int offset, CharSequence cs, int from) {
		if (cs == null) {
			cs = "null";
		}
		return insert(offset, cs, from, cs.length());
	}

	public Chars insert(int offset, CharSequence cs, int from, int to) {
		if (cs == null) {
			cs = "null";
		}
		char[] tarr = readOnlyArray(cs);
		int tlen = readOnlyArrayLength(cs);
		int copyLen = to - from;
		return insert(offset, tarr, tlen, from, copyLen);
	}

	public Chars insert(int offset, char[] inj, int injlen, int copyOffset, int copyLen) {
		if (inj == null) {
			return insertNull(offset);
		} else if (injlen == 0 || copyLen == 0) {
			return this;
		}

		ensureCanAccommodate(copyLen);
		Check.insertIndex(offset, length());
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.safe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();

		// ------------------
		offset = cps.reindex(arr, alen, offset);
		// -------------------

		// turn copyLen to copyTo, both suppose to be in visual-level
		int copyTo = copyOffset + copyLen;
		// below, copyOffset, copyTo and copyLen will be in surrogate-level
		// ========================
		int spc_before = cps.extendablePairsCount(inj, injlen, 0, copyOffset);
		copyOffset += spc_before;
		copyTo += spc_before;
		int spc_between = cps.extendablePairsCount(inj, injlen, copyOffset, copyTo);
		copyTo += spc_between;
		// ========================
		// int disp_after = countSurrogatePairs(inj, inj.length, copyTo, inj.length);

		copyTo = copyTo > injlen ? injlen : copyTo;
		copyLen = copyTo - copyOffset;
		spcount += spc_between;

		Check.insertIndex(copyOffset + copyLen, inj.length);
		final int newLen = alen + copyLen;
		arr = Lang.capacity.ensure(arr, alen, newLen);
		arr = Lang.expand.at(arr, alen, offset, copyLen);
		arr = Lang.copy.to.that(inj, inj.length, arr, arr.length, copyOffset, copyOffset + copyLen, offset);
		return assign(cpa.assign(arr, newLen, spcount, cps));
	}

	public Chars insert(int offset, byte n) {
		return insert(offset, (int) n);
	}

	public Chars insert(int offset, short n) {
		return insert(offset, (int) n);
	}

	public Chars insert(int offset, boolean b) {
		return insert(offset, b ? "true" : "false");
	}

	public Chars insert(int offset, char ch) {
		return insertCodePoint(offset, ch);
	}

	public Chars insert(int offset, int n) {
		if (n == Integer.MIN_VALUE) {
			return insert(offset, "-2147483648");
		}
		final int radix = 10;
		final int nlen = Digits.ints.lengthOf(n, radix);
		ensureCanAccommodate(nlen);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.safe();
		int alen = cpa.lengthActual();
		final int newlen = alen + nlen;
		// -------------------
		offset = cps.reindex(arr, alen, offset);
		// -------------------
		Check.insertIndex(offset, length());
		arr = Lang.capacity.ensure(arr, alen, newlen);
		arr = Lang.expand.at(arr, alen, offset, nlen);
		Digits.ints.format(n, radix, arr, alen, offset + nlen);
		return assign(cpa.assign(arr, newlen));
	}

	public Chars insert(int offset, long n) {
		if (n == Long.MIN_VALUE) {
			return insert(offset, "-9223372036854775808");
		}
		final int radix = 10;
		final int nlen = Digits.longs.lengthOf(n, radix);
		ensureCanAccommodate(nlen);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.safe();
		int alen = cpa.lengthActual();
		final int newlen = alen + nlen;
		// -------------------
		offset = cps.reindex(arr, alen, offset);
		// -------------------
		Check.insertIndex(offset, length());
		arr = Lang.capacity.ensure(arr, alen, newlen);
		arr = Lang.expand.at(arr, alen, offset, nlen);
		Digits.longs.format(n, radix, arr, alen, offset + nlen);
		return assign(cpa.assign(arr, newlen));
	}

	public Chars insert(int offset, float n) {
		String str = JavaFloatingDecimal.toJavaFormatString(n);
		char[] inj = str.toString().toCharArray();
		return insert(offset, inj, inj.length, 0, str.length());
	}

	public Chars insert(int offset, double n) {
		String str = JavaFloatingDecimal.toJavaFormatString(n);
		char[] inj = str.toString().toCharArray();
		return insert(offset, inj, inj.length, 0, str.length());
	}

	public Chars insertCodePoint(int offset, int cp) {
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.safe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		Check.insertIndex(offset, length());
		// ------------------
		offset = cps.reindex(arr, alen, offset);
		// ------------------
		int cplen = cps.lengthOf(cp);
		arr = Lang.capacity.ensure(arr, alen, alen + cplen);
		arr = Lang.expand.at(arr, alen, offset, cplen);
		int newlen = Lang.codepoint.set(arr, alen, offset, cp, cps);
		spcount -= (alen - newlen);
		return assign(cpa.assign(arr, newlen, spcount, cps));
	}

	public Chars insertCodePoints(int offset, int[] cps) {
		ensureCanAccommodate(cps.length * 2);
		CodepointArray cpa = unsafe();
		CodepointSupport cps0 = cpa.getPairsSupport();
		char[] arr = cpa.safe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		Check.insertIndex(offset, length());
		// ------------------
		offset = cps0.reindex(arr, alen, offset);
		// ------------------
		int cp = 0, cplen = 0, newlen = alen;
		for (int i = 0; i < cps.length; i++) {
			cp = cps[i];
			cplen = cps0.lengthOf(cp);
			arr = Lang.capacity.ensure(arr, alen, alen + cplen);
			offset += cplen;
			newlen = Lang.codepoint.set(arr, newlen, offset, cp, cps0);
		}
		spcount -= (alen - newlen);
		return assign(cpa.assign(arr, newlen, spcount, cps0));
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
	 * append given code-points array based on given range
	 */
	public Chars appendCodePoints(int[] cps) {
		return insertCodePoints(length(), cps);
	}

	// ===============
	// =============== sub-string
	// ===============

	/**
	 * @see #substring(int, int)
	 */
	public Chars sub(int from) {
		return sub(from, length());
	}

	/**
	 * @see String#substring(int, int)
	 */
	public Chars sub(int from, int to) {
		int len = length();
		if (len == 0 || from == to) {
			return Chars.of();
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.sub.of(arr, alen, from, to);
		return newInstance(newCodepointArray(out, out.length));
	}

	// ===============
	// =============== sub-string before
	// ===============

	/*
	 * sube #substringBefore(char[], int)
	 */
	public Chars subBefore(int separator, int from, int to) {
		int len = length();
		if (len == 0) {
			return newInstance();
		}
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.codepoint.sub.before(arr, alen, separator, from, to, getFlags(), 0, CharsMatcher.MUST_EQUALS,
				cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	/**
	 * @see #substringBefore(char[], int)
	 */
	public Chars subBefore(CharSequence separator, int from, int to) {
		int len = length();
		if (len == 0 || separator.length() == 0) {
			return newInstance();
		}
		char[] tarr = readOnlyArray(separator);
		int tlen = readOnlyArrayLength(separator);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.chararray.sub.before(arr, alen, tarr, tlen, from, to, getFlags(), 0, CharsMatcher.MUST_EQUALS,
				cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	// ===============
	// =============== sub-string before-last
	// ===============

	/**
	 * @see #substringBeforeLast(char[], int)
	 */
	public Chars subBeforeLast(int separator, int from, int to) {
		int len = length();
		if (len == 0) {
			return newInstance();
		}
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.codepoint.sub.beforeLast(arr, alen, separator, from, to, getFlags(), 0,
				CharsMatcher.MUST_EQUALS, cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	/**
	 * @see #substringBeforeLast(char[], int)
	 */
	public Chars subBeforeLast(CharSequence separator, int from, int to) {
		int len = length();
		if (len == 0 || separator.length() == 0) {
			return newInstance();
		}
		char[] tarr = readOnlyArray(separator);
		int tlen = readOnlyArrayLength(separator);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.chararray.sub.beforeLast(arr, alen, tarr, tlen, from, to, getFlags(), 0,
				CharsMatcher.MUST_EQUALS, cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	// ===============
	// =============== sub-string after
	// ===============

	/**
	 * @param from
	 * @param to
	 * @see #substringAfter(char[], int)
	 */
	public Chars subAfter(int separator, int from, int to) {
		int len = length();
		if (len == 0) {
			return newInstance();
		}
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		if (!cps.isBmp(separator)) {
			return newInstance();
		}
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.codepoint.sub.after(arr, alen, separator, from, to, getFlags(), 0, CharsMatcher.MUST_EQUALS,
				cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	/**
	 * @param from
	 * @param to
	 * @see #substringAfter(char[], int)
	 */
	public Chars subAfter(CharSequence separator, int from, int to) {
		int len = length();
		if (len == 0) {
			return newInstance();
		}
		char[] tarr = readOnlyArray(separator);
		int tlen = readOnlyArrayLength(separator);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.chararray.sub.after(arr, alen, tarr, tlen, from, to, getFlags(), 0, CharsMatcher.MUST_EQUALS,
				cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	// ===============
	// =============== sub-string after-last
	// ===============

	/**
	 * @see #substringAfterLast(char[], int)
	 */
	public Chars subAfterLast(int separator, int from, int to) {
		int len = length();
		if (len == 0) {
			return newInstance();
		}
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		if (!cps.isBmp(separator)) {
			return newInstance();
		}
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.codepoint.sub.afterLast(arr, alen, separator, from, to, getFlags(), 0,
				CharsMatcher.MUST_EQUALS, cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	/**
	 * @see #substringAfterLast(char[], int)
	 */
	public Chars subAfterLast(CharSequence separator, int from, int to) {
		int len = length();
		if (len == 0) {
			return newInstance();
		}
		char[] tarr = readOnlyArray(separator);
		int tlen = readOnlyArrayLength(separator);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.chararray.sub.afterLast(arr, alen, tarr, tlen, from, to, getFlags(), 0,
				CharsMatcher.MUST_EQUALS, cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	// ===============
	// =============== sub-string between
	// ===============

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(int open, int close, int from, int to) {
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		if (isEmpty() || !cps.isBmp(open) || !cps.isBmp(close)) {
			return newInstance();
		}
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.codepoint.sub.between(arr, alen, open, close, from, to, getFlags(), 0,
				CharsMatcher.MUST_EQUALS, cps);
		return newInstance(newCodepointArray(out, out.length));
	}

	/**
	 * @see #substringBetween(char[], int, char[], int)
	 */
	public Chars subBetween(CharSequence open, CharSequence close, int from, int to) {
		if (isEmpty()) {
			return newInstance();
		}
		char[] oarr = readOnlyArray(open);
		int olen = readOnlyArrayLength(open);
		char[] carr = readOnlyArray(close);
		int clen = readOnlyArrayLength(close);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		char[] out = Lang.chararray.sub.between(arr, alen, oarr, olen, carr, clen, from, to, getFlags(), 0,
				CharsMatcher.MUST_EQUALS, cps);
		return newInstance(newCodepointArray(out, out.length));
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
		return sub(start, end);
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
		Check.insertIndex(insertAt, length());
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		int alen = cpa.lengthActual();
		char[] arr = cpa.unsafe();
		int spcount = cpa.getPairsCount();
		// ------------------
		insertAt = cps.reindex(arr, alen, insertAt);
		// ------------------
		arr = Lang.codepoint.repeat.in(arr, alen, target, repeat, insertAt, cps);
		int newlen = Lang.codepoint.repeat.lengthOf.in(arr, alen, target, repeat, insertAt, cps);
		spcount = cps.isBmp(target) ? spcount : spcount + repeat;
		return assign(cpa.assign(arr, newlen, spcount, cps));
	}

	// ===============
	// =============== repeat chararra
	// ===============

	/**
	 * @see #repeat(int, int, int)
	 */
	public Chars repeat(CharSequence target, int repeat) {
		return repeat(target, repeat, length());
	}

	/**
	 * repeat given code-point and insert it
	 */
	public Chars repeat(CharSequence target, int repeat, int insertAt) {
		if (repeat <= 0) {
			return this;
		} else if (repeat == 1) {
			return insert(insertAt, target);
		}
		Check.insertIndex(insertAt, length());
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		int alen = cpa.lengthActual();
		char[] arr = cpa.unsafe();
		int spcount = cpa.getPairsCount();
		// ------------------
		insertAt = cps.reindex(arr, alen, insertAt);
		// ------------------
		arr = Lang.chararray.repeat.in(arr, alen, tarr, tlen, repeat, insertAt);
		int newlen = Lang.chararray.repeat.lengthOf.in(arr, alen, tarr, tlen, repeat, insertAt);
		spcount += readOnlyArrayPairsCount(target, cps);
		return assign(cpa.assign(arr, newlen, spcount, cps));
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
		Check.insertIndex(offset, length());
		CodepointArray cpa = safe();
		int alen = cpa.lengthActual();
		char[] arr = cpa.unsafe();
		char[] out = Lang.chararray.ellipse.in(arr, alen, maxWidth, offset);
		int newlen = Lang.chararray.ellipse.lengthOf.in(arr, alen, maxWidth, offset);
		return assign(cpa.assign(out, newlen));
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
		char[] rarr = readOnlyArray(replacement);
		int rlen = readOnlyArrayLength(replacement);
		if (isEmpty()) {
			return assign(safe().assign(rarr, rlen));
		}
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		arr = Lang.chararray.replace.range(arr, alen, from, to, rarr, rlen, cps);
		alen = Lang.chararray.replace.lengthOf.range(arr, alen, from, to, rarr, rlen, cps);
		return assign(cpa.assign(arr, alen));
	}

	// ===============
	// =============== replace all
	// ===============

	public Chars replaceAll(int target, int replacement) {
		return replaceAll(target, replacement, 0);
	}

	public Chars replaceAll(int target, int replacement, int from) {
		return replaceAll(target, replacement, from, length());
	}

	public Chars replaceAll(int target, int replacement, int from, int to) {
		return replaceAll(target, replacement, from, to, isIgnoreCase());
	}

	public Chars replaceAll(int target, int replacement, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from == len) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		Check.codePoint(target, cps);
		Check.codePoint(replacement, cps);
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ------------------
		CharArray arr2 = Lang.codepoint.replace.all(arr, alen, target, replacement, from, to, flags, cps);
		return assign(cpa.assign(arr2.getArray(), arr2.length()));
	}

	public Chars replaceAll(CharSequence target, CharSequence replacement) {
		return replaceAll(target, replacement, 0);
	}

	public Chars replaceAll(CharSequence target, CharSequence replacement, int from) {
		return replaceAll(target, replacement, from, length());
	}

	public Chars replaceAll(CharSequence target, CharSequence replacement, int from, int to) {
		return replaceAll(target, replacement, from, to, isIgnoreCase());
	}

	public Chars replaceAll(CharSequence target, CharSequence replacement, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from == len) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		// ------------------
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		char[] rarr = readOnlyArray(replacement);
		int rlen = readOnlyArrayLength(replacement);
		// ------------------
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ------------------
		CharArray arr2 = Lang.chararray.replace.all(arr, alen, tarr, tlen, rarr, rlen, from, to, flags, cps);
		return assign(cpa.assign(arr2.getArray(), arr2.length()));
	}

	// ===============
	// =============== replace first
	// ===============

	public Chars replaceFirst(int target, int replacement) {
		return replaceFirst(target, replacement, 0);
	}

	public Chars replaceFirst(int target, int replacement, int from) {
		return replaceFirst(target, replacement, from, length());
	}

	public Chars replaceFirst(int target, int replacement, int from, int to) {
		return replaceFirst(target, replacement, from, to, isIgnoreCase());
	}

	public Chars replaceFirst(int target, int replacement, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from == len) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		Check.codePoint(target, cps);
		Check.codePoint(replacement, cps);
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		int spcount = cpa.getPairsCount();
		// ------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ------------------
		arr = Lang.codepoint.replace.first(arr, alen, target, replacement, from, to, flags, cps);
		int newlen = Lang.codepoint.replace.lengthOf.first(arr, alen, target, replacement, from, to, flags, cps);
		spcount += newlen - len;
		return assign(cpa.assign(arr, newlen, spcount, cps));
	}

	public Chars replaceFirst(CharSequence target, CharSequence replacement) {
		return replaceFirst(target, replacement, 0);
	}

	public Chars replaceFirst(CharSequence target, CharSequence replacement, int from) {
		return replaceFirst(target, replacement, from, length());
	}

	public Chars replaceFirst(CharSequence target, CharSequence replacement, int from, int to) {
		return replaceFirst(target, replacement, from, to, isIgnoreCase());
	}

	public Chars replaceFirst(CharSequence target, CharSequence replacement, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (from == len) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		// ------------------
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		char[] rarr = readOnlyArray(replacement);
		int rlen = readOnlyArrayLength(replacement);
		// ------------------
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ------------------
		arr = Lang.chararray.replace.first(arr, alen, tarr, tlen, rarr, rlen, from, to, flags, cps);
		alen = Lang.chararray.replace.lengthOf.first(arr, alen, tarr, tlen, rarr, rlen, from, to, flags, cps);
		return assign(cpa.assign(arr, alen));
	}

	// ===============
	// =============== split
	// ===============

	public Chars[] splitBy(int target, int from, int to, boolean ignoreCase) {
		if (isEmpty())
			return newArray(0);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		CharArray[] a = Lang.codepoint.split.by(arr, alen, target, from, to, flags, 0, CharsMatcher.MUST_EQUALS, cps);
		if (a.length != 0)
			return newArray(0);
		Chars[] out = newArray(a.length);
		for (int i = 0; i < out.length; i++) {
			out[i] = newInstance(cpa.newInstance(a[i]));
		}
		return out;
	}

	public Chars[] splitByAny(int[] targets, int from, int to, boolean ignoreCase) {
		if (isEmpty())
			return newArray(0);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		CharArray[] a = Lang.codepoint.split.byAny(arr, alen, targets, from, to, flags, 0, CharsMatcher.MUST_EQUALS,
				cps);
		if (a.length != 0)
			return newArray(0);
		Chars[] out = newArray(a.length);
		for (int i = 0; i < out.length; i++) {
			out[i] = newInstance(cpa.newInstance(a[i]));
		}
		return out;
	}

	public Chars[] splitBy(CharSequence target, int from, int to, boolean ignoreCase) {
		if (isEmpty())
			return newArray(0);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ------------------
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		CharArray[] a = Lang.chararray.split.by(arr, alen, tarr, tlen, from, to, flags, 0, CharsMatcher.MUST_EQUALS,
				cps);
		if (a.length != 0)
			return newArray(0);
		Chars[] out = newArray(a.length);
		for (int i = 0; i < out.length; i++) {
			out[i] = newInstance(cpa.newInstance(a[i]));
		}
		return out;
	}

	public Chars[] splitByAny(CharSequence targets, int from, int to, boolean ignoreCase) {
		if (isEmpty())
			return newArray(0);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ------------------
		char[] tarr = readOnlyArray(targets);
		int tlen = readOnlyArrayLength(targets);
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		CharArray[] a = Lang.chararray.split.byAny(arr, alen, tarr, tlen, from, to, flags, 0, CharsMatcher.MUST_EQUALS,
				cps);
		if (a.length != 0)
			return newArray(0);
		Chars[] out = newArray(a.length);
		for (int i = 0; i < out.length; i++) {
			out[i] = newInstance(cpa.newInstance(a[i]));
		}
		return out;
	}

	// ===============
	// =============== clear and delete
	// ===============

	/**
	 * clear the entire sequence
	 */
	public Chars clear() {
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		return assign(cpa.assign(arr, 0, 0, cps));
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
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		// ----------------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// ---------------------
		// since the deletion is (from-to), means the count of spc between from-to
		// equals
		// the spc_dellen
		final int spc_dellen = disp;
		final int spc_newlen = spcount - spc_dellen;

		int dellen = to - from;
		final int newlen = alen - dellen;
		if (newlen == 0)
			return assign(cpa.assign(arr, 0, 0, cps));
		// in-case of deleting from middle to len, no need to shrink the tail

		if (to == alen) {
			return assign(cpa.assign(arr, newlen, spc_newlen, cps));
		}

		Lang.shrink.at(arr, alen, from, dellen);
		return assign(cpa.assign(arr, newlen, spc_newlen, cps));
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
		return delete(target, from, to, isIgnoreCase());
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
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		int spcount = cpa.getPairsCount();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		int newlen = Lang.codepoint.remove.when(arr, alen, target, 0, from, to, fromDisp, flags,
				CharsMatcher.MUST_EQUALS, cps);
		int diff = alen - newlen;
		spcount -= cps.isSupported() && !cps.isBmp(target) ? (diff / 2) : 0;
		return assign(cpa.assign(arr, newlen, cps.isSupported() ? spcount : 0, cps));
	}

	public Chars delete(CharSequence target) {
		return delete(target, 0);
	}

	public Chars delete(CharSequence target, int from) {
		return delete(target, from, length());
	}

	public Chars delete(CharSequence target, int from, int to) {
		return delete(target, from, to, isIgnoreCase());
	}

	public Chars delete(CharSequence target, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		int newlen = Lang.chararray.remove.when(arr, alen, tarr, tlen, 0, from, to, 0, flags, CharsMatcher.MUST_EQUALS,
				cps);
		return assign(cpa.assign(arr, newlen));
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
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		int newlen = Lang.codepoint.remove.whitespaces(arr, alen, 0, from, to, 0, 0, CharsMatcher.MUST_EQUALS, cps);
		return assign(cpa.assign(arr, newlen));
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
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		int newlen = Lang.codepoint.remove.linefeeds(arr, alen, 0, from, to, 0, 0, CharsMatcher.MUST_EQUALS, cps);
		return assign(cpa.assign(arr, newlen));
	}

	// ===============
	// =============== delete duplicates
	// ===============

	/**
	 * @see #deleteDuplicates(int, int, int)
	 */
	public Chars deleteDuplicates() {
		// -1 means search and delete any duplicates
		return deleteDuplicates(-1);
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
	 * @see #deleteDuplicates(int, int, int)
	 */
	public Chars deleteDuplicates(int target, int from, int to) {
		return deleteDuplicates(target, from, to, isIgnoreCase());
	}

	/**
	 * delete all occurrences of duplicated given code-point based on given range
	 * 
	 * <br>
	 * <b>default</b> target: -1, means search and find any duplicates
	 */
	public Chars deleteDuplicates(int target, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		int newlen = Lang.codepoint.remove.when(arr, alen, target, 1, from, to, 0, flags, CharsMatcher.MUST_EQUALS,
				cps);
		return assign(cpa.assign(arr, newlen));
	}

	public Chars deleteDuplicates(CharSequence target) {
		return deleteDuplicates(target, 0);
	}

	public Chars deleteDuplicates(CharSequence target, int from) {
		return deleteDuplicates(target, from, length());
	}

	public Chars deleteDuplicates(CharSequence target, int from, int to) {
		return deleteDuplicates(target, from, to, isIgnoreCase());
	}

	public Chars deleteDuplicates(CharSequence target, int from, int to, boolean ignoreCase) {
		final int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		int newlen = Lang.chararray.remove.when(arr, alen, tarr, tlen, 1, from, to, 0, flags, CharsMatcher.MUST_EQUALS,
				cps);
		return assign(cpa.assign(arr, newlen));
	}

	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// =============== index-of
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
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
		return indexOf(target, from, to, isIgnoreCase());
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
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.codepoint.index.of(arr, alen, target, from, to, flags, fromDisp, m, cps);
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
		return indexOf(target, from, to, isIgnoreCase());
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
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.chararray.index.of(arr, alen, tarr, tlen, from, to, flags, fromDisp, m, cps);
	}

	// ===============
	// =============== index-of-any sequence
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
		return indexOfAny(target, from, to, isIgnoreCase());
	}

	/**
	 * @see #indexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfAny(CharSequence target, int from, int to, boolean ignoreCase) {
		return indexOfAny(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	protected int indexOfAny(CharSequence targets, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (len == 0 || from >= len || targets == null || targets.length() == 0) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] tarr = readOnlyArray(targets);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.chararray.index.ofAny(arr, alen, tarr, from, to, flags, fromDisp, m, cps);
	}

	// ===============
	// =============== index-of-end code-point
	// ===============
	/**
	 * @see #indexOfEnd(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(int target) {
		return indexOfEnd(target, 0);
	}

	/**
	 * @see #indexOfEnd(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(int target, int from) {
		return indexOfEnd(target, from, length());
	}

	/**
	 * @see #indexOfEnd(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(int target, int from, int to) {
		return indexOfEnd(target, from, to, isIgnoreCase());
	}

	/**
	 * @see #indexOfEnd(int, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(int target, int from, int to, boolean ignoreCase) {
		return indexOfEnd(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return index of given target code-point based on given range, or -1 if not
	 *         found
	 * @see String#indexOfEnd(int, int)
	 */
	protected int indexOfEnd(int target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.codepoint.index.ofEnd(arr, alen, target, from, to, flags, fromDisp, m, cps);
	}

	// ===============
	// =============== index-of-end sequence
	// ===============
	/**
	 * @see #indexOfEnd(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(CharSequence target) {
		return indexOfEnd(target, 0);
	}

	/**
	 * @see #indexOfEnd(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(CharSequence target, int from) {
		return indexOfEnd(target, from, length());
	}

	/**
	 * @see #indexOfEnd(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(CharSequence target, int from, int to) {
		return indexOfEnd(target, from, to, isIgnoreCase());
	}

	/**
	 * @see #indexOfEnd(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int indexOfEnd(CharSequence target, int from, int to, boolean ignoreCase) {
		return indexOfEnd(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return index of given target sequence <b>(entire)</b> based on given range,
	 *         or -1 if not found
	 * @see String#indexOfEnd(String, int)
	 */
	protected int indexOfEnd(CharSequence target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.chararray.index.ofEnd(arr, alen, tarr, tlen, from, to, flags, fromDisp, m, cps);
	}

	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// =============== last-index-of
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// ===============
	// =============== lastIndex-of codepoint
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
		return lastIndexOf(target, from, to, isIgnoreCase());
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
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.codepoint.lastIndex.of(arr, alen, target, from, to, flags, fromDisp, m, cps);
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
		return lastIndexOf(target, from, to, isIgnoreCase());
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
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.chararray.lastIndex.of(arr, alen, tarr, tlen, from, to, flags, fromDisp, m, cps);
	}

	// ===============
	// =============== last-index-of any
	// ===============

	/**
	 * @see #lastIndexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfAny(CharSequence target) {
		return lastIndexOfAny(target, 0);
	}

	/**
	 * @see #lastIndexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfAny(CharSequence target, int from) {
		return lastIndexOfAny(target, from, length());
	}

	/**
	 * @see #lastIndexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfAny(CharSequence target, int from, int to) {
		return lastIndexOfAny(target, from, to, isIgnoreCase());
	}

	/**
	 * @see #lastIndexOfAny(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfAny(CharSequence target, int from, int to, boolean ignoreCase) {
		return lastIndexOfAny(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	protected int lastIndexOfAny(CharSequence targets, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (len == 0 || from >= len || targets == null || targets.length() == 0) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] tarr = readOnlyArray(targets);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.chararray.index.ofAny(arr, alen, tarr, from, to, flags, fromDisp, m, cps);
	}
	
	
	/**
	 * @see #lastIndexOfBegin(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(int target) {
		return lastIndexOfBegin(target, length());
	}

	/**
	 * @see #lastIndexOfBegin(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(int target, int from) {
		return lastIndexOfBegin(target, from, 0);
	}

	/**
	 * @see #lastIndexOfBegin(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(int target, int from, int to) {
		return lastIndexOfBegin(target, from, to, isIgnoreCase());
	}

	/**
	 * @see #lastIndexOfBegin(int, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(int target, int from, int to, boolean ignorCase) {
		return lastIndexOfBegin(target, from, to, ignorCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @param from (exclusive-right-index)
	 * @param to   (inclusive-left-index)
	 * @return last-index of given target code-point based on given range, or return
	 *         -1 if not found
	 * @see String#lastIndexOfBegin(int, int)
	 */
	protected int lastIndexOfBegin(int target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.codepoint.lastIndex.ofBegin(arr, alen, target, from, to, flags, fromDisp, m, cps);
	}

	// ===============
	// =============== lastIndex-of sequence
	// ===============
	/**
	 * @see #lastIndexOfBegin(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(CharSequence target) {
		return lastIndexOfBegin(target, length());
	}

	/**
	 * @see #lastIndexOfBegin(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(CharSequence target, int from) {
		return lastIndexOfBegin(target, from, 0);
	}

	/**
	 * @see #lastIndexOfBegin(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(CharSequence target, int from, int to) {
		return lastIndexOfBegin(target, from, to, isIgnoreCase());
	}

	/**
	 * @see #lastIndexOfBegin(CharSequence, int, int, boolean, CharsMatcher)
	 */
	public int lastIndexOfBegin(CharSequence target, int from, int to, boolean ignoreCase) {
		return lastIndexOfBegin(target, from, to, ignoreCase, CharsMatcher.MUST_EQUALS);
	}

	/**
	 * @return last-index of given target sequence <b>(entire)</b> based on given
	 *         range, or -1 if not found
	 * @see String#lastIndexOfBegin(String, int) <br>
	 *      <b>default</b> to=-1 to return exact result as
	 *      {@link String#lastIndexOfBegin(String, int)}
	 */
	protected int lastIndexOfBegin(CharSequence target, int from, int to, boolean ignoreCase, CharsMatcher m) {
		final int len = length();
		if (from >= len) {
			return Lang.constant.INDEX_NOT_FOUND;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		char[] tarr = readOnlyArray(target);
		int tlen = readOnlyArrayLength(target);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int between = cps.extendablePairsCount(arr, alen, from, to);
		to += between;
		// ---------------------
		return Lang.chararray.lastIndex.ofBegin(arr, alen, tarr, tlen, from, to, flags, fromDisp, m, cps);
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
		ensureNotEmpty();
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
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
		ensureNotEmpty();
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
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
		if (len == 0)
			return false;
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ----------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += cps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		return Check.isValidNumeric(arr, alen, radix, from, to);
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
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ------------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// ------------------
		int cp = 0, rangelen = to - from;
		List<Integer> l = new ArrayList<Integer>();
		for (int i = from; i < to; i++) {
			cp = cps.getCodepoint(arr, rangelen, i);
			if (bp.test(i, cp)) {
				l.add(cp);
			}
			i += cps.isSupported() && !cps.isBmp(cp) ? 1 : 0;
		}
		if (l.isEmpty()) {
			return of();
		}
		return clear().appendCodePoints(Lang.primitive.to.ints(l));
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
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		// ------------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// ------------------
		arr = Lang.chararray.reverse.in(arr, alen, from, to, cps);
		return assign(cpa.assign(arr, len, spcount, cps));
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
	public Chars sort(int from, int to) {
		int len = length();
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		// ------------------
		// supported or not, both cases no need to reindex/displace (if supported sort
		// method will convert char[] into codepoints int[]
		// ------------------
		arr = Lang.chararray.sort.in(arr, alen, from, to, cps);
		return assign(cpa.assign(arr, len, spcount, cps));
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
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		// ------------------
		// supported or not, both cases no need to reindex/displace (if supported sort
		// method will convert char[] into codepoints int[]
		// ------------------
		arr = Lang.chararray.sort.parallel(arr, alen, from, to, cps);
		return assign(cpa.assign(arr, len, spcount, cps));
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
		if (len == 0) {
			return this;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		// ------------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// ------------------
		arr = Lang.chararray.shuffle.in(arr, alen, from, to, Digits.RANDOM, cps);
		return assign(cpa.assign(arr, len, spcount, cps));

	}

	// ===============
	// =============== swap
	// ===============

	public Chars swap(int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			throw new IllegalArgumentException(String.format("leftIndex(%d) >= rightIndex(%d)", leftIndex, rightIndex));
		}
		int len = length();
		if (len == 0) {
			return this;
		}
		Check.index(leftIndex, len);
		Check.index(rightIndex, len);
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		// -----------------
		leftIndex = cps.reindex(arr, alen, leftIndex);
		rightIndex = cps.reindex(arr, alen, rightIndex);
		// -----------------
		arr = Lang.codepoint.swap.with(arr, alen, leftIndex, rightIndex, cps);
		return assign(cpa.assign(arr, len, spcount, cps));
	}

	// ===============
	// =============== trim
	// ===============

	/**
	 * trim both sides
	 */
	public Chars trim() {
		final int len = length();
		if (len == 0)
			return this;
		CodepointArray cpa = unsafe();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int right = Lang.chararray.skip.whitespace(arr, alen);
		int left = Lang.chararray.skip.e.whitespace(arr, alen, Endian.BIG);
		if (left != alen) {
			int from = alen - left;
			arr = Lang.copy.of.this_(arr, alen, from, right);
			return assign(cpa.assign(arr, right - from));
		}
		return assign(cpa.assign(arr, right));
	}

	/**
	 * trim left side
	 */
	public Chars trimLeft() {
		final int len = length();
		if (len == 0)
			return this;
		CodepointArray cpa = unsafe();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int left = Lang.chararray.skip.e.whitespace(arr, alen, Endian.BIG);
		if (left != alen) {
			int from = alen - left;
			arr = Lang.copy.of.this_(arr, alen, from, alen);
			return assign(cpa.assign(arr, alen - from));
		}
		return this;
	}

	/**
	 * trim right side
	 */
	public Chars trimRight() {
		final int len = length();
		if (len == 0)
			return this;
		CodepointArray cpa = unsafe();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int right = Lang.chararray.skip.whitespace(arr, alen);
		if (right == alen)
			return this;
		return assign(cpa.assign(arr, right));
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
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// -----------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -----------------
		int x = 0;
		for (int i = from; i < to;) {
			x = cps.getCodepoint(arr, alen, i);
			if (Character.isUpperCase(x)) {
				if (Character.isLowerCase(x)) {
					i += cps.lengthOf(x);
					continue;
				}
				return false;
			}
			i += cps.lengthOf(x);
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
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// -----------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -----------------
		int x = 0;
		for (int i = from; i < to;) {
			x = cps.getCodepoint(arr, alen, i);
			if (!Character.isUpperCase(x)) {
				if (!Character.isLowerCase(x)) {
					i += cps.lengthOf(x);
					continue;
				}
				return false;
			}
			i += cps.lengthOf(x);
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
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// -----------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -----------------
		int x = 0;
		boolean isUppercase = false;
		boolean isLowercase = false;
		for (int i = from; i < to;) {
			x = cps.getCodepoint(arr, alen, i);
			if (!isUppercase) {
				isUppercase = Character.isUpperCase(x);
			}
			if (!isLowercase) {
				isLowercase = Character.isLowerCase(x);
			}
			i += cps.lengthOf(x);
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
		return Character.isUpperCase(getCodepointAt(0));
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
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// -----------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -----------------
		if (from == 0 && to == alen) {
			return new String(arr, 0, alen).getBytes(charset);
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
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// -----------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -----------------
		return Lang.copy.of.this_(arr, alen, from, to);
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
	public int[] toCodePointArray(int from) {
		return toCodePointArray(from, length());
	}

	public int[] toCodePointArray(int from, int to) {
		final int len = length();
		if (len == 0) {
			return new int[0];
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// -----------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -----------------
		return cps.toCodepointArray(arr, alen, from, to);
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
		CodepointArray cpa = unsafe();
		// string class will recopy
		return new String(cpa.unsafe(), 0, cpa.lengthActual());
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
		CodepointArray cpa = unsafe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		// ==================
		index = cps.reindex(arr, alen, index);
		// ==================
		return Lang.chararray.offsetByCodePoints(arr, 0, alen, index, codePointOffset, cps);
	}

	/**
	 * @see Character#getName(int)
	 */
	public CharSequence getNameAt(int index) {
		ensureNotEmpty();
		return Character.getName(getCodepointAt(index));
	}

	/**
	 * @see Character#highSurrogate(int)
	 */
	public char highSurrogateAt(int index) {
		return unsafe().getPairsSupport().toHigh(getCodepointAt(index));
	}

	/**
	 * @see Character#lowSurrogate(int)
	 */
	public char lowSurrogateAt(int index) {
		return unsafe().getPairsSupport().toLow(getCodepointAt(index));
	}

	/**
	 * @see Character#isBmpCodePoint(int)
	 */
	public boolean isBmpget(int index) {
		return unsafe().getPairsSupport().isBmp(getCodepointAt(index));
	}

	/**
	 * @see Character#toChars(int, char[], int)
	 */
	public int toCharArrayAt(int index, char[] buf, int insertAt) {
		return unsafe().getPairsSupport().toCharArray(getCodepointAt(index), buf, buf.length, insertAt);
	}

	/**
	 * @see Character#toChars(int)
	 */
	public char[] toCharArrayAt(int index) {
		return unsafe().getPairsSupport().toCharArray(getCodepointAt(index));
	}

	/**
	 * @see Character#isDigit(int)
	 */
	public boolean isDigitAt(int index) {
		return Character.isDigit(getCodepointAt(index));
	}

	/**
	 * @see Character#isSurrogate(char)
	 */
	public boolean isSurrogateAt(int index) {
		return unsafe().getPairsSupport().isHighOrLow(getCodepointAt(index));
	}

	public boolean isLowSurrogateAt(int index) {
		return unsafe().getPairsSupport().isLow(getCodepointAt(index));
	}

	/**
	 * @see Character#isHighSurrogate(char)
	 */
	public boolean isHighSurrogateAt(int index) {
		return unsafe().getPairsSupport().isHigh(getCodepointAt(index));
	}

	/**
	 * @see Character#isLetter(int)
	 */
	public boolean isLetterAt(int index) {
		return Character.isLetter(getCodepointAt(index));
	}

	/**
	 * @see Character#isLetterOrDigit(int)
	 */
	public boolean isLetterOrDigitAt(int index) {
		return Character.isLetterOrDigit(getCodepointAt(index));
	}

	/**
	 * @see Character#isSupplementaryCodePoint(int)
	 */
	public boolean isSupplementaryget(int index) {
		return unsafe().getPairsSupport().isPair(getCodepointAt(index));
	}

	/**
	 * @see Character#isSurrogatePair(char, char)
	 */
	public boolean isSurrogatePairAt(int index) {
		return unsafe().getPairsSupport().isPair(getCodepointAt(index));
	}

	/**
	 * @see Character#isLowerCase(int)
	 */
	public boolean isLowerCaseAt(int index) {
		return Character.isLowerCase(getCodepointAt(index));
	}

	/**
	 * @see Character#isUpperCase(int)
	 */
	public boolean isUpperCaseAt(int index) {
		return Character.isUpperCase(getCodepointAt(index));
	}

	/**
	 * @see Character#isTitleCase(int)
	 */
	public boolean isTitleCaseAt(int index) {
		return Character.isTitleCase(getCodepointAt(index));
	}

	/**
	 * @see Character#toTitleCase(int)
	 */
	public Chars toTitleCaseAt(int index) {
		int c = getCodepointAt(index);
		return set(index, Character.toTitleCase(c));
	}

	/**
	 * @see Character#isDefined(int)
	 */
	public boolean isDefinedAt(int index) {
		return Character.isDefined(getCodepointAt(index));
	}

	/**
	 * @see Character#isAlphabetic(int)
	 */
	public boolean isAlphabeticAt(int index) {
		return Character.isAlphabetic(getCodepointAt(index));
	}

	/**
	 * @see Character#isIdeographic(int)
	 */
	public boolean isIdeographicAt(int index) {
		return Character.isIdeographic(getCodepointAt(index));
	}

	/**
	 * @see Character#isUnicodeIdentifierStart(int)
	 */
	public boolean isUnicodeIdentifierStartAt(int index) {
		return Character.isUnicodeIdentifierStart(getCodepointAt(index));
	}

	/**
	 * @see Character#isUnicodeIdentifierPart(int)
	 */
	public boolean isUnicodeIdentifierPartAt(int index) {
		return Character.isUnicodeIdentifierPart(getCodepointAt(index));
	}

	/**
	 * @see Character#isJavaIdentifierStart(int)
	 */
	public boolean isJavaIdentifierStartAt(int index) {
		return Character.isJavaIdentifierStart(getCodepointAt(index));
	}

	/**
	 * @see Character#isJavaIdentifierPart(int)
	 */
	public boolean isJavaIdentifierPartAt(int index) {
		return Character.isJavaIdentifierPart(getCodepointAt(index));
	}

	/**
	 * @see Character#isIdentifierIgnorable(int)
	 */
	public boolean isIdentifierIgnorableAt(int index) {
		return Character.isIdentifierIgnorable(getCodepointAt(index));
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
		return Character.digit(getCodepointAt(index), radix);
	}

	/**
	 * @see Character#getNumericValue(int)
	 */
	public int getNumericValueAt(int index) {
		return Character.getNumericValue(getCodepointAt(index));
	}

	/**
	 * @see Character#isSpaceChar(int)
	 */
	public boolean isSpaceAt(int index) {
		return Character.isSpaceChar(getCodepointAt(index));
	}

	/**
	 * @see Character#isWhitespace(int)
	 */
	public boolean isWhitespaceAt(int index) {
		return Character.isWhitespace(getCodepointAt(index));
	}

	/**
	 * @see Character#isISOControl(int)
	 */
	public boolean isISOControlAt(int index) {
		return Character.isISOControl(getCodepointAt(index));
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
		return Character.isMirrored(getCodepointAt(index));
	}

	/**
	 * @see Character#getDirectionality(int)
	 */
	public byte getDirectionality(int index) {
		return Character.getDirectionality(getCodepointAt(index));
	}

	/**
	 * @see Character#getType(int)
	 */
	public int getCategoryAt(int index) {
		return Character.getType(getCodepointAt(index));
	}

	/**
	 * @see Character#COMBINING_SPACING_MARK
	 */
	public boolean isCategoryCombiningSpacingMarkAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.COMBINING_SPACING_MARK;
	}

	/**
	 * @see Character#CONNECTOR_PUNCTUATION
	 */
	public boolean isCategoryConnectorPunctuationAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.CONNECTOR_PUNCTUATION;
	}

	/**
	 * @see Character#CONTROL
	 */
	public boolean isCategoryControlAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.CONTROL;
	}

	/**
	 * @see Character#CURRENCY_SYMBOL
	 */
	public boolean isCategoryCurrencySymbolAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.CURRENCY_SYMBOL;
	}

	/**
	 * @see Character#DASH_PUNCTUATION
	 */
	public boolean isCategoryDashPunctuationAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.DASH_PUNCTUATION;
	}

	/**
	 * @see Character#DECIMAL_DIGIT_NUMBER
	 */
	public boolean isCategoryDecimalDigitNumberAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.DECIMAL_DIGIT_NUMBER;
	}

	/**
	 * @see Character#ENCLOSING_MARK
	 */
	public boolean isCategoryEnclosingMarkAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.ENCLOSING_MARK;
	}

	/**
	 * @see Character#END_PUNCTUATION
	 */
	public boolean isCategoryEndPunctuationAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.END_PUNCTUATION;
	}

	/**
	 * @see Character#FINAL_QUOTE_PUNCTUATION
	 */
	public boolean isCategoryFinalQuotePunctuationAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.FINAL_QUOTE_PUNCTUATION;
	}

	/**
	 * @see Character#FORMAT
	 */
	public boolean isCategoryFormatAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.FORMAT;
	}

	/**
	 * @see Character#INITIAL_QUOTE_PUNCTUATION
	 */
	public boolean isCategoryInitialQuotePunctuationAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.INITIAL_QUOTE_PUNCTUATION;
	}

	/**
	 * @see Character#LETTER_NUMBER
	 */
	public boolean isCategoryLetterNumberAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.LETTER_NUMBER;
	}

	/**
	 * @see Character#LINE_SEPARATOR
	 */
	public boolean isCategoryLineSeparatorAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.LINE_SEPARATOR;
	}

	/**
	 * @see Character#LOWERCASE_LETTER
	 */
	public boolean isCategoryLowercaseLetterAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.LOWERCASE_LETTER;
	}

	/**
	 * @see Character#MATH_SYMBOL
	 */
	public boolean isCategoryMathSymbolAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.MATH_SYMBOL;
	}

	/**
	 * @see Character#MODIFIER_LETTER
	 */
	public boolean isCategoryModifierLetterAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.MODIFIER_LETTER;
	}

	/**
	 * @see Character#MODIFIER_SYMBOL
	 */
	public boolean isCategoryModifierSymbolAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.MODIFIER_SYMBOL;
	}

	/**
	 * @see Character#NON_SPACING_MARK
	 */
	public boolean isCategoryNonSpacingMarkAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.NON_SPACING_MARK;
	}

	/**
	 * @see Character#OTHER_LETTER
	 */
	public boolean isCategoryOtherLetterAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.OTHER_LETTER;
	}

	/**
	 * @see Character#OTHER_NUMBER
	 */
	public boolean isCategoryOtherNumberAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.OTHER_NUMBER;
	}

	/**
	 * @see Character#OTHER_PUNCTUATION
	 */
	public boolean isCategoryOtherPunctuationAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.OTHER_PUNCTUATION;
	}

	/**
	 * @see Character#OTHER_SYMBOL
	 */
	public boolean isCategoryOtherSymbolAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.OTHER_SYMBOL;
	}

	/**
	 * @see Character#PARAGRAPH_SEPARATOR
	 */
	public boolean isCategoryParagraphSeparatorAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.PARAGRAPH_SEPARATOR;
	}

	/**
	 * @see Character#PRIVATE_USE
	 */
	public boolean isCategoryPrivateUseAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.PRIVATE_USE;
	}

	/**
	 * @see Character#SPACE_SEPARATOR
	 */
	public boolean isCategorySpaceSeparatorAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.SPACE_SEPARATOR;
	}

	/**
	 * @see Character#START_PUNCTUATION
	 */
	public boolean isCategoryStartPunctuationAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.START_PUNCTUATION;
	}

	/**
	 * @see Character#SURROGATE
	 */
	public boolean isCategorySurrogateAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.SURROGATE;
	}

	/**
	 * @see Character#TITLECASE_LETTER
	 */
	public boolean isCategoryTitlecaseLetterAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.TITLECASE_LETTER;
	}

	/**
	 * @see Character#UNASSIGNED
	 */
	public boolean isCategoryUnassignedAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.UNASSIGNED;
	}

	/**
	 * @see Character#UPPERCASE_LETTER
	 */
	public boolean isCategoryUppercaseLetterAt(int index) {
		return Character.getType(getCodepointAt(index)) == Character.UPPERCASE_LETTER;
	}

	/**
	 * @see Character#DIRECTIONALITY_UNDEFINED
	 */
	public boolean isDirectionalityUndefinedAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_UNDEFINED;
	}

	/**
	 * @see Character#DIRECTIONALITY_LEFT_TO_RIGHT
	 */
	public boolean isDirectionalityLeftToRightAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_LEFT_TO_RIGHT;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT
	 */
	public boolean isDirectionalityRightToLeftAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC
	 */
	public boolean isDirectionalityRightToLeftArabicAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
	}

	/**
	 * @see Character#DIRECTIONALITY_EUROPEAN_NUMBER
	 */
	public boolean isDirectionalityEuropeanNumberAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_EUROPEAN_NUMBER;
	}

	/**
	 * @see Character#DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR
	 */
	public boolean isDirectionalityEuropeanNumberSeparatorAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR
	 */
	public boolean isDirectionalityEuropeanNumberTerminatorAt(int index) {
		return Character
				.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_ARABIC_NUMBER
	 */
	public boolean isDirectionalityArabicNumberAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_ARABIC_NUMBER;
	}

	/**
	 * @see Character#DIRECTIONALITY_COMMON_NUMBER_SEPARATOR
	 */
	public boolean isDirectionalityCommonNumberSeparatorAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_NONSPACING_MARK
	 */
	public boolean isDirectionalityNonspacingMarkAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_NONSPACING_MARK;
	}

	/**
	 * @see Character#DIRECTIONALITY_BOUNDARY_NEUTRAL
	 */
	public boolean isDirectionalityBoundaryNeutralAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_BOUNDARY_NEUTRAL;
	}

	/**
	 * @see Character#DIRECTIONALITY_PARAGRAPH_SEPARATOR
	 */
	public boolean isDirectionalityParagraphSeparatorAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_SEGMENT_SEPARATOR
	 */
	public boolean isDirectionalitySegmentSeparatorAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_SEGMENT_SEPARATOR;
	}

	/**
	 * @see Character#DIRECTIONALITY_WHITESPACE
	 */
	public boolean isDirectionalityWhitespaceAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_WHITESPACE;
	}

	/**
	 * @see Character#DIRECTIONALITY_OTHER_NEUTRALS
	 */
	public boolean isDirectionalityOtherNeutralsAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_OTHER_NEUTRALS;
	}

	/**
	 * @see Character#DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING
	 */
	public boolean isDirectionalityLeftToRightEmbeddingAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING;
	}

	/**
	 * @see Character#DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE
	 */
	public boolean isDirectionalityLeftToRightOverrideAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING
	 */
	public boolean isDirectionalityRightToLeftEmbeddingAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING;
	}

	/**
	 * @see Character#DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE
	 */
	public boolean isDirectionalityRightToLeftOverrideAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE;
	}

	/**
	 * @see Character#DIRECTIONALITY_POP_DIRECTIONAL_FORMAT
	 */
	public boolean isDirectionalityPopDirectionalFormatAt(int index) {
		return Character.getDirectionality(getCodepointAt(index)) == Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT;
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
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int spcount = cpa.getPairsCount();
		int diff = 0;
		if (from == 0 && to == len) {
			String sthis = new String(arr, 0, alen);
			sthis = upperCase ? sthis.toUpperCase(locale) : sthis.toLowerCase(locale);
			diff = sthis.length() - alen;
			arr = sthis.toString().toCharArray();
			return assign(cpa.assign(arr, alen + diff, spcount, cps));
		}

		// ------------------
		int disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
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
			arr = Lang.copy.to.that(tarr, tarr.length, arr, alen, 0, tarr.length, from);
		} else if (diff > 0) {
			arr = Lang.capacity.ensure(arr, alen, len + diff);
			arr = Lang.expand.at(arr, alen + diff, to, diff);
			arr = Lang.copy.to.that(tarr, tarr.length, arr, alen, 0, tarr.length, from);
		}
		return assign(cpa.assign(arr, alen + diff, spcount, cps));
	}

	int findMaxMinLengthByCodePoint(int separator, int from, int to, boolean ignoreCase, boolean findMax) {
		int len = length();
		if (len == 0) {
			return 0;
		}
		to = to > len ? len : to;
		Check.range(from, to, len);
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ------------------
		int begins = from;
		int index = from;
		int max = 0, min = 0, length = 0;
		boolean firstTime = true;
		int spDisp = cps.isBmp(separator) ? 0 : 1;
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
		while ((index = CharsLoop.INDEX_OF.codePoint(arr, alen, from, to, separator, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, cps)) != Lang.constant.INDEX_NOT_FOUND) {
			if (index > srcfrom && index < to) {
				length = (index + fromDisp) - begins;
				max = Math.max(max, length);
				if (firstTime) {
					min = max;
					firstTime = false;
				}
				min = Math.min(min, length);
			}
			fromDisp += cps.extendablePairsCount(arr, alen, from, index + fromDisp) + spDisp;
			from = index + 1 + fromDisp;
			begins = from;
		}

		fromDisp = cps.extendablePairsCount(arr, alen, begins, to);
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
		CodepointArray cpa = safe();
		CodepointSupport cps = cpa.getPairsSupport();
		char[] arr = cpa.unsafe();
		int alen = cpa.lengthActual();
		int flags = reflag(ignoreCase, Lang.constant.FLAG_ALWAYS_IGNORE_CASE, getFlags());
		// ------------------
		int fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		int toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ------------------
		final int srcfrom = from;
		int begins = from;
		int index = from;
		int max = 0, min = 0, length = 0;
		boolean firstTime = true;
		int spDisp = separatorLength - 1;
		while ((index = CharsLoop.INDEX_OF.array(arr, alen, from, to, separator, separatorLength, flags, fromDisp,
				CharsMatcher.MUST_EQUALS, cps)) != Lang.constant.INDEX_NOT_FOUND) {
			if (index > srcfrom && index < to) {
				length = (index + fromDisp) - begins;
				max = Math.max(max, length);
				if (firstTime) {
					min = max;
					firstTime = false;
				}
				min = Math.min(min, length);
			}
			fromDisp += cps.extendablePairsCount(arr, alen, from, index + fromDisp) + spDisp;
			from = index + 1 + fromDisp;
			begins = from;
		}
		fromDisp = cps.extendablePairsCount(arr, alen, begins, to);
		length = (to - fromDisp) - begins;
		if (min > 0 && length > 0) {
			min = Math.min(min, length);
		}
		max = Math.max(max, length);
		return findMax ? max : min;
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

	private static char[] readOnlyArray(CharSequence cs) {
		if (cs instanceof Chars) {
			Chars c = (Chars) cs;
			return c.unsafe().unsafe();
		} else if (cs != null) {
			return cs.toString().toCharArray();
		}
		return null;
	}

	private static int readOnlyArrayLength(CharSequence cs) {
		if (cs instanceof Chars) {
			Chars c = (Chars) cs;
			return c.unsafe().lengthActual();
		} else if (cs != null) {
			return cs.length();
		}
		return 0;
	}

	private static int readOnlyArrayPairsCount(CharSequence cs, CodepointSupport cps) {
		if (!cps.isSupported())
			return 0;
		if (cs instanceof Chars) {
			Chars c = (Chars) cs;
			return c.unsafe().getPairsCount();
		} else if (cs != null) {
			return cps.fixedPairsCount(cs);
		}
		return 0;
	}

	int reflag(boolean b, int f, int flags) {
		return b ? flag(f, flags) : unflag(f, flags);
	}

	int flag(int f, int flags) {
		return flags | f;
	}

	int unflag(int f, int flags) {
		return flags & (flags ^ f);
	}

	boolean isFlagged(int f, int flags) {
		return Digits.ints.isFlagged(flags, f);
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
}
