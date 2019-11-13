package exam1;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.awt.Point;

import practiceexam3.GetData3;
import practiceexam3.Measurement;

public class MidTermExam {

	public static void main(String[] args) {

		GetCandidateData gc = new GetCandidateData();
		GetConsData gd = new GetConsData();
		String datafileR = "results.csv";
		String datafileC = "constituencies.csv";
		String directory;
		String resultfile;
		String consfile;

		// our data is saved on a file which must be accessible from any directory
		// thus we will first ask for the input of the directory in which the file is
		// stored from the user
		try {
			directory = Directory.getDirectory();
			// here I didn't use the file path separator but rather inputted my exact path
			// on request (/Users/daphnedemekas/Downloads)
			// this is because the file path separator wasn't working for me, hope that's
			// ok!
			resultfile = (String) directory + datafileR;
			consfile = (String) directory + datafileC;
			System.out.println(consfile);
			System.out.println(resultfile);

			// get the data from the file

		}
		// if the input does not work, we instead redirect to the home directory
		catch (Exception e) {
			directory = System.getProperty("user.home");
			resultfile = (String) directory + datafileR;
			consfile = (String) directory + datafileC;
			// get the data from the file
		}

		// ============================================================

		// now we will create our arrays and hashmaps for our data analysis

		try {
			// first we will get our arraylist of candidates

			ArrayList<Candidate> Candidate = gc.getArrayList(resultfile);

			System.out.println("The total number of candidates is: " + Candidate.size() + "\n");

			// HashMap<String, Candidate> CandidateMap = gc.getMap(resultfile);

			ArrayList<Const> Constituent = gd.getArrayList(consfile);

			// Print the turnout in the election (defined as valid votes (sum of votes
			// casted) divided by number of registered voters (sum of electorate).

			// first we want to sum the votes casted
			int votes_casted = 0;
			for (Candidate cand : Candidate) {
				votes_casted += cand.votes;
			}

			// then we want to sum the registered voters
			int registered_voters = 0;
			for (Const co : Constituent) {
				registered_voters += co.electorate;
			}
			// had to convert to long and double in order to get good answers
			long r = (long) registered_voters;
			long v = (long) votes_casted;
			double turnout = (double) r / v;

			// print out the turnout
			System.out.println("The turnout in the election is " + (turnout));

			// now i'm going to make a hashmap (candidate, (votes, electorate)) so that i
			// can calculate for how many did not secure
			// valid votes versus the electorate for the corresponding constituency

			HashMap<Candidate, Point> CandMap = new HashMap<Candidate, Point>();

			for (Candidate c : Candidate) {
				for (Const co : Constituent) {
					if (c.constituency.equalsIgnoreCase(co.con)) {
						// then our candidate is in the given constituency
						Point p = new Point(c.votes, co.electorate);
						CandMap.put(c, p);

					}
				}
			}
			int lost_votes = 0;
			for (Candidate c : CandMap.keySet()) {
				// now we are iterating through the candidates
				double x = (double) CandMap.get(c).x;
				double y = (double) CandMap.get(c).y;
				double ratio = x / y;
				// here we have calulated the ratio for each candidate
				if (ratio < 0.05) {
					lost_votes += 1;
				}
			}
			System.out.println(lost_votes + " candidates lost their deposit");

			// name of the candidate who got the most votes is just
			Candidate name = Collections.max(Candidate, Comparator.comparingInt(i -> i.getVotes()));
			System.out.println("The most voted for candidate is " + name);

			// now need the candidate with the most number of votes in their constituent but
			// smaller number of votes overall

			// need votes, constituent

			ArrayList<String> unique_cons = new ArrayList<String>();
			ArrayList<Integer> vote_values = new ArrayList<Integer>();
			HashMap<ArrayList<Integer>, String> cons_votes = new HashMap<ArrayList<Integer>, String>();

			// list of unique constituencies
			for (Candidate c : Candidate) {
				String l = c.constituency;
				if (!unique_cons.contains(l)) {
					unique_cons.add(l);
				}
			}
			// find the candidate in who has the most votes in thier constituency but the
			// least votes overall winners
			Candidate mp = null;
			int min = 1000000;
			// just a very big number
			for (Candidate c : Candidate) {
				int max = 0;
				for (String l : unique_cons) {
					// iterate through the constituencies
					if (l.equals(c.constituency)) {
						// if we are in the constituency check if we are bigger than our min
						vote_values.add(c.votes);

						if (c.votes > max) {
							// if so update our min
							max = c.votes;
							// repeat for every constituency

						}
					}
					cons_votes.put(vote_values, l);
					// this has (the votes, the constituency)

				}
				// now check if we are smaller than our overall number
				if (max < min) {
					// if so update
					min = max;
					mp = c;
				}

			}
			System.out.println("The candidate who gained the most votes but did not become an MP is" + mp);

			// gained the most votes but did not become an MP
			// so the maximum among those who are second place

			ArrayList<Integer> nums = new ArrayList<Integer>();
			// an array of votes for each constituent
			for (Entry<ArrayList<Integer>, String> mapElement : cons_votes.entrySet()) {
				ArrayList<Integer> key = mapElement.getKey();
				Collections.sort(key);
				Collections.reverse(key);
				nums.add(key.get(1)); // the second biggest element
			}
			Integer max = Collections.max(nums);
			// this is the maximum number of votes

			// i need the candidate who got hta tnumber of votes
			for (Candidate c : Candidate) {
				if (c.votes == max) {
					System.out.println("The second best candidate is" + c);

				}

			}
			// each of the 5 constituents with lowest overall turnout
// ten closest (number of votes cast for winner - for second place candidate

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}
}
