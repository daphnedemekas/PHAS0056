package finalexam_1;

import java.util.ArrayList;

public class ArrivalTimeComparison {
	
	ArrivalTime_method1 arrivaltime1 = new ArrivalTime_method1();
	
	ArrivalTime_method2 arrivaltime2 = new ArrivalTime_method2();
	ArrayList<String> detectors = new ArrayList<String>();

	
	double totalmax;
	String result;

	
	//Write a program to find out and report for which detector the difference
	//between the arrival times calculated using the two methods is greatest.
	
	public String compareArrivalTime(ArrayList<Signal> signals) {
		
		totalmax = 0;
		result = null;
		
		for (Signal s: signals) {
			if (!detectors.contains(s.identifier)) {
				detectors.add(s.identifier);
			}
		}
		
		for (String d: detectors) {
			double maxdifference = 0; 
			for (Signal s: signals) {
				if (s.identifier.equals(d)) {
					double time1 = arrivaltime1.arrivaltime(s);
					double time2 = arrivaltime2.arrivaltime(s);
					double difference = Math.abs(time1 - time2);
					if (difference > maxdifference) {
						maxdifference = difference;
					}
				}
			}
			if (maxdifference > totalmax) {
				totalmax = maxdifference;
				result = d;
			}
		}
		return result;
	}
	

}
