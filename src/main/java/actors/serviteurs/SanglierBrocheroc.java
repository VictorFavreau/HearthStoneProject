package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;

public class SanglierBrocheroc  extends Serviteur {

    public SanglierBrocheroc(){
        super();
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
