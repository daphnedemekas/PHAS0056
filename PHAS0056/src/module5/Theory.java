package module5;
public class Theory {
// class representing the function y=x^n that can be compared to some data in the form of DataPoint objects
double n;

public Theory(double n) {
	this.n =n;
}
public double y(double x) {
	return Math.pow(x, n);
}
}