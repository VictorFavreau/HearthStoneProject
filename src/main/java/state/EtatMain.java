package state;

import jeu.Jeu;
import utils.Tools;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class EtatMain extends Etat{
    public EtatMain(Tour tour) {
        super(tour);
    }

    /**
     * Permet d'afficher les cartes dans la main du joueur en cours
     */
    public void afficheMain(){
        Tools.log(Jeu.getJoueurActuel().afficheMain(), Tools.getLogPlayer(Jeu.getPlayerActuel()));
        this.tour.attenteAction();
    }
}
