package daniKazzoul.view;

import daniKazzoul.controller.BoissonController;

import java.io.FileNotFoundException;

public class DemarrageVue extends UtilisateurVue{

    public DemarrageVue() throws FileNotFoundException {
    }

    // Verification du demarrage, et a chaque selection d'une boisson!
    // remplir l'eau et/ou graine et/ou vider bac.

    public static void miseAJourTotalBoisson(BoissonController boissonController, String BoissonNom) throws Exception {
        switch (BoissonNom) {
            case "Expresso":
            case "Café":
                BoissonVue.consomationBoissonCafe();
                break;
            case "CaféLait":
            case "Cappuccino":
                BoissonVue.consomationBoissonLactee();
                break;
            case "EauChaude":
            case "Americano":
                BoissonVue.consomationBoissonSpecial();
                break;
            default:
                throw new Exception(" action mise à jours du demarrage est incorrecte");
        }
    }
}
