package daniKazzoul.components;

public class ReservoirEau {

    private static boolean etatReservoir;
    private static int cptEau=0;

    public ReservoirEau() {
    }

    public static void initializeReservoirEau() {
        etatReservoir = false;
        cptEau = 0;
    }

    public static int checkNiveauEau() {
        if ((cptEau % 5) == 0) {
            return 1; // declencher la maintenance
        }
        return -1; // utilisation normal
    }

    public static void consommerBoissonParReservoir() {
        cptEau++;
    }
    public static void remplire() {
        cptEau = 0;
    }

}