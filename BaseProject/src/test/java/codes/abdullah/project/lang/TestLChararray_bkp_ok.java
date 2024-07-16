package codes.abdullah.project.lang;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.digits.Digits;

public class TestLChararray_bkp_ok {
	@Test
	public void testChararray() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testIndex() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testRepeat() {
		// assertEquals("required impl", "");

	}

	@Test
	public void testRemove() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testIndexes() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testSplit() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testCrop() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testMark() {
		testMarkIndexes();
		testMarkRange();
	}

	private void testMarkRange() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		CodepointSupport sps = CodepointSupport.BMP;
		int from = 0;
		int to = 0;
		CharArray[] lines = null;
		String expected = null, result = null;

		// ===============
		// ===============
		// =============== one line test, no tabs
		// ===============
		// ===============

		from = 0;
		to = 4;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes.abdullah\n" + "^___^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 5;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes.abdullah\n" + "     ^_______^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 0;
		to = 1;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes.abdullah\n" + "^^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 4;
		to = 5;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes.abdullah\n" + "    ^^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 12;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes.abdullah\n" + "            ^^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// =============== one line test, with tabs
		// ===============
		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 0;
		to = 1;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "^_______^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 0;
		to = 2;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "^________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 1;
		to = 2;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "        ^^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 1;
		to = 5;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "        ^___^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 0;
		to = 9;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "^_________________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 5;
		to = 15;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "            ^______________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 11;
		to = 12;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "                    ^___^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 15;
		to = 16;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "                           ^^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 3;
		to = 8;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes		abdu		llah	\n"//
				+ "          ^_____________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 6;
		to = 8;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes		abdu		llah	\n"//
				+ "             ^__________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 7;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes		abdu		llah	\n"//
				+ "                ^_______________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 4;
		to = 16;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	codes		abdu		llah	\n"//
				+ "           ^______________________________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// =============== two lines test, no tabs
		// ===============
		// ===============

		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 0;
		to = 6;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "^_____\n"//
				+ "abdullah\n"//
				+ "^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 4;
		to = 10;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n" //
				+ "    ^_\n"//
				+ "abdullah\n"//
				+ "____^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 5;
		to = 6;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "     ^\n"//
				+ "abdullah\n"//
				+ "^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 6;
		to = 10;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "^___^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 9;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "   ^___^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 0;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n" + "^_____\n" + "abdullah\n" + "_______^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 12;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n" + "abdullah\n" + "      ^^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes||abdullah".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 3;
		to = 8;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "   ^__\n"//
				+ "\n"//
				+ "_\n"//
				+ "abdullah\n"//
				+ "_^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes||||abdullah".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 3;
		to = 10;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "   ^__\n"//
				+ "\n"//
				+ "_\n"//
				+ "\n"//
				+ "_\n"//
				+ "\n"//
				+ "_\n"//
				+ "abdullah\n" + "_^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// =============== multiline test, no tabs
		// ===============
		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 0;
		to = 16;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "^_____\n"//
				+ "abdullah\n"//
				+ "_________\n"//
				+ "java\n"//
				+ "_^\n"//
				+ "c++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 0;
		to = 20;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "^_____\n"//
				+ "abdullah\n"//
				+ "_________\n"//
				+ "java\n"//
				+ "_____\n"//
				+ "c++\n"//
				+ "^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 9;
		to = 21;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "   ^_____\n"//
				+ "java\n"//
				+ "_____\n"//
				+ "c++\n"//
				+ "_^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 5;
		to = 19;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "     ^\n"//
				+ "abdullah\n"//
				+ "_________\n"//
				+ "java\n"//
				+ "____^\n"//
				+ "c++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 12;
		to = 22;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "      ^__\n"//
				+ "java\n"//
				+ "_____\n"//
				+ "c++\n"//
				+ "__^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 2;
		to = 21;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "  ^___\n"//
				+ "abdullah\n"//
				+ "_________\n"//
				+ "java\n"//
				+ "_____\n"//
				+ "c++\n"//
				+ "_^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// ===============
		// =============== multiline test, with tabs
		// ===============
		// ===============

		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 0;
		to = 5;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	cod	s\n"//
				+ "^_______________^\n"//
				+ "abdu	lah\n"//
				+ "ja	a\n"//
				+ "	++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 7;
		to = 14;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	cod	s\n"//
				+ "abdu	lah\n" //
				+ "^_________^\n"//
				+ "ja	a\n" //
				+ "	++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 4;
		to = 12;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	cod	s\n"//
				+ "           ^______\n"//
				+ "abdu	lah\n"//
				+ "________^\n"//
				+ "ja	a\n"//
				+ "	++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 4;
		to = 19;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	cod	s\n"//
				+ "           ^______\n"//
				+ "abdu	lah\n"//
				+ "____________\n"//
				+ "ja	a\n"//
				+ "________^\n"//
				+ "	++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 18;
		to = 20;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	cod	s\n"//
				+ "abdu	lah\n"//
				+ "ja	a\n"//
				+ "  ^______^\n"//
				+ "	++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 4;
		to = 23;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', ' ', '_', sps);
		expected = "	cod	s\n"//
				+ "           ^______\n"//
				+ "abdu	lah\n"//
				+ "____________\n"//
				+ "ja	a\n"//
				+ "__________\n"//
				+ "	++\n"//
				+ "_________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// =============== multiline test, with tabs an surrogate-pairs
		// ===============
		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		int alen = arr.length;
		int spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 0;
		to = 1;
		// =================
		// ----------------------
		int fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "^_______^\n"//
				+ "A6bD8u	lA9h\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 1;
		to = 2;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "        ^^\n"//
				+ "A6bD8u	lA9h\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 1;
		to = 3;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "        ^__^\n"//
				+ "A6bD8u	lA9h\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 2;
		to = 3;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "         ^_^\n"//
				+ "A6bD8u	lA9h\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 2;
		to = 4;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "         ^__^\n"//
				+ "A6bD8u	lA9h\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 2;
		to = 5;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "         ^______^\n"//
				+ "A6bD8u	lA9h\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 3;
		to = 4;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "           ^^\n"//
				+ "A6bD8u	lA9h\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 3;
		to = 9;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "           ^______\n"//
				+ "A6bD8u	lA9h\n"//
				+ "___^\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 3;
		to = 10;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "           ^______\n"//
				+ "A6bD8u	lA9h\n"//
				+ "_____^\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 3;
		to = 12;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "           ^______\n"//
				+ "A6bD8u	lA9h\n"//
				+ "________^\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 3;
		to = 18;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "           ^______\n"//
				+ "A6bD8u	lA9h\n"//
				+ "_____________\n"//
				+ "J2a	a\n"//
				+ "___^\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 8;
		to = 13;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "A6bD8u	lA9h\n"//
				+ "  ^______^\n"//
				+ "J2a	a\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 8;
		to = 16;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n"//
				+ "A6bD8u	lA9h\n"//
				+ "  ^__________\n"//
				+ "J2a	a\n"//
				+ "^\n"//
				+ "	C1C2";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		sps = CodepointSupport.DEBUG;
		arr = ">cO4d>s|A6bD8u>lA9h|J2a>a|>C1C2".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		alen = arr.length;
		spcount = sps.fixedPairsCount(arr, alen);
		len = alen - spcount;
		// =================
		from = 14;
		to = 23;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', ' ', '_', sps);
		expected = "	cO4d	s\n" + "A6bD8u	lA9h\n" + "           ^_\n" + "J2a	a\n" + "__________\n" + "	C1C2\n"
				+ "__________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);
	}

	boolean test = true;

	private void testMarkIndexes() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		CodepointSupport sps = CodepointSupport.BMP;

		// ===============
		// ===============
		// =============== one line test, no tabs
		// ===============
		// ===============

		int[] indexes = new int[] { 0, 4, 8, 10 };
		CharArray[] lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		String expected = "codes.abdullah\n" + "^___^___^_^";
		String result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		indexes = Digits.ints.range(len);
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "codes.abdullah\n" + "^^^^^^^^^^^^^^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		indexes = new int[] { 13 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "codes.abdullah\n" + "_____________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// =============== one line test, with tabs
		// ===============
		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 0 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 4 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "___________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 10 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "___________________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 0, 4, 8, 10 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "^__________^_____^_^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 0, 4, 8, 10, 14 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "^__________^_____^_^______^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 15 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes	abdu	llah	\n" + "___________________________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// =============== multiline, no tabs
		// ===============
		// ===============

		// ===============

		arr = "codes|abdullah||java|c++|R|rust|||i-love-java".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		indexes = new int[] { 22 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "\n"//
				+ "java\n"//
				+ "c++\n"//
				+ "_^\n"//
				+ "R\n"//
				+ "rust\n"//
				+ "\n"//
				+ "\n"//
				+ "i-love-java";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah||java|c++|R|rust|||i-love-java".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		indexes = new int[] { 40, 42, 44 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "\n"//
				+ "java\n"//
				+ "c++\n"//
				+ "R\n"//
				+ "rust\n"//
				+ "\n"//
				+ "\n"//
				+ "i-love-java\n"//
				+ "______^_^_^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		arr = "codes|abdullah||java|c++|R|rust|||i-love-java".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		indexes = new int[] { 0, 8, 12, 19, 21, 22, 23, 25, 40 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "codes\n"//
				+ "^\n"//
				+ "abdullah\n"//
				+ "__^___^\n"//
				+ "\n"//
				+ "java\n"//
				+ "___^\n"//
				+ "c++\n"//
				+ "^^^\n"//
				+ "R\n"//
				+ "^\n"//
				+ "rust\n"//
				+ "\n"//
				+ "\n"//
				+ "i-love-java\n"//
				+ "______^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		// ===============
		// =============== multiline with tabs
		// ===============

		// ===============

		arr = ">codes|abd>>ulla>h||java|>c+>+|R|ru>st|||i-l>>ove>-java".replaceAll("[|]", "\n").replaceAll("[>]", "\t")
				.toCharArray();
		len = arr.length;
		indexes = new int[] { 1 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes\n" + "________^\n" + "abd		ulla	h\n" + "\n" + "java\n" + "	c+	+\n" + "R\n"
				+ "ru	st\n" + "\n" + "\n" + "i-l		ove	-java";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes|abd>>ulla>h||java|>c+>+|R|ru>st|||i-l>>ove>-java".replaceAll("[|]", "\n").replaceAll("[>]", "\t")
				.toCharArray();
		len = arr.length;
		indexes = new int[] { 9 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes\n"//
				+ "abd		ulla	h\n"//
				+ "__^\n"//
				+ "\n"//
				+ "java\n"//
				+ "	c+	+\n"//
				+ "R\n"//
				+ "ru	st\n"//
				+ "\n"//
				+ "\n"//
				+ "i-l		ove	-java";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes|abd>>ulla>h||java|>c+>+|R|ru>st|||i-l>>ove>-java".replaceAll("[|]", "\n").replaceAll("[>]", "\t")
				.toCharArray();
		len = arr.length;
		indexes = new int[] { 0, 5, 9, 16, 17, 19, 26, 27, 28, 29, 30, 38, 39, 40, 44, 45, 49, 50 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', ' ', '_', sps);
		expected = "	codes\n"//
				+ "^___________^\n"//
				+ "abd		ulla	h\n"//
				+ "__^_________________^___^\n"//
				+ "\n"//
				+ "^\n"//
				+ "java\n"//
				+ "	c+	+\n"//
				+ "________^^^_____^^\n"//
				+ "R\n"//
				+ "ru	st\n"//
				+ "__________^\n"//
				+ "\n"//
				+ "^\n"//
				+ "\n"//
				+ "^\n"//
				+ "i-l		ove	-java\n"//
				+ "___^____^__________^____^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);
	}

	@Test
	public void testAbbreviate() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testEllipse() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testCount() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testSkip() {
		// assertEquals("required impl", "");
	}

	@Test
	public void testTrim() {
		// assertEquals("required impl", "");
	}

}
