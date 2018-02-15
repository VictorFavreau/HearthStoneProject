package decorators;

import actors.Serviteur;
import actors.sorts.effet.Effet;
import utils.Player;

import java.util.LinkedList;

public abstract class ActionServiteur extends Serviteur {

    Serviteur serviteur;

    protected ActionServiteur(){
        super();
    }

    @Override
    public Player getCreateur() { return serviteur.getCreateur(); }

    @Override
    public String getNom() {
        return serviteur.getNom();
    }

    @Override
    public String getDescription() {
        return serviteur.getDescription();
    }

    @Override
    public int getMana() {
        return serviteur.getMana();
    }

    @Override
    public int getVie(){ return serviteur.getVie(); }

    @Override
    public int getDegats(){ return serviteur.getDegats(); }

    @Override
    public boolean isSleeping(){ return serviteur.isSleeping(); }

    @Override
    public boolean isProvocation(){ return serviteur.isProvocation(); }

    @Override
    public boolean isVolVie(){ return serviteur.isVolVie(); }

    @Override
    public boolean isCharge() {
        return serviteur.isCharge();
    }

    @Override
    public LinkedList<Effet> getEffets(){ return serviteur.getEffets(); }

    public void setServiteur(Serviteur serviteur){
        this.serviteur = (Serviteur) serviteur.clone();
    }



}
