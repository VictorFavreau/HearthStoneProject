package actors.heros;

import actors.Heros;
import actors.TypeActeur;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionHerosAddDefense;
import decorators.ActionServiteurAddDegats;
import decorators.ActionServiteurSubDegats;
import utils.Player;
import utils.Tools;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class HerosGuerrier extends Heros {

    public HerosGuerrier(Player joueur){

        this.vie = 30;
        this.typeHeros = TypeClasse.MAGE;
        this.defense = 0;
        this.mana = 1;
        this.stockMana = 1;
        this.descr = "Confère 2 points d'armure au Heros";
        this.typeCibleEffet = TypeActeur.HEROS;

        //initialisation Effet
        Effet effet = new Effet(TypeEffet.HEROS, joueur, "Confère 2 points d'armure au Heros");
        effet.setActionHeros(new ActionHerosAddDefense(2));
        this.effetHeros = effet;



    }


}
