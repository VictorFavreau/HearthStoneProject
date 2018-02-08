package decorators;

import actors.Serviteur;

public class ActionServiteurSetSleeping extends ActionServiteur {

    private boolean sleeping;

    public ActionServiteurSetSleeping(Serviteur serviteur, boolean sleeping){
        super();
        this.serviteur = serviteur;
        this.sleeping = sleeping;
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}
