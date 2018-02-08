package actors.heros;

import actors.Heros;
import actors.TypeClasse;

public class HerosMage extends Heros {

    public HerosMage(){

        this.vie = 30;
        this.typeHeros = TypeClasse.MAGE;
        this.defense = 0;
        this.stockMana = 0;
    }

}
