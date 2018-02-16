package state;

import jeu.Jeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatAttaque extends Etat{

    public EtatAttaque(Tour tour) {
        super(tour);
    }

    /**
     * Permet de lancer l'action d'attaque sur l'adversaire du joueur courant
     */
    public void attaquer(){
        Jeu.getJoueurActuel().attaque();
        this.tour.attenteAction();
    }
}
