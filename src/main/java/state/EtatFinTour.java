package state;

import jeu.Jeu;

public class EtatFinTour extends Etat {
    public EtatFinTour(Tour tour) {
        super(tour);
    }

    public void finirTour(){
        Jeu.changeJoueur();
        Jeu.getJoueurActuel().pioche();
        this.tour.attenteAction();
    }
}
