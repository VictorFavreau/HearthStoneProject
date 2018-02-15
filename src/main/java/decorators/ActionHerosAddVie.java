package decorators;

import actors.Heros;

public class ActionHerosAddVie extends ActionHeros {

    private int vie;

    public ActionHerosAddVie(int vie){
        super();
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return heros.getVie() + this.vie;
    }

}
