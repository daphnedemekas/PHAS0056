package module2;

public class TestComplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(-2,1);
		
		//print the product
		System.out.println(Complex.multiply(c1,  c2));
		//print the quotient
		System.out.println(Complex.divide(c1,  c2));
		//divide c1 by zero 
		System.out.println(Complex.divide(c1,  Complex.ZERO));
		//cannot divide by zero 
		
		//multiply c1 by its conjugate
		System.out.println(Complex.multiply(c1, c1.conjugate()));
		//multiply c2 by its conjugate
		System.out.println(Complex.multiply(c2, c2.conjugate()));

		
		
		
	}

}
