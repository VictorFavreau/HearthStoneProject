package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class AvocatCommisOffice extends Serviteur {

    public AvocatCommisOffice(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.GUERRIER;
        this.nom = "Avocat commis d'office";
        this.description = "";
        this.mana = 2;
        this.degats = 0;
        this.vie = 7;
        this.sleeping = true;
        this.provocation = true;
        this.volVie = false;
        this.charge = false;
    }
}
