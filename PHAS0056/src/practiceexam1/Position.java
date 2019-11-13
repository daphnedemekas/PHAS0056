package practiceexam1;

public class Position {
	
	double lon;
	double lat;
	
	public Position(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}
	public String toString() {
		String components =  "longitude = " + lon + ", latitutde = " +lat ;
		return components;
	}
}
