package finalexam_2;

import java.util.HashMap;

public class MainPart3 {

	public static void main(String[] args) {

		GetAudioData gad = new GetAudioData();
		SpectralClassifier sc = new SpectralClassifier();

		try {

			HashMap<String, String> index = gad
					.getInstruments("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");

			for (String filename : index.keySet()) {
				String link = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/" + filename;
				AudioFile audio = gad.getAudioFile(link);
				System.out.println("The audio file " + filename + " is " + sc.classify(audio));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
