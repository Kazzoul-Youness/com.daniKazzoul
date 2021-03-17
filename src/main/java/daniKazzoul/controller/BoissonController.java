package daniKazzoul.controller;

import daniKazzoul.components.BacCollecteur;
import daniKazzoul.components.Nettoyeur;
import daniKazzoul.components.ReservoirEau;
import daniKazzoul.components.ReservoirGraine;
import daniKazzoul.view.DemarrageVue;


public class BoissonController {

    // - Singleton Pattern
    private static final BoissonController instance = new BoissonController();
    public static int cpteurBoissonTotal;

    //constructeur privé pour éviter que les applications clientes utilisent le constructeur
    private BoissonController(){
    }

    public static BoissonController getInstance(){
        cpteurBoissonTotal = 0;
        return instance;
    }


    /* Ravitaillement de la machine qui declench l'entretient
    *
    *
    * Déclenche la necessité de remplir le reservoir d'eau
    * envoie le code 1 si il faut le remplir
    * sinon code -1 */

    public int passerActionReservoirEau() {
        if (ReservoirEau.checkNiveauEau() == 1) {
            return 1;
        }
        return -1;
    }

    /* Déclenche la necessité de vider le bac collecteur
     * envoie le code 2 si il faut le vider
     * sinon code -2 */

    public int passerActionBacColecteur() {
        if (BacCollecteur.checkNiveauCollecteur() == 2) {
            return 2;
        }
        return -2;
    }

    /* Déclenche la necessité de remplissage les graines à café
    *  envoie le code 3 si il faut les remplir
    *  sinon code -3 */


    public int passerActionReservoirGraine() {
        if (ReservoirGraine.checkNiveauReservoirGraine() == 3) {
            return 3;
        }
        return -3;
    }

    /* action qui declench la maintenance netooyage automatique
     basé sur le comptage des boissons avec le cpteurBoissonTotal */

    public int passerActionComptageBoisson() {
        if (Nettoyeur.checkMaintenanceNettoayge() == 4){
            return 4;
        }
        return -4;
    }


    /* Verification au demarrage, et a chaque selection d'une boisson!
    /* Pour soit remplir l'eau et/ou graine et/ou vider bac. */

    public void miseAJourTotalBoisson(String BoissonNom) throws Exception {
        DemarrageVue.miseAJourTotalBoisson(this, BoissonNom);
    }


}

