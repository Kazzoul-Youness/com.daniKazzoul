package daniKazzoul.components;

import daniKazzoul.view.AbstractView;
import daniKazzoul.view.SimulateurView;

import javax.swing.*;

public class BandeauCommande {

    // use Singleton design pattern
    private BandeauCommande() {}; // make constructor invisible to clients
    private static BandeauCommande instance = null;
    public static BandeauCommande getInstance() {
        if(instance == null) instance = new BandeauCommande();
        return instance;
    }

    // - Affichage menu Principal /

    public static void actionMenuPrincipal(SimulateurView simulateurView) {

        if (simulateurView.selectionChoixMenu == 0) {
            AbstractView.textField_Choice.setText("Maintenance");
            AbstractView.textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu maintenance");
            simulateurView.selectionChoixMenu++;
        } else if (simulateurView.selectionChoixMenu == 1) {
            AbstractView.textField_Choice.setText("Favori");
            AbstractView.textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu Favori");
            simulateurView.selectionChoixMenu = 0;
        }
    }

    // - Affichage sous menu Maintenance

    public static void sousMenuMaintenance(SimulateurView simulateurView) {

        if (simulateurView.selectionChoixMaintenance == 0) {
            AbstractView.textField_Choice.setText("Nettoyer le mousseur de lait");
            simulateurView.selectionChoixMaintenance++;
        }
        else if (simulateurView.selectionChoixMaintenance == 1) {
            AbstractView.textField_Choice.setText("Détartrage");
            simulateurView.selectionChoixMaintenance++;
        }
        else if (simulateurView.selectionChoixMaintenance == 2) {
            AbstractView.textField_Choice.setText("Nettoyage");
            simulateurView.selectionChoixMaintenance++;
        }
        else if (simulateurView.selectionChoixMaintenance == 3) {
            AbstractView.textField_Choice.setText("calc'nClean");
            simulateurView.selectionChoixMaintenance = 0;
        }
    }


    // - Affichage sous menu Favori - reglage

    public static void sousMenuFavori(SimulateurView simulateurView) {

        if (SimulateurView.selectionChoixFavori == 0) {
            AbstractView.textField_Choice.setText("Profile 1");
            SimulateurView.selectionChoixFavori++;
        }
        else if (SimulateurView.selectionChoixFavori == 1) {
            AbstractView.textField_Choice.setText("Profile 2");
            SimulateurView.selectionChoixFavori = 0;
        }
    }

    // - ProgressBar
    public static void createProgressBar(SimulateurView simulateurView) {
        AbstractView.progressBar = new JProgressBar(0, 1000);
        AbstractView.progressBar.setForeground(UIManager.getColor("Table.dropLineColor"));
        AbstractView.progressBar.setBounds(282, 463, 400, 38);
        AbstractView.progressBar.setVisible(true);
        AbstractView.progressBar.setStringPainted(true);
        simulateurView.frame.getContentPane().add(AbstractView.progressBar);
        simulateurView.setSize(500, 500);
    }


}
