package practiceexam3;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;

import practiceexam2.Player;
import practiceexam3.Get_Data;

public class practiceexam3 {

	public static void main(String[] args) {
		
		Get_Data gd = new Get_Data();

		try {
		ArrayList<Measurement> data_list = gd.datafromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/N_extent_v3.0.csv");
		System.out.println("The total number of measurements is " + data_list.size());
		
		HashMap<Point, Measurement> bymonthandyear = gd.getMeasMap(data_list);
		
		Measurement lowest_extent = Collections.min(data_list, Comparator.comparingDouble( i -> (i).getExtent()));

		Measurement lowest_area = Collections.min(data_list, Comparator.comparingDouble( i -> ((i).getArea())));
		
		System.out.println("the details of the measurement for the  month with the lowest total ice extent is " + lowest_extent);
		System.out.println("the details of the measurement for the  month with the lowest total ice area is " + lowest_area);

		int[] months = {1,2,3,4,5,6,7,8,9,10,11,12};
		
		HashMap<Integer, Double> month_average = new HashMap<Integer, Double>();
		HashMap<Double, Integer> diffMap = new HashMap<Double, Integer>();

		
		for (int i: months) {
			double min_area = 1000;
			double difference = 0;
			// if i == 1 this remains null 
			//HashMap<Double, Integer> diffMap = new HashMap<Double, Integer>();
			ArrayList<Double> diffs = new ArrayList<Double>();
			ArrayList<Double> five_biggest = new ArrayList<Double>();
			ArrayList<Double> for_average = new ArrayList<Double>();

			int year = 0;
			
			for (Map.Entry element : bymonthandyear.entrySet()) {
				Point p = (Point) element.getKey();
				Measurement m = (Measurement) element.getValue();
				if (p.x == i) {
					if (m.area < min_area) {
						year = m.year;
						
						// we are in the entry in (month, year) , (measurement)
						for_average.add(m.area);
						
					}
				Point last_year = new Point(i, m.year - 1);
				if (i != 1 && bymonthandyear.get(last_year) != null)  {

				// here we skip when i = 1
				// calculate the difference 
					Measurement last_m = bymonthandyear.get(last_year);
					difference = m.area - last_m.area;
					diffs.add(difference);
					diffMap.put(difference, p.y);
					
					}
				}
			}
			
			System.out.println("For the month " + i + ", The year with the lowest ice area is " + year);
			
			if (i != 1) {
				System.out.println("For the month " + i + " The required difference is " + difference  );
			}
			if (i != 1) {
				int d;
				for (d=0; d<=5; d++) {
					double max = Collections.max(diffs);
					diffs.remove(max);
					five_biggest.add(max);
				}
				System.out.println("The years with the 5 biggest differences in month " + i + " are" );
				for (double max : five_biggest) {
					System.out.println(diffMap.get(max));
				}	
			}
			
			Double average = for_average.stream().mapToDouble(val -> val).average().orElse(1);
			month_average.put(i, average);
			System.out.println("for month " + i + " the average ice area is " + average);
			System.out.println("\n");
		}	
		
		// i is the month with the lowest average 
		Double lowestAverage = Double.parseDouble("1000");
		double highestAverage = 0;
		int lowestAverageMonth = 1000;
		int highestAverageMonth = 0;
		
		for (Map.Entry e: month_average.entrySet()) {
			Double a = (Double) e.getValue();
			if (a < lowestAverage) {
				lowestAverage = a;
				lowestAverageMonth = (int) e.getKey();
			}
			if (a > highestAverage) {
				highestAverage = a;
				highestAverageMonth = (int) e.getKey();

			}
			
		}
		// average change in area per year 
			// have (month, year), (measurement)
		
			// we have (difference, year)
			// we need average difference for each year in lowestAverageMonth
		Point poi = null;
		Point poi2 = null;
		double current_area = 0;
		
		ArrayList<Double> average_change = new ArrayList<Double>();
		ArrayList<Double> average_change2 = new ArrayList<Double>();

		for (Map.Entry entry: bymonthandyear.entrySet()) {
			
			Point p = (Point) entry.getKey();
			Measurement moo =  (Measurement) entry.getValue();
			
			if (p.x == lowestAverageMonth) {
				poi = p;
				current_area = (moo.area);
				// we are in the month with the lowest average area
				int year1 = p.y;
				for (Map.Entry en : diffMap.entrySet()) {
					int y = (int) en.getValue();
					if (y == year1) {
						
						average_change.add((double) en.getKey());					}
				}	
			}
			
		}
		
		Double averageChange = average_change.stream().mapToDouble(val -> val).average().orElse(1);
		
		System.out.println("For the month " + poi + " which is the month with the lowest average area, " + "\n" + "the average change in area per year is " + averageChange);
		
		int count = 2017;
		while (current_area > 0) {
			current_area += averageChange;
			count += 1;
		}
		
		System.out.println("It will be in " + count + " that there will be no longer ice in the arctic" + "\n");
		

		// need the year with the biggest fall in ice area, the biggest negative difference  (the smallest difference)
		
		double bigdrop = 0;
		int pessimisticyear = 0;
		for (Map.Entry en : diffMap.entrySet()) {
			int ye = (int) en.getValue();
			double drop = (double) en.getKey();
			if (drop < bigdrop) {
				bigdrop = drop;
				pessimisticyear = ye;
			}				
		}
		
		int count2 = pessimisticyear;
		double are = 0;
		// i need the current area in the pessimistic year 
		for (Map.Entry element : bymonthandyear.entrySet()) {
			Point poin = (Point) element.getKey();
			if (poin.y == pessimisticyear) {
				are = ((Measurement) element.getValue()).area;
			}
			
		}
		
		while (are > 0) {
			are += bigdrop;
			count2 += 1;
		}

		System.out.println("The most pessimistic estimate for when there will be no more ice in the arctic is "
				+ "" + count2);

		}
		
		catch (IOException e) {
			System.out.println(e);
		}
	}
}

