package decorators;

import actors.Serviteur;

public class ActionServiteurSetSleeping extends ActionServiteur {

    private boolean sleeping;

    public ActionServiteurSetSleeping(boolean sleeping){
        super();
        this.sleeping = sleeping;
    }

    @Override
    public boolean isSleeping() {
        return this.sleeping;
    }
}
