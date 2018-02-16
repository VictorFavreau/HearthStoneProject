package actors.serviteurs;

import actors.Serviteur;
import actors.TypeClasse;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ChampionFriselame extends Serviteur {

    public ChampionFriselame(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.PALADIN;
        this.nom = "Chef de raid";
        this.description = "+1 d'attaque pour tous les serviteurs allies du plateau (tant que ce serviteur est vivant).";
        this.mana = 3;
        this.degats = 2;
        this.vie = 2;
        this.sleeping = false;
        this.provocation = false;
        this.volVie = true;
        this.charge = true;
    }
}
