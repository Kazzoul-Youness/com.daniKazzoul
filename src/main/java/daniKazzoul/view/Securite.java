package daniKazzoul.view;

import daniKazzoul.controller.OperationControlleur;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.TimerTask;

public class Securite extends FavoriSecuriteVue{

    public Securite() throws FileNotFoundException {
    }


    static void Securite(UtilisateurVue utilisateurVue) {

        utilisateurVue.btnFavorisSecurite.addMouseListener(new MouseAdapter() {
            private java.util.Timer t1;

            public void mousePressed(MouseEvent e) {
                if (t1 == null) {
                    t1 = new java.util.Timer();
                }
                if (utilisateurVue.btnFavorisSecurite.getText().equals("FavoriSecurite")) {
                    t1.schedule(new TimerTask() {

                        public void run() {
                            System.out.println("Machine est bloquée");
                            OperationControlleur.desableBoisson(utilisateurVue.btnAmericano, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso);
                            OperationControlleur.desableParametre(utilisateurVue.btnDeuxtasses, utilisateurVue.btnIntensit, utilisateurVue.btnQuantit);
                            OperationControlleur.desableComposante(utilisateurVue.btnFavorisSecurite, utilisateurVue.progressBar, utilisateurVue.textArea_MessageEcran, utilisateurVue.textField_Choice, utilisateurVue.textField_Intensite, utilisateurVue.textField_Quantite);
                            utilisateurVue.btnStartStop.setEnabled(false);
                            utilisateurVue.btnMenu.setEnabled(false);
                            utilisateurVue.btnBas.setEnabled(false);
                            utilisateurVue.btnOk.setEnabled(false);
                            utilisateurVue.btnRetour.setEnabled(false);
                            utilisateurVue.btnFavorisSecurite.setEnabled(true);

                            utilisateurVue.textField_Choice.setText(null);
                            utilisateurVue.textArea_MessageEcran.setEnabled(true);
                            utilisateurVue.textArea_MessageEcran.setText("\n Sécurité enfant activé, " +
                                    "\n\n Appuyer plus de 3s \n\n pour la désactiver ");

                            utilisateurVue.btnFavorisSecurite.setIcon(new ImageIcon("icon//cle.png"));

                            utilisateurVue.btnFavorisSecurite.setText("Securite");
                        }
                    }, 3000);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (t1 != null) {
                    t1.cancel();
                    t1 = null;
                }
            }
        });
        utilisateurVue.btnFavorisSecurite.addMouseListener(new MouseAdapter() {
            private java.util.Timer t2;

            //Timer t1;
            public void mousePressed(MouseEvent e) {
                if (t2 == null) {
                    t2 = new java.util.Timer();
                }
                if (utilisateurVue.btnFavorisSecurite.getText().equals("Securite")) {
                    t2.schedule(new TimerTask() {
                        public void run() {
                            System.out.println("Machine est débloquée");
                            OperationControlleur.resetMachine(utilisateurVue.btnAmericano, utilisateurVue.btnBas, utilisateurVue.btnCafe, utilisateurVue.btnCafeLait, utilisateurVue.btnCappuccino, utilisateurVue.btnDeuxtasses, utilisateurVue.btnEauChaude, utilisateurVue.btnExpresso, utilisateurVue.btnFavorisSecurite, utilisateurVue.btnIntensit, utilisateurVue.btnMenu, utilisateurVue.btnOk, utilisateurVue.btnQuantit, utilisateurVue.btnRetour, utilisateurVue.btnStartStop, utilisateurVue.progressBar, utilisateurVue.textArea_MessageEcran, utilisateurVue.textField_Choice, utilisateurVue.textField_Intensite, utilisateurVue.textField_Quantite, utilisateurVue.timer, utilisateurVue.timer1, utilisateurVue.timer2, utilisateurVue.timer3, utilisateurVue.timer4, utilisateurVue.timer5, utilisateurVue.timer6);
                            utilisateurVue.btnFavorisSecurite.setText("FavoriSecurite");
                            utilisateurVue.btnFavorisSecurite.setIcon(new ImageIcon("icon//FavoriSecurite.png"));

                        }
                    }, 3000);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (t2 != null) {
                    t2.cancel();
                    t2 = null;
                }
            }
        });


    }

}
