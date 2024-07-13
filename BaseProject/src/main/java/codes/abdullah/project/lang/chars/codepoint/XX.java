package codes.abdullah.project.lang.chars.codepoint;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import codes.abdullah.project.CodepointSupport;
import codes.abdullah.project.lang.chars.codepoint.X.D;
import net.miginfocom.swing.MigLayout;

public class XX extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JLabel lbl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XX frame = new XX();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public XX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow][]"));

		textArea = new JTextArea("root\n" + "10-classA{\n" + "	20-fn{\n" + "		30-if{}\n" + "		31-if{\n"
				+ "			40-do{}\n" + "		}\n" + "		32-if{\n" + "			41-do{}\n" + "		}\n"
				+ "	}\n" + "}\n" + "\n" + "11-classB{\n" + "	21-fn{\n" + "		33-if{\n" + "		}\n"
				+ "		34-if{\n" + "		}\n" + "	}\n" + "	22-fn{\n" + "		35-if{\n"
				+ "			42-do{\n" + "				50-for{				\n" + "				}\n" + "			}\n"
				+ "		}		\n" + "	}\n" + "	23-fn{	\n" + "		36-if{\n" + "		}\n" + "	}\n" + "}\n"
				+ "\n" + "12-classC{\n" + "	24-fn{\n" + "	}\n" + "	25-fn{\n" + "	}\n" + "}\n" + "");
		contentPane.add(textArea, "cell 0 0,grow");

		lbl = new JLabel("New label");
		contentPane.add(lbl, "cell 0 1");
		D d = new D();
		textArea.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				Caret caret = textArea.getCaret();
				final int flags = 0;
				// ===============
				final int columns = 10;
				final int rows = 3;
				// ============
				CodepointSupport cps = CodepointSupport.DEBUG;
				char[] arr = textArea.getText().toCharArray();
				final int len = arr.length;
				// =============
				int targetIndex = caret.getDot();
				int fromDisp = cps.extendablePairsCount(arr, len, 0, targetIndex);
				targetIndex += fromDisp;

				d.sequence_global_index = targetIndex;
//
//				X.loop(arr, len, d, cps);
//
//				lbl.setText(String.format(
//						"sequence-global-index(%d), sequence-local-index(%d), column-global-index(%d), column-local-index(%d)",
//						d.sequence_global_index, d.sequence_local_index, d.column_global_index, d.column_local_index));
			}

			public void keyPressed(KeyEvent e) {

			}
		});
		textArea.requestFocus();
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JLabel getLblNewLabel() {
		return lbl;
	}

}
