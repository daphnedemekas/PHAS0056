package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create 3 three vectors
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = ThreeVector.ZERO;
		
		//print the 3 vectors and their unit vectors
		System.out.println("The vectors are");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		
		// here i had to ammend these with try catch statements
		System.out.println("The unit vectors are");
		try {System.out.println(v1.unitVector());
		}
		catch (Exception e) {
			System.out.println("Error: zero vector");
		}
		
		try {System.out.println(v2.unitVector());
		}
		catch (Exception e) {
			System.out.println("Error: zero vector");
		}
		
		try {System.out.println(v3.unitVector());
		}
		catch (Exception e) {
			System.out.println("Error: zero vector");
		}
		//the zero vector has no unit vector, can't divide by zero 
		
		
		//the following prints the required non static scalar products 
		System.out.println("the non static scalar products are");
		System.out.println(v1.scalarProduct(v2));
		System.out.println(v1.scalarProduct(v3));
		
		//the following prints the required static scalar products
		System.out.println("the static scalar products are");
		System.out.println(ThreeVector.scalarProduct(v1,v2));
		System.out.println(ThreeVector.scalarProduct(v1,v3));
		
		//the following prints the required non static vector products
		System.out.println("the non static vector products are");
		System.out.println(v1.vectorProduct(v2));
		System.out.println(v1.vectorProduct(v3));
		
		//the following prints the required static vector products
		System.out.println("the static vector products are");
		System.out.println(ThreeVector.vectorProduct(v1,v2));
		System.out.println(ThreeVector.vectorProduct(v1,v3));
		
		//the following prints the required non static angles
		System.out.println("the non static angles are");

		// again had to amend with try catch statements
		try {
			System.out.println(v1.angle(v2));
		}
		catch (Exception e){
			System.out.println("Error: zero vector");
		}
		
		try {
			System.out.println(v1.angle(v3));
		}
		catch (Exception e) {
			System.out.println("Error: zero vector");
		}
		
		//prints the static angles
		// ammended with try catch statements
		System.out.println("the static angles are");

		try {
			System.out.println(ThreeVector.angle(v1, v2));
		}
		catch (Exception e) {
			System.out.println("Error: zero vector");
		}
		
		try {
			System.out.println(ThreeVector.angle(v1, v3));
		}
		catch (Exception e) {
			System.out.println("Error: zero vector");
		}
		//again, you get Nan when trying to divide by zero
		
		
		//see what happens when
		System.out.println("myThreeVec");
		ThreeVector myThreeVec = v1;
		System.out.println(myThreeVec);
		
		System.out.println("if I don't comment out the toString then it prints the contents of the toString method"
				+ "(because java knows to cast it to a string). If I comment it out it prints the address of the 2 string");
		
	}

}
