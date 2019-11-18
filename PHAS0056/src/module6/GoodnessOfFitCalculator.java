package module6;
import java.util.Collection;

// this is an interface for any kind of function that you may want to use to calculate the goodness of your fit 
// in this case we need to minimise this function according to the code in our main method
// but may want to maximize in another scenario and in that case would need to elaborate this code 

public interface GoodnessOfFitCalculator {
	double goodnessOfFit(Collection<DataPoint> data, Theory theory);
}
