package daniKazzoul.controller;

import daniKazzoul.model.IntensiteEnum;
import daniKazzoul.model.QuantiteEnum;
import daniKazzoul.view.Vue;

import javax.swing.*;
import java.awt.*;

public class ParametreControlleur {

    // - Singleton Pattern
    private static final ParametreControlleur instance = new ParametreControlleur();

    //constructeur privé pour éviter que les applications clientes utilisent le constructeur
    private ParametreControlleur(){  }

    public static ParametreControlleur getInstance(){
        return instance;
    }


    /***********************        Quantité        ****************************************
     * @param vue*/

    public void createQuantiteButton(Vue vue) {
        vue.btnQuantit = new JButton("Quantite");
        vue.btnQuantit.setIcon(new ImageIcon("icon//Quantite.png"));
        vue.btnQuantit.addActionListener(e -> {
            if (vue.quantite == 0) {
                vue.textField_Quantite.setText(String.valueOf(QuantiteEnum.Moyen));
                vue.quantite++;
            } else if (vue.quantite == 1) {
                vue.textField_Quantite.setText(String.valueOf(QuantiteEnum.Gand));
                vue.quantite++;
            } else if (vue.quantite == 2) {
                vue.textField_Quantite.setText(String.valueOf(QuantiteEnum.Petit));
                vue.quantite = 0;
            }
        });
        vue.btnQuantit.setBounds(131, 432, 107, 100);
        vue.frame.getContentPane().add(vue.btnQuantit);
    }

    /***********************        Intensité        ****************************************
    * @param vue*/

    public void createIntensiteButton(Vue vue) {
        vue.btnIntensit = new JButton("Intensite");
        vue.btnIntensit.setIcon(new ImageIcon("icon//Intensite.png"));
        vue.btnIntensit.addActionListener(e -> {
            if (vue.intensite == 0) {
                vue.textField_Intensite.setText(String.valueOf(IntensiteEnum.Normal));
                vue.intensite++;
            } else if (vue.intensite == 1) {
                vue.textField_Intensite.setText(String.valueOf(IntensiteEnum.Fort));
                vue.intensite++;
            } else if (vue.intensite == 2) {
                vue.textField_Intensite.setText(String.valueOf(IntensiteEnum.Doux));
                vue.intensite = 0;
            }
        });
        vue.btnIntensit.setBounds(715, 404, 107, 100);
        vue.frame.getContentPane().add(vue.btnIntensit);


    }

    public void createDeuxTasseButton(Vue vue) {
        vue.btnDeuxtasses = new JButton("DeuxTasses");
        vue.btnDeuxtasses.setIcon(new ImageIcon("icon//DeuxTasses.png"));
        vue.btnDeuxtasses.setForeground(new Color(204, 255, 255));
        vue.btnDeuxtasses.setBackground(new Color(51, 51, 51));

        vue.btnDeuxtasses.addActionListener(e -> {
            if (!vue.selected) {
                vue.selected = true;
                vue.btnDeuxtasses.setSelected(true);
                vue.btnDeuxtasses.setFocusable(true);
                vue.btnDeuxtasses.setBackground(new Color(100, 51, 51));

                // ici il faut introduire une image qui montre que la deux tasse est choisi
                System.out.println(vue.btnDeuxtasses.isSelected());
            } else {
                vue.selected = false;
                vue.btnDeuxtasses.setSelected(false);
                vue.btnDeuxtasses.setFocusable(false);
                vue.btnDeuxtasses.setBackground(new Color(51, 51, 51));
                System.out.println(vue.btnDeuxtasses.isSelected());
            }

        });

        vue.btnDeuxtasses.setBounds(12, 432, 107, 98);
        vue.frame.getContentPane().add(vue.btnDeuxtasses);
    }


}
