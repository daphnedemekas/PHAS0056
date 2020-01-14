package finalexam_4;

import java.util.ArrayList;

public class MCC {

	double TP; // images of lions correctly identified

	double TN; // images not of lions that are not identified as lion candidates

	double K = 1000;

	double L; // number of lions

	double P; // number of lion candidates

	double N; // number of negatives

	double FP;

	double FN;

	public double mcc(ArrayList<Image> species, ArrayList<Image> candidates) {

		double MCC = 0;

		try {

			TP = 0;

			for (Image l : species) {
				if (candidates.contains(l)) {
					TP += 1;
				}
			}

			L = species.size();

			P = candidates.size();

			N = K - P;

			FP = P - TP;

			FN = L - TP;

			TN = N - FN;

			MCC = (TP * TN - FP * FN) / (Math.sqrt((TP + FP) * (TP + FN) * (TN + FP) * (TN + FN)));
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return MCC;


	}
}
