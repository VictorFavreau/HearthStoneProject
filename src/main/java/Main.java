import actors.serviteurs.SanglierBrocheroc;
import actors.Serviteur;
import decorators.ActionServiteurAddDegats;
import decorators.ActionServiteurAddVie;
import utils.LogType;
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
        Serviteur serviteur = new SanglierBrocheroc();
        Tools.log((serviteur.getNom() + " - degats: " + serviteur.getDegats() + " - vie: " + serviteur.getVie()), LogType.INFO);

        serviteur = new ActionServiteurAddDegats(serviteur, 9);
        serviteur = new ActionServiteurAddVie(serviteur, 5);

        Tools.log((serviteur.getNom() + " - degats: " + serviteur.getDegats() + " - vie: " + serviteur.getVie()), LogType.INFO);
        //DECORATOR DEMO END

    }


}
