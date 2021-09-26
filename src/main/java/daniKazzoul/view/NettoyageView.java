package daniKazzoul.view;

import daniKazzoul.model.MaintenanceProgrammeModel;

import static daniKazzoul.view.AbstractView.*;

public class NettoyageView {

    // use Singleton design pattern
    private NettoyageView() {}; // make constructor invisible to clients
    private static NettoyageView instance = null;
    public static NettoyageView getInstance() {
        if(instance == null) instance = new NettoyageView();
        return instance;
    }


    /** Maintenance mode Nettoyage *********************************************************************/

    //Etape 1
    public static void clickStartStopNettoyage1() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {
                System.out.println(" ----------------------- Nettoyage  -------------------------------");

                System.out.println(" etape 1 : Vider le bac collecteur et le remettre en place, progression : " + (progressBar.getValue() + 100) / 10 + " %");
                textArea_MessageEcran.setText("\n 1. Vider le bac collecteur, \n\n et le remettre en place \n\n Et puis continuer avec (Start/Stop)");
                progressBar.setValue(100);
                btnStartStop.setText("End");
                clickStartStopNettoyage2();
            }
        });

    }

    // Etape 2
    private static void clickStartStopNettoyage2() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {
                System.out.println(" etape 2 : Ouvrir le tiroir à café, progression : " + (progressBar.getValue() + 100) / 10 + " %");
                textArea_MessageEcran.setText("\n 2. Ouvrir le tiroir à café \n\n Et puis appuyer sur (Start/Stop)");
                progressBar.setValue(200);
                btnStartStop.setText("End");
                clickStartStopNettoyage3();
            }
        });
    }

    //Etape 3
    private static void clickStartStopNettoyage3() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {
                System.out.println(" etape 3 : Déposer une pastille de nettoyage, progression : " + (progressBar.getValue() + 200) / 10 + " %");
                textArea_MessageEcran.setText("\n 3. Déposer une pastille de nettoyage \n\n " +
                        "dans le tirroire et le renfermer \n\n\n et apres continuer avec (Start/Stop)");

                progressBar.setValue(400);
                btnStartStop.setText("End");
                clickStartStopNettoyage4();
            }
        });
    }

    //Etape 4
    private static void clickStartStopNettoyage4() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {
                System.out.println(" etape 4 : Appuyer sur (Start/Stop), progression : " + (progressBar.getValue() + 200) / 10 + " %");
                textArea_MessageEcran.setText("\n 4. Appuyer sur Start/Stop \n\n Pour commencer le nettoyage \n\n\n (Le programme dure +/- 7min)");
                progressBar.setValue(600);
                btnStartStop.setText("End");
                clickStartStopNettoyage5();
            }
        });
    }

    // Etape 5
    private static void clickStartStopNettoyage5() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {
                System.out.println(" etape 5 : Vider le bac collecteur et le remettre en place, progression : " + (progressBar.getValue() + 200) / 10 + " %");
                textArea_MessageEcran.setText("\n 5. Vider le bac collecteur, \n\n et le remettre en place \n\n Puis (Start/Stop) pour finir");
                progressBar.setValue(800);
                btnStartStop.setText("End");
                clickStartStopNettoyage6();
            }
        });
    }

    // Etape 6
    private static void clickStartStopNettoyage6() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {
                System.out.println(" etape 6 : Machine prête à fonctionner, progression : " + (progressBar.getValue() + 200) / 10 + " % " +
                        "\n ---------------- Fin programme nettoyage --------------------");
                textArea_MessageEcran.setText("\n\n 6. Machine prête à fonctionner, \n\n Ok pour sortir vers l'ecran principal ");
                textField_Choice.setText("Nettoyage fini");

                btnStartStop.setText("End");
                progressBar.setValue(1000);

                btnStartStop.setEnabled(false);
                btnOk.setEnabled(true);
                nettoyageAccompli = true;
                MaintenanceProgrammeModel.nettoyer();  // remise du compte de nettoyage à zèro
            }
        });
    }



}
