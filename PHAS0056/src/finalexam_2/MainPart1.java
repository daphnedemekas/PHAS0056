package finalexam_2;

import java.util.HashMap;

public class MainPart1 {

	public static void main(String[] args) {
		GetAudioData gad = new GetAudioData();

		try {
			HashMap<String, String> index = gad.getInstruments("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");

			for (String filename : index.keySet()) {
				String link = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/" + filename;
				AudioFile audio = gad.getAudioFile(link); // this is an audiofile
				double duration = audio.num_samples / audio.frequency;

				double sum = 0;
				for (double i : audio.amplitudes) {
					double square = i * i;
					sum += square;
				}
				double rms = Math.sqrt(sum / audio.amplitudes.size());

				double amplitude = 20 * Math.log10(rms / audio.max_amplitude);
				System.out.println("For the file " + filename + ", the duration is " + duration
						+ ",  the amplitude is " + amplitude);
				System.out.println(" and the instrument is " + index.get(filename) + "\n");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
