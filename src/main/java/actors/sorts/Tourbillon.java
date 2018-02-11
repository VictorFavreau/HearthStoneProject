package actors.sorts;

import actors.Sort;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionServiteurSubVie;
import utils.Player;


public class Tourbillon extends Sort {

    public Tourbillon(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.GUERRIER;
        this.nom = "Tourbillon";
        this.description = "Inflige 1 points de dégats à TOUS les serviteurs (y compris les vôtres)";
        this.mana = 1;
        this.vie = 0;

        //initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.PLATEAU, Player.TOUS, "Inflige 1 points de dégats à TOUS les serviteurs (y compris les vôtres)");
        effet.setActionServiteur(new ActionServiteurSubVie(null, 1));
        this.effetsCarte.add(effet);

    }


}
