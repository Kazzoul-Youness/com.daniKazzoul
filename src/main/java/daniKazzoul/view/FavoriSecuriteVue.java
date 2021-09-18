package daniKazzoul.view;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class FavoriSecuriteVue extends SimulateurView {


    public FavoriSecuriteVue() throws FileNotFoundException {
    }


    /**********************         Favoris Et/Ou sécurité Enfant   ********************************
     * @param simulateurView*/

    static void createButtonFavoriSecurite(final SimulateurView simulateurView) {
        btnFavorisSecurite = new JButton("FavoriSecurite");
        
        btnFavorisSecurite.setBounds(822, 420, 170, 120);
        btnFavorisSecurite.setFont(new Font("Dialog", Font.BOLD, 17));
        simulateurView.frame.getContentPane().add(btnFavorisSecurite);

        // Favori
        btnFavorisSecurite.addActionListener(e -> {
            Favori.favori(simulateurView);
        });

        // activer desactiver la Securite
        Securite.Securite(simulateurView);

    }

}
