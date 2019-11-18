package module6;
import java.lang.Math;

//  this class creates a function of the form y=x^n (which is a type of interface theory)
// it declares the exponent n and has a to string method to return the function in a readable way
public class PowerLawTheory implements Theory {
	double n;
	
	public PowerLawTheory(double n) {
		this.n =n;
	}
	
	public double y(double x) {
		return Math.pow(x, n);
	}
	
	public String toString() {
		return "x^" + n;
	}
	
	
	

}
