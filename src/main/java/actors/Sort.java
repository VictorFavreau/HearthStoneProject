package actors;

import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class Sort extends Carte{

    protected Sort(){

    }

    public Sort(Player createur){
        super(createur);
        this.typeActeur = TypeActeur.SORT;
    }

    @Override
    public String toString() {

        StringBuilder toStringBuilder = new StringBuilder("");

        toStringBuilder.append(getNom());
        toStringBuilder.append(" Mana:"+ getMana());

        if(!getDescription().equals("")) toStringBuilder.append(" effet: " + getDescription());

        return toStringBuilder.toString();
    }

}
