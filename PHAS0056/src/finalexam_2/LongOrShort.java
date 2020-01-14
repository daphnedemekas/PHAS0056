package finalexam_2;

public class LongOrShort implements Classifier {

	public String classify(AudioFile audio) {
		double duration = audio.num_samples / audio.frequency;
		if (duration > 1) {
			return "long";
		}
		else {
			return "short";
		}
		
	}
	
	

}
