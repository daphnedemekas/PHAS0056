package finalexam_3;

import java.util.ArrayList;

public class CostFilter implements FlightFilter {
	
	Double maxcost;

	public ArrayList<Flight> filter(ArrayList<Flight> flights) {
		ArrayList<Flight> output = new ArrayList<Flight>();
		
		for (Flight f: flights) {
			if (f.cost < maxcost) {
				output.add(f);
			}
			
		}
		return output;
	}

}
