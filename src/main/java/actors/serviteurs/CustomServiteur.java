package actors.serviteurs;

import actors.Serviteur;
import actors.sorts.effet.Effet;
import utils.Player;

import java.util.LinkedList;

public class CustomServiteur extends Serviteur{

    public CustomServiteur(Player createur, int degats, int vie, boolean sleeping, boolean provocation, boolean volVie, LinkedList<Effet> listeEffets){
        super(createur);
        this.nom = "Serviteur";
        this.degats = degats;
        this.vie = vie;
        this.sleeping = sleeping;
        this.provocation = provocation;
        this.volVie = volVie;
        this.effetsCarte.addAll(listeEffets);

    }
}
