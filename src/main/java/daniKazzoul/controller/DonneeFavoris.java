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

    public void messageVerification() throws Exception{
        System.out.println("Check Favori : " +boisson+ " : " +quantite+" : "+intensite+" : "+deuxTasses);
    }

    public void afficherDonneeFavoriTerminal(int favori) throws Exception{
        if (favori == 1){
            System.out.println("----------------\n Les des données Favoris du Profile 1 :");
        }
        else if (favori == 0) {
            System.out.println("----------------\n Les des données Favoris du Profile 2 :");
        }
        System.out.println("boisson: " + boisson);
        System.out.println("quantite: " + quantite);
        System.out.println("intensite: " + intensite);
        System.out.println("DeuxTasses: " + deuxTasses);


    }



}
