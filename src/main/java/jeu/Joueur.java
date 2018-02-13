package jeu;

import actors.Carte;
import actors.Heros;
import actors.TypeClasse;
import actors.deck.Deck;
import actors.heros.HerosGuerrier;
import actors.heros.HerosMage;
import actors.heros.HerosPaladin;
import decorators.ActionHeros;
import utils.Player;

import java.util.LinkedList;

import static actors.TypeClasse.MAGE;

//TODO
public class Joueur {

    private TypeClasse classe;
    private Player player;
    private Heros heros;
    private Deck deck;
    private LinkedList<Carte> main;

    public Joueur(TypeClasse classe, Player player){

        this.classe = classe;
        this.player = player;

        this.main = new LinkedList<>();

        init();
    }

    public void init(){
        switch(this.classe){
            case MAGE:
                this.heros = new HerosMage(this.player);
                //this.deck = new DeckMage();
                break;

            case PALADIN:
                this.heros = new HerosPaladin(this.player);
                //this.deck = new DeckPaladin();
                break;

            case GUERRIER:
                this.heros = new HerosGuerrier(this.player);
                //this.deck = new DeckGuerrier();
                break;
        }
    }

    public void actionOnHero(ActionHeros action){
        action.setHeros(this.heros);
        this.heros = action;
    }

    public boolean isDead(){
        return this.heros.isDead();
    }

    public void pioche(){
        //TODO
    }

    public Heros getHeros(){ return this.heros; }


}
