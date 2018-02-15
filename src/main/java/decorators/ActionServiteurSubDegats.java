package decorators;

import actors.Serviteur;

public class ActionServiteurSubDegats extends ActionServiteur {

    private int degats;

    public ActionServiteurSubDegats(int degats){
        super();
        this.degats = degats;
    }

    @Override
    public int getDegats() {
        return serviteur.getDegats() - degats;
    }
}
