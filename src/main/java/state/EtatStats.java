package state;

import jeu.Jeu;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatStats extends Etat {
    public EtatStats(Tour tour) {
        super(tour);
    }

    /**
     *  Permet d'afficher les statistiques des joueurs
     */
    public void afficheStats(){
        Jeu.afficheStat();
        this.tour.attenteAction();
    }
}
