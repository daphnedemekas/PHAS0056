package practiceexam3;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import practiceexam2.Player;

import java.awt.Desktop;

public class GetData3 {
	
	private File datafile;
	private FileReader fr;
	private BufferedReader b;
	int year;
	int month;
	String datatype;
	String region;
	double area;
	double extent;
	
	public GetData3() { };
	
	public ArrayList<Measurement> getData(String file) throws Exception {
		
		ArrayList<Measurement> data = new ArrayList<Measurement>();

		fr = new FileReader(file);
		b = new BufferedReader(fr);
		
		String line = "";
		
		b.readLine();
		
		while((line = b.readLine()) != null) {
			Scanner s = new Scanner(line);	
			String[] row = s.nextLine().split(",");
			year = Integer.parseInt(row[0]);
			month = Integer.parseInt(row[1]);
			if (((String) row[2]).equals("-9999")) {
				datatype = "no datatype";
			}
			else { datatype = (String) row[2];}
			
			region = (String) row[3];
			
			if (((String) row[4]).equals("-9999")) {
				// i set this to 101 so it will not affect our calculations
				extent = Double.parseDouble("101"); }
			
			else { extent = Double.parseDouble(row[4]);}

			if (((String) row[5]).equals("-9999")) {
				// i set this to 101 so that it will not affect our calculations. 
				area = Double.parseDouble("101"); }
			else { area = Double.parseDouble(row[5]);}
			
			Measurement m = new Measurement(year, month, datatype, region, extent, area);
			data.add(m);
		}
		return data;
	}
		
		
		//some data is missing: fields where the data has not been recorded are marked with
		//the number “-9999”. Your code should be able to handle this missing data and not take it into
		//your calculations. Also note that some years do not contain data for every single month: you
		//should also be able to handle this when processing the data and making the necessary
		//calculations.

	//	}
		
	}
	
