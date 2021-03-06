package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionServiteurAddDegats;
import decorators.ActionServiteurSubDegats;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ChefDeRaid extends Serviteur {

    public ChefDeRaid(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Chef de raid";
        this.description = "+1 d'attaque pour tous les serviteurs allies du plateau (tant que ce serviteur est vivant)";
        this.mana = 3;
        this.degats = 2;
        this.vie = 2;
        this.sleeping = true;
        this.provocation = false;
        this.volVie = false;
        this.charge = false;

        //Initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.PLATEAU, createur, "+1 d'attaque pour tous les serviteurs allies du plateau (tant que ce serviteur est vivant)");
        effet.setActionServiteur(new ActionServiteurAddDegats(1));
        this.effetsCarte.add(effet);


        //Initialisation des effetsDie
        Effet effetDie = new Effet(TypeEffet.PLATEAU, createur, "");
        effetDie.setActionServiteur(new ActionServiteurSubDegats(1));
        this.effetsDie.add(effetDie);

    }
}
