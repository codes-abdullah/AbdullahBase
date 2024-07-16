package codes.abdullah.project.lang;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.digits.Digits;
import codes.abdullah.digits.Range;

public class TestLChararray {
	@Test
	public void testChararray() throws IOException, URISyntaxException {
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
	public void testBlock() throws IOException, URISyntaxException {
		int i = 1;
		// ===================
		// mode="global",esc='\',prefix='{',suffix='}'
		// ===================
		String[] metadataTokensQuets = { "\"", "'", "'", "'" };
		while (true) {
			String num = Digits.numbers.considerZeroing(i++, 2);
			URL res = TestLChararray.class.getResource("/block_test/block" + num + ".input");
			if (res == null)
				break;
			Path srcBlock = Paths.get(res.toURI());
			List<String> l = Files.readAllLines(srcBlock);
			String metadata = l.get(0);

			String[] tokens = metadata.split("[,]");
			if (tokens.length != metadataTokensQuets.length)
				throw new IllegalStateException();
			for (int j = 0; j < tokens.length; j++) {
				char[] tarr = tokens[j].toCharArray();
				int tlen = tarr.length;
				char[] m = metadataTokensQuets[j].toCharArray();
				tokens[j] = new String(Lang.chararray.sub.between(tarr, tlen, m, m.length, m, m.length));
			}

			final CodepointSupport sps = CodepointSupport.BMP;
			final boolean globalMode = tokens[0].equals("global");
			final int esc = sps.getCodepoint(tokens[1], 0);
			final int prefix = sps.getCodepoint(tokens[2], 0);
			final int suffix = sps.getCodepoint(tokens[3], 0);

			l.remove(0);
			final char[] src = l.stream().collect(Collectors.joining("\n")).toCharArray();
			final int len = src.length;

			// =================
			Path expectedDir = srcBlock.getParent().resolve("block01-expected");
			Files.walkFileTree(expectedDir, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path expectedBlock, BasicFileAttributes attrs) throws IOException {

					System.out.println(expectedBlock);

					String name = expectedBlock.getFileName().toString();
					int x = name.lastIndexOf(".expected");
					name = name.substring(0, x);
					String nt[] = name.split("[,]");
					final int depth = Digits.ints
							.parse(new String(Lang.codepoint.sub.after(nt[0].toCharArray(), nt[0].length(), '=')));
					final int index = Digits.ints
							.parse(new String(Lang.codepoint.sub.after(nt[1].toCharArray(), nt[1].length(), '=')));

					// =============
					Range r = Range.of(0, len).toImmutable();
					Range r2 = Lang.codepoint.block.of(src, len, prefix, suffix, esc, depth, index, r, sps, globalMode);
					String result;
					String expected = Files.readAllLines(expectedBlock).stream().collect(Collectors.joining("\n"));
					if (r2.getFrom() == -1 && r2.getTo() == -1) {
						result = "";
					} else {
						result = new String(src, 0, len).substring(r2.getFrom(), r2.getTo());
					}

					assertEquals(expectedDir.getFileName() + "/" + expectedBlock.getFileName() + "\n",expected, result);

					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
					if (e == null) {
						return FileVisitResult.CONTINUE;
					} else {
						throw e;
					}
				}
			});
		}
	}

