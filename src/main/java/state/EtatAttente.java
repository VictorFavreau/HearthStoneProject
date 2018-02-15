package state;

import jeu.Jeu;
import utils.Tools;

public class EtatAttente extends Etat {

    public EtatAttente(Tour tour) {
        super(tour);
    }

    public void attenteAction(){
        if(!Jeu.getJoueur1().isDead() && !Jeu.getJoueur2().isDead()) {
            switch (Tools.getInputType()) {
                case POSER:
                    this.tour.poserCarte();
                    break;
                case QUITTER:
                    this.tour.quitterJeu();
                    break;
                case HELP:
                    this.tour.afficherAide();
                    break;
                case FIN_TOUR:
                    this.tour.finTour();
                    break;
                case ATTAQUER:
                    this.tour.attaquer();
                    break;
                default:
                    this.attenteAction();
            }
        } else {
            this.tour.finJeu();
        }
    }
}
