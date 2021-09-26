package daniKazzoul.view;

import daniKazzoul.components.ProgressFavoris;
import daniKazzoul.controller.DonneeFavorisController;
import daniKazzoul.model.EntretientReservoirModel;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static daniKazzoul.view.AbstractView.*;
import static daniKazzoul.view.OperationsView.desableTableauBord;

public class OkBouttonView {

    // use Singleton design pattern
    private OkBouttonView() {} // make constructor invisible to clients
    private static OkBouttonView instance = null;
    public static OkBouttonView getInstance() {
        if(instance == null) instance = new OkBouttonView();
        return instance;
    }

    /** Ok
     * @param simulateurView*****************************************************************************************/

    public static void createOKButton(SimulateurView simulateurView) {

        btnOk = new JButton("Ok");
        btnOk.setFont(new Font("Dialog", Font.BOLD, 24));
        btnOk.setBounds(690, 222, 120, 120);
        simulateurView.frame.getContentPane().add(btnOk);

        /** *********************************************************************************
         **********        Gestion des clicks sur le button Ok,
         **********************************************************************************/

        btnOk.addActionListener(e -> {


/** ****************     Les resets des Reservoirs apres l'entretient ****************************************/

            if (simulateurView.entretientAction == 1) {
                EntretientReservoirModel.getInstance().remplireEau();
                simulateurView.entretientAction = 0;

            } else if (simulateurView.entretientAction == 2) {
                EntretientReservoirModel.getInstance().viderBac();
                simulateurView.entretientAction = 0;

            } else if (simulateurView.entretientAction == 3) {
                EntretientReservoirModel.getInstance().remplireGraine();
                simulateurView.entretientAction = 0;

            } else if (simulateurView.entretientAction == 12) {
                EntretientReservoirModel.getInstance().remplireEau();
                EntretientReservoirModel.getInstance().viderBac();
                simulateurView.entretientAction = 0;

            } else if (simulateurView.entretientAction == 13) {
                EntretientReservoirModel.getInstance().remplireEau();
                EntretientReservoirModel.getInstance().remplireGraine();
                simulateurView.entretientAction = 0;

            } else if (simulateurView.entretientAction == 23) {
                EntretientReservoirModel.getInstance().viderBac();
                EntretientReservoirModel.getInstance().remplireGraine();
                simulateurView.entretientAction = 0;

            } else if (simulateurView.entretientAction == 123) {
                EntretientReservoirModel.getInstance().remplireEau();
                EntretientReservoirModel.getInstance().viderBac();
                EntretientReservoirModel.getInstance().remplireGraine();
                simulateurView.entretientAction = 0;
            }


//---------------- Click (Ok) lors de la navigation dans les sous menu Maintenance et leurs possibilités  --------------

            else if (textField_Choice.getText().equals("Maintenance") /* && entretientAction > 0 */ ) {

                textArea_MessageEcran.setText(" Appuyer sur (Bas), \n\n pour se déplacer, \n\n dans le sous menu maintenance \n\n\n (Ok) pour valider ");

            }

//---------------- Click lors de la navigation dans les sous menu favoris et leurs possibilités

            else if (textArea_MessageEcran.getText().equals(" Appuyer sur (Ok), \n\n pour entrer dans le menu Favori")) {
                textArea_MessageEcran.setText(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Favori, \n\n\n (Ok) pour valider");

            }


/** Click (Ok) dirigé vers sous-menu nettoyer mousseur de lait (sans redirection)  ************************************/

            else if (textField_Choice.getText().equals("Nettoyer le mousseur de lait")) {
                OperationsView.operationSousMenuNettoyerMousseur(btnBas, btnMenu, btnOk, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, btnQuantit, btnIntensit, btnDeuxtasses);
                nettoyerMousseurAccompli = false;
                NettoyageMousseurView.getInstance().clickStartStopNettoyageMousseur1();

            }


/** Click (Ok) dirigé vers sous-menu Nettoyage (sans redirection) *****************************************************/
            else if (textField_Choice.getText().equals("Nettoyage")) {
                OperationsView.operationSousMenuNettoyage(btnBas, btnMenu, btnOk, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite);
                nettoyageAccompli = false;
                NettoyageView.getInstance().clickStartStopNettoyage1();
            }

/** dirigé automatiquement vers sous-menu nettoyage (avec redirection automatique) */

            if (textField_Choice.getText().equals("Nettoyage necessaire")  ) {
                OperationsView.operationSousMenuNettoyage(btnBas, btnMenu, btnOk, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite);
                btnRetour.setEnabled(false);
                NettoyageView.getInstance().clickStartStopNettoyage1();

            }



/** Click (Ok) dirigé vers sous-menu Detartrage (sans redirection)  ***************************************************/

            else if (textField_Choice.getText().equals("Détartrage")) {
                detartrageAccompli = false;
                OperationsView.operationSousMenuDetartrage(btnBas, btnMenu, btnOk, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, detartrageAccompli);
                DetartrageView.getInstance().clickStartStopDetartrage1();

            }

/** dirigé automatiquement vers sous-menu detartrage (avec redirection automatique) */

            if ( textField_Choice.getText().equals("Detartrage necessaire") ) {
                OperationsView.operationSousMenuDetartrage(btnBas, btnMenu, btnOk, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, detartrageAccompli);
                btnRetour.setEnabled(false);
                DetartrageView.getInstance().clickStartStopDetartrage1();

            }

/** Click (Ok) dirigé vers sous-menu calcNClean (sans redirection) ****************************************************/

            else if (textField_Choice.getText().equals("calc'nClean")) {
                OperationsView.operationSousMenuCaclNClean(btnBas, btnMenu, btnOk, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite);
                calcNCleanAccompli = false;
                CalcNCleanView.getInstance().clickStartStopCalcNClean1();

            }

/** dirigé automatiquement vers sous-menu calcNClean (avec redirection automatique) */

            if (textField_Choice.getText().equals("calc'nClean necessaire") ) {
                OperationsView.operationSousMenuCaclNClean(btnBas, btnMenu, btnOk, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite);
                btnRetour.setEnabled(false);
                CalcNCleanView.getInstance().clickStartStopCalcNClean1();

            }

// Click (Ok), reset apres les programme de maintenance ----------------------------------------------------------------

            else if ( textField_Choice.getText().equals("Nettoyage fini")
                    || textField_Choice.getText().equals("Nettoyage Mousseur de lait fini")
                    || textField_Choice.getText().equals("Détartrage fini")
                    || textField_Choice.getText().equals("calc'nClean fini")  ){

                OperationsView.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude,
                        btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit, btnRetour, btnStartStop,
                        progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer);

            }




//----------------------------------------------------------------------------------------------------------------
// Profile 1
            else if (textField_Choice.getText().equals("Profile 1")) {
                textArea_MessageEcran.setText(" Profile 1, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser");
                textField_Choice.setText("Expresso");
                textField_Intensite.setVisible(true);
                textField_Quantite.setVisible(true);
                textField_Quantite.setText("Petit");
                textField_Intensite.setText("Doux");
                OperationsView.enableComposante(progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer);
                OperationsView.enableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
                OperationsView.enableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
                btnFavorisSecurite.setEnabled(false);
                btnBas.setEnabled(false);

            }
            else if (textArea_MessageEcran.getText().equals(" Profile 1, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser")) {

                DonneeFavorisController donneeFavori1 = DonneeFavorisController.getInstance();
                donneeFavori1.boisson = textField_Choice.getText();
                donneeFavori1.quantite = textField_Quantite.getText();
                donneeFavori1.intensite = textField_Intensite.getText();
                donneeFavori1.deuxTasses = selected;
                ProgressFavoris progressFavoris1 = new ProgressFavoris(progressBar, textArea_MessageEcran, btnFavorisSecurite, btnOk);

                try {
                    FileOutputStream fileOut1 = new FileOutputStream("dataFavori/boisson1.xml");
                    ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
                    out1.writeObject(donneeFavori1);
                    out1.close();
                    fileOut1.close();

                    desableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);
                    textArea_MessageEcran.setEnabled(true);
                    textArea_MessageEcran.setText("Vous avez enregistré :\n\n La Boisson pour profile 1 :" + textField_Choice.getText() + "" +
                            "\n\n Quantité :" + textField_Quantite.getText() + "\n\n Intensité :" + textField_Intensite.getText() + "" +
                            "\n\n Deux Tasses : " + selected);
                    btnFavorisSecurite.setEnabled(false);

                    progressFavoris1.execute();
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }

// Profile 2 -----------------------
            else if (textField_Choice.getText().equals("Profile 2")) {
                textArea_MessageEcran.setText(" Profile 2, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser");
                textField_Choice.setText("Expresso");
                textField_Intensite.setVisible(true);
                textField_Quantite.setVisible(true);
                textField_Quantite.setText("Petit");
                textField_Intensite.setText("Doux");
                OperationsView.enableComposante(progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer);
                OperationsView.enableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
                OperationsView.enableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
                btnFavorisSecurite.setEnabled(false);
                btnBas.setEnabled(false);

            }

            else if (textArea_MessageEcran.getText().equals(" Profile 2, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser")) {
                DonneeFavorisController donneeFavori2 = DonneeFavorisController.getInstance();
                donneeFavori2.boisson = textField_Choice.getText();
                donneeFavori2.quantite = textField_Quantite.getText();
                donneeFavori2.intensite = textField_Intensite.getText();
                donneeFavori2.deuxTasses = selected;

                ProgressFavoris progressFavoris2 = new ProgressFavoris(progressBar, textArea_MessageEcran, btnFavorisSecurite, btnOk);

                try {
                    FileOutputStream fileOut2 = new FileOutputStream("dataFavori/boisson2.xml");
                    ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
                    out2.writeObject(donneeFavori2);
                    out2.close();
                    fileOut2.close();

                    desableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);

                    textArea_MessageEcran.setEnabled(true);
                    textArea_MessageEcran.setText("Vous avez enregistré :\n\n La Boisson pour profile 2 :" + textField_Choice.getText() + "" +
                            "\n\n Quantité :" + textField_Quantite.getText() + "\n\n Intensité :" + textField_Intensite.getText() + "" +
                            "\n\n Deux Tasses : " + selected);

                    btnFavorisSecurite.setEnabled(false);
                    progressFavoris2.execute();
                } catch (IOException i) {
                    i.printStackTrace();
                }

            }

//------ le click (ok) qui réinisialise la machine apres avoir reçu un message d'etretient---------------------------

            else if (textField_Choice.getText().equals("Expresso") || textField_Choice.getText().equals("Cafe")
                    || textField_Choice.getText().equals("CafeLait") || textField_Choice.getText().equals("Cappuccino")
                    || textField_Choice.getText().equals("EauChaude") || textField_Choice.getText().equals("Americano") ) {

                OperationsView.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude,
                        btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit, btnRetour, btnStartStop,
                        progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite,
                        timer);

            }

        });

    }
}
