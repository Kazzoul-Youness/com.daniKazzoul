package daniKazzoul;

import daniKazzoul.controller.SimulateurController;
import daniKazzoul.model.SimulateurModel;
import daniKazzoul.view.SimulateurView;
import daniKazzoul.view.AbstractView;

import java.awt.*;
import java.io.FileNotFoundException;

public class Gui {

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AbstractView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/*  Launching frames **/

		EventQueue.invokeLater(() -> {
			try {
				createAndShowGUI();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void createAndShowGUI() throws FileNotFoundException {
		System.out.println("*********************** Simulateur de machine à café ************************");
		/* Création du MVC (model, view et controller) **/
		SimulateurModel model = SimulateurModel.getInstance();
		SimulateurView view = new SimulateurView();
		SimulateurController controller = new SimulateurController(model, view);
		/* Register le controller comme un listener **/
		controller.registerListener();
		view.frame.setVisible(true);

	}

}

