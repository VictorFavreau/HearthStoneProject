package decorators;

import actors.Heros;

public class ActionHerosAddDefense extends ActionHeros {

    private int defense;

    public ActionHerosAddDefense(Heros heros, int defense) {
        super();
        this.heros = heros;
        this.defense = defense;
    }

    @Override
    public int getDefense() {
        return heros.getDefense() + defense;
    }

}
