package daniKazzoul.view;

import daniKazzoul.controller.MaintenanceEntretientController;
import daniKazzoul.controller.SimulateurController;
import org.junit.jupiter.api.Test;

import static daniKazzoul.model.SimulateurModel.getEntretientAction;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulateurViewTest {


    int compteBoisson = 0;
    int entretientAction = 0;
    // int quantite = 0;

    /* Simuler une boisson  */
    @Test
    void testcreateStartStopButton(){

        MaintenanceEntretientController.miseAJourTotal();

        SimulateurController.setCpteurBoissonTotal(); // incrementer le compteur une fois
        compteBoisson = SimulateurController.getCpteurBoissonTotal(); // aller voir la sortie
        assertEquals(compteBoisson,1); // verifier si c'est ok

        entretientAction = getEntretientAction(); // le code retour de la premiere boisson
        assertEquals(entretientAction,0); // verification

    }










}