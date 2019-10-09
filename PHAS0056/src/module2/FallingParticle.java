package module2;
import java.lang.Math;

public class FallingParticle {
	
	public FallingParticle(double m, double d) {
		this.m = m;
		this.d = d;
	}
	//consider what values would be sensible defaults for other 
	//member variables
	// z = h  - v*t
	
	
	double m;  // mass of falling particle
	double d;  // drag coefficient
	
	double t; // time elapsed, changes (not static) and 
	double z; // vertical position of particle, not static
	static double h; // initial starting height can be static 
	double v; //velocity of particle, not static
	final double g = 9.81; //acceleration due to gravity 
	// g is final because it will never change 

	//no equation for h, just set as itself
	public double setH(double h) {
		return h;
	}
	// function to get vertical position
	double getZ(double z) {
		return z;
	}
	// function to set velocity 
	double setV(double u) {
		return u;
	}
	// get v by setting initial v to be zero
	double getV(double v) {
		if (t == 0) {
			return setV(0);
		}
		else {
			return v;
		}
	}
	// set t as initial time plus time elapsed 
	static double getT(double t, double deltaT) {
		return t += deltaT;
	}
	
	//  this performs 1 time step
	void doTimeStep(double deltaT) {
		v = getV(v);
		double a = (d*Math.pow(v, 2)/m)-g;
		v += a*deltaT;
		z += v*deltaT;
		t = getT(t, deltaT);
	}
	// this performs time steps until our height above the ground is zero and retur
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
