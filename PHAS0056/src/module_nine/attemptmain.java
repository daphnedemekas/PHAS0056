package module_nine;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class attemptmain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("The Solar System Animation");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the gui exits when the window is closed
				
				anim_panel panel = new anim_panel(1300,800); // create constructor for gui panel
				frame.add(panel);
				frame.pack(); // set components sizes and layout
				frame.setVisible(true); // display the resulting frame
			}
		});
	}
}


