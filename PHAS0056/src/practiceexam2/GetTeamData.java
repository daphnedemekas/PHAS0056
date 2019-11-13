	package practiceexam2;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.*;

	import practiceexam1.Earthquake;

public class GetTeamData {

	public GetTeamData() {}

		public  void test(String url) throws IOException {
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
			
			while (scanner.hasNext()) {
				// create a list out of the 2 row entries
				String[] row = scanner.nextLine().split("\t");
				System.out.println((String) row[3]);
			}
		}
		
		public ArrayList<Player> dataFromURL(String url) throws IOException {
			ArrayList<Player> data = new ArrayList<Player>();
			// first check if the string is a valid url
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
			
			String line = "";
			while (scanner.hasNext()) {
				// create a list out of the 2 row entries
				String[] row = scanner.nextLine().split("\t");
				String name = (String) row[0];
				String team = (String) row[1];
				String position = (String) row[2];
				int games = Integer.parseInt(row[3]);
				int ab = Integer.parseInt(row[4]);
				int runs = Integer.parseInt(row[5]);
				int hits = Integer.parseInt(row[6]);
				int doubles = Integer.parseInt(row[7]);
				int triples = Integer.parseInt(row[8]);
				int homeruns = Integer.parseInt(row[9]);
				int rbi = Integer.parseInt(row[10]);
				double batting_avg = Double.parseDouble(row[11]);
				double obp = Double.parseDouble(row[12]);	
				
				Player p = new Player(name, team, position, games, ab, runs, hits, doubles, triples, homeruns, rbi, batting_avg, obp);
				data.add(p);
				}
			return data;
		}
		
	}


