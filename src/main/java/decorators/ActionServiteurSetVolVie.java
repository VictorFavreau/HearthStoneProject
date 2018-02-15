package decorators;

import actors.Serviteur;

public class ActionServiteurSetVolVie extends ActionServiteur{

    private boolean volVie;

    public ActionServiteurSetVolVie(boolean volVie){
        super();
        this.volVie = volVie;
    }

    public boolean isVolVie() {
        return volVie;
    }
}
