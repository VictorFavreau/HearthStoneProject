package state;

import jeu.Jeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatEffet extends Etat {

    public EtatEffet(Tour tour) {
        super(tour);
    }

    /**
     * Permet de lancer l'action spéciale du héros du joueur courant
     */
    public void appliquerEffet(){
        Jeu.getJoueurActuel().actionSpeciale();
        this.tour.attenteAction();
    }
}
