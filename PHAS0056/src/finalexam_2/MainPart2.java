package finalexam_2;

import java.util.HashMap;

public class MainPart2 {

	public static void main(String[] args) {

		GetAudioData gad = new GetAudioData();
		LongOrShort los = new LongOrShort();
		LoudOrQuiet lod = new LoudOrQuiet();
		
		try {

		HashMap<String, String> index = gad
				.getInstruments("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");

			for (String filename : index.keySet()) {
				String link = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/" + filename;
				AudioFile audio = gad.getAudioFile(link); // this is an audiofile
				System.out.println("The audio file" + filename + " is " + los.classify(audio) + " and " + lod.classify(audio));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
