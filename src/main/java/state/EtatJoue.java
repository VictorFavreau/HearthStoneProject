package state;

import jeu.Jeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatJoue extends Etat {
    public EtatJoue(Tour tour) {
        super(tour);
    }

    /**
     * Permet d'initialiser le jeu
     */
    public void jouer(){
        Jeu.init();
        this.tour.attenteAction();
    }
}
