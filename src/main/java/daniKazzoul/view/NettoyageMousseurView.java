package daniKazzoul.view;


import static daniKazzoul.view.AbstractView.*;

public class NettoyageMousseurView {

    // use Singleton design pattern
    private NettoyageMousseurView() {}; // make constructor invisible to clients
    private static NettoyageMousseurView instance = null;
    public static NettoyageMousseurView getInstance() {
        if(instance == null) instance = new NettoyageMousseurView();
        return instance;
    }

    /** Maintenance mode Nettoyage Mousseur de lait  **********************************************************************/

    public static void clickStartStopNettoyageMousseur1() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyerMousseurAccompli) {
                System.out.println(" ----------------------- Nettoyage Mousseur de lait  -------------------------------");

                System.out.println(" Etape 1 : placement du verre sous la buse d'écoulement..., progression : " + (progressBar.getValue() + 300) / 10 + " %");
                textArea_MessageEcran.setText(" 1. Placer un verre vide \n\n" +
                        " sous la buse d'écoulement,\n\n" +
                        " et placer l'extrémité du tube d'aspiration\n\n" +
                        " dans le verre.\n\n" +
                        " Puis appuyer sur (Start/Stop)");

                progressBar.setValue(300);
                btnStartStop.setText("End");
                NettoyageMousseurView.getInstance().cliclStartStopNettoyageMousseur2();
            }
        });
    }

    public static void cliclStartStopNettoyageMousseur2() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyerMousseurAccompli) {

                System.out.println(" Etape 2 : Si necessaire, retirez le filtre eau, progression : " + (progressBar.getValue() + 300) / 10 + " %");
                textArea_MessageEcran.setText("\n\n 2. Vider le verre,\n\n" +
                        " et nettoyer le tube d'aspiration.\n\n\n" +
                        " Appuyer sur (Start/Stop)");

                progressBar.setValue(600);
                btnStartStop.setText("End");
                NettoyageMousseurView.getInstance().cliclStartStopNettoyageMousseur3();
            }
        });
    }

    public static void cliclStartStopNettoyageMousseur3() {

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyerMousseurAccompli) {

                System.out.println(" Etape 3 : Fin de nettoyage du mousseur de lait, progression : " + (progressBar.getValue() + 400) / 10 + " % " +
                        "\n -------------- Fin Nettoyage Mousseur de lait --------------------");
                textArea_MessageEcran.setText("\n 3. Nettoyage terminé,\n\n " +
                        "Important : De plus nettoyer régulièrement\n\n " +
                        "et tres soigneusement le mousseur de lait\n\n " +
                        "Appuyer sur (Ok) pour sortir.");

                textField_Choice.setText("Nettoyage Mousseur de lait fini");

                btnStartStop.setText("End");
                progressBar.setValue(1000);

                btnStartStop.setEnabled(false);
                btnOk.setEnabled(true);
                nettoyerMousseurAccompli = true;
            }
        });
    }











}
