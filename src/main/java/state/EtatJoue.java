package state;

public class EtatJoue extends Etat {
    public EtatJoue(Tour tour) {
        super(tour);
    }

    public void poserCarte() {
        this.tour.getJoueur().pioche();
    }

    public void attaquer(){

    }

    public void passer(){

    }
}
