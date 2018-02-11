package jeu;

import actors.Carte;
import actors.Serviteur;
import decorators.ActionServiteur;
import decorators.ActionServiteurSubVie;
import utils.LogType;
import utils.Player;
import utils.Tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Plateau {

    ArrayList<Serviteur> serviteursJ1;
    ArrayList<Serviteur> serviteursJ2;

    public Plateau(){
        this.serviteursJ1 = new ArrayList<>();
        this.serviteursJ2 = new ArrayList<>();
    }

    /**
     * Pose la carte sur le plateau du joueur concerné
     * @param player Joueur concerné
     * @param serviteur Serviteur à poser
     */
    public void addCarte(Player player, Serviteur serviteur){

        switch(player){
            case JOUEUR1:
                this.serviteursJ1.add(serviteur);
                break;

            case JOUEUR2:
                this.serviteursJ2.add(serviteur);
                break;

            default:
                Tools.log("Rien ne se passe...", LogType.INFO);
                break;
        }

    }

    /**
     * Execute une action sur la carte d'un joueur
     * @param player joueur concerné
     * @param serviteur indice de la carte
     * @param action action effectuee sur la carte
     */
    public void actionOnCard(Player player, Serviteur serviteur, ActionServiteur action){

        switch (player){
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
     * @param serviteurs serviteurs du joueur
     * @param serviteur serviteur concerne
     * @param action action effectuee sur la carte
     */
    private ArrayList<Serviteur> executeAction(ArrayList<Serviteur> serviteurs, Serviteur serviteur, ActionServiteur action){
        if(serviteurs.contains(serviteur)){

            int indiceCarte = serviteurs.indexOf(serviteur);

            ActionServiteur actionServiteur = (ActionServiteur) action.clone();

            actionServiteur.setServiteur(serviteurs.get(indiceCarte));
            serviteurs.set(indiceCarte, actionServiteur);

        } else {
            Tools.log("Rien ne se passe...", LogType.INFO);
        }

        return serviteurs;
    }

    public void actionOnCards(Player player, ActionServiteur action){
        switch (player){
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

    private ArrayList<Serviteur> executeActions(ArrayList<Serviteur> serviteurs, ActionServiteur action){


        for(int indice=0; indice < serviteurs.size(); indice++){

            ActionServiteur actionServiteur = (ActionServiteur) action.clone();
            actionServiteur.setServiteur(serviteurs.get(indice));
            serviteurs.set(indice, actionServiteur);
        }

        return serviteurs;
    }

    /**
     * Retourne la liste des cartes du JOUEUR1
     * @return liste des cartes du JOUEUR1
     */
    public List<Serviteur> getCartesJ1() {
        return serviteursJ1;
    }

    /**
     * Retourne la liste des cartes du JOUEUR2
     * @return liste des cartes du JOUEUR2
     */
    public List<Serviteur> getCartesJ2() {
        return serviteursJ2;
    }

    public Serviteur getCarteJ1(int indice){
        if(indice >= 0 && indice < serviteursJ1.size()) {
            return serviteursJ1.get(indice);
        }

        return null;
    }

    public Serviteur getCarteJ2(int indice){
        if(indice >= 0 && indice < serviteursJ2.size()) {
            return serviteursJ2.get(indice);
        }

        return null;
    }

    public String afficheCartesJ1(){
        StringBuilder cartes = new StringBuilder();

        for(int i=0; i<serviteursJ1.size(); i++){
            cartes.append("(" + i + ") " + serviteursJ1.get(i).getNom() + " " + serviteursJ1.get(i).getDegats()+ ":" + serviteursJ1.get(i).getVie() + ",\n");
        }

        return cartes.toString();
    }

    public String afficheCartesJ2(){
        StringBuilder cartes = new StringBuilder();

        for(int i=0; i<serviteursJ2.size(); i++){
            cartes.append("(" + i + ") " + serviteursJ2.get(i).toString() + ",\n");
        }

        return cartes.toString();
    }

    public void purge(){
        //purge J1
        for(int i=0; i<serviteursJ1.size(); i++){
            if(serviteursJ1.get(i).isDead()){
                Tools.log("Le Serviteur: " + serviteursJ1.get(i).getNom() + "meurt", LogType.WARNING);
                serviteursJ1.remove(i);
            }
        }

        //purge J2
        for(int i=0; i<serviteursJ2.size(); i++){
            if(serviteursJ2.get(i).isDead()){
                Tools.log("Le Serviteur: " + serviteursJ2.get(i).getNom() + " meurt !", LogType.WARNING);
                serviteursJ2.remove(i);
            }
        }

    }

}


