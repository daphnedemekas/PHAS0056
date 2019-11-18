package module6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDataPoints {

	public static void main(String[] args) {

		try  {
			// we define points to be our array list created below of labelled or non labelled data points
			//depending on the line in the URL
			ArrayList<DataPoint> points = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			// iterate through the data point objects and print them out 
			for (DataPoint p : points) {
				System.out.println(p);			
			}
		}
		// catch any exceptions and print them out
		catch (Exception e) {
			System.out.println(e);
			
		}

	}
	
	// this will look through the data file on the URL and either put a line into a point 
	// or a labelled point if the line contains a label 
	// and then return an array of each data points (either labelled or non labelled)
	
	public static ArrayList<DataPoint> dataFromURL(String url) throws Exception{
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
		// first check if the string is a valid url
		URL u = new URL(url);
		// create an input stream
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);
		//return the buffered reader object
		Scanner s = new Scanner(b);
		// make a scanner object to separate the points by white space 
		while (s.hasNext()) {
			String[] r = s.nextLine().split("\\s+");
			
			// parse the first three entries of every row (x , y and ey) 
			double x = Double.parseDouble(r[0]);
			double y = Double.parseDouble(r[1]);
			double ey = Double.parseDouble(r[2]);
			
			// declare the DataPoint that you have to return 
			DataPoint data;
			
			if (r.length == 4 ) {
				// if you have a line with 4 elements in it, this means you have a label
				// then you need to make a labelled data point containing a string with a label
				String label = r[3];
				data = new LabelledDataPoint(x,y,ey,label);
			}
			
			else {		
				// if you don't have a line with 4 elements then you don't have a label
				// and you only need a regular data point object 
				data = new DataPoint(x,y,ey);
			}
			// add your data point ( or labelled data point) to your array list of data points 
			dataPoints.add(data);
		}
		// close your scanner
		s.close();
		return dataPoints;
	}

}
