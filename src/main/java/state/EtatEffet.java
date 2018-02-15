package state;

import jeu.Jeu;

public class EtatEffet extends Etat {

    public EtatEffet(Tour tour) {
        super(tour);
    }

    public void appliquerEffet(){
        Jeu.getJoueurActuel().actionSpeciale();
        this.tour.attenteAction();
    }
}
