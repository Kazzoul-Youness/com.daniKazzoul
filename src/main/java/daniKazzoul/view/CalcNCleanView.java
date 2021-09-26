package daniKazzoul.view;

import daniKazzoul.model.MaintenanceProgrammeModel;

import static daniKazzoul.view.AbstractView.*;

public class CalcNCleanView {

    // use Singleton design pattern
    private CalcNCleanView() {}; // make constructor invisible to clients
    private static CalcNCleanView instance = null;
    public static CalcNCleanView getInstance() {
        if(instance == null) instance = new CalcNCleanView();
        return instance;
    }


    /**
     * Maintenance mode calc'nClean
     **********************************************************************************/

    public static void clickStartStopCalcNClean1() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {
                System.out.println(" ----------------------- calc'nClean  -------------------------------");

                System.out.println(" etape 1 : Si un filtre est present retirez le avant de lancer le programme, progression : " + (progressBar.getValue() + 80) / 10 + " %");
                textArea_MessageEcran.setText("\n 1. Si un filtre est present retirez\n\n le avant de lancer le programme,\n" +
                        "\n\n\n Et puis appuyer (Start/Stop)");

                progressBar.setValue(80);
                btnStartStop.setText("End");
                clickStartStopCalcNClean2();
            }
        });
    }

    private static void clickStartStopCalcNClean2() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 2 : Vider le bac collecteur est le remettre en place, progression : " + (progressBar.getValue() + 80) / 10 + " %");

                textArea_MessageEcran.setText(" 2. Vider le bac collecteur est le remettre\n\n" +
                        " en place, ouvrir le tiroire à café,\n\n" +
                        " et déposer une pastille de nettoyage \n\n" +
                        " dans le tiroire et refermer,\n\n" +
                        " Appuyer sur (Start/Stop)");

                progressBar.setValue(160);
                btnStartStop.setText("End");
                clickStartStopCalcNClean3();
            }
        });
    }

    private static void clickStartStopCalcNClean3() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 3 : Si nécessaire, retirez filtre à eau ..., progression : " + (progressBar.getValue() + 80) / 10 + " %");

                textArea_MessageEcran.setText("\n 3. Si nécessaire, retirez le filtre à eau,\n\n\n" +
                        " et apres continuer avec (Start/Stop)");

                progressBar.setValue(240);
                btnStartStop.setText("End");
                clickStartStopCalcNClean4();
            }
        });
    }

    private static void clickStartStopCalcNClean4() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 4 : Verser l'eau tiède dans le reservoir ..., progression : " + (progressBar.getValue() + 80) / 10 + " %");

                textArea_MessageEcran.setText(" 4. Verser l'eau tiède dans le reservoir\n\n" +
                        " d'eau jusqu'au repère <<0,5>>,\n\n" +
                        " et dissoudre 1 pastille de détartrage\n\n " +
                        " Puis appuyer sur (Start/Stop)");

                progressBar.setValue(320);
                btnStartStop.setText("End");
                clickStartStopCalcNClean5();
            }
        });
    }

    private static void clickStartStopCalcNClean5() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 5 : Le programme de detartrage commence..., progression : " + (progressBar.getValue() + 80) / 10 + " %");

                textArea_MessageEcran.setText(" 5. Le programme de détartrage se déroule\n\n" +
                        " pendant (20 min environ), S'il n'y a pas\n\n" +
                        " assez de solution de détartrage dans\n\n" +
                        " le réservoir d'eau, rajoutez le\n\n" +
                        " Puis appuyer sur (Start/Stop)");

                progressBar.setValue(400);
                btnStartStop.setText("End");
                clickStartStopCalcNClean6();
            }
        });
    }

    private static void clickStartStopCalcNClean6() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 6 : Placer un récipient d'une contenance de 1L ...., progression : " + (progressBar.getValue() + 80) / 10 + " % ");

                textArea_MessageEcran.setText(" 6. Placer un récipient d'une contenance\n\n" +
                        " de 1L au moins sous la buse d'écoulement,\n\n" +
                        " Placer l'embout du tube d'aspiration\n\n" +
                        " dans le récipeint,\n\n" +
                        " Appuyer sur (Start/Stop) ");

                progressBar.setValue(480);
                btnStartStop.setText("End");
                clickStartStopCalcNClean7();
            }
        });
    }

    private static void clickStartStopCalcNClean7() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 7 : Le programme de détartrage se déroule pendant 28 min...., progression : " + (progressBar.getValue() + 80) / 10 + " % ");

                textArea_MessageEcran.setText("\n 7. Le programme de détartrage se déroule\n\n" +
                        " à présent pendant (28 min environ),\n\n\n" +
                        " Appuyer sur (Start/Stop)");

                progressBar.setValue(560);
                btnStartStop.setText("End");
                clickStartStopCalcNClean8();
            }
        });
    }

    private static void clickStartStopCalcNClean8() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 8 : S'il n'y a pas assez de solution détergant ....., progression : " + (progressBar.getValue() + 80) / 10 + " % ");

                textArea_MessageEcran.setText("\n 8. S'il n'y a pas assez de solution\n\n" +
                        " de détartrage dans le reservoir d'eau,\n\n" +
                        " veuillez en rajouter,\n\n" +
                        " Puis appuyer sur (Start/Stop)");
                progressBar.setValue(640);
                btnStartStop.setText("End");
                clickStartStopCalcNClean9();
            }
        });
    }

    private static void clickStartStopCalcNClean9() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 9 : Rincer le reservoir d'eau ..., progression : " + (progressBar.getValue() + 80) / 10 + " % ");

                textArea_MessageEcran.setText("\n 9. Rincer le reservoir d'eau\n\n" +
                        " et le remplir d'au frîche jusqu'au <<max>>,\n\n " +
                        " Si filtre est utilisé, remettez le en place,\n\n" +
                        " Puis appuyer sur (Start/Stop)");
                progressBar.setValue(720);
                btnStartStop.setText("End");
                clickStartStopCalcNClean10();
            }
        });
    }

    private static void clickStartStopCalcNClean10() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 10 : Le programme de détartrage se lance, progression : " + (progressBar.getValue() + 80) / 10 + " % ");

                textArea_MessageEcran.setText(" 10. Le programme de détartrage se déroule\n\n" +
                        " à present encore (pendant 1 min),\n\n" +
                        " et puis le programme de nettoyage rince\n\n" +
                        " la machine pendant (7 min envi),\n\n" +
                        " Appuyer sur (Start/Stop) pour commencer");

                progressBar.setValue(800);
                btnStartStop.setText("End");
                clickStartStopCalcNClean11();
            }
        });
    }

    private static void clickStartStopCalcNClean11() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 11 : Vider le bac collecteur et le remettre en place ...., progression : " + (progressBar.getValue() + 100) / 10 + " % ");

                textArea_MessageEcran.setText(" 11. Vider le bac collecteur et le remettre\n" +
                        " en place,\n\n Important :\n" +
                        " Essuyer la machine avec un chiffon\n" +
                        " doux et humide pour éliminer imméditement\n" +
                        " les résidus du produit ...\n" +
                        " voir la suite dans le manuel page.31,\n\n" +
                        " Appuyer sur (Start/Stop)");

                progressBar.setValue(900);
                btnStartStop.setText("End");
                clickStartStopCalcNClean12();
            }
        });
    }

    private static void clickStartStopCalcNClean12() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !calcNCleanAccompli) {

                System.out.println(" etape 12 : Machine détartrée, prête à fonctionner, progression : " + (progressBar.getValue() + 100) / 10 + " % " +
                        "\n -------------------    Fin programme calcn'Clean   ----------------------------");

                textArea_MessageEcran.setText("\n 12. Machine détartrée,\n\n" +
                        " et est ainsi prête à fonctoinner.\n\n\n" +
                        " (Ok) pour sortir vers l'ecran principal");

                textField_Choice.setText("calc'nClean fini");

                btnStartStop.setText("End");
                progressBar.setValue(1000);

                btnStartStop.setEnabled(false);
                btnOk.setEnabled(true);
                calcNCleanAccompli = true;
                MaintenanceProgrammeModel.calcNClean();  // remise du compte de calcNClean à zèro
            }
        });
    }


}
