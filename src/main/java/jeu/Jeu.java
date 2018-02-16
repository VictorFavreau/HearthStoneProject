package jeu;

import actors.TypeClasse;
import utils.LogType;
import state.InterfaceTour;
import utils.Player;
import utils.Tools;
import java.util.Random;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
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

        playerActuel = getRandomPlayer();

        Tools.log(playerActuel + " commence la partie !", LogType.INFO);

        switch (playerActuel){
            case JOUEUR1:
                joueur1.pioche();
                joueur1.pioche();
                joueur1.pioche();

                joueur2.pioche();
                joueur2.pioche();
                joueur2.pioche();
                joueur2.pioche();
                break;

            case JOUEUR2:
                joueur2.pioche();
                joueur2.pioche();
                joueur2.pioche();

                joueur1.pioche();
                joueur1.pioche();
                joueur1.pioche();
                joueur1.pioche();
                break;
        }

    }

    /**
     * Sélectionne un joueur aléatoirement
     * @return Le joueur sélectionné
     */
    private static Player getRandomPlayer(){

        Random randomGenerator = new Random();
        int randomIndice = randomGenerator.nextInt(2);

        switch (randomIndice){
            case 0:
                return Player.JOUEUR1;

            case 1:
                return Player.JOUEUR2;

            default:
                return Player.JOUEUR1;
        }
    }

    /**
     * Récupère le plateau du jeu
     * @return Le plateau du jeu en cours
     */
    public static Plateau getPlateau() {
        return plateau;
    }

    /**
     * Récupère le joueur numéro 1
     * @return Joueur1
     */
    public static Joueur getJoueur1(){
        return joueur1;
    }

    /**
     * Récupère le joueur numéro 2
     * @return Joueur2
     */
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
                break;

            case JOUEUR2:
                joueur = joueur2;
                break;
        }

        return joueur;
    }


    @Override
    /**
     * Permet de vérifier si le jeu est terminée ou non.
     * Il peut se terminé si un des joueurs à perdu ou si un des joueurs à demander à arrêter le jeu.
     * @return Retourne true si c'est la fin du jeu ou false si le jeu n'est pas terminée
     */
    public boolean isFinJeu() {
        return finJeu;
    }

    /**
     * Instancie la fin du jeu
     * @param finJeu : Variable exprimant si le jeu est terminé ou non
     */
    public void setFinJeu(boolean finJeu) {
        this.finJeu = finJeu;
    }

    /**
     * Permet d'arrêter le jeu et d'afficher le message de fin du jeu
     */
    @Override
    public void finGame() {
        this.setFinJeu(true);
        Tools.finJeu();
    }

    /**
     * Permet d'afficher les stats des deux joueurs
     */
    public static void afficheStat(){
        Tools.log(getJoueur1().toString(), LogType.JOUEUR1);
        getPlateau().affichePlateauJoueur(Player.JOUEUR1);
        Tools.log(getJoueur2().toString(), LogType.JOUEUR2);
        getPlateau().affichePlateauJoueur(Player.JOUEUR2);
    }
}
