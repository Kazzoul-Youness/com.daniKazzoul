package daniKazzoul.view;

import daniKazzoul.components.BacCollecteur;
import daniKazzoul.components.ReservoirEau;
import daniKazzoul.components.ReservoirGraine;
import daniKazzoul.controller.OperationControlleur;

import java.io.FileNotFoundException;

public class EntretientVue extends UtilisateurVue {


    public EntretientVue() throws FileNotFoundException {
    }

    /*********************     Actions d'entretient de la machine et (maintenance)
     * @param utilisateurVue*****************************/
    static void remplireGrainCafe(UtilisateurVue utilisateurVue) {
        if (utilisateurVue.textArea_MessageEcran.getText().equals(" \n Remplir graine café \n")) {
            ReservoirGraine.remplire();
            OperationControlleur.enableAllFunctions(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnQuantit, utilisateurVue.btnRetour, utilisateurVue.btnStartStop);
            utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.btnStartStop.setText("Start/Stop");
        }
    }

    static void remplireReservoirEauAction(UtilisateurVue utilisateurVue) {
        if (utilisateurVue.textArea_MessageEcran.getText().equals(" Remplir le reservoir d'eau \n")) {
            ReservoirEau.remplire();
            OperationControlleur.enableAllFunctions(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnQuantit, utilisateurVue.btnRetour, utilisateurVue.btnStartStop);
            utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.btnStartStop.setText("Start/Stop");
        }
    }

    static void viderBacCollecteur(UtilisateurVue utilisateurVue) {
        if (utilisateurVue.textArea_MessageEcran.getText().equals(" \n Vider bac collecteur \n")) {
            BacCollecteur.remplire();
            OperationControlleur.enableAllFunctions(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnQuantit, utilisateurVue.btnRetour, utilisateurVue.btnStartStop);
            utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.btnStartStop.setText("Start/Stop");
        }
    }
}
