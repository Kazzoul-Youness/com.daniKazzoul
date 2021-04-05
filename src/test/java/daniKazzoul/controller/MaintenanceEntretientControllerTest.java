package daniKazzoul.controller;

import daniKazzoul.model.EntretientReservoirModel;
import daniKazzoul.model.MaintenanceProgrammeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceEntretientControllerTest {

    private MaintenanceEntretientControllerTest() {};
    private static MaintenanceEntretientControllerTest instance = null;
    public static MaintenanceEntretientControllerTest getInstance() {
        if(instance == null) instance = new MaintenanceEntretientControllerTest();
        return instance;
    }


    @BeforeEach
    void resetSingleton() throws SecurityException, NoSuchFieldException,  IllegalArgumentException, IllegalAccessException {
        Field instance = MaintenanceEntretientControllerTest.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        MaintenanceEntretientControllerTest.getInstance();
    }


    @Test
    void testremplireReservoirEauAction(){
        EntretientReservoirModel.getInstance().remplireEau();
        assertEquals(EntretientReservoirModel.getInstance().getCptEau(),0);
    }

    @Test
    void testviderBacCollecteurAction(){
        EntretientReservoirModel.getInstance().viderBac();
        assertEquals(EntretientReservoirModel.getInstance().getCptBac(),0);
    }

    @Test
    void testremplireGrainCafeAction(){
        EntretientReservoirModel.getInstance().remplireGraine();
        assertEquals(EntretientReservoirModel.getInstance().getCptGraine(),0);
    }


    @Test
    void testnettoyerMachineAction(){
        MaintenanceProgrammeModel.getInstance().nettoyer();
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptNettoyage(),0);
    }

    @Test
    void testdetartrerMachineAction(){
        MaintenanceProgrammeModel.getInstance().detartrer();
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptDetartrage(),0);
    }

    @Test
    void testcalcNCleanMachineAction(){
        MaintenanceProgrammeModel.getInstance().calcNClean();
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptCalcNClean(),0);
    }

   @Test
    void testmiseAJourTotalCasReservoirEau(){
       EntretientReservoirModel.getInstance().consommerBoissonParReservoir();
       assertEquals(EntretientReservoirModel.getInstance().getCptEau(),1);
   }

    @Test
    void testmiseAJourTotalCasBacCollecteur(){
        EntretientReservoirModel.getInstance().consomerBoissonCollecteur();
        assertEquals(EntretientReservoirModel.getInstance().getCptBac(),1);
    }

    @Test
    void testmiseAJourTotalCasReservoirGraineCafe(){
        EntretientReservoirModel.getInstance().consommerBoissonParGraine();
        assertEquals(EntretientReservoirModel.getInstance().getCptGraine(),1);
    }


    @Test
    public void testmiseAJourTotalCasNettoyage(){
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantNettoyage();
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptNettoyage(),1);
    }

    @Test
    public void testmiseAJourTotalCasDetartrage(){
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantDetartrage();
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptDetartrage(),1);
    }

    @Test
    public void testmiseAJourTotalCasCalcNClean(){
        MaintenanceProgrammeModel.getInstance().consommerBoissonAvantCalcNClean();
        assertEquals(MaintenanceProgrammeModel.getInstance().getCptCalcNClean(),1);
    }






}