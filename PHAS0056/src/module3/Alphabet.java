package module3;
import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;

public class Alphabet {
	
	// build the string builder to collect my string
	static StringBuilder mystring = new StringBuilder();
	
	// declare the running total
	static int runningtotal;
	
	//set the initial exceptions to zero
	static int exceptions = 0;
	
	
	public static char randomCharacter() {
		// create a random number with the random class 
		Random random_number = new Random();
		// convert this random number to an integer between 0 and 128
		int number = (int) (random_number.nextInt(128));
		// convert this integer to a character
		char character = (char) number;
		// return the character
		return character;
			
	}

	public static void main(String[] args) throws Exception {
		// for loop that iterates 400 times
		for(int i=0;i<400; i++) {
			// create a random character
			char character = randomCharacter();
			// check if it is an integer or digit
			if (Character.isLetterOrDigit(character)) {
				// append it to my string if so
				mystring.append(character);
				
				// if it can be interpreted as a number, parse it as an integer
				// and add it to running total
				try  {
					int number = Integer.parseInt(Character.toString(character));
					runningtotal += number;
				}
				// if not, add the number of exceptions by 1
				catch (Exception e) {
					exceptions += 1;
				}
			}
		}
		
		//  print the results
		System.out.println("My string is");
		System.out.println(mystring);
			
		System.out.println("The sum of all the numbers is");
		System.out.println(runningtotal);
			
		System.out.println("The number of exceptions is");
		System.out.println(exceptions);


	}

}
