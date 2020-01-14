package finalexam_2;

public class LoudOrQuiet implements Classifier {

	public String classify(AudioFile audio) {
		double sum = 0;
		for (double i : audio.amplitudes) {
			double square = i * i;
			sum += square;
		}
		double rms = Math.sqrt(sum / audio.amplitudes.size());

		double amplitude = 20 * Math.log10(rms / audio.max_amplitude);
		
		if (amplitude > -20) {
			return "loud";
		}
		else {
			return "quiet";
		}
	}
	

}
