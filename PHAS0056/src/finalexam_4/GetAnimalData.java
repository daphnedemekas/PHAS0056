package finalexam_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import finalexam_3.Flight;

public class GetAnimalData {

	public GetAnimalData() {
	};

	public HashMap<Integer, Image> getImageData(String url) throws IOException {
		HashMap<Integer, Image> images = new HashMap<Integer, Image>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split("\\s+");
			int id = Integer.parseInt(row[0]);
			double latitude = Double.parseDouble(row[1]);
			double longitude = Double.parseDouble(row[2]);
			Image image = new Image(id, latitude, longitude);
			images.put(id, image);
		}
		scanner.close();

		return images;
	}

	public HashMap<Integer, Expert> getExpertData(String url) throws IOException {
		HashMap<Integer, Expert> experts = new HashMap<Integer, Expert>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split("\\s+");
			int id = Integer.parseInt(row[0]);
			int expert_id = Integer.parseInt(row[1]);
			String classification = row[2];
			Expert expert = new Expert(id, expert_id, classification);
			experts.put(id, expert);
		}
		scanner.close();

		return experts;
	}

	public ArrayList<Volunteer> getVolunteerData(String url) throws IOException {
		ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split("\\s+");
			int id = Integer.parseInt(row[0]);
			int volunteer_id = Integer.parseInt(row[1]);
			String classification = row[2];
			Volunteer volunteer = new Volunteer(id, volunteer_id, classification);
			volunteers.add(volunteer);
		}
		scanner.close();

		return volunteers;
	}

	public ArrayList<Image> getImageList(String url) throws IOException {
		ArrayList<Image> images = new ArrayList<Image>();
		URL u = new URL(url);
		InputStream is = u.openStream();
		// read from the input stream
		InputStreamReader isr = new InputStreamReader(is);
		// now wrap the input stream reader with a buffered reader
		BufferedReader b = new BufferedReader(isr);

		Scanner scanner = new Scanner(b);
		while (scanner.hasNext()) {
			String[] row = scanner.nextLine().split("\\s+");
			int id = Integer.parseInt(row[0]);
			double latitude = Double.parseDouble(row[1]);
			double longitude = Double.parseDouble(row[2]);
			Image image = new Image(id, latitude, longitude);
			images.add(image);
		}
		scanner.close();

		return images;
	}

}
