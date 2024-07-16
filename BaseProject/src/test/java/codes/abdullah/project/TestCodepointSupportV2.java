package codes.abdullah.project;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.lang.Lang;

//cod𐂽s.𐁕bdullah
public class TestCodepointSupportV2 {
	@Test
	public void testUnsupportedLittle() {
		Endian read = Endian.LITTLE;
		CodepointSupport s = CodepointSupport.BMP;
		// ======================
		String x = "cod𐂽s.𐁕bdullah";
		char[] arr = x.toCharArray();
		int len = arr.length;
		// ================ is-supported
		assertFalse(s.isSupported());
		// =============== is
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			char c = arr[i];
			assertFalse(Integer.toString(cp), s.isPair(cp));
			assertFalse(Integer.toString(cp), s.isPair(x, i));
			assertFalse(Integer.toString(cp), s.isPair(arr, len, i));
			if (Character.isHighSurrogate((char) c)) {
				assertTrue(Integer.toString(cp), s.isHigh(c));
			} else {
				assertFalse(Integer.toString(cp), s.isHigh(c));
			}

			if (Character.isLowSurrogate((char) c)) {
				assertTrue(Integer.toString(cp), s.isLow(c));
			} else {
				assertFalse(Integer.toString(cp), s.isLow(c));
			}
		}
		// ================ is-backward
		for (int i = x.length(); i > 0; i--) {
			assertEquals(false, s.isPairBackwardly(x, i));
			assertEquals(false, s.isPairBackwardly(x.toCharArray(), x.length(), i));
		}
		// ================ is-intersect
		for (int i = x.length() - 1; i >= 0; i--) {
			assertEquals(false, s.isPairIntersectly(x, i));
			assertEquals(false, s.isPairIntersectly(x.toCharArray(), x.length(), i));
		}
		// =============== length-of
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			if (i == 3 || i == 7) {
				assertEquals(Integer.toString(cp), 0, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(x, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
		}
		// ================= code-point-at
		for (int i = 0; i < x.length(); i++) {
			assertEquals(x.charAt(i), s.getCodepoint(x, i));
			assertEquals(x.charAt(i), s.getCodepoint(x.toCharArray(), x.length(), i));
		}
		// ================ length-of-backward
		for (int i = x.length(); i > 0; i--) {
			int cp = x.codePointAt(i - 1);
			if (i == 4 || i == 8) {
				assertEquals(Integer.toString(cp), 0, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(x, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
		}
		// =============== to high / low
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			assertEquals(Integer.toString(cp), (char) cp, s.toHigh(cp));
			assertEquals(Integer.toString(cp), (char) cp, s.toLow(cp));
		}
		// ================ to-code-point | char[]
		String u = "𐂽𐁕ac";
		char[] y = u.toCharArray();
		assertEquals(-1, s.toCodepoint(y[0], y[1]));
		assertEquals(-1, s.toCodepoint(y[2], y[3]));
		assertEquals(-1, s.toCodepoint(y[4], y[5]));
		// =============== to-code-point | int[]
		int[] z = Lang.primitive.to.e.ints(y);
		assertEquals(-1, s.toCodepoint(z[0], z[1]));
		assertEquals(-1, s.toCodepoint(z[2], z[3]));
		assertEquals(-1, s.toCodepoint(z[4], z[5]));
		// =============== to-code-points
		int[] z2 = s.toCodepointArray(u, 0, u.length());
		assertArrayEquals(z, z2);
		// =============== count | char-sequence
		assertEquals(x.length(), s.countCodepoints(x, 0, x.length())); // cod??s.??bdullah

		assertEquals(15, s.countCodepoints(x, 1, x.length())); // od??s.??bdullah
		assertEquals(14, s.countCodepoints(x, 2, x.length())); // d??s.??bdullah

		assertEquals(2, s.countCodepoints(x, 1, 3)); // od
		assertEquals(3, s.countCodepoints(x, 1, 4)); // od?
		assertEquals(3, s.countCodepoints(x, 2, 5)); // d??

		assertEquals(5, s.countCodepoints(x, 3, 8)); // ??s.?
		assertEquals(6, s.countCodepoints(x, 3, 9)); // ??s.??

		assertEquals(9, s.countCodepoints(x, 7, x.length())); // ??bdullah
		assertEquals(8, s.countCodepoints(x, 8, x.length())); // ??bdullah

		assertEquals(7, s.countCodepoints(x, 9, x.length())); // bdullah
		// ================= count | char[]
		y = x.toCharArray();
		assertEquals(y.length, s.countCodepoints(y, y.length, 0, x.length())); // cod??s.??bdullah

		assertEquals(15, s.countCodepoints(y, y.length, 1, x.length())); // od??s.??bdullah
		assertEquals(14, s.countCodepoints(y, y.length, 2, x.length())); // d??s.??bdullah

		assertEquals(2, s.countCodepoints(y, y.length, 1, 3)); // od
		assertEquals(3, s.countCodepoints(y, y.length, 1, 4)); // od?
		assertEquals(3, s.countCodepoints(y, y.length, 2, 5)); // d??

		assertEquals(5, s.countCodepoints(y, y.length, 3, 8)); // ??s.?
		assertEquals(6, s.countCodepoints(y, y.length, 3, 9)); // ??s.??

		assertEquals(9, s.countCodepoints(y, y.length, 7, x.length())); // ??bdullah
		assertEquals(8, s.countCodepoints(y, y.length, 8, x.length())); // ??bdullah

		assertEquals(7, s.countCodepoints(y, y.length, 9, x.length())); // bdullah
		// ===============
		// ===============
		// ===============
		// ===============

		int[] ii = { 55296, 111, 100, 55296, 56509, 115, 46, 55296, 56405, 98, 100, 117, 108, 108, 97, 56405 };
		y = Lang.primitive.to.e.chars(ii);
		len = y.length;

		assertEquals(-1, s.indexOfBroken(y, len, 0, len));

		assertEquals(-1, s.indexOfBroken(y, len, 3, len));
		assertEquals(-1, s.indexOfBroken(y, len, 4, len));
		assertEquals(-1, s.indexOfBroken(y, len, 5, len));

		assertEquals(-1, s.indexOfBroken(y, len, 3, 4));
		assertEquals(-1, s.indexOfBroken(y, len, 4, 8));
		assertEquals(-1, s.indexOfBroken(y, len, 5, 9));

		// ===================
		x = new String(y, 0, y.length);
		assertEquals(-1, s.indexOfBroken(y, len, 0, len));

		assertEquals(-1, s.indexOfBroken(y, len, 3, len));
		assertEquals(-1, s.indexOfBroken(y, len, 4, len));
		assertEquals(-1, s.indexOfBroken(y, len, 5, len));

		assertEquals(-1, s.indexOfBroken(y, len, 3, 4));
		assertEquals(-1, s.indexOfBroken(y, len, 4, 8));
		assertEquals(-1, s.indexOfBroken(y, len, 5, 9));

	}

	@Test
	public void testSupportedLittle() {
		CodepointSupport s = CodepointSupport.SUPPORTED;
		// ======================
		String x = "cod𐂽s.𐁕bdullah";
		final char[] arr = x.toCharArray();
		int len = arr.length;
		// ================ is-supported
		assertTrue(s.isSupported());
		// =============== is
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			boolean supplementary = isIt(cp);
			assertEquals(Integer.toString(cp), supplementary, s.isPair(cp));

			assertEquals(Integer.toString(cp), supplementary, s.isPair(x, i));
			assertEquals(Integer.toString(cp), supplementary, s.isPair(arr, len, i));

			int high = supplementary ? Character.highSurrogate(cp) : cp;
			int low = supplementary ? Character.lowSurrogate(cp) : cp;

			assertEquals(Integer.toString(cp), Character.isHighSurrogate((char) high), s.isHigh((char) high));
			assertEquals(Integer.toString(cp), Character.isLowSurrogate((char) low), s.isLow((char) low));

			assertEquals(Integer.toString(cp), Character.isHighSurrogate((char) high), s.isHigh(high));
			assertEquals(Integer.toString(cp), Character.isLowSurrogate((char) low), s.isLow(low));
		}
		// ================ is-backward
		for (int i = x.length(); i > 0; i--) {
			int cp = x.codePointBefore(i);
			boolean supplementary = isIt(cp);

			assertEquals(Integer.toString(cp), supplementary, s.isPairBackwardly(x, i));
			assertEquals(Integer.toString(cp), supplementary, s.isPairBackwardly(x.toCharArray(), x.length(), i));

		}
		// ================ is-intersect
		for (int i = x.length() - 1; i > 0; i--) {
			int cp = x.codePointAt(i - 1);
			boolean supplementary = isIt(cp);
			assertEquals(supplementary, s.isPairIntersectly(x, i));
			assertEquals(supplementary, s.isPairIntersectly(x.toCharArray(), x.length(), i));
		}
		// =============== length-of
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			if (i == 3 || i == 7) {
				assertEquals(Integer.toString(cp), 2, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(x, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
		}
		// ================= code-point-at
		for (int i = 0; i < x.length(); i++) {
			assertEquals(x.codePointAt(i), s.getCodepoint(x, i));
			assertEquals(x.codePointAt(i), s.getCodepoint(x.toCharArray(), x.length(), i));
		}
		// ================= code-point-backward
		for (int i = x.length(); i > 0; i--) {// cod𐂽s.𐁕bdullah
			int cp = s.getCodepointBackwardly(x, i);
			cp = i == 5 ? 65725 : i == 9 ? 65621 : cp;
			assertEquals(cp, s.getCodepointBackwardly(x, i));
			assertEquals(cp, s.getCodepointBackwardly(x.toCharArray(), x.length(), i));
		}

		// ================ length-of-backward
		for (int i = x.length(); i > 0; i--) {
			int cp = s.getCodepointBackwardly(x, i);
			if (i == 5 || i == 9) {
				assertEquals(Integer.toString(cp), 2, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(x, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
		}
		// ================ length-of-intersect
		for (int i = 0; i > x.length(); i++) {
			int cp = x.codePointAt(i - 1);
			if (i == 4 || i == 8) {
				assertEquals(Integer.toString(cp), 2, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOfIntersectly(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfIntersectly(x, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfIntersectly(arr, len, i));
		}
		// =============== to high / low
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			assertEquals(Integer.toString(cp), Character.highSurrogate(cp), s.toHigh(cp));
			assertEquals(Integer.toString(cp), Character.lowSurrogate(cp), s.toLow(cp));
		}
		// ================ to-code-point | char[]
		String u = "𐂽𐁕ac";
		char[] y = u.toCharArray();
		assertEquals(Character.toCodePoint(y[0], y[1]), s.toCodepoint(y[0], y[1]));
		assertEquals(Character.toCodePoint(y[2], y[3]), s.toCodepoint(y[2], y[3]));
		assertEquals(Character.toCodePoint(y[4], y[5]), s.toCodepoint(y[4], y[5]));
		// =============== to-code-point | int[]
		int[] z = Lang.primitive.to.e.ints(y);
		assertEquals(Character.toCodePoint((char) z[0], (char) z[1]), s.toCodepoint(z[0], z[1]));
		assertEquals(Character.toCodePoint((char) z[2], (char) z[3]), s.toCodepoint(z[2], z[3]));
		assertEquals(Character.toCodePoint((char) z[4], (char) z[5]), s.toCodepoint(z[4], z[5]));
		// =============== to-code-points
		z = new int[] { Character.toCodePoint(y[0], y[1]), Character.toCodePoint(y[2], y[3]), y[4], y[5] };
		int[] z2 = s.toCodepointArray(u, 0, u.length());
		assertArrayEquals(z, z2);
		// =============== count | char-sequence
		assertEquals(x.codePointCount(0, x.length()), s.countCodepoints(x, 0, x.length())); // cod??s.??bdullah

		assertEquals(13, s.countCodepoints(x, 1, x.length())); // od??s.??bdullah
		assertEquals(12, s.countCodepoints(x, 2, x.length())); // d??s.??bdullah

		assertEquals(2, s.countCodepoints(x, 1, 3)); // od
		assertEquals(3, s.countCodepoints(x, 1, 4)); // od?
		assertEquals(2, s.countCodepoints(x, 2, 5)); // d??

		assertEquals(4, s.countCodepoints(x, 3, 8)); // ??s.?
		assertEquals(4, s.countCodepoints(x, 3, 9)); // ??s.??

		assertEquals(8, s.countCodepoints(x, 7, x.length())); // ??bdullah
		assertEquals(8, s.countCodepoints(x, 8, x.length())); // ?bdullah

		assertEquals(7, s.countCodepoints(x, 9, x.length())); // bdullah
		// ================= count | char[]
		y = x.toCharArray();
		assertEquals(x.codePointCount(0, x.length()), s.countCodepoints(y, y.length, 0, x.length())); // cod??s.??bdullah

		assertEquals(13, s.countCodepoints(y, y.length, 1, x.length())); // od??s.??bdullah
		assertEquals(12, s.countCodepoints(y, y.length, 2, x.length())); // d??s.??bdullah

		assertEquals(2, s.countCodepoints(y, y.length, 1, 3)); // od
		assertEquals(3, s.countCodepoints(y, y.length, 1, 4)); // od?
		assertEquals(2, s.countCodepoints(y, y.length, 2, 5)); // d??

		assertEquals(4, s.countCodepoints(y, y.length, 3, 8)); // ??s.?
		assertEquals(4, s.countCodepoints(y, y.length, 3, 9)); // ??s.??

		assertEquals(8, s.countCodepoints(y, y.length, 7, x.length())); // ??bdullah
		assertEquals(8, s.countCodepoints(y, y.length, 8, x.length())); // ??bdullah

		assertEquals(7, s.countCodepoints(y, y.length, 9, x.length())); // bdullah
		// ===============
		// ===============
		// ===============
		// ===============

		int[] ii = { 55296, 111, 100, 55296, 56509, 115, 46, 55296, 56405, 98, 100, 117, 108, 108, 97, 56405 };
		y = Lang.primitive.to.e.chars(ii);
		len = y.length;

		assertEquals(0, s.indexOfBroken(y, len, 0, len));

		assertEquals(15, s.indexOfBroken(y, len, 1, len));

		assertEquals(15, s.indexOfBroken(y, len, 3, len));
		assertEquals(4, s.indexOfBroken(y, len, 4, len));
		assertEquals(15, s.indexOfBroken(y, len, 5, len));

		assertEquals(-1, s.indexOfBroken(y, len, 3, 4));
		assertEquals(4, s.indexOfBroken(y, len, 4, 8));
		assertEquals(-1, s.indexOfBroken(y, len, 5, 9));

		assertEquals(15, s.indexOfBroken(y, len, 7, len));
		assertEquals(-1, s.indexOfBroken(y, len, 7, len - 1));

		// ===================
		x = new String(y, 0, y.length);

		assertEquals(0, s.indexOfBroken(x, 0, len));

		assertEquals(15, s.indexOfBroken(x, 1, len));

		assertEquals(15, s.indexOfBroken(x, 3, len));
		assertEquals(4, s.indexOfBroken(x, 4, len));
		assertEquals(15, s.indexOfBroken(x, 5, len));

		assertEquals(-1, s.indexOfBroken(x, 3, 4));
		assertEquals(4, s.indexOfBroken(x, 4, 8));
		assertEquals(-1, s.indexOfBroken(x, 5, 9));

		assertEquals(15, s.indexOfBroken(x, 7, len));
		assertEquals(-1, s.indexOfBroken(x, 7, len - 1));

	}

//	@Test
	public void testSupportedBig() {
		CodepointSupport s = CodepointSupport.SUPPORTED;
		// ======================
		String x = "cod𐂽s.𐁕bdullah";
		final char[] arr = x.toCharArray();
		int len = arr.length;
		// ================ is-supported
		assertTrue(s.isSupported());
		// =============== is
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(Endian.BIG.index(i, x.length(), x.length()));
			boolean supplementary = isIt(cp);

			assertEquals(Integer.toString(cp), supplementary, s.isPair(cp));
			assertEquals(Integer.toString(cp), supplementary, s.isPair(x, i));
			assertEquals(Integer.toString(cp), supplementary, s.isPair(arr, len, i));

			int high = supplementary ? Character.highSurrogate(cp) : cp;
			int low = supplementary ? Character.lowSurrogate(cp) : cp;

			assertEquals(Integer.toString(cp), Character.isHighSurrogate((char) high), s.isHigh((char) high));
			assertEquals(Integer.toString(cp), Character.isLowSurrogate((char) low), s.isLow((char) low));

			assertEquals(Integer.toString(cp), Character.isHighSurrogate((char) high), s.isHigh(high));
			assertEquals(Integer.toString(cp), Character.isLowSurrogate((char) low), s.isLow(low));
		}
		// ================ is-backward
		for (int i = x.length(); i > 0; i--) {
			int cp = x.codePointAt(Endian.BIG.index(i - 1, x.length(), x.length()));
			boolean supplementary = isIt(cp);
			assertEquals(cp + " @ " + i, supplementary, s.isPairBackwardly(x, i));
			assertEquals(cp + " @ " + i, supplementary, s.isPairBackwardly(x.toCharArray(), x.length(), i));
		}

		// ================ is-intersect
		for (int i = x.length() - 1; i > 0; i--) {
			int cp = x.codePointAt(i - 1);
			boolean supplementary = isIt(cp);
			assertEquals(cp + " @ " + i, supplementary, s.isPairIntersectly(x, i));
			assertEquals(cp + " @ " + i, supplementary, s.isPairIntersectly(x.toCharArray(), x.length(), i));
		}
		// =============== length-of
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			if (i == 3 || i == 7) {
				assertEquals(Integer.toString(cp), 2, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(x, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
		}
		// ================= code-point-at
		for (int i = 0; i < x.length(); i++) {
			assertEquals(x.codePointAt(i), s.getCodepoint(x, i));
			assertEquals(x.codePointAt(i), s.getCodepoint(x.toCharArray(), x.length(), i));
		}

		// ================= code-point-backward
		for (int i = x.length(); i > 0; i--) {// cod𐂽s.𐁕bdullah
			int cp = x.codePointBefore(i);
//			cp = i == 4 ? 65725 : i == 8 ? 65621 : cp;
			assertEquals(cp, s.getCodepointBackwardly(x, i));
			assertEquals(cp, s.getCodepointBackwardly(x.toCharArray(), x.length(), i));
		}

		// ================ length-of-backward
		for (int i = x.length() - 1; i > 0; i--) {
			int cp = x.codePointAt(i - 1);
			if (i == 4 || i == 8) {
				assertEquals(Integer.toString(cp), 2, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(x, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
		}
		// =============== to high / low
		for (int i = 0; i < x.length(); i++) {
			int cp = x.codePointAt(i);
			assertEquals(Integer.toString(cp), Character.highSurrogate(cp), s.toHigh(cp));
			assertEquals(Integer.toString(cp), Character.lowSurrogate(cp), s.toLow(cp));
		}
		// ================ to-code-point | char[]
		String u = "𐂽𐁕ac";
		char[] y = u.toCharArray();
		assertEquals(Character.toCodePoint(y[0], y[1]), s.toCodepoint(y[0], y[1]));
		assertEquals(Character.toCodePoint(y[2], y[3]), s.toCodepoint(y[2], y[3]));
		assertEquals(Character.toCodePoint(y[4], y[5]), s.toCodepoint(y[4], y[5]));
		// =============== to-code-point | int[]
		int[] z = Lang.primitive.to.e.ints(y);
		assertEquals(Character.toCodePoint((char) z[0], (char) z[1]), s.toCodepoint(z[0], z[1]));
		assertEquals(Character.toCodePoint((char) z[2], (char) z[3]), s.toCodepoint(z[2], z[3]));
		assertEquals(Character.toCodePoint((char) z[4], (char) z[5]), s.toCodepoint(z[4], z[5]));
		// =============== to-code-points
		z = new int[] { Character.toCodePoint(y[0], y[1]), Character.toCodePoint(y[2], y[3]), y[4], y[5] };
		int[] z2 = s.toCodepointArray(u, 0, u.length());
		assertArrayEquals(z, z2);
		// =============== count | char-sequence
		assertEquals(x.codePointCount(0, x.length()), s.countCodepoints(x, 0, x.length())); // cod??s.??bdullah

		assertEquals(13, s.countCodepoints(x, 1, x.length())); // od??s.??bdullah
		assertEquals(12, s.countCodepoints(x, 2, x.length())); // d??s.??bdullah

		assertEquals(2, s.countCodepoints(x, 1, 3)); // od
		assertEquals(3, s.countCodepoints(x, 1, 4)); // od?
		assertEquals(2, s.countCodepoints(x, 2, 5)); // d??

		assertEquals(4, s.countCodepoints(x, 3, 8)); // ??s.?
		assertEquals(4, s.countCodepoints(x, 3, 9)); // ??s.??

		assertEquals(8, s.countCodepoints(x, 7, x.length())); // ??bdullah
		assertEquals(8, s.countCodepoints(x, 8, x.length())); // ?bdullah

		assertEquals(7, s.countCodepoints(x, 9, x.length())); // bdullah
		// ================= count | char[]
		y = x.toCharArray();
		assertEquals(x.codePointCount(0, x.length()), s.countCodepoints(y, y.length, 0, x.length())); // cod??s.??bdullah

		assertEquals(13, s.countCodepoints(y, y.length, 1, x.length())); // od??s.??bdullah
		assertEquals(12, s.countCodepoints(y, y.length, 2, x.length())); // d??s.??bdullah

		assertEquals(2, s.countCodepoints(y, y.length, 1, 3)); // od
		assertEquals(3, s.countCodepoints(y, y.length, 1, 4)); // od?
		assertEquals(2, s.countCodepoints(y, y.length, 2, 5)); // d??

		assertEquals(4, s.countCodepoints(y, y.length, 3, 8)); // ??s.?
		assertEquals(4, s.countCodepoints(y, y.length, 3, 9)); // ??s.??

		assertEquals(8, s.countCodepoints(y, y.length, 7, x.length())); // ??bdullah
		assertEquals(8, s.countCodepoints(y, y.length, 8, x.length())); // ??bdullah

		assertEquals(7, s.countCodepoints(y, y.length, 9, x.length())); // bdullah
		// ===============
		// ===============
		// ===============
		// ===============

		int[] ii = { 55296, 111, 100, 55296, 56509, 115, 46, 55296, 56405, 98, 100, 117, 108, 108, 97, 56405 };
		y = Lang.primitive.to.e.chars(ii);
		len = y.length;

		assertEquals(0, s.indexOfBroken(y, len, 0, len));

		assertEquals(15, s.indexOfBroken(y, len, 1, len));

		assertEquals(15, s.indexOfBroken(y, len, 3, len));
		assertEquals(4, s.indexOfBroken(y, len, 4, len));
		assertEquals(15, s.indexOfBroken(y, len, 5, len));

		assertEquals(-1, s.indexOfBroken(y, len, 3, 4));
		assertEquals(4, s.indexOfBroken(y, len, 4, 8));
		assertEquals(-1, s.indexOfBroken(y, len, 5, 9));

		assertEquals(15, s.indexOfBroken(y, len, 7, len));
		assertEquals(-1, s.indexOfBroken(y, len, 7, len - 1));

		// ===================
		x = new String(y, 0, y.length);

		assertEquals(0, s.indexOfBroken(x, 0, len));

		assertEquals(15, s.indexOfBroken(x, 1, len));

		assertEquals(15, s.indexOfBroken(x, 3, len));
		assertEquals(4, s.indexOfBroken(x, 4, len));
		assertEquals(15, s.indexOfBroken(x, 5, len));

		assertEquals(-1, s.indexOfBroken(x, 3, 4));
		assertEquals(4, s.indexOfBroken(x, 4, 8));
		assertEquals(-1, s.indexOfBroken(x, 5, 9));

		assertEquals(15, s.indexOfBroken(x, 7, len));
		assertEquals(-1, s.indexOfBroken(x, 7, len - 1));

	}

	@Test
	public void testDebugLittle() {
		CodepointSupport s = CodepointSupport.DEBUG;
		// ======================
		String j = "c2dA1s.J9bdullAh";
		char[] arr = j.toCharArray();
		int len = arr.length;
		// ================ is-supported
		assertTrue(s.isSupported());
		// =============== is
		for (int i = 0; i < j.length(); i++) {
			int cp = s.getCodepoint(j, i);
			boolean supplementary = i == 3 || i == 7;
			assertEquals(Integer.toString(cp), supplementary, s.isPair(cp));
			assertEquals(Integer.toString(cp), supplementary, s.isPair(j, i));
			assertEquals(Integer.toString(cp), supplementary, s.isPair(arr, len, i));

			int high = supplementary ? s.toHigh(cp) : cp;
			int low = supplementary ? s.toLow(cp) : cp;
			boolean isHigh = i == 3 || i == 7 || i == 14;
			boolean isLow = i == 1 || i == 4 || i == 8;
			assertEquals(Integer.toString(cp), supplementary || isHigh, s.isHigh((char) high));
			assertEquals(Integer.toString(cp), supplementary || isLow, s.isLow((char) low));

			assertEquals(Integer.toString(cp), supplementary || isHigh, s.isHigh(high));
			assertEquals(Integer.toString(cp), supplementary || isLow, s.isLow(low));
		}

		// ================ is-backward
		for (int i = j.length(); i > 0; i--) {
			assertEquals(i == 5 || i == 9, s.isPairBackwardly(j, i));
			assertEquals(i == 5 || i == 9, s.isPairBackwardly(j.toCharArray(), j.length(), i));
		}

		// ================ is-intersect
		for (int i = j.length() - 1; i > 0; i--) {
			assertEquals(i == 4 || i == 8, s.isPairIntersectly(j, i));
			assertEquals(i == 4 || i == 8, s.isPairIntersectly(j.toCharArray(), j.length(), i));
		}
		// =============== length-of
		for (int i = 0; i < j.length(); i++) {
			int cp = s.getCodepoint(j, i);
			if (i == 3 || i == 7) {
				assertEquals(Integer.toString(cp), 2, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(j, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOf(arr, len, i));
		}
		// ================= code-point-at
		for (int i = 0; i < j.length(); i++) {
			int cp = j.codePointAt(i);
			cp = i == 3 ? 65537 : i == 7 ? 74761 : cp;
			assertEquals(cp, s.getCodepoint(j, i));
			assertEquals(cp, s.getCodepoint(j.toCharArray(), j.length(), i));
		}

		// ================= code-point-backward
		for (int i = j.length(); i > 0; i--) { // c2dA1s.J9bdullAh
			int cp = j.codePointBefore(i);
			cp = i == 5 ? 65537 : i == 9 ? 74761 : cp;
			assertEquals(cp, s.getCodepointBackwardly(j, i));
			assertEquals(cp, s.getCodepointBackwardly(j.toCharArray(), j.length(), i));
		}

		// ================ length-of-backward
		for (int i = j.length(); i > 0; i--) {
			int cp = s.getCodepointBackwardly(j, i);
			if (i == 5 || i == 9) {
				assertEquals(Integer.toString(cp), 2, s.lengthOf(cp));
				continue;
			}
			assertEquals(Integer.toString(cp), 1, s.lengthOf(cp));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(j, i));
			assertEquals(Integer.toString(cp), 1, s.lengthOfBackwardly(arr, len, i));
		}
		// =============== to high / low
		for (int i = 0; i < j.length(); i++) {
			int cp = j.codePointAt(i);
			assertEquals(Integer.toString(cp), Character.highSurrogate(cp), s.toHigh(cp));
			assertEquals(Integer.toString(cp), Character.lowSurrogate(cp), s.toLow(cp));
		}
		// =============== to high / low
		for (int i = 0; i < j.length(); i++) {
			int cp = s.getCodepoint(j, i);
			int x = i == 3 ? 'A' : i == 7 ? 'J' : Character.highSurrogate(cp);
			int y = i == 3 ? '1' : i == 7 ? '9' : Character.lowSurrogate(cp);
			assertEquals(Integer.toString(cp), x, s.toHigh(cp));
			assertEquals(Integer.toString(cp), y, s.toLow(cp));
		}
		// ================ to-code-point | char[]
		String u = "A1J9ac";
		char[] y = u.toCharArray();
		assertEquals(65537, s.toCodepoint(y[0], y[1]));
		assertEquals(74761, s.toCodepoint(y[2], y[3]));
		assertEquals(Character.toCodePoint(y[4], y[5]), s.toCodepoint(y[4], y[5]));
		// =============== to-code-point | int[]
		int[] z = Lang.primitive.to.e.ints(y);
		assertEquals(65537, s.toCodepoint(z[0], z[1]));
		assertEquals(74761, s.toCodepoint(z[2], z[3]));
		assertEquals(Character.toCodePoint((char) z[4], (char) z[5]), s.toCodepoint(z[4], z[5]));
		// =============== to-code-points
		z = new int[] { 65537, 74761, y[4], y[5] };
		int[] z2 = s.toCodepointArray(u, 0, u.length());
		assertArrayEquals(z, z2);
		// =============== count | char-sequence

		assertEquals(14, s.countCodepoints(j, 0, j.length()));

		assertEquals(13, s.countCodepoints(j, 1, j.length())); // 2dA1s.J9bdullAh
		assertEquals(12, s.countCodepoints(j, 2, j.length())); // dA1s.J9bdullAh

		assertEquals(2, s.countCodepoints(j, 1, 3)); // 2d
		assertEquals(3, s.countCodepoints(j, 1, 4)); // 2dA
		assertEquals(2, s.countCodepoints(j, 2, 5)); // dA1

		assertEquals(4, s.countCodepoints(j, 3, 8)); // A1s.J
		assertEquals(4, s.countCodepoints(j, 3, 9)); // A1s.J9

		assertEquals(8, s.countCodepoints(j, 7, j.length())); // J9bdullAh
		assertEquals(8, s.countCodepoints(j, 8, j.length())); // 9bdullAh

		assertEquals(7, s.countCodepoints(j, 9, j.length())); // bdullAh
		// ================= count | char[] "c2dA1s.J9bdullAh"
		y = j.toCharArray();
		assertEquals(14, s.countCodepoints(y, y.length, 0, j.length()));

		assertEquals(13, s.countCodepoints(y, y.length, 1, j.length())); // 2dA1s.J9bdullAh
		assertEquals(12, s.countCodepoints(y, y.length, 2, j.length())); // dA1s.J9bdullAh

		assertEquals(2, s.countCodepoints(y, y.length, 1, 3)); // 2d
		assertEquals(3, s.countCodepoints(y, y.length, 1, 4)); // 2dA
		assertEquals(2, s.countCodepoints(y, y.length, 2, 5)); // dA1

		assertEquals(4, s.countCodepoints(y, y.length, 3, 8)); // A1s.J
		assertEquals(4, s.countCodepoints(y, y.length, 3, 9)); // A1s.J9

		assertEquals(8, s.countCodepoints(y, y.length, 7, j.length())); // J9bdullAh
		assertEquals(8, s.countCodepoints(y, y.length, 8, j.length())); // 9bdullAh

		assertEquals(7, s.countCodepoints(y, y.length, 9, j.length())); // bdullAh
		// ===============
		// ===============
		// ===============
		// ===============

		j = "AodA1s.J9bdulla9";
		int[] ii = Lang.primitive.to.e.ints(j.toCharArray());
		y = Lang.primitive.to.e.chars(ii);
		len = y.length;

		assertEquals(0, s.indexOfBroken(y, len, 0, len));

		assertEquals(15, s.indexOfBroken(y, len, 1, len));

		assertEquals(15, s.indexOfBroken(y, len, 3, len));
		assertEquals(4, s.indexOfBroken(y, len, 4, len));
		assertEquals(15, s.indexOfBroken(y, len, 5, len));

		assertEquals(-1, s.indexOfBroken(y, len, 3, 4));
		assertEquals(4, s.indexOfBroken(y, len, 4, 8));
		assertEquals(-1, s.indexOfBroken(y, len, 5, 9));

		assertEquals(15, s.indexOfBroken(y, len, 7, len));
		assertEquals(-1, s.indexOfBroken(y, len, 7, len - 1));

		// ===================
		j = new String(y, 0, y.length);

		assertEquals(0, s.indexOfBroken(j, 0, len));

		assertEquals(15, s.indexOfBroken(j, 1, len));

		assertEquals(15, s.indexOfBroken(j, 3, len));
		assertEquals(4, s.indexOfBroken(j, 4, len));
		assertEquals(15, s.indexOfBroken(j, 5, len));

		assertEquals(-1, s.indexOfBroken(j, 3, 4));
		assertEquals(4, s.indexOfBroken(j, 4, 8));
		assertEquals(-1, s.indexOfBroken(j, 5, 9));

		assertEquals(15, s.indexOfBroken(j, 7, len));
		assertEquals(-1, s.indexOfBroken(j, 7, len - 1));

	}

	@Test
	public void testOccupiedCount() {
		String s = "codes.abdullah";
		char[] arr = s.toCharArray();
		int len = arr.length;
		int alen = arr.length;
		int from = 0;
		int to = len;
		int fromDisp = 0;
		int toDisp = 0;
		int spcount = 0;
		int tabSize = Lang.constant.DEFAULT_TAB_SIZE;
		CodepointSupport cps = CodepointSupport.BMP;
		// =====================
		// =====================
		// ===================== no tabs, no pairs
		// =====================
		// =====================

		int expected = to - from;
		int previousOccupations = 0;
		int result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 5;
		to = 10;
		previousOccupations = from;
		expected = to - from;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 12;
		to = 14;
		previousOccupations = from;
		expected = to - from;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		// =====================
		// =====================
		// ===================== with pairs, no tabs
		// =====================
		// =====================

		cps = CodepointSupport.DEBUG;
		// cXdes.aXdullXh
		arr = "cO5des.aB3dullA1h".toCharArray();
		spcount = cps.fixedPairsCount(arr, arr.length);
		alen = arr.length;
		len = alen - spcount;

		from = 0;
		to = 7;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 0;
		expected = (to - from);
		assertEquals(8, expected);
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 0;
		to = 3;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 0;
		expected = (to - from);
		assertEquals(4, expected);
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 3;
		to = 5;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 4;
		expected = (to - from);
		assertEquals(2, expected);
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 7;
		to = 10;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = from;
		expected = (to - from);
		assertEquals(4, expected);
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 0;
		to = 13;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 0;
		expected = (to - from);
		assertEquals(16, expected);
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 12;
		to = 14;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 14;
		expected = (to - from);
		assertEquals(3, expected);
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		// =====================
		// =====================
		// ===================== no pairs, with tabs
		// =====================
		// =====================

		cps = CodepointSupport.DEBUG;
		arr = ">ode>.abd>llah".replaceAll("[>]", "\t").toCharArray();
		spcount = cps.fixedPairsCount(arr, arr.length);
		alen = arr.length;
		len = alen - spcount;

		from = 0;
		to = 7;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 0;
		expected = 18;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 0;
		to = 3;
		previousOccupations = 0;
		expected = 10;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 3;
		to = 5;
		previousOccupations = 10;
		expected = 6;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 7;
		to = 10;
		previousOccupations = 18;
		expected = 6;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 0;
		to = 13;
		previousOccupations = 0;
		expected = 27;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 12;
		to = 14;
		previousOccupations = 26;
		expected = 2;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		// =====================
		// =====================
		// ===================== with pairs and tabs
		// =====================
		// =====================

		cps = CodepointSupport.DEBUG;
		// >Xde>.aXd>llXh
		arr = ">O1de>.aB2d>llA3h".replaceAll("[>]", "\t").toCharArray();
		spcount = cps.fixedPairsCount(arr, arr.length);
		alen = arr.length;
		len = alen - spcount;

		from = 0;
		to = 7;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 0;
		expected = 18;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 0;
		to = 3;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 0;
		expected = 11;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 3;
		to = 5;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 11;
		expected = 5;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 7;
		to = 10;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 18;
		expected = 6;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 0;
		to = 13;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 0;
		expected = 28;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

		from = 12;
		to = 14;
		// ====================
		fromDisp = cps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		toDisp = cps.extendablePairsCount(arr, alen, from, to);
		to += toDisp;
		// ====================
		previousOccupations = 26;
		expected = 3;
		result = Lang.codepoint.count.ofColumns(arr, alen, from, to, tabSize, previousOccupations, cps);
		assertEquals(expected, result);

	}

	private static boolean isIt(int cp) {
		return Character.isSurrogatePair(Character.highSurrogate(cp), Character.lowSurrogate(cp));
	}

	private static int codePointBefore(String s, int i, Endian e) {
		i = e.index(i, s.length(), s.length());
		if (e.isBig()) {
			return s.codePointAt(i + 1);
		}
		return s.codePointBefore(i);
	}

	private static int getCodepointBackwardAt(String cs, int index, Endian read) {
		index = read.index(index, cs.length(), cs.length());
		if (index - 1 >= 0 && Character.isSurrogatePair(cs.charAt(index - 1), cs.charAt(index)))
			return Character.toCodePoint(cs.charAt(index - 1), cs.charAt(index));
		return cs.charAt(index);
	}
}
