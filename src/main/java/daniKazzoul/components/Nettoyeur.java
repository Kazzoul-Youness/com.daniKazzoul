package daniKazzoul.components;


public class Nettoyeur {

    private static int cptNettoyage = 0;

    public Nettoyeur() {
    }

    public static int checkMaintenanceNettoayge() {
        if ((cptNettoyage % 6) == 0) {
            return 4; // declencher la maintenance nettoyage automatiquement apres chaque (% X) nombre de fois
        }
        return -4; // code retour pour une utilisation normal
    }

    public static void consommerBoissonAvantNettoayge() {
        cptNettoyage++;
    }

    public static void nettoyer() {
        cptNettoyage = 0;
    }
}

