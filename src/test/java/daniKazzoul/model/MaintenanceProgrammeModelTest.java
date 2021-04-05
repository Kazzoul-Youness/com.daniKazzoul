package daniKazzoul.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceProgrammeModelTest {


    /*** Test Programme Maintenance - Nettoyage ************************/
    // Test cas normal
    @Test
    void checkMaintenanceNettoyageTest1() {
        assertEquals(MaintenanceProgrammeModel.getInstance().checkMaintenanceNettoyage(), 0); // faire une boisson le cas normal
    }

    // Test cas déclencheur de message maintenance
    @Test
    void checkMaintenanceNettoyageTest2() {
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantNettoyage();
        assertEquals(MaintenanceProgrammeModel.getInstance().checkMaintenanceNettoyage(), 1); // le cas d'un déclenchement de maintenance nettoyage
    }

    // Consomation
    @Test
    void consommerBoissonAvantMaintenanceNettoyageTest() {
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantNettoyage(); //on increment de 1
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptNettoyage(), 1);	// on test la sortie si c'est ok
    }

    // Test - Rénitialisation
    @Test
    void nettoyerTest() {
        MaintenanceProgrammeModel.getInstance().nettoyer();	// cette methode met le compteur a 0, quand elle est appeller lors de remplissage du café
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptNettoyage(), 0);	// on verifier si le test est passé
    }

    //Test - Getter compteur
    @Test
    void getCptNettoyageTest() {
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptNettoyage(), 0);	// on verifier si le test est passé
    }


    /*** Test Programme Maintenance - Détartrage ************************/
    // Test cas normal
    @Test
    void checkMaintenanceDetartrageTest1() {
        assertEquals(MaintenanceProgrammeModel.getInstance().checkMaintenanceDetartrage(), 0); // faire une boisson le cas normal
    }

    // Test cas déclencheur de message maintenance
    @Test
    void checkMaintenanceDetartrageTest2() {
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantDetartrage();
        assertEquals(MaintenanceProgrammeModel.getInstance().checkMaintenanceDetartrage(), 0); // le cas d'un déclenchement de maintenance Détartrage
    }

    // Consomation
    @Test
    void consommerBoissonAvantMaintenanceDetartrageTest() {
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantDetartrage(); //on increment de 1
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptDetartrage(), 1);	// on test la sortie si c'est ok
    }

    // Test - Rénitialisation
    @Test
    void detartrerTest() {
        MaintenanceProgrammeModel.getInstance().detartrer();	// cette methode met le compteur a 0, quand elle est appeller lors du détartrage de la machine
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptNettoyage(), 0);	// on verifier si le test est passé
    }

    //Test - Getter compteur
    @Test
    void getCptDetartrageTest() {
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptNettoyage(), 0);	// on verifier si le test est passé
    }


    /*** Test Programme Maintenance - calc'nClean ************************/
    // Test cas normal
    @Test
    void checkMaintenanceCalcNCleanTest1() {
        assertEquals(MaintenanceProgrammeModel.getInstance().checkMaintenanceCalcNClean(), 0); // faire une boisson le cas normal
    }

    // Test cas déclencheur de message maintenance
    @Test
    void checkMaintenanceCalcNCleanTest2() {
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantCalcNClean();
        assertEquals(MaintenanceProgrammeModel.getInstance().checkMaintenanceCalcNClean(), 0); // le cas d'un déclenchement de maintenance calc'nClean
    }

    // Consomation
    @Test
    void consommerBoissonAvantMaintenanceCalcNCleanTest() {
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantCalcNClean(); //on increment de 1
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptCalcNClean(), 1);	// on test la sortie si c'est ok
    }

    // Test - Rénitialisation
    @Test
    void calcNCleanTest() {
        MaintenanceProgrammeModel.getInstance().detartrer();	// cette methode met le compteur a 0, quand elle est appeller lors du calc'nClean de la machine
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptCalcNClean(), 2);	// on verifier si le test est passé
    }

    //Test - Getter compteur
    @Test
    void getCptCalcNCleanTest() {
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptCalcNClean(), 1);	// on verifier si le test est passé
    }


}