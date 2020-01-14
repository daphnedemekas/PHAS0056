package finalexam_4;

import java.util.ArrayList;
import java.util.HashMap;

public class SpeciesSelector implements ImageSelector {
	
	GetAnimalData gad = new GetAnimalData();
	
	String species;

	public ArrayList<Image> select(ArrayList<Image> images) {
		ArrayList<Image> output = new ArrayList<Image>();
		try {
			HashMap<Integer, Expert> experts = gad.getExpertData("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt");
			for (Image image : images) {
				if (experts.get(image.id).classification.equals(species)){ 
					output.add(image);
				}	
			}	
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return output;
	}
	
	

}
