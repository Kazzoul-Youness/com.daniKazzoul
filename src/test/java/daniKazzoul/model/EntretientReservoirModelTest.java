package daniKazzoul.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntretientReservoirModelTest {


    /** Tests Reservoir d'eau *************************/

    @Test
    public void checkNiveauEauTest1() {
        assertEquals(EntretientReservoirModel.getInstance().checkNiveauEau(), 1);
    }

    @Test
    public void checkNiveauEauTest2() {
        EntretientReservoirModel.getInstance().consommerBoissonParReservoir();
        assertEquals(EntretientReservoirModel.getInstance().checkNiveauEau(), 0);
    }

    @Test
    public void consommerBoissonParReservoirTest() {
        EntretientReservoirModel.getInstance().consommerBoissonParReservoir(); //on increment de 1
        assertEquals(EntretientReservoirModel.getInstance().getCptEau(), 1);	// on test la sortie si c'est ok
    }

    @Test
    public void remplireEauTest() {
        EntretientReservoirModel.getInstance().remplireEau();	// cette methode met le compteur a 0, quand elle est appeller lors de remplissage d'eau
        assertEquals(EntretientReservoirModel.getInstance().getCptEau(), 0);	// on verifier si le test est passé
    }

    @Test
    public void getCptEauTest() {
        assertEquals(EntretientReservoirModel.getInstance().getCptEau(), 1);	// on verifier si le test est passé
    }


    /** Tests le Bac collecteur *************************/

    @Test
    public void checkNiveauCollecteur1() {
        assertEquals(EntretientReservoirModel.getInstance().checkNiveauCollecteur(), 1);
    }

    @Test
    public void checkNiveauCollecteur2() {
        EntretientReservoirModel.getInstance().consomerBoissonCollecteur();
        assertEquals(EntretientReservoirModel.getInstance().checkNiveauCollecteur(), 0);
    }

    @Test
    public void consomerBoissonCollecteurTest() {
        EntretientReservoirModel.getInstance().consomerBoissonCollecteur(); //on increment de 1
        assertEquals(EntretientReservoirModel.getInstance().getCptBac(), 1);	// on test la sortie si c'est ok
    }

    @Test
    public void viderBacTest() {
        EntretientReservoirModel.getInstance().viderBac();	// cette methode met le compteur a 0, quand elle est appeller lors de vidange du bac collecteur
        assertEquals(EntretientReservoirModel.getInstance().getCptBac(), 0);	// on verifier si le test est passé
    }

    @Test
    public void getCptBacTest() {
        assertEquals(EntretientReservoirModel.getInstance().getCptBac(), 0);	// on verifier si le test est passé
    }

    /** Tests le reservoir des Graines Café *************************/

    @Test
    public void checkNiveauReservoirGraine1() {
        assertEquals(EntretientReservoirModel.getInstance().checkNiveauReservoirGraine(), 1);
    }

    @Test
    public void checkNiveauReservoirGraine2() {
        EntretientReservoirModel.getInstance().consommerBoissonParGraine();
        assertEquals(EntretientReservoirModel.getInstance().checkNiveauReservoirGraine(), 0);
    }

    @Test
    public void consommerBoissonParGraineTest() {
        EntretientReservoirModel.getInstance().consommerBoissonParGraine(); //on increment de 1
        assertEquals(EntretientReservoirModel.getInstance().getCptGraine(), 2);	// on test la sortie si c'est ok
    }

    @Test
    public void remplireGraineTest() {
        EntretientReservoirModel.getInstance().viderBac();	// cette methode met le compteur a 0, quand elle est appeller lors de remplissage du café
        assertEquals(EntretientReservoirModel.getInstance().getCptGraine(), 0);	// on verifier si le test est passé
    }

    @Test
    public void getCptGraineTest() {
        assertEquals(EntretientReservoirModel.getInstance().getCptGraine(), 2);	// on verifier si le test est passé
    }





}