package jeu;

import actors.*;
import decorators.*;
import utils.LogType;
import utils.Player;
import utils.Tools;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class Plateau {

    ArrayList<Serviteur> serviteursJ1;
    ArrayList<Serviteur> serviteursJ2;

    public Plateau() {
        this.serviteursJ1 = new ArrayList<>();
        this.serviteursJ2 = new ArrayList<>();
    }

    /**
     * Pose la carte sur le plateau du joueur concerne et execute ses effets
     *
     * @param player    Joueur concerne
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
     * @param player    joueur concerne
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

    /**
     * Effectue une action sur tous les serviteurs du Plateau d'un Joueur
     * @param player joueur concerne
     * @param action action à effectuer
     */
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

    /**
     * Effectue une action sur tous les serviteurs du plateau du joueur
     * @param serviteurs liste des serviteurs du joueur
     * @param action action à effectuer
     * @return liste mise à jour
     */
    private ArrayList<Serviteur> executeActions(ArrayList<Serviteur> serviteurs, ActionServiteur action) {

        for (int indice = 0; indice < serviteurs.size(); indice++) {

            ActionServiteur actionServiteur = (ActionServiteur) action.clone();
            actionServiteur.setServiteur(serviteurs.get(indice));
            serviteurs.set(indice, actionServiteur);
        }

        return serviteurs;
    }

    /**
     * Le joueur effectue une attaque
     * @param joueurAttaquant joueur attaquant
     */
    public void attaque(Player joueurAttaquant) {

        if(isCartesPlateauJoueur(joueurAttaquant)){

            Player adversaire = Tools.getAdversaire(joueurAttaquant);

            Tools.log("Selectionnez l'attaquant:", Tools.getLogPlayer(joueurAttaquant));
            Serviteur attaquant = Tools.readServiteur(joueurAttaquant);

            if(attaquant != null){

                int indiceAttaquant = getIndiceCarte(joueurAttaquant, attaquant);

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

                                    Tools.log(joueurAttaquant + ": " + attaquant.getNom() + " attaque " + adversaire + ": " + cible.getNom(), LogType.INFO);

                                    //Le serviteur attaque la cible
                                    actionOnCard(adversaire,cible, new ActionServiteurSubVie(attaquant.getDegats()));

                                    //L'attaquant prend des dégats
                                    actionOnCard(joueurAttaquant,getCarteByIndice(joueurAttaquant, indiceAttaquant), new ActionServiteurSubVie(cible.getDegats()));

                                    //On endort l'attaquant
                                    actionOnCard(joueurAttaquant, getCarteByIndice(joueurAttaquant, indiceAttaquant), new ActionServiteurSetSleeping(true));

                                    if(attaquant.isVolVie()){

                                        ActionHeros actionHeros = new ActionHerosAddVie(attaquant.getDegats());
                                        switch (joueurAttaquant){
                                            case JOUEUR1:
                                                actionHeros.setHeros(Jeu.getJoueur1().getHeros());
                                                Jeu.getJoueur1().actionOnHero(actionHeros);
                                                break;

                                            case JOUEUR2:
                                                actionHeros.setHeros(Jeu.getJoueur2().getHeros());
                                                Jeu.getJoueur2().actionOnHero(actionHeros);
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
                                            Jeu.getJoueur1().actionOnHero(new ActionHerosSubDefense(subDefense));
                                        }

                                        if(subVie > 0){
                                            Jeu.getJoueur1().actionOnHero(new ActionHerosSubVie(subVie));
                                        }

                                        //On endort l'attaquant
                                        actionOnCard(joueurAttaquant, attaquant, new ActionServiteurSetSleeping(true));


                                        Tools.log("Le " + adversaire + " perd " + subDefense + "def et " + subVie + "pv", LogType.WARNING);

                                    } else {
                                        Tools.log("Un serviteur avec l'effet Provocation gene votre attaque. Elle echoue (dignement bien ententu !).", Tools.getLogPlayer(joueurAttaquant));
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
                                            Jeu.getJoueur2().actionOnHero(new ActionHerosSubDefense(subDefense));
                                        }

                                        if(subVie > 0){
                                            Jeu.getJoueur2().actionOnHero(new ActionHerosSubVie(subVie));
                                        }

                                        Tools.log("Le " + adversaire + " perd " + subDefense + "def et " + subVie + "pv", LogType.WARNING);

                                    } else {
                                        Tools.log("Un serviteur avec l'effet Provocation gene votre attaque. Elle echoue (dignement bien ententu !).", Tools.getLogPlayer(joueurAttaquant));
                                    }

                                    break;
                            }
                            break;
                    }

                } else {
                    Tools.log("Le serviteur attaquant est en train de dormir ! Il serait dommage de le reveiller de façon si brutale...", LogType.INFO);
                }
            } else {
                Tools.log("Rien ne se passe...", LogType.INFO);
            }




        } else {
            Tools.log("Il va etre dur d'attaquer sans serviteur sur le plateau vous ne pensez pas ?", LogType.INFO);
        }


    }

    /**
     * Le joueur utilise l'action speciale de son heros
     * @param joueurExecutant joueur effectuant l'action
     */
    public void actionSpeciale(Player joueurExecutant){

        if(assezMana(joueurExecutant, 2)){

            Heros heros = null;
            Joueur joueur = null;

            switch(joueurExecutant){
                case JOUEUR1:
                    heros = Jeu.getJoueur1().getHeros();
                    joueur = Jeu.getJoueur1();
                    break;

                case JOUEUR2:
                    heros = Jeu.getJoueur2().getHeros();
                    joueur = Jeu.getJoueur1();
                    break;
            }

            switch(heros.getTypeCibleEffet()){
                case HEROS:
                    heros.getEffetHeros().action();
                    joueur.actionOnHero(new ActionHerosSubMana(2));
                    joueur.setSortUtilise(true);
                    Tools.log("Activation de l'effet:\n" + heros.getEffetHeros().getDescr(), LogType.INFO);
                    break;

                case SERVITEUR:
                    if(isCartesPlateauJoueur(heros.getEffetServiteur().getCible())){
                        heros.getEffetServiteur().action();
                        joueur.actionOnHero(new ActionHerosSubMana(2));
                        joueur.setSortUtilise(true);
                        Tools.log("Activation de l'effet:\n" + heros.getEffetServiteur().getDescr(), LogType.INFO);
                    } else {
                        Tools.log("Il n'y à pas de cartes sur le plateau de la cible... Rien ne se passe.", LogType.WARNING);
                    }

                    break;

                case CHOIX:
                    TypeActeur cible = Tools.getTypeCible();

                    if(cible == TypeActeur.HEROS){
                        heros.getEffetHeros().action();
                        joueur.actionOnHero(new ActionHerosSubMana(2));
                        joueur.setSortUtilise(true);
                        Tools.log("Activation de l'effet:\n" + heros.getEffetHeros().getDescr(), LogType.INFO);
                    } else {
                        if(isCartesPlateauJoueur(heros.getEffetServiteur().getCible())){
                            heros.getEffetServiteur().action();
                            joueur.actionOnHero(new ActionHerosSubMana(2));
                            joueur.setSortUtilise(true);
                            Tools.log("Activation de l'effet:\n" + heros.getEffetServiteur().getDescr(), LogType.INFO);
                        } else {
                            Tools.log("Il n'y à pas de cartes sur le plateau de la cible... Rien ne se passe.", LogType.WARNING);
                        }
                    }
            }

        } else {
            Tools.log("Vous n'avez pas assez de mana pour executer cette action.", LogType.WARNING);
        }
    }

    public void wakeUpServiteurs(Player player){

        ArrayList<Serviteur> cartes;

        switch (player){
            case JOUEUR1:
                cartes = this.getCartesJ1();
                break;

            case JOUEUR2:
                cartes = this.getCartesJ2();
                break;

            default:
                cartes = new ArrayList<>();
                break;
        }

        for(int i=0; i<cartes.size(); i++){
            if(cartes.get(i).isSleeping()){
                ActionServiteur actionServiteur = new ActionServiteurSetSleeping(false);
                actionServiteur.setServiteur(cartes.get(i));
                cartes.set(i, actionServiteur);
            }
        }

    }

    /**
     * On verifie que le joueur à le mana necessaire pour effectuer l'action
     * @param player joueur concerne
     * @param mana mana requis pour effectuer l'action
     * @return Le joueur peut ou non effectuer l'action
     */
    public boolean assezMana(Player player, int mana){

        switch (player){
            case JOUEUR1:
                return Jeu.getJoueur1().assezMana(mana);

            case JOUEUR2:
                return Jeu.getJoueur2().assezMana(mana);
        }

        return false;
    }

    /**
     * Retourne la liste des cartes du JOUEUR1
     * @return liste des cartes du JOUEUR1
     */
    public ArrayList<Serviteur> getCartesJ1() {
        return serviteursJ1;
    }

    /**
     * Retourne la liste des cartes du JOUEUR2
     * @return liste des cartes du JOUEUR2
     */
    public ArrayList<Serviteur> getCartesJ2() {
        return serviteursJ2;
    }

    /**
     * Retourne l'indice du serviteur sur le plateau
     * @param player joueur observe
     * @param serviteur serviteur recherché
     * @return indice du serviteur recherché sur le plateau du joueur
     */
    private Integer getIndiceCarte(Player player, Serviteur serviteur) {

        switch (player){
            case JOUEUR1:
                if(serviteursJ1.contains(serviteur)){
                    return serviteursJ1.indexOf(serviteur);
                }

                break;

            case JOUEUR2:
                if(serviteursJ2.contains(serviteur)){
                    return serviteursJ2.indexOf(serviteur);
                }

                break;
        }

        return null;
    }

    /**
     * Retourne une carte du plateau du JOUEUR2
     * @param player joueur concerné
     * @param indice indice de la carte
     * @return la carte desiree
     */
    public Serviteur getCarteByIndice(Player player, int indice) {

        switch (player){
            case JOUEUR1:
                if (indice >= 0 && indice < serviteursJ1.size()) {
                    return serviteursJ1.get(indice);
                }

                break;

            case JOUEUR2:
                if (indice >= 0 && indice < serviteursJ2.size()) {
                    return serviteursJ2.get(indice);
                }

                break;
        }

        return null;
    }

    /**
     * Affiche le contenu du plateau du joueur
     * @param player joueur concerne
     */
    public void affichePlateauJoueur(Player player){

        ArrayList<Serviteur> plateauJoueur = null;

        switch(player){
            case JOUEUR1:
                plateauJoueur = this.serviteursJ1;
                break;

            case JOUEUR2:
                plateauJoueur = this.serviteursJ2;
                break;
        }

        StringBuilder cartes = new StringBuilder("Plateau "+ player +": \n");

        for (int i = 0; i < plateauJoueur.size(); i++) {
            cartes.append("(" + i + ") " + plateauJoueur.get(i).toString() + ",\n");
        }

        cartes.append("\n");

        Tools.log(cartes.toString(), LogType.NORMAL);

    }

    /**
     * Methode verifiant la presence d'un serviteur provoquant sur le plateau du joueur
     * @param player joueur observe
     * @return La presence d'un Serviteur provoquant sur le plateau du joueur
     */
    public boolean isServiteurProvoquant(Player player){

        boolean isProvocation = false;
        ArrayList<Serviteur> cartesJoueur = new ArrayList<>();

        switch(player){
            case JOUEUR1:
                cartesJoueur.addAll(getCartesJ1());
                break;

            case JOUEUR2:
                cartesJoueur.addAll(getCartesJ2());
                break;
        }

        for(Serviteur serviteur: cartesJoueur){
            if(serviteur.isProvocation()){
                isProvocation = true;
                break;
            }
        }

        return isProvocation;
    }

    /**
     * On controle la presence de cartes sur le plateau du joueur
     * @param player joueur observe
     * @return la presence de cartes sur le plateau
     */
    public boolean isCartesPlateauJoueur(Player player){

        switch(player){
            case JOUEUR1:
                return serviteursJ1.size() > 0;

            case JOUEUR2:
                return serviteursJ2.size() > 0;
        }

        return false;
    }

    /**
     * Methode permettant de purger le plateau des Serviteurs morts au combat
     */
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


