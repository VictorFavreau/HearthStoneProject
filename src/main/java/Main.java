import utils.InputType;
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
        String str = Tools.readInput("Saisir qq chose: ");
        Tools.log(str, LogType.INFO);

        InputType inputType = Tools.getInputType("Saisir une action");
        Tools.log(inputType.toString(), LogType.INFO);
        //TOOLS DEMO END

    }


}
