package module4;

import java.io.*;
import java.io.File;

//The input for your second program will be a text file that contains a list of real numbers. 
//The format is such that there may be zero, one or more values per line. 
//If a line starts with a letter it is to be interpreted as a comment. 
//Your program should ignore such lines, as we are only interested in the numbers.
import java.net.URL;

public class NumericalReader {
	
	//here we declare our member variables
	private int minValue;
	private int maxValue;
	private long nValues;
	private int sumOfValues;
	private String saveFile;
	// this is my file, filewriter, bufferedwriter and printwriter
	private File myfile;
	private FileWriter fw;
	private BufferedWriter b;
	private PrintWriter writer;
	
	public static void main(String[] args) {
		//create Strings to make datafile from 
		String dataFile = ("numbers1.txt");
		String dataFile2 = ("numbers2.txt");
		String saveFile;
		String saveFile2;

		// try to make the datafile from the get directory from keyboard function
		try { 
			String directory = NumericalReader.getStringfromKeyboard();
			saveFile = (directory +  File.pathSeparator + dataFile);
			saveFile2 = (directory + File.pathSeparator + dataFile2);
		}
		//if it doesn't work, set directory to user.home
		catch (Exception e) {
			String directory = System.getProperty("user.home");
			saveFile = (directory +  File.pathSeparator + dataFile);
			saveFile2 = (directory + File.pathSeparator + dataFile2);
			System.out.println("input output exception for keyboard, redirected home");
		}
		// make the 2 objects for both files
		NumericalReader nr = new NumericalReader();
		NumericalReader nr2 = new NumericalReader();

		
		try {
			//try to start the analysis for the file
			nr.analysisStart(saveFile);
			// now try to read the file
			BufferedReader reader = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");

			String line = "";
			//now analyse the file
			while ((line = reader.readLine()) != null) {
			    nr.analyseData(line); // analyze lines, check for comments etc.
			  }
			  nr.analysisEnd(); // print min, max, etc.
			  
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// this does the exact same thing as above but opens numbers2.txt and uses a different link
		try {
			//try to start the analysis for the files
			nr2.analysisStart(saveFile2);
			// now try to read the files
			BufferedReader reader2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");

			String line = "";
			  
			while ((line = reader2.readLine()) != null) {
				    nr2.analyseData(line); // analyze lines, check for comments etc.
				  }
			nr2.analysisEnd(); // print min, max, etc.
		}
		catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	//method which prompts the user to enter a string via the keyboard and returns the string
	public static String getStringfromKeyboard() throws IOException {
		// prompts the user to type
		System.out.println("Type something!");
		//use the System.in to collect string from keyboard
		InputStreamReader r = new InputStreamReader(System.in);
		//wrap the input in a buffer
		BufferedReader b = new BufferedReader(r);	
		// read the data as a string
		String s = b.readLine();
		//return the string
		return s;
	}
	
	
	// non static version of the buffered reader
	public BufferedReader brFromURL(String urlName) throws IOException {
		// first check if the string is a valid url
		URL u = new URL(urlName);
		// create an input stream
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);
		//return the buffered reader object
		return b;
	}
	
	// make this method private to initialise private variables
	void analysisStart(String dF) throws IOException{
		//initialize myFile, filewriter and printwriter for the file being analysed  
		saveFile = dF;
		myfile = new File(saveFile);
		// this creates the file^
		fw = new FileWriter(myfile);
		b = new BufferedWriter(fw);
		writer = new PrintWriter(b);
		
		//check if the file was created
		try { 
			if (myfile.createNewFile()  ) {
            System.out.println(dF+" File Created");
		}
		}
		catch (Exception e) {
			System.out.println("no new file");
		}
		//initialize private variables
		minValue = 100000;
		// minimum value
		maxValue = 0;
		//maximum value
		nValues = myfile.length();
		// number of values
		sumOfValues = 0;
		// sum of values
		
	}
	
	//a  method for each line 
	void analyseData(String line) throws IOException {
		// check the first character of the line
		// if the first character of the line is a letter, skip the line
		if ( line.isEmpty() || Character.isLetter(line.charAt(0)) ) {
			;
		}
		else {		
		// iterate through the characters and take out the digits 
		for (char ch: line.toCharArray()) { 
			if (Character.isDigit(ch) ) {

				// if a digit, then turn the character into an integer
				int num = Character.getNumericValue(ch);
				// update for maximum value
				if (num > maxValue) {
					maxValue = num;
				}
				
				//update for minimum value
				if (num < minValue) {
					minValue = num;
				}
				
				//turn the character into an int for the sum
				//sum the values
		    	sumOfValues += num;

		    	nValues += 1;
				// print the digits to the screen
				System.out.println(num);
				// print the digits to the file
				
				writer.println(num);
				
			}
		}
		}
		}

		// for lines containing numbers write them to a screen and to a fil
	// create a method that prints the required values
	void analysisEnd() {
		System.out.println("The minimum value is");
		System.out.println(minValue);
		
		System.out.println("The maximum value is");
		System.out.println(maxValue);
		
		System.out.println("The number of values value is");
		System.out.println(nValues);
		
		System.out.println("The sum of values is");
		System.out.println(sumOfValues);
		writer.close();
		// close the file

	}


}
