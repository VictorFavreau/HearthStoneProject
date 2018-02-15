package state;

import jeu.ObserverJeu;

public interface InterfaceTour {
    public void attenteAction();
    public void joue();
    public void finTour();
    public void poserCarte();
    public void attaquer();
    public void quitterJeu();
    public void afficherAide();
    public void finJeu();
    public void enregistrerObs(ObserverJeu obs);
    public void supprimerObs(ObserverJeu obs);
    public void notifierObs();
    public boolean isFinJeu();
}
