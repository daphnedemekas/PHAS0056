package finalexam_3;


import java.util.ArrayList;

public class Part3 {

	public static void main(String[] args) {
		try {

			GetData gd = new GetData();

			ArrayList<Flight> flights = gd
					.getFlightData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
			
			OriginDestinationFilter odf = new OriginDestinationFilter();
	
			odf.origincode = "LHR";
			odf.destinationcode = "CPT";
			
			ArrayList<Flight> lhr_cpt = odf.filter(flights);
			
			
			DurationFilter df = new DurationFilter();
			df.maxduration = (double) 24*60;

			ArrayList<Flight> directflights = df.filter(lhr_cpt);
			
			double mincost = 50000;
			Flight mincostflight = null;
			for (Flight f: directflights) {
				if (f.cost < mincost) {
					mincost = f.cost;
					mincostflight = f;
				}
			}
			
			LayoverFilter lf = new LayoverFilter();
			lf.origin = "LHR";
			lf.destination = "CPT";
			
			Layover minlayover = lf.filter(flights);

			if (minlayover.cost < mincostflight.cost) {
				System.out.println("The cheapest flight from LHR to CPT is a layover flight with details: " + "\n"  + minlayover);
			}
			else {
				System.out.println("The cheapest flight from LHR to CPT is a direct flight with details: " + mincostflight);
			}
		}
			
		
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	}

