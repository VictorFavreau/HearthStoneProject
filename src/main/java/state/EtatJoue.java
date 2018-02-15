package state;

import jeu.Jeu;

public class EtatJoue extends Etat {
    public EtatJoue(Tour tour) {
        super(tour);
    }

    public void jouer(){
        Jeu.init();
        this.tour.attenteAction();
    }
}
