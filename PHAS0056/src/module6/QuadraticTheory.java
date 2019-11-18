package module6;
import java.lang.Math;

public class QuadraticTheory implements Theory {
	// this class defines a quadratic  function (type of theory) and declares coefficients
	double a;
	double b;
	double c;
	
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// create the method for y = f(x)
	public double y(double x) {
		return a*(Math.pow(x, 2)) + b*x + c;
	}
	// create the to string to return in a readable form 
	public String toString() {
		return a + " + x^2 + " + b + " + x + " + c;
	}

}
