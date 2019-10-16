package module3;
import java.lang.Math;

public class Complex {
	// represents a complex number with real and imaginary parts 
	
	public Complex(double Re, double Im) {
		this.Re = Re;
		this.Im = Im;
	}
	double Re;
	double Im;
	
	double real() {
		return Re;
	}
	double imag() {
		return Im;
	}
	//returns the modulus of the complex number
	double modulus() {
		return Math.sqrt(Re*Re + Im*Im);
	}
	// returns the argument of the complex number
	double angle() {
		return Math.atan(Im/Re);
	}
	//returns the conjugate of the complex number
	public Complex conjugate() {
		return new Complex(Re, -1*Im);
	}
	
	
	
	//returns the complex number normalised and throws exception for zero magnitude
	public Complex normalised() throws Exception {
		double mod = modulus();

		if (mod == 0) {
			throw new Exception("division by zero");
		}
		double real = Re / mod;
		double imag = Im / mod;
		return new Complex(real, imag);
	}
	//returns true if the input is the complex number
	boolean equals(Complex c) {
		if(c.Re == Re && c.Im == Im) {
			return true;
		} else {
			return  false;
		}
	}
	//returns a string of the complex number
	public String toString() {
		String complex = Re + "+i"+Im;
		return complex;
	}
	// returns the real and imaginary part given teh modulus and argument
	public Complex setFromModulusAngle(double mag, double ang) {
		double Im = mag*Math.sin(ang);
		double Re = mag*Math.cos(ang);
		return new Complex(Re, Im);
		
	}
	//adds 2 complex numbers
	public static Complex add(Complex c1, Complex c2) {
		double real = c1.Re+c1.Re;
		double imag = c1.Im + c2.Im;
		return new Complex(real, imag);
	}
	//subtracts 2 complex numbers
	public static Complex subtract(Complex c1, Complex c2) {
		double real = c1.Re-c1.Re;
		double imag = c1.Im - c2.Im;
		return new Complex(real, imag);
	}
	//returns the product of 2 complex numbers
	public static Complex multiply(Complex c1, Complex c2) {
		double real = c1.Re*c2.Re - c1.Im*c2.Im;
		double imag = c1.Re*c2.Im + c1.Im*c2.Re;
		return new Complex (real, imag);
	}
	// returns the first divided by the second (first multiplied both top and bottom by the 
	//conjugate of the second vector in order to find the real and imaginary parts of the quotient
	
	
	// edit the divide class so that it now throws an exceptions for division by zero
	public static Complex divide(Complex c1, Complex c2) throws Exception {
		// add the exception
		if (c2.Re ==  0 && c2.Im == 0) {
			throw new Exception("division by zero");
		} 
		double real = (c1.Re*c2.Re + c1.Im*c2.Im) / (c2.Re*c2.Re + c2.Im*c2.Im);
		double imag = (c2.Re*c1.Im - c2.Im*c1.Re) / (c2.Re*c2.Re + c2.Im*c2.Im);
		return new Complex (real, imag);
	}
	
	static Complex ONE = new Complex(1,0);
	static Complex ZERO = new Complex(0,0);
	static Complex i = new Complex(0,1);
}
	
