package daniKazzoul.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulateurModelTest {

    private static SimulateurModelTest instance = new SimulateurModelTest();
    private int cpt= SimulateurModel.getEntretientAction();


    private SimulateurModelTest(){ }
    public static SimulateurModelTest getInstance() {
        return instance;
    }

    @BeforeEach
    public void resetSingleton() throws SecurityException, NoSuchFieldException,  IllegalArgumentException, IllegalAccessException {
        Field instance = SimulateurModelTest.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        SimulateurModelTest.getInstance();
    }

    @Test
    void testGetInstanceTest() {
    }

    @Test
    void getEntretientActionTest() {
        assertEquals(SimulateurModel.getEntretientAction(), 0);
    }

    @Test
    void checkActionReturnGlobalVideTest() {
        SimulateurModel.checkActionReturnGlobal(0, 0, 0, 0, 0);
        assertEquals(SimulateurModel.getEntretientAction(), 0);
    }


}