package decorators;

import actors.Heros;

public class ActionHerosAddVie extends ActionHeros {

    private int vie;

    public ActionHerosAddVie(Heros heros, int vie){
        super();
        this.heros = heros;
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return heros.getVie() + this.vie;
    }

}
