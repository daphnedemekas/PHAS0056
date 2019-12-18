package module_nine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class anim_panel extends JPanel implements ActionListener {
	int sunRadius = 20;
	Timer animationTimer;
	Point orbitCentre = new Point(590, 340);
	public static final int delay = 10; // time in milliseconds for increment of planet movement
	private Shape sun;
	
	public anim_panel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		sun = new Ellipse2D.Double(orbitCentre.x - sunRadius, orbitCentre.y - sunRadius, 2*sunRadius,2*sunRadius);
		animationTimer = new Timer(delay, this);
	}
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int height = getHeight();
	    int width = getWidth();
	    // Fill in background
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 0, width, height);
	    // Rotate and draw shape
	    g.setColor(Color.YELLOW);
		g.fillOval(width/2 - sunRadius, height/2 - sunRadius, 2 * sunRadius, 2 * sunRadius);
	  }

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
