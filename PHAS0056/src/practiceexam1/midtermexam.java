package practiceexam1;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.*;

public class midtermexam {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GetData gd = new GetData();
			
		try  {
			
			ArrayList<Earthquake> eqArray = gd.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt");
			
			//print number of earthquakes
			System.out.println("number of earthquakes is" + eqArray.size());
			
			//earthquake with the largest magnitude 
			//double maxMag = Collections.max(eqArray, Comparator.comparingDouble(Earthquake::getMag)).getMag();
			double maxMag = Collections.max(eqArray, Comparator.comparingDouble(i -> i.getMag())).getMag();
			
			//print the earthquake with the maximum magnitude 
			System.out.println("maximum magnitude earthquake is " + maxMag);
			
			// for each print number of earthquakes measured 
			
			int count = 0;
			int month;
	
			// iterate 12 months 
			for (month =1; month <= 12; month++) {
				Earthquake deepest = null;
				Earthquake accurate = null;
	
				for (Earthquake e : eqArray) {
					if (e.getMonth() == month) {
						count+= 1;
						
						if(deepest == null || e.depth > deepest.depth) {
							deepest = e;
						}
						if( accurate == null || e.depth_error < accurate.depth_error) {
							accurate = e;
						}
						//deepest = Collections.max(eqArray, Comparator.comparingDouble(i -> i.depth));
					}
				}
				System.out.println("Number of earthquakes in month  " + month + " is " + count );
				System.out.println("Info for deepest earthquakes in month  " + month + " is " + deepest );
				System.out.println("Info for most accurate earthquakes in month  " + month + " is " + accurate+ "\n");

			
			}	
		}
		catch (IOException e) {
				
			System.out.println(e);
		}
		
		
		
		
	}
	

}
