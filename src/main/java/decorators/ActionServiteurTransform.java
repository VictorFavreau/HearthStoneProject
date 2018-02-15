package decorators;

import actors.sorts.effet.Effet;
import utils.Player;

import java.util.LinkedList;

public class ActionServiteurTransform extends ActionServiteur {

    private Player createur;
    private String nom;
    private int degats;
    private int vie;
    private boolean sleeping;
    private boolean provocation;
    private boolean volVie;
    private LinkedList<Effet> listeEffets;



    public ActionServiteurTransform(Player createur, int degats, int vie, boolean sleeping, boolean provocation, boolean volVie, LinkedList<Effet> listeEffets){
        super();
        this.createur = createur;
        this.nom = "Serviteur";
        this.degats = degats;
        this.vie = vie;
        this.sleeping = sleeping;
        this.provocation = provocation;
        this.volVie = volVie;

        this.effetsCarte = new LinkedList<Effet>();
        this.effetsCarte.addAll(listeEffets);
    }

    @Override
    public Player getCreateur() {
        return createur;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getDegats() {
        return degats;
    }

    @Override
    public int getVie() {
        return vie;
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }

    @Override
    public boolean isProvocation() {
        return provocation;
    }

    @Override
    public boolean isVolVie() {
        return volVie;
    }

    public LinkedList<Effet> getListeEffets() {
        return listeEffets;
    }
}


