package decorators;

import actors.Heros;

public class ActionHerosSubVie extends ActionHeros {

    private int vie;

    public ActionHerosSubVie(Heros heros, int vie){
        super();
        this.heros = heros;
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return heros.getVie() - this.vie;
    }

}
