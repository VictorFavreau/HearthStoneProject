package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;

public class ChampionFriselame extends Serviteur {

    public ChampionFriselame(){
        super();
        this.typeCarte = TypeClasse.PALADIN;
        this.nom = "Chef de raid";
        this.description = "+1 d'attaque pour tous les serviteurs alliés du plateau (tant que ce serviteur est vivant).";
        this.mana = 3;
        this.degats = 2;
        this.vie = 2;
        this.sleeping = false;
        this.provocation = false;
        this.volVie = true;
    }
}
