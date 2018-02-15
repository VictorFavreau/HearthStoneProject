package state;

import decorators.ActionHerosAddStockMana;
import jeu.Jeu;

public class EtatFinTour extends Etat {
    public EtatFinTour(Tour tour) {
        super(tour);
    }

    public void finirTour(){
        Jeu.changeJoueur();
        Jeu.getJoueurActuel().pioche();
        Jeu.getJoueurActuel().addStockMana();
        Jeu.getJoueurActuel().setMaxMana();
        Jeu.getJoueurActuel().wakeUpServiteurs();

        this.tour.attenteAction();
    }
}
