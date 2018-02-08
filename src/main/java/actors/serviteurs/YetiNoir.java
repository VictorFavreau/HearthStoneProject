package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;

public class YetiNoir extends Serviteur {

    public YetiNoir(){
        super();
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Yéti Noir";
        this.description = "";
        this.mana = 4;
        this.degats = 4;
        this.vie = 5;
        this.sleeping = true;
        this.provocation = false;
        this.volVie = false;
    }
}
