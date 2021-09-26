package daniKazzoul.view;

import javax.swing.*;
import java.awt.*;

public class RetourBouttonView {

    // use Singleton design pattern
    private RetourBouttonView() {}; // make constructor invisible to clients
    private static RetourBouttonView instance = null;
    public static RetourBouttonView getInstance() {
        if(instance == null) instance = new RetourBouttonView();
        return instance;
    }

    /** Retour
     * @param simulateurView*****************************************************************************************/
    public static void createRetourButton(SimulateurView simulateurView) {
        AbstractView.btnRetour = new JButton("Retour");
        //btnRetour.setIcon(new ImageIcon("icon//Retour.png"));

        AbstractView.btnRetour.setFont(new Font("Dialog", Font.BOLD, 24));
        AbstractView.btnRetour.setBounds(150, 222, 120, 120);

        simulateurView.frame.getContentPane().add(AbstractView.btnRetour);


        /** *********************************************************************************
         *******    Gestion des clicks sur le button Retour et entre les sous menu   ******
         **********************************************************************************/

        AbstractView.btnRetour.addActionListener(e -> {

            /* ******************  sortie vers l'ecran         *******************************************/


            if (AbstractView.textField_Choice.getText().equals("Menu Principal")
                    || AbstractView.textField_Choice.getText().equals("Expresso") || AbstractView.textField_Choice.getText().equals("Cafe")
                    || AbstractView.textField_Choice.getText().equals("CafeLait") || AbstractView.textField_Choice.getText().equals("Cappuccino")
                    || AbstractView.textField_Choice.getText().equals("EauChaude") || AbstractView.textField_Choice.getText().equals("Americano")  ) {

                OperationsView.resetMachine(AbstractView.btnAmericano, AbstractView.btnBas, AbstractView.btnCafe, AbstractView.btnCafeLait, AbstractView.btnCappuccino, AbstractView.btnDeuxtasses, AbstractView.btnEauChaude,
                        AbstractView.btnExpresso, AbstractView.btnFavorisSecurite, AbstractView.btnIntensit, AbstractView.btnMenu, AbstractView.btnOk, AbstractView.btnQuantit, AbstractView.btnRetour,
                        AbstractView.btnStartStop, AbstractView.progressBar, AbstractView.textArea_MessageEcran, AbstractView.textField_Choice, AbstractView.textField_Intensite, AbstractView.textField_Quantite,
                        AbstractView.timer);

                //    textField_Quantite.setText("R1 ="+nettoyerMousseurAccompli);

            }

            /* ******************  Retour vers sous menu Principal          *******************************************/

            else if (AbstractView.textField_Choice.getText().equals("Maintenance") || AbstractView.textField_Choice.getText().equals("Favori")) {
                //    System.out.println("Maintenance " + selectionChoixMenu);
                AbstractView.textField_Choice.setText("Menu Principal");
                AbstractView.textArea_MessageEcran.setText("\n (Bas) = se deplacer vers le bas, \n\n (Ok) = confirmer/mémoriser, \n\n (Retour) = revenir en arrière \n\n (menu) = pour quitter!");

                //     textField_Quantite.setText("R2 ="+nettoyerMousseurAccompli);

            }

            /* ******************   Retour vers sous menu Maintenance          *******************************************/

            else if (AbstractView.textField_Choice.getText().equals("Nettoyer le mousseur de lait") || AbstractView.textField_Choice.getText().equals("Détartrage")
                    || AbstractView.textField_Choice.getText().equals("Nettoyage") || AbstractView.textField_Choice.getText().equals("calc'nClean")) {

                AbstractView.btnOk.setEnabled(true);

                AbstractView.nettoyageAccompli = true;
                AbstractView.detartrageAccompli = true;
                AbstractView.nettoyerMousseurAccompli = true;
                AbstractView.calcNCleanAccompli = true;

                OperationsView.resetMachine(AbstractView.btnAmericano, AbstractView.btnBas, AbstractView.btnCafe, AbstractView.btnCafeLait, AbstractView.btnCappuccino, AbstractView.btnDeuxtasses, AbstractView.btnEauChaude,
                        AbstractView.btnExpresso, AbstractView.btnFavorisSecurite, AbstractView.btnIntensit, AbstractView.btnMenu, AbstractView.btnOk, AbstractView.btnQuantit, AbstractView.btnRetour,
                        AbstractView.btnStartStop, AbstractView.progressBar, AbstractView.textArea_MessageEcran, AbstractView.textField_Choice, AbstractView.textField_Intensite, AbstractView.textField_Quantite,
                        AbstractView.timer);

                //    textField_Quantite.setText("R3 ="+nettoyerMousseurAccompli);

            }

            /* ******************   Retour vers sous menu Favori          *******************************************/

            else if (  AbstractView.textArea_MessageEcran.getText().equals(" Profile 1, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser")
                    || AbstractView.textArea_MessageEcran.getText().equals(" Profile 2, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser")) {

                //        System.out.println("Favori " + selectionChoixMenu);
                AbstractView.textField_Choice.setText("Favori");
                AbstractView.textArea_MessageEcran.setText(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Favori, \n\n\n (Ok) pour valider");

                simulateurView.selectionChoixMenu = 1;
                AbstractView.btnBas.setEnabled(true);
                AbstractView.btnFavorisSecurite.setEnabled(true);
//                btnOk.setEnabled(true);
//                btnMenu.setEnabled(true);

                //    textField_Quantite.setText("R4 ="+nettoyerMousseurAccompli);

            }

            else if ( AbstractView.textField_Choice.getText().equals("Profile 2") || AbstractView.textField_Choice.getText().equals("Profile 1")   ) {
                AbstractView.textField_Choice.setText("Favori");
                simulateurView.selectionChoixMenu = 1;

                //    textField_Quantite.setText("R5 ="+nettoyerMousseurAccompli);

            }


        });

    }
}
