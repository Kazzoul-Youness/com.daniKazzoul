package daniKazzoul.controller;

public class DonneeFavorisController implements java.io.Serializable{

    /** - Singleton Pattern ************************************************************/
    private static DonneeFavorisController instance = new DonneeFavorisController();
    private DonneeFavorisController(){ }
    public static DonneeFavorisController getInstance(){
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
