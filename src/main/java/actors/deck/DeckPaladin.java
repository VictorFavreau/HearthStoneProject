package actors.deck;

import actors.serviteurs.ChampionFriselame;
import actors.sorts.BenedictionDePuissance;
import actors.sorts.Consecration;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class DeckPaladin extends Deck{

    public DeckPaladin(Player joueur){
        super(joueur);

        this.cartesDeck.add(new ChampionFriselame(joueur));
        this.cartesDeck.add(new BenedictionDePuissance(joueur));
        this.cartesDeck.add(new Consecration(joueur));
    }
}
