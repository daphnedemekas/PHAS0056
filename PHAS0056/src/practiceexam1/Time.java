package practiceexam1;

public class Time {
	
	double second;
	int hour; 
	int minute;
	
	public Time(double second, int hour, int minute) {
		this.second = second;
		this.hour = hour;
		this.minute = minute;
	}
	
	public String toString() {
		String components =  "second = " + second + ", hour = " +hour + "minute = " + minute ;
		return components;
	}

}
