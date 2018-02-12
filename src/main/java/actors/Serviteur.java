package actors;

import actors.sorts.effet.Effet;
import utils.LogType;
import utils.Player;
import utils.Tools;

import java.util.LinkedList;

/**
 * author: Anais BESSON & Victor FAVREAU
 */
public abstract class Serviteur extends Carte implements Cloneable{


    protected int degats;
    protected boolean sleeping;
    protected boolean provocation;
    protected boolean volVie;
    protected LinkedList<Effet> effetsDie;

    protected Serviteur(){

    }

    public Serviteur(Player createur){
        super(createur);
        this.typeActeur = TypeActeur.SERVITEUR;
        this.effetsDie = new LinkedList<>();
    }

    public void executeEffetsDie(){
        for(Effet effet: effetsDie){
            effet.action();
        }
    }

    /**
     * GETTERS
     */
    public void die(){

        Tools.log("Le Serviteur: " + getNom() + " meurt !", LogType.WARNING);

        for(Effet effetDie: effetsDie){
            effetDie.action();
        }
    }

    public int getDegats() {
        return degats;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public boolean isProvocation() {
        return provocation;
    }

    public boolean isVolVie() {
        return volVie;
    }

    public Object clone(){
        Object o = null;

        try{
            o = super.clone();
        } catch(CloneNotSupportedException cnse){
            cnse.printStackTrace();
        }

        return o;
    }

    @Override
    public String toString() {

        StringBuilder toStringBuilder = new StringBuilder("");

        toStringBuilder.append(getNom() + " ");
        toStringBuilder.append(getDegats() + ":" + getVie() + " ");

        if(sleeping) toStringBuilder.append("sleeping ");
        if(sleeping) toStringBuilder.append("provocation ");
        if(sleeping) toStringBuilder.append("volvie ");

        return toStringBuilder.toString();


    }
}
