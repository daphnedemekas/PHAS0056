package module8;

public class CountdownTask implements Runnable {
	
	int seconds;
	
	public CountdownTask(int seconds) {
		this.seconds = seconds;
	};
	
	// run method should print the number of seconds remaining at one second intervals
	// then return when countdown reaches zero 
	
	public void run() {
		// timeInterval specifies how long we want to wait before printing to the screen
		final long timeInterval = 1000;
		for (int i=seconds; i>=0; i--) {
		      System.out.println(i);
		      try {
		    	  // thread . sleep basically just tells this thread to sleep for time interaval (one second)
		    	  // and then continue, which allows it to print to the screen every second 
		    	  // rather than right away 
		    	  Thread.sleep(timeInterval);
		      } catch (InterruptedException e) {
		    	  	e.printStackTrace();
		      } 
		}
		// we 'return' void when we are finished and have iterated through 10 seconds. 
		return;
	}	
	
}
	
