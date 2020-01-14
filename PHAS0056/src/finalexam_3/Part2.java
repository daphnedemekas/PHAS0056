package finalexam_3;

import java.util.ArrayList;

public class Part2 {

	public static void main(String[] args) {

		try {

			GetData gd = new GetData();

			ArrayList<Flight> flights = gd
					.getFlightData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
			
			OriginDestinationFilter odf = new OriginDestinationFilter();
			
			odf.origincode = "LHR";
			odf.destinationcode = "ATH";
			
			ArrayList<Flight> lhr_ath = odf.filter(flights);
			
			CostFilter cf = new CostFilter();
			cf.maxcost = (double) 200;

			
			ArrayList<Flight> below2hundred = cf.filter(lhr_ath);
			
			System.out.println("The flights between LHR and ATH below 200 are: " + "\n");
			for (Flight b: below2hundred) {
				System.out.println(b);
			}
			
			DurationFilter df = new DurationFilter();
			df.maxduration = (double) 4*60;
			
			ArrayList<Flight> under4hours = df.filter(lhr_ath);
			
			System.out.println("The flights between LHR and ATH under 4 hours are: " + "\n");
			
			double minduration = 5000;
			Flight minFlight = null;

			for (Flight u: under4hours) {
				System.out.println(u);
				
				double duration = Part1.duration(u);
				if (duration < minduration) {
					minduration = duration;
					minFlight = u;
				}
			}
			System.out.println("The shortest flight from LHR to ATH under 4 hours is: " + minFlight);
			
			
			
			
			
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

}
