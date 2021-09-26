package daniKazzoul.view;

import daniKazzoul.components.BandeauCommande;
import daniKazzoul.model.EntretientReservoirModel;
import daniKazzoul.model.MaintenanceProgrammeModel;

import javax.swing.*;
import java.awt.*;

public class BasBouttonView {

    // use Singleton design pattern
    private BasBouttonView() {}; // make constructor invisible to clients
    private static BasBouttonView instance = null;
    public static BasBouttonView getInstance() {
        if(instance == null) instance = new BasBouttonView();
        return instance;
    }

    /** Bas
     * @param simulateurView*******************************************************************************************/

    public static void createBasButton(SimulateurView simulateurView) {
        AbstractView.btnBas = new JButton("Bas");
        //    btnBas.setIcon(new ImageIcon("icon//bas.png"));

        AbstractView.btnBas.setFont(new Font("Dialog", Font.BOLD, 20));
        AbstractView.btnBas.setBounds(362, 145, 249, 65);
        simulateurView.frame.getContentPane().add(AbstractView.btnBas);

        /** *********************************************************************************
         **********        Gestion des clicks sur le button Bas,
         **********************************************************************************/

        AbstractView.btnBas.addActionListener(e -> {

            if (AbstractView.textArea_MessageEcran.getText().equals(" Appuyer sur (Bas), \n\n pour se déplacer, \n\n dans le sous menu maintenance \n\n\n (Ok) pour valider ")  ) {
                BandeauCommande.getInstance().sousMenuMaintenance(simulateurView);
                AbstractView.btnOk.setVisible(true);
                AbstractView.btnOk.setEnabled(true);
            }
            else if (AbstractView.textArea_MessageEcran.getText().equals(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Favori, \n\n\n (Ok) pour valider")  ) {
                BandeauCommande.getInstance().sousMenuFavori(simulateurView);
                AbstractView.btnOk.setVisible(true);
                AbstractView.btnOk.setEnabled(true);
            }

            // l'appel du boutton (Bas) apres avoir clické sur le boutton favorisSecurite, on reset
            // affichage combien de boisson reste encore avant la maintenance : Nettoyage et Detartrer

            else if ( simulateurView.afficherInfoAvant ==0 && ( !AbstractView.textField_Choice.getText().equals("Menu Principal") && !AbstractView.textField_Choice.getText().equals("Maintenance") && !AbstractView.textField_Choice.getText().equals("Favori") ) ) {

                int boissonRestantAvantNettoyage = 2 - MaintenanceProgrammeModel.getInstance().getCptNettoyage();
                int boissonRestantAvantDetartrage = 3 - MaintenanceProgrammeModel.getInstance().getCptDetartrage();
                int boissonRestantAvantCalcNClean = 6 - MaintenanceProgrammeModel.getInstance().getCptCalcNClean();
                int boissonRestantAvantEau = 2 - EntretientReservoirModel.getInstance().getCptEau();
                int boissonRestantAvantBac = 3 - EntretientReservoirModel.getInstance().getCptBac();
                int boissonRestantAvantGraines = 4 - EntretientReservoirModel.getInstance().getCptGraine();

                AbstractView.textField_Choice.setText("Informations Maintenance-Entretient");
                AbstractView.textArea_MessageEcran.setText(" Remplissage reservoir d'eau dans ----> "+boissonRestantAvantEau+" tasses\n"+
                        " Vidang du bac collecteur dans       ----> "+boissonRestantAvantBac+" tasses\n"+
                        " Remplissage des graines café        ----> "+boissonRestantAvantGraines+" tasses\n\n"+
                        " Nettoyaye dans      ----> "+boissonRestantAvantNettoyage+ " tasses\n" +
                        " Détartrage dans     ----> "+boissonRestantAvantDetartrage+ " tasses\n" +
                        " calc'nClean dans    ----> "+boissonRestantAvantCalcNClean+ " tasses\n\n" );
                simulateurView.afficherInfoAvant =1;
                AbstractView.btnStartStop.setEnabled(false);
            }
            else if (simulateurView.afficherInfoAvant == 1){
                AbstractView.textArea_MessageEcran.setText(null);
                AbstractView.textField_Choice.setText("Expresso");
                simulateurView.afficherInfoAvant =0;
                AbstractView.btnStartStop.setEnabled(true);
            }

            else {
                BandeauCommande.actionMenuPrincipal(simulateurView);
                AbstractView.btnOk.setVisible(true);
                AbstractView.btnOk.setEnabled(true);
            }

        });

    }
}
