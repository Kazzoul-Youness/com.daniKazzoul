package daniKazzoul.components;

import daniKazzoul.view.SimulateurView;
import daniKazzoul.view.Vue;

import javax.swing.*;

public class BandeauCommande {

    // - Affichage menu Principal /

    public static void actionMenuPrincipal(SimulateurView simulateurView) {

        if (simulateurView.selectionChoixMenu == 0) {
            Vue.textField_Choice.setText("Maintenance");
            Vue.textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu maintenance");
            simulateurView.selectionChoixMenu++;
        } else if (simulateurView.selectionChoixMenu == 1) {
            Vue.textField_Choice.setText("Favori");
            Vue.textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu Favori");
            simulateurView.selectionChoixMenu = 0;
        }
    }

    // - Affichage sous menu Maintenance

    public static void sousMenuMaintenance(SimulateurView simulateurView) {

        if (simulateurView.selectionChoixMaintenance == 0) {
            Vue.textField_Choice.setText("Nettoyer le mousseur de lait");
            simulateurView.selectionChoixMaintenance++;
        }
        else if (simulateurView.selectionChoixMaintenance == 1) {
            Vue.textField_Choice.setText("Détartrage");
            simulateurView.selectionChoixMaintenance++;
        }
        else if (simulateurView.selectionChoixMaintenance == 2) {
            Vue.textField_Choice.setText("Nettoyage");
            simulateurView.selectionChoixMaintenance++;
        }
        else if (simulateurView.selectionChoixMaintenance == 3) {
            Vue.textField_Choice.setText("calc'nClean");
            simulateurView.selectionChoixMaintenance = 0;
        }
    }


    // - Affichage sous menu Favori - reglage

    public static void sousMenuFavori(SimulateurView simulateurView) {

        if (SimulateurView.selectionChoixFavori == 0) {
            Vue.textField_Choice.setText("Profile 1");
            SimulateurView.selectionChoixFavori++;
        }
        else if (SimulateurView.selectionChoixFavori == 1) {
            Vue.textField_Choice.setText("Profile 2");
            SimulateurView.selectionChoixFavori = 0;
        }
    }

    // - ProgressBar
    public static void createProgressBar(SimulateurView simulateurView) {
        Vue.progressBar = new JProgressBar(0, 1000);
        Vue.progressBar.setForeground(UIManager.getColor("Table.dropLineColor"));
        Vue.progressBar.setBounds(282, 463, 400, 38);
        Vue.progressBar.setVisible(true);
        Vue.progressBar.setStringPainted(true);
        simulateurView.frame.getContentPane().add(Vue.progressBar);
        simulateurView.setSize(500, 500);
    }


}
