package actors.heros;

import actors.Heros;
import actors.TypeActeur;
import actors.TypeClasse;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionHerosSubVie;
import decorators.ActionServiteurSubDegats;
import decorators.ActionServiteurSubVie;
import utils.Player;
import utils.Tools;

public class HerosMage extends Heros {

    public HerosMage(Player joueur){

        this.vie = 30;
        this.typeHeros = TypeClasse.MAGE;
        this.defense = 0;
        this.mana = 1;
        this.stockMana = 1;
        this.descr = "Inflige 1 point de dégats à un adversaire (Serviteur ou Heros)";
        this.typeCibleEffet = TypeActeur.CHOIX;

        //initialisation Effet (dans ce cas, en fonction de la cible un des deux sera executé)
        Effet effet = new Effet(TypeEffet.SERVITEUR, Tools.getAdversaire(joueur), "Inflige 1 point de dégats à un adversaire (Serviteur ou Heros)");
        effet.setActionServiteur(new ActionServiteurSubVie(1));
        this.effetServiteur = effet;

        effet = new Effet(TypeEffet.HEROS, Tools.getAdversaire(joueur), "Inflige 1 point de dégats à un adversaire (Serviteur ou Heros)");
        effet.setActionHeros(new ActionHerosSubVie(1));
        this.effetHeros = effet;
    }

}
