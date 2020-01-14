package finalexam_4;

public class Image {
	
	int id;
	double latitude;
	double longitude;
	
	public Image(int id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String toString() {
		return " the latitude is " + this.latitude + " and the longitude is " + this.longitude;
	}

}
