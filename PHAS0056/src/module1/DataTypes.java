package module1;

public class DataTypes {
		
	public static void main(String[] args) {		
		
		double doubVar = 5.0;
		System.out.println(doubVar);
		
		float floatVar = 5;
		System.out.println(floatVar);
		
		int intVar = 5;
		System.out.println(intVar);
		
		long longVar = 5;
		System.out.println(longVar);
		
		byte byteVar = 5;
		System.out.println(byteVar);
		
		// multiply each of these values by itself and print the result
		
		System.out.println(doubVar*doubVar);
		System.out.println(floatVar*floatVar);	
		System.out.println(intVar*intVar);
		System.out.println(longVar*longVar);	
		System.out.println(byteVar*byteVar);
		
		// what happens when we mix types
		
		System.out.println(floatVar + intVar);
		
		System.out.println(floatVar + "a");
		
		System.out.println(longVar + doubVar);
		
		// not initialized

		int i;
		int j = 3;
		//System.out.println(j+i);
		// cannot use this if not initialized
		
		System.out.println(j+1);
		
		// double to int cast 
		double doubVar2 = 4.99;					
		int x = (int) doubVar2;		
		System.out.println(x);
		// weird how it rounds down 
		
		
		
		
	}
}

