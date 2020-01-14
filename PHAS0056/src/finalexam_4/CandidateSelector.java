package finalexam_4;

import java.util.ArrayList;
import java.util.HashMap;

public class CandidateSelector implements ImageSelector {

	GetAnimalData gad = new GetAnimalData();
	
	String species;

	public ArrayList<Image> select(ArrayList<Image> images) {
		ArrayList<Image> output = new ArrayList<Image>();
		try {
			ArrayList<Volunteer> volunteers = gad
					.getVolunteerData("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");
			
			// this contains the number of volunteers that classified each image
			HashMap<Integer, Integer> num_volunteers = MainPart1.numberVs(volunteers);
			
			// we need the number of volunteers who identified them as species
			
			//int number_classified;
			
				
			for (Image image: images) {
				//System.out.println(image.id);
				
				int number_classified = 0;
				double number_vs = 0;
				
				for (Volunteer v: volunteers) {

					// find a volunteer who classified this image
										
					if (v.image_id == image.id) {
						number_vs = (double) num_volunteers.get(image.id);

						//System.out.println(image.id + "and" + v.volunteer_id);
						// did she classify as lion?
						if (v.classification.equals(species)) {
							number_classified += 1;
						}
					}
					
					
				}
				
				if ((double) number_classified > number_vs / 2) {
					output.add(image);
				}
			}
			
		} catch (Exception e) {
			System.out.println("WATCH O:UT");
			System.out.println(e);
		}
		return output;
	}

}
