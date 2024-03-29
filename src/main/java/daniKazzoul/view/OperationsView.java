package daniKazzoul.view;

import javax.swing.*;
import java.awt.*;

import static daniKazzoul.view.AbstractView.*;

public class OperationsView {

    // use Singleton design pattern
    private OperationsView() {}; // make constructor invisible to clients
    private static OperationsView instance = null;
    public static OperationsView getInstance() {
        if(instance == null) instance = new OperationsView();
        return instance;
    }

    /************** Les operations desactivation ****************************/

    public static void desableTableauBord(JButton btnBas, JButton btnMenu, JButton btnOk,
                                          JButton btnRetour, JButton btnStartStop) {
        btnStartStop.setEnabled(false);
        btnMenu.setEnabled(false);
        btnOk.setEnabled(false);
        btnBas.setEnabled(false);
        btnRetour.setEnabled(false);
    }

    public static void desableComposante(JButton btnFavorisSecurite, JProgressBar progressBar,
                                         JTextArea textArea_MessageEcran, JTextField textField_Choice,
                                         JTextField textField_Intensite, JTextField textField_Quantite) {
        textField_Choice.setEnabled(false);
        textField_Quantite.setEnabled(false);
        textField_Intensite.setEnabled(false);
        textArea_MessageEcran.setEnabled(false);
        progressBar.setEnabled(false);
        btnFavorisSecurite.setEnabled(false);
    }

    public static void desableParametre(JButton btnDeuxtasses, JButton btnIntensit, JButton btnQuantit) {
        btnQuantit.setEnabled(false);
        btnIntensit.setEnabled(false);
        btnDeuxtasses.setEnabled(false);
    }

    public static void desableBoisson(JButton btnAmericano, JButton btnCafe, JButton btnCafeLait,
                                      JButton btnCappuccino, JButton btnEauChaude, JButton btnExpresso) {
        btnExpresso.setEnabled(false);
        btnCafe.setEnabled(false);
        btnCafeLait.setEnabled(false);
        btnCappuccino.setEnabled(false);
        btnEauChaude.setEnabled(false);
        btnAmericano.setEnabled(false);
    }


    public static void enableTableauBord(JButton btnBas, JButton btnMenu, JButton btnOk,
                                         JButton btnRetour, JButton btnStartStop) {
        btnStartStop.setEnabled(true);
        btnMenu.setEnabled(true);
        btnOk.setEnabled(true);
        btnBas.setEnabled(true);
        btnRetour.setEnabled(true);
    }

    public static void enableComposante(JProgressBar progressBar,
                                        JTextArea textArea_MessageEcran, JTextField textField_Choice,
                                        JTextField textField_Intensite, JTextField textField_Quantite,
                                        Timer timer ) {
        textField_Choice.setVisible(true);
        textField_Choice.setEnabled(true);

        textField_Quantite.setVisible(true);
        textField_Quantite.setEnabled(true);

        textField_Intensite.setVisible(true);
        textField_Intensite.setEnabled(true);

        textArea_MessageEcran.setVisible(true);
        textArea_MessageEcran.setEnabled(true);

        progressBar.setVisible(true);
        progressBar.setEnabled(true);
        progressBar.setValue(0);
        timer.stop();


        btnFavorisSecurite.setVisible(true);
        btnFavorisSecurite.setEnabled(true);
    }

    public static void enableParametre(JButton btnDeuxtasses, JButton btnIntensit, JButton btnQuantit) {
        btnQuantit.setEnabled(true);
        btnQuantit.setVisible(true);

        btnIntensit.setEnabled(true);
        btnIntensit.setVisible(true);

        btnDeuxtasses.setEnabled(true);
        btnDeuxtasses.setVisible(true);
    }

