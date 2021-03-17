package daniKazzoul;

import daniKazzoul.components.BacCollecteur;
import daniKazzoul.components.ReservoirEau;
import daniKazzoul.components.ReservoirGraine;
import daniKazzoul.view.UtilisateurVue;
import daniKazzoul.view.Vue;

import static java.awt.EventQueue.invokeLater;

public class Gui {

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Vue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//Launching frames


		invokeLater(() -> {
			try {
				createAndShowGUI();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}



	public static void createAndShowGUI() throws Exception {

		UtilisateurVue window = new UtilisateurVue();
		window.frame.setVisible(true);

		ReservoirEau.initializeReservoirEau();
		BacCollecteur.initializeBacCollecteur();
		ReservoirGraine.initializeReservoirGraine();
		//ProgressBarComposant.ProgressBarComposant();




	}

}

