package state;

import jeu.Jeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatPoseCarte extends Etat{

    public EtatPoseCarte(Tour tour) {
        super(tour);
    }

    /**
     * Permet d'appeler la méthode poserCarte() qui pose la carte souhaité par le joueur issu de sa main
     */
    public void poserCarte(){
        Jeu.getJoueurActuel().poseCarte();
        this.tour.attenteAction();
    }
}
