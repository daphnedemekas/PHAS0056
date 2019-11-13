package practiceexam2;
import java.io.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.*;
import practiceexam1.GetData;

public class midtermexam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	GetTeamData gd = new GetTeamData();
	
	try {
		ArrayList<Player> data = gd.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt");
		System.out.println("Number of Players is " + data.size());
		
		Player maxhomerun = Collections.max(data, Comparator.comparingInt(i -> i.getHomeRuns()));
		System.out.println("Details for player with max home runs is");
		System.out.println(maxhomerun);
		
		ArrayList<String> teams = new ArrayList<String>();
		for (Player p : data) {
			if (!teams.contains(p.team)) {
				teams.add(p.team);
			}			
		}
		System.out.println(teams);
		
		for (String t : teams) {
			int count =0;
			double slug = 0;
			double Obsp = 0;
			String bestplayer = "";
			String bestplayer2 = "";

			// iterate through teams
			for (Player p : data) {
				
				// iterate through players
				if ((p.team).equals(t)) {
				// if my player is on my team
					ArrayList<Player> bestplayers = new ArrayList<Player>();
					
					if(p.atbats >= 10) {
						count += 1;
						bestplayers.add(p);
					}
					for (Player player : bestplayers) {
						double SLG = (double) ((p.hits + (2*p.doubles)+ (3*p.triples) )) / p.atbats;
						double obsp = SLG + p.obp;
						if (SLG > slug) {
							slug = SLG;
							bestplayer = p.name;
						}
						if (obsp > Obsp) {
							obsp = Obsp;
							bestplayer2 = p.name;
						}
					}
					
				}
		
			}
		System.out.println("For the team " +t +" : ");
		System.out.println("The number of players with at least 10 at-bats is" + count);
		System.out.println("The best player 1 is" + bestplayer);
		System.out.println("The best player 2 is" + bestplayer2 + "\n");
	}
	}
	
	
	catch (IOException e) {
		System.out.println(e);
		
		
		}
	catch (NullPointerException e) {
		System.out.println(e);
	}

	}
}
