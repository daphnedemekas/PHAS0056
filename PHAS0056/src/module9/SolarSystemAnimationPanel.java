package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SolarSystemAnimationPanel extends JPanel implements ActionListener {
	
	// this is the panel which will first initialize the lists of orbiting bodies, planets and asteroids
	// then paint the animation
	// and then eventually be called by the GUI panel, which is called by the main method, to create the animation
	
	private static final long serialVersionUID = 1L;
	public static final int delay = 10; // time in milliseconds for increment of planet movement

	private Timer animationTimer;
	private Position orbitCentre;
	int sunRadius;

	private int eRadius;
	private int ePeriod;
	private Planet earth;
	ArrayList<Planet> planets;
	ArrayList<Asteroid> asteroids;
	ArrayList<OrbitingBody> orbitingbodies;
	
	// need to initialize variables !!!
	private int mercuryOrbitRadius;
	private int venusOrbitRadius;
	private int marsOrbitRadius; 
	private int jupiterOrbitRadius;
	
	private int asteroidOrbitRadius;
	
	private double mercuryOrbitPeriod;
	private double venusOrbitPeriod;
	private double marsOrbitPeriod;
	private double jupiterOrbitPeriod;
	
	private double asteroidOrbitPeriod;
	
	
	public SolarSystemAnimationPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height)); // this is just part of JPanel class
		animationTimer = new Timer(delay, this); // we will repaint the animation every 10 miliseconds until we press stop
		orbitCentre = new Position(500, 375);
		
		// these valuesa are only to make it look nice, not scientifically accurate !
		sunRadius = 30; 
		eRadius = 150;
		ePeriod = 100;
		asteroidOrbitRadius = (int) (eRadius *2);
		venusOrbitRadius = (int) (eRadius * 0.72);
		mercuryOrbitRadius = (int) (eRadius * 0.39);
		marsOrbitRadius = (int) (eRadius * 1.9);
		jupiterOrbitRadius = (int) (eRadius * 2.4);
		mercuryOrbitPeriod =  (ePeriod * 0.241);
		venusOrbitPeriod =  (ePeriod * 0.616);
		marsOrbitPeriod =  (ePeriod * 1.88);
		jupiterOrbitPeriod =  (ePeriod * 11.8);

		asteroidOrbitPeriod = (ePeriod * 3.5);
		
		// create planets 
		earth = new Planet("earth", orbitCentre, eRadius, ePeriod, Color.cyan, sunRadius / 3);
		
		Planet mercury = new Planet("mercury", orbitCentre, mercuryOrbitRadius, mercuryOrbitPeriod, Color.gray,
				sunRadius / 4);
		Planet venus = new Planet("venus", orbitCentre, venusOrbitRadius, venusOrbitPeriod, Color.orange,
				(int) (sunRadius / 3.3));
		Planet mars = new Planet("mars", orbitCentre, marsOrbitRadius, marsOrbitPeriod, Color.red,
				(int) (sunRadius / 3.2));
		Planet jupiter = new Planet("jupiter", orbitCentre, jupiterOrbitRadius, jupiterOrbitPeriod,
				new Color(153, 102, 0), (int) (sunRadius / 4.9));
		
		planets = new ArrayList<Planet>();
		planets.add(earth);
		planets.add(mercury);
		planets.add(venus);
		planets.add(jupiter);
		planets.add(mars);
		
	
		asteroids = new ArrayList<Asteroid>();
		
		// create asteroids:
		
		for (int i=0; i<1000; i++) {
			asteroids.add(new Asteroid(asteroidOrbitRadius, asteroidOrbitPeriod, orbitCentre, Color.lightGray, 3));
		}
		
		// add both planets and asteroids to general list, orbiting bodies 
		orbitingbodies = new ArrayList<OrbitingBody>();
		orbitingbodies.addAll(planets);
		orbitingbodies.addAll(asteroids);
	}

	// first we paint everything but the bodies themselves 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		// Fill in background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// paint the sun
		g.setColor(Color.YELLOW);
		g.fillOval(orbitCentre.x() - sunRadius, orbitCentre.y() - sunRadius, 2 * sunRadius, 2 * sunRadius);
		
		// now we paint the planets: orbits, names and bdoies 
		for (Planet planet : planets) {
			g.setColor(Color.WHITE); // the orbits will be drawn in white 
			// these are not perfect. i think its because i need to use integers in the draw Oval and fill Oval methods 
			
			g.drawOval(orbitCentre.x() - planet.getRadius(), orbitCentre.y() - planet.getRadius(), 2 * planet.getRadius(),
					2 * planet.getRadius()); // the oval that marks the path of the planet 
			g.drawChars(planet.name().toCharArray(), 0, planet.name().length(), planet.getPosition().x(),
					planet.getPosition().y() + 30);
			g.setColor(planet.color);
			// i  put the minus 1 here just to make it look a bit better 
			g.fillOval(planet.getPosition().x() - 1 , planet.getPosition().y() - 1, 2 * planet.radius, 2 * planet.radius);
		}
		
		// here we paint the asteroids
		for (Asteroid a : asteroids) {
			g.setColor(a.color);
			g.fillOval(a.getPosition().x(), a.getPosition().y(), a.size, a.size());
		}
		
	}
	
	// this method gets called every 10 seconds, we repaint our bodies in their new positions
	public void actionPerformed(ActionEvent e) {
		repaint();
	}


	// start the animation
	public void start() {
		animationTimer.start();
	}

	// stop the animation
	public void stop() {
		animationTimer.stop();
	}

}
