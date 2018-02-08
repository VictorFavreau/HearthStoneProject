package decorators;

import actors.Serviteur;

public class ActionServiteurAddVie extends ActionServiteur{

    private int vie;

    public ActionServiteurAddVie(Serviteur serviteur, int vie){
        super();
        this.serviteur = serviteur;
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return serviteur.getVie() + vie;
    }
}
