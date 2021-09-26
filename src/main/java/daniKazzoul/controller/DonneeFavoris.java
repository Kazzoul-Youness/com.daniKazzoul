package daniKazzoul.controller;

public class DonneeFavoris implements java.io.Serializable{

    // - Singleton Pattern
    private static final DonneeFavoris instance = new DonneeFavoris();

    //constructeur privé pour éviter que les applications clientes utilisent le constructeur
    private DonneeFavoris(){ }

    public static DonneeFavoris getInstance(){
        return instance;
    }


    public String boisson;
    public String quantite;
    public String intensite;
    public boolean deuxTasses;

    public void afficherDonneeFavoriTerminal(int favori) throws Exception{
        System.out.println("Boisson: "+boisson+"| Quantite: "+quantite+"| Intensite: "+intensite+"| DeuxTasses: "+deuxTasses);


    }



}
