package daniKazzoul.view;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Intensite extends UtilisateurVue{


    public Intensite() throws FileNotFoundException {
    }


    /***********************        Intensité        ****************************************
     * @param utilisateurVue*/

    static void createIntensiteButton(UtilisateurVue utilisateurVue) {
        utilisateurVue.btnIntensit = new JButton("Intensite");
        utilisateurVue.btnIntensit.setIcon(new ImageIcon("icon//Intensite.png"));
        utilisateurVue.btnIntensit.addActionListener(e -> {
            if (utilisateurVue.intensite == 0) {
                utilisateurVue.textField_Intensite.setText("Normal");
                utilisateurVue.intensite++;
            } else if (utilisateurVue.intensite == 1) {
                utilisateurVue.textField_Intensite.setText("Fort");
                utilisateurVue.intensite++;
            } else if (utilisateurVue.intensite == 2) {
                utilisateurVue.textField_Intensite.setText("Doux");
                utilisateurVue.intensite = 0;
            }
        });
        utilisateurVue.btnIntensit.setBounds(715, 404, 107, 97);
        utilisateurVue.frame.getContentPane().add(utilisateurVue.btnIntensit);
    }
}
