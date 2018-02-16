package jeu;

import actors.*;
import actors.deck.Deck;
import actors.deck.DeckGuerrier;
import actors.deck.DeckMage;
import actors.deck.DeckPaladin;
import actors.heros.HerosGuerrier;
import actors.heros.HerosMage;
import actors.heros.HerosPaladin;
import decorators.ActionHeros;
import decorators.ActionHerosAddMana;
import decorators.ActionHerosAddStockMana;
import decorators.ActionHerosSubMana;
import utils.LogType;
import utils.Player;
import utils.Tools;

import java.util.LinkedList;

import static actors.TypeClasse.MAGE;

public class Joueur {

    private TypeClasse classe;
    private Player player;
    private Heros heros;
    private Deck deck;
    private LinkedList<Carte> main;
    private boolean sortUtilise;

    public Joueur(TypeClasse classe, Player player) {

        this.classe = classe;
        this.player = player;

        this.main = new LinkedList<>();

        init();
    }

    /**
     * Initialisation du joueur
     */
    public void init() {
        switch (this.classe) {
            case MAGE:
                this.heros = new HerosMage(this.player);
                this.deck = new DeckMage(this.player);
                break;

            case PALADIN:
                this.heros = new HerosPaladin(this.player);
                this.deck = new DeckPaladin(this.player);
                break;

            case GUERRIER:
                this.heros = new HerosGuerrier(this.player);
                this.deck = new DeckGuerrier(this.player);
                break;
        }
    }

    /**
     * On vérifié que le joueur possède assez de mana pour effectuer une action
     *
     * @param mana quantité de mana requise pour effectuer l'action
     * @return le joueur peut effectuer l'action
     */
    public boolean assezMana(int mana) {
        return this.heros.getMana() >= mana;
    }

    /**
     * Incrémente le stock de mana du heros de 1
     */
    public void addStockMana() {
        if (this.heros.getStockMana() < 10) {
            ActionHeros actionHeros = new ActionHerosAddStockMana(1);
            actionHeros.setHeros(this.heros);
            this.heros = actionHeros;
        }
    }

    /**
     * Incrémente la quantité de mana possédée par le héros de 1
     */
    public void addMana(int mana) {
        if (this.heros.getMana() < this.heros.getStockMana()) {
            ActionHeros actionHeros = new ActionHerosAddMana(mana);
            actionHeros.setHeros(this.heros);
            this.heros = actionHeros;
        }
    }

    /**
     * Redonne au heros tout ses points de mana
     */
    public void setMaxMana() {
        if(heros.getStockMana() - heros.getMana() > 0){
            addMana(heros.getStockMana()-heros.getMana());
        }
    }

    /**
     * Une action est effectuee sur le heros
     *
     * @param action action effectuee
     */
    public void actionOnHero(ActionHeros action) {
        action.setHeros(this.heros);
        this.heros = action;
    }

    /**
     * On vérifie si le heros est mort
     *
     * @return Le heros est il mort ?
     */
    public boolean isDead() {
        return this.heros.isDead();
    }

    /**
     * Le joueur pioche une carte
     */
    public void pioche() {

        Tools.log("pioche une carte", Tools.getLogPlayer(player));

        Carte carte = this.deck.getRandomCard();
        this.main.add(carte);

    }

    public void wakeUpServiteurs(){
        Jeu.getPlateau().wakeUpServiteurs(player);
    }

    public void attaque(){
        Jeu.getPlateau().attaque(this.player);
    }

    public void actionSpeciale(){

        if(!this.sortUtilise){
            Jeu.getPlateau().actionSpeciale(player);
        } else {
            Tools.log("Vous avez deja utilisé votre sort au cours de ce tour !", LogType.WARNING);
        }


    }

    public void poseCarte() {

        boolean valide = false;

        Tools.log("", Tools.getLogPlayer(player));
        String msg = "Quelle carte souhaitez vous poser ? Il vous reste: "+ heros.getMana() + "/"+ heros.getStockMana() +" mana\n" + afficheMain();
        int indice = Tools.readIntegerValue(msg);


        if (indice >= 0 && indice < main.size()) {
            valide = true;
            Carte carte = main.get(indice);

            if(assezMana(carte.getMana())){
                switch (carte.getTypeActeur()) {
                    case SERVITEUR:
                        Tools.log("Vous posez le Serviteur: " + carte.getNom(), Tools.getLogPlayer(player));

                        Jeu.getPlateau().poseCarte(player, (Serviteur) carte);
                        main.remove(indice);
                        break;

                    case SORT:
                        Tools.log("Vous posez le Sort: " + carte.getNom(), Tools.getLogPlayer(player));
                        carte.executeEffets();
                        main.remove(indice);
                        break;
                }

                ActionHeros actionHeros = new ActionHerosSubMana(carte.getMana());
                actionHeros.setHeros(this.heros);
                this.heros = actionHeros;

            } else {
                Tools.log("Vous n'avez pas assez de mana pour poser cette carte...", LogType.WARNING);
            }




        } else {
            Tools.log("Oops, il semblerait que la carte que vous souhaitez poser n'est pas dans votre main...", LogType.WARNING);
        }


    }

    public Heros getHeros() {
        return this.heros;
    }

    /**
     * Methode retournant la main du Joueur
     *
     * @return main du joueur
     */
    public String afficheMain() {

        StringBuilder cartes = new StringBuilder("Main: \n");

        for (int i = 0; i < this.main.size(); i++) {

            String stat = "";

            if (this.main.get(i).getTypeActeur() == TypeActeur.SERVITEUR) {
                Serviteur serviteur = (Serviteur) this.main.get(i);
                stat = serviteur.getDegats() + ":" + serviteur.getVie();
            }

            cartes.append("(" + i + ") " + this.main.get(i).toString() + ",\n");
        }

        return cartes.toString();

    }

    public String toString() {

        StringBuilder strBuilder = new StringBuilder("\n");
        strBuilder.append("Classe: " + this.classe + "\n");
        strBuilder.append("Mana: " + this.heros.getMana() + "/" + this.heros.getStockMana() + "\n");
        strBuilder.append("Heros: " + this.heros.getDefense() + "def " + this.heros.getVie() + "hp  effet: " + heros.getDescr());


        return strBuilder.toString();
    }

    public void setSortUtilise(boolean sortUtilise) {
        this.sortUtilise = sortUtilise;
    }
}
