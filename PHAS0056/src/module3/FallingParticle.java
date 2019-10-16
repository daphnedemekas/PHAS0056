package module3;
import java.lang.Math;

public class FallingParticle {
	
	public FallingParticle(double m, double d) throws Exception{
		this.d = d;
		// throw the exception for the unphysical mass inside of the constructor
		if (m <= 0) {
			throw new Exception("unphysical mass" +m); 
		}
		else {
			this.m = m;
		}
		
	}
	//consider what values would be sensible defaults for other 
	//member variables

	double m;  // mass of falling particle
	double d;  // drag coefficient
	double t; // time elapsed, changes (not static) and 
	double z; // vertical position of particle, not static
	double h; // initial starting height can be static 
	double v; //velocity of particle, not static
	final double g = 9.81; //acceleration due to gravity 
	// g is final because it will never change 

	//no equation for h, just set as itself
	// throw exception for unphysical height
	public double setH(double h) throws Exception {
		if (h<0) {
			throw new Exception("unphysical height" +h);
		}
		return h;
	}
	
	// function to get vertical position
	// throw exception for unphysical position
	double getZ(double z) throws Exception{
		if (z<0) {
			throw new Exception("unphysical position" +z);
		}
		return z;
	}
	
	// function to set velocity 
	double setV(double u) {
		return u;
	}
	double getV(double v) {
			return v;
	}
	
	// throw exception for unphysical time
	double getT(double t) throws Exception {
		if (t<0) {
			throw new Exception("unphysical time" +t);
		}
		return t;
	}
	
	//  this performs 1 time step
	void doTimeStep(double deltaT) {
		v = 0;
		double a = (d*Math.pow(v, 2)/m)-g;
		v += a*deltaT;
		z += v*deltaT;
		t += deltaT;
	}
	// this performs time steps until our height above the ground is zero and return
	public double drop(double deltaT) {
		z = h;
		t = 0;
		while (z > 0) {  
			doTimeStep(deltaT);
		}
		System.out.println("velocity is " + getV(v));
		System.out.print("Time Elapsed is ");
		return t;
	}
	
}
