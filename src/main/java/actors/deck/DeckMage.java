package actors.deck;

import actors.sorts.ExplosionDesArcanes;
import actors.sorts.ImageMirroir;
import actors.sorts.Methamorphose;
import utils.Player;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class DeckMage extends Deck{

    public DeckMage(Player joueur){
        super(joueur);

        this.cartesDeck.add(new ImageMirroir(joueur));
        this.cartesDeck.add(new ExplosionDesArcanes(joueur));
        this.cartesDeck.add(new Methamorphose(joueur));
    }
}
