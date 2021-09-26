package daniKazzoul.view;

import daniKazzoul.components.BandeauCommande;
import daniKazzoul.components.CreateRoundButton;
import daniKazzoul.controller.MaintenanceEntretientController;
import daniKazzoul.controller.SimulateurController;
import daniKazzoul.model.SingletoneIntensiteEnum;
import daniKazzoul.model.SingletoneQuantiteEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static daniKazzoul.model.SimulateurModel.checkActionReturnGlobal;
import static daniKazzoul.model.SimulateurModel.getEntretientAction;
import static daniKazzoul.view.OperationsView.*;

public class SimulateurView extends AbstractView {

    /** initialise les valeurs **/
    public static int selectionChoixMenu = 0;
    public int selectionChoixMaintenance = 0;
    public static int selectionChoixFavori = 0;
    public static boolean securiteActive;
    int afficherInfoAvant = 0;
    int compteBoisson = 0;
    int entretientAction = 0;


    /** Creation de l'application **/
     public SimulateurView(){
         initialize();
     }


    /** Initialiser le contenu de la frame **/
    public void initialize() {

        createJframe();
        BandeauCommande.getInstance().createProgressBar(this);
        createStartStopButton();
        NettoyageView.getInstance().clickStartStopNettoyage1();
        DetartrageView.getInstance().clickStartStopDetartrage1();
        CalcNCleanView.getInstance().clickStartStopCalcNClean1();
        NettoyageMousseurView.getInstance().clickStartStopNettoyageMousseur1();
        BasBouttonView.getInstance().createBasButton(this);
        OkBouttonView.getInstance().createOKButton(this);
        MenuBouttonView.getInstance().createButtonMenu(this);
        RetourBouttonView.getInstance().createRetourButton(this);
        createButtonFavoriSecurite(this);

        createExpressoButton();
        createCafeButton();
        createCafeAuLaitButton();
        createCappuccinoButton();
        createEauChaudeButton();
        createAmericanoButton();

        createQuantiteButton();
        createIntensiteButton();
        createDeuxTasseButton();
        setFocusDeuxTasses(false);
        createJTextField();
        createJTextArea();

        /* ** Reset Les reservoirs d'entretient
        ** et les programmes de maintenance de la machine au du demarrage */

        MaintenanceEntretientController.remplireReservoirEauAction(SimulateurController.passerActionReservoirEau());
        MaintenanceEntretientController.viderBacCollecteurAction(SimulateurController.passerActionBacColecteur());
        MaintenanceEntretientController.remplireGrainCafeAction(SimulateurController.passerActionReservoirGraine());
        MaintenanceEntretientController.nettoyerMachineAction(SimulateurController.passerActionComptageBoissonNettoyage());
        MaintenanceEntretientController.detartrerMachineAction(SimulateurController.passerActionComptageBoissonDetartrage());
        MaintenanceEntretientController.calcNCleanMachineAction(SimulateurController.passerActionComptageBoissonCalcNClean());


    }


    /**
     * * Start/Stop boutton (Lancer une boisson )
     ***/

