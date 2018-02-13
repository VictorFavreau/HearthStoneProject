package jeu;

import actors.*;
import decorators.*;
import utils.LogType;
import utils.Player;
import utils.Tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Plateau {

    ArrayList<Serviteur> serviteursJ1;
    ArrayList<Serviteur> serviteursJ2;

    public Plateau() {
        this.serviteursJ1 = new ArrayList<>();
        this.serviteursJ2 = new ArrayList<>();
    }

    /**
     * Pose la carte sur le plateau du joueur concerné et execute ses effets
     *
     * @param player    Joueur concerné
     * @param serviteur Serviteur à poser
     */
    public void poseCarte(Player player, Serviteur serviteur) {

        switch (player) {
            case JOUEUR1:
                serviteur.executeEffets();
                this.serviteursJ1.add(serviteur);
                break;

            case JOUEUR2:
                serviteur.executeEffets();
                this.serviteursJ2.add(serviteur);
                break;

            default:
                Tools.log("Rien ne se passe...", LogType.INFO);
                break;
        }

    }

    /**
     * Execute une action sur la carte d'un joueur
     *
     * @param player    joueur concerné
     * @param serviteur indice de la carte
     * @param action    action effectuee sur la carte
     */
    public void actionOnCard(Player player, Serviteur serviteur, ActionServiteur action) {

        switch (player) {
            case JOUEUR1:
                serviteursJ1 = executeAction(this.serviteursJ1, serviteur, action);
                break;

            case JOUEUR2:
                serviteursJ2 = executeAction(this.serviteursJ2, serviteur, action);
                break;

            default:
                Tools.log("Rien ne se passe...", LogType.INFO);
                break;
        }

        purge();
    }

    /**
     * Execute une action sur la carte du joueur
     *
     * @param serviteurs serviteurs du joueur
     * @param serviteur  serviteur concerne
     * @param action     action effectuee sur la carte
     */
    private ArrayList<Serviteur> executeAction(ArrayList<Serviteur> serviteurs, Serviteur serviteur, ActionServiteur action) {
        if (serviteurs.contains(serviteur)) {

            int indiceCarte = serviteurs.indexOf(serviteur);

            ActionServiteur actionServiteur = (ActionServiteur) action.clone();

            actionServiteur.setServiteur(serviteurs.get(indiceCarte));
            serviteurs.set(indiceCarte, actionServiteur);

        } else {
            Tools.log("Rien ne se passe...", LogType.INFO);
        }

        return serviteurs;
    }


    public void actionOnCards(Player player, ActionServiteur action) {
        switch (player) {
            case JOUEUR1:
                serviteursJ1 = executeActions(this.serviteursJ1, action);
                break;

            case JOUEUR2:
                serviteursJ2 = executeActions(this.serviteursJ2, action);
                break;

            case TOUS:
                serviteursJ1 = executeActions(this.serviteursJ1, action);
                serviteursJ2 = executeActions(this.serviteursJ2, action);
                break;
            default:
                Tools.log("Rien ne se passe...", LogType.INFO);
                break;
        }

        purge();
    }

    private ArrayList<Serviteur> executeActions(ArrayList<Serviteur> serviteurs, ActionServiteur action) {

        for (int indice = 0; indice < serviteurs.size(); indice++) {

            ActionServiteur actionServiteur = (ActionServiteur) action.clone();
            actionServiteur.setServiteur(serviteurs.get(indice));
            serviteurs.set(indice, actionServiteur);
        }

        return serviteurs;
    }

    public void attaque(Player joueurAttaquant) {

        Player adversaire = Tools.getAdversaire(joueurAttaquant);

        Tools.log("Selectionnez l'attaquant:", Tools.getLogPlayer(joueurAttaquant));
        Serviteur attaquant = Tools.readServiteur(joueurAttaquant);

        if(!attaquant.isSleeping()){

            TypeActeur typeActeur = Tools.getTypeCible();

            switch (typeActeur) {
                case SERVITEUR:
                    //On controle que le plateau du joueur cible n'est pas vide
                    if(isCartesPlateauJoueur(adversaire)){

                        Tools.log("Selectionnez le Serviteur cible de l'attaque:", Tools.getLogPlayer(joueurAttaquant));
                        Serviteur cible = Tools.readServiteur(adversaire);

                        //On vérifie la présence de Serviteurs disposants de l'effet Provocation sur le plateau adverse. S'il y en a ils doivent être ciblés
                        if(cible.isProvocation() || !isServiteurProvoquant(adversaire)){

                            //Le serviteur attaque la cible
                            Jeu.getPlateau().actionOnCard(adversaire,cible, new ActionServiteurSubVie(null, attaquant.getDegats()));

                            //L'attaquant prend des dégats
                            Jeu.getPlateau().actionOnCard(joueurAttaquant,attaquant, new ActionServiteurSubVie(null, cible.getDegats()));

                            if(attaquant.isVolVie()){
                                switch (joueurAttaquant){
                                    case JOUEUR1:
                                        Jeu.getJoueur1().actionOnHero(new ActionHerosAddVie(null, attaquant.getDegats()));
                                        break;

                                    case JOUEUR2:
                                        Jeu.getJoueur2().actionOnHero(new ActionHerosAddVie(null, attaquant.getDegats()));
                                        break;
                                }
                            }
                        }
                    }

                    break;

                case HEROS:

                    int subVie = 0;
                    int subDefense = 0;

                    switch (adversaire){
                        case JOUEUR1:

                            if(!isServiteurProvoquant(adversaire)){

                                if(Jeu.getJoueur1().getHeros().getDefense() >= attaquant.getDegats()){
                                    subDefense = attaquant.getDegats();
                                } else {
                                    subDefense = Jeu.getJoueur1().getHeros().getDefense();
                                    subVie = attaquant.getDegats() - subDefense;
                                }

                                if(subDefense > 0){
                                    Jeu.getJoueur1().actionOnHero(new ActionHerosSubDefense(null, subDefense));
                                }

                                if(subVie > 0){
                                    Jeu.getJoueur1().actionOnHero(new ActionHerosSubVie(null, subVie));
                                }

                            } else {
                                Tools.log("Un serviteur avec l'effet Provocation gène votre attaque. Elle échoue (dignement bien ententu !).", Tools.getLogPlayer(joueurAttaquant));
                            }

                            break;

                        case JOUEUR2:

                            if(!isServiteurProvoquant(adversaire)){

                                if(Jeu.getJoueur2().getHeros().getDefense() >= attaquant.getDegats()){
                                    subDefense = attaquant.getDegats();
                                } else {
                                    subDefense = Jeu.getJoueur2().getHeros().getDefense();
                                    subVie = attaquant.getDegats() - subDefense;
                                }

                                if(subDefense > 0){
                                    Jeu.getJoueur2().actionOnHero(new ActionHerosSubDefense(null, subDefense));
                                }

                                if(subVie > 0){
                                    Jeu.getJoueur2().actionOnHero(new ActionHerosSubVie(null, subVie));
                                }

                            } else {
                                Tools.log("Un serviteur avec l'effet Provocation gène votre attaque. Elle échoue (dignement bien ententu !).", Tools.getLogPlayer(joueurAttaquant));
                            }

                            break;
                    }

                    break;
            }

        } else {
            Tools.log("Le serviteur attaquant est en train de dormir ! Il serait dommage de le révéiller de façon si brutale...", LogType.INFO);
        }
    }

    public void actionSpeciale(Player joueurExecutant){

        //TODO
/*
        if(assezMana(joueurExecutant, 2)){

            switch(joueurExecutant){
                case JOUEUR1:






                    break;

                case JOUEUR2:

                    break;
            }

        } else {
            Tools.log("Vous n'avez pas assez de mana pour executer cette action.", LogType.WARNING);
        }
*/


    }


    public boolean assezMana(Player player, int mana){

        switch (player){
            case JOUEUR1:
                return Jeu.getJoueur1().getHeros().getMana() >= mana;

            case JOUEUR2:
                return Jeu.getJoueur2().getHeros().getMana() >= mana;
        }

        return false;
    }

    /**
     * Retourne la liste des cartes du JOUEUR1
     *
     * @return liste des cartes du JOUEUR1
     */
    public List<Serviteur> getCartesJ1() {
        return serviteursJ1;
    }

    /**
     * Retourne la liste des cartes du JOUEUR2
     *
     * @return liste des cartes du JOUEUR2
     */
    public List<Serviteur> getCartesJ2() {
        return serviteursJ2;
    }

    public Serviteur getCarteJ1(int indice) {
        if (indice >= 0 && indice < serviteursJ1.size()) {
            return serviteursJ1.get(indice);
        }

        return null;
    }

    public Serviteur getCarteJ2(int indice) {
        if (indice >= 0 && indice < serviteursJ2.size()) {
            return serviteursJ2.get(indice);
        }

        return null;
    }

    public String afficheCartesJ1() {
        StringBuilder cartes = new StringBuilder();

        for (int i = 0; i < serviteursJ1.size(); i++) {
            cartes.append("(" + i + ") " + serviteursJ1.get(i).getNom() + " " + serviteursJ1.get(i).getDegats() + ":" + serviteursJ1.get(i).getVie() + ",\n");
        }

        return cartes.toString();
    }

    public String afficheCartesJ2() {
        StringBuilder cartes = new StringBuilder();

        for (int i = 0; i < serviteursJ2.size(); i++) {
            cartes.append("(" + i + ") " + serviteursJ2.get(i).toString() + ",\n");
        }

        return cartes.toString();
    }

    public boolean isServiteurProvoquant(Player player){


        return false;
    }

    public boolean isCartesPlateauJoueur(Player player){

        switch(player){
            case JOUEUR1:
                return serviteursJ1.size() > 0;

            case JOUEUR2:
                return serviteursJ2.size() > 0;
        }

        return false;
    }


    public void purge() {

        ArrayList<Serviteur> toRemoveJ1 = new ArrayList<>();
        ArrayList<Serviteur> toRemoveJ2 = new ArrayList<>();

        //purge J1
        for(Serviteur serviteur: serviteursJ1){
            if(serviteur.isDead()){
                serviteur.die();
                toRemoveJ1.add(serviteur);
            }
        }

        //purge J2
        for(Serviteur serviteur: serviteursJ2){
            if(serviteur.isDead()){
                serviteur.die();
                toRemoveJ2.add(serviteur);
            }
        }

        this.serviteursJ1.removeAll(toRemoveJ1);
        this.serviteursJ2.removeAll(toRemoveJ2);

    }

}


