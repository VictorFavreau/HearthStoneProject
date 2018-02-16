package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionHerosAddMana extends ActionHeros{

    private int mana;

    public ActionHerosAddMana(int mana){
        super();
        this.mana = mana;
    }

    public int getMana() {
        return heros.getMana() + mana;
    }
}
