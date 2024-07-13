package codes.abdullah.digits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import codes.abdullah.digits.CharsRadix.FlagsIterator;

public class TestCharsRadix {

//	@Test
	public void testWithStandard() {
		FlagsIterator it = new FlagsIterator().withoutMinSizeFlags().withoutExpansionFlags().withoutDelimitaionFlags()
				.withoutIncludePrefixesFlags();
		while (it.hasNext()) {
			Integer flags = (Integer) it.next();
			CharsRadix c = CharsRadix.of(flags);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 32; j++) {
				int n = 1 << j;
				assertWithStandardJava(n, c, sb);
			}
		}

		it = new FlagsIterator().withoutMinSizeFlags().withoutExpansionFlags().withoutDelimitaionFlags()
				.withoutIncludePrefixesFlags();
		while (it.hasNext()) {
			Integer flags = (Integer) it.next();
			CharsRadix c = CharsRadix.of(flags);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 1024; j++) {
				int n = Digits.RANDOM.nextInt();
				assertWithStandardJava(n, c, sb);
			}
		}
	}

//	@Test
	public void testWithoutDelimitation() {
		FlagsIterator it = new FlagsIterator().withoutDelimitaionFlags();
		while (it.hasNext()) {
			int flags = it.next();
//			flags = RADIX_10 | MIN_SIZE_02 | EXPANSION_02 | WRITE_LAST | INCLUDE_PREFIX;
			CharsRadix c = CharsRadix.of(flags);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 32; i++) {
				int n = 1 << i;
//				n = -2147483648;
				assertWithoutDelimitation(n, c, sb);
			}
		}

		it = new FlagsIterator().withoutDelimitaionFlags();
		while (it.hasNext()) {
			int flags = it.next();
//			flags = RADIX_10 | MIN_SIZE_02 | EXPANSION_02 | WRITE_LAST | INCLUDE_PREFIX;
			CharsRadix c = CharsRadix.of(flags);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 1024; i++) {
				int n = Digits.RANDOM.nextInt();
//				n = -2147483648;
				assertWithoutDelimitation(n, c, sb);
			}
		}
	}

	@Test
	public void testWithDelimitation() {

		CharsRadix.FlagsIterator it = new CharsRadix.FlagsIterator();
		while (it.hasNext()) {
			int flags = it.next();
//			flags = RADIX_02 | MIN_SIZE_02 | EXPANSION_04 | DELIMITATION_02 | WRITE_LAST | INCLUDE_PREFIX;			
			if (!isDelimitaionFlagged(flags)) {
				flags |= CharsRadix.DELIMITATION_02;
			}

			CharsRadix c = CharsRadix.of(flags, '_');
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 32; i++) {
				int n = 1 << i;
//				n = 4;
				assertWithDelimitation(n, c, sb);
//				System.out.println(n + ": " + c.stringfyFlags() + ", " + c);
			}
		}
	}

	private boolean isDelimitaionFlagged(int flags) {
		for (int f : CharsRadix.getDelimitationFlags()) {
			if (f != 0 && Digits.ints.isFlagged(flags, f)) {
				return true;
			}
		}
		return false;
	}

	private void assertWithoutDelimitation(int n, CharsRadix c, StringBuilder sb) {
		String msg = String.format("input(%d), \nflags(\n%s\n%s)\n", n, c.stringfyFlags(), c.explainFlags());
		try {
			c = c.put(n);
			String src = c.toString();
			String esc = removePrefix(src, c.getPrefix());
			String byjava = null;
			String prefix = c.getPrefix();

			if (c.getRadix() == 2) {
				byjava = Integer.toBinaryString(n);
			} else if (c.getRadix() == 8) {
				byjava = Integer.toOctalString(n);
			} else if (c.getRadix() == 10) {
				byjava = Integer.toString(n);
			} else if (c.getRadix() == 16) {
				byjava = Integer.toHexString(n);
			} else {
				fail("unsupported: " + msg);
			}

			if (byjava.startsWith("-"))
				byjava = byjava.substring(1);

			byjava = padLeft(byjava, c);

			if (c.isWriteOverwite()) {
				sb.delete(0, sb.length()).append(byjava);
			} else if (c.isWriteAppend()) {
				sb.append(byjava);
			} else {
				fail("unsupported: " + msg);
			}

			if (c.isIncludePrefix()) {
				assertTrue(msg, c.getPrefix().equals(prefix));
				assertTrue(msg, src.startsWith(prefix));
			}

			assertEquals(msg, sb.toString(), esc);

		} catch (Exception e) {
			e.printStackTrace();
			fail(msg);
		}
	}

	private void assertWithStandardJava(int n, CharsRadix c, StringBuilder sb) {
		String msg = String.format("input(%d), \nflags(\n%s\n%s)\n", n, c.stringfyFlags(), c.explainFlags());
		try {
			c = c.put(n);
			String byjava = null;
			if (c.getRadix() == 2) {
				byjava = Integer.toBinaryString(n);
			} else if (c.getRadix() == 8) {
				byjava = Integer.toOctalString(n);
			} else if (c.getRadix() == 10) {
				byjava = Integer.toString(n);
			} else if (c.getRadix() == 16) {
				byjava = Integer.toHexString(n);
			} else {
				fail("unsupported: " + msg);
			}

			if (byjava.startsWith("-"))
				byjava = byjava.substring(1);

			if (c.isWriteOverwite()) {
				sb.delete(0, sb.length()).append(byjava);
			} else if (c.isWriteAppend()) {
				sb.append(byjava);
			} else {
				fail("unsupported: " + msg);
			}

			assertEquals(msg, sb.toString(), c.toString());
		} catch (Exception e) {
			e.printStackTrace();
			fail(msg);
		}
	}

	private void assertWithDelimitation(int n, CharsRadix c, StringBuilder sb) {
		String msg = String.format("input(%d), \nflags(\n%s\n%s)\n", n, c.stringfyFlags(), c.explainFlags());
		try {
			c = c.put(n);
			String src = c.toString();
			String esc = removePrefix(src, c.getPrefix());

			msg += "\n" + esc;
			String[] groups = esc.split(regexIt(c.getDelimiter()));

			for (int i = 1; i < groups.length; i++) {
				for (int j = i + 1; j < groups.length; j++) {
					assertEquals(msg, groups[i].length(), groups[j].length());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(msg);
		}
	}

	private String delimIt(String byjava, CharsRadix c) {
		StringBuffer s = new StringBuffer();
		return null;
	}

	private static String regexIt(char c) {
		if ("<([{\\^-=$!|]})?*+.>".indexOf(c) >= 0)
			return "[\\" + c + "]";
		return "[" + c + "]";
	}

	private static String removePrefix(String s, String prefix) {
		if (prefix.length() > 0) {
			return s.substring(prefix.length());
		}
		return s;
	}

	private static String esc(String s) {

		int x = 0;
		while (x < s.length() && s.charAt(x) == '0') {
			x++;
		}
		// keep only 1 zero
		if (x == s.length() && s.length() > 0)
			return s.substring(x - 1);
		return s.substring(x);
	}

	private static String deleteDelims(String s, char delim) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) != delim)
				sb.append(s.charAt(i));
			i++;
		}
		return sb.toString();
	}

	private static String padLeft(String byjava, CharsRadix c) {
		int len = byjava.length();
		if (byjava.startsWith("-"))
			len = byjava.substring(1).length();
		int missing = c.getMissing(len);
		for (int i = 0; i < missing; i++) {
			byjava = "0" + byjava;
		}
		return byjava;
	}

	private static String padRight(String byjava, CharsRadix c) {
		int missing = c.getMissing(byjava.length());
		for (int i = 0; i < missing; i++) {
			byjava = byjava + "0";
		}
		return byjava;
	}

}
