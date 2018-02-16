package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
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
