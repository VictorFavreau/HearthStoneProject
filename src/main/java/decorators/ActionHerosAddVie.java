package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionHerosAddVie extends ActionHeros {

    private int vie;

    public ActionHerosAddVie(int vie){
        super();
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return heros.getVie() + this.vie;
    }

}
