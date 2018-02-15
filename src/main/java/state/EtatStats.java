package state;

import jeu.Jeu;

public class EtatStats extends Etat {
    public EtatStats(Tour tour) {
        super(tour);
    }

    public void afficheStats(){
        Jeu.afficheStat();
        this.tour.attenteAction();
    }
}
