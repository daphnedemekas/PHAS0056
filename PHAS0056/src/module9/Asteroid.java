package module9;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// this is a class for the asteroids , which extends the class OrbitingBody


public class Asteroid extends OrbitingBody {
	// we have to override the variables that we want to use 
	
	int orbitRadius; // the asteroids will have unique radii, randomly distributed 
	double orbitPeriod; // the asteroids will have unique periods, determined by their radii
	Color color; 
	Position position;
	
	// we set the initial orbit angle to zero which will then be incremented in a method below
	protected double orbitAngle = 0;
	
	private static Random rand = new Random(); // we want to start out at a random angle 
	
	public Asteroid(int orbitRadius, double orbitPeriod, Position orbitCentre, Color color, int size) {
		super(); // implements the methods and variables of the orbiting body class 
		this.orbitCentre = orbitCentre; // did not have to initialize this because it's always the same 
		this.color = color;
		this.size = size;
		
		// now we want the radii of our asteroids to be randomly distributed
		// so we take the product of a normally distributed double and a random number between 0 and 50 
		// and then cast it to an integer, to make a random radius for each asteroid (i.e. adding noise to the orbit) 
		this.orbitRadius = orbitRadius + (int) (rand.nextGaussian() * ThreadLocalRandom.current().nextInt(0,50+1)); 
		
		// the orbit period is also random, we scale it by this 'noise' factor
		this.orbitPeriod = orbitPeriod * this.orbitRadius / orbitRadius;
		
		this.position = new Position(orbitCentre.x(), orbitCentre.y()+this.orbitRadius);
		this.angularSpeed = 2*Math.PI/this.orbitPeriod; // angular speed theta = 2*pi / T
		this.delta = this.angularSpeed * this.delay/1000;  // this is what we increment our angle by each iteration
		this.orbitAngle = ThreadLocalRandom.current().nextInt(0,360+1); // we start our asteroid at a random angle.
		// so that each asteroid can start in a different angle 
	}
	
	// this is very important. in this function we update our position each time we repaint
	// so this is what allows our asteroids to move. 
	public Position getPosition() {
		this.updatePosition();
		return position;
	}
	
	private void updatePosition() {
		this.orbitAngle += delta;
		if (this.orbitAngle > Math.PI * 2) {
			this.orbitAngle %= Math.PI *2; //  if we have completed a circular orbit 
			// then we update our current angle by how much we are past our initial point in the orbit
		}
		// x = rcos(theta) 
		// y = rsin(theta)
		// and we have our origin at the orbit centre so we have:
		this.position.setX((int) (Math.cos(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.x());
		this.position.setY((int)(Math.sin(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.y());	
		}


}
