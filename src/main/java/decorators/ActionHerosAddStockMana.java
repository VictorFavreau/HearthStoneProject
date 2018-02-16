package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionHerosAddStockMana extends ActionHeros {

    private int stockMana;

    public ActionHerosAddStockMana(int stockMana){
        super();
        this.stockMana = stockMana;
    }

    @Override
    public int getStockMana() {
        return heros.getStockMana() + stockMana;
    }
}
