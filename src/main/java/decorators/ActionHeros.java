package decorators;

import actors.Heros;
import actors.TypeActeur;
import actors.TypeClasse;
import actors.heros.HerosGuerrier;
import actors.sorts.effet.Effet;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
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

    @Override
    public String getDescr(){ return heros.getDescr(); }

    @Override
    public TypeActeur getTypeCibleEffet() {
        return heros.getTypeCibleEffet();
    }

    @Override
    public Effet getEffetHeros() {
        return heros.getEffetHeros();
    }

    @Override
    public Effet getEffetServiteur() {
        return heros.getEffetServiteur();
    }

    public void setHeros(Heros heros){
        this.heros = (Heros) heros.clone();
    }

}
