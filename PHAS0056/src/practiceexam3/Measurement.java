package practiceexam3;

public class Measurement {
	
	int year;
	int month;
	String data_type;
	String region;
	double extent;
	double area;
	
	public Measurement(int year, int month, String data_type, String region, double extent, double area) {
		this.year = year;
		this.month = month;
		this.data_type = data_type;
		this.extent = extent;
		this.area = area;
	}
	
	public double getArea() {
		return area;
	}
	public double getExtent() {
		return extent;
	}
	
	public String toString() {
		return "Year: " + year + " Month: " + month + " Data type: " + data_type + " Region:  " +  region + " Ice Extent: " + extent + " Ice Area: " + area;
		
	}
}

