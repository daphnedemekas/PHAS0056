package midtermredo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class Main {

	public static void main(String[] args) {

		// total number of candidates
		// do arraylist of candidates and print length 
		GetDataPolitics gdp = new GetDataPolitics();
	try {
		ArrayList<Candidate> candidate = gdp.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/results.csv");
		System.out.println("the number of candidates is " + candidate.size());
		
		
		// we need the turnout (valid votes divided by number of registered voters)
		
		// so valid votes is a column in candidate, and registered voters is a candidate in electorate
		// if we do arraylists
		ArrayList<Electorate> electorate = gdp.electorateData("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/constituencies.csv");
		
		double total_votes = 0;
		for (Candidate c : candidate) {
			total_votes += c.votes;
		}
		double total_voters = 0;
		for (Electorate e: electorate) {
			total_voters += e.electorate;
		}
		double t = total_votes / total_voters; 
		System.out.println("The turnout is " + t);
		
		// determine the number of candidates who lost thier deposit (did not secure 5% of valid votes cast)
		
		
		// valid votes for candidate / valid votes for constituency < 0.05
		
		
		
		HashMap<Electorate, ArrayList<Integer>> const_allvotes = new HashMap<Electorate, ArrayList<Integer>>();
		
		HashMap<Electorate, Integer> const_votes = new HashMap<Electorate, Integer>();
		
		HashMap<Electorate, ArrayList<Candidate>> const_cand = new HashMap<Electorate, ArrayList<Candidate>>();

		//HashMap<Integer, Integer> candidatevotes_constvotes = new HashMap<Integer, Integer>();
		
		ArrayList<Integer> votes_e = new ArrayList<Integer>();
		
		ArrayList<Integer> votes = new ArrayList<Integer>();
				
		for (Electorate e: electorate) {
			ArrayList<Candidate> candidatesine = new ArrayList<Candidate>();
			int votes_in_electorate = 0;
			for (Candidate c: candidate) {
				if (c.ons.equals(e.id)) {
					votes_e.add(c.votes);
					votes_in_electorate += c.votes;
					candidatesine.add(c);
				}
			}
			const_cand.put(e, candidatesine);
			
			// the actual votes in electorate in an arraylist
			const_allvotes.put(e, votes_e);
			
			// number of votes in electorate
			const_votes.put(e , votes_in_electorate);
		}
		
		for (Candidate c: candidate) {
			votes.add(c.votes);
		}
		Integer most_votes = Collections.max(votes);
		Candidate best_candidate = null; 

		// now we have (electorate) (arraylist of votes)

		int lost_deposit = 0;
		for (Candidate c: candidate) {
			if (((Integer) c.votes).equals(most_votes)) {
				best_candidate = c;
			}
			for (Electorate e: const_votes.keySet())  {
				if (c.ons.equals(e.id)) {
					// c.votes is the number of votes that candidate c has 
					// const_votes.get(e) is the number of votes 
					double ratio = (double) c.votes / const_votes.get(e);
					if (ratio < 0.05) {
						lost_deposit += 1;
					}
				}
			}
		}
		System.out.println("The number of candidates who lost their deposit is " + lost_deposit);
		
		// gained the most votes 
		System.out.println("The candidate who got the most votes is " + best_candidate);
		
		// have (constituency, candidate) 
		// want (max number of votes in each constituency, candidate)
		
		int minofmax = 1000000;
		int maxofloser = 0;
		for (Electorate e: const_allvotes.keySet()) {
			int max_votes = Collections.max(const_allvotes.get(e));
			if (max_votes < minofmax) {
				minofmax = max_votes;
			}
			ArrayList<Integer> v = const_allvotes.get(e);
			v.remove((Integer) max_votes);
			int second_max = Collections.max(const_allvotes.get(e));
			if (second_max > maxofloser) {
				maxofloser = second_max;
			}
		}
		

		for (Candidate c: candidate) {
			if (c.votes == minofmax) {
				System.out.println("The lowest winnimg MP is " + c);
			}
			if (c.votes == maxofloser) {
				System.out.println("The best loser is " +c);
			}
			
		}
		
		HashMap<Electorate, Double> const_turnout = new HashMap<Electorate, Double>();
		ArrayList<Double> turnouts = new ArrayList<Double>();
		// by electorate not candidate 
		// so you have total votes 
		for (Electorate e: const_votes.keySet()) {
			double turnout = (double) const_votes.get(e) / e.electorate;
			const_turnout.put(e, turnout);
			turnouts.add(turnout);
		}
		Electorate el = null;
		int i;
		for (i = 1; i<=5; i++ ) {
			System.out.println("For the " + i + "th constituency with lowest overall turnout");
			double min_turnout = Collections.min(turnouts);
			for (Entry<Electorate, Double> element : const_turnout.entrySet()) {
				double t1 = element.getValue();
				if (t1 == min_turnout) {
					el = (Electorate) element.getKey();
				}
			}
			System.out.println("The constituency is" + el);
			ArrayList<Candidate> candidates = const_cand.get(el);
			System.out.println( " The candidates with their share of votes cast are ");
			for (Candidate c: candidates) {
				System.out.println(c);
				System.out.println(c.votes);	
			}
			int registered = el.electorate;
			int valid = const_votes.get(el);
			double percentage = (double) (registered - valid) / registered;
			System.out.println("The percentage that did not vote is " + percentage);
			turnouts.remove((Double) min_turnout);
		}
		
		int j;
		for (j = 0; i<5; j++ ) {
			System.out.println("For the " + i + "th constituency with highest overall turnout");
			double max_turnout = Collections.max(turnouts);
			for (Map.Entry element : const_turnout.entrySet()) {
				if (element.equals(max_turnout)) {
					el = (Electorate) element.getKey();
				}
			}
			System.out.println("The constituency is" + el);
			ArrayList<Candidate> candidates = const_cand.get(el);
			System.out.println( " The candidates with their share of votes cast are ");
			for (Candidate c: candidates) {
				System.out.println(c);
				System.out.println(c.votes);	
			}
			int registered = el.electorate;
			int valid = const_votes.get(el);
			double percentage = (registered - valid) / registered;
			System.out.println("The percentage that did not vote is " + percentage);
			turnouts.remove(max_turnout);
		}
		int winner = 0;
		int second = 0;
		ArrayList<Integer> rates = new ArrayList<Integer>();
		HashMap<Integer, Electorate> constrates = new HashMap<Integer, Electorate>();
		for (Electorate e: const_allvotes.keySet()) {
			ArrayList<Integer> c = const_allvotes.get(e);
			winner = Collections.max(c);
			c.remove(winner);
			second = Collections.max(c);
			int rate = winner - second;
			rates.add(rate);
		}
		
		int k;
		for (k=0; k<10;k++) {
			int smallestrate = Collections.min(rates);
			Electorate elect = constrates.get(smallestrate);
			System.out.println("For the " + k + "th constituency rate the name of the constituency is" + elect.con);
			System.out.println("The country is" + elect.country);
			for (Candidate c: candidate) {
				if (c.votes == winner) {
					System.out.println("The winning candidate is" + c.firstname + c.surname + " with " + c.votes + " votes");
				} 
				if (c.votes == second) {
					System.out.println("The second place candidate is" + c.firstname + c.surname + " with " + c.votes + " votes");
				} 
			}
			
		}
		// ten closest constituency races
		// smallest difference between the number of votes cast for the winner 
		// and the second placed candidate 
		// have to calculate the difference between all constituencies 
		// make an array list differences 
		
		
		
		
		
		
		
		
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
