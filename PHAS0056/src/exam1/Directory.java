package exam1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Directory {
	
	public static String getDirectory() throws IOException  { 
	
		System.out.println("Please type the directory in which the datafile is stored. ");
		InputStreamReader r = new InputStreamReader(System.in);
		//wrap the input in a buffer
		BufferedReader b = new BufferedReader(r);	
		// read the data as a string
		String s = b.readLine();
		return s;
		
	}


}
