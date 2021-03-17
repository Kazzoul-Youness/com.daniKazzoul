package daniKazzoul.contoller;

import daniKazzoul.controller.BoissonController;
import daniKazzoul.model.BoissonNomEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoissonControllerTest {

    private BoissonController boissonController;

    @Before
    public void setUp(){
        boissonController = BoissonController.getInstance();
        BoissonController.cpteurBoissonTotal = 0;
    }

    @Test
    public void passerActionReservoirEauTest(){
        Assert.assertEquals(boissonController.passerActionReservoirEau(),1);
    }

    @Test
    public void passerActionBacColecteurTest(){
        Assert.assertEquals(boissonController.passerActionBacColecteur(),2);
    }

    @Test
    public void passerActionReservoirGraineTest(){
        Assert.assertEquals(boissonController.passerActionReservoirGraine(), 3);
    }

    @Test
    public void passerActionComptageBoissonTest(){
        Assert.assertEquals(boissonController.passerActionComptageBoisson(),4);
    }


}
