package module5;

public class TestSquareMatrix {

	public static void main(String[] args) throws Exception{
		
		// define the matrices as double arrays
		double[][] A1 = {{2,1,0}, {0,1,0},{-1,0,2}};
		double[][] B1 = {{1,3,1},{0,2,0},{1,0,-1}};
		double[][] C1 = {{2,3},{3,4}};
		double[][] D1 = {{-4,3},{3,-2}};
		
		// create square matrices for each double array 
		SquareMatrix A = new SquareMatrix(A1);	
		SquareMatrix B = new SquareMatrix(B1);
		SquareMatrix C = new SquareMatrix(C1);
		SquareMatrix D = new SquareMatrix(D1);
		
		// add A and B
		System.out.println("A+B is:");
		System.out.println(A.add(B));
		
		// subtract B from A
		System.out.println("A-B is:");
		System.out.println(A.subtract(B));
		
		//print the commutator [A,B]
		System.out.println("Commutator [A,B] is:");
		System.out.println(SquareMatrix.subtract(A.multiply(B),B.multiply(A)));
		 
		//calculate the product CD and check if it's the unit matrix 
		System.out.println("CD is");
		
		SquareMatrix CD = C.multiply(D);
		System.out.println(CD);
		if (CD.equals(SquareMatrix.unitMatrix(2))) {
			System.out.println("CD is the unit matrix");
		}
			else {
				System.out.println("CD is not the unit matrix");
			}
		
		
		
	

}
}
