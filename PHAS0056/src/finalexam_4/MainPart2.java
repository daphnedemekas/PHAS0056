package finalexam_4;

import java.util.ArrayList;

public class MainPart2 {

	public static void main(String[] args) {
		
		GetAnimalData gad = new GetAnimalData();
		
		SpeciesSelector ss = new SpeciesSelector();

		CandidateSelector cs = new CandidateSelector();
		
		try {
		
			ArrayList<Image> images = gad.getImageList("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
	
			ss.species = "lion";
			
			ArrayList<Image> Lions = ss.select(images);
			
			System.out.println("The images that experts classified as lions are: ");
			for (Image l: Lions) {
				System.out.println(l.id);
				System.out.println(l);
			}
			
			cs.species = "lion";
			
			ArrayList<Image> MaybeLions = cs.select(images);
			
			
			
			System.out.println("The lion candidates are: ");
			
			for (Image ml: MaybeLions) {
				System.out.println(ml.id);
				System.out.println(ml);
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
