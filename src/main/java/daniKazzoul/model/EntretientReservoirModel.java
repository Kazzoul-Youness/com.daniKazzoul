package daniKazzoul.model;

public class EntretientReservoirModel{

    public static int cptEau;
    public static int cptBac;
    public static int cptGraine;

    // use Singleton design pattern
    private EntretientReservoirModel() {
        cptEau = 0;
        cptBac = 0;
        cptGraine = 0;
    }
    private static EntretientReservoirModel instance = null;
    public static EntretientReservoirModel getInstance() {
        if(instance == null) instance = new EntretientReservoirModel();
        return instance;
    }


    // - Entretient -----------------------------------

    public static int checkNiveauEau() {
        if ((cptEau % 2) == 0) {
            return 1;       // declencher le message de remplissage d'eau toutes les 2 cycles
        }
        return 0;           // utilisation normal
    }

    public static int checkNiveauCollecteur() {
        if ( (cptBac % 3) == 0 ){
            return 1;           // declencher l'entretient de vidange du bac Collecteur toutes les 3 cycles
        }
        return 0;
    }

    public static int checkNiveauReservoirGraine() {
        if ((cptGraine % 4) == 0){
            return 1;           // declencher l'entretient de remplissage des graines de café toutes les 4 cycles
        }
        return 0;
    }

    // - Consomations -----------------------------------

    public static void consommerBoissonParReservoir() {   cptEau++;    }
    public static void consomerBoissonCollecteur()    {   cptBac++;   }
    public static void consommerBoissonParGraine()    {   cptGraine++; }

    // - Rénitialisations -----------------------------------

    public static void remplireEau()    {  cptEau    = 0; }
    public static void viderBac()       {  cptBac    = 0; }
    public static void remplireGraine() {  cptGraine = 0; }

    // - Getters compteurs -----------------------------------

    public static int getCptEau()    {  return cptEau;    }
    public static int getCptBac()    {  return cptBac;    }
    public static int getCptGraine() {  return cptGraine; }



}
