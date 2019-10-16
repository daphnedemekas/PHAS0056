package module2;
import java.lang.Math;
public class ThreeVector {
// this class should store and retrieve (as double variables) the x,y,z components of a 3-component vector. 
	
	//input is three real numbers representing cartesian or polar coordinates

	double x;
	
	double y;
	
	double z; 
	// this stores the vector
	
	public ThreeVector(double x, double y, double z) {
		this.x = x; 
		this.y = y; 
		this.z = z; 
	}
	
	//for calculating the magnitude of a vector
	
	// define the zero vector
	static ThreeVector ZERO = new ThreeVector(0,0,0);

	
	double magnitude() { 
		
		double mag = Math.sqrt(x*x + y*y + z*z);
		
		return mag;
	}
	
	//returns a unit vector in the same direction as the vector in the input (by dividing each component by magnitude)
	public ThreeVector unitVector() throws Exception{
		double mag = magnitude();

		// add exception for zero vector
		if (mag == 0) {
			throw new Exception("division by zero");
		}
		double unit_x = x / mag;
		
		double unit_y = y / mag;
		
		double unit_z = z / mag;
		// better to store magnitude first
		return new ThreeVector(unit_x, unit_y, unit_z);
	}
	// returns as a string the components of the vector
	
	public String toString() {
		String components =  "x = " +x + ", y = " +y + ", z = " +z;
		return components;
	}
	
	// static method: take arguments three vectors, return scalar product by multiplying components
	public static double scalarProduct(ThreeVector v1, ThreeVector v2) {
		double scalar_product = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
		return scalar_product;
	}
	
	// static method: take arguments as three vectors, return vector product 
	public static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {
		double s1 = v1.y*v2.z - v1.z*v2.y;
		double s2 = v1.z*v2.x - v1.x*v2.z;
		double s3 = v1.x*v2.y - v1.y*v2.x;
		return new ThreeVector(s1, s2, s3);
	}
	
	//add to vectors 
	public static ThreeVector add(ThreeVector v1, ThreeVector v2) {
		ThreeVector v = new ThreeVector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
		return v;
	}
	// return the angle in radians between the two input vectors 
	public static double angle(ThreeVector v, ThreeVector u) throws Exception {
		if (v == ZERO || u == ZERO) {
		
		// could also do if ((v.x == 0 && v.y == 0 && v.z == 0 ) || (u.x == 0 &&  u.y == 0 && u.z ==0))
			
			throw new Exception("division by zero");
		}
		double cosine = scalarProduct(v, u) / (v.magnitude()*u.magnitude());
		double radian = Math.acos(cosine);
		return radian;
	}
	
	// the following are 4 non-static versions of the above static functions
	public double scalarProduct(ThreeVector v1) {
		return scalarProduct(this, v1);
	}
	//performs the vector product
	public ThreeVector vectorProduct(ThreeVector v1) {
		return vectorProduct(this, v1);	
	}
	//performs addition
	public ThreeVector add(ThreeVector v1) {
		return add(this, v1);
	}
	//calculates the angle between vectros
	public double angle(ThreeVector v1) throws Exception {
		if (v1 == ZERO || this == ZERO) {
			throw new Exception("division by zero");
		}
		return angle(this, v1);
	}
	
	// this just tests if the string method works 
	
	public static void main(String[] args) {
		ThreeVector u = new ThreeVector(1,0,0);
		String myThreeVec = u.toString();
		System.out.println(myThreeVec);
	}
	
}
