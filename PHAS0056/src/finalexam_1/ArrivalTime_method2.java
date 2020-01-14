package finalexam_1;

import java.util.ArrayList;

public class ArrivalTime_method2 implements ArrivalTime {

	double threshold = 1;
	double arrivaltime;
	
	public double arrivaltime(Signal signal) {
		ArrayList<Double> voltages = signal.voltages;
		for (double v: voltages) {
			if (v > threshold) {
				arrivaltime = voltages.indexOf(v);
				break;
			}
		}
		return arrivaltime;
	}

}
