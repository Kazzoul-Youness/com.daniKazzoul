package daniKazzoul.view;

import daniKazzoul.components.BacCollecteur;
import daniKazzoul.components.Nettoyeur;
import daniKazzoul.components.ReservoirEau;
import daniKazzoul.components.ReservoirGraine;

import java.io.FileNotFoundException;

public class BoissonVue extends UtilisateurVue {


    public BoissonVue() throws FileNotFoundException {
    }

    /** La consomation des Boisson, ça permet de vérifier les %(modulo)
     de chaque sorte de boisson (Les cafes, Lactées ou Special)
     et on vérifier au début de chaque demarrage ***/
    public static void consomationBoissonCafe() {
        BacCollecteur.consomerBoissonCollecteur();
        ReservoirEau.consommerBoissonParReservoir();
        ReservoirGraine.consommerBoissonParGraine();
        Nettoyeur.consommerBoissonAvantNettoayge();
    }


    public static void consomationBoissonLactee() {
        BacCollecteur.consomerBoissonCollecteur();
        ReservoirEau.consommerBoissonParReservoir();
        ReservoirGraine.consommerBoissonParGraine();
        Nettoyeur.consommerBoissonAvantNettoayge();
    }


    public static void consomationBoissonSpecial() {
        BacCollecteur.consomerBoissonCollecteur();
        ReservoirEau.consommerBoissonParReservoir();
        /* Test de la boisson special qui ne consome pas de graines de café,
        Par exemple: si on choisi les boisson special comme l'eau chaude pour le thé ou boisson Americano
         On remarque que le message de remplir les graines de cafe ne se declenche jamais ! **/
        ReservoirGraine.consommerBoissonParGraine();
        Nettoyeur.consommerBoissonAvantNettoayge();
    }
}
