package exam1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import practiceexam1.Time;

import java.util.*;

import practiceexam3.Measurement;

public class GetCandidateData {
	// this class will get the data in the 'results' file

	private File resultsfile;
	// this is the file that contains the results
	private FileReader fr;
	private BufferedReader b;
	String ons;
	int pano;
	String constituency;
	String surname;
	String firstname;
	String party;
	String identifier;
	int votes;
	ArrayList<Candidate> candidate;

	public GetCandidateData() {
	};

	// the following function will return an array of objects containing all of the
	// values for each candidate
	public ArrayList<Candidate> getArrayList(String file) throws Exception {

		candidate = new ArrayList<Candidate>();

		fr = new FileReader(file);
		b = new BufferedReader(fr);

		String line = "";

		b.readLine();

		while ((line = b.readLine()) != null) {
			Scanner s = new Scanner(line);
			String[] row = s.nextLine().split(",");
			ons = (String) row[0];
			pano = Integer.parseInt(row[1]);
			constituency = (String) row[2];
			surname = (String) row[3];
			firstname = (String) row[4];
			party = (String) row[5];
			identifier = (String) row[6];
			votes = Integer.parseInt(row[7]);

			Candidate c = new Candidate(ons, pano, constituency, surname, firstname, party, identifier, votes);
			candidate.add(c);
		}
		return candidate;
	}

	// the following function creates a hashmap of (names, candidate) and returns it
	public HashMap<Integer, Candidate> getMap(String file) throws Exception {

		HashMap<Integer, Candidate> Map = new HashMap<Integer, Candidate>();

		for (Candidate c : candidate) {
			Map.put(c.votes, c);
		}
		return Map;

	}

}
