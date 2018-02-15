package state;

public class EtatHelp extends Etat {
    public EtatHelp(Tour tour) {
        super(tour);
    }

    public void afficherAide() {
        //Appel méthode afficher aide
        //Tools.
        this.tour.attenteAction();
    }
}
