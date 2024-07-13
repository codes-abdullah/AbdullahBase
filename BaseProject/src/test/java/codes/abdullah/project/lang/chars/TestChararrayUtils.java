package codes.abdullah.project.lang.chars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codes.abdullah.project.lang.Lang;

public class TestChararrayUtils {

	@SuppressWarnings("rawtypes")
	@Test
	public void test() {
		String src = "";
		String marker = "";
		int maxloop = 16;
		// src-gen
		for (int x = 0; x <= 26; x++) {
			src = gen(x);
			for (int k = 0; k <= 26; k++) {
				marker = gendot(k);

				for (int offset = 0; offset < maxloop; offset++) {
					for (int maxWidth = 0; maxWidth < maxloop; maxWidth++) {
//
//						src = "a";
//						marker = "x";
//						maxWidth = 2;
//						System.out.printf("src(%s), marker(%s), offset(%d), maxWidth(%d)\n", src, marker, offset,maxWidth);
						char[] arr = src.toCharArray();
						int len = arr.length;
						char[] amarker = marker.toCharArray();
						int markerLen = amarker.length;
						String common = null, me = null;
						Exception ce = null;

						try {
							common = abbreviate(src, marker, offset, maxWidth);
						} catch (Exception e0) {
							ce = e0;
						}

						try {
							char[] arr2 = Lang.chararray.abbreviate.begin(arr, len,maxWidth, amarker, markerLen, offset);
							boolean arrEmptyOrNull = Lang.emptyOrNull.isAny(arr2, len);
							boolean marEmptyOrNull = Lang.emptyOrNull.isAny(amarker, markerLen);
							int len2 = getlen(src, marker, maxWidth, offset);

							me = new String(arr2, 0, len2);
							
							String msg = String.format(
									"offset(%d), maxWidth(%d), src(%s), marker(%s), common(%s), me(%s)\n", offset,
									maxWidth, src, marker, common, me);
							assertEquals(msg, common, me);
							assertEquals(msg, common.length(), len2);
							System.out.println(me);
						} catch (Exception e0) {
							String msg = String.format(
									"offset(%d), maxWidth(%d), src(%s), marker(%s), common(%s), me(%s), ce(%s), e0(%s)\n",
									offset, maxWidth, src, marker, common, me, ce, e0);
							Class cec = ce != null ? ce.getClass() : null;
							String ces = ce != null ? ce.toString() : null;
							if (ce != null) {
//								ce.printStackTrace();
//								System.out.println("==================");
//								e0.printStackTrace();
							}

							boolean pass = false;
							if (cec != null && cec.equals(StringIndexOutOfBoundsException.class)) {
								pass = true;
							}

							assertEquals(msg, cec, e0.getClass());
							if (!pass)
								assertEquals(msg, ces, e0.toString());
						}

					}
				}

//			System.exit(0);
			}
		}

	}

	private static String gen(int len) {
		String s = "";
		for (int x = 0; x < len; x++) {
			char c = (char) (x + 'a');
			s = c + s;
		}
		return s;
	}
	
	private static String gendot(int len) {
		String s = "";
		for (int x = 0; x < len; x++) {
			s = '.' + s;
		}
		return s;
	}

	private static int getlen(final String str, final String abbrevMarker, final int maxWidth, int offset) {
		if (isEmpty(str) && isEmpty(abbrevMarker)) {
			return str.length();
		} else if (isNotEmpty(str) && EMPTY.equals(abbrevMarker) && maxWidth > 0) {
			return maxWidth;
		} else if (isEmpty(str) || isEmpty(abbrevMarker)) {
			return str.length();
		}
		return Math.min(str.length(), maxWidth);
	}

	private static String abbreviate(final String str, final String abbrevMarker, int offset, final int maxWidth) {
		if (isEmpty(str) && isEmpty(abbrevMarker)) {
			return str;
		} else if (isNotEmpty(str) && EMPTY.equals(abbrevMarker) && maxWidth > 0) {
			return str.substring(0, maxWidth);
		} else if (isEmpty(str) || isEmpty(abbrevMarker)) {
			return str;
		}
		final int abbrevMarkerLength = abbrevMarker.length();
		final int minAbbrevWidth = abbrevMarkerLength + 1;
		final int minAbbrevWidthOffset = abbrevMarkerLength + abbrevMarkerLength + 1;

		if (maxWidth < minAbbrevWidth) {
			throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", minAbbrevWidth));
		}
		if (str.length() <= maxWidth) {
			return str;
		}
		if (offset > str.length()) {
			// System.out.println("passed #1");
			offset = str.length();
		}
		if (str.length() - offset < maxWidth - abbrevMarkerLength) {
			// System.out.println("passed #2");
			offset = str.length() - (maxWidth - abbrevMarkerLength);
		}
		if (offset <= abbrevMarkerLength + 1) {
			// System.out.println("passed #3");
			return str.substring(0, maxWidth - abbrevMarkerLength) + abbrevMarker;
		}
		if (maxWidth < minAbbrevWidthOffset) {
			throw new IllegalArgumentException(
					String.format("Minimum abbreviation width with offset is %d", minAbbrevWidthOffset));
		}
		if (offset + maxWidth - abbrevMarkerLength < str.length()) {
			// System.out.println("passed #4");
			return abbrevMarker + abbreviate(str.substring(offset), abbrevMarker, maxWidth - abbrevMarkerLength);
		}
		// System.out.println("passed #5");
		return abbrevMarker + str.substring(str.length() - (maxWidth - abbrevMarkerLength));
	}

	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}

	public static final String EMPTY = "";

	public static String abbreviate(final String str, final String abbrevMarker, final int maxWidth) {
		return abbreviate(str, abbrevMarker, 0, maxWidth);
	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}
}
