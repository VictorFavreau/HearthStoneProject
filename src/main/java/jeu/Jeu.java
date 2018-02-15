package jeu;

import actors.TypeClasse;
import utils.LogType;
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

    /**
     * Initialise une nouvelle partie
     */
    public static void init(){
        plateau = new Plateau();

        //initialisation du joueur 1
        TypeClasse classeJoueur1 = Tools.getClasse(Player.JOUEUR1);
        joueur1 = new Joueur(classeJoueur1, Player.JOUEUR1);

        //initialisation du joueur 2
        TypeClasse classeJoueur2 = Tools.getClasse(Player.JOUEUR2);
        joueur2 = new Joueur(classeJoueur2, Player.JOUEUR2);
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

    /**
     * Change de joueur actif
     */
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

    /**
     * Retourne le libelle du joueur actif
     * @return libelle du joueur actif
     */
    public static Player getPlayerActuel(){
        return playerActuel;
    }

    /**
     * Retourne le joueur actuellement actif
     * @return joueur actif
     */
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
    public boolean isFinJeu() {
        return finJeu;
    }

    @Override
    public void finGame() {
        this.finJeu = this.tour.isFinJeu();
        Tools.finJeu();
    }



    /**
     * Affiche les stats de la partie
     */
    public static void afficheStat(){
        Tools.log(getJoueur1().toString(), LogType.JOUEUR1);
        getPlateau().affichePlateauJoueur(Player.JOUEUR1);
        Tools.log(getJoueur2().toString(), LogType.JOUEUR2);
        getPlateau().affichePlateauJoueur(Player.JOUEUR2);
    }
}
