package Graphicsnotes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Animation {

	/**
	 * Rotating square animation with start, stop and exit buttons.
	 */
	/** Create and display JFrame containing animation GUI panel */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation demo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(250, 300);
				JPanel panel = new AnimationGuiPanel();
				frame.add(panel);
				frame.setVisible(true);
			}
		});
	}
}
