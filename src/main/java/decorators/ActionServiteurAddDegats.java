package decorators;

import actors.Serviteur;

public class ActionServiteurAddDegats extends ActionServiteur {

    private int degats;

    public ActionServiteurAddDegats(Serviteur serviteur, int degats){
        super();
        this.serviteur = serviteur;
        this.degats = degats;
    }

    @Override
    public int getDegats() {
        return serviteur.getDegats() + degats;
    }
}
