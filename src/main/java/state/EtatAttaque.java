package state;

import jeu.Jeu;

public class EtatAttaque extends Etat{

    public EtatAttaque(Tour tour) {
        super(tour);
    }

    public void attaquer(){
        Jeu.getJoueurActuel().attaque();
        this.tour.attenteAction();
    }
}
