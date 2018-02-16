package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class YetiNoroit extends Serviteur {

    public YetiNoroit(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Yéti Noroit";
        this.description = "";
        this.mana = 4;
        this.degats = 4;
        this.vie = 5;
        this.sleeping = true;
        this.provocation = false;
        this.volVie = false;
        this.charge = false;
    }
}
