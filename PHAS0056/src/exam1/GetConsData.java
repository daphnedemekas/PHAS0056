package exam1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetConsData {

	private File resultsfile;
	// this is the file that contains the results
	private FileReader fr;
	private BufferedReader b;
	String id;
	String con;
	String country;
	int electorate;
	ArrayList<Const> constituent;

	public GetConsData() {
	};

	// the following function will return an array of objects containing all of the
	// values for each candidate
	public ArrayList<Const> getArrayList(String file) throws Exception {

		constituent = new ArrayList<Const>();

		fr = new FileReader(file);
		b = new BufferedReader(fr);

		String line = "";

		b.readLine();

		while ((line = b.readLine()) != null) {
			Scanner s = new Scanner(line);
			String[] row = s.nextLine().split(",");
			id = (String) row[0];
			con = (String) row[1];
			country = (String) row[2];
			electorate = Integer.parseInt(row[3]);
			Const c = new Const(id, con, country, electorate);
			constituent.add(c);
		}
		return constituent;
	}

// might need a hashmap later let's see 

}
