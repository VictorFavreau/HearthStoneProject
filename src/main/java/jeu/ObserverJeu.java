package jeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public interface ObserverJeu {

    /**
     * Permet d'arrêter le jeu et d'afficher le message de fin du jeu
     */
    public void finGame();

    /**
     * Permet de vérifier si le jeu est terminée ou non.
     * Il peut se terminé si un des joueurs à perdu ou si un des joueurs à demander à arrêter le jeu.
     * @return Retourne true si c'est la fin du jeu ou false si le jeu n'est pas terminée
     */
    public boolean isFinJeu();
}
