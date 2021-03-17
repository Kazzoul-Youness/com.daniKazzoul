package daniKazzoul.controller;

import javax.swing.*;

public class OperationControlleur {

    // - Singleton Pattern
    private static final OperationControlleur instance = new OperationControlleur();

    //constructeur privé pour éviter que les applications clientes utilisent le constructeur
    private OperationControlleur(){  }

    public static OperationControlleur getInstance(){  return instance;  }


    /************** Les operations desactivation ****************************/

    public static void desableTableauBord(JButton btnBas, JButton btnMenu, JButton btnOk, JButton btnRetour, JButton btnStartStop) {
        btnStartStop.setEnabled(false);
        btnMenu.setEnabled(false);
        btnOk.setEnabled(false);
        btnBas.setEnabled(false);
        btnRetour.setEnabled(false);
    }

    public static void desableComposante(JButton btnFavorisSecurite, JProgressBar progressBar, JTextArea textArea_MessageEcran, JTextField textField_Choice, JTextField textField_Intensite, JTextField textField_Quantite) {
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

    public static void desableBoisson(JButton btnAmericano, JButton btnCafe, JButton btnCafeLait, JButton btnCappuccino, JButton btnEauChaude, JButton btnExpresso) {
        btnExpresso.setEnabled(false);
        btnCafe.setEnabled(false);
        btnCafeLait.setEnabled(false);
        btnCappuccino.setEnabled(false);
        btnEauChaude.setEnabled(false);
        btnAmericano.setEnabled(false);
    }

    /************** Les operations enabling
     * @param btnBas
     * @param btnMenu
     * @param btnOk
     * @param btnRetour
     * @param btnStartStop
     * **/

    public static void enableTableauBord(JButton btnBas, JButton btnMenu, JButton btnOk, JButton btnRetour, JButton btnStartStop) {
        btnStartStop.setEnabled(true);
        btnMenu.setEnabled(true);
        btnOk.setEnabled(true);
        btnBas.setEnabled(true);
        btnRetour.setEnabled(true);
    }

    public static void enableComposante(JButton btnFavorisSecurite, JProgressBar progressBar, JTextArea textArea_MessageEcran, JTextField textField_Choice, JTextField textField_Intensite, JTextField textField_Quantite, Timer timer, Timer timer1, Timer timer2, Timer timer3, Timer timer4, Timer timer5, Timer timer6) {
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
        timer.stop(); timer1.stop(); timer2.stop();
        timer3.stop();
        timer4.stop();
        timer5.stop();
        timer6.stop();

        btnFavorisSecurite.setVisible(true);
        btnFavorisSecurite.setEnabled(true);
    }

    public static void ensableParametre(JButton btnDeuxtasses, JButton btnIntensit, JButton btnQuantit) {
        btnQuantit.setEnabled(true);
        btnQuantit.setVisible(true);

        btnIntensit.setEnabled(true);
        btnIntensit.setVisible(true);

        btnDeuxtasses.setEnabled(true);
        btnDeuxtasses.setVisible(true);
    }

    public static void ensableBoisson(JButton btnAmericano, JButton btnCafe, JButton btnCafeLait, JButton btnCappuccino, JButton btnEauChaude, JButton btnExpresso) {
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

    public static void choixParametreParDefautBoisson(JButton btnDeuxtasses, JButton btnStartStop, JTextArea textArea_MessageEcran, JTextField textField_Choice, JTextField textField_Intensite, JTextField textField_Quantite) {
        textField_Choice.setEnabled(true);
        textField_Intensite.setEnabled(true);
        textField_Quantite.setEnabled(true);

        textField_Choice.setText("Expresso");
        textField_Quantite.setText("petit");
        textField_Intensite.setText("doux");
        textArea_MessageEcran.setText(null);
        textArea_MessageEcran.setText("");
        btnDeuxtasses.setSelected(true);
        btnStartStop.setText("Start/Stop");
    }

    /**
     * @param btnAmericano
     * @param btnBas
     * @param btnCafe
     * @param btnCafeLait
     * @param btnCappuccino
     * @param btnDeuxtasses
     * @param btnEauChaude
     * @param btnExpresso
     * @param btnFavorisSecurite
     * @param btnIntensit
     * @param btnMenu
     * @param btnQuantit
     * @param btnRetour
     * @param btnStartStop
     **/

    public static void enableAllFunctions(JButton btnAmericano, JButton btnBas, JButton btnCafe, JButton btnCafeLait, JButton btnCappuccino, JButton btnDeuxtasses, JButton btnEauChaude, JButton btnExpresso, JButton btnFavorisSecurite, JButton btnIntensit, JButton btnMenu, JButton btnQuantit, JButton btnRetour, JButton btnStartStop) {
        btnIntensit.setEnabled(true);
        btnStartStop.setEnabled(true);
        btnBas.setEnabled(true);
        btnFavorisSecurite.setEnabled(true);
        btnMenu.setEnabled(true);
        btnQuantit.setEnabled(true);
        btnRetour.setEnabled(true);
        btnDeuxtasses.setEnabled(true);

        btnAmericano.setEnabled(true);
        btnCappuccino.setEnabled(true);
        btnEauChaude.setEnabled(true);
        btnCafeLait.setEnabled(true);
        btnCafe.setEnabled(true);
        btnExpresso.setEnabled(true);
    }

    public static void disableOtherFunction(JButton btnAmericano, JButton btnBas, JButton btnCafe, JButton btnCafeLait, JButton btnCappuccino, JButton btnDeuxtasses, JButton btnEauChaude, JButton btnExpresso, JButton btnFavorisSecurite, JButton btnIntensit, JButton btnMenu, JButton btnOk, JButton btnQuantit, JButton btnRetour) {
        btnIntensit.setEnabled(false);
        /*btnStartStop.setEnabled(false);*/
        btnBas.setEnabled(false);
        btnAmericano.setEnabled(false);
        btnCappuccino.setEnabled(false);
        btnEauChaude.setEnabled(false);
        btnFavorisSecurite.setEnabled(false);
        btnMenu.setEnabled(false);
        btnQuantit.setEnabled(false);
        btnRetour.setEnabled(false);
        btnDeuxtasses.setEnabled(false);
        btnCafeLait.setEnabled(false);
        btnCafe.setEnabled(false);
        btnExpresso.setEnabled(false);
        btnOk.setEnabled(true);
    }

    /** - Reset Machine
     * @param btnAmericano
     * @param btnBas
     * @param btnCafe
     * @param btnCafeLait
     * @param btnCappuccino
     * @param btnDeuxtasses
     * @param btnEauChaude
     * @param btnExpresso
     * @param btnFavorisSecurite
     * @param btnIntensit
     * @param btnMenu
     * @param btnOk
     * @param btnQuantit
     * @param btnRetour
     * @param btnStartStop
     * @param progressBar
     * @param textArea_MessageEcran
     * @param textField_Choice
     * @param textField_Intensite
     * @param textField_Quantite
     * @param timer
     * @param timer1
     * @param timer2
     * @param timer3
     * @param timer4
     * @param timer5
     * @param timer6
     * **/

    public static void resetMachine(JButton btnAmericano, JButton btnBas, JButton btnCafe, JButton btnCafeLait, JButton btnCappuccino, JButton btnDeuxtasses, JButton btnEauChaude, JButton btnExpresso, JButton btnFavorisSecurite, JButton btnIntensit, JButton btnMenu, JButton btnOk, JButton btnQuantit, JButton btnRetour, JButton btnStartStop, JProgressBar progressBar, JTextArea textArea_MessageEcran, JTextField textField_Choice, JTextField textField_Intensite, JTextField textField_Quantite, Timer timer, Timer timer1, Timer timer2, Timer timer3, Timer timer4, Timer timer5, Timer timer6) {
        enableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);
        enableComposante(btnFavorisSecurite, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);
        ensableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
        ensableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
        choixParametreParDefautBoisson(btnDeuxtasses, btnStartStop, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite);
    }
}
