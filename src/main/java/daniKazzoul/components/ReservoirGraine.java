package daniKazzoul.components;

public class ReservoirGraine {

    private static int cptGraine=0;
    private static boolean etatGraine;

    public ReservoirGraine() {
    }

    public static void initializeReservoirGraine() {
        etatGraine = false;
        cptGraine = 0;
    }

    public static int checkNiveauReservoirGraine() {
        if ((cptGraine % 4) == 0){
            return 3;
        }
        return -3;
    }

    public static void consommerBoissonParGraine() {
        cptGraine++;
    }
    public static void remplire() {
        cptGraine = 0;
    }

}