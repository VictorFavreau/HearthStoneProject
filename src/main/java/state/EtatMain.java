package state;

import jeu.Jeu;

public class EtatMain extends Etat{
    public EtatMain(Tour tour) {
        super(tour);
    }

    public void afficheMain(){
        Jeu.getJoueurActuel().afficheMain();
        this.tour.attenteAction();
    }
}
