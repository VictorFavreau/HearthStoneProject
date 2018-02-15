package jeu;

import actors.TypeClasse;
import state.InterfaceTour;
import utils.Player;
import utils.Tools;

public class Jeu implements ObserverJeu{

    private static Plateau plateau;
    private static Joueur joueur1;
    private static Joueur joueur2;
    private static Player playerActuel;
    private InterfaceTour tour;
    private boolean finJeu;

    public Jeu(){
        this.finJeu = false;
    }

    public static void init(){
        plateau = new Plateau();

        //initialisation du joueur 1
        TypeClasse classeJoueur1 = Tools.getClasse(Player.JOUEUR1);
        joueur1 = new Joueur(classeJoueur1, Player.JOUEUR1);
        //TODO SET DECK
        switch(classeJoueur1){
            case MAGE:
                break;

            case PALADIN:
                break;
            case GUERRIER:
                break;
        }


        //initialisation du joueur 2
        TypeClasse classeJoueur2 = Tools.getClasse(Player.JOUEUR2);
        joueur2 = new Joueur(classeJoueur1, Player.JOUEUR2);
        //TODO SET DECK
        switch(classeJoueur2){
            case MAGE:
                break;

            case PALADIN:
                break;
            case GUERRIER:
                break;
        }

    }

    public static Plateau getPlateau() {
        return plateau;
    }

    public static Joueur getJoueur1(){
        return joueur1;
    }

    public static Joueur getJoueur2(){
        return joueur2;
    }

    public static void changeJoueur(){
        switch(playerActuel){
            case JOUEUR1:
                playerActuel = Player.JOUEUR2;
                break;

            case JOUEUR2:
                playerActuel = Player.JOUEUR1;
                break;

        }
    }

    public static Player getPlayerActuel(){
        return playerActuel;
    }

    /*
    public static Heros getHerosPlayer(Player player){
        switch(player){
            case JOUEUR1:
                return joueur1.;

            case JOUEUR2:
                return serviteursJ2.size() > 0;
        }

        return null;
    }*/

    public static Joueur getJoueurActuel() {

        Joueur joueur = null;

        switch(playerActuel){
            case JOUEUR1:
                joueur = joueur1;

            case JOUEUR2:
                joueur = joueur2;
        }

        return joueur;
    }

    @Override
    public void finGame() {
        this.finJeu = this.tour.isFinJeu();
        Tools.finJeu();
    }
}
