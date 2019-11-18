package module6;
import module6.DataPoint;

public class LabelledDataPoint extends DataPoint {
	// this is a subclass of data point for those data points that contain labels in the URL 
	
	protected String label;

	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.label = label;
	}
	
	public String toString() {
		return label + " x = " + x + " y = " +y + " +- "  + ey;
	}

}

