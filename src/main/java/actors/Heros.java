package actors;

public abstract class Heros extends Acteur{

    protected TypeClasse typeHeros;
    protected int defense;
    protected int stockMana;
    protected int mana;
    //protected ActionSpeciale actionSpeciale; EN ATTENTE D'IMPLEMENTATION

    public Heros(){

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

    public int getMana(){
        return mana;
    }
}
