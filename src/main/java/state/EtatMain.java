package state;

import jeu.Jeu;
import utils.LogType;
import utils.Tools;

public class EtatMain extends Etat{
    public EtatMain(Tour tour) {
        super(tour);
    }

    public void afficheMain(){
        Tools.log(Jeu.getJoueurActuel().afficheMain(), Tools.getLogPlayer(Jeu.getPlayerActuel()));
        this.tour.attenteAction();
    }
}
