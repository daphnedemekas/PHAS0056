package finalexam_3;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class Part1 {
	

	public static void main(String[] args) {
		GetData gd = new GetData();


		try {
		
		ArrayList<Flight> flights = gd.getFlightData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
		HashMap<String, Airport> airports = gd.getAirportData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");

		for (Flight f: flights) {

			String origin = airports.get(f.origincode).name;
			String destination = airports.get(f.destinationcode).name;
			
			long duration = duration(f);

			
			System.out.println("Flight code: " + f.flightcode + ", origin airport: " + origin + ", destination airport: " + destination + "\n"
					+ "date and time of departure: " + f.departuredate + ", " + f.departuretime + ", date and time of arrival: " + f.arrivaldate + " " + f.arrivaltime + "\n"
					+ "duration of flight: " + duration + " minutes, cost of flight: " + f.cost + "\n");
		}
		
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static long duration(Flight f) {
		GetData gd = new GetData();
		long duration = 0;

		
		try {
			HashMap<String, Airport> airports = gd.getAirportData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
			LocalDateTime lt1 = LocalDateTime.parse(f.departuredate + "T" + f.departuretime);
			ZoneId z1 = ZoneId.of(airports.get(f.origincode).zone);
			LocalDateTime lt2 = LocalDateTime.parse(f.arrivaldate + "T" + f.arrivaltime);
			ZoneId z2 = ZoneId.of(airports.get(f.destinationcode).zone);
			ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);
			ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);
			duration = zt1.until(zt2, ChronoUnit.MINUTES);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return duration;

	}
	

}
