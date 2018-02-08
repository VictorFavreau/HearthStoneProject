package decorators;

import actors.Heros;

public class ActionHerosSubDefense extends ActionHeros{

    private int defense;

    public ActionHerosSubDefense(Heros heros, int defense){
        super();
        this.heros = heros;
        this.defense = defense;
    }

    @Override
    public int getDefense() {
        return heros.getDefense() - defense;
    }
}
