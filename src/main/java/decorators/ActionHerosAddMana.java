package decorators;

import actors.Heros;

public class ActionHerosAddMana extends ActionHeros{

    private int mana;

    public ActionHerosAddMana(Heros heros, int mana){
        super();
        this.heros = heros;
        this.mana = mana;
    }

    public int getMana() {
        return heros.getMana() + mana;
    }
}
