package daniKazzoul.view;

import daniKazzoul.controller.DonneeFavoris;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Favori extends FavoriSecuriteVue{

    public Favori() throws FileNotFoundException {
    }


    static void favori(UtilisateurVue utilisateurVue) {
        if (utilisateurVue.selectionChoixFavori ==0) {
            utilisateurVue.textField_Choice.setText("Profile 1");
            utilisateurVue.selectionChoixFavori =1;

            DonneeFavoris donneeFavori1;
            try {
                FileInputStream fileIn1 = new FileInputStream("src/main/java/daniKazzoul/dataFavori/boisson1.txt");
                try (ObjectInputStream in1 = new ObjectInputStream(fileIn1)) {
                    donneeFavori1 = (DonneeFavoris) in1.readObject();
                    in1.close();
                    fileIn1.close();
                }
            } catch (IOException i) {
                System.out.println("DonneeFavoris Profile 1 absente");
                utilisateurVue.textArea_MessageEcran.setText(" Profile 1, \n\n Veuillez enregistrer votre boisson favori \n\n Dans : Menu -> Favori -> Profile 1");
                //i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Donnee favoris - le fichier 1 manquant");
                //c.printStackTrace();
                return;
            }

            utilisateurVue.textArea_MessageEcran.setText(" Profile 1 à, \n\n La boisson favori : "+donneeFavori1.boisson+"\n La quantité favori : "+donneeFavori1.quantite+"\n Intensité favori : "+donneeFavori1.intensite+"\n Deux tasses : "+donneeFavori1.deuxTasses+"\n\n Appuyer sur (Star/Stop) pour lancer votre favori");
            utilisateurVue.textField_Choice.setText(donneeFavori1.boisson);
            utilisateurVue.textField_Quantite.setText(donneeFavori1.quantite);
            utilisateurVue.textField_Intensite.setText(donneeFavori1.intensite);
            utilisateurVue.btnDeuxtasses.setSelected(donneeFavori1.deuxTasses);

            try {
                donneeFavori1.afficherDonneeFavoriTerminal(utilisateurVue.selectionChoixFavori);
            } catch (Exception exception) { exception.printStackTrace(); }
        }
        else if (utilisateurVue.selectionChoixFavori ==1) {
            utilisateurVue.textField_Choice.setText("Profile 2");
            utilisateurVue.selectionChoixFavori =0;

            DonneeFavoris donneeFavori2;
            try {
                FileInputStream fileIn2 = new FileInputStream("src/main/java/daniKazzoul/dataFavori/boisson2.txt");
                //                System.out.println(fileIn.getFD()+" val2 "+fileIn.available()+" val3 "+fileIn.getChannel()+" val4 "+ fileIn.getClass() );
                try (ObjectInputStream in2 = new ObjectInputStream(fileIn2)) {
                    donneeFavori2 = (DonneeFavoris) in2.readObject();
                    in2.close();
                    fileIn2.close();
                }
            } catch (IOException i) {
                System.out.println("DonneeFavoris Profile 2 absente");
                utilisateurVue.textArea_MessageEcran.setText(" Profile 2, \n\n Veuillez enregistrer votre boisson favori \n\n Dans : Menu -> Favori -> Profile 2");
                //  i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Donnee Favoris - le fichier 2 manquant");
                //   c.printStackTrace();
                return;
            }
            utilisateurVue.textArea_MessageEcran.setText(" Profile 2 à, \n\n La boisson favori : "+donneeFavori2.boisson+"\n La quantité favori : "+donneeFavori2.quantite+"\n Intensité favori : "+donneeFavori2.intensite+"\n Deux tasses : "+donneeFavori2.deuxTasses+"\n\n Appuyer sur (Star/Stop) pour lancer votre favori");
            utilisateurVue.textField_Choice.setText(donneeFavori2.boisson);
            utilisateurVue.textField_Quantite.setText(donneeFavori2.quantite);
            utilisateurVue.textField_Intensite.setText(donneeFavori2.intensite);
            utilisateurVue.btnDeuxtasses.setSelected(donneeFavori2.deuxTasses);

            try {
                donneeFavori2.afficherDonneeFavoriTerminal(utilisateurVue.selectionChoixFavori);
            } catch (Exception exception) { exception.printStackTrace(); }



        }
    }
}
