package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionHerosAddDefense extends ActionHeros {

    private int defense;

    public ActionHerosAddDefense(int defense) {
        super();
        this.defense = defense;
    }

    @Override
    public int getDefense() {
        return heros.getDefense() + defense;
    }

}
