package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;

public class ChevaucheurDeLoup  extends Serviteur {

    public ChevaucheurDeLoup(){
        super();
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Chevaucheur de loup";
        this.description = "";
        this.mana = 3;
        this.degats = 3;
        this.vie = 1;
        this.sleeping = false;
        this.provocation = false;
        this.volVie = false;
    }
}
