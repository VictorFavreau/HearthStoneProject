package state;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public abstract class Etat {

    protected Tour tour;

    public Etat(Tour tour){ this.tour=tour; }

    /**
     * Permet d'initialiser le jeu
     */
    public void jouer() {}

    /**
     * Attend l'action du jeu souhaité par l'utilisateur
     */
    public void attenteAction() {}

    /**
     * Méthode arrêtant le tour en cours lorsque le joueur en cours le décide.
     * Celle-ci change aussi le joueur en cours pour passer à l'autre joueur et initialise ses différents paramètres.
     */
    public void finirTour() {}

    /**
     * Permet d'appeler la méthode poserCarte() qui pose la carte souhaité par le joueur issu de sa main
     */
    public void poserCarte() {}

    /**
     * Permet de lancer l'action spéciale du héros du joueur courant
     */
    public void appliquerEffet(){}

    /**
     * Permet de lancer l'action d'attaque sur l'adversaire du joueur courant
     */
    public void attaquer() {}

    /**
     * Permet d'arrêter le jeu soit car un des joueurs à perdus soit car un des joueurs à décidé d'arrêter le jeu
     */
    public void arreterJeu() {}

    /**
     * Permet d'arrêter la partie lorsqu'un joueur est mort
     */
    public void finPartie() {}

    /**
     *  Permet d'afficher les statistiques des joueurs
     */
    public void afficheStats() {}

    /**
     * Permet d'afficher les cartes dans la main du joueur en cours
     */
    public void afficheMain() {}
}