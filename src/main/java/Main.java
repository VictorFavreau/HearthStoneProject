import jeu.Jeu;
import jeu.ObserverJeu;
import state.InterfaceTour;
import state.Tour;
import utils.InputType;
import utils.LogType;
import utils.Tools;

/**
 * @author: Anais BESSON et Victor FAVREAU
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
    }
}
