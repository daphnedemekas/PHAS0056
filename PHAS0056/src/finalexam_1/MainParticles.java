package finalexam_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MainParticles {

	public static void main(String[] args) {
		
		getParticleData gpd = new getParticleData();
		ArrivalTime_method2 arrivaltime2 = new ArrivalTime_method2();
		ArrivalTimeComparison atc = new ArrivalTimeComparison();

		try {
			ArrayList<Signal> signalData = gpd.getSignalData("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt");
			HashMap<String, Double> distances = gpd.getDetectorData("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/detectors.txt");

			
			System.out.println("The total number of pulses is " + signalData.size());
			
			// want mean amplitude of pulses
			// amplitude = maximum voltage 
			
			
			double masterSum = 0;
			
			for (String id: distances.keySet()) {
				double amplitudeSum = 0;
				double signalSum = 0;
				double arrivaltime = 0;
				double arrT2 = 0;
				int numSignals = 0;
				
				for (Signal s: signalData) {
					if (id.equals(s.identifier)) {
						ArrayList<Double> volts = s.voltages;
						numSignals += 1;
						double amplitude = Collections.max(volts);
						// so the arrival time is the index of this maximum in volts 
						
						// i have identifier: voltages 
						arrivaltime += volts.indexOf(amplitude); // this occurs the index of the first occurence as required
						// i want for each detector (index, index, index) 
						amplitudeSum += amplitude;
						masterSum += amplitude;
						signalSum += 1;
						
						arrT2 += arrivaltime2.arrivaltime(s);
					}
				}
				
				double average = amplitudeSum / signalSum;
				double meanArrivalTime = arrivaltime / signalSum;
				double speed = distances.get(id) / meanArrivalTime;
								
				System.out.println("The detector " + id + " has " + numSignals + " signals, a mean amplitude of " + average + "\n" + " , a mean arrival time of " + meanArrivalTime + " nanoseconds, and a speed of " + speed);
				
				double speed2 = distances.get(id) / (arrT2 / signalSum);
				
				System.out.println("and finally, the speed calculated using the second arrival time method is" + speed2 + "\n");
			
			}
			
			double meanAmp = masterSum / signalData.size();
			
			System.out.println("The mean amplitude of pulses is " + meanAmp + "\n");
			
			
			System.out.println("The detector with the maximum difference in arrival times by methods is " + atc.compareArrivalTime(signalData));
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		

	}

}
