package module5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.Map;

public class Minerals {
	// initialize my maps
	HashMap<Long, Double> massMap;
	HashMap<Long, String> locationMap;
	
	//make a constructor
	public Minerals () {}
	
	
	public static void main(String[] args) throws Exception{
		
		Minerals m = new Minerals();
		// start with the sample mass map, create vairable
		HashMap<Long, Double> massMap = m.SampleMass("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");	
		
		//get the key of the maximum value in the hash map
		
		// this first finds the maximum mass and then uses the comparator to then retrieve the key of that maximum mass in the map
		long heaviestMineral = Collections.max(massMap.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();
		// this gets the maximum mass 
		double maxMass = Collections.max(massMap.values());
		
		System.out.println("The code for the heaviest mineral is:  " + heaviestMineral);
		System.out.println("The mass of the heaviest mineral is: " + maxMass);
		
		//here we make our locations map
		HashMap<Long, String> locationMap = m.SampleLocation("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
		// and here we get the location of the maximum mass 
		String location = locationMap.get(heaviestMineral);
		
		System.out.println("The location of the heaviest mineral is: " + location);
		
		}
	

	
	public HashMap<Long, Double>  SampleMass(String url) throws Exception{
		//create my hashmap
		massMap = new HashMap<Long, Double>();
		// first check if the string is a valid url
		URL u = new URL(url);
		// create an input stream
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);
		// make a scanner to search through the file entires
		Scanner scanner =  new Scanner(b);
		// regex to break on any amount of spaces
		while (scanner.hasNext()) {
			// create a list out of the 2 row entries
			String[] row = scanner.nextLine().split("\\s+");
			// collect the code 
			long code = Long.parseLong(row[0]);
			// collect the mass
			double mass = Double.parseDouble(row[1]);
			// put the code and mass into the has map
			massMap.put(code, mass);
		}
		return massMap;
			
		}
	
	public HashMap<Long, String>  SampleLocation(String url) throws Exception{
		// create the map for locations
		locationMap = new HashMap<Long, String>();
		// first check if the string is a valid url
		URL u = new URL(url);
		// create an input stream
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);
		//create the scanner 
		Scanner scanner =  new Scanner(b);
		// regex to break on any amount of spaces
		while (scanner.hasNext()) {
			// create a list to search through the objects
			String[] row = scanner.nextLine().split("\\s+");
			// get the code, second entry this time
			long code = Long.parseLong(row[1]);
			// get the location
			String location = row[0];
			// put the code and location in the hash map
			locationMap.put(code, location);
		}
		return locationMap;
			
		}


}