//	@Test
	public void testMark() throws IOException, URISyntaxException {
		testMarkIndexes();
		testMarkRange();
		testMarkBlockRange();
	}

	private void testMarkBlockRange() throws IOException, URISyntaxException {
		Path srcBlock = Paths.get(TestLChararray.class.getResource("/mark_underneeth_tests/block01.input").toURI());
		char[] arr = Files.readAllLines(srcBlock).stream().collect(Collectors.joining("\n")).toCharArray();
		int len = arr.length;
		CodepointSupport sps = CodepointSupport.BMP;

		char leftPadChar = ' ';
		char middlePadChar = '_';
		// =================
		Path expectedDir = srcBlock.getParent().resolve("block01-expected");
		Files.walkFileTree(expectedDir, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path expectedBlock, BasicFileAttributes attrs) throws IOException {

				if (expectedBlock.getFileName().toString().equals("3-29.expected")) {
//					System.out.println();
				}
//				System.out.println(expectedBlock);

				String name = expectedBlock.getFileName().toString();
				int i = name.indexOf(".expected");
				name = name.substring(0, i);
				String[] r = name.split("[-]");
				int from = Integer.parseInt(r[0]);
				int to = Integer.parseInt(r[1]);

				CharArray[] lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar,
						sps);
				String expected = Files.readAllLines(expectedBlock).stream().collect(Collectors.joining("\n"));
				String result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
						.collect(Collectors.joining("\n"));
				assertEquals(expectedDir.getFileName() + "/" + expectedBlock.getFileName() + "\n", expected, result);

				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
				if (e == null) {
					return FileVisitResult.CONTINUE;
				} else {
					throw e;
				}
			}
		});

	}

	private void testMarkRange() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		CodepointSupport sps = CodepointSupport.BMP;
		int from = 0;
		int to = 0;
		CharArray[] lines = null;
		String expected = null, result = null;
		char leftPadChar = ' ';
		char middlePadChar = '_';

		// ===============
		// ===============
		// =============== one line test, no tabs
		// ===============
		// ===============

		from = 0;
		to = 4;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes.abdullah\n" + "^__^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 5;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes.abdullah\n" + "     ^______^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 0;
		to = 1;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes.abdullah\n" + "^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 4;
		to = 5;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes.abdullah\n" + "    ^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 12;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes.abdullah\n" + "            ^";
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
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 0;
		to = 2;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "^_______^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 1;
		to = 2;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "        ^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 1;
		to = 5;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "        ^__^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 0;
		to = 9;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "^________________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 5;
		to = 15;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "            ^_____________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 11;
		to = 12;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "                    ^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		from = 15;
		to = 16;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "                           ^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 3;
		to = 8;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes		abdu		llah	\n"//
				+ "          ^_____^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 6;
		to = 8;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes		abdu		llah	\n"//
				+ "             ^__^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 7;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes		abdu		llah	\n"//
				+ "                ^___________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>>abdu>>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		from = 4;
		to = 16;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes		abdu		llah	\n"//
				+ "           ^_____________________________^";//
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
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "^____^\n"//
				+ "abdullah";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 4;
		to = 10;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n" //
				+ "    ^_\n"//
				+ "abdullah\n"//
				+ "___^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 5;
		to = 6;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "     ^\n"//
				+ "abdullah";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 6;
		to = 10;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "^__^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 9;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "   ^__^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 0;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n" + "^_____\n"//
				+ "abdullah\n"//
				+ "______^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes|abdullah".replaceAll("[|]", "\n").toCharArray();
		from = 12;
		to = 13;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "      ^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes||abdullah".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 3;
		to = 8;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "   ^__\n"//
				+ "\n"//
				+ "_\n"//
				+ "abdullah\n"//
				+ "^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = "codes||||abdullah".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 3;
		to = 10;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "   ^__\n"//
				+ "\n"//
				+ "_\n"//
				+ "\n"//
				+ "_\n"//
				+ "\n"//
				+ "_\n"//
				+ "abdullah\n"//
				+ "^";//
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
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "^_____\n"//
				+ "abdullah\n"//
				+ "_________\n"//
				+ "java\n"//
				+ "^\n"//
				+ "c++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 0;
		to = 20;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "^_____\n"//
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
		from = 9;
		to = 21;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "   ^_____\n"//
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
		from = 5;
		to = 19;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "     ^\n"//
				+ "abdullah\n"//
				+ "_________\n"//
				+ "java\n"//
				+ "___^\n"//
				+ "c++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = "codes|abdullah|java|c++".replaceAll("[|]", "\n").toCharArray();
		len = arr.length;
		from = 12;
		to = 22;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "abdullah\n"//
				+ "      ^__\n"//
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
		from = 2;
		to = 21;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "codes\n"//
				+ "  ^___\n"//
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
		// ===============
		// ===============
		// =============== multiline test, with tabs
		// ===============
		// ===============

		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 0;
		to = 5;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cod	s\n"//
				+ "^__________^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cod	s\n"//
				+ "abdu	lah\n" //
				+ "^________^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cod	s\n"//
				+ "           ^______\n"//
				+ "abdu	lah\n"//
				+ "____^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cod	s\n"//
				+ "           ^______\n"//
				+ "abdu	lah\n"//
				+ "____________\n"//
				+ "ja	a\n"//
				+ "__^\n"//
				+ "	++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 18;
		to = 20;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cod	s\n"//
				+ "abdu	lah\n"//
				+ "ja	a\n"//
				+ "  ^_____^\n"//
				+ "	++";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============
		arr = ">cod>s|abdu>lah|ja>a|>++".replaceAll("[|]", "\n").replaceAll("[>]", "\t").toCharArray();
		len = arr.length;
		from = 4;
		to = 23;
		lines = Lang.chararray.mark.underneath(arr, len, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cod	s\n"//
				+ "           ^______\n"//
				+ "abdu	lah\n"//
				+ "____________\n"//
				+ "ja	a\n"//
				+ "__________\n"//
				+ "	++\n"//
				+ "________^";//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "        ^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
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
		from = 2;
		to = 3;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "         ^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
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
		to = 5;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
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
		from = 3;
		to = 4;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "           ^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "           ^______\n"//
				+ "A6bD8u	lA9h\n"//
				+ "__^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n" + "           ^______\n" + "A6bD8u	lA9h\n" + "___^\n" + "J2a	a\n" + "	C1C2";//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "           ^______\n"//
				+ "A6bD8u	lA9h\n"//
				+ "______^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "           ^______\n"//
				+ "A6bD8u	lA9h\n"//
				+ "_____________\n"//
				+ "J2a	a\n"//
				+ "__^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "A6bD8u	lA9h\n"//
				+ "  ^_____^\n"//
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
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n"//
				+ "A6bD8u	lA9h\n"//
				+ "  ^_________^\n"//
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
		from = 14;
		to = 23;
		// =================
		// ----------------------
		fromDisp = sps.extendablePairsCount(arr, alen, 0, from);
		from += fromDisp;
		to += fromDisp;
		to += sps.extendablePairsCount(arr, alen, from, to);
		// ---------------------
		lines = Lang.chararray.mark.underneath(arr, alen, from, to, '^', leftPadChar, middlePadChar, sps);
		expected = "	cO4d	s\n" + "A6bD8u	lA9h\n" + "           ^_\n" + "J2a	a\n" + "__________\n" + "	C1C2\n"
				+ "________^";//
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);
	}

	private void testMarkIndexes() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		CodepointSupport sps = CodepointSupport.BMP;
		char leftPadChar = '_';
		char middlePadChar = '_';
		// ===============
		// ===============
		// =============== one line test, no tabs
		// ===============
		// ===============

		int[] indexes = new int[] { 0, 4, 8, 10 };
		CharArray[] lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
		String expected = "codes.abdullah\n" + "^___^___^_^";
		String result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		indexes = Digits.ints.range(len);
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
		expected = "codes.abdullah\n" + "^^^^^^^^^^^^^^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		indexes = new int[] { 13 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 4 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "___________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 10 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "___________________^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 0, 4, 8, 10 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "^__________^_____^_^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 0, 4, 8, 10, 14 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
		expected = "	codes	abdu	llah	\n" + "^__________^_____^_^______^";
		result = Arrays.stream(lines).map(ca -> new String(ca.getArray(), 0, ca.length()))
				.collect(Collectors.joining("\n"));
		assertEquals(expected, result);

		// ===============

		arr = ">codes>abdu>llah>".replaceAll(">", "\t").toCharArray();
		len = arr.length;
		indexes = new int[] { 15 };
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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
		lines = Lang.chararray.mark.underneath(arr, len, indexes, '^', leftPadChar, middlePadChar, sps);
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

	@Test
	public void testReplace() {
		testReplaceRange();
		testReplaceAllCharArrayByCharArray();
		testReplaceAllChararrayByCodepoint();
	}

	private void testReplaceRange() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		int from = 0;
		int to = 2;
		char[] replacement = "".toCharArray();
		int rlen = 0;
		CodepointSupport cps = CodepointSupport.BMP;

		// =================
		// =================
		// ================= bmp
		// =================
		// =================
		replacement = "C++".toCharArray();
		rlen = replacement.length;
		char[] expected = "C++des.abdullah".toCharArray();
		char[] result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen,
				cps);
		int newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 3;
		to = 8;
		replacement = "C++".toCharArray();
		rlen = replacement.length;
		expected = "codC++dullah".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 13;
		to = 14;
		replacement = "C++".toCharArray();
		rlen = replacement.length;
		expected = "codes.abdullaC++".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 1;
		replacement = "+".toCharArray();
		rlen = replacement.length;
		expected = "+odes.abdullah".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 1;
		replacement = "+".toCharArray();
		rlen = replacement.length;
		expected = "+odes.abdullah".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// =================
		// =================
		// ================= debug
		// =================
		// =================

		arr = "codes.abdullah".toCharArray();
		len = arr.length;
		cps = CodepointSupport.DEBUG;

		from = 0;
		to = 2;
		replacement = "F9".toCharArray();
		rlen = replacement.length;
		expected = "F9des.abdullah".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 3;
		to = 8;
		expected = "codF9dullah".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 9;
		to = 14;
		expected = "codes.abdF9".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 14;
		expected = "F9".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 0;
		to = 1;
		expected = "F9odes.abdullah".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 4;
		to = 5;
		expected = "codeF9.abdullah".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 13;
		to = 14;
		expected = "codes.abdullaF9".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

		// ====================
		from = 13;
		to = 14;
		expected = "codes.abdullaF9".toCharArray();
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, len), len, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, len, from, to, replacement, rlen, cps);
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
		replacement = "F6".toCharArray();
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
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, alen, from, to, replacement, rlen, cps);
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
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, alen, from, to, replacement, rlen, cps);
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
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, alen, from, to, replacement, rlen, cps);
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
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, alen, from, to, replacement, rlen, cps);
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
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, alen, from, to, replacement, rlen, cps);
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
		result = Lang.chararray.replace.range(Lang.copy.of.this_(arr, alen), alen, from, to, replacement, rlen, cps);
		newlen = Lang.chararray.replace.lengthOf.range(arr, alen, from, to, replacement, rlen, cps);
		assertEquals(new String(expected), new String(result, 0, newlen));

	}

	public void testReplaceAllChararrayByCodepoint() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		int from = 0;
		int to = 2;
		CodepointSupport cps = CodepointSupport.BMP;
		char[] expected = null;
		CharArray result = null;
		int alen = 0, disp = 0, spcount, tlen = 0;
		int replacement = 0;
		char[] target = null;

		// =================
		// =================
		// ================= bmp
		// =================
		// =================
		target = "a".toCharArray();
		tlen = target.length;
		replacement = '+';
		tlen = target.length;
		from = 0;
		to = len;
		expected = "codes.+bdull+h".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "a".toCharArray();
		tlen = target.length;
		from = 7;
		to = len;
		expected = "codes.abdull+h".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "l".toCharArray();
		tlen = target.length;
		from = 7;
		to = len;
		expected = "codes.abdu++ah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "l".toCharArray();
		tlen = target.length;
		from = 11;
		to = len;
		expected = "codes.abdul+ah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		// ===========================
		// =========================== what if both same length?
		// ===========================
		// ===========================
		target = "l".toCharArray();
		tlen = target.length;
		replacement = '+';

		from = 7;
		to = len;
		expected = "codes.abdu++ah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));
		// ===========================
		from = 11;
		to = len;
		expected = "codes.abdul+ah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, from, to, 0,
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
		target = "a".toCharArray();
		tlen = target.length;
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
		expected = "C0oD2es.A6B7dullXH3".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, alen), alen, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = "B7".toCharArray();
		tlen = target.length;
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
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, alen), alen, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = "l".toCharArray();
		tlen = target.length;
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
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, alen), alen, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = "H3".toCharArray();
		tlen = target.length;
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
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, alen), alen, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ====================
		target = "a".toCharArray();
		tlen = target.length;
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
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, alen), alen, target, tlen, replacement, from, to, 0,
				cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));
	}

	private void testReplaceAllCharArrayByCharArray() {
		char[] arr = "codes.abdullah".toCharArray();
		int len = arr.length;
		int from = 0;
		int to = 0;
		CodepointSupport cps = CodepointSupport.BMP;
		char[] expected = null;
		CharArray result = null;
		int alen = 0, disp = 0, spcount, tlen = 0, rlen = 0;
		char[] replacement = null;
		char[] target = null;
		// ====================

		// ===========================
		target = "cod".toCharArray();
		tlen = target.length;
		replacement = "abc".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "abces.abdullah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "cod".toCharArray();
		tlen = target.length;
		replacement = "abc".toCharArray();
		rlen = replacement.length;
		from = 1;
		to = len;
		expected = "codes.abdullah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "ull".toCharArray();
		tlen = target.length;
		replacement = "XYZ".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "codes.abdXYZah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "ull".toCharArray();
		tlen = target.length;
		replacement = "XYZ".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = 10;
		expected = "codes.abdullah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "ull".toCharArray();
		tlen = target.length;
		replacement = "XYZ".toCharArray();
		rlen = replacement.length;
		from = 9;
		to = len;
		expected = "codes.abdXYZah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "ull".toCharArray();
		tlen = target.length;
		replacement = "XYZ".toCharArray();
		rlen = replacement.length;
		from = 10;
		to = len;
		expected = "codes.abdullah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "codes.abdullah".toCharArray();
		tlen = target.length;
		replacement = "XYZ".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "XYZ".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "abdull".toCharArray();
		tlen = target.length;
		replacement = "XYZ".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "codes.XYZah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "abdullah".toCharArray();
		tlen = target.length;
		replacement = "X".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "codes.X".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		target = "abdu".toCharArray();
		tlen = target.length;
		replacement = "X".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "codes.Xllah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

		// ===========================
		arr = "codes.abdullah-codes.abdullah".toCharArray();
		len = arr.length;
		target = "abd".toCharArray();
		tlen = target.length;
		replacement = "+".toCharArray();
		rlen = replacement.length;
		from = 0;
		to = len;
		expected = "codes.+ullah-codes.+ullah".toCharArray();
		result = Lang.chararray.replace.all(Lang.copy.of.this_(arr, len), len, target, tlen, replacement, rlen, from,
				to, 0, cps);
		assertEquals(new String(expected), new String(result.getArray(), 0, result.length()));

	}

	@SuppressWarnings("unused")
	private static String getBlock() {
		return "root|10-class> A {|>20-fn {|> >30- if{   }| >>31-if{|>> >40-do  {    >}|>>  }|>>32-if{  >|>>>41 -do{ >}|>>}  |>}|}"
				.replaceAll("[>]", "\t").replaceAll("[|]", "\n");

	}
}
