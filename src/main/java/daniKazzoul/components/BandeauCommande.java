package daniKazzoul.components;

import daniKazzoul.view.UtilisateurVue;

import javax.swing.*;

public class BandeauCommande {

    // - Affichage menu Principal /

    public static void actionMenuPrincipal(UtilisateurVue utilisateurVue) {

        if (utilisateurVue.selectionChoixMenu == 0) {
            utilisateurVue.textField_Choice.setText("Maintenance");
            utilisateurVue.textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu maintenance");
            utilisateurVue.selectionChoixMenu++;
        } else if (utilisateurVue.selectionChoixMenu == 1) {
            utilisateurVue.textField_Choice.setText("Favori");
            utilisateurVue.textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu Favori");
            utilisateurVue.selectionChoixMenu++;
        } else if (utilisateurVue.selectionChoixMenu == 2) {
            utilisateurVue.textField_Choice.setText("Langue");
            utilisateurVue.textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu Langue");
            utilisateurVue.selectionChoixMenu = 0;
        }
    }

    // - Affichage sous menu Maintenance

    public static void sousMenuMaintenance(UtilisateurVue utilisateurVue) {

        if (utilisateurVue.selectionChoixMaintenance == 0) {
            utilisateurVue.textField_Choice.setText("Nettoyer le mousseur de lait");
            utilisateurVue.selectionChoixMaintenance++;
        } else if (utilisateurVue.selectionChoixMaintenance == 1) {
            utilisateurVue.textField_Choice.setText("Détartrage");
            utilisateurVue.selectionChoixMaintenance++;
        } else if (utilisateurVue.selectionChoixMaintenance == 2) {
            utilisateurVue.textField_Choice.setText("Nettoyage");
            utilisateurVue.selectionChoixMaintenance++;
        } else if (utilisateurVue.selectionChoixMaintenance == 3) {
            utilisateurVue.textField_Choice.setText("calc'nClean");
            utilisateurVue.selectionChoixMaintenance = 0;
        }
    }

    // - Affichage sous menu Langue - reglage

    public static void sousMenuLangue(UtilisateurVue utilisateurVue) {

        if (utilisateurVue.selectionChoixLangue == 0) {
            utilisateurVue.textField_Choice.setText("Allemand");
            utilisateurVue.selectionChoixLangue++;
        }
        else if (utilisateurVue.selectionChoixLangue == 1) {
            utilisateurVue.textField_Choice.setText("Français");
            utilisateurVue.selectionChoixLangue++;
        }
        else if (utilisateurVue.selectionChoixLangue == 2) {
            utilisateurVue.textField_Choice.setText("Néerlandais");
            utilisateurVue.selectionChoixLangue = 0;
        }
    }


    // - Affichage sous menu Favori - reglage

    public static void sousMenuFavori(UtilisateurVue utilisateurVue) {

        if (utilisateurVue.selectionChoixFavori == 0) {
            utilisateurVue.textField_Choice.setText("Profile 1");
            utilisateurVue.selectionChoixFavori++;
        } else if (utilisateurVue.selectionChoixFavori == 1) {
            utilisateurVue.textField_Choice.setText("Profile 2");
            utilisateurVue.selectionChoixFavori =0;
        }
    }

    // - ProgressBar
    public static void createProgressBar(UtilisateurVue utilisateurVue) {
        utilisateurVue.progressBar = new JProgressBar(0, 1000);
        utilisateurVue.progressBar.setForeground(UIManager.getColor("Table.dropLineColor"));
        utilisateurVue.progressBar.setBounds(282, 463, 400, 38);
        utilisateurVue.progressBar.setVisible(true);
        utilisateurVue.progressBar.setStringPainted(true);
        utilisateurVue.frame.getContentPane().add(utilisateurVue.progressBar);
        utilisateurVue.setSize(500, 500);

    }
}
