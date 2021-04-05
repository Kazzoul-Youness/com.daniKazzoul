package daniKazzoul.view;

import daniKazzoul.controller.DonneeFavorisController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static daniKazzoul.view.AbstractView.*;
import static daniKazzoul.view.SimulateurView.selectionChoixFavori;

public class FavoriView {

    // use Singleton design pattern
    private FavoriView() {}; // make constructor invisible to clients
    private static FavoriView instance = null;
    public static FavoriView getInstance() {
        if(instance == null) instance = new FavoriView();
        return instance;
    }


    static void favori(SimulateurView simulateurView) {
        if (selectionChoixFavori ==0 && !SimulateurView.securiteActive) {
            OperationsView.resetMachine(btnAmericano, btnBas, btnCafe, btnCafeLait, btnCappuccino, btnDeuxtasses,
                    btnEauChaude, btnExpresso, btnFavorisSecurite, btnIntensit, btnMenu, btnOk, btnQuantit,
                    btnRetour, btnStartStop, progressBar, textArea_MessageEcran,
                    textField_Choice, textField_Intensite, textField_Quantite, timer);
            textField_Choice.setText("Profile 1");
            selectionChoixFavori = 1;
            DonneeFavorisController donneeFavori1;
            try {
                //FileInputStream fileIn1 = new FileInputStream("src/main/java/daniKazzoul/dataFavori/boisson1.xml");
                FileInputStream fileIn1 = new FileInputStream("dataFavori/boisson1.xml");
                try (ObjectInputStream in1 = new ObjectInputStream(fileIn1)) {
                    donneeFavori1 = (DonneeFavorisController) in1.readObject();
                    in1.close();
                    fileIn1.close();
                }
            } catch (IOException i) {
                System.out.println("DonneeFavorisController Profile 1 absente");
                System.out.println("---------- Veuillez enregistrer votre boisson favori --------------------");
                textArea_MessageEcran.setText(" Profile 1, \n\n Veuillez enregistrer votre boisson favori \n\n Dans : Menu -> Favori -> Profile 1");
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Donnee favoris - le fichier 1 manquant");
                return;
            }
            System.out.println("---------------- Les des données Favoris du Profile 1 :");
            textArea_MessageEcran.setText(" Profile 1 à, \n\n La boisson favori : " + donneeFavori1.boisson + "\n La quantité favori : "
                    + donneeFavori1.quantite + "\n Intensité favori : " + donneeFavori1.intensite + "\n Deux tasses : "
                    + donneeFavori1.deuxTasses + "\n\n Appuyer sur (Star/Stop) pour lancer votre favori\n\n (Retour)/(Ok) Pour sortir");
            textField_Choice.setText(donneeFavori1.boisson);
            textField_Quantite.setText(donneeFavori1.quantite);
            textField_Intensite.setText(donneeFavori1.intensite);
            btnDeuxtasses.setSelected(donneeFavori1.deuxTasses);
            simulateurView.setFocusDeuxTasses(donneeFavori1.deuxTasses);
            try {
                donneeFavori1.afficherDonneeFavoriTerminal(selectionChoixFavori);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        else if (selectionChoixFavori ==1 && !SimulateurView.securiteActive) {
            OperationsView.resetMachine(btnAmericano, btnBas, btnCafe,
                    btnCafeLait, btnCappuccino, btnDeuxtasses,
                    btnEauChaude, btnExpresso, btnFavorisSecurite,
                    btnIntensit, btnMenu, btnOk, btnQuantit,
                    btnRetour, btnStartStop, progressBar, textArea_MessageEcran,
                    textField_Choice, textField_Intensite, textField_Quantite, timer);

            textField_Choice.setText("Profile 2");
            selectionChoixFavori =0;

            DonneeFavorisController donneeFavori2;
            try {
                //FileInputStream fileIn2 = new FileInputStream("src/main/java/daniKazzoul/dataFavori/boisson2.xml");
                FileInputStream fileIn2 = new FileInputStream("dataFavori/boisson2.xml");
                try (ObjectInputStream in2 = new ObjectInputStream(fileIn2)) {
                    donneeFavori2 = (DonneeFavorisController) in2.readObject();
                    in2.close();
                    fileIn2.close();
                }
            } catch (IOException i) {
                System.out.println("DonneeFavorisController Profile 2 absente");
                textArea_MessageEcran.setText(" Profile 2, \n\n Veuillez enregistrer votre boisson favori \n\n Dans : Menu -> Favori -> Profile 2");
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Donnee Favoris - le fichier 2 manquant");
                return;
            }
                System.out.println("---------------- Les des données Favoris du Profile 2 :");
                textArea_MessageEcran.setText(" Profile 2 à, \n\n La boisson favori : " + donneeFavori2.boisson + "\n La quantité favori : " + donneeFavori2.quantite + "\n Intensité favori : " + donneeFavori2.intensite + "\n Deux tasses : " + donneeFavori2.deuxTasses + "\n\n Appuyer sur (Star/Stop) pour lancer votre favori\n\n (Retour)/(Ok) Pour sortir");
                textField_Choice.setText(donneeFavori2.boisson);
                textField_Quantite.setText(donneeFavori2.quantite);
                textField_Intensite.setText(donneeFavori2.intensite);
                btnDeuxtasses.setSelected(donneeFavori2.deuxTasses);
                simulateurView.setFocusDeuxTasses(donneeFavori2.deuxTasses);

                try {
                    donneeFavori2.afficherDonneeFavoriTerminal(selectionChoixFavori);
                } catch (Exception exception) {  exception.printStackTrace();  }
            }


    }
}
