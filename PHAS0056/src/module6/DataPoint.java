package module6;
import java.util.Scanner;
//Each line of the list contains three values in order: x, y and ey, where x is a parameter set by the experimenter, 
//y is a measurement of a dependent variable, and ey is the measurement error on y. 
//In this exercise you will write a program to assess how well these data are described by a function of the 
//form y = xn.

//The goodness of fit between the function and the data is measured using the Χ2 (chi squared) statistic, 
//defined as the sum over all data points of the quantity (ymeasured - ytheory)2 / ey2.

public class DataPoint {
	//initialize variables
	public double x;
	public double y;
	public double ey;
	
	public DataPoint(double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}
	
	// getter methods for x, y, and ey
	public static double getX(double x) {
		return x;
	}
	public static double getY(double y) {
		return y;
	}
	public static double getEY(double ey) {
		return ey;
	}
	
	public static DataPoint readline(String line) {
		// this is another way of scanning through the lines. 
		// this way works differently than the one that we use in general for labelled or unlabelled
		// because there is no case scenario in which we will hit a string for a non-labelled data point
		Scanner scan = new Scanner(line);
		double[] numbers = new double[3];
		for (int i = 0; i< 3; i++) {
		numbers[i] = scan.nextDouble();
		}
		DataPoint point = new DataPoint(numbers[0], numbers[1], numbers[2]);
		scan.close();
		return point;
	} 
	public String toString() {
		return "x =  " +x + "y = " + y + " +- " + ey;
	}
	
}