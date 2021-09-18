package daniKazzoul.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulateurControllerTest {

    private static SimulateurControllerTest instance = new SimulateurControllerTest();
    //constructeur privé
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
        assertEquals(SimulateurController.passerActionBacColecteur(),2);
    }
    @Test
    public void passerActionReservoirGraineTest(){
        assertEquals(SimulateurController.passerActionReservoirGraine(),3);
    }
    @Test
    public void passerActionComptageBoissonNettoyageTest(){  assertEquals(SimulateurController.passerActionComptageBoissonNettoyage(),4); }
    @Test
    public void passerActionComptageBoissonDetartrageTest(){  assertEquals(SimulateurController.passerActionComptageBoissonDetartrage(),5); }

//    @Test
//    public void miseAJourTotalBoissonTest() throws Exception {
//        assertNotNull(DemarrageVue.miseAJourTotalBoisson("Expresso") );
//        assertNotNull(DemarrageVue.miseAJourTotalBoisson("Café") );
//        assertNotNull(DemarrageVue.miseAJourTotalBoisson("CaféLait") );
//        assertNotNull(DemarrageVue.miseAJourTotalBoisson("Cappuccino") );
//        assertNotNull(DemarrageVue.miseAJourTotalBoisson("EauChaude") );
//        assertNotNull(DemarrageVue.miseAJourTotalBoisson("Americano") );
//    }

}