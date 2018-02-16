package actors.deck;

import actors.serviteurs.AvocatCommisOffice;
import actors.sorts.MaitriseDuBlocage;
import actors.sorts.Tourbillon;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class DeckGuerrier extends Deck{

    public DeckGuerrier(Player joueur){
        super(joueur);

        this.cartesDeck.add(new Tourbillon(joueur));
        this.cartesDeck.add(new AvocatCommisOffice(joueur));
        this.cartesDeck.add(new MaitriseDuBlocage(joueur));
    }
}
