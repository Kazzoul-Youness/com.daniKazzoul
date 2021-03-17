package daniKazzoul.view;

import javax.swing.*;
import java.io.FileNotFoundException;

public class FavoriSecuriteVue extends UtilisateurVue{


    public FavoriSecuriteVue() throws FileNotFoundException {
    }


    /**********************         Favoris Et/Ou sécurité Enfant   ********************************
     * @param utilisateurVue*/

    static void createButtonFavoriSecurite(final UtilisateurVue utilisateurVue) {
        utilisateurVue.btnFavorisSecurite = new JButton("FavoriSecurite");
        utilisateurVue.btnFavorisSecurite.setIcon(new ImageIcon("icon//FavoriSecurite.png"));
        utilisateurVue.btnFavorisSecurite.setToolTipText("");
        utilisateurVue.btnFavorisSecurite.setBounds(867, 406, 121, 95);
        utilisateurVue.frame.getContentPane().add(utilisateurVue.btnFavorisSecurite);

        /* **************        Favori        ************************************************/

        //  int profile = 1; // par defaut le profile d'utilisateur est à 1

        utilisateurVue.btnFavorisSecurite.addActionListener(e -> {

            Favori.favori(utilisateurVue);

        });

        /* **************       activer desactiver la Securite      **************************************/

        Securite.Securite(utilisateurVue);

    }

}
