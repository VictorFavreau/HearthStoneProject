package state;

import jeu.ObserverJeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public interface InterfaceTour {
    /**
     * Permet de lancer l'éatat d'attente qui attend une action de jeu de la part de l'utilisateur
     */
    public void attenteAction();

    /**
     *  Permet de lancer l'état joue qui initialiser le jeu
     */
    public void joue();

    /**
     * Permet de lancer l'état fin de tour qui arrête le tour en cours d'un joueur
     */
    public void finTour();

    /**
     * Permet de lancer l'état pose carte qui pose une carte de la main du joueur sur le plateau
     */
    public void poserCarte();

    /**
     * Permet de lancer l'état attaquer qui attaque l'adversaire du joueur courant
     */
    public void attaquer();

    /**
     * Permet de lancer l'état quitter qui arrête le jeu
     */
    public void quitterJeu();

    /**
     * Permet de lancer l'état main qui affiche les cartes dans la main du joueur courant
     */
    public void afficherMain();

    /**
     * Permet de lancer l'état stat qui affiche les statistiques des deux joueurs
     */
    public void afficherStats();

    /**
     * Permet de lancer l'état effet qui lance l'action spéciale du héros du joueur en cours
     */
    public void utiliserEffet();

    /**
     * Permet de lancer l'état mort qui arrête la partie après qu'un joueur est perdu
     */
    public void finJeu();

    /**
     * Permet d'enregistrer un nouveau observateur
     * @param obs : observateur du jeu
     */
    public void enregistrerObs(ObserverJeu obs);

    /**
     * Permet de supprimé un observeur
     * @param obs : observateur du jeu
     */
    public void supprimerObs(ObserverJeu obs);

    /**
     * Permet de notifier tous les observers que le jeu est terminé
     */
    public void notifierObs();

    /**
     * Permet de vérifier si le jeu est terminé
     * @return True si le jeu est terminé false sinon
     */
    public boolean isFinJeu();
}
