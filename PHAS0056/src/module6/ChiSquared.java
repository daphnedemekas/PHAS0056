package module6;
import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {

	public double goodnessOfFit(Collection<DataPoint> points, Theory equation) {
		double chi = 0;
		// iterate through the lines of the datafile
		for (DataPoint data: points) {
			// difference is y measured - y theory
			double diff  = data.y - equation.y(data.x); 
			// sum the square of the difference over the square of the error
			chi += (diff*diff / (data.ey*data.ey));
		}
		return chi;
	}


}
