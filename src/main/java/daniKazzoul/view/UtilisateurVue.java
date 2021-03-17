package daniKazzoul.view;

import daniKazzoul.components.BandeauCommande;
import daniKazzoul.components.ProgressWorker;
import daniKazzoul.controller.DonneeFavoris;
import daniKazzoul.controller.MaintenanceEntretientControlleur;
import daniKazzoul.controller.OperationControlleur;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UtilisateurVue extends Vue {

    public int selectionChoixMenu = 0;
    public int selectionChoixMaintenance = 0;
    public int selectionChoixLangue = 0;
    public int selectionChoixFavori = 0;

    // Create the application.
    public UtilisateurVue() throws FileNotFoundException {
        initialize();
        manageAllAction();
    }

    // Initialize the contents of the frame.
    private void initialize() {

        createJframe();
        BandeauCommande.createProgressBar(this);
        createStartStopButton();
        clickStartStopNettoyage1();
        clickStartStopNettoyage2();
        clickStartStopNettoyage3();
        clickStartStopNettoyage4();
        clickStartStopNettoyage5();
        clickStartStopNettoyage6();
        createBasButton();
        createOKButton();
        createButtonMenuPrincipal();
        createRetourButton();

        createExpressoButton();
        createCafeButton();
        createCafeAuLaitButton();
        createCappuccinoButton();
        createEauChaudeButton();
        createAmericanoButton();

//        createIntensiteButton();
//        createQuantiteButton();

        createButtonFavoriSecurite();
        parametreControlleur.createQuantiteButton(UtilisateurVue.this);
        parametreControlleur.createIntensiteButton(UtilisateurVue.this);
        parametreControlleur.createDeuxTasseButton(UtilisateurVue.this);
        createJTextField();
        createJTextArea();

    }

    // Start/Stop ------------------------------------------------

    private void createStartStopButton() {
        System.out.println("*********** Simulateur de machine  à café *************");

        btnStartStop = new JButton("Start/Stop");
        //btnStartStop.setIcon(new ImageIcon("icon//StartStop.png"));
        btnStartStop.setBounds(867, 14, 100, 100);
        frame.getContentPane().add(btnStartStop);
        // ActionListener updateProBar = actionEvent -> {
        ActionListener updateProBar = actionEvent -> {
            int val = progressBar.getValue();
            while (val >= 1000) {
                btnStartStop.setText("End");
                timer.stop();
                progressBar.setValue(0);
                btnStartStop.doClick();
                btnOk.setEnabled(true);

                return;
            }
            progressBar.setValue(++val);
        };
        timer = new Timer(1, updateProBar);
        btnStartStop.addActionListener(e -> {

/*  selectionChoixMaintenance == 3 c'est l'indice de la maintenance nettoyage, qui neccecite le programme de netoyage,
 * et des interactions avec le utilisateur, pour naviguer avec le button (Bas), (Ok) pour selectionner,
 * et valider chaque etape avec (StarStop)  */

            if (btnStartStop.getText().equals("Start/Stop") && nettoyageAccompli) {

                try {
                    selected = btnDeuxtasses.isSelected();

                    boissonController.miseAJourTotalBoisson(textField_Choice.getText());

                    if (timer.isRunning()) {
                        timer.stop();
                        btnStartStop.setText("Start/Stop");
                        progressBar.setValue(0);
                        btnOk.setEnabled(false);

                    } else if (!btnStartStop.getText().equals("End")) {
                        timer.start();
                        btnStartStop.setText("Stop");
                        btnOk.setEnabled(false);
                        textArea_MessageEcran.setText("Appuyer sur stop pour annuler!\n");
                    }

                    System.out.println("Codes retour: ReservoirEau = " +boissonController.passerActionReservoirEau() + " | "+
                            " Bac = " + boissonController.passerActionBacColecteur() + " | " +
                            " Graine = " + boissonController.passerActionReservoirGraine() + " | " +
                            " Nettoyage = " + boissonController.passerActionComptageBoisson());
                    System.out.println("--------------------------------------------------");

                    MaintenanceEntretientControlleur.checkActionReturnReservoirEau(this, boissonController.passerActionReservoirEau());
                    MaintenanceEntretientControlleur.checkActionReturnBacColecteur(this, boissonController.passerActionBacColecteur());
                    MaintenanceEntretientControlleur.checkActionReturnReservoirGraine(this, boissonController.passerActionReservoirGraine());
                    MaintenanceEntretientControlleur.checkActionReturnNettoyage(this, boissonController.passerActionComptageBoisson());
                } catch (Exception exception) {  exception.printStackTrace();  }
            }

            else if (btnStartStop.getText().equals("Stop") || btnStartStop.getText().equals("End") && nettoyageAccompli) {
                timer.stop();
                progressBar.setValue(0);
                btnStartStop.setText("Start/Stop");

                if (textArea_MessageEcran.getText().equals("Appuyer sur stop pour annuler!\n")) {
                    textArea_MessageEcran.setText(null);
                }
            }
        });
    }

    /**********************************************
     StartStop pour la Maintenance mode Nettoyage
     Etape 1
     **********************************************/

    private void clickStartStopNettoyage1() {

        ActionListener updateProBar = actionEvent -> {
            int val1 = progressBar.getValue();
            while (val1 < 100) {
                progressBar.setValue(++val1);
            }
        };
        timer1 = new Timer(1, updateProBar);

        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {

                if (!btnStartStop.getText().equals("End")) {
                    timer1.start();
                    btnStartStop.setText("Stop");
                    System.out.println(" etape 1 : Vider le bac collecteur et le remettre en place, progression : " + (progressBar.getValue()+100)/10+" %");
                    textArea_MessageEcran.setText("\n 1. Vider le bac collecteur, \n\n et le remettre en place \n\n Et puis continuer avec (Start/Stop)");
                    clickStartStopNettoyage2();
                }
            }
        });

    }

    /**********************************************
     Etape 2
     *********************************************/

    private void clickStartStopNettoyage2() {

        ActionListener updateProBar = actionEvent -> {
            int val2 = progressBar.getValue();
            while (val2 < 200 && val2 >= 100) {
                progressBar.setValue(++val2);
            }
        };
        timer2 = new Timer(50, updateProBar);
        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {

                if (!btnStartStop.getText().equals("End")) {
                    timer2.start();
                    btnStartStop.setText("Stop");
                    System.out.println(" etape 2 : Ouvrir le tiroir à café, progression : "  + (progressBar.getValue()+100)/10+" %");
                    textArea_MessageEcran.setText("\n 2. Ouvrir le tiroir à café \n\n Et puis appuyer sur (Start/Stop)");
                    clickStartStopNettoyage3();

                }
            }
        });
    }

    /**********************************************
     Etape 3
     *********************************************/

    private void clickStartStopNettoyage3() {
        ActionListener updateProBar = actionEvent -> {
            int val3 = progressBar.getValue();
            while (val3 < 400 && val3 >= 200) {
                progressBar.setValue(++val3);
            }
        };
        timer3 = new Timer(50, updateProBar);
        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {

                if (!btnStartStop.getText().equals("End")) {
                    timer3.start();
                    btnStartStop.setText("Stop");
                    System.out.println(" etape 3 : Déposer une pastille de nettoyage, progression : " + (progressBar.getValue()+200)/10+" %");
                    textArea_MessageEcran.setText("\n 3. Déposer une pastille de nettoyage \n\n " +
                            "dans le tirroire et le renfermer \n\n\n et apres continuer avec (Start/Stop)");
                    clickStartStopNettoyage4();
                }
            }
        });
    }

    /**********************************************
     Etape 4
     *********************************************/

    private void clickStartStopNettoyage4() {
        ActionListener updateProBar = actionEvent -> {
            int val4 = progressBar.getValue();
            while (val4 < 600 && val4 >= 400) {
                progressBar.setValue(++val4);
            }
        };
        timer4 = new Timer(50, updateProBar);
        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {

                if (!btnStartStop.getText().equals("End")) {
                    timer4.start();
                    btnStartStop.setText("Stop");
                    System.out.println(" etape 4 : Appuyer sur (Start/Stop), progression : " + (progressBar.getValue()+200)/10+" %");
                    textArea_MessageEcran.setText("\n 4. Appuyer sur Start/Stop \n\n Pour commencer le nettoyage \n\n\n (Le programme dure +/- 7min)" );
                    clickStartStopNettoyage5();
                }
            }
        });
    }

    /**********************************************
     Etape 5
     *********************************************/

    private void clickStartStopNettoyage5() {
        ActionListener updateProBar = actionEvent -> {
            int val5 = progressBar.getValue();
            while (val5 < 800 && val5 >= 600) {
                progressBar.setValue(++val5);
            }
        };
        timer5 = new Timer(50, updateProBar);
        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {

                if (!btnStartStop.getText().equals("End")) {
                    timer5.start();
                    btnStartStop.setText("Stop");
                    System.out.println(" etape 5 : Vider le bac collecteur et le remettre en place, progression : " + (progressBar.getValue()+200)/10+" %");
                    textArea_MessageEcran.setText("\n 5. Vider le bac collecteur, \n\n et le remettre en place \n\n Puis (Start/Stop) pour finir");
                    clickStartStopNettoyage6();
                }
            }
        });
    }

    /**********************************************
     ** Etape 6
     *********************************************/

    private void clickStartStopNettoyage6() {
        ActionListener updateProBar = actionEvent -> {
            int val6 = progressBar.getValue();
            while (val6 < 1000 && val6 >= 800) {
                progressBar.setValue(++val6);
            }
        };
        timer6 = new Timer(50, updateProBar);
        btnStartStop.addActionListener(e -> {
            if (btnStartStop.getText().equals("Start/Stop") && !nettoyageAccompli) {
                if (!btnStartStop.getText().equals("End")) {
                    timer6.start();
                    System.out.println(" etape 6 : Machine prête à fonctionner, progression : "
                            + (progressBar.getValue() + 200) / 10 + " % " +
                            "\n --------------------------------------------------");
                    textArea_MessageEcran.setText("\n\n 6. Machine prête à fonctionner, \n\n Ok pour sortir vers l'ecran principal ");

                    btnStartStop.setText("Stop");
                    btnStartStop.setEnabled(false);
                    btnOk.setEnabled(true);
                    nettoyageAccompli = true;
                }
            }
        });
    }

    /** - Quantité
     * @param utilisateurVue
     * */

    private static void createQuantiteButton(UtilisateurVue utilisateurVue) {
        Quantite.createQuantiteButton(utilisateurVue);
    }

    /** - Intensité
     * @param utilisateurVue
     * */

    private static void createIntensiteButton(UtilisateurVue utilisateurVue) {
        Intensite.createIntensiteButton(utilisateurVue);
    }

    // - Favoris Et/Ou sécurité Enfant

    private void createButtonFavoriSecurite() {
        FavoriSecuriteVue.createButtonFavoriSecurite(this);
    }

    // **********************************************************************************

    // - Gestion des clicks sur le button Ok

    private void manageAllAction() {
        btnOk.addActionListener(e -> {

            /* *********************************************************************************/
            /* *   Urgence !!! à tester le remplisaage de l'eau, des graines
             **   et le vidange du bac
             /**********************************************************************************/

            EntretientVue.remplireReservoirEauAction(this);
            EntretientVue.viderBacCollecteur(this);
            EntretientVue.remplireGrainCafe(this);
            //operationMaintenanceNettoyage();

            //---------------- Click lors de la navigation dans les sous menu Maintenance et leurs possibilités

            if (textArea_MessageEcran.getText().equals(" Appuyer sur (Ok), \n\n pour entrer dans le menu maintenance")) {
                textArea_MessageEcran.setText(" Appuyer sur (Bas), \n\n pour se déplacer, \n\n dans le sous menu maintenance \n\n\n (Ok) pour valider ");
            }

            else if (textField_Choice.getText().equals("Nettoyer le mousseur de lait") || textField_Choice.getText().equals("Détartrage") || textField_Choice.getText().equals("calc'nClean") ) {

                textArea_MessageEcran.setText(" Pour lancer le programme nop");
            }
            // menu pas obliger dans le menu
            else if (textField_Choice.getText().equals("Nettoyage") ) {
                btnBas.setEnabled(false);
                btnRetour.setVisible(true);  // à tester le retour *****************
                btnRetour.setEnabled(true);
                textField_Choice.setText(null);
                textField_Quantite.setText(null);
                textField_Intensite.setText(null);
                textArea_MessageEcran.setText(" Pour lancer le programme Nettoyage, \n\n Appuyer sur (Start/Stop) \n\n Et suivez les instructions sur l'écran.  \n\n (Le programme dure +/- 9min) \n \n En Six étapes ");

                btnStartStop.setEnabled(true);
                btnStartStop.setText("Start/Stop");
                progressBar.setVisible(true);
                progressBar.setEnabled(true);
                btnOk.setEnabled(false);
                btnRetour.setEnabled(false);
                btnMenu.setEnabled(false);
                nettoyageAccompli = false;
                clickStartStopNettoyage1();
            }

            // menu obliger dirigé automatiquement

            else if ( textField_Choice.getText().equals("") && !nettoyageAccompli) {
                btnBas.setEnabled(false);
                btnRetour.setVisible(true);
                btnRetour.setEnabled(true);
                textField_Choice.setText(null);
                textField_Quantite.setText(null);
                textField_Intensite.setText(null);
                textArea_MessageEcran.setText(" Pour lancer le programme Nettoyage, \n\n Appuyer sur (Start/Stop) \n\n Et suivez les instructions sur l'écran.  \n\n (Le programme dure +/- 9min) \n \n En Six étapes ");
                btnStartStop.setEnabled(true);
                btnStartStop.setText("Start/Stop");
                progressBar.setVisible(true);
                progressBar.setEnabled(true);
                btnOk.setEnabled(false);
                btnRetour.setEnabled(false);
                btnMenu.setEnabled(false);
                clickStartStopNettoyage1();
            }
            // reset apres nettoyage
            else if (textArea_MessageEcran.getText().equals("\n\n 6. Machine prête à fonctionner, \n\n Ok pour sortir vers l'ecran principal ") && nettoyageAccompli){
                OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude, btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);

            }


//---------------- Click lors de la navigation dans les sous menu favoris et leurs possibilités

            else if (textArea_MessageEcran.getText().equals(" Appuyer sur (Ok), \n\n pour entrer dans le menu Favori")) {
                textArea_MessageEcran.setText(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Favori, \n\n\n (Ok) pour valider");
            }


// Profile 1  ---------------
            else if (textField_Choice.getText().equals("Profile 1")) {
                textArea_MessageEcran.setText(" Profile 1, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser");
                textField_Choice.setText("Expresso");
                textField_Intensite.setVisible(true);
                textField_Quantite.setVisible(true);
                textField_Quantite.setText("petit");
                textField_Intensite.setText("doux");
                OperationControlleur.enableComposante(btnFavorisSecurite, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);
                OperationControlleur.ensableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
                OperationControlleur.ensableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
                btnFavorisSecurite.setEnabled(false);
                btnBas.setEnabled(false);
            }

            else if (textArea_MessageEcran.getText().equals(" Profile 1, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser")) {
                //DonneeFavoris donneeFavori1 = new DonneeFavoris();
                DonneeFavoris donneeFavori1 = DonneeFavoris.getInstance();
                donneeFavori1.boisson = textField_Choice.getText();
                donneeFavori1.quantite = textField_Quantite.getText();
                donneeFavori1.intensite = textField_Intensite.getText();
                donneeFavori1.deuxTasses = selected;

                ProgressWorker worker = new ProgressWorker(progressBar, textArea_MessageEcran, btnFavorisSecurite, btnOk);

                try {
                    FileOutputStream fileOut1 = new FileOutputStream("src/main/java/daniKazzoul/dataFavori/boisson1.txt");
                    ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
                    out1.writeObject(donneeFavori1);
                    out1.close();
                    fileOut1.close();

                    OperationControlleur.desableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);

                    textArea_MessageEcran.setEnabled(true);
                    textArea_MessageEcran.setText("Vous avez enregistré :\n\n La Boisson pour profile 1 :"+textField_Choice.getText()+"" +
                            "\n\n Quantité :"+textField_Quantite.getText()+"\n\n Intensité :"+textField_Intensite.getText()+"" +
                            "\n\n Deux Tasses : "+selected);

                    btnFavorisSecurite.setEnabled(false);
                    worker.execute();
                }
                catch (IOException i) {  i.printStackTrace();  }

            }


// Profile 2 -----------------------
            else if (textField_Choice.getText().equals("Profile 2")) {
                textArea_MessageEcran.setText(" Profile 2, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser");
                textField_Choice.setText("Expresso");
                textField_Intensite.setVisible(true);
                textField_Quantite.setVisible(true);
                textField_Quantite.setText("petit");
                textField_Intensite.setText("doux");
                OperationControlleur.enableComposante(btnFavorisSecurite, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);
                OperationControlleur.ensableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
                OperationControlleur.ensableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
                btnFavorisSecurite.setEnabled(false);
                btnBas.setEnabled(false);
            }

            else if (textArea_MessageEcran.getText().equals(" Profile 2, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser")) {
                DonneeFavoris donneeFavori2 = DonneeFavoris.getInstance();
                donneeFavori2.boisson = textField_Choice.getText();
                donneeFavori2.quantite = textField_Quantite.getText();
                donneeFavori2.intensite = textField_Intensite.getText();
                donneeFavori2.deuxTasses = selected;

                ProgressWorker worker = new ProgressWorker(progressBar, textArea_MessageEcran, btnFavorisSecurite, btnOk);

                try {
                    FileOutputStream fileOut2 = new FileOutputStream("src/main/java/daniKazzoul/dataFavori/boisson2.txt");
                    ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
                    out2.writeObject(donneeFavori2);
                    out2.close();
                    fileOut2.close();

                    OperationControlleur.desableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);

                    textArea_MessageEcran.setEnabled(true);
                    textArea_MessageEcran.setText("Vous avez enregistré :\n\n La Boisson pour profile 2 :"+textField_Choice.getText()+"" +
                            "\n\n Quantité :"+textField_Quantite.getText()+"\n\n Intensité :"+textField_Intensite.getText()+"" +
                            "\n\n Deux Tasses : "+selected);

                    btnFavorisSecurite.setEnabled(false);
                    worker.execute();
                }
                catch (IOException i) {  i.printStackTrace();  }

            }


//--------------- ce sous menu de langue n'est pas totalement developper! -----------------

            else if (textArea_MessageEcran.getText().equals(" Appuyer sur (Ok), \n\n pour entrer dans le menu Langue")) {
                textArea_MessageEcran.setText(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Langue, \n\n\n (Ok) pour valider");
            }

            else if (textField_Choice.getText().equals("Allemand") || textField_Choice.getText().equals("Français") || textField_Choice.getText().equals("Néerlandais")) {
                textArea_MessageEcran.setText(" Langue choisi : " + textField_Choice.getText() + " \n\n Elle sera mémorisée dans le profile ");
                langue = textField_Choice.getText();
            }


//------ le click (ok) qui réinisialise la machine apres avoir reçu un message d'etretient
// on suppose que l'utilisateur réalise la tâche demander, puis ici il rénitialise la machine

            else if ( textField_Choice.getText().equals("Expresso") || textField_Choice.getText().equals("Café")
                    || textField_Choice.getText().equals("CaféLait") || textField_Choice.getText().equals("Cappuccino")
                    || textField_Choice.getText().equals("EauChaude") || textField_Choice.getText().equals("Americano") )  {
                OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude, btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);
            }

        });

        /* *********************************************************************************/
        /* **********        Gestion des clicks sur le button Bas,
        /**********    en interaction avec le menu et les sous menu     *******************/
        /* *********************************************************************************/

        btnBas.addActionListener(e -> {

            if (textArea_MessageEcran.getText().equals(" Appuyer sur (Bas), \n\n pour se déplacer, \n\n dans le sous menu maintenance \n\n\n (Ok) pour valider ")) {
                BandeauCommande.sousMenuMaintenance(this);
                btnOk.setVisible(true);
                btnOk.setEnabled(true);
            }
            else if (textArea_MessageEcran.getText().equals(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Langue, \n\n\n (Ok) pour valider")) {
                BandeauCommande.sousMenuLangue(this);
                btnOk.setVisible(true);
                btnOk.setEnabled(true);
            }
            else if (textArea_MessageEcran.getText().equals(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Favori, \n\n\n (Ok) pour valider")) {
                BandeauCommande.sousMenuFavori(this);
                btnOk.setVisible(true);
                btnOk.setEnabled(true);
            }

            // l'appel du boutton bas depuis le boutton favorisSecurite pour choisir un profile

            else if ( textField_Choice.getText().equals("Expresso") || textField_Choice.getText().equals("Café")
                    || textField_Choice.getText().equals("CaféLait") || textField_Choice.getText().equals("Cappuccino")
                    || textField_Choice.getText().equals("EauChaude") || textField_Choice.getText().equals("Americano") )  {
//                    textField_Choice.setText("Profile 1");
//                    selectionChoixFavori =1;
// ici je laisse vide, en réponse au click bas dans de l'ecran principal, aucune action ne devait se produire
                OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude, btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);
            }



            else {
                BandeauCommande.actionMenuPrincipal(this);
                btnOk.setVisible(true);
                btnOk.setEnabled(true);
            }

        });

        /* *********************************************************************************/
        /* ******    Gestion des clicks sur le button Retour et entre les sous menu   ******/
        /* *********************************************************************************/

        btnRetour.addActionListener(e -> {

            /* ******************  sortie vers l'ecran         *******************************************/

            if (textField_Choice.getText().equals("Menu Principal")
                    || textField_Choice.getText().equals("Expresso") || textField_Choice.getText().equals("Café")
                    || textField_Choice.getText().equals("CaféLait") || textField_Choice.getText().equals("Cappuccino")
                    || textField_Choice.getText().equals("EauChaude") || textField_Choice.getText().equals("Americano") ) {
                OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude, btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);
            }

            /* ******************  Retour vers sous menu Principal          *******************************************/

            else if (textField_Choice.getText().equals("Maintenance") || textField_Choice.getText().equals("Favori") || textField_Choice.getText().equals("Langue")) {
                System.out.println("Maintenance " + selectionChoixMenu);
                textField_Choice.setText("Menu Principal");
                textArea_MessageEcran.setText(" (V) = se deplacer vers le bas, \n\n (Ok) = confirmer/mémoriser, \n\n (Retour) = revenir en arrière \n\n (menu) = pour quitter!");
            }

            /* ******************   Retour vers sous menu Maintenance          *******************************************/

            else if (textField_Choice.getText().equals("Nettoyer le mousseur de lait") || textField_Choice.getText().equals("Détartrage") || textField_Choice.getText().equals("Nettoyage") || textField_Choice.getText().equals("calc'nClean")) {
                textField_Choice.setText("Maintenance");
                textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu maintenance");
                selectionChoixMenu = 1;
            }

            /* ******************   Retour vers sous menu Favori          *******************************************/

            else if ( textArea_MessageEcran.getText().equals(" Profile 1, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser") ||
                    textArea_MessageEcran.getText().equals(" Profile 2, \n\n Veuillez choisir votre boisson favori, \n\n et vos parametres favoris: \n\n Quantité, Intensité et Une ou deux tasses, \n\n Puis appuyer sur (Ok) pour la mémoriser") ) {
                System.out.println("Favori " + selectionChoixMenu);
                textField_Choice.setText("Favori");
                textArea_MessageEcran.setText(" Appuyer sur (Bas), \n\n pour entrer dans le sous menu Favori, \n\n\n (Ok) pour valider");
                selectionChoixMenu = 2;
                textField_Quantite.setEnabled(false);
                textField_Intensite.setEnabled(false);
                btnBas.setEnabled(true);

            }
            /* ******************    Retour vers sous menu Langue           *******************************************/

            else if (textField_Choice.getText().equals("Allemand") || textField_Choice.getText().equals("Français") || textField_Choice.getText().equals("Néerlandais")) {
                textField_Choice.setText("Langue");
                textArea_MessageEcran.setText(" Appuyer sur (Ok), \n\n pour entrer dans le menu Langue");
                selectionChoixMenu = 0;
            }
        });




        /* *********************************************************************************/
        /* ******************      Gestion des clicks sur le button menu           *********/
        /* *********************************************************************************/

        btnMenu.addActionListener(e -> {

            /* ***********************       Reset de la machine                   ***************************************/
            if (textField_Choice.getText().equals("Expresso") || textField_Choice.getText().equals("Café")
                    || textField_Choice.getText().equals("CaféLait") || textField_Choice.getText().equals("Cappuccino")
                    || textField_Choice.getText().equals("EauChaude") || textField_Choice.getText().equals("Americano")) {
                //        System.out.println(" selectionChoixMenu if1 :"+ selectionChoixMenu+" : "+nettoyageAccompli);

                OperationControlleur.desableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);
                OperationControlleur.desableComposante(btnFavorisSecurite, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite);
                OperationControlleur.desableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
                OperationControlleur.desableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
                textArea_MessageEcran.setEnabled(true);
                textArea_MessageEcran.setText(" (V) = se deplacer vers le bas, \n\n (Ok) = confirmer/mémoriser, \n\n (Retour) = revenir en arrière \n\n (menu) = pour quitter!");
                textField_Choice.setEnabled(true);
                textField_Choice.setText("Menu Principal");
                btnRetour.setEnabled(true);
                btnBas.setEnabled(true);
                btnMenu.setEnabled(true);
            }
            else if ( ( !textField_Choice.getText().equals("Menu Principal") && nettoyageAccompli )
            || textField_Choice.getText().equals("Menu Principal") ) {
                OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses, btnEauChaude, btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit, btnRetour, btnStartStop, progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer, timer1, timer2, timer3, timer4, timer5, timer6);
            }

             /* ** Obligation de faire le nettoyage
             /* s'il est declenché automatiquement apres le comptage de cycle
             /*** on peux plus revenir en arriere !! */

            else if (!nettoyageAccompli) {
                System.out.println(" Necessité de faire le nettoyage ");
                textField_Choice.setText("Menu Principal");
                textArea_MessageEcran.setText(" ");
                btnBas.setEnabled(true);
                btnRetour.setEnabled(true);
                btnOk.setEnabled(true);
            }
        });
    }


}