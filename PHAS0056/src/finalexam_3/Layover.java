package finalexam_3;

public class Layover {
	
	Flight flight1;
	Flight flight2;
	Double cost;
	
	public Layover(Flight flight1, Flight flight2, Double cost) {
		this.flight1 = flight1;
		this.flight2 = flight2;
		this.cost = cost;
	}
	
	public String toString() {
		return "first flight: " + "\n" + flight1 + " second flight: " + "\n" + flight2 + "\n" + "total cost" + cost;
	}
}


