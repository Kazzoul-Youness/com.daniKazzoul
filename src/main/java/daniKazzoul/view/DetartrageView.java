package daniKazzoul.view;

import daniKazzoul.model.MaintenanceProgrammeModel;

import static daniKazzoul.view.AbstractView.*;

public class DetartrageView {

    // use Singleton design pattern
    private DetartrageView() {}; // make constructor invisible to clients
    private static DetartrageView instance = null;
    public static DetartrageView getInstance() {
        if(instance == null) instance = new DetartrageView();
        return instance;
    }

    /** Maintenance mode Détartrage   ******************************************************************************/

    public static void clickStartStopDetartrage1() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" ----------------------- Détartrage  -------------------------------");

                System.out.println(" etape 1 : Vider le bac collecteur et le remettre en place, " +
                        "progression : " + (progressBar.getValue() + 100) / 10 + " %");
                textArea_MessageEcran.setText("\n 1. Vider le bac collecteur, \n\n et le remettre en place \n\n\n Et puis continuer avec (Start/Stop)");

                progressBar.setValue(100);
                btnStartStop.setText("End");
                clickStartStopDetartrage2();
            }
        });
    }

    private static void clickStartStopDetartrage2() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 2 : Si necessaire, retirez le filtre eau, " +
                        "progression : " + (progressBar.getValue() + 100) / 10 + " %");
                textArea_MessageEcran.setText("\n 2. Si necessaire,\n\n retirez le filtre eau \n\n\n Et puis appuyer sur (Start/Stop)");

                progressBar.setValue(200);
                btnStartStop.setText("End");
                clickStartStopDetartrage3();
            }
        });
    }

    private static void clickStartStopDetartrage3() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 3 : Versement de l'eau tiède dans le reservoir d'eau..., " +
                        "progression : " + (progressBar.getValue() + 100) / 10 + " %");
                textArea_MessageEcran.setText("\n 3. Verser l'eau tiède dans le reservoir d'eau \n\n " +
                        "vide jusqu'au repère <<0,5L>>, \n\n et y dissoudre 1 pastille de détartrage\n\n\n " +
                        "et apres continuer avec (Start/Stop)");

                progressBar.setValue(300);
                btnStartStop.setText("End");
                clickStartStopDetartrage4();
            }
        });
    }

    private static void clickStartStopDetartrage4() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 4 : Placement du récipient sous la buse d'écoulement, " +
                        "progression : " + (progressBar.getValue() + 100) / 10 + " %");

                textArea_MessageEcran.setText("4. Placer un récipient d'une contenance de 0,5L \n\n sous la buse d'écoulement" +
                        "\n\n Placer l'embout du tube aspiration \n dans le récipient" +
                        " \n\n\n Appuyer  sur (Start/Stop)");

                progressBar.setValue(400);
                btnStartStop.setText("End");
                clickStartStopDetartrage5();
            }
        });
    }

    private static void clickStartStopDetartrage5() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 5 : Le programme de detartrage commence, progression : " + (progressBar.getValue() + 100) / 10 + " %");

                textArea_MessageEcran.setText("5. Le programme de détartrage se déroule\n\n" +
                        " à présent pendant 20 min envi, S'il n'y a pas\n\n" +
                        " assez de solution de détartrage dans\n\n" +
                        " le réservoir d'eau, rajoutez du détartrant\n\n\n" +
                        " Puis (Start/Stop)");

                progressBar.setValue(500);
                btnStartStop.setText("End");
                clickStartStopDetartrage6();
            }
        });
    }

    private static void clickStartStopDetartrage6() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 6 : Rajouter du détartrage, progression : "
                        + (progressBar.getValue() + 100) / 10 + " % ");

                textArea_MessageEcran.setText("\n\n 6. Rajouter du détartrage, \n\n\n et appuyer à nouveau sur (Start/Stop) ");

                progressBar.setValue(600);
                btnStartStop.setText("End");
                clickStartStopDetartrage7();
            }
        });
    }

    private static void clickStartStopDetartrage7() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 7 : Rincer le reservoir d'eau et le remplir, progression : "
                        + (progressBar.getValue() + 100) / 10 + " % ");

                textArea_MessageEcran.setText("\n 7. Rincer le reservoir d'eau et le remplir\n\n" +
                        " avec d'eau fraîche jusqu'au repère <<max>>\n\n\n" +
                        " et appuyer sur (Start/Stop)");

                progressBar.setValue(700);
                btnStartStop.setText("End");
                clickStartStopDetartrage8();
            }
        });
    }

    private static void clickStartStopDetartrage8() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 8 : Si un filtre est utilisé, le remettre en place, progression : "
                        + (progressBar.getValue() + 100) / 10 + " % ");
                textArea_MessageEcran.setText("\n\n 8. Si un filtre est utilisé, le remettre en place,\n\n\n" +
                        " Appuyer sur (Start/Stop)");

                progressBar.setValue(800);
                btnStartStop.setText("End");
                clickStartStopDetartrage9();
            }
        });
    }

    private static void clickStartStopDetartrage9() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 9 : Le programme de détartrage se lance, progression : "
                        + (progressBar.getValue() + 100) / 10 + " % ");
                textArea_MessageEcran.setText("\n 9. Le programme de détartrage se déroule, \n\n" +
                        " envi 1 min et rince la machine,\n\n" +
                        " Vider le bac collecteur et le remettre en place\n\n\n" +
                        " Appuyer sur (Start/Stop)");

                progressBar.setValue(900);
                btnStartStop.setText("End");
                clickStartStopDetartrage10();
            }
        });
    }

    private static void clickStartStopDetartrage10() {

        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") && !detartrageAccompli) {
                System.out.println(" etape 10 : Machine détartrée, prête à fonctionner, progression : "
                        + (progressBar.getValue() + 100) / 10 + " % " +
                        "\n -------------------    Fin programme Détartrage   ----------------------------");

                textArea_MessageEcran.setText("\n\n 10. La machine détartrée\n\n" +
                        " et de nouveau prête à fonctionner, \n\n\n" +
                        " (Ok) pour sortir vers l'ecran principal");

                textField_Choice.setText("Détartrage fini");

                btnStartStop.setText("End");
                progressBar.setValue(1000);

                btnStartStop.setEnabled(false);
                btnOk.setEnabled(true);
                detartrageAccompli = true;
                MaintenanceProgrammeModel.detartrer();  // remise du compte de detartrage à zèro
            }
        });
    }


}
