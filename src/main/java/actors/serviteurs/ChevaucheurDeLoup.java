package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ChevaucheurDeLoup  extends Serviteur {

    public ChevaucheurDeLoup(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Chevaucheur de loup";
        this.description = "";
        this.mana = 3;
        this.degats = 3;
        this.vie = 1;
        this.sleeping = false;
        this.provocation = false;
        this.volVie = false;
        this.charge = true;
    }
}
