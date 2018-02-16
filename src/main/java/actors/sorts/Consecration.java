package actors.sorts;

import actors.Sort;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionHeros;
import decorators.ActionHerosSubVie;
import decorators.ActionServiteurSubVie;
import utils.Player;
import utils.Tools;


public class Consecration extends Sort{

    public Consecration(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.PALADIN;
        this.nom = "Consecration";
        this.description = "Inflige 2 points de degats à tous les adversaires";
        this.mana = 4;
        this.vie = 0;

        //initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.PLATEAU, Tools.getAdversaire(createur), "Inflige 2 points de degats à tous les adversaires (Serviteurs)");
        effet.setActionServiteur(new ActionServiteurSubVie(2));
        this.effetsCarte.add(effet);

        Effet effet2 = new Effet(TypeEffet.HEROS, Tools.getAdversaire(createur), "Inflige 2 points de degats à tous les adversaires (Heros)");
        effet2.setActionHeros(new ActionHerosSubVie(2));
        this.effetsCarte.add(effet2);

    }
}
