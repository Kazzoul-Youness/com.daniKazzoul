package daniKazzoul.view;

import daniKazzoul.controller.DonneeFavoris;
import daniKazzoul.controller.OperationControlleur;
import daniKazzoul.controller.ParametreControlleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Favori extends FavoriSecuriteVue{

    public Favori() throws FileNotFoundException {
    }


    static void favori(SimulateurView simulateurView) {

        if (selectionChoixFavori ==0 && !SimulateurView.securiteActive) {
            OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe,
                    btnCafeLait, btnCappuccino, btnDeuxtasses,
                    btnEauChaude, btnExpresso, btnFavorisSecurite,
                    btnIntensit, btnMenu, btnOk, btnQuantit,
                    btnRetour, btnStartStop, progressBar, textArea_MessageEcran,
                    textField_Choice, textField_Intensite, textField_Quantite, timer);

            textField_Choice.setText("Profile 1");
            selectionChoixFavori =1;

            DonneeFavoris donneeFavori1;
            try {
                FileInputStream fileIn1 = new FileInputStream("src/main/java/daniKazzoul/dataFavori/boisson1.xml");
                try (ObjectInputStream in1 = new ObjectInputStream(fileIn1)) {
                    donneeFavori1 = (DonneeFavoris) in1.readObject();
                    in1.close();
                    fileIn1.close();
                }
            } catch (IOException i) {
                System.out.println("DonneeFavoris Profile 1 absente");
                System.out.println("---------- Veuillez enregistrer votre boisson favori --------------------");

                textArea_MessageEcran.setText(" Profile 1, \n\n Veuillez enregistrer votre boisson favori \n\n Dans : Menu -> Favori -> Profile 1");
                //i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Donnee favoris - le fichier 1 manquant");

                //c.printStackTrace();
                return;
            }

            System.out.println("---------------- Les des données Favoris du Profile 1 :");
            textArea_MessageEcran.setText(" Profile 1 à, \n\n La boisson favori : " + donneeFavori1.boisson + "\n La quantité favori : " + donneeFavori1.quantite + "\n Intensité favori : " + donneeFavori1.intensite + "\n Deux tasses : " + donneeFavori1.deuxTasses + "\n\n Appuyer sur (Star/Stop) pour lancer votre favori");
            textField_Choice.setText(donneeFavori1.boisson);
            textField_Quantite.setText(donneeFavori1.quantite);
            textField_Intensite.setText(donneeFavori1.intensite);
            btnDeuxtasses.setSelected(donneeFavori1.deuxTasses);
            ParametreControlleur.getInstance().setFocusDeuxTasses(simulateurView, donneeFavori1.deuxTasses);

            try {
                donneeFavori1.afficherDonneeFavoriTerminal(selectionChoixFavori);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            }

        else if (selectionChoixFavori ==1 && !SimulateurView.securiteActive) {
            OperationControlleur.resetMachine(btnAmericano, btnBas, btnCafe,
                    btnCafeLait, btnCappuccino, btnDeuxtasses,
                    btnEauChaude, btnExpresso, btnFavorisSecurite,
                    btnIntensit, btnMenu, btnOk, btnQuantit,
                    btnRetour, btnStartStop, progressBar, textArea_MessageEcran,
                    textField_Choice, textField_Intensite, textField_Quantite, timer);

            textField_Choice.setText("Profile 2");
            selectionChoixFavori =0;

            DonneeFavoris donneeFavori2;
            try {
                FileInputStream fileIn2 = new FileInputStream("src/main/java/daniKazzoul/dataFavori/boisson2.xml");
                //                System.out.println(fileIn.getFD()+" val2 "+fileIn.available()+" val3 "+fileIn.getChannel()+" val4 "+ fileIn.getClass() );
                try (ObjectInputStream in2 = new ObjectInputStream(fileIn2)) {
                    donneeFavori2 = (DonneeFavoris) in2.readObject();
                    in2.close();
                    fileIn2.close();
                }
            } catch (IOException i) {
                System.out.println("DonneeFavoris Profile 2 absente");
                textArea_MessageEcran.setText(" Profile 2, \n\n Veuillez enregistrer votre boisson favori \n\n Dans : Menu -> Favori -> Profile 2");
                //  i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Donnee Favoris - le fichier 2 manquant");
                //   c.printStackTrace();
                return;
            }
                System.out.println("---------------- Les des données Favoris du Profile 2 :");
                textArea_MessageEcran.setText(" Profile 2 à, \n\n La boisson favori : " + donneeFavori2.boisson + "\n La quantité favori : " + donneeFavori2.quantite + "\n Intensité favori : " + donneeFavori2.intensite + "\n Deux tasses : " + donneeFavori2.deuxTasses + "\n\n Appuyer sur (Star/Stop) pour lancer votre favori");
                textField_Choice.setText(donneeFavori2.boisson);
                textField_Quantite.setText(donneeFavori2.quantite);
                textField_Intensite.setText(donneeFavori2.intensite);
                btnDeuxtasses.setSelected(donneeFavori2.deuxTasses);
                ParametreControlleur.getInstance().setFocusDeuxTasses(simulateurView, donneeFavori2.deuxTasses);

                try {
                    donneeFavori2.afficherDonneeFavoriTerminal(selectionChoixFavori);
                } catch (Exception exception) {  exception.printStackTrace();  }
            }


    }
}
