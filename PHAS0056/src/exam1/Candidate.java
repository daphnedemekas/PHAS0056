package exam1;

public class Candidate {
	// this class is for the candidate, containing all of its member variables

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

	public int getVotes() {
		return votes;
	}

	public String toString() {
		String components = "ONS = " + ons + "pano = " + pano + "constituency= " + constituency + "firstname = "
				+ firstname + "surname = " + surname + "party = " + party + "Identifier = " + identifier + "Votes = "
				+ votes;
		return components;

	}
}