    public void createStartStopButton() {
        /* Boutton rond via la class CreateRoundButton */
        btnStartStop = new CreateRoundButton("Start/Stop");
        btnStartStop.setBounds(830, 14, 150, 150);
        btnStartStop.setFont(new Font("Dialog", Font.BOLD, 20));
        frame.getContentPane().add(btnStartStop);


        // La progression d'un écoulement d'une boisson
        ActionListener updateProBar = actionEvent -> {
            int val = progressBar.getValue();
            if (val >= 1000) {
                if (!nettoyageAccompli || !detartrageAccompli || !nettoyerMousseurAccompli || !calcNCleanAccompli) {
                    btnStartStop.setEnabled(false);
                    checkActionReturnGlobal(SimulateurController.passerActionReservoirEau(),
                            SimulateurController.passerActionBacColecteur(),
                            SimulateurController.passerActionReservoirGraine(),
                            SimulateurController.passerActionComptageBoissonNettoyage(),
                            SimulateurController.passerActionComptageBoissonDetartrage());
                }
                if (nettoyageAccompli && detartrageAccompli && nettoyerMousseurAccompli && calcNCleanAccompli) {
                    btnStartStop.doClick();
                }
                btnStartStop.setText("Start/Stop");  // pour l'interruption pendant l'écoulement
                timer.stop();
                progressBar.setValue(0);
                btnOk.setEnabled(true);
                return;
            }
            progressBar.setValue(++val);
        };
        timer = new Timer(1, updateProBar);


        btnStartStop.addActionListener(e -> {

            if (btnStartStop.getText().equals("Start/Stop") ) {
                System.out.println(" -----------------------   Ecoulement de boisson   --------------------------");
                System.out.println(" "+textField_Choice.getText()+" : "+textField_Quantite.getText()+" : "+textField_Intensite.getText());

                OperationsView.disableOtherFunction(AbstractView.btnAmericano, AbstractView.btnBas, AbstractView.btnCafe, AbstractView.btnCafeLait,
                        AbstractView.btnCappuccino, AbstractView.btnDeuxtasses, AbstractView.btnEauChaude, AbstractView.btnExpresso,
                        AbstractView.btnFavorisSecurite, AbstractView.btnIntensit, AbstractView.btnMenu, AbstractView.btnOk, AbstractView.btnQuantit,
                        AbstractView.btnRetour, AbstractView.textField_Choice, AbstractView.textField_Quantite, AbstractView.textField_Intensite);
                selected = btnDeuxtasses.isSelected();

                MaintenanceEntretientController.miseAJourTotal();

                SimulateurController.setCpteurBoissonTotal();
                compteBoisson = SimulateurController.getCpteurBoissonTotal();


                checkActionReturnGlobal(SimulateurController.passerActionReservoirEau(),
                        SimulateurController.passerActionBacColecteur(),
                        SimulateurController.passerActionReservoirGraine(),
                        SimulateurController.passerActionComptageBoissonNettoyage(),
                        SimulateurController.passerActionComptageBoissonDetartrage());

                entretientAction = getEntretientAction();

                System.out.println("Boisson N°" + compteBoisson + " | entretientAction= " + entretientAction +
                        "| ReservoirEau = " + SimulateurController.passerActionReservoirEau() +
                        " | Bac = " + SimulateurController.passerActionBacColecteur() +
                        " | Graine = " + SimulateurController.passerActionReservoirGraine() +
                        " | Nettoyage = " + SimulateurController.passerActionComptageBoissonNettoyage() +
                        " | Detartrer = " + SimulateurController.passerActionComptageBoissonDetartrage() +
                        " | calc'nClean = " + SimulateurController.passerActionComptageBoissonCalcNClean() +
                        "\n ----------------------------------------------------------------------------");


                timer.start();
                btnStartStop.setText("Stop");
                btnStartStop.setEnabled(true);
                btnOk.setEnabled(false);
                textArea_MessageEcran.setText("\n\n Appuyer sur (Stop) pour annuler!\n");

            } else if (btnStartStop.getText().equals("Stop")
                    && nettoyageAccompli && detartrageAccompli && nettoyerMousseurAccompli && calcNCleanAccompli) {

                enableBoisson(btnAmericano, btnCafe, btnCafeLait, btnCappuccino, btnEauChaude, btnExpresso);
                enableParametre(btnDeuxtasses, btnIntensit, btnQuantit);
                enableTableauBord(btnBas, btnMenu, btnOk, btnRetour, btnStartStop);
                enableComposante(progressBar, textArea_MessageEcran, textField_Choice, textField_Intensite, textField_Quantite, timer);
                progressBar.setValue(0);
                btnStartStop.setText("Start/Stop");
                textArea_MessageEcran.setText(null);

                if (entretientAction != 0) {
                    textArea_MessageEcran.setText(null);
                    checkActionReturnGlobal(SimulateurController.passerActionReservoirEau(),
                            SimulateurController.passerActionBacColecteur(),
                            SimulateurController.passerActionReservoirGraine(),
                            SimulateurController.passerActionComptageBoissonNettoyage(),
                            SimulateurController.passerActionComptageBoissonDetartrage());
                    btnStartStop.setEnabled(false);
                    btnBas.setEnabled(false);
                    btnMenu.setEnabled(false);
                    btnRetour.setEnabled(false);
                    btnFavorisSecurite.setEnabled(false);
                }

            } else if (btnStartStop.getText().equals("Stop")
                    && (!nettoyageAccompli || !detartrageAccompli || !nettoyerMousseurAccompli || !calcNCleanAccompli)) {

                btnStartStop.setText("Start/Stop");
                btnStartStop.setEnabled(false);
                btnOk.setEnabled(true);
                progressBar.setValue(0);
                timer.stop();
                checkActionReturnGlobal(SimulateurController.passerActionReservoirEau(),
                        SimulateurController.passerActionBacColecteur(),
                        SimulateurController.passerActionReservoirGraine(),
                        SimulateurController.passerActionComptageBoissonNettoyage(),
                        SimulateurController.passerActionComptageBoissonDetartrage());

            } else if (btnStartStop.getText().equals("End")) {
                btnStartStop.setText("Start/Stop");
            }

        });
    }


