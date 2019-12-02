package midtermredo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetDataPolitics {
	
	
	Candidate c;
	
	public GetDataPolitics() {};

	
	public ArrayList<Candidate> dataFromURL(String url) throws Exception {
		ArrayList<Candidate> candidate = new ArrayList<Candidate>();
		
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner =  new Scanner(b);
		scanner.nextLine();
		while (scanner.hasNext()) {
			// create a list out of the 2 row entries
			String[] row = scanner.nextLine().split(",");
			String ons = row[0];
			int pano = Integer.parseInt(row[1]);
			String constituency = row[2];
			String surname = row[3];
			String firstname = row[4];
			String party = row[5];
			String identifier = row[6];
			int votes = Integer.parseInt(row[7]);
			c = new Candidate(ons, pano, constituency, surname, firstname, party, identifier, votes);
			candidate.add(c);
		}
	return candidate;
	
	
	}

	public static ArrayList<Electorate> electorateData(String url) throws IOException {
		ArrayList<Electorate> electorate = new ArrayList<Electorate>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr); 
		
		Scanner scanner = new Scanner(b);
		scanner.nextLine();
		
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split(",");
			String ons = row[0];
			String constituency = row[1];
			String region = row[2];
			int voters = Integer.parseInt(row[3]);
			Electorate e = new Electorate(ons, constituency, region, voters);
			electorate.add(e);
		}
	return electorate;
	}

}
