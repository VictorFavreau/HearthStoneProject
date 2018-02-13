package state;

import jeu.Joueur;

public class Tour implements InterfaceTour {
    private Etat etatCourant;
    private Joueur joueur;

    public Tour(Joueur joueur){
        this.etatCourant = new EtatAttente(this);
        this.joueur = joueur;
    }

    @Override
    public void joue() {
        this.etatCourant = new EtatJoue(this);
        this.etatCourant.joue();
    }

    @Override
    public void passe() {
        this.etatCourant = new EtatAttente(this);
        this.etatCourant.passe();
    }

    @Override
    public void poserCarte() {
        this.etatCourant = new EtatPoseCarte(this);
        this.etatCourant.poserCarte();
    }

    @Override
    public void attaquer() {
        this.etatCourant = new EtatAttaquant(this);
        this.etatCourant.attaquer();
    }

    @Override
    public void attaqueAdverse() {
        this.etatCourant = new EtatVictime(this);
        this.etatCourant.attaqueAdverse();
    }

    public Etat getEtatCourant() {
        return etatCourant;
    }

    public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}