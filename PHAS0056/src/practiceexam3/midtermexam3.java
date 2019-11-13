package practiceexam3;

import java.io.File;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.awt.Point;

import practiceexam2.Player;


public class midtermexam3 {
	
	// the best bet would be to start with a hashmap of the point (dates) and the objects and then work from there

	//private String file;
	//private String directory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	GetData3 gd = new GetData3();
	String datafile = "midtermpracticexam3.csv";
	String directory;
	String file;

	// our data is saved on a file which must be accesible from any directory
	//thus we will first ask for the input of the directory in which the file is stored from the user 
	try {
		directory = Directory.getDirectory();
		file = (String) directory +  datafile;
		// get the data from the file
		
	}
	catch (Exception e) {
		directory = System.getProperty("user.home");
		file = (String) directory +  datafile;
		// get the data from the file
	}
	
	
	
	try {
		
		ArrayList<Measurement> data = gd.getData(file);
		
		System.out.println("The total number of measurements is: " + data.size() + "\n");
		
		// make an array list of unique dates
		
		ArrayList<Point> months = new ArrayList<Point>();
		ArrayList<Integer> ms = new ArrayList<Integer>();
		HashMap<Point, Measurement> map = new HashMap<Point, Measurement>();
	
		for (Measurement d : data) {
			// the following two lines ensure that we don't hit the values 101
			//necessary to use the object double in order to succesfully use .equals()
			double number = Double.parseDouble("101");
			if (!d.area.equals(number) && !d.extent.equals(number))  {
		// add numbers to the point
			Point p = new Point(d.month, d.year);
		// add numbers to the months array
			months.add(p);
		// Map(point, object)
			map.put(p, d);
			
			if (!ms.contains(d.month)) {
				ms.add(d.month);
			}
			}
		}


		Double min1 = 100.0;
		Double min2 = 100.0;
		Measurement min_extent = null;
		Measurement min_area = null;
		
		// should be able to do it like this
		//Point p = Collections.min(data, Comparator.comparingDouble(i -> i.getArea())).getKey();
		
		
		
		//=======================================================
		// iterate through the points in the keyset 
		
			
		 
		 
			 
		for (Point m : months) {
	
			double e1 =  100;
			double e2 = 100;
			// setting the maximum extents for each month 
			
			for (Measurement d: data) {
				Double number = Double.parseDouble("101");
				if (!d.area.equals(number) && !d.extent.equals(number)) {
				Point p = new Point(d.month, d.year);
				if (p.equals(m)) {
					// for all of the measurements of the same month and year 
					
					// check if the current extent is less than the minimum for the current month
					if (d.extent < e1) {
						e1 = d.extent; // if so update the current extent
						
						// also if so, check if the current extent is less than the current minimum over all months
						if (d.extent < min1) {
							min1 = d.extent; // if so update the minimum over all months
							min_extent = d; // also  update the measurement with the smallest extent
						}
					}
					// now we do the exact same thing for area
					if (d.area < e2) {
						e2 = d.extent;
						if (d.extent < min2) {
							min2 = d.extent;
							min_area = d;
						}
					}
				}
				}
			}
		}
		System.out.println("The smallest ice extent occured in  " + min_extent.month + ", " + min_extent.year + " and the details are " + "\n" + min_extent);
		System.out.println("The smallest area occured in month " + min_area.month + " , " + min_area.year + " and the details are "+ "\n"  + min_area + "\n");
		
		// It turns out that they are in the same month
		
		// HASHMAP: months, object 
		ArrayList<Double> avgd = new ArrayList<Double>();
		double min_avg = 100;
		double max_avg = 0;

		
		for (Integer m: ms) {
			double min_a =  100;
			double min_year = 3000;

			// setting the maximum extents for each month 
			
			for (Measurement d: data) {
				Double number = Double.parseDouble("101");
				if (!d.area.equals(number) && !d.extent.equals(number)) {
				if (m.equals(d.month)) {
					// we are in the same month
					avgd.add(d.area);
					if (d.area < min_a) {
						min_a = d.area;
						min_year = d.year;	
					}
					}
				}
				}	
			System.out.println("For the month " + m + ", The year with the smallest area is " + (int) min_year );
			
			// calculate and print the difference in area from the previous year 
			
			System.out.println("The differences are: " );
			// first year is 1979
			Integer year = 1980;
			Integer i;
			HashMap<Double, Integer> years = new HashMap<Double, Integer>() ;
			ArrayList<Double> y = new ArrayList<Double>();
			for (i = 1980; i<= 2016; i++) {
				Point point1 = new Point(m, i);
				Point point2 = new Point(m, i-1);
				
				
				
				
				// =================
				
			
				if ( map.containsKey(point1) &&  map.containsKey(point2)) {
					// map.get(point) is AN OBJECT corresponding to the KEY point 1, point 2 so we can say .area
				Double area1 = map.get(point1).area;
				Double area2 = map.get(point2).area;
				Double difference = area1 - area2;
				System.out.println(difference);
				y.add(difference);
				years.put(difference, i);
				}
			}
			double sum = 0;
			int max_month;
			int min_month;
			for (Double avg : avgd) {
				sum += avg;
			}
			if ((sum / avgd.size()) < min_avg) {
				min_avg = sum / avgd.size();
				min_month = m;
			}
			if ((sum / avgd.size()) > max_avg) {
				max_avg = sum / avgd.size();
				max_month = m;

			}
			System.out.println("The average is " + (sum / avgd.size()));
			//System.out.println("The max is" + max_month);
			//System.out.println("The min is" + min_month);

			
			Collections.sort(y);
			Collections.reverse(y);

			System.out.println("And we have");
			int num;
			for (num=0; num<=5; num++) {
				System.out.println(years.get(y.get(num)));
			}

			
			}
			System.out.println("\n");
	
		
		// January
		// 2016 - 2015 = , 2017-2016 = 
		
		
		
	}
	
	catch (Exception e) {
		System.out.println(e); 
		
	}
	
	

}
	
}