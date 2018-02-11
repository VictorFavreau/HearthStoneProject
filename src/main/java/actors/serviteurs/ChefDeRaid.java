package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionServiteurAddDegats;
import decorators.ActionServiteurSubDegats;
import utils.Player;

public class ChefDeRaid extends Serviteur {

    public ChefDeRaid(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Chef de raid";
        this.description = "+1 d'attaque pour tous les serviteurs alliés du plateau (tant que ce serviteur est vivant).";
        this.mana = 3;
        this.degats = 2;
        this.vie = 2;
        this.sleeping = true;
        this.provocation = false;
        this.volVie = false;

        //Initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.PLATEAU, createur, "+1 d'attaque pour tous les serviteurs alliés du plateau (tant que ce serviteur est vivant)");
        effet.setActionServiteur(new ActionServiteurAddDegats(null, 1));
        this.effetsCarte.add(effet);

        //Initialisation des effetsDie
        effet.setActionServiteur(new ActionServiteurSubDegats(null, 1));
        this.effetsDie.add(effet);
    }
}
