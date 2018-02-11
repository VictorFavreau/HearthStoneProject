package actors.sorts.effet;

import actors.Serviteur;
import decorators.ActionHeros;
import decorators.ActionServiteur;
import jeu.Jeu;
import utils.Player;

import java.util.LinkedList;

public class Effet {

    private Player cible;
    private TypeEffet typeEffet;
    private ActionServiteur actionServiteur;
    private ActionHeros actionHeros;
    private Serviteur serviteur;
    private int nbCartes;
    private String descr;
    private LinkedList<Serviteur> listeInvocation;

    public Effet(TypeEffet typeEffet, Player cible, String descr){
        super();
        this.typeEffet = typeEffet;
        this.cible = cible;
        this.descr = descr;
        this.listeInvocation = new LinkedList<>();
    }

    public void action(){

        switch(typeEffet){

            case PIOCHE:
                actionPioche(this.cible);
                break;

            case PLATEAU:
                actionPlateau(this.cible);
                break;

            case SERVITEUR:
                actionServiteur(this.cible);
                break;

            case HEROS:
                actionHeros(this.cible);
                break;

            case INVOCATION:
                actionInvocation(this.cible);
                break;
        }

    }

    private void actionPioche(Player cible){

        switch(cible){
            case TOUS:
                Jeu.getJoueur1().pioche();
                Jeu.getJoueur2().pioche();
                break;

            case JOUEUR1:
                Jeu.getJoueur1().pioche();
                break;

            case JOUEUR2:
                Jeu.getJoueur2().pioche();
                break;
        }
    }

    private void actionServiteur(Player cible){

        Jeu.getPlateau().actionOnCard(cible, serviteur, actionServiteur);

    }

    private void actionPlateau(Player cible){
        Jeu.getPlateau().actionOnCards(cible, actionServiteur);
    }

    private void actionHeros(Player cible){
        switch(cible){
            case JOUEUR1:
                Jeu.getJoueur1().actionOnHero(this.actionHeros);
                break;

            case JOUEUR2:
                Jeu.getJoueur2().actionOnHero(this.actionHeros);
                break;

            case TOUS:
                Jeu.getJoueur1().actionOnHero(this.actionHeros);
                Jeu.getJoueur2().actionOnHero(this.actionHeros);
                break;
        }
    }

    private void actionInvocation(Player cible){
        for(Serviteur serviteur: this.listeInvocation){
            Jeu.getPlateau().addCarte(cible, serviteur);
        }
    }

    public void addInvocation(Serviteur serviteur){
        listeInvocation.add(serviteur);
    }

    public void setActionServiteur(ActionServiteur actionServiteur) {
        this.actionServiteur = actionServiteur;
    }

    public void setActionHeros(ActionHeros actionHeros){ this.actionHeros = actionHeros; }

    public void setServiteur(Serviteur serviteur) {
        this.serviteur = serviteur;
    }

    public void setNbCartes(int nbCartes) {
        this.nbCartes = nbCartes;
    }

    public String getDescr(){
        return this.descr;
    }

    public TypeEffet getTypeEffet(){
        return this.typeEffet;
    }

    public Player getCible(){
        return this.cible;
    }

}
