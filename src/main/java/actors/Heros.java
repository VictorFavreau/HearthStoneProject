package actors;

import actors.sorts.effet.Effet;
import actors.sorts.effet.TypeEffet;

public abstract class Heros extends Acteur {

    protected TypeClasse typeHeros;
    protected int defense;
    protected int stockMana;
    protected int mana;
    protected Effet effetHeros;
    protected Effet effetServiteur;
    protected TypeActeur typeCibleEffet;
    protected String descr;

    public Heros() {
        this.typeActeur = TypeActeur.HEROS;
    }

    /**
     * GETTERS
     */

    public TypeClasse getTypeHeros() {
        return typeHeros;
    }

    public int getDefense() {
        return defense;
    }

    public int getStockMana() {
        return stockMana;
    }

    public int getMana() {
        return mana;
    }

    public String getDescr(){ return descr; };

    public Effet getEffetHeros() {
        return effetHeros;
    }

    public Effet getEffetServiteur() {
        return effetServiteur;
    }

    public TypeActeur getTypeCibleEffet() {
        return typeCibleEffet;
    }
}
