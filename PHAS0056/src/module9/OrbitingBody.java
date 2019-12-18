package module9;

import java.awt.Color;

// this is an abstract class which initializes variables and methods to be used both by
// planets and asteroids. 


public abstract class OrbitingBody {
	
	protected int orbitRadius;  // radius of orbit 
	protected Position orbitCentre;  // the centre of the orbit, which will then be scaled uniquely for each body
	protected double angularSpeed;	// the speed at which the orbit rotates, which will be used in the calculation of delta 
	protected double delta; // the angle will increment by delta
	protected double delay = 5; // delay in ms between steps of orbit
	protected Position position; // the position of the body 
	protected double orbitPeriod; // the period at which the body orbits
	protected Color color; // the color of the graphic 
	protected int size; 
	protected int orbitAngle; // the angle will be updated at each increment so that we know when an orbit 
	// has been completed and a new one must begin


	protected int size() {
		return this.size;
	}

	protected Color color() {
		return this.color;
	}

	protected abstract Position getPosition();

}