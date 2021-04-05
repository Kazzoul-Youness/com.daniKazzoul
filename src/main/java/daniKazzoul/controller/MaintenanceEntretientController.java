package daniKazzoul.controller;

import daniKazzoul.model.EntretientReservoirModel;
import daniKazzoul.model.MaintenanceProgrammeModel;

public class MaintenanceEntretientController {

    /** - Singleton Pattern  */
    private MaintenanceEntretientController() {};
    private static MaintenanceEntretientController instance = null;
    public static MaintenanceEntretientController getInstance() {
        if(instance == null) instance = new MaintenanceEntretientController();
        return instance;
    }
    /*************/


    public static void remplireReservoirEauAction(int actionEau) {
        if (actionEau == 1) {
            EntretientReservoirModel.getInstance().remplireEau();
        }
    }

    public static void viderBacCollecteurAction(int actionBac) {
        if (actionBac == 1) {
            EntretientReservoirModel.getInstance().viderBac();
        }
    }

    public static void remplireGrainCafeAction(int actionGraine) {
        if (actionGraine == 1) {
            EntretientReservoirModel.getInstance().remplireGraine();
        }
    }

    public static void nettoyerMachineAction(int actionNettoyage) {
        if (actionNettoyage == 1) {
            MaintenanceProgrammeModel.getInstance().nettoyer();
        }
    }

    public static void detartrerMachineAction(int actionDetartrage) {
        if (actionDetartrage == 1) {
            MaintenanceProgrammeModel.getInstance().detartrer();
        }
    }

    public static void calcNCleanMachineAction(int actionCalc) {
        if (actionCalc == 1) {
            MaintenanceProgrammeModel.getInstance().calcNClean();
        }
    }


    /* *******************************************************/
    /*  Verification au demarrage, et a chaque selection d'une boisson!
    /*** Pour: soit remplir l'eau, remplir les graine, viderBac le bac,
    **** et les programmes de maintenance : nettoyage, détartrage, calc'nClean
    ***/

    public static void miseAJourTotal() {

        EntretientReservoirModel.getInstance().consommerBoissonParReservoir();
        EntretientReservoirModel.getInstance().consomerBoissonCollecteur();
        EntretientReservoirModel.getInstance().consommerBoissonParGraine();
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantNettoyage();
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantDetartrage();
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantCalcNClean();

    }


}
