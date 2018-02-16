package actors.deck;

import actors.Carte;
import actors.serviteurs.*;
import utils.Player;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */

public abstract class Deck {

    protected LinkedList<Carte> cartesDeck;
    protected Player joueur;


    protected Deck(Player joueur) {
        this.joueur = joueur;
        this.cartesDeck = new LinkedList<>();

        this.cartesDeck.add(new SanglierBrocheroc(joueur));
        this.cartesDeck.add(new SoldatCompteOr(joueur));
        this.cartesDeck.add(new ChevaucheurDeLoup(joueur));
        this.cartesDeck.add(new ChefDeRaid(joueur));
        this.cartesDeck.add(new YetiNoroit(joueur));
    }

    public LinkedList<Carte> getDeck() {
        return this.cartesDeck;
    }

    public Carte getRandomCard() {

        Random randomGenerator = new Random();
        int randomIndice = randomGenerator.nextInt(cartesDeck.size());

        return (Carte) cartesDeck.get(randomIndice).clone();
    }

}
