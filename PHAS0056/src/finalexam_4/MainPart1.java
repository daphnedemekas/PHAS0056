package finalexam_4;

import java.util.ArrayList;
import java.util.HashMap;

public class MainPart1 {

	public static void main(String[] args) {

		GetAnimalData gad = new GetAnimalData();

		try {
			HashMap<Integer, Image> images = gad
					.getImageData("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");

			HashMap<Integer, Expert> experts = gad
					.getExpertData("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt");

			ArrayList<Volunteer> volunteers = gad
					.getVolunteerData("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");

			System.out.println("The total number of images is: " + images.size());

			// now we find how many volunteers classified each image
			
			HashMap<Integer, Integer> num_volunteers = numberVs(volunteers);

			

			System.out.println(
					"The number of images classified by at least 1 volunteer is" + num_volunteers.size() + "\n");

			// now we need those that have more than 10

			System.out.println("The images that have more than 10 volunteer classifications: ");
			for (Integer id : num_volunteers.keySet()) {
				if (num_volunteers.get(id) >= 10) {
					System.out.println("image id: " + id);
					System.out.println(images.get(id));
					System.out.println("The expert classified the image as a " + experts.get(id).classification);
					System.out.println("And the volunteers classified the image as: ");
					for (Volunteer v : volunteers) {
						Integer V = (Integer) v.image_id;
						Integer ID = (Integer) id;
						if (V.equals(ID)) {
							System.out.println(v.classification);
						}
						//System.out.println("\n");
					}

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static HashMap<Integer, Integer> numberVs(ArrayList<Volunteer> volunteers) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		HashMap<Integer, Integer> num_volunteers = new HashMap<Integer, Integer>();
		for (Volunteer v : volunteers) {
			if (!ids.contains(v.image_id)) {
				num_volunteers.put(v.image_id, 1);
				ids.add(v.image_id);
			} else {
				num_volunteers.put(v.image_id, num_volunteers.get(v.image_id) + 1);
			}
	}
		return num_volunteers;

}
}
