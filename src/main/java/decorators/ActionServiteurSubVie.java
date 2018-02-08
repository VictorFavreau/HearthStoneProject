package decorators;

import actors.Serviteur;

public class ActionServiteurSubVie extends ActionServiteur {

    private int vie;

    public ActionServiteurSubVie(Serviteur serviteur, int vie){
        super();
        this.serviteur = serviteur;
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return serviteur.getVie() - vie;
    }
}
