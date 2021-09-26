package daniKazzoul.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static daniKazzoul.controller.SimulateurController.setCpteurBoissonTotal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulateurControllerTest {

    private static SimulateurControllerTest instance = new SimulateurControllerTest();

    private SimulateurControllerTest(){
    }
    public static SimulateurControllerTest getInstance(){
       SimulateurController.cpteurBoissonTotal = 0;
        return instance;
    }

    @BeforeEach
    public void resetSingleton() throws SecurityException, NoSuchFieldException,  IllegalArgumentException, IllegalAccessException {
        Field instance = SimulateurControllerTest.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        SimulateurControllerTest.getInstance();
    }

    @Test
    public void passerActionReservoirEauTest(){

        assertEquals(SimulateurController.passerActionReservoirEau(),1);
    }

    @Test
    public void passerActionBacColecteurTest(){

        assertEquals(SimulateurController.passerActionBacColecteur(),1);
    }

    @Test
    public void passerActionReservoirGraineTest(){
        assertEquals(SimulateurController.passerActionReservoirGraine(),1);
    }

    @Test
    public void passerActionComptageBoissonNettoyageTest(){
        assertEquals(SimulateurController.passerActionComptageBoissonNettoyage(),1);
    }

    @Test
    public void passerActionComptageBoissonDetartrageTest(){
        assertEquals(SimulateurController.passerActionComptageBoissonDetartrage(),1);
    }

    @Test
    public void passerActionComptageBoissonCalcNCleanTest(){
        assertEquals(SimulateurController.passerActionComptageBoissonCalcNClean(),1);
    }

    @Test
    public void setCpteurBoissonTotalTest(){
        assertEquals(SimulateurController.setCpteurBoissonTotal(),0);
    }

    @Test
    public void getCpteurBoissonTotalTest(){
        setCpteurBoissonTotal();
        assertEquals(SimulateurController.getCpteurBoissonTotal(),1);
    }



}