package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionServiteurSubVie extends ActionServiteur {

    private int vie;

    public ActionServiteurSubVie(int vie){
        super();

        this.vie = vie;
    }

    @Override
    public int getVie() {
        return serviteur.getVie() - vie;
    }
}
