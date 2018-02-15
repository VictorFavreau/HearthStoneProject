package state;

import jeu.Joueur;
import jeu.ObserverJeu;

import java.util.ArrayList;

public class Tour implements InterfaceTour {
    private Etat etatCourant;
    private ArrayList<ObserverJeu> obs;
    private EtatHelp etatHelp;
    private EtatQuitter etatQuitter;
    private EtatAttaque etatAttaq;
    private EtatAttente etatAttente;
    private EtatMort etatMort;
    private EtatPoseCarte etatPoseCarte;
    private EtatFinTour etatFinTour;
    private boolean finJeu;

    public Tour(Joueur joueur){
        this.etatCourant = new EtatJoue(this);
        this.obs = new ArrayList<ObserverJeu>();
        this.finJeu = false;
        this.etatHelp = new EtatHelp(this);
        this.etatAttaq = new EtatAttaque(this);
        this.etatMort = new EtatMort(this);
        this.etatAttente = new EtatAttente(this);
        this.etatPoseCarte = new EtatPoseCarte(this);
        this.etatQuitter = new EtatQuitter(this);
        this.etatFinTour = new EtatFinTour(this);
    }

    @Override
    public void attenteAction() {
        this.etatCourant = etatAttente;
        this.etatCourant.attenteAction();
    }

    @Override
    public void joue() {
        this.etatCourant.jouer();
    }

    @Override
    public void finTour() {
        this.etatCourant = etatAttente;
        this.etatCourant.passe();
    }

    @Override
    public void poserCarte() {
        this.etatCourant = new EtatPoseCarte(this);
        this.etatCourant.poserCarte();
    }

    @Override
    public void attaquer() {
        this.etatCourant = new EtatAttaque(this);
        this.etatCourant.attaquer();
    }

    @Override
    public void quitterJeu() {
        this.etatCourant = new EtatQuitter(this);
        this.etatCourant.arreterJeu();
    }

    @Override
    public void afficherAide() {
        this.etatCourant = new EtatHelp(this);
        this.etatCourant.afficherAide();
    }

    @Override
    public void enregistrerObs(ObserverJeu obs) {
        this.obs.add(obs);
    }

    @Override
    public void supprimerObs(ObserverJeu obs) {
        this.obs.remove(obs);
    }

    @Override
    public void notifierObs() {
        for (ObserverJeu observer : this.obs) {
            observer.finGame();
        }
    }

    public Etat getEtatCourant() {
        return etatCourant;
    }

    public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }

    public boolean isFinJeu() {
        return finJeu;
    }

    public void setFinJeu(boolean finJeu) {
        this.finJeu = finJeu;
    }
}