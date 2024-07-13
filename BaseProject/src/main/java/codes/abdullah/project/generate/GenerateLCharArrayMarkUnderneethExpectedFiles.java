package codes.abdullah.project.generate;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;
//TODO i wanted to generate testing files (03-29.expected) for LCharArray.Mark.underneeth testing

class GenerateLCharArrayMarkUnderneethExpectedFiles {

	private static int countTotalPairs(int len) {
		len--;
		return len == 0 ? len : len + countTotalPairs(len);
	}

	public static void main(String[] args) throws IOException {

		Path root = Paths.get("src/test/resources/mark_underneeth_tests").toAbsolutePath();
		Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (file.getFileName().toString().endsWith(".input")) {
//					generate(file);
				}
				return super.visitFile(file, attrs);
			}
		});

		generate(Paths.get("/home/abod/junk/1/a.input"));
	}

//		same line: 
//		pad( ), mark, pad(_), mark
//
//
//		next line: 
//		pad( ), mark, pad(_)
//		pad(_), mark
//
//
//		3rd line :
//		pad( ), mark, pad(_)
//		pad(_)
//		pad(_) mark
//
//
//		4th line :
//		pad( ), mark, pad(_)
//		pad(_)
//		pad(_)
//		pad(_) mark

	// 5
	// 5
	// 5
	// 5

	protected static void generate(Path file) throws IOException {
		int from = 0, to = 47;// 2,5

		// exclusively
		to--;

		List<String> ll = Files.readAllLines(file);
		int currentTotalLen = 0, localFrom = from, localTo = to;
		boolean localFromSet = false, localToSet = false;
		int lineOfFrom = -1, lineOfTo = -1;
		char pad = ' ';
		boolean padfrom = false;
		for (int i = 0; i < ll.size(); i++) {
			String line = ll.get(i);
			int lineLen = line.length() + (i < ll.size() - 1 ? 1 : 0);
			currentTotalLen += lineLen;

			if (!localFromSet && localFrom < lineLen) {
				localFromSet = true;
				lineOfFrom = i;
			}
			if (!localToSet && localTo < lineLen) {
				localToSet = true;
				lineOfTo = i;
			}
			if (!localFromSet && localFrom >= lineLen) {
				localFrom -= lineLen;
			}
			if (!localToSet && localTo >= lineLen) {
				localTo -= lineLen;
			}

			if (!padfrom && localFromSet) {
				System.out.printf("pad(%s), mark(^)", pad);
				if (localToSet) {
					// same line
					System.out.println(", pad(_), mark(^)");
					break;
				} else {
					// different lines
					pad = '_';
					System.out.printf(", pad(%s)\n", pad);
				}
				padfrom = true;
				continue;
			}
			
			
			if(padfrom && !localFromSet) {
				System.out.printf("pad(%s)\n", pad);
			}
			
			if(localToSet) {
				System.out.printf("pad(%s), mark(^)\n", pad);
				break;
			}

		}

		System.out.printf("localRange(%d:%d) lines(%d/%d)\n", localFrom, localTo, lineOfFrom, lineOfTo);

	}

	public static void pad(int from, int to, char pad) {

	}

	private static String chatAt(String s, int i) {
		if (i < 0)
			return "UNKNOWN";
		char c = s.charAt(i);
		if (c == '\t')
			return "TAB";
		else if (c == '\n')
			return "LINEFEED";
		else if (c == ' ')
			return "SPACE";
		return c + "";
	}

	private static char toSymbol(char cf) {
		if (cf == '\n')
			return '|';
		else if (cf == '\t')
			return '>';
		return cf;
	}

}
