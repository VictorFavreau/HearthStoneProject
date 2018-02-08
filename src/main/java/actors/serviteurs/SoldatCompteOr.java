package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;

public class SoldatCompteOr extends Serviteur {

    public SoldatCompteOr(){
        super();
        this.typeCarte = TypeClasse.NEUTRE;
        this.nom = "Soldat du compté-de-l'or";
        this.description = "";
        this.mana = 1;
        this.degats = 1;
        this.vie = 2;
        this.sleeping = true;
        this.provocation = true;
        this.volVie = false;
    }
}
