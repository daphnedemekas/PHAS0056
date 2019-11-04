package module5;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {

	
	//a static method dataFromURL(String url)
	//that reads the values from the given URL and returns them in the form of an ArrayList.

	ArrayList<DataPoint> MyList;
	//should i iniitalize this variable?

	public static ArrayList<DataPoint> dataFromURL(String url) throws Exception {
		ArrayList<DataPoint> MyList = new ArrayList<DataPoint>();
		// first check if the string is a valid url
		URL u = new URL(url);
		// create an input stream
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);
		//return the buffered reader object
		String line = "";
		while ((line = b.readLine()) != null) {
			// read the data line by line
			DataPoint data = DataPoint.readline(line);
			MyList.add(data);
		}
		// return a list of data points (x,y,ey)
		return MyList;
	}
	public static double goodnessOfFit(Theory theory, ArrayList<DataPoint> L) {
		// initial chi is zero 
		double chi = 0;
		// iterate through the lines of the datafile
		for (DataPoint data: L) {
			// difference is y measured - y theory
			double diff  = data.y - theory.y(data.x); 
			// sum the square of the difference over the square of the error
			chi += (diff*diff / data.ey*data.ey);
		}
		return chi;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("Our chi squareds for n=2 and n=4 are:");
		// test using this link
		ArrayList<DataPoint> List = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		// test first for n is 2
		Theory theory1 = new Theory(2);
		double chi1 = goodnessOfFit(theory1,List);
		System.out.println("For n=2:  " + chi1);
		System.out.println("our data is a very bad estimate of the function x^2!");
		
		Theory theory2 = new Theory(4);
		double chi2 = goodnessOfFit(theory2,List);
		System.out.println("For n=4:  " + chi2);
		System.out.println("we have a much better estimate of the function x^4");
	}
}
