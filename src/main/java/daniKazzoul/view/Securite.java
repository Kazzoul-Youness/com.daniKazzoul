package daniKazzoul.view;

import daniKazzoul.controller.OperationControlleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.TimerTask;

public class Securite extends FavoriSecuriteVue{

    public Securite() throws FileNotFoundException {
    }


    static void Securite(SimulateurView simulateurView) {



        btnFavorisSecurite.addMouseListener(new MouseAdapter() {
            private java.util.Timer t1;

            public void mousePressed(MouseEvent e) {
                if (t1 == null) {
                    t1 = new java.util.Timer();
                }
                if (btnFavorisSecurite.getText().equals("FavoriSecurite")) {
                    t1.schedule(new TimerTask() {

                        public void run() {
                            System.out.println("Machine est bloquée");
                            securiteActive = true;
                            OperationControlleur.desableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
                            OperationControlleur.desableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
                            OperationControlleur.desableComposante(btnFavorisSecurite, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite);
                            btnStartStop.setEnabled(false);
                            btnMenu.setEnabled(false);
                            btnBas.setEnabled(false);
                            btnOk.setEnabled(false);
                            btnRetour.setEnabled(false);
                            btnFavorisSecurite.setEnabled(true);

                            textField_Choice.setText(null);
                            textArea_MessageEcran.setEnabled(true);
                            textArea_MessageEcran.setText("\n Sécurité enfant activé, " +
                                    "\n\n Appuyer plus de 3s \n\n pour la désactiver ");


                        //    utilisateurVue.btnFavorisSecurite.setIcon(new ImageIcon("icon//cle.png"));

                            btnFavorisSecurite.setText("Securite");
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
        btnFavorisSecurite.addMouseListener(new MouseAdapter() {
            private java.util.Timer t2;

            //Timer t1;
            public void mousePressed(MouseEvent e) {
                if (t2 == null) {
                    t2 = new java.util.Timer();
                }
                if (btnFavorisSecurite.getText().equals("Securite")) {
                    t2.schedule(new TimerTask() {
                        public void run() {
                            System.out.println("Machine est débloquée");
                            securiteActive = false;
                            OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe,
                                    btnCafeLait, btnCappuccino, btnDeuxtasses,
                                    btnEauChaude, btnExpresso, btnFavorisSecurite,
                                    btnIntensit, btnMenu, btnOk, btnQuantit,
                                    btnRetour, btnStartStop, progressBar, textArea_MessageEcran,
                                    textField_Choice, textField_Intensite, textField_Quantite, timer);

                            btnFavorisSecurite.setText("FavoriSecurite");
                          //  utilisateurVue.btnFavorisSecurite.setIcon(new ImageIcon("icon//FavoriSecurite.png"));

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
