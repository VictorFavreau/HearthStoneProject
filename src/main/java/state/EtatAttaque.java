package state;

import jeu.Jeu;

public class EtatAttaque extends Etat{

    public EtatAttaque(Tour tour) {
        super(tour);
    }

    public void attaquer(){
        //ATTAQUER AVERSSAIRE
        //Jeu.getJoueurActuel().attaquer();
        this.tour.attenteAction();
    }
}
