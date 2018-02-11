package actors.sorts.effet;

import actors.Serviteur;
import decorators.ActionServiteur;
import jeu.Jeu;
import utils.Player;

public class Effet {

    private Player cible;
    private TypeEffet typeEffet;
    private ActionServiteur actionServiteur;
    private Serviteur serviteur;
    private int nbCartes;

    public Effet(TypeEffet typeEffet, Player cible){
        super();
        this.typeEffet = typeEffet;
        this.cible = cible;
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

    public void setActionServiteur(ActionServiteur actionServiteur) {
        this.actionServiteur = actionServiteur;
    }

    public void setServiteur(Serviteur serviteur) {
        this.serviteur = serviteur;
    }

    public void setNbCartes(int nbCartes) {
        this.nbCartes = nbCartes;
    }

    public TypeEffet getTypeEffet(){
        return this.typeEffet;
    }
}
