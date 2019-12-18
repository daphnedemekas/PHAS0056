package Graphicsnotes;

import javax.swing.*;

/**
 * Simple Swing application using JLabel to display text.
 */
public class Textdisplay {

  /** Create and display a JFrame containing a JLabel. */
  static void createAndDisplayGui() {
	  	// JFrame is a top-level container representing a window on the computer screen 
	  // a container is a component that can contain other componenets
	  // this one is called top level because it is not contained within any other container. 
	    JFrame frame = new JFrame("Swing example");
	    // Exit application if window is closed
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel label = new JLabel("Hello Java programmers!");
	    // only contains text string
	    frame.add(label);       // Add label to frame
	    frame.pack();           // Set component sizes and layout to be just big enough to contain the components
	    frame.setVisible(true); // Display the resulting frame
	  }
}

