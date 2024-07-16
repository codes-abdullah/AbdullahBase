package codes.abdullah.project.lang.chars.chararray;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.lang.Lang;
import codes.abdullah.project.lang.chars.utils.CharsMatcher;

public class LCrop {
	public final LCropLength lengthOf = new LCropLength();

	LCrop() {

	}

	/**
	 * <pre>
	 * public static void main(String[] args) {
	 * 	EventQueue.invokeLater(() -> new CropTextJFrame());
	 * }
	 *
	 * public CropTextJFrame() {
	 * 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * 	setBounds(100, 100, 800, 300);
	 * 	getContentPane().setLayout(new BorderLayout(0, 0));
	 * 
	 * 	JSplitPane splitPane = new JSplitPane();
	 * 	getContentPane().add(splitPane, BorderLayout.CENTER);
	 * 	splitPane.setDividerLocation(400);
	 * 	JTextArea left = new JTextArea();
	 * 	splitPane.setLeftComponent(left);
	 * 
	 * 	JTextArea right = new JTextArea();
	 * 	splitPane.setRightComponent(right);
	 * 
	 * 	// ===============
	 * 	final String src = "Java software runs on everything from laptops to data centers\n" //
	 * 			+ "game consoles to scientific supercomputers.\n" //
	 * 			+ "Oracle (and others) highly recommend uninstalling outdated and unsupported versions of Java\n" //
	 * 			+ "due to unresolved security issues in older versions."; //
	 * 	right.setText(src);
	 * 
	 * 	right.addKeyListener(new KeyListener() {
	 * 
	 * 		&#64;Override
	 * 		public void keyTyped(KeyEvent e) {
	 * 		}
	 * 
	 * 		&#64;Override
	 * 		public void keyReleased(KeyEvent e) {
	 * 			Caret caret = right.getCaret();
	 * 			final int flags = 0;
	 * 			// ===============
	 * 			final int columns = 10;
	 * 			final int rows = 3;
	 * 			// ============
	 * 			CodepointSupport cps = CodepointSupport.DEBUG;
	 * 			char[] arr = src.toCharArray();
	 * 			final int len = arr.length;
	 * 			// =============
	 * 			int targetIndex = caret.getDot();
	 * 			int fromDisp = cps.extendablePairsCount(arr, len, 0, targetIndex);
	 * 			targetIndex += fromDisp;
	 * 			Chararray[] cl = Lang.chararray.crop.in(arr, len, targetIndex, columns, rows, flags, fromDisp, cps);
	 * 			String sw = Arrays.stream(cl).map(ca -> new String(ca.getArray(), 0, ca.getLength()))
	 * 					.collect(Collectors.joining("\n"));
	 * 
	 * 			left.setText(sw);
	 * 		}
	 * 
	 * 		&#64;Override
	 * 		public void keyPressed(KeyEvent e) {
	 * 
	 * 		}
	 * 	});
	 * 	right.requestFocus();
	 * 	this.setVisible(true);
	 * }
	 * </pre>
	 * 
	 */
	@SuppressWarnings("unused")
	public CharArray[] in(char[] arr, int len, int targetIndex, int columns, int rows, CodepointSupport cps) {
		arr = CharArray.join(Lang.chararray.mark.underneath(arr, len, targetIndex)).toCharArray();
		len = arr.length;
		rows++;

		int halfColumns = columns / 2;
		int halfRows = (rows / 2) + (rows % 2);
		int targetRowIndex = halfRows - 1;

		// ---------------------------
		int cropFrom = Lang.codepoint.lastIndex.ofIndex(arr, len, Lang.chararray.CHARS_LINEFEEDS_CODEPOINTS,
				targetRowIndex, 0, targetIndex, 0, 0, CharsMatcher.MUST_EQUALS, cps);
		int cropTo = Lang.codepoint.index.ofIndex(arr, len, Lang.chararray.CHARS_LINEFEEDS_CODEPOINTS, targetRowIndex,
				targetIndex, len, 0, 0, CharsMatcher.MUST_EQUALS, cps);
		cropFrom = cropFrom == Lang.constant.INDEX_NOT_FOUND ? 0 : cropFrom + 1;
		cropTo = cropTo == Lang.constant.INDEX_NOT_FOUND ? len : cropTo;
		int targetColumn = Lang.codepoint.column.from(arr, len, targetIndex, Lang.constant.DEFAULT_TAB_SIZE, cps);
		System.out.printf(
				"columns(%s), rows(%s), index(%s), halfColumns(%s), halfRows(%s), targetRowIndex(%s), cropFrom(%d), cropTo(%d)\n",
				columns, rows, targetIndex, halfColumns, halfRows, targetRowIndex, cropFrom, cropTo);

		// ---------------------------
		int linesCount = Lang.codepoint.count.ofLinefeed(arr, len, cropFrom, cropTo, 0, 0, CharsMatcher.MUST_EQUALS,
				cps) + 1;
		if (linesCount < rows) {
			if (cropFrom == 0) {
				int _ct = Lang.codepoint.index.ofIndex(arr, len, Lang.chararray.CHARS_LINEFEEDS_CODEPOINTS, 0,
						cropTo + 1, len, 0, 0, CharsMatcher.MUST_EQUALS, cps);
				cropTo = _ct == Lang.constant.INDEX_NOT_FOUND ? len : _ct;
			} else if (cropTo == len) {
				int _cf = Lang.codepoint.lastIndex.ofIndex(arr, len, Lang.chararray.CHARS_LINEFEEDS_CODEPOINTS, 0, 0,
						cropFrom - 1, 0, 0, CharsMatcher.MUST_EQUALS, cps);
				cropFrom = _cf == Lang.constant.INDEX_NOT_FOUND ? 0 : _cf + 1;

			}
		}
		// ---------------------------

		final char[] crop = Lang.sub.of(arr, len, cropFrom, cropTo);
		CharArray[] cropLines = Lang.codepoint.split.byAny(crop, crop.length, Lang.chararray.CHARS_LINEFEEDS_CODEPOINTS,
				0, crop.length, 0, 0, CharsMatcher.MUST_EQUALS, cps);
//		CharArray[] cropLines = Lang.codepoint.split.linefeeds(arr, crop.length, 0, crop.length, 0, 0,
//				CharsMatcher.MUST_EQUALS, cps);

		// convert targetIndex from global index to in-line index
		int lengthSum = cropFrom;
		int lengthSofar = cropFrom;
		int inlineColumnIndex = 0;
		for (int i = 0; i < cropLines.length; i++) {
			CharArray ca = cropLines[i];
			lengthSofar = (lengthSum + ca.length() + 1);
			if (lengthSofar > targetIndex) {
				targetIndex -= lengthSum;
				inlineColumnIndex = Lang.codepoint.column.from(ca.getArray(), ca.length(), targetIndex,
						Lang.constant.DEFAULT_TAB_SIZE, cps);
				break;
			}
			lengthSum += ca.length() + 1;
		}

		int addition = LEllipse.DEFAULT_ELLIPSE_MARKER.length * 2;
		for (int i = 0; i < cropLines.length; i++) {
			CharArray ca = cropLines[i];
			char[] arr0 = ca.getArray();
			int len0 = ca.length();
			CharArray arr00 = Lang.codepoint.replace.tabs(arr0, len0, '-', 0, arr0.length,
					Lang.constant.DEFAULT_TAB_SIZE, cps);
			arr0 = arr00.getArray();
			len0 = arr00.length();
			int newlen = Lang.chararray.ellipse.lengthOf.middle(arr0, len0, columns, inlineColumnIndex);
			arr0 = Lang.capacity.ensure(arr0, len0, newlen + addition);
			arr0 = Lang.chararray.ellipse.middle(arr0, len0, columns, inlineColumnIndex);
			ca = ca.assign(arr0, newlen);			
		}
		return cropLines;
	}

	public static class LCropLength {
		private LCropLength() {

		}

		public int crop(char[] arr, int len, int centerIndex, int columns, int rows, CodepointSupport cps) {

			return rows * columns;
		}
	}

}
