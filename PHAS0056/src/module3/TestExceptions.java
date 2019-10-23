package module3;

import module3.Complex;
import module3.ThreeVector;

public class TestExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// First I will test the three vector methods
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(0,0,0);
		// I use the definition of zero from the class  
		
		// testing the unit vector method for nonzero and zero vectors'
		System.out.println("For the vector: (" +v1.x + ", " + v1.y + " " + v1.z +")");
		System.out.println("The unit vector is:");
		// for a nonzero vector
		try {System.out.println(v1.unitVector()+"\n");
		}
		catch (Exception e) {
			System.out.println("Error: zero vector"+"\n");
		}
		
		// for a zero vector
		System.out.println("For the vector: (" +v2.x + ", " + v2.y + " " + v2.z +")");

		System.out.println("The unit vector is:");
		try {System.out.println(v2.unitVector());
		}
		catch (Exception e) {
			System.out.println("Error:  zero vector"+"\n");
		}
		
		
		// testing non static the angle method
		System.out.println("Between these 2 vectors, the non static angles are:");
		try {
			System.out.println(v1.angle(v2));
		}
		catch (Exception e){
			System.out.println("Error: cannot take the angle because zero vector."+"\n");
		}
		
		// testing the static angle method
		System.out.println("The static angles are:");

		try {
			System.out.println(ThreeVector.angle(v1, v2));
		}
		catch (Exception e) {
			System.out.println("Error: cannot take the angle because zero vector." +"\n");
		}
			
		
		
		// Now I will test the complex methods 
		
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(0,0);
		
		System.out.println("For the complex number:" +c2);
		System.out.println("the normalised complex number is:");
		
		try {
			System.out.println(c2.normalised());
			}
		catch (Exception e) {
			System.out.println("Error: cannot normalise zero vector" +"\n");
		}
		
		System.out.println("The quotient " +c1 + " / " +c2 +"is");

		try {
			System.out.println(Complex.divide(c1,c2));
		}
		catch (Exception e) {
			System.out.println("Error: cannot divide by zero vector"+"\n");
		}
		
		// Now I will test the Falling Particle class
		
		
		// inserting mass into the constructor leads to the error for mass 
		System.out.println("The mass of the particle is");
		try {
			FallingParticle p = new FallingParticle(-4, 2);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("The height of the particle is");
		try {
			// here i create a physical particle, no error thrown
			FallingParticle particle = new FallingParticle(4, 2);
			// here I set an unphysical height so we should get an error for height
			particle.setH(-5);
		}
		// catch the error and print it
		catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("The current position of the particle is");
		try {
			// here i create a physical particle, no error thrown
			FallingParticle particle = new FallingParticle(4, 2);
			// here I set an unphysical position so we should get an error for position
			particle.getZ(-3);
		}
		// catch the error and print it
		catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("The current time is");
		try {
			// here i create a physical particle, no error thrown
			FallingParticle particle = new FallingParticle(4, 2);
			// here I set an unphysical time so we should get an error for time
			particle.getT(-1);
		}
		// catch the error and print it
		catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
}
