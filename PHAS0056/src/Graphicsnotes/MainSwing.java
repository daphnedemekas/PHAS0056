package Graphicsnotes;

import javax.swing.SwingUtilities;

public class MainSwing {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			// main creates an instance of an anonymous inner class that implements the runmable interface and calls
			// the createAndDisplayGui from its run method
	    public void run() {
	    	Textdisplay.createAndDisplayGui();
			      }
			    });
			 }

	}

