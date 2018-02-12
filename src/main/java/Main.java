import actors.serviteurs.SanglierBrocheroc;
import actors.Serviteur;
import decorators.ActionServiteurAddVie;
import decorators.ActionServiteurSubVie;
import jeu.Jeu;
import utils.LogType;
import utils.Player;
import utils.Tools;


/**
 * author: Anais BESSON & Victor FAVREAU
 */
public class Main {

    public static void main(String[] args){
        //Welcome to the HearthStone project
        Tools.printHearthStone();

        //TOOLS DEMO
        /*
        String str = Tools.readInput("Saisir qq chose: ");
        Tools.log(str, LogType.INFO);

        InputType inputType = Tools.getInputType("Saisir une action");
        Tools.log(inputType.toString(), LogType.INFO);
        Tools.log(inputType.toString(), LogType.WARNING);
        Tools.log(inputType.toString(), LogType.JOUEUR1);
        Tools.log(inputType.toString(), LogType.JOUEUR2);
        */
        //TOOLS DEMO END

        //DECORATOR DEMO

        Jeu jeu = new Jeu();

      /*  Serviteur serviteur = new SanglierBrocheroc(Player.JOUEUR1);
        Tools.log((serviteur.getNom() + " - degats: " + serviteur.getDegats() + " - vie: " + serviteur.getVie()), LogType.INFO);

        serviteur = new ActionServiteurAddDegats(serviteur, 9);
        serviteur = new ActionServiteurAddVie(serviteur, 5);

        Tools.log((serviteur.getNom() + " - degats: " + serviteur.getDegats() + " - vie: " + serviteur.getVie()), LogType.INFO);
        //DECORATOR DEMO END

*/


        Player player = Tools.readPlayer();
        System.out.println(player.toString());

        SanglierBrocheroc sanglier = new SanglierBrocheroc(Player.JOUEUR1);


        Jeu.getPlateau().poseCarte(player, (Serviteur) sanglier.clone());
        Jeu.getPlateau().poseCarte(player, (Serviteur) sanglier.clone());

        Serviteur selectedServiteur = Tools.readServiteur(player);
        Jeu.getPlateau().actionOnCard(player,selectedServiteur, new ActionServiteurAddVie(null, 5));
        Tools.log(Jeu.getPlateau().afficheCartesJ1(), LogType.INFO);

        selectedServiteur = Tools.readServiteur(player);
        Jeu.getPlateau().actionOnCard(player,selectedServiteur, new ActionServiteurAddVie(null, 5));
        Tools.log(Jeu.getPlateau().afficheCartesJ1(), LogType.INFO);


        Jeu.getPlateau().actionOnCards(player, new ActionServiteurSubVie(null,6));
        Tools.log(Jeu.getPlateau().afficheCartesJ1(), LogType.INFO);

    }


}
