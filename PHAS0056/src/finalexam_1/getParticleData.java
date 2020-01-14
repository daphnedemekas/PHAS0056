package finalexam_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class getParticleData {
	
	// get the signal data
	// as an arraylist? 
	
	public ArrayList<Signal> getSignalData(String url) throws IOException {
		ArrayList<Signal> signals = new ArrayList<Signal>();
		
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner =  new Scanner(b);
		while (scanner.hasNext()) {
			ArrayList<Double> voltages = new ArrayList<Double>();
			// create a list out of the 2 row entries
			String[] row = scanner.nextLine().split("\\s+");
			String identifier = row[0];
			for (int i = 1; i< row.length; i++) {
				voltages.add(Double.parseDouble(row[i]));
			}
			Signal s = new Signal(identifier, voltages);
			signals.add(s);
		}
		scanner.close();

	return signals;
	}
	
	
	
	public HashMap<String, Double> getDetectorData(String url) throws IOException {
		HashMap<String, Double> detectors = new HashMap<String, Double>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner =  new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split("\\s+");
			String identifier = row[0];
			Double distance = Double.parseDouble(row[1]);
			detectors.put(identifier, distance);
		}
		scanner.close();

		return detectors;
	}
	
	// then make a hashmap (identifier, mean amplitude of pulses)
	
	
	

}
