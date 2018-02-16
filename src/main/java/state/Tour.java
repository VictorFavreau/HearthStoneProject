package state;

import jeu.ObserverJeu;
import java.util.ArrayList;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class Tour implements InterfaceTour {
    private Etat etatCourant;
    private ArrayList<ObserverJeu> obs;
    private EtatQuitter etatQuitter;
    private EtatAttaque etatAttaque;
    private EtatAttente etatAttente;
    private EtatMort etatMort;
    private EtatPoseCarte etatPoseCarte;
    private EtatFinTour etatFinTour;
    private EtatMain etatMain;
    private EtatStats etatStats;
    private EtatEffet etatEffet;
    private boolean finJeu;

    public Tour(){
        this.etatCourant = new EtatJoue(this);
        this.obs = new ArrayList<ObserverJeu>();
        this.finJeu = false;
        this.etatAttaque = new EtatAttaque(this);
        this.etatMort = new EtatMort(this);
        this.etatAttente = new EtatAttente(this);
        this.etatPoseCarte = new EtatPoseCarte(this);
        this.etatQuitter = new EtatQuitter(this);
        this.etatFinTour = new EtatFinTour(this);
        this.etatMain = new EtatMain(this);
        this.etatStats = new EtatStats(this);
        this.etatEffet = new EtatEffet(this);
    }

    @Override
    /**
     * Permet de lancer l'éatat d'attente qui attend une action de jeu de la part de l'utilisateur
     */
    public void attenteAction() {
        this.etatCourant = etatAttente;
        this.etatCourant.attenteAction();
    }

    @Override
    /**
     *  Permet de lancer l'état joue qui initialiser le jeu
     */
    public void joue() {
        this.etatCourant.jouer();
    }

    @Override
    /**
     * Permet de lancer l'état fin de tour qui arrête le tour en cours d'un joueur
     */
    public void finTour() {
        this.etatCourant = etatFinTour;
        this.etatCourant.finirTour();
    }

    @Override
    /**
     * Permet de lancer l'état pose carte qui pose une carte de la main du joueur sur le plateau
     */
    public void poserCarte() {
        this.etatCourant = etatPoseCarte;
        this.etatCourant.poserCarte();
    }

    @Override
    /**
     * Permet de lancer l'état attaquer qui attaque l'adversaire du joueur courant
     */
    public void attaquer() {
        this.etatCourant = etatAttaque;
        this.etatCourant.attaquer();
    }

    @Override
    /**
     * Permet de lancer l'état quitter qui arrête le jeu
     */
    public void quitterJeu() {
        this.etatCourant = etatQuitter;
        this.etatCourant.arreterJeu();
    }

    @Override
    /**
     * Permet de lancer l'état main qui affiche les cartes dans la main du joueur courant
     */
    public void afficherMain() {
        this.etatCourant = etatMain;
        this.etatCourant.afficheMain();
    }

    @Override
    /**
     * Permet de lancer l'état stat qui affiche les statistiques des deux joueurs
     */
    public void afficherStats() {
        this.etatCourant = etatStats;
        this.etatCourant.afficheStats();
    }

    @Override
    /**
     * Permet de lancer l'état effet qui lance l'action spéciale du héros du joueur en cours
     */
    public void utiliserEffet() {
        this.etatCourant = etatEffet;
        this.etatCourant.appliquerEffet();
    }

    @Override
    /**
     * Permet de lancer l'état mort qui arrête la partie après qu'un joueur est perdu
     */
    public void finJeu() {
        this.etatCourant = etatMort;
        this.etatCourant.finPartie();
    }

    @Override
    /**
     * Permet d'enregistrer un nouveau observateur
     * @param obs : observateur du jeu
     */
    public void enregistrerObs(ObserverJeu obs) {
        this.obs.add(obs);
    }

    @Override
    /**
     * Permet de supprimé un observeur
     * @param obs : observateur du jeu
     */
    public void supprimerObs(ObserverJeu obs) {
        this.obs.remove(obs);
    }

    @Override
    /**
     * Permet de notifier tous les observers que le jeu est terminé
     */
    public void notifierObs() {
        for (ObserverJeu observer : this.obs) {
            observer.finGame();
        }
    }

    /**
     * Permet de récupérer l'état courant du tour
     * @return L'état courant dans lequel le tour se trouve actuellement
     */
    public Etat getEtatCourant() {
        return etatCourant;
    }

    /**
     * Permet de modifier l'état courant
     * @param etatCourant : Etat dans lequel le tour se trouve actuellement
     */
    public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }

    /**
     * Permet de vérifier si le jeu est terminé
     * @return True si le jeu est terminé false sinon
     */
    public boolean isFinJeu() {
        return finJeu;
    }

    /**
     * Permet de modifier la valeur de finJeu
     * @param finJeu : True si le jeu est terminé ou false sinon
     */
    public void setFinJeu(boolean finJeu) {
        this.finJeu = finJeu;
    }
}