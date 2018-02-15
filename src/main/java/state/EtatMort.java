package state;

public class EtatMort extends Etat{
    public EtatMort(Tour tour) {
        super(tour);
    }

    public void finPartie(){
        this.tour.setFinJeu(true);
        this.tour.notifierObs();
    }
}
