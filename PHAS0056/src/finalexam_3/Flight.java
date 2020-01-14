package finalexam_3;

public class Flight {
	String flightcode;
	String origincode;
	String destinationcode;
	String departuredate;
	String departuretime;
	String arrivaldate;
	String arrivaltime;
	Double cost;
	
	public Flight(String flightcode, String origincode, String destinationcode, String departuredate, String departuretime, String arrivaldate, String arrivaltime, Double cost) {
		this.flightcode = flightcode;
		this.origincode = origincode;
		this.destinationcode = destinationcode;
		this.departuredate = departuredate;
		this.departuretime = departuretime;
		this.arrivaldate = arrivaldate;
		this.arrivaltime = arrivaltime;
		this.cost = cost;
	}
	
	public String toString() {
		return "flight code: " + this.flightcode + ", origincode: " + this.origincode + ", destination code:" + this.destinationcode + "\n"
				+ " departure date: " + this.departuredate + ", departuretime: " + this.departuretime + ", arrivaldate: " + this.arrivaldate + ", arrivaltime: " + this.arrivaltime + "\n" +
				"cost: " + this.cost + "\n";
	}
}
