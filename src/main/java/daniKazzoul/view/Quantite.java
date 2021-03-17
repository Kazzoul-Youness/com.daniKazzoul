package daniKazzoul.view;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Quantite extends UtilisateurVue {


    public Quantite() throws FileNotFoundException {


    }


    /***********************        Quantité        ****************************************
     * @param utilisateurVue*/

    static void createQuantiteButton(UtilisateurVue utilisateurVue) {
        utilisateurVue.btnQuantit = new JButton("Quantite");
        utilisateurVue.btnQuantit.setIcon(new ImageIcon("icon//Quantite.png"));
        utilisateurVue.btnQuantit.addActionListener(e -> {
            if (utilisateurVue.quantite == 0) {
                utilisateurVue.textField_Quantite.setText("Moyen");
                utilisateurVue.quantite++;
            } else if (utilisateurVue.quantite == 1) {
                utilisateurVue.textField_Quantite.setText("Grand");
                utilisateurVue.quantite++;
            } else if (utilisateurVue.quantite == 2) {
                utilisateurVue.textField_Quantite.setText("Petit");
                utilisateurVue.quantite = 0;
            }
        });
        utilisateurVue.btnQuantit.setBounds(131, 432, 107, 98);
        utilisateurVue.frame.getContentPane().add(utilisateurVue.btnQuantit);
    }
}
