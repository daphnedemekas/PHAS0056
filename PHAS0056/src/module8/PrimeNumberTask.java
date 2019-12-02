package module8;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeNumberTask implements Runnable {

	// initialise varibles in which we want to store our primes and our counter
	static ArrayList<Integer> primes;
	static int i;

	PrimeNumberTask() {};

	// this method checks if a number is prime
	// by checking if it has a remainder when divided by any number between 2 and one less than itself.
	boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public void run() {
		// go through all the integers and check if they are prime
		primes = new ArrayList<Integer>();
		i = 0;
		// i is the index that we will increase by one, check if it is prime with the above method, and if so
		// append it to our array list 'primes'
		while (true) {
			i++;
			if (isPrime(i) == true) {
				primes.add(i);
			}
			// then we will 'return' if our thread is interrupted
			if (Thread.currentThread().isInterrupted())
				return;
		}
	}

	// these 3 methods are 'get' methods which we use if at the end of our main method
	// when we want to access the current value of the member variables in this task.
	public static int biggestnumber() {
		return i;
	}

	public static int maxprime() {
		return Collections.max(primes);
	}

	public static int lengthprimes() {
		return primes.size();
	}

}
