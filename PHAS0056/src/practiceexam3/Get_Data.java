package practiceexam3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.*;


public class Get_Data {

	public ArrayList<Measurement> datafromURL(String url) throws IOException {
		URL u = new URL(url);
		// create an input stream
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner =  new Scanner(b);
		scanner.nextLine();
		scanner.nextLine();
		
		ArrayList <Measurement> m = new ArrayList<Measurement>();

		while (scanner.hasNext()) {
			// create a list out of the 2 row entries
			String[] row = scanner.nextLine().split(",\\s*");
			int year = Integer.parseInt(row[0]);
			int month = Integer.parseInt(row[1]);
			String type = row[2];
			String region = row[3];
			if (!row[4].equals("-9999") && !row[5].equals("-9999") && !type.equals(-9999)) {
				double extent = Double.parseDouble(row[4]);
				double area = Double.parseDouble(row[5]);			
				Measurement meas = new Measurement(year, month, type, region, extent, area);
				m.add(meas);

			}
		}
		return m;
	}
	
	public HashMap<Point, Measurement> getMeasMap(ArrayList<Measurement> m) {
		HashMap<Point, Measurement> measMap = new HashMap<Point, Measurement>();
		for (Measurement meas : m) {
			Point p = new Point(meas.month, meas.year);
			measMap.put(p, meas);
		}
		return measMap;
	}
	

}
