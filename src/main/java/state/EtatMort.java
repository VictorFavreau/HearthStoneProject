package state;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatMort extends Etat{
    public EtatMort(Tour tour) {
        super(tour);
    }

    /**
     * Permet d'arrêter la partie lorsqu'un joueur est mort
     */
    public void finPartie(){
        this.tour.setFinJeu(true);
        this.tour.notifierObs();
    }
}
