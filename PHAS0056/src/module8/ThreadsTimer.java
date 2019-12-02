package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadsTimer {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//we will be using this many random points to calculate pi
		long nPoints = 10000000L;

		// first using a single thread: 
		MonteCarloPiCalculatorTask singlethread = new MonteCarloPiCalculatorTask(nPoints);
		long currenttime = System.currentTimeMillis();
		
		double pi = singlethread.call();
		
		double timetaken1 = (double) (System.currentTimeMillis() - currenttime)/ 1000;
		
		System.out.println("The time taken for a single thread is " + timetaken1 + " seconds,");
		System.out.println("and the result for a single thread is " + pi + "\n");
		// need to measure and report the time taken using System.currentTimeMillisI

		int nThreads = 4;
		
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		// make 4 threads to check 4 different random numbers simulatenously 
		// so that you have a better estimate 
		
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		// future is the result of a task that hasn't completed 
		
		long currenttime2 = System.currentTimeMillis();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints / nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		// adding the estimates of pi to the arraylist of futures 
		
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			// getting the results of the task whenever the task is complete
			sum += result;
			// summing the 4 results
		}
		threadPool.shutdown();
		double pi2 = sum / nThreads;
		// taking the average of the 4 results which are estimates for pi
	double timetaken2 = (double) (System.currentTimeMillis() - currenttime2) / 1000;
			
	System.out.println("The time taken for 4 threads is " + timetaken2 + " seconds,");
	System.out.println("and the result for 4 threads is " + pi2 + "\n");
	
	System.out.println(" We see that running 4 threads in parallel will always take less time, in this case by " +  (timetaken1 - timetaken2) + " less seconds.");
	System.out.println("However, there is no real evidence that 4 parallel threads will always result in a better estimate for pi." + "\n" + "In this case, we are " + (Math.PI - pi) + " off for a single thread and");
	System.out.println((Math.PI - pi2) + " off for the 4 threads.");
	}
	
	
}