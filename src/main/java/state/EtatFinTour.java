package state;

import jeu.Jeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatFinTour extends Etat {
    public EtatFinTour(Tour tour) {
        super(tour);
    }

    /**
     * Méthode arrêtant le tour en cours lorsque le joueur en cours le décide.
     * Celle-ci change aussi le joueur en cours pour passer à l'autre joueur et initialise ses différents paramètres.
     */
    public void finirTour(){
        Jeu.changeJoueur();
        Jeu.getJoueurActuel().pioche();
        Jeu.getJoueurActuel().addStockMana();
        Jeu.getJoueurActuel().setMaxMana();
        Jeu.getJoueurActuel().wakeUpServiteurs();

        this.tour.attenteAction();
    }
}
