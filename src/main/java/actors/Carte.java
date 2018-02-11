package actors;

import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import jeu.Jeu;
import utils.Player;

import java.util.LinkedList;

public abstract class Carte extends Acteur{

    protected Player createur;
    protected String nom;
    protected String description;
    protected int mana;
    protected TypeClasse typeCarte;
    protected LinkedList<Effet> effetsCarte;

    protected Carte(){

    }

    public Carte(Player createur){
        this.createur = createur;
        this.effetsCarte = new LinkedList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getMana() {
        return mana;
    }

    public Player getCreateur() { return createur; }

    public TypeClasse getTypeCarte() {
        return typeCarte;
    }

    public LinkedList<Effet> getEffets() {
        return effetsCarte;
    }

    public void executeEffets(){
        for(Effet effet: effetsCarte) {

            if(effet.getTypeEffet() == TypeEffet.SERVITEUR){
                //TODO

                effet.action();
            } else {
                effet.action();
            }

        }
    }


}
