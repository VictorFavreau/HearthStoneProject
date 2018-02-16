package actors;

import actors.sorts.effet.Effet;
import utils.LogType;
import utils.Player;
import utils.Tools;

import java.util.LinkedList;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public abstract class Serviteur extends Carte{


    protected int degats;
    protected boolean sleeping;
    protected boolean provocation;
    protected boolean volVie;
    protected boolean charge;
    protected LinkedList<Effet> effetsDie;

    protected Serviteur(){
        if(this.effetsDie == null){
            this.effetsDie = new LinkedList<>();
        }

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
        executeEffetsDie();
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

    public boolean isCharge() { return charge; }


    @Override
    public String toString() {

        StringBuilder toStringBuilder = new StringBuilder("");

        toStringBuilder.append(getNom());
        toStringBuilder.append(" Mana:" + getMana() + " ");
        toStringBuilder.append(getDegats() + ":" + getVie() + " ");

        if(isSleeping()) toStringBuilder.append("sleeping ");
        if(isProvocation()) toStringBuilder.append("provocation ");
        if(isVolVie()) toStringBuilder.append("volvie ");
        if(isCharge()) toStringBuilder.append("charge ");

        String effet = getDescription();

        if(!getDescription().equals("")) toStringBuilder.append(" effet: " + getDescription());



        return toStringBuilder.toString();
    }
}
