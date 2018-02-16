package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionHerosSubVie extends ActionHeros {

    private int vie;

    public ActionHerosSubVie(int vie){
        super();
        this.vie = vie;
    }

    @Override
    public int getVie() {
        return heros.getVie() - this.vie;
    }

}
