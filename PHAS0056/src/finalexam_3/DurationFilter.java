package finalexam_3;

import java.util.ArrayList;

public class DurationFilter implements FlightFilter {

	double maxduration;
	GetData gd = new GetData();

	public ArrayList<Flight> filter(ArrayList<Flight> flights) {
		ArrayList<Flight> output = null;

		try {
			output = new ArrayList<Flight>();

			for (Flight f : flights) {
				
				long duration = Part1.duration(f);

				if (duration < maxduration) {
					output.add(f);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return output;
	}
	
}
