package decorators;

import actors.Heros;

public class ActionHerosSubMana extends ActionHeros{

    int mana;

    public ActionHerosSubMana(Heros heros, int mana){
        super();
        this.heros = heros;
        this.mana = mana;
    }

    @Override
    public int getMana() {
        return heros.getMana() + mana;
    }
}
