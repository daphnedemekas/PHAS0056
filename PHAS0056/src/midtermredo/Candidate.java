package midtermredo;

public class Candidate {
	
	String ons;
	int pano;
	String constituency;
	String surname;
	String firstname;
	String party;
	String identifier;
	int votes;

	public Candidate(String ons, int pano, String constituency, String surname, String firstname, String party,
			String identifier, int votes) {
		this.ons = ons;
		this.pano = pano;
		this.constituency = constituency;
		this.surname = surname;
		this.firstname = firstname;
		this.party = party;
		this.identifier = identifier;
		this.votes = votes;
	}
	
	public String toString() {
		return firstname + " " + surname + " , ONS: " +ons + " pano " + pano + " constituency " + constituency + " party " + party + " identifier " + identifier + " votes " + votes;
	}

}
