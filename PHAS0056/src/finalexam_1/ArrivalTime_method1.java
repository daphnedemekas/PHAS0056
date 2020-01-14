package finalexam_1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrivalTime_method1 implements ArrivalTime{

	public double arrivaltime(Signal signal) {
		
		ArrayList<Double> voltages = signal.voltages;
		
		double amplitude = Collections.max(voltages);
		
		double arrivalTime = voltages.indexOf(amplitude);
		
		return arrivalTime;
	}
}
