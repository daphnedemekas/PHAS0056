package module1;

public class AlgorithmControl {
	
	public AlgorithmControl()  { }
	
	// integers 1 to 8
	
	void loop() {
		
		for (int i=1; i<=8; i++) {
			System.out.println(i);
		}
	}
				
	void decrement() {
		int x = 10;
		while (x > -6) {
			System.out.println(x);
			x--;
		}
		
	}
	
	void increment() {
		double y = 25;
		double z = 0.1;
		while ( y < 44) {
			System.out.println(y);
			y += z;
		}
	}
	
	int timer(long maxTime, int loopSteps) { 
		int i = 0;
		int loops = 0;
		long startTime = System.currentTimeMillis();
		long currentTime = startTime;
		while(currentTime<startTime+maxTime){
			i += 1;
			if (i % loopSteps == 0) {
				loops += 1;
			}
			currentTime =  System.currentTimeMillis();

		}
		return loops;


	}
		
	public static void main(String[] args) {
				
		AlgorithmControl ac = new AlgorithmControl();
		
		System.out.println("Loop returns");
		ac.loop();
		
		System.out.println("Decrement returns");
		ac.decrement();
		
		System.out.println("Increment returns");
		ac.increment();
		
		System.out.println("Every 1000 loops, the number of loops is");
		int number_of_loops = ac.timer(10000,1000);
		System.out.println(number_of_loops);
		
		System.out.println("Every 50,000 loops, the number of loops is");
		int number_of_loops2 = ac.timer(10000, 50000);
		System.out.println(number_of_loops2);
		
		System.out.println("the total number of loops decreases substantially because only loop counts that are multiples of  50,000 can be counted rather than 10000. if there are 285811 loops counted every 1000 there are 285811000 iterations. if there are 6071 loops counted every 50,000 there are 303550000 iterations. close enough!"); 

		
	}

}
