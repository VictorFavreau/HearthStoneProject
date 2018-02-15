package state;

import jeu.Jeu;

public class EtatPoseCarte extends Etat{

    public EtatPoseCarte(Tour tour) {
        super(tour);
    }

    public void poserCarte(){
        Jeu.getJoueurActuel().poseCarte();
        this.tour.attenteAction();
    }
}
