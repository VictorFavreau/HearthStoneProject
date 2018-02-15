package decorators;

import actors.Serviteur;

public class ActionServiteurSetProvocation extends ActionServiteur{

    private boolean provocation;

    public ActionServiteurSetProvocation(boolean provocation){
        super();
        this.provocation = provocation;
    }

    public boolean isProvocation() {
        return provocation;
    }
}
