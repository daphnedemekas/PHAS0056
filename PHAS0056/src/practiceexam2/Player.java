package practiceexam2;

public class Player {
	
	String name;
	String team;
	String position;
	int games;
	int atbats;
	int runs;
	int hits;
	int doubles;
	int triples;
	int homeruns;
	int runs_batted;
	double batting_avg;
	double obp;
	
	
	public Player(String name, String team, String position, int games, int atbats, int runs, int hits, int doubles, int triples, int homeruns, int runs_batted, double batting_avg, double obp) {
		this.name = name;
		this.team = team;
		this.position = position;
		this.games = games;
		this.atbats = atbats;
		this.hits = hits;
		this.doubles = doubles;
		this.triples = triples;
		this.homeruns = homeruns;
		this.runs_batted = runs_batted;
		this.batting_avg = batting_avg;
		this.obp = obp;
	}
	
	public String toString() {
		String components =  "name = " + name + ", team = " + team + ", position = " + position + ", games = " + games + ", atbats = "
				+ atbats + ", hits =  " + hits + ", doubles " + doubles + ", triples = " + triples +
				", homeruns " + homeruns + ", runs_batted " + runs_batted + ", batting average " + batting_avg + ", obp = " +obp; 
		return components;
	}
	
	public int getHomeRuns() {
		return homeruns;
	}
	
	public String getTeam() {
		return team;
	}
}
