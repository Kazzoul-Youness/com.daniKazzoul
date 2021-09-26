package daniKazzoul.view;

import javax.swing.*;
import java.awt.*;

import static daniKazzoul.view.OperationsView.*;

public class MenuBouttonView {

    // use Singleton design pattern
    private MenuBouttonView() {}; // make constructor invisible to clients
    private static MenuBouttonView instance = null;
    public static MenuBouttonView getInstance() {
        if(instance == null) instance = new MenuBouttonView();
        return instance;
    }

    /** Menu
     * @param simulateurView*****************************************************************************************/
    public static void createButtonMenu(SimulateurView simulateurView) {
        AbstractView.btnMenu = new JButton("Menu");
        //btnMenu.setIcon(new ImageIcon("icon//Menu.png"));

        AbstractView.btnMenu.setFont(new Font("Dialog", Font.BOLD, 24));
        AbstractView.btnMenu.setBounds(867, 222, 120, 120);
        simulateurView.frame.getContentPane().add(AbstractView.btnMenu);


        /**********************************************************************************
         ********************      Gestion des clicks sur le button menu           *********
         ***********************************************************************************/

        AbstractView.btnMenu.addActionListener(e -> {

            /* ***********************       Reset de la machine                   ***************************************/
            if (AbstractView.textField_Choice.getText().equals("Expresso") || AbstractView.textField_Choice.getText().equals("Cafe")
                    || AbstractView.textField_Choice.getText().equals("CafeLait") || AbstractView.textField_Choice.getText().equals("Cappuccino")
                    || AbstractView.textField_Choice.getText().equals("EauChaude") || AbstractView.textField_Choice.getText().equals("Americano")) {
                //        System.out.println(" selectionChoixMenu if1 :"+ selectionChoixMenu+" : "+nettoyageAccompli);

                desableTableauBord(AbstractView.btnBas, AbstractView.btnMenu, AbstractView.btnOk, AbstractView.btnRetour, AbstractView.btnStartStop);
                OperationsView.desableComposante(AbstractView.btnFavorisSecurite, AbstractView.progressBar, AbstractView.textArea_MessageEcran, AbstractView.textField_Choice, AbstractView.textField_Intensite, AbstractView.textField_Quantite);
                desableParametre(AbstractView.btnDeuxtasses, AbstractView.btnIntensit, AbstractView.btnQuantit);
                desableBoisson(AbstractView.btnAmericano, AbstractView.btnCafe, AbstractView.btnCafeLait, AbstractView.btnCappuccino, AbstractView.btnEauChaude, AbstractView.btnExpresso);
                AbstractView.textArea_MessageEcran.setEnabled(true);
                AbstractView.textArea_MessageEcran.setText("\n (Bas) = se deplacer vers le bas, \n\n (Ok) = confirmer/mémoriser, \n\n (Retour) = revenir en arrière \n\n (menu) = pour quitter!");
                AbstractView.textField_Choice.setEnabled(true);
                AbstractView.textField_Choice.setText("Menu Principal");
                AbstractView.btnRetour.setEnabled(true);
                AbstractView.btnBas.setEnabled(true);
                AbstractView.btnMenu.setEnabled(true);

            }

            else if ((!AbstractView.textField_Choice.getText().equals("Menu Principal") && AbstractView.nettoyageAccompli && AbstractView.detartrageAccompli && AbstractView.calcNCleanAccompli && AbstractView.nettoyerMousseurAccompli)
                    || AbstractView.textField_Choice.getText().equals("Menu Principal")) {

                OperationsView.resetMachine(AbstractView.btnAmericano, AbstractView.btnBas, AbstractView.btnCafe, AbstractView.btnCafeLait, AbstractView.btnCappuccino, AbstractView.btnDeuxtasses, AbstractView.btnEauChaude,
                        AbstractView.btnExpresso, AbstractView.btnFavorisSecurite, AbstractView.btnIntensit, AbstractView.btnMenu, AbstractView.btnOk, AbstractView.btnQuantit, AbstractView.btnRetour, AbstractView.btnStartStop,
                        AbstractView.progressBar, AbstractView.textArea_MessageEcran, AbstractView.textField_Choice, AbstractView.textField_Intensite, AbstractView.textField_Quantite,
                        AbstractView.timer);

            }






        });

    }
}
