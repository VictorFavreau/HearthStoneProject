import actors.deck.Deck;
import actors.deck.DeckMage;
import actors.serviteurs.SanglierBrocheroc;
import actors.Serviteur;
import decorators.ActionServiteurAddVie;
import decorators.ActionServiteurSubVie;
import jeu.Jeu;
import jeu.ObserverJeu;
import state.InterfaceTour;
import state.Tour;
import utils.InputType;
import utils.LogType;
import utils.Player;
import utils.Tools;


/**
 * author: Anais BESSON & Victor FAVREAU
 */
public class Main {

    public static void main(String[] args) {
        //Welcome to the HearthStone project

        Tools.printHearthStone();

        InterfaceTour tour = new Tour();
        ObserverJeu obs = new Jeu();

        tour.enregistrerObs(obs);





        while(!obs.isFinJeu()){

            InputType inputMenu = Tools.getInputMenu();

            switch (inputMenu){
                case JOUER:
                    tour.joue();
                    break;

                case HELP:
                    //Tools.help();
                    Tools.log("HELP", LogType.INFO);
                    break;

            }

            if(inputMenu == InputType.QUITTER) break;

        }















       /*



        Jeu jeu = new Jeu();

        jeu.joue();


        Jeu.afficheStat();

        for(int i=0; i<= 10; i++){
            Jeu.getJoueur1().pioche();
            Jeu.getJoueur1().addStockMana();

            Jeu.getJoueur2().pioche();
            Jeu.getJoueur2().addStockMana();

        }

        Jeu.getJoueur1().setMaxMana();
        Jeu.getJoueur2().setMaxMana();

        Jeu.afficheStat();





        for(int i=0; i< 3; i++){
           // Jeu.getJoueur1().poseCarte();
           // Jeu.getJoueur2().poseCarte();

            //Jeu.getJoueur1().attaque();
            Jeu.getJoueur1().actionSpeciale();

            Jeu.afficheStat();
           // Jeu.getJoueur1().wakeUpServiteurs();
        }


        Jeu.afficheStat();


/*
        Player player = Tools.readPlayer();
        System.out.println(player.toString());

        SanglierBrocheroc sanglier = new SanglierBrocheroc(player);


        Jeu.getPlateau().poseCarte(player, (Serviteur) sanglier.clone());
        Jeu.getPlateau().poseCarte(player, (Serviteur) sanglier.clone());

        Serviteur selectedServiteur = Tools.readServiteur(player);
        Jeu.getPlateau().actionOnCard(player,selectedServiteur, new ActionServiteurAddVie(null, 5));
        Tools.log(Jeu.getPlateau().afficheCartesJ1(), LogType.NORMAL);

        selectedServiteur = Tools.readServiteur(player);
        Jeu.getPlateau().actionOnCard(player,selectedServiteur, new ActionServiteurAddVie(null, 5));
        Tools.log(Jeu.getPlateau().afficheCartesJ1(), LogType.NORMAL);

        Tools.log("Test action on cards", LogType.INFO);
        Jeu.getPlateau().actionOnCards(player, new ActionServiteurSubVie(null,6));
        Tools.log(Jeu.getPlateau().afficheCartesJ1(), LogType.NORMAL);


*/

    }
}
