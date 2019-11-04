package module5;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {
	// initialize my matrix
	
	double[][] elements;

	
	public SquareMatrix(double[][] elements) throws Exception {
		//throws an exception if the array passed as an argument is not a valid square matrix, 
		//i.e. it doesn't have the same numbers of rows and columns;
		if (elements.length != Array.getLength(elements[0])) {
			throw new Exception("not a square matrix");
		}
		this.elements = elements;
	}
		
	public String toString() {
		// returns a string representation of the matrix
		int row, col;
		String output = "(";
		double length = elements.length;
		for (row = 0; row < length; row++ ) {
			for (col = 0; col < length; col ++ ) {
				output += (double) elements[row][col];
				if (col < length-1) {
					output += ",";
				}
			}
			output += ")" + "\n";
				if (row < length-1) {
					output += "(";
				}
		}
		return output;
	}
	
	public static SquareMatrix unitMatrix(int size) throws Exception {
		// returns a unit matrix of a given size 
		int row, col;
		double[][] identity = new double[size][size];
		// iterate through the rows and the columns
		for (row = 0; row < size; row++ )
		{
			for (col = 0; col < size; col++)
			{
				// Checking if row is equal to column
				// putting in a 1 along the diagonal
				if (row == col) {
					identity[row][col] = 1.0;
				}
				//putting zeros everywhere else 
				else {
					identity[row][col] = 0.0;
				}	
			}
		}
		return new SquareMatrix(identity);
	}
	
	public boolean equals(Object obj) {
		// checking if the argument is actually a reference to the object
		// whose equals method is being called 
		if (this == obj) {
			return true;
			}
		// check if the argument is null, eliminate this option
		if (obj == null) {
				return false;
			}
		// if not, check if the objects are of the same class 
		if (getClass() != obj.getClass()) {
				return false;
			}
		// if they are of the same class, cast it to a square  matrix
		SquareMatrix other = (SquareMatrix) obj;
		// return a boolean result, by checking if each element is equal 
		return Arrays.deepEquals(elements, other.elements);
		}
	// add 2 matrices
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		// check if the matrices are the same size 
		if (sm1.elements.length != sm2.elements.length) {
			throw new Exception("matrices are not of the same size");
		}
		// if so, size is length
		int length = sm1.elements.length;
		// create a square matrix of the required length
		double[][] sum = new double[length][length];
		// iterate through rows and columsn and add each element
		for(int i = 0; i < length; i++) {
			for(int j=0; j < length; j++) {
				sum[i][j] = sm1.elements[i][j] + sm2.elements[i][j];
				}
			}
		// return the summed matrix
		return new SquareMatrix(sum);
		}
	// subtract 2 matrices 
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		// check if the matrices are the same size 
		if (sm1.elements.length != sm2.elements.length) {
			throw new Exception("matrices are not of the same size");
		}
		// if so, size is length
		int length = sm1.elements.length;
		// create a square matrix of the required length
		double[][] difference = new double[length][length];
		// iterate through rows and columns and subtract each element
		for(int i = 0; i < length; i++) {
			for(int j=0; j < length; j++) {
				difference[i][j] = sm1.elements[i][j] - sm2.elements[i][j];
				}
			}
		// return the resulting matrix
		return new SquareMatrix(difference);
		}
	
	// matrix multiplication 
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		// check if the matrices are the same size 
		if (sm1.elements.length != sm2.elements.length) {
			throw new Exception("matrices are not of the same size");
		}
		int length = sm1.elements.length;
		// create a matrix of the required size 
		double[][] product = new double[length][length];
		// iterate through rows and columns
		for(int i = 0; i < length; i++) {
			for(int j=0; j < length; j++) {
				product[i][j] = 0;
				// set the initial values to zero for each entry.
				// then iterate through an arbitrary index k and 
				// perform matrix multiplication
				for(int k=0; k<length ;k++) {
					product[i][j] += sm1.elements[i][k]*sm2.elements[k][j] ;
				}

				}
			}
		// return the matrix product
		return new SquareMatrix(product);
		}
	
	// the following three methods are the non static versions of our above 
	// static methods: add, subtract, multiply
	public SquareMatrix add(SquareMatrix sm2) throws Exception {
		return add(this, sm2);
		
	}
	
	public SquareMatrix subtract(SquareMatrix sm2) throws Exception {
		return subtract(this, sm2);
	}
	
	public SquareMatrix multiply(SquareMatrix sm2) throws Exception {
		return multiply(this, sm2);
	}
	
	
}
	
	
	
