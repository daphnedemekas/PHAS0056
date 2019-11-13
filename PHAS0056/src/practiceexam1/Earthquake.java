package practiceexam1;

import java.util.ArrayList;

import module5.DataPoint;

public class Earthquake {
	
	long id;
	double magnitude;
	double depth_error;
	double depth;
	
	Position lonLat;
	Time secondMinuteHour;
	Date dayMonthYear;
	
	public Earthquake(long id, double mag, double de, double depth, Position lonLat, Time secondMinuteHour, Date dayMonthYear) {
		this.id = id;
		this.magnitude = mag;
		this.depth_error = de;
		this.depth = depth;
		this.lonLat = lonLat;
		this.secondMinuteHour = secondMinuteHour;
		this.dayMonthYear = dayMonthYear;
	
	}
	public double getMag() {
		return magnitude;
	}
	public Date getDate() {
		return dayMonthYear;
	}
	
	public int getMonth() {
		return dayMonthYear.month;
	}
	
	public long getid() {
		return id;
	}
	
	public double getDepthError() {
		return depth_error;
	}
	
	public Position getPosition() {
		return lonLat;
	}
	
	public Time getTime() {
		return secondMinuteHour;
	}
	
	public String toString() {
		String components =  "id = " + id + "mag = " + getMag() + "depth error = " + getDepthError() + "depth = " + depth + "Position = "
				+ getPosition() + "Time = " + getTime() + "Date = " + getDate() ;
		return components;
	
	}
	
}
