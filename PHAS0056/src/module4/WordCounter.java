package module4;
import java.io.*;
import java.net.*;

public class WordCounter {
	
	// takes the name of the url as argument and returns a buffered reader object
	public static BufferedReader brFromURL(String urlName) 
	// needs to throw an input output exception in order to work
	throws IOException {
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
	
	
	//takes the name of a file on the disk as argument and returns a buffered reader object
	public static BufferedReader brFromFile(String fileName) 
	// again, need to throw an input output exception
	throws IOException {
		// read the file with a file reader
		FileReader fr = new FileReader(fileName);
		// wrap it in a buffer
		BufferedReader br = new BufferedReader(fr);
		// return the buffer
		return br;
	}
	
	//reads through the data contained in bufferedreader object and returns the number of words 
	// throw input output exception
	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
		// initialize a counter string called line
		String line;
		// set the word counter to 0
		int countWord = 0;
		// read the file line by line
		while((line = dataAsBR.readLine()) != null) {
			// create an array of words split by a whitespace delimiter
			String[] wordList = line.split("\\s+"); 
			
			//commented out code used to test whether its working
	        //for (String a : wordList) 
	        //    System.out.println(a); 
			
			//add the number of words in the line to countWord
			countWord += wordList.length; 
		}
		// return the number of words in the file
		return countWord;
	}

	
	public static void main(String[] args) { 
		// for a url : read with a buffered reader, take into account IO exception
		System.out.println("The number of words in the URL is: ");
		
		try{
			BufferedReader fromURL =  brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			System.out.println(countWordsInResource(fromURL));
		}
		catch (Exception e) {
			System.out.println("Input Output failure for url");
		
		}
		
		
		// for a file: read with a buffered reader, take into account IO exception
		
		//System.out.println("The number of words in the file is: ");
		//try {
		//	BufferedReader fromFile = brFromFile("fileName");
		//	System.out.println(countWordsInResource(fromFile));

		//}
		//catch (Exception e) {
		//	System.out.println("Input output failure for file");
		//}
		
		
		
		
	}

}
