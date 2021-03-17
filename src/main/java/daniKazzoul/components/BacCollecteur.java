package daniKazzoul.components;

public class BacCollecteur {

	private static boolean etatCollecteur;
	private static int cptBac=0;

	public BacCollecteur() {
	}
	public static void initializeBacCollecteur() {
		etatCollecteur = false;
		cptBac =0;
	}

	public static int checkNiveauCollecteur() {
		if ( (cptBac % 3) == 0 ){
			return 2;
		}
		return -2;
	}

	public static void consomerBoissonCollecteur() {
		cptBac ++;
	}

	public static void remplire() {
		cptBac = 0;
	}

}