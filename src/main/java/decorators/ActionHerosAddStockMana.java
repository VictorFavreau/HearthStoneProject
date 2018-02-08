package decorators;

import actors.Heros;

public class ActionHerosAddStockMana extends ActionHeros {

    private int stockMana;

    public ActionHerosAddStockMana(Heros heros, int stockMana){
        super();
        this.heros = heros;
        this.stockMana = stockMana;
    }

    @Override
    public int getStockMana() {
        return heros.getStockMana() + stockMana;
    }
}
