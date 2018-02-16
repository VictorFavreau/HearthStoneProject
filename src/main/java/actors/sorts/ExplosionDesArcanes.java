package actors.sorts;

import actors.Sort;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionServiteurSubVie;
import utils.Player;
import utils.Tools;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ExplosionDesArcanes extends Sort {

    public ExplosionDesArcanes(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.MAGE;
        this.nom = "Explosion des arcanes";
        this.description = "Inflige 1 point de degats a tous les serviteurs adverses";
        this.mana = 2;
        this.vie = 0;

        //initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.PLATEAU, Tools.getAdversaire(createur), "Inflige 1 point de dégats a tous les serviteurs adverses");
        effet.setActionServiteur(new ActionServiteurSubVie(1));
        this.effetsCarte.add(effet);
    }

}
