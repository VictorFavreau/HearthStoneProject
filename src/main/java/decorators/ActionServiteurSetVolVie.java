package decorators;

import actors.Serviteur;

public class ActionServiteurSetVolVie extends ActionServiteur{

    private boolean volVie;

    public ActionServiteurSetVolVie(Serviteur serviteur, boolean volVie){
        super();
        this.serviteur = serviteur;
        this.volVie = volVie;
    }

    public boolean isVolVie() {
        return volVie;
    }
}
