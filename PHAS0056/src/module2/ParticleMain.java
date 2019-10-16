package module2;

public class ParticleMain {

	public static void main(String[] args) {
		
		// create a falling particle with given mass and drag 
		FallingParticle object = new FallingParticle(4.3,2.4);
		
		// set the initial height as 5. our h is static so accessed in a static way
		object.h = 5;
		
		// print the time elapsed for given delta T values
		System.out.println(object.drop(0.5));
		
		System.out.println(object.drop(0.1));
		
		System.out.println(object.drop(0.01));
		
		System.out.println(object.drop(0.001));
		
		System.out.println(object.drop(0.0001));

		System.out.println("the different time steps change the rate at which z appraoches zero. "
				+ "a larger time step means z takes much larger jumps each iteration and will hit zero quickly" 
				+ "But a shorter time step means that there will be many more iterations before z hits zero"
				+ "Therefore velocity will be smaller where total distance travelled is smaller (where deltaT is smaller) and the rate of this"
				+ "change will decrease as time steps decrease. The time elapsed changes for similar reasons as we are adding smaller intervals"
				+ "each iteration as deltaT decreases");

	}

}
