package state;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatQuitter extends Etat{
    public EtatQuitter(Tour tour) {
        super(tour);
    }

    /**
     * Permet d'arrêter le jeu soit car un des joueurs à perdus soit car un des joueurs a décidé d'arrêter le jeu
     */
    public void arreterJeu(){
        this.tour.finJeu();
    }
}
