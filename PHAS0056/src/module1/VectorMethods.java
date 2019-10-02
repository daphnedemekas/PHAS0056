package module1;
import java.lang.Math;

public class VectorMethods {
	
	public VectorMethods() { }
	

	double dotProduct (double x, double y, double z, double a, double b, double c) {
		
		y = x*a + y*b + z*c;
		
		return y;	
	}	
	
	double magnitude (double x, double y, double z) {
		
		y = Math.sqrt(x*x + y*y + z*z);
		
		return y;
	}
	
	double angle (double x, double y, double z, double a, double b, double c) {
		
		double cosine = dotProduct(x,y,z,a,b,c) / (magnitude(x,y,c) * magnitude(a,b,c));
		
		double radian = Math.acos(cosine);
		
		double degrees = Math.toDegrees(radian);
		
		return degrees;
		
	}

	public static void main(String[] args) {
		
		VectorMethods vm = new VectorMethods();
		
		double x = 4;
		double y = 3;
		double z = 2;
		
		double a = 1;
		double b = 5;
		double c = 4;
		
		// magnitude
		double mag1 = vm.magnitude(x,y,z);
		double mag2 = vm.magnitude(a, b, c);
		
		
		// dotproduct 
		double dotproduct = vm.dotProduct(x,y,z,a,b,c);
		
		// angle
		double angle_between = vm.angle(x,y,z,a,b,c);
		
		System.out.println("the magnitudes of the vectors are "+ mag1 + " and " + mag2);
		System.out.println("the dot product of the vectors is " + dotproduct);
		System.out.println("the angle between the vectors is " + angle_between + " degrees");
	
		double d = 0;
		double e = 0;
		double f = 0;
		
		double angle_between2 = vm.angle(x, y, z, d, e, f);
		
		System.out.println("the angle between the vectors is " + angle_between2 + " degrees");
		System.out.println("you get Nan because you are dividing by zero (the magnitude of the zero vector is zero");
	
	}

}
