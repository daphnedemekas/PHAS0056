package finalexam_3;

import java.util.ArrayList;

public class OriginDestinationFilter implements FlightFilter {
	
	String origincode;
	String destinationcode;

	public ArrayList<Flight> filter(ArrayList<Flight> flights) {
		ArrayList<Flight> output = new ArrayList<Flight>();
		for (Flight f: flights) {
			if (f.origincode.equals(origincode) && f.destinationcode.equals(destinationcode)) {
				output.add(f);
			}
		}
		return output;
	}

}
