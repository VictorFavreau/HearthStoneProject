package actors.sorts;

import actors.Sort;
import actors.TypeClasse;
import actors.serviteurs.CustomServiteur;
import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;
import decorators.ActionServiteurTransform;
import utils.Player;
import utils.Tools;

import java.util.LinkedList;

public class Methamorphose extends Sort {

    public Methamorphose(Player createur){
        super(createur);
        this.typeCarte = TypeClasse.MAGE;
        this.nom = "Methamorphose";
        this.description = "Transforme un serviteur en serviteur 1:1 sans effet";
        this.mana = 4;
        this.vie = 0;

        //initialisation des effetsCarte
        Effet effet = new Effet(TypeEffet.SERVITEUR, Tools.getAdversaire(createur), "Transforme un serviteur en serviteur 1:1 sans effet");
        effet.setActionServiteur(new ActionServiteurTransform(Tools.getAdversaire(createur), 1, 1, false, false, false, new LinkedList<Effet>()));
        this.effetsCarte.add(effet);
    }
}
