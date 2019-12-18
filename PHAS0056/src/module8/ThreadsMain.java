package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		
		// here we create our 2 different threads 
		Thread countdown = new Thread(new CountdownTask(10));
		Thread primetask = new Thread(new PrimeNumberTask());
		// and we start their run methods
		countdown.start();
		primetask.start();
		
		// when the countdown task is completed, the main method should interrupt
		// the prime number task 
		try {
			countdown.join();
			// we are now pausing the main method until the countdown thread is complete and then continuing it
		}
		catch (InterruptedException e) {
			// unless the countdown method is interrupted everything should be ok
			System.out.println(e);
		}
		primetask.interrupt();
		try {primetask.sleep(1000);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		// once the countdown thread is complete, the main method will continue, and interrupt the prime thread
		
		// now we can use our get methods to access the values that we wish to print
		int biggestnumber = PrimeNumberTask.biggestnumber();
		int maxprime = PrimeNumberTask.maxprime();
		int numofprimes = PrimeNumberTask.lengthprimes();
		
		System.out.println("The largest integer checked so far is " + biggestnumber);
		System.out.println(" The largest prime found is " + maxprime);
		System.out.println(" The total number of primes is " + numofprimes);
		
	}

}
