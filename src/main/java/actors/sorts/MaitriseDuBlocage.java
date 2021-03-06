package actors.sorts;

import actors.Sort;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionHerosAddDefense;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class MaitriseDuBlocage extends Sort{

    public MaitriseDuBlocage(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.GUERRIER;
        this.nom = "Maitrise du bloquage";
        this.description = "+5 d'armure au Heros et place une carte aleatoire de la pioche dans votre main";
        this.mana = 3;
        this.vie = 0;

        //initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.HEROS, createur, "+5 d'armure au Heros");
        effet.setActionHeros(new ActionHerosAddDefense(5));
        this.effetsCarte.add(effet);

        Effet effet2 = new Effet(TypeEffet.PIOCHE, createur, "place une carte aléatoire de la pioche dans votre main");
        effet2.setNbCartes(1);
        this.effetsCarte.add(effet2);

    }

}