    /**
     * Parametre de la boisson*
     * **
     * *    Quantité
     *******/

    public void createQuantiteButton() {
        btnQuantit = new JButton("Quantite");
        btnQuantit.addActionListener(e -> {
            if (quantite == 0) {
                textField_Quantite.setText(String.valueOf(SingletoneQuantiteEnum.SingleQuantiteEnum.Moyen));
                quantite++;
            } else if (quantite == 1) {
                textField_Quantite.setText(String.valueOf(SingletoneQuantiteEnum.SingleQuantiteEnum.Grand));
                quantite++;
            } else if (quantite == 2) {
                textField_Quantite.setText(String.valueOf(SingletoneQuantiteEnum.SingleQuantiteEnum.Petit));
                quantite = 0;
            }
        });

        btnQuantit.setFont(new Font("Dialog", Font.BOLD, 18));
        btnQuantit.setBounds(150, 420, 120, 120);
        frame.getContentPane().add(btnQuantit);
    }


    /**
     * Intensité
     ***/

    public void createIntensiteButton() {
        btnIntensit = new JButton("Intensite");
        btnIntensit.addActionListener(e -> {
            if (intensite == 0) {
                textField_Intensite.setText(String.valueOf(SingletoneIntensiteEnum.SingleIntensiteEnum.Normal));
                intensite++;
            } else if (intensite == 1) {
                textField_Intensite.setText(String.valueOf(SingletoneIntensiteEnum.SingleIntensiteEnum.Fort));
                intensite++;
            } else if (intensite == 2) {
                textField_Intensite.setText(String.valueOf(SingletoneIntensiteEnum.SingleIntensiteEnum.Doux));
                intensite = 0;
            }
        });

        btnIntensit.setFont(new Font("Dialog", Font.BOLD, 18));
        btnIntensit.setBounds(690, 420, 120, 120);
        frame.getContentPane().add(btnIntensit);

    }


    /***
     * Deux Tasses  **/

    public void createDeuxTasseButton() {
        btnDeuxtasses = new JButton("");
        btnDeuxtasses.setIcon(new ImageIcon("icon//DeuxTasses.png"));
        btnDeuxtasses.setForeground(new Color(204, 255, 255));
        btnDeuxtasses.setBackground(new Color(51, 51, 51));
        btnDeuxtasses.addActionListener(e -> setFocusDeuxTasses(!selected));
        btnDeuxtasses.setBounds(12, 420, 110, 110);
        frame.getContentPane().add(btnDeuxtasses);
    }


    /**
     * Focus quand selectionné
     */

    public void setFocusDeuxTasses(boolean b) {
        selected = b;
        btnDeuxtasses.setSelected(b);
        btnDeuxtasses.setFocusable(b);
        if (b) {
            btnDeuxtasses.setBackground(new Color(100, 51, 51));
        } else {
            btnDeuxtasses.setBackground(new Color(51, 51, 51));
        }

    }


    /**
     * Favoris Et/Ou sécurité Enfant
     **/

    public static void createButtonFavoriSecurite(SimulateurView simulateurView) {
        btnFavorisSecurite = new JButton("FavoriSecurite");

        btnFavorisSecurite.setBounds(822, 420, 170, 120);
        btnFavorisSecurite.setFont(new Font("Dialog", Font.BOLD, 17));
        simulateurView.frame.getContentPane().add(btnFavorisSecurite);

        /* ******* Obtenir une boisson Favori ********/
        btnFavorisSecurite.addActionListener(e -> FavoriView.favori(simulateurView));


        /* *** activer desactiver la Securite  *****/
        SecuriteView.Securite(simulateurView);

    }

}
