package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.project.lang.Lang;

public class LEllipse {
	static final char[] DEFAULT_ELLIPSE_MARKER = "...".toCharArray();
	static final int DEFAULT_ELLIPSE_WIDTH = 4;
	public final LEllipseLength lengthOf = new LEllipseLength();

	LEllipse() {

	}

	public char[] begin(char[] arr, int len) {
		return begin(arr, len, DEFAULT_ELLIPSE_WIDTH);
	}

	public char[] begin(char[] arr, int len, int width) {
		return begin(arr, len, width, 0);
	}

	public char[] begin(char[] arr, int len, int width, int offset) {
		return Lang.chararray.abbreviate.begin(arr, len, width, DEFAULT_ELLIPSE_MARKER, DEFAULT_ELLIPSE_MARKER.length,
				offset);
	}

	public char[] middle(char[] arr, int len, int width, int offset) {
		return Lang.chararray.abbreviate.middle(arr, len, width, DEFAULT_ELLIPSE_MARKER, DEFAULT_ELLIPSE_MARKER.length,
				offset);
	}

	public char[] end(char[] arr, int len, int width, int offset) {
		return Lang.chararray.abbreviate.end(arr, len, width, DEFAULT_ELLIPSE_MARKER, DEFAULT_ELLIPSE_MARKER.length,
				offset);
	}

	// ================
	// ================
	// ================
	// ================

	public static class LEllipseLength {
		private LEllipseLength() {

		}

		public int begin(char[] arr, int len) {
			return begin(arr, len, DEFAULT_ELLIPSE_WIDTH);
		}

		public int begin(char[] arr, int len, int width) {
			return begin(arr, len, width, 0);
		}

		public int begin(char[] arr, int len, int width, int offset) {
			return Lang.chararray.abbreviate.lengthOf.begin(arr, len, width, DEFAULT_ELLIPSE_MARKER,
					DEFAULT_ELLIPSE_MARKER.length, offset);
		}

		public int middle(char[] arr, int len, int width, int offset) {
			return Lang.chararray.abbreviate.lengthOf.middle(arr, len, width, DEFAULT_ELLIPSE_MARKER,
					DEFAULT_ELLIPSE_MARKER.length, offset);
		}

		public int end(char[] arr, int len, int width, int offset) {
			return Lang.chararray.abbreviate.lengthOf.end(arr, len, width, DEFAULT_ELLIPSE_MARKER,
					DEFAULT_ELLIPSE_MARKER.length, offset);
		}

	}

}
