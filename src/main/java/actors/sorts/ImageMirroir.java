package actors.sorts;

import actors.Sort;
import actors.TypeClasse;
import actors.serviteurs.CustomServiteur;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import utils.Player;

import java.util.LinkedList;


public class ImageMirroir extends Sort {

    public ImageMirroir(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.MAGE;
        this.nom = "Image mirroir";
        this.description = "invoque 2 serviteurs 0:2 avec provocation";
        this.mana = 1;
        this.vie = 0;

        //initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.INVOCATION, createur, "invique 2 serviteurs 0:2 avec provocation");
        effet.addInvocation(new CustomServiteur(createur, 0, 2, true, true, false, new LinkedList<Effet>()));
        effet.addInvocation(new CustomServiteur(createur, 0, 2, true, true, false, new LinkedList<Effet>()));
        this.effetsCarte.add(effet);

    }

}
