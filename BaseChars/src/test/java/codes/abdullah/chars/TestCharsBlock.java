package codes.abdullah.chars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codes.abdullah.chars.blocks.CharsBlock;

public class TestCharsBlock {

	@Test
	public void basicTest() {

		// ==========================
		// ==========================
		// first digits represent depth, second represent index, e.g: 21 depth 2 index 1
		// ==========================
		// ==========================
		String src = "outside[00 [10], [11, [20]] and [12[21], [22], [23]]][01][02][03]";
		String prefix = "[";
		String suffix = "]";
		String esc = "";
		boolean fullscan = false;
		CharsBlock cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		// =========================
		cb.reset();
		String[] arr = new String[] { "[00 [10], [11, [20]] and [12[21], [22], [23]]]", "[01]", "[02]", "[03]" };
		int targetDepth = 0;
		int i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		cb.reset();
		arr = new String[] { "[10]", "[11, [20]]", "[12[21], [22], [23]]" };
		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		cb.reset();
		arr = new String[] { "[20]", "[21]", "[22]", "[23]" };
		targetDepth = 2;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		cb.reset();
		arr = new String[] {};
		targetDepth = 3;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		cb.reset();
		arr = new String[] {};
		targetDepth = 3;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

		// =========================
		src = "a[b[c]]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] { "[c]" };
		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

		// =========================
		src = "a[b[c]]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] { "[b[c]]" };
		targetDepth = 0;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

		// =========================
		src = "a[bc]]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] { "[bc]" };
		targetDepth = 0;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

		// =========================
		src = "a[bc]]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] {};
		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

		// =========================
		src = "a[[bc]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] {};
		targetDepth = 0;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

		// =========================
		src = "a[[bc]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] { "[bc]" };

		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

	}

	// \\[

	@Test
	public void escapeTest() {
		// ==========================
		// ==========================
		// escape pair of index 0
		// ==========================
		// ==========================
		String src = "outside\\[00 [10], [11, [20]] and [12[21], [22], [23]]\\][01][02][03]";
		String prefix = "[";
		String suffix = "]";
		String esc = "\\";
		String cleared = cleared(src.toString(), esc.toString(), prefix.toString(), suffix.toString());
		boolean fullscan = false;
		CharsBlock cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		// =========================
		cb.reset();
		String[] arr = new String[] { "[10]", "[11, [20]]", "[12[21], [22], [23]]", "[01]", "[02]", "[03]" };
		int targetDepth = 0;
		int i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		cb.reset();
		arr = new String[] { "[20]", "[21]", "[22]", "[23]" };
		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		cb.reset();
		arr = new String[] {};
		targetDepth = 2;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		// outside\\[00 [10], \\[11, [20]] and [12[21\\], [22], [23]]\\][01][02][03]
		// outside\[00 [10], \[11, [20]] and [12[21\], [22], [23]]\][01][02][03]
		// outside00 [10], 11, [20]] and [12[21, [22], [23]][01][02][03]
		// outside00 [10], [20], [21, [22], [23]][01][02][03]
		//
		src = "outside\\[00 [10], \\[11, [20]] and [12[21\\], [22], [23]]\\][01][02][03]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		arr = new String[] { "[10]", "[20]", "[21\\], [22], [23]]", "[01]", "[02]", "[03]" };
		targetDepth = 0;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			String s = cb.next().toString();
			assertEquals(arr[i++], s);
		}

		// =========================
		src = "outside\\[00 [10], \\[11, [20]] and [12[21\\], [22], [23]]\\][01][02][03]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		arr = new String[] { "[22]", "[23]" };
		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			String s = cb.next().toString();
			assertEquals(arr[i++], s);
		}

		// =========================
		esc = "===>";
		src = "outside===>[00 [10], ===>[11, [20]] and [12[21===>], [22], [23]]===>][01][02][03]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		arr = new String[] { "[10]", "[20]", "[21===>], [22], [23]]", "[01]", "[02]", "[03]" };
		targetDepth = 0;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			String s = cb.next().toString();
			assertEquals(arr[i++], s);
		}

		// =========================
		esc = "===>";
		src = "outside===>[00 [10], ===>[11, [20]] and [12[21===>], [22], [23]]===>][01][02][03]";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		arr = new String[] { "[22]", "[23]" };
		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			String s = cb.next().toString();
			assertEquals(arr[i++], s);
		}

		// =========================
		src = "c{m1{f1{}}m2{f2{}}}";
		esc = "&";
		prefix = "{";
		suffix = "}";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] { "{m1{f1{}}m2{f2{}}}" };
		targetDepth = 0;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		src = "c{m1{f1{}}m2{f2{}}}";
		esc = "&";
		prefix = "{";
		suffix = "}";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] { "{f1{}}", "{f2{}}" };
		targetDepth = 1;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}
		// =========================
		src = "c{m1{f1{x}}m2{f2{y}}}";
		esc = "&";
		prefix = "{";
		suffix = "}";
		cb = CharsBlock.of(src, prefix, suffix, esc, fullscan);
		cb.reset();
		arr = new String[] { "{x}", "{y}" };
		targetDepth = 2;
		i = 0;
		assertEquals(arr.length, cb.getCount(targetDepth));
		while (cb.hasNext(targetDepth)) {
			assertEquals(arr[i++], cb.next().toString());
		}

	}

//	org.junit.ComparisonFailure: expected:<[11[]]> but was:<[11[, [20]]]>
	private static String cleared(String c, String esc, String prefix, String suffix) {
		String cp = esc + prefix;
		String sp = esc + suffix;
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < c.length(); i++) {
			if (c.startsWith(cp, i)) {
				i += cp.length() - 1;
				continue;
			} else if (c.startsWith(sp, i)) {
				i += sp.length() - 1;
				continue;
			}

			s.append(c.charAt(i));
		}
		return s.toString();
	}

}
