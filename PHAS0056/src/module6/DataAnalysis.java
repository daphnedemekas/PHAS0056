package module6;

import java.util.Collection;
import java.util.ArrayList;
import module6.QuadraticTheory;

public class DataAnalysis {

	// the main method should return the function that has the best fit to the datapoints in the file
	public static void main(String[] args) {
	
		// make the three functions asked for in the question
		QuadraticTheory qt = new QuadraticTheory(1,10,0);
		PowerLawTheory plt = new PowerLawTheory(2.05);
		PowerLawTheory plt2 = new PowerLawTheory(2);
		
		// make an arraylist to contain these functions and add them in
		// you can make an arraylist here because it is a class that implements collection
		ArrayList<Theory> d = new ArrayList<Theory>();
		d.add(qt);
		d.add(plt);
		d.add(plt2);
		
		
		try {
			// make an arraylist of data points from the url given
			ArrayList<DataPoint> data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			
			// make your goodness of fit calculator 
			GoodnessOfFitCalculator gofc = new ChiSquared();
			// print out the best theory (the best function in terms of smallest goodness of fit value)
			System.out.println(bestTheory(data, d, gofc));
		}
		// catch any exceptions and print them out 
		catch (Exception e) {
			System.out.println(e);
		}
	
	
	
	}
	// this method will select the Theory (the equation) that gives the best agreement 
	// with a given set of DataPoint objects 
	// this is done by minimising the goodness of fit function
	// which in  this case is the chi squared function but could be any other function 
	// since we have an interface 
	
    private static Theory bestTheory(Collection<DataPoint> data,
            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
    	// the inputs of the function are a a collection of data points and a collection of theories (functions)
    	// in our case we use an arraylist but could in general be any collection 
    	// as well as a GoodnessOfFitCalculator which is an interface, which can then be used to make an instance of
    	// whichever kind of function we want to minimise in order to measure the goodness of our fit 
    	
        boolean first = true;
        // this is because we need to change our 'bestTheory' from null initially 
        // in order for the chi squared function to be minimised 
        // so we need to make an if statement that only applies to the first iteration in the for loop below
        
        double bestGoodnessOfFit = 0.0;
        // maximum chi squared (initially)
        // the fact that this is zero doesn't matter really 
        //because we change it in our first iteration
        
        Theory bestTheory = null;
        // we set this as null initially but will change it in our first iteration
        
        for (Theory theory : theories) {
        	// iterate through the functions that we would like to test
        	
            double gof = gofCalculator.goodnessOfFit(data, theory);
            System.out.println(theory + " " + gof);
            // calculate chi squared for this initial function 
            
            if (first) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
                first = false;
                // for the first iteration, first will be true
                // here we need to update our bestTheory from null to the first 
                // function in our for loop and set first to false
                // so that we never go into this if statement again
                
            } else if (gof < bestGoodnessOfFit) {
            	// now our bestGoodnessOfFit is the gof of our first function 
            	// that we iterated through so we need to check if our second function
            	// has a smaller goodness of fit than our first 
            	// if it does, then we need to update our bestTheory
            	// as well as our best goodnessoffit 
            	// in order to check the next function to see if its EVEN smaller
            	
            	// if not we just go ahead and return the first function 
            	
                bestTheory = theory;
                
                bestGoodnessOfFit = gof;
            }
        }
        return bestTheory;
    }

}
