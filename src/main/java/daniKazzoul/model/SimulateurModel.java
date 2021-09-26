package daniKazzoul.model;

import daniKazzoul.view.AbstractView;

public class SimulateurModel {

    public static int entretientAction;

    // - Singleton Pattern ---------------------------------------------
    private static SimulateurModel instance = new SimulateurModel();
    // !! à ne pas oublier de remettre le constructeur en private !!!!!!!
    private SimulateurModel() {  }
    public static SimulateurModel getInstance() {
        entretientAction = 0;
        return instance;
    }

    /************* Les operations d'affichage d'entretient et maintenance ****************************/

    public static void checkActionReturnGlobal(int actionEau, int actionBac, int actionGraine, int actionNettoyage, int actionDetartrage) {

        if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.nettoyageAccompli = true;
            AbstractView.detartrageAccompli = true;
            AbstractView.calcNCleanAccompli = true;
            entretientAction = 0;
        } else if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Detartrer necessaire\n\n\n Et puis appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 0;
        } else if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Nettoyage necessaire\n\n\n Et puis appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 0;
        } else if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" calc'nClean necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 0;
        } else if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir graine café\n\n\n Et puis appuyer sur (Ok)");
            entretientAction = 3;
        } else if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Detartrage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 3;
        } else if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Nettoyage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 3;
        } else if ((actionEau == 0) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" calc'nClean necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 3;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n\n Et puis appuyer sur (Ok)");
            entretientAction = 2;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Detartrage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 2;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Nettoyage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 2;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" calc'nClean necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 2;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n\n Et puis appuyer sur (Ok)");
            entretientAction = 23;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Detartrage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 23;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Nettoyage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 23;
        } else if ((actionEau == 0) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" calc'nClean necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 23;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n\n Et puis appuyer sur (Ok)");
            entretientAction = 1;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Detartrage necessaire\n\n\n Et puis appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 1;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Nettoyage necessaire\n\n\n Et puis appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 1;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" calc'nClean necessaire\n\n\n Et puis appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 1;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n\n Et puis appuyer sur (Ok)");
            entretientAction = 13;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Detartrage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 13;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Nettoyage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 13;
        } else if ((actionEau == 1) && (actionBac == 0) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" calc'nClean necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 13;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n\n Et puis appuyer sur (Ok)");
            entretientAction = 12;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Detartrage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 12;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Nettoyage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 12;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 0) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" calc'nClean necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 12;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n\n Appuyer sur (Ok)");
            entretientAction = 123;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 0) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Detartrage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Detartrage necessaire");
            AbstractView.detartrageAccompli = false;
            entretientAction = 123;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 0)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" Nettoyage necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("Nettoyage necessaire");
            AbstractView.nettoyageAccompli = false;
            entretientAction = 123;
        } else if ((actionEau == 1) && (actionBac == 1) && (actionGraine == 1) && (actionNettoyage == 1) && (actionDetartrage == 1)) {
            AbstractView.textArea_MessageEcran.setText(" Remplir le reservoir d'eau\n\n");
            AbstractView.textArea_MessageEcran.append(" Vider bac collecteur \n\n");
            AbstractView.textArea_MessageEcran.append(" Remplir graine café\n\n");
            AbstractView.textArea_MessageEcran.append(" calc'nClean necessaire\n\n\n Appuyer sur (Ok)");
            AbstractView.textField_Choice.setText("calc'nClean necessaire");
            AbstractView.calcNCleanAccompli = false;
            entretientAction = 123;
        }

    }


    /*******************************************/

    public static int getEntretientAction() {
        return entretientAction;
    }


}
