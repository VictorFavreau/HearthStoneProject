package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionHerosSubMana extends ActionHeros{

    int mana;

    public ActionHerosSubMana(int mana){
        super();
        this.heros = heros;
        this.mana = mana;
    }

    @Override
    public int getMana() {
        return heros.getMana() - mana;
    }
}
