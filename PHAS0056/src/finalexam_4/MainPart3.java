package finalexam_4;

import java.util.ArrayList;

public class MainPart3 {

	public static void main(String[] args) {
		
		GetAnimalData gad = new GetAnimalData();

		SpeciesSelector ss = new SpeciesSelector();

		CandidateSelector cs = new CandidateSelector();
		
		MCC mcc = new MCC();
		
		CandidateSelector2 cs2 = new CandidateSelector2();
		
		try {

		ArrayList<Image> images = gad
				.getImageList("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");

		ss.species = "lion";

		ArrayList<Image> lions = ss.select(images);

		cs.species = "lion";

		ArrayList<Image> maybelions = cs.select(images);
		
		
		
		double mcc1 = mcc.mcc(lions, maybelions);
		
		
		cs2.species = "lion";
		
		ArrayList<Image> maybelion2 = cs2.select(images);
		
		double mcc2 = mcc.mcc(lions, maybelion2);
		
		System.out.println("The first MCC is " + mcc1);
		System.out.println("The second MCC is " + mcc2);
		
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		}
		
	}

