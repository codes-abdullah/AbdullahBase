package codes.abdullah.project.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;

public class TestLCodepoint {

	@Test
	public void testCodepoint() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testIndex() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testLastIndex() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testIndexes() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testRepeat() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testFill() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testRemove() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testSplit() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testMark() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testLengthOf() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testCount() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testReplace() {
		testReplaceRange();
		testReplaceAllCodepointByCodepoint();
		testReplaceAllCodepointByChararray();
	}

	public void testReplaceRange() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		int from = 0;
		int to = 2;
		int replacement = 'X';
		CodepointSupport cps = CodepointSupport.BMP;

		// =================
		// =================
		// ================= bmp
		// =================
		// =================

		char[] expected = "Xdes.abdullah".toCharArray();
		char[] result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		int newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 3;
		to = 8;
		replacement = 'X';
		expected = "codXdullah".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 9;
		to = 14;
		replacement = 'X';
		expected = "codes.abdX".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 14;
		replacement = 'X';
		expected = "X".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 1;
		replacement = 'X';
		expected = "Xodes.abdullah".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// =================
		// =================
		// ================= debug - replace bmp by surrogate-pair
		// =================
		// =================

		arr = "codes.abdullah".toCharArray();
		len = arr.length;
		cps = CodepointSupport.DEBUG;
		replacement = cps.toCodepoint("F9");

		// ====================

		from = 0;
		to = 2;
		expected = "F9des.abdullah".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 3;
		to = 8;
		expected = "codF9dullah".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 9;
		to = 14;
		expected = "codes.abdF9".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 14;
		expected = "F9".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 1;
		expected = "F9odes.abdullah".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 4;
		to = 5;
		expected = "codeF9.abdullah".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 13;
		to = 14;
		expected = "codes.abdullaF9".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 13;
		to = 14;
		expected = "codes.abdullaF9".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, len, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// =================
		// =================
		// ================= debug - replace surrogate-pair by bmp
		// =================
		// =================

		cps = CodepointSupport.DEBUG;
		// XodXs.abdXllaX
		arr = "C0odE3s.abdU9llaH3".toCharArray();
		int alen = arr.length;
		int spcount = cps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		int disp = 0;
		replacement = cps.toCodepoint("F6");
		// ====================
		from = 0;
		to = 1;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------

		expected = "F6odE3s.abdU9llaH3".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, alen, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));
		// ====================
		from = 1;
		to = 2;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------

		expected = "C0F6dE3s.abdU9llaH3".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, alen, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 2;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------

		expected = "F6dE3s.abdU9llaH3".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, alen, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 4;
		to = 10;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
//		XodXs.abdXllaX
		expected = "C0odE3F6llaH3".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, alen, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 13;
		to = 14;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
//		XodXs.abdXllaX
		expected = "C0odE3s.abdU9llaF6".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, alen, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 12;
		to = 13;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
//		XodXs.abdXllaX
		expected = "C0odE3s.abdU9llF6H3".toCharArray();
		result = Lang.codepoint.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, cps);
		newlen = Lang.codepoint.replace.lengthOf.range(arr, alen, from, to, replacement, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

	}

	public void testReplaceAllCodepointByCodepoint() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		int from = 0;
		int to = 2;
		CodepointSupport cps = CodepointSupport.BMP;
		char[] expected = null;
		CharArray result = null;
		int target = 0, replacement = 0, alen = 0, disp = 0, spcount;
		// =================
		// =================
		// ================= bmp
		// =================
		// =================
		target = 'a';
		replacement = 'X';
		from = 0;
		to = len;
		expected = "codes.XbdullXh".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = 'a';
		replacement = 'X';
		from = 7;
		to = len;
		expected = "codes.abdullXh".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = 'l';
		replacement = 'X';
		from = 7;
		to = len;
		expected = "codes.abduXXah".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = 'l';
		replacement = 'X';
		from = 11;
		to = len;
		expected = "codes.abdulXah".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// =================
		// =================
		// ================= debug
		// =================
		// =================

		// ===========================
		cps = CodepointSupport.DEBUG;
		arr = "C0oD2es.A6B7dullaH3".toCharArray();
		alen = arr.length;
		spcount = cps.fixedPairsCount(arr, alen, 0, alen);
		len = alen - spcount;
		// ====================
		target = 'l';
		replacement = 'X';
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7duXXaH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = cps.toCodepoint("B7");
		replacement = 'X';
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6XdullaH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = 'l';
		replacement = cps.toCodepoint("Z7");
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7duZ7Z7aH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = cps.toCodepoint("H3");
		replacement = cps.toCodepoint("Z7");
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7dullaZ7".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = cps.toCodepoint("H3");
		replacement = cps.toCodepoint("Z7");
		from = 0;
		to = 6;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7dullaH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

	}

	public void testReplaceAllCodepointByChararray() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		int from = 0;
		int to = 2;
		CodepointSupport cps = CodepointSupport.BMP;
		char[] expected = null;
		CharArray result = null;
		int target = 0, alen = 0, disp = 0, spcount, rlen = 0;
		char[] replacement = null;

		// =================
		// =================
		// ================= bmp
		// =================
		// =================
		target = 'a';
		replacement = "C++".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "codes.C++bdullC++h".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, rlen, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = 'a';
		from = 7;
		to = len;
		expected = "codes.abdullC++h".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, rlen, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = 'l';
		from = 7;
		to = len;
		expected = "codes.abduC++C++ah".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, rlen, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = 'l';
		from = 11;
		to = len;
		expected = "codes.abdulC++ah".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, rlen, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		// ===========================
		// =========================== what if both same length?
		// ===========================
		// ===========================
		target = 'l';
		replacement = "+".toCharArray();
		rlen = replacement.length;

		target = 'l';
		from = 7;
		to = len;
		expected = "codes.abdu++ah".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, rlen, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));
		// ===========================
		from = 11;
		to = len;
		expected = "codes.abdul+ah".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, len), len, target, replacement, rlen, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// =================
		// =================
		// ================= debug
		// =================
		// =================

		// ===========================
		cps = CodepointSupport.DEBUG;
		arr = "C0oD2es.A6B7dullaH3".toCharArray();
		alen = arr.length;
		spcount = cps.fixedPairsCount(arr, alen, 0, alen);
		len = alen - spcount;
		// ====================
		target = 'l';
		replacement = "X".toCharArray();
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7duXXaH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, rlen, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = cps.toCodepoint("B7");		
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6XdullaH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, rlen, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = 'l';
		replacement = "Z7".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7duZ7Z7aH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, rlen, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = cps.toCodepoint("H3");
		replacement = "Z7".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7dullaZ7".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, rlen, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = cps.toCodepoint("H3");
		replacement = "Z7".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = 6;
		// -------------------
		disp = cps.extendablePairsCount(arr, alen, 0, from);
		from += disp;
		to += disp;
		disp = cps.extendablePairsCount(arr, alen, from, to);
		to += disp;
		// -------------------
		expected = "C0oD2es.A6B7dullaH3".toCharArray();
		result = Lang.codepoint.replace.all(Lang.copy.of.this_(arr, alen), alen, target, replacement, rlen, from, to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));
	}

}
