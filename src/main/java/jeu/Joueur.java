package jeu;

import actors.Carte;
import actors.Heros;
import actors.TypeClasse;
import actors.deck.Deck;
import actors.heros.HerosGuerrier;
import actors.heros.HerosMage;
import actors.heros.HerosPaladin;
import decorators.ActionHeros;

import java.util.LinkedList;

//TODO
public class Joueur {

    private Heros heros;
    private Deck deck;
    private LinkedList<Carte> main;

    public Joueur(TypeClasse classe){

        switch(classe){
            case MAGE:
                this.heros = new HerosMage();
                //this.deck = new DeckMage();
                break;

            case PALADIN:
                this.heros = new HerosPaladin();
                //this.deck = new DeckPaladin();
                break;

            case GUERRIER:
                this.heros = new HerosGuerrier();
                //this.deck = new DeckGuerrier();
                break;
        }

        this.main = new LinkedList<>();

    }

    public void init(){

    }

    public void actionOnHero(ActionHeros action){
        action.setHeros(this.heros);
        this.heros = action;
    }

    public boolean isDead(){
        return this.heros.isDead();
    }

    public void pioche(){

    }


}
