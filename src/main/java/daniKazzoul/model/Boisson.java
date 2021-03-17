package daniKazzoul.model;

public class Boisson {

    private Long id;
    private BoissonNomEnum boissonNomEnum;
    private boolean estCeDeuxTasse;
    private QuantiteEnum quantite;
    private IntensiteEnum intensite;
    private static int cptBoisson;


    public Boisson(BoissonNomEnum boissonNomEnum) {
        this.boissonNomEnum = boissonNomEnum;
    }

    public Boisson(BoissonNomEnum boissonNomEnum, boolean estCeDeuxTasse, QuantiteEnum quantite, IntensiteEnum intensite) {
        this.boissonNomEnum = boissonNomEnum;
        this.estCeDeuxTasse = estCeDeuxTasse;
        this.quantite = quantite;
        this.intensite = intensite;
    }

//    public static int getCptBoisson() {
//        return cptBoisson;
//    }
//
//    public static void setCptBoisson(int cptBoisson) {
//        Boisson.cptBoisson = cptBoisson;
//        cptBoisson++;
//    }


    public boolean isEstCeDeuxTasse() {
        return estCeDeuxTasse;
    }

    public void setEstCeDeuxTasse(boolean estCeDeuxTasse) {
        this.estCeDeuxTasse = estCeDeuxTasse;
    }

    public QuantiteEnum getQuantite() {
        return quantite;
    }

    public void setQuantite(QuantiteEnum quantite) {
        this.quantite = quantite;
    }

    public IntensiteEnum getIntensite() {
        return intensite;
    }

    public void setIntensite(IntensiteEnum intensite) {
        this.intensite = intensite;
    }

    public BoissonNomEnum getBoissonNomEnum() {
        return boissonNomEnum;
    }

    public void setBoissonNomEnum(BoissonNomEnum boissonNomEnum) {
        this.boissonNomEnum = boissonNomEnum;
    }

    @Override
    public String toString() {
        return "Boisson{" +
                "id=" + id +
                ", estCeDeuxTasse=" + estCeDeuxTasse +
                ", quantite=" + quantite +
                ", intensite=" + intensite +
                '}';
    }
}