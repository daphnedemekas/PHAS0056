package module9;
import java.awt.Color;

public class Planet extends OrbitingBody{
	
	// the class planet also extends orbiting body 
	
	// here we initialize the variables that we have to change / control
	int orbitRadius;
	double orbitPeriod;
	Color color;
	Position position;
	String name;
	protected double orbitAngle = 0;
	int radius;
	int size;
	
	public Planet(String name, Position orbitCentre, int orbitRadius, double orbitPeriod, Color color, int radius) {
		// set the position as orbitCentre because position is a function of orbitCentre, starts at the middle 
		super();
		this.name = name;
		this.orbitPeriod = orbitPeriod;
		this.orbitRadius = orbitRadius;
		this.color = color;
		this.radius = radius;
		this.position = new Position(orbitCentre.x(), orbitCentre.y() + this.orbitRadius);
		// position is the orbit centre off by the radius
		// so that the planets all start on a vertical line at the centre 
		// different distances from the sun
		this.angularSpeed = 2*Math.PI/this.orbitPeriod; 
		this.delta = 2*Math.PI*this.delay/(this.orbitPeriod*1000); // angular speed times velocity
		// so this is the angle at which it will be turning at each increment 
		this.orbitCentre = orbitCentre;
		this.size = 2* this.radius;
	}
	
	public int getRadius() {
		return this.orbitRadius;
	}
	
	public String name() {
		return this.name;
	}
	
	// this is very important. in this function we update our position each time we repaint
		// so this is what allows our asteroids to move. 
	public Position getPosition() {
		updatePosition();
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



