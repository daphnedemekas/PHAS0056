package finalexam_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetData {
	
	public GetData() {};
	
	public ArrayList<Flight> getFlightData(String url) throws IOException {
		ArrayList<Flight> flights = new ArrayList<Flight>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split(",\\s*");
			String flightcode = row[0];
			String origincode = row[1];
			String destinationcode = row[2];
			String departuredate = row[3];
			String departuretime = row[4];
			String arrivaldate = row[5];
			String arrivaltime = row[6];
			Double cost = Double.parseDouble(row[7]);
			Flight flight = new Flight(flightcode, origincode, destinationcode, departuredate, departuretime, arrivaldate, arrivaltime, cost);
			flights.add(flight);
		}
		scanner.close();

		return flights;
	}
	
	public HashMap<String, Airport> getAirportData(String url) throws IOException {
		HashMap<String, Airport> airports = new HashMap<String, Airport>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split(",\\s*");
			String airportcode = row[0];
			String name = row[1];
			String zone = row[2];
			Airport airport = new Airport(airportcode, name, zone);
			airports.put(airportcode, airport);
		}
		scanner.close();

		return airports;
}
}
