package actors.sorts;

import actors.Sort;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionServiteurAddDegats;
import utils.Player;


public class BenedictionDePuissance extends Sort {

    public BenedictionDePuissance(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.PALADIN;
        this.nom = "Benediction de puissance";
        this.description = "Confere +3 d'attaque à un serviteur";
        this.mana = 1;
        this.vie = 0;

        //initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.SERVITEUR, createur, "+3 d'attaque à un serviteur");
        
        effet.setActionServiteur(new ActionServiteurAddDegats(3));
        this.effetsCarte.add(effet);

    }
}
