package module9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SSGuiPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L; // not sure 
	
	// will initialise some variables to be used later on
	// these are private because they should not be changed outside of this class
	private JLabel title;
	private SolarSystemAnimationPanel panel;
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	
	// this class will be responsible for making buttons that start and stop the animation 
	// and the code that allows the response to these buttons 
	
	public SSGuiPanel() {
		super(); // get all of the methods from ActionListener
		setPreferredSize(new Dimension(1000,800)); // these are my dimensions of the gui panel to make everything centred 
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // this will align my components in this class
		//along the y axis
		
		title = new JLabel("The Solar System Animation");
		panel = new SolarSystemAnimationPanel(1000,700); // create the animation panel with required dimensions
		// to have orbit centre in the middle.
		
		// create our 3 buttons 
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		
		//want to use action listener to allow actions when these buttons are pressed 
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		JPanel buttonPanel = new JPanel(); //  create a button panel and add the buttons to it
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		//  want to align the buttons along the x axis
		
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		
		// add components to main panel
		add(title, BorderLayout.PAGE_START); // title comes before the first line of the content 
		add(panel, BorderLayout.CENTER); // the solar system goes in the centre 
		add(buttonPanel, BorderLayout.LINE_END); // end of the line direction for the layout
		
	}
	
	public void actionPerformed(ActionEvent e) { // now we respond to actions
		if (e.getSource() == startButton) start();
		else if (e.getSource() == stopButton) stop();
		else if (e.getSource()== exitButton) System.exit(0);
	}
	
	// start and stop methods
	public void start() {panel.start();}
	public void stop() {panel.stop();}

}
