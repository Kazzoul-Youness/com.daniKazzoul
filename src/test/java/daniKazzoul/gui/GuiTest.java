package daniKazzoul.gui;

import daniKazzoul.controller.SimulateurController;
import daniKazzoul.model.SimulateurModel;
import daniKazzoul.view.SimulateurView;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.FileNotFoundException;

class GuiTest {

    @Test
    void main() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    }

    @Test
    void createAndShowGUI() throws FileNotFoundException {
        SimulateurModel model = SimulateurModel.getInstance();
        SimulateurView view = new SimulateurView();
        SimulateurController controller = new SimulateurController(model, view);

        /* Register le controller comme un listener */
        controller.registerListener();

        view.frame.setVisible(true);

    }

}