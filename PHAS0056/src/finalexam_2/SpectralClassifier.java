package finalexam_2;

public class SpectralClassifier implements Classifier {
	double[] frequencies = {100,400,1000};

	public String classify(AudioFile audio) {
		double[] frequencies = {100,400,1000};
		int count = 0;
		double density = 0;
		for (double f: frequencies) {
			double spectraldensity = spectralDensity(audio, f);
			if (spectraldensity > density) {
				density = spectraldensity;
				count += 1;
			}
		}
		if (count == 1) {
			return "low";
		}
		if (count == 2) {
			return "medium";
		}
		if (count == 3) {
			return "high";
		}
		return null;		
	}
		


	private double spectralDensity(AudioFile audio, double frequency) {
		double bigN = audio.amplitudes.size();
		double duration = audio.num_samples / audio.frequency;
		double z = 2 * Math.PI * frequency * duration / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
			sumCos += audio.amplitudes.get(n) * Math.cos(z*n);
			sumSin += audio.amplitudes.get(n) * Math.sin(z*n);
		}
		double norm = duration / (bigN * bigN);
		double density = norm * (sumCos * sumCos + sumSin * sumSin);
		return norm * (sumCos * sumCos + sumSin * sumSin);
	}
}