    public static void enableBoisson(JButton btnAmericano, JButton btnCafe, JButton btnCafeLait,
                                     JButton btnCappuccino, JButton btnEauChaude, JButton btnExpresso) {
        btnExpresso.setEnabled(true);
        btnExpresso.setVisible(true);

        btnCafe.setEnabled(true);
        btnCafe.setVisible(true);

        btnCafeLait.setEnabled(true);
        btnCafeLait.setVisible(true);

        btnCappuccino.setEnabled(true);
        btnCappuccino.setVisible(true);

        btnEauChaude.setEnabled(true);
        btnEauChaude.setVisible(true);

        btnAmericano.setEnabled(true);
        btnAmericano.setVisible(true);
    }

    public static void choixParametreParDefautBoisson(JButton btnDeuxtasses, JButton btnStartStop,
                                                      JTextArea textArea_MessageEcran, JTextField textField_Choice,
                                                      JTextField textField_Intensite, JTextField textField_Quantite) {

        textField_Choice.setText("Expresso");
        textField_Quantite.setText("Petit");
        textField_Intensite.setText("Doux");
        textArea_MessageEcran.setText(null);
        textArea_MessageEcran.setText("");
        btnDeuxtasses.setSelected(true);
        btnDeuxtasses.setBackground(new Color(51, 51, 51));
        btnStartStop.setText("Start/Stop");
    }

    public static void disableOtherFunction(JButton btnAmericano, JButton btnBas, JButton btnCafe, JButton btnCafeLait,
                                            JButton btnCappuccino, JButton btnDeuxtasses, JButton btnEauChaude,
                                            JButton btnExpresso, JButton btnFavorisSecurite, JButton btnIntensit,
                                            JButton btnMenu, JButton btnOk, JButton btnQuantit, JButton btnRetour,
                                            JTextField textField_Choice, JTextField textField_Quantite, JTextField textField_Intensite) {
        btnIntensit.setEnabled(false);
        btnQuantit.setEnabled(false);
        btnDeuxtasses.setEnabled(false);

        btnMenu.setEnabled(false);
        btnBas.setEnabled(false);
        btnOk.setEnabled(true);
        btnRetour.setEnabled(false);

        btnExpresso.setEnabled(false);
        btnCafe.setEnabled(false);
        btnCafeLait.setEnabled(false);
        btnCappuccino.setEnabled(false);
        btnEauChaude.setEnabled(false);
        btnAmericano.setEnabled(false);
        btnFavorisSecurite.setEnabled(false);

    }



    public static void resetMachine(JButton btnAmericano, JButton btnBas, JButton btnCafe, JButton btnCafeLait,
                                    JButton btnCappuccino, JButton btnDeuxtasses, JButton btnEauChaude,
                                    JButton btnExpresso, JButton btnFavorisSecurite, JButton btnIntensit,
                                    JButton btnMenu, JButton btnOk, JButton btnQuantit, JButton btnRetour,
                                    JButton btnStartStop, JProgressBar progressBar, JTextArea textArea_MessageEcran,
                                    JTextField textField_Choice, JTextField textField_Intensite,
                                    JTextField textField_Quantite, Timer timer) {

        enableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);

        enableComposante(progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer);

        enableParametre(btnDeuxtasses, btnIntensit, btnQuantit);

        enableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);

        choixParametreParDefautBoisson(btnDeuxtasses, btnStartStop, textArea_MessageEcran, textField_Choice,
                textField_Intensite, textField_Quantite);

    }

    public static void operationSousMenuNettoyage(JButton btnBas, JButton btnMenu, JButton btnOk, JButton btnRetour,
                                                  JButton btnStartStop, JProgressBar progressBar,
                                                  JTextArea textArea_MessageEcran, JTextField textField_Choice,
                                                  JTextField textField_Intensite, JTextField textField_Quantite) {
        btnBas.setEnabled(false);
        btnRetour.setVisible(true);
        btnRetour.setEnabled(true);
        textField_Choice.setText(null);
        textField_Quantite.setText(null);
        textField_Intensite.setText(null);
        textArea_MessageEcran.setText(" Pour lancer le programme Nettoyage, \n\n Appuyer sur (Start/Stop) \n\n Et suivez les instructions sur l'écran.  \n\n (Le programme dure +/- 9min) \n \n En 6 étapes ");
        textField_Choice.setText("Nettoyage");

        btnStartStop.setEnabled(true);
        btnStartStop.setText("Start/Stop");
        progressBar.setVisible(true);
        progressBar.setEnabled(true);
        btnOk.setEnabled(false);
        btnMenu.setEnabled(false);
    }

    public static void operationSousMenuDetartrage(JButton btnBas, JButton btnMenu, JButton btnOk, JButton btnRetour,
                                                   JButton btnStartStop, JProgressBar progressBar,
                                                   JTextArea textArea_MessageEcran, JTextField textField_Choice,
                                                   JTextField textField_Intensite, JTextField textField_Quantite, boolean detartrageAccompli) {

        btnBas.setEnabled(false);
        btnRetour.setVisible(true);
        btnRetour.setEnabled(true);
        textField_Choice.setText(null);
        textField_Quantite.setText(null);
        textField_Intensite.setText(null);
        textArea_MessageEcran.setText(" Pour lancer le programme Detartrer, \n\n Appuyer sur (Start/Stop) \n\n Et suivez les instructions sur l'écran.  \n\n (Le programme dure +/- 21min) \n \n En 10 étapes ");
        textField_Choice.setText("Détartrage");

        btnStartStop.setEnabled(true);
        btnStartStop.setText("Start/Stop");
        progressBar.setVisible(true);
        progressBar.setEnabled(true);
        btnOk.setEnabled(false);
        btnMenu.setEnabled(false);

    }

    public static void operationSousMenuCaclNClean(JButton btnBas, JButton btnMenu, JButton btnOk, JButton btnRetour,
                                                   JButton btnStartStop, JProgressBar progressBar,
                                                   JTextArea textArea_MessageEcran, JTextField textField_Choice,
                                                   JTextField textField_Intensite, JTextField textField_Quantite) {
        btnBas.setEnabled(false);
        btnRetour.setVisible(true);
        btnRetour.setEnabled(true);
        textField_Choice.setText(null);
        textField_Quantite.setText(null);
        textField_Intensite.setText(null);
        textArea_MessageEcran.setText(" Pour lancer le programme calc'nClean, \n\n Appuyer sur (Start/Stop) \n\n Et suivez les instructions sur l'écran. \n\n (Le programme dure +/- 43min) \n\n En 12 étapes ");
        textField_Choice.setText("calc'nClean");

        btnStartStop.setEnabled(true);
        btnStartStop.setText("Start/Stop");
        progressBar.setVisible(true);
        progressBar.setEnabled(true);
        btnOk.setEnabled(false);
        btnMenu.setEnabled(false);
    }

    public static void operationSousMenuNettoyerMousseur(JButton btnBas, JButton btnMenu, JButton btnOk,
                                                         JButton btnRetour, JButton btnStartStop,
                                                         JProgressBar progressBar, JTextArea textArea_MessageEcran,
                                                         JTextField textField_Choice, JTextField textField_Intensite,
                                                         JTextField textField_Quantite, JButton btnQuantit,
                                                         JButton btnIntensit, JButton btnDeuxtasses) {
        btnBas.setEnabled(false);
        btnRetour.setVisible(true);
        btnRetour.setEnabled(true);
        textField_Choice.setText(null);
        textField_Quantite.setText(null);
        textField_Intensite.setText(null);
        textArea_MessageEcran.setText(" Pour lancer le Nettoyage du mousseur, \n\n Appuyer sur (Start/Stop), \n\n et suivez les instructions sur l'écran.  \n\n (Le programme est rapide, en 3 étapes) \n\n (Retour) pour sortir.");
        textField_Choice.setText("Nettoyer le mousseur de lait");

        btnStartStop.setEnabled(true);
        btnStartStop.setText("Start/Stop");
        progressBar.setVisible(true);
        progressBar.setEnabled(true);
        btnOk.setEnabled(false);
        btnMenu.setEnabled(false);
        btnIntensit.setEnabled(false);
        btnQuantit.setEnabled(false);
        btnDeuxtasses.setEnabled(false);
        desableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);

    }



}
