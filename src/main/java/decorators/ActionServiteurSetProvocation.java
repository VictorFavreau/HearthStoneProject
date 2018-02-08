package decorators;

import actors.Serviteur;

public class ActionServiteurSetProvocation extends ActionServiteur{

    private boolean provocation;

    public ActionServiteurSetProvocation(Serviteur serviteur, boolean provocation){
        super();
        this.serviteur = serviteur;


        this.provocation = provocation;
    }

    public boolean isProvocation() {
        return provocation;
    }
}
