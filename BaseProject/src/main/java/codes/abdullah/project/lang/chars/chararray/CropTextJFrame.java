package codes.abdullah.project.lang.chars.chararray;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.text.Caret;

import codes.abdullah.array.wrapper.character.CharArray;
import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.Lang;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class CropTextJFrame extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new CropTextJFrame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public CropTextJFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 800);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow]"));

		JLabel txt = new JLabel("New label");
		getContentPane().add(txt, "cell 0 0");

		JSplitPane splitPane = new JSplitPane();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(splitPane);
		getContentPane().add(scrollPane, "cell 0 1,grow");
		splitPane.setDividerLocation(1200);
		JTextArea left = new JTextArea();
		splitPane.setLeftComponent(left);

		JTextArea right = new JTextArea();
		splitPane.setRightComponent(right);

		// ===============
//		String src = Files.readAllLines(Paths.get("/home/abod/junk/file")).stream()
//				.collect(Collectors.joining("\n")); //
		String src = "codes.abdullah";
		right.setText(src);
		right.setCaretPosition(0);
		right.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Caret caret = right.getCaret();
				
				final int flags = 0;
				// ===============
				final int columns = 5;
				final int rows = 5;
				// ============
				CodepointSupport cps = CodepointSupport.DEBUG;
				char[] arr = src.toCharArray();
				final int len = arr.length;
				// =============
				int targetIndex = caret.getDot();
				int fromDisp = cps.extendablePairsCount(arr, len, 0, targetIndex);
				targetIndex += fromDisp;
				CharArray[] cl = Lang.chararray.crop.in(arr, len, targetIndex, columns, rows, cps);
				String sw = Arrays.stream(cl).map(ca -> new String(ca.getArray(), 0, ca.getLength()))
						.collect(Collectors.joining("\n"));

				left.setText(sw);

				targetIndex--;
				scan(src.toCharArray(), src.length(), targetIndex, targetIndex + 1, 8, cps, txt);
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		right.requestFocus();
		this.setVisible(true);
	}

	public CharArray scan(char[] arr, int len, int from, int to, int tabSize, CodepointSupport cps, JLabel txt) {
		int cp_len = 0, cp_columns = 0, spcount = 0;
		int globalIndex = 0;
		int localIndex = 0;
		// =================
		int globalColumn = 0;
		int localColumn = 0;
		// =================
		int lineIndex = 0;
		int cp = 0;
		int previousColumn = 0;
		CharArray result = CharArray.of(arr, len);
		for (; globalIndex < to;) {

			if (cps.isLinefeed(cp)) {
				localIndex = 0;
				localColumn = 0;
				lineIndex++;
				previousColumn = 0;
			}

			cp = cps.getCodepoint(arr, len, globalIndex);
			cp_len = cps.lengthOf(cp);
			spcount += (cp_len - 1);
			cp_columns = Lang.codepoint.count.ofColumns(arr, len, globalIndex, globalIndex + 1, tabSize, previousColumn,
					cps);

			if (globalIndex >= from) {
				// ============================
//				if (globalIndex == 46)
//					System.out.println();
//
//				System.out.printf("==sgi(%d), sli(%d), cgi(%d), cli(%d), spcount(%d), line(%d)\n", globalIndex,
//						localIndex, globalColumn, localColumn, spcount, lineIndex);
//				System.out.println(CharArray.join(Lang.chararray.mark.underneath(arr, len, globalIndex)));
//
//				System.out.println("-----------------");
				// ============================
//				result = csv.apply(arr, globalIndex, localIndex, globalColumn, localColumn, lineIndex, spcount,
//						cps);

			}

			globalColumn += cp_columns;
			localColumn += cp_columns;
			previousColumn += cp_columns;
			globalIndex++;
			localIndex++;
		}
		txt.setText(String.format("gi(%d), li(%d), gc(%d), lc(%d), spcount(%d), line(%d)\n", globalIndex, localIndex,
				globalColumn, localColumn, spcount, lineIndex));
		return result;
	}
}
