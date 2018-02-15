package state;

public abstract class Etat {

    protected Tour tour;

    public Etat(Tour tour){ this.tour=tour; }

    public void jouer() {}
    public void attenteAction() {}
    public void finirTour() {}
    public void passe() {}
    public void poserCarte() {}
    public void attaquer() {}
    public void arreterJeu() {}
    public void afficherAide() {}
}