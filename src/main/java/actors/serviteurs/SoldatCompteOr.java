package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class SoldatCompteOr extends Serviteur {

    public SoldatCompteOr(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Soldat du compte-de-l'or";
        this.description = "";
        this.mana = 1;
        this.degats = 1;
        this.vie = 2;
        this.sleeping = true;
        this.provocation = true;
        this.volVie = false;
        this.charge = false;
    }
}
