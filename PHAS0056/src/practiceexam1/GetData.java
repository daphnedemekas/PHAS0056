package practiceexam1;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class GetData {
	
	public ArrayList<Earthquake> dataFromURL(String url) throws IOException {
		ArrayList<Earthquake> data = new ArrayList<Earthquake>();
		// first check if the string is a valid url
		URL u = new URL(url);
		// create an input stream
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner =  new Scanner(b);
		// regex to break on any amount of spaces
		
		//call the first line first to get read of header
		scanner.nextLine();
		
		scanner.nextLine();
		
		while (scanner.hasNext()) {
			// create a list out of the 2 row entries
			String[] row = scanner.nextLine().split("\\s+");
			// collect the code 
			Date DayMonthYear = new Date(Integer.parseInt(row[2]), Integer.parseInt(row[2]), Integer.parseInt(row[0]));
			
			Time SecondMinuteHour = new Time(Double.parseDouble(row[5]), Integer.parseInt(row[4]), Integer.parseInt(row[3]));
			
			Position LonLat = new Position(Double.parseDouble(row[7]), Double.parseDouble(row[6]));
			
			double depth = Double.parseDouble(row[8]);
					
			double depth_error = Double.parseDouble(row[12]);
			
			double mag = Double.parseDouble(row[13]);
			
			long id = Long.parseLong(row[14]);
			// put the code and mass into the has map
			
			Earthquake eq = new Earthquake(id, mag, depth_error, depth, LonLat, SecondMinuteHour, DayMonthYear);
			
			data.add(eq);
		}
		// return a list of data points (x,y,ey)
		return data;
	
	}
	

}
