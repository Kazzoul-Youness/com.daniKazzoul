package daniKazzoul.controller;

import daniKazzoul.model.SingletoneBoissonNomEnum;
import daniKazzoul.model.EntretientReservoirModel;
import daniKazzoul.model.MaintenanceProgrammeModel;
import daniKazzoul.model.SimulateurModel;
import daniKazzoul.view.AbstractView;
import daniKazzoul.view.SimulateurView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimulateurController implements ActionListener {

    public static int cpteurBoissonTotal;

    /** - Singleton Pattern ************************************************************/
    private static SimulateurController instance = new SimulateurController();
    private SimulateurController(){}
    public static SimulateurController getInstance(){
        cpteurBoissonTotal = 0;
        return instance;
    }

    /** MVC *****************************************************************
     *
     * Le model de l'implementation MVC du simulateur.
     */
    private SimulateurModel model;

    /**
     * la view de l'implementation MVC du simulateur.
     */
    private SimulateurView view;

    /**
     * Cela sauvgarde le model et la view.
     *
     * @param model du SimulateurModel pour les fonctions du simulateur et les valeurs
     * @param view du SimulateurView pour ce qui doit être affiché dans GUI
     */
    public SimulateurController(SimulateurModel model, SimulateurView view) {
        this.model = model;
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Exit")) {
            System.exit(0);
        }
        else {
            MaintenanceProgrammeModel.getInstance().checkMaintenanceNettoyage();
            MaintenanceProgrammeModel.getInstance().checkMaintenanceDetartrage();
            MaintenanceProgrammeModel.getInstance().checkMaintenanceCalcNClean();

            EntretientReservoirModel.getInstance().checkNiveauEau();
            EntretientReservoirModel.getInstance().checkNiveauCollecteur();
            EntretientReservoirModel.getInstance().checkNiveauReservoirGraine();

            view.initialize();
        }
    }

    


    /************************************************************************
    * Ravitaillement et Maintenance de la machine qui declenche l'entretient
    *
    * Remplissage du reservoir d'eau tout les multiples de 2
    * Vidange du bac collecteur tout les multiples de 3
    * Remplissage des graine de café 4
    *
    * Nettoyage est déclenché tous les multiple de 2
    * Deratrage est déclenché tous les multiple de 3
    * calc'nClean est déclenché tous les multiple de 2(Nettoyage) * 3(Deratrage) = 6
     *********************************************************************/


    /** Déclenche la necessité de remplissage le reservoir d'eau
    * envoie le code 1 si il faut le remplir sinon code 0
    * */

    public static int passerActionReservoirEau() {
        if (EntretientReservoirModel.getInstance().checkNiveauEau() == 1) {
           return 1;
        }
        return 0;
    }

    /** Déclenche la necessité de viderBac le bac collecteur
     * envoie le code 1 si il faut le viderBac
     * sinon code 0 */

    public static int passerActionBacColecteur() {
        if (EntretientReservoirModel.getInstance().checkNiveauCollecteur() == 1) {
            return 1;
        }
        return 0;
    }

    /** Déclenche la necessité de remplissage les graines à café
    *  envoie le code 1 si il faut les remplir
    *  sinon code 0 */

    public static int passerActionReservoirGraine() {
        if (EntretientReservoirModel.getInstance().checkNiveauReservoirGraine() == 1 ) {
            return 1;
        }
        return 0;
    }

    /** action qui declench la maintenance nettoyage automatique
     * basé sur le comptage des boissons avec le setCpteurBoissonTotal */

    public static int passerActionComptageBoissonNettoyage() {
        if (MaintenanceProgrammeModel.getInstance().checkMaintenanceNettoyage() == 1){
            return 1;
        }
        return 0;
    }

    /** actions qui declenchent la maintenance detartrage automatique
     * basé sur le comptage des boissons avec le setCpteurBoissonTotal */

    public static int passerActionComptageBoissonDetartrage() {
        if (MaintenanceProgrammeModel.getInstance().checkMaintenanceDetartrage() == 1){
            return 1;
        }
        return 0;
    }

    /** actions qui declenchent la maintenance calc'nClean automatique
     * basé sur le comptage des boissons avec le setCpteurBoissonTotal */
    public static int passerActionComptageBoissonCalcNClean() {
        if (MaintenanceProgrammeModel.getInstance().checkMaintenanceCalcNClean() == 1){
            return 1;
        }
        return 0;
    }


    public static int setCpteurBoissonTotal(){

        return cpteurBoissonTotal++;
    }

    public static int getCpteurBoissonTotal(){

        return cpteurBoissonTotal;
    }


    /** Register le controller comme un listener pour les bouttons
     * le gestionnaire d'événements pour le simulateur
     */
    public void registerListener() {

        AbstractView.btnExpresso.addActionListener(e -> AbstractView.textField_Choice.setText(String.valueOf(SingletoneBoissonNomEnum.SingleBoissonNomEnum.Expresso)));
        AbstractView.btnCafe.addActionListener(e -> AbstractView.textField_Choice.setText(String.valueOf(SingletoneBoissonNomEnum.SingleBoissonNomEnum.Cafe)));
        AbstractView.btnCafeLait.addActionListener(e -> AbstractView.textField_Choice.setText(String.valueOf(SingletoneBoissonNomEnum.SingleBoissonNomEnum.CafeLait)));
        AbstractView.btnCappuccino.addActionListener(e -> AbstractView.textField_Choice.setText(String.valueOf(SingletoneBoissonNomEnum.SingleBoissonNomEnum.Cappuccino)));
        AbstractView.btnEauChaude.addActionListener(e -> AbstractView.textField_Choice.setText(String.valueOf(SingletoneBoissonNomEnum.SingleBoissonNomEnum.EauChaude)));
        AbstractView.btnAmericano.addActionListener(e -> AbstractView.textField_Choice.setText(String.valueOf(SingletoneBoissonNomEnum.SingleBoissonNomEnum.Americano)));

        AbstractView.btnStartStop.addActionListener(e -> { });
        AbstractView.btnMenu.addActionListener(e -> { });
        AbstractView.btnOk.addActionListener(e -> { });
        AbstractView.btnBas.addActionListener(e -> { });
        AbstractView.btnRetour.addActionListener(e -> { });

        AbstractView.btnQuantit.addActionListener(e -> { });
        AbstractView.btnIntensit.addActionListener(e -> { });
        AbstractView.btnDeuxtasses.addActionListener(e -> { });
        AbstractView.btnFavorisSecurite.addActionListener(e -> { });

    }



}

