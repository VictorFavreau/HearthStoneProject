package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import utils.Player;

public class SanglierBrocheroc  extends Serviteur {

    public SanglierBrocheroc(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Sanglier brocheroc";
        this.description = "";
        this.mana = 1;
        this.degats = 1;
        this.vie = 1;
        this.sleeping = true;
        this.provocation = false;
        this.volVie = false;
    }
}
