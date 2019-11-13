package practiceexam3;

public class Measurement {
	
	int year;
	int month;
	String datatype;
	String region;
	Double extent;
	Double area;
	
	
	public Measurement(int year, int month, String datatype, String region, double extent, double area) {
		this.year = year;
		this.month = month;
		this.datatype = datatype;
		this.region = region;
		this.extent = extent;
		this.area = area;
	}
	
	public String toString() {
		String components =  "year = " + year + ", month = " + month + ", datatype = " + datatype + ", region = " + region + ", extent = "
				+ extent + ", area =  " + area ; 
		return components;
	}

}
