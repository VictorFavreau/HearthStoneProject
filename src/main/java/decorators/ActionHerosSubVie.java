package decorators;

import actors.Heros;

public class ActionHerosSubVie extends ActionHeros {

    private int vie;

    public ActionHerosSubVie(int vie){
        super();
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return heros.getVie() - this.vie;
    }

}
