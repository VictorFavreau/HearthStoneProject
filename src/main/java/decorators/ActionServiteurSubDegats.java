package decorators;

import actors.Serviteur;

public class ActionServiteurSubDegats extends ActionServiteur {

    private int degats;

    public ActionServiteurSubDegats(Serviteur serviteur, int degats){
        super();
        this.serviteur = serviteur;
        this.degats = degats;
    }

    @Override
    public int getDegats() {
        return serviteur.getDegats() - degats;
    }
}
