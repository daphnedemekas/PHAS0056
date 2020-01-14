package finalexam_3;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class LayoverFilter {
	// would call this something else

	String origin;
	String destination;
	
	public Layover filter(ArrayList<Flight> flights) {
		ArrayList<Flight[]> connections = new ArrayList<Flight[]>();
		
		ArrayList<Flight> originlist = new ArrayList<Flight>();
		ArrayList<Flight> destinationlist = new ArrayList<Flight>();

		for (Flight f: flights) {
			if (f.origincode.equals(origin)) {
				originlist.add(f);
			}
			if (f.destinationcode.equals(destination)) {
				destinationlist.add(f);
			}
		}
		
		for (Flight o: originlist) {
			for (Flight d: destinationlist) {
				if (o.destinationcode.equals(d.origincode) && layover(o,d) > 0 && layover(o,d) < 24*60) {
					Flight[] connection = {o,d};
					connections.add(connection);
				}
			}
		}
		
		double mincost = 100000;
		Flight[] cheapestflight = null;
		
		for (Flight[] c : connections) {
			double cost = c[0].cost + c[1].cost;
			if (cost < mincost) {
				mincost = cost;
				cheapestflight = c;
			}
			
		}
		
		Layover cheapestlayover = new Layover(cheapestflight[0], cheapestflight[1], mincost);
		
		return cheapestlayover;
		
	}
	
	public long layover(Flight f1, Flight f2) {
		GetData gd = new GetData();
		long duration = 0;
		
		long duration1 = Part1.duration(f1);
		long duration2 = Part1.duration(f2);

		try {
			HashMap<String, Airport> airports = gd.getAirportData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
			LocalDateTime lt1 = LocalDateTime.parse(f1.arrivaldate + "T" + f1.arrivaltime);
			ZoneId z1 = ZoneId.of(airports.get(f1.destinationcode).zone);
			LocalDateTime lt2 = LocalDateTime.parse(f2.departuredate + "T" + f2.departuretime);
			ZoneId z2 = ZoneId.of(airports.get(f1.origincode).zone);
			ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);
			ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);
			duration = zt1.until(zt2, ChronoUnit.MINUTES);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		if (duration < 0) {
			return -1;
		}
		return duration1 + duration + duration2;

	}
	
	

}
