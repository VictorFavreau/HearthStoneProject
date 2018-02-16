package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionServiteurAddVie extends ActionServiteur{

    private int vie;

    public ActionServiteurAddVie(int vie){
        super();
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return serviteur.getVie() + vie;
    }
}
