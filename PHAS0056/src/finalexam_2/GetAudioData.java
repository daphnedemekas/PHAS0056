package finalexam_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import finalexam_1.Signal;

public class GetAudioData {

	public HashMap<String, String> getInstruments(String url) throws IOException {
		HashMap<String, String> instruments = new HashMap<String, String>();

		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split("\\s+");
			String name = row[0];
			String instrument = row[1];
			instruments.put(name, instrument);
		}
		scanner.close();

		return instruments;
	}

	// one function for each file

	// want to make audiofile objects
	public AudioFile getAudioFile(String url) throws IOException {
		ArrayList<Double> amplitudes = new ArrayList<Double>();

		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		String[] row = scanner.nextLine().split("\\s+");
		double frequency = Double.parseDouble(row[0]);
		double num_samples = Double.parseDouble(row[1]);
		double max_amplitudes = Double.parseDouble(row[2]);
		while (scanner.hasNext()) {
			double amplitude = Double.parseDouble(scanner.nextLine());
			amplitudes.add(amplitude);
		}
		AudioFile file = new AudioFile(frequency, num_samples, max_amplitudes, amplitudes);
		scanner.close();

		return file;
	}

}
