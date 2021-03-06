package state;

import jeu.Jeu;
import utils.Tools;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatAttente extends Etat {

    public EtatAttente(Tour tour) {
        super(tour);
    }

    /**
     * Attend l'action du jeu souhaité par l'utilisateur
     */
    public void attenteAction(){
        if(!Jeu.getJoueur1().isDead() && !Jeu.getJoueur2().isDead()) {
            switch (Tools.getInputType()) {
                case POSER:
                    this.tour.poserCarte();
                    break;
                case QUITTER:
                    this.tour.quitterJeu();
                    break;
                case FIN_TOUR:
                    this.tour.finTour();
                    break;
                case ATTAQUER:
                    this.tour.attaquer();
                    break;

                case MAIN:
                    this.tour.afficherMain();
                    break;

                case STAT:
                    this.tour.afficherStats();
                    break;

                case EFFET:
                    this.tour.utiliserEffet();
                    break;

                default:
                    this.attenteAction();
            }
        } else {
            this.tour.finJeu();
        }
    }
}
