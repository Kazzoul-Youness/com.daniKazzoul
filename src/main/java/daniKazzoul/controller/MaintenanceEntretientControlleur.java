package daniKazzoul.controller;

import daniKazzoul.view.UtilisateurVue;

public class MaintenanceEntretientControlleur {

    // - Singleton Pattern
    private static final MaintenanceEntretientControlleur instance = new MaintenanceEntretientControlleur();

    //constructeur privé pour éviter que les applications clientes utilisent le constructeur
    private MaintenanceEntretientControlleur(){  }

    public static MaintenanceEntretientControlleur getInstance(){
        return instance;
    }



    /************** Les operations d'affichage d'entretient et maintenance ****************************/

    public static void checkActionReturnReservoirEau(UtilisateurVue utilisateurVue, int action) {
        if (action == 1) {
            OperationControlleur.disableOtherFunction(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnOk, utilisateurVue.btnQuantit, utilisateurVue.btnRetour);
            utilisateurVue.btnStartStop.setEnabled(false);
            if (utilisateurVue.textArea_MessageEcran.getText().equals("Appuyer sur stop pour annuler!\n"))
                utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.textArea_MessageEcran.append(" Remplir le reservoir d'eau \n\n");
        }
    }

    public static void checkActionReturnReservoirGraine(UtilisateurVue utilisateurVue, int action) {
        if (action == 3) {
            OperationControlleur.disableOtherFunction(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnOk, utilisateurVue.btnQuantit, utilisateurVue.btnRetour);
            utilisateurVue.btnStartStop.setEnabled(false);
            if (utilisateurVue.textArea_MessageEcran.getText().equals("Appuyer sur stop pour annuler!\n"))
                utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.textArea_MessageEcran.append(" Remplir graine café \n\n");
        }
    }

    public static void checkActionReturnBacColecteur(UtilisateurVue utilisateurVue, int action) {
        if (action == 2) {
            OperationControlleur.disableOtherFunction(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnOk, utilisateurVue.btnQuantit, utilisateurVue.btnRetour);
            utilisateurVue.btnStartStop.setEnabled(false);
            if (utilisateurVue.textArea_MessageEcran.getText().equals("Appuyer sur stop pour annuler!\n"))
                utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
        }
    }

    public static void checkActionReturnNettoyage(UtilisateurVue utilisateurVue, int action) {
        if (action == 4) {
            utilisateurVue.nettoyageAccompli = false;
            OperationControlleur.disableOtherFunction(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnOk, utilisateurVue.btnQuantit, utilisateurVue.btnRetour);
            utilisateurVue.btnOk.setEnabled(true);
            utilisateurVue.btnMenu.setEnabled(false);
            if (utilisateurVue.textArea_MessageEcran.getText().equals("Appuyer sur stop pour annuler!\n"))
                utilisateurVue.textArea_MessageEcran.setText(null);
            utilisateurVue.textArea_MessageEcran.append(" Nettoyage necessaire \n\n Appuyer sur (OK) pour commencer");

            utilisateurVue.textField_Quantite.setText(null);
            utilisateurVue.textField_Intensite.setText(null);
            utilisateurVue.textField_Choice.setText(null);
        }
    }

}
