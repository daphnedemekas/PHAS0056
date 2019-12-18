package module9;

import javax.swing.SwingUtilities;
import javax.swing.*;

public class SolarSystem {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("The Solar System Animation");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the gui exits when the window is closed
				
				SSGuiPanel panel = new SSGuiPanel(); // create constructor for gui panel
				frame.add(panel);
				frame.pack(); // set components sizes and layout
				frame.setVisible(true); // display the resulting frame
			}
		});
	}
}
