package daniKazzoul.controller;

import daniKazzoul.model.SimulateurModel;
import daniKazzoul.view.SimulateurView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import static daniKazzoul.model.SimulateurModel.*;


public class SimulateurController implements ActionListener {

    // - Singleton Pattern ---------------------------------------------
    private static final SimulateurController instance = new SimulateurController();
    public static int cpteurBoissonTotal;

    //constructeur privé pour éviter que les applications clientes utilisent le constructeur
    private SimulateurController(){
    }

    public static SimulateurController getInstance(){
        cpteurBoissonTotal = 1;
        return instance;
    }

    /** MVC
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
            model.checkMaintenanceNettoyage();
            model.checkMaintenanceDetartrage();
            model.checkMaintenanceCalcNClean();
            model.checkNiveauEau();
            model.checkNiveauCollecteur();
            model.checkNiveauReservoirGraine();

            try {
                new SimulateurView();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
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
        if (SimulateurModel.checkNiveauEau() == 1) {
           return 1;
        }
        return 0;
    }

    /** Déclenche la necessité de viderBac le bac collecteur
     * envoie le code 1 si il faut le viderBac
     * sinon code 0 */

    public static int passerActionBacColecteur() {
        if (SimulateurModel.checkNiveauCollecteur() == 1) {
            return 1;
        }
        return 0;
    }

    /** Déclenche la necessité de remplissage les graines à café
    *  envoie le code 1 si il faut les remplir
    *  sinon code 0 */

    public static int passerActionReservoirGraine() {
        if (SimulateurModel.checkNiveauReservoirGraine() == 1 ) {
            return 1;
        }
        return 0;
    }

    /** action qui declench la maintenance nettoyage automatique
     * basé sur le comptage des boissons avec le cpteurBoissonTotal */

    public static int passerActionComptageBoissonNettoyage() {
        if (SimulateurModel.checkMaintenanceNettoyage() == 1){
            return 1;
        }
        return 0;
    }

    /** actions qui declenchent la maintenance detartrage automatique
     * basé sur le comptage des boissons avec le cpteurBoissonTotal */

    public static int passerActionComptageBoissonDetartrage() {
        if (SimulateurModel.checkMaintenanceDetartrage() == 1){
            return 1;
        }
        return 0;
    }

    /** actions qui declenchent la maintenance calc'nClean automatique
     * basé sur le comptage des boissons avec le cpteurBoissonTotal */
    public static int passerActionComptageBoissonCalcNClean() {
        if (SimulateurModel.checkMaintenanceCalcNClean() == 1){
            return 1;
        }
        return 0;
    }

    /********************************************************/
    /**  Verification au demarrage, et a chaque selection d'une boisson!
    /*** Pour: soit remplir l'eau, remplir les graine, viderBac le bac,
    **** et les programmes de maintenance : nettoyage, détartrage, calc'nClean
    ***/

    public void miseAJourTotal(String BoissonNom) {
        System.out.println( "*** miseAJourTotal : "+BoissonNom );

        if (BoissonNom.equals("EauChaude")){     // les boissons Eau chaude ne consomme pas de graines de café !
            consommerBoissonParReservoir();
            consomerBoissonCollecteur();
//            consommerBoissonParGraine();
        }
        else /* if ( BoissonNom.equals(BoissonNomEnum.Expresso) || BoissonNom.equals(BoissonNomEnum.Cafe)
                || BoissonNom.equals(BoissonNomEnum.CafeLait) || BoissonNom.equals(BoissonNomEnum.Cappuccino)
                || BoissonNom.equals(BoissonNomEnum.Americano)) */{
            consommerBoissonParReservoir();
            consomerBoissonCollecteur();
            consommerBoissonParGraine();
        }
        consommerBoissonAvantMaintenance();
    }

    public static int getCpteurBoissonTotal(){
        return cpteurBoissonTotal++;
    }

//    public static int actionReturnGlobal(int entretientAction){
//        SimulateurModel.checkActionReturnGlobal(SimulateurController.passerActionReservoirEau(), SimulateurController.passerActionBacColecteur(), SimulateurController.passerActionReservoirGraine(), SimulateurController.passerActionComptageBoissonNettoyage(), SimulateurController.passerActionComptageBoissonDetartrage(), entretientAction);
//    }


}

