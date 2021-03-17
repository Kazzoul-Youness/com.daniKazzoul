package daniKazzoul.view;

import daniKazzoul.controller.OperationControlleur;

import java.io.FileNotFoundException;

public class MaintenanceVue extends UtilisateurVue{

    public MaintenanceVue() throws FileNotFoundException {
    }


    static void operationMaintenanceNettoyage(UtilisateurVue utilisateurVue) {
        if (utilisateurVue.textArea_MessageEcran.getText().equals("\n Nettoyage necessaire \n\n Appuyer sur le menu pour l'ouvrir")) {
            //OperationNettoyage.nettoyer();
            OperationControlleur.enableAllFunctions(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnQuantit, utilisateurVue.btnRetour, utilisateurVue.btnStartStop);
            utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.btnStartStop.setText("Start/Stop");
        }
    }
}
