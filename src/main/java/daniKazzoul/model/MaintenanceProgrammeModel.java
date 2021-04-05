package daniKazzoul.model;

public class MaintenanceProgrammeModel{

    public static int cptNettoyage;
    public static int cptDetartrage;
    public static int cptCalcNClean;

    // use Singleton design pattern
    private MaintenanceProgrammeModel() {
       cptNettoyage = 0;
       cptDetartrage = 0;
       cptCalcNClean = 0;
    };
    private static MaintenanceProgrammeModel instance = null;
    public static MaintenanceProgrammeModel getInstance() {
        if(instance == null) instance = new MaintenanceProgrammeModel();
        return instance;
    }


    // - Maintenance -----------------------------------

    public static int checkMaintenanceNettoyage() {
        if ((cptNettoyage % 2) == 0 ) {
            return 1;   // declencher le nettoyage apres chaque (% 2) nombre de fois
        }
        return 0;       // code retour pour une utilisation normal
    }
    public static int checkMaintenanceDetartrage() {
        if ((cptDetartrage % 3) == 0 ) {
            return 1;   // declencher le detartrage apres chaque (% 3) nombre de fois
        }
        return 0;       // code retour pour une utilisation normal
    }
    public static int checkMaintenanceCalcNClean() {
        if (( cptCalcNClean % 6) == 0) {
            return 1;   // declencher le calc'nClean apres chaque (% 6) nombre de fois
        }
        return 0;       // code retour pour une utilisation normal
    }

    // - Consomations -----------------------------------

    public static void consommerBoissonAvantNettoyage()   {  cptNettoyage++;  }
    public static void consommerBoissonAvantDetartrage()  {  cptDetartrage++; }
    public static void consommerBoissonAvantCalcNClean()  {  cptCalcNClean++; }


    // - Rénitialisations -----------------------------------

    public static void nettoyer()   { cptNettoyage  = 0;  }
    public static void detartrer()  { cptDetartrage = 0;  }
    public static void calcNClean() { cptCalcNClean = 0; cptNettoyage = 0; cptDetartrage = 0;  }


    // - Getters compteurs -----------------------------------

    public static int getCptNettoyage()  {  return cptNettoyage;  }
    public static int getCptDetartrage() {  return cptDetartrage;  }
    public static int getCptCalcNClean() {  return cptCalcNClean;  }


}
