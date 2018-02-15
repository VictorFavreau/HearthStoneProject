package actors.heros;

import actors.Heros;
import actors.TypeActeur;
import actors.TypeClasse;
import actors.serviteurs.CustomServiteur;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionServiteurSubDegats;
import utils.Player;
import utils.Tools;

import java.util.LinkedList;

public class HerosPaladin extends Heros {

    public HerosPaladin(Player joueur){

        this.vie = 30;
        this.typeHeros = TypeClasse.PALADIN;
        this.defense = 0;
        this.stockMana = 0;
        this.descr = "Invoque un serviteur 'Recrue de la main d'argent' 1:1";
        this.typeCibleEffet = TypeActeur.SERVITEUR;

        //initialisation Effet
        Effet effet = new Effet(TypeEffet.INVOCATION, joueur, "Invoque un serviteur 'Recrue de la main d'argent' 1:1");
        effet.addInvocation(new CustomServiteur(joueur, 1, 1, true, false, false, false, new LinkedList<Effet>()));
        this.effetServiteur = effet;

    }

}
