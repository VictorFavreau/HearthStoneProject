package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionHerosSubDefense extends ActionHeros{

    private int defense;

    public ActionHerosSubDefense(int defense){
        super();
        this.defense = defense;
    }

    @Override
    public int getDefense() {
        return heros.getDefense() - defense;
    }
}
