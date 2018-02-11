package decorators;

import actors.Heros;

public abstract class ActionHeros extends Heros{

    Heros heros;

    protected ActionHeros(){
        super();
    }

    @Override
    public int getVie(){ return heros.getVie(); }

    @Override
    public int getDefense(){ return heros.getDefense(); }

    @Override
    public int getStockMana(){ return heros.getStockMana(); }

    @Override
    public int getMana(){ return heros.getMana(); }

    public void setHeros(Heros heros){
        this.heros = heros;
    }

}
