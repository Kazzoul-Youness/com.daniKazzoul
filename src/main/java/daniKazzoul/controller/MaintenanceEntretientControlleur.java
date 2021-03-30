package daniKazzoul.controller;

import daniKazzoul.model.SimulateurModel;
import daniKazzoul.view.SimulateurView;

import static daniKazzoul.view.Vue.*;

public class MaintenanceEntretientControlleur {

    // - Singleton Pattern  ---------------------------------------------
    private static final MaintenanceEntretientControlleur instance = new MaintenanceEntretientControlleur();

    //constructeur privé pour éviter que les applications clientes utilisent le constructeur
    private MaintenanceEntretientControlleur() {
    }

    public static MaintenanceEntretientControlleur getInstance() {
        return instance;
    }




    public static void remplireReservoirEauAction(SimulateurView simulateurView, int actionEau) {
        if (actionEau == 1) {
            SimulateurModel.remplireEau();
            resetApresMaintenanceEtretient(simulateurView);
        }
    }

    public static void viderBacCollecteurAction(SimulateurView simulateurView, int actionBac) {
        if (actionBac == 1) {
            SimulateurModel.viderBac();
            resetApresMaintenanceEtretient(simulateurView);
        }
    }

    public static void remplireGrainCafeAction(SimulateurView simulateurView, int actionGraine) {
        if (actionGraine == 1) {
            SimulateurModel.remplireGraine();
            resetApresMaintenanceEtretient(simulateurView);
        }
    }

    public static void nettoyerMachineAction(SimulateurView simulateurView, int actionNettoyage) {
        if (actionNettoyage == 1) {
            SimulateurModel.nettoyer();
            resetApresMaintenanceEtretient(simulateurView);
        }
    }

    public static void detartrerMachineAction(SimulateurView simulateurView, int actionDetartrage) {
        if (actionDetartrage == 1) {
            SimulateurModel.detartrer();
            resetApresMaintenanceEtretient(simulateurView);
        }
    }

    public static void calcNCleanMachineAction(SimulateurView simulateurView, int actionCalc) {
        if (actionCalc == 1) {
            SimulateurModel.calcNClean();
            resetApresMaintenanceEtretient(simulateurView);
        }
    }

    private static void resetApresMaintenanceEtretient(SimulateurView simulateurView) {
        OperationControlleur.enableAllFunctions(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude, btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnQuantit, btnRetour, btnStartStop);
        simulateurView.textArea_MessageEcran.setText(null);
        simulateurView.btnStartStop.setText("Start/Stop");
    }




}
